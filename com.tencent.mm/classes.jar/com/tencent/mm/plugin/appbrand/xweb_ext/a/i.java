package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "TAG", "", "convert2Path", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "convert2PathImpl", "T", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "flatten", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/VFSFile;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "copyImageIfNeed", "resDir", "originFile", "generateResDirName", "kotlin.jvm.PlatformType", "infoObj", "plugin-appbrand-integration_release"})
public final class i
  extends b
{
  public static final i rIE;
  
  static
  {
    AppMethodBeat.i(268647);
    rIE = new i();
    AppMethodBeat.o(268647);
  }
  
  static q c(q paramq1, q paramq2)
  {
    AppMethodBeat.i(268646);
    paramq1 = new q(paramq1, paramq2.getName());
    Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile: " + paramq2 + ", newFile: " + paramq1);
    d locald = d.pKE;
    if (d.C(paramq1))
    {
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, newFile already exist");
      AppMethodBeat.o(268646);
      return paramq1;
    }
    if (!paramq2.ifE())
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile not exist");
      AppMethodBeat.o(268646);
      return null;
    }
    if (0L > u.on(paramq2.bOF(), paramq1.bOF()))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, copy fail");
      AppMethodBeat.o(268646);
      return null;
    }
    paramq2 = d.pKE;
    if (!d.B(paramq1))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, record newFile fail");
      AppMethodBeat.o(268646);
      return null;
    }
    AppMethodBeat.o(268646);
    return paramq1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.i
 * JD-Core Version:    0.7.0.1
 */