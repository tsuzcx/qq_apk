package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class c
{
  static File em(String paramString)
  {
    AppMethodBeat.i(87625);
    paramString = new File(paramString);
    if (paramString.exists())
    {
      AppMethodBeat.o(87625);
      return paramString;
    }
    if (!paramString.getParentFile().exists()) {
      em(paramString.getParentFile().getAbsolutePath());
    }
    paramString.mkdir();
    AppMethodBeat.o(87625);
    return paramString;
  }
  
  static List<String> z(File paramFile)
  {
    AppMethodBeat.i(87624);
    paramFile = new FileReader(paramFile);
    BufferedReader localBufferedReader = new BufferedReader(paramFile);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      localArrayList.add(str.trim());
    }
    paramFile.close();
    localBufferedReader.close();
    AppMethodBeat.o(87624);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */