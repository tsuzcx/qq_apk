package com.tencent.luggage.bridge.a;

import com.tencent.luggage.a.b;
import com.tencent.luggage.a.d;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static b cgW;
  
  public static abstract interface a
    extends a.c
  {}
  
  public static abstract interface b
  {
    public abstract void a(a.a parama);
    
    public abstract void a(a.c paramc);
  }
  
  public static abstract interface c
  {
    public abstract <T extends b> void a(Class<T> paramClass, T paramT);
    
    public abstract <T extends d> void a(Class<T> paramClass, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.bridge.a.a
 * JD-Core Version:    0.7.0.1
 */