package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.data.ShowExternalTroop;
import java.util.Comparator;

public class ShowExternalTroopListAdapter$ShowExternalTroopCompator
  implements Comparator
{
  public int a(ShowExternalTroop paramShowExternalTroop1, ShowExternalTroop paramShowExternalTroop2)
  {
    if (paramShowExternalTroop1.addedTimestamp < paramShowExternalTroop2.addedTimestamp) {
      return 1;
    }
    if (paramShowExternalTroop1.addedTimestamp > paramShowExternalTroop2.addedTimestamp) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.ShowExternalTroopCompator
 * JD-Core Version:    0.7.0.1
 */