package com.tencent.mm.plugin.finder.nearby.live.search;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/search/FinderLiveSearchHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "enterFinderLiveSearch", "", "intent", "Landroid/content/Intent;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final Context context;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(340764);
    this.context = paramContext;
    AppMethodBeat.o(340764);
  }
  
  public final void az(Intent paramIntent)
  {
    AppMethodBeat.i(340772);
    s.u(paramIntent, "intent");
    paramIntent.putExtra("request_type", 13);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.V(this.context, paramIntent);
    AppMethodBeat.o(340772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.search.a
 * JD-Core Version:    0.7.0.1
 */