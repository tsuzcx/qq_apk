package com.tencent.mobileqq.emosm.view;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;

class DragSortAdapter$3$2
  implements Runnable
{
  DragSortAdapter$3$2(DragSortAdapter.3 param3, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    DownloadTask localDownloadTask = DragSortAdapter.access$200(this.this$1.this$0).a("vipEmoticonKey_" + this.val$ep.epId);
    if ((localDownloadTask != null) && (!localDownloadTask.b()))
    {
      int i = (int)localDownloadTask.a;
      this.this$1.val$proBtn.setProgress(i);
      this.this$1.val$proBtn.setText("取消");
      this.this$1.val$proBtn.setTextColor(DragSortAdapter.access$000(this.this$1.this$0));
      this.this$1.val$proBtn.setTag(Integer.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.d("DragSortAdapter", 2, "down ep=" + this.val$ep.epId + "progress=" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.3.2
 * JD-Core Version:    0.7.0.1
 */