package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC.b;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC.c;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC.d;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC.e;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityDescUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "descContainer", "Landroid/view/View;", "fixActionBar", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFullScreen", "plugin-finder_release"})
public final class FinderActivityDescUI
  extends MMFinderUI
  implements i
{
  private HashMap _$_findViewCache;
  private View uhh;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252105);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252105);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252104);
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
    AppMethodBeat.o(252104);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494192;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252103);
    Set localSet = ak.setOf(FinderActivityDescUIC.class);
    AppMethodBeat.o(252103);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252102);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131296454);
    p.g(paramBundle, "findViewById(R.id.activity_desc_container)");
    this.uhh = paramBundle;
    int i = getResources().getColor(2131101287);
    getController().setStatusBarColor(i);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    i = au.getStatusBarHeight((Context)this);
    paramBundle = this.uhh;
    if (paramBundle == null) {
      p.btv("descContainer");
    }
    int j = paramBundle.getPaddingTop();
    paramBundle = this.uhh;
    if (paramBundle == null) {
      p.btv("descContainer");
    }
    paramBundle.setPadding(0, i + j, 0, 0);
    i = getResources().getColor(2131101287);
    getController().setStatusBarColor(i);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    FinderActivityDescUIC localFinderActivityDescUIC = (FinderActivityDescUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderActivityDescUIC.class);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131296475);
    p.g(paramBundle, "activity.findViewById(R.…vity_profile_header_name)");
    localFinderActivityDescUIC.tqS = ((TextView)paramBundle);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131300748);
    p.g(paramBundle, "activity.findViewById(R.id.finder_activity_name)");
    localFinderActivityDescUIC.tqT = ((TextView)paramBundle);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131300737);
    p.g(paramBundle, "activity.findViewById(R.id.finder_activity_desc)");
    localFinderActivityDescUIC.tqU = ((TextView)paramBundle);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131300754);
    p.g(paramBundle, "activity.findViewById(R.…activity_post_cancel_btn)");
    localFinderActivityDescUIC.hPV = ((WeImageView)paramBundle);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131296455);
    p.g(paramBundle, "activity.findViewById(R.…activity_desc_default_bg)");
    localFinderActivityDescUIC.tqW = ((WeImageView)paramBundle);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131300764);
    p.g(paramBundle, "activity.findViewById(R.…nder_activity_post_title)");
    localFinderActivityDescUIC.hbb = ((TextView)paramBundle);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131296463);
    p.g(paramBundle, "activity.findViewById(R.id.activity_post_cover)");
    localFinderActivityDescUIC.cxe = ((ImageView)paramBundle);
    paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131296464);
    p.g(paramBundle, "activity.findViewById(R.…activity_post_cover_mask)");
    localFinderActivityDescUIC.tqR = ((ImageView)paramBundle);
    Object localObject1 = localFinderActivityDescUIC.getIntent().getStringExtra("key_cover_url");
    Log.i("Finder.ActivityDescUIC", "initView coverUrl:".concat(String.valueOf(localObject1)));
    Object localObject2;
    if (Util.isNullOrNil((String)localObject1))
    {
      paramBundle = localFinderActivityDescUIC.getActivity();
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(252102);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).getController().updataStatusBarIcon(ao.isDarkMode());
      localFinderActivityDescUIC.Ii(localFinderActivityDescUIC.getResources().getColor(2131099746));
      i = localFinderActivityDescUIC.getResources().getColor(2131100044);
      paramBundle = localFinderActivityDescUIC.tqU;
      if (paramBundle == null) {
        p.btv("activityDescText");
      }
      paramBundle.setTextColor(i);
      paramBundle = localFinderActivityDescUIC.tqT;
      if (paramBundle == null) {
        p.btv("activityNameText");
      }
      paramBundle.setTextColor(i);
      paramBundle = localFinderActivityDescUIC.cxe;
      if (paramBundle == null) {
        p.btv("coverImageView");
      }
      paramBundle.setVisibility(8);
      paramBundle = localFinderActivityDescUIC.tqR;
      if (paramBundle == null) {
        p.btv("coverMaskImageView");
      }
      paramBundle.setVisibility(8);
      paramBundle = localFinderActivityDescUIC.tqW;
      if (paramBundle == null) {
        p.btv("defaultBg");
      }
      paramBundle.setVisibility(0);
      paramBundle = localFinderActivityDescUIC.tqW;
      if (paramBundle == null) {
        p.btv("defaultBg");
      }
      paramBundle.setVisibility(0);
      paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131296472);
      p.g(paramBundle, "activity.findViewById(R.…ty_profile_header_avatar)");
      localFinderActivityDescUIC.tqQ = ((ImageView)paramBundle);
      localObject1 = localFinderActivityDescUIC.getIntent().getStringExtra("key_avatar_url");
      paramBundle = m.uJa;
      paramBundle = m.dka();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject2 = localFinderActivityDescUIC.tqQ;
      if (localObject2 == null) {
        p.btv("avatarImage");
      }
      m localm = m.uJa;
      paramBundle.a(localObject1, (ImageView)localObject2, m.a(m.a.uJe));
      paramBundle = localFinderActivityDescUIC.getIntent().getStringExtra("key_nick_name");
      localObject1 = localFinderActivityDescUIC.tqS;
      if (localObject1 == null) {
        p.btv("nickNameText");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localFinderActivityDescUIC.getActivity(), (CharSequence)paramBundle));
      paramBundle = localFinderActivityDescUIC.tqT;
      if (paramBundle == null) {
        p.btv("activityNameText");
      }
      paramBundle.setText((CharSequence)localFinderActivityDescUIC.getIntent().getStringExtra("key_activity_name"));
      paramBundle = localFinderActivityDescUIC.tqU;
      if (paramBundle == null) {
        p.btv("activityDescText");
      }
      paramBundle.setText((CharSequence)localFinderActivityDescUIC.getIntent().getStringExtra("key_activity_desc"));
      paramBundle = localFinderActivityDescUIC.getActivity().findViewById(2131300741);
      p.g(paramBundle, "activity.findViewById(R.…finder_activity_exit_btn)");
      localFinderActivityDescUIC.tqV = ((TextView)paramBundle);
      paramBundle = localFinderActivityDescUIC.tqV;
      if (paramBundle == null) {
        p.btv("exitActivityBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)FinderActivityDescUIC.c.tqZ);
      paramBundle = localFinderActivityDescUIC.hPV;
      if (paramBundle == null) {
        p.btv("backBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new FinderActivityDescUIC.d(localFinderActivityDescUIC));
      paramBundle = new DisplayMetrics();
      localObject1 = localFinderActivityDescUIC.getActivity();
      if (localObject1 == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(252102);
        throw paramBundle;
      }
    }
    else
    {
      if (localObject1 != null) {
        break label1464;
      }
    }
    label1464:
    for (paramBundle = "";; paramBundle = (Bundle)localObject1)
    {
      paramBundle = new g(paramBundle);
      localObject2 = m.uJa;
      paramBundle = m.djY().bQ(paramBundle);
      localObject2 = m.uJa;
      paramBundle = paramBundle.a(m.a(m.a.uJl)).a((e)new FinderActivityDescUIC.e(localFinderActivityDescUIC, (String)localObject1));
      localObject1 = localFinderActivityDescUIC.cxe;
      if (localObject1 == null) {
        p.btv("coverImageView");
      }
      paramBundle.c((ImageView)localObject1);
      paramBundle = localFinderActivityDescUIC.getActivity();
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(252102);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).getController().updataStatusBarIcon(true);
      localFinderActivityDescUIC.Ii(localFinderActivityDescUIC.getResources().getColor(2131099679));
      i = localFinderActivityDescUIC.getResources().getColor(2131100406);
      paramBundle = localFinderActivityDescUIC.tqU;
      if (paramBundle == null) {
        p.btv("activityDescText");
      }
      paramBundle.setTextColor(i);
      paramBundle = localFinderActivityDescUIC.tqT;
      if (paramBundle == null) {
        p.btv("activityNameText");
      }
      paramBundle.setTextColor(i);
      paramBundle = localFinderActivityDescUIC.cxe;
      if (paramBundle == null) {
        p.btv("coverImageView");
      }
      paramBundle.setVisibility(0);
      paramBundle = localFinderActivityDescUIC.tqR;
      if (paramBundle == null) {
        p.btv("coverMaskImageView");
      }
      paramBundle.setVisibility(0);
      paramBundle = localFinderActivityDescUIC.tqW;
      if (paramBundle == null) {
        p.btv("defaultBg");
      }
      paramBundle.setVisibility(8);
      paramBundle = localFinderActivityDescUIC.tqW;
      if (paramBundle == null) {
        p.btv("defaultBg");
      }
      paramBundle.setVisibility(8);
      paramBundle = localFinderActivityDescUIC.cxe;
      if (paramBundle == null) {
        p.btv("coverImageView");
      }
      paramBundle.post((Runnable)new FinderActivityDescUIC.b(localFinderActivityDescUIC));
      break;
      localObject1 = ((Activity)localObject1).getWindowManager();
      p.g(localObject1, "(activity as Activity).windowManager");
      ((WindowManager)localObject1).getDefaultDisplay().getMetrics(paramBundle);
      double d = paramBundle.heightPixels;
      paramBundle = localFinderActivityDescUIC.tqR;
      if (paramBundle == null) {
        p.btv("coverMaskImageView");
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(252102);
        throw paramBundle;
      }
      paramBundle = (FrameLayout.LayoutParams)paramBundle;
      paramBundle.topMargin = ((int)(d * 0.4D));
      localObject1 = localFinderActivityDescUIC.tqR;
      if (localObject1 == null) {
        p.btv("coverMaskImageView");
      }
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
      AppMethodBeat.o(252102);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderActivityDescUI paramFinderActivityDescUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252101);
      this.vHa.finish();
      AppMethodBeat.o(252101);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderActivityDescUI
 * JD-Core Version:    0.7.0.1
 */