package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
{
  private static final Pattern jMJ;
  
  static
  {
    AppMethodBeat.i(198589);
    jMJ = Pattern.compile("(\\$\\{[^\\}]+\\})");
    AppMethodBeat.o(198589);
  }
  
  public static List<a> akL(String paramString)
  {
    AppMethodBeat.i(198588);
    Matcher localMatcher = jMJ.matcher(paramString);
    paramString = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        String str1 = localMatcher.group(0);
        String str2 = str1.substring(2, str1.length() - 1);
        ac.i("MicroMsg.SysMsgTemplateHelper", "parse template, group:%s,value:%s", new Object[] { str1, str2 });
        paramString.add(new a(str1, str2));
      }
      return paramString;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SysMsgTemplateHelper", localException, "parseParams error!", new Object[0]);
      AppMethodBeat.o(198588);
    }
  }
  
  public static final class a
  {
    public String group;
    public String value;
    
    a(String paramString1, String paramString2)
    {
      this.group = paramString1;
      this.value = paramString2;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198587);
      String str = "group:" + this.group + ",value:" + this.value;
      AppMethodBeat.o(198587);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.k
 * JD-Core Version:    0.7.0.1
 */