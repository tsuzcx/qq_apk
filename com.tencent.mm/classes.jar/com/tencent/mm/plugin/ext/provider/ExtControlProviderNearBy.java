package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.pg;
import com.tencent.mm.autogen.a.pg.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.event.IListenerNetScene;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storagebase.e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class ExtControlProviderNearBy
  extends ExtContentProviderBase
  implements AvatarStorage.a
{
  private static final String AUTHORITY;
  private static final String[] COLUMNS;
  private static boolean mtE;
  private static final UriMatcher zPC;
  private static MTimerHandler zPE;
  private IListenerNetScene lAz;
  private b.a lsF;
  private boolean mhq;
  private com.tencent.mm.modelgeo.d owr;
  private CountDownLatch zPA;
  private dgy zPB;
  private boolean zPD;
  private int zPv;
  private List<dgy> zPw;
  private e zPx;
  private Set<String> zPy;
  private CountDownLatch zPz;
  
  static
  {
    AppMethodBeat.i(24455);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_NEARBY();
    UriMatcher localUriMatcher = new UriMatcher(-1);
    zPC = localUriMatcher;
    localUriMatcher.addURI(AUTHORITY, "male", 1);
    zPC.addURI(AUTHORITY, "female", 2);
    zPC.addURI(AUTHORITY, "all", 0);
    mtE = false;
    zPE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24441);
        ExtControlProviderNearBy.aAs();
        AppMethodBeat.o(24441);
        return false;
      }
    }, false);
    AppMethodBeat.o(24455);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(24445);
    this.zPD = false;
    this.lAz = new IListenerNetScene()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(24443);
        if ((paramAnonymousIEvent instanceof pg))
        {
          if (ExtControlProviderNearBy.c(ExtControlProviderNearBy.this) == null)
          {
            AppMethodBeat.o(24443);
            return;
          }
          paramAnonymousString = (pg)paramAnonymousIEvent;
          Log.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramAnonymousInt2 + ", errType: " + paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label273;
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, paramAnonymousString.hSo.hSu);
          if ((ExtControlProviderNearBy.d(ExtControlProviderNearBy.this) != null) && (ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size() != 0)) {
            break label146;
          }
          Log.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
        }
        for (;;)
        {
          ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
          AppMethodBeat.o(24443);
          return;
          label146:
          if (ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size() > 10)
          {
            Log.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size());
            ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).subList(10, ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()).clear();
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, new CountDownLatch(ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()));
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          ExtControlProviderNearBy.e(ExtControlProviderNearBy.this);
          continue;
          label273:
          Log.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + paramAnonymousInt2 + ", errType=" + paramAnonymousInt1);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
        }
      }
    };
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(274334);
        if (ExtControlProviderNearBy.g(ExtControlProviderNearBy.this))
        {
          AppMethodBeat.o(274334);
          return false;
        }
        ExtControlProviderNearBy.h(ExtControlProviderNearBy.this);
        if (!paramAnonymousBoolean)
        {
          Log.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
          ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          AppMethodBeat.o(274334);
          return false;
        }
        pg localpg = new pg();
        localpg.hSn.hHC = ExtControlProviderNearBy.i(ExtControlProviderNearBy.this);
        localpg.hSn.longitude = paramAnonymousFloat1;
        localpg.hSn.latitude = paramAnonymousFloat2;
        localpg.hSn.hSp = ((int)paramAnonymousDouble2);
        localpg.hSn.hSq = paramAnonymousInt;
        localpg.hSn.hSr = "";
        localpg.hSn.hSs = "";
        if (localpg.publish()) {
          Log.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
        }
        AppMethodBeat.o(274334);
        return false;
      }
    };
    AppMethodBeat.o(24445);
  }
  
  private void a(dgy paramdgy)
  {
    AppMethodBeat.i(24449);
    if ((paramdgy == null) || (paramdgy.UserName == null))
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(24449);
      return;
    }
    this.zPy.add(paramdgy.UserName);
    Bitmap localBitmap = com.tencent.mm.modelavatar.d.a(paramdgy.UserName, false, -1, null);
    Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.zPA.getCount());
    if (localBitmap != null)
    {
      Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.zPy.remove(paramdgy.UserName);
      this.zPx.addRow(new Object[] { paramdgy.vhX, arrayOfByte, paramdgy.aaMl, paramdgy.pSi, Integer.valueOf(paramdgy.pSf) });
      Log.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(24449);
  }
  
  private dgy aty(String paramString)
  {
    AppMethodBeat.i(24448);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(24448);
      return null;
    }
    Iterator localIterator = this.zPw.iterator();
    while (localIterator.hasNext())
    {
      dgy localdgy = (dgy)localIterator.next();
      if (localdgy.UserName.equals(paramString))
      {
        AppMethodBeat.o(24448);
        return localdgy;
      }
    }
    AppMethodBeat.o(24448);
    return null;
  }
  
  private void dOi()
  {
    AppMethodBeat.i(24451);
    if (this.zPy.size() > 0)
    {
      Iterator localIterator = this.zPy.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Log.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.zPB = aty(str);
        if ((this.zPB != null) && (this.zPB.UserName != null)) {
          this.zPx.addRow(new Object[] { this.zPB.vhX, null, this.zPB.aaMl, this.zPB.pSi, Integer.valueOf(this.zPB.pSf) });
        }
      }
      AppMethodBeat.o(24451);
      return;
    }
    Log.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(24451);
  }
  
  private static void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(24446);
    if (paramBoolean)
    {
      mtE = true;
      zPE.startTimer(15000L);
      AppMethodBeat.o(24446);
      return;
    }
    zPE.startTimer(0L);
    AppMethodBeat.o(24446);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(24450);
    Log.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.mhq)
    {
      Log.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(24450);
      return;
    }
    a(aty(paramString));
    this.zPA.countDown();
    AppMethodBeat.o(24450);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(24452);
    this.zPv = -1;
    switch (zPC.match(paramUri))
    {
    default: 
      this.zPv = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(24452);
      return null;
      this.zPv = 1;
      continue;
      this.zPv = 3;
      continue;
      this.zPv = 4;
    }
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public final boolean onCreate()
  {
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(24447);
    Log.i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), 15);
    if (paramUri == null)
    {
      Mm(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if ((Util.isNullOrNil(this.zPa)) || (Util.isNullOrNil(dOe())))
    {
      Mm(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if (mtE)
    {
      Log.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      Mm(5);
      AppMethodBeat.o(24447);
      return null;
    }
    iK(true);
    if (!dak())
    {
      iK(false);
      Mm(1);
      paramUri = this.vsh;
      AppMethodBeat.o(24447);
      return paramUri;
    }
    if (!gh(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      iK(false);
      Mm(2);
      AppMethodBeat.o(24447);
      return null;
    }
    Log.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.zPv);
    getType(paramUri);
    if (this.zPv < 0)
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      iK(false);
      Mm(3);
      AppMethodBeat.o(24447);
      return null;
    }
    for (;;)
    {
      try
      {
        this.zPw = new ArrayList();
        this.zPx = new e(COLUMNS, (byte)0);
        this.zPz = new CountDownLatch(1);
        this.zPA = null;
        this.zPy = new HashSet();
        this.zPw = new ArrayList();
        this.mhq = false;
        Log.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (bh.baz()) {
          continue;
        }
        Log.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        Log.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.zPz.await(15000L, TimeUnit.MILLISECONDS)) {
          Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.zPA == null) {
          continue;
        }
        Log.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.zPA.await(15000L, TimeUnit.MILLISECONDS)) {
          Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        Log.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        Mm(4);
        continue;
        Log.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        Mm(4);
        continue;
      }
      iK(false);
      q.bFp().b(this);
      this.mhq = true;
      dOi();
      if ((this.zPx == null) || (this.zPx.getCount() <= 0)) {
        continue;
      }
      Mm(0);
      Log.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.zPx;
      AppMethodBeat.o(24447);
      return paramUri;
      IListenerNetScene.a(pg.class.getName(), this.lAz);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24442);
          if (ExtControlProviderNearBy.a(ExtControlProviderNearBy.this) == null) {
            ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, com.tencent.mm.modelgeo.d.bJl());
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this).a(ExtControlProviderNearBy.b(ExtControlProviderNearBy.this), true, false);
          l.kK(22, 10);
          AppMethodBeat.o(24442);
        }
      });
    }
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy
 * JD-Core Version:    0.7.0.1
 */