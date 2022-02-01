package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.n;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class g
{
  int dlK;
  int obk;
  int obl;
  HashMap<String, g.a> obm;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(5934);
    this.obm = new HashMap();
    this.dlK = paramInt;
    AppMethodBeat.o(5934);
  }
  
  static void a(g.a parama, String paramString)
  {
    AppMethodBeat.i(5936);
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString);
    if ((paramString != null) && (paramString.adq()))
    {
      parama.FIs = 1;
      parama.FIw = 1;
      AppMethodBeat.o(5936);
      return;
    }
    parama.FIs = 0;
    parama.FIw = 0;
    AppMethodBeat.o(5936);
  }
  
  private void a(final w paramw, final int paramInt1, final int paramInt2, final int paramInt3)
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
        if (paramw.fpd())
        {
          l2 = l1;
          l3 = l1;
        }
        for (;;)
        {
          try
          {
            Object localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).a(paramw.field_msgId, paramw.field_content);
            if (localObject == null) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            if (bt.hj(((u)localObject).hDb)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = (v)((u)localObject).hDb.get(paramInt1);
            l2 = l1;
            l3 = l1;
            if (bt.isNullOrNil(((v)localObject).url)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = Uri.parse(((v)localObject).url);
            l2 = l1;
            l3 = l1;
            l1 = bt.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
            l2 = l1;
            l3 = l1;
            i = bt.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            ad.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
            i = 0;
            l1 = l2;
            continue;
          }
          catch (Exception localException)
          {
            ad.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
          }
          g.this.a(paramw.field_talker, l1, i, paramInt2, paramInt3);
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
  
  static int d(w paramw)
  {
    AppMethodBeat.i(209501);
    if (paramw.isText())
    {
      AppMethodBeat.o(209501);
      return 1;
    }
    if (paramw.fpi())
    {
      AppMethodBeat.o(209501);
      return 2;
    }
    if (paramw.fph())
    {
      AppMethodBeat.o(209501);
      return 3;
    }
    AppMethodBeat.o(209501);
    return -1;
  }
  
  public final void a(w paramw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209500);
    if (paramw == null)
    {
      AppMethodBeat.o(209500);
      return;
    }
    g.a locala = (g.a)this.obm.get(paramw.field_msgId + "_" + paramInt1);
    if (locala != null)
    {
      locala.FIF = 1;
      ad.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (!paramw.fpe()) {
      a(paramw, paramInt1, 11, paramInt2);
    }
    AppMethodBeat.o(209500);
  }
  
  public final void a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(5937);
    paramw = (g.a)this.obm.get(Long.valueOf(paramw.field_msgId));
    if (paramw == null)
    {
      AppMethodBeat.o(5937);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramw.FHw = i;
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
    AppMethodBeat.i(209502);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString);
      int j = paramInt3;
      if (!paramBoolean)
      {
        j = paramInt3;
        if (localam != null)
        {
          j = paramInt3;
          if (!com.tencent.mm.o.b.lM(localam.field_type)) {
            j = 3;
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(15721, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.dlK), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), "", Integer.valueOf(j), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(209502);
      return;
    }
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, String paramString6)
  {
    AppMethodBeat.i(209504);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.g.yhR.f(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.dlK), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(3), Integer.valueOf(paramInt3), paramString3, paramString4, paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString6 });
    AppMethodBeat.o(209504);
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(221697);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.g.yhR.f(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(24), Integer.valueOf(i), Integer.valueOf(this.dlK), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(3), Integer.valueOf(0), paramString3, paramString4, paramString5, Integer.valueOf(0), Integer.valueOf(paramInt), paramString6, paramString7, paramString8 });
    AppMethodBeat.o(221697);
  }
  
  public final void c(final w paramw, final int paramInt)
  {
    AppMethodBeat.i(5935);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5930);
        Object localObject3 = g.this;
        Object localObject2 = paramw;
        int n = paramInt;
        int i1 = this.iqF;
        int m = this.obn;
        u localu;
        int j;
        int k;
        Object localObject5;
        Object localObject4;
        label354:
        Object localObject6;
        Object localObject7;
        if (localObject2 != null) {
          if (((w)localObject2).fpd()) {
            if (((w)localObject2).fpd())
            {
              localu = ((a)com.tencent.mm.kernel.g.ab(a.class)).a(((w)localObject2).field_msgId, ((w)localObject2).field_content);
              if ((localu == null) || (bt.hj(localu.hDb)))
              {
                AppMethodBeat.o(5930);
                return;
              }
              try
              {
                j = localu.hDb.size();
                if ((j <= 2) || (((w)localObject2).field_isExpand)) {
                  break label3342;
                }
                j = 2;
              }
              catch (UnsupportedOperationException localUnsupportedOperationException)
              {
                for (;;)
                {
                  ad.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
                  AppMethodBeat.o(5930);
                  return;
                  ((g.a)localObject4).FIn = 0;
                }
              }
              catch (Exception localException1)
              {
                ad.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localException1.getMessage() });
              }
              if (k >= j) {
                break label918;
              }
              localObject5 = (v)localu.hDb.get(k);
              if (localObject5 == null) {
                break label3347;
              }
              localObject4 = (g.a)((g)localObject3).obm.get(((w)localObject2).field_msgId + "_" + k);
              if (localObject4 != null) {
                break label827;
              }
              localObject4 = new g.a((byte)0);
              ((g.a)localObject4).fkx = ((w)localObject2).field_bizClientMsgId;
              ((g)localObject3).obm.put(((w)localObject2).field_msgId + "_" + k, localObject4);
              ((g.a)localObject4).FIk = ((w)localObject2).field_talker;
              ((g.a)localObject4).FIm = 1;
              ((g.a)localObject4).FIu = ((int)(System.currentTimeMillis() / 1000L));
              ((g.a)localObject4).pos = n;
              ((g.a)localObject4).FIo = 0;
              ((g.a)localObject4).FIq = 0;
              ((g.a)localObject4).FIr = 0;
              ((g.a)localObject4).FIt = 0;
              ((g.a)localObject4).FHw = 0;
              ((g.a)localObject4).FIt = 0;
              ((g.a)localObject4).FIv = ((int)(((w)localObject2).field_createTime / 1000L));
              if (i1 != 4)
              {
                i = 0;
                ((g.a)localObject4).FIx = i;
                ((g.a)localObject4).FIy = ((v)localObject5).type;
                localObject6 = new StringBuilder("1_");
                localObject7 = ((v)localObject5).url;
                if (!bt.isNullOrNil((String)localObject7)) {
                  break label686;
                }
                i = 0;
                label398:
                ((g.a)localObject4).FIz = (i + ";");
                ((g.a)localObject4).FIB = k;
                if (!((w)localObject2).field_isExpand) {
                  break label3364;
                }
                i = 1;
                label433:
                ((g.a)localObject4).FIC = i;
                ((g.a)localObject4).FIE = m;
                if ((k != 0) || (!((w)localObject2).Ion)) {
                  break label3369;
                }
                i = 1;
                label460:
                ((g.a)localObject4).FIG = i;
                if (!((w)localObject2).Ioo) {
                  break label3374;
                }
              }
            }
          }
        }
        label913:
        label918:
        label1453:
        label3374:
        for (int i = 1;; i = 0)
        {
          ((g.a)localObject4).FIH = i;
          ((g.a)localObject4).FIK = ((v)localObject5).hzk;
          ((g.a)localObject4).FIL = ((w)localObject2).field_rankSessionId;
          ((g.a)localObject4).weight = ((int)((w)localObject2).fpc());
          g.a((g.a)localObject4, ((w)localObject2).field_talker);
          long l;
          if (!bt.isNullOrNil(((v)localObject5).url))
          {
            localObject5 = Uri.parse(((v)localObject5).url);
            i = bt.getInt(((Uri)localObject5).getQueryParameter("idx"), 0);
            l = bt.getLong(((Uri)localObject5).getQueryParameter("mid"), 0L);
            ((g.a)localObject4).FIl.add(Integer.valueOf(i));
            ((g.a)localObject4).dmV = l;
            ((g.a)localObject4).FIA = l;
          }
          if (((w)localObject2).field_isExpand)
          {
            ((g.a)localObject4).FIn = 2;
            label612:
            localObject5 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(((w)localObject2).field_talker);
            if ((localObject5 == null) || (com.tencent.mm.o.b.lM(((aw)localObject5).field_type))) {
              break label822;
            }
          }
          label686:
          label822:
          for (i = 2;; i = 0)
          {
            ((g.a)localObject4).mrl = i;
            break label3347;
            if (System.currentTimeMillis() - ((w)localObject2).field_createTime > 86400000L) {
              break label3354;
            }
            i = 1;
            break;
            localObject7 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WN((String)localObject7);
            if ((localObject7 == null) || (((com.tencent.mm.ai.p)localObject7).hCY == null)) {
              break label3359;
            }
            i = ((com.tencent.mm.ai.p)localObject7).hCY.hCS;
            break label398;
            if (localu.hDb.size() > 2)
            {
              ((g.a)localObject4).FIn = 1;
              break label612;
            }
            AppMethodBeat.o(5930);
            return;
          }
          label827:
          if ((k == 0) && (((w)localObject2).Ion))
          {
            i = 1;
            ((g.a)localObject4).FIG = i;
            if (!((w)localObject2).Ioo) {
              break label913;
            }
          }
          for (i = 1;; i = 0)
          {
            ((g.a)localObject4).FIH = i;
            ((g.a)localObject4).FIm += 1;
            ((g.a)localObject4).pos = n;
            ((g.a)localObject4).FIu = ((int)(System.currentTimeMillis() / 1000L));
            g.a((g.a)localObject4, ((w)localObject2).field_talker);
            break label3347;
            i = 0;
            break;
          }
          AppMethodBeat.o(5930);
          return;
          if (((w)localObject2).fpe())
          {
            localObject4 = ((w)localObject2).fpm();
            if ((localObject4 != null) && ((((dlt)localObject4).style == 101) || (((dlt)localObject4).style == 102)))
            {
              localObject5 = ((dlt)localObject4).HAf;
              if ((localObject5 == null) || (bt.hj(((aig)localObject5).FHP)))
              {
                AppMethodBeat.o(5930);
                return;
              }
              j = 0;
            }
          }
          for (;;)
          {
            Object localObject1;
            if (j < ((aig)localObject5).FHP.size()) {
              if (((ok)((aig)localObject5).FHP.get(j)).FuX == 0)
              {
                localObject1 = (oj)((ok)((aig)localObject5).FHP.get(j)).FJV.get(0);
                localObject6 = (g.a)((g)localObject3).obm.get(((w)localObject2).field_msgId + "_" + j);
                if (localObject6 != null) {
                  break label1593;
                }
                localObject6 = new g.a((byte)0);
                ((g.a)localObject6).fkx = ((w)localObject2).field_bizClientMsgId;
                ((g)localObject3).obm.put(((w)localObject2).field_msgId + "_" + j, localObject6);
                ((g.a)localObject6).FIk = ((w)localObject2).field_talker;
                if ((localObject1 != null) && ((((oj)localObject1).FuX & 0x1) == 0))
                {
                  localObject7 = ((oj)localObject1).FFW;
                  if (bt.isNullOrNil((String)localObject7)) {}
                }
              }
            }
            try
            {
              localObject7 = Uri.parse((String)localObject7);
              i = bt.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
              l = bt.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
              ((g.a)localObject6).FIl.add(Integer.valueOf(i));
              ((g.a)localObject6).dmV = l;
              ((g.a)localObject6).FIA = l;
              label1255:
              ((g.a)localObject6).FIN = ((oj)localObject1).FJR;
              ((g.a)localObject6).FIO = ((oj)localObject1).FJS;
              ((g.a)localObject6).FIm = 1;
              ((g.a)localObject6).FIu = ((int)(System.currentTimeMillis() / 1000L));
              ((g.a)localObject6).pos = n;
              ((g.a)localObject6).FIt = 0;
              ((g.a)localObject6).FIv = ((int)(((w)localObject2).field_createTime / 1000L));
              if (i1 != 4)
              {
                i = 0;
                label1330:
                ((g.a)localObject6).FIx = i;
                ((g.a)localObject6).FIE = m;
                ((g.a)localObject6).mrl = 3;
                ((g.a)localObject6).FIL = ((w)localObject2).field_rankSessionId;
                ((g.a)localObject6).weight = ((int)((w)localObject2).fpc());
                if (((oj)localObject1).uhr != null) {
                  ((g.a)localObject6).FIJ = com.tencent.mm.pluginsdk.ui.tools.x.aNF(((oj)localObject1).uhr);
                }
                if (localObject4 != null) {
                  ((g.a)localObject6).FII = ((dlt)localObject4).Hki;
                }
                ((g.a)localObject6).FIB = j;
                if (((w)localObject2).Ioq == null) {
                  break label1580;
                }
                i = ((w)localObject2).Ioq.style;
                ((g.a)localObject6).style = i;
                if (((w)localObject2).Ioq == null) {
                  break label1585;
                }
                localObject1 = ((w)localObject2).Ioq.dln;
                ((g.a)localObject6).dln = ((String)localObject1);
                if ((((w)localObject2).Ioq != null) && (((w)localObject2).Ioq.HAf != null))
                {
                  ((g.a)localObject6).dHX = ((w)localObject2).Ioq.HAf.FHU;
                  ((g.a)localObject6).FIM = ((w)localObject2).Ioq.HAf.FHY;
                }
                if (((dlt)localObject4).style == 102)
                {
                  ((g.a)localObject6).FIS = ((dlt)localObject4).HAf.GfO;
                  ((g.a)localObject6).FIR = ((dlt)localObject4).HAf.GfN;
                }
              }
              for (;;)
              {
                j += 1;
                break;
                if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                {
                  i = 1;
                  break label1330;
                }
                i = 2;
                break label1330;
                i = 0;
                break label1429;
                label1585:
                localObject1 = "";
                break label1453;
                label1593:
                ((g.a)localObject6).FIm += 1;
                ((g.a)localObject6).pos = n;
                ((g.a)localObject6).FIu = ((int)(System.currentTimeMillis() / 1000L));
              }
              AppMethodBeat.o(5930);
              return;
              if ((localObject4 != null) && (((dlt)localObject4).style == 1001) && (((dlt)localObject4).HAh != null))
              {
                if (((w)localObject2).fpe())
                {
                  localObject1 = (g.a)((g)localObject3).obm.get(((w)localObject2).field_msgId + "_0");
                  if (localObject1 != null) {
                    break label1952;
                  }
                  localObject1 = new g.a((byte)0);
                  ((g)localObject3).obm.put(((w)localObject2).field_msgId + "_0", localObject1);
                  ((g.a)localObject1).FIQ = ((dlt)localObject4).HAh.dzP;
                  ((g.a)localObject1).fkx = ((w)localObject2).field_bizClientMsgId;
                  ((g.a)localObject1).FIm = 1;
                  ((g.a)localObject1).pos = n;
                  ((g.a)localObject1).FIu = ((int)(System.currentTimeMillis() / 1000L));
                  ((g.a)localObject1).FIt = 0;
                  ((g.a)localObject1).FIv = ((int)(((w)localObject2).field_createTime / 1000L));
                  if (i1 == 4) {
                    break label1926;
                  }
                  i = 0;
                  ((g.a)localObject1).FIx = i;
                  ((g.a)localObject1).FIE = m;
                  ((g.a)localObject1).mrl = 5;
                  ((g.a)localObject1).FIL = ((w)localObject2).field_rankSessionId;
                  ((g.a)localObject1).weight = ((int)((w)localObject2).fpc());
                  if (localObject4 != null) {
                    ((g.a)localObject1).FII = ((dlt)localObject4).Hki;
                  }
                  ((g.a)localObject1).style = 1001;
                }
                for (;;)
                {
                  ad.d("MicroMsg.BizTimeLineReport", "onExposeRecCanvasMsg %d", new Object[] { Long.valueOf(((w)localObject2).field_msgId) });
                  AppMethodBeat.o(5930);
                  return;
                  if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                  {
                    i = 1;
                    break;
                  }
                  i = 2;
                  break;
                  ((g.a)localObject1).FIm += 1;
                  ((g.a)localObject1).pos = n;
                  ((g.a)localObject1).FIu = ((int)(System.currentTimeMillis() / 1000L));
                }
              }
              localObject1 = ((w)localObject2).fpl();
              if ((localObject1 == null) || (((dlo)localObject1).FJV == null) || (((dlo)localObject1).FJV.size() <= 0))
              {
                ad.w("MicroMsg.BizTimeLineReport", "recCard is null");
                AppMethodBeat.o(5930);
                return;
              }
              k = ((dlo)localObject1).FJV.size();
              j = 0;
              for (;;)
              {
                if (j < k)
                {
                  localObject6 = (dlp)((dlo)localObject1).FJV.get(j);
                  localObject5 = (g.a)((g)localObject3).obm.get(((w)localObject2).field_msgId + "_" + j);
                  if (localObject5 == null)
                  {
                    localObject5 = new g.a((byte)0);
                    ((g.a)localObject5).fkx = ((w)localObject2).field_bizClientMsgId;
                    ((g)localObject3).obm.put(((w)localObject2).field_msgId + "_" + j, localObject5);
                    ((g.a)localObject5).FIk = ((w)localObject2).field_talker;
                    if ((localObject6 != null) && ((((dlp)localObject6).FuX & 0x1) == 0))
                    {
                      localObject6 = ((dlp)((dlo)localObject1).FJV.get(j)).FFW;
                      if (bt.isNullOrNil((String)localObject6)) {}
                    }
                  }
                }
                try
                {
                  localObject6 = Uri.parse((String)localObject6);
                  i = bt.getInt(((Uri)localObject6).getQueryParameter("idx"), 0);
                  l = bt.getLong(((Uri)localObject6).getQueryParameter("mid"), 0L);
                  ((g.a)localObject5).FIl.add(Integer.valueOf(i));
                  ((g.a)localObject5).dmV = l;
                  ((g.a)localObject5).FIA = l;
                  label2278:
                  ((g.a)localObject5).FIm = 1;
                  ((g.a)localObject5).FIu = ((int)(System.currentTimeMillis() / 1000L));
                  ((g.a)localObject5).pos = n;
                  ((g.a)localObject5).FIt = 0;
                  ((g.a)localObject5).FIv = ((int)(((w)localObject2).field_createTime / 1000L));
                  if (i1 != 4)
                  {
                    i = 0;
                    ((g.a)localObject5).FIx = i;
                    ((g.a)localObject5).FIE = m;
                    ((g.a)localObject5).mrl = 1;
                    ((g.a)localObject5).FIL = ((w)localObject2).field_rankSessionId;
                    ((g.a)localObject5).weight = ((int)((w)localObject2).fpc());
                    if (((dlo)localObject1).HzY != null) {
                      ((g.a)localObject5).FIJ = com.tencent.mm.pluginsdk.ui.tools.x.aNF(((dlo)localObject1).HzY.HAa);
                    }
                    if (localObject4 != null) {
                      ((g.a)localObject5).FII = ((dlt)localObject4).Hki;
                    }
                    ((g.a)localObject5).FIB = j;
                    if (((w)localObject2).Ioq == null) {
                      break label2474;
                    }
                    i = ((w)localObject2).Ioq.style;
                    ((g.a)localObject5).style = i;
                  }
                  for (;;)
                  {
                    j += 1;
                    break;
                    if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                    {
                      i = 1;
                      break label2333;
                    }
                    i = 2;
                    break label2333;
                    i = 0;
                    break label2435;
                    ((g.a)localObject5).FIm += 1;
                    ((g.a)localObject5).pos = n;
                    ((g.a)localObject5).FIu = ((int)(System.currentTimeMillis() / 1000L));
                  }
                  AppMethodBeat.o(5930);
                  return;
                  if (((w)localObject2).fpf())
                  {
                    if (((w)localObject2).fpf())
                    {
                      localObject1 = (g.a)((g)localObject3).obm.get(((w)localObject2).field_msgId);
                      if (localObject1 == null)
                      {
                        localObject1 = new g.a((byte)0);
                        ((g)localObject3).obm.put(((w)localObject2).field_msgId, localObject1);
                        ((g.a)localObject1).fkx = ((w)localObject2).field_bizClientMsgId;
                        ((g.a)localObject1).FIk = ((w)localObject2).field_talker;
                        ((g.a)localObject1).FIm = 1;
                        ((g.a)localObject1).FIu = ((int)(System.currentTimeMillis() / 1000L));
                        ((g.a)localObject1).pos = n;
                        ((g.a)localObject1).FIv = ((int)(((w)localObject2).field_createTime / 1000L));
                        if (i1 != 4)
                        {
                          i = 0;
                          ((g.a)localObject1).FIx = i;
                          ((g.a)localObject1).FIy = g.d((w)localObject2);
                          g.a((g.a)localObject1, ((w)localObject2).field_talker);
                          ((g.a)localObject1).FIE = m;
                          ((g.a)localObject1).FIL = ((w)localObject2).field_rankSessionId;
                          ((g.a)localObject1).weight = ((int)((w)localObject2).fpc());
                          ((g.a)localObject1).mrl = aa.t((w)localObject2);
                          localObject3 = ((w)localObject2).fpo();
                          ((g.a)localObject1).zuP = ((String)localObject3);
                          ((g.a)localObject1).zuO = ((w)localObject2).getTraceId();
                          localObject2 = com.tencent.mm.storage.p.InU;
                          if (!com.tencent.mm.storage.p.aSr((String)localObject3)) {
                            break label2823;
                          }
                        }
                        for (i = 1;; i = 0)
                        {
                          ((g.a)localObject1).FIP = i;
                          AppMethodBeat.o(5930);
                          return;
                          if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                          {
                            i = 1;
                            break;
                          }
                          i = 2;
                          break;
                        }
                      }
                      ((g.a)localObject1).FIm += 1;
                      ((g.a)localObject1).pos = n;
                      ((g.a)localObject1).FIu = ((int)(System.currentTimeMillis() / 1000L));
                      g.a((g.a)localObject1, ((w)localObject2).field_talker);
                    }
                    AppMethodBeat.o(5930);
                    return;
                  }
                  localObject1 = (g.a)((g)localObject3).obm.get(((w)localObject2).field_msgId);
                  if (localObject1 == null)
                  {
                    localObject1 = new g.a((byte)0);
                    ((g.a)localObject1).fkx = ((w)localObject2).field_bizClientMsgId;
                    ((g)localObject3).obm.put(((w)localObject2).field_msgId, localObject1);
                    ((g.a)localObject1).FIk = ((w)localObject2).field_talker;
                    ((g.a)localObject1).dmV = 0L;
                    ((g.a)localObject1).FIm = 1;
                    ((g.a)localObject1).FIu = ((int)(System.currentTimeMillis() / 1000L));
                    ((g.a)localObject1).pos = n;
                    ((g.a)localObject1).FIo = 0;
                    ((g.a)localObject1).FIq = 0;
                    ((g.a)localObject1).FIr = 0;
                    ((g.a)localObject1).FIt = 0;
                    ((g.a)localObject1).FHw = 0;
                    ((g.a)localObject1).FIv = ((int)(((w)localObject2).field_createTime / 1000L));
                    if (i1 != 4)
                    {
                      i = 0;
                      ((g.a)localObject1).FIx = i;
                      ((g.a)localObject1).FIy = g.d((w)localObject2);
                      g.a((g.a)localObject1, ((w)localObject2).field_talker);
                      ((g.a)localObject1).FIE = m;
                      if (!((w)localObject2).Ion) {
                        break label3226;
                      }
                      i = 1;
                      ((g.a)localObject1).FIG = i;
                      if (!((w)localObject2).Ioo) {
                        break label3231;
                      }
                      i = 1;
                      ((g.a)localObject1).FIH = i;
                      ((g.a)localObject1).FIL = ((w)localObject2).field_rankSessionId;
                      ((g.a)localObject1).weight = ((int)((w)localObject2).fpc());
                      localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(((w)localObject2).field_talker);
                      if ((localObject2 == null) || (com.tencent.mm.o.b.lM(((aw)localObject2).field_type))) {
                        break label3236;
                      }
                    }
                    for (i = 3;; i = 0)
                    {
                      ((g.a)localObject1).mrl = i;
                      AppMethodBeat.o(5930);
                      return;
                      if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                      {
                        i = 1;
                        break;
                      }
                      i = 2;
                      break;
                      i = 0;
                      break label3100;
                      i = 0;
                      break label3116;
                    }
                  }
                  ((g.a)localObject1).FIm += 1;
                  ((g.a)localObject1).pos = n;
                  ((g.a)localObject1).FIu = ((int)(System.currentTimeMillis() / 1000L));
                  g.a((g.a)localObject1, ((w)localObject2).field_talker);
                  if (((w)localObject2).Ion)
                  {
                    i = 1;
                    ((g.a)localObject1).FIG = i;
                    if (!((w)localObject2).Ioo) {
                      break label3327;
                    }
                  }
                  label3327:
                  for (i = 1;; i = 0)
                  {
                    ((g.a)localObject1).FIH = i;
                    AppMethodBeat.o(5930);
                    return;
                    i = 0;
                    break;
                  }
                }
                catch (Exception localException2)
                {
                  break label2278;
                }
              }
            }
            catch (Exception localException3)
            {
              break label1255;
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
  
  public final void d(w paramw, int paramInt)
  {
    AppMethodBeat.i(5938);
    a(paramw, 0, paramInt, -1);
    AppMethodBeat.o(5938);
  }
  
  public final void f(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(209503);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.g.yhR.f(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(this.dlK), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(209503);
  }
  
  public final void zs(int paramInt)
  {
    AppMethodBeat.i(5940);
    a("", 0L, 0, paramInt, -1);
    AppMethodBeat.o(5940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g
 * JD-Core Version:    0.7.0.1
 */