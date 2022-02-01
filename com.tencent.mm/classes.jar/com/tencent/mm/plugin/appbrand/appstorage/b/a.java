package com.tencent.mm.plugin.appbrand.appstorage.b;

import android.util.Base64;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/security/AppBrandEncryptKVStorageSecretKeyManager;", "", "()V", "TAG", "", "HexString2Bytes", "", "src", "getSecretKey", "appId", "uniteBytes", "", "src0", "src1", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a qOf;
  
  static
  {
    AppMethodBeat.i(323222);
    qOf = new a();
    AppMethodBeat.o(323222);
  }
  
  public static String WF(String paramString)
  {
    AppMethodBeat.i(323214);
    s.u(paramString, "appId");
    Assert.assertTrue(MMApplicationContext.isMainProcess());
    Object localObject = ((com.tencent.luggage.sdk.customize.a)e.T(com.tencent.luggage.sdk.customize.a.class)).aqT();
    if (localObject == null)
    {
      AppMethodBeat.o(323214);
      return "";
    }
    localObject = ((b)localObject).WH(paramString);
    paramString = new StringBuilder().append(paramString);
    h.baC();
    paramString = com.tencent.mm.kernel.b.getUin() + (String)localObject;
    localObject = d.UTF_8;
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(323214);
      throw paramString;
    }
    paramString = paramString.getBytes((Charset)localObject);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    try
    {
      localObject = MessageDigest.getInstance("SHA-256");
      ((MessageDigest)localObject).update(paramString);
      paramString = Base64.encodeToString(((MessageDigest)localObject).digest(), 0);
      localObject = (CharSequence)paramString;
      if ((localObject == null) || (n.bp((CharSequence)localObject)))
      {
        i = 1;
        if (i != 0)
        {
          Log.i("MicroMsg.SecretMMKVStorage.AppBrandStorageSecretKeyManager", "gen secret key fail, use default instead");
          paramString = Base64.encodeToString(WG("1d3ac09f244e11bc134df5ec87f44e41fcc820ec2238244b8d183fa1cd7a6743"), 0);
        }
        s.s(paramString, "try {\n            val md…t\n            }\n        }");
        AppMethodBeat.o(323214);
        return paramString;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        paramString = "";
        continue;
        int i = 0;
      }
    }
  }
  
  private static byte[] WG(String paramString)
  {
    AppMethodBeat.i(323220);
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k / 2];
    paramString = paramString.getBytes(d.UTF_8);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    int n = k / 2;
    if (n > 0) {}
    int m;
    for (k = 0;; k = m)
    {
      m = k + 1;
      int i = paramString[(k * 2)];
      int j = paramString[(k * 2 + 1)];
      Charset localCharset = d.UTF_8;
      int i1 = (char)((char)Byte.decode(s.X("0x", new String(new byte[] { i }, localCharset))).byteValue() << '\004');
      localCharset = d.UTF_8;
      arrayOfByte[k] = ((byte)(i1 ^ (char)Byte.decode(s.X("0x", new String(new byte[] { j }, localCharset))).byteValue()));
      if (m >= n)
      {
        AppMethodBeat.o(323220);
        return arrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.a
 * JD-Core Version:    0.7.0.1
 */