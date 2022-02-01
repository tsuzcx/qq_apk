package com.tencent.mobileqq.theme.diy;

import android.view.View;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ThemeDIYActivity$6
  extends DownloadListener
{
  ThemeDIYActivity$6(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDIYActivity", 2, "-->download success!");
      }
      int i = Integer.parseInt(paramDownloadTask.a);
      if ((i >= 0) && (i < this.this$0.showData.length))
      {
        paramDownloadTask = this.this$0.mScrollLayout.getChildAt(i);
        if ((paramDownloadTask == null) || (!(paramDownloadTask.getTag() instanceof ThemeDIYActivity.ViewHolder))) {}
        ThemeDIYActivity.ViewHolder localViewHolder;
        do
        {
          return;
          localViewHolder = (ThemeDIYActivity.ViewHolder)paramDownloadTask.getTag();
        } while (localViewHolder.waitMap == null);
        paramDownloadTask.post(new ThemeDIYActivity.6.1(this, localViewHolder));
      }
    }
    for (;;)
    {
      paramDownloadTask = this.this$0;
      paramDownloadTask.loadingInt -= 1;
      if ((this.this$0.loadArr == null) || (this.this$0.loadArr.size() <= 0)) {
        break;
      }
      this.this$0.downloadPic((DownloadTask)this.this$0.loadArr.remove(0));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDIYActivity", 2, "-->download failed!");
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ThemeDIYActivity", 2, "-->download progress!");
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ThemeDIYActivity", 2, "-->download start!");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.6
 * JD-Core Version:    0.7.0.1
 */