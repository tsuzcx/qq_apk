package com.tencent.mm.be;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class a$1
  implements am.a
{
  a$1(a parama) {}
  
  public final boolean tC()
  {
    long l = e.aeQ(this.eBc.filename);
    y.d("MicroMsg.NetSceneUploadMedia", g.zI() + " onTimerExpired: file:" + this.eBc.filename + " nowlen:" + l + " oldoff:" + this.eBc.eBa);
    if (this.eBc.a(this.eBc.edc, this.eBc.dmL) == -1) {
      this.eBc.dmL.onSceneEnd(3, -1, "doScene failed", this.eBc);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.a.1
 * JD-Core Version:    0.7.0.1
 */