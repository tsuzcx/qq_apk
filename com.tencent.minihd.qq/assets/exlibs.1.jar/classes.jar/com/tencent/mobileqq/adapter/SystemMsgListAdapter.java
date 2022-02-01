package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class SystemMsgListAdapter
  extends XBaseAdapter
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private BaseSystemMsgInterface jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public SystemMsgListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, BaseSystemMsgInterface paramBaseSystemMsgInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface = paramBaseSystemMsgInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(getCount() - paramInt - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    label162:
    int m;
    int j;
    label182:
    int n;
    int k;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904035, paramViewGroup, false);
      paramViewGroup = new SystemMsgListAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298653));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298654));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297282));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296683));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300590));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131300591));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131300592));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300594));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300593));
      paramViewGroup.jdField_c_of_type_Int = paramInt;
      paramView.setTag(paramViewGroup);
      if (paramInt >= this.jdField_a_of_type_Int) {
        break label295;
      }
      i = 1;
      m = AIOUtils.a(8.0F, paramView.getResources());
      if (i == 0) {
        break label301;
      }
      j = 2130837606;
      n = m * 4;
      k = m * 2;
      if (getCount() != 1) {
        break label315;
      }
      if (i == 0) {
        break label308;
      }
      i = 2130837598;
      label211:
      m *= 4;
      k = m;
      j = i;
      i = m;
    }
    for (;;)
    {
      paramView.setBackgroundResource(j);
      paramView.setPadding(n, k, n, i);
      MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(getCount() - paramInt - 1);
      if (localMessageRecord != null) {
        if ((localMessageRecord instanceof MessageForSystemMsg)) {}
      }
      for (;;)
      {
        return paramView;
        paramViewGroup = (SystemMsgListAdapter.ViewHolder)paramView.getTag();
        break;
        label295:
        i = 0;
        break label162;
        label301:
        j = 2130837603;
        break label182;
        label308:
        i = 2130837595;
        break label211;
        label315:
        if (paramInt == 0)
        {
          if (i != 0) {}
          for (i = 2130837610;; i = 2130837607)
          {
            m *= 4;
            j = i;
            i = k;
            k = m;
            break;
          }
        }
        if (paramInt != getCount() - 1) {
          break label468;
        }
        if (i != 0) {}
        for (i = 2130837602;; i = 2130837599)
        {
          j = i;
          i = m * 4;
          break;
        }
        paramViewGroup.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
        paramViewGroup.jdField_c_of_type_Long = localMessageRecord.uniseq;
        if (localMessageRecord != null) {}
        for (i = ((MessageForSystemMsg)localMessageRecord).getSystemMsg().msg_type.get(); (i != 2) && (i == 1); i = 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseSystemMsgInterface.a(paramViewGroup, paramInt);
          return paramView;
        }
      }
      label468:
      i = k;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SystemMsgListAdapter
 * JD-Core Version:    0.7.0.1
 */