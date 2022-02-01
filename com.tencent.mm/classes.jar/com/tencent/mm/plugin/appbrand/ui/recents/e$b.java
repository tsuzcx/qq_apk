package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.protocal.protobuf.bzj;
import java.lang.ref.WeakReference;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$updateMoreOptionEntryRedDotStatus$netSceneGetWxaOrderInfo$1", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "plugin-appbrand-integration_release"})
public final class e$b
  extends c.a<c, e>
{
  e$b(WeakReference paramWeakReference)
  {
    super(localWeakReference);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(e.b paramb, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(180701);
      Object localObject = (e)this.obw.nhy.get();
      if (localObject != null)
      {
        a locala = this.obx.nhw.aYK();
        if (locala == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetWxaOrderInfoResp");
          AppMethodBeat.o(180701);
          throw ((Throwable)localObject);
        }
        ((e)localObject).iR(((bzj)locala).Mfa);
        AppMethodBeat.o(180701);
        return;
      }
      AppMethodBeat.o(180701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.b
 * JD-Core Version:    0.7.0.1
 */