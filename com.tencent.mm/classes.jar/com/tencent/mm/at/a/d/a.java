package com.tencent.mm.at.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import java.util.Map;

public final class a<K, V>
{
  public f<K, V> eQf;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(116095);
    this.eQf = new c(paramInt);
    AppMethodBeat.o(116095);
  }
  
  public final boolean Z(K paramK)
  {
    try
    {
      AppMethodBeat.i(116097);
      if (this.eQf == null)
      {
        paramK = new NullPointerException("mData == null");
        AppMethodBeat.o(116097);
        throw paramK;
      }
    }
    finally {}
    boolean bool = this.eQf.Z(paramK);
    AppMethodBeat.o(116097);
    return bool;
  }
  
  public final V get(K paramK)
  {
    AppMethodBeat.i(116098);
    if (this.eQf == null)
    {
      paramK = new NullPointerException("mData == null");
      AppMethodBeat.o(116098);
      throw paramK;
    }
    paramK = this.eQf.get(paramK);
    AppMethodBeat.o(116098);
    return paramK;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(116099);
    if (this.eQf == null)
    {
      paramK = new NullPointerException("mData == null");
      AppMethodBeat.o(116099);
      throw paramK;
    }
    paramK = this.eQf.put(paramK, paramV);
    AppMethodBeat.o(116099);
    return paramK;
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      AppMethodBeat.i(116100);
      if (this.eQf == null)
      {
        NullPointerException localNullPointerException = new NullPointerException("mData == null");
        AppMethodBeat.o(116100);
        throw localNullPointerException;
      }
    }
    finally {}
    Map localMap = this.eQf.snapshot();
    AppMethodBeat.o(116100);
    return localMap;
  }
  
  public final String toString()
  {
    try
    {
      AppMethodBeat.i(116101);
      if (this.eQf == null)
      {
        NullPointerException localNullPointerException = new NullPointerException("mData == null");
        AppMethodBeat.o(116101);
        throw localNullPointerException;
      }
    }
    finally {}
    String str = this.eQf.toString();
    AppMethodBeat.o(116101);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.at.a.d.a
 * JD-Core Version:    0.7.0.1
 */