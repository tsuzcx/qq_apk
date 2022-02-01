package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import gjc;
import gjd;

public class DiscussionView
  extends BaseTroopView
  implements View.OnClickListener, OverScrollViewListener
{
  private static final String jdField_a_of_type_JavaLangString = "DiscussionView";
  static final int jdField_b_of_type_Int = 100;
  private static final String jdField_b_of_type_JavaLangString = "rec_last_discussion_list_refresh_time";
  static final int c = 102;
  static final int d = 1000;
  Button jdField_a_of_type_AndroidWidgetButton;
  public DiscussionListAdapter2 a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  private gjd jdField_a_of_type_Gjd = new gjd(this, null);
  public boolean d = false;
  View e;
  
  public DiscussionView(Context paramContext)
  {
    super(paramContext);
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).getLong("rec_last_discussion_list_refresh_time", 0L);
  }
  
  private void a(View paramView)
  {
    Utils.a(a(), paramView);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = new Intent(a(), ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  private boolean c()
  {
    if (NetworkUtil.f(a()))
    {
      this.d = true;
      ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).g(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
      return true;
    }
    return false;
  }
  
  private void k()
  {
    this.e = findViewById(2131298592);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.e.findViewById(2131298594));
    this.e.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298595));
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    View localView;
    if (this.c)
    {
      localView = localLayoutInflater.inflate(2130904390, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      a(localView);
      localView.findViewById(2131299461).setVisibility(8);
      EditText localEditText = (EditText)localView.findViewById(2131299473);
      localEditText.setFocusableInTouchMode(false);
      localEditText.setOnClickListener(this);
      localEditText.setCursorVisible(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      if (this.c) {
        break label256;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      return;
      localView = new View(getContext());
      localView.setBackgroundColor(getResources().getColor(2131427574));
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(16.0F, getResources())));
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView, null, false);
      break;
      label256:
      Utils.a(a(), this.jdField_a_of_type_ComTencentWidgetXListView);
      Utils.b(a(), this.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent(a(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 49);
    b(localIntent, 1300);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
  }
  
  protected Dialog a()
  {
    return new gjc(this, a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), 5);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).edit().putLong("rec_last_discussion_list_refresh_time", l).commit();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2130903515);
    k();
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 = new DiscussionListAdapter2(a(), this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2);
    a(this.jdField_a_of_type_Gjd);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 7;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      ForwardOperations localForwardOperations = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localForwardOperations != null) {
        localForwardOperations.a(paramDiscussionInfo.uin, 3000, "", paramDiscussionInfo.discussionName);
      }
      return;
    }
    a(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      a(102, 1000L);
    }
    return true;
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentWidgetXListView.B();
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.B();
      b(2131366939);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  protected void h()
  {
    super.h();
    b(this.jdField_a_of_type_Gjd);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299473: 
      j();
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.DiscussionView
 * JD-Core Version:    0.7.0.1
 */