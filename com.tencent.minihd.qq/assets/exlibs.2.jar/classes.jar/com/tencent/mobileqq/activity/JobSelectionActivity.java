package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import efc;

public class JobSelectionActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  public static final String a = "param_id";
  public static final String b = "param_tag";
  public static final String c = "param_name";
  public static final String d = "param_tag_bg";
  public static final String e = "param_need_no_limit";
  private int jdField_a_of_type_Int;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private efc jdField_a_of_type_Efc;
  private boolean jdField_a_of_type_Boolean = false;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903931);
    setTitle(2131365803);
    setLeftViewName(2131365114);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("param_id", -1);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("param_need_no_limit", false);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131297468));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Efc = new efc(this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Efc);
    return true;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = (paramInt + 1))
    {
      this.jdField_a_of_type_Efc.notifyDataSetChanged();
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("param_id", this.jdField_a_of_type_Int);
      paramAdapterView.putExtra("param_tag", com.tencent.mobileqq.util.NearbyProfileUtil.e[this.jdField_a_of_type_Int]);
      paramAdapterView.putExtra("param_name", com.tencent.mobileqq.util.NearbyProfileUtil.d[this.jdField_a_of_type_Int]);
      paramAdapterView.putExtra("param_tag_bg", com.tencent.mobileqq.util.NearbyProfileUtil.a[this.jdField_a_of_type_Int]);
      setResult(-1, paramAdapterView);
      finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity
 * JD-Core Version:    0.7.0.1
 */