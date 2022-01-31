package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;

final class t$a
  implements p
{
  private final i aFw = new i(new byte[4]);
  
  public t$a(t paramt) {}
  
  public final void a(com.google.android.exoplayer2.i.q paramq, f paramf, u.d paramd) {}
  
  public final void b(j paramj)
  {
    if (paramj.readUnsignedByte() != 0) {}
    do
    {
      return;
      paramj.dB(7);
      int j = paramj.oe() / 4;
      int i = 0;
      if (i < j)
      {
        paramj.c(this.aFw, 4);
        int k = this.aFw.dz(16);
        this.aFw.dy(3);
        if (k == 0) {
          this.aFw.dy(13);
        }
        for (;;)
        {
          i += 1;
          break;
          k = this.aFw.dz(13);
          t.a(this.aFx).put(k, new q(new t.b(this.aFx, k)));
          t.b(this.aFx);
        }
      }
    } while (t.c(this.aFx) == 2);
    t.a(this.aFx).remove(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.t.a
 * JD-Core Version:    0.7.0.1
 */