package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.n;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class g
{
  int dmM;
  int oha;
  int ohb;
  HashMap<String, g.a> ohc;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(5934);
    this.ohc = new HashMap();
    this.dmM = paramInt;
    AppMethodBeat.o(5934);
  }
  
  static void a(g.a parama, String paramString)
  {
    AppMethodBeat.i(5936);
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
    if ((paramString != null) && (paramString.adB()))
    {
      parama.GaP = 1;
      parama.GaT = 1;
      AppMethodBeat.o(5936);
      return;
    }
    parama.GaP = 0;
    parama.GaT = 0;
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
        if (paramw.fta())
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
            if (bu.ht(((u)localObject).hFT)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = (v)((u)localObject).hFT.get(paramInt1);
            l2 = l1;
            l3 = l1;
            if (bu.isNullOrNil(((v)localObject).url)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = Uri.parse(((v)localObject).url);
            l2 = l1;
            l3 = l1;
            l1 = bu.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
            l2 = l1;
            l3 = l1;
            i = bu.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            ae.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
            i = 0;
            l1 = l2;
            continue;
          }
          catch (Exception localException)
          {
            ae.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
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
    AppMethodBeat.i(208455);
    if (paramw.isText())
    {
      AppMethodBeat.o(208455);
      return 1;
    }
    if (paramw.ftg())
    {
      AppMethodBeat.o(208455);
      return 2;
    }
    if (paramw.ftf())
    {
      AppMethodBeat.o(208455);
      return 3;
    }
    AppMethodBeat.o(208455);
    return -1;
  }
  
  public static void f(dmq paramdmq)
  {
    AppMethodBeat.i(224125);
    if (paramdmq.HTS != null) {
      com.tencent.mm.plugin.report.service.g.yxI.f(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), paramdmq.HTS.Gaq, Long.valueOf(paramdmq.HDI), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(paramdmq.style), paramdmq.HTS.Gau });
    }
    AppMethodBeat.o(224125);
  }
  
  public final void a(w paramw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208454);
    if (paramw == null)
    {
      AppMethodBeat.o(208454);
      return;
    }
    g.a locala = (g.a)this.ohc.get(paramw.field_msgId + "_" + paramInt1);
    if (locala != null)
    {
      locala.Gbc = 1;
      ae.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (!paramw.ftb()) {
      a(paramw, paramInt1, 11, paramInt2);
    }
    AppMethodBeat.o(208454);
  }
  
  public final void a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(5937);
    paramw = (g.a)this.ohc.get(Long.valueOf(paramw.field_msgId));
    if (paramw == null)
    {
      AppMethodBeat.o(5937);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramw.FZS = i;
      AppMethodBeat.o(5937);
      return;
    }
  }
  
  public final void a(String paramString1, int paramInt1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(224126);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt2 == 103) {
      i = 5;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(this.dmM), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(i), Integer.valueOf(0), paramString3, paramString4, paramString5, Integer.valueOf(0), Integer.valueOf(paramInt2), paramString6, paramString7, paramString8 });
    AppMethodBeat.o(224126);
  }
  
  public final void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5941);
    a(paramString, paramLong, paramInt1, paramInt2, paramInt3, 0L, false, 0);
    AppMethodBeat.o(5941);
  }
  
  public final void a(String paramString, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(208456);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
      int j = paramInt3;
      if (!paramBoolean)
      {
        j = paramInt3;
        if (localan != null)
        {
          j = paramInt3;
          if (!c.lO(localan.field_type)) {
            j = 3;
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(15721, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.dmM), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), "", Integer.valueOf(j), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(208456);
      return;
    }
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, String paramString6)
  {
    AppMethodBeat.i(208458);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt5 == 103) {
      i = 5;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(this.dmM), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(i), Integer.valueOf(paramInt3), paramString3, paramString4, paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString6 });
    AppMethodBeat.o(208458);
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
        int i1 = this.itA;
        int m = this.ohd;
        u localu;
        int j;
        int k;
        Object localObject4;
        Object localObject5;
        label354:
        Object localObject6;
        Object localObject7;
        if (localObject2 != null) {
          if (((w)localObject2).fta()) {
            if (((w)localObject2).fta())
            {
              localu = ((a)com.tencent.mm.kernel.g.ab(a.class)).a(((w)localObject2).field_msgId, ((w)localObject2).field_content);
              if ((localu == null) || (bu.ht(localu.hFT)))
              {
                AppMethodBeat.o(5930);
                return;
              }
              try
              {
                j = localu.hFT.size();
                if ((j <= 2) || (((w)localObject2).field_isExpand)) {
                  break label3677;
                }
                j = 2;
              }
              catch (UnsupportedOperationException localUnsupportedOperationException)
              {
                for (;;)
                {
                  ae.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
                  AppMethodBeat.o(5930);
                  return;
                  ((g.a)localObject5).GaK = 0;
                }
              }
              catch (Exception localException1)
              {
                ae.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localException1.getMessage() });
              }
              if (k >= j) {
                break label937;
              }
              localObject4 = (v)localu.hFT.get(k);
              if (localObject4 == null) {
                break label3682;
              }
              localObject5 = (g.a)((g)localObject3).ohc.get(((w)localObject2).field_msgId + "_" + k);
              if (localObject5 != null) {
                break label846;
              }
              localObject5 = new g.a((byte)0);
              ((g.a)localObject5).fmu = ((w)localObject2).field_bizClientMsgId;
              ((g)localObject3).ohc.put(((w)localObject2).field_msgId + "_" + k, localObject5);
              ((g.a)localObject5).GaH = ((w)localObject2).field_talker;
              ((g.a)localObject5).GaJ = 1;
              ((g.a)localObject5).GaR = ((int)(System.currentTimeMillis() / 1000L));
              ((g.a)localObject5).pos = n;
              ((g.a)localObject5).GaL = 0;
              ((g.a)localObject5).GaN = 0;
              ((g.a)localObject5).GaO = 0;
              ((g.a)localObject5).GaQ = 0;
              ((g.a)localObject5).FZS = 0;
              ((g.a)localObject5).GaQ = 0;
              ((g.a)localObject5).GaS = ((int)(((w)localObject2).field_createTime / 1000L));
              if (i1 != 4)
              {
                i = 0;
                ((g.a)localObject5).GaU = i;
                ((g.a)localObject5).GaV = ((v)localObject4).type;
                localObject6 = new StringBuilder("1_");
                localObject7 = ((v)localObject4).url;
                if (!bu.isNullOrNil((String)localObject7)) {
                  break label705;
                }
                i = 0;
                label398:
                ((g.a)localObject5).GaW = (i + ";");
                ((g.a)localObject5).GaY = k;
                if (!((w)localObject2).field_isExpand) {
                  break label3699;
                }
                i = 1;
                label433:
                ((g.a)localObject5).GaZ = i;
                ((g.a)localObject5).Gbb = m;
                if ((k != 0) || (!((w)localObject2).IID)) {
                  break label3704;
                }
                i = 1;
                label460:
                ((g.a)localObject5).Gbd = i;
                if (!((w)localObject2).IIE) {
                  break label3709;
                }
              }
            }
          }
        }
        label612:
        label3689:
        label3694:
        label3699:
        label3704:
        label3709:
        for (int i = 1;; i = 0)
        {
          ((g.a)localObject5).Gbe = i;
          ((g.a)localObject5).Gbh = ((v)localObject4).hBY;
          ((g.a)localObject5).Gbi = ((w)localObject2).field_rankSessionId;
          ((g.a)localObject5).weight = ((int)((w)localObject2).fsZ());
          g.a((g.a)localObject5, ((w)localObject2).field_talker);
          long l1;
          if (!bu.isNullOrNil(((v)localObject4).url))
          {
            localObject6 = Uri.parse(((v)localObject4).url);
            i = bu.getInt(((Uri)localObject6).getQueryParameter("idx"), 0);
            l1 = bu.getLong(((Uri)localObject6).getQueryParameter("mid"), 0L);
            ((g.a)localObject5).GaI.add(Integer.valueOf(i));
            ((g.a)localObject5).dnX = l1;
            ((g.a)localObject5).GaX = l1;
          }
          if (((w)localObject2).field_isExpand)
          {
            ((g.a)localObject5).GaK = 2;
            localObject6 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(((w)localObject2).field_talker);
            if ((localObject6 == null) || (c.lO(((aw)localObject6).field_type))) {
              break label841;
            }
          }
          for (i = 2;; i = 0)
          {
            ((g.a)localObject5).mwj = i;
            if (((v)localObject4).type != 5) {
              break label3682;
            }
            ((g.a)localObject5).udb = ((v)localObject4).hCa;
            break label3682;
            if (System.currentTimeMillis() - ((w)localObject2).field_createTime > 86400000L) {
              break label3689;
            }
            i = 1;
            break;
            localObject7 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xz((String)localObject7);
            if ((localObject7 == null) || (((com.tencent.mm.ah.p)localObject7).hFQ == null)) {
              break label3694;
            }
            i = ((com.tencent.mm.ah.p)localObject7).hFQ.hFK;
            break label398;
            if (localu.hFT.size() > 2)
            {
              ((g.a)localObject5).GaK = 1;
              break label612;
            }
            AppMethodBeat.o(5930);
            return;
          }
          if ((k == 0) && (((w)localObject2).IID))
          {
            i = 1;
            ((g.a)localObject5).Gbd = i;
            if (!((w)localObject2).IIE) {
              break label932;
            }
          }
          for (i = 1;; i = 0)
          {
            ((g.a)localObject5).Gbe = i;
            ((g.a)localObject5).GaJ += 1;
            ((g.a)localObject5).pos = n;
            ((g.a)localObject5).GaR = ((int)(System.currentTimeMillis() / 1000L));
            g.a((g.a)localObject5, ((w)localObject2).field_talker);
            break label3682;
            i = 0;
            break;
          }
          AppMethodBeat.o(5930);
          return;
          Object localObject1;
          if (((w)localObject2).ftb())
          {
            localObject4 = ((w)localObject2).ftk();
            if ((localObject4 != null) && ((((dmq)localObject4).style == 101) || (((dmq)localObject4).style == 102) || (((dmq)localObject4).style == 103)))
            {
              localObject5 = ((dmq)localObject4).HTS;
              if ((localObject5 == null) || (bu.ht(((aiq)localObject5).Gal)))
              {
                AppMethodBeat.o(5930);
                return;
              }
              k = 0;
              i = 0;
              if (k < ((aiq)localObject5).Gal.size())
              {
                if (((om)((aiq)localObject5).Gal.get(k)).FNv != 0) {
                  break label3674;
                }
                localObject1 = (ol)((om)((aiq)localObject5).Gal.get(k)).Gcu.get(0);
                localObject6 = (g.a)((g)localObject3).ohc.get(((w)localObject2).field_msgId + "_" + k);
                if (localObject6 == null)
                {
                  localObject6 = new g.a((byte)0);
                  ((g.a)localObject6).fmu = ((w)localObject2).field_bizClientMsgId;
                  ((g)localObject3).ohc.put(((w)localObject2).field_msgId + "_" + k, localObject6);
                  ((g.a)localObject6).GaH = ((w)localObject2).field_talker;
                  if ((localObject1 != null) && ((((ol)localObject1).FNv & 0x1) == 0))
                  {
                    localObject7 = ((ol)localObject1).FYs;
                    if (bu.isNullOrNil((String)localObject7)) {}
                  }
                }
              }
            }
          }
          for (;;)
          {
            try
            {
              localObject7 = Uri.parse((String)localObject7);
              j = bu.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
              l1 = bu.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
              ((g.a)localObject6).GaI.add(Integer.valueOf(j));
              ((g.a)localObject6).dnX = l1;
              ((g.a)localObject6).GaX = l1;
              ((g.a)localObject6).Gbk = ((ol)localObject1).Gcq;
              ((g.a)localObject6).Gbl = ((ol)localObject1).Gcr;
              ((g.a)localObject6).GaJ = 1;
              ((g.a)localObject6).GaR = ((int)(System.currentTimeMillis() / 1000L));
              ((g.a)localObject6).pos = n;
              ((g.a)localObject6).GaQ = 0;
              ((g.a)localObject6).GaS = ((int)(((w)localObject2).field_createTime / 1000L));
              if (i1 != 4)
              {
                j = 0;
                ((g.a)localObject6).GaU = j;
                ((g.a)localObject6).Gbb = m;
                j = 3;
                if (((dmq)localObject4).style == 103) {
                  j = 5;
                }
                ((g.a)localObject6).mwj = j;
                ((g.a)localObject6).Gbi = ((w)localObject2).field_rankSessionId;
                ((g.a)localObject6).weight = ((int)((w)localObject2).fsZ());
                if (((ol)localObject1).usP != null) {
                  ((g.a)localObject6).Gbg = com.tencent.mm.pluginsdk.ui.tools.x.aPc(((ol)localObject1).usP);
                }
                if (localObject4 != null) {
                  ((g.a)localObject6).Gbf = ((dmq)localObject4).HDI;
                }
                ((g.a)localObject6).GaY = k;
                if (((w)localObject2).IIG == null) {
                  continue;
                }
                j = ((w)localObject2).IIG.style;
                ((g.a)localObject6).style = j;
                if (((w)localObject2).IIG == null) {
                  continue;
                }
                localObject1 = ((w)localObject2).IIG.dmp;
                ((g.a)localObject6).dmp = ((String)localObject1);
                if ((((w)localObject2).IIG != null) && (((w)localObject2).IIG.HTS != null))
                {
                  ((g.a)localObject6).dJb = ((w)localObject2).IIG.HTS.Gaq;
                  ((g.a)localObject6).Gbj = ((w)localObject2).IIG.HTS.Gau;
                }
                if ((((dmq)localObject4).style == 102) || (((dmq)localObject4).style == 103))
                {
                  ((g.a)localObject6).Gbp = ((dmq)localObject4).HTS.Gyw;
                  ((g.a)localObject6).Gbo = ((dmq)localObject4).HTS.Gyv;
                }
                ((g.a)localObject6).oFv = ((dmq)localObject4).HTS.Gys;
                if ((i == 0) && (((dmq)localObject4).HTS != null)) {
                  com.tencent.mm.plugin.report.service.g.yxI.f(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), ((dmq)localObject4).HTS.Gaq, Long.valueOf(((dmq)localObject4).HDI), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(((dmq)localObject4).style), ((dmq)localObject4).HTS.Gau });
                }
                i = 1;
                k += 1;
                break;
              }
              if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
              {
                j = 1;
              }
              else
              {
                j = 2;
                continue;
                j = 0;
                continue;
                localObject1 = "";
                continue;
                ((g.a)localObject6).GaJ += 1;
                ((g.a)localObject6).pos = n;
                ((g.a)localObject6).GaR = ((int)(System.currentTimeMillis() / 1000L));
                continue;
                AppMethodBeat.o(5930);
                return;
                if ((localObject4 != null) && (((dmq)localObject4).style == 1001) && (((dmq)localObject4).HTU != null))
                {
                  if (((w)localObject2).ftb())
                  {
                    localObject1 = (g.a)((g)localObject3).ohc.get(((w)localObject2).field_msgId + "_0");
                    if (localObject1 != null) {
                      continue;
                    }
                    localObject1 = new g.a((byte)0);
                    ((g)localObject3).ohc.put(((w)localObject2).field_msgId + "_0", localObject1);
                    ((g.a)localObject1).Gbn = ((dmq)localObject4).HTU.dAU;
                    ((g.a)localObject1).fmu = ((w)localObject2).field_bizClientMsgId;
                    ((g.a)localObject1).GaJ = 1;
                    ((g.a)localObject1).pos = n;
                    ((g.a)localObject1).GaR = ((int)(System.currentTimeMillis() / 1000L));
                    ((g.a)localObject1).GaQ = 0;
                    ((g.a)localObject1).GaS = ((int)(((w)localObject2).field_createTime / 1000L));
                    if (i1 != 4)
                    {
                      i = 0;
                      ((g.a)localObject1).GaU = i;
                      ((g.a)localObject1).Gbb = m;
                      ((g.a)localObject1).mwj = 5;
                      ((g.a)localObject1).Gbi = ((w)localObject2).field_rankSessionId;
                      ((g.a)localObject1).weight = ((int)((w)localObject2).fsZ());
                      if (localObject4 != null) {
                        ((g.a)localObject1).Gbf = ((dmq)localObject4).HDI;
                      }
                      ((g.a)localObject1).style = 1001;
                      localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
                      com.tencent.mm.plugin.webcanvas.g.CH(74L);
                      localObject3 = com.tencent.mm.plugin.report.service.g.yxI;
                      l1 = System.currentTimeMillis();
                      localObject5 = ((dmq)localObject4).HTU.cardId;
                      long l2 = ((dmq)localObject4).HDI;
                      i = ((dmq)localObject4).style;
                      if (((dmq)localObject4).HTS == null) {
                        continue;
                      }
                      localObject1 = ((dmq)localObject4).HTS.Gau;
                      ((com.tencent.mm.plugin.report.service.g)localObject3).f(21064, new Object[] { Long.valueOf(l1), localObject5, Long.valueOf(l2), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(i), localObject1 });
                      ae.i("MicroMsg.BizTimeLineReport", "onExposeRecCanvasMsg %d", new Object[] { Long.valueOf(((w)localObject2).field_msgId) });
                    }
                  }
                  else
                  {
                    AppMethodBeat.o(5930);
                    return;
                  }
                  if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                  {
                    i = 1;
                    continue;
                  }
                  i = 2;
                  continue;
                  ((g.a)localObject1).GaJ += 1;
                  ((g.a)localObject1).pos = n;
                  ((g.a)localObject1).GaR = ((int)(System.currentTimeMillis() / 1000L));
                  continue;
                  localObject1 = "";
                  continue;
                }
                localObject1 = ((w)localObject2).ftj();
                if ((localObject1 == null) || (((dml)localObject1).Gcu == null) || (((dml)localObject1).Gcu.size() <= 0))
                {
                  ae.w("MicroMsg.BizTimeLineReport", "recCard is null");
                  AppMethodBeat.o(5930);
                  return;
                }
                k = ((dml)localObject1).Gcu.size();
                j = 0;
                if (j < k)
                {
                  localObject6 = (dmm)((dml)localObject1).Gcu.get(j);
                  localObject5 = (g.a)((g)localObject3).ohc.get(((w)localObject2).field_msgId + "_" + j);
                  if (localObject5 == null)
                  {
                    localObject5 = new g.a((byte)0);
                    ((g.a)localObject5).fmu = ((w)localObject2).field_bizClientMsgId;
                    ((g)localObject3).ohc.put(((w)localObject2).field_msgId + "_" + j, localObject5);
                    ((g.a)localObject5).GaH = ((w)localObject2).field_talker;
                    if ((localObject6 != null) && ((((dmm)localObject6).FNv & 0x1) == 0))
                    {
                      localObject6 = ((dmm)((dml)localObject1).Gcu.get(j)).FYs;
                      if (bu.isNullOrNil((String)localObject6)) {}
                    }
                  }
                }
                try
                {
                  localObject6 = Uri.parse((String)localObject6);
                  i = bu.getInt(((Uri)localObject6).getQueryParameter("idx"), 0);
                  l1 = bu.getLong(((Uri)localObject6).getQueryParameter("mid"), 0L);
                  ((g.a)localObject5).GaI.add(Integer.valueOf(i));
                  ((g.a)localObject5).dnX = l1;
                  ((g.a)localObject5).GaX = l1;
                  ((g.a)localObject5).GaJ = 1;
                  ((g.a)localObject5).GaR = ((int)(System.currentTimeMillis() / 1000L));
                  ((g.a)localObject5).pos = n;
                  ((g.a)localObject5).GaQ = 0;
                  ((g.a)localObject5).GaS = ((int)(((w)localObject2).field_createTime / 1000L));
                  if (i1 != 4)
                  {
                    i = 0;
                    ((g.a)localObject5).GaU = i;
                    ((g.a)localObject5).Gbb = m;
                    ((g.a)localObject5).mwj = 1;
                    ((g.a)localObject5).Gbi = ((w)localObject2).field_rankSessionId;
                    ((g.a)localObject5).weight = ((int)((w)localObject2).fsZ());
                    if (((dml)localObject1).HTL != null) {
                      ((g.a)localObject5).Gbg = com.tencent.mm.pluginsdk.ui.tools.x.aPc(((dml)localObject1).HTL.HTN);
                    }
                    if (localObject4 != null) {
                      ((g.a)localObject5).Gbf = ((dmq)localObject4).HDI;
                    }
                    ((g.a)localObject5).GaY = j;
                    if (((w)localObject2).IIG != null)
                    {
                      i = ((w)localObject2).IIG.style;
                      ((g.a)localObject5).style = i;
                      ((g.a)localObject5).oFv = ((dml)localObject1).Gys;
                      j += 1;
                    }
                  }
                  else
                  {
                    if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                    {
                      i = 1;
                      continue;
                    }
                    i = 2;
                    continue;
                  }
                  i = 0;
                  continue;
                  ((g.a)localObject5).GaJ += 1;
                  ((g.a)localObject5).pos = n;
                  ((g.a)localObject5).GaR = ((int)(System.currentTimeMillis() / 1000L));
                  continue;
                  AppMethodBeat.o(5930);
                  return;
                  if (((w)localObject2).ftc())
                  {
                    if (((w)localObject2).ftc())
                    {
                      localObject1 = (g.a)((g)localObject3).ohc.get(((w)localObject2).field_msgId);
                      if (localObject1 == null)
                      {
                        localObject1 = new g.a((byte)0);
                        ((g)localObject3).ohc.put(((w)localObject2).field_msgId, localObject1);
                        ((g.a)localObject1).fmu = ((w)localObject2).field_bizClientMsgId;
                        ((g.a)localObject1).GaH = ((w)localObject2).field_talker;
                        ((g.a)localObject1).GaJ = 1;
                        ((g.a)localObject1).GaR = ((int)(System.currentTimeMillis() / 1000L));
                        ((g.a)localObject1).pos = n;
                        ((g.a)localObject1).GaS = ((int)(((w)localObject2).field_createTime / 1000L));
                        if (i1 != 4)
                        {
                          i = 0;
                          ((g.a)localObject1).GaU = i;
                          ((g.a)localObject1).GaV = g.d((w)localObject2);
                          g.a((g.a)localObject1, ((w)localObject2).field_talker);
                          ((g.a)localObject1).Gbb = m;
                          ((g.a)localObject1).Gbi = ((w)localObject2).field_rankSessionId;
                          ((g.a)localObject1).weight = ((int)((w)localObject2).fsZ());
                          ((g.a)localObject1).mwj = aa.t((w)localObject2);
                          localObject3 = ((w)localObject2).ftm();
                          ((g.a)localObject1).zMk = ((String)localObject3);
                          ((g.a)localObject1).zMj = ((w)localObject2).getTraceId();
                          localObject2 = com.tencent.mm.storage.p.IIi;
                          if (com.tencent.mm.storage.p.aTO((String)localObject3))
                          {
                            i = 1;
                            ((g.a)localObject1).Gbm = i;
                            ay.aRX("brandService").encode("BizLastExposeAdTime", System.currentTimeMillis());
                            localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
                            com.tencent.mm.plugin.webcanvas.g.CH(69L);
                            AppMethodBeat.o(5930);
                          }
                        }
                        else
                        {
                          if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                          {
                            i = 1;
                            continue;
                          }
                          i = 2;
                          continue;
                        }
                        i = 0;
                        continue;
                      }
                      ((g.a)localObject1).GaJ += 1;
                      ((g.a)localObject1).pos = n;
                      ((g.a)localObject1).GaR = ((int)(System.currentTimeMillis() / 1000L));
                      g.a((g.a)localObject1, ((w)localObject2).field_talker);
                    }
                    AppMethodBeat.o(5930);
                    return;
                  }
                  localObject1 = (g.a)((g)localObject3).ohc.get(((w)localObject2).field_msgId);
                  if (localObject1 == null)
                  {
                    localObject1 = new g.a((byte)0);
                    ((g.a)localObject1).fmu = ((w)localObject2).field_bizClientMsgId;
                    ((g)localObject3).ohc.put(((w)localObject2).field_msgId, localObject1);
                    ((g.a)localObject1).GaH = ((w)localObject2).field_talker;
                    ((g.a)localObject1).dnX = 0L;
                    ((g.a)localObject1).GaJ = 1;
                    ((g.a)localObject1).GaR = ((int)(System.currentTimeMillis() / 1000L));
                    ((g.a)localObject1).pos = n;
                    ((g.a)localObject1).GaL = 0;
                    ((g.a)localObject1).GaN = 0;
                    ((g.a)localObject1).GaO = 0;
                    ((g.a)localObject1).GaQ = 0;
                    ((g.a)localObject1).FZS = 0;
                    ((g.a)localObject1).GaS = ((int)(((w)localObject2).field_createTime / 1000L));
                    if (i1 != 4)
                    {
                      i = 0;
                      ((g.a)localObject1).GaU = i;
                      ((g.a)localObject1).GaV = g.d((w)localObject2);
                      g.a((g.a)localObject1, ((w)localObject2).field_talker);
                      ((g.a)localObject1).Gbb = m;
                      if (((w)localObject2).IID)
                      {
                        i = 1;
                        ((g.a)localObject1).Gbd = i;
                        if (!((w)localObject2).IIE) {
                          continue;
                        }
                        i = 1;
                        ((g.a)localObject1).Gbe = i;
                        ((g.a)localObject1).Gbi = ((w)localObject2).field_rankSessionId;
                        ((g.a)localObject1).weight = ((int)((w)localObject2).fsZ());
                        localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(((w)localObject2).field_talker);
                        if ((localObject2 == null) || (c.lO(((aw)localObject2).field_type))) {
                          continue;
                        }
                        i = 3;
                        ((g.a)localObject1).mwj = i;
                        AppMethodBeat.o(5930);
                      }
                    }
                    else
                    {
                      if (System.currentTimeMillis() - ((w)localObject2).field_createTime <= 86400000L)
                      {
                        i = 1;
                        continue;
                      }
                      i = 2;
                      continue;
                    }
                    i = 0;
                    continue;
                    i = 0;
                    continue;
                    i = 0;
                    continue;
                  }
                  ((g.a)localObject1).GaJ += 1;
                  ((g.a)localObject1).pos = n;
                  ((g.a)localObject1).GaR = ((int)(System.currentTimeMillis() / 1000L));
                  g.a((g.a)localObject1, ((w)localObject2).field_talker);
                  if (((w)localObject2).IID)
                  {
                    i = 1;
                    ((g.a)localObject1).Gbd = i;
                    if (((w)localObject2).IIE)
                    {
                      i = 1;
                      ((g.a)localObject1).Gbe = i;
                      AppMethodBeat.o(5930);
                    }
                  }
                  else
                  {
                    i = 0;
                    continue;
                  }
                  i = 0;
                }
                catch (Exception localException2) {}
              }
            }
            catch (Exception localException3) {}
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
    AppMethodBeat.i(208457);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.g.yxI.f(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(this.dmM), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(208457);
  }
  
  public final void zB(int paramInt)
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