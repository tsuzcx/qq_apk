package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.ng.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy
  extends ExtContentProviderBase
  implements e.a
{
  private static final String AUTHORITY;
  private static final String[] COLUMNS;
  private static boolean hho;
  private static final UriMatcher sNB;
  private static MTimerHandler sND;
  private boolean chA;
  private b.a gmA;
  private b guy;
  private d iOv;
  private chi sNA;
  private boolean sNC;
  private int sNu;
  private List<chi> sNv;
  private com.tencent.mm.storagebase.e sNw;
  private Set<String> sNx;
  private CountDownLatch sNy;
  private CountDownLatch sNz;
  
  static
  {
    AppMethodBeat.i(24455);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_NEARBY();
    UriMatcher localUriMatcher = new UriMatcher(-1);
    sNB = localUriMatcher;
    localUriMatcher.addURI(AUTHORITY, "male", 1);
    sNB.addURI(AUTHORITY, "female", 2);
    sNB.addURI(AUTHORITY, "all", 0);
    hho = false;
    sND = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24441);
        ExtControlProviderNearBy.TT();
        AppMethodBeat.o(24441);
        return false;
      }
    }, false);
    AppMethodBeat.o(24455);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(24445);
    this.sNC = false;
    this.guy = new b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(24443);
        if ((paramAnonymousIEvent instanceof ng))
        {
          if (ExtControlProviderNearBy.c(ExtControlProviderNearBy.this) == null)
          {
            AppMethodBeat.o(24443);
            return;
          }
          paramAnonymousString = (ng)paramAnonymousIEvent;
          Log.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramAnonymousInt2 + ", errType: " + paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label273;
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, paramAnonymousString.dTi.dTp);
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
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(24444);
        if (ExtControlProviderNearBy.g(ExtControlProviderNearBy.this))
        {
          AppMethodBeat.o(24444);
          return false;
        }
        ExtControlProviderNearBy.h(ExtControlProviderNearBy.this);
        if (!paramAnonymousBoolean)
        {
          Log.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
          ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          AppMethodBeat.o(24444);
          return false;
        }
        ng localng = new ng();
        localng.dTh.dJY = ExtControlProviderNearBy.i(ExtControlProviderNearBy.this);
        localng.dTh.dTj = paramAnonymousFloat1;
        localng.dTh.latitude = paramAnonymousFloat2;
        localng.dTh.dTk = ((int)paramAnonymousDouble2);
        localng.dTh.dTl = paramAnonymousInt;
        localng.dTh.dTm = "";
        localng.dTh.dTn = "";
        if (EventCenter.instance.publish(localng)) {
          Log.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
        }
        AppMethodBeat.o(24444);
        return false;
      }
    };
    AppMethodBeat.o(24445);
  }
  
  private void a(chi paramchi)
  {
    AppMethodBeat.i(24449);
    if ((paramchi == null) || (paramchi.UserName == null))
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(24449);
      return;
    }
    this.sNx.add(paramchi.UserName);
    Bitmap localBitmap = c.a(paramchi.UserName, false, -1, null);
    Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.sNz.getCount());
    if (localBitmap != null)
    {
      Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.sNx.remove(paramchi.UserName);
      this.sNw.addRow(new Object[] { paramchi.oUJ, arrayOfByte, paramchi.MmJ, paramchi.keb, Integer.valueOf(paramchi.kdY) });
      Log.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(24449);
  }
  
  private chi arq(String paramString)
  {
    AppMethodBeat.i(24448);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(24448);
      return null;
    }
    Iterator localIterator = this.sNv.iterator();
    while (localIterator.hasNext())
    {
      chi localchi = (chi)localIterator.next();
      if (localchi.UserName.equals(paramString))
      {
        AppMethodBeat.o(24448);
        return localchi;
      }
    }
    AppMethodBeat.o(24448);
    return null;
  }
  
  private void cSx()
  {
    AppMethodBeat.i(24451);
    if (this.sNx.size() > 0)
    {
      Iterator localIterator = this.sNx.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Log.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.sNA = arq(str);
        if ((this.sNA != null) && (this.sNA.UserName != null)) {
          this.sNw.addRow(new Object[] { this.sNA.oUJ, null, this.sNA.MmJ, this.sNA.keb, Integer.valueOf(this.sNA.kdY) });
        }
      }
      AppMethodBeat.o(24451);
      return;
    }
    Log.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(24451);
  }
  
  private static void gW(boolean paramBoolean)
  {
    AppMethodBeat.i(24446);
    if (paramBoolean)
    {
      hho = true;
      sND.startTimer(15000L);
      AppMethodBeat.o(24446);
      return;
    }
    sND.startTimer(0L);
    AppMethodBeat.o(24446);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(24450);
    Log.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.chA)
    {
      Log.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(24450);
      return;
    }
    a(arq(paramString));
    this.sNz.countDown();
    AppMethodBeat.o(24450);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(24452);
    this.sNu = -1;
    switch (sNB.match(paramUri))
    {
    default: 
      this.sNu = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(24452);
      return null;
      this.sNu = 1;
      continue;
      this.sNu = 3;
      continue;
      this.sNu = 4;
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
      HF(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if ((Util.isNullOrNil(this.sMZ)) || (Util.isNullOrNil(cSt())))
    {
      HF(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if (hho)
    {
      Log.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      HF(5);
      AppMethodBeat.o(24447);
      return null;
    }
    gW(true);
    if (!ckf())
    {
      gW(false);
      HF(1);
      paramUri = this.pem;
      AppMethodBeat.o(24447);
      return paramUri;
    }
    if (!fe(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      gW(false);
      HF(2);
      AppMethodBeat.o(24447);
      return null;
    }
    Log.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.sNu);
    getType(paramUri);
    if (this.sNu < 0)
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      gW(false);
      HF(3);
      AppMethodBeat.o(24447);
      return null;
    }
    for (;;)
    {
      try
      {
        this.sNv = new ArrayList();
        this.sNw = new com.tencent.mm.storagebase.e(COLUMNS, (byte)0);
        this.sNy = new CountDownLatch(1);
        this.sNz = null;
        this.sNx = new HashSet();
        this.sNv = new ArrayList();
        this.chA = false;
        Log.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (bg.aAc()) {
          continue;
        }
        Log.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        Log.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.sNy.await(15000L, TimeUnit.MILLISECONDS)) {
          Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.sNz == null) {
          continue;
        }
        Log.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.sNz.await(15000L, TimeUnit.MILLISECONDS)) {
          Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        Log.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        HF(4);
        continue;
        Log.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        HF(4);
        continue;
      }
      gW(false);
      p.aYn().b(this);
      this.chA = true;
      cSx();
      if ((this.sNw == null) || (this.sNw.getCount() <= 0)) {
        continue;
      }
      HF(0);
      Log.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.sNw;
      AppMethodBeat.o(24447);
      return paramUri;
      b.a(ng.class.getName(), this.guy);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24442);
          if (ExtControlProviderNearBy.a(ExtControlProviderNearBy.this) == null) {
            ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, d.bca());
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this).a(ExtControlProviderNearBy.b(ExtControlProviderNearBy.this), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy
 * JD-Core Version:    0.7.0.1
 */