package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class j
{
  private static j.b iqb;
  
  static
  {
    AppMethodBeat.i(140656);
    iqb = new a();
    AppMethodBeat.o(140656);
  }
  
  public static void a(j.b paramb)
  {
    iqb = paramb;
  }
  
  public static void aIa()
  {
    AppMethodBeat.i(105642);
    iqb.hB(0L);
    AppMethodBeat.o(105642);
  }
  
  public static void oR(int paramInt)
  {
    AppMethodBeat.i(105643);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(689);
    localIDKey1.SetKey(1);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(689);
    localIDKey2.SetKey(i.oQ(paramInt));
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    iqb.n(localArrayList);
    AppMethodBeat.o(105643);
  }
  
  public static void oS(int paramInt)
  {
    AppMethodBeat.i(105644);
    iqb.hB(i.oQ(paramInt));
    AppMethodBeat.o(105644);
  }
  
  static final class a
    implements j.b
  {
    public final void hB(long paramLong)
    {
      AppMethodBeat.i(140654);
      ab.v("Luggage.RecordStat", "ID:%d, key:%d, val:%d, isImportant:%b", new Object[] { Long.valueOf(689L), Long.valueOf(paramLong), Long.valueOf(1L), Boolean.TRUE });
      AppMethodBeat.o(140654);
    }
    
    public final void n(ArrayList<IDKey> paramArrayList)
    {
      AppMethodBeat.i(140655);
      ab.v("Luggage.RecordStat", "lstIdKeyDataInfos:%s, isImportant:%b", new Object[] { paramArrayList, Boolean.TRUE });
      AppMethodBeat.o(140655);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.j
 * JD-Core Version:    0.7.0.1
 */