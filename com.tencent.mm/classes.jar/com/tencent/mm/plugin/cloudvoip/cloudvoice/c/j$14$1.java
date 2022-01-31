package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.ase;
import com.tencent.mm.sdk.platformtools.y;

final class j$14$1
  implements Runnable
{
  j$14$1(j.14 param14, int paramInt1, int paramInt2, b paramb, String paramString) {}
  
  public final void run()
  {
    if ((this.bEf != 0) || (this.bEg != 0) || (this.eew.ecF.ecN == null))
    {
      y.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: getroomId fail, errType:" + this.bEf + ",errCode:" + this.bEg);
      j.a(this.iGg.iFU, this.iGg.iFY, this.bEf, this.bEg, "join room failed " + this.edL);
      return;
    }
    long l = ((ase)this.eew.ecF.ecN).sPi;
    j.a(this.iGg.iFU, l, this.iGg.iFY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.14.1
 * JD-Core Version:    0.7.0.1
 */