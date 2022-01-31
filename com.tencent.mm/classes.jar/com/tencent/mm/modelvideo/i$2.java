package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(50716);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVo, false);
    Object localObject1;
    if (!com.tencent.mm.r.a.Ok())
    {
      localObject1 = new ux();
      ((ux)localObject1).cLs.cut = 2;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!((ux)localObject1).cLt.cLu) {}
    }
    else if (bool)
    {
      AppMethodBeat.o(50716);
      return;
    }
    if (o.alJ().ckK)
    {
      AppMethodBeat.o(50716);
      return;
    }
    if (this.fWw.fWu != null)
    {
      AppMethodBeat.o(50716);
      return;
    }
    if ((this.fWw.fWq) || (this.fWw.fWr))
    {
      AppMethodBeat.o(50716);
      return;
    }
    int i;
    if (this.fWw.fWm.isEmpty())
    {
      localObject1 = this.fWw;
      if (bo.gz(((i)localObject1).fWv) > 600L) {
        ((i)localObject1).fWv = bo.aox();
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          i.a(this.fWw);
        }
        AppMethodBeat.o(50716);
        return;
      }
    }
    Object localObject5 = new PBool();
    for (;;)
    {
      Object localObject6;
      int j;
      synchronized (this.fWw.fWm)
      {
        Iterator localIterator = this.fWw.fWm.iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label816;
        }
        localObject1 = (bi)localIterator.next();
        localObject6 = this.fWw;
        if (localObject1 == null)
        {
          ((PBool)localObject5).value = true;
          i = 0;
          if (!((PBool)localObject5).value) {
            break label1080;
          }
          localIterator.remove();
          break label1080;
        }
        s locals = u.vr(((dd)localObject1).field_imgPath);
        if ((locals != null) && (locals.alS()))
        {
          ab.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), locals.getFileName() });
          Object localObject7 = br.F(locals.alP(), "msg");
          String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
          localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
          bool = t.lA(locals.getUser());
          if (!bool) {
            break label1087;
          }
          i = 2;
          long l = locals.fsd;
          if (!t.lA(locals.getUser())) {
            break label1092;
          }
          j = n.nv(locals.getUser());
          ((i)localObject6).a(str, i, l, locals.alM(), locals.getUser(), j, (String)localObject7, "", "");
          h.qsU.idkeyStat(354L, 146L, 1L, false);
          if (bool)
          {
            h.qsU.idkeyStat(354L, 126L, 1L, false);
            ((PBool)localObject5).value = true;
            i = 0;
            continue;
          }
          h.qsU.idkeyStat(354L, 125L, 1L, false);
        }
      }
      if (bo.hl(localObject2.field_createTime) >= 86400000L)
      {
        ab.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
        ((PBool)localObject5).value = true;
        i = 0;
      }
      else
      {
        if (((i)localObject6).dj(true)) {
          ab.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).fWn) });
        }
        label803:
        for (;;)
        {
          ((PBool)localObject5).value = false;
          i = 0;
          break;
          ab.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.dns });
          localObject6 = bf.pA(localObject2.dns);
          if (localObject6 == null)
          {
            ((PBool)localObject5).value = true;
            i = 0;
            break;
          }
          if (((bf.b)localObject6).fmU <= 0)
          {
            ((PBool)localObject5).value = true;
            i = 0;
            break;
          }
          if (!com.tencent.mm.modelcontrol.b.sM(((bf.b)localObject6).fmW))
          {
            if (at.isWifi(ah.getContext())) {
              i = ((bf.b)localObject6).fmV & 0x1;
            }
            for (;;)
            {
              if (i <= 0) {
                break label803;
              }
              ((PBool)localObject5).value = false;
              i = 1;
              break;
              if (at.is4G(ah.getContext()))
              {
                i = ((bf.b)localObject6).fmV & 0x2;
              }
              else
              {
                if (!at.is3G(ah.getContext())) {
                  break label805;
                }
                i = ((bf.b)localObject6).fmV & 0x4;
              }
            }
          }
        }
        label805:
        ((PBool)localObject5).value = false;
        i = 0;
        continue;
        label816:
        label1080:
        do
        {
          if (localObject2 == null)
          {
            AppMethodBeat.o(50716);
            return;
          }
          this.fWw.fWu = new f(localObject2.field_msgId);
          ab.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(this.fWw.hashCode()), this.fWw.fWu.alv() });
          if (this.fWw.fWu.a(this.fWw) < 0)
          {
            ab.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(this.fWw.hashCode()) });
            synchronized (this.fWw.fWm)
            {
              ??? = this.fWw.fWm.iterator();
              while (((Iterator)???).hasNext())
              {
                localObject5 = (bi)((Iterator)???).next();
                if ((localObject5 != null) && (((dd)localObject5).field_msgId == this.fWw.fWu.cpO))
                {
                  ab.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(this.fWw.hashCode()), Long.valueOf(this.fWw.fWu.cpO) });
                  ((Iterator)???).remove();
                }
              }
            }
            this.fWw.fWu = null;
          }
          AppMethodBeat.o(50716);
          return;
        } while (i != 0);
        continue;
        label1087:
        i = 1;
        continue;
        label1092:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i.2
 * JD-Core Version:    0.7.0.1
 */