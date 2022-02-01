package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.x.a;
import java.util.ArrayList;

public final class h
{
  public static void fr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144492);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(762);
    localIDKey.SetKey(paramInt1);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(762);
    localIDKey.SetKey(paramInt2);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    ((a)e.U(a.class)).b(localArrayList, true);
    AppMethodBeat.o(144492);
  }
  
  public static void rG(int paramInt)
  {
    AppMethodBeat.i(144491);
    ((a)e.U(a.class)).idkeyStat(762L, paramInt, 1L, false);
    AppMethodBeat.o(144491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h
 * JD-Core Version:    0.7.0.1
 */