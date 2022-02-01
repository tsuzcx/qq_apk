package com.tencent.mm.plugin.finder.live.fluent.animate;

import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/animate/FluentTransitionConfig;", "", "animatorList", "Ljava/util/ArrayList;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getAnimators", "Builder", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final ArrayList<ValueAnimator> CCM;
  
  public b(ArrayList<ValueAnimator> paramArrayList)
  {
    AppMethodBeat.i(352052);
    this.CCM = paramArrayList;
    AppMethodBeat.o(352052);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/animate/FluentTransitionConfig$Builder;", "", "()V", "animatorList", "Ljava/util/ArrayList;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/ArrayList;", "addAnimator", "animator", "build", "Lcom/tencent/mm/plugin/finder/live/fluent/animate/FluentTransitionConfig;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final ArrayList<ValueAnimator> CCM;
    
    public a()
    {
      AppMethodBeat.i(352057);
      this.CCM = new ArrayList();
      AppMethodBeat.o(352057);
    }
    
    public final a c(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(352065);
      s.u(paramValueAnimator, "animator");
      this.CCM.add(paramValueAnimator);
      AppMethodBeat.o(352065);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.animate.b
 * JD-Core Version:    0.7.0.1
 */