package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.activity.uic.b.b;
import com.tencent.mm.plugin.finder.activity.uic.b.d;
import com.tencent.mm.plugin.finder.activity.uic.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;

@a(3)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityDescUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "descContainer", "Landroid/view/View;", "fixActionBar", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFullScreen", "plugin-finder_release"})
public final class FinderActivityDescUI
  extends MMFinderUI
  implements i
{
  private HashMap _$_findViewCache;
  private View ybl;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(271450);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(271450);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(271449);
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
    AppMethodBeat.o(271449);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_activity_desc_ui_new;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(271448);
    Set localSet = ak.setOf(com.tencent.mm.plugin.finder.activity.uic.b.class);
    AppMethodBeat.o(271448);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271447);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.f.activity_desc_container);
    p.j(paramBundle, "findViewById(R.id.activity_desc_container)");
    this.ybl = paramBundle;
    int i = getResources().getColor(com.tencent.mm.plugin.finder.b.c.transparent);
    getController().setStatusBarColor(i);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    i = ax.getStatusBarHeight((Context)this);
    paramBundle = this.ybl;
    if (paramBundle == null) {
      p.bGy("descContainer");
    }
    int j = paramBundle.getPaddingTop();
    paramBundle = this.ybl;
    if (paramBundle == null) {
      p.bGy("descContainer");
    }
    paramBundle.setPadding(0, i + j, 0, 0);
    i = getResources().getColor(com.tencent.mm.plugin.finder.b.c.transparent);
    getController().setStatusBarColor(i);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = g.Xox;
    com.tencent.mm.plugin.finder.activity.uic.b localb = (com.tencent.mm.plugin.finder.activity.uic.b)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.activity.uic.b.class);
    paramBundle = localb.getActivity().findViewById(b.f.activity_profile_header_name);
    p.j(paramBundle, "activity.findViewById(R.…vity_profile_header_name)");
    localb.wXG = ((TextView)paramBundle);
    paramBundle = localb.getActivity().findViewById(b.f.finder_activity_name);
    p.j(paramBundle, "activity.findViewById(R.id.finder_activity_name)");
    localb.wXH = ((TextView)paramBundle);
    paramBundle = localb.getActivity().findViewById(b.f.finder_activity_desc);
    p.j(paramBundle, "activity.findViewById(R.id.finder_activity_desc)");
    localb.wXI = ((TextView)paramBundle);
    paramBundle = localb.getActivity().findViewById(b.f.finder_activity_post_cancel_btn);
    p.j(paramBundle, "activity.findViewById(R.…activity_post_cancel_btn)");
    localb.kEr = ((WeImageView)paramBundle);
    paramBundle = localb.getActivity().findViewById(b.f.finder_activity_post_title);
    p.j(paramBundle, "activity.findViewById(R.…nder_activity_post_title)");
    localb.jMg = ((TextView)paramBundle);
    paramBundle = localb.getActivity().findViewById(b.f.activity_post_cover);
    p.j(paramBundle, "activity.findViewById(R.id.activity_post_cover)");
    localb.cvK = ((ImageView)paramBundle);
    paramBundle = localb.getActivity().findViewById(b.f.activity_profile_cover_mask);
    p.j(paramBundle, "activity.findViewById(R.…ivity_profile_cover_mask)");
    localb.wXE = ((ImageView)paramBundle);
    paramBundle = localb.getActivity().findViewById(b.f.activity_profile_cover_container);
    p.j(paramBundle, "activity.findViewById(R.…_profile_cover_container)");
    localb.wXF = ((ViewGroup)paramBundle);
    Object localObject1 = localb.getIntent().getStringExtra("key_cover_url");
    Log.i("Finder.ActivityDescUIC", "initView coverUrl:".concat(String.valueOf(localObject1)));
    if (!Util.isNullOrNil((String)localObject1))
    {
      i = 1;
      if (i == 0) {
        break label1333;
      }
      if (localObject1 != null) {
        break label1522;
      }
    }
    label1333:
    label1522:
    for (paramBundle = "";; paramBundle = (Bundle)localObject1)
    {
      paramBundle = new m(paramBundle);
      Object localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramBundle = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(paramBundle);
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramBundle = paramBundle.a(com.tencent.mm.plugin.finder.loader.t.a(t.a.zuf)).a((com.tencent.mm.loader.f.e)new b.e(localb, (String)localObject1));
      localObject1 = localb.cvK;
      if (localObject1 == null) {
        p.bGy("coverImageView");
      }
      paramBundle.c((ImageView)localObject1);
      paramBundle = localb.getActivity();
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(271447);
        throw paramBundle;
        i = 0;
        break;
      }
      ((MMActivity)paramBundle).getController().updataStatusBarIcon(true);
      localb.LT(localb.getResources().getColor(com.tencent.mm.plugin.finder.b.c.BW_100_Alpha_0_8));
      i = localb.getResources().getColor(com.tencent.mm.plugin.finder.b.c.finder_activity_covered_white);
      paramBundle = localb.wXI;
      if (paramBundle == null) {
        p.bGy("activityDescText");
      }
      paramBundle.setTextColor(i);
      paramBundle = localb.wXI;
      if (paramBundle == null) {
        p.bGy("activityDescText");
      }
      paramBundle.setHintTextColor(localb.getResources().getColor(com.tencent.mm.plugin.finder.b.c.BW_100_Alpha_0_3));
      paramBundle = localb.wXH;
      if (paramBundle == null) {
        p.bGy("activityNameText");
      }
      paramBundle.setTextColor(i);
      paramBundle = localb.cvK;
      if (paramBundle == null) {
        p.bGy("coverImageView");
      }
      paramBundle.setVisibility(0);
      paramBundle = localb.wXF;
      if (paramBundle == null) {
        p.bGy("coverMaskContainer");
      }
      paramBundle.setVisibility(0);
      paramBundle = new DisplayMetrics();
      localObject1 = localb.getActivity();
      if (localObject1 == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(271447);
        throw paramBundle;
      }
      localObject1 = ((Activity)localObject1).getWindowManager();
      p.j(localObject1, "(activity as Activity).windowManager");
      ((WindowManager)localObject1).getDefaultDisplay().getMetrics(paramBundle);
      float f = paramBundle.widthPixels;
      paramBundle = localb.wXE;
      if (paramBundle == null) {
        p.bGy("coverMaskImageView");
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(271447);
        throw paramBundle;
      }
      paramBundle.height = ((int)(f * 1.333333F));
      localObject1 = localb.wXE;
      if (localObject1 == null) {
        p.bGy("coverMaskImageView");
      }
      ((ImageView)localObject1).setLayoutParams(paramBundle);
      paramBundle = localb.cvK;
      if (paramBundle == null) {
        p.bGy("coverImageView");
      }
      paramBundle.post((Runnable)new b.b(localb));
      for (;;)
      {
        paramBundle = localb.getActivity().findViewById(b.f.activity_profile_header_avatar);
        p.j(paramBundle, "activity.findViewById(R.…ty_profile_header_avatar)");
        localb.wXD = ((ImageView)paramBundle);
        localObject1 = localb.getIntent().getStringExtra("key_avatar_url");
        paramBundle = com.tencent.mm.plugin.finder.loader.t.ztT;
        paramBundle = com.tencent.mm.plugin.finder.loader.t.dJh();
        localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
        localObject2 = localb.wXD;
        if (localObject2 == null) {
          p.bGy("avatarImage");
        }
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        paramBundle.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
        paramBundle = localb.getIntent().getStringExtra("key_nick_name");
        localObject1 = localb.wXG;
        if (localObject1 == null) {
          p.bGy("nickNameText");
        }
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localb.getActivity(), (CharSequence)paramBundle));
        paramBundle = localb.wXH;
        if (paramBundle == null) {
          p.bGy("activityNameText");
        }
        paramBundle.setText((CharSequence)localb.getIntent().getStringExtra("key_activity_name"));
        localObject1 = localb.getIntent().getStringExtra("key_activity_desc");
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
        localb.wXK = paramBundle;
        paramBundle = localb.getActivity().findViewById(b.f.finder_activity_exit_btn);
        p.j(paramBundle, "activity.findViewById(R.…finder_activity_exit_btn)");
        localb.wXJ = ((TextView)paramBundle);
        paramBundle = localb.wXJ;
        if (paramBundle == null) {
          p.bGy("exitActivityBtn");
        }
        paramBundle.setOnClickListener((View.OnClickListener)com.tencent.mm.plugin.finder.activity.uic.b.c.wXN);
        paramBundle = localb.kEr;
        if (paramBundle == null) {
          p.bGy("backBtn");
        }
        paramBundle.setOnClickListener((View.OnClickListener)new b.d(localb));
        paramBundle = localb.getResources().getString(b.j.finder_activity_post_desc_prefix, new Object[] { localb.wXK });
        p.j(paramBundle, "resources.getString(R.st…_prefix, descTextContent)");
        localObject1 = localb.wXI;
        if (localObject1 == null) {
          p.bGy("activityDescText");
        }
        ((TextView)localObject1).setMovementMethod(ScrollingMovementMethod.getInstance());
        localObject1 = localb.wXI;
        if (localObject1 == null) {
          p.bGy("activityDescText");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
        AppMethodBeat.o(271447);
        return;
        paramBundle = localb.getActivity();
        if (paramBundle == null)
        {
          paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(271447);
          throw paramBundle;
        }
        ((MMActivity)paramBundle).getController().updataStatusBarIcon(ar.isDarkMode());
        localb.LT(localb.getResources().getColor(com.tencent.mm.plugin.finder.b.c.FG_0));
        i = localb.getResources().getColor(com.tencent.mm.plugin.finder.b.c.black_color);
        paramBundle = localb.wXI;
        if (paramBundle == null) {
          p.bGy("activityDescText");
        }
        paramBundle.setTextColor(i);
        paramBundle = localb.wXH;
        if (paramBundle == null) {
          p.bGy("activityNameText");
        }
        paramBundle.setTextColor(i);
        paramBundle = localb.wXI;
        if (paramBundle == null) {
          p.bGy("activityDescText");
        }
        paramBundle.setHintTextColor(localb.getResources().getColor(com.tencent.mm.plugin.finder.b.c.FG_2));
        paramBundle = localb.cvK;
        if (paramBundle == null) {
          p.bGy("coverImageView");
        }
        paramBundle.setVisibility(8);
        paramBundle = localb.wXF;
        if (paramBundle == null) {
          p.bGy("coverMaskContainer");
        }
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderActivityDescUI paramFinderActivityDescUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(286285);
      this.AnX.finish();
      AppMethodBeat.o(286285);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderActivityDescUI
 * JD-Core Version:    0.7.0.1
 */