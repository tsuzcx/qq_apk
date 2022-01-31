package com.tencent.c.a.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class c
{
  static File bC(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    if (!paramString.getParentFile().exists()) {
      bC(paramString.getParentFile().getAbsolutePath());
    }
    paramString.mkdir();
    return paramString;
  }
  
  static List<String> j(File paramFile)
  {
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
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */