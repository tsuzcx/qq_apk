package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.n;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.v;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  int daq;
  int nAe;
  int nAf;
  HashMap<String, a> nAg;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(5934);
    this.nAg = new HashMap();
    this.daq = paramInt;
    AppMethodBeat.o(5934);
  }
  
  static void a(a parama, String paramString)
  {
    AppMethodBeat.i(5936);
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString).aaN())
    {
      parama.Ecv = 1;
      parama.Ecz = 1;
      AppMethodBeat.o(5936);
      return;
    }
    parama.Ecv = 0;
    parama.Ecz = 0;
    AppMethodBeat.o(5936);
  }
  
  private void a(final t paramt, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(5939);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        long l1 = 0L;
        AppMethodBeat.i(5933);
        long l3 = l1;
        long l2;
        if (paramt.eZj())
        {
          l2 = l1;
          l3 = l1;
        }
        for (;;)
        {
          try
          {
            Object localObject = ((a)g.ab(a.class)).a(paramt.field_msgId, paramt.field_content);
            if (localObject == null) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            if (bs.gY(((com.tencent.mm.ah.u)localObject).hkS)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = (v)((com.tencent.mm.ah.u)localObject).hkS.get(paramInt1);
            l2 = l1;
            l3 = l1;
            if (bs.isNullOrNil(((v)localObject).url)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = Uri.parse(((v)localObject).url);
            l2 = l1;
            l3 = l1;
            l1 = bs.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
            l2 = l1;
            l3 = l1;
            i = bs.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            ac.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
            i = 0;
            l1 = l2;
            continue;
          }
          catch (Exception localException)
          {
            ac.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
          }
          h.this.a(paramt.field_talker, l1, i, paramInt2, paramInt3);
          AppMethodBeat.o(5933);
          return;
          int i = 0;
          l1 = l3;
          continue;
          label259:
          i = 0;
        }
      }
    }, 0L);
    AppMethodBeat.o(5939);
  }
  
  public final void a(t paramt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198690);
    if (paramt == null)
    {
      AppMethodBeat.o(198690);
      return;
    }
    a locala = (a)this.nAg.get(paramt.field_msgId + "_" + paramInt1);
    if (locala != null)
    {
      locala.EcI = 1;
      ac.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (!paramt.eZk()) {
      a(paramt, paramInt1, 11, paramInt2);
    }
    AppMethodBeat.o(198690);
  }
  
  public final void a(t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(5937);
    paramt = (a)this.nAg.get(Long.valueOf(paramt.field_msgId));
    if (paramt == null)
    {
      AppMethodBeat.o(5937);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramt.EbK = i;
      AppMethodBeat.o(5937);
      return;
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5941);
    a(paramString, paramLong, paramInt1, paramInt2, paramInt3, 0L, false, 0);
    AppMethodBeat.o(5941);
  }
  
  public final void a(String paramString, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(198691);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
      int j = paramInt3;
      if (!paramBoolean)
      {
        j = paramInt3;
        if (localai != null)
        {
          j = paramInt3;
          if (!com.tencent.mm.n.b.ln(localai.field_type)) {
            j = 2;
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(15721, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.daq), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), "", Integer.valueOf(j), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(198691);
      return;
    }
  }
  
  public final void c(final t paramt, final int paramInt)
  {
    AppMethodBeat.i(5935);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5930);
        h localh = h.this;
        t localt = paramt;
        int n = paramInt;
        int i1 = this.hXk;
        int m = this.nAh;
        Object localObject1;
        int j;
        int k;
        Object localObject2;
        h.a locala;
        if (localt != null) {
          if (localt.eZj()) {
            if (localt.eZj())
            {
              localObject1 = ((a)g.ab(a.class)).a(localt.field_msgId, localt.field_content);
              if ((localObject1 == null) || (bs.gY(((com.tencent.mm.ah.u)localObject1).hkS)))
              {
                AppMethodBeat.o(5930);
                return;
              }
              try
              {
                j = ((com.tencent.mm.ah.u)localObject1).hkS.size();
                if ((j <= 2) || (localt.field_isExpand)) {
                  break label1971;
                }
                j = 2;
              }
              catch (UnsupportedOperationException localUnsupportedOperationException)
              {
                for (;;)
                {
                  StringBuilder localStringBuilder;
                  Object localObject3;
                  ac.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
                  AppMethodBeat.o(5930);
                  return;
                  locala.Ecq = 0;
                }
              }
              catch (Exception localException1)
              {
                ac.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localException1.getMessage() });
              }
              if (k >= j) {
                break label918;
              }
              localObject2 = (v)((com.tencent.mm.ah.u)localObject1).hkS.get(k);
              if (localObject2 == null) {
                break label1976;
              }
              locala = (h.a)localh.nAg.get(localt.field_msgId + "_" + k);
              if (locala != null) {
                break label827;
              }
              locala = new h.a((byte)0);
              locala.eSi = localt.field_bizClientMsgId;
              localh.nAg.put(localt.field_msgId + "_" + k, locala);
              locala.Ecn = localt.field_talker;
              locala.Ecp = 1;
              locala.Ecx = ((int)(System.currentTimeMillis() / 1000L));
              locala.pos = n;
              locala.Ecr = 0;
              locala.Ect = 0;
              locala.Ecu = 0;
              locala.Ecw = 0;
              locala.EbK = 0;
              locala.Ecw = 0;
              locala.Ecy = ((int)(localt.field_createTime / 1000L));
              if (i1 != 4)
              {
                i = 0;
                label354:
                locala.EcA = i;
                locala.EcB = ((v)localObject2).type;
                localStringBuilder = new StringBuilder("1_");
                localObject3 = ((v)localObject2).url;
                if (!bs.isNullOrNil((String)localObject3)) {
                  break label686;
                }
                i = 0;
                label398:
                locala.EcC = (i + ";");
                locala.EcE = k;
                if (!localt.field_isExpand) {
                  break label1993;
                }
                i = 1;
                label433:
                locala.EcF = i;
                locala.EcH = m;
                if ((k != 0) || (!localt.GBZ)) {
                  break label1998;
                }
                i = 1;
                label460:
                locala.EcJ = i;
                if (!localt.GCa) {
                  break label2003;
                }
              }
            }
          }
        }
        label686:
        label822:
        label827:
        label1224:
        label1865:
        label1870:
        label2003:
        for (int i = 1;; i = 0)
        {
          locala.EcK = i;
          locala.EcN = ((v)localObject2).hhb;
          locala.EcO = localt.field_rankSessionId;
          locala.weight = ((int)localt.eZi());
          h.a(locala, localt.field_talker);
          long l;
          if (!bs.isNullOrNil(((v)localObject2).url))
          {
            localObject2 = Uri.parse(((v)localObject2).url);
            i = bs.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
            l = bs.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
            locala.Eco.add(Integer.valueOf(i));
            locala.dbz = l;
            locala.EcD = l;
          }
          if (localt.field_isExpand)
          {
            locala.Ecq = 2;
            label612:
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localt.field_talker);
            if ((localObject2 == null) || (com.tencent.mm.n.b.ln(((av)localObject2).field_type))) {
              break label822;
            }
          }
          for (i = 2;; i = 0)
          {
            locala.lRv = i;
            break label1976;
            if (System.currentTimeMillis() - localt.field_createTime > 86400000L) {
              break label1983;
            }
            i = 1;
            break;
            localObject3 = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Th((String)localObject3);
            if ((localObject3 == null) || (((p)localObject3).hkP == null)) {
              break label1988;
            }
            i = ((p)localObject3).hkP.hkJ;
            break label398;
            if (((com.tencent.mm.ah.u)localObject1).hkS.size() > 2)
            {
              locala.Ecq = 1;
              break label612;
            }
            AppMethodBeat.o(5930);
            return;
          }
          if ((k == 0) && (localt.GBZ))
          {
            i = 1;
            locala.EcJ = i;
            if (!localt.GCa) {
              break label913;
            }
          }
          for (i = 1;; i = 0)
          {
            locala.EcK = i;
            locala.Ecp += 1;
            locala.pos = n;
            locala.Ecx = ((int)(System.currentTimeMillis() / 1000L));
            h.a(locala, localt.field_talker);
            break label1976;
            i = 0;
            break;
          }
          AppMethodBeat.o(5930);
          return;
          if (localt.eZk())
          {
            localObject1 = localt.eZp();
            if ((localObject1 == null) || (((dgb)localObject1).FPq == null) || (((dgb)localObject1).FPq.size() <= 0))
            {
              ac.w("MicroMsg.BizTimeLineReport", "recCard is null");
              AppMethodBeat.o(5930);
              return;
            }
            k = ((dgb)localObject1).FPq.size();
            j = 0;
          }
          for (;;)
          {
            if (j < k)
            {
              localObject2 = (dgc)((dgb)localObject1).FPq.get(j);
              locala = (h.a)localException1.nAg.get(localt.field_msgId + "_" + j);
              if (locala == null)
              {
                locala = new h.a((byte)0);
                locala.eSi = localt.field_bizClientMsgId;
                localException1.nAg.put(localt.field_msgId + "_" + j, locala);
                locala.Ecn = localt.field_talker;
                if ((localObject2 != null) && ((((dgc)localObject2).DPI & 0x1) == 0))
                {
                  localObject2 = ((dgc)((dgb)localObject1).FPq.get(j)).Ean;
                  if (bs.isNullOrNil((String)localObject2)) {}
                }
              }
            }
            try
            {
              localObject2 = Uri.parse((String)localObject2);
              i = bs.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
              l = bs.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
              locala.Eco.add(Integer.valueOf(i));
              locala.dbz = l;
              locala.EcD = l;
              locala.Ecp = 1;
              locala.Ecx = ((int)(System.currentTimeMillis() / 1000L));
              locala.pos = n;
              locala.Ecw = 0;
              locala.Ecy = ((int)(localt.field_createTime / 1000L));
              if (i1 != 4)
              {
                i = 0;
                label1279:
                locala.EcA = i;
                locala.EcH = m;
                locala.lRv = 1;
                locala.EcO = localt.field_rankSessionId;
                locala.weight = ((int)localt.eZi());
                if (((dgb)localObject1).FPo != null) {
                  locala.EcM = x.aId(((dgb)localObject1).FPo.FPw);
                }
                localObject2 = localt.eZq();
                if (localObject2 != null) {
                  locala.EcL = ((dgg)localObject2).FPC;
                }
                locala.EcE = j;
                if (localt.GCc == null) {
                  break label1427;
                }
                i = localt.GCc.style;
                label1388:
                locala.style = i;
              }
              for (;;)
              {
                j += 1;
                break;
                if (System.currentTimeMillis() - localt.field_createTime <= 86400000L)
                {
                  i = 1;
                  break label1279;
                }
                i = 2;
                break label1279;
                i = 0;
                break label1388;
                locala.Ecp += 1;
                locala.pos = n;
                locala.Ecx = ((int)(System.currentTimeMillis() / 1000L));
              }
              AppMethodBeat.o(5930);
              return;
              localObject1 = (h.a)localException1.nAg.get(localt.field_msgId);
              if (localObject1 == null)
              {
                localObject1 = new h.a((byte)0);
                ((h.a)localObject1).eSi = localt.field_bizClientMsgId;
                localException1.nAg.put(localt.field_msgId, localObject1);
                ((h.a)localObject1).Ecn = localt.field_talker;
                ((h.a)localObject1).dbz = 0L;
                ((h.a)localObject1).Ecp = 1;
                ((h.a)localObject1).Ecx = ((int)(System.currentTimeMillis() / 1000L));
                ((h.a)localObject1).pos = n;
                ((h.a)localObject1).Ecr = 0;
                ((h.a)localObject1).Ect = 0;
                ((h.a)localObject1).Ecu = 0;
                ((h.a)localObject1).Ecw = 0;
                ((h.a)localObject1).EbK = 0;
                ((h.a)localObject1).Ecy = ((int)(localt.field_createTime / 1000L));
                if (i1 != 4)
                {
                  i = 0;
                  ((h.a)localObject1).EcA = i;
                  if (!localt.isText()) {
                    break label1829;
                  }
                  i = 1;
                  ((h.a)localObject1).EcB = i;
                  h.a((h.a)localObject1, localt.field_talker);
                  ((h.a)localObject1).EcH = m;
                  if (!localt.GBZ) {
                    break label1860;
                  }
                  i = 1;
                  ((h.a)localObject1).EcJ = i;
                  if (!localt.GCa) {
                    break label1865;
                  }
                  i = 1;
                  ((h.a)localObject1).EcK = i;
                  ((h.a)localObject1).EcO = localt.field_rankSessionId;
                  ((h.a)localObject1).weight = ((int)localt.eZi());
                  ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localt.field_talker);
                  if ((localai == null) || (com.tencent.mm.n.b.ln(localai.field_type))) {
                    break label1870;
                  }
                }
                for (i = 2;; i = 0)
                {
                  ((h.a)localObject1).lRv = i;
                  AppMethodBeat.o(5930);
                  return;
                  if (System.currentTimeMillis() - localt.field_createTime <= 86400000L)
                  {
                    i = 1;
                    break;
                  }
                  i = 2;
                  break;
                  if (localt.eZm())
                  {
                    i = 2;
                    break label1670;
                  }
                  if (localt.eZl())
                  {
                    i = 3;
                    break label1670;
                  }
                  i = -1;
                  break label1670;
                  i = 0;
                  break label1703;
                  i = 0;
                  break label1719;
                }
              }
              ((h.a)localObject1).Ecp += 1;
              ((h.a)localObject1).pos = n;
              ((h.a)localObject1).Ecx = ((int)(System.currentTimeMillis() / 1000L));
              h.a((h.a)localObject1, localt.field_talker);
              if (localt.GBZ)
              {
                i = 1;
                ((h.a)localObject1).EcJ = i;
                if (!localt.GCa) {
                  break label1961;
                }
              }
              for (i = 1;; i = 0)
              {
                ((h.a)localObject1).EcK = i;
                AppMethodBeat.o(5930);
                return;
                i = 0;
                break;
              }
            }
            catch (Exception localException2)
            {
              break label1224;
            }
          }
          k = 0;
          break;
          k += 1;
          break;
          i = 2;
          break label354;
          i = 0;
          break label398;
          i = 0;
          break label433;
          i = 0;
          break label460;
        }
      }
    }, 0L);
    AppMethodBeat.o(5935);
  }
  
  public final void d(t paramt, int paramInt)
  {
    AppMethodBeat.i(5938);
    a(paramt, 0, paramInt, -1);
    AppMethodBeat.o(5938);
  }
  
  public final void f(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(5943);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.wUl.f(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(this.daq), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(1) });
    AppMethodBeat.o(5943);
  }
  
  public final void yI(int paramInt)
  {
    AppMethodBeat.i(5940);
    a("", 0L, 0, paramInt, -1);
    AppMethodBeat.o(5940);
  }
  
  static final class a
    extends nb
  {
    public String eSi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.h
 * JD-Core Version:    0.7.0.1
 */