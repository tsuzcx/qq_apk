package com.tencent.mm.ak;

import com.tencent.mm.h.a.lf;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.j.g;
import com.tencent.mm.j.g.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class e$8
  implements Runnable
{
  e$8(e parame, String paramString, c paramc, d paramd) {}
  
  public final void run()
  {
    Object localObject = (g)this.ejo.eiI.get(this.BF);
    if (localObject == null) {}
    s locals;
    do
    {
      do
      {
        do
        {
          return;
          if (((g)localObject).dmn == null) {
            break;
          }
          if (this.eiQ != null)
          {
            ((g)localObject).dmn.e(this.BF, this.eiQ.field_finishedLength, this.eiQ.field_toltalLength);
            return;
          }
        } while (this.eiR == null);
        ((g)localObject).dmn.x(this.BF, this.eiR.field_retCode);
        this.ejo.eiI.remove(this.BF);
        return;
        locals = u.oe(((g)localObject).filename);
        if (locals == null)
        {
          y.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((g)localObject).filename });
          return;
        }
        if (((g)localObject).dlP == null) {
          break;
        }
        ((g)localObject).dlP.a(this.BF, 0, this.eiQ, this.eiR, ((g)localObject).field_onlycheckexist);
      } while (this.eiR == null);
      this.ejo.eiI.remove(this.BF);
      return;
      if (this.eiQ != null)
      {
        if (this.eiQ.field_finishedLength == locals.ebK)
        {
          y.i("MicroMsg.OnlineVideoService", "stream download finish.");
          return;
        }
        if ((locals.status != 130) && (locals.eHC > this.eiQ.field_finishedLength))
        {
          y.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(locals.eHC), Integer.valueOf(this.eiQ.field_finishedLength) });
          return;
        }
        y.i("MicroMsg.OnlineVideoService", "callback progress info " + this.eiQ.field_finishedLength);
        locals.eHF = bk.UX();
        locals.eHC = this.eiQ.field_finishedLength;
        locals.bcw = 1040;
        u.f(locals);
        localObject = new lf();
        ((lf)localObject).bUh.bNb = 5;
        ((lf)localObject).bUh.bUi = this.BF;
        ((lf)localObject).bUh.offset = this.eiQ.field_finishedLength;
        ((lf)localObject).bUh.length = this.eiQ.field_toltalLength;
        a.udP.m((b)localObject);
        return;
      }
    } while (this.eiR == null);
    y.i("MicroMsg.OnlineVideoService", "callback result info " + this.eiR.field_retCode + ", filesize:" + this.eiR.field_fileLength + ",recved:" + this.eiR.field_recvedBytes);
    int i;
    int j;
    if (this.eiR.field_retCode != 0)
    {
      if (this.eiR.field_retCode != -10012) {
        u.nX(locals.getFileName());
      }
      boolean bool = ((g)localObject).wZ();
      i = this.eiR.field_retCode;
      j = ((g)localObject).dmg;
      if (bool) {
        if (j == 1) {
          if (i == -5103059)
          {
            h.nFQ.a(354L, 111L, 1L, false);
            h.nFQ.f(13836, new Object[] { Integer.valueOf(101), Long.valueOf(bk.UX()), Integer.valueOf(i) });
          }
        }
      }
    }
    for (;;)
    {
      localObject = new lf();
      ((lf)localObject).bUh.bNb = 4;
      ((lf)localObject).bUh.bUi = this.BF;
      ((lf)localObject).bUh.offset = 0;
      ((lf)localObject).bUh.retCode = this.eiR.field_retCode;
      ((lf)localObject).bUh.length = this.eiR.field_fileLength;
      a.udP.m((b)localObject);
      this.ejo.eiI.remove(this.BF);
      return;
      if (i == -5103087)
      {
        h.nFQ.a(354L, 112L, 1L, false);
        break;
      }
      if (i == -10012)
      {
        h.nFQ.a(354L, 113L, 1L, false);
        break;
      }
      h.nFQ.a(354L, 114L, 1L, false);
      break;
      if (i == -5103059)
      {
        h.nFQ.a(354L, 116L, 1L, false);
        break;
      }
      if (i == -5103087)
      {
        h.nFQ.a(354L, 117L, 1L, false);
        break;
      }
      if (i == -10012)
      {
        h.nFQ.a(354L, 118L, 1L, false);
        break;
      }
      h.nFQ.a(354L, 119L, 1L, false);
      break;
      h.nFQ.a(354L, 213L, 1L, false);
      if (j == 1) {
        h.nFQ.a(354L, 214L, 1L, false);
      }
      for (;;)
      {
        h.nFQ.f(13836, new Object[] { Integer.valueOf(201), Long.valueOf(bk.UX()), Integer.valueOf(i) });
        break;
        h.nFQ.a(354L, 215L, 1L, false);
      }
      e.a(locals, this.eiR.field_fileLength, ((g)localObject).dme);
      this.ejo.ejm.put(((g)localObject).field_mediaId, localObject);
      this.ejo.ejn.put(((g)localObject).field_mediaId, this.eiR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ak.e.8
 * JD-Core Version:    0.7.0.1
 */