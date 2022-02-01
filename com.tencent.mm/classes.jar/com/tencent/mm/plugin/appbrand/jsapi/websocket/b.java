package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.e.h;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.sdk.platformtools.ad;
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
  private String iFB;
  private String luI;
  private URI luJ;
  private ArrayList luK;
  private ArrayList luL;
  private WssConfig luM;
  private int luN;
  private ArrayList<String> luO;
  private e.a luP;
  private WcWss.a luQ;
  private a luR;
  private Map<String, String> mHeaders;
  private Timer mTimer;
  private X509TrustManager mTrustManager;
  private String mUrl;
  
  public b(String paramString1, String paramString2, URI paramURI, Map<String, String> paramMap, WssConfig paramWssConfig, ArrayList<String> paramArrayList, com.tencent.mm.plugin.appbrand.o.a parama)
  {
    AppMethodBeat.i(144274);
    this.luK = new ArrayList();
    this.luL = new ArrayList();
    this.luN = -1;
    this.mTimer = null;
    this.luR = a.luT;
    this.luI = paramString1;
    this.mUrl = paramString2;
    this.luJ = paramURI;
    this.mHeaders = paramMap;
    this.luM = paramWssConfig;
    this.luO = paramArrayList;
    this.mTrustManager = j.b(parama);
    if (this.mHeaders == null)
    {
      ad.e("MicroMsg.AppBrandWcWssSocket", "header is null");
      AppMethodBeat.o(144274);
      return;
    }
    paramString1 = this.mHeaders.entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (Map.Entry)paramString1.next();
      this.luK.add(paramString2.getKey());
      this.luL.add(paramString2.getValue());
    }
    AppMethodBeat.o(144274);
  }
  
  public final void Rl(String paramString)
  {
    this.iFB = paramString;
  }
  
  public final void Rm(String paramString)
  {
    AppMethodBeat.i(144278);
    ad.i("MicroMsg.AppBrandWcWssSocket", "send text");
    if (this.luN < 0)
    {
      this.luP.Ob("error socket id");
      AppMethodBeat.o(144278);
      return;
    }
    try
    {
      paramString = ByteBuffer.wrap(paramString.getBytes("UTF8"));
      byte[] arrayOfByte = new byte[paramString.remaining()];
      paramString.get(arrayOfByte);
      WcWss.sendBuffer(this.luI, this.luN, arrayOfByte, true);
      AppMethodBeat.o(144278);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramString, "unsupport encoding UnsupportedEncodingException", new Object[0]);
      this.luP.Ob("unsupport encoding");
      AppMethodBeat.o(144278);
    }
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(144275);
    ad.i("MicroMsg.AppBrandWcWssSocket", "setCallBack");
    this.luP = parama;
    this.luQ = new WcWss.a()
    {
      public final int doCertificateVerify(String paramAnonymousString, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(144270);
        ad.i("MicroMsg.AppBrandWcWssSocket", "certifivate verify for ".concat(String.valueOf(paramAnonymousString)));
        try
        {
          AndroidCertVerifyResult localAndroidCertVerifyResult2 = X509Util.verifyServerCertificates(paramAnonymousArrayOfByte, "RSA", paramAnonymousString, 1, b.b(b.this));
          ad.i("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramAnonymousString, Integer.valueOf(localAndroidCertVerifyResult2.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByHostMatched()) });
          AndroidCertVerifyResult localAndroidCertVerifyResult1 = localAndroidCertVerifyResult2;
          if (localAndroidCertVerifyResult2.getStatus() != 0)
          {
            localAndroidCertVerifyResult1 = X509Util.verifyServerCertificates(paramAnonymousArrayOfByte, "ECDSA", paramAnonymousString, 1, b.b(b.this));
            ad.i("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramAnonymousString, Integer.valueOf(localAndroidCertVerifyResult1.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByHostMatched()) });
          }
          if (localAndroidCertVerifyResult1.getStatus() != 0) {
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 7L, 1L, false);
          }
          if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 8L, 1L, false);
          }
          if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 9L, 1L, false);
          }
          if ((localAndroidCertVerifyResult1.getStatus() == 0) && (localAndroidCertVerifyResult1.isIssuedByKnownRoot()))
          {
            AppMethodBeat.o(144270);
            return 0;
          }
          AppMethodBeat.o(144270);
          return -1;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramAnonymousString, "doCertificateVerify Exception", new Object[0]);
          AppMethodBeat.o(144270);
        }
        return -1;
      }
      
      public final void onClose(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(144269);
        ad.i("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1), paramAnonymousString2, Integer.valueOf(paramAnonymousInt2) });
        b.a(b.this, b.a.luX);
        b.a(b.this).aa(paramAnonymousInt2, paramAnonymousString2);
        AppMethodBeat.o(144269);
      }
      
      public final void onHandShake(String paramAnonymousString, int paramAnonymousInt, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2)
      {
        AppMethodBeat.i(144266);
        ad.i("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        paramAnonymousString = b.a(b.this, 1, paramAnonymousArrayOfString1, paramAnonymousArrayOfString2);
        b.a(b.this).a((com.tencent.mm.plugin.appbrand.aa.e.a)paramAnonymousString);
        AppMethodBeat.o(144266);
      }
      
      public final void onMessage(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(144268);
        ad.d("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          try
          {
            paramAnonymousString = new String(paramAnonymousArrayOfByte, "utf-8");
            b.a(b.this).Qh(paramAnonymousString);
            AppMethodBeat.o(144268);
            return;
          }
          catch (UnsupportedEncodingException paramAnonymousString)
          {
            ad.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramAnonymousString, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
            AppMethodBeat.o(144268);
            return;
          }
        }
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousArrayOfByte);
        b.a(b.this).k(paramAnonymousString);
        AppMethodBeat.o(144268);
      }
      
      public final void onOpen(String paramAnonymousString1, int paramAnonymousInt1, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, int paramAnonymousInt2, String paramAnonymousString2, long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, long paramAnonymousLong4, long paramAnonymousLong5, long paramAnonymousLong6, long paramAnonymousLong7, long paramAnonymousLong8)
      {
        AppMethodBeat.i(175387);
        ad.i("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s, fetchStart:%d, domainLookupStart:%d, domainLookupEnd:%d, connectStart:%d, connectEnd:%d, rtt:%d, handshakeCost:%d, cost:%d", new Object[] { paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong3), Long.valueOf(paramAnonymousLong4), Long.valueOf(paramAnonymousLong5), Long.valueOf(paramAnonymousLong6), Long.valueOf(paramAnonymousLong7), Long.valueOf(paramAnonymousLong8) });
        if (paramAnonymousBoolean)
        {
          b.a(b.this, b.a.luV);
          paramAnonymousString1 = b.a(b.this, 2, paramAnonymousArrayOfString1, paramAnonymousArrayOfString2);
          paramAnonymousArrayOfString1 = b.a(new String[] { "fetchStart", "domainLookupStart", "domainLookupEnd", "connectStart", "connectEnd", "rtt", "handshakeCost", "cost" }, new long[] { paramAnonymousLong1, paramAnonymousLong2, paramAnonymousLong3, paramAnonymousLong4, paramAnonymousLong5, paramAnonymousLong6, paramAnonymousLong7, paramAnonymousLong8 });
          b.a(b.this).a((h)paramAnonymousString1, paramAnonymousArrayOfString1);
          AppMethodBeat.o(175387);
          return;
        }
        b.a(b.this).Ob("onOpen fail code:" + paramAnonymousInt2 + ", msg:" + paramAnonymousString2);
        AppMethodBeat.o(175387);
      }
    };
    AppMethodBeat.o(144275);
  }
  
  public final void a(Socket paramSocket) {}
  
  public final void a(Timer paramTimer)
  {
    this.mTimer = paramTimer;
  }
  
  public final String aOC()
  {
    return this.iFB;
  }
  
  public final void bI(String paramString, int paramInt)
  {
    AppMethodBeat.i(144277);
    ad.i("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.luN < 0)
    {
      this.luP.Ob("error socket id");
      AppMethodBeat.o(144277);
      return;
    }
    if ((this.luR != a.luW) && (this.luR != a.luX)) {
      this.luR = a.luW;
    }
    WcWss.closeSocket(this.luI, this.luN, paramInt, paramString);
    AppMethodBeat.o(144277);
  }
  
  public final Timer boX()
  {
    return this.mTimer;
  }
  
  public final void close()
  {
    AppMethodBeat.i(144276);
    ad.i("MicroMsg.AppBrandWcWssSocket", "close");
    bI("default_close", 1000);
    AppMethodBeat.o(144276);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(144280);
    ad.i("MicroMsg.AppBrandWcWssSocket", "connect");
    if (this.mHeaders == null)
    {
      this.luP.Ob("header is null");
      AppMethodBeat.o(144280);
      return;
    }
    this.luN = WcWss.a(this.luQ, this.luI, this.mUrl, this.luK.toArray(), this.luL.toArray(), this.luM, this.luO.toArray());
    if (this.luN < 0) {
      this.luP.Ob("call connect fail code:" + this.luN);
    }
    ad.i("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", new Object[] { Integer.valueOf(this.luN) });
    AppMethodBeat.o(144280);
  }
  
  public final Socket getSocket()
  {
    return null;
  }
  
  public final boolean isOpen()
  {
    return this.luR == a.luV;
  }
  
  public final void o(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144279);
    ad.i("MicroMsg.AppBrandWcWssSocket", "send bytes");
    if (this.luN < 0)
    {
      this.luP.Ob("error socket id");
      AppMethodBeat.o(144279);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    WcWss.sendBuffer(this.luI, this.luN, arrayOfByte, false);
    AppMethodBeat.o(144279);
  }
  
  public final void setTcpNoDelay(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(144273);
      luT = new a("NOT_YET_CONNECTED", 0);
      luU = new a("CONNECTING", 1);
      luV = new a("OPEN", 2);
      luW = new a("CLOSING", 3);
      luX = new a("CLOSED", 4);
      luY = new a[] { luT, luU, luV, luW, luX };
      AppMethodBeat.o(144273);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b
 * JD-Core Version:    0.7.0.1
 */