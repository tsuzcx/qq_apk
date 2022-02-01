package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOConstants;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import csb;
import csc;
import csd;
import cse;

public abstract class AbstractImageListScene
  extends ImageScene
  implements AnimationLister
{
  int jdField_a_of_type_Int;
  protected Activity a;
  protected Dialog a;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected AbstractAnimationManager a;
  public AbstractImageAdapter a;
  protected AbstractImageListModel a;
  AnimationLister jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister = new cse(this);
  protected QQCustomDialog a;
  protected GestureSelectGridView a;
  protected boolean a;
  int b;
  protected ImageView b;
  protected TextView b;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  private int e;
  
  public AbstractImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
  }
  
  private void b(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation == 2) {}
    for (int i = 6;; i = 4)
    {
      AIOConstants.jdField_c_of_type_Int = i;
      this.jdField_a_of_type_Int = ((((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay().getWidth() - this.e * 2 - this.jdField_c_of_type_Int * (AIOConstants.jdField_c_of_type_Int - 1)) / AIOConstants.jdField_c_of_type_Int);
      return;
    }
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903832, null));
    if (paramViewGroup == null) {
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297001));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299107));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299769));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299771));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299772));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299770);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299773));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(AIOConstants.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.d);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.e, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.e, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(a());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(a());
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369003);
      p();
      q();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    }
  }
  
  private void o()
  {
    this.e = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493054);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493052);
    this.d = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493053);
    b(this.jdField_a_of_type_AndroidAppActivity.getResources().getConfiguration());
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369012);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new csb(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369010);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(a());
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new csc(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new csd(this));
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public Rect a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
    int j = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.b();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
    if (localView != null) {
      return AnimationUtils.a(localView);
    }
    return null;
  }
  
  public abstract View.OnClickListener a();
  
  public abstract AbstractImageAdapter a(Activity paramActivity, int paramInt);
  
  public abstract AdapterView.OnItemClickListener a();
  
  public abstract GestureSelectGridView.OnSelectListener a();
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    b(paramConfiguration);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(AIOConstants.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager = this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    o();
    c(paramViewGroup);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public boolean e()
  {
    i();
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130968583, 2130968584);
    return true;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = null;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = null;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131369004), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a()) }));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onstart");
    }
  }
  
  public void k()
  {
    super.k();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onStop");
    }
  }
  
  public abstract void l();
  
  public abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene
 * JD-Core Version:    0.7.0.1
 */