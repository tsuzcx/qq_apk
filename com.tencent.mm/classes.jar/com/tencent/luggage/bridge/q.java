package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q
  implements p
{
  private static final Pattern bZI;
  private o bZw;
  
  static
  {
    AppMethodBeat.i(140345);
    bZI = Pattern.compile("^<<//([a-z]{0,10})//>>");
    AppMethodBeat.o(140345);
  }
  
  q(o paramo)
  {
    this.bZw = paramo;
  }
  
  public final String bN(String paramString)
  {
    AppMethodBeat.i(140344);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140344);
      return null;
    }
    Object localObject = bZI.matcher(paramString);
    if (((Matcher)localObject).find()) {}
    for (localObject = ((Matcher)localObject).group(1); localObject == null; localObject = null)
    {
      AppMethodBeat.o(140344);
      return null;
    }
    paramString = paramString.replaceFirst("^<<//([a-z]{0,10})//>>", "");
    boolean bool = ((String)localObject).equals("sync");
    paramString = this.bZw.bZB.i(paramString, bool);
    AppMethodBeat.o(140344);
    return paramString;
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(140343);
    this.bZw.AK();
    AppMethodBeat.o(140343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.q
 * JD-Core Version:    0.7.0.1
 */