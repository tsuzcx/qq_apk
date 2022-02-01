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
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.mo.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.btk;
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
  private static boolean grY;
  private static final UriMatcher rdQ;
  private static av rdS;
  private boolean bWS;
  private b.a fFl;
  private com.tencent.mm.pluginsdk.c.b fNg;
  private d hQo;
  private int rdJ;
  private List<btk> rdK;
  private com.tencent.mm.storagebase.e rdL;
  private Set<String> rdM;
  private CountDownLatch rdN;
  private CountDownLatch rdO;
  private btk rdP;
  private boolean rdR;
  
  static
  {
    AppMethodBeat.i(24455);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    rdQ = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
    rdQ.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
    rdQ.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    grY = false;
    rdS = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24441);
        ExtControlProviderNearBy.Jy();
        AppMethodBeat.o(24441);
        return false;
      }
    }, false);
    AppMethodBeat.o(24455);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(24445);
    this.rdR = false;
    this.fNg = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(24443);
        if ((paramAnonymousb instanceof mo))
        {
          if (ExtControlProviderNearBy.c(ExtControlProviderNearBy.this) == null)
          {
            AppMethodBeat.o(24443);
            return;
          }
          paramAnonymousString = (mo)paramAnonymousb;
          ad.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramAnonymousInt2 + ", errType: " + paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label273;
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, paramAnonymousString.dAo.dAv);
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
    this.fFl = new b.a()
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
        mo localmo = new mo();
        localmo.dAn.drI = ExtControlProviderNearBy.i(ExtControlProviderNearBy.this);
        localmo.dAn.dAp = paramAnonymousFloat1;
        localmo.dAn.dyz = paramAnonymousFloat2;
        localmo.dAn.dAq = ((int)paramAnonymousDouble2);
        localmo.dAn.dAr = paramAnonymousInt;
        localmo.dAn.dAs = "";
        localmo.dAn.dAt = "";
        if (a.IbL.l(localmo)) {
          ad.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
        }
        AppMethodBeat.o(24444);
        return false;
      }
    };
    AppMethodBeat.o(24445);
  }
  
  private void a(btk parambtk)
  {
    AppMethodBeat.i(24449);
    if ((parambtk == null) || (parambtk.nDo == null))
    {
      ad.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(24449);
      return;
    }
    this.rdM.add(parambtk.nDo);
    Bitmap localBitmap = c.a(parambtk.nDo, false, -1, null);
    ad.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.rdO.getCount());
    if (localBitmap != null)
    {
      ad.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.rdM.remove(parambtk.nDo);
      this.rdL.addRow(new Object[] { parambtk.nEt, arrayOfByte, parambtk.GNT, parambtk.jdf, Integer.valueOf(parambtk.jdc) });
      ad.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(24449);
  }
  
  private btk afK(String paramString)
  {
    AppMethodBeat.i(24448);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(24448);
      return null;
    }
    Iterator localIterator = this.rdK.iterator();
    while (localIterator.hasNext())
    {
      btk localbtk = (btk)localIterator.next();
      if (localbtk.nDo.equals(paramString))
      {
        AppMethodBeat.o(24448);
        return localbtk;
      }
    }
    AppMethodBeat.o(24448);
    return null;
  }
  
  private void csn()
  {
    AppMethodBeat.i(24451);
    if (this.rdM.size() > 0)
    {
      Iterator localIterator = this.rdM.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ad.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.rdP = afK(str);
        if ((this.rdP != null) && (this.rdP.nDo != null)) {
          this.rdL.addRow(new Object[] { this.rdP.nEt, null, this.rdP.GNT, this.rdP.jdf, Integer.valueOf(this.rdP.jdc) });
        }
      }
      AppMethodBeat.o(24451);
      return;
    }
    ad.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(24451);
  }
  
  private static void ga(boolean paramBoolean)
  {
    AppMethodBeat.i(24446);
    if (paramBoolean)
    {
      grY = true;
      rdS.az(15000L, 15000L);
      AppMethodBeat.o(24446);
      return;
    }
    rdS.az(0L, 0L);
    AppMethodBeat.o(24446);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(24450);
    ad.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.bWS)
    {
      ad.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(24450);
      return;
    }
    a(afK(paramString));
    this.rdO.countDown();
    AppMethodBeat.o(24450);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(24452);
    this.rdJ = -1;
    switch (rdQ.match(paramUri))
    {
    default: 
      this.rdJ = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(24452);
      return null;
      this.rdJ = 1;
      continue;
      this.rdJ = 3;
      continue;
      this.rdJ = 4;
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
      DF(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if ((bt.isNullOrNil(this.rdo)) || (bt.isNullOrNil(csj())))
    {
      DF(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if (grY)
    {
      ad.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      DF(5);
      AppMethodBeat.o(24447);
      return null;
    }
    ga(true);
    if (!bMn())
    {
      ga(false);
      DF(1);
      paramUri = this.nNT;
      AppMethodBeat.o(24447);
      return paramUri;
    }
    if (!eG(getContext()))
    {
      ad.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      ga(false);
      DF(2);
      AppMethodBeat.o(24447);
      return null;
    }
    ad.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.rdJ);
    getType(paramUri);
    if (this.rdJ < 0)
    {
      ad.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      ga(false);
      DF(3);
      AppMethodBeat.o(24447);
      return null;
    }
    for (;;)
    {
      try
      {
        this.rdK = new ArrayList();
        this.rdL = new com.tencent.mm.storagebase.e(COLUMNS, (byte)0);
        this.rdN = new CountDownLatch(1);
        this.rdO = null;
        this.rdM = new HashSet();
        this.rdK = new ArrayList();
        this.bWS = false;
        ad.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (ba.ajx()) {
          continue;
        }
        ad.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        ad.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.rdN.await(15000L, TimeUnit.MILLISECONDS)) {
          ad.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.rdO == null) {
          continue;
        }
        ad.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.rdO.await(15000L, TimeUnit.MILLISECONDS)) {
          ad.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        ad.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        DF(4);
        continue;
        ad.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        DF(4);
        continue;
      }
      ga(false);
      p.aEk().b(this);
      this.bWS = true;
      csn();
      if ((this.rdL == null) || (this.rdL.getCount() <= 0)) {
        continue;
      }
      DF(0);
      ad.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.rdL;
      AppMethodBeat.o(24447);
      return paramUri;
      com.tencent.mm.pluginsdk.c.b.a(mo.class.getName(), this.fNg);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24442);
          if (ExtControlProviderNearBy.a(ExtControlProviderNearBy.this) == null) {
            ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, d.aHQ());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy
 * JD-Core Version:    0.7.0.1
 */