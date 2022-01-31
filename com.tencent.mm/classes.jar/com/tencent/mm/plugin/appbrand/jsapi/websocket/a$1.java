package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

final class a$1
  implements e.a
{
  a$1(a parama, String paramString1, e parame, d.a parama1, String paramString2) {}
  
  public final void AM(String paramString)
  {
    AppMethodBeat.i(108081);
    ab.e("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketError url is %s ,error is %s,taskId=%s", new Object[] { this.val$url, paramString, this.hwk });
    a.f(this.igi);
    a.a(this.igk, this.igi);
    this.igj.AM("exception ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(108081);
  }
  
  public final void CD(String paramString)
  {
    AppMethodBeat.i(108082);
    ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s ,socket onmessage length :%d,taskId=%s", new Object[] { this.val$url, Integer.valueOf(paramString.length()), this.hwk });
    this.igj.CD(paramString);
    AppMethodBeat.o(108082);
  }
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(108084);
    ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketClose url is %s ,state: closed ,reason: %s, errCode = %d,taskId=%s", new Object[] { this.val$url, paramString, Integer.valueOf(paramInt), this.hwk });
    a.f(this.igi);
    a.a(this.igk, this.igi);
    if (paramInt == -1)
    {
      d.a locala;
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
        AppMethodBeat.o(108084);
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
    AppMethodBeat.o(108084);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.u.e.a parama)
  {
    AppMethodBeat.i(108080);
    ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "onWebsocketHandshakeSentAsClient");
    this.igj.a(parama);
    AppMethodBeat.o(108080);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(108079);
    ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketOpen taskId=%s", new Object[] { this.hwk });
    a.f(this.igi);
    this.igj.b(paramh);
    AppMethodBeat.o(108079);
  }
  
  public final void h(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(108083);
    String str = this.val$url;
    if (paramByteBuffer != null) {}
    for (int i = paramByteBuffer.capacity();; i = -1)
    {
      ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s , socket onMessage buffer length : %d,taskId=%s", new Object[] { str, Integer.valueOf(i), this.hwk });
      this.igj.h(paramByteBuffer);
      AppMethodBeat.o(108083);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.a.1
 * JD-Core Version:    0.7.0.1
 */