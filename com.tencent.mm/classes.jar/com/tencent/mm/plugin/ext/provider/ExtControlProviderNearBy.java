package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.b;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final String[] COLUMNS;
  private static boolean fUH;
  private static final UriMatcher pLv;
  private static av pLx;
  private boolean bOX;
  private b.a fjJ;
  private com.tencent.mm.pluginsdk.c.b fqA;
  private d gXu;
  private int pLo;
  private List<blb> pLp;
  private com.tencent.mm.storagebase.e pLq;
  private Set<String> pLr;
  private CountDownLatch pLs;
  private CountDownLatch pLt;
  private blb pLu;
  private boolean pLw;
  
  static
  {
    AppMethodBeat.i(24455);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    pLv = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
    pLv.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
    pLv.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    fUH = false;
    pLx = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24441);
        ExtControlProviderNearBy.acT();
        AppMethodBeat.o(24441);
        return false;
      }
    }, false);
    AppMethodBeat.o(24455);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(24445);
    this.pLw = false;
    this.fqA = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(24443);
        if ((paramAnonymousb instanceof lw))
        {
          if (ExtControlProviderNearBy.c(ExtControlProviderNearBy.this) == null)
          {
            AppMethodBeat.o(24443);
            return;
          }
          paramAnonymousString = (lw)paramAnonymousb;
          ad.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramAnonymousInt2 + ", errType: " + paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label273;
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, paramAnonymousString.dqP.dqW);
          if ((ExtControlProviderNearBy.d(ExtControlProviderNearBy.this) != null) && (ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size() != 0)) {
            break label146;
          }
          ad.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
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
            ad.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size());
            ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).subList(10, ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()).clear();
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, new CountDownLatch(ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()));
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          ExtControlProviderNearBy.e(ExtControlProviderNearBy.this);
          continue;
          label273:
          ad.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + paramAnonymousInt2 + ", errType=" + paramAnonymousInt1);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
        }
      }
    };
    this.fjJ = new b.a()
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
          ad.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
          ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          AppMethodBeat.o(24444);
          return false;
        }
        lw locallw = new lw();
        locallw.dqO.diR = ExtControlProviderNearBy.i(ExtControlProviderNearBy.this);
        locallw.dqO.dqQ = paramAnonymousFloat1;
        locallw.dqO.dpb = paramAnonymousFloat2;
        locallw.dqO.dqR = ((int)paramAnonymousDouble2);
        locallw.dqO.dqS = paramAnonymousInt;
        locallw.dqO.dqT = "";
        locallw.dqO.dqU = "";
        if (a.ESL.l(locallw)) {
          ad.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
        }
        AppMethodBeat.o(24444);
        return false;
      }
    };
    AppMethodBeat.o(24445);
  }
  
  private blb Xy(String paramString)
  {
    AppMethodBeat.i(24448);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(24448);
      return null;
    }
    Iterator localIterator = this.pLp.iterator();
    while (localIterator.hasNext())
    {
      blb localblb = (blb)localIterator.next();
      if (localblb.mAQ.equals(paramString))
      {
        AppMethodBeat.o(24448);
        return localblb;
      }
    }
    AppMethodBeat.o(24448);
    return null;
  }
  
  private void a(blb paramblb)
  {
    AppMethodBeat.i(24449);
    if ((paramblb == null) || (paramblb.mAQ == null))
    {
      ad.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(24449);
      return;
    }
    this.pLr.add(paramblb.mAQ);
    Bitmap localBitmap = c.a(paramblb.mAQ, false, -1, null);
    ad.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.pLt.getCount());
    if (localBitmap != null)
    {
      ad.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.pLr.remove(paramblb.mAQ);
      this.pLq.addRow(new Object[] { paramblb.mBV, arrayOfByte, paramblb.DIU, paramblb.ijP, Integer.valueOf(paramblb.ijM) });
      ad.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(24449);
  }
  
  private void cfb()
  {
    AppMethodBeat.i(24451);
    if (this.pLr.size() > 0)
    {
      Iterator localIterator = this.pLr.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ad.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.pLu = Xy(str);
        if ((this.pLu != null) && (this.pLu.mAQ != null)) {
          this.pLq.addRow(new Object[] { this.pLu.mBV, null, this.pLu.DIU, this.pLu.ijP, Integer.valueOf(this.pLu.ijM) });
        }
      }
      AppMethodBeat.o(24451);
      return;
    }
    ad.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(24451);
  }
  
  private static void fz(boolean paramBoolean)
  {
    AppMethodBeat.i(24446);
    if (paramBoolean)
    {
      fUH = true;
      pLx.av(15000L, 15000L);
      AppMethodBeat.o(24446);
      return;
    }
    pLx.av(0L, 0L);
    AppMethodBeat.o(24446);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(24452);
    this.pLo = -1;
    switch (pLv.match(paramUri))
    {
    default: 
      this.pLo = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(24452);
      return null;
      this.pLo = 1;
      continue;
      this.pLo = 3;
      continue;
      this.pLo = 4;
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
    ad.i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), 15);
    if (paramUri == null)
    {
      BS(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if ((bt.isNullOrNil(this.pKT)) || (bt.isNullOrNil(ceX())))
    {
      BS(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if (fUH)
    {
      ad.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      BS(5);
      AppMethodBeat.o(24447);
      return null;
    }
    fz(true);
    if (!bBg())
    {
      fz(false);
      BS(1);
      paramUri = this.mKX;
      AppMethodBeat.o(24447);
      return paramUri;
    }
    if (!ey(getContext()))
    {
      ad.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      fz(false);
      BS(2);
      AppMethodBeat.o(24447);
      return null;
    }
    ad.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.pLo);
    getType(paramUri);
    if (this.pLo < 0)
    {
      ad.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      fz(false);
      BS(3);
      AppMethodBeat.o(24447);
      return null;
    }
    for (;;)
    {
      try
      {
        this.pLp = new ArrayList();
        this.pLq = new com.tencent.mm.storagebase.e(COLUMNS, (byte)0);
        this.pLs = new CountDownLatch(1);
        this.pLt = null;
        this.pLr = new HashSet();
        this.pLp = new ArrayList();
        this.bOX = false;
        ad.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (az.afw()) {
          continue;
        }
        ad.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        ad.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.pLs.await(15000L, TimeUnit.MILLISECONDS)) {
          ad.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.pLt == null) {
          continue;
        }
        ad.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.pLt.await(15000L, TimeUnit.MILLISECONDS)) {
          ad.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        ad.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        BS(4);
        continue;
        ad.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        BS(4);
        continue;
      }
      fz(false);
      p.auq().b(this);
      this.bOX = true;
      cfb();
      if ((this.pLq == null) || (this.pLq.getCount() <= 0)) {
        continue;
      }
      BS(0);
      ad.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.pLq;
      AppMethodBeat.o(24447);
      return paramUri;
      com.tencent.mm.pluginsdk.c.b.a(lw.class.getName(), this.fqA);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24442);
          if (ExtControlProviderNearBy.a(ExtControlProviderNearBy.this) == null) {
            ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, d.axT());
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
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(24450);
    ad.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.bOX)
    {
      ad.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(24450);
      return;
    }
    a(Xy(paramString));
    this.pLt.countDown();
    AppMethodBeat.o(24450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy
 * JD-Core Version:    0.7.0.1
 */