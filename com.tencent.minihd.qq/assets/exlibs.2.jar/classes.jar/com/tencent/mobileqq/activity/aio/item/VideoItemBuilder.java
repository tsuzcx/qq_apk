package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.qphone.base.util.QLog;
import fxr;
import fxs;

public class VideoItemBuilder
  extends BaseBubbleBuilder
{
  private static final int f = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int g = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int h = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private static final int i = BaseChatItemLayout.l + BaseChatItemLayout.q;
  private View.OnClickListener a;
  
  public VideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fxr(this);
  }
  
  private void a(View paramView, MessageForVideo paramMessageForVideo, boolean paramBoolean, int paramInt)
  {
    IconPopupWindow localIconPopupWindow = new IconPopupWindow(this.jdField_a_of_type_AndroidContentContext);
    if (paramMessageForVideo.isVideo) {
      localIconPopupWindow.a(2131366477, new VideoItemBuilder.IconPopupWindowCallback(this, paramMessageForVideo, paramBoolean, paramInt));
    }
    for (;;)
    {
      localIconPopupWindow.a(paramView, 4);
      return;
      localIconPopupWindow.a(2131366480, new VideoItemBuilder.IconPopupWindowCallback(this, paramMessageForVideo, paramBoolean, paramInt));
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int j = localDrawable.getIntrinsicWidth();
    paramInt = localDrawable.getIntrinsicHeight();
    switch (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    }
    for (;;)
    {
      localDrawable.setBounds(0, 0, j, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.s);
      return;
      int k = localResources.getDimensionPixelSize(2131493601);
      int m = localResources.getDimensionPixelSize(2131493602);
      j = j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / k + m;
      paramInt = paramInt * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / k + m;
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    int k = 0;
    Object localObject1 = "";
    if (paramMessageForVideo == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgAccDescription-->message is null");
      }
    }
    do
    {
      return;
      if ((paramMessageForVideo.senderuin != null) && (paramMessageForVideo.selfuin != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgAccDescription-->uin is null");
    return;
    Object localObject2;
    label110:
    int m;
    int j;
    if (paramMessageForVideo.selfuin.equals(paramMessageForVideo.senderuin))
    {
      localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject2 = new StringBuilder().append((String)localObject1);
        if (!paramMessageForVideo.isVideo) {
          break label449;
        }
        localObject1 = "视频电话,";
        localObject2 = (String)localObject1;
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131362857))) {
        break label501;
      }
      localObject2 = paramMessageForVideo.text;
      paramContext = paramContext.getResources().getString(2131362857) + ",";
      localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
      if (localObject2.length != 3) {
        break label457;
      }
      m = Integer.valueOf(localObject2[0]).intValue();
      k = Integer.valueOf(localObject2[1]).intValue();
      j = Integer.valueOf(localObject2[2]).intValue();
    }
    for (;;)
    {
      label272:
      if ((m > 0) || (k > 0) || (j > 0)) {
        if (m <= 0) {
          break label627;
        }
      }
      label396:
      label449:
      label457:
      label627:
      for (localObject1 = paramContext + m + "小时,";; localObject1 = paramContext)
      {
        paramContext = (Context)localObject1;
        if (k > 0) {
          paramContext = (String)localObject1 + k + "分,";
        }
        localObject1 = paramContext;
        if (j > 0) {
          localObject1 = paramContext + j + "秒";
        }
        if (paramMessageForVideo.isVideo)
        {
          paramMessageForVideo = "视频电话,";
          localObject1 = paramMessageForVideo + (String)localObject1;
        }
        for (;;)
        {
          paramView.setContentDescription(((String)localObject1).replace("点击", "双击"));
          return;
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
          break;
          localObject1 = "QQ电话,";
          break label110;
          if (localObject2.length != 2) {
            break label633;
          }
          k = Integer.valueOf(localObject2[0]).intValue();
          j = Integer.valueOf(localObject2[1]).intValue();
          m = 0;
          break label272;
          paramMessageForVideo = "QQ电话,";
          break label396;
          label501:
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131362860)))
          {
            paramContext = paramContext.getResources();
            if (paramMessageForVideo.isVideo) {}
            for (j = 2131362939;; j = 2131362882)
            {
              localObject1 = paramContext.getString(j);
              break;
            }
          }
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131362784))) {
            localObject1 = paramContext.getResources().getString(2131362791);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131362790))) {
            localObject1 = paramContext.getResources().getString(2131362791);
          }
        }
      }
      label633:
      j = 0;
      m = 0;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    fxs localfxs = (fxs)paramViewHolder;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131297062);
      paramViewHolder.setTextColor(localResources.getColorStateList(2131427942));
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131492882));
      paramViewHolder.setGravity(16);
      localfxs.a = paramViewHolder;
    }
    paramChatMessage = (MessageForVideo)paramChatMessage;
    localfxs.a.setText(paramChatMessage.text);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new fxs(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了视频";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131302479) {
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(i, f, h, g);
      return;
    }
    paramView.setPadding(h, f, i, g);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    fxs localfxs = (fxs)paramViewHolder;
    localfxs.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (localfxs.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131362856)))
      {
        paramViewHolder = paramView.getColorStateList(2131427999);
        localfxs.a.setTextColor(paramViewHolder);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131427945);
        localfxs.a.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (paramViewHolder = paramView.getColorStateList(2131427944);; paramViewHolder = paramView.getColorStateList(2131427943))
      {
        localfxs.a.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131427942);
        break;
      }
    }
    if (paramBubbleInfo.e == 0) {
      localfxs.a.setTextColor(-16777216);
    }
    while (paramBubbleInfo.f == 0)
    {
      localfxs.a.setLinkTextColor(paramView.getResources().getColorStateList(2131427943));
      return;
      localfxs.a.setTextColor(paramBubbleInfo.e);
    }
    localfxs.a.setLinkTextColor(paramBubbleInfo.f);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */