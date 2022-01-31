package com.tencent.mm.modelvideo;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
    if (o.Sw().bDV) {
      break label9;
    }
    label9:
    Object localObject1;
    int i;
    for (;;)
    {
      return;
      if ((this.eGG.eGE == null) && (!this.eGG.eGA) && (!this.eGG.eGB))
      {
        if (!this.eGG.eGw.isEmpty()) {
          break;
        }
        localObject1 = this.eGG;
        if (bk.cn(((i)localObject1).eGF) > 600L) {
          ((i)localObject1).eGF = bk.UX();
        }
        for (i = 1; i != 0; i = 0)
        {
          i.a(this.eGG);
          return;
        }
      }
    }
    Object localObject5 = new PBool();
    for (;;)
    {
      Object localObject6;
      int j;
      synchronized (this.eGG.eGw)
      {
        Iterator localIterator = this.eGG.eGw.iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label709;
        }
        localObject1 = (bi)localIterator.next();
        localObject6 = this.eGG;
        if (localObject1 == null)
        {
          ((PBool)localObject5).value = true;
          i = 0;
          if (!((PBool)localObject5).value) {
            break label957;
          }
          localIterator.remove();
          break label957;
        }
        s locals = u.oe(((cs)localObject1).field_imgPath);
        if ((locals != null) && (locals.SG()))
        {
          y.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), locals.getFileName() });
          Object localObject7 = bn.s(locals.SD(), "msg");
          String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
          localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
          boolean bool = com.tencent.mm.model.s.fn(locals.SA());
          if (!bool) {
            break label964;
          }
          i = 2;
          long l = locals.ebK;
          if (!com.tencent.mm.model.s.fn(locals.SA())) {
            break label969;
          }
          j = m.gM(locals.SA());
          ((i)localObject6).a(str, i, l, locals.SB(), locals.SA(), j, (String)localObject7, "", "");
          h.nFQ.a(354L, 146L, 1L, false);
          if (bool)
          {
            h.nFQ.a(354L, 126L, 1L, false);
            ((PBool)localObject5).value = true;
            i = 0;
            continue;
          }
          h.nFQ.a(354L, 125L, 1L, false);
        }
      }
      if (bk.co(localObject2.field_createTime) >= 86400000L)
      {
        y.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
        ((PBool)localObject5).value = true;
        i = 0;
      }
      else
      {
        if (((i)localObject6).cg(true)) {
          y.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).eGx) });
        }
        label696:
        for (;;)
        {
          ((PBool)localObject5).value = false;
          i = 0;
          break;
          y.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.czr });
          localObject6 = bd.iM(localObject2.czr);
          if (localObject6 == null)
          {
            ((PBool)localObject5).value = true;
            i = 0;
            break;
          }
          if (((bd.b)localObject6).dWM <= 0)
          {
            ((PBool)localObject5).value = true;
            i = 0;
            break;
          }
          if (!b.lO(((bd.b)localObject6).dWO))
          {
            if (aq.isWifi(ae.getContext())) {
              i = ((bd.b)localObject6).dWN & 0x1;
            }
            for (;;)
            {
              if (i <= 0) {
                break label696;
              }
              ((PBool)localObject5).value = false;
              i = 1;
              break;
              if (aq.is4G(ae.getContext()))
              {
                i = ((bd.b)localObject6).dWN & 0x2;
              }
              else
              {
                if (!aq.is3G(ae.getContext())) {
                  break label698;
                }
                i = ((bd.b)localObject6).dWN & 0x4;
              }
            }
          }
        }
        label698:
        ((PBool)localObject5).value = false;
        i = 0;
        continue;
        label709:
        do
        {
          if (localObject2 == null) {
            break;
          }
          this.eGG.eGE = new f(localObject2.field_msgId);
          y.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(this.eGG.hashCode()), this.eGG.eGE.getTips() });
          if (this.eGG.eGE.a(this.eGG) >= 0) {
            break;
          }
          y.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(this.eGG.hashCode()) });
          synchronized (this.eGG.eGw)
          {
            ??? = this.eGG.eGw.iterator();
            while (((Iterator)???).hasNext())
            {
              localObject5 = (bi)((Iterator)???).next();
              if ((localObject5 != null) && (((cs)localObject5).field_msgId == this.eGG.eGE.bIt))
              {
                y.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(this.eGG.hashCode()), Long.valueOf(this.eGG.eGE.bIt) });
                ((Iterator)???).remove();
              }
            }
          }
          this.eGG.eGE = null;
          return;
        } while (i != 0);
        label957:
        continue;
        label964:
        i = 1;
        continue;
        label969:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i.2
 * JD-Core Version:    0.7.0.1
 */