package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements am.a
{
  f$1(f paramf) {}
  
  public final boolean tC()
  {
    p localp = q.oG(this.eJY.fileName);
    if ((localp == null) || (!localp.Tk()))
    {
      y.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.eJY.fileName);
      this.eJY.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      this.eJY.dmL.onSceneEnd(3, -1, "doScene failed", this.eJY);
    }
    do
    {
      return false;
      if ((3 != localp.status) && (8 != localp.status))
      {
        long l = System.currentTimeMillis();
        if (l / 1000L - localp.eHF > 30L)
        {
          y.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + this.eJY.fileName);
          this.eJY.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          this.eJY.dmL.onSceneEnd(3, -1, "doScene failed", this.eJY);
          return false;
        }
        if (l - this.eJY.eJX < 2000L)
        {
          y.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + this.eJY.fileName + " but last send time:" + (l - this.eJY.eJX));
          return true;
        }
        g localg = q.ox(this.eJY.fileName).bz(localp.eGk, 6000);
        y.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + this.eJY.fileName + " readByte:" + localg.bDu + " stat:" + localp.status);
        if (localg.bDu < 2000) {
          return true;
        }
      }
    } while (this.eJY.a(this.eJY.edc, this.eJY.dmL) != -1);
    this.eJY.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
    this.eJY.dmL.onSceneEnd(3, -1, "doScene failed", this.eJY);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.f.1
 * JD-Core Version:    0.7.0.1
 */