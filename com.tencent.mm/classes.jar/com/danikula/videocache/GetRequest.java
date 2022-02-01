package com.danikula.videocache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GetRequest
{
  private static final Pattern RANGE_HEADER_PATTERN;
  private static final Pattern URL_PATTERN;
  public final boolean partial;
  public final long rangeOffset;
  public final String uri;
  
  static
  {
    AppMethodBeat.i(183564);
    RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    URL_PATTERN = Pattern.compile("GET /(.*) HTTP");
    AppMethodBeat.o(183564);
  }
  
  public GetRequest(String paramString)
  {
    AppMethodBeat.i(183561);
    Preconditions.checkNotNull(paramString);
    long l = findRangeOffset(paramString);
    this.rangeOffset = Math.max(0L, l);
    if (l >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.partial = bool;
      this.uri = findUri(paramString);
      AppMethodBeat.o(183561);
      return;
    }
  }
  
  private long findRangeOffset(String paramString)
  {
    AppMethodBeat.i(223130);
    paramString = RANGE_HEADER_PATTERN.matcher(paramString);
    if (paramString.find())
    {
      long l = Long.parseLong(paramString.group(1));
      AppMethodBeat.o(223130);
      return l;
    }
    AppMethodBeat.o(223130);
    return -1L;
  }
  
  private String findUri(String paramString)
  {
    AppMethodBeat.i(223131);
    Matcher localMatcher = URL_PATTERN.matcher(paramString);
    if (localMatcher.find())
    {
      paramString = localMatcher.group(1);
      AppMethodBeat.o(223131);
      return paramString;
    }
    paramString = new IllegalArgumentException("Invalid request `" + paramString + "`: url not found!");
    AppMethodBeat.o(223131);
    throw paramString;
  }
  
  public static GetRequest read(InputStream paramInputStream)
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
    paramInputStream = new GetRequest(localStringBuilder.toString());
    AppMethodBeat.o(183562);
    return paramInputStream;
  }
  
  public String toString()
  {
    AppMethodBeat.i(183563);
    String str = "GetRequest{rangeOffset=" + this.rangeOffset + ", partial=" + this.partial + ", uri='" + this.uri + '\'' + '}';
    AppMethodBeat.o(183563);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.GetRequest
 * JD-Core Version:    0.7.0.1
 */