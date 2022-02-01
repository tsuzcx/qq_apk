package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q
  implements p
{
  private static final Pattern csP;
  private o csD;
  
  static
  {
    AppMethodBeat.i(140345);
    csP = Pattern.compile("^<<//([a-z]{0,10})//>>");
    AppMethodBeat.o(140345);
  }
  
  q(o paramo)
  {
    this.csD = paramo;
  }
  
  public final String cO(String paramString)
  {
    AppMethodBeat.i(140344);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140344);
      return null;
    }
    Object localObject = csP.matcher(paramString);
    if (((Matcher)localObject).find()) {}
    for (localObject = ((Matcher)localObject).group(1); localObject == null; localObject = null)
    {
      AppMethodBeat.o(140344);
      return null;
    }
    paramString = paramString.replaceFirst("^<<//([a-z]{0,10})//>>", "");
    boolean bool = ((String)localObject).equals("sync");
    paramString = this.csD.csI.i(paramString, bool);
    AppMethodBeat.o(140344);
    return paramString;
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(140343);
    this.csD.La();
    AppMethodBeat.o(140343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.q
 * JD-Core Version:    0.7.0.1
 */