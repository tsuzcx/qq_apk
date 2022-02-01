package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import gxb;
import gxc;
import gxd;
import java.util.ArrayList;
import java.util.List;

public class RenMaiQuanMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, View.OnTouchListener
{
  public int a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  public CircleManager a;
  IGroupObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new gxb(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public gxc a;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  
  public RenMaiQuanMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public RenMaiQuanMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public RenMaiQuanMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_Int);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(-1000, 1);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130904427);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298897));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427375);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130904390, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299474)).setText(2131366040);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299461)).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Gxc = new gxc(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gxc);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    this.jdField_a_of_type_Int = paramBundle.getInt("group_uin");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "人脉圈", this.jdField_a_of_type_JavaLangString);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, true);
    if (i != 0)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c(i);
      if (i != 0) {
        break label96;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f();
    }
    for (;;)
    {
      this.jdField_a_of_type_Gxc.notifyDataSetChanged();
      return;
      label96:
      if (i == -2) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131365730), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.getHeight());
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Gxc != null) {
      this.jdField_a_of_type_Gxc.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Gxc.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    gxd localgxd = (gxd)paramView.getTag();
    if ((localgxd != null) && (localgxd.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localgxd.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy != null))
    {
      CircleBuddy localCircleBuddy = localgxd.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy;
      if (localgxd.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localCircleBuddy.uin, this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy), 3, "-1");
        localgxd.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (!localgxd.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label121;
        }
        paramView.setContentDescription(localgxd.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "已选中,双击取消");
      }
    }
    return;
    label121:
    paramView.setContentDescription(localgxd.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "未选中,双击选中");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Mutichat_circle_search", 0, 0, "1", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RenMaiQuanMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */