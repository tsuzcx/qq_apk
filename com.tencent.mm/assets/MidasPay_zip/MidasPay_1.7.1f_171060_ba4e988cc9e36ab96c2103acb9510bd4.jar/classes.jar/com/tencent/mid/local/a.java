package com.tencent.mid.local;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class a
{
  static List<String> a(File paramFile)
  {
    paramFile = new FileReader(paramFile);
    BufferedReader localBufferedReader = new BufferedReader(paramFile);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
      {
        paramFile.close();
        localBufferedReader.close();
        return localArrayList;
      }
      localArrayList.add(str.trim());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.a
 * JD-Core Version:    0.7.0.1
 */