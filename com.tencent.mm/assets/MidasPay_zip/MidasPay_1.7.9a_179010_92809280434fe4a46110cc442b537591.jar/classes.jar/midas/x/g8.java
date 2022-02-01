package midas.x;

import com.tencent.midas.comm.APLog;

public class g8
{
  public static k8 a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createWebPage name = ");
    localStringBuilder.append(paramString);
    APLog.d("APPageFactory", localStringBuilder.toString());
    if (y7.t.equals(paramString)) {
      return new q8();
    }
    if (y7.u.equals(paramString)) {
      return new u8();
    }
    if (y7.v.equals(paramString)) {
      return new p8();
    }
    if (y7.x.equals(paramString)) {
      return new l8();
    }
    if (y7.w.equals(paramString)) {
      return new n8();
    }
    if (y7.y.equals(paramString)) {
      return new t8();
    }
    if (y7.z.equals(paramString)) {
      return new o8();
    }
    if (y7.A.equals(paramString)) {
      return new m8();
    }
    if (y7.B.equals(paramString)) {
      return new s8();
    }
    return null;
  }
  
  public static v8 b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createX5WebPage name = ");
    localStringBuilder.append(paramString);
    APLog.d("APPageFactory", localStringBuilder.toString());
    if (y7.t.equals(paramString)) {
      return new b9();
    }
    if (y7.u.equals(paramString)) {
      return new e9();
    }
    if (y7.v.equals(paramString)) {
      return new a9();
    }
    if (y7.x.equals(paramString)) {
      return new w8();
    }
    if (y7.w.equals(paramString)) {
      return new y8();
    }
    if (y7.y.equals(paramString)) {
      return new d9();
    }
    if (y7.z.equals(paramString)) {
      return new z8();
    }
    if (y7.A.equals(paramString)) {
      return new x8();
    }
    if (y7.B.equals(paramString)) {
      return new c9();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.g8
 * JD-Core Version:    0.7.0.1
 */