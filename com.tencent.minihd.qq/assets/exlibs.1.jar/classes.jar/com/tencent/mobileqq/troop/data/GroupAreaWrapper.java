package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import java.io.Serializable;
import java.util.ArrayList;

public class GroupAreaWrapper
  implements Serializable
{
  public static final int ACTIVITY_INFO_WRAPPER_TYPE_NORMAL = 1;
  public static final int GROUP_INFO_WRAPPER_TYPE_NORMAL = 0;
  public static final int TOPIC_INFO_WRAPPER_TYPE_NORMAL = 2;
  public GroupAreaWrapper.ActivityInfo activityArea = null;
  public GroupArea groupArea = null;
  public boolean isMoreClick = false;
  public GroupAreaWrapper.TopicInfo topicArea = null;
  public int type = 0;
  
  public GroupAreaWrapper() {}
  
  public GroupAreaWrapper(GroupArea paramGroupArea)
  {
    this.type = 0;
    this.groupArea = paramGroupArea;
  }
  
  public GroupAreaWrapper(GroupAreaWrapper.ActivityInfo paramActivityInfo)
  {
    this.type = 1;
    this.activityArea = paramActivityInfo;
  }
  
  public GroupAreaWrapper(GroupAreaWrapper.TopicInfo paramTopicInfo)
  {
    this.type = 2;
    this.topicArea = paramTopicInfo;
  }
  
  public int getChildCount()
  {
    int i = 1;
    if (this.type == 0) {
      if ((this.groupArea != null) && (this.groupArea.vGroupInfo != null)) {}
    }
    while ((this.type != 1) && (this.type != 2))
    {
      return 0;
      int j = this.groupArea.vGroupInfo.size();
      if (this.groupArea.dwGroupTotalCnt > this.groupArea.vGroupInfo.size()) {}
      for (;;)
      {
        return j + i;
        i = 0;
      }
    }
    return 1;
  }
  
  public View getChildView(NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext, Context paramContext, NearbyTroopsExpandableListViewAdapter paramNearbyTroopsExpandableListViewAdapter, int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    if (this.type == 0)
    {
      ArrayList localArrayList = this.groupArea.vGroupInfo;
      if (localArrayList == null)
      {
        paramNearbyTroopsExpandableListViewAdapter = null;
        return paramNearbyTroopsExpandableListViewAdapter;
      }
      if (paramInt2 == localArrayList.size())
      {
        if (paramView != null)
        {
          paramINearbyTroopContext = paramView;
          if ((paramView.getTag() instanceof NearbyTroops.MoreBtnViewHolder)) {}
        }
        else
        {
          paramINearbyTroopContext = NearbyTroops.f(paramContext, paramViewGroup);
        }
        NearbyTroops.a(paramINearbyTroopContext, this.isMoreClick, (int)this.groupArea.dwGroupTotalCnt - localArrayList.size());
        return paramINearbyTroopContext;
      }
      if ((paramView != null) && ((paramView.getTag() instanceof NearbyTroops.CustomViewHolder)) && (!(paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder))) {
        break label326;
      }
      paramView = NearbyTroops.d(paramContext, paramViewGroup);
    }
    label326:
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramINearbyTroopContext.a());
        NearbyTroops.a(paramView, getGroupInfo(paramInt2), paramContext, false, l);
        paramNearbyTroopsExpandableListViewAdapter.a((NearbyTroops.CustomViewHolder)paramView.getTag(), null);
        return paramView;
      }
      catch (NumberFormatException paramINearbyTroopContext)
      {
        long l = 0L;
        continue;
      }
      if (this.type == 1)
      {
        if (paramView != null)
        {
          paramNearbyTroopsExpandableListViewAdapter = paramView;
          if ((paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder)) {}
        }
        else
        {
          paramNearbyTroopsExpandableListViewAdapter = this.activityArea.createView(paramContext, paramViewGroup);
        }
        this.activityArea.fillView(paramNearbyTroopsExpandableListViewAdapter);
        ReportController.b(paramINearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "ac", "exp", 0, 0, "", "", "", "");
        return paramNearbyTroopsExpandableListViewAdapter;
      }
      paramNearbyTroopsExpandableListViewAdapter = paramView;
      if (this.type != 2) {
        break;
      }
      if (paramView != null)
      {
        paramNearbyTroopsExpandableListViewAdapter = paramView;
        if ((paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder)) {}
      }
      else
      {
        paramNearbyTroopsExpandableListViewAdapter = this.topicArea.createView(paramContext, paramViewGroup);
      }
      this.topicArea.fillView(paramNearbyTroopsExpandableListViewAdapter);
      ReportController.b(paramINearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "post", "exp", 0, 0, "", "", "", "");
      return paramNearbyTroopsExpandableListViewAdapter;
    }
  }
  
  public GroupInfo getGroupInfo(int paramInt)
  {
    if (this.type == 0)
    {
      ArrayList localArrayList = this.groupArea.vGroupInfo;
      if (localArrayList != null) {
        return (GroupInfo)localArrayList.get(paramInt);
      }
    }
    return null;
  }
  
  public View getGroupView(Context paramContext, int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    NearbyTroops.GroupViewHolder localGroupViewHolder = null;
    if (paramView != null) {
      localGroupViewHolder = (NearbyTroops.GroupViewHolder)paramView.getTag();
    }
    if (this.type == 0)
    {
      if ((localGroupViewHolder == null) || (localGroupViewHolder.a != 3)) {
        paramView = NearbyTroops.b(paramContext, paramViewGroup);
      }
      NearbyTroops.a(paramView, this.groupArea.strAreaName, (float)this.groupArea.dwGroupTotalCnt, (float)this.groupArea.dwDistance, paramBoolean);
    }
    while ((localGroupViewHolder != null) && (localGroupViewHolder.a == 1)) {
      return paramView;
    }
    return NearbyTroops.a(paramContext, paramViewGroup);
  }
  
  public Object getObject()
  {
    if (this.type == 0) {
      return this.groupArea;
    }
    if (this.type == 1) {
      return this.activityArea;
    }
    if (this.type == 2) {
      return this.topicArea;
    }
    return null;
  }
  
  public void onClick(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.type == 0)
    {
      Object localObject = this.groupArea.vGroupInfo;
      if (localObject != null)
      {
        localObject = (GroupInfo)((ArrayList)localObject).get(paramInt1);
        if (localObject != null)
        {
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_data", 0, 0, String.valueOf(((GroupInfo)localObject).lCode), String.valueOf(paramInt4), "", paramInt5 + "");
          openTroopProfile(paramContext, (GroupInfo)localObject, paramInt3, paramInt5, paramInt4);
        }
      }
    }
  }
  
  public void openTroopProfile(Context paramContext, GroupInfo paramGroupInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramGroupInfo == null) {
      return;
    }
    paramGroupInfo = TroopUtils.a(paramInt1, paramGroupInfo, 0, false);
    paramGroupInfo.putInt("filter_id", paramInt2);
    paramGroupInfo.putInt("exposureSource", paramInt3);
    TroopUtils.a(paramContext, paramGroupInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper
 * JD-Core Version:    0.7.0.1
 */