package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class e$8
  implements Runnable
{
  e$8(e parame, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(50565);
    com.tencent.mm.i.h localh = (com.tencent.mm.i.h)this.fzs.fyM.get(this.Cq);
    if (localh != null)
    {
      localh.edP = this.fzv;
      if (localh.edQ != null)
      {
        localh.edQ.l(this.Cq, this.fzv, this.fzw);
        AppMethodBeat.o(50565);
        return;
      }
      if (r.uY(localh.field_fullpath))
      {
        ab.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.edJ);
        if (localh.edJ == 1)
        {
          e.r(localh.field_mediaId, 0, localh.field_totalLen);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 19L, 1L, false);
        }
        AppMethodBeat.o(50565);
        return;
      }
      Object localObject = new lu();
      ((lu)localObject).cBN.cut = 1;
      ((lu)localObject).cBN.retCode = 0;
      ((lu)localObject).cBN.cBO = this.Cq;
      ((lu)localObject).cBN.offset = this.fzv;
      ((lu)localObject).cBN.length = this.fzw;
      ((lu)localObject).cBN.cBP = localh.edG;
      lu.a locala = ((lu)localObject).cBN;
      if (localh.edq > 0) {
        bool = true;
      }
      locala.cBQ = bool;
      a.ymk.l((b)localObject);
      localObject = u.vr(localh.filename);
      if (localObject != null)
      {
        ab.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((s)localObject).getFileName() + " status : " + ((s)localObject).status);
        if (((s)localObject).status == 130)
        {
          AppMethodBeat.o(50565);
          return;
        }
        if (((s)localObject).status != 122)
        {
          localObject = u.vr(localh.filename);
          if (localObject != null)
          {
            ((s)localObject).status = 121;
            ((s)localObject).bsY = 256;
            o.alE().c((s)localObject);
          }
          if (localh.edJ == 0)
          {
            ab.i("MicroMsg.OnlineVideoService", "stop download video");
            o.alJ().alZ();
            o.alJ().run();
          }
        }
      }
    }
    AppMethodBeat.o(50565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.al.e.8
 * JD-Core Version:    0.7.0.1
 */