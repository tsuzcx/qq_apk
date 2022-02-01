package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.tencentmap.mapsdk.map.MapView;
import kmt;
import kmu;

public class AutoLocationMapView
  extends MapView
{
  static final int a = 1;
  public Handler a;
  public AutoLocationMapView.AutoLocationCallback a;
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new kmt(this);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new kmt(this);
  }
  
  public void a(String paramString, AutoLocationMapView.AutoLocationCallback paramAutoLocationCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView$AutoLocationCallback = paramAutoLocationCallback;
    SosoInterface.a(new kmu(this, 0, true, 300000L, false, false, "AutoLocationMapView"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView
 * JD-Core Version:    0.7.0.1
 */