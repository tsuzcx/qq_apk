package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTeenModeService;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "BIZ_TEEN_MODE_ACCT_OPTION", "", "BIZ_TEEN_MODE_MMKV_KEY_SUFFIX", "BIZ_TEEN_MODE_NO_ACCESS_URL", "IS_TEEN_MODE", "TAG", "bizTeenModeAcctOption", "", "isInit", "", "isTeenMode", "mTeenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", "init", "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", "username", "nickname", "updateTeenModeData", "plugin-biz_release"})
public final class q
  implements com.tencent.mm.api.q
{
  private static MultiProcessMMKV cQO;
  private static boolean isInit;
  private static boolean lsi;
  private static int lsj;
  private static com.tencent.mm.plugin.teenmode.a.c lsk;
  public static final q lsl;
  
  static
  {
    AppMethodBeat.i(206714);
    lsl = new q();
    lsk = (com.tencent.mm.plugin.teenmode.a.c)a.lsm;
    AppMethodBeat.o(206714);
  }
  
  private static void bcM()
  {
    AppMethodBeat.i(206700);
    if (!isInit)
    {
      init();
      isInit = true;
    }
    AppMethodBeat.o(206700);
  }
  
  private static void bcN()
  {
    AppMethodBeat.i(206712);
    Log.v("MicroMsg.BizTeenModeService", "alvinluo updateTeenModeData isTeenMode: %s, bizTeenModeOption: %s", new Object[] { Boolean.valueOf(lsi), Integer.valueOf(lsj) });
    MultiProcessMMKV localMultiProcessMMKV = cQO;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("is_teen_mode", lsi);
    }
    localMultiProcessMMKV = cQO;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putInt("biz_teen_mode_acct_option", lsj);
    }
    localMultiProcessMMKV = cQO;
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.apply();
      AppMethodBeat.o(206712);
      return;
    }
    AppMethodBeat.o(206712);
  }
  
  public static void init()
  {
    AppMethodBeat.i(206699);
    if ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class) == null)
    {
      Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService service null and ignore");
      AppMethodBeat.o(206699);
      return;
    }
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).a(lsk);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    lsi = ((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM();
    localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    lsj = ((com.tencent.mm.plugin.teenmode.a.b)localObject).gkr();
    int i = com.tencent.mm.kernel.b.aGP();
    if (i == 0)
    {
      Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService invalid account");
      cQO = null;
      AppMethodBeat.o(206699);
      return;
    }
    localObject = i + "_biz_teen_mode_mmkv";
    cQO = MultiProcessMMKV.getMMKV((String)localObject, 2);
    bcN();
    isInit = true;
    Log.i("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService key: %s, isTeenMode: %b, bizAcctOption: %d", new Object[] { localObject, Boolean.valueOf(lsi), Integer.valueOf(lsj) });
    AppMethodBeat.o(206699);
  }
  
  public static void release()
  {
    AppMethodBeat.i(206701);
    com.tencent.mm.plugin.teenmode.a.b localb = (com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    if (localb != null)
    {
      localb.b(lsk);
      AppMethodBeat.o(206701);
      return;
    }
    AppMethodBeat.o(206701);
  }
  
  public final boolean ZM()
  {
    AppMethodBeat.i(206703);
    bcM();
    boolean bool = lsi;
    AppMethodBeat.o(206703);
    return bool;
  }
  
  public final boolean ZN()
  {
    AppMethodBeat.i(206704);
    bcM();
    if ((!lsi) || (lsj == 1))
    {
      AppMethodBeat.o(206704);
      return true;
    }
    AppMethodBeat.o(206704);
    return false;
  }
  
  public final boolean ZO()
  {
    AppMethodBeat.i(206705);
    bcM();
    if ((lsi) && (lsj == 2))
    {
      AppMethodBeat.o(206705);
      return true;
    }
    AppMethodBeat.o(206705);
    return false;
  }
  
  public final void c(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(206707);
    if (paramc == null)
    {
      AppMethodBeat.o(206707);
      return;
    }
    if (lsi)
    {
      paramc = paramc.field_username;
      String str = aa.PJ(paramc);
      Log.d("MicroMsg.BizTeenModeService", "reportRemoveBizContact username: %s, nickname: %s", new Object[] { paramc, str });
      com.tencent.mm.plugin.report.service.h.IzE.a(20911, new Object[] { Integer.valueOf(1), paramc, str });
    }
    AppMethodBeat.o(206707);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206709);
    if (paramString1 == null)
    {
      AppMethodBeat.o(206709);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(206709);
      return;
    }
    Log.d("MicroMsg.BizTeenModeService", "reportTeenModeToast username: %s, nickname: %s, scene: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.IzE.a(20912, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(206709);
  }
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(206708);
    if (paramString == null)
    {
      AppMethodBeat.o(206708);
      return;
    }
    if (lsi) {
      d(paramInt, paramString, aa.PJ(paramString));
    }
    AppMethodBeat.o(206708);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDataChanged"})
  static final class a
    implements com.tencent.mm.plugin.teenmode.a.c
  {
    public static final a lsm;
    
    static
    {
      AppMethodBeat.i(205230);
      lsm = new a();
      AppMethodBeat.o(205230);
    }
    
    public final void onDataChanged()
    {
      AppMethodBeat.i(205228);
      Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
      boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM();
      localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
      int i = ((com.tencent.mm.plugin.teenmode.a.b)localObject).gkr();
      localObject = q.lsl;
      if (bool2 == q.bcO())
      {
        localObject = q.lsl;
        if (i == q.bcP()) {
          break label149;
        }
      }
      label149:
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.BizTeenModeService", "alvinluo onTeenModeDataChanged isTeenMode: %b, bizAcctOption: %d, isChanged: %b", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          localObject = q.lsl;
          q.ga(bool2);
          localObject = q.lsl;
          q.uG(i);
          localObject = q.lsl;
          q.bcQ();
        }
        AppMethodBeat.o(205228);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */