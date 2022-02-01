package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class MsgUtils
{
  private static final int a = 16;
  
  private static int a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    int i;
    if (paramMessage == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
      i = j;
    } while (j != -1);
    Object localObject = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (localObject != null)
    {
      if (((FileManagerEntity)localObject).fProgress == 1.0D) {
        return 1;
      }
      return ((FileManagerEntity)localObject).status;
    }
    localObject = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.a(), paramMessage.frienduin });
    ((EntityManager)localObject).a();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = FileManagerUtil.c(paramQQAppInterface.status);
    if (paramQQAppInterface.status == 2) {
      paramQQAppInterface.status = 0;
    }
    return paramQQAppInterface.status;
  }
  
  private static SpannableStringBuilder a(CharSequence paramCharSequence1, String paramString, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    paramDrawable1 = new StringBuffer();
    if (paramCharSequence1 != null) {
      paramDrawable1.append(paramCharSequence1).append(": ");
    }
    for (int j = paramDrawable1.length();; j = 0)
    {
      int i;
      if (paramBoolean1)
      {
        paramDrawable1.append("F ");
        i = paramDrawable1.length();
      }
      for (;;)
      {
        if (paramString != null) {
          paramDrawable1.append(paramString);
        }
        if (paramCharSequence2 != null) {
          paramDrawable1.append(paramCharSequence2);
        }
        paramCharSequence1 = new SpannableStringBuilder(paramDrawable1.toString());
        if (paramBoolean1)
        {
          paramDrawable3.setBounds(0, 0, paramDrawable3.getIntrinsicWidth() * 2 / 3, paramDrawable3.getIntrinsicHeight() * 2 / 3);
          paramCharSequence1.setSpan(new ImageSpan(paramDrawable3), j, i, 33);
        }
        while (!paramBoolean2)
        {
          return paramCharSequence1;
          if (!paramBoolean2) {
            break label210;
          }
          paramDrawable1.append("S ");
          i = paramDrawable1.length();
          break;
        }
        paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth() * 2 / 3, paramDrawable2.getIntrinsicHeight() * 2 / 3);
        paramCharSequence1.setSpan(new ImageSpan(paramDrawable2), j, i, 33);
        return paramCharSequence1;
        label210:
        i = 0;
      }
    }
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue))) {
      return paramMessage.actMsgContentValue;
    }
    paramContext = paramQQAppInterface.a().a(AppShareIDUtil.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.a().getString(2131368378);
    }
    return paramQQAppInterface.a().getString(2131368376) + paramContext.messagetail + paramQQAppInterface.a().getString(2131368377);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return paramQQAppInterface.a().getString(2131368378);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    String str1;
    if (SystemMsg.isSystemMessage(paramMessageRecord.msgtype))
    {
      str1 = null;
      switch (paramMessageRecord.msgtype)
      {
      default: 
        paramContext = str1;
        String str2 = TroopSystemMsgUtil.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessageRecord.senderuin, true);
              if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramMessageRecord.senderuin))) {
                break label274;
              }
              paramString = new StringBuilder();
              paramString.append(paramQQAppInterface).append(paramContext);
              str1 = paramString.toString();
            }
          }
        }
        break;
      }
    }
    label274:
    label439:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return str1;
                  paramContext = paramContext.getString(2131367193);
                  break;
                  paramContext = paramContext.getString(2131367194);
                  break;
                  paramContext = paramContext.getString(2131367195);
                  break;
                  paramContext = paramContext.getString(2131367202);
                  break;
                  paramContext = paramContext.getString(2131367203);
                  break;
                  return paramMessageRecord.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessageRecord.msgtype));
                if ((paramMessageRecord.msgtype != -1020) && (paramMessageRecord.msgtype != 84) && (paramMessageRecord.msgtype != 35) && (paramMessageRecord.msgtype != -1023) && (paramMessageRecord.msgtype != 87) && (paramMessageRecord.msgtype != 46)) {
                  break label439;
                }
                paramContext = TroopSystemMsgUtil.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return TroopSystemMsgUtil.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessageRecord.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessageRecord.msgtype != -1022);
    label462:
    paramString = TroopSystemMsgUtil.a(paramString, paramQQAppInterface);
    paramMessageRecord = TroopSystemMsgUtil.b(paramString);
    paramContext = paramString;
    if (paramMessageRecord != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessageRecord.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessageRecord) == 1)
        {
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessageRecord, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = TroopSystemMsgUtil.a(paramString, paramMessageRecord, paramQQAppInterface);
            }
          }
        }
      }
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramString;
      localObject = Pattern.compile("(|(\\d{2}):)(\\d{2}):(\\d{2})$").matcher(paramString);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() < 4));
    String str1 = ((Matcher)localObject).group(0);
    String str2 = ((Matcher)localObject).group(1);
    int i = j;
    if (str2 != null)
    {
      i = j;
      if (str2.length() > 0) {
        i = Integer.parseInt(((Matcher)localObject).group(2));
      }
    }
    j = Integer.parseInt(((Matcher)localObject).group(3));
    int k = Integer.parseInt(((Matcher)localObject).group(4));
    Object localObject = new StringBuffer();
    if (i > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131365798));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131365801));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131365802));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramArrayOfString == null) {
      paramQQAppInterface = "";
    }
    for (;;)
    {
      return paramQQAppInterface;
      if (((paramInt == 1) || (paramInt != 5000)) || (paramArrayOfString.length > 1)) {}
      try
      {
        Integer.parseInt(paramArrayOfString[1]);
        label36:
        paramQQAppInterface = paramContext.getResources().getString(2131362793);
        if ((paramInt != 1) && (paramInt != 5000)) {
          continue;
        }
        return paramContext.getResources().getString(2131362794);
        return "";
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        break label36;
      }
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append("[文件]");
    return localStringBuilder.toString();
  }
  
  public static String a(String[] paramArrayOfString, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayOfString == null) {
      return "";
    }
    if (paramArrayOfString.length > 1) {}
    try
    {
      Integer.parseInt(paramArrayOfString[1]);
      label20:
      if ((paramArrayOfString.length > 3) && ("1".equals(paramArrayOfString[3]))) {}
      return "";
      return "";
    }
    catch (NumberFormatException paramContext)
    {
      break label20;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessage == null) {
      return;
    }
    if ((AnonymousChatHelper.a(paramMessage)) && ((TextUtils.isEmpty(paramString)) || (!paramString.equals(ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, true))))) {
      paramString = AnonymousChatHelper.a(paramMessage).b;
    }
    for (;;)
    {
      Object localObject1 = paramString;
      if (!paramBoolean1) {
        if (!paramMessage.isSendFromLocal())
        {
          localObject1 = paramString;
          if (paramMessage.selfuin != null)
          {
            localObject1 = paramString;
            if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      if (paramMessage.msgtype == -2005) {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 12) {
          localObject2 = ((String)localObject1).substring(0, 11) + "...";
        }
      }
      if (paramMessage.msgtype == -2011)
      {
        paramBoolean1 = a(paramQQAppInterface, paramMessage);
        paramBoolean2 = b(paramQQAppInterface, paramMessage);
        a((CharSequence)localObject2, null, paramMessage.msg, paramBoolean1, paramBoolean2, paramMsgSummary);
        return;
      }
      boolean bool;
      if (paramMessage.msgtype == -2000)
      {
        paramBoolean2 = false;
        bool = false;
      }
      label2210:
      label2377:
      label2380:
      label2392:
      label2401:
      label2407:
      for (;;)
      {
        long l;
        try
        {
          paramString = paramMessage.frienduin;
          if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
            break label2407;
          }
          paramString = paramMessage.senderuin;
          localObject1 = (MessageForPic)paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
          paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramMessage.uniseq);
        }
        catch (Exception paramMessage)
        {
          paramQQAppInterface = null;
        }
        try
        {
          if ((!paramMessage.isSendFromLocal()) || (paramQQAppInterface != null) || (localObject1 == null)) {
            continue;
          }
          l = ((MessageForPic)localObject1).size;
          if (l > 0L) {
            continue;
          }
          paramBoolean1 = true;
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            continue;
            paramContext = paramString;
            continue;
            continue;
            paramBoolean1 = false;
            continue;
            paramBoolean1 = false;
          }
          paramBoolean1 = false;
          continue;
          paramBoolean1 = false;
          continue;
        }
        paramBoolean2 = paramBoolean1;
        if ((paramQQAppInterface instanceof BaseTransProcessor))
        {
          paramQQAppInterface = (BaseTransProcessor)paramQQAppInterface;
          if (paramQQAppInterface.c() != 1003L)
          {
            paramBoolean1 = true;
            if (QLog.isColorLevel())
            {
              if (paramQQAppInterface.a != null)
              {
                l = paramQQAppInterface.a.a;
                QLog.d("sendingpic", 2, "uniseq:" + l + ",key:" + paramQQAppInterface.a());
              }
            }
            else
            {
              a((CharSequence)localObject2, paramContext.getString(2131368066), null, paramBoolean2, paramBoolean1, paramMsgSummary);
              return;
              if ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof BaseTransProcessor))) {
                break label2401;
              }
              l = ((BaseTransProcessor)paramQQAppInterface).c();
              paramInt = (int)l;
              if ((paramInt != 1005) && (paramInt != 1004)) {
                break label2401;
              }
              paramBoolean1 = true;
              continue;
              paramMessage.printStackTrace();
              continue;
            }
            l = -1L;
            continue;
          }
        }
        else
        {
          paramBoolean1 = bool;
          if (paramQQAppInterface == null) {
            continue;
          }
          bool = true;
          paramBoolean1 = bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("sendingpic", 2, "processor:" + paramQQAppInterface);
          paramBoolean1 = bool;
          continue;
          if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
          {
            paramString = paramMessage.frienduin;
            if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
              break label2392;
            }
            paramString = paramMessage.senderuin;
            paramBoolean2 = false;
            paramContext = paramContext.getString(2131368067);
            localObject1 = paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
            if ((localObject1 instanceof MessageForPtt))
            {
              localObject1 = (MessageForPtt)localObject1;
              if (paramMessage.isSendFromLocal())
              {
                if (((MessageForPtt)localObject1).fileSize == -1L)
                {
                  paramBoolean1 = true;
                  DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
                  a((CharSequence)localObject2, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                  return;
                }
                if (((MessageForPtt)localObject1).fileSize <= 0L)
                {
                  paramInt = paramQQAppInterface.a().d(paramString, ((MessageForPtt)localObject1).url, ((MessageForPtt)localObject1).uniseq);
                  if ((paramInt == 1005) || (paramInt == 1004) || (paramInt == -1))
                  {
                    paramBoolean2 = true;
                    paramBoolean1 = false;
                  }
                  for (;;)
                  {
                    DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Long.valueOf(((MessageForPtt)localObject1).fileSize), Integer.valueOf(paramInt) });
                    bool = paramBoolean1;
                    paramBoolean1 = paramBoolean2;
                    paramBoolean2 = bool;
                    break;
                    paramBoolean1 = true;
                    paramBoolean2 = false;
                  }
                }
              }
            }
          }
          else
          {
            if (paramMessage.msgtype == -3008)
            {
              paramMsgSummary.b = (paramContext.getString(2131362486) + "\"" + paramMessage.msg + "\"");
              return;
            }
            if (paramMessage.msgtype == -2015)
            {
              paramMsgSummary.b = "";
              return;
            }
            if (ActionMsgUtil.a(paramMessage.msgtype))
            {
              a((CharSequence)localObject2, a(paramContext, paramQQAppInterface, paramMessage), null, a(paramQQAppInterface, paramMessage), b(paramQQAppInterface, paramMessage), paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2017)
            {
              a((CharSequence)localObject2, paramContext.getString(2131363971), null, a(paramQQAppInterface, paramMessage), b(paramQQAppInterface, paramMessage), paramMsgSummary);
              return;
            }
            if (ActionMsgUtil.b(paramMessage.msgtype))
            {
              paramQQAppInterface = TransfileUtile.a(paramMessage.msg);
              if (paramQQAppInterface == null) {
                break;
              }
              paramMsgSummary.b = a(paramQQAppInterface, paramContext, b(paramMessage.issend), paramBoolean2);
              return;
            }
            if (ActionMsgUtil.c(paramMessage.msgtype))
            {
              paramString = TransfileUtile.a(paramMessage.msg);
              if (paramString == null) {
                break;
              }
              paramMsgSummary.b = a(paramQQAppInterface, paramString, paramContext, paramMessage.frienduin, paramMessage.senderuin, paramInt);
              return;
            }
            if (ActionMsgUtil.d(paramMessage.msgtype))
            {
              a((CharSequence)localObject2, paramContext.getString(2131368619), null, a(paramQQAppInterface, paramMessage), b(paramQQAppInterface, paramMessage), paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1013)
            {
              a(null, null, MessageForGrayTips.getOrginMsg(paramMessage.msg), false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1034)
            {
              paramContext = new MessageForRichState();
              paramContext.msg = paramMessage.msg;
              paramContext.parse();
              paramQQAppInterface = new StringBuilder();
              if (!TextUtils.isEmpty(paramContext.actionText))
              {
                paramQQAppInterface.append(paramContext.actionText);
                if (!TextUtils.isEmpty(paramContext.dataText)) {
                  paramQQAppInterface.append(paramContext.dataText);
                }
                paramQQAppInterface.append(' ');
              }
              if ((paramContext.plainText != null) && (paramContext.plainText.length() > 0)) {
                paramQQAppInterface.append(paramContext.plainText.optString(0));
              }
              if (paramQQAppInterface.length() <= 0) {
                break;
              }
              a(null, paramQQAppInterface.toString(), null, false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1019)
            {
              a(null, null, "对方通过" + paramMessage.msg + "加你为好友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1018)
            {
              a(null, null, "通过" + paramMessage.msg + "加的新朋友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2019)
            {
              paramMsgSummary.b = paramContext.getString(2131369188);
              return;
            }
            if (paramMessage.msgtype == -1026)
            {
              paramMsgSummary.b = paramContext.getString(2131369856);
              return;
            }
            if (paramMessage.msgtype == -1027)
            {
              paramMsgSummary.b = paramContext.getString(2131369858);
              return;
            }
            if (paramMessage.msgtype == -2005)
            {
              paramString = FileManagerUtil.a(paramQQAppInterface, paramMessage);
              paramBoolean1 = a(paramQQAppInterface, paramMessage);
              paramBoolean2 = b(paramQQAppInterface, paramMessage);
              a((CharSequence)localObject2, paramContext.getString(2131368069), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              if (paramString == null) {
                break;
              }
              paramMsgSummary.b = paramString;
              return;
            }
            if (paramMessage.msgtype == -2022)
            {
              bool = false;
              paramString = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if (!(paramString instanceof MessageForShortVideo)) {
                break;
              }
              localObject1 = (MessageForShortVideo)paramString;
              if ((((MessageForShortVideo)localObject1).videoFileStatus != 1005) && (paramMessage.extraflag != 32768)) {
                break label2380;
              }
              paramBoolean1 = true;
              try
              {
                paramString = paramMessage.frienduin;
                if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
                  break label2377;
                }
                paramString = paramMessage.senderuin;
                MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
                paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramMessage.uniseq);
                paramBoolean2 = paramBoolean1;
                if (paramMessage.isSendFromLocal())
                {
                  paramBoolean2 = paramBoolean1;
                  if (paramQQAppInterface == null)
                  {
                    paramInt = ((MessageForShortVideo)localObject1).videoFileStatus;
                    paramBoolean2 = paramBoolean1;
                    if (paramInt == 1002) {
                      paramBoolean2 = true;
                    }
                  }
                }
              }
              catch (Exception paramQQAppInterface)
              {
                for (;;)
                {
                  paramQQAppInterface.printStackTrace();
                  paramBoolean2 = paramBoolean1;
                }
              }
              paramBoolean1 = bool;
              if (paramMessage.isSendFromLocal()) {
                if (((MessageForShortVideo)localObject1).videoFileStatus != 1001)
                {
                  paramBoolean1 = bool;
                  if (((MessageForShortVideo)localObject1).videoFileStatus != 1002) {}
                }
                else
                {
                  paramBoolean1 = true;
                }
              }
              a((CharSequence)localObject2, paramContext.getString(2131368070), null, paramBoolean2, paramBoolean1, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -5002)
            {
              paramContext = new MessageForIncompatibleGrayTips();
              paramContext.msgData = paramMessage.msgData;
              paramContext.parse();
              if (paramContext.msg == null) {
                break;
              }
              paramMsgSummary.b = paramContext.msg;
              return;
            }
            if (paramMessage.msgtype == -2025)
            {
              paramMsgSummary.b = paramMessage.msg;
              return;
            }
            if (paramMessage.msg == null)
            {
              paramMsgSummary.b = "";
              return;
            }
            if (paramMessage.msgtype == -5003)
            {
              paramMsgSummary.b = paramMessage.getMessageText();
              return;
            }
            paramBoolean1 = a(paramQQAppInterface, paramMessage);
            paramBoolean2 = b(paramQQAppInterface, paramMessage);
            switch (paramMessage.fileType)
            {
            default: 
              if ((AppConstants.ae.equalsIgnoreCase(paramMessage.frienduin)) && (paramMessage.istroop == 0))
              {
                paramMsgSummary.b = SystemMsgController.a().a(paramQQAppInterface);
                return;
              }
              break;
            case 65536: 
              a((CharSequence)localObject2, "", paramMessage.msg, paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            case 1: 
              if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == -3001))
              {
                paramMsgSummary.b = paramContext.getString(2131368621);
                return;
              }
              a((CharSequence)localObject2, paramContext.getString(2131368066), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            case 65538: 
              a((CharSequence)localObject2, paramContext.getString(2131368066), null, false, false, paramMsgSummary);
              return;
            case 2: 
            case 8: 
              DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
              paramContext = paramContext.getString(2131368067);
              if ((Utils.a(paramMessage.senderuin, paramQQAppInterface.a())) && (paramInt != 0))
              {
                a((CharSequence)localObject2, paramContext, "", paramBoolean1, paramBoolean2, paramMsgSummary);
                return;
              }
              a((CharSequence)localObject2, paramContext, "", false, false, paramMsgSummary);
              return;
            }
            paramString = paramMessage.getMessageText();
            if ((paramMessage.emoRecentMsg != null) && (paramString != null))
            {
              paramContext = new StringBuilder();
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                paramContext.append((String)localObject2).append(": ");
              }
              if (!AnonymousChatHelper.a(paramMessage))
              {
                if (paramBoolean1) {
                  paramContext.append("F ");
                }
              }
              else
              {
                if (!(paramString instanceof QQText)) {
                  break label2210;
                }
                paramContext = ((QQText)paramString).a(paramContext.toString(), true, new int[0]);
              }
              for (paramMsgSummary.g = 1;; paramMsgSummary.g = 0)
              {
                a((CharSequence)localObject2, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                return;
                if (!paramBoolean2) {
                  break;
                }
                paramContext.append("S ");
                break;
                paramContext.append(paramString);
                paramContext = new SpannableString(paramContext.toString());
              }
            }
            if (paramString != null) {
              paramString = paramString.toString().trim();
            }
            while ((AppConstants.ae.equalsIgnoreCase(paramMessage.frienduin)) && (paramString != null) && (paramString.length() > 0))
            {
              paramContext = a(paramContext, paramQQAppInterface, paramString, paramMessage);
              a((CharSequence)localObject2, null, paramContext, paramBoolean1, paramQQAppInterface.a().b(paramMessage), paramMsgSummary);
              if ((paramMessage.msgtype == -1000) && (paramMsgSummary.b != null))
              {
                paramMsgSummary.b = new QQText(paramMsgSummary.b, 1, 16);
                paramMsgSummary.g = 1;
                return;
                paramString = null;
              }
              else
              {
                paramMsgSummary.g = 0;
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramChatMessage == null) {
      return;
    }
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramContext = "[结构化消息]";
      paramQQAppInterface = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramQQAppInterface != null) {
        paramContext = paramQQAppInterface.mMsgBrief;
      }
      if ((!TextUtils.isEmpty(paramContext)) || (!(paramQQAppInterface instanceof StructMsgForGeneralShare))) {
        break label1970;
      }
      paramQQAppInterface = (StructMsgForGeneralShare)paramQQAppInterface;
      if (paramQQAppInterface.getItemCount() != 3) {
        break label1970;
      }
      paramQQAppInterface = paramQQAppInterface.getItemByIndex(1);
      if (!(paramQQAppInterface instanceof AbsStructMsgTextElement)) {
        break label1970;
      }
      paramContext = ((AbsStructMsgTextElement)paramQQAppInterface).b();
      paramContext = "[位置信息]" + paramContext;
    }
    label916:
    label1952:
    label1961:
    label1967:
    label1970:
    for (;;)
    {
      a(paramString, null, paramContext, false, false, paramMsgSummary);
      return;
      if ((paramChatMessage instanceof MessageForShakeWindow))
      {
        a(paramString, null, paramContext.getResources().getString(2131366056), false, false, paramMsgSummary);
        return;
      }
      boolean bool;
      if (paramChatMessage.msgtype == -2000) {
        bool = false;
      }
      Object localObject1;
      for (;;)
      {
        Object localObject2;
        long l;
        try
        {
          localObject1 = paramChatMessage.frienduin;
          if (!MsgProxyUtils.a(paramChatMessage.frienduin, paramChatMessage.istroop)) {
            break label1967;
          }
          localObject1 = paramChatMessage.senderuin;
          localObject2 = (MessageForPic)paramQQAppInterface.a().b((String)localObject1, paramChatMessage.istroop, paramChatMessage.uniseq);
          paramQQAppInterface = paramQQAppInterface.a().a((String)localObject1, paramChatMessage.uniseq);
        }
        catch (Exception paramChatMessage)
        {
          paramQQAppInterface = null;
        }
        try
        {
          if ((!paramChatMessage.isSendFromLocal()) || (paramQQAppInterface != null) || (localObject2 == null)) {
            continue;
          }
          l = ((MessageForPic)localObject2).size;
          if (l > 0L) {
            continue;
          }
          paramBoolean1 = true;
        }
        catch (Exception paramChatMessage)
        {
          for (;;)
          {
            continue;
            paramContext = (Context)localObject1;
            continue;
            continue;
            paramBoolean1 = false;
            continue;
            paramBoolean1 = false;
            paramBoolean2 = false;
          }
          paramBoolean1 = false;
          continue;
          paramBoolean1 = false;
          continue;
        }
        paramBoolean2 = paramBoolean1;
        if ((paramQQAppInterface instanceof BaseTransProcessor))
        {
          paramQQAppInterface = (BaseTransProcessor)paramQQAppInterface;
          if (paramQQAppInterface.c() != 1003L)
          {
            paramBoolean1 = true;
            if (QLog.isColorLevel())
            {
              if (paramQQAppInterface.a != null)
              {
                l = paramQQAppInterface.a.a;
                QLog.d("sendingpic", 2, "uniseq:" + l + ",key:" + paramQQAppInterface.a());
              }
            }
            else
            {
              a(paramString, paramContext.getString(2131368066), null, paramBoolean2, paramBoolean1, paramMsgSummary);
              return;
              if ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof BaseTransProcessor))) {
                break label1961;
              }
              l = ((BaseTransProcessor)paramQQAppInterface).c();
              paramInt = (int)l;
              if ((paramInt != 1005) && (paramInt != 1004)) {
                break label1961;
              }
              paramBoolean1 = true;
              continue;
              paramChatMessage.printStackTrace();
              paramBoolean2 = false;
              continue;
            }
            l = -1L;
            continue;
          }
        }
        else
        {
          paramBoolean1 = bool;
          if (paramQQAppInterface == null) {
            continue;
          }
          bool = true;
          paramBoolean1 = bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("sendingpic", 2, "processor:" + paramQQAppInterface);
          paramBoolean1 = bool;
          continue;
          if ((paramChatMessage.msgtype == -2002) || (paramChatMessage.msgtype == -1031))
          {
            localObject1 = paramChatMessage.frienduin;
            if (!MsgProxyUtils.a(paramChatMessage.frienduin, paramChatMessage.istroop)) {
              break label1952;
            }
            localObject1 = paramChatMessage.senderuin;
            paramContext = paramContext.getString(2131368067);
            localObject2 = paramQQAppInterface.a().b((String)localObject1, paramChatMessage.istroop, paramChatMessage.uniseq);
            if ((localObject2 instanceof MessageForPtt))
            {
              localObject2 = (MessageForPtt)localObject2;
              if (paramChatMessage.isSendFromLocal())
              {
                if (((MessageForPtt)localObject2).fileSize == -1L)
                {
                  paramBoolean1 = true;
                  paramBoolean2 = false;
                  DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
                  a(paramString, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                  return;
                }
                if (((MessageForPtt)localObject2).fileSize <= 0L)
                {
                  paramInt = paramQQAppInterface.a().d((String)localObject1, ((MessageForPtt)localObject2).url, ((MessageForPtt)localObject2).uniseq);
                  if ((paramInt == 1005) || (paramInt == 1004) || (paramInt == -1))
                  {
                    paramBoolean1 = true;
                    paramBoolean2 = false;
                  }
                  for (;;)
                  {
                    DatingUtil.a("buildMsgSummaryForMsg", new Object[] { Long.valueOf(((MessageForPtt)localObject2).fileSize), Integer.valueOf(paramInt) });
                    break;
                    paramBoolean2 = true;
                    paramBoolean1 = false;
                  }
                }
              }
            }
          }
          else
          {
            if (paramChatMessage.msgtype == -3008)
            {
              paramMsgSummary.b = (paramContext.getString(2131362486) + "\"" + paramChatMessage.msg + "\"");
              return;
            }
            if (paramChatMessage.msgtype == -2015)
            {
              paramMsgSummary.b = "";
              return;
            }
            if (ActionMsgUtil.a(paramChatMessage.msgtype))
            {
              a(paramString, a(paramContext, paramQQAppInterface, paramChatMessage), null, false, false, paramMsgSummary);
              return;
            }
            if (paramChatMessage.msgtype == -2017)
            {
              a(paramString, paramContext.getString(2131363971), null, false, false, paramMsgSummary);
              return;
            }
            if (ActionMsgUtil.b(paramChatMessage.msgtype))
            {
              paramContext = TransfileUtile.a(paramChatMessage.msg);
              if (paramContext == null) {
                break;
              }
              paramInt = 1;
              if (paramContext.length > 3) {
                if (!"1".equals(paramContext[3])) {
                  break label916;
                }
              }
              for (paramInt = 1; paramInt != 0; paramInt = 0)
              {
                paramMsgSummary.b = "[视频电话]";
                return;
              }
              paramMsgSummary.b = "[QQ电话]";
              return;
            }
            if (ActionMsgUtil.c(paramChatMessage.msgtype))
            {
              paramString = TransfileUtile.a(paramChatMessage.msg);
              if (paramString == null) {
                break;
              }
              paramMsgSummary.b = a(paramQQAppInterface, paramString, paramContext, paramChatMessage.frienduin, paramChatMessage.senderuin, paramInt);
              return;
            }
            if (ActionMsgUtil.d(paramChatMessage.msgtype))
            {
              a(paramString, paramContext.getString(2131368619), null, false, false, paramMsgSummary);
              return;
            }
            if (paramChatMessage.msgtype == -1013)
            {
              a(null, null, MessageForGrayTips.getOrginMsg(paramChatMessage.msg), false, false, paramMsgSummary);
              return;
            }
            if (paramChatMessage.msgtype == -1034)
            {
              paramContext = new MessageForRichState();
              paramContext.msg = paramChatMessage.msg;
              paramContext.parse();
              paramQQAppInterface = new StringBuilder("[个性签名]");
              if (!TextUtils.isEmpty(paramContext.actionText))
              {
                paramQQAppInterface.append(paramContext.actionText);
                if (!TextUtils.isEmpty(paramContext.dataText)) {
                  paramQQAppInterface.append(paramContext.dataText);
                }
                paramQQAppInterface.append(' ');
              }
              if ((paramContext.plainText != null) && (paramContext.plainText.length() > 0)) {
                paramQQAppInterface.append(paramContext.plainText.optString(0));
              }
              if (paramQQAppInterface.length() <= 0) {
                break;
              }
              a(null, paramQQAppInterface.toString(), null, false, false, paramMsgSummary);
              return;
            }
            if (paramChatMessage.msgtype == -1019)
            {
              a(null, null, "对方通过" + paramChatMessage.msg + "加你为好友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramChatMessage.msgtype == -1018)
            {
              a(null, null, "通过" + paramChatMessage.msg + "加的新朋友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramChatMessage.msgtype == -2019)
            {
              paramMsgSummary.b = paramContext.getString(2131369188);
              return;
            }
            if (paramChatMessage.msgtype == -1026)
            {
              paramMsgSummary.b = paramContext.getString(2131369856);
              return;
            }
            if (paramChatMessage.msgtype == -1027)
            {
              paramMsgSummary.b = paramContext.getString(2131369858);
              return;
            }
            if (paramChatMessage.msgtype == -2005)
            {
              paramQQAppInterface = FileManagerUtil.a(paramQQAppInterface, paramChatMessage);
              a(paramString, paramContext.getString(2131368069), null, false, false, paramMsgSummary);
              if (paramQQAppInterface == null) {
                break;
              }
              paramMsgSummary.b = paramQQAppInterface;
              return;
            }
            if (paramChatMessage.msgtype == -2022)
            {
              bool = false;
              localObject1 = paramQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
              if (!(localObject1 instanceof MessageForShortVideo)) {
                break;
              }
              localObject2 = (MessageForShortVideo)localObject1;
              if ((((MessageForShortVideo)localObject2).videoFileStatus != 1005) && (paramChatMessage.extraflag != 32768)) {
                break label1937;
              }
              paramBoolean1 = true;
              try
              {
                localObject1 = paramChatMessage.frienduin;
                if (!MsgProxyUtils.a(paramChatMessage.frienduin, paramChatMessage.istroop)) {
                  break label1934;
                }
                localObject1 = paramChatMessage.senderuin;
                MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramQQAppInterface.a().b((String)localObject1, paramChatMessage.istroop, paramChatMessage.uniseq);
                paramQQAppInterface = paramQQAppInterface.a().a((String)localObject1, paramChatMessage.uniseq);
                paramBoolean2 = paramBoolean1;
                if (paramChatMessage.isSendFromLocal())
                {
                  paramBoolean2 = paramBoolean1;
                  if (paramQQAppInterface == null)
                  {
                    paramInt = ((MessageForShortVideo)localObject2).videoFileStatus;
                    paramBoolean2 = paramBoolean1;
                    if (paramInt == 1002) {
                      paramBoolean2 = true;
                    }
                  }
                }
                paramBoolean1 = paramBoolean2;
              }
              catch (Exception paramQQAppInterface)
              {
                for (;;)
                {
                  paramQQAppInterface.printStackTrace();
                }
              }
              paramBoolean2 = bool;
              if (paramChatMessage.isSendFromLocal()) {
                if (((MessageForShortVideo)localObject2).videoFileStatus != 1001)
                {
                  paramBoolean2 = bool;
                  if (((MessageForShortVideo)localObject2).videoFileStatus != 1002) {}
                }
                else
                {
                  paramBoolean2 = true;
                }
              }
              a(paramString, paramContext.getString(2131368070), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            }
            if (paramChatMessage.msgtype == -5002)
            {
              paramContext = new MessageForIncompatibleGrayTips();
              paramContext.msgData = paramChatMessage.msgData;
              paramContext.parse();
              if (paramContext.msg == null) {
                break;
              }
              paramMsgSummary.b = paramContext.msg;
              return;
            }
            if (paramChatMessage.msgtype == -2025)
            {
              paramContext = paramChatMessage.msg;
              if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
                paramContext = ((MessageForQQWalletMsg)paramChatMessage).getMsgSummary();
              }
              paramQQAppInterface = paramContext;
              if (TextUtils.isEmpty(paramContext)) {
                paramQQAppInterface = "[QQ红包]";
              }
              paramMsgSummary.b = paramQQAppInterface;
              return;
            }
            if (paramChatMessage.msg == null)
            {
              paramMsgSummary.b = "";
              return;
            }
            if (paramChatMessage.msgtype == -5003)
            {
              paramMsgSummary.b = paramChatMessage.msg;
              return;
            }
            if ((AppConstants.ae.equalsIgnoreCase(paramChatMessage.frienduin)) && (paramChatMessage.istroop == 0))
            {
              paramMsgSummary.b = SystemMsgController.a().a(paramQQAppInterface);
              return;
            }
            localObject1 = paramChatMessage.msg;
            if (localObject1 != null) {
              localObject1 = ((CharSequence)localObject1).toString().trim();
            }
            while ((AppConstants.ae.equalsIgnoreCase(paramChatMessage.frienduin)) && (localObject1 != null) && (((String)localObject1).length() > 0))
            {
              paramContext = a(paramContext, paramQQAppInterface, (String)localObject1, paramChatMessage);
              a(paramString, null, paramContext, false, paramQQAppInterface.a().b(paramChatMessage), paramMsgSummary);
              if ((paramChatMessage.msgtype == -1000) && (paramMsgSummary.b != null))
              {
                paramMsgSummary.b = new QQText(paramMsgSummary.b, 1, 16);
                paramMsgSummary.g = 1;
                return;
                localObject1 = null;
              }
              else
              {
                paramMsgSummary.g = 0;
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(TextView paramTextView, QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if ((paramTextView == null) || (paramArrayOfString == null)) {
      return;
    }
    paramTextView.setText(a(paramQQAppInterface, paramArrayOfString, paramContext, paramString1, paramString2, paramInt));
  }
  
  public static void a(TextView paramTextView, String[] paramArrayOfString, Context paramContext, int paramInt)
  {
    if ((paramTextView == null) || (paramArrayOfString == null)) {
      return;
    }
    paramTextView.setText(a(paramArrayOfString, paramContext, b(paramInt), false));
  }
  
  private static void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean1, boolean paramBoolean2, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.a = paramCharSequence1;
    paramMsgSummary.b = paramCharSequence2;
    paramMsgSummary.c = paramCharSequence3;
    if (paramBoolean1)
    {
      paramMsgSummary.f = 2;
      return;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.f = 1;
      return;
    }
    paramMsgSummary.f = 0;
  }
  
  public static boolean a(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, TextView paramTextView, int paramInt, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    return a(paramContext, paramQQAppInterface, paramMessage, paramTextView, paramInt, paramDrawable1, paramDrawable2, paramDrawable3, null, null);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, TextView paramTextView, int paramInt, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, CountDownTimer.CountDownTimerListener paramCountDownTimerListener, CountDownTimer paramCountDownTimer)
  {
    if ((paramTextView == null) || (paramMessage == null)) {
      return true;
    }
    paramTextView.setVisibility(0);
    paramCountDownTimer = paramMessage.nickName;
    if (!paramMessage.isSendFromLocal())
    {
      paramCountDownTimerListener = paramCountDownTimer;
      if (paramMessage.selfuin != null)
      {
        paramCountDownTimerListener = paramCountDownTimer;
        if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
      }
    }
    else
    {
      paramCountDownTimerListener = null;
    }
    paramCountDownTimer = paramCountDownTimerListener;
    if (paramCountDownTimerListener != null)
    {
      paramCountDownTimer = paramCountDownTimerListener;
      if (paramCountDownTimerListener.length() > 12) {
        paramCountDownTimer = paramCountDownTimerListener.substring(0, 11) + "...";
      }
    }
    boolean bool1 = a(paramQQAppInterface, paramMessage);
    boolean bool2 = b(paramQQAppInterface, paramMessage);
    paramContext.getResources();
    paramContext.getString(2131368068);
    paramCountDownTimerListener = paramContext.getString(2131368069);
    if (paramMessage.msgtype == -2011)
    {
      paramContext = StructMsgFactory.a(paramMessage.msgData);
      if (paramContext != null) {
        paramTextView.setText(a(paramCountDownTimer, null, paramContext.mMsgBrief, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
      }
      return false;
    }
    String str;
    Object localObject;
    if (paramMessage.msgtype == -2000)
    {
      str = paramMessage.frienduin;
      bool1 = false;
      bool2 = false;
      localObject = null;
      paramCountDownTimerListener = (CountDownTimer.CountDownTimerListener)localObject;
    }
    for (;;)
    {
      long l1;
      try
      {
        MessageForPic localMessageForPic = (MessageForPic)paramQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        paramCountDownTimerListener = (CountDownTimer.CountDownTimerListener)localObject;
        paramQQAppInterface = paramQQAppInterface.a().a(str, paramMessage.uniseq);
        paramCountDownTimerListener = paramQQAppInterface;
        if ((!paramMessage.isSendFromLocal()) || (paramQQAppInterface != null) || (localMessageForPic == null)) {
          continue;
        }
        paramCountDownTimerListener = paramQQAppInterface;
        l1 = localMessageForPic.size;
        if (l1 > 0L) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramQQAppInterface = paramCountDownTimerListener;
        continue;
      }
      if (paramQQAppInterface != null) {
        bool2 = true;
      }
      paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131368066), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
      return false;
      if (paramQQAppInterface != null)
      {
        paramCountDownTimerListener = paramQQAppInterface;
        if ((paramQQAppInterface instanceof BaseTransProcessor))
        {
          paramCountDownTimerListener = paramQQAppInterface;
          l1 = ((BaseTransProcessor)paramQQAppInterface).c();
          paramInt = (int)l1;
          if ((paramInt == 1005) || (paramInt == 1004))
          {
            bool1 = true;
            continue;
            if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
            {
              paramCountDownTimerListener = paramMessage.frienduin;
              boolean bool4 = false;
              boolean bool3 = false;
              localObject = paramQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if ((localObject instanceof MessageForPtt))
              {
                localObject = (MessageForPtt)localObject;
                bool1 = bool4;
                bool2 = bool3;
                if (paramMessage.isSendFromLocal())
                {
                  if (((MessageForPtt)localObject).fileSize != -1L) {
                    break label537;
                  }
                  bool1 = true;
                  bool2 = bool3;
                }
              }
              for (;;)
              {
                paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131368067), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                return false;
                label537:
                bool1 = bool4;
                bool2 = bool3;
                if (((MessageForPtt)localObject).fileSize <= 0L)
                {
                  paramInt = paramQQAppInterface.a().d(paramCountDownTimerListener, ((MessageForPtt)localObject).url, ((MessageForPtt)localObject).uniseq);
                  if ((paramInt == 1005) || (paramInt == 1004) || (paramInt == -1))
                  {
                    bool1 = true;
                    bool2 = bool3;
                  }
                  else
                  {
                    bool2 = true;
                    bool1 = bool4;
                  }
                }
              }
            }
            if (paramMessage.msgtype == -3008)
            {
              paramTextView.setText(BaseApplicationImpl.getContext().getString(2131362486) + "\"" + paramMessage.msg + "\"");
              return false;
            }
            if (paramMessage.msgtype == -2015)
            {
              paramTextView.setText("");
              return false;
            }
            if (ActionMsgUtil.a(paramMessage.msgtype))
            {
              paramTextView.setText(a(paramCountDownTimer, a(paramContext, paramQQAppInterface, paramMessage), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == -2017)
            {
              if (paramMessage.isSend()) {}
              for (paramContext = a(null);; paramContext = a(paramCountDownTimer))
              {
                paramTextView.setText(paramContext);
                return false;
              }
            }
            if (ActionMsgUtil.b(paramMessage.msgtype))
            {
              paramInt = paramMessage.issend;
              a(paramTextView, TransfileUtile.a(paramMessage.msg), paramContext, paramInt);
              return false;
            }
            if (ActionMsgUtil.c(paramMessage.msgtype))
            {
              a(paramTextView, paramQQAppInterface, TransfileUtile.a(paramMessage.msg), paramContext, paramMessage.frienduin, paramMessage.senderuin, paramInt);
              return false;
            }
            if (ActionMsgUtil.d(paramMessage.msgtype))
            {
              paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131368619), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == -2017)
            {
              paramTextView.setText("[群文件]");
              return false;
            }
            switch (paramMessage.fileType)
            {
            default: 
              if (paramMessage.msg == null) {
                paramTextView.setText("");
              }
              break;
            case 1: 
            case 0: 
            case 65538: 
            case 2: 
            case 8: 
            case 65536: 
              for (;;)
              {
                return true;
                if (paramMessage.msg == null)
                {
                  paramTextView.setText("");
                }
                else if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == -3001))
                {
                  paramTextView.setText(2131368621);
                }
                else
                {
                  paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131368066), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                  continue;
                  if (paramMessage.msg == null)
                  {
                    paramTextView.setText("");
                  }
                  else
                  {
                    paramContext = FileManagerUtil.a(paramQQAppInterface, paramMessage);
                    if (paramContext == null)
                    {
                      paramTextView.setText(a(paramCountDownTimer, paramCountDownTimerListener, null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                    }
                    else
                    {
                      paramTextView.setText(paramContext);
                      continue;
                      if (paramMessage.msg == null)
                      {
                        paramTextView.setText("");
                      }
                      else
                      {
                        paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131368066), null, false, false, paramDrawable1, paramDrawable2, paramDrawable3));
                        continue;
                        if (paramMessage.msg == null)
                        {
                          paramTextView.setText("");
                        }
                        else
                        {
                          long l2 = 0L;
                          if (paramMessage.fileSize > 0L)
                          {
                            l1 = paramMessage.fileSize;
                            label1184:
                            if (l1 <= 0L) {
                              break label1322;
                            }
                            new StringBuilder().append(l1).append("\"").toString();
                          }
                          label1322:
                          for (;;)
                          {
                            paramContext = paramContext.getString(2131368067);
                            if ((paramMessage.senderuin == null) || (!paramMessage.senderuin.equalsIgnoreCase(paramQQAppInterface.a())) || (paramInt == 0)) {
                              break label1325;
                            }
                            paramTextView.setText(a(paramCountDownTimer, paramContext, "", bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                            break;
                            l1 = l2;
                            if (paramMessage.pttUrl == null) {
                              break label1184;
                            }
                            l1 = l2;
                            if (paramMessage.pttUrl.toLowerCase().startsWith("http")) {
                              break label1184;
                            }
                            l1 = QQRecorder.a(paramMessage.pttUrl);
                            paramMessage.fileSize = l1;
                            break label1184;
                          }
                          label1325:
                          paramTextView.setText(a(paramCountDownTimer, paramContext, "", false, false, paramDrawable1, paramDrawable2, paramDrawable3));
                          continue;
                          paramTextView.setText(a(paramCountDownTimer, "", paramMessage.msg, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                        }
                      }
                    }
                  }
                }
              }
            }
            if ((String.valueOf(AppConstants.ae).equalsIgnoreCase(paramMessage.frienduin)) && (paramMessage.istroop == 0))
            {
              paramTextView.setText(SystemMsgController.a().a(paramQQAppInterface));
              return true;
            }
            paramCountDownTimerListener = paramMessage.getMessageText();
            if ((paramMessage.emoRecentMsg != null) && (paramCountDownTimerListener != null))
            {
              paramContext = new StringBuilder();
              int j = 0;
              paramInt = 0;
              int i = j;
              if (paramCountDownTimer != null)
              {
                i = j;
                if (paramCountDownTimer.length() > 0)
                {
                  paramContext.append(paramCountDownTimer).append(": ");
                  i = paramContext.length();
                }
              }
              if (bool1)
              {
                paramContext.append("F ");
                paramInt = paramContext.length();
                label1501:
                if (!(paramCountDownTimerListener instanceof QQText)) {
                  break label1609;
                }
                paramContext = ((QQText)paramCountDownTimerListener).a(paramContext.toString(), true, new int[0]);
                label1526:
                if (!bool1) {
                  break label1631;
                }
                paramDrawable3.setBounds(0, 0, paramDrawable3.getIntrinsicWidth() * 2 / 3, paramDrawable3.getIntrinsicHeight() * 2 / 3);
                ((Spannable)paramContext).setSpan(new ImageSpan(paramDrawable3), i, paramInt, 33);
              }
              for (;;)
              {
                paramTextView.setText(paramContext);
                break;
                if (!bool2) {
                  break label1501;
                }
                paramContext.append("S ");
                paramInt = paramContext.length();
                break label1501;
                label1609:
                paramContext.append(paramCountDownTimerListener);
                paramContext = new SpannableString(paramContext.toString());
                break label1526;
                label1631:
                if (bool2)
                {
                  paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth() * 2 / 3, paramDrawable2.getIntrinsicHeight() * 2 / 3);
                  ((Spannable)paramContext).setSpan(new ImageSpan(paramDrawable2), i, paramInt, 33);
                }
              }
            }
            if (paramCountDownTimerListener != null)
            {
              paramCountDownTimerListener = paramCountDownTimerListener.toString().trim();
              label1705:
              if ((!String.valueOf(AppConstants.ae).equalsIgnoreCase(paramMessage.frienduin)) || (paramCountDownTimerListener == null) || (paramCountDownTimerListener.length() <= 0)) {
                break label1810;
              }
            }
            label1810:
            for (paramContext = a(paramContext, paramQQAppInterface, paramCountDownTimerListener, paramMessage);; paramContext = paramCountDownTimerListener)
            {
              paramContext = a(paramCountDownTimer, null, paramContext, bool1, paramQQAppInterface.a().b(paramMessage), paramDrawable1, paramDrawable2, paramDrawable3);
              if ((paramMessage.msgtype == -1000) && (paramContext != null)) {
                paramContext = new QQText(paramContext, 1, 16);
              }
              for (;;)
              {
                paramTextView.setText(paramContext);
                break;
                paramCountDownTimerListener = null;
                break label1705;
              }
            }
          }
        }
      }
      bool1 = false;
    }
  }
  
  public static boolean a(Context paramContext, MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null) {}
    String str;
    do
    {
      return false;
      str = paramMessageForVideo.text;
    } while ((paramMessageForVideo.isSend()) || (!str.contains(paramContext.getString(2131362856))));
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    QQMessageFacade.Message localMessage = paramMessage;
    if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null) {
        localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop);
      }
    }
    if (localMessage.msgtype == -2005) {
      if (a(paramQQAppInterface, localMessage) != 0) {}
    }
    int i;
    do
    {
      return true;
      return false;
      if (localMessage.fileType != 1) {
        break;
      }
      i = paramQQAppInterface.a().d(localMessage.frienduin, null, localMessage.uniseq);
    } while ((i == 1005) || (i == 1004));
    label110:
    if ((localMessage.isSendFromLocal()) && (localMessage.extraflag == 32768)) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (localMessage.msgtype != -2017) {
        break label110;
      }
      paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && (paramMessage.frienduin != null))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.b == 3)) {
          break;
        }
      }
      return false;
    }
  }
  
  public static boolean b(int paramInt)
  {
    return 1 == paramInt;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    QQMessageFacade.Message localMessage = paramMessage;
    if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null) {
        localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop);
      }
    }
    if (localMessage.msgtype == -2005) {
      return 2 == a(paramQQAppInterface, localMessage);
    }
    if (localMessage.msgtype == -2017)
    {
      paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && (paramMessage.frienduin != null))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
          return true;
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof BuddyTransfileProcessor)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((BuddyTransfileProcessor)paramMessage).b() >= 0) && (((BuddyTransfileProcessor)paramMessage).b() != 100)) {
      return true;
    }
    return paramQQAppInterface.a().b(localMessage);
  }
  
  public static boolean c(int paramInt)
  {
    return 2 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MsgUtils
 * JD-Core Version:    0.7.0.1
 */