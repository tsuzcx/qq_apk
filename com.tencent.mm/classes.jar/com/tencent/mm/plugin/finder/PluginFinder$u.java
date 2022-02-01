package com.tencent.mm.plugin.finder;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.snscover.b;
import com.tencent.mm.plugin.finder.view.snscover.c;
import com.tencent.mm.plugin.sns.cover.a.a;
import com.tencent.mm.plugin.sns.cover.a.f.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/PluginFinder$onAccountInitialized$4", "Lcom/tencent/mm/plugin/sns/cover/api/SnsFinderBackPreviewFactory$ISnsFinderBackPreviewDelegate;", "getImageView", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "context", "Landroid/content/Context;", "getVideoView", "setFinderObj", "", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "absSnsBackPreview", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinder$u
  implements f.a
{
  public final a go(Context paramContext)
  {
    AppMethodBeat.i(329773);
    s.u(paramContext, "context");
    paramContext = (a)new c(paramContext);
    AppMethodBeat.o(329773);
    return paramContext;
  }
  
  public final a gp(Context paramContext)
  {
    AppMethodBeat.i(329778);
    s.u(paramContext, "context");
    paramContext = (a)new b(paramContext);
    AppMethodBeat.o(329778);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.u
 * JD-Core Version:    0.7.0.1
 */