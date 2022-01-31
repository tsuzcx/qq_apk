package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.h.a.ez;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public class b
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private static boolean jJE;
  private ah jJA = new b.8(this, Looper.getMainLooper());
  private j.a jJB = new b.9(this);
  private boolean jJC = true;
  private boolean jJD = false;
  private final long jJo = 1600L;
  private z jJp;
  private bp jJq;
  private ca jJr;
  private b.a jJs;
  private b.b jJt;
  private HashMap<String, Integer> jJu = new HashMap();
  private g.a jJv = new b.5(this);
  i.a jJw = new b.6(this);
  private ah jJx = new b.7(this, Looper.getMainLooper());
  private LinkedList<String> jJy = new LinkedList();
  private final long jJz = 60L;
  m.b jwR = new b.10(this);
  
  static
  {
    int i = m.yR();
    try
    {
      if (!Build.CPU_ABI.contains("armeabi")) {
        y.e("hakon SilkCodec", "x86 machines not supported.");
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        dgp = localHashMap;
        localHashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new b.1());
        dgp.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new b.3());
        jJE = false;
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        k.b("wechatvoicesilk_v7a", b.class.getClassLoader());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("hakon SilkCodec", "load library failed!");
        continue;
        if ((i & 0x200) != 0)
        {
          k.b("wechatvoicesilk", b.class.getClassLoader());
          Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
        }
        else
        {
          y.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
        }
      }
    }
  }
  
  public static b aNn()
  {
    au.Hq();
    b localb2 = (b)bu.iR("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      au.Hq().a("plugin.ext", localb1);
    }
    return localb1;
  }
  
  public static z aNo()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aNn().jJp == null)
    {
      b localb = aNn();
      au.Hx();
      localb.jJp = new z(com.tencent.mm.model.c.Dv());
    }
    return aNn().jJp;
  }
  
  public static bp aNp()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aNn().jJq == null)
    {
      b localb = aNn();
      au.Hx();
      localb.jJq = new bp(com.tencent.mm.model.c.Dv());
    }
    return aNn().jJq;
  }
  
  public static ca aNq()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aNn().jJr == null)
    {
      b localb = aNn();
      au.Hx();
      localb.jJr = new ca(com.tencent.mm.model.c.Dv());
    }
    return aNn().jJr;
  }
  
  private static void aNr()
  {
    File localFile = new File(com.tencent.mm.kernel.g.DP().dKt);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.kernel.g.DP().dKt + "image/ext/pcm");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    y.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { com.tencent.mm.kernel.g.DP().dKt, bk.csb() });
  }
  
  public static String aNs()
  {
    return com.tencent.mm.kernel.g.DP().dKt + "image/ext/pcm";
  }
  
  public static void aNt()
  {
    Object localObject = (String)aNo().get(ac.a.uto, null);
    y.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = " + (String)localObject);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        Intent localIntent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
        localIntent.setPackage(str);
        com.tencent.mm.compatible.a.a.a(12, new b.4(localIntent));
        localIntent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
        ae.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
  }
  
  public static ad eg(long paramLong)
  {
    if ((au.DK()) && (paramLong > 0L))
    {
      au.Hx();
      return com.tencent.mm.model.c.Fw().hE(paramLong);
    }
    return null;
  }
  
  public static void eh(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    try
    {
      au.Hx();
      if (com.tencent.mm.model.c.Fy().fg(paramLong))
      {
        au.Hx();
        com.tencent.mm.plugin.messenger.foundation.a.a.g localg = com.tencent.mm.model.c.Fy();
        au.Hx();
        localg.U(com.tencent.mm.model.c.Fy().fd(paramLong));
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SubCoreExt", localException.getMessage());
      y.printErrStackTrace("MicroMsg.SubCoreExt", localException, "", new Object[0]);
      return;
    }
    y.e("MicroMsg.SubCoreExt", "msgId is out of range, " + paramLong);
  }
  
  private void fH(boolean paramBoolean)
  {
    if (!this.jJC) {}
    do
    {
      return;
      if ((paramBoolean) && (this.jJD))
      {
        y.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
        return;
      }
    } while ((!paramBoolean) && (!jJE));
    y.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jJD), Boolean.valueOf(jJE) });
    this.jJC = false;
    au.DS().k(new b.2(this), 10000L);
  }
  
  public final void aNu()
  {
    this.jJx.removeMessages(0);
    this.jJx.sendEmptyMessageDelayed(0, 1600L);
  }
  
  public final void bh(boolean paramBoolean)
  {
    Object localObject = new ez();
    ((ez)localObject).bLq.op = 1;
    if (!com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject)) {
      y.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    com.tencent.mm.pluginsdk.model.i.cku().ckv();
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this.jJv, null);
    if (this.jJs == null) {
      this.jJs = new b.a();
    }
    com.tencent.mm.sdk.b.a.udP.c(this.jJs);
    if (this.jJt == null) {
      this.jJt = new b.b();
    }
    com.tencent.mm.sdk.b.a.udP.c(this.jJt);
    localObject = ap.brn();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.i)localObject).c(this.jJB);
    }
    localObject = ae.cqS();
    this.jJD = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    jJE = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    y.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.jJD), Boolean.valueOf(jJE) });
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this.jwR);
    fH(true);
    com.tencent.mm.plugin.ext.c.c.aNI();
    aNr();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (this.jJs != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.jJs);
    }
    if (this.jJt != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.jJt);
    }
    Object localObject = ap.brn();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.i)localObject).d(this.jJB);
    }
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this.jJv);
    localObject = new ez();
    ((ez)localObject).bLq.op = 2;
    if (!com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject)) {
      y.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = com.tencent.mm.pluginsdk.model.i.cku();
    if (au.DK())
    {
      com.tencent.mm.pluginsdk.model.i.rTk = false;
      ap.brq().b(14, (t)localObject);
    }
    au.Hx();
    com.tencent.mm.model.c.Fw().b(this.jwR);
    com.tencent.mm.plugin.ext.c.c.aNJ();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */