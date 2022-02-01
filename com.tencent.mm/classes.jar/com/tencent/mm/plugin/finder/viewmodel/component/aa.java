package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.live.report.d;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isFromTeenModeSettingPage", "", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "getLayoutId", "", "initDataFromIntent", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends UIComponent
{
  private static final String EXP;
  public static final a GQm;
  private final FinderFollowListContract.FollowListPresent EXI;
  private boolean EXJ;
  
  static
  {
    AppMethodBeat.i(338807);
    GQm = new a((byte)0);
    EXP = "followList.fp";
    AppMethodBeat.o(338807);
  }
  
  public aa(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338792);
    this.EXI = new FinderFollowListContract.FollowListPresent();
    AppMethodBeat.o(338792);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_follow_list_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338827);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = Boolean.valueOf(paramBundle.getBooleanExtra("from_teen_mode_setting_page", false)))
    {
      this.EXJ = paramBundle.booleanValue();
      Log.i("Finder.FinderFollowListUIC", s.X("initDataFromIntent, isFromTeenModeSettingPage:", Boolean.valueOf(this.EXJ)));
      paramBundle = new FinderFollowListContract.FollowListViewCallback((MMActivity)getActivity(), getRootView(), this.EXI, this.EXJ);
      this.EXI.a(paramBundle);
      paramBundle.initView();
      AppMethodBeat.o(338827);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338834);
    super.onDestroy();
    this.EXI.onDetach();
    AppMethodBeat.o(338834);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338850);
    super.onPause();
    ((ce)h.ax(ce.class)).b(null, q.w.DwO, "12", d.Dng);
    AppMethodBeat.o(338850);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338842);
    super.onResume();
    ((ce)h.ax(ce.class)).b(null, q.w.DwO, "12", d.Dnf);
    AppMethodBeat.o(338842);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.aa
 * JD-Core Version:    0.7.0.1
 */