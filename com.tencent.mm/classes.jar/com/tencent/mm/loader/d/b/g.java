package com.tencent.mm.loader.d.b;

import android.view.View;
import com.tencent.mm.loader.g.a.a;
import java.lang.ref.WeakReference;

public class g<T>
{
  public int height = 0;
  WeakReference<T> nqO;
  a nqP = a.bmj();
  final int nqQ;
  public int width = 0;
  
  public g(T paramT)
  {
    this.nqO = new WeakReference(paramT);
    if (paramT != null)
    {
      this.nqQ = paramT.hashCode();
      return;
    }
    this.nqQ = hashCode();
  }
  
  public g(T paramT, a parama)
  {
    this.nqO = new WeakReference(paramT);
    if (paramT != null) {}
    for (this.nqQ = paramT.hashCode();; this.nqQ = hashCode())
    {
      this.nqP = parama;
      return;
    }
  }
  
  public final View getView()
  {
    if (this.nqO != null)
    {
      Object localObject = this.nqO.get();
      if ((localObject != null) && ((localObject instanceof View))) {
        return (View)localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.b.g
 * JD-Core Version:    0.7.0.1
 */