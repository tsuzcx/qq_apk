package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;

public final class j
  implements at
{
  private static j kHf;
  public HashSet<String> kGS;
  public long kGr;
  public long kGs;
  public long kGt;
  public HashMap<String, Long> kHe;
  
  public static long bgJ()
  {
    AppMethodBeat.i(18723);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(e.eQx);
      l = localStatFs.getBlockCount();
      int i = localStatFs.getBlockSize();
      l = i * l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = 0L;
      }
      AppMethodBeat.o(18723);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(18723);
      return 1L;
    }
    return l;
  }
  
  public static long bgK()
  {
    AppMethodBeat.i(18724);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(e.eQx);
      l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      l = i * l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = 0L;
      }
      AppMethodBeat.o(18724);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(18724);
      return 1L;
    }
    return l;
  }
  
  public static j bhb()
  {
    AppMethodBeat.i(18718);
    if (kHf == null) {
      kHf = new j();
    }
    j localj = kHf;
    AppMethodBeat.o(18718);
    return localj;
  }
  
  public static void bhc()
  {
    AppMethodBeat.i(18725);
    b.bak().bam();
    AppMethodBeat.o(18725);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(18719);
    d.bgV();
    AppMethodBeat.o(18719);
  }
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(18720);
    ab.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    b.bak().onAccountInitialized(null);
    AppMethodBeat.o(18720);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(18722);
    ab.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.kGr = 0L;
    this.kGs = 0L;
    this.kGt = 0L;
    if (this.kHe != null) {
      this.kHe.clear();
    }
    if (this.kGS != null) {
      this.kGS.clear();
    }
    d.bgV();
    b.bak().onAccountRelease();
    AppMethodBeat.o(18722);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(18721);
    ab.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(18721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.j
 * JD-Core Version:    0.7.0.1
 */