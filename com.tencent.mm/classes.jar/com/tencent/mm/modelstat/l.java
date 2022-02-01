package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.r;
import com.tencent.mm.ci.c;
import com.tencent.mm.ci.d.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.a.b.1;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Map;

public final class l
  extends b.a
  implements com.tencent.mm.ak.e
{
  public static long a(k paramk, long paramLong)
  {
    AppMethodBeat.i(177293);
    long l1 = 0L;
    long l2 = l1;
    for (;;)
    {
      int i;
      try
      {
        paramk = paramk.fTj();
        i = 0;
        l2 = l1;
        l3 = l1;
        if (i < paramk.length)
        {
          l2 = l1;
          if (paramk[i].isDirectory())
          {
            l2 = l1;
            l1 += a(paramk[i], paramLong);
          }
          else
          {
            l2 = l1;
            if (paramk[i].length() > paramLong)
            {
              l2 = l1;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[] { Long.valueOf(paramk[i].length()), w.B(paramk[i].mUri) });
            }
            l2 = l1;
            l3 = paramk[i].length();
            l1 += l3;
          }
        }
      }
      catch (Exception paramk)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[] { bu.o(paramk) });
        long l3 = l2;
        AppMethodBeat.o(177293);
        return l3;
      }
      i += 1;
    }
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(151096);
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      AppMethodBeat.o(151096);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(151096);
      return;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetStatMsgExtension", "send bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(0L, paramInt3, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(0L, paramInt3, paramInt2);
      AppMethodBeat.o(151096);
      return;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(paramInt3, 0L, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(paramInt3, 0L, paramInt2);
      AppMethodBeat.o(151096);
      return;
      ao.aRR("dns_failed_report");
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(151094);
    com.tencent.mm.kernel.g.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151090);
        l.b(paramInt1, paramInt2, paramInt3, paramBoolean);
        AppMethodBeat.o(151090);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(151091);
        String str = super.toString() + "|report";
        AppMethodBeat.o(151091);
        return str;
      }
    }, 3000L);
    AppMethodBeat.o(151094);
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(151093);
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
      AppMethodBeat.o(151093);
      return null;
    }
    parama = parama.gte.FNI.HId;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", new Object[] { parama });
    if (bu.isNullOrNil(parama))
    {
      AppMethodBeat.o(151093);
      return null;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", new Object[] { parama });
    Object localObject1 = bx.M(parama, "cmd");
    final long l;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = bx.M(parama, "ClearCache");
      if (localObject1 != null)
      {
        l = bu.getLong((String)((Map)localObject1).get(".ClearCache.androidCacheMask"), 0L);
        localObject1 = (String)((Map)localObject1).get(".ClearCache.message");
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_mask", l);
        ((Intent)localObject2).putExtra("key_message", (String)localObject1);
        com.tencent.mm.br.d.f(ak.getContext(), ".ui.ClearCacheUI", (Intent)localObject2);
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.foo();
      com.tencent.mm.kernel.g.ajj().hRo.DT(parama);
      try
      {
        Thread.sleep(50L, 0);
        label202:
        LogLogic.initIPxxLogInfo();
        MMProtocalJni.setProtocalJniLogLevel(com.tencent.mm.sdk.platformtools.ae.getLogLevel());
        AppMethodBeat.o(151093);
        return null;
        final int i = bu.getInt((String)((Map)localObject1).get(".cmd.trace.$code"), -1);
        if (i > 0)
        {
          if (i == 6)
          {
            parama = new xw();
            com.tencent.mm.sdk.b.a.IvT.l(parama);
            AppMethodBeat.o(151093);
            return null;
          }
          parama = (String)((Map)localObject1).get(".cmd.trace.$class");
          int j = bu.getInt((String)((Map)localObject1).get(".cmd.trace.$size"), 0);
          int k = bu.getInt((String)((Map)localObject1).get(".cmd.trace.$type"), 0);
          com.tencent.mm.ci.d.fyy().c(new d.a(parama, i, j, k));
          AppMethodBeat.o(151093);
          return null;
        }
        i = bu.getInt((String)((Map)localObject1).get(".cmd.hprof.$type"), -1);
        if (i > 0)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[] { Integer.valueOf(i) });
          c.abW(i);
          AppMethodBeat.o(151093);
          return null;
        }
        if ("android".equalsIgnoreCase((String)((Map)localObject1).get(".cmd.prconfig.$os")))
        {
          parama = new kf();
          parama.dyi.dyj = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$url"));
          parama.dyi.dyk = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$signature"));
          parama.dyi.dyl = ((String)((Map)localObject1).get(".cmd.prconfig.$url"));
          parama.dyi.dym = ((String)((Map)localObject1).get(".cmd.prconfig.$signature"));
          com.tencent.mm.sdk.b.a.IvT.a(parama, Looper.myLooper());
          AppMethodBeat.o(151093);
          return null;
        }
        i = bu.getInt((String)((Map)localObject1).get(".cmd.clearfile.$fb"), -1);
        if (i == 1)
        {
          l = bu.getInt((String)((Map)localObject1).get(".cmd.clearfile.$ps"), 1048576);
          com.tencent.mm.kernel.g.ajU().aw(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(151087);
              long l = bu.fpO();
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new k(com.tencent.mm.kernel.g.ajR().cachePath), l)), com.tencent.mm.kernel.g.ajR().cachePath });
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new k(com.tencent.mm.kernel.g.ajR().gDS), l)), com.tencent.mm.kernel.g.ajR().gDS });
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new k(com.tencent.mm.kernel.g.ajR().gDS), l)), com.tencent.mm.kernel.g.ajR().gDS });
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new k(com.tencent.mm.kernel.g.ajR().gDT), l)), com.tencent.mm.kernel.g.ajR().gDT });
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new k(am.IKh), l)), am.IKh });
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[] { Long.valueOf(bu.fpO() - l) });
              AppMethodBeat.o(151087);
            }
          });
          i = bu.getInt((String)((Map)localObject1).get(".cmd.updzh.$pt"), -1);
          localObject2 = (String)((Map)localObject1).get(".cmd.updzh.$pd");
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[] { Integer.valueOf(i), localObject2 });
          if ((i > 0) && (!bu.isNullOrNil((String)localObject2))) {
            com.tencent.mm.kernel.g.ajU().aw(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(151088);
                switch (i)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(151088);
                  return;
                  aa.a(com.tencent.mm.kernel.g.ajR().gDT + this.itz, v.aAC(), false, true);
                  AppMethodBeat.o(151088);
                  return;
                  aa.a(com.tencent.mm.kernel.g.ajR().cachePath + this.itz, v.aAC(), false, true);
                  AppMethodBeat.o(151088);
                  return;
                  aa.a(this.itz, v.aAC(), false, true);
                }
              }
              
              public final String toString()
              {
                AppMethodBeat.i(151089);
                String str = super.toString() + "|onPreAddMessage";
                AppMethodBeat.o(151089);
                return str;
              }
            });
          }
          i = bu.getInt((String)((Map)localObject1).get(".cmd.uploadx5log.type"), -1);
          if (i <= 0) {
            break label1254;
          }
          parama = (String)((Map)localObject1).get(".cmd.uploadx5log.date");
          localObject1 = (String)((Map)localObject1).get(".cmd.uploadx5log.process");
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.UploadX5Log", "upload, date %s,process %s,type %d", new Object[] { parama, localObject1, Integer.valueOf(i) });
          if (i != 1) {
            break label1138;
          }
          if ((!bu.isNullOrNil(parama)) && (!bu.isNullOrNil((String)localObject1))) {
            break label1082;
          }
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.UploadX5Log", "date or process is null,date %s,process %s", new Object[] { parama, localObject1 });
        }
        for (;;)
        {
          AppMethodBeat.o(151093);
          return null;
          if (i == 2)
          {
            localObject2 = (String)((Map)localObject1).get(".cmd.clearfile.$pd");
            k localk = new k((String)localObject2);
            if (localk.exists())
            {
              l = localk.length();
              label849:
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile delete :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              o.deleteFile((String)localObject2);
              localk = new k((String)localObject2);
              if (!localk.exists()) {
                break label942;
              }
            }
            label942:
            for (l = localk.length();; l = -1L)
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "clearfile delete finish :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              break;
              l = -1L;
              break label849;
            }
          }
          if (i != 3) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + com.tencent.mm.kernel.g.ajR().ajx() + ".tem");
          o.deleteFile(com.tencent.mm.kernel.g.ajR().ajx() + ".tem");
          o.deleteFile(com.tencent.mm.kernel.g.ajR().ajy() + ".tem");
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + com.tencent.mm.kernel.g.ajR().ajx() + ".tem");
          break;
          label1082:
          label1138:
          for (parama = String.format("%s/tencent/tbs_live_log/com.tencent.mm/com.tencent.mm_%s_%s.livelog", new Object[] { com.tencent.mm.loader.j.b.asd(), localObject1, parama });; parama = com.tencent.mm.loader.j.b.asd() + "/Android/data/com.tencent.mm/files/tbslog/tbslog.txt")
          {
            localObject1 = new k(parama);
            if (((k)localObject1).exists()) {
              break label1164;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.UploadX5Log", "upload file not exists");
            break;
          }
          label1164:
          parama = r.a((k)localObject1, false, parama + ".zip");
          if (parama == null)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.UploadX5Log", "zipPath is null");
          }
          else
          {
            parama = new k(parama);
            if (!parama.exists()) {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.UploadX5Log", "upload zip file not exists");
            } else {
              com.tencent.mm.cm.g.eu(parama).h(new b.1(i));
            }
          }
        }
        label1254:
        i = bu.getInt((String)((Map)localObject1).get(".cmd.testbizad.type"), -1);
        if (i > 0)
        {
          parama = (String)((Map)localObject1).get(".cmd.testbizad.content");
          ((s)com.tencent.mm.kernel.g.ad(s.class)).getBizTimeLineCallback().ay(i, parama);
          AppMethodBeat.o(151093);
          return null;
        }
        com.tencent.mm.plugin.performance.a.a.wWa.aA((Map)localObject1);
      }
      catch (Exception parama)
      {
        break label202;
      }
    }
  }
  
  public final void b(e.c paramc) {}
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    AppMethodBeat.i(151095);
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      AppMethodBeat.o(151095);
      return;
    }
    if (!com.tencent.mm.kernel.g.ajS().gEt.gEN)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
      AppMethodBeat.o(151095);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (com.tencent.mm.network.ae.cR(ak.getContext()))
    {
      if (paramInt1 > 0) {}
      for (l2 = paramInt1;; l2 = 0L)
      {
        if (paramInt2 > 0) {
          l1 = paramInt2;
        }
        n.b(l2, l1, 0);
        AppMethodBeat.o(151095);
        return;
      }
    }
    if (paramInt3 > 0) {}
    for (long l2 = paramInt3;; l2 = 0L)
    {
      if (paramInt4 > 0) {
        l1 = paramInt4;
      }
      n.c(l2, l1, 0);
      AppMethodBeat.o(151095);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.l
 * JD-Core Version:    0.7.0.1
 */