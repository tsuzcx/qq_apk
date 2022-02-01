package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.cj.c;
import com.tencent.mm.cj.d.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.u;
import com.tencent.mm.modelstat.a.b.1;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.al;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class l
  extends b.a
  implements com.tencent.mm.al.e
{
  public static long a(com.tencent.mm.vfs.e parame, long paramLong)
  {
    AppMethodBeat.i(177293);
    long l1 = 0L;
    long l2 = l1;
    for (;;)
    {
      int i;
      try
      {
        parame = parame.fOM();
        i = 0;
        l2 = l1;
        l3 = l1;
        if (i < parame.length)
        {
          l2 = l1;
          if (parame[i].isDirectory())
          {
            l2 = l1;
            l1 += a(parame[i], paramLong);
          }
          else
          {
            l2 = l1;
            if (parame[i].length() > paramLong)
            {
              l2 = l1;
              ad.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[] { Long.valueOf(parame[i].length()), com.tencent.mm.vfs.q.B(parame[i].mUri) });
            }
            l2 = l1;
            l3 = parame[i].length();
            l1 += l3;
          }
        }
      }
      catch (Exception parame)
      {
        ad.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[] { bt.n(parame) });
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
    if (!com.tencent.mm.kernel.g.ajA().aiK())
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
      ad.d("MicroMsg.NetStatMsgExtension", "send bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(0L, paramInt3, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(0L, paramInt3, paramInt2);
      AppMethodBeat.o(151096);
      return;
      ad.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(paramInt3, 0L, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(paramInt3, 0L, paramInt2);
      AppMethodBeat.o(151096);
      return;
      an.aQu("dns_failed_report");
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(151094);
    com.tencent.mm.kernel.g.ajF().n(new Runnable()
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
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      ad.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
      AppMethodBeat.o(151093);
      return null;
    }
    parama = parama.gqE.Fvk.HoB;
    ad.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", new Object[] { parama });
    if (bt.isNullOrNil(parama))
    {
      AppMethodBeat.o(151093);
      return null;
    }
    ad.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", new Object[] { parama });
    Object localObject1 = bw.M(parama, "cmd");
    final long l;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = bw.M(parama, "ClearCache");
      if (localObject1 != null)
      {
        l = bt.getLong((String)((Map)localObject1).get(".ClearCache.androidCacheMask"), 0L);
        localObject1 = (String)((Map)localObject1).get(".ClearCache.message");
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_mask", l);
        ((Intent)localObject2).putExtra("key_message", (String)localObject1);
        com.tencent.mm.bs.d.f(aj.getContext(), ".ui.ClearCacheUI", (Intent)localObject2);
      }
    }
    for (;;)
    {
      ad.fku();
      com.tencent.mm.kernel.g.aiU().hOv.Dr(parama);
      try
      {
        Thread.sleep(50L, 0);
        label202:
        LogLogic.initIPxxLogInfo();
        MMProtocalJni.setProtocalJniLogLevel(ad.getLogLevel());
        AppMethodBeat.o(151093);
        return null;
        final int i = bt.getInt((String)((Map)localObject1).get(".cmd.trace.$code"), -1);
        if (i > 0)
        {
          if (i == 6)
          {
            parama = new xs();
            com.tencent.mm.sdk.b.a.IbL.l(parama);
            AppMethodBeat.o(151093);
            return null;
          }
          parama = (String)((Map)localObject1).get(".cmd.trace.$class");
          int j = bt.getInt((String)((Map)localObject1).get(".cmd.trace.$size"), 0);
          int k = bt.getInt((String)((Map)localObject1).get(".cmd.trace.$type"), 0);
          com.tencent.mm.cj.d.fux().c(new d.a(parama, i, j, k));
          AppMethodBeat.o(151093);
          return null;
        }
        i = bt.getInt((String)((Map)localObject1).get(".cmd.hprof.$type"), -1);
        if (i > 0)
        {
          ad.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[] { Integer.valueOf(i) });
          c.abo(i);
          AppMethodBeat.o(151093);
          return null;
        }
        if ("android".equalsIgnoreCase((String)((Map)localObject1).get(".cmd.prconfig.$os")))
        {
          parama = new ke();
          parama.dxd.dxe = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$url"));
          parama.dxd.dxf = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$signature"));
          parama.dxd.dxg = ((String)((Map)localObject1).get(".cmd.prconfig.$url"));
          parama.dxd.dxh = ((String)((Map)localObject1).get(".cmd.prconfig.$signature"));
          com.tencent.mm.sdk.b.a.IbL.a(parama, Looper.myLooper());
          AppMethodBeat.o(151093);
          return null;
        }
        i = bt.getInt((String)((Map)localObject1).get(".cmd.clearfile.$fb"), -1);
        if (i == 1)
        {
          l = bt.getInt((String)((Map)localObject1).get(".cmd.clearfile.$ps"), 1048576);
          com.tencent.mm.kernel.g.ajF().ay(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(151087);
              long l = bt.flT();
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().cachePath), l)), com.tencent.mm.kernel.g.ajC().cachePath });
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().gBl), l)), com.tencent.mm.kernel.g.ajC().gBl });
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().gBl), l)), com.tencent.mm.kernel.g.ajC().gBl });
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().gBm), l)), com.tencent.mm.kernel.g.ajC().gBm });
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new com.tencent.mm.vfs.e(al.IpN), l)), al.IpN });
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[] { Long.valueOf(bt.flT() - l) });
              AppMethodBeat.o(151087);
            }
          });
          i = bt.getInt((String)((Map)localObject1).get(".cmd.updzh.$pt"), -1);
          localObject2 = (String)((Map)localObject1).get(".cmd.updzh.$pd");
          ad.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[] { Integer.valueOf(i), localObject2 });
          if ((i > 0) && (!bt.isNullOrNil((String)localObject2))) {
            com.tencent.mm.kernel.g.ajF().ay(new Runnable()
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
                  aa.a(com.tencent.mm.kernel.g.ajC().gBm + this.iqE, u.aAm(), false, true);
                  AppMethodBeat.o(151088);
                  return;
                  aa.a(com.tencent.mm.kernel.g.ajC().cachePath + this.iqE, u.aAm(), false, true);
                  AppMethodBeat.o(151088);
                  return;
                  aa.a(this.iqE, u.aAm(), false, true);
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
          i = bt.getInt((String)((Map)localObject1).get(".cmd.uploadx5log.type"), -1);
          if (i <= 0) {
            break label1254;
          }
          parama = (String)((Map)localObject1).get(".cmd.uploadx5log.date");
          localObject1 = (String)((Map)localObject1).get(".cmd.uploadx5log.process");
          ad.i("MicroMsg.UploadX5Log", "upload, date %s,process %s,type %d", new Object[] { parama, localObject1, Integer.valueOf(i) });
          if (i != 1) {
            break label1138;
          }
          if ((!bt.isNullOrNil(parama)) && (!bt.isNullOrNil((String)localObject1))) {
            break label1082;
          }
          ad.w("MicroMsg.UploadX5Log", "date or process is null,date %s,process %s", new Object[] { parama, localObject1 });
        }
        for (;;)
        {
          AppMethodBeat.o(151093);
          return null;
          if (i == 2)
          {
            localObject2 = (String)((Map)localObject1).get(".cmd.clearfile.$pd");
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e((String)localObject2);
            if (locale.exists())
            {
              l = locale.length();
              label849:
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile delete :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              i.deleteFile((String)localObject2);
              locale = new com.tencent.mm.vfs.e((String)localObject2);
              if (!locale.exists()) {
                break label942;
              }
            }
            label942:
            for (l = locale.length();; l = -1L)
            {
              ad.i("MicroMsg.NetStatMsgExtension", "clearfile delete finish :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              break;
              l = -1L;
              break label849;
            }
          }
          if (i != 3) {
            break;
          }
          ad.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + com.tencent.mm.kernel.g.ajC().aji() + ".tem");
          i.deleteFile(com.tencent.mm.kernel.g.ajC().aji() + ".tem");
          i.deleteFile(com.tencent.mm.kernel.g.ajC().ajj() + ".tem");
          ad.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + com.tencent.mm.kernel.g.ajC().aji() + ".tem");
          break;
          label1082:
          label1138:
          for (parama = String.format("%s/tencent/tbs_live_log/com.tencent.mm/com.tencent.mm_%s_%s.livelog", new Object[] { com.tencent.mm.loader.j.b.arO(), localObject1, parama });; parama = com.tencent.mm.loader.j.b.arO() + "/Android/data/com.tencent.mm/files/tbslog/tbslog.txt")
          {
            localObject1 = new com.tencent.mm.vfs.e(parama);
            if (((com.tencent.mm.vfs.e)localObject1).exists()) {
              break label1164;
            }
            ad.i("MicroMsg.UploadX5Log", "upload file not exists");
            break;
          }
          label1164:
          parama = com.tencent.mm.b.r.a((com.tencent.mm.vfs.e)localObject1, false, parama + ".zip");
          if (parama == null)
          {
            ad.i("MicroMsg.UploadX5Log", "zipPath is null");
          }
          else
          {
            parama = new com.tencent.mm.vfs.e(parama);
            if (!parama.exists()) {
              ad.i("MicroMsg.UploadX5Log", "upload zip file not exists");
            } else {
              com.tencent.mm.cn.g.er(parama).h(new b.1(i));
            }
          }
        }
        label1254:
        i = bt.getInt((String)((Map)localObject1).get(".cmd.testbizad.type"), -1);
        if (i > 0)
        {
          parama = (String)((Map)localObject1).get(".cmd.testbizad.content");
          ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getBizTimeLineCallback().az(i, parama);
          AppMethodBeat.o(151093);
          return null;
        }
        com.tencent.mm.plugin.performance.a.a.wGn.au((Map)localObject1);
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
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      AppMethodBeat.o(151095);
      return;
    }
    if (!com.tencent.mm.kernel.g.ajD().gBM.gCg)
    {
      ad.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
      AppMethodBeat.o(151095);
      return;
    }
    ad.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (ae.cP(aj.getContext()))
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