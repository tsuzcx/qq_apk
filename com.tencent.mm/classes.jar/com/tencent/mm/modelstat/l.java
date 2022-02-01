package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.b.r;
import com.tencent.mm.cj.c;
import com.tencent.mm.cj.d.a;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelstat.a.b.1;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.network.ae;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class l
  extends b.a
  implements com.tencent.mm.ak.f
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
        parame = parame.fxX();
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
              ac.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[] { Long.valueOf(parame[i].length()), com.tencent.mm.vfs.q.B(parame[i].mUri) });
            }
            l2 = l1;
            l3 = parame[i].length();
            l1 += l3;
          }
        }
      }
      catch (Exception parame)
      {
        ac.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[] { bs.m(parame) });
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
    if (!com.tencent.mm.kernel.g.agP().afY())
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
      ac.d("MicroMsg.NetStatMsgExtension", "send bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(0L, paramInt3, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(0L, paramInt3, paramInt2);
      AppMethodBeat.o(151096);
      return;
      ac.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(paramInt3, 0L, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(paramInt3, 0L, paramInt2);
      AppMethodBeat.o(151096);
      return;
      am.aKO("dns_failed_report");
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(151094);
    com.tencent.mm.kernel.g.agU().m(new Runnable()
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
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(151093);
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      ac.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
      AppMethodBeat.o(151093);
      return null;
    }
    parama = parama.fXi.DPV.FEm;
    ac.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", new Object[] { parama });
    if (bs.isNullOrNil(parama))
    {
      AppMethodBeat.o(151093);
      return null;
    }
    ac.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", new Object[] { parama });
    Object localObject1 = bv.L(parama, "cmd");
    long l;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = bv.L(parama, "ClearCache");
      if (localObject1 != null)
      {
        l = bs.getLong((String)((Map)localObject1).get(".ClearCache.androidCacheMask"), 0L);
        localObject1 = (String)((Map)localObject1).get(".ClearCache.message");
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_mask", l);
        ((Intent)localObject2).putExtra("key_message", (String)localObject1);
        com.tencent.mm.br.d.e(ai.getContext(), ".ui.ClearCacheUI", (Intent)localObject2);
      }
    }
    for (;;)
    {
      ac.eUQ();
      com.tencent.mm.kernel.g.agi().hwg.As(parama);
      try
      {
        Thread.sleep(50L, 0);
        label202:
        LogLogic.initIPxxLogInfo();
        MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
        AppMethodBeat.o(151093);
        return null;
        int i = bs.getInt((String)((Map)localObject1).get(".cmd.trace.$code"), -1);
        if (i > 0)
        {
          if (i == 6)
          {
            parama = new wz();
            com.tencent.mm.sdk.b.a.GpY.l(parama);
            AppMethodBeat.o(151093);
            return null;
          }
          parama = (String)((Map)localObject1).get(".cmd.trace.$class");
          int j = bs.getInt((String)((Map)localObject1).get(".cmd.trace.$size"), 0);
          int k = bs.getInt((String)((Map)localObject1).get(".cmd.trace.$type"), 0);
          com.tencent.mm.cj.d.feq().c(new d.a(parama, i, j, k));
          AppMethodBeat.o(151093);
          return null;
        }
        i = bs.getInt((String)((Map)localObject1).get(".cmd.hprof.$type"), -1);
        if (i > 0)
        {
          ac.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[] { Integer.valueOf(i) });
          c.Zf(i);
          AppMethodBeat.o(151093);
          return null;
        }
        if ("android".equalsIgnoreCase((String)((Map)localObject1).get(".cmd.prconfig.$os")))
        {
          parama = new jw();
          parama.dlq.dlr = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$url"));
          parama.dlq.dls = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$signature"));
          parama.dlq.dlt = ((String)((Map)localObject1).get(".cmd.prconfig.$url"));
          parama.dlq.dlu = ((String)((Map)localObject1).get(".cmd.prconfig.$signature"));
          com.tencent.mm.sdk.b.a.GpY.a(parama, Looper.myLooper());
          AppMethodBeat.o(151093);
          return null;
        }
        i = bs.getInt((String)((Map)localObject1).get(".cmd.clearfile.$fb"), -1);
        if (i == 1)
        {
          l = bs.getInt((String)((Map)localObject1).get(".cmd.clearfile.$ps"), 1048576);
          com.tencent.mm.kernel.g.agU().az(new l.1(this, l));
          i = bs.getInt((String)((Map)localObject1).get(".cmd.updzh.$pt"), -1);
          localObject2 = (String)((Map)localObject1).get(".cmd.updzh.$pd");
          ac.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[] { Integer.valueOf(i), localObject2 });
          if ((i > 0) && (!bs.isNullOrNil((String)localObject2))) {
            com.tencent.mm.kernel.g.agU().az(new l.2(this, i, (String)localObject2));
          }
          i = bs.getInt((String)((Map)localObject1).get(".cmd.uploadx5log.type"), -1);
          if (i <= 0) {
            break label1261;
          }
          parama = (String)((Map)localObject1).get(".cmd.uploadx5log.date");
          localObject1 = (String)((Map)localObject1).get(".cmd.uploadx5log.process");
          ac.i("MicroMsg.UploadX5Log", "upload, date %s,process %s,type %d", new Object[] { parama, localObject1, Integer.valueOf(i) });
          if (i != 1) {
            break label1145;
          }
          if ((!bs.isNullOrNil(parama)) && (!bs.isNullOrNil((String)localObject1))) {
            break label1089;
          }
          ac.w("MicroMsg.UploadX5Log", "date or process is null,date %s,process %s", new Object[] { parama, localObject1 });
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
              label856:
              ac.i("MicroMsg.NetStatMsgExtension", "clearfile delete :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              i.deleteFile((String)localObject2);
              locale = new com.tencent.mm.vfs.e((String)localObject2);
              if (!locale.exists()) {
                break label949;
              }
            }
            label949:
            for (l = locale.length();; l = -1L)
            {
              ac.i("MicroMsg.NetStatMsgExtension", "clearfile delete finish :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              break;
              l = -1L;
              break label856;
            }
          }
          if (i != 3) {
            break;
          }
          ac.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + com.tencent.mm.kernel.g.agR().agx() + ".tem");
          i.deleteFile(com.tencent.mm.kernel.g.agR().agx() + ".tem");
          i.deleteFile(com.tencent.mm.kernel.g.agR().agy() + ".tem");
          ac.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + com.tencent.mm.kernel.g.agR().agx() + ".tem");
          break;
          label1089:
          label1145:
          for (parama = String.format("%s/tencent/tbs_live_log/com.tencent.mm/com.tencent.mm_%s_%s.livelog", new Object[] { b.apb(), localObject1, parama });; parama = b.apb() + "/Android/data/com.tencent.mm/files/tbslog/tbslog.txt")
          {
            localObject1 = new com.tencent.mm.vfs.e(parama);
            if (((com.tencent.mm.vfs.e)localObject1).exists()) {
              break label1171;
            }
            ac.i("MicroMsg.UploadX5Log", "upload file not exists");
            break;
          }
          label1171:
          parama = r.a((com.tencent.mm.vfs.e)localObject1, false, parama + ".zip");
          if (parama == null)
          {
            ac.i("MicroMsg.UploadX5Log", "zipPath is null");
          }
          else
          {
            parama = new com.tencent.mm.vfs.e(parama);
            if (!parama.exists()) {
              ac.i("MicroMsg.UploadX5Log", "upload zip file not exists");
            } else {
              com.tencent.mm.cn.g.eo(parama).h(new b.1(i));
            }
          }
        }
        label1261:
        com.tencent.mm.plugin.performance.a.a.vAc.ap((Map)localObject1);
      }
      catch (Exception parama)
      {
        break label202;
      }
    }
  }
  
  public final void b(f.c paramc) {}
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    AppMethodBeat.i(151095);
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      AppMethodBeat.o(151095);
      return;
    }
    if (!com.tencent.mm.kernel.g.agS().gic.giw)
    {
      ac.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
      AppMethodBeat.o(151095);
      return;
    }
    ac.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (ae.cS(ai.getContext()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.l
 * JD-Core Version:    0.7.0.1
 */