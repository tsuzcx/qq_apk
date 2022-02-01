package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionBarNicknameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getActionBarNicknameTv", "()Landroid/widget/TextView;", "actionBarNicknameTv$delegate", "Lkotlin/Lazy;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout$delegate", "appBarLayoutOffset", "", "backBtnIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBackBtnIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "backBtnIv$delegate", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getCoordinatorLayout", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout$delegate", "coverAlphaView", "Landroid/view/View;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1;", "isAvatarLoaded", "", "lastActionBarProgress", "", "moreBtn", "Landroid/widget/LinearLayout;", "getMoreBtn", "()Landroid/widget/LinearLayout;", "moreBtn$delegate", "myActionBar", "getMyActionBar", "myActionBar$delegate", "normalActionBarColor", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "userInfoLayout", "getUserInfoLayout", "userInfoLayout$delegate", "username", "", "changeViewAlpha", "", "progress", "alpha", "fixActionBarStatus", "hideActionBar", "initCustomActionBar", "loadAvatar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setCoveredStyle", "setNormalStyle", "setVisibleStats", "view", "visibleStat", "OnOffsetChangedListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends UIComponent
{
  private final j AvT;
  private final j AvU;
  private final j AvV;
  private final j AvW;
  private final j AvX;
  private final j AvY;
  private final j AvZ;
  private View Awa;
  private int Awb;
  private boolean Awc;
  private final FinderActivitySlideUIC.finderTopicInfoListener.1 Awd;
  private float Awe;
  private int Awf;
  private bxv hLt;
  private String username;
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348123);
    this.AvT = k.cm((a)new c(paramAppCompatActivity));
    this.AvU = k.cm((a)new e(paramAppCompatActivity));
    this.AvV = k.cm((a)new b(paramAppCompatActivity));
    this.AvW = k.cm((a)new h(paramAppCompatActivity));
    this.AvX = k.cm((a)new d(paramAppCompatActivity));
    this.AvY = k.cm((a)new f(paramAppCompatActivity));
    this.AvZ = k.cm((a)new g(paramAppCompatActivity));
    this.Awb = paramAppCompatActivity.getResources().getColor(e.b.finder_activity_covered_background);
    this.username = "";
    this.Awd = new FinderActivitySlideUIC.finderTopicInfoListener.1(this, f.hfK);
    AppMethodBeat.o(348123);
  }
  
  private static void ar(View paramView, int paramInt)
  {
    AppMethodBeat.i(348155);
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(348155);
  }
  
  private final AppBarLayout dTJ()
  {
    AppMethodBeat.i(348130);
    AppBarLayout localAppBarLayout = (AppBarLayout)this.AvT.getValue();
    AppMethodBeat.o(348130);
    return localAppBarLayout;
  }
  
  private final TextView dTK()
  {
    AppMethodBeat.i(348137);
    TextView localTextView = (TextView)this.AvV.getValue();
    AppMethodBeat.o(348137);
    return localTextView;
  }
  
  private final LinearLayout dTL()
  {
    AppMethodBeat.i(348143);
    LinearLayout localLinearLayout = (LinearLayout)this.AvW.getValue();
    AppMethodBeat.o(348143);
    return localLinearLayout;
  }
  
  private final LinearLayout dTM()
  {
    AppMethodBeat.i(348150);
    LinearLayout localLinearLayout = (LinearLayout)this.AvZ.getValue();
    AppMethodBeat.o(348150);
    return localLinearLayout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348276);
    super.onCreate(paramBundle);
    this.Awd.alive();
    Object localObject1 = getActivity().getIntent().getStringExtra("key_creator_finder_name");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.username = paramBundle;
    paramBundle = getActivity().getWindow().getDecorView();
    s.s(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    c.h((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = bf.getStatusBarHeight((Context)getActivity());
    paramBundle = dTM().getLayoutParams();
    paramBundle.height += i;
    dTM().setLayoutParams(paramBundle);
    dTM().setPadding(0, i, 0, 0);
    dTL().setAlpha(0.0F);
    this.Awa = getActivity().findViewById(e.e.activity_profile_cover_alpha);
    paramBundle = dTJ();
    localObject1 = new a();
    Object localObject2 = dTJ();
    s.s(localObject2, "appBarLayout");
    ((a)localObject1).onOffsetChanged((AppBarLayout)localObject2, 0);
    localObject2 = ah.aiuX;
    paramBundle.a((AppBarLayout.b)localObject1);
    AppMethodBeat.o(348276);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348283);
    super.onDestroy();
    this.Awd.dead();
    AppMethodBeat.o(348283);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$OnOffsetChangedListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC;)V", "onOffsetChanged", "", "view", "Lcom/google/android/material/appbar/AppBarLayout;", "offset", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements AppBarLayout.b
  {
    public a()
    {
      AppMethodBeat.i(348102);
      AppMethodBeat.o(348102);
    }
    
    public final void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(348109);
      s.u(paramAppBarLayout, "view");
      g.a(this.Awg, paramInt);
      float f2 = 1.0F * Math.abs(paramInt) / paramAppBarLayout.getTotalScrollRange();
      if (f2 == g.a(this.Awg)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(348109);
        return;
      }
      g.a(this.Awg, f2);
      float f1;
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        g.b(this.Awg).setBackgroundColor(this.Awg.getResources().getColor(e.b.transparent));
        g.c(this.Awg).setAlpha(0.0F);
        g.a(this.Awg, f2, f1);
      }
      for (;;)
      {
        paramAppBarLayout = g.e(this.Awg);
        if (paramAppBarLayout != null) {
          paramAppBarLayout.setAlpha(f2);
        }
        Log.i("SimpleUIComponent", s.X("alpha : ", Float.valueOf(f1)));
        AppMethodBeat.o(348109);
        return;
        f1 = (f2 - 0.5F) / 0.5F;
        paramInt = (int)(255.0F * f1);
        g.b(this.Awg).setBackgroundColor(bb.gy(g.d(this.Awg), paramInt));
        g.c(this.Awg).setAlpha(f1);
        g.a(this.Awg, f2, f1);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<TextView>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<AppBarLayout>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<WeImageView>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<CoordinatorLayout>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<LinearLayout>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<LinearLayout>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<LinearLayout>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.g
 * JD-Core Version:    0.7.0.1
 */