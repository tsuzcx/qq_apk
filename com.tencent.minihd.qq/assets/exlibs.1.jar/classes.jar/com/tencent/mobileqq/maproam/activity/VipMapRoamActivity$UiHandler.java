package com.tencent.mobileqq.maproam.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class VipMapRoamActivity$UiHandler
  extends Handler
{
  private WeakReference a;
  
  public VipMapRoamActivity$UiHandler(VipMapRoamActivity paramVipMapRoamActivity)
  {
    this.a = new WeakReference(paramVipMapRoamActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    VipMapRoamActivity localVipMapRoamActivity = (VipMapRoamActivity)this.a.get();
    if (localVipMapRoamActivity == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 100: 
        localVipMapRoamActivity.a.B();
      }
    } while (paramMessage.arg1 != 200);
    VipMapRoamActivity.a(localVipMapRoamActivity, 1, 2131366939);
    return;
    localVipMapRoamActivity.a.B();
    VipMapRoamActivity.a(localVipMapRoamActivity, 1, localVipMapRoamActivity.getString(2131367328));
    return;
    VipMapRoamActivity.a(localVipMapRoamActivity, (SosoInterface.SosoLbsInfo)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.activity.VipMapRoamActivity.UiHandler
 * JD-Core Version:    0.7.0.1
 */