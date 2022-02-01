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
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingFailView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "loadingView", "hideLoading", "", "loadFailed", "setOnClickListener", "callback", "Lkotlin/Function0;", "plugin-gamelife_release"})
public final class GameLifeLoadingCoverView
  extends FrameLayout
{
  final View gWO;
  final View uzr;
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public GameLifeLoadingCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(211494);
    setBackgroundResource(2131099650);
    paramContext = com.tencent.mm.ui.z.jO(paramContext).inflate(2131496409, (ViewGroup)this, false);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 17;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.gWO = findViewById(2131301491);
    this.uzr = findViewById(2131308149);
    AppMethodBeat.o(211494);
  }
  
  public final void setOnClickListener(final d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(211493);
    p.h(parama, "callback");
    this.uzr.setOnClickListener((View.OnClickListener)new a(this, parama));
    AppMethodBeat.o(211493);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(GameLifeLoadingCoverView paramGameLifeLoadingCoverView, d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211492);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = GameLifeLoadingCoverView.a(this.uzs);
      p.g(paramView, "loadingFailView");
      paramView.setVisibility(8);
      paramView = GameLifeLoadingCoverView.b(this.uzs);
      p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      parama.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeLoadingCoverView
 * JD-Core Version:    0.7.0.1
 */