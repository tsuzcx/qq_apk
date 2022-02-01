package com.tencent.mm.plugin.finder.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/fts/PluginFinderFts$onAccountInitialized$1", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "execute", "", "getName", "", "plugin-finder-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderFts$b
  extends c
{
  public final boolean aXz()
  {
    AppMethodBeat.i(330934);
    Object localObject = (i)new a();
    ((n)h.az(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = (k)new b();
    ((n)h.az(n.class)).registerNativeLogic(13, (k)localObject);
    ((k)localObject).create();
    localObject = new f();
    ((n)h.az(n.class)).registerFTSUILogic((d)localObject);
    localObject = new e();
    ((n)h.az(n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(330934);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSFinderFollowPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.PluginFinderFts.b
 * JD-Core Version:    0.7.0.1
 */