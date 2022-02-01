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
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.b;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static boolean fYC;
  private static final UriMatcher qud;
  private static au quf;
  private boolean bMF;
  private b.a fnd;
  private com.tencent.mm.pluginsdk.c.b fuf;
  private d hxT;
  private int qtV;
  private List<box> qtW;
  private com.tencent.mm.storagebase.e qtX;
  private Set<String> qtY;
  private CountDownLatch qtZ;
  private CountDownLatch qub;
  private box quc;
  private boolean que;
  
  static
  {
    AppMethodBeat.i(24455);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    qud = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
    qud.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
    qud.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    fYC = false;
    quf = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24441);
        ExtControlProviderNearBy.adZ();
        AppMethodBeat.o(24441);
        return false;
      }
    }, false);
    AppMethodBeat.o(24455);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(24445);
    this.que = false;
    this.fuf = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(24443);
        if ((paramAnonymousb instanceof mf))
        {
          if (ExtControlProviderNearBy.c(ExtControlProviderNearBy.this) == null)
          {
            AppMethodBeat.o(24443);
            return;
          }
          paramAnonymousString = (mf)paramAnonymousb;
          ac.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramAnonymousInt2 + ", errType: " + paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label273;
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, paramAnonymousString.doA.doH);
          if ((ExtControlProviderNearBy.d(ExtControlProviderNearBy.this) != null) && (ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size() != 0)) {
            break label146;
          }
          ac.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
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
            ac.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size());
            ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).subList(10, ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()).clear();
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, new CountDownLatch(ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()));
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          ExtControlProviderNearBy.e(ExtControlProviderNearBy.this);
          continue;
          label273:
          ac.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + paramAnonymousInt2 + ", errType=" + paramAnonymousInt1);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
        }
      }
    };
    this.fnd = new b.a()
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
          ac.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
          ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          AppMethodBeat.o(24444);
          return false;
        }
        mf localmf = new mf();
        localmf.doz.dgm = ExtControlProviderNearBy.i(ExtControlProviderNearBy.this);
        localmf.doz.doB = paramAnonymousFloat1;
        localmf.doz.dmL = paramAnonymousFloat2;
        localmf.doz.doC = ((int)paramAnonymousDouble2);
        localmf.doz.doD = paramAnonymousInt;
        localmf.doz.doE = "";
        localmf.doz.doF = "";
        if (a.GpY.l(localmf)) {
          ac.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
        }
        AppMethodBeat.o(24444);
        return false;
      }
    };
    AppMethodBeat.o(24445);
  }
  
  private void a(box parambox)
  {
    AppMethodBeat.i(24449);
    if ((parambox == null) || (parambox.ncR == null))
    {
      ac.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(24449);
      return;
    }
    this.qtY.add(parambox.ncR);
    Bitmap localBitmap = c.a(parambox.ncR, false, -1, null);
    ac.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.qub.getCount());
    if (localBitmap != null)
    {
      ac.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.qtY.remove(parambox.ncR);
      this.qtX.addRow(new Object[] { parambox.ndW, arrayOfByte, parambox.Fep, parambox.iJW, Integer.valueOf(parambox.iJT) });
      ac.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(24449);
  }
  
  private box abV(String paramString)
  {
    AppMethodBeat.i(24448);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(24448);
      return null;
    }
    Iterator localIterator = this.qtW.iterator();
    while (localIterator.hasNext())
    {
      box localbox = (box)localIterator.next();
      if (localbox.ncR.equals(paramString))
      {
        AppMethodBeat.o(24448);
        return localbox;
      }
    }
    AppMethodBeat.o(24448);
    return null;
  }
  
  private void cmI()
  {
    AppMethodBeat.i(24451);
    if (this.qtY.size() > 0)
    {
      Iterator localIterator = this.qtY.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ac.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.quc = abV(str);
        if ((this.quc != null) && (this.quc.ncR != null)) {
          this.qtX.addRow(new Object[] { this.quc.ndW, null, this.quc.Fep, this.quc.iJW, Integer.valueOf(this.quc.iJT) });
        }
      }
      AppMethodBeat.o(24451);
      return;
    }
    ac.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(24451);
  }
  
  private static void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(24446);
    if (paramBoolean)
    {
      fYC = true;
      quf.au(15000L, 15000L);
      AppMethodBeat.o(24446);
      return;
    }
    quf.au(0L, 0L);
    AppMethodBeat.o(24446);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(24450);
    ac.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.bMF)
    {
      ac.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(24450);
      return;
    }
    a(abV(paramString));
    this.qub.countDown();
    AppMethodBeat.o(24450);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(24452);
    this.qtV = -1;
    switch (qud.match(paramUri))
    {
    default: 
      this.qtV = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(24452);
      return null;
      this.qtV = 1;
      continue;
      this.qtV = 3;
      continue;
      this.qtV = 4;
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
    ac.i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), 15);
    if (paramUri == null)
    {
      CN(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if ((bs.isNullOrNil(this.qtA)) || (bs.isNullOrNil(cmE())))
    {
      CN(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if (fYC)
    {
      ac.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      CN(5);
      AppMethodBeat.o(24447);
      return null;
    }
    fV(true);
    if (!bIc())
    {
      fV(false);
      CN(1);
      paramUri = this.nng;
      AppMethodBeat.o(24447);
      return paramUri;
    }
    if (!eG(getContext()))
    {
      ac.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      fV(false);
      CN(2);
      AppMethodBeat.o(24447);
      return null;
    }
    ac.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.qtV);
    getType(paramUri);
    if (this.qtV < 0)
    {
      ac.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      fV(false);
      CN(3);
      AppMethodBeat.o(24447);
      return null;
    }
    for (;;)
    {
      try
      {
        this.qtW = new ArrayList();
        this.qtX = new com.tencent.mm.storagebase.e(COLUMNS, (byte)0);
        this.qtZ = new CountDownLatch(1);
        this.qub = null;
        this.qtY = new HashSet();
        this.qtW = new ArrayList();
        this.bMF = false;
        ac.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (az.agM()) {
          continue;
        }
        ac.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        ac.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.qtZ.await(15000L, TimeUnit.MILLISECONDS)) {
          ac.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.qub == null) {
          continue;
        }
        ac.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.qub.await(15000L, TimeUnit.MILLISECONDS)) {
          ac.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        ac.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        CN(4);
        continue;
        ac.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        CN(4);
        continue;
      }
      fV(false);
      p.aBh().b(this);
      this.bMF = true;
      cmI();
      if ((this.qtX == null) || (this.qtX.getCount() <= 0)) {
        continue;
      }
      CN(0);
      ac.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.qtX;
      AppMethodBeat.o(24447);
      return paramUri;
      com.tencent.mm.pluginsdk.c.b.a(mf.class.getName(), this.fuf);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24442);
          if (ExtControlProviderNearBy.a(ExtControlProviderNearBy.this) == null) {
            ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, d.aEL());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy
 * JD-Core Version:    0.7.0.1
 */