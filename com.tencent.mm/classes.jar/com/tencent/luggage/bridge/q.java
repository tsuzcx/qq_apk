package com.tencent.luggage.bridge;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q
  implements p
{
  private static final Pattern bhS = Pattern.compile("^<<//([a-z]{0,10})//>>");
  private o bhF;
  
  q(o paramo)
  {
    this.bhF = paramo;
  }
  
  public final String aW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      Object localObject = bhS.matcher(paramString);
      if (((Matcher)localObject).find()) {}
      for (localObject = ((Matcher)localObject).group(1); localObject != null; localObject = null)
      {
        paramString = paramString.replaceFirst("^<<//([a-z]{0,10})//>>", "");
        boolean bool = ((String)localObject).equals("sync");
        return this.bhF.bhL.g(paramString, bool);
      }
    }
  }
  
  public final void onReady()
  {
    this.bhF.pS();
    this.bhF.bhM.pP();
  }
  
  public final void pT()
  {
    this.bhF.pS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.bridge.q
 * JD-Core Version:    0.7.0.1
 */