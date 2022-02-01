package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XExpandableListView;
import gwx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FriendTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  public static final int a = -1;
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter;
  public XExpandableListView a;
  List jdField_a_of_type_JavaUtilList;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private RelativeLayout d;
  private RelativeLayout e;
  
  public FriendTeamListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)findViewById(2131298897));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setChildDivider(null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130904402, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localLinearLayout.findViewById(2131302088));
    this.b = ((RelativeLayout)localLinearLayout.findViewById(2131302089));
    this.c = ((RelativeLayout)localLinearLayout.findViewById(2131302091));
    this.d = ((RelativeLayout)localLinearLayout.findViewById(2131302093));
    this.e = ((RelativeLayout)localLinearLayout.findViewById(2131302095));
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131302087);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      ((LinearLayout.LayoutParams)localLinearLayout.findViewById(2131302097).getLayoutParams()).topMargin = 0;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.b.setContentDescription("人脉圈,按钮");
      this.c.setContentDescription("通讯录,按钮");
      this.d.setContentDescription("群,按钮");
      this.e.setContentDescription("讨论组,按钮");
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a(localLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(this.jdField_a_of_type_ComTencentWidgetXExpandableListView);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131302086));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131367982));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localTextView.setVisibility(8);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Boolean)
      {
        this.b.setEnabled(false);
        label326:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c) {
          break label394;
        }
        this.c.setEnabled(false);
        label344:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d) {
          break label443;
        }
        this.d.setEnabled(false);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) {
          break label454;
        }
        this.e.setEnabled(false);
        break;
        this.b.setOnClickListener(this);
        break label326;
        label394:
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("select_member_contacts_flag", 0) == 1)
        {
          this.c.setOnClickListener(this);
          break label344;
        }
        this.c.setEnabled(false);
        break label344;
        label443:
        this.d.setOnClickListener(this);
      }
      label454:
      this.e.setOnClickListener(this);
    }
  }
  
  public String a()
  {
    return null;
  }
  
  public List a()
  {
    Object localObject3 = null;
    int i = 1;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilList == null) && ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8) != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f) {
        break label238;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k) {
        break label233;
      }
      bool = true;
      localObject1 = SearchResultDialog.a((Context)localObject1, (QQAppInterface)localObject2, 38654705664L, 0, bool, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject3 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!((ContactSearchableFriend)((Iterator)localObject3).next()).a().uin.equals(localObject2));
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((Friends)localObject2).groupid = 0;
        ((Friends)localObject2).name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        ((List)localObject1).add(new ContactSearchableFriend(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject2, "我的好友", 0L, 38654705664L));
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
      return this.jdField_a_of_type_JavaUtilList;
      label233:
      bool = false;
      break;
      label238:
      List localList = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 38654705664L, 0, true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) {}
      for (localObject1 = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 30064771072L, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);; localObject1 = null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c) {}
        for (localObject2 = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);; localObject2 = null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Boolean) {
            localObject3 = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
          }
          if (localList != null) {}
          for (int j = localList.size() + 0;; j = 0)
          {
            i = j;
            if (localObject1 != null) {
              i = j + ((List)localObject1).size();
            }
            j = i;
            if (localObject2 != null) {
              j = i + ((List)localObject2).size();
            }
            i = j;
            if (localObject3 != null) {
              i = j + ((List)localObject3).size();
            }
            if (i <= 0) {
              break;
            }
            this.jdField_a_of_type_JavaUtilList = new ArrayList(i);
            if (localList != null) {
              this.jdField_a_of_type_JavaUtilList.addAll(localList);
            }
            if (localObject1 != null) {
              this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
            }
            if (localObject2 != null) {
              this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
            }
            if (localObject3 == null) {
              break;
            }
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
            break;
          }
        }
      }
      i = 0;
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130904411);
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter = new SelectMemberBuddyListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXExpandableListView);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.post(new gwx(this));
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131368403), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.G);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "0", "", "", "");
    }
    do
    {
      return;
      if (paramView == this.c)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
        return;
      }
      if (paramView == this.d)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "2", "", "", "");
        return;
      }
      if (paramView == this.e)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(4);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "3", "", "", "");
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A7", "0X80041A7", 0, 0, "", "", "", "");
  }
  
  public void setSearchBarVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */