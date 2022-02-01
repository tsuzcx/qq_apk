package com.tencent.mobileqq.msf.core.c;

import com.tencent.qphone.base.util.QLog;

class k
  extends Thread
{
  long a = 0L;
  
  public k(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
  }
  
  public void run()
  {
    
    try
    {
      i.a(0, this.a);
      i.a(1, this.a);
      i.b(this.b);
      i.c(this.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MSF.C.NetworkTraffic", 1, "makeReportRDMData error " + localException, localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.k
 * JD-Core Version:    0.7.0.1
 */