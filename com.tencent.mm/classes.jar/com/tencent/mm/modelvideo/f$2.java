package com.tencent.mm.modelvideo;

import com.tencent.mm.j.d;
import com.tencent.mm.j.f.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  implements f.b
{
  f$2(f paramf) {}
  
  public final void a(String paramString, d paramd)
  {
    if (paramd == null)
    {
      y.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(this.eGg.hashCode()) });
      if (this.eGg.eGf != null) {
        this.eGg.eGf.a(this.eGg, false, 0, 0);
      }
      return;
    }
    int i = paramd.field_recvedBytes;
    int j = paramd.field_fileLength;
    y.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(this.eGg.hashCode()), paramString, this.eGg.eFZ, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramd.field_videoFormat) });
    if ((i > 0) && (j > 0)) {
      this.eGg.eGc = f.e(this.eGg.eFZ, i, true);
    }
    boolean bool;
    if (this.eGg.eGf != null)
    {
      paramString = this.eGg.eGf;
      f localf = this.eGg;
      if ((i > 0) && (j > 0))
      {
        bool = true;
        paramString.a(localf, bool, i, j);
      }
    }
    else
    {
      this.eGg.eGb = bk.UX();
      this.eGg.nG(paramd.wW());
      if (!this.eGg.eFY) {
        break label325;
      }
      h.nFQ.a(354L, 142L, 1L, false);
      if (this.eGg.eGd != 1) {
        break label308;
      }
      h.nFQ.a(354L, 123L, 1L, false);
    }
    for (;;)
    {
      h.nFQ.a(354L, paramd.field_videoFormat + 240, 1L, false);
      return;
      bool = false;
      break;
      label308:
      h.nFQ.a(354L, 124L, 1L, false);
    }
    label325:
    h.nFQ.a(354L, 143L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f.2
 * JD-Core Version:    0.7.0.1
 */