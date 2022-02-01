package midas.x;

import android.text.TextUtils;
import org.json.JSONObject;

public class br
{
  public jr a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  private br() {}
  
  public br(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString1;
    this.b = 3;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return gh.b(paramString1, bq.d(paramString2));
  }
  
  public static br a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new br(String.valueOf(paramInt), paramString1, paramString2, paramString3);
    paramString1.b = 1;
    return paramString1;
  }
  
  public static br a(jr paramjr)
  {
    br localbr = new br();
    localbr.a = paramjr;
    Object localObject;
    if (!TextUtils.isEmpty(paramjr.d)) {
      localObject = paramjr.d;
    } else {
      localObject = paramjr.g;
    }
    paramjr = a(paramjr.k, (String)localObject);
    try
    {
      localObject = new JSONObject(paramjr);
      localbr.b = ((JSONObject)localObject).optInt("type");
      localbr.c = ((JSONObject)localObject).optString("text");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localbr.b = 3;
      localbr.c = paramjr;
    }
    if (localbr.b == 0)
    {
      localbr.b = 3;
      localbr.c = paramjr;
    }
    return localbr;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return gh.a(paramString1, bq.d(paramString2));
  }
  
  public int a()
  {
    return this.b;
  }
  
  public br b()
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
    br localbr = new br(String.valueOf(i + 1), this.a.b, this.a.c, this.a.d);
    localbr.b = 2;
    return localbr;
  }
  
  public int c()
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
  
  public br d()
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
        localObject1 = new br((String)localObject1, str1, str2, (String)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.br
 * JD-Core Version:    0.7.0.1
 */