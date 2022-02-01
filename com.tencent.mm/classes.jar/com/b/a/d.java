package com.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class d
{
  private static final Pattern RANGE_HEADER_PATTERN;
  private static final Pattern cAP;
  public final long cAQ;
  public final boolean cAR;
  public final String uri;
  
  static
  {
    AppMethodBeat.i(183564);
    RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    cAP = Pattern.compile("GET /(.*) HTTP");
    AppMethodBeat.o(183564);
  }
  
  private d(String paramString)
  {
    AppMethodBeat.i(183561);
    l.checkNotNull(paramString);
    Matcher localMatcher = RANGE_HEADER_PATTERN.matcher(paramString);
    long l;
    if (localMatcher.find())
    {
      l = Long.parseLong(localMatcher.group(1));
      this.cAQ = Math.max(0L, l);
      if (l < 0L) {
        break label105;
      }
    }
    label105:
    for (boolean bool = true;; bool = false)
    {
      this.cAR = bool;
      localMatcher = cAP.matcher(paramString);
      if (!localMatcher.find()) {
        break label111;
      }
      this.uri = localMatcher.group(1);
      AppMethodBeat.o(183561);
      return;
      l = -1L;
      break;
    }
    label111:
    paramString = new IllegalArgumentException("Invalid request `" + paramString + "`: url not found!");
    AppMethodBeat.o(183561);
    throw paramString;
  }
  
  public static d o(InputStream paramInputStream)
  {
    AppMethodBeat.i(183562);
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      localStringBuilder.append(str).append('\n');
    }
    paramInputStream = new d(localStringBuilder.toString());
    AppMethodBeat.o(183562);
    return paramInputStream;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(183563);
    String str = "GetRequest{rangeOffset=" + this.cAQ + ", partial=" + this.cAR + ", uri='" + this.uri + '\'' + '}';
    AppMethodBeat.o(183563);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.b.a.d
 * JD-Core Version:    0.7.0.1
 */