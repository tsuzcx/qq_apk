package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements bd
{
  private static d qpN;
  public long cacheSize;
  public long dataSize;
  public LinkedList<String> pQk;
  public List<Runnable> pQl;
  public long qpK;
  public HashMap<String, Long> qpL;
  public HashSet<String> qpM;
  public long qpu;
  public long qpv;
  
  private d()
  {
    AppMethodBeat.i(231658);
    this.pQl = new ArrayList();
    AppMethodBeat.o(231658);
  }
  
  public static d cyM()
  {
    AppMethodBeat.i(22827);
    if (qpN == null) {
      qpN = new d();
    }
    d locald = qpN;
    AppMethodBeat.o(22827);
    return locald;
  }
  
  public static long cyN()
  {
    AppMethodBeat.i(22832);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.aKD());
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
    Log.i("MicroMsg.SubCoreClean", "getSdcardFullSize:%d", new Object[] { Long.valueOf(l) });
    if (l <= 0L)
    {
      AppMethodBeat.o(22832);
      return 1L;
    }
    return l;
  }
  
  public static long cyO()
  {
    AppMethodBeat.i(22833);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.aKD());
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
  
  public static void cyP()
  {
    AppMethodBeat.i(22834);
    com.tencent.mm.plugin.f.b.crW().crY();
    AppMethodBeat.o(22834);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(22828);
    a.cyK();
    AppMethodBeat.o(22828);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22829);
    Log.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.f.b.crW().onAccountInitialized(null);
    AppMethodBeat.o(22829);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22831);
    Log.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.qpK = 0L;
    this.dataSize = 0L;
    this.qpu = 0L;
    this.qpv = 0L;
    if (this.qpL != null) {
      this.qpL.clear();
    }
    if (this.qpM != null) {
      this.qpM.clear();
    }
    a.cyK();
    com.tencent.mm.plugin.f.b.crW().onAccountRelease();
    AppMethodBeat.o(22831);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(22830);
    Log.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(22830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */