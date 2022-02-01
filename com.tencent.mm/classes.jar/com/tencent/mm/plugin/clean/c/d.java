package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class d
  implements aw
{
  private static d oqQ;
  public long cacheSize;
  public LinkedList<String> nSF;
  public long oqA;
  public HashMap<String, Long> oqO;
  public HashSet<String> oqP;
  public long oqy;
  public long oqz;
  
  public static d bVd()
  {
    AppMethodBeat.i(22827);
    if (oqQ == null) {
      oqQ = new d();
    }
    d locald = oqQ;
    AppMethodBeat.o(22827);
    return locald;
  }
  
  public static long bVe()
  {
    AppMethodBeat.i(22832);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.apb());
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
      AppMethodBeat.o(22832);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(22832);
      return 1L;
    }
    return l;
  }
  
  public static long bVf()
  {
    AppMethodBeat.i(22833);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.apb());
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
      AppMethodBeat.o(22833);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(22833);
      return 1L;
    }
    return l;
  }
  
  public static void bVg()
  {
    AppMethodBeat.i(22834);
    com.tencent.mm.plugin.f.b.bOp().bOr();
    AppMethodBeat.o(22834);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(22828);
    a.bVb();
    AppMethodBeat.o(22828);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22829);
    ac.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.f.b.bOp().onAccountInitialized(null);
    AppMethodBeat.o(22829);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22831);
    ac.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.oqy = 0L;
    this.oqz = 0L;
    this.oqA = 0L;
    if (this.oqO != null) {
      this.oqO.clear();
    }
    if (this.oqP != null) {
      this.oqP.clear();
    }
    a.bVb();
    com.tencent.mm.plugin.f.b.bOp().onAccountRelease();
    AppMethodBeat.o(22831);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(22830);
    ac.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(22830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */