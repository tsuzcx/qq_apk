package com.tencent.mm.av.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import java.util.Map;

public final class a<K, V>
{
  public f<K, V> gMv;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(130425);
    this.gMv = new c(paramInt);
    AppMethodBeat.o(130425);
  }
  
  public final boolean aK(K paramK)
  {
    try
    {
      AppMethodBeat.i(130426);
      if (this.gMv == null)
      {
        paramK = new NullPointerException("mData == null");
        AppMethodBeat.o(130426);
        throw paramK;
      }
    }
    finally {}
    boolean bool = this.gMv.aK(paramK);
    AppMethodBeat.o(130426);
    return bool;
  }
  
  public final V get(K paramK)
  {
    AppMethodBeat.i(130427);
    if (this.gMv == null)
    {
      paramK = new NullPointerException("mData == null");
      AppMethodBeat.o(130427);
      throw paramK;
    }
    paramK = this.gMv.get(paramK);
    AppMethodBeat.o(130427);
    return paramK;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(130428);
    if (this.gMv == null)
    {
      paramK = new NullPointerException("mData == null");
      AppMethodBeat.o(130428);
      throw paramK;
    }
    paramK = this.gMv.put(paramK, paramV);
    AppMethodBeat.o(130428);
    return paramK;
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      AppMethodBeat.i(130429);
      if (this.gMv == null)
      {
        NullPointerException localNullPointerException = new NullPointerException("mData == null");
        AppMethodBeat.o(130429);
        throw localNullPointerException;
      }
    }
    finally {}
    Map localMap = this.gMv.snapshot();
    AppMethodBeat.o(130429);
    return localMap;
  }
  
  public final String toString()
  {
    try
    {
      AppMethodBeat.i(130430);
      if (this.gMv == null)
      {
        NullPointerException localNullPointerException = new NullPointerException("mData == null");
        AppMethodBeat.o(130430);
        throw localNullPointerException;
      }
    }
    finally {}
    String str = this.gMv.toString();
    AppMethodBeat.o(130430);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.a.d.a
 * JD-Core Version:    0.7.0.1
 */