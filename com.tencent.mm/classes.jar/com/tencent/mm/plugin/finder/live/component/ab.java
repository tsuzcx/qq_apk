package com.tencent.mm.plugin.finder.live.component;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSearchMusicSlideAnimHelper;", "", "()V", "HEIGHT", "", "WIDTH", "slideFromRightAnim", "Landroid/animation/ObjectAnimator;", "slideFromRightListener", "Lcom/tencent/mm/plugin/finder/live/component/HorizontalAnimationListener;", "slideToBottomAnim", "slideToBottomListener", "Lcom/tencent/mm/plugin/finder/live/component/VerticalAnimationListener;", "slideToRightAnim", "slideToRightListener", "slideFromRight", "", "view", "Landroid/view/View;", "animEndCallback", "Lkotlin/Function0;", "slideToBottom", "slideToRight", "Companion", "plugin-finder_release"})
public final class ab
{
  public static final a ycE;
  ObjectAnimator ycA;
  af ycB;
  ObjectAnimator ycC;
  ai ycD;
  final float ycw;
  final float ycx;
  ObjectAnimator ycy;
  af ycz;
  
  static
  {
    AppMethodBeat.i(289886);
    ycE = new a((byte)0);
    AppMethodBeat.o(289886);
  }
  
  public ab()
  {
    AppMethodBeat.i(289885);
    this.ycw = ax.au(MMApplicationContext.getContext()).x;
    this.ycx = ax.au(MMApplicationContext.getContext()).y;
    AppMethodBeat.o(289885);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSearchMusicSlideAnimHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ab
 * JD-Core Version:    0.7.0.1
 */