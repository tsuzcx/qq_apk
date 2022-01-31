package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.p;
import com.tencent.mm.ch.c;
import com.tencent.mm.ch.d.a;
import com.tencent.mm.h.a.ij;
import com.tencent.mm.h.a.sw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.Map;

public final class l
  extends b.a
  implements com.tencent.mm.ah.e
{
  public static long a(File paramFile, long paramLong)
  {
    long l1 = 0L;
    long l2 = l1;
    for (;;)
    {
      int i;
      long l3;
      try
      {
        paramFile = paramFile.listFiles();
        i = 0;
        l2 = l1;
        l3 = l1;
        if (i < paramFile.length)
        {
          l2 = l1;
          if (paramFile[i].isDirectory())
          {
            l2 = l1;
            l1 += a(paramFile[i], paramLong);
          }
          else
          {
            l2 = l1;
            if (paramFile[i].length() > paramLong)
            {
              l2 = l1;
              y.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[] { Long.valueOf(paramFile[i].length()), paramFile[i].getPath() });
            }
            l2 = l1;
            l3 = paramFile[i].length();
            l1 += l3;
          }
        }
      }
      catch (Exception paramFile)
      {
        y.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[] { bk.j(paramFile) });
        l3 = l2;
      }
      return l3;
      i += 1;
    }
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!g.DN().Dc()) {
      return;
    }
    switch (paramInt1)
    {
    case 6: 
    case 7: 
    default: 
      return;
    case 4: 
      y.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:" + paramInt3);
      if (paramBoolean)
      {
        n.w(paramInt3, 0, paramInt2);
        return;
      }
    case 5: 
      y.d("MicroMsg.NetStatMsgExtension", "send bytes flow:" + paramInt3);
      if (paramBoolean)
      {
        n.w(0, paramInt3, paramInt2);
        return;
      }
      n.x(0, paramInt3, paramInt2);
      return;
      n.x(paramInt3, 0, paramInt2);
      return;
    }
    ag.Zm("dns_failed_report");
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, boolean paramBoolean)
  {
    g.DS().k(new l.3(this, paramInt1, paramInt2, paramString1, paramInt3, paramString2, paramBoolean), 3000L);
  }
  
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    if (!g.DN().Dc()) {
      y.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
    }
    do
    {
      return null;
      parama = parama.dBs.svH.tFO;
      y.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", new Object[] { parama });
    } while (bk.bl(parama));
    y.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", new Object[] { parama });
    Object localObject1 = bn.s(parama, "cmd");
    long l;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = bn.s(parama, "ClearCache");
      if (localObject1 != null)
      {
        l = bk.getLong((String)((Map)localObject1).get(".ClearCache.androidCacheMask"), 0L);
        localObject1 = (String)((Map)localObject1).get(".ClearCache.message");
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_mask", l);
        ((Intent)localObject2).putExtra("key_message", (String)localObject1);
        com.tencent.mm.br.d.e(ae.getContext(), ".ui.ClearCacheUI", (Intent)localObject2);
      }
    }
    for (;;)
    {
      y.cqL();
      g.Dk().edx.kt(parama);
      try
      {
        Thread.sleep(50L, 0);
        label185:
        LogLogic.initIPxxLogInfo();
        MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
        return null;
        int i = bk.getInt((String)((Map)localObject1).get(".cmd.trace.$code"), -1);
        if (i > 0)
        {
          if (i == 6)
          {
            parama = new sw();
            com.tencent.mm.sdk.b.a.udP.m(parama);
            return null;
          }
          parama = (String)((Map)localObject1).get(".cmd.trace.$class");
          int j = bk.getInt((String)((Map)localObject1).get(".cmd.trace.$size"), 0);
          int k = bk.getInt((String)((Map)localObject1).get(".cmd.trace.$type"), 0);
          com.tencent.mm.ch.d.cxA().c(new d.a(parama, i, j, k));
          return null;
        }
        i = bk.getInt((String)((Map)localObject1).get(".cmd.hprof.$type"), -1);
        if (i > 0)
        {
          y.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[] { Integer.valueOf(i) });
          c.FG(i);
          return null;
        }
        if ("android".equalsIgnoreCase((String)((Map)localObject1).get(".cmd.hotpatch.$os")))
        {
          parama = new ij();
          parama.bQz.bQA = ((String)((Map)localObject1).get(".cmd.hotpatch.xml.$url"));
          parama.bQz.bQB = ((String)((Map)localObject1).get(".cmd.hotpatch.xml.$signature"));
          parama.bQz.bQC = ((String)((Map)localObject1).get(".cmd.hotpatch.$url"));
          parama.bQz.bQD = ((String)((Map)localObject1).get(".cmd.hotpatch.$signature"));
          com.tencent.mm.sdk.b.a.udP.a(parama, Looper.myLooper());
          return null;
        }
        i = bk.getInt((String)((Map)localObject1).get(".cmd.clearfile.$fb"), -1);
        if (i == 1)
        {
          l = bk.getInt((String)((Map)localObject1).get(".cmd.clearfile.$ps"), 1048576);
          g.DS().O(new l.1(this, l));
        }
        for (;;)
        {
          i = bk.getInt((String)((Map)localObject1).get(".cmd.updzh.$pt"), -1);
          localObject1 = (String)((Map)localObject1).get(".cmd.updzh.$pd");
          y.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[] { Integer.valueOf(i), localObject1 });
          if ((i <= 0) || (bk.bl((String)localObject1))) {
            break;
          }
          g.DS().O(new l.2(this, i, (String)localObject1));
          break;
          if (i == 2)
          {
            localObject2 = (String)((Map)localObject1).get(".cmd.clearfile.$pd");
            File localFile = new File((String)localObject2);
            if (localFile.exists())
            {
              l = localFile.length();
              label688:
              y.i("MicroMsg.NetStatMsgExtension", "clearfile delete :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              com.tencent.mm.a.e.deleteFile((String)localObject2);
              localFile = new File((String)localObject2);
              if (!localFile.exists()) {
                break label781;
              }
            }
            label781:
            for (l = localFile.length();; l = -1L)
            {
              y.i("MicroMsg.NetStatMsgExtension", "clearfile delete finish :[%s] length:%s", new Object[] { localObject2, Long.valueOf(l) });
              break;
              l = -1L;
              break label688;
            }
          }
          if (i == 3)
          {
            y.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + g.DP().Dw() + ".tem");
            com.tencent.mm.a.e.deleteFile(g.DP().Dw() + ".tem");
            com.tencent.mm.a.e.deleteFile(g.DP().Dx() + ".tem");
            y.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + g.DP().Dw() + ".tem");
          }
        }
      }
      catch (Exception parama)
      {
        break label185;
      }
    }
  }
  
  public final void m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!g.DN().Dc()) {
      return;
    }
    if (!g.DQ().dKP.dLj)
    {
      y.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
      return;
    }
    y.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label108;
      }
      label80:
      n.w(paramInt1, paramInt2, 0);
      if (paramInt3 <= 0) {
        break label113;
      }
      label90:
      if (paramInt4 <= 0) {
        break label118;
      }
    }
    for (;;)
    {
      n.x(paramInt3, paramInt4, 0);
      return;
      paramInt1 = 0;
      break;
      label108:
      paramInt2 = 0;
      break label80;
      label113:
      paramInt3 = 0;
      break label90;
      label118:
      paramInt4 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.l
 * JD-Core Version:    0.7.0.1
 */