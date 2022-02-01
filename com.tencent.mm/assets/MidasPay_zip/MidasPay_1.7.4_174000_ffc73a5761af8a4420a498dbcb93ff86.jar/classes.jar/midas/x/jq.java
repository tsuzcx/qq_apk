package midas.x;

import org.json.JSONObject;

public class jq
{
  public jr a;
  public String b;
  
  public jq()
  {
    this.a = null;
    this.b = null;
  }
  
  public jq(jr paramjr, String paramString)
  {
    this.a = paramjr;
    this.b = kh.a(this.a.a(), paramString);
  }
  
  public static jq a(String paramString1, String paramString2)
    throws Exception
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("from() : text = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" , key = ");
    ((StringBuilder)localObject).append(paramString2);
    jw.b("SignText", ((StringBuilder)localObject).toString());
    localObject = new JSONObject(paramString1);
    paramString1 = ((JSONObject)localObject).optString("sign");
    localObject = ((JSONObject)localObject).optString("data");
    paramString2 = kh.a((String)localObject, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("from() : theSign = ");
    localStringBuilder.append(paramString2);
    jw.b("SignText", localStringBuilder.toString());
    if (!paramString1.equalsIgnoreCase(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sign is invalid : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" != ");
      ((StringBuilder)localObject).append(paramString2);
      jw.b("SignText", ((StringBuilder)localObject).toString());
      return null;
    }
    paramString2 = jr.a((String)localObject);
    if (paramString2 == null)
    {
      jw.b("SignText", "wsText == Null");
      return null;
    }
    localObject = new jq();
    ((jq)localObject).a = paramString2;
    ((jq)localObject).b = paramString1;
    return localObject;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("data", this.a.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jq
 * JD-Core Version:    0.7.0.1
 */