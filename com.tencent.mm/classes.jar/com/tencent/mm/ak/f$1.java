package com.tencent.mm.ak;

import com.tencent.mm.ah.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements c
{
  f$1(f paramf) {}
  
  public final void a(ld paramld1, ld paramld2, ld paramld3)
  {
    y.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + paramld1.toString() + " getCore().engine:" + f.Ne());
    if (f.Ne() != null)
    {
      f.Ne().a(paramld1, paramld2, paramld3, null, null, null);
      g.DS().O(new f.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ak.f.1
 * JD-Core Version:    0.7.0.1
 */