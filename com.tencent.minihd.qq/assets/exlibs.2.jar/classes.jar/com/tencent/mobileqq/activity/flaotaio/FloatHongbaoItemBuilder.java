package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.activity.empty.PayBridgeNewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import gmg;
import gmh;
import java.net.URLDecoder;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class FloatHongbaoItemBuilder
  extends FloatBaseBubbleBuilder
{
  public static final String a = "from_float_aio";
  public static final String b = "from_float_nick";
  public static final String c = "hongbao_sender_uin";
  public long a;
  private View.OnClickListener a;
  
  public FloatHongbaoItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new gmg(this);
  }
  
  private FrameLayout a(Context paramContext)
  {
    paramContext = (FrameLayout)LayoutInflater.from(paramContext).inflate(2130903319, null);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_a_of_type_Float * 4.0F));
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (TextView)paramContext.findViewById(2131297701);
    ((TextView)localObject).setMaxWidth((int)(((TextView)localObject).getPaint().measureText("测") * 5.0F + 0.5F));
    return paramContext;
  }
  
  private String a()
  {
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    return "";
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    switch (paramMessageRecord.istroop)
    {
    default: 
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      break;
    case 1: 
    case 3000: 
      return paramMessageRecord.senderuin;
    }
    return paramMessageRecord.frienduin;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, SessionInfo paramSessionInfo)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramSessionInfo == null)) {
      return false;
    }
    paramString1 = paramString1.split("\\?");
    if ((TextUtils.isEmpty(paramString1[0])) && (paramString1.length != 2)) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    if ((paramString1.length > 1) && (!TextUtils.isEmpty(paramString1[1])))
    {
      String[] arrayOfString1 = paramString1[1].split("&");
      int i = 0;
      if (i < arrayOfString1.length)
      {
        if (TextUtils.isEmpty(arrayOfString1[i])) {}
        for (;;)
        {
          i += 1;
          break;
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length == 2) {
            try
            {
              arrayOfString2[1] = URLDecoder.decode(arrayOfString2[1], "UTF-8");
              localHashMap.put(arrayOfString2[0], arrayOfString2[1]);
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    if (paramString1[0].equals("red"))
    {
      paramString1 = (String)localHashMap.get("id");
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      paramString2 = QQWalletMsgItemBuilder.a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", paramSessionInfo);
      paramString1 = new Bundle();
      paramString1.putString("json", paramString2.toString());
      paramString1.putString("callbackSn", "0");
      paramString2 = new Intent(paramContext, PayBridgeNewActivity.class);
      paramString2.putExtras(paramString1);
      paramString2.putExtra("pay_requestcode", 5);
      paramString2.putExtra("from_float_aio", true);
      paramString2.putExtra("from_float_nick", paramQQAppInterface.c());
      paramString2.setFlags(268435456);
      paramContext.startActivity(paramString2);
      return true;
    }
    return false;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    paramView = (gmh)paramViewHolder;
    if ((paramView.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (paramView.jdField_a_of_type_Long == paramChatMessage.uniseq)) {
      return paramView.jdField_a_of_type_AndroidWidgetFrameLayout;
    }
    if (paramView.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout = a(this.jdField_a_of_type_AndroidContentContext);
    }
    paramView.jdField_a_of_type_Long = paramChatMessage.uniseq;
    paramViewHolder = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((paramViewHolder == null) || (paramViewHolder.mQQWalletRedPacketMsg == null)) {
      return paramView.jdField_a_of_type_AndroidWidgetFrameLayout;
    }
    paramViewHolder = paramViewHolder.mQQWalletRedPacketMsg.elem;
    if (paramViewHolder == null) {
      return paramView.jdField_a_of_type_AndroidWidgetFrameLayout;
    }
    paramFloatBaseChatItemLayout = (TextView)paramView.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297701);
    ImageView localImageView1 = (ImageView)paramView.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297699);
    ImageView localImageView2 = (ImageView)paramView.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297700);
    if (paramChatMessage.isSend())
    {
      localImageView2.setVisibility(0);
      localImageView1.setVisibility(8);
    }
    for (;;)
    {
      paramFloatBaseChatItemLayout.setText(paramViewHolder.title);
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView.jdField_a_of_type_AndroidWidgetFrameLayout;
      localImageView2.setVisibility(8);
      localImageView1.setVisibility(0);
    }
  }
  
  protected FloatBaseBubbleBuilder.ViewHolder a()
  {
    return new gmh(this, null);
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatHongbaoItemBuilder
 * JD-Core Version:    0.7.0.1
 */