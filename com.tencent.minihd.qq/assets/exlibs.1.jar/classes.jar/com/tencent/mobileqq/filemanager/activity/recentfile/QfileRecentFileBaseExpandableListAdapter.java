package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import iql;
import iqm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

@SuppressLint({"ResourceAsColor"})
public class QfileRecentFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public QfileRecentFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.b = paramOnClickListener1;
    this.c = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(FileManagerEntity paramFileManagerEntity)
  {
    return QfileTimeUtils.b(paramFileManagerEntity.srvTime);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130839658);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  private String b(FileManagerEntity paramFileManagerEntity)
  {
    String str = null;
    Object localObject1;
    Object localObject2;
    switch (paramFileManagerEntity.nOpType)
    {
    case 2: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.cloudType == 0) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
      }
      localObject2 = localObject1;
      if (paramFileManagerEntity.cloudType == 5)
      {
        if (paramFileManagerEntity.bSend)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
          label234:
          localObject1 = paramFileManagerEntity.peerNick;
        }
      }
      else
      {
        if ((localObject2 != null) && (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385))) && (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396)))) {
          localObject1 = paramFileManagerEntity.peerNick;
        }
        localObject1 = localObject2;
        if (paramFileManagerEntity.nOpType == 1)
        {
          localObject1 = localObject2;
          if (paramFileManagerEntity.bSend) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
          }
        }
        localObject2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
        if (paramFileManagerEntity.TroopUin == 0L) {
          break label1020;
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(50)).a(String.valueOf(paramFileManagerEntity.TroopUin));
        if ((localObject1 != null) && (((TroopInfo)localObject1).troopname != null)) {
          break label862;
        }
        localObject1 = "";
        label379:
        if (!paramFileManagerEntity.bSend) {
          break label904;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362513) + (String)localObject1;
        label413:
        localObject1 = null;
      }
      break;
    }
    label514:
    label862:
    label1020:
    for (;;)
    {
      Object localObject3 = localObject2;
      if (localObject1 != null)
      {
        localObject3 = localObject2;
        if (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385))) {
          localObject3 = null;
        }
      }
      if ((paramFileManagerEntity.peerType == 3000) && (localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385))))
      {
        localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(51)).a(String.valueOf(paramFileManagerEntity.peerUin));
        if ((localObject1 == null) || (((DiscussionInfo)localObject1).discussionName == null))
        {
          localObject1 = "";
          if (!paramFileManagerEntity.bSend) {
            break label976;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362514) + (String)localObject1;
          localObject2 = str;
        }
      }
      for (;;)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362402);
        str = QfileTimeUtils.b(paramFileManagerEntity.srvTime) + a((String)localObject3, (String)localObject2) + a((String)localObject3, (String)localObject1);
        if ((localObject2 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396)) && (paramFileManagerEntity.bSend))
        {
          return QfileTimeUtils.b(paramFileManagerEntity.srvTime) + a((String)localObject3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396)) + a((String)localObject3, (String)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396);
          break;
          if (paramFileManagerEntity.bSend)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362496);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362497);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362498);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362499);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362500);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362501);
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362502);
          break;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
          break label234;
          if ((localObject1 != null) && (((TroopInfo)localObject1).troopname != null) && (((TroopInfo)localObject1).troopname.length() > 14))
          {
            localObject1 = FileManagerUtil.d(((TroopInfo)localObject1).troopname);
            break label379;
          }
          localObject1 = ((TroopInfo)localObject1).troopname;
          break label379;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362512) + (String)localObject1;
          break label413;
          if ((localObject1 != null) && (((DiscussionInfo)localObject1).discussionName != null) && (((DiscussionInfo)localObject1).discussionName.length() > 14))
          {
            localObject1 = FileManagerUtil.d(((DiscussionInfo)localObject1).discussionName);
            break label514;
          }
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
          break label514;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362515) + (String)localObject1;
          localObject2 = str;
          continue;
        }
        return str;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
  }
  
  private String c(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject1;
    Object localObject2;
    switch (paramFileManagerEntity.nOpType)
    {
    case 2: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.cloudType == 0) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
      }
      localObject2 = localObject1;
      if (paramFileManagerEntity.cloudType == 5)
      {
        if (paramFileManagerEntity.bSend)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
          label234:
          localObject1 = paramFileManagerEntity.peerNick;
        }
      }
      else
      {
        if ((localObject2 != null) && (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385))) && (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396)))) {
          localObject1 = paramFileManagerEntity.peerNick;
        }
        localObject1 = localObject2;
        if (paramFileManagerEntity.nOpType == 1)
        {
          localObject1 = localObject2;
          if (paramFileManagerEntity.bSend) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
          }
        }
        localObject2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
        if (paramFileManagerEntity.TroopUin == 0L) {
          break label983;
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(50)).a(String.valueOf(paramFileManagerEntity.TroopUin));
        if ((localObject1 != null) && (((TroopInfo)localObject1).troopname != null)) {
          break label830;
        }
        localObject1 = "";
        label379:
        if (!paramFileManagerEntity.bSend) {
          break label872;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362513) + (String)localObject1;
        label413:
        localObject1 = null;
      }
      break;
    }
    label542:
    label830:
    label983:
    for (;;)
    {
      if ((localObject1 != null) && (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385)))) {
        localObject2 = str1;
      }
      for (;;)
      {
        if ((paramFileManagerEntity.peerType == 3000) && (localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385))))
        {
          localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(51)).a(String.valueOf(paramFileManagerEntity.peerUin));
          if ((localObject1 == null) || (((DiscussionInfo)localObject1).discussionName == null))
          {
            localObject1 = "";
            label508:
            if (!paramFileManagerEntity.bSend) {
              break label944;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362514) + (String)localObject1;
            str1 = "";
            localObject2 = localObject1;
            localObject1 = str1;
          }
        }
        for (;;)
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362402);
          String str2 = (String)localObject1 + a(str1, (String)localObject2);
          if ((localObject1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396)) && (paramFileManagerEntity.bSend))
          {
            return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396) + a(str1, (String)localObject2);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362385);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362396);
            break;
            if (paramFileManagerEntity.bSend)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362397);
              break;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362496);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362497);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362498);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362499);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362500);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362501);
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362502);
            break;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362395);
            break label234;
            if ((localObject1 != null) && (((TroopInfo)localObject1).troopname != null) && (((TroopInfo)localObject1).troopname.length() > 14))
            {
              localObject1 = FileManagerUtil.d(((TroopInfo)localObject1).troopname);
              break label379;
            }
            localObject1 = ((TroopInfo)localObject1).troopname;
            break label379;
            label872:
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362512) + (String)localObject1;
            break label413;
            if ((localObject1 != null) && (((DiscussionInfo)localObject1).discussionName != null) && (((DiscussionInfo)localObject1).discussionName.length() > 14))
            {
              localObject1 = FileManagerUtil.d(((DiscussionInfo)localObject1).discussionName);
              break label508;
            }
            localObject1 = ((DiscussionInfo)localObject1).discussionName;
            break label508;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362515) + (String)localObject1;
            break label542;
          }
          return str2;
        }
      }
    }
  }
  
  private String d(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject;
    String str2;
    switch (paramFileManagerEntity.cloudType)
    {
    case 4: 
    default: 
      localObject = null;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362402);
      str2 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, (String)localObject) + a(str3, str1) + c(paramFileManagerEntity);
      localObject = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, str1) + c(paramFileManagerEntity);
      if ((paramFileManagerEntity.cloudType == 2) && (3 == paramFileManagerEntity.nOpType)) {
        localObject = str2;
      }
      break;
    }
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362362);
      str1 = FileManagerUtil.a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      str1 = str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362398);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362363);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131364775);
      break;
      if (paramFileManagerEntity.cloudType == 5) {
        return str2;
      }
    } while (paramFileManagerEntity.TroopUin == 0L);
    return str2;
  }
  
  public int a()
  {
    return 2130903315;
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject = (iqm)paramView.getTag();
    if (localObject == null)
    {
      localObject = new iqm();
      paramView.findViewById(2131297233).setVisibility(0);
      ((iqm)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297234));
      ((iqm)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297235));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h())
    {
      localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (iql)((Iterator)localObject3).next();
          if (((iql)localObject2).jdField_a_of_type_Int != paramInt2) {
            break label1680;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((iql)localObject2).jdField_b_of_type_Int);
        }
      }
    }
    while (localObject2 == null)
    {
      return paramView;
      localObject2 = (FileManagerEntity)getChild(paramInt1, paramInt2);
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject3 = new QfileRecentFileBaseExpandableListAdapter.RecentItemHolder(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903751, paramViewGroup, false);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131299496));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.c);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject3);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131299500));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131299501));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131299498));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299499));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299503));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297407));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299504));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).d = ((TextView)paramView.findViewById(2131297921));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131296570));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.b);
        localObject1 = paramView;
        paramView.setTag(localObject3);
        paramViewGroup = (ViewGroup)localObject3;
      }
      catch (Exception paramViewGroup)
      {
        paramView = (View)localObject1;
        continue;
      }
      try
      {
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.c = paramInt2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.d);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
        if (FileManagerUtil.a(((FileManagerEntity)localObject2).fileName) == 0)
        {
          if (FileUtils.b(((FileManagerEntity)localObject2).strFilePath))
          {
            FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).strFilePath, ((FileManagerEntity)localObject2).nFileType);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject2).fileName);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(d((FileManagerEntity)localObject2));
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.d.setText(a((FileManagerEntity)localObject2));
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            FileManagerUtil.c((FileManagerEntity)localObject2);
          }
          switch (((FileManagerEntity)localObject2).status)
          {
          case 16: 
          case 17: 
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h())
            {
              paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a((FileManagerEntity)localObject2));
              return paramView;
              localObject1 = paramView;
              paramViewGroup = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
              continue;
              if (FileUtils.b(((FileManagerEntity)localObject2).strThumbPath))
              {
                a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).strThumbPath);
                continue;
              }
            }
            break;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).fileName, ((FileManagerEntity)localObject2).nFileType);
        continue;
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362544);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427956));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 2;
        paramViewGroup.d.setVisibility(4);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362545);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427955));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramBoolean = FileUtil.a(((FileManagerEntity)localObject2).strFilePath);
        if ((((FileManagerEntity)localObject2).cloudType == 3) || (((FileManagerEntity)localObject2).cloudType == 5) || (paramBoolean))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362543);
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427954));
          paramViewGroup.jdField_a_of_type_Int = 0;
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          continue;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362546);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427955));
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362545);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427955));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362543);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427954));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362546);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427955));
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362543);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427954));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362543);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427954));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362546);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427955));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362543);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427954));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362546);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427955));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      label1680:
      break;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        int j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (FileManagerEntity)localIterator.next();
          int k;
          if ((((FileManagerEntity)localObject2).cloudType == 0) || ((((FileManagerEntity)localObject2).cloudType == 5) && (!((FileManagerEntity)localObject2).bSend) && (((FileManagerEntity)localObject2).status != 1)))
          {
            k = j + 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            k = j;
            j = i;
            i = k;
            break;
            localObject2 = new iql(this);
            ((iql)localObject2).jdField_a_of_type_Int = i;
            ((iql)localObject2).jdField_b_of_type_Int = (i + j);
            localArrayList.add(localObject2);
            k = i + 1;
            i = j;
            j = k;
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
        i = ((ArrayList)localObject1).size() - j;
      }
    }
    else
    {
      return i;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    return ((ArrayList)localObject1).size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (iqm)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (!paramBoolean) {
        break label178;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841853);
      label57:
      if (!paramBoolean) {
        break label191;
      }
      paramViewGroup.setContentDescription((String)localObject + "分组已展开，双击此处可收起分组");
    }
    for (;;)
    {
      paramViewGroup.setFocusable(true);
      paramViewGroup.setFocusableInTouchMode(true);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903315, paramViewGroup, false);
      paramView = new iqm();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297234));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297235));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297233));
      paramViewGroup.setTag(paramView);
      break;
      label178:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841854);
      break label57;
      label191:
      paramViewGroup.setContentDescription((String)localObject + "分组已折叠，双击此处可展开分组");
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */