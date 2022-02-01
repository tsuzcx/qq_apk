package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final a mJq;
  
  static
  {
    AppMethodBeat.i(180709);
    mJq = new a((byte)0);
    AppMethodBeat.o(180709);
  }
  
  public e(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
  }
  
  private final void bAy()
  {
    AppMethodBeat.i(180707);
    h.fUh();
    c localc = new c((c.a)new b(this, new WeakReference(this)));
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b((n)localc);
    AppMethodBeat.o(180707);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180708);
    p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690508);
    FragmentActivity localFragmentActivity = getActivity();
    p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099699));
    AppMethodBeat.o(180708);
  }
  
  public final void bAu()
  {
    AppMethodBeat.i(180705);
    super.bAu();
    h.fUh();
    bAy();
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
    paramView = new com.tencent.mm.plugin.appbrand.api.f();
    paramView.username = "gh_af04e9bb7e91@app";
    paramView.hQh = 0;
    paramView.version = 0;
    paramView.scene = 1151;
    paramView.dkh = "";
    ((o)com.tencent.mm.kernel.g.ab(o.class)).a((Context)getActivity(), paramView);
    paramView = new com.tencent.mm.plugin.appbrand.n.f(true);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b((n)paramView);
    com.tencent.mm.plugin.report.service.g.yhR.f(18685, new Object[] { Integer.valueOf(2) });
    paramView = com.tencent.mm.plugin.appbrand.report.e.mqZ;
    paramView = getActivity();
    p.g(paramView, "activity");
    paramView = com.tencent.mm.plugin.appbrand.report.e.b(paramView);
    com.tencent.mm.plugin.report.service.g.yhR.f(19468, new Object[] { Integer.valueOf(4), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(180704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(180706);
    super.onResume();
    bAy();
    AppMethodBeat.o(180706);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$updateMoreOptionEntryRedDotStatus$netSceneGetWxaOrderInfo$1", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo$IOnNetSceneGetWxaOrderInfoCallback;", "Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneGetWxaOrderInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "scene", "plugin-appbrand-integration_release"})
  public static final class b
    extends c.a<c, e>
  {
    b(WeakReference paramWeakReference)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(180701);
        Object localObject = (e)this.mJs.lVh.get();
        if (localObject != null)
        {
          a locala = this.mJt.lVf.aEF();
          if (locala == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetWxaOrderInfoResp");
            AppMethodBeat.o(180701);
            throw ((Throwable)localObject);
          }
          ((e)localObject).hM(((bma)locala).GGy);
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