package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/MakeupApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "TAG", "", "convert2Path", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV1;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2;", "convert2PathImpl", "T", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "flatten", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/VFSFile;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "copyImageIfNeed", "resDir", "originFile", "generateResDirName", "kotlin.jvm.PlatformType", "infoObj", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends b
{
  public static final i uTV;
  
  static
  {
    AppMethodBeat.i(317131);
    uTV = new i();
    AppMethodBeat.o(317131);
  }
  
  static u e(u paramu1, u paramu2)
  {
    AppMethodBeat.i(317095);
    paramu1 = new u(paramu1, paramu2.getName());
    Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile: " + paramu2 + ", newFile: " + paramu1);
    d locald = d.sPx;
    if (d.C(paramu1))
    {
      Log.d("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, newFile already exist");
      AppMethodBeat.o(317095);
      return paramu1;
    }
    if (!paramu2.jKS())
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, originFile not exist");
      AppMethodBeat.o(317095);
      return null;
    }
    if (0L > y.O(ah.v(paramu2.jKT()), ah.v(paramu1.jKT()), false))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, copy fail");
      AppMethodBeat.o(317095);
      return null;
    }
    paramu2 = d.sPx;
    if (!d.B(paramu1))
    {
      Log.w("MicroMsg.AppBrand.MakeupApplyAdapterCoreLogic", "copyImageIfNeed, record newFile fail");
      AppMethodBeat.o(317095);
      return null;
    }
    AppMethodBeat.o(317095);
    return paramu1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.i
 * JD-Core Version:    0.7.0.1
 */