package com.tencent.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class c
{
  static File cF(String paramString)
  {
    AppMethodBeat.i(125743);
    paramString = new File(paramString);
    if (paramString.exists())
    {
      AppMethodBeat.o(125743);
      return paramString;
    }
    if (!paramString.getParentFile().exists()) {
      cF(paramString.getParentFile().getAbsolutePath());
    }
    paramString.mkdir();
    AppMethodBeat.o(125743);
    return paramString;
  }
  
  static List<String> n(File paramFile)
  {
    AppMethodBeat.i(125742);
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
    AppMethodBeat.o(125742);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */