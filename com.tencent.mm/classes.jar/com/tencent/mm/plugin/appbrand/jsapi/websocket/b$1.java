package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

final class b$1
  implements WcWss.a
{
  b$1(b paramb) {}
  
  public final int doCertificateVerify(String paramString, byte[][] paramArrayOfByte)
  {
    AppMethodBeat.i(108103);
    ab.i("MicroMsg.AppBrandWcWssSocket", "certifivate verify for ".concat(String.valueOf(paramString)));
    try
    {
      AndroidCertVerifyResult localAndroidCertVerifyResult2 = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString, 1, b.b(this.igw));
      ab.i("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult2.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByHostMatched()) });
      AndroidCertVerifyResult localAndroidCertVerifyResult1 = localAndroidCertVerifyResult2;
      if (localAndroidCertVerifyResult2.getStatus() != 0)
      {
        localAndroidCertVerifyResult1 = X509Util.verifyServerCertificates(paramArrayOfByte, "ECDSA", paramString, 1, b.b(this.igw));
        ab.i("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult1.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByHostMatched()) });
      }
      if (localAndroidCertVerifyResult1.getStatus() != 0) {
        ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 9L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (localAndroidCertVerifyResult1.isIssuedByKnownRoot()))
      {
        AppMethodBeat.o(108103);
        return 0;
      }
      AppMethodBeat.o(108103);
      return -1;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramString, "doCertificateVerify Exception", new Object[0]);
      AppMethodBeat.o(108103);
    }
    return -1;
  }
  
  public final void onClose(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108102);
    ab.i("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    b.a(this.igw, b.a.igB);
    b.a(this.igw).N(paramInt2, paramString2);
    AppMethodBeat.o(108102);
  }
  
  public final void onHandShake(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(108099);
    ab.i("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = b.a(this.igw, 1, paramArrayOfString1, paramArrayOfString2);
    b.a(this.igw).a((com.tencent.mm.plugin.appbrand.u.e.a)paramString);
    AppMethodBeat.o(108099);
  }
  
  public final void onMessage(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(108101);
    ab.i("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      try
      {
        paramString = new String(paramArrayOfByte, "utf-8");
        b.a(this.igw).CD(paramString);
        AppMethodBeat.o(108101);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", paramString, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
        AppMethodBeat.o(108101);
        return;
      }
    }
    paramString = ByteBuffer.wrap(paramArrayOfByte);
    b.a(this.igw).h(paramString);
    AppMethodBeat.o(108101);
  }
  
  public final void onOpen(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108100);
    ab.i("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (paramBoolean)
    {
      b.a(this.igw, b.a.igz);
      paramString1 = b.a(this.igw, 2, paramArrayOfString1, paramArrayOfString2);
      b.a(this.igw).b((h)paramString1);
      AppMethodBeat.o(108100);
      return;
    }
    b.a(this.igw).AM("onOpen fail code:" + paramInt2 + ", msg:" + paramString2);
    AppMethodBeat.o(108100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b.1
 * JD-Core Version:    0.7.0.1
 */