package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.ny;
import com.tencent.mm.f.a.ny.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.sdk.event.EventCenter;
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

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy
  extends ExtContentProviderBase
  implements f.a
{
  private static final String AUTHORITY;
  private static final String[] COLUMNS;
  private static boolean jTm;
  private static final UriMatcher wtw;
  private static MTimerHandler wty;
  private b.a iQJ;
  private b iYJ;
  private boolean jHM;
  private com.tencent.mm.modelgeo.d lEL;
  private int wtp;
  private List<cqe> wtq;
  private e wtr;
  private Set<String> wts;
  private CountDownLatch wtt;
  private CountDownLatch wtu;
  private cqe wtv;
  private boolean wtx;
  
  static
  {
    AppMethodBeat.i(24455);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_NEARBY();
    UriMatcher localUriMatcher = new UriMatcher(-1);
    wtw = localUriMatcher;
    localUriMatcher.addURI(AUTHORITY, "male", 1);
    wtw.addURI(AUTHORITY, "female", 2);
    wtw.addURI(AUTHORITY, "all", 0);
    jTm = false;
    wty = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24441);
        ExtControlProviderNearBy.Yy();
        AppMethodBeat.o(24441);
        return false;
      }
    }, false);
    AppMethodBeat.o(24455);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(24445);
    this.wtx = false;
    this.iYJ = new b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(24443);
        if ((paramAnonymousIEvent instanceof ny))
        {
          if (ExtControlProviderNearBy.c(ExtControlProviderNearBy.this) == null)
          {
            AppMethodBeat.o(24443);
            return;
          }
          paramAnonymousString = (ny)paramAnonymousIEvent;
          Log.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramAnonymousInt2 + ", errType: " + paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label273;
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, paramAnonymousString.fME.fMK);
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
    this.iQJ = new b.a()
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
        ny localny = new ny();
        localny.fMD.fCN = ExtControlProviderNearBy.i(ExtControlProviderNearBy.this);
        localny.fMD.longitude = paramAnonymousFloat1;
        localny.fMD.latitude = paramAnonymousFloat2;
        localny.fMD.fMF = ((int)paramAnonymousDouble2);
        localny.fMD.fMG = paramAnonymousInt;
        localny.fMD.fMH = "";
        localny.fMD.fMI = "";
        if (EventCenter.instance.publish(localny)) {
          Log.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
        }
        AppMethodBeat.o(24444);
        return false;
      }
    };
    AppMethodBeat.o(24445);
  }
  
  private void a(cqe paramcqe)
  {
    AppMethodBeat.i(24449);
    if ((paramcqe == null) || (paramcqe.UserName == null))
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(24449);
      return;
    }
    this.wts.add(paramcqe.UserName);
    Bitmap localBitmap = com.tencent.mm.am.d.a(paramcqe.UserName, false, -1, null);
    Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.wtu.getCount());
    if (localBitmap != null)
    {
      Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.wts.remove(paramcqe.UserName);
      this.wtr.addRow(new Object[] { paramcqe.rWI, arrayOfByte, paramcqe.TxE, paramcqe.mVB, Integer.valueOf(paramcqe.mVy) });
      Log.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(24449);
  }
  
  private cqe azr(String paramString)
  {
    AppMethodBeat.i(24448);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(24448);
      return null;
    }
    Iterator localIterator = this.wtq.iterator();
    while (localIterator.hasNext())
    {
      cqe localcqe = (cqe)localIterator.next();
      if (localcqe.UserName.equals(paramString))
      {
        AppMethodBeat.o(24448);
        return localcqe;
      }
    }
    AppMethodBeat.o(24448);
    return null;
  }
  
  private void dhx()
  {
    AppMethodBeat.i(24451);
    if (this.wts.size() > 0)
    {
      Iterator localIterator = this.wts.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Log.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.wtv = azr(str);
        if ((this.wtv != null) && (this.wtv.UserName != null)) {
          this.wtr.addRow(new Object[] { this.wtv.rWI, null, this.wtv.TxE, this.wtv.mVB, Integer.valueOf(this.wtv.mVy) });
        }
      }
      AppMethodBeat.o(24451);
      return;
    }
    Log.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(24451);
  }
  
  private static void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(24446);
    if (paramBoolean)
    {
      jTm = true;
      wty.startTimer(15000L);
      AppMethodBeat.o(24446);
      return;
    }
    wty.startTimer(0L);
    AppMethodBeat.o(24446);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(24450);
    Log.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.jHM)
    {
      Log.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(24450);
      return;
    }
    a(azr(paramString));
    this.wtu.countDown();
    AppMethodBeat.o(24450);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(24452);
    this.wtp = -1;
    switch (wtw.match(paramUri))
    {
    default: 
      this.wtp = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(24452);
      return null;
      this.wtp = 1;
      continue;
      this.wtp = 3;
      continue;
      this.wtp = 4;
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
      Lp(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if ((Util.isNullOrNil(this.wsU)) || (Util.isNullOrNil(dht())))
    {
      Lp(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if (jTm)
    {
      Log.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      Lp(5);
      AppMethodBeat.o(24447);
      return null;
    }
    hN(true);
    if (!cxw())
    {
      hN(false);
      Lp(1);
      paramUri = this.sgp;
      AppMethodBeat.o(24447);
      return paramUri;
    }
    if (!fj(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      hN(false);
      Lp(2);
      AppMethodBeat.o(24447);
      return null;
    }
    Log.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.wtp);
    getType(paramUri);
    if (this.wtp < 0)
    {
      Log.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      hN(false);
      Lp(3);
      AppMethodBeat.o(24447);
      return null;
    }
    for (;;)
    {
      try
      {
        this.wtq = new ArrayList();
        this.wtr = new e(COLUMNS, (byte)0);
        this.wtt = new CountDownLatch(1);
        this.wtu = null;
        this.wts = new HashSet();
        this.wtq = new ArrayList();
        this.jHM = false;
        Log.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (bh.aHB()) {
          continue;
        }
        Log.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        Log.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.wtt.await(15000L, TimeUnit.MILLISECONDS)) {
          Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.wtu == null) {
          continue;
        }
        Log.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.wtu.await(15000L, TimeUnit.MILLISECONDS)) {
          Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        Log.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        Lp(4);
        continue;
        Log.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        Lp(4);
        continue;
      }
      hN(false);
      q.bhz().b(this);
      this.jHM = true;
      dhx();
      if ((this.wtr == null) || (this.wtr.getCount() <= 0)) {
        continue;
      }
      Lp(0);
      Log.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.wtr;
      AppMethodBeat.o(24447);
      return paramUri;
      b.a(ny.class.getName(), this.iYJ);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24442);
          if (ExtControlProviderNearBy.a(ExtControlProviderNearBy.this) == null) {
            ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, com.tencent.mm.modelgeo.d.blq());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy
 * JD-Core Version:    0.7.0.1
 */