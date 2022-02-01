package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.o.c;
import com.tencent.mm.plugin.appbrand.o.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final a miP;
  
  static
  {
    AppMethodBeat.i(180709);
    miP = new a((byte)0);
    AppMethodBeat.o(180709);
  }
  
  public e(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
  }
  
  private final void bws()
  {
    AppMethodBeat.i(180707);
    com.tencent.d.f.h.fCP();
    c localc = new c((c.a)new b(this, new WeakReference(this)));
    com.tencent.mm.kernel.b localb = g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().b((com.tencent.mm.ak.n)localc);
    AppMethodBeat.o(180707);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180708);
    k.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690508);
    FragmentActivity localFragmentActivity = getActivity();
    k.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099699));
    AppMethodBeat.o(180708);
  }
  
  public final void bwo()
  {
    AppMethodBeat.i(180705);
    super.bwo();
    com.tencent.d.f.h.fCP();
    bws();
    AppMethodBeat.o(180705);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180703);
    String str = getActivity().getString(2131755617);
    AppMethodBeat.o(180703);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180704);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.a.f();
    paramView.username = "gh_af04e9bb7e91@app";
    paramView.hxM = 0;
    paramView.version = 0;
    paramView.scene = 1151;
    paramView.cYP = "";
    ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a((Context)getActivity(), paramView);
    paramView = new com.tencent.mm.plugin.appbrand.o.f(true);
    com.tencent.mm.kernel.b localb = g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().b((com.tencent.mm.ak.n)paramView);
    com.tencent.mm.plugin.report.service.h.wUl.f(18685, new Object[] { Integer.valueOf(2) });
    paramView = d.lRj;
    paramView = getActivity();
    k.g(paramView, "activity");
    paramView = d.b(paramView);
    com.tencent.mm.plugin.report.service.h.wUl.f(19468, new Object[] { Integer.valueOf(4), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(180704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(180706);
    super.onResume();
    bws();
    AppMethodBeat.o(180706);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$updateMoreOptionEntryRedDotStatus$netSceneGetWxaOrderInfo$1", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "plugin-appbrand-integration_release"})
  public static final class b
    extends c.a<c, e>
  {
    b(WeakReference paramWeakReference)
    {
      super();
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(180701);
        Object localObject = (e)this.miR.lvU.get();
        if (localObject != null)
        {
          a locala = this.miS.lvS.aBD();
          if (locala == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetWxaOrderInfoResp");
            AppMethodBeat.o(180701);
            throw ((Throwable)localObject);
          }
          ((e)localObject).hC(((bhs)locala).EXb);
          AppMethodBeat.o(180701);
          return;
        }
        AppMethodBeat.o(180701);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */