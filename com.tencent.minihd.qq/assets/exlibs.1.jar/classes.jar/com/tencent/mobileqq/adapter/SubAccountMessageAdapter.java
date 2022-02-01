package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SubAccountMessageAdapter
  extends BaseAdapter
  implements DragFrameLayout.OnDragModeChangedListener
{
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private int jdField_a_of_type_Int = 0;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private int e = 200;
  
  public SubAccountMessageAdapter(QQAppInterface paramQQAppInterface, List paramList, View.OnClickListener paramOnClickListener, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SubAccountMessage localSubAccountMessage;
    Object localObject;
    label326:
    int i;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904465, paramViewGroup, false);
      paramViewGroup = new SubAccountMessageAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131302265);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302272));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131302275));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302274));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131302276));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131302273));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      localSubAccountMessage = (SubAccountMessage)getItem(paramInt);
      if (localSubAccountMessage != null)
      {
        String str = localSubAccountMessage.sendername;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = localSubAccountMessage.senderuin;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
          localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
        }
        paramViewGroup.b.setText(localSubAccountMessage.mEmoRecentMsg);
        if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
          localSubAccountMessage.mTimeString = TimeFormatterUtils.a(localSubAccountMessage.time * 1000L, true, SubAccountControll.d);
        }
        paramViewGroup.c.setText(localSubAccountMessage.mTimeString);
        if (!localSubAccountMessage.senderuin.equals("2005060620050606")) {
          break label432;
        }
        localObject = BaseApplication.getContext().getResources().getDrawable(2130842000);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localSubAccountMessage.senderuin);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        i = localSubAccountMessage.unreadNum;
        if (i <= 0) {
          break label464;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        if (i <= 99) {
          break label449;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText("99+");
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Int != 1) {
        break label475;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838151);
      return paramView;
      paramViewGroup = (SubAccountMessageAdapter.ViewHolder)paramView.getTag();
      break;
      label432:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localSubAccountMessage.senderuin);
      break label326;
      label449:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText(String.valueOf(i));
      continue;
      label464:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
    label475:
    if (paramInt == 0)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838156);
      return paramView;
    }
    if (paramInt == this.jdField_a_of_type_Int - 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838153);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838155);
    return paramView;
  }
  
  private View a(View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904463, null);
    }
    int i = paramViewGroup.getHeight() - this.jdField_a_of_type_AndroidViewView.getHeight();
    if (i > this.e) {}
    for (;;)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      localView.setLayoutParams(paramView);
      localView.setTag(Boolean.valueOf(true));
      return localView;
      i = this.e;
    }
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
  }
  
  public void a(String paramString, View paramView)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramView = (ImageView)paramView.findViewById(2131302272);
      if (paramView != null)
      {
        Object localObject = paramView.getTag();
        if ((localObject != null) && ((localObject instanceof String)) && (paramString.equals(localObject))) {
          paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString));
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean)
    {
      paramDragFrameLayout = paramDragFrameLayout.a();
      if ((paramDragFrameLayout != null) && (paramDragFrameLayout.getTag() != null)) {
        ((Integer)paramDragFrameLayout.getTag()).intValue();
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();; this.jdField_a_of_type_Int = 0) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    SubAccountMessage localSubAccountMessage = (SubAccountMessage)getItem(paramInt);
    if ((localSubAccountMessage != null) && (localSubAccountMessage.subUin != null)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("SUB_ACCOUNT", 4, "getView() position=" + paramInt + " viewType=" + i);
    }
    if (i == 0) {
      return a(paramInt, paramView, paramViewGroup);
    }
    return a(paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SubAccountMessageAdapter
 * JD-Core Version:    0.7.0.1
 */