package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.c.a;
import com.tencent.mm.protocal.protobuf.bea;
import d.l;
import d.v;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$updateMoreOptionEntryRedDotStatus$netSceneGetWxaOrderInfo$1", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "plugin-appbrand-integration_release"})
public final class e$b
  extends c.a<c, e>
{
  e$b(WeakReference paramWeakReference)
  {
    super(localWeakReference);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(e.b paramb, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(180701);
      Object localObject = (e)this.lGW.kUk.get();
      if (localObject != null)
      {
        a locala = this.lGX.kUi.auM();
        if (locala == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetWxaOrderInfoResp");
          AppMethodBeat.o(180701);
          throw ((Throwable)localObject);
        }
        ((e)localObject).hf(((bea)locala).DBF);
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