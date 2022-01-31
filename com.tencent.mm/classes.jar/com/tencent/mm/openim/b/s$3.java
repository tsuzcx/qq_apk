package com.tencent.mm.openim.b;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;

final class s$3
  implements g
{
  s$3(s params, s.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    if ((paramb.status == 0) && (paramb.bitmap != null) && (!paramb.bitmap.isRecycled())) {
      this.eQf.bitmap = paramb.bitmap;
    }
  }
  
  public final void mv(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openim.b.s.3
 * JD-Core Version:    0.7.0.1
 */