package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.OnTroopListClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import gjw;
import gjx;
import java.util.ArrayList;
import java.util.List;

public class ShowExternalTroopListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ShowExternalTroopListAdapter.OnTroopListClickListener, OverScrollViewListener
{
  public static final String a = "isHost";
  static final int b = 99;
  public static final String b = "dest_uin_str";
  static final int c = 100;
  public static final String c = "is_from_show_ext_troop_list";
  static final int jdField_d_of_type_Int = 101;
  static final int jdField_e_of_type_Int = 102;
  private static final String jdField_e_of_type_JavaLangString = "rec_last_ext_show_troop_list_refresh_time";
  static final int f = 103;
  static final int g = 1000;
  public int a;
  public Handler a;
  protected Button a;
  public RelativeLayout a;
  protected TextView a;
  public ShowExternalTroopListAdapter a;
  public TroopManager a;
  protected TroopObserver a;
  public PullRefreshHeader a;
  protected RedDotTextView a;
  public XListView a;
  public List a;
  protected boolean a;
  protected TextView b;
  public boolean b;
  protected TextView c;
  String jdField_d_of_type_JavaLangString;
  
  public ShowExternalTroopListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.d = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gjw(this);
    this.jdField_a_of_type_AndroidOsHandler = new gjx(this);
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).getLong("rec_last_ext_show_troop_list_refresh_time", 0L);
  }
  
  private boolean a()
  {
    if (NetworkUtil.f(getActivity()))
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
      if (this.jdField_a_of_type_Boolean) {
        localTroopHandler.a();
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = true;
        return true;
        localTroopHandler.a(this.d, 0, 0);
      }
    }
    return false;
  }
  
  private void b()
  {
    setContentViewNoTitle(2130903708);
    setTitle(2131363980);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Boolean = localIntent.getExtras().getBoolean("isHost");
    String str2 = localIntent.getExtras().getString("leftViewText");
    String str1 = str2;
    if (str2 == null) {
      str1 = getString(2131366374);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)findViewById(2131297360));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setContentDescription(getString(2131363979));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(2131363978);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299337));
      this.c = ((TextView)findViewById(2131299339));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299372));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299371));
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130842234);
      if (!this.jdField_a_of_type_Boolean) {
        this.d = localIntent.getExtras().getString("dest_uin_str");
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter = new ShowExternalTroopListAdapter(getActivity(), this.app, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Boolean, this.d);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        if (!NetworkUtil.f(this)) {
          this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(new ArrayList());
        }
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.notifyDataSetChanged();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c().size() != 0)) {
        break label422;
      }
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
      break;
      label422:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).edit().putLong("rec_last_ext_show_troop_list_refresh_time", l).commit();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    if (this.jdField_a_of_type_Boolean)
    {
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 2130839509, 0, 0);
      this.c.setText(2131363983);
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "exp_blank", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 2130839495, 0, 0);
      this.c.setText(2131363985);
      QQToast.a(this, 1, getString(2131363986), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    Bundle localBundle;
    Activity localActivity;
    if (paramTroopInfo != null)
    {
      localBundle = TroopInfoActivity.a(paramTroopInfo.troopuin, 18);
      localActivity = getActivity();
      if (!this.jdField_a_of_type_Boolean) {
        break label81;
      }
    }
    label81:
    for (paramInt = 1;; paramInt = 2)
    {
      ChatSettingForTroop.a(localActivity, localBundle, paramInt);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramTroopInfo.troopuin, "1", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramTroopInfo.troopuin, "0", "", "");
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if ((!a()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 1000L);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(50));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.b();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c().size() == 0))
      {
        a();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter);
        this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a();
      }
    }
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
    case 2131297360: 
    case 2131299372: 
      do
      {
        return;
        paramView = new Intent();
        paramView.putExtra("onlyOneSegement", true);
        paramView.putExtra("_key_mode", 0);
        paramView.putExtra("key_tab_mode", 1);
        paramView.putExtra("is_from_show_ext_troop_list", true);
        paramView.setClass(this, TroopActivity.class);
        startActivity(paramView);
        if (i == 2131297360)
        {
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_mana", 0, 0, "", "", "", "");
          return;
        }
      } while (i != 2131299372);
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_set", 0, 0, "", "", "", "");
      return;
    }
    onBackEvent2();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity
 * JD-Core Version:    0.7.0.1
 */