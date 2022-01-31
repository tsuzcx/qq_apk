package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.ResourcePathMapper;
import java.io.IOException;

public final class a
{
  public static final String lto;
  
  static
  {
    AppMethodBeat.i(2559);
    lto = com.tencent.mm.compatible.util.e.eQw + "bgcut/";
    AppMethodBeat.o(2559);
  }
  
  public static void bnI()
  {
    int m = 0;
    AppMethodBeat.i(2554);
    try
    {
      if (com.tencent.mm.vfs.e.cN("assets:///bgcut/version.txt"))
      {
        i = bo.apV(com.tencent.mm.vfs.e.cS("assets:///bgcut/version.txt"));
        j = m;
        k = i;
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          if (com.tencent.mm.vfs.e.cN(lto + "version.txt"))
          {
            j = bo.apV(com.tencent.mm.vfs.e.cS(lto + "version.txt"));
            k = i;
          }
          if (k > j)
          {
            ab.i("MicroMsg.BgCutSoLogic", "checkFile: version upgrade");
            com.tencent.mm.vfs.e.O(lto, true);
            com.tencent.mm.vfs.e.um(lto);
            com.tencent.mm.vfs.e.C("assets:///bgcut/version.txt", lto + "version.txt");
          }
          if (!com.tencent.mm.vfs.e.cN(lto + "libsegmentern.so")) {
            com.tencent.mm.vfs.e.C("assets:///bgcut/libsegmentern.so", lto + "libsegmentern.so");
          }
          if (!com.tencent.mm.vfs.e.cN(lto + "libsegmentero.so")) {
            com.tencent.mm.vfs.e.C("assets:///bgcut/libsegmentero.so", lto + "libsegmentero.so");
          }
          ResourcePathMapper.setResPath("so3", lto);
          ResourcePathMapper.setResPath("so4", lto);
          ResourcePathMapper.setResPath("model5", "assets://");
          AppMethodBeat.o(2554);
          return;
        }
        catch (IOException localIOException2)
        {
          int j;
          int k;
          continue;
        }
        localIOException1 = localIOException1;
        int i = 0;
        ab.printErrStackTrace("MicroMsg.BgCutSoLogic", localIOException1, "", new Object[0]);
        j = m;
        k = i;
        continue;
        i = 0;
      }
    }
  }
  
  public static void bnJ()
  {
    AppMethodBeat.i(2555);
    ResourcePathMapper.setResPath("so3", null);
    ResourcePathMapper.setResPath("so4", null);
    ResourcePathMapper.setResPath("model5", null);
    AppMethodBeat.o(2555);
  }
  
  public static void bnK()
  {
    AppMethodBeat.i(2556);
    int i = as.apq("emoji_segment_so").getInt("load_start", 0);
    as.apq("emoji_segment_so").putInt("load_start", i + 1);
    as.apq("emoji_segment_so").commit();
    ab.i("MicroMsg.BgCutSoLogic", "markStart:%s", new Object[] { Integer.valueOf(i + 1) });
    AppMethodBeat.o(2556);
  }
  
  public static void bnL()
  {
    AppMethodBeat.i(2557);
    int i = as.apq("emoji_segment_so").getInt("load_start", 0);
    as.apq("emoji_segment_so").putInt("load_end", i);
    as.apq("emoji_segment_so").commit();
    ab.i("MicroMsg.BgCutSoLogic", "markEnd:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(2557);
  }
  
  public static boolean bnM()
  {
    int i = 5;
    AppMethodBeat.i(2558);
    int k = as.apq("emoji_segment_so").getInt("load_start", 0);
    int m = as.apq("emoji_segment_so").getInt("load_end", 0);
    try
    {
      int j = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVn, 5);
      i = j;
    }
    catch (Exception localException)
    {
      label52:
      boolean bool;
      break label52;
    }
    if (k - m <= i) {}
    for (bool = true;; bool = false)
    {
      ab.i("MicroMsg.BgCutSoLogic", "checkManualStart: %s, %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if (!bool)
      {
        d locald = d.ltx;
        d.bot();
      }
      AppMethodBeat.o(2558);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a
 * JD-Core Version:    0.7.0.1
 */