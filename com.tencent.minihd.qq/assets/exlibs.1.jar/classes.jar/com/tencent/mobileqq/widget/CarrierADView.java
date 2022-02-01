package com.tencent.mobileqq.widget;

import EncounterSvc.EntranceContent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.IFlingSwitch;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.nearby.entrance.nearby_entrance_common.NearbyEntranceContent;

public class CarrierADView
  extends ADView
  implements Handler.Callback
{
  public static final String a = "CarrierADView";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private IFlingSwitch jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch;
  
  public CarrierADView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CarrierADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a();
    }
    return i;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    }
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
        return;
      }
      catch (Exception paramView) {}
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0)).getChildAt(0));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getWidth() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a() + 1);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3400);
      return false;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch != null)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label56;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch.a(false);
      c();
      if (this.jdField_a_of_type_AndroidViewMotionEvent != null) {
        this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    label56:
    do
    {
      return false;
      if (i == 2)
      {
        if (this.jdField_a_of_type_AndroidViewMotionEvent != null)
        {
          float f1 = this.jdField_a_of_type_AndroidViewMotionEvent.getX();
          float f2 = paramMotionEvent.getX();
          if (Math.abs((this.jdField_a_of_type_AndroidViewMotionEvent.getY() - paramMotionEvent.getY()) / (f1 - f2)) < 0.5F) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        return false;
      }
    } while ((i != 1) && (i != 3));
    this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch.a(true);
    b();
    getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void setCarrierData(List paramList, int paramInt, CarrierHelper paramCarrierHelper)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this);
    }
    a();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CarrierADView", 2, "carrier List is null or empty");
      }
      return;
    }
    while (paramInt > 0)
    {
      paramList.add(paramList.get(0));
      paramList.remove(0);
      paramInt -= 1;
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt < paramList.size())
      {
        EntranceContent localEntranceContent = (EntranceContent)paramList.get(paramInt);
        try
        {
          nearby_entrance_common.NearbyEntranceContent localNearbyEntranceContent = new nearby_entrance_common.NearbyEntranceContent();
          localNearbyEntranceContent.mergeFrom(localEntranceContent.content_buff);
          View localView = paramCarrierHelper.a();
          paramCarrierHelper.a(localView, localEntranceContent.type, localNearbyEntranceContent);
          b(localView, paramInt);
          paramInt += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CarrierADView", 2, localException.toString());
            }
          }
        }
      }
    }
    b();
  }
  
  public void setFlingSwitch(IFlingSwitch paramIFlingSwitch)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingIFlingSwitch = paramIFlingSwitch;
  }
  
  public void setVisibility(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 4)) {
      c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setVisibility(paramInt);
      }
      super.setVisibility(paramInt);
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CarrierADView
 * JD-Core Version:    0.7.0.1
 */