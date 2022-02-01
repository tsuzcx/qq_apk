package com.tencent.open.agent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import lbh;
import lbi;

public class DeviceDeleteFriendChooserActivity
  extends BaseActivity
  implements View.OnClickListener, ImageLoader.ImageLoadListener, AdapterView.OnItemClickListener
{
  protected static final String a = "DeviceDeleteFriendChooserActivity";
  protected static final String b = "result_buddies_deleted";
  protected static final String c = "result_buddies_undeleted";
  protected final int a;
  protected Bundle a;
  public final Handler a;
  protected LayoutInflater a;
  protected TextView a;
  public PinnedDividerListView a;
  protected QQProgressDialog a;
  protected DeviceDeleteFriendChooserActivity.FriendListAdapter a;
  public ArrayList a;
  public boolean[] a;
  protected TextView b;
  public ArrayList b;
  protected TextView c;
  protected TextView d;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  
  public DeviceDeleteFriendChooserActivity()
  {
    this.jdField_a_of_type_Int = 10000;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = new lbh(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      LogUtility.c("DeviceDeleteFriendChooserActivity", "mParams is null return ");
    }
    for (;;)
    {
      return;
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
      this.e = this.jdField_a_of_type_AndroidOsBundle.getString("device_id");
      this.f = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
      this.g = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
      this.h = this.jdField_a_of_type_AndroidOsBundle.getString("vkey");
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("RESULT_BUDDIES_SELECTED");
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        LogUtility.e("DeviceDeleteFriendChooserActivity", "buddies is null return ");
        finish();
        return;
      }
      this.jdField_a_of_type_ArrayOfBoolean = new boolean[this.jdField_a_of_type_JavaUtilArrayList.size()];
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_ArrayOfBoolean[i] = false;
        i += 1;
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297357));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297358));
    this.c = ((TextView)super.findViewById(2131297360));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297348));
    this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131297502));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    if (this.jdField_a_of_type_ComTencentOpenAgentDeviceDeleteFriendChooserActivity$FriendListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentDeviceDeleteFriendChooserActivity$FriendListAdapter = new DeviceDeleteFriendChooserActivity.FriendListAdapter(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentDeviceDeleteFriendChooserActivity$FriendListAdapter);
    }
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (DeviceFriendListOpenFrame.ViewHolder)paramView.getTag();
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      paramInt -= this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m();
      if (paramInt >= 0) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      paramView = (Friend)this.jdField_a_of_type_ComTencentOpenAgentDeviceDeleteFriendChooserActivity$FriendListAdapter.getItem(paramInt);
    } while (paramView == null);
    if (paramAdapterView.a.isChecked())
    {
      paramAdapterView.a.setChecked(false);
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramView);
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = false;
      return;
    }
    paramAdapterView.a.setChecked(true);
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramView);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("DeviceDeleteFriendChooserActivity", "-->onImageLoaded() url = " + paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new lbi(this, paramString, paramBitmap));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362676);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    paramView = new HttpCgiAsyncTask("https://fusion.qq.com/cgi-bin/qzapps/op_bindlist", "GET", new DeviceDeleteFriendChooserActivity.SendUnBindListCallBack(this));
    Bundle localBundle = new Bundle();
    localBundle.putString("din", this.e);
    localBundle.putString("appid", this.jdField_d_of_type_JavaLangString);
    LogUtility.a("DeviceDeleteFriendChooserActivity", "mUnDeleteFriendList size=" + this.jdField_b_of_type_JavaUtilArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = this.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(((Friend)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a);
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localBundle.putString("unbindlist", localStringBuilder.toString());
    localBundle.putString("vkey", this.h);
    localBundle.putString("openid", this.f);
    paramView.a(localBundle);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setTheme(2131559078);
    super.setContentView(2130903270);
    b();
    c();
  }
  
  @Deprecated
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(0);
    this.c.setText(2131362631);
    this.c.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131362630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.DeviceDeleteFriendChooserActivity
 * JD-Core Version:    0.7.0.1
 */