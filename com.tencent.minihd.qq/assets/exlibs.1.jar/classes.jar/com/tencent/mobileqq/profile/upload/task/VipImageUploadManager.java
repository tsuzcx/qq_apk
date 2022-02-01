package com.tencent.mobileqq.profile.upload.task;

import com.tencent.base.Global;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import jnj;
import mqq.manager.Manager;

public class VipImageUploadManager
  implements Manager
{
  public VipImageUploadManager(QQAppInterface paramQQAppInterface)
  {
    Global.init(paramQQAppInterface.a().getApplicationContext());
  }
  
  private void a(QQAppInterface paramQQAppInterface, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (paramVipUploadConfigImpl != null)
    {
      IUploadService.UploadServiceCreator.getInstance().init(paramQQAppInterface.a().getApplicationContext(), paramVipUploadConfigImpl, null, null);
      return;
    }
    IUploadService.UploadServiceCreator.getInstance().init(paramQQAppInterface.a().getApplicationContext(), new jnj(this, Long.parseLong(paramQQAppInterface.a())), null, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, VipBaseUploadTask paramVipBaseUploadTask, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (!IUploadService.UploadServiceCreator.getInstance().isInitialized()) {
      a(paramQQAppInterface, paramVipUploadConfigImpl);
    }
    paramVipBaseUploadTask.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipImageUploadManager
 * JD-Core Version:    0.7.0.1
 */