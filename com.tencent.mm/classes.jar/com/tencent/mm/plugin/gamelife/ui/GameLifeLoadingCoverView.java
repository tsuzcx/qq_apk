package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gamelife.d.a;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.ui.af;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingFailView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "loadingView", "hideLoading", "", "loadFailed", "setOnClickListener", "callback", "Lkotlin/Function0;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLifeLoadingCoverView
  extends FrameLayout
{
  final View JcC;
  final View njN;
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(267893);
    AppMethodBeat.o(267893);
  }
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(267879);
    setBackgroundResource(d.a.BG_2);
    paramContext = af.mU(paramContext).inflate(d.d.Jad, (ViewGroup)this, false);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.njN = findViewById(d.c.loading);
    this.JcC = findViewById(d.c.IZQ);
    AppMethodBeat.o(267879);
  }
  
  private static final void a(GameLifeLoadingCoverView paramGameLifeLoadingCoverView, kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(267901);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramGameLifeLoadingCoverView);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGameLifeLoadingCoverView, "this$0");
    s.u(parama, "$callback");
    paramGameLifeLoadingCoverView.JcC.setVisibility(8);
    paramGameLifeLoadingCoverView.njN.setVisibility(0);
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267901);
  }
  
  public final void setOnClickListener(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(267919);
    s.u(parama, "callback");
    this.JcC.setOnClickListener(new GameLifeLoadingCoverView..ExternalSyntheticLambda0(this, parama));
    AppMethodBeat.o(267919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeLoadingCoverView
 * JD-Core Version:    0.7.0.1
 */