package com.tencent.mm.plugin.festival.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.a.b;
import com.tencent.mm.plugin.festival.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/festival/ui/FestivalActivityBase;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getContentLayoutId", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setActionBarDesc", "desc", "", "setActionBarIcon", "iconResId", "setActionBarIconOnClick", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "setActionBarTitle", "title", "setWindowStyle", "plugin-festival_release"})
public abstract class FestivalActivityBase
  extends MMActivity
{
  private HashMap _$_findViewCache;
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
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
    return localView1;
  }
  
  public abstract int dmv();
  
  public int getLayoutId()
  {
    return a.c.wUq;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = (RelativeLayout)_$_findCachedViewById(a.b.wUn);
    paramBundle.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)new a(paramBundle));
    paramBundle = LayoutInflater.from((Context)this).inflate(dmv(), null);
    ((FrameLayout)_$_findCachedViewById(a.b.container)).addView(paramBundle);
    paramBundle = (b)new b(this);
    ((WeImageView)_$_findCachedViewById(a.b.wUm)).setOnClickListener((View.OnClickListener)new FestivalActivityBase.c(paramBundle));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "insets", "onApplyWindowInsets"})
  static final class a
    implements View.OnApplyWindowInsetsListener
  {
    a(RelativeLayout paramRelativeLayout) {}
    
    public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
    {
      AppMethodBeat.i(258622);
      paramView = this.wUy;
      p.j(paramView, "this");
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(258622);
        throw paramView;
      }
      paramView = (RelativeLayout.LayoutParams)paramView;
      p.j(paramWindowInsets, "insets");
      paramView.topMargin = paramWindowInsets.getSystemWindowInsetTop();
      AppMethodBeat.o(258622);
      return paramWindowInsets;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class b
    extends q
    implements b<View, x>
  {
    b(FestivalActivityBase paramFestivalActivityBase)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.ui.FestivalActivityBase
 * JD-Core Version:    0.7.0.1
 */