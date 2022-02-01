package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "TAG", "", "convert2Path", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "convert2PathImpl", "T", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "flatten", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/VFSFile;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "copyImageIfNeed", "resDir", "originFile", "generateResDirName", "kotlin.jvm.PlatformType", "infoObj", "plugin-appbrand-integration_release"})
public final class i
  extends b
{
  public static final i oGO;
  
  static
  {
    AppMethodBeat.i(229733);
    oGO = new i();
    AppMethodBeat.o(229733);
  }
  
  static o c(o paramo1, o paramo2)
  {
    AppMethodBeat.i(229732);
    paramo1 = new o(paramo1, paramo2.getName());
    Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile: " + paramo2 + ", newFile: " + paramo1);
    d locald = d.mJM;
    if (d.D(paramo1))
    {
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, newFile already exist");
      AppMethodBeat.o(229732);
      return paramo1;
    }
    if (!paramo2.exists())
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile not exist");
      AppMethodBeat.o(229732);
      return null;
    }
    if (0L > s.nw(paramo2.getAbsolutePath(), paramo1.getAbsolutePath()))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, copy fail");
      AppMethodBeat.o(229732);
      return null;
    }
    paramo2 = d.mJM;
    if (!d.C(paramo1))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, record newFile fail");
      AppMethodBeat.o(229732);
      return null;
    }
    AppMethodBeat.o(229732);
    return paramo1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.i
 * JD-Core Version:    0.7.0.1
 */