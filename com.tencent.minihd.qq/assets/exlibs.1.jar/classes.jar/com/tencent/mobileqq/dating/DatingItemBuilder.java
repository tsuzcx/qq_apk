package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.widget.DatingFeedItemView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import icn;

public class DatingItemBuilder
  implements DatingItemActionListener
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  protected Context a;
  protected QQAppInterface a;
  protected FaceDecoder a;
  protected icn a;
  
  public DatingItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, FaceDecoder paramFaceDecoder)
  {
    if ((paramContext == null) || (paramFaceDecoder == null) || (paramQQAppInterface == null)) {
      throw new NullPointerException("context is null or decoder is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = (DatingFeedItemView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903903, paramViewGroup, false);
    paramViewGroup.setDatingItemActionListener(this);
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, DatingInfo paramDatingInfo, Object paramObject)
  {
    Drawable localDrawable;
    if ((paramView instanceof DatingFeedItemView))
    {
      paramView = (DatingFeedItemView)paramView;
      localDrawable = DatingUtil.a(String.valueOf(paramDatingInfo.publisherID), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
      if (!(paramObject instanceof Integer)) {
        break label67;
      }
    }
    label67:
    for (int i = ((Integer)paramObject).intValue();; i = 0)
    {
      paramView.a(paramInt1, paramInt2, paramDatingInfo, localDrawable, i);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, DatingInfo paramDatingInfo)
  {
    paramInt2 = 1005;
    if (paramDatingInfo == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      paramInt2 = 1004;
      paramInt1 = 0;
    }
    for (;;)
    {
      DatingDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, paramDatingInfo.datingId, paramInt1, paramInt2, paramDatingInfo, false, false);
      DatingUtil.a("detail item clicked : ", new Object[] { paramDatingInfo.datingId, Integer.valueOf(paramInt2) });
      return;
      if (paramInt1 == 1)
      {
        paramInt1 = 1;
      }
      else if (paramInt1 == 2)
      {
        paramInt1 = 2;
      }
      else
      {
        paramInt2 = 1050;
        paramInt1 = 0;
      }
    }
  }
  
  public void a(Drawable paramDrawable, View paramView)
  {
    if ((paramView instanceof DatingFeedItemView)) {
      ((DatingFeedItemView)paramView).a(paramDrawable);
    }
  }
  
  public void a(icn paramicn)
  {
    this.jdField_a_of_type_Icn = paramicn;
  }
  
  public void a(String paramString, View paramView)
  {
    paramString = DatingUtil.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
    if (paramString != null) {
      a(paramString, paramView);
    }
  }
  
  public boolean a(View paramView)
  {
    return (paramView != null) && ((paramView instanceof DatingFeedItemView));
  }
  
  public boolean a(String paramString, View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof DatingFeedItemView)) {
      bool = ((DatingFeedItemView)paramView).a(paramString);
    }
    return bool;
  }
  
  public void b(int paramInt1, int paramInt2, DatingInfo paramDatingInfo)
  {
    if (paramDatingInfo == null) {}
    do
    {
      return;
      if (paramInt1 == 0)
      {
        DatingUtil.a(this.jdField_a_of_type_AndroidContentContext, paramDatingInfo.publisherID, paramDatingInfo.datingId, paramDatingInfo.detailSigC2C, 17, paramDatingInfo.publisherNickname, paramDatingInfo.publisherAge, paramDatingInfo.publisherGender, paramDatingInfo.datingSubject, true);
        return;
      }
    } while (paramInt1 != 2);
    DatingUtil.a(this.jdField_a_of_type_AndroidContentContext, paramDatingInfo.publisherID, paramDatingInfo.datingId, paramDatingInfo.detailSigC2C, 19, paramDatingInfo.publisherNickname, paramDatingInfo.publisherAge, paramDatingInfo.publisherGender, paramDatingInfo.datingSubject, true);
  }
  
  public void c(int paramInt1, int paramInt2, DatingInfo paramDatingInfo)
  {
    if (paramDatingInfo == null) {
      return;
    }
    if (paramDatingInfo.datingSubject != 5)
    {
      paramDatingInfo = paramDatingInfo.addressCompanyUrl;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004941", "0X8004941", 0, 0, "", "", "", "");
    }
    for (paramInt1 = 2131369812;; paramInt1 = 2131369813)
    {
      if (!TextUtils.isEmpty(paramDatingInfo)) {
        break label115;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof DatingBaseActivity)) {
        break;
      }
      ((DatingBaseActivity)this.jdField_a_of_type_AndroidContentContext).b(paramInt1);
      return;
      paramDatingInfo = paramDatingInfo.placeUrl;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F39", "0X8004F39", 0, 0, "", "", "", "");
    }
    label115:
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDatingInfo);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void d(int paramInt1, int paramInt2, DatingInfo paramDatingInfo)
  {
    if ((paramDatingInfo != null) && (this.jdField_a_of_type_Icn != null))
    {
      if (paramInt1 != 1) {
        break label31;
      }
      this.jdField_a_of_type_Icn.c(0, paramDatingInfo.datingId);
    }
    label31:
    while (paramInt1 != 2) {
      return;
    }
    this.jdField_a_of_type_Icn.c(1, paramDatingInfo.datingId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingItemBuilder
 * JD-Core Version:    0.7.0.1
 */