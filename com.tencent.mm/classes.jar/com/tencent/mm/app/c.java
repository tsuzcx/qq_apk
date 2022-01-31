package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;

final class c
  implements i.a
{
  private Bitmap bwa = null;
  d bwb;
  
  public final void a(i parami)
  {
    if ((parami instanceof d.a)) {
      o.JQ().a((d.a)parami);
    }
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return b.c(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public final Bitmap ch(String paramString)
  {
    return b.a(paramString, false, -1);
  }
  
  public final Bitmap ci(String paramString)
  {
    if (this.bwb == null) {
      this.bwb = o.JQ();
    }
    return d.kf(paramString);
  }
  
  public final Bitmap sG()
  {
    return this.bwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */