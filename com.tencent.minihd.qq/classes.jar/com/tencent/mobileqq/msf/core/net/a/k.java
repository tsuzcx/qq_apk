package com.tencent.mobileqq.msf.core.net.a;

import com.tencent.qphone.base.util.QLog;

class k
  implements a.a
{
  k(i parami) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 10) {
        str = paramString.substring(0, 10);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WifiDetector", 2, "WIFI detect onEchoResult, taskId: " + paramInt1 + " result: " + paramInt2 + " actualContent: " + str);
    }
    paramInt2 = i.a(this.a, paramInt2);
    i.a(this.a, paramInt2, (String)paramObject);
    i.b(this.a, i.a(this.a) - (1 << paramInt1));
    if (i.a(this.a) == 0) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.k
 * JD-Core Version:    0.7.0.1
 */