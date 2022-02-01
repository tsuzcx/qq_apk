package com.tencent.mm.plugin.finder.record.plugin;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/record/plugin/FinderTemplateListPlugin$1$1", "Lcom/tencent/mm/plugin/finder/record/plugin/DynMarginLayoutManager;", "canScrollHorizontally", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTemplateListPlugin$1$1
  extends DynMarginLayoutManager
{
  FinderTemplateListPlugin$1$1(c paramc, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(336976);
    AppMethodBeat.o(336976);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(336983);
    if ((c.f(this.Fjj)) && (super.canScrollHorizontally()))
    {
      AppMethodBeat.o(336983);
      return true;
    }
    AppMethodBeat.o(336983);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.FinderTemplateListPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */