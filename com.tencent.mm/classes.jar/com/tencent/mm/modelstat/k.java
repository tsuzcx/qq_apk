package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.acb;
import com.tencent.mm.autogen.a.mr;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Map;

public final class k
  extends b.a
  implements com.tencent.mm.am.g
{
  public static long a(u paramu, long paramLong)
  {
    AppMethodBeat.i(177293);
    long l1 = 0L;
    long l2 = l1;
    for (;;)
    {
      int i;
      try
      {
        paramu = paramu.jKX();
        i = 0;
        l2 = l1;
        l3 = l1;
        if (i < paramu.length)
        {
          l2 = l1;
          if (paramu[i].isDirectory())
          {
            l2 = l1;
            l1 += a(paramu[i], paramLong);
          }
          else
          {
            l2 = l1;
            if (paramu[i].length() > paramLong)
            {
              l2 = l1;
              Log.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[] { Long.valueOf(paramu[i].length()), com.tencent.mm.vfs.ah.v(paramu[i].mUri) });
            }
            l2 = l1;
            l3 = paramu[i].length();
            l1 += l3;
          }
        }
      }
      catch (Exception paramu)
      {
        Log.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[] { Util.stackTraceToString(paramu) });
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
    if (!h.baC().aZN())
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
        m.e(0L, paramInt3, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      m.f(0L, paramInt3, paramInt2);
      AppMethodBeat.o(151096);
      return;
      Log.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(paramInt3)));
      if (paramBoolean)
      {
        m.e(paramInt3, 0L, paramInt2);
        AppMethodBeat.o(151096);
        return;
      }
      m.f(paramInt3, 0L, paramInt2);
      AppMethodBeat.o(151096);
      return;
      MMEntryLock.lock("dns_failed_report");
    }
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = 0L;
    AppMethodBeat.i(151095);
    if (!h.baC().aZN())
    {
      AppMethodBeat.o(151095);
      return;
    }
    if (!h.baF().mDl.mDG)
    {
      Log.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
      AppMethodBeat.o(151095);
      return;
    }
    Log.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (com.tencent.mm.network.ah.eb(MMApplicationContext.getContext()))
    {
      if (paramInt1 > 0) {}
      for (l2 = paramInt1;; l2 = 0L)
      {
        if (paramInt2 > 0) {
          l1 = paramInt2;
        }
        m.e(l2, l1, 0);
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
      m.f(l2, l1, 0);
      AppMethodBeat.o(151095);
      return;
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(151094);
    h.baH().postToWorkerDelayed(new Runnable()
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
  
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(151093);
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
      AppMethodBeat.o(151093);
      return null;
    }
    parama = parama.mpN.YFG.abwM;
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
        c.g(MMApplicationContext.getContext(), ".ui.ClearCacheUI", (Intent)localObject2);
      }
    }
    for (;;)
    {
      Log.appenderFlush();
      h.aZW().oun.Mb(parama);
      try
      {
        Thread.sleep(50L, 0);
        label204:
        LogLogic.initIPxxLogInfo();
        MMProtocalJni.setProtocalJniLogLevel(Log.getLogLevel());
        AppMethodBeat.o(151093);
        return null;
        localObject1 = XmlParser.parseXml(parama, "uploadFiles", null);
        if ((localObject1 == null) || (((Map)localObject1).isEmpty())) {
          continue;
        }
        a.MIk.aK((Map)localObject1);
        continue;
        final int i = Util.getInt((String)((Map)localObject1).get(".cmd.trace.$code"), -1);
        if (i > 0)
        {
          if (i == 6)
          {
            new acb().publish();
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
          parama = new mr();
          parama.hON.hOO = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$url"));
          parama.hON.hOP = ((String)((Map)localObject1).get(".cmd.prconfig.xml.$signature"));
          parama.hON.hOQ = ((String)((Map)localObject1).get(".cmd.prconfig.$url"));
          parama.hON.hOR = ((String)((Map)localObject1).get(".cmd.prconfig.$signature"));
          parama.asyncPublish(Looper.myLooper());
          AppMethodBeat.o(151093);
          return null;
        }
        i = Util.getInt((String)((Map)localObject1).get(".cmd.clearfile.$fb"), -1);
        if (i == 1)
        {
          l = Util.getInt((String)((Map)localObject1).get(".cmd.clearfile.$ps"), 1048576);
          h.baH().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(151087);
              long l = Util.nowMilliSecond();
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new u(h.baE().cachePath), l)), h.baE().cachePath });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new u(h.baE().mCI), l)), h.baE().mCI });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new u(h.baE().mCI), l)), h.baE().mCI });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new u(h.baE().mCJ), l)), h.baE().mCJ });
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[] { Long.valueOf(k.a(new u(at.acHq), l)), at.acHq });
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
            h.baH().postToWorker(new Runnable()
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
                  x.cj(h.baE().mCJ + this.oWV, z.bAM());
                  AppMethodBeat.o(151088);
                  return;
                  x.cj(h.baE().cachePath + this.oWV, z.bAM());
                  AppMethodBeat.o(151088);
                  return;
                  x.cj(this.oWV, z.bAM());
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
          i = Util.getInt((String)((Map)localObject1).get(".cmd.uploadx5log.$type"), -1);
          if (i <= 0) {
            break;
          }
          com.tencent.mm.modelstat.a.b.r((String)((Map)localObject1).get(".cmd.uploadx5log.$date"), (String)((Map)localObject1).get(".cmd.uploadx5log.$process"), i);
          AppMethodBeat.o(151093);
          return null;
          if (i == 2)
          {
            localObject2 = (String)((Map)localObject1).get(".cmd.clearfile.$pd");
            u localu = new u((String)localObject2);
            if (localu.jKS())
            {
              l = localu.length();
              label780:
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile delete :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              y.deleteFile((String)localObject2);
              localu = new u((String)localObject2);
              if (!localu.jKS()) {
                break label869;
              }
            }
            label869:
            for (l = localu.length();; l = -1L)
            {
              Log.i("MicroMsg.NetStatMsgExtension", "clearfile delete finish :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              break;
              l = -1L;
              break label780;
            }
          }
          if (i == 3)
          {
            Log.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + h.baE().bak() + ".tem");
            y.deleteFile(h.baE().bak() + ".tem");
            y.deleteFile(h.baE().bal() + ".tem");
            Log.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + h.baE().bak() + ".tem");
          }
        }
        i = Util.getInt((String)((Map)localObject1).get(".cmd.testbizad.type"), -1);
        if (i > 0)
        {
          parama = (String)((Map)localObject1).get(".cmd.testbizad.content");
          ((v)h.az(v.class)).getBizTimeLineCallback().aQ(i, parama);
          AppMethodBeat.o(151093);
          return null;
        }
        a.MIk.aK((Map)localObject1);
      }
      catch (Exception parama)
      {
        break label204;
      }
    }
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */