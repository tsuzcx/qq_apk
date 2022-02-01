package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class j
{
  private static b tjg;
  
  static
  {
    AppMethodBeat.i(146336);
    tjg = new a();
    AppMethodBeat.o(146336);
  }
  
  public static void Cn(int paramInt)
  {
    AppMethodBeat.i(146334);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(689);
    localIDKey1.SetKey(1);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(689);
    localIDKey2.SetKey(i.Cm(paramInt));
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    tjg.O(localArrayList);
    AppMethodBeat.o(146334);
  }
  
  public static void Co(int paramInt)
  {
    AppMethodBeat.i(146335);
    tjg.hp(i.Cm(paramInt));
    AppMethodBeat.o(146335);
  }
  
  public static void a(b paramb)
  {
    tjg = paramb;
  }
  
  public static void cBS()
  {
    AppMethodBeat.i(146333);
    tjg.hp(0L);
    AppMethodBeat.o(146333);
  }
  
  static final class a
    implements j.b
  {
    public final void O(ArrayList<IDKey> paramArrayList)
    {
      AppMethodBeat.i(146332);
      Log.v("Luggage.RecordStat", "lstIdKeyDataInfos:%s, isImportant:%b", new Object[] { paramArrayList, Boolean.TRUE });
      AppMethodBeat.o(146332);
    }
    
    public final void hp(long paramLong)
    {
      AppMethodBeat.i(146331);
      Log.v("Luggage.RecordStat", "ID:%d, key:%d, val:%d, isImportant:%b", new Object[] { Long.valueOf(689L), Long.valueOf(paramLong), Long.valueOf(1L), Boolean.TRUE });
      AppMethodBeat.o(146331);
    }
  }
  
  public static abstract interface b
  {
    public abstract void O(ArrayList<IDKey> paramArrayList);
    
    public abstract void hp(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.j
 * JD-Core Version:    0.7.0.1
 */