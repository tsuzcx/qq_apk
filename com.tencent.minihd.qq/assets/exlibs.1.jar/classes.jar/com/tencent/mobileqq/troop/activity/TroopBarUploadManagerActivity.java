package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import kgv;
import kgw;
import kgx;
import kgy;
import kgz;
import kha;
import khb;
import khc;
import khd;

public class TroopBarUploadManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, INetInfoHandler, SlideDetectListView.OnSlideListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "TroopBarUploadManagerActivity";
  private static final int jdField_b_of_type_Int = 2;
  public static final String b = "#65D521";
  private static final int jdField_c_of_type_Int = 3;
  private static final long jdField_c_of_type_Long = 2000L;
  public static final String c = "#787878";
  private static final int d = 4;
  public static final String d = "#F76249";
  public static final String e = "#787878";
  private long jdField_a_of_type_Long = 0L;
  public Handler a;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new kgv(this);
  public TroopBarUploadTaskManager a;
  public QQCustomDialog a;
  ShaderAnimLayout jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout;
  public SlideDetectListView a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public khd a;
  private long jdField_b_of_type_Long;
  
  public TroopBarUploadManagerActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
    this.jdField_a_of_type_Khd = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager = TroopBarUploadTaskManager.a();
    this.jdField_a_of_type_AndroidOsHandler = new kgw(this);
    this.b = 9223372036854775807L;
  }
  
  private void a(String paramString)
  {
    ThreadManager.a(new kgx(this, paramString));
  }
  
  private void b()
  {
    ThreadManager.a(new kgy(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298865));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
    setLeftViewName(2131364110);
    setTitle(2131364109);
  }
  
  private void d()
  {
    ThreadManager.a(new khb(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
      Object localObject = new kha(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364121, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131364103, (DialogInterface.OnClickListener)localObject);
      localObject = getString(2131364120);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131364076);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public void a(TroopBarUploadItemEntity paramTroopBarUploadItemEntity)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    kgz localkgz = new kgz(this, paramTroopBarUploadItemEntity);
    localQQCustomDialog.setTitle(2131364114);
    localQQCustomDialog.setMessage(getString(2131364116, new Object[] { paramTroopBarUploadItemEntity.mTitle }));
    localQQCustomDialog.setPositiveButton(2131364114, localkgz);
    localQQCustomDialog.setNegativeButton(2131364079, localkgz);
    localQQCustomDialog.show();
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramView = (ShaderAnimLayout)paramView.findViewById(2131298863);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramView.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = paramView;
  }
  
  public void b(TroopBarUploadItemEntity paramTroopBarUploadItemEntity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.d();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.a(2131366672, 1);
    localActionSheet.e(2131365736);
    localActionSheet.a(new khc(this, paramTroopBarUploadItemEntity, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    ((ShaderAnimLayout)paramView.findViewById(2131298863)).d();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903576);
    b();
    c();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = (Integer)paramView.getTag();
    } while (this.jdField_a_of_type_Khd.getItem(paramView.intValue()) == null);
    b((TroopBarUploadItemEntity)this.jdField_a_of_type_Khd.getItem(paramView.intValue()));
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi() {}
  
  public void onNetNone2Mobile()
  {
    this.b = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarUploadManagerActivity", 2, "wifi2none to none2mobile = " + (this.b - this.jdField_a_of_type_Long));
    }
    if (this.b - this.jdField_a_of_type_Long < 2000L) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
  
  public void onNetNone2Wifi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarUploadManagerActivity", 2, "time" + System.currentTimeMillis());
    }
  }
  
  public void onNetWifi2Mobile()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void onNetWifi2None()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("TroopBarUploadManagerActivity", 2, "time" + System.currentTimeMillis());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity
 * JD-Core Version:    0.7.0.1
 */