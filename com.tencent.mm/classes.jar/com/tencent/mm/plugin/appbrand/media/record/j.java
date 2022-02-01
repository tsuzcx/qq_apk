package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class j
{
  private static b lsO;
  
  static
  {
    AppMethodBeat.i(146336);
    lsO = new a();
    AppMethodBeat.o(146336);
  }
  
  public static void a(b paramb)
  {
    lsO = paramb;
  }
  
  public static void boV()
  {
    AppMethodBeat.i(146333);
    lsO.oQ(0L);
    AppMethodBeat.o(146333);
  }
  
  public static void tX(int paramInt)
  {
    AppMethodBeat.i(146334);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(689);
    localIDKey1.SetKey(1);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(689);
    localIDKey2.SetKey(i.tW(paramInt));
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    lsO.D(localArrayList);
    AppMethodBeat.o(146334);
  }
  
  public static void tY(int paramInt)
  {
    AppMethodBeat.i(146335);
    lsO.oQ(i.tW(paramInt));
    AppMethodBeat.o(146335);
  }
  
  static final class a
    implements j.b
  {
    public final void D(ArrayList<IDKey> paramArrayList)
    {
      AppMethodBeat.i(146332);
      ac.v("Luggage.RecordStat", "lstIdKeyDataInfos:%s, isImportant:%b", new Object[] { paramArrayList, Boolean.TRUE });
      AppMethodBeat.o(146332);
    }
    
    public final void oQ(long paramLong)
    {
      AppMethodBeat.i(146331);
      ac.v("Luggage.RecordStat", "ID:%d, key:%d, val:%d, isImportant:%b", new Object[] { Long.valueOf(689L), Long.valueOf(paramLong), Long.valueOf(1L), Boolean.TRUE });
      AppMethodBeat.o(146331);
    }
  }
  
  public static abstract interface b
  {
    public abstract void D(ArrayList<IDKey> paramArrayList);
    
    public abstract void oQ(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.j
 * JD-Core Version:    0.7.0.1
 */