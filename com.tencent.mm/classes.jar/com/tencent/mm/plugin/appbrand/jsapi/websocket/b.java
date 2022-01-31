package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import javax.net.ssl.X509TrustManager;

public final class b
  implements e
{
  private String hwp;
  private String igm;
  private URI ign;
  private ArrayList igo;
  private ArrayList igp;
  private WssConfig igq;
  private int igr;
  private ArrayList<String> igs;
  private e.a igt;
  private WcWss.a igu;
  private b.a igv;
  private Map<String, String> mHeaders;
  private Timer mTimer;
  private X509TrustManager mTrustManager;
  private String mUrl;
  
  public b(String paramString1, String paramString2, URI paramURI, Map<String, String> paramMap, WssConfig paramWssConfig, ArrayList<String> paramArrayList, a parama)
  {
    AppMethodBeat.i(108107);
    this.igo = new ArrayList();
    this.igp = new ArrayList();
    this.igr = -1;
    this.mTimer = null;
    this.igv = b.a.igx;
    this.igm = paramString1;
    this.mUrl = paramString2;
    this.ign = paramURI;
    this.mHeaders = paramMap;
    this.igq = paramWssConfig;
    this.igs = paramArrayList;
    this.mTrustManager = j.b(parama);
    if (this.mHeaders == null)
    {
      ab.e("MicroMsg.AppBrandWcWssSocket", "header is null");
      AppMethodBeat.o(108107);
      return;
    }
    paramString1 = this.mHeaders.entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (Map.Entry)paramString1.next();
      this.igo.add(paramString2.getKey());
      this.igp.add(paramString2.getValue());
    }
    AppMethodBeat.o(108107);
  }
  
  public final void CY(String paramString)
  {
    this.hwp = paramString;
  }
  
  public final void CZ(String paramString)
  {
    AppMethodBeat.i(108111);
    ab.i("MicroMsg.AppBrandWcWssSocket", "send text");
    if (this.igr < 0)
    {
      this.igt.AM("error socket id");
      AppMethodBeat.o(108111);
      return;
    }
    try
    {
      paramString = ByteBuffer.wrap(paramString.getBytes("UTF8"));
      byte[] arrayOfByte = new byte[paramString.remaining()];
      paramString.get(arrayOfByte);
      WcWss.sendBuffer(this.igm, this.igr, arrayOfByte, true);
      AppMethodBeat.o(108111);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramString, "unsupport encoding UnsupportedEncodingException", new Object[0]);
      this.igt.AM("unsupport encoding");
      AppMethodBeat.o(108111);
    }
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(108108);
    ab.i("MicroMsg.AppBrandWcWssSocket", "setCallBack");
    this.igt = parama;
    this.igu = new b.1(this);
    AppMethodBeat.o(108108);
  }
  
  public final void a(Socket paramSocket) {}
  
  public final void a(Timer paramTimer)
  {
    this.mTimer = paramTimer;
  }
  
  public final String aAR()
  {
    return this.hwp;
  }
  
  public final Timer aGh()
  {
    return this.mTimer;
  }
  
  public final void bj(String paramString, int paramInt)
  {
    AppMethodBeat.i(108110);
    ab.i("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.igr < 0)
    {
      this.igt.AM("error socket id");
      AppMethodBeat.o(108110);
      return;
    }
    if ((this.igv != b.a.igA) && (this.igv != b.a.igB)) {
      this.igv = b.a.igA;
    }
    WcWss.closeSocket(this.igm, this.igr, paramInt, paramString);
    AppMethodBeat.o(108110);
  }
  
  public final void close()
  {
    AppMethodBeat.i(108109);
    ab.i("MicroMsg.AppBrandWcWssSocket", "close");
    bj("default_close", 1000);
    AppMethodBeat.o(108109);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(108113);
    ab.i("MicroMsg.AppBrandWcWssSocket", "connect");
    if (this.mHeaders == null)
    {
      this.igt.AM("header is null");
      AppMethodBeat.o(108113);
      return;
    }
    this.igr = WcWss.a(this.igu, this.igm, this.mUrl, this.igo.toArray(), this.igp.toArray(), this.igq, this.igs.toArray());
    if (this.igr < 0) {
      this.igt.AM("call connect fail code:" + this.igr);
    }
    ab.i("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", new Object[] { Integer.valueOf(this.igr) });
    AppMethodBeat.o(108113);
  }
  
  public final Socket getSocket()
  {
    return null;
  }
  
  public final boolean isOpen()
  {
    return this.igv == b.a.igz;
  }
  
  public final void l(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(108112);
    ab.i("MicroMsg.AppBrandWcWssSocket", "send bytes");
    if (this.igr < 0)
    {
      this.igt.AM("error socket id");
      AppMethodBeat.o(108112);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    WcWss.sendBuffer(this.igm, this.igr, arrayOfByte, false);
    AppMethodBeat.o(108112);
  }
  
  public final void setTcpNoDelay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b
 * JD-Core Version:    0.7.0.1
 */