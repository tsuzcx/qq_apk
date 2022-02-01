package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;

public abstract class FloatBaseBubbleBuilder
  implements View.OnClickListener, FloatChatItemBuilder
{
  public static int a = 0;
  private static final Handler a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  protected float a;
  public Context a;
  public SessionInfo a;
  public QQAppInterface a;
  
  static
  {
    jdField_a_of_type_Int = 255;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public FloatBaseBubbleBuilder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static Drawable a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (AnonymousChatHelper.a(paramChatMessage))
    {
      paramContext = paramContext.getResources().getDrawable(2130839451);
      return URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_Int), paramContext, paramContext);
    }
    if (paramChatMessage.isSend()) {
      paramContext = paramChatMessage.selfuin;
    }
    for (;;)
    {
      return FaceDrawable.a(paramQQAppInterface, 1, paramContext);
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004)) {
        paramContext = paramChatMessage.frienduin;
      } else {
        paramContext = paramChatMessage.senderuin;
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, FloatBaseChatItemLayout paramFloatBaseChatItemLayout, FloatBaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramChatMessage);
    paramViewHolder.jdField_a_of_type_Int = paramInt1;
    if (paramInt1 != 0)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, true);
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
      }
      if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
      {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(a(65));
        paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(a(34));
      }
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramViewHolder.jdField_a_of_type_AndroidViewView);
      }
      a(paramViewHolder, paramFloatBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      a(paramViewHolder, paramChatMessage);
    }
    for (;;)
    {
      paramFloatBaseChatItemLayout.setBubbleView(paramViewHolder.jdField_a_of_type_AndroidViewView);
      return;
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
    }
  }
  
  private void c(ChatMessage paramChatMessage, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    if (AnonymousChatHelper.a(paramChatMessage))
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839451);
      paramFloatBaseChatItemLayout.setHeaderIcon(URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_Int), localDrawable, localDrawable));
      return;
    }
    if (paramChatMessage.isSend()) {
      paramChatMessage = paramChatMessage.selfuin;
    }
    for (;;)
    {
      paramFloatBaseChatItemLayout.setHeaderIcon(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramChatMessage));
      return;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004)) {
        paramChatMessage = paramChatMessage.frienduin;
      } else {
        paramChatMessage = paramChatMessage.senderuin;
      }
    }
  }
  
  private void d(ChatMessage paramChatMessage, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    String str = null;
    boolean bool2 = true;
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
      if (paramChatMessage.isMultiMsg)
      {
        str = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((str != null) && (str.length() != 0)) {
          break label215;
        }
        str = paramChatMessage.senderuin;
        label70:
        if (!AnonymousChatHelper.a(paramChatMessage)) {
          break label269;
        }
        str = AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_JavaLangString;
      }
    }
    label269:
    for (int i = 1;; i = 0)
    {
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427946);
      boolean bool1;
      if (((str != null) && (!paramChatMessage.isSend())) || (i != 0))
      {
        bool1 = true;
        label121:
        if ((i == 0) || (!AnonymousChatHelper.b(paramChatMessage))) {
          break label246;
        }
      }
      for (;;)
      {
        paramFloatBaseChatItemLayout.a(bool1, str, localColorStateList, bool2);
        return;
        if (paramChatMessage.istroop == 1)
        {
          str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
          break;
        }
        if (3000 != paramChatMessage.istroop) {
          break;
        }
        str = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramChatMessage.frienduin, paramChatMessage.senderuin);
        break;
        label215:
        str = str + ":";
        break label70;
        bool1 = false;
        break label121;
        label246:
        bool2 = false;
      }
      paramFloatBaseChatItemLayout.a(false, null, null, false);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      return;
    }
  }
  
  protected int a(int paramInt)
  {
    return (int)(paramInt * this.jdField_a_of_type_Float + 0.5F);
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup)
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    paramView = (FloatBaseChatItemLayout)paramView;
    if (paramView == null)
    {
      paramView = new FloatBaseChatItemLayout(localContext);
      paramView.setId(2131296391);
      paramView.setFocusableInTouchMode(true);
      paramView.setPadding(FloatBaseChatItemLayout.n, FloatBaseChatItemLayout.p, FloatBaseChatItemLayout.o, 0);
      paramViewGroup = a();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout = paramView;
      paramViewGroup.jdField_b_of_type_Int = paramInt1;
      paramViewGroup.c = paramInt2;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.isSend()) {
        break label193;
      }
    }
    label193:
    for (int i = 1;; i = 0)
    {
      paramView.setHearIconPosition(i);
      c(paramChatMessage, paramView);
      d(paramChatMessage, paramView);
      a(paramChatMessage, paramView);
      b(paramChatMessage, paramView);
      paramViewGroup.jdField_a_of_type_AndroidViewView = a(paramChatMessage, paramViewGroup, paramViewGroup.jdField_a_of_type_AndroidViewView, paramView);
      a(paramChatMessage, localContext, paramView, paramViewGroup, paramInt1, paramInt2);
      paramView.requestLayout();
      return paramView;
      paramViewGroup = (FloatBaseBubbleBuilder.ViewHolder)paramView.getTag();
      break;
    }
  }
  
  protected abstract View a(ChatMessage paramChatMessage, FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, FloatBaseChatItemLayout paramFloatBaseChatItemLayout);
  
  protected abstract FloatBaseBubbleBuilder.ViewHolder a();
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c();
    }
  }
  
  public void a(long paramLong)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("target_activity", ChatActivity.class);
    localIntent.putExtra("tab_index", 1);
    localIntent.addFlags(335544320);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("msg_uni_seq", paramLong);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  protected void a(View paramView) {}
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(FloatBaseChatItemLayout.l, FloatBaseChatItemLayout.i, FloatBaseChatItemLayout.k, FloatBaseChatItemLayout.j);
      return;
    }
    paramView.setPadding(FloatBaseChatItemLayout.k, FloatBaseChatItemLayout.i, FloatBaseChatItemLayout.l, FloatBaseChatItemLayout.j);
  }
  
  protected void a(FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  protected void a(FloatBaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  protected void a(FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    if ((paramFloatBaseChatItemLayout.getParent() instanceof ListView))
    {
      paramFloatBaseChatItemLayout = ((ListView)paramFloatBaseChatItemLayout.getParent()).getAdapter();
      if ((paramFloatBaseChatItemLayout instanceof BaseAdapter)) {
        ((BaseAdapter)paramFloatBaseChatItemLayout).notifyDataSetChanged();
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    paramFloatBaseChatItemLayout.setProgressVisable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage));
  }
  
  protected boolean a(ChatMessage paramChatMessage, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  protected void b(ChatMessage paramChatMessage, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramFloatBaseChatItemLayout))
    {
      paramFloatBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    paramFloatBaseChatItemLayout.setFailedIconVisable(false, null);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatBaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */