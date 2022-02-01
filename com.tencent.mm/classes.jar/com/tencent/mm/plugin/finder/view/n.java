package com.tencent.mm.plugin.finder.view;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderSlideAnimHelper;", "", "()V", "HEIGHT", "", "getHEIGHT", "()F", "WIDTH", "getWIDTH", "slideFromLeftAnim", "Landroid/animation/ObjectAnimator;", "slideFromLeftListener", "Lcom/tencent/mm/plugin/finder/view/HorizontalAnimationListener;", "slideFromRightAnim", "slideFromRightListener", "slideToBottomAnim", "slideToBottomListener", "Lcom/tencent/mm/plugin/finder/view/VerticalAnimationListener;", "slideToLeftAnim", "slideToLeftListener", "slideToRightAnim", "slideToRightListener", "printDebugMsg", "", "tag", "", "msg", "slideFromLeft", "view", "Landroid/view/View;", "animEndCallback", "Lkotlin/Function0;", "width", "slideFromRight", "slideToBottom", "slideToLeft", "slideToRight", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n.a GCe;
  public ObjectAnimator GCf;
  public ad GCg;
  public ObjectAnimator GCh;
  public ad GCi;
  public ObjectAnimator GCj;
  public ai GCk;
  
  static
  {
    AppMethodBeat.i(344213);
    GCe = new n.a((byte)0);
    AppMethodBeat.o(344213);
  }
  
  public static float getHEIGHT()
  {
    AppMethodBeat.i(344200);
    float f = bf.bf(MMApplicationContext.getContext()).y;
    AppMethodBeat.o(344200);
    return f;
  }
  
  public static float getWIDTH()
  {
    AppMethodBeat.i(344195);
    float f = bf.bf(MMApplicationContext.getContext()).x;
    AppMethodBeat.o(344195);
    return f;
  }
  
  public static void hQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(344205);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    aw localaw = aw.Gjk;
    if (aw.bgV()) {
      Log.i(s.X(paramString1, "(Debug)"), paramString2);
    }
    AppMethodBeat.o(344205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.n
 * JD-Core Version:    0.7.0.1
 */