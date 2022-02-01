package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

final class PluginFTS$a
  extends a
{
  private PluginFTS$a(PluginFTS paramPluginFTS) {}
  
  public final String bdq()
  {
    AppMethodBeat.i(52578);
    String str = String.format("{T2S: %d PY: %d}", new Object[] { Integer.valueOf(com.tencent.mm.plugin.fts.a.g.iuR.size()), Integer.valueOf(com.tencent.mm.plugin.fts.a.g.sxw.size()) });
    AppMethodBeat.o(52578);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(52577);
    afX("start");
    try
    {
      String[] arrayOfString1 = new String(i.aU("assets:///fts/fts_t2s.txt", 0, -1)).split("\n");
      int j = arrayOfString1.length;
      int i = 0;
      String[] arrayOfString3;
      while (i < j)
      {
        arrayOfString3 = arrayOfString1[i].split(",");
        com.tencent.mm.plugin.fts.a.g.iuR.put(arrayOfString3[0], arrayOfString3[1]);
        i += 1;
      }
      try
      {
        arrayOfString2 = new String(i.aU("assets:///fts/fts_py.txt", 0, -1)).split("\n");
        i = 0;
        if (i >= arrayOfString2.length) {
          break label272;
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
          com.tencent.mm.plugin.fts.a.e.Fy(27);
          ac.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException2, localException2.getMessage(), new Object[0]);
          afX("py");
          com.tencent.mm.plugin.fts.a.e.swU.swX = (d.cKo().length() / 1048576L);
          com.tencent.mm.plugin.fts.a.e.swU.swY = PluginFTS.access$100(this.svX).Q(-301L, 0L);
          com.tencent.mm.plugin.fts.a.e.swU.swZ = PluginFTS.access$100(this.svX).Q(-302L, 0L);
          com.tencent.mm.plugin.fts.a.e.swU.sxb = PluginFTS.access$100(this.svX).Q(-303L, 0L);
          com.tencent.mm.plugin.fts.a.e.swU.sxa = PluginFTS.access$100(this.svX).Q(-304L, 0L);
          long l1 = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().Q(-300L, 0L);
          long l2 = System.currentTimeMillis();
          if (!com.tencent.mm.plugin.fts.a.d.S(l1, l2))
          {
            com.tencent.mm.plugin.fts.a.e.cKu();
            ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().R(-300L, l2);
          }
          for (;;)
          {
            afX("reportData");
            AppMethodBeat.o(52577);
            return true;
            ac.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
          }
          j += 1;
        }
      }
    }
    catch (Exception localException1)
    {
      com.tencent.mm.plugin.fts.a.e.Fy(26);
      ac.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException1, localException1.getMessage(), new Object[0]);
      afX("t2s");
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
          com.tencent.mm.plugin.fts.a.g.sxv.afZ(arrayOfString5);
          j += 1;
        }
        com.tencent.mm.plugin.fts.a.g.sxw.put(arrayOfString3, arrayOfString4);
      }
      i += 1;
    }
  }
  
  public final String getName()
  {
    return "InitResourceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.a
 * JD-Core Version:    0.7.0.1
 */