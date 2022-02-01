package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.MsgUtils;
import gmr;
import gms;
import gmt;

public class FloatTextItemBuilder
  extends FloatBaseBubbleBuilder
{
  private View.OnClickListener a;
  protected MsgSummary a;
  
  public FloatTextItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new gmr(this);
  }
  
  private CharSequence a(ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage.simpleMsg == null)
    {
      a(paramChatMessage, a());
      paramChatMessage.simpleMsg = this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.a(this.jdField_a_of_type_AndroidContentContext);
      if (((paramChatMessage.simpleMsg instanceof SpannableStringBuilder)) && (a(paramChatMessage)))
      {
        SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)paramChatMessage.simpleMsg;
        paramInt = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(" 进入QQ查看");
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.setSpan(new gms(this, paramChatMessage, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427448)), paramInt, i, 33);
      }
    }
    return paramChatMessage.simpleMsg;
  }
  
  private CharSequence a(ChatMessage paramChatMessage, String paramString)
  {
    paramString = new SpannableStringBuilder(paramString);
    int i = paramString.length();
    paramString.append(" 进入QQ查看");
    int j = paramString.length();
    paramString.setSpan(new gmt(this, paramChatMessage, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427448)), i, j, 33);
    return paramString;
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForShakeWindow)) {}
    while ((paramChatMessage instanceof MessageForRichState)) {
      return false;
    }
    return true;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    paramFloatBaseChatItemLayout = (FloatTextItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new ETTextView(localContext);
      paramViewHolder.setTextColor(localContext.getResources().getColorStateList(2131427942));
      paramViewHolder.setSpannableFactory(QQText.a);
      paramViewHolder.setMaxWidth(FloatBaseChatItemLayout.h);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131297062);
      paramFloatBaseChatItemLayout.a = paramViewHolder;
    }
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)paramFloatBaseChatItemLayout.a).a();
      if (paramView != null) {
        paramView.a = (paramChatMessage.uniseq + 1L);
      }
    }
    paramFloatBaseChatItemLayout.a.setTextSize(1, 16.0F);
    int j = FloatBaseChatItemLayout.s;
    int i = FloatBaseChatItemLayout.t;
    if (paramChatMessage.isSend())
    {
      j = FloatBaseChatItemLayout.t;
      i = FloatBaseChatItemLayout.s;
    }
    paramFloatBaseChatItemLayout.a.setPadding(j, FloatBaseChatItemLayout.q, i, FloatBaseChatItemLayout.r);
    if ((paramChatMessage instanceof MessageForText))
    {
      paramView = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          paramFloatBaseChatItemLayout.a.setText(localContext.getString(2131368542));
        }
      }
    }
    for (;;)
    {
      paramFloatBaseChatItemLayout.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramViewHolder;
      paramFloatBaseChatItemLayout.a.setText(localContext.getString(2131368541));
      continue;
      if (((MessageForText)paramChatMessage).locationUrl != null)
      {
        paramView = "[地理位置]" + ((MessageForText)paramChatMessage).location;
        paramFloatBaseChatItemLayout.a.setText(a(paramChatMessage, paramView));
      }
      else
      {
        paramChatMessage = paramView.getFloatSb();
        if (paramChatMessage != null)
        {
          paramFloatBaseChatItemLayout.a.setText(paramChatMessage);
        }
        else
        {
          paramFloatBaseChatItemLayout.a.setText(paramView.sb);
          continue;
          paramView = a(paramChatMessage, paramFloatBaseChatItemLayout.b);
          if (paramView == null) {
            paramFloatBaseChatItemLayout.a.setText(paramChatMessage.msg);
          } else {
            paramFloatBaseChatItemLayout.a.setText(paramView);
          }
        }
      }
    }
  }
  
  protected FloatBaseBubbleBuilder.ViewHolder a()
  {
    return new FloatTextItemBuilder.Holder(this);
  }
  
  public final MsgSummary a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary = new MsgSummary();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.a();
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = AIOUtils.a(paramView);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView.msg, paramView.uniseq);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage) {}
  
  protected void a(FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    FloatTextItemBuilder.Holder localHolder = (FloatTextItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131427945);
        localHolder.a.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label86;
        }
      }
      label86:
      for (paramViewHolder = paramView.getColorStateList(2131427944);; paramViewHolder = paramView.getColorStateList(2131427943))
      {
        localHolder.a.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131427942);
        break;
      }
    }
    if (paramBubbleInfo.e == 0) {
      localHolder.a.setTextColor(-16777216);
    }
    while (paramBubbleInfo.f == 0)
    {
      localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131427943));
      return;
      localHolder.a.setTextColor(paramBubbleInfo.e);
    }
    localHolder.a.setLinkTextColor(paramBubbleInfo.f);
  }
  
  protected void a(ChatMessage paramChatMessage, MsgSummary paramMsgSummary)
  {
    MsgUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramMsgSummary, null, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */