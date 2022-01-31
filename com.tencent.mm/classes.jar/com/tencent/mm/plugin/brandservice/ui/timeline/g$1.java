package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.net.Uri;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import java.util.HashMap;
import java.util.LinkedList;

final class g$1
  implements Runnable
{
  g$1(g paramg, q paramq, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    g localg = this.igK;
    q localq = this.hSM;
    int n = this.ffJ;
    int i1 = this.eEj;
    int m = this.igJ;
    Object localObject1;
    if (localq != null)
    {
      if (!localq.ctz()) {
        break label738;
      }
      if (localq.ctz())
      {
        localObject1 = ((a)com.tencent.mm.kernel.g.r(a.class)).d(localq.field_msgId, localq.field_content);
        if ((localObject1 != null) && (!bk.dk(((l)localObject1).dTx))) {
          break label93;
        }
      }
    }
    label93:
    int k;
    do
    {
      return;
      try
      {
        j = ((l)localObject1).dTx.size();
        if ((j <= 2) || (localq.field_isExpand)) {
          break;
        }
        j = 2;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        int j;
        Object localObject2;
        y.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
        return;
        locala.sDt = 0;
        break label1143;
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localException.getMessage() });
        return;
      }
    } while (k >= j);
    localObject2 = (m)((l)localObject1).dTx.get(k);
    g.a locala;
    if (localObject2 != null)
    {
      locala = (g.a)localg.igI.get(localq.field_msgId + "_" + k);
      if (locala == null)
      {
        locala = new g.a((byte)0);
        localg.igI.put(localq.field_msgId + "_" + k, locala);
        locala.sDq = localq.field_talker;
        locala.sDs = 1;
        locala.sDB = ((int)(System.currentTimeMillis() / 1000L));
        locala.pos = n;
        locala.sDu = 0;
        locala.sDw = 0;
        locala.sDx = 0;
        locala.sDA = 0;
        locala.sDy = 0;
        locala.sDA = 0;
        locala.sDC = ((int)(localq.field_createTime / 1000L));
        if (i1 != 4)
        {
          i = 0;
          label332:
          locala.sDE = i;
          locala.sDF = ((m)localObject2).type;
          locala.sDG = ("1_" + g.a(localq, ((m)localObject2).url) + ";");
          locala.sDI = k;
          if (!localq.field_isExpand) {
            break label1155;
          }
          i = 1;
          label399:
          locala.sDJ = i;
          locala.sDL = m;
          if ((k != 0) || (!localq.umU)) {
            break label1160;
          }
          i = 1;
          label426:
          locala.sDN = i;
          if (!localq.umV) {
            break label1165;
          }
        }
      }
    }
    label1155:
    label1160:
    label1165:
    for (int i = 1;; i = 0)
    {
      locala.sDO = i;
      g.a(locala, localq.field_talker);
      if (!bk.bl(((m)localObject2).url))
      {
        localObject2 = Uri.parse(((m)localObject2).url);
        i = bk.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        long l = bk.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        locala.sDr.add(Integer.valueOf(i));
        locala.bHR = l;
        locala.sDH = l;
      }
      if (localq.field_isExpand)
      {
        locala.sDt = 2;
        break label1143;
        if (System.currentTimeMillis() - localq.field_createTime > 86400000L) {
          break label1150;
        }
        i = 1;
        break label332;
      }
      if (((l)localObject1).dTx.size() > 2)
      {
        locala.sDt = 1;
      }
      else
      {
        if ((k == 0) && (localq.umU))
        {
          i = 1;
          locala.sDN = i;
          if (!localq.umV) {
            break label733;
          }
        }
        label733:
        for (i = 1;; i = 0)
        {
          locala.sDO = i;
          locala.sDs += 1;
          locala.pos = n;
          locala.sDB = ((int)(System.currentTimeMillis() / 1000L));
          g.a(locala, localq.field_talker);
          break label1143;
          i = 0;
          break;
        }
        label738:
        localObject1 = (g.a)localException.igI.get(localq.field_msgId);
        if (localObject1 == null)
        {
          localObject1 = new g.a((byte)0);
          localException.igI.put(localq.field_msgId, localObject1);
          ((g.a)localObject1).sDq = localq.field_talker;
          ((g.a)localObject1).bHR = 0L;
          ((g.a)localObject1).sDs = 1;
          ((g.a)localObject1).sDB = ((int)(System.currentTimeMillis() / 1000L));
          ((g.a)localObject1).pos = n;
          ((g.a)localObject1).sDu = 0;
          ((g.a)localObject1).sDw = 0;
          ((g.a)localObject1).sDx = 0;
          ((g.a)localObject1).sDA = 0;
          ((g.a)localObject1).sDy = 0;
          ((g.a)localObject1).sDA = 0;
          ((g.a)localObject1).sDC = ((int)(localq.field_createTime / 1000L));
          if (i1 != 4)
          {
            i = 0;
            ((g.a)localObject1).sDE = i;
            if (!localq.isText()) {
              break label1012;
            }
            i = 1;
            label930:
            ((g.a)localObject1).sDF = i;
            g.a((g.a)localObject1, localq.field_talker);
            ((g.a)localObject1).sDL = m;
            if (!localq.umU) {
              break label1043;
            }
            i = 1;
            label963:
            ((g.a)localObject1).sDN = i;
            if (!localq.umV) {
              break label1048;
            }
          }
          label1043:
          label1048:
          for (i = 1;; i = 0)
          {
            ((g.a)localObject1).sDO = i;
            return;
            if (System.currentTimeMillis() - localq.field_createTime <= 86400000L)
            {
              i = 1;
              break;
            }
            i = 2;
            break;
            label1012:
            if (localq.ctB())
            {
              i = 2;
              break label930;
            }
            if (localq.ctA())
            {
              i = 3;
              break label930;
            }
            i = -1;
            break label930;
            i = 0;
            break label963;
          }
        }
        ((g.a)localObject1).sDs += 1;
        ((g.a)localObject1).pos = n;
        ((g.a)localObject1).sDB = ((int)(System.currentTimeMillis() / 1000L));
        g.a((g.a)localObject1, localq.field_talker);
        if (localq.umU)
        {
          i = 1;
          ((g.a)localObject1).sDN = i;
          if (!localq.umV) {
            break label1133;
          }
        }
        label1133:
        for (i = 1;; i = 0)
        {
          ((g.a)localObject1).sDO = i;
          return;
          i = 0;
          break;
        }
        k = 0;
        break;
      }
      label1143:
      k += 1;
      break;
      label1150:
      i = 2;
      break label332;
      i = 0;
      break label399;
      i = 0;
      break label426;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g.1
 * JD-Core Version:    0.7.0.1
 */