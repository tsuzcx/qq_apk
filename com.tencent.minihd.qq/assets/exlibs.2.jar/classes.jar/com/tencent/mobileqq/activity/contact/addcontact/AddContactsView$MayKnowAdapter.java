package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import gft;
import gfu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AddContactsView$MayKnowAdapter
  extends FacePreloadBaseAdapter
{
  CircleManager jdField_a_of_type_ComTencentMobileqqAppCircleManager;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private Set b = new HashSet();
  
  public AddContactsView$MayKnowAdapter(AddContactsView paramAddContactsView, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    super(paramContext, paramQQAppInterface, paramListView, 1, true);
    paramListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(49));
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)paramQQAppInterface.getManager(34));
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.a = a(paramInt).uin;
    return localFaceInfo;
  }
  
  public void a(List paramList)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = AddContactsView.a();
      localStringBuilder = new StringBuilder().append("addItems size=");
      if (paramList != null) {
        break label136;
      }
    }
    label136:
    for (int i = 0;; i = paramList.size())
    {
      QLog.d((String)localObject, 2, i);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (paramList == null) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (MayKnowRecommend)paramList.next();
        if (!this.b.contains(((MayKnowRecommend)localObject).uin))
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          this.b.add(((MayKnowRecommend)localObject).uin);
        }
      }
    }
  }
  
  public void b(List paramList)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = AddContactsView.a();
      localStringBuilder = new StringBuilder().append("refreshItems size=");
      if (paramList != null) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = paramList.size())
    {
      QLog.d((String)localObject, 2, i);
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.b.clear();
      if (paramList == null) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (MayKnowRecommend)paramList.next();
        this.b.add(((MayKnowRecommend)localObject).uin);
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size()) {
      return i + 1;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      MayKnowRecommend localMayKnowRecommend;
      label218:
      int i;
      if (paramView == null)
      {
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_AndroidContentContext).inflate(2130903067, paramViewGroup, false);
        paramViewGroup = new gft();
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131296657));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131296660));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131296662));
        paramViewGroup.c = ((TextView)((View)localObject1).findViewById(2131296663));
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131296664));
        paramViewGroup.e = ((TextView)((View)localObject1).findViewById(2131296658));
        paramViewGroup.f = ((TextView)((View)localObject1).findViewById(2131296659));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = new StringBuilder();
        localMayKnowRecommend = a(paramInt);
        paramViewGroup.jdField_b_of_type_JavaLangString = localMayKnowRecommend.uin;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_b_of_type_JavaLangString));
        if (!TextUtils.isEmpty(localMayKnowRecommend.remark)) {
          break label682;
        }
        if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
          break label673;
        }
        paramView = localMayKnowRecommend.uin;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        if (!TextUtils.isEmpty(paramView)) {
          ((StringBuilder)localObject2).append(paramView);
        }
        paramInt = 0;
        switch (localMayKnowRecommend.gender)
        {
        default: 
          i = 0;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840435);
          label280:
          if (localMayKnowRecommend.age != 0)
          {
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localMayKnowRecommend.age));
            ((StringBuilder)localObject2).append(localMayKnowRecommend.age);
            ((StringBuilder)localObject2).append("岁");
            paramInt = 1;
            label324:
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            if (paramInt == 0) {
              break label761;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            label348:
            if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager == null) {
              break label785;
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c(localMayKnowRecommend.uin);
            if (TextUtils.isEmpty(paramView)) {
              break label773;
            }
            paramViewGroup.c.setText(paramView);
            paramViewGroup.c.setVisibility(0);
            paramViewGroup.c.setBackgroundResource(2130840447);
            ((StringBuilder)localObject2).append(paramView);
            paramView = new StringBuffer(100);
            i = 0;
            paramInt = i;
            if (!"中国".equals(localMayKnowRecommend.country))
            {
              paramInt = i;
              if (!TextUtils.isEmpty(localMayKnowRecommend.country))
              {
                paramView.append(localMayKnowRecommend.country);
                paramView.append(" ");
                paramInt = 1;
              }
            }
            if (!TextUtils.isEmpty(localMayKnowRecommend.province))
            {
              paramView.append(localMayKnowRecommend.province);
              paramView.append(" ");
              paramInt = 1;
            }
            if (!TextUtils.isEmpty(localMayKnowRecommend.city))
            {
              paramView.append(localMayKnowRecommend.city);
              paramView.append(" ");
              paramInt = 1;
            }
            if (paramInt != 0) {
              paramView.deleteCharAt(paramView.length() - 1);
            }
            if (paramView.length() <= 0) {
              break label797;
            }
            paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(paramView.toString());
            ((StringBuilder)localObject2).append(paramView);
            label582:
            if (localMayKnowRecommend.friendStatus != 0) {
              break label809;
            }
            paramViewGroup.e.setVisibility(0);
            paramViewGroup.e.setTag(localMayKnowRecommend);
            paramViewGroup.f.setVisibility(8);
            paramViewGroup.e.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
          }
          label408:
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.e.setContentDescription("添加");
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
        return localObject1;
        paramViewGroup = (gft)paramView.getTag();
        localObject1 = paramView;
        break;
        label673:
        paramView = localMayKnowRecommend.nick;
        break label218;
        label682:
        paramView = localMayKnowRecommend.remark;
        break label218;
        paramInt = 1;
        i = 2130838484;
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840435);
        ((StringBuilder)localObject2).append("男");
        break label280;
        paramInt = 1;
        i = 2130838479;
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840431);
        ((StringBuilder)localObject2).append("女");
        break label280;
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
        break label324;
        label761:
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label348;
        label773:
        paramViewGroup.c.setVisibility(8);
        break label408;
        label785:
        paramViewGroup.c.setVisibility(8);
        break label408;
        label797:
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        break label582;
        label809:
        if (localMayKnowRecommend.friendStatus == 1)
        {
          paramViewGroup.e.setVisibility(8);
          paramViewGroup.f.setVisibility(0);
          paramViewGroup.f.setText(2131365759);
          paramViewGroup.f.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365759));
        }
        else
        {
          paramViewGroup.e.setVisibility(8);
          paramViewGroup.f.setVisibility(0);
          paramViewGroup.f.setText(2131365752);
          paramViewGroup.f.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365752));
        }
      }
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_AndroidContentContext).inflate(2130903818, null);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
      paramView = new gfu();
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296735));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297997));
    }
    if (AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView) == 5)
    {
      AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView, true, false, this.jdField_a_of_type_JavaUtilList);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004E41", "0X8004E41", 0, 0, "", "", "", "");
    }
    Object localObject2 = (gfu)paramViewGroup.getTag();
    Object localObject1 = "";
    if (AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView) == 3)
    {
      ((gfu)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      ((gfu)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请稍后再试");
      paramView = "获取失败，请稍后再试";
    }
    for (;;)
    {
      paramViewGroup.setContentDescription(paramView);
      return paramViewGroup;
      if ((AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView) == 2) && (getCount() == 1))
      {
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText("正在加载…");
        paramView = "正在加载…";
      }
      else if ((AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView) == 2) && (getCount() > 1))
      {
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText("正在加载更多…");
        paramView = "正在加载更多…";
      }
      else if (AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView) == 4)
      {
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请检查网络连接");
        paramView = "获取失败，请检查网络连接";
      }
      else if ((AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView) == 1) && (getCount() == 1))
      {
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((gfu)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText("暂无可能认识的人");
        paramView = "暂无可能认识的人";
      }
      else
      {
        paramView = (View)localObject1;
        if (AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView) == 1)
        {
          paramView = (View)localObject1;
          if (getCount() > 1)
          {
            ((gfu)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramView = "暂无更多可能认识的人";
            ((gfu)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText("暂无更多可能认识的人");
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.MayKnowAdapter
 * JD-Core Version:    0.7.0.1
 */