package midas.x;

import android.text.TextUtils;
import org.json.JSONObject;

public class s1
{
  public x9 a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public s1() {}
  
  public s1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString1;
    this.b = 3;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return l6.a(paramString1, r1.b(paramString2));
  }
  
  public static s1 a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new s1(String.valueOf(paramInt), paramString1, paramString2, paramString3);
    paramString1.b = 1;
    return paramString1;
  }
  
  public static s1 a(x9 paramx9)
  {
    s1 locals1 = new s1();
    locals1.a = paramx9;
    Object localObject;
    if (!TextUtils.isEmpty(paramx9.d)) {
      localObject = paramx9.d;
    } else {
      localObject = paramx9.g;
    }
    paramx9 = a(paramx9.k, (String)localObject);
    try
    {
      localObject = new JSONObject(paramx9);
      locals1.b = ((JSONObject)localObject).optInt("type");
      locals1.c = ((JSONObject)localObject).optString("text");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      locals1.b = 3;
      locals1.c = paramx9;
    }
    if (locals1.b == 0)
    {
      locals1.b = 3;
      locals1.c = paramx9;
    }
    return locals1;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return l6.c(paramString1, r1.b(paramString2));
  }
  
  public int a()
  {
    try
    {
      int i = Integer.valueOf(this.c).intValue();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public s1 c()
  {
    int i;
    try
    {
      i = Integer.valueOf(this.c).intValue();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = -1;
    }
    Object localObject = this.a;
    localObject = new s1(String.valueOf(i + 1), ((x9)localObject).b, ((x9)localObject).c, ((x9)localObject).d);
    ((s1)localObject).b = 2;
    return localObject;
  }
  
  public s1 d()
  {
    try
    {
      Object localObject2 = new JSONObject(this.c);
      Object localObject1 = ((JSONObject)localObject2).optString("nextMessage");
      String str1 = ((JSONObject)localObject2).optString("nextOfferId");
      String str2 = ((JSONObject)localObject2).optString("nextOpenId");
      localObject2 = ((JSONObject)localObject2).optString("nextLinkId");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = new s1((String)localObject1, str1, str2, (String)localObject2);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String e()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("type", this.b);
      ((JSONObject)localObject).put("text", this.c);
      localObject = b(((JSONObject)localObject).toString(), this.f);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("APWSText{mType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mText='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", toOfferId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", toOpenId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", toLinkId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s1
 * JD-Core Version:    0.7.0.1
 */