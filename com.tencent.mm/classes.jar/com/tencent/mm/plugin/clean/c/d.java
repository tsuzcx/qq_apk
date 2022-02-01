package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.be;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public final class d
  implements be
{
  private static d wRL;
  public long cWt;
  public List<Map.Entry<String, Long>> tbH;
  public long wRJ;
  public HashSet<String> wRK;
  public long wRt;
  public long wRu;
  public LinkedList<String> wbC;
  public long wbD;
  public List<Runnable> wbE;
  
  private d()
  {
    AppMethodBeat.i(271846);
    this.wbE = new ArrayList();
    AppMethodBeat.o(271846);
  }
  
  public static d dqN()
  {
    AppMethodBeat.i(22827);
    if (wRL == null) {
      wRL = new d();
    }
    d locald = wRL;
    AppMethodBeat.o(22827);
    return locald;
  }
  
  public static long dqO()
  {
    AppMethodBeat.i(22832);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(b.bmt());
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
  
  public static long dqP()
  {
    AppMethodBeat.i(22833);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(b.bmt());
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
  
  public static void dqQ()
  {
    AppMethodBeat.i(22834);
    com.tencent.mm.plugin.calcwx.a.diz().diB();
    AppMethodBeat.o(22834);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(22828);
    a.dqL();
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
    com.tencent.mm.plugin.calcwx.a.diz().onAccountInitialized(null);
    AppMethodBeat.o(22829);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22831);
    Log.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.wRJ = 0L;
    this.cWt = 0L;
    this.wRt = 0L;
    this.wRu = 0L;
    if (this.tbH != null) {
      this.tbH.clear();
    }
    if (this.wRK != null) {
      this.wRK.clear();
    }
    a.dqL();
    com.tencent.mm.plugin.calcwx.a.diz().onAccountRelease();
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