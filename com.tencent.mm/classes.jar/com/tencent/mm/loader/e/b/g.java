package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T>
{
  public int height = 0;
  private WeakReference<T> kPl;
  a kPm = a.aSv();
  final int kPn;
  public int width = 0;
  
  public g(T paramT)
  {
    this.kPl = new WeakReference(paramT);
    if (paramT != null)
    {
      this.kPn = paramT.hashCode();
      return;
    }
    this.kPn = hashCode();
  }
  
  public g(T paramT, a parama)
  {
    this.kPl = new WeakReference(paramT);
    if (paramT != null) {}
    for (this.kPn = paramT.hashCode();; this.kPn = hashCode())
    {
      this.kPm = parama;
      return;
    }
  }
  
  public final T get()
  {
    if (this.kPl == null) {
      return null;
    }
    return this.kPl.get();
  }
  
  public final View getView()
  {
    if (this.kPl != null)
    {
      Object localObject = this.kPl.get();
      if ((localObject != null) && ((localObject instanceof View))) {
        return (View)localObject;
      }
    }
    return null;
  }
  
  public final int getViewWidth()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.g
 * JD-Core Version:    0.7.0.1
 */