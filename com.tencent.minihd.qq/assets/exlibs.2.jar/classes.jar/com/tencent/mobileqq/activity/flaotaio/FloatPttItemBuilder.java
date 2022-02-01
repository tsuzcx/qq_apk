package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.stt.SttManager.ISttListener;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import gmq;

public class FloatPttItemBuilder
  extends FloatBaseBubbleBuilder
  implements FileTransferManager.Callback, MediaPlayerManager.Callback, SttManager.ISttListener
{
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 4;
  private static final int i = 1;
  private static final int j = 2;
  private static final int k = 3;
  private SttManager a;
  
  public FloatPttItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager = ((SttManager)paramQQAppInterface.getManager(16));
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
  }
  
  private int a(int paramInt1, String paramString, Paint paramPaint, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int m = Math.min(60, Math.max(1, paramInt1));
    int n;
    float f1;
    if (m > 40)
    {
      m += 40;
      n = AIOUtils.a(m + 20, this.jdField_a_of_type_AndroidContentContext.getResources());
      if ((paramString == null) || (paramPaint == null)) {
        break label199;
      }
      m = FloatBaseChatItemLayout.g - FloatBaseChatItemLayout.k - FloatBaseChatItemLayout.l - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= m) {
        break label202;
      }
      f1 = m;
    }
    label199:
    label202:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int i1 = AIOUtils.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramInt2 = n + i1 + paramInt3;
        paramInt1 = paramInt2;
        if (paramInt2 > m) {
          paramInt1 = m;
        }
        paramInt2 = Math.max(paramInt1, (int)f1) - i1;
        paramInt1 = paramInt2;
        if (paramBoolean) {
          paramInt1 = paramInt2 - paramInt3;
        }
        return paramInt1;
        m *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return n;
    }
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected int a(MessageForPtt paramMessageForPtt)
  {
    int m = 1005;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.aE))) {
        if (paramMessageForPtt.fileSize > 0L) {
          m = 1003;
        }
      }
    }
    do
    {
      int n;
      do
      {
        do
        {
          return m;
        } while (paramMessageForPtt.fileSize == -1L);
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt)) {
            return 999;
          }
          paramMessageForPtt.fileSize = -1L;
          return 1005;
        }
        if (paramMessageForPtt.fileSize == -3L)
        {
          m = 1001;
          n = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
          if ((n == 1005) || (n == -1))
          {
            paramMessageForPtt.fileSize = -1L;
            m = 1005;
          }
          return m;
        }
        return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
        return 1004;
        if (paramMessageForPtt == null) {
          break;
        }
        if (paramMessageForPtt.url == null) {
          return 2005;
        }
        if ((paramMessageForPtt.url.startsWith(AppConstants.aE)) && (FileUtils.a(paramMessageForPtt.url))) {
          return 2003;
        }
        n = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt.url, paramMessageForPtt.uniseq);
        m = n;
      } while (n != -1);
      m = n;
    } while (paramMessageForPtt.fileSize != -4L);
    return 2005;
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramFloatBaseChatItemLayout);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout, this);
    return paramChatMessage;
  }
  
  protected FloatBaseBubbleBuilder.ViewHolder a()
  {
    return new FloatPttItemBuilder.Holder();
  }
  
  protected String a(int paramInt)
  {
    String str = "";
    int m = paramInt / 60;
    if (m > 0) {
      str = m + "'";
    }
    return str + paramInt % 60 + "\"";
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
    paramView = (FloatPttItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.b)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout);
          PttInfoCollector.c(paramFileMsg.c, localMessageForPtt.frienduin);
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      a(paramView, localMessageForPtt, paramInt2, b(localMessageForPtt));
      return;
      if ((paramFileMsg.D == 1005) || (paramFileMsg.D == 1004))
      {
        a(paramView.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout);
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
  
  protected void a(FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    FloatPttItemBuilder.Holder localHolder = (FloatPttItemBuilder.Holder)paramViewHolder;
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
  
  protected void a(FloatPttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new gmq(this, paramMessageForPtt));
  }
  
  protected void a(FloatPttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setUnread(false);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
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
    localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
        return;
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject1), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject1), BaseChatItemLayout.o);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
        paramInt = 1;
        continue;
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(20.0F, (Resources)localObject1), BaseChatItemLayout.n, AIOUtils.a(20.0F, (Resources)localObject1), BaseChatItemLayout.o);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
        paramInt = 0;
        continue;
        if (paramMessageForPtt.timeLength <= 0) {
          paramMessageForPtt.timeLength = QQRecorder.a(paramMessageForPtt.url);
        }
        if (paramMessageForPtt.timeLength <= 0)
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject1), BaseChatItemLayout.n, AIOUtils.a(10.0F, (Resources)localObject1), BaseChatItemLayout.o);
          return;
        }
        if (paramMessageForPtt.timeLength > PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
          paramMessageForPtt.sttAbility = 0;
        }
        if (TextUtils.isEmpty(paramMessageForPtt.timeStr)) {
          paramMessageForPtt.timeStr = a(paramMessageForPtt.timeLength);
        }
        Object localObject2 = paramMessageForPtt.timeStr;
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
        paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        if (paramMessageForPtt.isSend()) {
          if (paramBoolean)
          {
            localObject2 = (AnimationDrawable)((Resources)localObject1).getDrawable(2130968647);
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            ((AnimationDrawable)localObject2).start();
            label640:
            if ((paramInt != 2003) && (paramInt != 1003)) {
              break label888;
            }
            if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setUnread(true);
            }
            if (paramMessageForPtt.sttAbility != 0) {
              break label863;
            }
            paramInt = 0;
          }
        }
        int m;
        int n;
        for (;;)
        {
          m = AIOUtils.a(9.0F, (Resources)localObject1);
          AIOUtils.a(12.0F, (Resources)localObject1);
          ((Resources)localObject1).getDrawable(2130840068).getIntrinsicWidth();
          ((Resources)localObject1).getDrawable(2130840068).getIntrinsicHeight();
          ((Resources)localObject1).getDrawable(2130841743).getIntrinsicWidth();
          AIOUtils.a(1.0F, (Resources)localObject1);
          n = a(paramMessageForPtt.timeLength, null, null, 0, 0, false);
          if (!paramMessageForPtt.isSend()) {
            break label912;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, m, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(n, BaseChatItemLayout.n, BaseChatItemLayout.s, BaseChatItemLayout.o);
          break;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841733);
          break label640;
          if (paramBoolean)
          {
            localObject2 = (AnimationDrawable)((Resources)localObject1).getDrawable(2130968766);
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            ((AnimationDrawable)localObject2).start();
            break label640;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841732);
          break label640;
          label863:
          if (paramMessageForPtt.sttAbility == 1)
          {
            paramInt = 0;
          }
          else
          {
            if (paramMessageForPtt.expandStt) {}
            paramInt = 0;
            continue;
            label888:
            if ((paramInt == 1005) || (paramInt == 1004)) {
              paramInt = 1;
            } else {
              paramInt = 4;
            }
          }
        }
        label912:
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(m, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.n, n, BaseChatItemLayout.o);
      }
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setFailedIconVisable(true, this);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView;
    if (paramMessageForPtt.isSendFromLocal()) {}
    for (paramHolder = "重新发送语音消息";; paramHolder = "重新拉取语音消息")
    {
      ((ImageView)localObject1).setContentDescription(paramHolder);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setFailedIconResource(2130838136, null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getDrawable()).start();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof FloatPttItemBuilder.Holder))
      {
        paramXListView = (FloatPttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(paramView), false);
      }
    }
  }
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    if (!paramBoolean) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "转文字失败，请稍候重试", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
    }
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
      paramView = (FloatPttItemBuilder.Holder)AIOUtils.a(paramView);
      if (paramAudioPlayer.a(paramXListView.url))
      {
        a(paramXListView);
        if (paramView != null) {
          a(paramView, paramXListView, a(paramXListView), true);
        }
        return true;
      }
    }
    return false;
  }
  
  protected View b(ChatMessage paramChatMessage, FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    paramFloatBaseChatItemLayout = (FloatPttItemBuilder.Holder)paramViewHolder;
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
      paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131296392);
      ((RelativeLayout.LayoutParams)paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int n = a(localMessageForPtt);
      int m = n;
      if (n == -1)
      {
        a(paramFloatBaseChatItemLayout, localMessageForPtt);
        m = 2001;
      }
      PttInfoCollector.a(localMessageForPtt.uniseq, localMessageForPtt.frienduin);
      a(paramFloatBaseChatItemLayout, localMessageForPtt, m, b(localMessageForPtt));
      if (PttInfoCollector.a()) {
        PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences());
      }
      PttInfoCollector.a(m);
      return paramViewHolder;
      ((RelativeLayout.LayoutParams)paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131296393);
      ((RelativeLayout.LayoutParams)paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
    PttInfoCollector.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences());
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.h = true;
    int m = paramView.getId();
    FloatPttItemBuilder.Holder localHolder = (FloatPttItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPtt localMessageForPtt = (MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (m == 2131296394)
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
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131366443, 0).a();
            return;
          }
        } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView)));
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131366444, 0).a();
        return;
        if (m != 2131296395) {
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
      a(localHolder, localHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout, localMessageForPtt, localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      return;
      if (m != 2131296397) {
        break;
      }
    } while (!localMessageForPtt.expandStt);
    localMessageForPtt.expandStt = false;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
    a(localHolder, localMessageForPtt, a(localMessageForPtt), b(localMessageForPtt));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
    return;
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatPttItemBuilder
 * JD-Core Version:    0.7.0.1
 */