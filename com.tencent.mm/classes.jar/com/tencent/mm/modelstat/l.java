package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.r;
import com.tencent.mm.ci.d;
import com.tencent.mm.ci.d.a;
import com.tencent.mm.co.f;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.yy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.a.b.1;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import java.util.Map;

public final class l
  extends b.a
  implements com.tencent.mm.ak.h
{
  public static long a(o paramo, long paramLong)
  {
    AppMethodBeat.i(177293);
    long l1 = 0L;
    long l2 = l1;
    for (;;)
    {
      int i;
      try
      {
        paramo = paramo.het();
        i = 0;
        l2 = l1;
        l3 = l1;
        if (i < paramo.length)
        {
          l2 = l1;
          if (paramo[i].isDirectory())
          {
            l2 = l1;
            l1 += a(paramo[i], paramLong);
          }
          else
          {
            l2 = l1;
            if (paramo[i].length() > paramLong)
            {
              l2 = l1;
              Log.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[] { Long.valueOf(paramo[i].length()), com.tencent.mm.vfs.aa.z(paramo[i].mUri) });
            }
            l2 = l1;
            l3 = paramo[i].length();
            l1 += l3;
          }
        }
      }
      catch (Exception paramo)
      {
        Log.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[] { Util.stackTraceToString(paramo) });
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
    if (!com.tencent.mm.kernel.g.aAf().azp())
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
      Log.d("MicroMsg.NetStatMsgExtension", "send bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(0L, paramInt3, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(0L, paramInt3, paramInt2);
      AppMethodBeat.o(151096);
      return;
      Log.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        n.b(paramInt3, 0L, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      n.c(paramInt3, 0L, paramInt2);
      AppMethodBeat.o(151096);
      return;
      MMEntryLock.lock("dns_failed_report");
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(151094);
    com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
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
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(151093);
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      Log.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
      AppMethodBeat.o(151093);
      return null;
    }
    parama = parama.heO.KHn.MTo;
    Log.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", new Object[] { parama });
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(151093);
      return null;
    }
    Log.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", new Object[] { parama });
    Object localObject1 = XmlParser.parseXml(parama, "cmd", null);
    final long l;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = XmlParser.parseXml(parama, "ClearCache", null);
      if (localObject1 != null)
      {
        l = Util.getLong((String)((Map)localObject1).get(".ClearCache.androidCacheMask"), 0L);
        localObject1 = (String)((Map)localObject1).get(".ClearCache.message");
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_mask", l);
        ((Intent)localObject2).putExtra("key_message", (String)localObject1);
        com.tencent.mm.br.c.f(MMApplicationContext.getContext(), ".ui.ClearCacheUI", (Intent)localObject2);
      }
    }
    for (;;)
    {
      Log.appenderFlush();
      com.tencent.mm.kernel.g.azz().iMw.MH(parama);
      try
      {
        Thread.sleep(50L, 0);
        label204:
        LogLogic.initIPxxLogInfo();
        MMProtocalJni.setProtocalJniLogLevel(Log.getLogLevel());
        AppMethodBeat.o(151093);
        return null;
        final int i = Util.getInt((String)((Map)localObject1).get(".cmd.trace.$code"), -1);
        if (i > 0)
        {
          if (i == 6)
          {
            parama = new yy();
            EventCenter.instance.publish(parama);
            AppMethodBeat.o(151093);
            return null;
          }
          parama = (String)((Map)localObject1).get(".cmd.trace.$class");
          int j = Util.getInt((String)((Map)localObject1).get(".cmd.trace.$size"), 0);
          int k = Util.getInt((String)((Map)localObject1).get(".cmd.trace.$type"), 0);
          d.gGm().c(new d.a(parama, i, j, k));
          AppMethodBeat.o(151093);
          return null;
        }
        i = Util.getInt((String)((Map)localObject1).get(".cmd.hprof.$type"), -1);
        if (i > 0)
        {
          Log.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.ci.c.akE(i);
          AppMethodBeat.o(151093);
          return null;
        }
        if ("android".equalsIgnoreCase((String)((Map)localObject1).get(".cmd.prconfig.$os")))
        {
          parama = new ku();
          parama.dPP.dPQ = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$url"));
          parama.dPP.dPR = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$signature"));
          parama.dPP.dPS = ((String)((Map)localObject1).get(".cmd.prconfig.$url"));
          parama.dPP.dPT = ((String)((Map)localObject1).get(".cmd.prconfig.$signature"));
          EventCenter.instance.asyncPublish(parama, Looper.myLooper());
          AppMethodBeat.o(151093);
          return null;
        }
        i = Util.getInt((String)((Map)localObject1).get(".cmd.clearfile.$fb"), -1);
        if (i == 1)
        {
          l = Util.getInt((String)((Map)localObject1).get(".cmd.clearfile.$ps"), 1048576);
          com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(151087);
              long l = Util.nowMilliSecond();
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new o(com.tencent.mm.kernel.g.aAh().cachePath), l)), com.tencent.mm.kernel.g.aAh().cachePath });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new o(com.tencent.mm.kernel.g.aAh().hqF), l)), com.tencent.mm.kernel.g.aAh().hqF });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new o(com.tencent.mm.kernel.g.aAh().hqF), l)), com.tencent.mm.kernel.g.aAh().hqF });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new o(com.tencent.mm.kernel.g.aAh().hqG), l)), com.tencent.mm.kernel.g.aAh().hqG });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(l.a(new o(ar.NSe), l)), ar.NSe });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
              AppMethodBeat.o(151087);
            }
          });
          i = Util.getInt((String)((Map)localObject1).get(".cmd.updzh.$pt"), -1);
          localObject2 = (String)((Map)localObject1).get(".cmd.updzh.$pd");
          Log.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[] { Integer.valueOf(i), localObject2 });
          if ((i > 0) && (!Util.isNullOrNil((String)localObject2))) {
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
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
                  com.tencent.mm.platformtools.aa.a(com.tencent.mm.kernel.g.aAh().hqG + this.joM, z.aTY(), false, true);
                  AppMethodBeat.o(151088);
                  return;
                  com.tencent.mm.platformtools.aa.a(com.tencent.mm.kernel.g.aAh().cachePath + this.joM, z.aTY(), false, true);
                  AppMethodBeat.o(151088);
                  return;
                  com.tencent.mm.platformtools.aa.a(this.joM, z.aTY(), false, true);
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
          i = Util.getInt((String)((Map)localObject1).get(".cmd.uploadx5log.type"), -1);
          if (i <= 0) {
            break label1290;
          }
          parama = (String)((Map)localObject1).get(".cmd.uploadx5log.date");
          localObject1 = (String)((Map)localObject1).get(".cmd.uploadx5log.process");
          Log.i("MicroMsg.UploadX5Log", "upload, date %s,process %s,type %d", new Object[] { parama, localObject1, Integer.valueOf(i) });
          if (i != 1) {
            break label1162;
          }
          if ((!Util.isNullOrNil(parama)) && (!Util.isNullOrNil((String)localObject1))) {
            break label1084;
          }
          Log.w("MicroMsg.UploadX5Log", "date or process is null,date %s,process %s", new Object[] { parama, localObject1 });
        }
        for (;;)
        {
          AppMethodBeat.o(151093);
          return null;
          if (i == 2)
          {
            localObject2 = (String)((Map)localObject1).get(".cmd.clearfile.$pd");
            o localo = new o((String)localObject2);
            if (localo.exists())
            {
              l = localo.length();
              label851:
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile delete :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              com.tencent.mm.vfs.s.deleteFile((String)localObject2);
              localo = new o((String)localObject2);
              if (!localo.exists()) {
                break label944;
              }
            }
            label944:
            for (l = localo.length();; l = -1L)
            {
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile delete finish :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              break;
              l = -1L;
              break label851;
            }
          }
          if (i != 3) {
            break;
          }
          Log.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + com.tencent.mm.kernel.g.aAh().azN() + ".tem");
          com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.kernel.g.aAh().azN() + ".tem");
          com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.kernel.g.aAh().azO() + ".tem");
          Log.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + com.tencent.mm.kernel.g.aAh().azN() + ".tem");
          break;
          label1084:
          for (parama = String.format("%s/tencent/tbs_live_log/" + MMApplicationContext.getApplicationId() + "/com.tencent.mm_%s_%s.livelog", new Object[] { com.tencent.mm.loader.j.b.aKD(), localObject1, parama });; parama = com.tencent.mm.loader.j.b.aKD() + "/Android/data/" + MMApplicationContext.getApplicationId() + "/files/tbslog/tbslog.txt")
          {
            localObject1 = new o(parama);
            if (((o)localObject1).exists()) {
              break label1200;
            }
            Log.i("MicroMsg.UploadX5Log", "upload file not exists");
            break;
          }
          label1162:
          label1200:
          parama = r.a((o)localObject1, false, parama + ".zip");
          if (parama == null)
          {
            Log.i("MicroMsg.UploadX5Log", "zipPath is null");
          }
          else
          {
            parama = new o(parama);
            if (!parama.exists()) {
              Log.i("MicroMsg.UploadX5Log", "upload zip file not exists");
            } else {
              com.tencent.mm.co.g.ey(parama).h(new b.1(i));
            }
          }
        }
        label1290:
        i = Util.getInt((String)((Map)localObject1).get(".cmd.testbizad.type"), -1);
        if (i > 0)
        {
          parama = (String)((Map)localObject1).get(".cmd.testbizad.content");
          ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getBizTimeLineCallback().aB(i, parama);
          AppMethodBeat.o(151093);
          return null;
        }
        com.tencent.mm.plugin.performance.a.a.ASb.aA((Map)localObject1);
      }
      catch (Exception parama)
      {
        break label204;
      }
    }
  }
  
  public final void b(h.c paramc) {}
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    AppMethodBeat.i(151095);
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(151095);
      return;
    }
    if (!com.tencent.mm.kernel.g.aAi().hrh.hrB)
    {
      Log.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
      AppMethodBeat.o(151095);
      return;
    }
    Log.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (ag.dm(MMApplicationContext.getContext()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.l
 * JD-Core Version:    0.7.0.1
 */