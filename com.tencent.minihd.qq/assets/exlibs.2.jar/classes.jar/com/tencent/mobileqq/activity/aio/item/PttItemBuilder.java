package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.stt.SttManager.ISttListener;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;
import fvv;
import fvw;
import fvx;
import fvy;
import mqq.manager.ServerConfigManager.ConfigType;

public class PttItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, MediaPlayerManager.Callback, SttManager.ISttListener
{
  public static final String b = "ConvertText_MaxPtt";
  public static final String c = "Normal_MaxPtt";
  public static final String d = "VIP_MaxPtt";
  private static final boolean d = true;
  public static final String e = "SVIP_MaxPtt";
  public static final int f = 20;
  public static final String f = "param_FailCode";
  public static final int g = 1;
  private static final String g = "PttItemBuilder";
  public static final int h = 2;
  private static final int i = 0;
  private static final int j = 1;
  private static final int k = 4;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SttManager jdField_a_of_type_ComTencentMobileqqSttSttManager;
  private SpannableString b;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager = ((SttManager)paramQQAppInterface.getManager(16));
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
  }
  
  private int a(int paramInt1, String paramString, Paint paramPaint, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i1 = Math.min(60, Math.max(1, paramInt1));
    int i2;
    float f1;
    if (i1 > 40)
    {
      i1 += 40;
      i2 = AIOUtils.a(i1 + 20, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "viewLenByTime is:" + i2);
      }
      if ((paramString == null) || (paramPaint == null)) {
        break label313;
      }
      i1 = BaseChatItemLayout.g - BaseChatItemLayout.k - BaseChatItemLayout.l - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= i1) {
        break label316;
      }
      f1 = i1;
    }
    label313:
    label316:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int i3 = AIOUtils.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
        i2 = i2 + i3 + paramInt3;
        paramInt1 = i2;
        if (i2 > i1) {
          paramInt1 = i1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "viewLenByText is:" + f1 + ",maxlength is:" + i1 + ",flagTimeLen is:" + i3 + ",arrowIVWidth is:" + paramInt2 + ",convertIVWidth is:" + paramInt3 + ",convertIVVisible is:" + paramBoolean);
        }
        paramInt2 = Math.max(paramInt1, (int)f1) - i3;
        paramInt1 = paramInt2;
        if (paramBoolean) {
          paramInt1 = paramInt2 - paramInt3;
        }
        return paramInt1;
        i1 *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return i2;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i2 = 120;
    paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "key = " + paramString + ", time = " + paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {}
    do
    {
      do
      {
        do
        {
          try
          {
            i1 = Integer.valueOf(paramQQAppInterface).intValue();
            if (i1 > 0) {
              return i1;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
          }
          i1 = i2;
        } while ("ConvertText_MaxPtt".equals(paramString));
        i1 = i2;
      } while ("Normal_MaxPtt".equals(paramString));
      if ("VIP_MaxPtt".equals(paramString)) {
        return 180;
      }
      int i1 = i2;
    } while (!"SVIP_MaxPtt".equals(paramString));
    return 300;
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  @SuppressLint({"NewApi"})
  private void e()
  {
    BluetoothAdapter localBluetoothAdapter;
    if (Build.VERSION.SDK_INT >= 15)
    {
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null) {}
    }
    else
    {
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayBluetooth", true, 0L, 0L, null, "");
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayBluetooth", true, 0L, 0L, null, "");
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) == 2)
    {
      fvx localfvx = new fvx(this, localBluetoothAdapter);
      localBluetoothAdapter.getProfileProxy(this.jdField_a_of_type_AndroidContentContext, localfvx, 1);
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayBluetooth", true, 0L, 0L, null, "");
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public int a(MessageForPtt paramMessageForPtt)
  {
    int i2 = 2005;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.aE))) {
        if (paramMessageForPtt.fileSize > 0L) {
          i1 = 1003;
        }
      }
    }
    do
    {
      do
      {
        return i1;
        if (paramMessageForPtt.fileSize == -1L) {
          return 1005;
        }
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt)) {
            return 999;
          }
          paramMessageForPtt.fileSize = -1L;
          return 1005;
        }
        if (paramMessageForPtt.fileSize != -3L) {
          break;
        }
        i1 = 1001;
        i2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
      } while ((i2 != 1005) && (i2 != -1));
      paramMessageForPtt.fileSize = -1L;
      return 1005;
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
      return 1004;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
      }
      if (paramMessageForPtt == null) {
        break;
      }
      i1 = i2;
    } while (paramMessageForPtt.url == null);
    if ((paramMessageForPtt.url.startsWith(AppConstants.aE)) && (FileUtils.a(paramMessageForPtt.url))) {
      return 2003;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
    if ((i1 == -1) && (paramMessageForPtt.fileSize == -4L)) {}
    for (;;)
    {
      i1 = i2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + i2 + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
      return i2;
      i2 = i1;
    }
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
  }
  
  protected String a(int paramInt)
  {
    String str = "";
    int i1 = paramInt / 60;
    if (i1 > 0) {
      str = i1 + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了语音";
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {}
    do
    {
      do
      {
        return;
        paramContext = (MessageForPtt)paramChatMessage;
        if (2131298924 != paramInt) {
          break;
        }
        paramInt = QQRecorder.a(paramContext.url);
      } while (paramInt <= 0);
      paramChatMessage = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new fvw(this, paramContext));
      if (paramChatMessage.a(paramContext.url, paramInt))
      {
        paramChatMessage.show();
        return;
      }
      QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364636, 1);
      return;
      if (paramInt == 2131302479)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131302484)
      {
        if (TextUtils.isEmpty(paramContext.sttText)) {}
        for (paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131366445);; paramContext = paramContext.sttText) {
          try
          {
            if (Build.VERSION.SDK_INT >= 11) {
              break;
            }
            ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
            return;
          }
          catch (Exception paramContext)
          {
            return;
          }
        }
        ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", paramContext));
        return;
      }
    } while (paramInt != 2131298174);
    if ((paramContext.sttText != null) && (paramContext.sttText.length() > 0))
    {
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("forward_type", -1);
      paramChatMessage.putString("forward_text", paramContext.sttText);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      paramContext.putExtras(paramChatMessage);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramContext, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "语音消息无文本内容", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131366318);
      paramView.c(2131366317);
      paramView.e(2131365736);
      paramView.a(new fvy(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    b(paramView, localMessageForPtt);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.e != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramFileMsg.c));
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.b)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          a();
          PttInfoCollector.c(paramFileMsg.c, localMessageForPtt.frienduin);
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, b(localMessageForPtt));
      return;
      if ((paramFileMsg.D == 1005) || (paramFileMsg.D == 1004))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        paramInt2 = paramInt1;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        paramInt2 = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        paramInt2 = 1001;
      }
      else if (localMessageForPtt.fileSize == -1L)
      {
        paramInt2 = 1005;
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2005)
        {
          localMessageForPtt.fileSize = -4L;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramViewHolder = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramViewHolder.getColorStateList(2131427945);
        if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if (localHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
      }
    }
    label127:
    do
    {
      do
      {
        return;
        paramViewHolder = paramViewHolder.getColorStateList(2131427942);
        break;
        if (paramBubbleInfo.e != 0) {
          break label127;
        }
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      } while (localHolder.jdField_b_of_type_AndroidWidgetTextView == null);
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.e);
    } while (localHolder.jdField_b_of_type_AndroidWidgetTextView == null);
    localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.e);
  }
  
  public void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    String str = "";
    if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
      paramHolder.c.setVisibility(8);
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramHolder.d.setVisibility(8);
      paramHolder.e.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
    switch (paramInt)
    {
    default: 
      localObject1 = null;
      paramInt = 0;
    case 2004: 
    case 2005: 
    case -1: 
    case 999: 
    case 1000: 
    case 2000: 
    case 2001: 
    case 2002: 
      for (;;)
      {
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          }
          label430:
          if (paramHolder.jdField_b_of_type_JavaLangStringBuilder != null)
          {
            paramHolder.jdField_b_of_type_JavaLangStringBuilder.append("发送了语音.").append(str);
            if (localObject1 != null) {
              paramHolder.jdField_b_of_type_JavaLangStringBuilder.append(" ").append((String)localObject1);
            }
          }
          return;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.o);
          paramInt = 1;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
          localObject1 = null;
          continue;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, (Resources)localObject4), BaseChatItemLayout.n, AIOUtils.a(40.0F, (Resources)localObject4), BaseChatItemLayout.o);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
          localObject1 = null;
          paramInt = 0;
        }
      }
    }
    if (paramMessageForPtt.timeLength <= 0) {
      paramMessageForPtt.timeLength = QQRecorder.a(paramMessageForPtt.url);
    }
    if (paramMessageForPtt.timeLength <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "get a amr file length = 0 return now");
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject4), BaseChatItemLayout.o);
      return;
    }
    if (paramMessageForPtt.timeLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject4).getDrawable(2130838639);
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject1 = "QQ会员专享长语音";
      }
    }
    for (;;)
    {
      label843:
      if (paramMessageForPtt.timeLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr)) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.timeLength);
      }
      str = paramMessageForPtt.timeStr;
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      int i1;
      label973:
      int i2;
      label1026:
      int i4;
      int i3;
      int i5;
      int i6;
      int i7;
      if (paramMessageForPtt.isSend()) {
        if (paramBoolean)
        {
          i1 = 2130968647;
          if (c(paramMessageForPtt)) {
            i1 = 2130968727;
          }
          localObject2 = (AnimationDrawable)((Resources)localObject4).getDrawable(i1);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          ((AnimationDrawable)localObject2).start();
          i2 = 0;
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label1426;
          }
          if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
          }
          if (paramMessageForPtt.sttAbility != 0) {
            break label1381;
          }
          i1 = 1;
          paramInt = 0;
          i4 = AIOUtils.a(9.0F, (Resources)localObject4);
          i3 = AIOUtils.a(12.0F, (Resources)localObject4);
          ((Resources)localObject4).getDrawable(2130840068).getIntrinsicWidth();
          i5 = ((Resources)localObject4).getDrawable(2130840068).getIntrinsicHeight();
          i6 = ((Resources)localObject4).getDrawable(2130841743).getIntrinsicWidth();
          i7 = AIOUtils.a(1.0F, (Resources)localObject4);
          if (i1 != 1) {
            break label1489;
          }
          i1 = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
          if (!paramMessageForPtt.isSend()) {
            break label1456;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i4, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
        }
      }
      for (;;)
      {
        break;
        if (paramMessageForPtt.longPttVipFlag != 2) {
          break label3097;
        }
        if (this.b == null)
        {
          this.b = new SpannableString("[v] 超级会员专享长语音");
          localObject1 = ((Resources)localObject4).getDrawable(2130838638);
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
          this.b.setSpan(localObject1, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
        localObject1 = "超级会员专享长语音";
        break label843;
        if (c(paramMessageForPtt))
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840705);
          break label973;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841733);
        break label973;
        if (paramBoolean)
        {
          i1 = 2130968766;
          if (c(paramMessageForPtt)) {
            i1 = 2130968726;
          }
          localObject2 = (AnimationDrawable)((Resources)localObject4).getDrawable(i1);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          ((AnimationDrawable)localObject2).start();
          break label973;
        }
        if (c(paramMessageForPtt))
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840704);
          break label973;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841732);
        break label973;
        label1381:
        if (paramMessageForPtt.sttAbility == 1)
        {
          i1 = 2;
          paramInt = 0;
          break label1026;
        }
        if (paramMessageForPtt.expandStt) {}
        for (paramInt = 3;; paramInt = 2)
        {
          i3 = 0;
          i2 = 1;
          i1 = paramInt;
          paramInt = i3;
          break;
        }
        label1426:
        if ((paramInt == 1005) || (paramInt == 1004))
        {
          i1 = 1;
          paramInt = 1;
          break label1026;
        }
        i1 = 1;
        paramInt = 4;
        break label1026;
        label1456:
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i4, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, i1, BaseChatItemLayout.o);
      }
      label1489:
      Object localObject3;
      if (i1 == 2)
      {
        if (paramHolder.jdField_b_of_type_AndroidWidgetImageView == null)
        {
          localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((ImageView)localObject2).setId(2131296395);
          ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject3).setImageDrawable(new ColorDrawable(838860800));
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
          localObject4 = new RelativeLayout.LayoutParams(i7, -1);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
          ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((ImageView)localObject3).setId(2131296396);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject2);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
          paramHolder.c = ((ImageView)localObject3);
          label1658:
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
          if (i2 == 0) {
            break label1948;
          }
          i1 = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
          label1686:
          if (!paramMessageForPtt.isSend()) {
            break label1966;
          }
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, -1);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296395);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131296394);
          ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131296394);
          ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).addRule(1, 2131296396);
          i3 = 2130841745;
          i2 = 2130840071;
          if (c(paramMessageForPtt))
          {
            i3 = 2130840073;
            i2 = 2130840069;
          }
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(i3);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i2);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i4, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setPadding(i4, 0, i4, 0);
          paramHolder.c.setPadding(0, BaseChatItemLayout.r, 0, BaseChatItemLayout.r);
          label1888:
          localObject2 = (Animatable)paramHolder.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
          if (paramMessageForPtt.sttAbility != 1) {
            break label2159;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(paramMessageForPtt)) {
            break label2149;
          }
          ((Animatable)localObject2).start();
        }
        for (;;)
        {
          break;
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramHolder.c.setVisibility(0);
          break label1658;
          label1948:
          i1 = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
          break label1686;
          label1966:
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296396);
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296394);
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131296394);
          ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131296394);
          i3 = 2130841744;
          i2 = 2130840070;
          if (c(paramMessageForPtt))
          {
            i3 = 2130840073;
            i2 = 2130840069;
          }
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(i3);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i2);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i4, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, i1, BaseChatItemLayout.o);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setPadding(i4, 0, i4, 0);
          paramHolder.c.setPadding(0, BaseChatItemLayout.r, 0, BaseChatItemLayout.r);
          break label1888;
          label2149:
          ((Animatable)localObject2).stop();
          continue;
          label2159:
          if (paramMessageForPtt.sttAbility == 2) {
            ((Animatable)localObject2).stop();
          }
        }
      }
      if (paramHolder.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject3).setImageDrawable(new ColorDrawable(838860800));
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i7);
        ((ImageView)localObject3).setLayoutParams(localLayoutParams1);
        ((ImageView)localObject3).setId(2131296398);
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        if (paramMessageForPtt.isSend())
        {
          localObject2 = ((Resources)localObject4).getColorStateList(2131427945);
          label2269:
          localTextView.setTextColor((ColorStateList)localObject2);
          localTextView.setId(2131296397);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localImageView.setLayoutParams(localLayoutParams2);
          localImageView.setImageResource(2130840068);
          localImageView.setScaleType(ImageView.ScaleType.FIT_END);
          localLayoutParams1.addRule(3, 2131296394);
          localLayoutParams1.addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131296398);
          localLayoutParams2.addRule(3, 2131296398);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131296397);
          localLayoutParams2.addRule(8, 2131296397);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramHolder.d = ((ImageView)localObject3);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView = localTextView;
          paramHolder.e = localImageView;
          label2459:
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          if (i2 == 0) {
            break label2844;
          }
          localObject3 = paramMessageForPtt.sttText;
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131366445);
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
            this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          i1 = a(paramMessageForPtt.timeLength, (String)localObject2, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0, i4 * 2 + i6 + i7, false);
          label2593:
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          i2 = AIOUtils.a(22.0F, (Resources)localObject4) + i5;
          if (!paramMessageForPtt.isSend()) {
            break label2862;
          }
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296394);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296394);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296394);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296394);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i4, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
          paramHolder.d.setPadding(i4, 0, i4, 0);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(i4, BaseChatItemLayout.n, i4, i2);
          paramHolder.e.setPadding(0, 0, 0, i3);
        }
      }
      for (;;)
      {
        localObject3 = paramMessageForPtt.sttText;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131366445);
        }
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        break;
        localObject2 = ((Resources)localObject4).getColorStateList(2131427942);
        break label2269;
        paramHolder.d.setVisibility(0);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramHolder.e.setVisibility(0);
        break label2459;
        label2844:
        i1 = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
        break label2593;
        label2862:
        localObject2 = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296394);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296394);
        localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296394);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296394);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i4, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, i1, BaseChatItemLayout.o);
        paramHolder.d.setPadding(i4, 0, i4, 0);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(i4, BaseChatItemLayout.n, i4, i2);
        paramHolder.e.setPadding(0, 0, 0, i3);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      Object localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = "重新发送语音消息";; paramMessageForPtt = "重新拉取语音消息")
      {
        ((ImageView)localObject2).setContentDescription(paramMessageForPtt);
        break;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130838136, null);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getDrawable()).start();
      break label430;
      label3097:
      localObject1 = null;
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(paramView), false);
        b();
      }
    }
  }
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    if (!paramBoolean) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "转文字失败，请稍候重试", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.url));
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    if (paramXListView.isReady())
    {
      e();
      paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      if (paramAudioPlayer.a(paramXListView.url))
      {
        a(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, a(paramXListView), true);
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo, 0);
        }
        return true;
      }
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (MessageForPtt)AIOUtils.a(paramView);
    if (!paramView.isReady())
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
    if (QQRecorder.a(paramView.url) <= 0)
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
    if ((paramView.sttAbility == 2) && (paramView.expandStt))
    {
      localQQCustomMenu.a(2131302484, this.jdField_a_of_type_AndroidContentContext.getString(2131366395));
      localQQCustomMenu.a(2131298174, this.jdField_a_of_type_AndroidContentContext.getString(2131366396));
    }
    localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131365743));
    localQQCustomMenu.a(2131298924, this.jdField_a_of_type_AndroidContentContext.getString(2131364620));
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131296393);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131296392);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427942));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131296394);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramViewHolder.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131296392);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int i2 = a(localMessageForPtt);
      int i1 = i2;
      if (i2 == -1)
      {
        b(paramBaseChatItemLayout, localMessageForPtt);
        i1 = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i1 + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      PttInfoCollector.a(localMessageForPtt.uniseq, localMessageForPtt.frienduin);
      a(paramBaseChatItemLayout, localMessageForPtt, i1, b(localMessageForPtt));
      if (PttInfoCollector.a()) {
        PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences());
      }
      PttInfoCollector.a(i1);
      return paramViewHolder;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131296393);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected void b(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fvv(this, paramMessageForPtt));
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
    PttInfoCollector.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences());
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.h = true;
    int i1 = paramView.getId();
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPtt localMessageForPtt = (MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (i1 == 2131296394)
    {
      PttInfoCollector.b(localMessageForPtt.uniseq, localMessageForPtt.frienduin);
      if (b(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    label66:
    do
    {
      do
      {
        do
        {
          break label66;
          do
          {
            return;
          } while ((localMessageForPtt == MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) || (!localMessageForPtt.isReady()));
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131366443, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
            return;
          }
        } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView)));
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131366444, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
        return;
        if (i1 != 2131296395) {
          break;
        }
        if (localMessageForPtt.sttAbility == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(localMessageForPtt);
          this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(this);
          a(localHolder, localMessageForPtt, a(localMessageForPtt), b(localMessageForPtt));
          return;
        }
      } while ((localMessageForPtt.sttAbility != 2) || (localMessageForPtt.expandStt));
      localMessageForPtt.expandStt = true;
      localMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
      a(localHolder, localMessageForPtt, a(localMessageForPtt), b(localMessageForPtt));
      a(localHolder, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForPtt, localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      return;
      if (i1 != 2131296397) {
        break;
      }
    } while (!localMessageForPtt.expandStt);
    localMessageForPtt.expandStt = false;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
    a(localHolder, localMessageForPtt, a(localMessageForPtt), b(localMessageForPtt));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
    return;
    if (i1 == 2131296323)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      paramView.putExtra("url", "https://m.vip.qq.com/freedom/freedom_longvoice.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder
 * JD-Core Version:    0.7.0.1
 */