package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class j
{
  private static b nea;
  
  static
  {
    AppMethodBeat.i(146336);
    nea = new j.a();
    AppMethodBeat.o(146336);
  }
  
  public static void a(b paramb)
  {
    nea = paramb;
  }
  
  public static void bPi()
  {
    AppMethodBeat.i(146333);
    nea.yU(0L);
    AppMethodBeat.o(146333);
  }
  
  public static void yy(int paramInt)
  {
    AppMethodBeat.i(146334);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(689);
    localIDKey1.SetKey(1);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(689);
    localIDKey2.SetKey(i.yx(paramInt));
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    nea.J(localArrayList);
    AppMethodBeat.o(146334);
  }
  
  public static void yz(int paramInt)
  {
    AppMethodBeat.i(146335);
    nea.yU(i.yx(paramInt));
    AppMethodBeat.o(146335);
  }
  
  public static abstract interface b
  {
    public abstract void J(ArrayList<IDKey> paramArrayList);
    
    public abstract void yU(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.j
 * JD-Core Version:    0.7.0.1
 */