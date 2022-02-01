package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.business.base.AppUtil;
import fvp;
import fvq;
import java.util.ArrayList;
import java.util.List;

public class PASingleItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PASingleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fvp(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (PAMessageUtil.a(paramString1, paramContext)) {
      return;
    }
    if ((paramString2 != null) && (paramString2.equals("open_local")))
    {
      paramString1 = new Bundle();
      paramString1.putString("schemaurl", paramString3);
      paramString1.putString("uin", paramQQAppInterface.a());
      paramString1.putString("vkey", paramQQAppInterface.d());
      OpenAppClient.b((Activity)paramContext, paramString1);
      return;
    }
    paramString1 = new Intent(paramContext, PublicAccountBrowser.class);
    paramString1.putExtra("uin", paramQQAppInterface.a());
    paramString1.putExtra("url", paramString3);
    paramString1.putExtra("assignBackText", paramContext.getResources().getString(2131366374));
    paramString1.putExtra("puin", paramString4);
    paramString1.putExtra("source_name", paramString5);
    paramString1.putExtra("fromAio", true);
    PublicAccountUtil.a(paramString1, paramString3);
    paramContext.startActivity(paramString1);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramString4, "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString3, "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    int i = 0;
    paramString2 = Uri.parse(paramString2);
    paramString1 = paramString2.getScheme();
    paramString2 = paramString2.getHost();
    if ((!TextUtils.isEmpty(paramString1)) && (AppUtil.a(paramString1)))
    {
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      if (AppLaucherHelper.a(paramString2) == 0) {}
      Bundle localBundle;
      int j;
      for (;;)
      {
        localBundle = AppLaucherHelper.a(paramString2);
        j = localBundle.getInt("a_launch_mode", 268435456);
        if (i == 0) {
          break;
        }
        localAppLaucherHelper.a(paramQQAppInterface, paramContext, String.valueOf(paramLong), paramString2, paramString1, j);
        return true;
        i = 1;
      }
      return AppUtil.a(paramContext, paramString1, localBundle, j);
    }
    return false;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903148, null);
    }
    Object localObject2 = (MessageForPubAccount)paramMessageRecord;
    paramMessageRecord = (fvq)paramViewHolder;
    paramViewHolder = paramLinearLayout.findViewById(2131297077);
    Object localObject1 = (TextView)paramLinearLayout.findViewById(2131297079);
    paramView = (TextView)paramLinearLayout.findViewById(2131297078);
    paramView = (ImageView)paramLinearLayout.findViewById(2131297080);
    Object localObject4 = (TextView)paramLinearLayout.findViewById(2131297081);
    Object localObject5 = (TextView)paramLinearLayout.findViewById(2131297082);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131297083);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131297084);
    TextView localTextView3 = (TextView)paramLinearLayout.findViewById(2131297085);
    Object localObject3 = (TextView)paramLinearLayout.findViewById(2131297086);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject4);
    localArrayList.add(localObject5);
    localArrayList.add(localTextView1);
    localArrayList.add(localTextView2);
    localArrayList.add(localTextView3);
    localObject5 = ((MessageForPubAccount)localObject2).mPAMessage;
    localObject4 = (PAMessage.Item)((PAMessage)localObject5).items.get(0);
    paramMessageRecord.c = ((PAMessage.Item)localObject4).url;
    paramMessageRecord.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject4).actionUrl;
    paramMessageRecord.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject4).nativeJumpString;
    paramMessageRecord.jdField_b_of_type_Int = ((PAMessage)localObject5).type;
    paramMessageRecord.jdField_a_of_type_Int = 5;
    paramMessageRecord.jdField_a_of_type_JavaLangObject = Long.valueOf(((MessageForPubAccount)localObject2).uniseq);
    paramMessageRecord.d = ((PAMessage)localObject5).moreText;
    paramMessageRecord.jdField_a_of_type_Long = ((PAMessage.Item)localObject4).appId;
    paramMessageRecord.e = ((PAMessage.Item)localObject4).actionData;
    paramMessageRecord.f = ((PAMessage.Item)localObject4).a_actionData;
    paramMessageRecord.g = ((PAMessage.Item)localObject4).i_actionData;
    if (!TextUtils.isEmpty(((PAMessage)localObject5).moreText)) {
      ((TextView)localObject3).setText(((PAMessage)localObject5).moreText);
    }
    for (;;)
    {
      localObject2 = Util.e(((PAMessage.Item)localObject4).title);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      if (((PAMessage.Item)localObject4).mVideoFlag == 1)
      {
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839268);
        int i = Util.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        ((Drawable)localObject3).setBounds(i, 0, Util.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + i, Util.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        localObject5 = new SpannableString((String)localObject2 + "1");
        ((SpannableString)localObject5).setSpan(new ImageSpan((Drawable)localObject3, 0), ((String)localObject2).length(), ((String)localObject2).length() + 1, 17);
        ((TextView)localObject1).setText((CharSequence)localObject5);
      }
      try
      {
        localObject1 = URLDrawable.getDrawable(PubAccountHttpDownloader.a(((PAMessage.Item)localObject4).cover));
        ((URLDrawable)localObject1).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramView.setImageDrawable((Drawable)localObject1);
        paramView = ((PAMessage.Item)localObject4).digestList;
        if (paramView != null) {
          paramView.size();
        }
        paramViewHolder.setTag(paramMessageRecord);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramLinearLayout;
        ((TextView)localObject3).setText(2131368504);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramView.setImageResource(2130837581);
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new fvq(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      PublicAccountUtil.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131302479, this.jdField_a_of_type_AndroidContentContext.getString(2131366320));
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder
 * JD-Core Version:    0.7.0.1
 */