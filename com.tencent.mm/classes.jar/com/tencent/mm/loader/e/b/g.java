package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T>
{
  public int height = 0;
  private WeakReference<T> iaF;
  a iaG = a.aKt();
  final int iaH;
  public int width = 0;
  
  public g(T paramT)
  {
    this.iaF = new WeakReference(paramT);
    if (paramT != null)
    {
      this.iaH = paramT.hashCode();
      return;
    }
    this.iaH = hashCode();
  }
  
  public g(T paramT, a parama)
  {
    this.iaF = new WeakReference(paramT);
    if (paramT != null) {}
    for (this.iaH = paramT.hashCode();; this.iaH = hashCode())
    {
      this.iaG = parama;
      return;
    }
  }
  
  public final T get()
  {
    if (this.iaF == null) {
      return null;
    }
    return this.iaF.get();
  }
  
  public final View getView()
  {
    if (this.iaF != null)
    {
      Object localObject = this.iaF.get();
      if ((localObject != null) && ((localObject instanceof View))) {
        return (View)localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.g
 * JD-Core Version:    0.7.0.1
 */