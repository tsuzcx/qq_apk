package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T>
{
  private WeakReference<T> gks;
  private a gkt = new a("");
  final int gku;
  public int height = 0;
  public int width = 0;
  
  public g(T paramT)
  {
    this.gks = new WeakReference(paramT);
    if (paramT != null)
    {
      this.gku = paramT.hashCode();
      return;
    }
    this.gku = hashCode();
  }
  
  public final T get()
  {
    if (this.gks == null) {
      return null;
    }
    return this.gks.get();
  }
  
  public final View getView()
  {
    if (this.gks != null)
    {
      Object localObject = this.gks.get();
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