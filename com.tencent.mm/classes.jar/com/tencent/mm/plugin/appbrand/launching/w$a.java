package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"})
public abstract interface w$a
{
  public static final a kIS = a.kIU;
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "TEST_SWITCH_MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "plugin-appbrand-integration_release"})
  public static final class a
    implements w.a
  {
    private static final ax kIT;
    
    static
    {
      AppMethodBeat.i(180531);
      kIU = new a();
      kIT = ax.fF("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE.TEST_SWITCH_MMKV", 2);
      AppMethodBeat.o(180531);
    }
    
    private static boolean a(b.a parama)
    {
      AppMethodBeat.i(196357);
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE))
      {
        ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", INTERNAL BUILD, defBool:true");
        AppMethodBeat.o(196357);
        return true;
      }
      if (!d.CpN)
      {
        ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", !ALPHA, defBool:false");
        AppMethodBeat.o(196357);
        return false;
      }
      if (aj.cbe()) {
        k.g(g.afz(), "MMKernel.account()");
      }
      String str;
      for (int i = a.getUin();; i = a.aep())
      {
        str = p.getString(i) + '_' + parama.name();
        if (!kIT.containsKey(str)) {
          break;
        }
        bool = kIT.getBoolean(str, false);
        ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", IS_ALPHA, defBool:" + bool);
        AppMethodBeat.o(196357);
        return bool;
      }
      if (i.cf(i, 101) > 50) {}
      for (boolean bool = true;; bool = false)
      {
        kIT.putBoolean(str, bool);
        break;
      }
    }
    
    public static boolean bgy()
    {
      AppMethodBeat.i(180528);
      boolean bool1 = a(b.a.pnh);
      boolean bool2 = ((b)g.ab(b.class)).a(b.a.pnh, bool1);
      ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewCgi exptVal[" + bool2 + "] defVal[" + bool1 + ']');
      AppMethodBeat.o(180528);
      return bool2;
    }
    
    public static boolean gu(boolean paramBoolean)
    {
      AppMethodBeat.i(180530);
      if (paramBoolean)
      {
        bool1 = a(b.a.pnl);
        bool2 = ((b)g.ab(b.class)).a(b.a.pnl, bool1);
        ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
        AppMethodBeat.o(180530);
        return bool2;
      }
      boolean bool1 = a(b.a.pni);
      boolean bool2 = ((b)g.ab(b.class)).a(b.a.pni, bool1);
      ad.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useNewSeparatedPluginCompatibleLogic isGame[" + paramBoolean + "] exptVal[" + bool2 + "] defVal[" + bool1 + ']');
      AppMethodBeat.o(180530);
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w.a
 * JD-Core Version:    0.7.0.1
 */