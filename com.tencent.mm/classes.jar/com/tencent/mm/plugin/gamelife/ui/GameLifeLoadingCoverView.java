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
import com.tencent.mm.plugin.gamelife.d.a;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.ui.ad;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingFailView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "loadingView", "hideLoading", "", "loadFailed", "setOnClickListener", "callback", "Lkotlin/Function0;", "plugin-gamelife_release"})
public final class GameLifeLoadingCoverView
  extends FrameLayout
{
  final View DiU;
  final View kGT;
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203580);
    setBackgroundResource(d.a.BG_2);
    paramContext = ad.kS(paramContext).inflate(d.d.Dgi, (ViewGroup)this, false);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.kGT = findViewById(d.c.loading);
    this.DiU = findViewById(d.c.DfV);
    AppMethodBeat.o(203580);
  }
  
  public final void setOnClickListener(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(203577);
    p.k(parama, "callback");
    this.DiU.setOnClickListener((View.OnClickListener)new a(this, parama));
    AppMethodBeat.o(203577);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(GameLifeLoadingCoverView paramGameLifeLoadingCoverView, kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203269);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = GameLifeLoadingCoverView.a(this.DiV);
      p.j(paramView, "loadingFailView");
      paramView.setVisibility(8);
      paramView = GameLifeLoadingCoverView.b(this.DiV);
      p.j(paramView, "loadingView");
      paramView.setVisibility(0);
      parama.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeLoadingCoverView
 * JD-Core Version:    0.7.0.1
 */