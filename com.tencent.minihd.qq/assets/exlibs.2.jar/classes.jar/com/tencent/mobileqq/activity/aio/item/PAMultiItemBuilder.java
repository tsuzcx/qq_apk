package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import fvn;
import fvo;
import java.util.ArrayList;

public class PAMultiItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PAMultiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fvn(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)paramView).setOrientation(1);
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = paramLinearLayout.mPAMessage;
    int i = (int)(1.0F * BaseChatItemLayout.d);
    ArrayList localArrayList = localPAMessage.items;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    i = 0;
    label167:
    ImageView localImageView;
    if (i < localArrayList.size())
    {
      fvo localfvo = new fvo(this);
      paramViewHolder = (PAMessage.Item)localArrayList.get(i);
      localfvo.jdField_a_of_type_Int = 5;
      localfvo.jdField_c_of_type_JavaLangString = paramViewHolder.url;
      localfvo.jdField_b_of_type_Int = localPAMessage.type;
      localfvo.jdField_b_of_type_JavaLangString = paramViewHolder.actionUrl;
      localfvo.jdField_a_of_type_JavaLangString = paramViewHolder.nativeJumpString;
      localfvo.jdField_a_of_type_Long = paramLinearLayout.uniseq;
      localfvo.jdField_c_of_type_Int = i;
      int j;
      if (i == 0)
      {
        paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903147, null);
        TextView localTextView = (TextView)paramMessageRecord.findViewById(2131297075);
        localImageView = (ImageView)paramMessageRecord.findViewById(2131297074);
        String str = Util.e(paramViewHolder.title);
        localTextView.setText(str);
        if (paramViewHolder.mVideoFlag == 1)
        {
          Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label465;
          }
          j = 2130839267;
          label231:
          localObject = ((Resources)localObject).getDrawable(j);
          j = Util.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject).setBounds(j, 0, Util.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, Util.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
          SpannableString localSpannableString = new SpannableString(str + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject, 0), str.length(), str.length() + 1, 17);
          localTextView.setText(localSpannableString);
        }
      }
      for (;;)
      {
        try
        {
          j = AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          if (i != 0) {
            continue;
          }
          paramViewHolder = URLDrawable.getDrawable(paramViewHolder.cover);
          localImageView.setImageDrawable(paramViewHolder);
        }
        catch (Exception paramViewHolder)
        {
          label465:
          localImageView.setImageResource(2130837581);
          continue;
        }
        localViewGroup.addView(paramMessageRecord);
        paramMessageRecord.setTag(localfvo);
        paramMessageRecord.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramMessageRecord.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramMessageRecord.setOnLongClickListener(paramOnLongClickAndTouchListener);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903145, null);
          break label167;
        }
        paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903146, null);
        break label167;
        j = 2130839268;
        break label231;
        paramViewHolder = URLDrawable.getDrawable(paramViewHolder.cover, j, j);
      }
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new fvo(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      PublicAccountUtil.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131302479, this.jdField_a_of_type_AndroidContentContext.getString(2131366320));
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */