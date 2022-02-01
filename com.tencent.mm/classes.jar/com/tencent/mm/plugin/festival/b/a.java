package com.tencent.mm.plugin.festival.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/festival/model/FestivalExpiredResourcesCleaner;", "", "()V", "execute", "", "plugin-festival_release"})
public final class a
{
  public static final a wUv;
  
  static
  {
    AppMethodBeat.i(258532);
    wUv = new a();
    AppMethodBeat.o(258532);
  }
  
  public static void execute()
  {
    AppMethodBeat.i(258529);
    com.tencent.e.h.ZvG.f((Runnable)a.wUw, "FestivalExpiredResourcesCleaner");
    AppMethodBeat.o(258529);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a wUw;
    
    static
    {
      AppMethodBeat.i(258539);
      wUw = new a();
      AppMethodBeat.o(258539);
    }
    
    public final void run()
    {
      int i = 0;
      AppMethodBeat.i(258538);
      for (;;)
      {
        if (i < 4) {}
        try
        {
          localObject1 = new String[] { "", ".ini", "-shm", "-wal" }[i];
          localObject2 = new StringBuilder();
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "storage()");
          u.deleteFile(((com.tencent.mm.kernel.f)localObject3).aHl() + "Festival2021.db" + (String)localObject1);
          i += 1;
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          AppMethodBeat.o(258538);
          return;
        }
      }
      u.dK(b.aSD() + "festival2021/", true);
      localObject1 = u.dP(b.aSC() + "files/mmkv/", false);
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.vfs.f)((Iterator)localObject1).next();
          localObject3 = ((com.tencent.mm.vfs.f)localObject2).name;
          p.j(localObject3, "it.name");
          if (n.M((String)localObject3, "FestivalProcessSharedMMKV", false)) {
            ((com.tencent.mm.vfs.f)localObject2).cFq();
          }
        }
        AppMethodBeat.o(258538);
        return;
      }
      AppMethodBeat.o(258538);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.b.a
 * JD-Core Version:    0.7.0.1
 */