package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.findersdk.a.ay;
import com.tencent.mm.plugin.findersdk.a.az;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderManagementUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderTitle", "Landroid/view/View;", "getFinderTitle", "()Landroid/view/View;", "setFinderTitle", "(Landroid/view/View;)V", "fromSettingPrivacy", "", "getFromSettingPrivacy", "()Z", "setFromSettingPrivacy", "(Z)V", "interactiveInfo", "getInteractiveInfo", "setInteractiveInfo", "liveRoleGroup", "getLiveRoleGroup", "setLiveRoleGroup", "notSeeAccount", "getNotSeeAccount", "setNotSeeAccount", "notSeeHim", "getNotSeeHim", "setNotSeeHim", "notSeeMine", "getNotSeeMine", "setNotSeeMine", "personalizeSetting", "getPersonalizeSetting", "setPersonalizeSetting", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderManagementUI
  extends MMFinderUI
{
  private View FRj;
  private View FRk;
  private View FRl;
  private View FRm;
  private View FRn;
  private View FRo;
  private boolean FRp;
  private View FRq;
  
  private static final void a(FinderManagementUI paramFinderManagementUI, View paramView)
  {
    AppMethodBeat.i(346601);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderManagementUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderManagementUI, "this$0");
    if (paramFinderManagementUI.FRp)
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderManagementUI = paramFinderManagementUI.getContext();
      s.s(paramFinderManagementUI, "context");
      com.tencent.mm.plugin.finder.utils.a.az((Context)paramFinderManagementUI, 1);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346601);
      return;
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderManagementUI = paramFinderManagementUI.getContext();
      s.s(paramFinderManagementUI, "context");
      com.tencent.mm.plugin.finder.utils.a.ay((Context)paramFinderManagementUI, 1);
    }
  }
  
  private static final boolean a(FinderManagementUI paramFinderManagementUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346592);
    s.u(paramFinderManagementUI, "this$0");
    paramFinderManagementUI.onBackPressed();
    AppMethodBeat.o(346592);
    return true;
  }
  
  private static final void b(FinderManagementUI paramFinderManagementUI, View paramView)
  {
    AppMethodBeat.i(346610);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderManagementUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderManagementUI, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramFinderManagementUI = paramFinderManagementUI.getContext();
    s.s(paramFinderManagementUI, "context");
    com.tencent.mm.plugin.finder.utils.a.ay((Context)paramFinderManagementUI, 3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346610);
  }
  
  private static final void c(FinderManagementUI paramFinderManagementUI, View paramView)
  {
    AppMethodBeat.i(346618);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderManagementUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderManagementUI, "this$0");
    if (paramFinderManagementUI.FRp)
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderManagementUI = paramFinderManagementUI.getContext();
      s.s(paramFinderManagementUI, "context");
      com.tencent.mm.plugin.finder.utils.a.az((Context)paramFinderManagementUI, 2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346618);
      return;
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderManagementUI = paramFinderManagementUI.getContext();
      s.s(paramFinderManagementUI, "context");
      com.tencent.mm.plugin.finder.utils.a.ay((Context)paramFinderManagementUI, 2);
    }
  }
  
  private static final void d(FinderManagementUI paramFinderManagementUI, View paramView)
  {
    AppMethodBeat.i(346626);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderManagementUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderManagementUI, "this$0");
    paramView = new Intent();
    paramView.setClass((Context)paramFinderManagementUI, FinderSettingPersonalizedUI.class);
    paramFinderManagementUI = paramFinderManagementUI.getContext();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramFinderManagementUI, paramView.aYi(), "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "onCreate$lambda-4", "(Lcom/tencent/mm/plugin/finder/ui/FinderManagementUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramFinderManagementUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramFinderManagementUI, "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "onCreate$lambda-4", "(Lcom/tencent/mm/plugin/finder/ui/FinderManagementUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346626);
  }
  
  private static final void e(FinderManagementUI paramFinderManagementUI, View paramView)
  {
    AppMethodBeat.i(346634);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderManagementUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderManagementUI, "this$0");
    paramView = new Intent();
    paramView.setClass((Context)paramFinderManagementUI, FinderSettingInteractiveInfoUI.class);
    paramFinderManagementUI = paramFinderManagementUI.getContext();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramFinderManagementUI, paramView.aYi(), "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "onCreate$lambda-5", "(Lcom/tencent/mm/plugin/finder/ui/FinderManagementUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramFinderManagementUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramFinderManagementUI, "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "onCreate$lambda-5", "(Lcom/tencent/mm/plugin/finder/ui/FinderManagementUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderManagementUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346634);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_self_management;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346723);
    Set localSet = ar.setOf(new Class[] { l.a(ai.cz(az.class)), l.a(ai.cz(ay.class)) });
    AppMethodBeat.o(346723);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346717);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_jump_new_privacy);
    setBackBtn(new FinderManagementUI..ExternalSyntheticLambda0(this));
    this.FRp = getIntent().getBooleanExtra("intent_status_from_privacy_to_video_setting", false);
    this.FRj = findViewById(e.e.not_see_him_group);
    paramBundle = this.FRj;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new FinderManagementUI..ExternalSyntheticLambda5(this));
    }
    this.FRk = findViewById(e.e.no_see_account_group);
    paramBundle = this.FRk;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new FinderManagementUI..ExternalSyntheticLambda3(this));
    }
    this.FRl = findViewById(e.e.no_see_mine_account_group);
    paramBundle = this.FRl;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new FinderManagementUI..ExternalSyntheticLambda1(this));
    }
    this.FRm = findViewById(e.e.personalized_setting_group);
    paramBundle = this.FRm;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new FinderManagementUI..ExternalSyntheticLambda2(this));
    }
    this.FRn = findViewById(e.e.interactive_info_group);
    paramBundle = this.FRn;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new FinderManagementUI..ExternalSyntheticLambda4(this));
    }
    this.FRo = findViewById(e.e.live_role_group);
    this.FRq = findViewById(e.e.finder_title);
    if (this.FRp)
    {
      paramBundle = this.FRk;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.FRo;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.FRq;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.FRm;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.FRn;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    AppMethodBeat.o(346717);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setFinderTitle(View paramView)
  {
    this.FRq = paramView;
  }
  
  public final void setInteractiveInfo(View paramView)
  {
    this.FRn = paramView;
  }
  
  public final void setLiveRoleGroup(View paramView)
  {
    this.FRo = paramView;
  }
  
  public final void setNotSeeAccount(View paramView)
  {
    this.FRk = paramView;
  }
  
  public final void setNotSeeHim(View paramView)
  {
    this.FRj = paramView;
  }
  
  public final void setNotSeeMine(View paramView)
  {
    this.FRl = paramView;
  }
  
  public final void setPersonalizeSetting(View paramView)
  {
    this.FRm = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderManagementUI
 * JD-Core Version:    0.7.0.1
 */