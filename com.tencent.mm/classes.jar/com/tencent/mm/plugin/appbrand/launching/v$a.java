package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "", "useEncryptPkg", "", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "Factory", "plugin-appbrand-integration_release"})
public abstract interface v$a
{
  public static final a mTH = a.mTJ;
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "TEST_SWITCH_MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "resetTestSwitch", "", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "useEncryptPkg", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "plugin-appbrand-integration_release"})
  public static final class a
    implements v.a
  {
    private static final MultiProcessMMKV mTI;
    
    static
    {
      AppMethodBeat.i(180531);
      mTJ = new a();
      mTI = MultiProcessMMKV.getMMKV("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE.TEST_SWITCH_MMKV", 2);
      AppMethodBeat.o(180531);
    }
    
    private static boolean a(b.a parama)
    {
      AppMethodBeat.i(228651);
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
      {
        Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "resetTestSwitch key:" + parama.name() + ", INTERNAL BUILD, defBool:true");
        AppMethodBeat.o(228651);
        return true;
      }
      AppMethodBeat.o(228651);
      return false;
    }
    
    public static boolean hW(boolean paramBoolean)
    {
      AppMethodBeat.i(180529);
      boolean bool2;
      if (paramBoolean) {
        bool2 = a(b.a.rUM);
      }
      for (boolean bool1 = ((b)g.af(b.class)).a(b.a.rUM, bool2);; bool1 = ((b)g.af(b.class)).a(b.a.rUL, bool2))
      {
        Log.i("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter.WECHAT_INSTANCE", "useEncryptPkg isGame[" + paramBoolean + "] exptVal[" + bool1 + "] defVal[" + bool2 + ']');
        AppMethodBeat.o(180529);
        return bool1;
        bool2 = a(b.a.rUL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.v.a
 * JD-Core Version:    0.7.0.1
 */