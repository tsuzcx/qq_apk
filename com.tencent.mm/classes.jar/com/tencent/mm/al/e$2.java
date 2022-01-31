package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class e$2
  implements Runnable
{
  e$2(e parame, String paramString, c paramc, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(50559);
    Object localObject = (com.tencent.mm.i.h)this.fzs.fyM.get(this.Cq);
    if (localObject == null)
    {
      AppMethodBeat.o(50559);
      return;
    }
    if (((com.tencent.mm.i.h)localObject).edQ != null)
    {
      ab.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { this.Cq });
      if (this.fyU != null)
      {
        ((com.tencent.mm.i.h)localObject).edQ.n(this.Cq, this.fyU.field_finishedLength, this.fyU.field_toltalLength);
        AppMethodBeat.o(50559);
        return;
      }
      if (this.fyV != null)
      {
        ab.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { this.Cq, Integer.valueOf(this.fyV.field_retCode) });
        ((com.tencent.mm.i.h)localObject).edQ.a(this.Cq, this.fyV.field_retCode, this.fyV);
        this.fzs.fyM.remove(this.Cq);
        if (this.fyV.field_retCode == 0)
        {
          this.fzs.fzq.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
          this.fzs.fzr.put(((com.tencent.mm.i.h)localObject).field_mediaId, this.fyV);
        }
        AppMethodBeat.o(50559);
        return;
      }
      AppMethodBeat.o(50559);
      return;
    }
    s locals = u.vr(((com.tencent.mm.i.h)localObject).filename);
    if (locals == null)
    {
      ab.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((com.tencent.mm.i.h)localObject).filename });
      AppMethodBeat.o(50559);
      return;
    }
    if (((com.tencent.mm.i.h)localObject).edp != null)
    {
      ((com.tencent.mm.i.h)localObject).edp.a(this.Cq, 0, this.fyU, this.fyV, ((com.tencent.mm.i.h)localObject).field_onlycheckexist);
      if (this.fyV != null) {
        this.fzs.fyM.remove(this.Cq);
      }
      AppMethodBeat.o(50559);
      return;
    }
    if (this.fyU != null)
    {
      if (this.fyU.field_finishedLength == locals.fsd)
      {
        ab.i("MicroMsg.OnlineVideoService", "stream download finish.");
        AppMethodBeat.o(50559);
        return;
      }
      if ((locals.status != 130) && (locals.fXs > this.fyU.field_finishedLength))
      {
        ab.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(locals.fXs), Integer.valueOf(this.fyU.field_finishedLength) });
        AppMethodBeat.o(50559);
        return;
      }
      ab.i("MicroMsg.OnlineVideoService", "callback progress info " + this.fyU.field_finishedLength);
      locals.fXv = bo.aox();
      locals.fXs = this.fyU.field_finishedLength;
      locals.bsY = 1040;
      u.f(locals);
      localObject = new lu();
      ((lu)localObject).cBN.cut = 5;
      ((lu)localObject).cBN.cBO = this.Cq;
      ((lu)localObject).cBN.offset = this.fyU.field_finishedLength;
      ((lu)localObject).cBN.length = this.fyU.field_toltalLength;
      a.ymk.l((b)localObject);
      AppMethodBeat.o(50559);
      return;
    }
    int i;
    int j;
    if (this.fyV != null)
    {
      ab.i("MicroMsg.OnlineVideoService", "callback result info " + this.fyV.field_retCode + ", filesize:" + this.fyV.field_fileLength + ",recved:" + this.fyV.field_recvedBytes);
      if (this.fyV.field_retCode == 0) {
        break label1120;
      }
      if (this.fyV.field_retCode != -10012) {
        u.vk(locals.getFileName());
      }
      boolean bool = ((com.tencent.mm.i.h)localObject).Jr();
      i = this.fyV.field_retCode;
      j = ((com.tencent.mm.i.h)localObject).edJ;
      if (!bool) {
        break label1029;
      }
      if (j != 1) {
        break label941;
      }
      if (i != -5103059) {
        break label876;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 111L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(13836, new Object[] { Integer.valueOf(101), Long.valueOf(bo.aox()), Integer.valueOf(i) });
    }
    for (;;)
    {
      localObject = new lu();
      ((lu)localObject).cBN.cut = 4;
      ((lu)localObject).cBN.cBO = this.Cq;
      ((lu)localObject).cBN.offset = 0;
      ((lu)localObject).cBN.retCode = this.fyV.field_retCode;
      ((lu)localObject).cBN.length = this.fyV.field_fileLength;
      a.ymk.l((b)localObject);
      this.fzs.fyM.remove(this.Cq);
      AppMethodBeat.o(50559);
      return;
      label876:
      if (i == -5103087)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 112L, 1L, false);
        break;
      }
      if (i == -10012)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 113L, 1L, false);
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 114L, 1L, false);
      break;
      label941:
      if (i == -5103059)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 116L, 1L, false);
        break;
      }
      if (i == -5103087)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 117L, 1L, false);
        break;
      }
      if (i == -10012)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 118L, 1L, false);
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 119L, 1L, false);
      break;
      label1029:
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 213L, 1L, false);
      if (j == 1) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 214L, 1L, false);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13836, new Object[] { Integer.valueOf(201), Long.valueOf(bo.aox()), Integer.valueOf(i) });
        break;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 215L, 1L, false);
      }
      label1120:
      e.a(locals, this.fyV.field_fileLength, ((com.tencent.mm.i.h)localObject).edH);
      this.fzs.fzq.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
      this.fzs.fzr.put(((com.tencent.mm.i.h)localObject).field_mediaId, this.fyV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.e.2
 * JD-Core Version:    0.7.0.1
 */