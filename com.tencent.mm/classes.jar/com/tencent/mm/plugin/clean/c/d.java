package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class d
  implements ax
{
  private static d oUm;
  public long cacheSize;
  public long dataSize;
  public long oTU;
  public long oTV;
  public long oUj;
  public HashMap<String, Long> oUk;
  public HashSet<String> oUl;
  public LinkedList<String> owa;
  
  public static d bZI()
  {
    AppMethodBeat.i(22827);
    if (oUm == null) {
      oUm = new d();
    }
    d locald = oUm;
    AppMethodBeat.o(22827);
    return locald;
  }
  
  public static long bZJ()
  {
    AppMethodBeat.i(22832);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.arO());
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
  
  public static long bZK()
  {
    AppMethodBeat.i(22833);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.arO());
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
  
  public static void bZL()
  {
    AppMethodBeat.i(22834);
    com.tencent.mm.plugin.f.b.bSU().bSW();
    AppMethodBeat.o(22834);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(22828);
    a.bZG();
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
    com.tencent.mm.plugin.f.b.bSU().onAccountInitialized(null);
    AppMethodBeat.o(22829);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22831);
    ad.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.oUj = 0L;
    this.dataSize = 0L;
    this.oTU = 0L;
    this.oTV = 0L;
    if (this.oUk != null) {
      this.oUk.clear();
    }
    if (this.oUl != null) {
      this.oUl.clear();
    }
    a.bZG();
    com.tencent.mm.plugin.f.b.bSU().onAccountRelease();
    AppMethodBeat.o(22831);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(22830);
    ad.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(22830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d
 * JD-Core Version:    0.7.0.1
 */