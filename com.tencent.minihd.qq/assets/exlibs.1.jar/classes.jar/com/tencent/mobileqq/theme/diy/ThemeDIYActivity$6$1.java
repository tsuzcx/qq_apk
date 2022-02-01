package com.tencent.mobileqq.theme.diy;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class ThemeDIYActivity$6$1
  implements Runnable
{
  ThemeDIYActivity$6$1(ThemeDIYActivity.6 param6, ThemeDIYActivity.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    int i = this.val$holder.mRLayout.getChildCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if ((this.val$holder.mRLayout.getChildAt(i) instanceof ProgressBar)) {
          this.val$holder.mRLayout.removeViewAt(i);
        }
      }
      else
      {
        Iterator localIterator = this.val$holder.waitMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          View localView = (View)localEntry.getValue();
          if (localView != null) {
            localView.setBackgroundDrawable(this.this$1.this$0.getLocalDrawable(this.this$1.this$0.diyScreenshotDir, (String)localEntry.getKey(), localView, this.val$holder, false));
          }
        }
      }
      i -= 1;
    }
    if ((this.this$1.this$0.currentIndex == this.val$holder.id) && (this.this$1.this$0.mScrollLayout != null)) {
      this.this$1.this$0.mScrollLayout.setToScreen(this.this$1.this$0.currentIndex, 50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.6.1
 * JD-Core Version:    0.7.0.1
 */