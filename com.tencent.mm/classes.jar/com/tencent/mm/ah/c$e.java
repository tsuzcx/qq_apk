package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;

final class c$e
  implements az.a
{
  Bitmap bitmap = null;
  byte[] buf;
  h frB = null;
  
  public c$e(c paramc, h paramh, byte[] paramArrayOfByte)
  {
    this.frB = paramh;
    this.buf = paramArrayOfByte;
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(77860);
    if ((this.frB == null) || (bo.isNullOrNil(this.frB.getUsername())))
    {
      ab.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 13L, 1L, true);
      AppMethodBeat.o(77860);
      return false;
    }
    if (c.acQ() != null)
    {
      this.bitmap = d.m(this.frB.getUsername(), this.buf);
      if (this.bitmap == null) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 14L, 1L, true);
      }
    }
    i locali = c.acR();
    if (locali != null)
    {
      this.frB.bsY = -1;
      this.frB.acZ();
      locali.b(this.frB);
    }
    AppMethodBeat.o(77860);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(77861);
    if (bo.isNullOrNil(this.frB.getUsername()))
    {
      AppMethodBeat.o(77861);
      return false;
    }
    d locald = c.acQ();
    if ((locald != null) && (this.bitmap != null)) {
      locald.e(this.frB.getUsername(), this.bitmap);
    }
    this.fry.frq.remove(this.frB.getUsername());
    AppMethodBeat.o(77861);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ah.c.e
 * JD-Core Version:    0.7.0.1
 */