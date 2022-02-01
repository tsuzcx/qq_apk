package com.tencent.mobileqq.emosm.view;

import com.tencent.mobileqq.widget.ProgressButton;

class DragSortAdapter$3$3
  implements Runnable
{
  DragSortAdapter$3$3(DragSortAdapter.3 param3, int paramInt) {}
  
  public void run()
  {
    if (this.val$resultCode == 0)
    {
      this.this$1.val$proBtn.setText("已下载");
      this.this$1.val$proBtn.setProgress(0);
      this.this$1.val$proBtn.setTag(Integer.valueOf(4));
      this.this$1.val$proBtn.setTextColor(-3355444);
      return;
    }
    this.this$1.val$proBtn.setProgress(0);
    this.this$1.val$proBtn.setText(2131368464);
    this.this$1.val$proBtn.setTextColor(DragSortAdapter.access$000(this.this$1.this$0));
    this.this$1.val$proBtn.setTag(Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.3.3
 * JD-Core Version:    0.7.0.1
 */