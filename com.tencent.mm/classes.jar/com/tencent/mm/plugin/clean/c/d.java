package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
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
  private static d tOv;
  public long bcy;
  public List<Map.Entry<String, Long>> pWR;
  public LinkedList<String> sXl;
  public long sXm;
  public List<Runnable> sXn;
  public long tOd;
  public long tOe;
  public long tOt;
  public HashSet<String> tOu;
  
  private d()
  {
    AppMethodBeat.i(223810);
    this.sXn = new ArrayList();
    AppMethodBeat.o(223810);
  }
  
  public static d cNh()
  {
    AppMethodBeat.i(22827);
    if (tOv == null) {
      tOv = new d();
    }
    d locald = tOv;
    AppMethodBeat.o(22827);
    return locald;
  }
  
  public static long cNi()
  {
    AppMethodBeat.i(22832);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(b.aSF());
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
  
  public static long cNj()
  {
    AppMethodBeat.i(22833);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(b.aSF());
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
  
  public static void cNk()
  {
    AppMethodBeat.i(22834);
    com.tencent.mm.plugin.h.a.cFg().cFi();
    AppMethodBeat.o(22834);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(22828);
    a.cNf();
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
    com.tencent.mm.plugin.h.a.cFg().onAccountInitialized(null);
    AppMethodBeat.o(22829);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22831);
    Log.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.tOt = 0L;
    this.bcy = 0L;
    this.tOd = 0L;
    this.tOe = 0L;
    if (this.pWR != null) {
      this.pWR.clear();
    }
    if (this.tOu != null) {
      this.tOu.clear();
    }
    a.cNf();
    com.tencent.mm.plugin.h.a.cFg().onAccountRelease();
    AppMethodBeat.o(22831);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(22830);
    Log.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(22830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */