package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.util.WeakReferenceHandler;

public class NearbyTroopsBaseView
  extends FrameLayout
{
  private View a;
  public NearbyTroopsBaseView.INearbyTroopContext a;
  protected int b;
  protected boolean b;
  public boolean c = false;
  
  public NearbyTroopsBaseView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
  }
  
  protected View a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
    }
    return findViewById(paramInt);
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
    setBackgroundDrawable(null);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  protected void a(Intent paramIntent) {}
  
  protected final void a(Intent paramIntent, int paramInt)
  {
    b(paramIntent, paramInt);
  }
  
  protected void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext = paramINearbyTroopContext;
  }
  
  protected final void a(String paramString)
  {
    if (!b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(paramString);
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b()
  {
    this.c = true;
  }
  
  protected final void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void b(Intent paramIntent)
  {
    b(paramIntent, 0);
  }
  
  protected final void b(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().startActivityForResult(paramIntent, paramInt);
  }
  
  protected final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void g()
  {
    this.c = false;
  }
  
  protected void h()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void i() {}
  
  protected void j()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().finish();
  }
  
  public void setUrl(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView
 * JD-Core Version:    0.7.0.1
 */