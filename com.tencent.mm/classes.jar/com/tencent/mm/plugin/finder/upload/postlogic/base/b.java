package com.tencent.mm.plugin.finder.upload.postlogic.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Executor;", "", "id", "", "parallelTask", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getParallelTask", "()I", "queue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/PipelineCore$PipelineTask;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/PipelineCore;", "getQueue", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "queueCallback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getQueueCallback", "()Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "stageList", "Ljava/util/Vector;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "getStageList", "()Ljava/util/Vector;", "exec", "", "pipelineTask", "release", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final com.tencent.mm.loader.f.d<d.a> GdO;
  private final com.tencent.mm.loader.f.e<d.a> GdP;
  final Vector<e> GdQ;
  private final String id;
  private final int nsb;
  
  public b(String paramString)
  {
    AppMethodBeat.i(343240);
    this.id = paramString;
    this.nsb = 1;
    this.GdQ = new Vector();
    this.GdO = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new a(100), new g(this.nsb, (byte)0), this.nsb, this.id));
    this.GdP = ((com.tencent.mm.loader.f.e)new com.tencent.mm.loader.f.e() {});
    this.GdO.a(this.GdP);
    AppMethodBeat.o(343240);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(343253);
    s.u(parama, "pipelineTask");
    Object localObject = (List)this.GdQ;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (!s.p(((e)((Iterator)localObject).next()).feq(), parama.GdT.feq())) {}
    }
    for (;;)
    {
      if (i < 0) {
        this.GdQ.add(parama.GdT);
      }
      this.GdO.c((com.tencent.mm.loader.f.c)parama);
      AppMethodBeat.o(343253);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.base.b
 * JD-Core Version:    0.7.0.1
 */