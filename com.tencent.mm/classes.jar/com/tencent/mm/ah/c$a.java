package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;

final class c$a
  implements az.a
{
  boolean bak;
  h frB;
  byte[] frC;
  byte[] frD;
  
  public c$a(c paramc, h paramh, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.frB = paramh;
    this.frC = paramArrayOfByte;
    this.bak = paramBoolean;
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(77854);
    byte[] arrayOfByte;
    if (this.bak)
    {
      ab.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
      com.tencent.mm.plugin.report.service.h.qsU.cT(138, 51);
      arrayOfByte = UtilsJni.DecryptAvatar(this.frC);
      if (bo.ce(arrayOfByte))
      {
        com.tencent.mm.plugin.report.service.h.qsU.cT(138, 52);
        ab.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
        AppMethodBeat.o(77854);
        return false;
      }
    }
    else
    {
      arrayOfByte = this.frC;
    }
    for (;;)
    {
      if (r.bX(arrayOfByte))
      {
        ab.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
        com.tencent.mm.plugin.report.service.h.qsU.cT(138, 53);
        this.frD = ((com.tencent.mm.plugin.emoji.b.c)g.E(com.tencent.mm.plugin.emoji.b.c.class)).aF(arrayOfByte);
        if (bo.ce(this.frD))
        {
          com.tencent.mm.plugin.report.service.h.qsU.cT(138, 54);
          ab.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
          AppMethodBeat.o(77854);
          return false;
        }
      }
      else
      {
        this.frD = arrayOfByte;
      }
      AppMethodBeat.o(77854);
      return true;
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(77855);
    if (!bo.ce(this.frD))
    {
      ab.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.frD.length) });
      this.fry.a(new c.e(this.fry, this.frB, this.frD));
      AppMethodBeat.o(77855);
      return true;
    }
    ab.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
    AppMethodBeat.o(77855);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ah.c.a
 * JD-Core Version:    0.7.0.1
 */