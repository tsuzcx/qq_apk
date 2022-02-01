package com.tencent.mobileqq.phonecontact;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class ContactBindObserver
  implements BusinessObserver
{
  public static final String a = "k_result";
  public static final String b = "k_uin";
  
  protected String a(int paramInt)
  {
    if (paramInt == 217) {
      return "手机号码不正确，请确认！";
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return "请求频率太高，请稍后重试！";
    }
    if (paramInt == 224) {
      return "所属地区运营商暂未支持开通服务";
    }
    if (paramInt == 223) {
      return "绑定失败，请稍后再试";
    }
    return "请求失败，请稍候重试。";
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void d(boolean paramBoolean) {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindObserver
 * JD-Core Version:    0.7.0.1
 */