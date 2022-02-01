package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import gvp;

public class RecentOptionBar
  extends FrameLayout
{
  protected static final int[] a;
  protected static final int[] b = { 2130838205, 2130838203, 2130838206, 2130838202 };
  protected static final int[] c = { 2131368584, 2131368583, 2131368588, 2131368587 };
  protected static final int[] d = { 2131362028, 2131362025, 2131362026, 2131362030, 2131362029 };
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gvp(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131297335, 2131297336, 2131297337, 2131297338, 2131299880 };
  }
  
  public RecentOptionBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static RecentOptionBar a(BaseActivity paramBaseActivity)
  {
    return (RecentOptionBar)LayoutInflater.from(paramBaseActivity).inflate(2130903870, null);
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", paramActivity.getString(2131368583));
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131365737));
    localIntent.putExtra("param_done_button_highlight_wording", paramActivity.getString(2131367559));
    localIntent.putExtra("param_entrance", 10);
    localIntent.putExtra("param_max", 49);
    localIntent.setFlags(603979776);
    localIntent.putExtra("display_like_dialog", true);
    paramActivity.getParent().startActivityForResult(localIntent, 1400);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368387));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368388));
    localIntent.putExtra("param_max", 49);
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130968593, 2130968594);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    int i = 0;
    if (i < jdField_a_of_type_ArrayOfInt.length)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(jdField_a_of_type_ArrayOfInt[i]);
      if (localLinearLayout == null) {}
      for (;;)
      {
        i += 1;
        break;
        localLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        Object localObject = (ImageView)localLinearLayout.findViewById(2131297339);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(b[i]);
        }
        localObject = (TextView)localLinearLayout.findViewById(2131297340);
        if (localObject != null) {
          ((TextView)localObject).setText(c[i]);
        }
        localLinearLayout.setContentDescription(paramBaseActivity.getString(d[i]));
      }
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public void c() {}
  
  public void d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, LiteActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800483A", "0X800483A", 0, 0, "", "", "", "");
  }
  
  protected void f()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368583));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131365737));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367559));
    localIntent.putExtra("param_entrance", 10);
    localIntent.putExtra("param_max", 49);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1400);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130968593, 2130968594);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.jdField_a_of_type_Int != i)
    {
      this.jdField_a_of_type_Int = i;
      i = (this.jdField_a_of_type_Int - getResources().getDimensionPixelSize(2131493330) * jdField_a_of_type_ArrayOfInt.length) / (jdField_a_of_type_ArrayOfInt.length * 2 - 2);
      int j = getResources().getDimensionPixelSize(2131493331);
      Object localObject = findViewById(2131298498);
      if (i < j)
      {
        ((View)localObject).setVisibility(0);
        i = j;
        j = 0;
        label84:
        if (j >= jdField_a_of_type_ArrayOfInt.length) {
          break label176;
        }
        localObject = (LinearLayout)findViewById(jdField_a_of_type_ArrayOfInt[j]);
        if (j != 0) {
          break label141;
        }
        ((LinearLayout)localObject).setPadding(0, 0, 0, i);
      }
      for (;;)
      {
        j += 1;
        break label84;
        ((View)localObject).setVisibility(8);
        break;
        label141:
        if (j == jdField_a_of_type_ArrayOfInt.length - 1) {
          ((LinearLayout)localObject).setPadding(0, i, 0, 0);
        } else {
          ((LinearLayout)localObject).setPadding(0, i, 0, i);
        }
      }
    }
    label176:
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptionBar
 * JD-Core Version:    0.7.0.1
 */