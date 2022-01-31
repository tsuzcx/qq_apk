package com.tencent.map.geolocation.internal;

import c.t.m.g.cr;
import c.t.m.g.j;

class TencentExtraKeys$LogCallback
  implements cr
{
  private void onLogImpl(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      if (paramInt == 3) {
        j.a(paramString1, 4, paramString2);
      }
      while (paramInt != 6) {
        return;
      }
      j.a(paramString1, 6, paramString2);
      return;
    }
    j.a(paramString1, paramString2, paramThrowable);
  }
  
  public void onLog(int paramInt, String paramString1, String paramString2)
  {
    onLogImpl(paramInt, paramString1, paramString2, null);
  }
  
  public void onLog(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    onLogImpl(paramInt, paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentExtraKeys.LogCallback
 * JD-Core Version:    0.7.0.1
 */