package com.tencent.mm.plugin.festival.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.festival.a.b;
import com.tencent.mm.plugin.festival.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/festival/ui/FestivalActivityBase;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getContentLayoutId", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setActionBarDesc", "desc", "", "setActionBarIcon", "iconResId", "setActionBarIconOnClick", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "setActionBarTitle", "title", "setWindowStyle", "plugin-festival_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FestivalActivityBase
  extends MMActivity
{
  private static final WindowInsets a(RelativeLayout paramRelativeLayout, View paramView, WindowInsets paramWindowInsets)
  {
    paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    if (paramRelativeLayout == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).topMargin = paramWindowInsets.getSystemWindowInsetTop();
    return paramWindowInsets;
  }
  
  private static final void i(kotlin.g.a.b paramb, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/festival/ui/FestivalActivityBase", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    if (paramb != null)
    {
      s.s(paramView, "it");
      paramb.invoke(paramView);
    }
    a.a(new Object(), "com/tencent/mm/plugin/festival/ui/FestivalActivityBase", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public abstract int dTn();
  
  public int getLayoutId()
  {
    return a.c.AqZ;
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
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = (RelativeLayout)findViewById(a.b.AqU);
    paramBundle.setOnApplyWindowInsetsListener(new FestivalActivityBase..ExternalSyntheticLambda0(paramBundle));
    paramBundle = LayoutInflater.from((Context)this).inflate(dTn(), null);
    ((FrameLayout)findViewById(a.b.container)).addView(paramBundle);
    paramBundle = (kotlin.g.a.b)new FestivalActivityBase.a(this);
    ((WeImageView)findViewById(a.b.AqT)).setOnClickListener(new FestivalActivityBase..ExternalSyntheticLambda1(paramBundle));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.ui.FestivalActivityBase
 * JD-Core Version:    0.7.0.1
 */