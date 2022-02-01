package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public class FileCompare
  implements Comparator
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.a())
    {
      if (!paramFileInfo2.a()) {
        return -1000;
      }
    }
    else if (paramFileInfo2.a()) {
      return 1000;
    }
    return paramFileInfo1.e().compareToIgnoreCase(paramFileInfo2.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCompare
 * JD-Core Version:    0.7.0.1
 */