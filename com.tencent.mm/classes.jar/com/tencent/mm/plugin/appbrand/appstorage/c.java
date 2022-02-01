package com.tencent.mm.plugin.appbrand.appstorage;

import android.util.Base64;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.Key;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "appId", "", "encryptMMKVStorageSecretKey", "multiWrite", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;)V", "encryptMMKVStorageSecretKeyByteArray", "", "kotlin.jvm.PlatformType", "storage", "clear", "", "storageId", "", "clearAll", "decrypt", "raw", "encrypt", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "data", "dataType", "dataSize", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements v
{
  public static final a qLN;
  private static final Map<String, c> qLS;
  private static final Map<String, c> qLT;
  private final l qLO;
  final l qLP;
  private final String qLQ;
  private final byte[] qLR;
  
  static
  {
    AppMethodBeat.i(323154);
    qLN = new a((byte)0);
    qLS = (Map)new LinkedHashMap();
    qLT = (Map)new LinkedHashMap();
    AppMethodBeat.o(323154);
  }
  
  private c(long paramLong, String paramString1, String paramString2, l paraml)
  {
    AppMethodBeat.i(323123);
    this.qLO = paraml;
    this.qLP = new l(paramLong, "AppBrandEncryptMMKVStorage#" + paramString1 + '#');
    this.qLQ = paramString2;
    this.qLR = Base64.decode(paramString2, 0);
    AppMethodBeat.o(323123);
  }
  
  public static final c a(long paramLong, String paramString1, String paramString2, l paraml)
  {
    AppMethodBeat.i(323144);
    paramString1 = a.a(paramLong, paramString1, paramString2, paraml);
    AppMethodBeat.o(323144);
    return paramString1;
  }
  
  private v.a a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(323140);
    s.u(paramString4, "dataType");
    Object localObject1 = this.qLO;
    if (localObject1 != null) {
      ((l)localObject1).a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2);
    }
    localObject1 = (CharSequence)paramString1;
    int i;
    label92:
    Object localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label360;
      }
      localObject1 = (CharSequence)paramString3;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label287;
      }
      i = 1;
      if (i != 0) {
        break label360;
      }
      try
      {
        localObject3 = this.qLR;
        s.s(localObject3, "encryptMMKVStorageSecretKeyByteArray");
        localObject1 = d.UTF_8;
        if (paramString3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(323140);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.AppBrandEncryptMMKVStorage", s.X("[set] encrypt fail: ", localException.getMessage()));
        ((a)e.U(a.class)).ag(1817L, 11L);
        localObject3 = new StringWriter();
        localException.printStackTrace(new PrintWriter((Writer)localObject3));
        ((b)e.U(b.class)).b(24463, new Object[] { paramString1, Integer.valueOf(1), ((StringWriter)localObject3).toString(), this.qLQ, paramString2, paramString3 });
      }
    }
    label287:
    label360:
    for (;;)
    {
      paramString1 = this.qLP.a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2);
      AppMethodBeat.o(323140);
      return paramString1;
      i = 0;
      break;
      i = 0;
      break label92;
      Object localObject2 = paramString3.getBytes(localException);
      s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject3 = new SecretKeySpec((byte[])localObject3, "AES");
      Cipher localCipher = Cipher.getInstance("AES");
      localCipher.init(1, (Key)localObject3);
      localObject2 = Base64.encodeToString(localCipher.doFinal((byte[])localObject2), 0);
      paramString3 = (String)localObject2;
    }
  }
  
  public final int VT(String paramString)
  {
    AppMethodBeat.i(323177);
    s.u(paramString, "appId");
    int i = this.qLP.VT(paramString);
    AppMethodBeat.o(323177);
    return i;
  }
  
  public final void ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(323158);
    l locall = this.qLO;
    if (locall != null) {
      locall.ai(paramInt, paramString);
    }
    this.qLP.ai(paramInt, paramString);
    AppMethodBeat.o(323158);
  }
  
  public final Object[] aj(int paramInt, String paramString)
  {
    AppMethodBeat.i(323166);
    paramString = this.qLP.aj(paramInt, paramString);
    AppMethodBeat.o(323166);
    return paramString;
  }
  
  public final void chU()
  {
    AppMethodBeat.i(323172);
    this.qLP.qMp.count();
    this.qLP.qMp.clearAll();
    String[] arrayOfString = this.qLP.qMp.allKeys();
    if (arrayOfString == null) {}
    for (int i = 0;; i = arrayOfString.length)
    {
      Log.i("MicroMsg.AppBrandEncryptMMKVStorage", "storage after clearAll keySize = [" + i + ']');
      if (i > 0) {
        ((a)e.U(a.class)).ag(1817L, 13L);
      }
      AppMethodBeat.o(323172);
      return;
    }
  }
  
  public final v.a d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(323176);
    s.u(paramString4, "dataType");
    paramString1 = a(paramInt, paramString1, paramString2, paramString3, paramString4, aa.dg(paramString2, paramString3));
    AppMethodBeat.o(323176);
    return paramString1;
  }
  
  public final v.a o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(323161);
    l locall = this.qLO;
    if (locall != null) {
      locall.o(paramInt, paramString1, paramString2);
    }
    paramString1 = this.qLP.o(paramInt, paramString1, paramString2);
    AppMethodBeat.o(323161);
    return paramString1;
  }
  
  public final Object[] p(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(323171);
    Object[] arrayOfObject = this.qLP.p(paramInt, paramString1, paramString2);
    if (((v.a)arrayOfObject[0] != v.a.qNg) || (arrayOfObject.length <= 1))
    {
      AppMethodBeat.o(323171);
      return arrayOfObject;
    }
    str = (String)arrayOfObject[1];
    Object localObject1;
    if (((CharSequence)str).length() > 0)
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localObject1 = (CharSequence)paramString1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label213;
        }
      }
    }
    label213:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {}
      try
      {
        localObject2 = this.qLR;
        s.s(localObject2, "encryptMMKVStorageSecretKeyByteArray");
        localObject1 = Base64.decode(str, 0);
        s.s(localObject1, "decode(value, Base64.DEFAULT)");
        localObject2 = new SecretKeySpec((byte[])localObject2, "AES");
        Cipher localCipher = Cipher.getInstance("AES");
        localCipher.init(2, (Key)localObject2);
        localObject1 = localCipher.doFinal((byte[])localObject1);
        paramString1 = (String)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MicroMsg.AppBrandEncryptMMKVStorage", s.X("[get] decrypt fail: ", localException.getMessage()));
          ((a)e.U(a.class)).ag(1817L, 12L);
          Object localObject2 = new StringWriter();
          localException.printStackTrace(new PrintWriter((Writer)localObject2));
          ((b)e.U(b.class)).b(24463, new Object[] { paramString1, Integer.valueOf(2), ((StringWriter)localObject2).toString(), this.qLQ, paramString2, str });
          paramString1 = null;
        }
      }
      if (paramString1 != null)
      {
        paramString1 = new String(paramString1, d.UTF_8);
        paramString2 = ah.aiuX;
        arrayOfObject[1] = paramString1;
      }
      AppMethodBeat.o(323171);
      return arrayOfObject;
      paramInt = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptMMKVStorage;", "MULTI_WRITE_MODE_CACHE", "TAG", "clearAll", "", "uin", "", "appId", "obtain", "encryptMMKVStorageSecretKey", "multiWrite", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "onAccountRelease", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static c a(long paramLong, String paramString1, String paramString2, l arg4)
    {
      AppMethodBeat.i(323272);
      s.u(paramString1, "appId");
      s.u(paramString2, "encryptMMKVStorageSecretKey");
      String str = paramLong + '-' + paramString1;
      if (??? != null) {
        synchronized (c.chV())
        {
          if (!c.chV().keySet().contains(str)) {
            c.chV().put(str, new c(paramLong, paramString1, paramString2, ???, (byte)0));
          }
          paramString1 = ah.aiuX;
          paramString1 = c.chV().get(str);
          s.checkNotNull(paramString1);
          paramString1 = (c)paramString1;
          AppMethodBeat.o(323272);
          return paramString1;
        }
      }
      synchronized (c.chW())
      {
        if (!c.chW().keySet().contains(str)) {
          c.chW().put(str, new c(paramLong, paramString1, paramString2));
        }
        paramString1 = ah.aiuX;
        paramString1 = c.chW().get(str);
        s.checkNotNull(paramString1);
        paramString1 = (c)paramString1;
        AppMethodBeat.o(323272);
        return paramString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c
 * JD-Core Version:    0.7.0.1
 */