package com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent;

import android.content.Context;

public class NetPageXmlBody
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  public NetPageXmlBody(String paramString)
  {
    this.a = paramString;
  }
  
  public String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<groupid>");
    localStringBuffer.append(this.b);
    localStringBuffer.append("</groupid>");
    localStringBuffer.append("<gl>");
    localStringBuffer.append(this.c);
    localStringBuffer.append("</gl>");
    localStringBuffer.append("<gt>");
    localStringBuffer.append(this.d);
    localStringBuffer.append("</gt>");
    localStringBuffer.append("<json>");
    localStringBuffer.append(this.e);
    localStringBuffer.append("</json>");
    localStringBuffer.append("<user_host_ts>");
    localStringBuffer.append(this.f);
    localStringBuffer.append("</user_host_ts>");
    if (paramString != null) {
      localStringBuffer.append(paramString);
    }
    return XmlProtocolConfig.a(paramContext, localStringBuffer.toString(), this.a);
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.NetPageXmlBody
 * JD-Core Version:    0.7.0.1
 */