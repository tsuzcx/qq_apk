package com.tencent.mm.modelvideo;

import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bh;
import java.util.Map;

final class d$2
  implements Runnable
{
  d$2(d paramd, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    Object localObject1 = bn.s(this.eFS.eFM.SD(), "msg");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = o.Sr();
      o.Sr();
      ((t)localObject2).q(t.nS(this.eFS.fileName), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    boolean bool1 = false;
    if (this.eFT)
    {
      boolean bool2 = u.W(this.eFS.fileName, this.eFU);
      bool1 = bool2;
      if (this.eFS.eFL)
      {
        u.oi(this.eFS.fileName);
        y.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
        bool1 = bool2;
      }
      y.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { this.eFS.Sj(), this.eFS.fileName, Long.valueOf(this.eFS.eFM.bXr), this.eFS.eFM.SB(), this.eFS.eFM.SA(), Boolean.valueOf(bool1), this.eFS.eoX, Integer.valueOf(this.eFS.eoY), Boolean.valueOf(this.eFT), Boolean.valueOf(this.eFS.eFQ) });
      if ((!bk.bl(this.eFS.eoX)) && (this.eFS.eoY > 0))
      {
        localObject1 = ((a)g.r(a.class)).FD();
        localObject2 = this.eFS.eoX;
        int i = this.eFS.eoY;
        o.Sr();
        ((bh)localObject1).A((String)localObject2, i, t.nS(this.eFS.fileName));
      }
      if (this.eFS.eFM.eHO != 3) {
        break label535;
      }
      h.nFQ.a(198L, 38L, this.eFS.eFM.ebK, false);
      h.nFQ.a(198L, 40L, this.eFS.eFM.eHH, false);
      h.nFQ.a(198L, 41L, 1L, false);
      localObject1 = h.nFQ;
      if (!com.tencent.mm.model.s.fn(this.eFS.eFM.SA())) {
        break label527;
      }
    }
    label527:
    for (long l = 43L;; l = 42L)
    {
      ((h)localObject1).a(198L, l, 1L, false);
      this.eFS.dmL.onSceneEnd(0, 0, "", this.eFS);
      return;
      if (this.eFS.eFL)
      {
        u.nX(this.eFS.fileName);
        h.nFQ.a(354L, 138L, 1L, false);
        break;
      }
      bool1 = u.W(this.eFS.fileName, this.eFU);
      break;
    }
    label535:
    h.nFQ.a(198L, 31L, this.eFS.eFM.ebK, false);
    h.nFQ.a(198L, 33L, this.eFS.eFM.eHH, false);
    h.nFQ.a(198L, 34L, 1L, false);
    localObject1 = h.nFQ;
    if (com.tencent.mm.model.s.fn(this.eFS.eFM.SA())) {}
    for (l = 36L;; l = 35L)
    {
      ((h)localObject1).a(198L, l, 1L, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d.2
 * JD-Core Version:    0.7.0.1
 */