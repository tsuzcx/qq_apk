package com.tencent.mobileqq.vas;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class PendantInfo$DecodeNextFrameTask
  extends AsyncTask
{
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject;
  
  public PendantInfo$DecodeNextFrameTask(PendantInfo paramPendantInfo, Object paramObject, long paramLong)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    try
    {
      long l1 = paramVarArgs[0].longValue();
      long l2 = paramVarArgs[1].longValue();
      long l3 = paramVarArgs[2].longValue();
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a((int)l3, this.jdField_a_of_type_JavaLangObject, (int)l2);
      if ((paramVarArgs != null) && (!isCancelled()))
      {
        l2 = SystemClock.uptimeMillis();
        Message localMessage = new Message();
        localMessage.what = 17;
        Bundle localBundle = new Bundle();
        localBundle.putLong("targetId", this.jdField_a_of_type_Long);
        localMessage.obj = paramVarArgs;
        localMessage.setData(localBundle);
        if (l2 < l1) {
          this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1 - l2);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
      }
    }
    catch (Throwable paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("PendantInfo", 4, "", paramVarArgs);
      }
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Boolean = true;
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.DecodeNextFrameTask
 * JD-Core Version:    0.7.0.1
 */