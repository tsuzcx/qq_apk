package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.cg.e;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements d.a
{
  private static final String[] COLUMNS;
  private static boolean ezJ;
  private static final UriMatcher meK;
  private static ap meM;
  private boolean bmx;
  private b.a dZA;
  private com.tencent.mm.pluginsdk.c.b efx;
  private com.tencent.mm.modelgeo.d fwu;
  private int meD;
  private List<azr> meE;
  private e meF;
  private Set<String> meG;
  private CountDownLatch meH;
  private CountDownLatch meI;
  private azr meJ;
  private boolean meL;
  
  static
  {
    AppMethodBeat.i(20376);
    COLUMNS = new String[] { "nickname", "avatar", "distance", "signature", "sex" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    meK = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
    meK.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
    meK.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    ezJ = false;
    meM = new ap(new ExtControlProviderNearBy.1(), false);
    AppMethodBeat.o(20376);
  }
  
  public ExtControlProviderNearBy()
  {
    AppMethodBeat.i(20366);
    this.meL = false;
    this.efx = new ExtControlProviderNearBy.3(this);
    this.dZA = new ExtControlProviderNearBy.4(this);
    AppMethodBeat.o(20366);
  }
  
  private azr Ne(String paramString)
  {
    AppMethodBeat.i(20369);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      AppMethodBeat.o(20369);
      return null;
    }
    Iterator localIterator = this.meE.iterator();
    while (localIterator.hasNext())
    {
      azr localazr = (azr)localIterator.next();
      if (localazr.jJA.equals(paramString))
      {
        AppMethodBeat.o(20369);
        return localazr;
      }
    }
    AppMethodBeat.o(20369);
    return null;
  }
  
  private void a(azr paramazr)
  {
    AppMethodBeat.i(20370);
    if ((paramazr == null) || (paramazr.jJA == null))
    {
      ab.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
      AppMethodBeat.o(20370);
      return;
    }
    this.meG.add(paramazr.jJA);
    Bitmap localBitmap = com.tencent.mm.ah.b.b(paramazr.jJA, false, -1);
    ab.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.meI.getCount());
    if (localBitmap != null)
    {
      ab.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[0];
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      this.meG.remove(paramazr.jJA);
      this.meF.addRow(new Object[] { paramazr.jKG, arrayOfByte, paramazr.xpd, paramazr.gwS, Integer.valueOf(paramazr.gwP) });
      ab.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    AppMethodBeat.o(20370);
  }
  
  private void btH()
  {
    AppMethodBeat.i(20372);
    if (this.meG.size() > 0)
    {
      Iterator localIterator = this.meG.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ab.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
        this.meJ = Ne(str);
        if ((this.meJ != null) && (this.meJ.jJA != null)) {
          this.meF.addRow(new Object[] { this.meJ.jKG, null, this.meJ.xpd, this.meJ.gwS, Integer.valueOf(this.meJ.gwP) });
        }
      }
      AppMethodBeat.o(20372);
      return;
    }
    ab.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    AppMethodBeat.o(20372);
  }
  
  private static void dR(boolean paramBoolean)
  {
    AppMethodBeat.i(20367);
    if (paramBoolean)
    {
      ezJ = true;
      meM.ag(15000L, 15000L);
      AppMethodBeat.o(20367);
      return;
    }
    meM.ag(0L, 0L);
    AppMethodBeat.o(20367);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(20373);
    this.meD = -1;
    switch (meK.match(paramUri))
    {
    default: 
      this.meD = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(20373);
      return null;
      this.meD = 1;
      continue;
      this.meD = 3;
      continue;
      this.meD = 4;
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
    AppMethodBeat.i(20368);
    ab.i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), 15);
    if (paramUri == null)
    {
      vA(3);
      AppMethodBeat.o(20368);
      return null;
    }
    if ((bo.isNullOrNil(this.mei)) || (bo.isNullOrNil(btD())))
    {
      vA(3);
      AppMethodBeat.o(20368);
      return null;
    }
    if (ezJ)
    {
      ab.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      vA(5);
      AppMethodBeat.o(20368);
      return null;
    }
    dR(true);
    if (!aVH())
    {
      dR(false);
      vA(1);
      paramUri = this.jLW;
      AppMethodBeat.o(20368);
      return paramUri;
    }
    if (!dO(getContext()))
    {
      ab.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      dR(false);
      vA(2);
      AppMethodBeat.o(20368);
      return null;
    }
    ab.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.meD);
    getType(paramUri);
    if (this.meD < 0)
    {
      ab.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      dR(false);
      vA(3);
      AppMethodBeat.o(20368);
      return null;
    }
    for (;;)
    {
      try
      {
        this.meE = new ArrayList();
        this.meF = new e(COLUMNS, (byte)0);
        this.meH = new CountDownLatch(1);
        this.meI = null;
        this.meG = new HashSet();
        this.meE = new ArrayList();
        this.bmx = false;
        ab.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (aw.RG()) {
          continue;
        }
        ab.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        ab.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.meH.await(15000L, TimeUnit.MILLISECONDS)) {
          ab.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.meI == null) {
          continue;
        }
        ab.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.meI.await(15000L, TimeUnit.MILLISECONDS)) {
          ab.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        ab.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        vA(4);
        continue;
        ab.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        vA(4);
        continue;
      }
      dR(false);
      o.acQ().b(this);
      this.bmx = true;
      btH();
      if ((this.meF == null) || (this.meF.getCount() <= 0)) {
        continue;
      }
      vA(0);
      ab.i("MicroMsg.ExtControlProviderNearBy", "return now");
      paramUri = this.meF;
      AppMethodBeat.o(20368);
      return paramUri;
      com.tencent.mm.pluginsdk.c.b.a(kr.class.getName(), this.efx);
      al.d(new ExtControlProviderNearBy.2(this));
    }
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(20371);
    ab.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(paramString)));
    if (this.bmx)
    {
      ab.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      AppMethodBeat.o(20371);
      return;
    }
    a(Ne(paramString));
    this.meI.countDown();
    AppMethodBeat.o(20371);
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy
 * JD-Core Version:    0.7.0.1
 */