package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import fwa;
import fwb;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QQWalletMsgItemBuilder
  extends BaseBubbleBuilder
{
  public static final String c = "open_hb_detail";
  public static boolean d;
  public long a;
  private View.OnClickListener a;
  protected String b = "";
  protected final int f = 2131300910;
  protected final int g = 2131300914;
  protected final int h = 2131300898;
  protected final int i = 2131300902;
  protected final int j = 2131300906;
  protected final int k = 2131300899;
  protected final int l = 2131300897;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  
  public QQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fwa(this);
    this.b = paramContext.getString(2131365059);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.m = ((int)(222.0F * f1 + 0.5F));
    this.n = ((int)(42.0F * f1 + 0.5F));
    this.o = ((int)(21.0F * f1 + 0.5F));
    this.p = ((int)(15.0F * f1 + 0.5F));
    this.q = ((int)(10.0F * f1 + 0.5F));
    this.r = ((int)(9.0F * f1 + 0.5F));
    this.s = ((int)(6.0F * f1 + 0.5F));
    this.t = ((int)(f1 * 4.0F + 0.5F));
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, SessionInfo paramSessionInfo)
  {
    int i1 = 2;
    paramContext = "";
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      i1 = -1;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      paramSessionInfo = new JSONObject();
      try
      {
        localJSONObject.put("listid", paramString1);
        localJSONObject.put("name", paramContext);
        localJSONObject.put("grouptype", i1 + "");
        localJSONObject.put("groupid", paramString3);
        if (paramString2 != null) {
          localJSONObject.put("authkey", paramString2);
        }
        paramSessionInfo.put("userId", paramQQAppInterface.a());
        paramSessionInfo.put("viewTag", paramString5);
        paramSessionInfo.put("app_info", paramString4);
        paramSessionInfo.put("come_from", 2);
        paramSessionInfo.put("extra_data", localJSONObject);
      }
      catch (Exception paramQQAppInterface)
      {
        int i2;
        while (!QLog.isDevelopLevel()) {}
        paramQQAppInterface.printStackTrace();
      }
      return paramSessionInfo;
      i1 = 0;
      paramContext = paramQQAppInterface.c();
      continue;
      paramContext = ContactUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.a());
      continue;
      paramContext = (HotChatManager)paramQQAppInterface.getManager(58);
      if ((paramContext != null) && (paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        i2 = 5;
        paramSessionInfo = ContactUtils.m(paramQQAppInterface, paramQQAppInterface.a());
        paramContext = paramSessionInfo;
        i1 = i2;
        if (TextUtils.isEmpty(paramSessionInfo))
        {
          paramContext = paramQQAppInterface.c();
          i1 = i2;
        }
      }
      else
      {
        i1 = 1;
        paramContext = paramQQAppInterface.c();
        continue;
        i1 = 3;
        paramContext = paramQQAppInterface.c();
        continue;
        i1 = 4;
        paramContext = paramQQAppInterface.c();
        continue;
        i2 = 6;
        paramSessionInfo = ContactUtils.m(paramQQAppInterface, paramQQAppInterface.a());
        paramContext = paramSessionInfo;
        i1 = i2;
        if (TextUtils.isEmpty(paramSessionInfo))
        {
          paramContext = paramQQAppInterface.c();
          i1 = i2;
        }
      }
    }
    return paramSessionInfo;
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
    return true;
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    String[] arrayOfString1 = paramString1.split("\\?");
    if (TextUtils.isEmpty(arrayOfString1[0])) {
      return false;
    }
    Object localObject = new HashMap();
    if ((arrayOfString1.length > 1) && (!TextUtils.isEmpty(arrayOfString1[1])))
    {
      String[] arrayOfString2 = arrayOfString1[1].split("&");
      int i1 = 0;
      if (i1 < arrayOfString2.length)
      {
        if (TextUtils.isEmpty(arrayOfString2[i1])) {}
        for (;;)
        {
          i1 += 1;
          break;
          String[] arrayOfString3 = arrayOfString2[i1].split("=");
          if (arrayOfString3.length == 2)
          {
            try
            {
              arrayOfString3[1] = URLDecoder.decode(arrayOfString3[1], "UTF-8");
              ((HashMap)localObject).put(arrayOfString3[0], arrayOfString3[1]);
            }
            catch (Exception localException)
            {
              if (QLog.isDevelopLevel()) {
                localException.printStackTrace();
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to URLDecoder.decode WalletAction value,tmps[1] is:" + arrayOfString3[0] + ",tmps[1] is:" + arrayOfString3[1], localException);
            }
          }
        }
      }
    }
    if (arrayOfString1[0].equals("pay"))
    {
      paramString1 = (String)((HashMap)localObject).get("payData");
      paramString2 = (String)((HashMap)localObject).get("reqCode");
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
        return false;
      }
      paramString3 = new Bundle();
      paramString3.putString("json", paramString1);
      paramString3.putString("callbackSn", "0");
      paramString1 = new Intent(paramContext, PayBridgeActivity.class);
      paramString1.putExtras(paramString3);
      paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString2).intValue());
    }
    label695:
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to startActivity : " + arrayOfString1[0], paramContext);
        return false;
      }
      if (arrayOfString1[0].equals("red"))
      {
        localObject = (String)((HashMap)localObject).get("id");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        paramString2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, (String)localObject, paramString2, paramString3, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramString3 = new Bundle();
        paramString3.putString("json", paramString2.toString());
        paramString3.putString("callbackSn", "0");
        paramString2 = new Intent(paramContext, PayBridgeActivity.class);
        paramString2.putExtras(paramString3);
        paramString2.putExtra("pay_requestcode", 5);
        paramString3 = new Intent("circle_hb_opend");
        paramString3.putExtra("nativeAndroid", paramString1);
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramString3);
        paramString1 = paramString2;
      }
      else
      {
        try
        {
          paramString1 = QQWalletMsgItemBuilder.class.getClassLoader();
          if (paramString1 == null) {
            return false;
          }
          paramString1 = paramString1.loadClass(arrayOfString1[0]);
        }
        catch (Exception paramString1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          paramString1.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to find Class : " + arrayOfString1[0], paramString1);
          paramString1 = null;
          continue;
          paramString1 = new Intent(paramContext, paramString1);
          paramString2 = ((HashMap)localObject).entrySet().iterator();
          if (!paramString2.hasNext()) {
            break label695;
          }
        }
        if (paramString1 == null) {
          return false;
        }
        paramString3 = (Map.Entry)paramString2.next();
        paramString1.putExtra((String)paramString3.getKey(), (String)paramString3.getValue());
      }
    }
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
    return true;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130840813;
    case 2: 
      return 2130840810;
    case 3: 
      return 2130840814;
    }
    return 2130840806;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    fwb localfwb = (fwb)paramViewHolder;
    if ((localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localfwb.jdField_a_of_type_Long == paramChatMessage.uniseq)) {
      return localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    if (localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout = a(this.jdField_a_of_type_AndroidContentContext);
    }
    localfwb.jdField_a_of_type_Long = paramChatMessage.uniseq;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;; paramViewHolder = null)
    {
      if (paramViewHolder == null) {
        return localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout;
      }
      if ((paramViewHolder.mQQWalletTransferMsg == null) && (paramViewHolder.mQQWalletRedPacketMsg == null)) {
        return localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout;
      }
      if (paramViewHolder.mQQWalletTransferMsg != null)
      {
        paramView = paramViewHolder.mQQWalletTransferMsg.elem;
        paramViewHolder = paramView;
        if (paramView == null) {
          return localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
      }
      else
      {
        if (paramViewHolder.mQQWalletRedPacketMsg == null) {
          break label460;
        }
        paramView = paramViewHolder.mQQWalletRedPacketMsg.elem;
        paramViewHolder = paramView;
        if (paramView == null) {
          return localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
      }
      for (;;)
      {
        paramView = (TextView)localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300898);
        TextView localTextView1 = (TextView)localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300902);
        ImageView localImageView = (ImageView)localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300914);
        TextView localTextView2 = (TextView)localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300899);
        paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131300897);
        QQWalletTransferBubbleView localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300910);
        paramView.setText(paramViewHolder.title);
        paramView.setTextColor(paramViewHolder.titleColor);
        localTextView1.setText(paramViewHolder.subTitle);
        localTextView1.setTextColor(paramViewHolder.subtitleColor);
        localTextView2.setText(paramViewHolder.content);
        localImageView.setImageResource(a(paramViewHolder.icon));
        int i1 = paramViewHolder.background;
        boolean bool;
        if (!paramChatMessage.isSend())
        {
          bool = true;
          localQQWalletTransferBubbleView.setBubbleBackground(2130840811, i1, bool);
          if (TextUtils.isEmpty(paramViewHolder.blackStripe)) {
            break label450;
          }
          paramBaseChatItemLayout.setText(paramViewHolder.blackStripe);
          paramBaseChatItemLayout.setVisibility(0);
        }
        for (;;)
        {
          localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramViewHolder.title + paramViewHolder.subTitle + this.b);
          localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
          localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
          return localfwb.jdField_a_of_type_AndroidWidgetRelativeLayout;
          bool = false;
          break;
          label450:
          paramBaseChatItemLayout.setVisibility(8);
        }
        label460:
        paramViewHolder = null;
      }
    }
  }
  
  protected RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject1 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.m, -2));
    ((QQWalletTransferBubbleView)localObject1).setId(2131300910);
    Object localObject2 = new ImageView(paramContext);
    Object localObject3 = new RelativeLayout.LayoutParams(this.n, this.n);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setId(2131300914);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(this.q * 12, -2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(24.0F);
    ((TextView)localObject3).setId(2131300898);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = (this.q / 2);
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(14.0F);
    ((TextView)localObject3).setId(2131300902);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(this.m, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131300910);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setBackgroundResource(2130840812);
    ((RelativeLayout)localObject1).setId(2131300906);
    paramContext = new TextView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131300899);
    ((RelativeLayout)localObject1).addView(paramContext);
    localRelativeLayout.addView((View)localObject1);
    return localRelativeLayout;
  }
  
  protected TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.q;
    localLayoutParams.bottomMargin = this.s;
    localLayoutParams.leftMargin = (this.n + this.t);
    localLayoutParams.rightMargin = (this.n + this.t);
    localLayoutParams.addRule(3, 2131296322);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130840060);
    paramContext.setPadding(this.r, this.t, this.r, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.t, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131300897);
    return paramContext;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new fwb(this, null);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */