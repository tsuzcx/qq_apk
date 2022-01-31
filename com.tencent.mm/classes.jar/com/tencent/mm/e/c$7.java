package com.tencent.mm.e;

import android.graphics.Matrix;
import com.tencent.mm.cache.a;
import com.tencent.mm.view.b.a.b;

public final class c$7
  implements a.b
{
  public c$7(c paramc) {}
  
  public final void onStart()
  {
    c.a(this.bAK, false);
  }
  
  public final void tW()
  {
    this.bAK.getMainMatrix().set(((a)this.bAK.tI()).dkY);
    this.bAK.tR();
    c.a(this.bAK, 300L, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.c.7
 * JD-Core Version:    0.7.0.1
 */