package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ah.e.h;
import com.tencent.mm.plugin.appbrand.t.i;
import com.tencent.mm.sdk.platformtools.Log;
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
  private Map<String, String> mHeaders;
  private Timer mTimer;
  private X509TrustManager mTrustManager;
  private String mUrl;
  private String ppa;
  private String sKH;
  private URI sKI;
  private ArrayList sKJ;
  private ArrayList sKK;
  private WssConfig sKL;
  private int sKM;
  private ArrayList<String> sKN;
  private e.a sKO;
  private WcWss.a sKP;
  private a sKQ;
  
  public b(String paramString1, String paramString2, URI paramURI, Map<String, String> paramMap, WssConfig paramWssConfig, ArrayList<String> paramArrayList, com.tencent.mm.plugin.appbrand.t.a parama)
  {
    AppMethodBeat.i(144274);
    this.sKJ = new ArrayList();
    this.sKK = new ArrayList();
    this.sKM = -1;
    this.mTimer = null;
    this.sKQ = a.sKS;
    this.sKH = paramString1;
    this.mUrl = paramString2;
    this.sKI = paramURI;
    this.mHeaders = paramMap;
    this.sKL = paramWssConfig;
    this.sKN = paramArrayList;
    this.mTrustManager = i.b(parama);
    if (this.mHeaders == null)
    {
      Log.e("MicroMsg.AppBrandWcWssSocket", "header is null");
      AppMethodBeat.o(144274);
      return;
    }
    paramString1 = this.mHeaders.entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (Map.Entry)paramString1.next();
      this.sKJ.add(paramString2.getKey());
      this.sKK.add(paramString2.getValue());
    }
    AppMethodBeat.o(144274);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(144275);
    Log.i("MicroMsg.AppBrandWcWssSocket", "setCallBack");
    this.sKO = parama;
    this.sKP = new WcWss.a()
    {
      public final int doCertificateVerify(String paramAnonymousString, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(144270);
        Log.i("MicroMsg.AppBrandWcWssSocket", "certifivate verify for ".concat(String.valueOf(paramAnonymousString)));
        try
        {
          AndroidCertVerifyResult localAndroidCertVerifyResult2 = X509Util.verifyServerCertificates(paramAnonymousArrayOfByte, "RSA", paramAnonymousString, 1, b.b(b.this));
          Log.i("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramAnonymousString, Integer.valueOf(localAndroidCertVerifyResult2.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByHostMatched()) });
          AndroidCertVerifyResult localAndroidCertVerifyResult1 = localAndroidCertVerifyResult2;
          if (localAndroidCertVerifyResult2.getStatus() != 0)
          {
            localAndroidCertVerifyResult1 = X509Util.verifyServerCertificates(paramAnonymousArrayOfByte, "ECDSA", paramAnonymousString, 1, b.b(b.this));
            Log.i("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramAnonymousString, Integer.valueOf(localAndroidCertVerifyResult1.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByHostMatched()) });
          }
          if (localAndroidCertVerifyResult1.getStatus() != 0) {
            ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 7L, 1L, false);
          }
          if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
            ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 8L, 1L, false);
          }
          if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
            ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 9L, 1L, false);
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
          Log.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramAnonymousString, "doCertificateVerify Exception", new Object[0]);
          AppMethodBeat.o(144270);
        }
        return -1;
      }
      
      public final void onClose(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(144269);
        Log.i("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1), paramAnonymousString2, Integer.valueOf(paramAnonymousInt2) });
        b.a(b.this, b.a.sKW);
        b.a(b.this).ap(paramAnonymousInt2, paramAnonymousString2);
        AppMethodBeat.o(144269);
      }
      
      public final void onHandShake(String paramAnonymousString, int paramAnonymousInt, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2)
      {
        AppMethodBeat.i(144266);
        Log.i("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        paramAnonymousString = b.a(b.this, 1, paramAnonymousArrayOfString1, paramAnonymousArrayOfString2);
        b.a(b.this).a((com.tencent.mm.plugin.appbrand.ah.e.a)paramAnonymousString);
        AppMethodBeat.o(144266);
      }
      
      public final void onMessage(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(144268);
        Log.d("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          try
          {
            paramAnonymousString = new String(paramAnonymousArrayOfByte, "utf-8");
            b.a(b.this).abg(paramAnonymousString);
            AppMethodBeat.o(144268);
            return;
          }
          catch (UnsupportedEncodingException paramAnonymousString)
          {
            Log.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramAnonymousString, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
            AppMethodBeat.o(144268);
            return;
          }
        }
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousArrayOfByte);
        b.a(b.this).n(paramAnonymousString);
        AppMethodBeat.o(144268);
      }
      
      public final void onOpen(String paramAnonymousString1, int paramAnonymousInt1, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, int paramAnonymousInt2, String paramAnonymousString2, String[] paramAnonymousArrayOfString3, String[] paramAnonymousArrayOfString4)
      {
        AppMethodBeat.i(325801);
        Log.i("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", new Object[] { paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousBoolean)
        {
          b.a(b.this, b.a.sKU);
          paramAnonymousString1 = b.a(b.this, 2, paramAnonymousArrayOfString1, paramAnonymousArrayOfString2);
          paramAnonymousArrayOfString1 = b.b(paramAnonymousArrayOfString3, paramAnonymousArrayOfString4);
          b.a(b.this).a((h)paramAnonymousString1, paramAnonymousArrayOfString1);
          AppMethodBeat.o(325801);
          return;
        }
        b.a(b.this).Yf("onOpen fail code:" + paramAnonymousInt2 + ", msg:" + paramAnonymousString2);
        AppMethodBeat.o(325801);
      }
    };
    AppMethodBeat.o(144275);
  }
  
  public final void a(Timer paramTimer)
  {
    this.mTimer = paramTimer;
  }
  
  public final void acu(String paramString)
  {
    this.ppa = paramString;
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(144278);
    Log.i("MicroMsg.AppBrandWcWssSocket", "send text");
    if (this.sKM < 0)
    {
      this.sKO.Yf("error socket id");
      AppMethodBeat.o(144278);
      return;
    }
    try
    {
      paramString = ByteBuffer.wrap(paramString.getBytes("UTF8"));
      byte[] arrayOfByte = new byte[paramString.remaining()];
      paramString.get(arrayOfByte);
      WcWss.sendBuffer(this.sKH, this.sKM, arrayOfByte, true);
      AppMethodBeat.o(144278);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramString, "unsupport encoding UnsupportedEncodingException", new Object[0]);
      this.sKO.Yf("unsupport encoding");
      AppMethodBeat.o(144278);
    }
  }
  
  public final void b(Socket paramSocket) {}
  
  public final String bQs()
  {
    return this.ppa;
  }
  
  public final void cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(144277);
    Log.i("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.sKM < 0)
    {
      this.sKO.Yf("error socket id");
      AppMethodBeat.o(144277);
      return;
    }
    if ((this.sKQ != a.sKV) && (this.sKQ != a.sKW)) {
      this.sKQ = a.sKV;
    }
    WcWss.closeSocket(this.sKH, this.sKM, paramInt, paramString);
    AppMethodBeat.o(144277);
  }
  
  public final void close()
  {
    AppMethodBeat.i(144276);
    Log.i("MicroMsg.AppBrandWcWssSocket", "close");
    cN("default_close", 1000);
    AppMethodBeat.o(144276);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(144280);
    Log.i("MicroMsg.AppBrandWcWssSocket", "connect");
    if (this.mHeaders == null)
    {
      this.sKO.Yf("header is null");
      AppMethodBeat.o(144280);
      return;
    }
    this.sKM = WcWss.a(this.sKP, this.sKH, this.mUrl, this.sKJ.toArray(), this.sKK.toArray(), this.sKL, this.sKN.toArray());
    if (this.sKM < 0) {
      this.sKO.Yf("call connect fail code:" + this.sKM);
    }
    Log.i("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", new Object[] { Integer.valueOf(this.sKM) });
    AppMethodBeat.o(144280);
  }
  
  public final Socket cxA()
  {
    return null;
  }
  
  public final Timer cxz()
  {
    return this.mTimer;
  }
  
  public final boolean isOpen()
  {
    return this.sKQ == a.sKU;
  }
  
  public final void r(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144279);
    Log.i("MicroMsg.AppBrandWcWssSocket", "send bytes");
    if (this.sKM < 0)
    {
      this.sKO.Yf("error socket id");
      AppMethodBeat.o(144279);
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    WcWss.sendBuffer(this.sKH, this.sKM, arrayOfByte, false);
    AppMethodBeat.o(144279);
  }
  
  public final void setTcpNoDelay(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(144273);
      sKS = new a("NOT_YET_CONNECTED", 0);
      sKT = new a("CONNECTING", 1);
      sKU = new a("OPEN", 2);
      sKV = new a("CLOSING", 3);
      sKW = new a("CLOSED", 4);
      sKX = new a[] { sKS, sKT, sKU, sKV, sKW };
      AppMethodBeat.o(144273);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b
 * JD-Core Version:    0.7.0.1
 */