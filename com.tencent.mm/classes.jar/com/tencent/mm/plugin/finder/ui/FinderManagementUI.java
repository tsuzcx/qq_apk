package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.viewmodel.k;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderManagementUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderTitle", "Landroid/view/View;", "getFinderTitle", "()Landroid/view/View;", "setFinderTitle", "(Landroid/view/View;)V", "fromSettingPrivacy", "", "getFromSettingPrivacy", "()Z", "setFromSettingPrivacy", "(Z)V", "liveRoleGroup", "getLiveRoleGroup", "setLiveRoleGroup", "notSeeAccount", "getNotSeeAccount", "setNotSeeAccount", "notSeeHim", "getNotSeeHim", "setNotSeeHim", "notSeeMine", "getNotSeeMine", "setNotSeeMine", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderManagementUI
  extends MMFinderUI
{
  private View ArJ;
  private View ArK;
  private View ArL;
  private View ArM;
  boolean ArN;
  private View ArO;
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290342);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290342);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290341);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(290341);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_self_management;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(290338);
    Set localSet = ak.setOf(k.class);
    AppMethodBeat.o(290338);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(290337);
    super.onCreate(paramBundle);
    setMMTitle(b.j.finder_jump_new_privacy);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.ArN = getIntent().getBooleanExtra("intent_status_from_privacy_to_video_setting", false);
    this.ArJ = findViewById(b.f.not_see_him_group);
    paramBundle = this.ArJ;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    }
    this.ArK = findViewById(b.f.no_see_account_group);
    paramBundle = this.ArK;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    this.ArL = findViewById(b.f.no_see_mine_account_group);
    paramBundle = this.ArL;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    this.ArM = findViewById(b.f.live_role_group);
    this.ArO = findViewById(b.f.finder_title);
    if (this.ArN)
    {
      paramBundle = this.ArK;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.ArM;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.ArO;
      if (paramBundle != null)
      {
        paramBundle.setVisibility(8);
        AppMethodBeat.o(290337);
        return;
      }
    }
    AppMethodBeat.o(290337);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setFinderTitle(View paramView)
  {
    this.ArO = paramView;
  }
  
  public final void setLiveRoleGroup(View paramView)
  {
    this.ArM = paramView;
  }
  
  public final void setNotSeeAccount(View paramView)
  {
    this.ArK = paramView;
  }
  
  public final void setNotSeeHim(View paramView)
  {
    this.ArJ = paramView;
  }
  
  public final void setNotSeeMine(View paramView)
  {
    this.ArL = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderManagementUI paramFinderManagementUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(269106);
      this.ArP.onBackPressed();
      AppMethodBeat.o(269106);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderManagementUI paramFinderManagementUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291801);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.ArP.ArN)
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.ArP.getContext();
        p.j(paramView, "context");
        com.tencent.mm.plugin.finder.utils.a.ap((Context)paramView, 1);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderManagementUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291801);
        return;
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.ArP.getContext();
        p.j(paramView, "context");
        com.tencent.mm.plugin.finder.utils.a.an((Context)paramView, 1);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderManagementUI paramFinderManagementUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285505);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramView = this.ArP.getContext();
      p.j(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.an((Context)paramView, 3);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderManagementUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285505);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderManagementUI paramFinderManagementUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278392);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderManagementUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.ArP.ArN)
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.ArP.getContext();
        p.j(paramView, "context");
        com.tencent.mm.plugin.finder.utils.a.ap((Context)paramView, 2);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderManagementUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(278392);
        return;
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.ArP.getContext();
        p.j(paramView, "context");
        com.tencent.mm.plugin.finder.utils.a.an((Context)paramView, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderManagementUI
 * JD-Core Version:    0.7.0.1
 */