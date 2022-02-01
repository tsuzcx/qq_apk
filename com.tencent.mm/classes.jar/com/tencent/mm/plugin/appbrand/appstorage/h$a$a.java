package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
public final class h$a$a
  implements Runnable
{
  public static final a nMK;
  
  static
  {
    AppMethodBeat.i(284273);
    nMK = new a();
    AppMethodBeat.o(284273);
  }
  
  public final void run()
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(284272);
    Object localObject1 = new q(av.bSa());
    if ((!((q)localObject1).ifE()) || (!((q)localObject1).isDirectory()))
    {
      AppMethodBeat.o(284272);
      return;
    }
    localObject1 = ((q)localObject1).ifJ();
    if (localObject1 != null)
    {
      if (localObject1.length != 0) {
        break label79;
      }
      i = 1;
      if (i == 0) {
        break label84;
      }
    }
    label79:
    label84:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label89;
      }
      AppMethodBeat.o(284272);
      return;
      i = 0;
      break;
    }
    label89:
    int m = localObject1.length;
    i = 0;
    Object localObject2;
    h.a locala;
    while (i < m)
    {
      localObject2 = localObject1[i];
      locala = h.nMI;
      p.j(localObject2, "mayBeDir");
      h.a.d(localObject2, localObject2.getName());
      i += 1;
    }
    localObject1 = new q(AppBrandVideoDownLoadMgr.puc);
    if ((!((q)localObject1).ifE()) || (!((q)localObject1).isDirectory()))
    {
      AppMethodBeat.o(284272);
      return;
    }
    localObject1 = ((q)localObject1).ifJ();
    i = k;
    if (localObject1 != null)
    {
      if (localObject1.length != 0) {
        break label209;
      }
      i = 1;
      if (i == 0) {
        break label214;
      }
    }
    label209:
    label214:
    for (i = k;; i = 0)
    {
      if (i == 0) {
        break label219;
      }
      AppMethodBeat.o(284272);
      return;
      i = 0;
      break;
    }
    label219:
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      localObject2 = localObject1[i];
      locala = h.nMI;
      h.a.d(localObject2, null);
      i += 1;
    }
    AppMethodBeat.o(284272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.h.a.a
 * JD-Core Version:    0.7.0.1
 */