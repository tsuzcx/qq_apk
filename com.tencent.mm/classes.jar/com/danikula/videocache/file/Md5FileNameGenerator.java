package com.danikula.videocache.file;

import android.text.TextUtils;
import com.danikula.videocache.ProxyCacheUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Md5FileNameGenerator
  implements FileNameGenerator
{
  private static final int MAX_EXTENSION_LENGTH = 4;
  
  private String getExtension(String paramString)
  {
    AppMethodBeat.i(195186);
    int i = paramString.lastIndexOf('.');
    int j = paramString.lastIndexOf('/');
    if ((i != -1) && (i > j) && (i + 2 + 4 > paramString.length()))
    {
      paramString = paramString.substring(i + 1, paramString.length());
      AppMethodBeat.o(195186);
      return paramString;
    }
    AppMethodBeat.o(195186);
    return "";
  }
  
  public String generate(String paramString)
  {
    AppMethodBeat.i(183627);
    String str = getExtension(paramString);
    paramString = ProxyCacheUtils.computeMD5(paramString);
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(183627);
      return paramString;
    }
    paramString = paramString + "." + str;
    AppMethodBeat.o(183627);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.file.Md5FileNameGenerator
 * JD-Core Version:    0.7.0.1
 */