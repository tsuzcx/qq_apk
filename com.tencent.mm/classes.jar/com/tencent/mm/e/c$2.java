package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mm.view.b.a.b;

final class c$2
  implements a.b
{
  c$2(c paramc) {}
  
  public final void onStart()
  {
    c.a(this.bAK, false);
    this.bAK.bAy = false;
    c.a(this.bAK);
    com.tencent.mm.z.a.hh(282);
  }
  
  public final void tW()
  {
    this.bAK.bAy = true;
    this.bAK.bzV.coH().getBaseBoardView().m(new Rect(0, 0, this.bAK.bzV.coJ().getWidth(), this.bAK.bzV.coJ().getHeight()));
    c.a(this.bAK, 200L, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.c.2
 * JD-Core Version:    0.7.0.1
 */