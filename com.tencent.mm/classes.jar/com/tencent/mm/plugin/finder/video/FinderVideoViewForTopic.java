package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.pointers.PInt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "firstCacheTimeStep", "", "calcDownloadRange", "", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "plugin-finder_release"})
public final class FinderVideoViewForTopic
  extends FinderVideoView
{
  private int wgg = 3;
  
  public FinderVideoViewForTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(254403);
    p.h(paramPInt1, "start");
    p.h(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.jqc);
    if (this.jpW == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.wgg + 1);
    }
    this.wgg += this.jqh.jqm;
    if (this.jpW == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.jqd + 8);
    }
    if ((this.jpW == 3) || (this.jpW == 4))
    {
      paramPInt1.value = this.jqc;
      paramPInt2.value = (this.jqd + paramInt + 1 + this.jqh.jqn);
      paramPInt2.value = (this.jpY + 1);
    }
    if (paramPInt2.value >= this.jpY + 1) {
      paramPInt2.value = (this.jpY + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.jqh.jqn;
      start();
      AppMethodBeat.o(254403);
      return true;
    }
    AppMethodBeat.o(254403);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic
 * JD-Core Version:    0.7.0.1
 */