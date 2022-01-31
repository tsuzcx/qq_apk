package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bh;
import java.util.Map;

final class d$2
  implements Runnable
{
  d$2(d paramd, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(50666);
    Object localObject1 = br.F(this.fVJ.fVD.alP(), "msg");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = o.alE();
      o.alE();
      ((t)localObject2).s(t.vf(this.fVJ.fileName), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    boolean bool1 = false;
    if (this.fVK)
    {
      boolean bool2 = u.ae(this.fVJ.fileName, this.fVL);
      bool1 = bool2;
      if (this.fVJ.fVC)
      {
        u.vx(this.fVJ.fileName);
        ab.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
        bool1 = bool2;
      }
      ab.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { this.fVJ.alu(), this.fVJ.fileName, Long.valueOf(this.fVJ.fVD.cFn), this.fVJ.fVD.alM(), this.fVJ.fVD.getUser(), Boolean.valueOf(bool1), this.fVJ.fFv, Integer.valueOf(this.fVJ.fFw), Boolean.valueOf(this.fVK), Boolean.valueOf(this.fVJ.fVH) });
      if ((!bo.isNullOrNil(this.fVJ.fFv)) && (this.fVJ.fFw > 0))
      {
        localObject1 = ((a)g.E(a.class)).YH();
        localObject2 = this.fVJ.fFv;
        int i = this.fVJ.fFw;
        o.alE();
        ((bh)localObject1).y((String)localObject2, i, t.vf(this.fVJ.fileName));
      }
      if (this.fVJ.fVD.fXE != 3) {
        break label545;
      }
      h.qsU.idkeyStat(198L, 38L, this.fVJ.fVD.fsd, false);
      h.qsU.idkeyStat(198L, 40L, this.fVJ.fVD.fXx, false);
      h.qsU.idkeyStat(198L, 41L, 1L, false);
      localObject1 = h.qsU;
      if (!com.tencent.mm.model.t.lA(this.fVJ.fVD.getUser())) {
        break label537;
      }
    }
    label537:
    for (long l = 43L;; l = 42L)
    {
      ((h)localObject1).idkeyStat(198L, l, 1L, false);
      this.fVJ.callback.onSceneEnd(0, 0, "", this.fVJ);
      AppMethodBeat.o(50666);
      return;
      if (this.fVJ.fVC)
      {
        u.vk(this.fVJ.fileName);
        h.qsU.idkeyStat(354L, 138L, 1L, false);
        break;
      }
      bool1 = u.ae(this.fVJ.fileName, this.fVL);
      break;
    }
    label545:
    h.qsU.idkeyStat(198L, 31L, this.fVJ.fVD.fsd, false);
    h.qsU.idkeyStat(198L, 33L, this.fVJ.fVD.fXx, false);
    h.qsU.idkeyStat(198L, 34L, 1L, false);
    localObject1 = h.qsU;
    if (com.tencent.mm.model.t.lA(this.fVJ.fVD.getUser())) {}
    for (l = 36L;; l = 35L)
    {
      ((h)localObject1).idkeyStat(198L, l, 1L, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d.2
 * JD-Core Version:    0.7.0.1
 */