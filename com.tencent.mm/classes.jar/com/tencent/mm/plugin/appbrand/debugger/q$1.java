package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.o.k.b;
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

final class q$1
  extends com.tencent.mm.plugin.appbrand.w.a.a
{
  private d fSQ = null;
  
  q$1(q paramq, URI paramURI, com.tencent.mm.plugin.appbrand.w.b.a parama, Map paramMap, k.b paramb)
  {
    super(paramURI, parama, paramMap, 60000);
  }
  
  public final void D(int paramInt, String paramString)
  {
    y.i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((paramInt == -1) || (paramInt == -2) || (paramInt == -3))
    {
      if (!aq.isConnected(ae.getContext()))
      {
        this.fSR.sL("network is down");
        paramInt = 1006;
      }
      for (;;)
      {
        this.fSR.A(paramInt, paramString);
        return;
        this.fSR.sL(paramString);
      }
    }
    this.fSR.A(paramInt, paramString);
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
        y.e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
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
          y.e("MicroMsg.RemoteDebugSocket", localException.getMessage());
          continue;
          if (this.fSQ.aqN() == d.a.hni) {
            try
            {
              sQ(bk.pm(b.w(this.fSQ.aqK())));
            }
            catch (Exception paramd)
            {
              y.e("MicroMsg.RemoteDebugSocket", paramd.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final void b(h paramh)
  {
    y.d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
    this.fSR.a(paramh);
  }
  
  public final void b(Exception paramException)
  {
    y.e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + paramException.toString());
  }
  
  public final void h(ByteBuffer paramByteBuffer)
  {
    this.fSR.g(paramByteBuffer);
  }
  
  public final void sQ(String paramString)
  {
    this.fSS.fSO.wO(paramString);
    y.d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", new Object[] { paramString });
    this.fSR.sM(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q.1
 * JD-Core Version:    0.7.0.1
 */