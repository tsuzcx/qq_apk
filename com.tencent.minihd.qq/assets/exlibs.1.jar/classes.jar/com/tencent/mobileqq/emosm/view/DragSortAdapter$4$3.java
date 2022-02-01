package com.tencent.mobileqq.emosm.view;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;

class DragSortAdapter$4$3
  implements Runnable
{
  DragSortAdapter$4$3(DragSortAdapter.4 param4, int paramInt, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (this.val$resultCode == 0)
    {
      this.this$1.val$proBtn.setVisibility(0);
      this.this$1.val$proBtn.setText("已下载");
      this.this$1.val$proBtn.setProgress(0);
      this.this$1.val$proBtn.setTag(Integer.valueOf(4));
      this.this$1.val$proBtn.setTextColor(-3355444);
      ReportController.b((QQAppInterface)((BaseActivity)this.this$1.this$0.mContext).getAppRuntime(), "CliOper", "", "", "ep_mall", "Clk_pkg_download_aio-mine", 0, 0, this.val$ep.epId, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DragSortAdapter", 2, "===========report============" + this.val$ep.epId);
      }
      return;
    }
    this.this$1.val$proBtn.setVisibility(0);
    this.this$1.val$proBtn.setText(2131368465);
    this.this$1.val$proBtn.setProgress(0);
    this.this$1.val$proBtn.setTextColor(DragSortAdapter.access$000(this.this$1.this$0));
    this.this$1.val$proBtn.setTag(Integer.valueOf(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.4.3
 * JD-Core Version:    0.7.0.1
 */