package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends e
{
  public static final d.a ulj;
  private aq scope;
  
  static
  {
    AppMethodBeat.i(180709);
    ulj = new d.a((byte)0);
    AppMethodBeat.o(180709);
  }
  
  public d(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(323098);
    this.scope = ar.kBZ();
    paramFragmentActivity.getLifecycle().addObserver((androidx.lifecycle.p)new AppBrandLauncherHeaderOrderEntrance.1(this));
    AppMethodBeat.o(323098);
  }
  
  private final void cMA()
  {
    AppMethodBeat.i(180707);
    com.tencent.e.f.h.jXD();
    aq localaq = this.scope;
    if (localaq != null) {
      kotlinx.coroutines.j.a(localaq, null, null, (m)new d.b(this, null), 3);
    }
    AppMethodBeat.o(180707);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180708);
    kotlin.g.b.s.u(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(ba.h.icons_outline_miniprogram_order);
    paramWeImageView.setIconColor(getActivity().getResources().getColor(ba.c.Brand));
    AppMethodBeat.o(180708);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180703);
    String str = getActivity().getString(ba.i.app_brand_recents_list_header_order_tag_wording);
    kotlin.g.b.s.s(str, "activity.getString(R.str…header_order_tag_wording)");
    AppMethodBeat.o(180703);
    return str;
  }
  
  public final void iR()
  {
    AppMethodBeat.i(180705);
    super.iR();
    com.tencent.e.f.h.jXD();
    cMA();
    AppMethodBeat.o(180705);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180704);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.g();
    paramView.username = "gh_af04e9bb7e91@app";
    paramView.euz = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.hzx = "";
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a((Context)getActivity(), paramView);
    paramView = new com.tencent.mm.plugin.appbrand.s.g(true);
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)paramView, 0);
    com.tencent.mm.plugin.report.service.h.OAn.b(18685, new Object[] { Integer.valueOf(2) });
    paramView = f.tNH;
    FragmentActivity localFragmentActivity = getActivity();
    kotlin.g.b.s.s(localFragmentActivity, "activity");
    paramView = paramView.a(localFragmentActivity);
    com.tencent.mm.plugin.report.service.h.OAn.b(19468, new Object[] { Integer.valueOf(4), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(180704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(180706);
    super.onResume();
    cMA();
    AppMethodBeat.o(180706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d
 * JD-Core Version:    0.7.0.1
 */