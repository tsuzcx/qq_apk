package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.c;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e.a;
import com.tencent.mm.plugin.appbrand.u.d.d;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.plugin.appbrand.u.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

final class k$1
  extends c
{
  private d hmq = null;
  
  k$1(k paramk, URI paramURI, com.tencent.mm.plugin.appbrand.u.b.a parama, Map paramMap, int paramInt, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a parama1)
  {
    super(paramURI, parama, paramMap, paramInt);
  }
  
  public final void AR(String paramString)
  {
    AppMethodBeat.i(108216);
    String str = this.val$url;
    if (paramString != null) {}
    for (int i = paramString.length();; i = -1)
    {
      ab.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d, taskId=%s", new Object[] { str, Integer.valueOf(i), this.hwk });
      this.igj.CD(paramString);
      AppMethodBeat.o(108216);
      return;
    }
  }
  
  public final void P(int paramInt, String paramString)
  {
    AppMethodBeat.i(108217);
    ab.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d, taskId=%s", new Object[] { this.val$url, paramString, Integer.valueOf(paramInt), this.hwk });
    k.g(this);
    k.a(this.itl, this);
    if ((paramInt == -1) || (paramInt == -2) || (paramInt == -3))
    {
      com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a locala;
      String str;
      if (!at.isConnected(ah.getContext()))
      {
        locala = this.igj;
        str = "network is down";
      }
      for (;;)
      {
        locala.AM(str);
        this.igj.N(1006, paramString);
        AppMethodBeat.o(108217);
        return;
        locala = this.igj;
        if (bo.isNullOrNil(paramString)) {
          str = "abnormal closure";
        } else {
          str = paramString;
        }
      }
    }
    this.igj.N(paramInt, paramString);
    AppMethodBeat.o(108217);
  }
  
  public final void a(e.a parama) {}
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(108220);
    if ((paramd.aOo() != com.tencent.mm.plugin.appbrand.u.d.d.a.iZF) && (!paramd.aOm()))
    {
      this.hmq = paramd;
      AppMethodBeat.o(108220);
      return;
    }
    if (paramd.aOo() == com.tencent.mm.plugin.appbrand.u.d.d.a.iZF)
    {
      if (this.hmq == null)
      {
        AppMethodBeat.o(108220);
        return;
      }
      if (this.hmq.aOl().position() > 10485760)
      {
        ab.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
        this.hmq = null;
        AppMethodBeat.o(108220);
        return;
      }
      try
      {
        this.hmq.e(paramd);
        if (!paramd.aOm())
        {
          AppMethodBeat.o(108220);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: Framedata append fail", new Object[0]);
        }
      }
      if (this.hmq.aOo() != com.tencent.mm.plugin.appbrand.u.d.d.a.iZH) {
        break label177;
      }
      i(this.hmq.aOl());
    }
    for (;;)
    {
      this.hmq = null;
      AppMethodBeat.o(108220);
      return;
      label177:
      if (this.hmq.aOo() == com.tencent.mm.plugin.appbrand.u.d.d.a.iZG) {
        try
        {
          AR(bo.nullAsNil(b.x(this.hmq.aOl())));
        }
        catch (Exception paramd)
        {
          ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramd, "Exception: stringUtf8 error", new Object[0]);
        }
      }
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(108214);
    ab.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened, taskId=%s", new Object[] { this.val$url, this.hwk });
    k.g(this);
    this.igj.b(paramh);
    AppMethodBeat.o(108214);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.u.e.a parama)
  {
    AppMethodBeat.i(108215);
    this.igj.a(parama);
    AppMethodBeat.o(108215);
  }
  
  public final void i(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(108219);
    String str = this.val$url;
    if (paramByteBuffer != null) {}
    for (int i = paramByteBuffer.capacity();; i = -1)
    {
      ab.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d, taskId=%s", new Object[] { str, Integer.valueOf(i), this.hwk });
      this.igj.h(paramByteBuffer);
      AppMethodBeat.o(108219);
      return;
    }
  }
  
  public final void onError(Exception paramException)
  {
    AppMethodBeat.i(108218);
    ab.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramException, "onError Exception: url %s, taskId=%s", new Object[] { this.val$url, this.hwk });
    k.g(this);
    k.a(this.itl, this);
    this.igj.AM("exception " + paramException.getMessage());
    AppMethodBeat.o(108218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.k.1
 * JD-Core Version:    0.7.0.1
 */