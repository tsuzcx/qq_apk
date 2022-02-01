package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import fts;
import ftt;
import ftu;
import ftv;
import ftw;
import ftx;
import fty;
import ftz;
import fua;
import fub;
import fuc;
import fud;
import fue;
import fuf;
import fug;
import fuh;
import fuk;
import ful;
import fum;
import fun;
import fuo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

public class GrayTipsItemBuilder
  extends AbstractChatItemBuilder
{
  private static final String b = "GrayTipsItemBuilder";
  private long a;
  
  public GrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Long = 0L;
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    Pattern localPattern = Pattern.compile("<a.*?/a>");
    paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
    int i = 0;
    while (paramCharSequence.find(i))
    {
      Object localObject3 = Pattern.compile(">.*?</a>").matcher(paramCharSequence.group());
      Object localObject1 = null;
      while (((Matcher)localObject3).find())
      {
        localObject2 = ((Matcher)localObject3).group().replaceAll(">|</a>", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "标题：" + (String)localObject2);
          localObject1 = localObject2;
        }
      }
      Matcher localMatcher = Pattern.compile("href=.*?>").matcher(paramCharSequence.group());
      Object localObject2 = null;
      while (localMatcher.find())
      {
        localObject3 = localMatcher.group().replaceAll("href=|>", "");
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "网址：" + (String)localObject3);
          localObject2 = localObject3;
        }
      }
      if ((localObject1 != null) && (localObject2 != null))
      {
        localSpannableStringBuilder.replace(paramCharSequence.start(), paramCharSequence.end(), localObject1);
        localSpannableStringBuilder.setSpan(new URLSpan((String)localObject2), paramCharSequence.start(), paramCharSequence.start() + localObject1.length(), 33);
        i = paramCharSequence.start() + localObject1.length();
        paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
        paramCharSequence.reset();
      }
    }
    return localSpannableStringBuilder;
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
      paramString.setSpan(new fuf(this), i, i + j, 33);
      return paramString;
      str = "对方通过" + paramString + "加你为好友，一起聊聊吧！";
      break;
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramString1.length() < paramInt)
    {
      paramTextView.setText(new SpannableString(paramString1));
      return;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.insert(paramInt, paramString2);
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(new ftv(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void b(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "讨论组已创建。\n";; paramString = paramString + "\n试试")
    {
      SpannableString localSpannableString = new SpannableString(paramString + "群组电话" + "吧，沟通更便捷。");
      localSpannableString.setSpan(new ftw(this), paramString.length(), (paramString + "群组电话").length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
      return;
    }
  }
  
  private void e(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131365756);
    int i = ((String)localObject).indexOf("群组电话");
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ftu(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void f(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131365753);
    int j = ((String)localObject).indexOf("QQ电话");
    int i = j;
    if (j < 0) {
      i = 10;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ftz(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void g(TextView paramTextView)
  {
    Object localObject = BaseApplicationImpl.getContext().getString(2131369856) + "\n";
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131369857);
    int j = ((String)localObject).length() + str.indexOf("取消收起");
    int i = j;
    if (j < 0) {
      i = 20;
    }
    localObject = new SpannableString(new SpannableString((String)localObject + str));
    ((SpannableString)localObject).setSpan(new fua(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void h(TextView paramTextView) {}
  
  private void i(TextView paramTextView)
  {
    int j = "羊年拜年，给好友发个QQ红包吧。".indexOf("Q");
    int i = j;
    if (j < 0) {
      i = 11;
    }
    SpannableString localSpannableString = new SpannableString("羊年拜年，给好友发个QQ红包吧。");
    localSpannableString.setSpan(new fub(this), i, j + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    fum localfum = (fum)paramViewHolder;
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903169, null);
      localfum.b = ((TextView)localView.findViewById(2131297202));
    }
    localfum.b.setMovementMethod(null);
    localfum.b.setGravity(17);
    String str1 = paramMessageRecord.msg;
    switch (paramMessageRecord.msgtype)
    {
    default: 
      localfum.b.setText(str1);
      return localView;
    case -1002: 
      if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
      }
      break;
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      paramLinearLayout = "";
      String str2 = "";
      paramView = str2;
      paramViewHolder = paramLinearLayout;
      if (paramMessageRecord != null)
      {
        paramView = str2;
        paramViewHolder = paramLinearLayout;
        if (paramMessageRecord.safeInfo != null)
        {
          paramViewHolder = paramMessageRecord.safeInfo.strFromMobile.get();
          paramView = paramMessageRecord.safeInfo.strFromName.get();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "strFromMobile" + paramViewHolder);
      }
      a(str1, paramViewHolder, paramView, localfum.b);
      localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
      return localView;
      if ((str1 != null) && (str1.length() > 0) && (str1.charAt(0) == '\026'))
      {
        paramMessageRecord = str1.split("\\|");
        label542:
        if ((paramMessageRecord == null) || (paramMessageRecord.length <= 0)) {
          break label2180;
        }
      }
      label2180:
      for (paramMessageRecord = paramMessageRecord[0].trim();; paramMessageRecord = str1)
      {
        localfum.b.setText(paramMessageRecord);
        localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return localView;
        paramMessageRecord = null;
        break label542;
        localfum.b.setText(str1);
        localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return localView;
        if (paramMessageRecord.istroop == 0)
        {
          f(localfum.b);
          return localView;
        }
        if ((paramMessageRecord instanceof MessageForGrayTips)) {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
          }
        }
        for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
        {
          if (paramMessageRecord != null)
          {
            localfum.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
            localfum.b.setClickable(true);
            localfum.b.setFocusable(true);
            localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
            return localView;
          }
          localfum.b.setText(str1);
          localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          return localView;
          localfum.b.setText(a(str1, true));
          localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          return localView;
          localfum.b.setText(a(str1, false));
          localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          return localView;
          if ((paramMessageRecord instanceof MessageForGrayTips)) {
            if (QLog.isColorLevel()) {
              QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
            }
          }
          for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
          {
            if (paramMessageRecord != null)
            {
              localfum.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
              localfum.b.setClickable(true);
              localfum.b.setFocusable(true);
              localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
              return localView;
            }
            localfum.b.setText(str1);
            localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
            localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
            return localView;
            paramMessageRecord = String.format(str1, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
            localfum.b.setText(paramMessageRecord);
            localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
            localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
            return localView;
            localfum.b.setText(a(str1));
            localfum.b.setGravity(3);
            localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
            localfum.b.setOnTouchListener(paramOnLongClickAndTouchListener);
            localfum.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
            return localView;
            paramMessageRecord = BaseApplicationImpl.getContext().getString(2131362486) + "\"" + str1 + "\"";
            localfum.b.setText(paramMessageRecord);
            return localView;
            localfum.b.setText(str1);
            return localView;
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131369213);
            paramOnLongClickAndTouchListener = this.jdField_a_of_type_AndroidContentContext.getString(2131369214);
            paramLinearLayout = this.jdField_a_of_type_AndroidContentContext.getString(2131369215);
            paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131369216);
            paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131369212);
            if (str1.contains(paramLinearLayout))
            {
              paramView = "CJCLUBT";
              paramViewHolder = paramMessageRecord;
              paramMessageRecord = paramLinearLayout;
            }
            for (;;)
            {
              paramMessageRecord = FileManagerUtil.a(str1, paramMessageRecord, new fts(this, paramViewHolder, paramView));
              localfum.b.setText(paramMessageRecord);
              localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
              localfum.b.setHighlightColor(17170445);
              return localView;
              if (str1.contains(paramViewHolder))
              {
                paramLinearLayout = "CJCLUBT";
                paramView = paramMessageRecord;
                paramMessageRecord = paramViewHolder;
                paramViewHolder = paramView;
                paramView = paramLinearLayout;
              }
              else
              {
                paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131369043);
                if (str1.contains(paramView))
                {
                  paramLinearLayout = "LTMCLUB";
                  paramViewHolder = paramMessageRecord;
                  paramMessageRecord = paramView;
                  paramView = paramLinearLayout;
                }
                else
                {
                  if (str1.contains(paramOnLongClickAndTouchListener))
                  {
                    paramView = "LTMCLUB";
                    paramViewHolder = paramMessageRecord;
                    paramMessageRecord = paramOnLongClickAndTouchListener;
                    continue;
                    a(localfum.b);
                    return localView;
                    g(localfum.b);
                    return localView;
                    localfum.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131369858));
                    return localView;
                    b(localfum.b);
                    return localView;
                    a(localfum.b, str1);
                    return localView;
                    localfum.b.setText("");
                    localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
                    localfum.b.setHighlightColor(17170445);
                    return localView;
                    paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131364879);
                    paramMessageRecord = paramViewHolder;
                    if (!str1.contains(paramViewHolder)) {
                      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131364880);
                    }
                    paramMessageRecord = FileManagerUtil.a(str1, paramMessageRecord, new fuc(this));
                    localfum.b.setText(paramMessageRecord);
                    localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
                    localfum.b.setHighlightColor(17170445);
                    return localView;
                    paramMessageRecord = FileManagerUtil.a(str1, this.jdField_a_of_type_AndroidContentContext.getString(2131362364), new fud(this));
                    localfum.b.setText(paramMessageRecord);
                    localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
                    localfum.b.setHighlightColor(17170445);
                    return localView;
                    b(localfum.b, paramMessageRecord.extStr);
                    return localView;
                    b(localfum.b, paramMessageRecord);
                    return localView;
                    e(localfum.b);
                    return localView;
                    paramMessageRecord = str1.split("\\|");
                    if (paramMessageRecord.length != 5) {
                      break;
                    }
                    a(localfum.b, paramMessageRecord[0], paramMessageRecord[1], Integer.parseInt(paramMessageRecord[2]), paramMessageRecord[3], paramMessageRecord[4]);
                    return localView;
                    c(localfum.b);
                    return localView;
                    i(localfum.b);
                    return localView;
                    if (QLog.isColorLevel()) {
                      QLog.d("GrayTipsItemBuilder", 2, "getItemView msgtype:-5000 istroop:" + paramMessageRecord.istroop + " msg:" + Utils.a(str1));
                    }
                    if ((paramMessageRecord instanceof MessageForNewGrayTips)) {}
                    for (paramMessageRecord = (MessageForNewGrayTips)paramMessageRecord; (paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0); paramMessageRecord = null)
                    {
                      paramViewHolder = new SpannableString(paramMessageRecord.msg);
                      if ((paramMessageRecord.spans != null) && (paramMessageRecord.spans.size() != 0))
                      {
                        paramMessageRecord = paramMessageRecord.spans.iterator();
                        while (paramMessageRecord.hasNext())
                        {
                          paramView = (GrayTipsSpan)paramMessageRecord.next();
                          try
                          {
                            paramViewHolder.setSpan(new URLSpan(paramView.url), paramView.begin, paramView.end, 33);
                          }
                          catch (Exception paramView)
                          {
                            paramView.printStackTrace();
                          }
                        }
                      }
                      localfum.b.setText(paramViewHolder);
                      localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
                      return localView;
                      h(localfum.b);
                      return localView;
                      if (!(paramMessageRecord instanceof MessageForIncompatibleGrayTips)) {
                        break;
                      }
                      paramMessageRecord = (MessageForIncompatibleGrayTips)paramMessageRecord;
                      paramView = paramMessageRecord.url;
                      if (QLog.isColorLevel()) {
                        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
                      }
                      paramViewHolder = new SpannableString(paramMessageRecord.msg);
                      paramView = new fue(this, paramView);
                      paramViewHolder.setSpan(new ForegroundColorSpan(2131427352), paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
                      paramViewHolder.setSpan(paramView, paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
                      localfum.b.setText(paramViewHolder);
                      localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
                      localfum.b.setHighlightColor(17170445);
                      return localView;
                      if ((paramMessageRecord instanceof MessageForGrayTips)) {
                        if (QLog.isColorLevel()) {
                          QLog.d("GrayTipsItemBuilder", 2, "getItemView MSG_TYPE_CONFIGURABLE_GRAY_TIPS");
                        }
                      }
                      for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
                      {
                        if (paramMessageRecord != null)
                        {
                          localfum.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
                          localfum.b.setClickable(true);
                          localfum.b.setFocusable(true);
                          localfum.b.setMovementMethod(LinkMovementMethod.getInstance());
                          return localView;
                        }
                        localfum.b.setText(str1);
                        return localView;
                        d(localfum.b);
                        return localView;
                        a(localfum.b, paramMessageRecord);
                        return localView;
                      }
                    }
                  }
                  paramView = "LTMCLUB";
                  paramViewHolder = paramMessageRecord;
                  paramMessageRecord = "";
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new fum(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131302479) {
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  void a(TextView paramTextView)
  {
    String str = BaseApplicationImpl.getContext().getString(2131369188) + "\n";
    SpannableString localSpannableString = new SpannableString(str + BaseApplicationImpl.getContext().getString(2131369121));
    localSpannableString.setSpan(new fuk(this), str.length(), localSpannableString.length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131369188) + "点击两次" + BaseApplicationImpl.getContext().getString(2131369121));
  }
  
  public void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype != -1046) {}
    do
    {
      do
      {
        return;
        long l1 = -1L;
        try
        {
          long l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("sens_msg_uniseq"));
          l1 = l2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            int n;
            int j;
            Object localObject7;
            boolean bool2;
            try
            {
              localObject4 = new bankcode_info.BankcodeCtrlInfo();
              j = k;
              ((bankcode_info.BankcodeCtrlInfo)localObject4).mergeFrom(HexUtil.a((String)localObject6));
              i = k;
              j = k;
              if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.has())
              {
                j = k;
                i = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.get();
              }
              j = i;
              if (((bankcode_info.BankcodeCtrlInfo)localObject4).fromuin_phonenum.has())
              {
                j = i;
                paramMessageRecord = ((bankcode_info.BankcodeCtrlInfo)localObject4).fromuin_phonenum.get();
              }
            }
            catch (Exception localException5)
            {
              MessageRecord localMessageRecord;
              int i1;
              int i3;
              int i2;
              Object localObject1;
              Object localObject2;
              Object localObject4;
              int m;
              boolean bool1;
              boolean bool3;
              k = 0;
              localSpannableString = null;
              paramMessageRecord = null;
              localObject3 = null;
              int i = j;
              j = k;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_conf_file_url.has()) {
                localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_conf_file_url.get();
              }
            }
            catch (Exception localException6)
            {
              j = 0;
              localSpannableString = null;
              localObject6 = null;
              localObject3 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject6;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_conf_file_md5.has()) {
                localObject2 = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_conf_file_md5.get();
              }
              m = i1;
            }
            catch (Exception localException7)
            {
              j = 0;
              localObject6 = null;
              localObject3 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject6;
              continue;
              continue;
              bool2 = false;
              continue;
              localObject7 = "0";
              continue;
              k = j;
              continue;
              k = 0;
              continue;
            }
            try
            {
              localObject6 = localMessageRecord.getExtInfoFromExtStr("sens_msg_attr");
              m = i1;
              bool1 = TextUtils.isEmpty((CharSequence)localObject6);
              if (bool1) {
                continue;
              }
              try
              {
                k = Integer.parseInt((String)localObject6);
                j = k;
                localObject6 = paramMessageRecord;
                paramMessageRecord = (MessageRecord)localObject2;
                if (j != 20) {
                  break label1280;
                }
                bool1 = true;
                localObject2 = localMessageRecord.getExtInfoFromExtStr("sens_msg_need_mask");
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  bool1 = Boolean.parseBoolean((String)localObject2);
                }
                if ((n == 0) && (bool1)) {
                  break label1280;
                }
                localObject7 = "1";
                bool3 = false;
                bool1 = false;
                bool2 = bool3;
                try
                {
                  localObject2 = paramTextView.getTag(2131296444);
                  if (localObject2 != null)
                  {
                    bool2 = bool3;
                    bool1 = ((Boolean)localObject2).booleanValue();
                  }
                  bool2 = bool1;
                  localObject2 = paramTextView.getTag(2131296445);
                  if (localObject2 == null) {
                    break label1274;
                  }
                  bool2 = bool1;
                  bool3 = ((Boolean)localObject2).booleanValue();
                  bool2 = bool3;
                }
                catch (Exception localException2)
                {
                  Bundle localBundle;
                  String str;
                  localException2.printStackTrace();
                  bool3 = false;
                  bool1 = bool2;
                  bool2 = bool3;
                  continue;
                  localObject3 = localException1;
                  Object localObject5 = paramMessageRecord;
                  if (!((String)localObject7).equalsIgnoreCase("0")) {
                    continue;
                  }
                  paramMessageRecord = (MessageRecord)localObject3;
                  localSpannableString = new SpannableString(paramMessageRecord);
                  if (localBundle == null) {
                    continue;
                  }
                  localObject3 = localBundle.keySet().iterator();
                  if (!((Iterator)localObject3).hasNext()) {
                    continue;
                  }
                  localObject7 = localBundle.getBundle((String)((Iterator)localObject3).next());
                  Object localObject8 = ((Bundle)localObject7).getString("Type");
                  localObject5 = ((Bundle)localObject7).getString("Name");
                  if ((paramMessageRecord.indexOf((String)localObject5) < 0) || ((((String)localObject8).equalsIgnoreCase("makePhoneCall")) && (TextUtils.isEmpty((CharSequence)localObject6)))) {
                    continue;
                  }
                  localObject7 = new fty(this, (String)localObject8, localMessageRecord, i, j, (String)localObject6, (Bundle)localObject7);
                  m = paramMessageRecord.indexOf((String)localObject5);
                  k = m;
                  if (m >= 0) {
                    continue;
                  }
                  k = 0;
                  localSpannableString.setSpan(localObject7, k, ((String)localObject5).length() + k, 33);
                  continue;
                  paramMessageRecord = (MessageRecord)localObject5;
                  continue;
                  paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
                  paramTextView.setText(localSpannableString);
                  return;
                }
                if ((!bool1) && (((String)localObject7).equalsIgnoreCase("0")))
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord.senderuin, "Tips_Show", "Mask", i, j, Long.toString(localMessageRecord.msgUid), Long.toString(localMessageRecord.uniseq), "", "");
                  paramTextView.setTag(2131296444, Boolean.valueOf(true));
                }
                if ((!bool2) && (((String)localObject7).equalsIgnoreCase("1")))
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord.senderuin, "Tips_Show", "Show", i, j, Long.toString(localMessageRecord.msgUid), Long.toString(localMessageRecord.uniseq), "", "");
                  paramTextView.setTag(2131296445, Boolean.valueOf(true));
                }
                localObject2 = null;
                localObject4 = null;
                AntiFraudConfigFileUtil.a().a(null, "SensMsgTipsCfg", (String)localObject1, paramMessageRecord);
                localBundle = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "TailWording", i, j);
                paramMessageRecord = (MessageRecord)localObject4;
                localObject1 = localObject2;
                if (localBundle != null)
                {
                  localObject1 = localBundle.getString("0");
                  paramMessageRecord = localBundle.getString("1");
                }
                localBundle = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "Action", i, j);
                if (localBundle == null) {
                  continue;
                }
                localObject8 = localBundle.keySet().iterator();
                localObject4 = paramMessageRecord;
                localObject2 = localObject1;
                if (!((Iterator)localObject8).hasNext()) {
                  continue;
                }
                localObject2 = (String)((Iterator)localObject8).next();
                localObject4 = localBundle.getBundle((String)localObject2).getString("Name");
                str = "$" + (String)localObject2;
                localObject2 = localObject1;
                if (localObject1 != null)
                {
                  localObject2 = localObject1;
                  if (((String)localObject1).contains(str)) {
                    localObject2 = ((String)localObject1).replace(str, (CharSequence)localObject4);
                  }
                }
                if ((paramMessageRecord == null) || (!paramMessageRecord.contains(str))) {
                  break label1271;
                }
                paramMessageRecord = paramMessageRecord.replace(str, (CharSequence)localObject4);
                localObject1 = localObject2;
                continue;
                localException1 = localException1;
                localException1.printStackTrace();
              }
              catch (Exception localException3)
              {
                m = i1;
                localException3.printStackTrace();
                k = i2;
                continue;
              }
              localException4.printStackTrace();
            }
            catch (Exception localException4)
            {
              j = m;
              localObject6 = localObject2;
              localObject2 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject6;
            }
            Object localObject6 = localObject2;
            continue;
            int k = i2;
            m = i1;
            if (localException4.bankcode_elems.has())
            {
              m = i1;
              localObject5 = localException4.bankcode_elems.get().iterator();
              j = i3;
              k = j;
              m = j;
              if (((Iterator)localObject5).hasNext())
              {
                m = j;
                localObject6 = (bankcode_info.BankcodeElem)((Iterator)localObject5).next();
                m = j;
                if (((bankcode_info.BankcodeElem)localObject6).bankcode_attr.has())
                {
                  m = j;
                  k = ((bankcode_info.BankcodeElem)localObject6).bankcode_attr.get();
                  if (k > j)
                  {
                    j = k;
                    continue;
                  }
                }
                Object localObject3;
                SpannableString localSpannableString;
                n = 0;
              }
            }
          }
        }
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, l1);
      } while (localMessageRecord == null);
      paramMessageRecord = localMessageRecord.getExtInfoFromExtStr("sens_msg_confirmed");
      if ((TextUtils.isEmpty(paramMessageRecord)) || (!paramMessageRecord.equalsIgnoreCase("1"))) {
        break label1301;
      }
      n = 1;
      k = -1;
      i1 = 0;
      i3 = 0;
      i2 = 0;
      paramMessageRecord = null;
      localObject1 = null;
      localObject2 = null;
      localObject6 = localMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty((CharSequence)localObject6));
    j = k;
  }
  
  void a(TextView paramTextView, String paramString)
  {
    String str1 = null;
    Object localObject;
    String str2;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = paramString.split("\\$");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTipMsg", 2, "splitResult is:" + Arrays.toString((Object[])localObject));
      }
      str2 = "";
      if (localObject.length >= 1)
      {
        if (!localObject[0].startsWith("ver=")) {
          break label194;
        }
        str2 = localObject[0].split("\\=")[1];
      }
      if (!str2.equals("1")) {
        break label202;
      }
      paramString = localObject[0];
      str1 = "语音通话";
    }
    for (;;)
    {
      label119:
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
        int i = paramString.indexOf((String)localObject);
        if ((str2.equals("1")) && (i < 0)) {
          i = paramString.indexOf("QQ电话");
        }
        for (;;)
        {
          if ((localObject == null) || (((String)localObject).trim().length() == 0) || (i < 0))
          {
            paramTextView.setText(paramString);
            return;
            label194:
            str2 = "1";
            break;
            label202:
            if (!str2.equals("2")) {
              break label292;
            }
            if (localObject.length >= 3)
            {
              paramString = localObject[1];
              str1 = localObject[2];
              break label119;
            }
            paramString = localObject[1];
            break label119;
          }
          paramString = new SpannableString(paramString);
          paramString.setSpan(new ftt(this), i, ((String)localObject).length() + i, 33);
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
      label292:
      paramString = null;
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, TextView paramTextView)
  {
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131367627) + "";
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131367628) + "";
    paramString1 = paramString1 + "";
    SpannableString localSpannableString = new SpannableString(paramString1);
    int i;
    int j;
    if (!TextUtils.isEmpty(str2))
    {
      i = paramString1.indexOf(str2);
      if (i >= 0)
      {
        j = str2.length();
        localSpannableString.setSpan(new fug(this), i, j + i, 33);
      }
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(str1)))
    {
      i = paramString1.indexOf(str1);
      if (i >= 0)
      {
        j = str1.length();
        localSpannableString.setSpan(new fuh(this, paramString3, paramString2), i, j + i, 33);
      }
    }
    paramTextView.setText(localSpannableString);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
  
  void b(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131366084);
    int i = ((String)localObject).indexOf("QQ电话");
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ful(this), i, "QQ电话".length() + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void b(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramMessageRecord.extStr)) {}
    do
    {
      return;
      paramMessageRecord = paramMessageRecord.extStr.split(":");
    } while (paramMessageRecord.length < 2);
    paramMessageRecord = String.format("你当前所在WiFi：%s，%s人正在热聊，", new Object[] { paramMessageRecord[0], paramMessageRecord[1] });
    SpannableString localSpannableString = new SpannableString(paramMessageRecord + "去看看吧！");
    localSpannableString.setSpan(new fun(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), paramMessageRecord.length(), (paramMessageRecord + "去看看吧！").length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void c(TextView paramTextView)
  {
    int j = "想要打字更快，试试搜狗输入法吧。".indexOf("搜");
    int i = j;
    if (j < 0) {
      i = 10;
    }
    SpannableString localSpannableString = new SpannableString("想要打字更快，试试搜狗输入法吧。");
    localSpannableString.setSpan(new fuo(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void d(TextView paramTextView)
  {
    paramTextView.setClickable(true);
    paramTextView.setText("为TA设置特别消息提示音,请点击");
    paramTextView.setOnClickListener(new ftx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */