package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingFailView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "loadingView", "hideLoading", "", "loadFailed", "setOnClickListener", "callback", "Lkotlin/Function0;", "plugin-gamelife_release"})
public final class GameLifeLoadingCoverView
  extends FrameLayout
{
  final View hSw;
  final View ydq;
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(241526);
    setBackgroundResource(2131099650);
    paramContext = aa.jQ(paramContext).inflate(2131494978, (ViewGroup)this, false);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.hSw = findViewById(2131303690);
    this.ydq = findViewById(2131303701);
    AppMethodBeat.o(241526);
  }
  
  public final void setOnClickListener(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(241525);
    p.h(parama, "callback");
    this.ydq.setOnClickListener((View.OnClickListener)new a(this, parama));
    AppMethodBeat.o(241525);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(GameLifeLoadingCoverView paramGameLifeLoadingCoverView, kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241524);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = GameLifeLoadingCoverView.a(this.ydr);
      p.g(paramView, "loadingFailView");
      paramView.setVisibility(8);
      paramView = GameLifeLoadingCoverView.b(this.ydr);
      p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      parama.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241524);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeLoadingCoverView
 * JD-Core Version:    0.7.0.1
 */