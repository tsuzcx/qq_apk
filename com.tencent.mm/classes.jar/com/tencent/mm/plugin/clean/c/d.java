package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements az
{
  private static d paP;
  public long cacheSize;
  public long dataSize;
  public LinkedList<String> oCB;
  public List<Runnable> oCC;
  public long paM;
  public HashMap<String, Long> paN;
  public HashSet<String> paO;
  public long paw;
  public long pax;
  
  private d()
  {
    AppMethodBeat.i(186437);
    this.oCC = new ArrayList();
    AppMethodBeat.o(186437);
  }
  
  public static d caX()
  {
    AppMethodBeat.i(22827);
    if (paP == null) {
      paP = new d();
    }
    d locald = paP;
    AppMethodBeat.o(22827);
    return locald;
  }
  
  public static long caY()
  {
    AppMethodBeat.i(22832);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.asd());
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
  
  public static long caZ()
  {
    AppMethodBeat.i(22833);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.asd());
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
  
  public static void cba()
  {
    AppMethodBeat.i(22834);
    com.tencent.mm.plugin.f.b.bUj().bUl();
    AppMethodBeat.o(22834);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(22828);
    a.caV();
    AppMethodBeat.o(22828);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22829);
    ae.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.f.b.bUj().onAccountInitialized(null);
    AppMethodBeat.o(22829);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22831);
    ae.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.paM = 0L;
    this.dataSize = 0L;
    this.paw = 0L;
    this.pax = 0L;
    if (this.paN != null) {
      this.paN.clear();
    }
    if (this.paO != null) {
      this.paO.clear();
    }
    a.caV();
    com.tencent.mm.plugin.f.b.bUj().onAccountRelease();
    AppMethodBeat.o(22831);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(22830);
    ae.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(22830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */