package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private static boolean mdI;
  n.b lGq;
  i.a mdA;
  private ak mdB;
  private LinkedList<String> mdC;
  private final long mdD;
  private ak mdE;
  private k.a mdF;
  private boolean mdG;
  private boolean mdH;
  private final long mds;
  private z mdt;
  private bp mdu;
  private ca mdv;
  private b.a mdw;
  private b.b mdx;
  private HashMap<String, Integer> mdy;
  private h.a mdz;
  
  static
  {
    AppMethodBeat.i(20290);
    int i = m.Lo();
    try
    {
      if (!Build.CPU_ABI.contains("armeabi")) {
        ab.e("hakon SilkCodec", "x86 machines not supported.");
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        baseDBFactories = localHashMap;
        localHashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new b.1());
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new b.3());
        mdI = false;
        AppMethodBeat.o(20290);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        k.a("wechatvoicesilk_v7a", b.class.getClassLoader());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("hakon SilkCodec", "load library failed!");
        continue;
        if ((i & 0x200) != 0)
        {
          k.a("wechatvoicesilk", b.class.getClassLoader());
          Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
        }
        else
        {
          ab.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
        }
      }
    }
  }
  
  public b()
  {
    AppMethodBeat.i(20274);
    this.mds = 1600L;
    this.mdy = new HashMap();
    this.mdz = new b.5(this);
    this.mdA = new b.6(this);
    this.mdB = new b.7(this, Looper.getMainLooper());
    this.mdC = new LinkedList();
    this.mdD = 60L;
    this.mdE = new b.8(this, Looper.getMainLooper());
    this.mdF = new b.9(this);
    this.lGq = new b.10(this);
    this.mdG = true;
    this.mdH = false;
    AppMethodBeat.o(20274);
  }
  
  public static b btq()
  {
    AppMethodBeat.i(20275);
    aw.aat();
    b localb2 = (b)bw.pF("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      aw.aat().a("plugin.ext", localb1);
    }
    AppMethodBeat.o(20275);
    return localb1;
  }
  
  public static z btr()
  {
    AppMethodBeat.i(20276);
    g.RJ().QQ();
    if (btq().mdt == null)
    {
      localObject = btq();
      aw.aaz();
      ((b)localObject).mdt = new z(com.tencent.mm.model.c.Rq());
    }
    Object localObject = btq().mdt;
    AppMethodBeat.o(20276);
    return localObject;
  }
  
  public static bp bts()
  {
    AppMethodBeat.i(20277);
    g.RJ().QQ();
    if (btq().mdu == null)
    {
      localObject = btq();
      aw.aaz();
      ((b)localObject).mdu = new bp(com.tencent.mm.model.c.Rq());
    }
    Object localObject = btq().mdu;
    AppMethodBeat.o(20277);
    return localObject;
  }
  
  public static ca btt()
  {
    AppMethodBeat.i(20278);
    g.RJ().QQ();
    if (btq().mdv == null)
    {
      localObject = btq();
      aw.aaz();
      ((b)localObject).mdv = new ca(com.tencent.mm.model.c.Rq());
    }
    Object localObject = btq().mdv;
    AppMethodBeat.o(20278);
    return localObject;
  }
  
  private static void btu()
  {
    AppMethodBeat.i(20280);
    File localFile = new File(g.RL().eHR);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(g.RL().eHR + "image/ext/pcm");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    ab.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", new Object[] { g.RL().eHR, bo.dtY() });
    AppMethodBeat.o(20280);
  }
  
  public static String btv()
  {
    AppMethodBeat.i(20283);
    String str = g.RL().eHR + "image/ext/pcm";
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static void btw()
  {
    AppMethodBeat.i(20284);
    Object localObject = (String)btr().get(ac.a.yDq, null);
    ab.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(localObject)));
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
        ah.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
    AppMethodBeat.o(20284);
  }
  
  private void hk(boolean paramBoolean)
  {
    AppMethodBeat.i(20288);
    if (!this.mdG)
    {
      AppMethodBeat.o(20288);
      return;
    }
    if ((paramBoolean) && (this.mdH))
    {
      ab.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      AppMethodBeat.o(20288);
      return;
    }
    if ((!paramBoolean) && (!mdI))
    {
      AppMethodBeat.o(20288);
      return;
    }
    ab.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mdH), Boolean.valueOf(mdI) });
    this.mdG = false;
    aw.RO().o(new b.2(this), 10000L);
    AppMethodBeat.o(20288);
  }
  
  public static ad jD(long paramLong)
  {
    AppMethodBeat.i(20285);
    if ((aw.RG()) && (paramLong > 0L))
    {
      aw.aaz();
      ad localad = com.tencent.mm.model.c.YA().on(paramLong);
      AppMethodBeat.o(20285);
      return localad;
    }
    AppMethodBeat.o(20285);
    return null;
  }
  
  public static void jE(long paramLong)
  {
    AppMethodBeat.i(20286);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(20286);
      return;
    }
    try
    {
      aw.aaz();
      if (com.tencent.mm.model.c.YC().kE(paramLong))
      {
        aw.aaz();
        h localh = com.tencent.mm.model.c.YC();
        aw.aaz();
        localh.aa(com.tencent.mm.model.c.YC().kB(paramLong));
        AppMethodBeat.o(20286);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SubCoreExt", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.SubCoreExt", localException, "", new Object[0]);
      AppMethodBeat.o(20286);
      return;
    }
    ab.e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(20286);
  }
  
  public final void btx()
  {
    AppMethodBeat.i(20287);
    this.mdB.removeMessages(0);
    this.mdB.sendEmptyMessageDelayed(0, 1600L);
    AppMethodBeat.o(20287);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20281);
    Object localObject = new fc();
    ((fc)localObject).csK.op = 1;
    if (!com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject)) {
      ab.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    com.tencent.mm.pluginsdk.model.i.dkZ().dla();
    aw.aaz();
    com.tencent.mm.model.c.YC().a(this.mdz, null);
    if (this.mdw == null) {
      this.mdw = new b.a();
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.mdw);
    if (this.mdx == null) {
      this.mdx = new b.b();
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.mdx);
    localObject = com.tencent.mm.pluginsdk.model.app.al.cac();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.i)localObject).add(this.mdF);
    }
    localObject = ah.dsQ();
    this.mdH = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    mdI = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    ab.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.mdH), Boolean.valueOf(mdI) });
    aw.aaz();
    com.tencent.mm.model.c.YA().a(this.lGq);
    hk(true);
    com.tencent.mm.plugin.ext.c.c.btL();
    btu();
    AppMethodBeat.o(20281);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20282);
    if (this.mdw != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.mdw);
    }
    if (this.mdx != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.mdx);
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.al.cac();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.i)localObject).remove(this.mdF);
    }
    aw.aaz();
    com.tencent.mm.model.c.YC().a(this.mdz);
    localObject = new fc();
    ((fc)localObject).csK.op = 2;
    if (!com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject)) {
      ab.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = com.tencent.mm.pluginsdk.model.i.dkZ();
    if (aw.RG())
    {
      com.tencent.mm.pluginsdk.model.i.vKi = false;
      com.tencent.mm.pluginsdk.model.app.al.caf().b(14, (t)localObject);
    }
    aw.aaz();
    com.tencent.mm.model.c.YA().b(this.lGq);
    com.tencent.mm.plugin.ext.c.c.btM();
    AppMethodBeat.o(20282);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(20279);
    btu();
    AppMethodBeat.o(20279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b
 * JD-Core Version:    0.7.0.1
 */