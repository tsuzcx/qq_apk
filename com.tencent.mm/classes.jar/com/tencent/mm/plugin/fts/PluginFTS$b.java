package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import com.tencent.wcdb.DatabaseErrorHandler;

final class PluginFTS$b
  extends a
{
  PluginFTS$b(PluginFTS paramPluginFTS) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(136599);
    g.RM();
    if (2 != ((Integer)g.RL().Ru().get(ac.a.yHq, Integer.valueOf(0))).intValue())
    {
      d.bBO();
      g.RM();
      g.RL().Ru().set(ac.a.yHq, Integer.valueOf(2));
    }
    g.RM();
    Object localObject = new b(g.RL().cachePath, "IndexMicroMsg.db");
    if (((b)localObject).exists()) {
      ((b)localObject).delete();
    }
    for (;;)
    {
      g.RM();
      localObject = new b(g.RL().cachePath, "FTS5IndexMicroMsg.db");
      if (((b)localObject).exists()) {
        ((b)localObject).delete();
      }
      try
      {
        for (;;)
        {
          localObject = this.mQm;
          g.RM();
          PluginFTS.access$102((PluginFTS)localObject, new d(g.RL().cachePath));
          PluginFTS.access$500(this.mQm);
          PluginFTS.access$600(this.mQm);
          PluginFTS.access$700(this.mQm);
          PluginFTS.access$800(this.mQm);
          AppMethodBeat.o(136599);
          return true;
          ab.i("MicroMsg.FTS.PluginFTS", "not exist fts3DBFile %s", new Object[] { j.p(((b)localObject).dQJ()) });
          break;
          ab.i("MicroMsg.FTS.PluginFTS", "not exist fts5DBUnEncrypt %s", new Object[] { j.p(((b)localObject).dQJ()) });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (PluginFTS.mPY)
          {
            AppMethodBeat.o(136599);
            return true;
          }
          ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException, "Index database corruption detected", new Object[0]);
          PluginFTS.access$900(this.mQm).onCorruption(null);
        }
      }
    }
  }
  
  public final String getName()
  {
    return "InitSearchTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.b
 * JD-Core Version:    0.7.0.1
 */