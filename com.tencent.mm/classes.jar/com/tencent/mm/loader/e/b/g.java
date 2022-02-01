package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T>
{
  private WeakReference<T> gLf;
  private a gLg = new a("");
  final int gLh;
  public int height = 0;
  public int width = 0;
  
  public g(T paramT)
  {
    this.gLf = new WeakReference(paramT);
    if (paramT != null)
    {
      this.gLh = paramT.hashCode();
      return;
    }
    this.gLh = hashCode();
  }
  
  public final T get()
  {
    if (this.gLf == null) {
      return null;
    }
    return this.gLf.get();
  }
  
  public final View getView()
  {
    if (this.gLf != null)
    {
      Object localObject = this.gLf.get();
      if ((localObject != null) && ((localObject instanceof View))) {
        return (View)localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.g
 * JD-Core Version:    0.7.0.1
 */