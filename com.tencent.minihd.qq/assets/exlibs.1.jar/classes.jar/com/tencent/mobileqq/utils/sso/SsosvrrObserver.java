package com.tencent.mobileqq.utils.sso;

import com.tencent.mobileqq.app.BusinessObserver;

public class SsosvrrObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, SsosvrrObserver.SsosvrrData paramSsosvrrData) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 70001) && ((paramObject instanceof SsosvrrObserver.SsosvrrData))) {
      a(paramBoolean, (SsosvrrObserver.SsosvrrData)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.sso.SsosvrrObserver
 * JD-Core Version:    0.7.0.1
 */