package com.tencent.mobileqq.app;

import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.util.Comparator;

public class LebaUtil$LebaItemComparator
  implements Comparator
{
  private boolean a(LebaViewItem paramLebaViewItem)
  {
    return (paramLebaViewItem != null) && (paramLebaViewItem.a != null);
  }
  
  public int a(LebaViewItem paramLebaViewItem1, LebaViewItem paramLebaViewItem2)
  {
    if ((a(paramLebaViewItem1)) && (a(paramLebaViewItem2))) {
      if (paramLebaViewItem1.a.sPriority <= paramLebaViewItem2.a.sPriority) {}
    }
    while (a(paramLebaViewItem1))
    {
      return -1;
      if (paramLebaViewItem1.a.sPriority < paramLebaViewItem2.a.sPriority) {
        return 1;
      }
      return 0;
    }
    if (a(paramLebaViewItem2)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaUtil.LebaItemComparator
 * JD-Core Version:    0.7.0.1
 */