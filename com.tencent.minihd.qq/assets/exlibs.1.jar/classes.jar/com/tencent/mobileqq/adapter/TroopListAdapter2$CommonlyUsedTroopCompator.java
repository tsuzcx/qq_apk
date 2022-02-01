package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.data.CommonlyUsedTroop;
import java.util.Comparator;

public class TroopListAdapter2$CommonlyUsedTroopCompator
  implements Comparator
{
  public int a(CommonlyUsedTroop paramCommonlyUsedTroop1, CommonlyUsedTroop paramCommonlyUsedTroop2)
  {
    if (paramCommonlyUsedTroop1.addedTimestamp < paramCommonlyUsedTroop2.addedTimestamp) {
      return 1;
    }
    if (paramCommonlyUsedTroop1.addedTimestamp > paramCommonlyUsedTroop2.addedTimestamp) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.CommonlyUsedTroopCompator
 * JD-Core Version:    0.7.0.1
 */