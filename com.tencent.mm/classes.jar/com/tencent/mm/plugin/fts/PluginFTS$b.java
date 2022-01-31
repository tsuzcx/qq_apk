package com.tencent.mm.plugin.fts;

import android.util.Log;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.b;

final class PluginFTS$b
  extends a
{
  private PluginFTS$b(PluginFTS paramPluginFTS) {}
  
  public final boolean execute()
  {
    g.DQ();
    if (2 != ((Integer)g.DP().Dz().get(ac.a.uxh, Integer.valueOf(0))).intValue())
    {
      d.aVp();
      g.DQ();
      g.DP().Dz().c(ac.a.uxh, Integer.valueOf(2));
    }
    g.DQ();
    Object localObject = new b(g.DP().cachePath, "IndexMicroMsg.db");
    if (((b)localObject).exists()) {
      ((b)localObject).delete();
    }
    try
    {
      localObject = this.kuy;
      g.DQ();
      PluginFTS.access$202((PluginFTS)localObject, new d(g.DP().cachePath));
      PluginFTS.access$600(this.kuy);
      PluginFTS.access$700(this.kuy);
      PluginFTS.access$800(this.kuy);
      PluginFTS.access$900(this.kuy);
      return true;
    }
    catch (Exception localException)
    {
      while (PluginFTS.kuk) {}
      y.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException, "Index database corruption detected", new Object[0]);
      com.tencent.mm.plugin.fts.a.e.rv(19);
      PluginFTS.access$300(this.kuy);
      PluginFTS.access$400(this.kuy);
      PluginFTS.access$200(this.kuy).close();
      d.aVp();
      String str = "InitSearchTask: " + Log.getStackTraceString(localException);
      h.nFQ.d("FTS", str, null);
    }
    return true;
  }
  
  public final String getName()
  {
    return "InitSearchTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.b
 * JD-Core Version:    0.7.0.1
 */