package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class j
  extends k
{
  private static volatile j hbd = null;
  
  public static j axa()
  {
    AppMethodBeat.i(129551);
    if (hbd == null) {}
    try
    {
      if (hbd == null) {
        hbd = new j();
      }
      j localj = hbd;
      AppMethodBeat.o(129551);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(129551);
    }
  }
  
  public static boolean axb()
  {
    AppMethodBeat.i(129553);
    if (!g.RG())
    {
      AppMethodBeat.o(129553);
      return false;
    }
    boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yCP, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129553);
    return bool;
  }
  
  public static void release()
  {
    hbd = null;
  }
  
  public final void a(long paramLong, boolean paramBoolean, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129552);
    m.aNS().ac(new j.3(this, paramInt1, paramInt2, paramBoolean, paramLong, paramBundle));
    AppMethodBeat.o(129552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.j
 * JD-Core Version:    0.7.0.1
 */