package com.tencent.mm.ag;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.e;
import com.tencent.mm.model.q;
import com.tencent.mm.network.u;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class c
  implements com.tencent.mm.ah.f
{
  boolean ebb = false;
  Set<String> ebc = new HashSet();
  com.tencent.mm.a.f<String, c> ebd = new com.tencent.mm.a.f(400);
  Stack<h> ebe = new Stack();
  private av ebf = null;
  private av ebg = null;
  String ebh = null;
  com.tencent.mm.a.f<String, String> ebi = new com.tencent.mm.a.f(200);
  am ebj = new am(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.am.a()
  {
    private long ebl = 0L;
    
    public final boolean tC()
    {
      long l = System.currentTimeMillis();
      if ((c.this.ebb) && (l - this.ebl > 60000L))
      {
        y.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.ebl) });
        c.this.ebb = false;
      }
      if (c.this.ebb)
      {
        c.this.ebj.S(1000L, 1000L);
        return false;
      }
      this.ebl = l;
      c.this.ebb = true;
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while ((i < 5) && (c.this.ebe.size() > 0))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 42L, 1L, true);
        localLinkedList.add(new bml().YI(((h)c.this.ebe.pop()).getUsername()));
        i += 1;
      }
      g.Dk().a(new j(localLinkedList), 0);
      com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 44L, 1L, true);
      return false;
    }
  }, false);
  
  public c()
  {
    g.Dk().a(123, this);
    this.ebb = false;
    this.ebh = q.Gj();
  }
  
  static d JQ()
  {
    if (g.DN().Dc()) {
      return o.JQ();
    }
    return null;
  }
  
  static h kd(String paramString)
  {
    Object localObject2 = o.Kh().kp(paramString);
    if ((localObject2 != null) && (((h)localObject2).getUsername().equals(paramString))) {}
    Object localObject1;
    byte[] arrayOfByte;
    do
    {
      return localObject2;
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
      if ((localObject1 == null) || (!((ao)localObject1).field_username.equals(paramString)))
      {
        if (localObject1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          y.d("MicroMsg.AvatarService", "ct == null? :%s", new Object[] { Boolean.valueOf(bool), paramString });
          return null;
        }
      }
      if (((ao)localObject1).cCq == 4)
      {
        b.M(paramString, ((ao)localObject1).cCq);
        y.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((ao)localObject1).cCq) });
        return null;
      }
      localObject1 = new h();
      ((h)localObject1).username = paramString;
      ((h)localObject1).cCq = 3;
      arrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abp(paramString);
      localObject2 = localObject1;
    } while (bk.bE(arrayOfByte));
    try
    {
      paramString = b.a(paramString, (axd)new axd().aH(arrayOfByte));
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.AvatarService", "exception:%s", new Object[] { bk.j(paramString) });
        paramString = (String)localObject1;
      }
    }
  }
  
  final int a(av.a parama)
  {
    if ((parama instanceof a))
    {
      if (this.ebf == null) {
        this.ebf = new av(1, "getavatar", 2, g.DS().mnU.getLooper());
      }
      return this.ebf.c(parama);
    }
    if (this.ebg == null) {
      this.ebg = new av(1, "readsave", 1, g.DS().mnU.getLooper());
    }
    return this.ebg.c(parama);
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt)
  {
    d locald = JQ();
    Object localObject2;
    if (locald != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localObject2 = d.kf(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localObject2 != null)
        {
          y.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          return localObject2;
        }
        y.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        label91:
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
    }
    for (Object localObject1 = d.kf(paramString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (paramInt < 0) {
          break;
        }
        localObject2 = localObject1;
        if (paramInt <= 5) {
          break;
        }
        y.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localObject1 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, false, paramInt);
        locald.d(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), (Bitmap)localObject1);
        return localObject1;
      }
      if (paramBoolean) {
        return null;
      }
      y.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.ebc.contains(paramString)) {
        return null;
      }
      this.ebc.add(paramString);
      a(new b(paramString));
      return null;
      localObject2 = null;
      break label91;
    }
  }
  
  public final void cancel()
  {
    while (this.ebe.size() > 0) {
      this.ebc.remove(this.ebe.pop());
    }
  }
  
  public final void kb(String paramString)
  {
    a(new b(paramString));
  }
  
  public final void kc(final String paramString)
  {
    g.DS().O(new Runnable()
    {
      public final void run()
      {
        if (bk.bl(paramString)) {}
        label10:
        label123:
        do
        {
          break label10;
          for (;;)
          {
            return;
            if (!paramString.equals(c.this.ebh))
            {
              Object localObject = c.JR();
              if (localObject == null) {
                break;
              }
              localObject = ((i)localObject).kp(paramString);
              if ((localObject == null) || (!((h)localObject).getUsername().equals(paramString))) {
                break;
              }
              if (bk.UX() - ((h)localObject).ebV * 60L > 86400L) {}
              for (int i = 1; i != 0; i = 0)
              {
                if (!bk.bl(((h)localObject).JY())) {
                  break label123;
                }
                y.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
                return;
              }
            }
          }
        } while (c.JQ() == null);
        d.B(paramString, false);
        d.B(paramString, true);
        c.this.kb(paramString);
      }
      
      public final String toString()
      {
        return super.toString() + "|checkAvatarExpire";
      }
    });
  }
  
  public final String ke(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.ebi.put(str1, paramString);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = String.format("%s%x_", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()) });
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 123) {}
    do
    {
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 12L, 1L, true);
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 45L, 1L, true);
      paramm = (j)paramm;
      paramString = new HashSet();
      Object localObject;
      if (paramm.ebY != null)
      {
        localObject = paramm.ebY.iterator();
        while (((Iterator)localObject).hasNext())
        {
          aqg localaqg = (aqg)((Iterator)localObject).next();
          String str = localaqg.tmm.tFO;
          if ((localaqg.svJ == null) || (localaqg.svJ.tFM == null) || (localaqg.svJ.tFM.oY == null))
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 11L, 1L, true);
          }
          else
          {
            paramString.add(str);
            h localh = new h();
            localh.username = str;
            localh.cCq = 3;
            com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 43L, 1L, true);
            a(new d(localh, localaqg.svJ.tFM.oY));
          }
        }
      }
      if (paramm.ebX != null)
      {
        paramm = paramm.ebX.iterator();
        while (paramm.hasNext())
        {
          localObject = ((bml)paramm.next()).tFO;
          if (!paramString.contains(localObject)) {
            this.ebc.remove(localObject);
          }
        }
      }
      this.ebb = false;
    } while (this.ebe.size() <= 0);
    this.ebj.S(0L, 0L);
  }
  
  private final class a
    implements av.a
  {
    public h ebm = null;
    public byte[] ebn = null;
    
    public a(h paramh)
    {
      this.ebm = paramh;
    }
    
    public final boolean JS()
    {
      if (this.ebm == null) {
        return false;
      }
      if (!aq.isNetworkConnected(ae.getContext()))
      {
        y.w("MicroMsg.HttpGetAvatar", "[tomys] network is unavailable, skip rest loading logic.");
        y.cqL();
      }
      String str = this.ebm.JY();
      Object localObject3 = "";
      int i;
      if (g.DN().Dc())
      {
        i = com.tencent.mm.protocal.d.spa;
        g.DN();
        localObject3 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", new Object[] { Integer.valueOf(i), com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.CK()), Integer.valueOf(aq.getNetTypeForStat(ae.getContext())), Integer.valueOf(aq.getStrength(ae.getContext())) });
      }
      y.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", new Object[] { this.ebm.getUsername(), localObject3 });
      this.ebn = null;
      Object localObject8 = null;
      Object localObject10 = null;
      Object localObject12 = null;
      Object localObject5 = null;
      Object localObject2 = new ByteArrayOutputStream();
      Object localObject17 = null;
      Object localObject18 = null;
      Object localObject19 = null;
      byte[] arrayOfByte4 = null;
      com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 40L, 1L, true);
      byte[] arrayOfByte1 = arrayOfByte4;
      Object localObject13 = localObject2;
      Object localObject6 = localObject17;
      Object localObject14 = localObject2;
      Object localObject9 = localObject18;
      Object localObject15 = localObject2;
      Object localObject11 = localObject19;
      Object localObject16 = localObject2;
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.network.b.a(str, null);
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          ((u)localObject1).setRequestMethod("GET");
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          ((u)localObject1).setRequestProperty("referer", (String)localObject3);
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          ((u)localObject1).setConnectTimeout(5000);
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          ((u)localObject1).setReadTimeout(5000);
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          if (com.tencent.mm.network.b.a((u)localObject1) == 0) {
            continue;
          }
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          i = ((u)localObject1).getResponseCode();
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          localObject3 = ((u)localObject1).getHeaderFields();
          if (localObject3 == null) {
            break label3882;
          }
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          localObject3 = (List)((Map)localObject3).get("X-ErrNo");
          if (localObject3 == null) {
            break label3888;
          }
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          if (((List)localObject3).size() <= 0) {
            break label3888;
          }
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          localObject3 = (String)((List)localObject3).get(0);
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          y.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", new Object[] { str, Integer.valueOf(i), localObject3 });
          switch (i)
          {
          }
        }
        catch (ProtocolException localProtocolException)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 1L, 1L, true);
          localObject8 = com.tencent.mm.plugin.report.service.h.nFQ;
          localObject9 = localProtocolException.getMessage();
          localObject10 = this.ebm.getUsername();
          if (localObject5 != null) {
            continue;
          }
          localObject1 = "null";
          if (localObject5 != null) {
            continue;
          }
          localObject2 = "null";
          if (localObject5 != null) {
            continue;
          }
          localObject3 = "null";
          ((com.tencent.mm.plugin.report.service.h)localObject8).f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10001), localObject9, Integer.valueOf(0), localObject10, localObject1, localObject2, localObject3, str, "" });
          y.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { str, localProtocolException.getClass().getSimpleName(), localProtocolException.getMessage() });
          localObject3 = localObject5;
          localObject2 = localObject13;
          localObject1 = arrayOfByte1;
          if (localObject3 == null) {
            continue;
          }
          try
          {
            ((u)localObject3).aRG.disconnect();
            if (localObject1 != null) {
              ((InputStream)localObject1).close();
            }
            if (localObject2 != null) {
              ((ByteArrayOutputStream)localObject2).close();
            }
          }
          catch (Exception localException1)
          {
            Object localObject7;
            byte[] arrayOfByte2;
            byte[] arrayOfByte3;
            Object localObject4;
            int j;
            Object localObject20;
            Object localObject22;
            Object localObject23;
            Object localObject24;
            Object localObject25;
            Object localObject21;
            Object localObject27;
            Object localObject28;
            Object localObject29;
            Object localObject30;
            Object localObject26;
            y.e("MicroMsg.HttpGetAvatar", "exception:%s", new Object[] { bk.j(localException1) });
            y.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", new Object[] { localException1.getMessage() });
            com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 9L, 1L, true);
            continue;
          }
          return true;
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 3L, 1L, true);
          arrayOfByte1 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.ebm.getUsername(), ((u)localObject1).eOw, Integer.valueOf(((u)localObject1).eNz), ((u)localObject1).url.getHost(), str, localObject3 });
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 8L, 1L, true);
          localObject5 = com.tencent.mm.plugin.report.service.h.nFQ;
          localObject9 = localSocketTimeoutException.getMessage();
          localObject10 = this.ebm.getUsername();
          if (localObject8 != null) {
            continue;
          }
          localObject1 = "null";
          if (localObject8 != null) {
            continue;
          }
          localObject2 = "null";
          if (localObject8 != null) {
            continue;
          }
          localObject3 = "null";
          ((com.tencent.mm.plugin.report.service.h)localObject5).f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10002), localObject9, Integer.valueOf(0), localObject10, localObject1, localObject2, localObject3, str, "" });
          y.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { str, localSocketTimeoutException.getClass().getSimpleName(), localSocketTimeoutException.getMessage() });
          localObject1 = localObject7;
          localObject2 = localObject14;
          localObject3 = localObject8;
          continue;
          arrayOfByte2 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 4L, 1L, true);
          arrayOfByte2 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.ebm.getUsername(), ((u)localObject1).eOw, Integer.valueOf(((u)localObject1).eNz), ((u)localObject1).url.getHost(), str, localObject3 });
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 7L, 1L, true);
          localObject5 = com.tencent.mm.plugin.report.service.h.nFQ;
          localObject7 = localIOException.getMessage();
          localObject8 = this.ebm.getUsername();
          if (localObject10 != null) {
            continue;
          }
          localObject1 = "null";
          if (localObject10 != null) {
            continue;
          }
          localObject2 = "null";
          if (localObject10 != null) {
            continue;
          }
          localObject3 = "null";
          ((com.tencent.mm.plugin.report.service.h)localObject5).f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10003), localObject7, Integer.valueOf(0), localObject8, localObject1, localObject2, localObject3, str, "" });
          y.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { str, localIOException.getClass().getSimpleName(), localIOException.getMessage() });
          localObject1 = localObject9;
          localObject2 = localObject15;
          localObject3 = localObject10;
          continue;
          arrayOfByte3 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 5L, 1L, true);
          arrayOfByte3 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.ebm.getUsername(), ((u)localObject1).eOw, Integer.valueOf(((u)localObject1).eNz), ((u)localObject1).url.getHost(), str, localObject3 });
        }
        catch (Exception localException2)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 0L, 1L, true);
          localObject5 = com.tencent.mm.plugin.report.service.h.nFQ;
          localObject7 = localException2.getMessage();
          localObject8 = this.ebm.getUsername();
          if (localObject12 != null) {
            continue;
          }
          Object localObject1 = "null";
          if (localObject12 != null) {
            continue;
          }
          localObject2 = "null";
          if (localObject12 != null) {
            continue;
          }
          localObject3 = "null";
          ((com.tencent.mm.plugin.report.service.h)localObject5).f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(10003), localObject7, Integer.valueOf(0), localObject8, localObject1, localObject2, localObject3, str, "" });
          y.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", new Object[] { str, localException2.getClass().getSimpleName(), localException2.getMessage() });
          localObject1 = localObject11;
          localObject2 = localObject16;
          localObject3 = localObject12;
          continue;
          localObject4 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          i = ((u)localObject1).aRG.getContentLength();
          localObject4 = arrayOfByte4;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject17;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject18;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject19;
          localObject16 = localObject2;
          localObject12 = localObject1;
          localObject3 = ((u)localObject1).getInputStream();
          if (localObject3 != null) {
            continue;
          }
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          y.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", new Object[] { str });
          return true;
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          arrayOfByte4 = new byte[1024];
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          j = ((InputStream)localObject3).read(arrayOfByte4);
          if (j == -1) {
            continue;
          }
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          ((ByteArrayOutputStream)localObject2).write(arrayOfByte4, 0, j);
          continue;
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 41L, 1L, true);
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          if (!com.tencent.mm.sdk.a.b.cqk()) {
            continue;
          }
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          com.tencent.mm.plugin.report.service.h.nFQ.f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(20000), "", Integer.valueOf(i), this.ebm.getUsername(), ((u)localObject1).eOw, Integer.valueOf(((u)localObject1).eNz), ((u)localObject1).url.getHost(), str, "" });
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          this.ebn = ((ByteArrayOutputStream)localObject2).toByteArray();
          localObject4 = localObject3;
          localObject13 = localObject2;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject2;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject2;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject2;
          localObject12 = localObject1;
          ((ByteArrayOutputStream)localObject2).close();
          localObject17 = null;
          localObject18 = null;
          localObject19 = null;
          localObject20 = null;
          arrayOfByte4 = null;
          localObject4 = localObject3;
          localObject13 = arrayOfByte4;
          localObject5 = localObject1;
          localObject7 = localObject3;
          localObject14 = localObject18;
          localObject8 = localObject1;
          localObject9 = localObject3;
          localObject15 = localObject19;
          localObject10 = localObject1;
          localObject11 = localObject3;
          localObject16 = localObject20;
          localObject12 = localObject1;
          ((u)localObject1).aRG.disconnect();
          localObject22 = null;
          localObject23 = null;
          localObject24 = null;
          localObject25 = null;
          localObject21 = null;
          localObject4 = localObject3;
          localObject13 = arrayOfByte4;
          localObject5 = localObject21;
          localObject7 = localObject3;
          localObject14 = localObject18;
          localObject8 = localObject23;
          localObject9 = localObject3;
          localObject15 = localObject19;
          localObject10 = localObject24;
          localObject11 = localObject3;
          localObject16 = localObject20;
          localObject12 = localObject25;
          ((InputStream)localObject3).close();
          localObject27 = null;
          localObject28 = null;
          localObject29 = null;
          localObject30 = null;
          localObject26 = null;
          localObject1 = localObject27;
          localObject2 = localObject17;
          localObject3 = localObject22;
          if (i <= 0) {
            continue;
          }
          localObject4 = localObject26;
          localObject13 = arrayOfByte4;
          localObject5 = localObject21;
          localObject1 = localObject27;
          localObject2 = localObject17;
          localObject3 = localObject22;
          localObject7 = localObject28;
          localObject14 = localObject18;
          localObject8 = localObject23;
          localObject9 = localObject29;
          localObject15 = localObject19;
          localObject10 = localObject24;
          localObject11 = localObject30;
          localObject16 = localObject20;
          localObject12 = localObject25;
          if (this.ebn.length >= i) {
            continue;
          }
          localObject4 = localObject26;
          localObject13 = arrayOfByte4;
          localObject5 = localObject21;
          localObject7 = localObject28;
          localObject14 = localObject18;
          localObject8 = localObject23;
          localObject9 = localObject29;
          localObject15 = localObject19;
          localObject10 = localObject24;
          localObject11 = localObject30;
          localObject16 = localObject20;
          localObject12 = localObject25;
          com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 15L, 1L, true);
          localObject4 = localObject26;
          localObject13 = arrayOfByte4;
          localObject5 = localObject21;
          localObject7 = localObject28;
          localObject14 = localObject18;
          localObject8 = localObject23;
          localObject9 = localObject29;
          localObject15 = localObject19;
          localObject10 = localObject24;
          localObject11 = localObject30;
          localObject16 = localObject20;
          localObject12 = localObject25;
          y.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
          localObject1 = localObject27;
          localObject2 = localObject17;
          localObject3 = localObject22;
          continue;
          localObject1 = ((u)localObject5).eOw;
          continue;
          localObject2 = Integer.valueOf(((u)localObject5).eNz);
          continue;
          localObject3 = ((u)localObject5).url.getHost();
          continue;
          localObject1 = ((u)localObject8).eOw;
          continue;
          localObject2 = Integer.valueOf(((u)localObject8).eNz);
          continue;
          localObject3 = ((u)localObject8).url.getHost();
          continue;
          localObject1 = ((u)localObject10).eOw;
          continue;
          localObject2 = Integer.valueOf(((u)localObject10).eNz);
          continue;
          localObject3 = ((u)localObject10).url.getHost();
          continue;
          localObject1 = localObject12.eOw;
          continue;
          localObject2 = Integer.valueOf(localObject12.eNz);
          continue;
          localObject3 = localObject12.url.getHost();
          continue;
          continue;
        }
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject17;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject18;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject19;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 6L, 1L, true);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject17;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject18;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject19;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.nFQ.f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.ebm.getUsername(), ((u)localObject1).eOw, Integer.valueOf(((u)localObject1).eNz), ((u)localObject1).url.getHost(), str, localObject3 });
        break label3880;
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject17;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject18;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject19;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 2L, 1L, true);
        arrayOfByte1 = arrayOfByte4;
        localObject13 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject17;
        localObject14 = localObject2;
        localObject8 = localObject1;
        localObject9 = localObject18;
        localObject15 = localObject2;
        localObject10 = localObject1;
        localObject11 = localObject19;
        localObject16 = localObject2;
        localObject12 = localObject1;
        com.tencent.mm.plugin.report.service.h.nFQ.f(14058, new Object[] { Integer.valueOf(100001), Integer.valueOf(i), "", Integer.valueOf(0), this.ebm.getUsername(), ((u)localObject1).eOw, Integer.valueOf(((u)localObject1).eNz), ((u)localObject1).url.getHost(), str, localObject3 });
        label3880:
        return true;
        label3882:
        localObject3 = null;
        continue;
        label3888:
        localObject3 = "";
      }
    }
    
    public final boolean JT()
    {
      if ((this.ebm == null) || (bk.bl(this.ebm.getUsername()))) {
        return false;
      }
      if (bk.bE(this.ebn))
      {
        c.this.ebc.remove(this.ebm.getUsername());
        com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 10L, 1L, true);
        return false;
      }
      if (com.tencent.mm.model.am.a.dVz != null) {
        com.tencent.mm.model.am.a.dVz.bg(this.ebn.length, 0);
      }
      c.this.a(new c.d(c.this, this.ebm, this.ebn));
      return false;
    }
  }
  
  private final class b
    implements av.a
  {
    Bitmap ebo = null;
    String username = null;
    
    public b(String paramString)
    {
      this.username = paramString;
    }
    
    public final boolean JS()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      if (bk.bl(this.username)) {
        return false;
      }
      String str1 = this.username;
      boolean bool;
      String str2;
      Object localObject2;
      if (str1 == null)
      {
        bool = false;
        if (bool)
        {
          str2 = (String)c.this.ebi.get(str1);
          if (!bk.bl(str2))
          {
            localObject2 = o.Kh().kp(str1);
            if ((localObject2 == null) || (!str1.equals(((h)localObject2).getUsername())))
            {
              localObject2 = o.Kh();
              String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bk.pl(str2) + "\"";
              localObject2 = ((i)localObject2).dXo.a(str3, null, 2);
              if (localObject2 != null) {
                break label246;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!bk.bl(((h)localObject1).getUsername()))) {
          com.tencent.mm.vfs.e.r(b.jZ(((h)localObject1).getUsername()), b.jZ(str1));
        }
        localObject1 = new h();
        ((h)localObject1).username = str1;
        ((h)localObject1).cCq = 3;
        ((h)localObject1).ebS = str2;
        ((h)localObject1).ebT = str2;
        ((h)localObject1).bcw = 3;
        ((h)localObject1).bK(true);
        ((h)localObject1).bcw = 31;
        o.Kh().a((h)localObject1);
        localObject1 = c.JQ();
        if (localObject1 != null) {
          break label291;
        }
        return false;
        bool = str1.startsWith("ammURL_");
        break;
        label246:
        localObject1 = localContext;
        if (((Cursor)localObject2).moveToFirst())
        {
          ((Cursor)localObject2).moveToFirst();
          localObject1 = new h();
          ((h)localObject1).d((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
      }
      label291:
      if (d.ebt.containsKey(this.username)) {
        i = ((Integer)d.ebt.get(this.username)).intValue();
      }
      if (i != 0)
      {
        o.Kg();
        localContext = o.getContext();
        if (localContext != null) {
          ((d)localObject1).e(this.username, com.tencent.mm.compatible.g.a.decodeResource(localContext.getResources(), i));
        }
      }
      this.ebo = d.kg(this.username);
      return true;
    }
    
    public final boolean JT()
    {
      if (this.ebo == null)
      {
        c localc = c.this;
        String str = this.username;
        y.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
        if (bk.bl(str))
        {
          localObject = null;
          if (localObject != null) {
            break label449;
          }
          localc.ebc.remove(str);
        }
        for (;;)
        {
          return false;
          if ((str.equals(localc.ebh + "@bottle")) && (!bk.a((Boolean)g.DP().Dz().get(60, null), false)))
          {
            localObject = null;
            break;
          }
          if ((str.equals(localc.ebh)) && (!bk.a((Boolean)g.DP().Dz().get(59, null), false)))
          {
            localObject = null;
            break;
          }
          long l = bk.UX();
          c.c localc1 = (c.c)localc.ebd.get(str);
          if ((localc1 != null) && (localc1.ebp >= 5) && (l - localc1.dXA < 600L))
          {
            y.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
            localObject = null;
            break;
          }
          localObject = c.kd(str);
          if (localObject == null)
          {
            y.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
            localObject = new c.c((byte)0);
            ((c.c)localObject).ebp = 5;
            ((c.c)localObject).dXA = l;
            localc.ebd.f(str, localObject);
            localObject = null;
            break;
          }
          if ((localc1 == null) || (l - localc1.dXA > 600L))
          {
            y.d("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
            localc1 = new c.c((byte)0);
            localc1.ebp = 1;
            localc1.dXA = l;
            localc.ebd.f(str, localc1);
          }
          for (;;)
          {
            break;
            if (localc1.ebp < 5)
            {
              y.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(localc1.ebp), Long.valueOf(l - localc1.dXA) });
              localc1.ebp += 1;
              localc1.dXA = l;
              localc.ebd.f(str, localc1);
            }
          }
          label449:
          if (!bk.bl(((h)localObject).JY()))
          {
            localc.a(new c.a(localc, (h)localObject));
          }
          else
          {
            y.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((h)localObject).cCq) });
            if (4 == ((h)localObject).cCq)
            {
              y.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
            }
            else
            {
              localc.ebe.push(localObject);
              if (localc.ebe.size() > 5) {
                localc.ebj.S(0L, 0L);
              } else {
                localc.ebj.S(1000L, 1000L);
              }
            }
          }
        }
      }
      Object localObject = c.JQ();
      if (localObject != null) {
        ((d)localObject).d(this.username, this.ebo);
      }
      c.this.ebc.remove(this.username);
      return false;
    }
  }
  
  private static final class c
  {
    public long dXA = 0L;
    public int ebp = 0;
  }
  
  private final class d
    implements av.a
  {
    Bitmap bitmap = null;
    byte[] buf;
    h ebq = null;
    
    public d(h paramh, byte[] paramArrayOfByte)
    {
      this.ebq = paramh;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean JS()
    {
      boolean bool = true;
      if ((this.ebq == null) || (bk.bl(this.ebq.getUsername())))
      {
        y.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 13L, 1L, true);
        bool = false;
      }
      i locali;
      do
      {
        return bool;
        if (c.JQ() != null)
        {
          this.bitmap = d.g(this.ebq.getUsername(), this.buf);
          if (this.bitmap == null) {
            com.tencent.mm.plugin.report.service.h.nFQ.a(138L, 14L, 1L, true);
          }
        }
        locali = c.JR();
      } while (locali == null);
      this.ebq.bcw = -1;
      this.ebq.JZ();
      locali.a(this.ebq);
      return true;
    }
    
    public final boolean JT()
    {
      if (bk.bl(this.ebq.getUsername())) {
        return false;
      }
      d locald = c.JQ();
      if ((locald != null) && (this.bitmap != null)) {
        locald.d(this.ebq.getUsername(), this.bitmap);
      }
      c.this.ebc.remove(this.ebq.getUsername());
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.c
 * JD-Core Version:    0.7.0.1
 */