package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class d
  implements aw
{
  private static d nNO;
  public long cacheSize;
  public HashMap<String, Long> nNM;
  public HashSet<String> nNN;
  public long nNw;
  public long nNx;
  public long nNy;
  public LinkedList<String> npF;
  
  public static d bNS()
  {
    AppMethodBeat.i(22827);
    if (nNO == null) {
      nNO = new d();
    }
    d locald = nNO;
    AppMethodBeat.o(22827);
    return locald;
  }
  
  public static long bNT()
  {
    AppMethodBeat.i(22832);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.aib());
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
  
  public static long bNU()
  {
    AppMethodBeat.i(22833);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.aib());
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
  
  public static void bNV()
  {
    AppMethodBeat.i(22834);
    com.tencent.mm.plugin.f.b.bHc().bHe();
    AppMethodBeat.o(22834);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(22828);
    a.bNQ();
    AppMethodBeat.o(22828);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22829);
    ad.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.f.b.bHc().onAccountInitialized(null);
    AppMethodBeat.o(22829);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22831);
    ad.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.nNw = 0L;
    this.nNx = 0L;
    this.nNy = 0L;
    if (this.nNM != null) {
      this.nNM.clear();
    }
    if (this.nNN != null) {
      this.nNN.clear();
    }
    a.bNQ();
    com.tencent.mm.plugin.f.b.bHc().onAccountRelease();
    AppMethodBeat.o(22831);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(22830);
    ad.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(22830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */