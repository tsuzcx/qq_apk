package com.tencent.mobileqq.troop.data;

import java.util.Comparator;

public class TroopFileInfo$UploadTimeComparator
  implements Comparator
{
  public int a(TroopFileInfo paramTroopFileInfo1, TroopFileInfo paramTroopFileInfo2)
  {
    if (paramTroopFileInfo1.c < paramTroopFileInfo2.c) {
      return 1;
    }
    if (paramTroopFileInfo1.c == paramTroopFileInfo2.c) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileInfo.UploadTimeComparator
 * JD-Core Version:    0.7.0.1
 */