package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.n;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.u;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  int dcS;
  int mXF;
  int mXG;
  HashMap<String, h.a> mXH;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(5934);
    this.mXH = new HashMap();
    this.dcS = paramInt;
    AppMethodBeat.o(5934);
  }
  
  static void a(h.a parama, String paramString)
  {
    AppMethodBeat.i(5936);
    if (((k)g.ab(k.class)).apM().aHY(paramString).ZS())
    {
      parama.CJT = 1;
      parama.CJX = 1;
      AppMethodBeat.o(5936);
      return;
    }
    parama.CJT = 0;
    parama.CJX = 0;
    AppMethodBeat.o(5936);
  }
  
  public final void a(s params, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5939);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new h.4(this, params, paramInt1, paramInt2, paramInt3), 0L);
    AppMethodBeat.o(5939);
  }
  
  public final void a(s params, boolean paramBoolean)
  {
    AppMethodBeat.i(5937);
    params = (h.a)this.mXH.get(Long.valueOf(params.field_msgId));
    if (params == null)
    {
      AppMethodBeat.o(5937);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      params.CJi = i;
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
    AppMethodBeat.i(192969);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      com.tencent.mm.storage.af localaf = ((k)g.ab(k.class)).apM().aHY(paramString);
      int j = paramInt3;
      if (!paramBoolean)
      {
        j = paramInt3;
        if (localaf != null)
        {
          j = paramInt3;
          if (!com.tencent.mm.n.b.ls(localaf.field_type)) {
            j = 2;
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(15721, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.dcS), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), "", Integer.valueOf(j), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(192969);
      return;
    }
  }
  
  public final void b(final s params, final int paramInt)
  {
    AppMethodBeat.i(5935);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5930);
        h localh = h.this;
        s locals = params;
        int n = paramInt;
        int i1 = this.hwJ;
        int m = this.mXI;
        Object localObject1;
        int j;
        int k;
        Object localObject2;
        h.a locala;
        if (locals != null) {
          if (locals.eJL()) {
            if (locals.eJL())
            {
              localObject1 = ((a)g.ab(a.class)).a(locals.field_msgId, locals.field_content);
              if ((localObject1 == null) || (bt.gL(((u)localObject1).gKs)))
              {
                AppMethodBeat.o(5930);
                return;
              }
              try
              {
                j = ((u)localObject1).gKs.size();
                if ((j <= 2) || (locals.field_isExpand)) {
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
                  ad.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
                  AppMethodBeat.o(5930);
                  return;
                  locala.CJO = 0;
                }
              }
              catch (Exception localException1)
              {
                ad.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { localException1.getMessage() });
              }
              if (k >= j) {
                break label918;
              }
              localObject2 = (com.tencent.mm.ai.v)((u)localObject1).gKs.get(k);
              if (localObject2 == null) {
                break label1976;
              }
              locala = (h.a)localh.mXH.get(locals.field_msgId + "_" + k);
              if (locala != null) {
                break label827;
              }
              locala = new h.a((byte)0);
              locala.ePa = locals.field_bizClientMsgId;
              localh.mXH.put(locals.field_msgId + "_" + k, locala);
              locala.CJL = locals.field_talker;
              locala.CJN = 1;
              locala.CJV = ((int)(System.currentTimeMillis() / 1000L));
              locala.pos = n;
              locala.CJP = 0;
              locala.CJR = 0;
              locala.CJS = 0;
              locala.CJU = 0;
              locala.CJi = 0;
              locala.CJU = 0;
              locala.CJW = ((int)(locals.field_createTime / 1000L));
              if (i1 != 4)
              {
                i = 0;
                label354:
                locala.CJY = i;
                locala.CJZ = ((com.tencent.mm.ai.v)localObject2).type;
                localStringBuilder = new StringBuilder("1_");
                localObject3 = ((com.tencent.mm.ai.v)localObject2).url;
                if (!bt.isNullOrNil((String)localObject3)) {
                  break label686;
                }
                i = 0;
                label398:
                locala.CKa = (i + ";");
                locala.CKc = k;
                if (!locals.field_isExpand) {
                  break label1993;
                }
                i = 1;
                label433:
                locala.CKd = i;
                locala.CKf = m;
                if ((k != 0) || (!locals.Fep)) {
                  break label1998;
                }
                i = 1;
                label460:
                locala.CKh = i;
                if (!locals.Feq) {
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
          locala.CKi = i;
          locala.CKl = ((com.tencent.mm.ai.v)localObject2).gGA;
          locala.CKm = locals.field_rankSessionId;
          locala.weight = ((int)locals.eJK());
          h.a(locala, locals.field_talker);
          long l;
          if (!bt.isNullOrNil(((com.tencent.mm.ai.v)localObject2).url))
          {
            localObject2 = Uri.parse(((com.tencent.mm.ai.v)localObject2).url);
            i = bt.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
            l = bt.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
            locala.CJM.add(Integer.valueOf(i));
            locala.ded = l;
            locala.CKb = l;
          }
          if (locals.field_isExpand)
          {
            locala.CJO = 2;
            label612:
            localObject2 = ((k)g.ab(k.class)).apM().aHY(locals.field_talker);
            if ((localObject2 == null) || (com.tencent.mm.n.b.ls(((au)localObject2).field_type))) {
              break label822;
            }
          }
          for (i = 2;; i = 0)
          {
            locala.lpz = i;
            break label1976;
            if (System.currentTimeMillis() - locals.field_createTime > 86400000L) {
              break label1983;
            }
            i = 1;
            break;
            localObject3 = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).OX((String)localObject3);
            if ((localObject3 == null) || (((p)localObject3).gKp == null)) {
              break label1988;
            }
            i = ((p)localObject3).gKp.gKj;
            break label398;
            if (((u)localObject1).gKs.size() > 2)
            {
              locala.CJO = 1;
              break label612;
            }
            AppMethodBeat.o(5930);
            return;
          }
          if ((k == 0) && (locals.Fep))
          {
            i = 1;
            locala.CKh = i;
            if (!locals.Feq) {
              break label913;
            }
          }
          for (i = 1;; i = 0)
          {
            locala.CKi = i;
            locala.CJN += 1;
            locala.pos = n;
            locala.CJV = ((int)(System.currentTimeMillis() / 1000L));
            h.a(locala, locals.field_talker);
            break label1976;
            i = 0;
            break;
          }
          AppMethodBeat.o(5930);
          return;
          if (locals.eJM())
          {
            localObject1 = locals.eJR();
            if ((localObject1 == null) || (((dap)localObject1).Eso == null) || (((dap)localObject1).Eso.size() <= 0))
            {
              ad.w("MicroMsg.BizTimeLineReport", "recCard is null");
              AppMethodBeat.o(5930);
              return;
            }
            k = ((dap)localObject1).Eso.size();
            j = 0;
          }
          for (;;)
          {
            if (j < k)
            {
              localObject2 = (daq)((dap)localObject1).Eso.get(j);
              locala = (h.a)localException1.mXH.get(locals.field_msgId + "_" + j);
              if (locala == null)
              {
                locala = new h.a((byte)0);
                locala.ePa = locals.field_bizClientMsgId;
                localException1.mXH.put(locals.field_msgId + "_" + j, locala);
                locala.CJL = locals.field_talker;
                if ((localObject2 != null) && ((((daq)localObject2).Cxm & 0x1) == 0))
                {
                  localObject2 = ((daq)((dap)localObject1).Eso.get(j)).CHL;
                  if (bt.isNullOrNil((String)localObject2)) {}
                }
              }
            }
            try
            {
              localObject2 = Uri.parse((String)localObject2);
              i = bt.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
              l = bt.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
              locala.CJM.add(Integer.valueOf(i));
              locala.ded = l;
              locala.CKb = l;
              locala.CJN = 1;
              locala.CJV = ((int)(System.currentTimeMillis() / 1000L));
              locala.pos = n;
              locala.CJU = 0;
              locala.CJW = ((int)(locals.field_createTime / 1000L));
              if (i1 != 4)
              {
                i = 0;
                label1279:
                locala.CJY = i;
                locala.CKf = m;
                locala.lpz = 1;
                locala.CKm = locals.field_rankSessionId;
                locala.weight = ((int)locals.eJK());
                if (((dap)localObject1).Esm != null) {
                  locala.CKk = x.aCL(((dap)localObject1).Esm.Esu);
                }
                localObject2 = locals.eJS();
                if (localObject2 != null) {
                  locala.CKj = ((dau)localObject2).EsA;
                }
                locala.CKc = j;
                if (locals.Fes == null) {
                  break label1427;
                }
                i = locals.Fes.style;
                label1388:
                locala.style = i;
              }
              for (;;)
              {
                j += 1;
                break;
                if (System.currentTimeMillis() - locals.field_createTime <= 86400000L)
                {
                  i = 1;
                  break label1279;
                }
                i = 2;
                break label1279;
                i = 0;
                break label1388;
                locala.CJN += 1;
                locala.pos = n;
                locala.CJV = ((int)(System.currentTimeMillis() / 1000L));
              }
              AppMethodBeat.o(5930);
              return;
              localObject1 = (h.a)localException1.mXH.get(locals.field_msgId);
              if (localObject1 == null)
              {
                localObject1 = new h.a((byte)0);
                ((h.a)localObject1).ePa = locals.field_bizClientMsgId;
                localException1.mXH.put(locals.field_msgId, localObject1);
                ((h.a)localObject1).CJL = locals.field_talker;
                ((h.a)localObject1).ded = 0L;
                ((h.a)localObject1).CJN = 1;
                ((h.a)localObject1).CJV = ((int)(System.currentTimeMillis() / 1000L));
                ((h.a)localObject1).pos = n;
                ((h.a)localObject1).CJP = 0;
                ((h.a)localObject1).CJR = 0;
                ((h.a)localObject1).CJS = 0;
                ((h.a)localObject1).CJU = 0;
                ((h.a)localObject1).CJi = 0;
                ((h.a)localObject1).CJW = ((int)(locals.field_createTime / 1000L));
                if (i1 != 4)
                {
                  i = 0;
                  ((h.a)localObject1).CJY = i;
                  if (!locals.isText()) {
                    break label1829;
                  }
                  i = 1;
                  ((h.a)localObject1).CJZ = i;
                  h.a((h.a)localObject1, locals.field_talker);
                  ((h.a)localObject1).CKf = m;
                  if (!locals.Fep) {
                    break label1860;
                  }
                  i = 1;
                  ((h.a)localObject1).CKh = i;
                  if (!locals.Feq) {
                    break label1865;
                  }
                  i = 1;
                  ((h.a)localObject1).CKi = i;
                  ((h.a)localObject1).CKm = locals.field_rankSessionId;
                  ((h.a)localObject1).weight = ((int)locals.eJK());
                  com.tencent.mm.storage.af localaf = ((k)g.ab(k.class)).apM().aHY(locals.field_talker);
                  if ((localaf == null) || (com.tencent.mm.n.b.ls(localaf.field_type))) {
                    break label1870;
                  }
                }
                for (i = 2;; i = 0)
                {
                  ((h.a)localObject1).lpz = i;
                  AppMethodBeat.o(5930);
                  return;
                  if (System.currentTimeMillis() - locals.field_createTime <= 86400000L)
                  {
                    i = 1;
                    break;
                  }
                  i = 2;
                  break;
                  if (locals.eJO())
                  {
                    i = 2;
                    break label1670;
                  }
                  if (locals.eJN())
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
              ((h.a)localObject1).CJN += 1;
              ((h.a)localObject1).pos = n;
              ((h.a)localObject1).CJV = ((int)(System.currentTimeMillis() / 1000L));
              h.a((h.a)localObject1, locals.field_talker);
              if (locals.Fep)
              {
                i = 1;
                ((h.a)localObject1).CKh = i;
                if (!locals.Feq) {
                  break label1961;
                }
              }
              for (i = 1;; i = 0)
              {
                ((h.a)localObject1).CKi = i;
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
  
  public final void c(s params, int paramInt)
  {
    AppMethodBeat.i(5938);
    a(params, 0, paramInt, -1);
    AppMethodBeat.o(5938);
  }
  
  public final void e(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(5943);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.vKh.f(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(this.dcS), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(1) });
    AppMethodBeat.o(5943);
  }
  
  public final void xR(int paramInt)
  {
    AppMethodBeat.i(5940);
    a("", 0L, 0, paramInt, -1);
    AppMethodBeat.o(5940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.h
 * JD-Core Version:    0.7.0.1
 */