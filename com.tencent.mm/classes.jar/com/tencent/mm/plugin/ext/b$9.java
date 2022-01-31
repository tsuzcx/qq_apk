package com.tencent.mm.plugin.ext;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

final class b$9
  implements j.a
{
  b$9(b paramb) {}
  
  public final void a(String paramString, l paraml)
  {
    if (!b.b(this.jJF).contains(paramString)) {
      b.b(this.jJF).add(paramString);
    }
    b.c(this.jJF).removeMessages(0);
    b.c(this.jJF).sendEmptyMessageDelayed(0, 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.9
 * JD-Core Version:    0.7.0.1
 */