package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.cf.e;
import com.tencent.mm.h.a.ke;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static boolean dCs = false;
  private static final UriMatcher jKG;
  private static am jKI = new am(new ExtControlProviderNearBy.1(), false);
  private static final String[] yY = { "nickname", "avatar", "distance", "signature", "sex" };
  private boolean aVP;
  private a.a dig = new ExtControlProviderNearBy.4(this);
  private com.tencent.mm.pluginsdk.c.b doa = new ExtControlProviderNearBy.3(this);
  private c egs;
  private List<atm> jKA;
  private e jKB;
  private Set<String> jKC;
  private CountDownLatch jKD;
  private CountDownLatch jKE;
  private atm jKF;
  private boolean jKH = false;
  private int jKz;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jKG = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
    jKG.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
    jKG.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
  }
  
  private atm Cd(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
      return null;
    }
    Iterator localIterator = this.jKA.iterator();
    while (localIterator.hasNext())
    {
      atm localatm = (atm)localIterator.next();
      if (localatm.hPY.equals(paramString)) {
        return localatm;
      }
    }
    return null;
  }
  
  private void a(atm paramatm)
  {
    if ((paramatm == null) || (paramatm.hPY == null)) {
      y.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
    }
    Bitmap localBitmap;
    do
    {
      return;
      this.jKC.add(paramatm.hPY);
      localBitmap = com.tencent.mm.ag.b.a(paramatm.hPY, false, -1);
      y.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.jKE.getCount());
    } while (localBitmap == null);
    y.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[0];
    if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream)) {
      arrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    this.jKC.remove(paramatm.hPY);
    this.jKB.addRow(new Object[] { paramatm.hRf, arrayOfByte, paramatm.tpf, paramatm.ffk, Integer.valueOf(paramatm.ffh) });
    y.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", new Object[] { localBitmap });
    localBitmap.recycle();
  }
  
  private void aNE()
  {
    if (this.jKC.size() > 0)
    {
      Iterator localIterator = this.jKC.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        y.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: " + str);
        this.jKF = Cd(str);
        if ((this.jKF != null) && (this.jKF.hPY != null)) {
          this.jKB.addRow(new Object[] { this.jKF.hRf, null, this.jKF.tpf, this.jKF.ffk, Integer.valueOf(this.jKF.ffh) });
        }
      }
    }
    y.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
  }
  
  private static void cN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      dCs = true;
      jKI.S(15000L, 15000L);
      return;
    }
    jKI.S(0L, 0L);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    this.jKz = -1;
    switch (jKG.match(paramUri))
    {
    default: 
      this.jKz = -1;
    }
    for (;;)
    {
      return null;
      this.jKz = 1;
      continue;
      this.jKz = 3;
      continue;
      this.jKz = 4;
    }
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public final void kk(String paramString)
  {
    y.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: " + paramString);
    if (this.aVP)
    {
      y.i("MicroMsg.ExtControlProviderNearBy", "has finished");
      return;
    }
    a(Cd(paramString));
    this.jKE.countDown();
  }
  
  public final boolean onCreate()
  {
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    y.i("MicroMsg.ExtControlProviderNearBy", "query() " + paramUri);
    a(paramUri, getContext(), 15);
    if (paramUri == null)
    {
      qF(3);
      return null;
    }
    if ((bk.bl(this.jKd)) || (bk.bl(aNA())))
    {
      qF(3);
      return null;
    }
    if (dCs)
    {
      y.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
      qF(5);
      return null;
    }
    cN(true);
    if (!awd())
    {
      cN(false);
      qF(1);
      return this.hSn;
    }
    if (!dc(getContext()))
    {
      y.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
      cN(false);
      qF(2);
      return null;
    }
    y.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.jKz);
    getType(paramUri);
    if (this.jKz < 0)
    {
      y.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
      cN(false);
      qF(3);
      return null;
    }
    for (;;)
    {
      try
      {
        this.jKA = new ArrayList();
        this.jKB = new e(yY, (byte)0);
        this.jKD = new CountDownLatch(1);
        this.jKE = null;
        this.jKC = new HashSet();
        this.jKA = new ArrayList();
        this.aVP = false;
        y.v("MicroMsg.ExtControlProviderNearBy", "start()");
        if (au.DK()) {
          continue;
        }
        y.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        y.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
        if (!this.jKD.await(15000L, TimeUnit.MILLISECONDS)) {
          y.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
        }
        if (this.jKE == null) {
          continue;
        }
        y.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
        if (!this.jKE.await(15000L, TimeUnit.MILLISECONDS)) {
          y.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
        }
      }
      catch (Exception paramUri)
      {
        y.w("MicroMsg.ExtControlProviderNearBy", paramUri.getMessage());
        y.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", paramUri, "", new Object[0]);
        qF(4);
        continue;
        y.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
        continue;
        qF(4);
        continue;
      }
      cN(false);
      o.JQ().b(this);
      this.aVP = true;
      aNE();
      if ((this.jKB == null) || (this.jKB.getCount() <= 0)) {
        continue;
      }
      qF(0);
      y.i("MicroMsg.ExtControlProviderNearBy", "return now");
      return this.jKB;
      com.tencent.mm.pluginsdk.c.b.a(ke.class.getName(), this.doa);
      ai.d(new ExtControlProviderNearBy.2(this));
    }
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