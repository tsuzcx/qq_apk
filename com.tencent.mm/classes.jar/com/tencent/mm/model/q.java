package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTeenModeService;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "BIZ_TEEN_MODE_ACCT_OPTION", "", "BIZ_TEEN_MODE_MMKV_KEY_SUFFIX", "BIZ_TEEN_MODE_NO_ACCESS_URL", "IS_TEEN_MODE", "TAG", "bizTeenModeAcctOption", "", "isInit", "", "isTeenMode", "mTeenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", "init", "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", "username", "nickname", "updateTeenModeData", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements r
{
  private static MultiProcessMMKV eMf;
  private static boolean epi;
  private static boolean isInit;
  public static final q ojI;
  private static int ojJ;
  private static g ojK;
  
  static
  {
    AppMethodBeat.i(241885);
    ojI = new q();
    ojK = q..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(241885);
  }
  
  private static void bAB()
  {
    AppMethodBeat.i(241878);
    Log.v("MicroMsg.BizTeenModeService", "alvinluo updateTeenModeData isTeenMode: %s, bizTeenModeOption: %s", new Object[] { Boolean.valueOf(epi), Integer.valueOf(ojJ) });
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("is_teen_mode", epi);
    }
    localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putInt("biz_teen_mode_acct_option", ojJ);
    }
    localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.apply();
    }
    AppMethodBeat.o(241878);
  }
  
  private static final void bAC()
  {
    AppMethodBeat.i(241882);
    boolean bool2 = ((d)com.tencent.mm.kernel.h.ax(d.class)).aBu();
    int i = ((d)com.tencent.mm.kernel.h.ax(d.class)).hEq();
    if ((bool2 != epi) || (i != ojJ)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.BizTeenModeService", "alvinluo onTeenModeDataChanged isTeenMode: %b, bizAcctOption: %d, isChanged: %b", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
      if (bool1)
      {
        epi = bool2;
        ojJ = i;
        bAB();
        com.tencent.mm.plugin.brandservice.api.c localc = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
        if (localc != null) {
          localc.dby();
        }
      }
      AppMethodBeat.o(241882);
      return;
    }
  }
  
  private static void checkInit()
  {
    AppMethodBeat.i(241869);
    if (!isInit)
    {
      init();
      isInit = true;
    }
    AppMethodBeat.o(241869);
  }
  
  public static void init()
  {
    AppMethodBeat.i(241866);
    if ((d)com.tencent.mm.kernel.h.ax(d.class) == null)
    {
      Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService service null and ignore");
      AppMethodBeat.o(241866);
      return;
    }
    ((d)com.tencent.mm.kernel.h.ax(d.class)).a(ojK);
    epi = ((d)com.tencent.mm.kernel.h.ax(d.class)).aBu();
    ojJ = ((d)com.tencent.mm.kernel.h.ax(d.class)).hEq();
    int i = b.aZP();
    if (i == 0)
    {
      Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService invalid account");
      eMf = null;
      AppMethodBeat.o(241866);
      return;
    }
    String str = i + "_biz_teen_mode_mmkv";
    eMf = MultiProcessMMKV.getMMKV(str, 2);
    bAB();
    isInit = true;
    Log.i("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService key: %s, isTeenMode: %b, bizAcctOption: %d", new Object[] { str, Boolean.valueOf(epi), Integer.valueOf(ojJ) });
    AppMethodBeat.o(241866);
  }
  
  public static void release()
  {
    AppMethodBeat.i(241872);
    d locald = (d)com.tencent.mm.kernel.h.ax(d.class);
    if (locald != null) {
      locald.b(ojK);
    }
    AppMethodBeat.o(241872);
  }
  
  public final boolean aBu()
  {
    AppMethodBeat.i(241889);
    checkInit();
    boolean bool = epi;
    AppMethodBeat.o(241889);
    return bool;
  }
  
  public final boolean aBv()
  {
    AppMethodBeat.i(241891);
    checkInit();
    if ((!epi) || (ojJ == 1))
    {
      AppMethodBeat.o(241891);
      return true;
    }
    AppMethodBeat.o(241891);
    return false;
  }
  
  public final boolean aBw()
  {
    AppMethodBeat.i(241893);
    checkInit();
    if ((epi) && (ojJ == 2))
    {
      AppMethodBeat.o(241893);
      return true;
    }
    AppMethodBeat.o(241893);
    return false;
  }
  
  public final void c(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(241897);
    if (paramc == null)
    {
      AppMethodBeat.o(241897);
      return;
    }
    if (epi)
    {
      paramc = paramc.field_username;
      String str = aa.getDisplayName(paramc);
      Log.d("MicroMsg.BizTeenModeService", "reportRemoveBizContact username: %s, nickname: %s", new Object[] { paramc, str });
      com.tencent.mm.plugin.report.service.h.OAn.b(20911, new Object[] { Integer.valueOf(1), paramc, str });
    }
    AppMethodBeat.o(241897);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(241908);
    if (paramString1 == null)
    {
      AppMethodBeat.o(241908);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(241908);
      return;
    }
    Log.d("MicroMsg.BizTeenModeService", "reportTeenModeToast username: %s, nickname: %s, scene: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.OAn.b(20912, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(241908);
  }
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(241902);
    if (paramString == null)
    {
      AppMethodBeat.o(241902);
      return;
    }
    if (epi) {
      e(paramInt, paramString, aa.getDisplayName(paramString));
    }
    AppMethodBeat.o(241902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */