package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/festival/model/FestivalExpiredResourcesCleaner;", "", "()V", "execute", "", "plugin-festival_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Are;
  
  static
  {
    AppMethodBeat.i(260904);
    Are = new a();
    AppMethodBeat.o(260904);
  }
  
  private static final void dTm()
  {
    int i = 0;
    AppMethodBeat.i(260897);
    for (;;)
    {
      if (i < 4) {}
      try
      {
        localObject = new String[] { "", ".ini", "-shm", "-wal" }[i];
        y.deleteFile(com.tencent.mm.kernel.h.baE().cachePath + "Festival2021.db" + (String)localObject);
        i += 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        AppMethodBeat.o(260897);
        return;
      }
    }
    y.ew(s.X(b.bmr(), "festival2021/"), true);
    localObject = y.eB(s.X(b.bmq(), "files/mmkv/"), false);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        String str = localj.name;
        s.s(str, "it.name");
        if (n.U(str, "FestivalProcessSharedMMKV", false)) {
          localj.NP(true);
        }
      }
    }
    AppMethodBeat.o(260897);
  }
  
  public static void execute()
  {
    AppMethodBeat.i(260886);
    com.tencent.threadpool.h.ahAA.i(a..ExternalSyntheticLambda0.INSTANCE, "FestivalExpiredResourcesCleaner");
    AppMethodBeat.o(260886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.b.a
 * JD-Core Version:    0.7.0.1
 */