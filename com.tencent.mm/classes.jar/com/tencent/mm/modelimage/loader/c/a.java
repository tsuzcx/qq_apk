package com.tencent.mm.modelimage.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import java.util.Map;

public final class a<K, V>
{
  public f<K, V> nsn;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(130425);
    this.nsn = new c(paramInt);
    AppMethodBeat.o(130425);
  }
  
  public final boolean check(K paramK)
  {
    try
    {
      AppMethodBeat.i(130426);
      if (this.nsn == null)
      {
        paramK = new NullPointerException("mData == null");
        AppMethodBeat.o(130426);
        throw paramK;
      }
    }
    finally {}
    boolean bool = this.nsn.check(paramK);
    AppMethodBeat.o(130426);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(239012);
    if (this.nsn == null)
    {
      NullPointerException localNullPointerException = new NullPointerException("mData == null");
      AppMethodBeat.o(239012);
      throw localNullPointerException;
    }
    this.nsn.trimToSize(-1);
    AppMethodBeat.o(239012);
  }
  
  public final V get(K paramK)
  {
    AppMethodBeat.i(130427);
    if (this.nsn == null)
    {
      paramK = new NullPointerException("mData == null");
      AppMethodBeat.o(130427);
      throw paramK;
    }
    paramK = this.nsn.get(paramK);
    AppMethodBeat.o(130427);
    return paramK;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(130428);
    if (this.nsn == null)
    {
      paramK = new NullPointerException("mData == null");
      AppMethodBeat.o(130428);
      throw paramK;
    }
    paramK = this.nsn.put(paramK, paramV);
    AppMethodBeat.o(130428);
    return paramK;
  }
  
  public final int size()
  {
    try
    {
      AppMethodBeat.i(239017);
      if (this.nsn == null)
      {
        NullPointerException localNullPointerException = new NullPointerException("mData == null");
        AppMethodBeat.o(239017);
        throw localNullPointerException;
      }
    }
    finally {}
    int i = this.nsn.size();
    AppMethodBeat.o(239017);
    return i;
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      AppMethodBeat.i(130429);
      if (this.nsn == null)
      {
        NullPointerException localNullPointerException = new NullPointerException("mData == null");
        AppMethodBeat.o(130429);
        throw localNullPointerException;
      }
    }
    finally {}
    Map localMap = this.nsn.snapshot();
    AppMethodBeat.o(130429);
    return localMap;
  }
  
  public final String toString()
  {
    try
    {
      AppMethodBeat.i(130430);
      if (this.nsn == null)
      {
        NullPointerException localNullPointerException = new NullPointerException("mData == null");
        AppMethodBeat.o(130430);
        throw localNullPointerException;
      }
    }
    finally {}
    String str = this.nsn.toString();
    AppMethodBeat.o(130430);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.c.a
 * JD-Core Version:    0.7.0.1
 */