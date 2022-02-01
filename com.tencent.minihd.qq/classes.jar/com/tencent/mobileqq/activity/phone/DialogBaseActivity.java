package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import gqu;
import gqv;
import gqw;
import gqx;
import gqy;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  public static final int h = 1;
  public static final int i = 2;
  static final int j = 1;
  static final int k = 2;
  private View jdField_a_of_type_AndroidViewView;
  public PhoneContactManager a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private gqy jdField_a_of_type_Gqy;
  public QQProgressDialog b;
  
  public void a()
  {
    this.jdField_a_of_type_Gqy.removeMessages(1);
    if (this.b != null)
    {
      this.b.cancel();
      this.b = null;
    }
  }
  
  public void a(int paramInt)
  {
    if ((!isFinishing()) && (this.b == null))
    {
      this.b = new QQProgressDialog(this, getTitleBarHeight());
      this.b.setOnDismissListener(new gqv(this));
      this.b.b(paramInt);
      this.b.setCanceledOnTouchOutside(false);
      this.b.show();
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Gqy.obtainMessage(1, paramInt, 0);
    this.jdField_a_of_type_Gqy.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 231, getString(2131362562), getString(2131362561), 2131362563, 2131362564, paramOnClickListener, new gqw(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new gqx(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, 0, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      DialogUtil.a(this, 231, paramString1, paramString2, new gqu(this), null).show();
    }
  }
  
  public void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (!isFinishing())
    {
      b(paramInt);
      this.jdField_a_of_type_Gqy.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Gqy = new gqy(this);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.app.getManager(10));
    return true;
  }
  
  public View findViewById(int paramInt)
  {
    View localView1 = null;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = super.findViewById(paramInt);
    }
    return localView2;
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = setContentViewB(paramInt);
  }
  
  protected String setLastActivityName()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */