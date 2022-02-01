package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class j
{
  private static b qer;
  
  static
  {
    AppMethodBeat.i(146336);
    qer = new j.a();
    AppMethodBeat.o(146336);
  }
  
  public static void BY(int paramInt)
  {
    AppMethodBeat.i(146334);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(689);
    localIDKey1.SetKey(1);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(689);
    localIDKey2.SetKey(i.BX(paramInt));
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    qer.K(localArrayList);
    AppMethodBeat.o(146334);
  }
  
  public static void BZ(int paramInt)
  {
    AppMethodBeat.i(146335);
    qer.EW(i.BX(paramInt));
    AppMethodBeat.o(146335);
  }
  
  public static void a(b paramb)
  {
    qer = paramb;
  }
  
  public static void cby()
  {
    AppMethodBeat.i(146333);
    qer.EW(0L);
    AppMethodBeat.o(146333);
  }
  
  public static abstract interface b
  {
    public abstract void EW(long paramLong);
    
    public abstract void K(ArrayList<IDKey> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.j
 * JD-Core Version:    0.7.0.1
 */