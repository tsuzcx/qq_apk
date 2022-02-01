package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class a<T>
{
  private final ThreadLocal<T> a;
  private final a<T> b;
  private WeakReference<T> c;
  
  public a(a<T> parama)
  {
    AppMethodBeat.i(14741);
    this.a = new ThreadLocal();
    this.c = new WeakReference(null);
    this.b = parama;
    AppMethodBeat.o(14741);
  }
  
  private T b()
  {
    AppMethodBeat.i(14743);
    Object localObject3 = this.c.get();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = this.c.get();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = this.b.a();
        this.c = new WeakReference(localObject1);
      }
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(14743);
    }
  }
  
  public T a()
  {
    AppMethodBeat.i(14742);
    Object localObject2 = this.a.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = b();
      this.a.set(localObject1);
    }
    AppMethodBeat.o(14742);
    return localObject1;
  }
  
  public static abstract interface a<T>
  {
    public abstract T a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.util.a
 * JD-Core Version:    0.7.0.1
 */