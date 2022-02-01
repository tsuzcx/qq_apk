package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public class FileUtil$MyFileCompare
  implements Comparator
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.a()) {
      if (paramFileInfo2.a()) {
        break label25;
      }
    }
    label25:
    while (paramFileInfo1.b() > paramFileInfo2.b())
    {
      return -1;
      if (paramFileInfo2.a()) {
        return 1;
      }
    }
    if (paramFileInfo1.b() == paramFileInfo2.b()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileUtil.MyFileCompare
 * JD-Core Version:    0.7.0.1
 */