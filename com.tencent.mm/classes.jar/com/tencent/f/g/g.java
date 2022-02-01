package com.tencent.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
{
  public a RUb;
  HashMap<String, Object> map;
  
  public g(a parama)
  {
    AppMethodBeat.i(183329);
    this.map = new HashMap();
    this.RUb = parama;
    AppMethodBeat.o(183329);
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(183334);
    paramString = this.map.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183334);
      return paramLong;
    }
    paramLong = ((Long)paramString).longValue();
    AppMethodBeat.o(183334);
    return paramLong;
  }
  
  public final void hE(String paramString, int paramInt)
  {
    AppMethodBeat.i(183332);
    this.RUb.RUc.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(183332);
  }
  
  public final int hF(String paramString, int paramInt)
  {
    AppMethodBeat.i(183333);
    paramString = this.RUb.RUc.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183333);
      return paramInt;
    }
    paramInt = ((Integer)paramString).intValue();
    AppMethodBeat.o(183333);
    return paramInt;
  }
  
  public final int hmu()
  {
    AppMethodBeat.i(183330);
    int i = this.RUb.RUd.get();
    AppMethodBeat.o(183330);
    return i;
  }
  
  public final void put(String paramString, long paramLong)
  {
    AppMethodBeat.i(183331);
    this.map.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(183331);
  }
  
  public static final class a
  {
    public ConcurrentHashMap<String, Object> RUc;
    public AtomicInteger RUd;
    public String key;
    
    public a(String paramString, AtomicInteger paramAtomicInteger)
    {
      AppMethodBeat.i(183328);
      this.RUc = new ConcurrentHashMap();
      this.key = paramString;
      this.RUd = paramAtomicInteger;
      AppMethodBeat.o(183328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.g.g
 * JD-Core Version:    0.7.0.1
 */