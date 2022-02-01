package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import fgl;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  public GroupCatalogBean a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private fgl jdField_a_of_type_Fgl;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  private String b;
  
  private void b()
  {
    Object localObject = getIntent();
    this.b = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(this).a();
    if ((localGroupCatalogBean != null) && (this.b.equals(localGroupCatalogBean.b)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = localGroupCatalogBean;
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("id");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label113;
      }
      this.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this).a();
    }
    for (;;)
    {
      CacheManager.a(CommonDataAdapter.a().a());
      a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = GroupCatalogTool.a(this).a(this, this.b);
      break;
      label113:
      this.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this).a(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = (GroupCatalogBean)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) {
          setTitle(((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void c()
  {
    setContentBackgroundResource(2130837687);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131302323));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Fgl = new fgl(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Fgl);
  }
  
  public void a()
  {
    GroupCatalogTool.a(this).a(new TroopClassChoiceActivity.GetClassChoiceCallBack(this), this);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (GroupCatalogBean)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((paramAdapterView.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdapterView.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!paramAdapterView.b.equals("10015")) && (!paramAdapterView.b.equals("10017")))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.b);
      paramView.putExtra("troopGroupClassExt", this.b);
      startActivityForResult(paramView, 11);
      return;
    }
    GroupCatalogTool.a(this).a(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.b);
    setResult(-1, paramView);
    finish();
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("id");
    if ((this.jdField_a_of_type_JavaLangString != null) && (str != null)) {
      return this.jdField_a_of_type_JavaLangString.equals(str);
    }
    if (this.jdField_a_of_type_JavaLangString == null) {
      return false;
    }
    return super.dataEquals(paramIntent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904486);
    setTitle(2131366341);
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */