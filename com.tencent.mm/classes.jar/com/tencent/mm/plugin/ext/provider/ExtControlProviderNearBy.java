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
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mp.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static boolean guz;
  private static final UriMatcher rlW;
  private static aw rlY;
  private boolean bWS;
  private b.a fHp;
  private com.tencent.mm.pluginsdk.c.b fPo;
  private d hTg;
  private int rlP;
  private List<bue> rlQ;
  private com.tencent.mm.storagebase.e rlR;
  private Set<String> rlS;
  private CountDownLatch rlT;
  private CountDownLatch rlU;
  private bue rlV;
  private boolean rlX;
  
  static
  {
    AppMethodBeat.i(24455);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    rlW = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
    rlW.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
    rlW.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    guz = false;
    rlY = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24441);
        ExtControlProviderNearBy.JG();
        AppMethodBeat.o(24441);
        return false;
      }
    }, false);
    AppMethodBeat.o(24455);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(24445);
    this.rlX = false;
    this.fPo = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(24443);
        if ((paramAnonymousb instanceof mp))
        {
          if (ExtControlProviderNearBy.c(ExtControlProviderNearBy.this) == null)
          {
            AppMethodBeat.o(24443);
            return;
          }
          paramAnonymousString = (mp)paramAnonymousb;
          ae.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramAnonymousInt2 + ", errType: " + paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label273;
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, paramAnonymousString.dBt.dBA);
          if ((ExtControlProviderNearBy.d(ExtControlProviderNearBy.this) != null) && (ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size() != 0)) {
            break label146;
          }
          ae.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
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
            ae.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size());
            ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).subList(10, ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()).clear();
          }
          ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, new CountDownLatch(ExtControlProviderNearBy.d(ExtControlProviderNearBy.this).size()));
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          ExtControlProviderNearBy.e(ExtControlProviderNearBy.this);
          continue;
          label273:
          ae.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + paramAnonymousInt2 + ", errType=" + paramAnonymousInt1);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
        }
      }
    };
    this.fHp = new b.a()
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
          ae.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
          ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
          ExtControlProviderNearBy.c(ExtControlProviderNearBy.this).countDown();
          AppMethodBeat.o(24444);
          return false;
        }
        mp localmp = new mp();
        localmp.dBs.dsO = ExtControlProviderNearBy.i(ExtControlProviderNearBy.this);
        localmp.dBs.dBu = paramAnonymousFloat1;
        localmp.dBs.dzE = paramAnonymousFloat2;
        localmp.dBs.dBv = ((int)paramAnonymousDouble2);
        localmp.dBs.dBw = paramAnonymousInt;
        localmp.dBs.dBx = "";
        localmp.dBs.dBy = "";
        if (a.IvT.l(localmp)) {
          ae.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
        }
        AppMethodBeat.o(24444);
        return false;
      }
    };
    AppMethodBeat.o(24445);
  }
  
  private void a(bue parambue)
  {
    AppMethodBeat.i(24449);
    if ((parambue == null) || (parambue.nIJ == null))
    {
      ae.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(24449);
      return;
    }
    this.rlS.add(parambue.nIJ);
    Bitmap localBitmap = c.a(parambue.nIJ, false, -1, null);
    ae.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.rlU.getCount());
    if (localBitmap != null)
    {
      ae.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.rlS.remove(parambue.nIJ);
      this.rlR.addRow(new Object[] { parambue.nJO, arrayOfByte, parambue.Hht, parambue.jfY, Integer.valueOf(parambue.jfV) });
      ae.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(24449);
  }
  
  private bue agG(String paramString)
  {
    AppMethodBeat.i(24448);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(24448);
      return null;
    }
    Iterator localIterator = this.rlQ.iterator();
    while (localIterator.hasNext())
    {
      bue localbue = (bue)localIterator.next();
      if (localbue.nIJ.equals(paramString))
      {
        AppMethodBeat.o(24448);
        return localbue;
      }
    }
    AppMethodBeat.o(24448);
    return null;
  }
  
  private void ctP()
  {
    AppMethodBeat.i(24451);
    if (this.rlS.size() > 0)
    {
      Iterator localIterator = this.rlS.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ae.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.rlV = agG(str);
        if ((this.rlV != null) && (this.rlV.nIJ != null)) {
          this.rlR.addRow(new Object[] { this.rlV.nJO, null, this.rlV.Hht, this.rlV.jfY, Integer.valueOf(this.rlV.jfV) });
        }
      }
      AppMethodBeat.o(24451);
      return;
    }
    ae.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(24451);
  }
  
  private static void fZ(boolean paramBoolean)
  {
    AppMethodBeat.i(24446);
    if (paramBoolean)
    {
      guz = true;
      rlY.ay(15000L, 15000L);
      AppMethodBeat.o(24446);
      return;
    }
    rlY.ay(0L, 0L);
    AppMethodBeat.o(24446);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(24450);
    ae.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.bWS)
    {
      ae.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(24450);
      return;
    }
    a(agG(paramString));
    this.rlU.countDown();
    AppMethodBeat.o(24450);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(24452);
    this.rlP = -1;
    switch (rlW.match(paramUri))
    {
    default: 
      this.rlP = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(24452);
      return null;
      this.rlP = 1;
      continue;
      this.rlP = 3;
      continue;
      this.rlP = 4;
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
    ae.i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), 15);
    if (paramUri == null)
    {
      DS(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if ((bu.isNullOrNil(this.rlu)) || (bu.isNullOrNil(ctL())))
    {
      DS(3);
      AppMethodBeat.o(24447);
      return null;
    }
    if (guz)
    {
      ae.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      DS(5);
      AppMethodBeat.o(24447);
      return null;
    }
    fZ(true);
    if (!bNl())
    {
      fZ(false);
      DS(1);
      paramUri = this.nTy;
      AppMethodBeat.o(24447);
      return paramUri;
    }
    if (!eK(getContext()))
    {
      ae.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      fZ(false);
      DS(2);
      AppMethodBeat.o(24447);
      return null;
    }
    ae.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.rlP);
    getType(paramUri);
    if (this.rlP < 0)
    {
      ae.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      fZ(false);
      DS(3);
      AppMethodBeat.o(24447);
      return null;
    }
    for (;;)
    {
      try
      {
        this.rlQ = new ArrayList();
        this.rlR = new com.tencent.mm.storagebase.e(COLUMNS, (byte)0);
        this.rlT = new CountDownLatch(1);
        this.rlU = null;
        this.rlS = new HashSet();
        this.rlQ = new ArrayList();
        this.bWS = false;
        ae.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (bc.ajM()) {
          continue;
        }
        ae.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        ae.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.rlT.await(15000L, TimeUnit.MILLISECONDS)) {
          ae.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.rlU == null) {
          continue;
        }
        ae.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.rlU.await(15000L, TimeUnit.MILLISECONDS)) {
          ae.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        ae.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        ae.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        DS(4);
        continue;
        ae.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        DS(4);
        continue;
      }
      fZ(false);
      p.aEA().b(this);
      this.bWS = true;
      ctP();
      if ((this.rlR == null) || (this.rlR.getCount() <= 0)) {
        continue;
      }
      DS(0);
      ae.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.rlR;
      AppMethodBeat.o(24447);
      return paramUri;
      com.tencent.mm.pluginsdk.c.b.a(mp.class.getName(), this.fPo);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24442);
          if (ExtControlProviderNearBy.a(ExtControlProviderNearBy.this) == null) {
            ExtControlProviderNearBy.a(ExtControlProviderNearBy.this, d.aIh());
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