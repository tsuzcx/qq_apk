package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.aaf;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Map;

public final class k
  extends b.a
  implements com.tencent.mm.an.h
{
  public static long a(q paramq, long paramLong)
  {
    AppMethodBeat.i(177293);
    long l1 = 0L;
    long l2 = l1;
    for (;;)
    {
      int i;
      try
      {
        paramq = paramq.ifJ();
        i = 0;
        l2 = l1;
        l3 = l1;
        if (i < paramq.length)
        {
          l2 = l1;
          if (paramq[i].isDirectory())
          {
            l2 = l1;
            l1 += a(paramq[i], paramLong);
          }
          else
          {
            l2 = l1;
            if (paramq[i].length() > paramLong)
            {
              l2 = l1;
              Log.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[] { Long.valueOf(paramq[i].length()), paramq[i].getPath() });
            }
            l2 = l1;
            l3 = paramq[i].length();
            l1 += l3;
          }
        }
      }
      catch (Exception paramq)
      {
        Log.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[] { Util.stackTraceToString(paramq) });
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
    if (!com.tencent.mm.kernel.h.aHE().aGM())
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
        m.c(0L, paramInt3, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      m.d(0L, paramInt3, paramInt2);
      AppMethodBeat.o(151096);
      return;
      Log.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        m.c(paramInt3, 0L, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      m.d(paramInt3, 0L, paramInt2);
      AppMethodBeat.o(151096);
      return;
      MMEntryLock.lock("dns_failed_report");
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(151094);
    com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151090);
        k.b(paramInt1, paramInt2, paramInt3, paramBoolean);
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
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      Log.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
      AppMethodBeat.o(151093);
      return null;
    }
    parama = parama.jQG.RIF.Ufy;
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
        c.f(MMApplicationContext.getContext(), ".ui.ClearCacheUI", (Intent)localObject2);
      }
    }
    for (;;)
    {
      Log.appenderFlush();
      com.tencent.mm.kernel.h.aGY().lCD.Uc(parama);
      try
      {
        Thread.sleep(50L, 0);
        label202:
        LogLogic.initIPxxLogInfo();
        MMProtocalJni.setProtocalJniLogLevel(Log.getLogLevel());
        AppMethodBeat.o(151093);
        return null;
        final int i = Util.getInt((String)((Map)localObject1).get(".cmd.trace.$code"), -1);
        if (i > 0)
        {
          if (i == 6)
          {
            parama = new aaf();
            EventCenter.instance.publish(parama);
            AppMethodBeat.o(151093);
            return null;
          }
          ((Map)localObject1).get(".cmd.trace.$class");
          Util.getInt((String)((Map)localObject1).get(".cmd.trace.$size"), 0);
          Util.getInt((String)((Map)localObject1).get(".cmd.trace.$type"), 0);
          AppMethodBeat.o(151093);
          return null;
        }
        i = Util.getInt((String)((Map)localObject1).get(".cmd.hprof.$type"), -1);
        if (i > 0)
        {
          Log.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(151093);
          return null;
        }
        if ("android".equalsIgnoreCase((String)((Map)localObject1).get(".cmd.prconfig.$os")))
        {
          parama = new ll();
          parama.fJg.fJh = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$url"));
          parama.fJg.fJi = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$signature"));
          parama.fJg.fJj = ((String)((Map)localObject1).get(".cmd.prconfig.$url"));
          parama.fJg.fJk = ((String)((Map)localObject1).get(".cmd.prconfig.$signature"));
          EventCenter.instance.asyncPublish(parama, Looper.myLooper());
          AppMethodBeat.o(151093);
          return null;
        }
        i = Util.getInt((String)((Map)localObject1).get(".cmd.clearfile.$fb"), -1);
        if (i == 1)
        {
          l = Util.getInt((String)((Map)localObject1).get(".cmd.clearfile.$ps"), 1048576);
          com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(151087);
              long l = Util.nowMilliSecond();
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new q(com.tencent.mm.kernel.h.aHG().cachePath), l)), com.tencent.mm.kernel.h.aHG().cachePath });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new q(com.tencent.mm.kernel.h.aHG().kcA), l)), com.tencent.mm.kernel.h.aHG().kcA });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new q(com.tencent.mm.kernel.h.aHG().kcA), l)), com.tencent.mm.kernel.h.aHG().kcA });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new q(com.tencent.mm.kernel.h.aHG().kcB), l)), com.tencent.mm.kernel.h.aHG().kcB });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new q(ar.Vgb), l)), ar.Vgb });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
              AppMethodBeat.o(151087);
            }
          });
        }
        for (;;)
        {
          i = Util.getInt((String)((Map)localObject1).get(".cmd.updzh.$pt"), -1);
          localObject2 = (String)((Map)localObject1).get(".cmd.updzh.$pd");
          Log.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[] { Integer.valueOf(i), localObject2 });
          if ((i > 0) && (!Util.isNullOrNil((String)localObject2))) {
            com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
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
                  aa.bW(com.tencent.mm.kernel.h.aHG().kcB + this.mec, z.bcZ());
                  AppMethodBeat.o(151088);
                  return;
                  aa.bW(com.tencent.mm.kernel.h.aHG().cachePath + this.mec, z.bcZ());
                  AppMethodBeat.o(151088);
                  return;
                  aa.bW(this.mec, z.bcZ());
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
            break;
          }
          com.tencent.mm.modelstat.a.b.o((String)((Map)localObject1).get(".cmd.uploadx5log.date"), (String)((Map)localObject1).get(".cmd.uploadx5log.process"), i);
          AppMethodBeat.o(151093);
          return null;
          if (i == 2)
          {
            localObject2 = (String)((Map)localObject1).get(".cmd.clearfile.$pd");
            q localq = new q((String)localObject2);
            if (localq.ifE())
            {
              l = localq.length();
              label750:
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile delete :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              u.deleteFile((String)localObject2);
              localq = new q((String)localObject2);
              if (!localq.ifE()) {
                break label839;
              }
            }
            label839:
            for (l = localq.length();; l = -1L)
            {
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile delete finish :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              break;
              l = -1L;
              break label750;
            }
          }
          if (i == 3)
          {
            Log.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + com.tencent.mm.kernel.h.aHG().aHm() + ".tem");
            u.deleteFile(com.tencent.mm.kernel.h.aHG().aHm() + ".tem");
            u.deleteFile(com.tencent.mm.kernel.h.aHG().aHn() + ".tem");
            Log.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + com.tencent.mm.kernel.h.aHG().aHm() + ".tem");
          }
        }
        i = Util.getInt((String)((Map)localObject1).get(".cmd.testbizad.type"), -1);
        if (i > 0)
        {
          parama = (String)((Map)localObject1).get(".cmd.testbizad.content");
          ((v)com.tencent.mm.kernel.h.ag(v.class)).getBizTimeLineCallback().aD(i, parama);
          AppMethodBeat.o(151093);
          return null;
        }
        a.GLp.au((Map)localObject1);
      }
      catch (Exception parama)
      {
        break label202;
      }
    }
  }
  
  public final void b(h.c paramc) {}
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    AppMethodBeat.i(151095);
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      AppMethodBeat.o(151095);
      return;
    }
    if (!com.tencent.mm.kernel.h.aHH().kdc.kdw)
    {
      Log.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
      AppMethodBeat.o(151095);
      return;
    }
    Log.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (ag.dj(MMApplicationContext.getContext()))
    {
      if (paramInt1 > 0) {}
      for (l2 = paramInt1;; l2 = 0L)
      {
        if (paramInt2 > 0) {
          l1 = paramInt2;
        }
        m.c(l2, l1, 0);
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
      m.d(l2, l1, 0);
      AppMethodBeat.o(151095);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */