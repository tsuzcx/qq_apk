package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.pointers.PInt;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "firstCacheTimeStep", "", "calcDownloadRange", "", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoViewForTopic
  extends FinderVideoView
{
  private int Grv = 3;
  
  public FinderVideoViewForTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(335156);
    s.u(paramPInt1, "start");
    s.u(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.oYz);
    if (this.oYt == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.Grv + 1);
    }
    this.Grv += this.oYE.oYJ;
    if (this.oYt == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.oYA + 8);
    }
    if ((this.oYt == 3) || (this.oYt == 4))
    {
      paramPInt1.value = this.oYz;
      paramPInt2.value = (this.oYA + paramInt + 1 + this.oYE.oYK);
      paramPInt2.value = (this.oYv + 1);
    }
    if (paramPInt2.value >= this.oYv + 1) {
      paramPInt2.value = (this.oYv + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.oYE.oYK;
      start();
      AppMethodBeat.o(335156);
      return true;
    }
    AppMethodBeat.o(335156);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic
 * JD-Core Version:    0.7.0.1
 */