package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import glt;
import glu;
import glv;

public class FloatGrayTipsItemBuilder
  extends FloatAbstractChatItemBuilder
{
  public FloatGrayTipsItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private CharSequence a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramBoolean)
    {
      str = "通过" + paramString + "加的新朋友，一起聊聊吧！";
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = "通过".length();; i = "对方通过".length())
    {
      int j = paramString.length();
      paramString = new SpannableString(str);
      paramString.setSpan(new glu(this), i, i + j, 33);
      return paramString;
      str = "对方通过" + paramString + "加你为好友，一起聊聊吧！";
      break;
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, FloatAbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout)
  {
    Object localObject = null;
    glv localglv = (glv)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903320, null);
      localglv.b = ((TextView)paramViewHolder.findViewById(2131297202));
    }
    localglv.b.setMovementMethod(null);
    localglv.b.setGravity(17);
    String str = paramMessageRecord.msg;
    switch (paramMessageRecord.msgtype)
    {
    default: 
      localglv.b.setText(str);
    case -4010: 
      return paramViewHolder;
    case -1001: 
      paramMessageRecord = localObject;
      if (str != null)
      {
        paramMessageRecord = localObject;
        if (str.length() > 0)
        {
          paramMessageRecord = localObject;
          if (str.charAt(0) == '\026') {
            paramMessageRecord = str.split("\\|");
          }
        }
      }
      paramView = str;
      if (paramMessageRecord != null)
      {
        paramView = str;
        if (paramMessageRecord.length > 0) {
          paramView = paramMessageRecord[0].trim();
        }
      }
      localglv.b.setText(paramView);
      return paramViewHolder;
    case -1004: 
      localglv.b.setText(str);
      return paramViewHolder;
    case -1013: 
      if (paramMessageRecord.istroop == 0)
      {
        paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131365753);
        localglv.b.setText(paramMessageRecord);
        return paramViewHolder;
      }
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
    }
    for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord != null)
      {
        localglv.b.setText(paramMessageRecord.getHightlightMsgText4Float(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
        return paramViewHolder;
      }
      localglv.b.setText(str);
      return paramViewHolder;
      localglv.b.setText(a(str, true));
      return paramViewHolder;
      localglv.b.setText(a(str, false));
      return paramViewHolder;
      if ((paramMessageRecord instanceof MessageForGrayTips)) {}
      for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
      {
        if (paramMessageRecord != null)
        {
          localglv.b.setText(paramMessageRecord.getHightlightMsgText4Float(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
          return paramViewHolder;
        }
        localglv.b.setText(str);
        return paramViewHolder;
        paramMessageRecord = String.format(str, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        localglv.b.setText(paramMessageRecord);
        return paramViewHolder;
        paramMessageRecord = BaseApplicationImpl.getContext().getString(2131362486) + "\"" + str + "\"";
        localglv.b.setText(paramMessageRecord);
        return paramViewHolder;
        localglv.b.setText(str);
        return paramViewHolder;
        localglv.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131369858));
        return paramViewHolder;
        if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
          break;
        }
        paramMessageRecord = paramMessageRecord.extStr.split(":");
        if (paramMessageRecord.length < 2) {
          break;
        }
        paramMessageRecord = String.format("你当前所在WiFi：%s，%s人正在热聊，", new Object[] { paramMessageRecord[0], paramMessageRecord[1] });
        localglv.b.setText(paramMessageRecord);
        return paramViewHolder;
        localglv.b.setText("羊年拜年，给好友发个QQ红包吧。");
        return paramViewHolder;
        if ((paramMessageRecord instanceof MessageForNewGrayTips)) {}
        for (paramMessageRecord = (MessageForNewGrayTips)paramMessageRecord; (paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0); paramMessageRecord = null)
        {
          localglv.b.setText(paramMessageRecord.msg);
          return paramViewHolder;
          if (!(paramMessageRecord instanceof MessageForIncompatibleGrayTips)) {
            break;
          }
          paramMessageRecord = (MessageForIncompatibleGrayTips)paramMessageRecord;
          paramView = paramMessageRecord.url;
          paramView = new SpannableString(paramMessageRecord.msg);
          paramLinearLayout = new glt(this);
          paramView.setSpan(new ForegroundColorSpan(2131427352), paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
          paramView.setSpan(paramLinearLayout, paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
          localglv.b.setText(paramView);
          localglv.b.setMovementMethod(LinkMovementMethod.getInstance());
          localglv.b.setHighlightColor(17170445);
          return paramViewHolder;
          if ((paramMessageRecord instanceof MessageForGrayTips)) {}
          for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
          {
            if (paramMessageRecord != null)
            {
              localglv.b.setText(paramMessageRecord.getHightlightMsgText4Float(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
              return paramViewHolder;
            }
            localglv.b.setText(str);
            return paramViewHolder;
          }
        }
      }
    }
  }
  
  protected FloatAbstractChatItemBuilder.ViewHolder a()
  {
    return new glv(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatGrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */