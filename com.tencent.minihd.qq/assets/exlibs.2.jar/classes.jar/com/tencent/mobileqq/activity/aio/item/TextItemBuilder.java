package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import fxb;
import fxc;
import fxd;
import fxe;

public class TextItemBuilder
  extends BaseBubbleBuilder
{
  private static final int f = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int g = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int h = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private static final int i = BaseChatItemLayout.l + BaseChatItemLayout.q;
  private View.OnClickListener a;
  
  public TextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fxb(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_AndroidContentContext;
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new ETTextView(paramBaseChatItemLayout);
      paramViewHolder.setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131427942));
      paramViewHolder.setLinkTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131427941));
      paramViewHolder.setSpannableFactory(QQText.a);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131297062);
      localHolder.a = paramViewHolder;
    }
    ((ETTextView)localHolder.a).setMaxWidth(BaseChatItemLayout.f);
    ((ETTextView)localHolder.a).setFont(0, paramChatMessage.uniseq);
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)localHolder.a).a();
      if (paramView != null) {
        paramView.a = (paramChatMessage.uniseq + 1L);
      }
    }
    localHolder.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.p;
    int j = BaseChatItemLayout.q;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.q;
      j = BaseChatItemLayout.p;
    }
    localHolder.a.setPadding(k, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    if ((paramChatMessage instanceof MessageForText))
    {
      paramView = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          localHolder.a.setText(paramBaseChatItemLayout.getString(2131368542));
        }
      }
    }
    for (;;)
    {
      localHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
      localHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localHolder.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((localHolder.a instanceof AnimationTextView)) {
        ((AnimationTextView)localHolder.a).a = new fxc(this);
      }
      return paramViewHolder;
      localHolder.a.setText(paramBaseChatItemLayout.getString(2131368541));
      continue;
      localHolder.a.setText(paramView.sb);
      continue;
      localHolder.a.setText(paramChatMessage.msg);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      return "说" + ((MessageForText)paramChatMessage).sb;
    }
    return "说" + paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
    case 2131302479: 
    case 2131302484: 
      do
      {
        do
        {
          return;
          ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
        } while (paramChatMessage.msg == null);
        try
        {
          ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage.msg);
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramContext.toString());
      return;
    case 2131302485: 
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
      return;
    case 2131298174: 
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      paramContext = (MessageForText)paramChatMessage;
      if (paramContext.sb != null) {}
      for (paramContext = paramContext.sb.toString();; paramContext = paramContext.msg)
      {
        localBundle.putString("forward_text", paramContext);
        paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        paramContext.putExtras(localBundle);
        paramContext.putExtra("display_like_dialog", true);
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramContext, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        return;
      }
    case 2131302493: 
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      paramContext.putExtra("url", "https://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131298924: 
      b(paramChatMessage);
      return;
    }
    a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131366317);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131366318);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new fxd(this, paramView), new fxe(this)).show();
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
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramViewHolder;
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
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
    if ((paramViewHolder.a instanceof ETTextView))
    {
      int j = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(paramChatMessage);
      ((ETTextView)paramViewHolder.a).setFont(j, paramChatMessage.uniseq);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForText)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131302484, "复制");
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localQQCustomMenu.a(2131302485, this.jdField_a_of_type_AndroidContentContext.getString(2131366397));
    }
    localQQCustomMenu.a(2131298174, this.jdField_a_of_type_AndroidContentContext.getString(2131367595));
    localQQCustomMenu.a(2131298924, this.jdField_a_of_type_AndroidContentContext.getString(2131364620));
    a(localQQCustomMenu);
    if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
      localQQCustomMenu.a(2131302493, this.jdField_a_of_type_AndroidContentContext.getString(2131368759));
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return localQQCustomMenu.a();
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    QfavBuilder.a(null, paramChatMessage.msg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder
 * JD-Core Version:    0.7.0.1
 */