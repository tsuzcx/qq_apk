package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

final class f$1
  implements Runnable
{
  f$1(f paramf, com.tencent.mm.storage.q paramq, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(14170);
    f localf = this.jWC;
    com.tencent.mm.storage.q localq = this.jMz;
    int n = this.gxr;
    int i1 = this.fUa;
    int m = this.jWB;
    Object localObject1;
    int k;
    f.a locala;
    if (localq != null) {
      if (localq.dvV()) {
        if (localq.dvV())
        {
          localObject1 = ((a)g.E(a.class)).b(localq.field_msgId, localq.field_content);
          if ((localObject1 == null) || (bo.es(((p)localObject1).fjy)))
          {
            AppMethodBeat.o(14170);
            return;
          }
          try
          {
            j = ((p)localObject1).fjy.size();
            if ((j <= 2) || (localq.field_isExpand)) {
              break label1182;
            }
            j = 2;
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            int j;
            Object localObject2;
            ab.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
            AppMethodBeat.o(14170);
            return;
            locala.wyZ = 0;
            break label1187;
          }
          catch (Exception localException)
          {
            ab.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localException.getMessage() });
          }
          if (k >= j) {
            break label763;
          }
          localObject2 = (com.tencent.mm.af.q)((p)localObject1).fjy.get(k);
          if (localObject2 == null) {
            break label1187;
          }
          locala = (f.a)localf.jWA.get(localq.field_msgId + "_" + k);
          if (locala != null) {
            break label672;
          }
          locala = new f.a((byte)0);
          localf.jWA.put(localq.field_msgId + "_" + k, locala);
          locala.wyW = localq.field_talker;
          locala.wyY = 1;
          locala.wzg = ((int)(System.currentTimeMillis() / 1000L));
          locala.pos = n;
          locala.wza = 0;
          locala.wzc = 0;
          locala.wzd = 0;
          locala.wzf = 0;
          locala.wyy = 0;
          locala.wzf = 0;
          locala.wzh = ((int)(localq.field_createTime / 1000L));
          if (i1 != 4)
          {
            i = 0;
            label344:
            locala.wzj = i;
            locala.wzk = ((com.tencent.mm.af.q)localObject2).type;
            locala.wzl = ("1_" + f.a(localq, ((com.tencent.mm.af.q)localObject2).url) + ";");
            locala.wzn = k;
            if (!localq.field_isExpand) {
              break label1199;
            }
            i = 1;
            label411:
            locala.wzo = i;
            locala.wzq = m;
            if ((k != 0) || (!localq.ywA)) {
              break label1204;
            }
            i = 1;
            label438:
            locala.wzs = i;
            if (!localq.ywB) {
              break label1209;
            }
          }
        }
      }
    }
    label672:
    label1187:
    label1194:
    label1199:
    label1204:
    label1209:
    for (int i = 1;; i = 0)
    {
      locala.wzt = i;
      f.a(locala, localq.field_talker);
      if (!bo.isNullOrNil(((com.tencent.mm.af.q)localObject2).url))
      {
        localObject2 = Uri.parse(((com.tencent.mm.af.q)localObject2).url);
        i = bo.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        long l = bo.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        locala.wyX.add(Integer.valueOf(i));
        locala.cpg = l;
        locala.wzm = l;
      }
      if (localq.field_isExpand)
      {
        locala.wyZ = 2;
        break label1187;
        if (System.currentTimeMillis() - localq.field_createTime > 86400000L) {
          break label1194;
        }
        i = 1;
        break label344;
      }
      if (((p)localObject1).fjy.size() > 2)
      {
        locala.wyZ = 1;
      }
      else
      {
        AppMethodBeat.o(14170);
        return;
        if ((k == 0) && (localq.ywA))
        {
          i = 1;
          locala.wzs = i;
          if (!localq.ywB) {
            break label758;
          }
        }
        label758:
        for (i = 1;; i = 0)
        {
          locala.wzt = i;
          locala.wyY += 1;
          locala.pos = n;
          locala.wzg = ((int)(System.currentTimeMillis() / 1000L));
          f.a(locala, localq.field_talker);
          break label1187;
          i = 0;
          break;
        }
        label763:
        AppMethodBeat.o(14170);
        return;
        localObject1 = (f.a)localException.jWA.get(localq.field_msgId);
        if (localObject1 == null)
        {
          localObject1 = new f.a((byte)0);
          localException.jWA.put(localq.field_msgId, localObject1);
          ((f.a)localObject1).wyW = localq.field_talker;
          ((f.a)localObject1).cpg = 0L;
          ((f.a)localObject1).wyY = 1;
          ((f.a)localObject1).wzg = ((int)(System.currentTimeMillis() / 1000L));
          ((f.a)localObject1).pos = n;
          ((f.a)localObject1).wza = 0;
          ((f.a)localObject1).wzc = 0;
          ((f.a)localObject1).wzd = 0;
          ((f.a)localObject1).wzf = 0;
          ((f.a)localObject1).wyy = 0;
          ((f.a)localObject1).wzf = 0;
          ((f.a)localObject1).wzh = ((int)(localq.field_createTime / 1000L));
          if (i1 != 4)
          {
            i = 0;
            ((f.a)localObject1).wzj = i;
            if (!localq.isText()) {
              break label1050;
            }
            i = 1;
            label962:
            ((f.a)localObject1).wzk = i;
            f.a((f.a)localObject1, localq.field_talker);
            ((f.a)localObject1).wzq = m;
            if (!localq.ywA) {
              break label1081;
            }
            i = 1;
            label995:
            ((f.a)localObject1).wzs = i;
            if (!localq.ywB) {
              break label1086;
            }
          }
          label1081:
          label1086:
          for (i = 1;; i = 0)
          {
            ((f.a)localObject1).wzt = i;
            AppMethodBeat.o(14170);
            return;
            if (System.currentTimeMillis() - localq.field_createTime <= 86400000L)
            {
              i = 1;
              break;
            }
            i = 2;
            break;
            if (localq.dvX())
            {
              i = 2;
              break label962;
            }
            if (localq.dvW())
            {
              i = 3;
              break label962;
            }
            i = -1;
            break label962;
            i = 0;
            break label995;
          }
        }
        ((f.a)localObject1).wyY += 1;
        ((f.a)localObject1).pos = n;
        ((f.a)localObject1).wzg = ((int)(System.currentTimeMillis() / 1000L));
        f.a((f.a)localObject1, localq.field_talker);
        if (localq.ywA)
        {
          i = 1;
          ((f.a)localObject1).wzs = i;
          if (!localq.ywB) {
            break label1177;
          }
        }
        for (i = 1;; i = 0)
        {
          ((f.a)localObject1).wzt = i;
          AppMethodBeat.o(14170);
          return;
          i = 0;
          break;
        }
        k = 0;
        break;
      }
      k += 1;
      break;
      i = 2;
      break label344;
      i = 0;
      break label411;
      i = 0;
      break label438;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f.1
 * JD-Core Version:    0.7.0.1
 */