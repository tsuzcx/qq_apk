package midas.x;

import org.json.JSONObject;

public class w9
{
  public x9 a;
  public String b;
  
  public w9()
  {
    this.a = null;
    this.b = null;
  }
  
  public w9(x9 paramx9, String paramString)
  {
    this.a = paramx9;
    this.b = na.a(this.a.c(), paramString);
  }
  
  public static w9 a(String paramString1, String paramString2)
    throws Exception
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("from() : text = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" , key = ");
    ((StringBuilder)localObject).append(paramString2);
    ca.a("SignText", ((StringBuilder)localObject).toString());
    localObject = new JSONObject(paramString1);
    paramString1 = ((JSONObject)localObject).optString("sign");
    localObject = ((JSONObject)localObject).optString("data");
    paramString2 = na.a((String)localObject, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("from() : theSign = ");
    localStringBuilder.append(paramString2);
    ca.a("SignText", localStringBuilder.toString());
    if (!paramString1.equalsIgnoreCase(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sign is invalid : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" != ");
      ((StringBuilder)localObject).append(paramString2);
      ca.a("SignText", ((StringBuilder)localObject).toString());
      return null;
    }
    paramString2 = x9.a((String)localObject);
    if (paramString2 == null)
    {
      ca.a("SignText", "wsText == Null");
      return null;
    }
    localObject = new w9();
    ((w9)localObject).a = paramString2;
    ((w9)localObject).b = paramString1;
    return localObject;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("data", this.a.c());
      ((JSONObject)localObject).put("sign", this.b);
      localObject = ((JSONObject)localObject).toString();
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
    localStringBuilder.append("SignText{data='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sign='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w9
 * JD-Core Version:    0.7.0.1
 */