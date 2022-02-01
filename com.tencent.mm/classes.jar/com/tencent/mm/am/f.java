package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public static boolean avE()
  {
    AppMethodBeat.i(124057);
    if (af.awe().nI(1) > 0)
    {
      AppMethodBeat.o(124057);
      return true;
    }
    AppMethodBeat.o(124057);
    return false;
  }
  
  public static boolean avF()
  {
    AppMethodBeat.i(124058);
    if (af.awe().nI(4) > 0)
    {
      AppMethodBeat.o(124058);
      return true;
    }
    AppMethodBeat.o(124058);
    return false;
  }
  
  public static boolean avG()
  {
    AppMethodBeat.i(124059);
    if (af.awe().nI(8) > 0)
    {
      AppMethodBeat.o(124059);
      return true;
    }
    AppMethodBeat.o(124059);
    return false;
  }
  
  public static boolean avH()
  {
    AppMethodBeat.i(124060);
    if (af.awe().nI(16) > 0)
    {
      AppMethodBeat.o(124060);
      return true;
    }
    AppMethodBeat.o(124060);
    return false;
  }
  
  public static boolean avI()
  {
    AppMethodBeat.i(124061);
    if (af.awe().nI(64) > 0)
    {
      AppMethodBeat.o(124061);
      return true;
    }
    AppMethodBeat.o(124061);
    return false;
  }
  
  public static List<String> avJ()
  {
    AppMethodBeat.i(124062);
    List localList = af.awe().nH(128);
    AppMethodBeat.o(124062);
    return localList;
  }
  
  public static boolean avK()
  {
    AppMethodBeat.i(124063);
    if (af.awe().nI(128) > 0)
    {
      AppMethodBeat.o(124063);
      return true;
    }
    AppMethodBeat.o(124063);
    return false;
  }
  
  public static List<String> avL()
  {
    AppMethodBeat.i(124064);
    List localList = af.awe().nH(256);
    AppMethodBeat.o(124064);
    return localList;
  }
  
  public static boolean avM()
  {
    AppMethodBeat.i(124065);
    if (af.awe().nI(256) > 0)
    {
      AppMethodBeat.o(124065);
      return true;
    }
    AppMethodBeat.o(124065);
    return false;
  }
  
  public static List<String> avN()
  {
    AppMethodBeat.i(124066);
    List localList = af.awe().nH(512);
    AppMethodBeat.o(124066);
    return localList;
  }
  
  public static boolean avO()
  {
    AppMethodBeat.i(124067);
    if (af.awe().nI(512) > 0)
    {
      AppMethodBeat.o(124067);
      return true;
    }
    AppMethodBeat.o(124067);
    return false;
  }
  
  public static boolean ee(String paramString)
  {
    AppMethodBeat.i(191048);
    try
    {
      boolean bool = af.awn().wt(paramString).field_hide_colleage_invite;
      AppMethodBeat.o(191048);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(191048);
    }
    return true;
  }
  
  public static String ef(String paramString)
  {
    AppMethodBeat.i(191049);
    try
    {
      paramString = af.awn().wt(paramString);
      mo localmo = new mo();
      localmo.parseFrom(paramString.field_raw_attrs);
      paramString = localmo.CJz;
      AppMethodBeat.o(191049);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(191049);
    }
    return "";
  }
  
  public static String eg(String paramString)
  {
    AppMethodBeat.i(191050);
    try
    {
      paramString = af.awn().wt(paramString);
      mo localmo = new mo();
      localmo.parseFrom(paramString.field_raw_attrs);
      paramString = localmo.CJA;
      AppMethodBeat.o(191050);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(191050);
    }
    return "";
  }
  
  public static com.tencent.mm.api.c ei(String paramString)
  {
    AppMethodBeat.i(124043);
    paramString = af.awe().wy(paramString);
    if (paramString.field_updateTime > 0L)
    {
      AppMethodBeat.o(124043);
      return paramString;
    }
    AppMethodBeat.o(124043);
    return null;
  }
  
  public static void h(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124053);
    if (paramc == null)
    {
      ad.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      AppMethodBeat.o(124053);
      return;
    }
    bqc localbqc = new bqc();
    localbqc.ika = paramc.field_brandFlag;
    localbqc.mAQ = paramc.field_username;
    com.tencent.mm.storage.af localaf = ((k)g.ab(k.class)).apM().aHX(paramc.field_username);
    if ((localaf != null) && (b.ls(localaf.field_type))) {
      ((k)g.ab(k.class)).apL().c(new j.a(47, localbqc));
    }
    for (;;)
    {
      ad.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(af.awe().update(paramc, new String[0])), Integer.valueOf(paramc.field_brandFlag) });
      AppMethodBeat.o(124053);
      return;
      ((k)g.ab(k.class)).apL().c(new j.a(58, localbqc));
    }
  }
  
  public static void i(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124054);
    if (paramc != null)
    {
      bqc localbqc = new bqc();
      localbqc.ika = paramc.field_brandFlag;
      localbqc.mAQ = paramc.field_username;
      ((k)g.ab(k.class)).apL().c(new j.a(47, localbqc));
      af.awe().update(paramc, new String[0]);
    }
    AppMethodBeat.o(124054);
  }
  
  public static void j(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124055);
    if (paramc != null)
    {
      paramc.field_brandFlag |= 0x8;
      i(paramc);
    }
    AppMethodBeat.o(124055);
  }
  
  public static void k(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(124056);
    if (paramc != null)
    {
      paramc.field_brandFlag &= 0xFFFFFFF7;
      i(paramc);
    }
    AppMethodBeat.o(124056);
  }
  
  public static boolean pc(String paramString)
  {
    AppMethodBeat.i(124050);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124050);
      return false;
    }
    if (paramString.Jg())
    {
      AppMethodBeat.o(124050);
      return true;
    }
    AppMethodBeat.o(124050);
    return false;
  }
  
  public static boolean wG(String paramString)
  {
    AppMethodBeat.i(124044);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124044);
      return false;
    }
    if (paramString.Jb())
    {
      AppMethodBeat.o(124044);
      return true;
    }
    AppMethodBeat.o(124044);
    return false;
  }
  
  public static boolean wH(String paramString)
  {
    AppMethodBeat.i(124045);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124045);
      return false;
    }
    if (paramString.Jb())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    if (paramString.Jc())
    {
      AppMethodBeat.o(124045);
      return true;
    }
    AppMethodBeat.o(124045);
    return false;
  }
  
  public static boolean wI(String paramString)
  {
    AppMethodBeat.i(124046);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124046);
      return false;
    }
    boolean bool = paramString.Jc();
    AppMethodBeat.o(124046);
    return bool;
  }
  
  public static boolean wJ(String paramString)
  {
    AppMethodBeat.i(124047);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124047);
      return false;
    }
    if (paramString.Jd())
    {
      AppMethodBeat.o(124047);
      return true;
    }
    AppMethodBeat.o(124047);
    return false;
  }
  
  public static boolean wK(String paramString)
  {
    AppMethodBeat.i(124048);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124048);
      return false;
    }
    if (paramString.Jf())
    {
      AppMethodBeat.o(124048);
      return true;
    }
    AppMethodBeat.o(124048);
    return false;
  }
  
  public static boolean wL(String paramString)
  {
    AppMethodBeat.i(124049);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124049);
      return false;
    }
    if (paramString.Je())
    {
      AppMethodBeat.o(124049);
      return true;
    }
    AppMethodBeat.o(124049);
    return false;
  }
  
  public static boolean wM(String paramString)
  {
    AppMethodBeat.i(124051);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124051);
      return false;
    }
    if (paramString.Jh())
    {
      AppMethodBeat.o(124051);
      return true;
    }
    AppMethodBeat.o(124051);
    return false;
  }
  
  public static boolean wN(String paramString)
  {
    AppMethodBeat.i(124052);
    paramString = ei(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(124052);
      return false;
    }
    boolean bool = paramString.IW();
    AppMethodBeat.o(124052);
    return bool;
  }
  
  public static void wO(String paramString)
  {
    AppMethodBeat.i(124068);
    af.awe();
    Object localObject = e.wC(paramString);
    if (localObject != null) {
      ((p)g.ab(p.class)).apP().agw((String)localObject);
    }
    ((k)g.ab(k.class)).apR().aIl(paramString);
    localObject = ei(paramString);
    if (localObject == null)
    {
      af.awn().vv(paramString);
      AppMethodBeat.o(124068);
      return;
    }
    if (((com.tencent.mm.api.c)localObject).Je())
    {
      ((k)g.ab(k.class)).apR().aID(paramString);
      af.awe();
      List localList = e.wB(paramString);
      bi.al(localList);
      int i = 0;
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (pc(str)) {
          com.tencent.mm.am.a.e.M(str, true);
        }
        af.awe().delete(str);
        i += 1;
      }
    }
    if (((com.tencent.mm.api.c)localObject).Jg()) {
      com.tencent.mm.am.a.e.M(paramString, true);
    }
    af.awe().e((com.tencent.mm.api.c)localObject);
    af.awn().vv(paramString);
    AppMethodBeat.o(124068);
  }
  
  public static List<dpl> wP(String paramString)
  {
    AppMethodBeat.i(191047);
    try
    {
      paramString = af.awn().wt(paramString);
      mo localmo = new mo();
      localmo.parseFrom(paramString.field_raw_attrs);
      paramString = localmo.CJw;
      AppMethodBeat.o(191047);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(191047);
    }
    return null;
  }
  
  public static List<String> wQ(String paramString)
  {
    AppMethodBeat.i(191051);
    try
    {
      paramString = af.awn().wt(paramString);
      mo localmo = new mo();
      localmo.parseFrom(paramString.field_raw_attrs);
      paramString = localmo.CJy;
      AppMethodBeat.o(191051);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new ArrayList(0);
      AppMethodBeat.o(191051);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.f
 * JD-Core Version:    0.7.0.1
 */