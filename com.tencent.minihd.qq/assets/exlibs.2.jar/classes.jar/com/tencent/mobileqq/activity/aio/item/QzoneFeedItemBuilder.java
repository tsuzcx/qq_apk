package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import fwc;
import fwd;

public class QzoneFeedItemBuilder
  extends AbstractChatItemBuilder
{
  public QzoneFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, fwd paramfwd)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903150, null);
      paramfwd.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131297097));
      paramfwd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297096));
      paramfwd.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131296340));
      paramfwd.c = ((TextView)localView.findViewById(2131296341));
      paramfwd.d = ((TextView)localView.findViewById(2131297099));
      paramfwd.e = ((TextView)localView.findViewById(2131297102));
      paramfwd.f = ((TextView)localView.findViewById(2131297103));
      paramfwd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297101));
      paramfwd.g = ((TextView)localView.findViewById(2131297098));
      paramfwd.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131297100));
      paramfwd.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    localView.setContentDescription(null);
    paramfwd.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramfwd.jdField_a_of_type_JavaLangStringBuilder.length(), "");
    return localView;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramMessageRecord = (MessageForQzoneFeed)paramMessageRecord;
    paramViewHolder = (fwd)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramViewHolder.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    paramViewHolder.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramMessageRecord.feedTime * 1000L);
    label157:
    String str1;
    String str2;
    if (paramMessageRecord.feedTime > 0L)
    {
      paramViewHolder.f.setVisibility(0);
      paramViewHolder.f.setText(paramLinearLayout);
      if (TextUtils.isEmpty(paramMessageRecord.lbsInfo)) {
        break label524;
      }
      paramViewHolder.e.setVisibility(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewHolder.e.setText(paramMessageRecord.lbsInfo);
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnLongClickAndTouchListener.addRule(11, -1);
      paramViewHolder.f.setLayoutParams(paramOnLongClickAndTouchListener);
      int j = paramViewHolder.jdField_b_of_type_AndroidViewViewGroup.getPaddingLeft();
      int i = paramViewHolder.jdField_b_of_type_AndroidViewViewGroup.getPaddingTop();
      int k = paramViewHolder.jdField_b_of_type_AndroidViewViewGroup.getPaddingRight();
      int m = paramViewHolder.jdField_b_of_type_AndroidViewViewGroup.getPaddingBottom();
      if (!TextUtils.isEmpty(paramMessageRecord.coverImageUrl)) {
        break label575;
      }
      paramViewHolder.g.setVisibility(8);
      paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      i = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnLongClickAndTouchListener.addRule(1, paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getId());
      paramOnLongClickAndTouchListener.addRule(3, paramViewHolder.d.getId());
      paramViewHolder.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_b_of_type_AndroidViewViewGroup.setPadding(j, i, k, m);
      paramOnLongClickAndTouchListener = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 10);
      str1 = paramOnLongClickAndTouchListener + paramMessageRecord.summery;
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      str1 = paramMessageRecord.title;
      str2 = paramMessageRecord.content;
      paramViewHolder.c.setText(str1);
      paramViewHolder.d.setText(str2);
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        break label709;
      }
      paramViewHolder.c.setVisibility(8);
      paramViewHolder.d.setVisibility(8);
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new fwc(this, paramMessageRecord));
      paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(paramOnLongClickAndTouchListener);
      if (paramMessageRecord.feedTime > 0L) {
        paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append("于").append(paramLinearLayout);
      }
      paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(paramMessageRecord.summery).append("内容是：").append(paramMessageRecord.title).append(paramMessageRecord.content);
      paramView.setContentDescription(paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.toString());
      return paramView;
      paramViewHolder.f.setVisibility(8);
      paramViewHolder.f.setText("");
      break;
      label524:
      paramViewHolder.e.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnLongClickAndTouchListener.addRule(9, -1);
      paramViewHolder.f.setLayoutParams(paramOnLongClickAndTouchListener);
      break label157;
      label575:
      if (paramMessageRecord.imageCount > 1)
      {
        paramViewHolder.g.setVisibility(0);
        paramViewHolder.g.setText(String.valueOf(paramMessageRecord.imageCount));
      }
      for (;;)
      {
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        int n = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(paramMessageRecord.coverImageUrl, n, n));
        paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
        paramOnLongClickAndTouchListener.addRule(1, paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getId());
        paramOnLongClickAndTouchListener.addRule(8, paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getId());
        paramViewHolder.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(paramOnLongClickAndTouchListener);
        break;
        paramViewHolder.g.setVisibility(8);
      }
      label709:
      if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
      {
        paramViewHolder.c.setVisibility(0);
        paramViewHolder.d.setVisibility(8);
        paramViewHolder.c.setMaxLines(2);
      }
      else if ((TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramViewHolder.c.setVisibility(8);
        paramViewHolder.d.setVisibility(0);
        paramViewHolder.d.setMaxLines(2);
      }
      else
      {
        paramViewHolder.c.setVisibility(0);
        paramViewHolder.d.setVisibility(0);
        paramViewHolder.c.setMaxLines(1);
        paramViewHolder.d.setMaxLines(1);
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new fwd(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder
 * JD-Core Version:    0.7.0.1
 */