package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.XListView;
import gwo;
import gwp;
import gwq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DiscussionListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private gwp jdField_a_of_type_Gwp;
  public ArrayList a;
  
  public DiscussionListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public DiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject1 != null) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((ContactFacade)localObject1).a("-1004").clone());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    localObject1 = new HashMap();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getString(2131366029);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getString(2131366032);
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      Object localObject2 = localFriendManager.a(localDiscussionInfo.uin);
      if ((localObject2 != null) && (((List)localObject2).size() == 1) && (((DiscussionMemberInfo)((List)localObject2).get(0)).memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
      else
      {
        long l = 0L;
        localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, localDiscussionInfo);
        String str3 = ChnToSpell.a((String)localObject2, 1);
        if ((((String)localObject2).matches(str1)) || (((String)localObject2).contains(str2))) {
          l = 65536L;
        }
        if ((str3 == null) || (str3.length() == 0)) {
          l |= 0xFFFF;
        }
        for (;;)
        {
          ((HashMap)localObject1).put(localDiscussionInfo.uin, Long.valueOf(l));
          break;
          if (StringUtil.c(str3.charAt(0))) {
            l |= str3.charAt(0);
          } else if (Character.isDigit(str3.charAt(0))) {
            l |= 0xFFFE;
          } else {
            l |= 0xFFFF;
          }
        }
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new gwo(this, (HashMap)localObject1));
  }
  
  public String a()
  {
    return null;
  }
  
  public List a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130904427);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298897));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    g();
    this.jdField_a_of_type_Gwp = new gwp(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gwp);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131368404), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131368398));
  }
  
  public void d()
  {
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Gwp.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (gwq)paramView.getTag();
    if ((paramView != null) && (paramView.a != null))
    {
      paramView = paramView.a;
      if (paramView != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("group_uin", paramView.uin);
        localBundle.putString("group_name", paramView.discussionName);
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.DiscussionListInnerFrame
 * JD-Core Version:    0.7.0.1
 */