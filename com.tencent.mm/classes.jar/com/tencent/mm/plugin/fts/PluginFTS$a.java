package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;

final class PluginFTS$a
  extends a
{
  private PluginFTS$a(PluginFTS paramPluginFTS) {}
  
  public final String afJ()
  {
    return String.format("{T2S: %d PY: %d}", new Object[] { Integer.valueOf(com.tencent.mm.plugin.fts.a.g.eSa.size()), Integer.valueOf(com.tencent.mm.plugin.fts.a.g.kvX.size()) });
  }
  
  public final boolean execute()
  {
    DW("start");
    try
    {
      String[] arrayOfString1 = new String(com.tencent.mm.vfs.e.c("assets:///fts_t2s.txt", 0, -1)).split("\n");
      int j = arrayOfString1.length;
      int i = 0;
      String[] arrayOfString3;
      while (i < j)
      {
        arrayOfString3 = arrayOfString1[i].split(",");
        com.tencent.mm.plugin.fts.a.g.eSa.put(arrayOfString3[0], arrayOfString3[1]);
        i += 1;
      }
      try
      {
        arrayOfString2 = new String(com.tencent.mm.vfs.e.c("assets:///fts_py.txt", 0, -1)).split("\n");
        i = 0;
        if (i >= arrayOfString2.length) {
          break label257;
        }
        arrayOfString5 = arrayOfString2[i].split(",");
        arrayOfString3 = arrayOfString5[0];
        arrayOfString4 = new String[arrayOfString5.length - 1];
        j = 0;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException2, localException2.getMessage(), new Object[0]);
          DW("py");
          com.tencent.mm.plugin.fts.a.e.kvw.kvy = (d.aVq().length() / 1048576L);
          com.tencent.mm.plugin.fts.a.e.kvw.kvz = PluginFTS.access$200(this.kuy).z(-301L, 0L);
          com.tencent.mm.plugin.fts.a.e.kvw.kvA = PluginFTS.access$200(this.kuy).z(-302L, 0L);
          com.tencent.mm.plugin.fts.a.e.kvw.kvC = PluginFTS.access$200(this.kuy).z(-303L, 0L);
          com.tencent.mm.plugin.fts.a.e.kvw.kvB = PluginFTS.access$200(this.kuy).z(-304L, 0L);
          long l1 = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexDB().z(-300L, 0L);
          long l2 = System.currentTimeMillis();
          if (!com.tencent.mm.plugin.fts.a.d.B(l1, l2))
          {
            com.tencent.mm.plugin.fts.a.e.aVx();
            ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexDB().A(-300L, l2);
          }
          for (;;)
          {
            DW("reportData");
            return true;
            y.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
          }
          j += 1;
        }
      }
    }
    catch (Exception localException1)
    {
      y.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException1, localException1.getMessage(), new Object[0]);
      DW("t2s");
    }
    for (;;)
    {
      String[] arrayOfString2;
      String[] arrayOfString5;
      String[] arrayOfString4;
      if (j < arrayOfString4.length)
      {
        if (j + 1 >= arrayOfString5.length) {
          break;
        }
        arrayOfString4[j] = arrayOfString5[(j + 1)];
        break;
      }
      if (arrayOfString4.length > 0)
      {
        int k = arrayOfString4.length;
        j = 0;
        while (j < k)
        {
          arrayOfString5 = arrayOfString4[j];
          com.tencent.mm.plugin.fts.a.g.kvW.DY(arrayOfString5);
          j += 1;
        }
        com.tencent.mm.plugin.fts.a.g.kvX.put(arrayOfString3, arrayOfString4);
      }
      i += 1;
    }
  }
  
  public final String getName()
  {
    return "InitResourceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.a
 * JD-Core Version:    0.7.0.1
 */