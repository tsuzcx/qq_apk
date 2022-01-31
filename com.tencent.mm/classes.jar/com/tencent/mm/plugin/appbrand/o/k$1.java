package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.plugin.appbrand.w.d.d;
import com.tencent.mm.plugin.appbrand.w.d.d.a;
import com.tencent.mm.plugin.appbrand.w.e.h;
import com.tencent.mm.plugin.appbrand.w.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

final class k$1
  extends com.tencent.mm.plugin.appbrand.w.a.a
{
  private d fSQ = null;
  
  k$1(k paramk, URI paramURI, com.tencent.mm.plugin.appbrand.w.b.a parama, Map paramMap, int paramInt, String paramString, k.b paramb)
  {
    super(paramURI, parama, paramMap, paramInt);
  }
  
  public final void D(int paramInt, String paramString)
  {
    y.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d", new Object[] { this.val$url, paramString, Integer.valueOf(paramInt) });
    k.d(this);
    k.b localb;
    String str;
    if ((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) {
      if (!aq.isConnected(ae.getContext()))
      {
        localb = this.gRy;
        str = "network is down";
        localb.sL(str);
        this.gRy.A(1006, paramString);
      }
    }
    for (;;)
    {
      this.gRz.b(this);
      return;
      localb = this.gRy;
      if (bk.bl(paramString))
      {
        str = "abnormal closure";
        break;
      }
      str = paramString;
      break;
      this.gRy.A(paramInt, paramString);
    }
  }
  
  public final void a(d paramd)
  {
    if ((paramd.aqN() != d.a.hnh) && (!paramd.aqL())) {
      this.fSQ = paramd;
    }
    for (;;)
    {
      return;
      if ((paramd.aqN() != d.a.hnh) || (this.fSQ == null)) {
        continue;
      }
      if (this.fSQ.aqK().position() > 10485760)
      {
        y.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
        this.fSQ = null;
        return;
      }
      try
      {
        this.fSQ.e(paramd);
        if (!paramd.aqL()) {
          continue;
        }
        if (this.fSQ.aqN() == d.a.hnj)
        {
          h(this.fSQ.aqK());
          this.fSQ = null;
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandNetworkWebSocket", localException.getMessage());
          continue;
          if (this.fSQ.aqN() == d.a.hni) {
            try
            {
              sQ(bk.pm(b.w(this.fSQ.aqK())));
            }
            catch (Exception paramd)
            {
              y.e("MicroMsg.AppBrandNetworkWebSocket", paramd.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.w.e.a parama)
  {
    this.gRy.a(parama);
  }
  
  public final void b(h paramh)
  {
    y.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened", new Object[] { this.val$url });
    k.d(this);
    this.gRy.a(paramh);
  }
  
  public final void b(Exception paramException)
  {
    y.e("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,error is %s", new Object[] { this.val$url, paramException.toString() });
    this.gRy.sL("exception " + paramException.getMessage());
    this.gRz.b(this);
  }
  
  public final void h(ByteBuffer paramByteBuffer)
  {
    String str = this.val$url;
    if (paramByteBuffer != null) {}
    for (int i = paramByteBuffer.capacity();; i = -1)
    {
      y.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d", new Object[] { str, Integer.valueOf(i) });
      this.gRy.g(paramByteBuffer);
      return;
    }
  }
  
  public final void sQ(String paramString)
  {
    String str = this.val$url;
    if (paramString != null) {}
    for (int i = paramString.length();; i = -1)
    {
      y.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d", new Object[] { str, Integer.valueOf(i) });
      this.gRy.sM(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.k.1
 * JD-Core Version:    0.7.0.1
 */