package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class g
  extends Thread
{
  private static String c = "MSF.S.RespHandler";
  public volatile boolean a = true;
  MsfCore b;
  
  public g(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
  }
  
  public void run()
  {
    while (this.a)
    {
      String str;
      for (;;)
      {
        try
        {
          MsfMessagePair localMsfMessagePair = (MsfMessagePair)this.b.getMsfMessagePairs().take();
          if (localMsfMessagePair == null) {
            break;
          }
          if (localMsfMessagePair.toServiceMsg == null) {
            break label200;
          }
          str = h.b(localMsfMessagePair.toServiceMsg);
          if ((!"LongConn.OffPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd()))) {
            break label149;
          }
          QLog.d(c, 1, "recv " + str + " req:" + localMsfMessagePair.toServiceMsg.getStringForLog() + "resp:" + localMsfMessagePair.fromServiceMsg.getStringForLog());
          c.a(str, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        break;
        label149:
        QLog.d(c, 2, str + " add resp to queue:" + localInterruptedException.toServiceMsg.getRequestSsoSeq() + " from:" + localInterruptedException.fromServiceMsg);
      }
      label200:
      if (localInterruptedException.fromServiceMsg != null)
      {
        str = h.a(localInterruptedException.fromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, str + " add push to queue: from:" + localInterruptedException.fromServiceMsg);
        }
        c.a(str, localInterruptedException.toServiceMsg, localInterruptedException.fromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.g
 * JD-Core Version:    0.7.0.1
 */