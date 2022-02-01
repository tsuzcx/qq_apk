package com.tencent.mobileqq.activity.widget.qqmusic.utils;

import android.util.Base64;

public class XmlStringBuilder
{
  protected StringBuilder a;
  
  protected static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("<").append(paramString1).append(">");
    if ((paramString2 == null) || ((paramString2.length() > 0) && (paramBoolean)))
    {
      try
      {
        String str = new String(Base64.encode(paramString2.getBytes("UTF-8"), 0), "UTF-8");
        paramString2 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramString2 = new String(Base64.encode(paramString2.getBytes(), 0));
        }
      }
      paramStringBuilder.append(paramString2);
    }
    for (;;)
    {
      paramStringBuilder.append("</").append(paramString1).append(">");
      return;
      paramStringBuilder.append(paramString2);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.a == null) {
      this.a = new StringBuilder();
    }
    this.a.append(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, false);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return;
    }
    if (this.a == null) {
      this.a = new StringBuilder();
    }
    a(this.a, paramString1, paramString2, paramBoolean);
  }
  
  public String toString()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.XmlStringBuilder
 * JD-Core Version:    0.7.0.1
 */