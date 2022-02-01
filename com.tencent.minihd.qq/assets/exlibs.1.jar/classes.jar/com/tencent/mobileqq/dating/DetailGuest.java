package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.widget.CustomTabBarView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import ico;
import icp;
import icq;
import icr;
import ics;

public class DetailGuest
  extends DetailModel
  implements DialogInterface.OnClickListener
{
  protected DetailGuest(DatingDetailActivity paramDatingDetailActivity, DatingInfo paramDatingInfo, CustomTabBarView paramCustomTabBarView)
  {
    super(paramDatingDetailActivity, 0, paramDatingInfo, paramCustomTabBarView);
  }
  
  protected void a(int paramInt, Object paramObject)
  {
    if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.e();
      this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApply = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject == 5)
      {
        paramInt = 2131369831;
        if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null) {
          break label215;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject != 5) {
          break label202;
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369833);
      }
      for (;;)
      {
        if (paramObject != null) {
          AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailPubUin), paramObject, 1010, false, false);
        }
        b();
        a(3, 4, 2131369709, 0, true, 2130838090, 2131427970);
        f();
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, paramInt, 2131365736, 2131369823, new ico(this), new icp(this));
          this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new icq(this));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.isResume()) && (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.isFinishing())) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return;
        paramInt = 2131369822;
        break;
        label202:
        paramObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369784);
        continue;
        label215:
        paramObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.b(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject);
      }
    }
    if (paramInt == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(1, "已放弃报名该约会", 0);
      this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApply = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null) {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailPubUin), this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.c(), 1010, false, false);
      }
      b();
      a(4, 3, 2131369708, 2130840159, true, 2130838085, 2131427966);
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.e();
  }
  
  public void a(DatingStranger paramDatingStranger) {}
  
  protected void b(int paramInt, Object paramObject)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId)) {}
    label213:
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        default: 
          super.b(paramInt, paramObject);
          return;
        case 2: 
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004943");
          if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailCanAio != 1)
          {
            String str = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailAioTip;
            paramObject = str;
            if (TextUtils.isEmpty(str)) {
              paramObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369806);
            }
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(2, paramObject, 0);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject == 5) {
            if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null) {
              break label213;
            }
          }
          for (paramObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369832);; paramObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a())
          {
            AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailPubUin), paramObject, 1010);
            DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailPubUin), this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailSigC2C, 1);
            return;
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApply == 1);
      if (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a())
      {
        DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, "0X800500E");
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 2131369827, 0, 2131365737, null, new icr(this));
          this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ics(this));
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.c()))
      {
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 230, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369814), this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369815), 0, 2131365737, this, null).show();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004948");
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingGender != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingGender != this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.b()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingGender == 1) {}
        for (paramInt = 2131369771;; paramInt = 2131369772)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b(paramInt);
          return;
        }
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getApplicationContext()))
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b(2131369795);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler.b(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, 0);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(0, 2131369794, 1000);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b(2131369796);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingApply == 0);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b(2131369799);
    return;
    DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailSigC2C, 18, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherAge, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherGender, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject, true);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.b(false);
      }
      b(3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DetailGuest
 * JD-Core Version:    0.7.0.1
 */