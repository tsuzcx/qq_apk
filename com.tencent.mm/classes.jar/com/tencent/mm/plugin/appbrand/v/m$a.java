package com.tencent.mm.plugin.appbrand.v;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class m$a
{
  private static final Pattern hlA = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
  public final String charset;
  public final String mimeType;
  
  private m$a(String paramString1, String paramString2)
  {
    this.mimeType = paramString1;
    this.charset = paramString2;
  }
  
  public static a wM(String paramString)
  {
    String str = null;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = hlA.matcher(paramString);
    } while (!((Matcher)localObject).find());
    Object localObject = ((Matcher)localObject).group(0);
    if (paramString.contains("charset=")) {
      str = paramString.substring(paramString.indexOf("charset=") + 8).trim();
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "UTF-8";
    }
    return new a((String)localObject, paramString);
  }
  
  public final String toString()
  {
    return "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.m.a
 * JD-Core Version:    0.7.0.1
 */