package com.tencent.mobileqq.emosm.view;

import android.os.Handler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;

class DragSortAdapter$4
  extends EmoticonPackageDownloadListener
{
  DragSortAdapter$4(DragSortAdapter paramDragSortAdapter, EmoticonPackage paramEmoticonPackage, ProgressButton paramProgressButton) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DragSortAdapter", 2, "epid=" + paramEmoticonPackage.epId + "====pkgId=" + this.val$pkg.epId);
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.epId.equals(this.val$pkg.epId))) {
      this.this$0.handler.post(new DragSortAdapter.4.3(this, paramInt, paramEmoticonPackage));
    }
  }
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.epId.equals(this.val$pkg.epId))) {
      this.this$0.handler.post(new DragSortAdapter.4.2(this, paramEmoticonPackage));
    }
  }
  
  public void onPackageStart(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.epId.equals(this.val$pkg.epId))) {
      this.this$0.handler.post(new DragSortAdapter.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.4
 * JD-Core Version:    0.7.0.1
 */