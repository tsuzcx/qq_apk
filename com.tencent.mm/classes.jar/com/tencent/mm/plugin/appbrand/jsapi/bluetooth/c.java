package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.a;
import java.util.ArrayList;

public final class c
{
  public static void df(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94180);
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
    ((a)e.r(a.class)).b(localArrayList, true);
    AppMethodBeat.o(94180);
  }
  
  public static void kS(int paramInt)
  {
    AppMethodBeat.i(94179);
    ((a)e.r(a.class)).idkeyStat(762L, paramInt, 1L, false);
    AppMethodBeat.o(94179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c
 * JD-Core Version:    0.7.0.1
 */