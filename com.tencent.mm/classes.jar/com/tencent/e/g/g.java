package com.tencent.e.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
{
  public a LUK;
  HashMap<String, Object> cDF;
  
  public g(a parama)
  {
    AppMethodBeat.i(183329);
    this.cDF = new HashMap();
    this.LUK = parama;
    AppMethodBeat.o(183329);
  }
  
  public final int fVK()
  {
    AppMethodBeat.i(183330);
    int i = this.LUK.LUM.get();
    AppMethodBeat.o(183330);
    return i;
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(183334);
    paramString = this.cDF.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183334);
      return paramLong;
    }
    paramLong = ((Long)paramString).longValue();
    AppMethodBeat.o(183334);
    return paramLong;
  }
  
  public final void hb(String paramString, int paramInt)
  {
    AppMethodBeat.i(183332);
    this.LUK.LUL.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(183332);
  }
  
  public final int hc(String paramString, int paramInt)
  {
    AppMethodBeat.i(183333);
    paramString = this.LUK.LUL.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183333);
      return paramInt;
    }
    paramInt = ((Integer)paramString).intValue();
    AppMethodBeat.o(183333);
    return paramInt;
  }
  
  public final void put(String paramString, long paramLong)
  {
    AppMethodBeat.i(183331);
    this.cDF.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(183331);
  }
  
  public static final class a
  {
    public ConcurrentHashMap<String, Object> LUL;
    public AtomicInteger LUM;
    public String key;
    
    public a(String paramString, AtomicInteger paramAtomicInteger)
    {
      AppMethodBeat.i(183328);
      this.LUL = new ConcurrentHashMap();
      this.key = paramString;
      this.LUM = paramAtomicInteger;
      AppMethodBeat.o(183328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.g
 * JD-Core Version:    0.7.0.1
 */