package com.tencent.mm.plugin.finder.upload.postlogic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.upload.postlogic.base.g;
import com.tencent.mm.plugin.finder.upload.postlogic.monitors.a;
import com.tencent.mm.plugin.finder.upload.postlogic.monitors.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderStageMonitor;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageMonitor;", "()V", "TAG", "", "monitorList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "begin", "", "taskId", "beginStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "end", "endStage", "transfer", "from", "to", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements g
{
  private final ArrayList<g> GdN;
  private final String TAG;
  
  public e()
  {
    AppMethodBeat.i(342974);
    this.TAG = "Finder.FinderPostStageMonitor";
    this.GdN = new ArrayList();
    this.GdN.add(new a());
    this.GdN.add(new b());
    AppMethodBeat.o(342974);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame1, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame2)
  {
    AppMethodBeat.i(342987);
    s.u(paramString, "taskId");
    s.u(parame1, "from");
    s.u(parame2, "to");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("PostLog transfer from:");
    c localc = c.GdI;
    localStringBuilder = localStringBuilder.append(c.a(parame1)).append(", to:");
    localc = c.GdI;
    Log.i((String)localObject, c.a(parame2));
    localObject = ((Iterable)this.GdN).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((g)((Iterator)localObject).next()).a(paramString, parame1, parame2);
    }
    AppMethodBeat.o(342987);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(342981);
    s.u(paramString, "taskId");
    s.u(parame, "beginStage");
    Object localObject = this.TAG;
    c localc = c.GdI;
    Log.i((String)localObject, s.X("PostLog begin:", c.a(parame)));
    localObject = ((Iterable)this.GdN).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((g)((Iterator)localObject).next()).b(paramString, parame);
    }
    AppMethodBeat.o(342981);
  }
  
  public final void c(String paramString, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(342992);
    s.u(paramString, "taskId");
    s.u(parame, "endStage");
    Object localObject = this.TAG;
    c localc = c.GdI;
    Log.i((String)localObject, s.X("PostLog end:", c.a(parame)));
    localObject = ((Iterable)this.GdN).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((g)((Iterator)localObject).next()).c(paramString, parame);
    }
    AppMethodBeat.o(342992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.e
 * JD-Core Version:    0.7.0.1
 */