package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.albumstatus.AlbumStatus;

public class WeiyunCheckAlbum
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Weiyun.AlbumBackup", 2, "weiyun album status check step begins at doStep()");
    }
    AlbumStatus.a(BaseApplicationImpl.a);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.WeiyunCheckAlbum
 * JD-Core Version:    0.7.0.1
 */