package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.HashMap;

public class gc
{
  public final HashMap<String, String> a = new HashMap();
  public final HashMap<String, String> b = new HashMap();
  public final HashMap<String, String> c = new HashMap();
  
  public static void a(Context paramContext, String paramString1, String paramString2)
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
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return "";
      }
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      paramContext = paramContext.getSharedPreferences(paramString1, 4).getString(paramString2, "");
      return paramContext;
    }
    finally {}
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2, String paramString3)
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
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1oOx");
    localStringBuilder.append("sBbJ");
    localStringBuilder.append("caUd");
    localStringBuilder.append("MbPy");
    return localStringBuilder.toString();
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
    paramString2 = (String)this.c.get(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    return paramString1;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
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
    a(paramContext, "TencentUnipay", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_SecretEncodeKey");
    a(paramContext, "TencentUnipay", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKeyTime");
    a(paramContext, "TencentUnipay", localStringBuilder.toString());
    paramContext = new StringBuilder();
    paramContext.append(paramString1);
    paramContext.append("_");
    paramContext.append(paramString2);
    paramContext = paramContext.toString();
    this.b.remove(paramContext);
    this.a.remove(paramContext);
    this.c.remove(paramContext);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString4);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKeyTime");
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
    this.c.put(paramString1, paramString3);
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
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3)
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
    a(paramContext, "TencentUnipay", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_CryptEncodeKeyTime");
    a(paramContext, "TencentUnipay", localStringBuilder.toString());
    paramContext = new StringBuilder();
    paramContext.append(paramString1);
    paramContext.append("_");
    paramContext.append(paramString2);
    paramContext = paramContext.toString();
    this.b.remove(paramContext);
    this.c.remove(paramContext);
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
    Object localObject = c(paramString1, paramString2);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    paramString3 = hc.b(paramString3, (String)localObject);
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
    paramString2 = (String)this.a.get(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return paramString1;
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3)
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
    String str1 = g(paramContext, paramString1, paramString2, paramString3);
    String str2 = e(paramContext, paramString1, paramString2, paramString3);
    paramContext = f(paramContext, paramString1, paramString2, paramString3);
    if (((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) || (!TextUtils.isEmpty(paramContext)))
    {
      c(paramString1, paramString2, str1);
      b(paramString1, paramString2, str2);
      a(paramString1, paramString2, paramContext);
    }
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
    paramString3 = hc.b(paramString3, a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString4);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_SecretEncodeKey");
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
    this.a.put(paramString1, paramString3);
  }
  
  public boolean d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ya.b("HTTP-KeyManager", "Cannot check need change key with empty offer id!");
      return false;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      ya.b("HTTP-KeyManager", "Cannot check need change key with empty open id!");
      return false;
    }
    if (paramContext == null)
    {
      ya.b("HTTP-KeyManager", "Cannot check need change key with null context!");
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      ya.b("HTTP-KeyManager", "Cannot check need change key with empty sdk version!");
      return false;
    }
    Object localObject = c(paramString1, paramString2);
    String str1 = b(paramString1, paramString2);
    String str2 = a(paramString1, paramString2);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("At least 1 key empty in ram for openid = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", offer id = ");
      ((StringBuilder)localObject).append(paramString2);
      ya.a("HTTP-KeyManager", ((StringBuilder)localObject).toString());
      localObject = g(paramContext, paramString1, paramString2, paramString3);
      str1 = e(paramContext, paramString1, paramString2, paramString3);
      str2 = f(paramContext, paramString1, paramString2, paramString3);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramContext = new StringBuilder();
        paramContext.append("At least 1 key empty in ram for openid = ");
        paramContext.append(paramString1);
        paramContext.append(", offer id = ");
        paramContext.append(paramString2);
        paramContext.append("! But all 3 key in disk is not empty! No need to change key!");
        ya.a("HTTP-KeyManager", paramContext.toString());
        c(paramString1, paramString2, (String)localObject);
        b(paramString1, paramString2, str1);
        a(paramString1, paramString2, str2);
      }
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append("All 3 key in ram is not empty! No need to change key! openid = ");
      paramContext.append(paramString1);
      paramContext.append(", offer id = ");
      paramContext.append(paramString2);
      ya.a("HTTP-KeyManager", paramContext.toString());
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("At least 1 key empty in both ram and disk for openid = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", offer id = ");
    ((StringBuilder)localObject).append(paramString2);
    ya.a("HTTP-KeyManager", ((StringBuilder)localObject).toString());
    a(paramContext, paramString1, paramString2, paramString3);
    return true;
  }
  
  public String e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ya.b("HTTP-KeyManager", "Try to read cry key from disk without openid!");
      return "";
    }
    if (paramContext == null)
    {
      ya.b("HTTP-KeyManager", "Try to read cry key from disk with null context!");
      return "";
    }
    if (TextUtils.isEmpty(paramString2))
    {
      ya.b("HTTP-KeyManager", "Try to read cry key from disk without offer id!");
      return "";
    }
    if (TextUtils.isEmpty(paramString3))
    {
      ya.b("HTTP-KeyManager", "Try to read cry key from disk without sdk version!");
      return "";
    }
    String str = g(paramContext, paramString1, paramString2, paramString3);
    if (TextUtils.isEmpty(str))
    {
      ya.b("HTTP-KeyManager", "Cannot read cry key from disk while not able to get sec key!");
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
      localStringBuilder.append("_CryptEncodeKey");
      paramContext = b(paramContext, "TencentUnipay", localStringBuilder.toString());
    }
    catch (Exception paramContext)
    {
      paramString3 = new StringBuilder();
      paramString3.append("Get cry key from disk got a exception = ");
      paramString3.append(paramContext.toString());
      ya.b("HTTP-KeyManager", paramString3.toString());
      paramContext = "";
    }
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = new StringBuilder();
      paramContext.append("Cannot read cry key from disk for open id = ");
      paramContext.append(paramString1);
      paramContext.append(", offer id = ");
      paramContext.append(paramString2);
      ya.b("HTTP-KeyManager", paramContext.toString());
      paramContext = "";
    }
    else
    {
      paramContext = hc.a(paramContext, str);
    }
    paramString1 = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      ya.b("HTTP-KeyManager", "Read cry key from disk, empty decode result");
      paramString1 = "";
    }
    return paramString1;
  }
  
  public String f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    String str = "";
    if (bool) {
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
      paramContext = b(paramContext, "TencentUnipay", localStringBuilder.toString());
      TextUtils.isEmpty(paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  public String g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ya.b("HTTP-KeyManager", "Cannot read sec key from disk with empty open id!");
      return "";
    }
    if (TextUtils.isEmpty(paramString2))
    {
      ya.b("HTTP-KeyManager", "Cannot read sec key from disk with empty offer id!");
      return "";
    }
    if (paramContext == null)
    {
      ya.b("HTTP-KeyManager", "Cannot read sec key from disk with null context!");
      return "";
    }
    if (TextUtils.isEmpty(paramString3))
    {
      ya.b("HTTP-KeyManager", "Cannot read sec key from disk with empty sdk version!");
      return "";
    }
    String str = a();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_SecretEncodeKey");
      paramContext = b(paramContext, "TencentUnipay", localStringBuilder.toString());
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = new StringBuilder();
        paramContext.append("Cannot read sec key from disk for offer id = ");
        paramContext.append(paramString2);
        paramContext.append(", open id = ");
        paramContext.append(paramString1);
        ya.b("HTTP-KeyManager", paramContext.toString());
        paramContext = "";
      }
      else
      {
        paramContext = hc.a(paramContext, str);
      }
      paramString1 = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        ya.b("HTTP-KeyManager", "Cannot decode sec key got from disk!");
        paramString1 = "";
      }
      return paramString1;
    }
    catch (Exception paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("Cannot get sec key from disk, exception = ");
      paramString1.append(paramContext.toString());
      ya.b("HTTP-KeyManager", paramString1.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.gc
 * JD-Core Version:    0.7.0.1
 */