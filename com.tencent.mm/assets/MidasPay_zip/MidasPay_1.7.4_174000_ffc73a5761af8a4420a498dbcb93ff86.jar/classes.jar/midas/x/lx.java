package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.HashMap;

public class lx
{
  private final HashMap<String, String> a = new HashMap();
  private final HashMap<String, String> b = new HashMap();
  private final HashMap<String, String> c = new HashMap();
  
  private String a()
  {
    String str1 = "caUdsBbJ1oOxMbPy".substring(0, 4);
    String str2 = "caUdsBbJ1oOxMbPy".substring(4, 8);
    String str3 = "caUdsBbJ1oOxMbPy".substring(8, 12);
    String str4 = "caUdsBbJ1oOxMbPy".substring(12, 16);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    localStringBuilder.append(str4);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +13 -> 17
    //   7: ldc 2
    //   9: monitorexit
    //   10: ldc 45
    //   12: areturn
    //   13: astore_0
    //   14: goto +49 -> 63
    //   17: aload_1
    //   18: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +9 -> 30
    //   24: ldc 2
    //   26: monitorexit
    //   27: ldc 45
    //   29: areturn
    //   30: aload_2
    //   31: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +9 -> 43
    //   37: ldc 2
    //   39: monitorexit
    //   40: ldc 45
    //   42: areturn
    //   43: aload_0
    //   44: aload_1
    //   45: iconst_4
    //   46: invokevirtual 57	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   49: aload_2
    //   50: ldc 45
    //   52: invokeinterface 63 3 0
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: areturn
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	Context
    //   0	68	1	paramString1	String
    //   0	68	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   17	24	13	finally
    //   30	37	13	finally
    //   43	58	13	finally
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {
        return;
      }
      bool = TextUtils.isEmpty(paramString2);
      if (bool) {
        return;
      }
      paramContext = paramContext.getSharedPreferences(paramString1, 4).edit();
      paramContext.remove(paramString2);
      paramContext.commit();
      return;
    }
    finally {}
  }
  
  private static void h(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {
        return;
      }
      bool = TextUtils.isEmpty(paramString2);
      if (bool) {
        return;
      }
      bool = TextUtils.isEmpty(paramString3);
      if (bool) {
        return;
      }
      paramContext = paramContext.getSharedPreferences(paramString1, 4).edit();
      paramContext.putString(paramString2, paramString3);
      paramContext.commit();
      return;
    }
    finally {}
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramString2 = (String)this.a.get(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return paramString1;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    String str1 = c(paramContext, paramString1, paramString2, paramString3);
    String str2 = d(paramContext, paramString1, paramString2, paramString3);
    paramContext = e(paramContext, paramString1, paramString2, paramString3);
    if (((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) || (!TextUtils.isEmpty(paramContext)))
    {
      a(paramString1, paramString2, str1);
      b(paramString1, paramString2, str2);
      c(paramString1, paramString2, paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString4)) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    paramString3 = ly.a(paramString3, a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString4);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_SecretEncodeKey");
    h(paramContext, "TencentUnipay", localStringBuilder.toString(), paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    this.a.put(paramString1, paramString3);
  }
  
  public String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramString2 = (String)this.b.get(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    return paramString1;
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString4)) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    Object localObject = a(paramString1, paramString2);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    paramString3 = ly.a(paramString3, (String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_CryptEncodeKey");
    h(paramContext, "TencentUnipay", ((StringBuilder)localObject).toString(), paramString3);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    this.b.put(paramString1, paramString3);
  }
  
  public boolean b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ks.a("HTTP-KeyManager", "Cannot check need change key with empty offer id!");
      return false;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      ks.a("HTTP-KeyManager", "Cannot check need change key with empty open id!");
      return false;
    }
    if (paramContext == null)
    {
      ks.a("HTTP-KeyManager", "Cannot check need change key with null context!");
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      ks.a("HTTP-KeyManager", "Cannot check need change key with empty sdk version!");
      return false;
    }
    Object localObject = a(paramString1, paramString2);
    String str1 = b(paramString1, paramString2);
    String str2 = c(paramString1, paramString2);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("At least 1 key empty in ram for openid = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", offer id = ");
      ((StringBuilder)localObject).append(paramString2);
      ks.b("HTTP-KeyManager", ((StringBuilder)localObject).toString());
      localObject = c(paramContext, paramString1, paramString2, paramString3);
      str1 = d(paramContext, paramString1, paramString2, paramString3);
      str2 = e(paramContext, paramString1, paramString2, paramString3);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramContext = new StringBuilder();
        paramContext.append("At least 1 key empty in ram for openid = ");
        paramContext.append(paramString1);
        paramContext.append(", offer id = ");
        paramContext.append(paramString2);
        paramContext.append("! But all 3 key in disk is not empty! No need to change key!");
        ks.b("HTTP-KeyManager", paramContext.toString());
        a(paramString1, paramString2, (String)localObject);
        b(paramString1, paramString2, str1);
        c(paramString1, paramString2, str2);
      }
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append("All 3 key in ram is not empty! No need to change key! openid = ");
      paramContext.append(paramString1);
      paramContext.append(", offer id = ");
      paramContext.append(paramString2);
      ks.b("HTTP-KeyManager", paramContext.toString());
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("At least 1 key empty in both ram and disk for openid = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", offer id = ");
    ((StringBuilder)localObject).append(paramString2);
    ks.b("HTTP-KeyManager", ((StringBuilder)localObject).toString());
    g(paramContext, paramString1, paramString2, paramString3);
    return true;
  }
  
  public String c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ks.a("HTTP-KeyManager", "Cannot read sec key from disk with empty open id!");
      return "";
    }
    if (TextUtils.isEmpty(paramString2))
    {
      ks.a("HTTP-KeyManager", "Cannot read sec key from disk with empty offer id!");
      return "";
    }
    if (paramContext == null)
    {
      ks.a("HTTP-KeyManager", "Cannot read sec key from disk with null context!");
      return "";
    }
    if (TextUtils.isEmpty(paramString3))
    {
      ks.a("HTTP-KeyManager", "Cannot read sec key from disk with empty sdk version!");
      return "";
    }
    String str2 = a();
    String str1 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_SecretEncodeKey");
      paramContext = a(paramContext, "TencentUnipay", localStringBuilder.toString());
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = new StringBuilder();
        paramContext.append("Cannot read sec key from disk for offer id = ");
        paramContext.append(paramString2);
        paramContext.append(", open id = ");
        paramContext.append(paramString1);
        ks.a("HTTP-KeyManager", paramContext.toString());
        paramContext = str1;
      }
      else
      {
        paramContext = ly.b(paramContext, str2);
      }
      paramString1 = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        ks.a("HTTP-KeyManager", "Cannot decode sec key got from disk!");
        paramString1 = "";
      }
      return paramString1;
    }
    catch (Exception paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("Cannot get sec key from disk, exception = ");
      paramString1.append(paramContext.toString());
      ks.a("HTTP-KeyManager", paramString1.toString());
    }
    return "";
  }
  
  public String c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramString2 = (String)this.c.get(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    return paramString1;
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString4)) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString4);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKeyTime");
    h(paramContext, "TencentUnipay", localStringBuilder.toString(), paramString3);
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    this.c.put(paramString1, paramString3);
  }
  
  public String d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ks.a("HTTP-KeyManager", "Try to read cry key from disk without openid!");
      return "";
    }
    if (paramContext == null)
    {
      ks.a("HTTP-KeyManager", "Try to read cry key from disk with null context!");
      return "";
    }
    if (TextUtils.isEmpty(paramString2))
    {
      ks.a("HTTP-KeyManager", "Try to read cry key from disk without offer id!");
      return "";
    }
    if (TextUtils.isEmpty(paramString3))
    {
      ks.a("HTTP-KeyManager", "Try to read cry key from disk without sdk version!");
      return "";
    }
    String str2 = c(paramContext, paramString1, paramString2, paramString3);
    if (TextUtils.isEmpty(str2))
    {
      ks.a("HTTP-KeyManager", "Cannot read cry key from disk while not able to get sec key!");
      return "";
    }
    String str1 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_CryptEncodeKey");
      paramContext = a(paramContext, "TencentUnipay", localStringBuilder.toString());
    }
    catch (Exception paramContext)
    {
      paramString3 = new StringBuilder();
      paramString3.append("Get cry key from disk got a exception = ");
      paramString3.append(paramContext.toString());
      ks.a("HTTP-KeyManager", paramString3.toString());
      paramContext = "";
    }
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = new StringBuilder();
      paramContext.append("Cannot read cry key from disk for open id = ");
      paramContext.append(paramString1);
      paramContext.append(", offer id = ");
      paramContext.append(paramString2);
      ks.a("HTTP-KeyManager", paramContext.toString());
      paramContext = str1;
    }
    else
    {
      paramContext = ly.b(paramContext, str2);
    }
    paramString1 = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      ks.a("HTTP-KeyManager", "Read cry key from disk, empty decode result");
      paramString1 = "";
    }
    return paramString1;
  }
  
  public String e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    if (TextUtils.isEmpty(paramString3)) {
      return "";
    }
    if (paramContext == null) {
      return "";
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_CryptEncodeKeyTime");
      paramContext = a(paramContext, "TencentUnipay", localStringBuilder.toString());
    }
    catch (Exception paramContext)
    {
      label108:
      break label108;
    }
    paramContext = "";
    TextUtils.isEmpty(paramContext);
    return paramContext;
  }
  
  public void f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKey");
    b(paramContext, "TencentUnipay", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKeyTime");
    b(paramContext, "TencentUnipay", localStringBuilder.toString());
    paramContext = new StringBuilder();
    paramContext.append(paramString1);
    paramContext.append("_");
    paramContext.append(paramString2);
    paramContext = paramContext.toString();
    this.b.remove(paramContext);
    this.c.remove(paramContext);
  }
  
  public void g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKey");
    b(paramContext, "TencentUnipay", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_SecretEncodeKey");
    b(paramContext, "TencentUnipay", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKeyTime");
    b(paramContext, "TencentUnipay", localStringBuilder.toString());
    paramContext = new StringBuilder();
    paramContext.append(paramString1);
    paramContext.append("_");
    paramContext.append(paramString2);
    paramContext = paramContext.toString();
    this.b.remove(paramContext);
    this.a.remove(paramContext);
    this.c.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lx
 * JD-Core Version:    0.7.0.1
 */