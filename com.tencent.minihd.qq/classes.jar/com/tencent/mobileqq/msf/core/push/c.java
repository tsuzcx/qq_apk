package com.tencent.mobileqq.msf.core.push;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class c
  extends Handler
{
  c(b paramb) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ("0".equals(b.a(this.a)));
    QLog.d("PCActiveEchoManager", 1, "autoEcho");
    b.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.c
 * JD-Core Version:    0.7.0.1
 */