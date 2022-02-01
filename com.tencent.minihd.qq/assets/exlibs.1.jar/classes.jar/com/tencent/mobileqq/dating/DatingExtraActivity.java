package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingConfigItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ibe;
import ibf;
import ibg;
import java.util.Iterator;
import java.util.List;

public class DatingExtraActivity
  extends DatingBaseActivity
{
  protected void a(DatingHandler paramDatingHandler, String paramString)
  {
    b("0X8004949");
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131369727);
    localActionSheet.c(2131369709);
    localActionSheet.e(2131365736);
    localActionSheet.a(new ibe(this, localActionSheet, paramDatingHandler, paramString));
    localActionSheet.show();
  }
  
  protected void b(DatingHandler paramDatingHandler, String paramString)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    List localList = ((DatingManager)this.app.getManager(67)).c();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      DatingConfigItem localDatingConfigItem = (DatingConfigItem)localIterator.next();
      if (localDatingConfigItem == null) {
        localIterator.remove();
      } else {
        localActionSheet.c(localDatingConfigItem.contentStr);
      }
    }
    localActionSheet.a(2131369728);
    localActionSheet.e(2131365736);
    localActionSheet.a(new ibf(this, localList, localActionSheet, paramDatingHandler, paramString));
    localActionSheet.a(new ibg(this));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingExtraActivity
 * JD-Core Version:    0.7.0.1
 */