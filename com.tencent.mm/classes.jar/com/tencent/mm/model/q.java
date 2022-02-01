package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizTeenModeService;", "Lcom/tencent/mm/api/IBizTeenModeService;", "()V", "BIZ_TEEN_MODE_ACCT_OPTION", "", "BIZ_TEEN_MODE_MMKV_KEY_SUFFIX", "BIZ_TEEN_MODE_NO_ACCESS_URL", "IS_TEEN_MODE", "TAG", "bizTeenModeAcctOption", "", "isInit", "", "isTeenMode", "mTeenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "checkInit", "", "init", "isBizTeenModeAllowAll", "isBizTeenModeDenyAll", "release", "reportRemoveBizContact", "bizInfo", "Lcom/tencent/mm/api/BizInfo;", "reportTeenModeToast", "scene", "username", "nickname", "updateTeenModeData", "plugin-biz_release"})
public final class q
  implements com.tencent.mm.api.q
{
  private static MultiProcessMMKV cQe;
  private static boolean iCn;
  private static int iCo;
  private static com.tencent.mm.plugin.teenmode.a.c iCp;
  public static final q iCq;
  private static boolean isInit;
  
  static
  {
    AppMethodBeat.i(212413);
    iCq = new q();
    iCp = (com.tencent.mm.plugin.teenmode.a.c)a.iCr;
    AppMethodBeat.o(212413);
  }
  
  private static void aTL()
  {
    AppMethodBeat.i(212404);
    if (!isInit)
    {
      init();
      isInit = true;
    }
    AppMethodBeat.o(212404);
  }
  
  private static void aTM()
  {
    AppMethodBeat.i(212412);
    Log.v("MicroMsg.BizTeenModeService", "alvinluo updateTeenModeData isTeenMode: %s, bizTeenModeOption: %s", new Object[] { Boolean.valueOf(iCn), Integer.valueOf(iCo) });
    MultiProcessMMKV localMultiProcessMMKV = cQe;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("is_teen_mode", iCn);
    }
    localMultiProcessMMKV = cQe;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putInt("biz_teen_mode_acct_option", iCo);
    }
    localMultiProcessMMKV = cQe;
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.apply();
      AppMethodBeat.o(212412);
      return;
    }
    AppMethodBeat.o(212412);
  }
  
  public static void init()
  {
    AppMethodBeat.i(212403);
    if ((b)g.af(b.class) == null)
    {
      Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService service null and ignore");
      AppMethodBeat.o(212403);
      return;
    }
    ((b)g.af(b.class)).a(iCp);
    Object localObject = g.af(b.class);
    p.g(localObject, "MMKernel.service(ITeenModeService::class.java)");
    iCn = ((b)localObject).Vt();
    localObject = g.af(b.class);
    p.g(localObject, "MMKernel.service(ITeenModeService::class.java)");
    iCo = ((b)localObject).fvo();
    int i = a.azs();
    if (i == 0)
    {
      Log.e("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService invalid account");
      cQe = null;
      AppMethodBeat.o(212403);
      return;
    }
    localObject = i + "_biz_teen_mode_mmkv";
    cQe = MultiProcessMMKV.getMMKV((String)localObject, 2);
    aTM();
    isInit = true;
    Log.i("MicroMsg.BizTeenModeService", "alvinluo initBizTeenModeService key: %s, isTeenMode: %b, bizAcctOption: %d", new Object[] { localObject, Boolean.valueOf(iCn), Integer.valueOf(iCo) });
    AppMethodBeat.o(212403);
  }
  
  public static void release()
  {
    AppMethodBeat.i(212405);
    b localb = (b)g.af(b.class);
    if (localb != null)
    {
      localb.b(iCp);
      AppMethodBeat.o(212405);
      return;
    }
    AppMethodBeat.o(212405);
  }
  
  public final boolean Vt()
  {
    AppMethodBeat.i(212406);
    aTL();
    boolean bool = iCn;
    AppMethodBeat.o(212406);
    return bool;
  }
  
  public final boolean Vu()
  {
    AppMethodBeat.i(212407);
    aTL();
    if ((!iCn) || (iCo == 1))
    {
      AppMethodBeat.o(212407);
      return true;
    }
    AppMethodBeat.o(212407);
    return false;
  }
  
  public final boolean Vv()
  {
    AppMethodBeat.i(212408);
    aTL();
    if ((iCn) && (iCo == 2))
    {
      AppMethodBeat.o(212408);
      return true;
    }
    AppMethodBeat.o(212408);
    return false;
  }
  
  public final void c(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(212409);
    if (paramc == null)
    {
      AppMethodBeat.o(212409);
      return;
    }
    if (iCn)
    {
      paramc = paramc.field_username;
      String str = aa.getDisplayName(paramc);
      Log.d("MicroMsg.BizTeenModeService", "reportRemoveBizContact username: %s, nickname: %s", new Object[] { paramc, str });
      h.CyF.a(20911, new Object[] { Integer.valueOf(1), paramc, str });
    }
    AppMethodBeat.o(212409);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212411);
    if (paramString1 == null)
    {
      AppMethodBeat.o(212411);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(212411);
      return;
    }
    Log.d("MicroMsg.BizTeenModeService", "reportTeenModeToast username: %s, nickname: %s, scene: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    h.CyF.a(20912, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(212411);
  }
  
  public final void o(int paramInt, String paramString)
  {
    AppMethodBeat.i(212410);
    if (paramString == null)
    {
      AppMethodBeat.o(212410);
      return;
    }
    if (iCn) {
      d(paramInt, paramString, aa.getDisplayName(paramString));
    }
    AppMethodBeat.o(212410);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDataChanged"})
  static final class a
    implements com.tencent.mm.plugin.teenmode.a.c
  {
    public static final a iCr;
    
    static
    {
      AppMethodBeat.i(212402);
      iCr = new a();
      AppMethodBeat.o(212402);
    }
    
    public final void onDataChanged()
    {
      AppMethodBeat.i(212401);
      Object localObject = g.af(b.class);
      p.g(localObject, "MMKernel.service(ITeenModeService::class.java)");
      boolean bool2 = ((b)localObject).Vt();
      localObject = g.af(b.class);
      p.g(localObject, "MMKernel.service(ITeenModeService::class.java)");
      int i = ((b)localObject).fvo();
      localObject = q.iCq;
      if (bool2 == q.aTN())
      {
        localObject = q.iCq;
        if (i == q.aTO()) {
          break label149;
        }
      }
      label149:
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.BizTeenModeService", "alvinluo onTeenModeDataChanged isTeenMode: %b, bizAcctOption: %d, isChanged: %b", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          localObject = q.iCq;
          q.fq(bool2);
          localObject = q.iCq;
          q.rM(i);
          localObject = q.iCq;
          q.aTP();
        }
        AppMethodBeat.o(212401);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */