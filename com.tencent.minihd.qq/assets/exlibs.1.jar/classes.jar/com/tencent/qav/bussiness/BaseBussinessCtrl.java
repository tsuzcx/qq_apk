package com.tencent.qav.bussiness;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.QavSDK;
import com.tencent.qav.channel.VideoChannelImpl;
import com.tencent.qav.controller.c2c.QavC2CObserver;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.log.AVLogImpl;
import java.util.Iterator;
import java.util.List;
import liv;

public abstract class BaseBussinessCtrl
  extends QavC2CObserver
{
  private static final String jdField_a_of_type_JavaLangString = "BaseBussinessCtrl";
  protected long a;
  public Context a;
  protected AppInterface a;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public BaseBussinessCtrl()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private String a(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      Iterator localIterator = paramContext.getRunningAppProcesses().iterator();
      paramContext = localObject2;
      localObject1 = paramContext;
      if (localIterator.hasNext())
      {
        localObject1 = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i) {
          break label96;
        }
        paramContext = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
      }
    }
    label96:
    for (;;)
    {
      break;
      AVLog.d("BaseBussinessCtrl", String.format("getCurProcessName processName=%s", new Object[] { localObject1 }));
      return localObject1;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a.getApplicationContext();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)BaseApplicationImpl.a.a());
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin();
    AVLog.setAVLogImpl(new AVLogImpl());
    VideoChannelImpl localVideoChannelImpl = VideoChannelImpl.a();
    localVideoChannelImpl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    localVideoChannelImpl.setVideoChannelSupportCallback(new liv(this));
    QavSDK localQavSDK = QavSDK.getInstance();
    localQavSDK.initSDK(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, localVideoChannelImpl);
    localQavSDK.addObserver(this);
  }
  
  private void c()
  {
    QavSDK localQavSDK = QavSDK.getInstance();
    localQavSDK.removeObserver(this);
    localQavSDK.unInitSDK();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.bussiness.BaseBussinessCtrl
 * JD-Core Version:    0.7.0.1
 */