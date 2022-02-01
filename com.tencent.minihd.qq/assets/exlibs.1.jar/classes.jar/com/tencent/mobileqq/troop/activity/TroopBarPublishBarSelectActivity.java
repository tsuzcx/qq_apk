package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import kgg;
import kgj;
import kgk;
import kgl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishBarSelectActivity
  extends IphoneTitleBarActivity
  implements HttpWebCgiAsyncTask.Callback, AdapterView.OnItemClickListener
{
  protected static final int a = 1001;
  public static final String a = "key_selected_item";
  public static final String b = "key_media_data";
  public static final String c = "key_drop_media_data";
  public long a;
  protected Drawable a;
  public Handler a;
  protected View a;
  protected TextView a;
  public TroopBarPublishBarSelectActivity.MyBarListAdapter a;
  public TroopBarMyBar a;
  protected PullRefreshHeader a;
  public XListView a;
  protected ArrayList a;
  protected boolean a;
  public int b;
  protected View b;
  protected int c = 0;
  
  public TroopBarPublishBarSelectActivity()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new kgj(this);
  }
  
  protected static final String a(int paramInt)
  {
    if (paramInt == 1) {
      return "语音";
    }
    if (paramInt == 4) {
      return "音乐";
    }
    if (paramInt == 2) {
      return "录音";
    }
    return "富媒体";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new kgg(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  public final void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(true);
    TroopBarUtils.a(paramBaseActivity, new Bundle(), "https://xiaoqu.qq.com/cgi-bin/bar/mybarlist", 5, new Bundle(), paramCallback);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt < 1) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    do
    {
      do
      {
        return;
        paramAdapterView = (TroopBarMyBar)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
        if (paramAdapterView.l == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopBar", 2, "用户点击了不可选的部落!!!");
      return;
    } while ((this.jdField_b_of_type_Int > 0) && (a(paramAdapterView)));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = paramAdapterView;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar);
    setResult(-1, paramAdapterView);
    finish();
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {
      try
      {
        paramBundle = paramJSONObject.getJSONArray("mybars");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        for (;;)
        {
          this.c = paramBundle.length();
          paramInt = 0;
          while (paramInt < this.c)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarMyBar(paramBundle.getJSONObject(paramInt)));
            paramInt += 1;
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        b(false);
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramBundle.toString());
        }
        if (paramJSONObject.optInt("isend", -1) != 1)
        {
          paramInt = paramJSONObject.optInt("retcode", -1);
          if (paramInt == 0) {
            break label220;
          }
          QQToast.a(this, 1, getString(2131363871, new Object[] { Integer.valueOf(paramInt) }), 0).b(getTitleBarHeight());
        }
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363891, new Object[] { Integer.valueOf(this.c) }));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
      continue;
      label220:
      QQToast.a(this, 1, getString(2131363871, new Object[] { Integer.valueOf(paramJSONObject.optInt("errno", -1)) }), 0).b(getTitleBarHeight());
      continue;
      QQToast.a(this, 1, 2131363870, 0).b(getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298154);
    if (paramBoolean)
    {
      localTextView.setText("全部加载完成");
      return;
    }
    localTextView.setText(2131366936);
  }
  
  protected boolean a(TroopBarMyBar paramTroopBarMyBar)
  {
    boolean bool = false;
    String str;
    if ((paramTroopBarMyBar.m & this.jdField_b_of_type_Int) != this.jdField_b_of_type_Int)
    {
      str = a(this.jdField_b_of_type_Int);
      str = getString(2131364105, new Object[] { str, str });
    }
    for (;;)
    {
      if (str != null)
      {
        DialogUtil.a(this, 230, null, str, 2131365736, 2131365117, new kgk(this, paramTroopBarMyBar), new kgl(this)).show();
        bool = true;
      }
      return bool;
      if ((paramTroopBarMyBar.n & this.jdField_b_of_type_Int) == this.jdField_b_of_type_Int)
      {
        str = a(this.jdField_b_of_type_Int);
        str = getString(2131364104, new Object[] { str, str });
      }
      else
      {
        str = null;
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      if ((this.centerView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838130);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    while ((this.centerView == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return;
    }
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getResources();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837687);
    int i = paramBundle.getDimensionPixelSize(2131493239);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    i = paramBundle.getDimensionPixelSize(2131493238);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838126);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    a();
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter = new TroopBarPublishBarSelectActivity.MyBarListAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter);
    this.jdField_a_of_type_Boolean = false;
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = ((TroopBarMyBar)localIntent.getParcelableExtra("key_selected_item"));
    this.jdField_b_of_type_Int = localIntent.getIntExtra("key_media_data", -1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle.getString(2131363891, new Object[] { Integer.valueOf(this.c) }));
    a(this.app, this, this);
    setTitle(2131363912);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
    for (paramBundle = "0";; paramBundle = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "exp_tribe", paramBundle, "0", "", "");
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity
 * JD-Core Version:    0.7.0.1
 */