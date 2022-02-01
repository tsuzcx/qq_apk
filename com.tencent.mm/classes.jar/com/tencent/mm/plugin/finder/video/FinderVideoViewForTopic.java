package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.pointers.PInt;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "firstCacheTimeStep", "", "calcDownloadRange", "", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "plugin-finder_release"})
public final class FinderVideoViewForTopic
  extends FinderVideoView
{
  private int APb = 3;
  
  public FinderVideoViewForTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(243143);
    p.k(paramPInt1, "start");
    p.k(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.mfD);
    if (this.mfx == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.APb + 1);
    }
    this.APb += this.mfI.mfN;
    if (this.mfx == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.mfE + 8);
    }
    if ((this.mfx == 3) || (this.mfx == 4))
    {
      paramPInt1.value = this.mfD;
      paramPInt2.value = (this.mfE + paramInt + 1 + this.mfI.mfO);
      paramPInt2.value = (this.mfz + 1);
    }
    if (paramPInt2.value >= this.mfz + 1) {
      paramPInt2.value = (this.mfz + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.mfI.mfO;
      start();
      AppMethodBeat.o(243143);
      return true;
    }
    AppMethodBeat.o(243143);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic
 * JD-Core Version:    0.7.0.1
 */