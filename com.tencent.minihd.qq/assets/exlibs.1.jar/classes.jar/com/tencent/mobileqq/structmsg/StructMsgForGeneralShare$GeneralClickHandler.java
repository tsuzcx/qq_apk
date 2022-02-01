package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

public class StructMsgForGeneralShare$GeneralClickHandler
  extends StructMsgClickHandler
{
  StructingMsgItemBuilder.StructingMsgViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder;
  StructMsgForGeneralShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
  
  public StructMsgForGeneralShare$GeneralClickHandler(View paramView)
  {
    super(paramView);
  }
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramQQAppInterface, paramView);
  }
  
  public StructMsgForGeneralShare$GeneralClickHandler(QQAppInterface paramQQAppInterface, View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    super(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = paramStructMsgForGeneralShare;
    paramQQAppInterface = paramView.getTag();
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructingMsgItemBuilder.StructingMsgViewHolder))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder = ((StructingMsgItemBuilder.StructingMsgViewHolder)paramQQAppInterface);
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "GeneralClickHandler clickWebMsg url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    StructMsgForGeneralShare localStructMsgForGeneralShare = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
    StructingMsgItemBuilder.StructingMsgViewHolder localStructingMsgViewHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder;
    Object localObject2 = paramString.trim();
    boolean bool = ((String)localObject2).startsWith("https://gamecenter.qq.com");
    long l = AppShareIDUtil.a(localStructMsgForGeneralShare.mSourceAppid);
    String str2 = ((QQAppInterface)localObject1).getSid();
    String str1 = ((QQAppInterface)localObject1).a();
    paramString = ((QQAppInterface)localObject1).c();
    if ((55901189L == l) || (274201605L == l) || (440495416L == l))
    {
      localObject1 = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject1).a = str1;
      ((QZoneHelper.UserInfo)localObject1).b = paramString;
      ((QZoneHelper.UserInfo)localObject1).c = str2;
      QZoneHelper.a((Activity)localContext, (QZoneHelper.UserInfo)localObject1, (String)localObject2, "mqqChat", -1);
    }
    for (;;)
    {
      return true;
      if ((2274034950L != l) && (2223703302L != l)) {
        break;
      }
      localObject1 = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject1).a = str1;
      ((QZoneHelper.UserInfo)localObject1).b = paramString;
      ((QZoneHelper.UserInfo)localObject1).c = str2;
      QZoneHelper.a((Activity)localContext, (QZoneHelper.UserInfo)localObject1, (String)localObject2, -1, "mqqChat");
    }
    int i;
    label260:
    label270:
    Intent localIntent;
    if ((((String)localObject2).startsWith("https://m.qzone.com")) || (((String)localObject2).startsWith("https://mobile.qzone.qq.com")))
    {
      i = 1;
      if ((!bool) && (i == 0)) {
        break label668;
      }
      i = 1;
      localIntent = new Intent(localContext, QQBrowserDelegationActivity.class);
      paramString = HtmlOffline.a((String)localObject2, "from=androidqq");
      if (i == 0) {
        break label705;
      }
      paramString = HtmlOffline.a((String)localObject2, "sid=" + str2);
    }
    label668:
    label705:
    for (;;)
    {
      localIntent.putExtra("param_force_internal_browser", true);
      if (bool) {
        paramString = HtmlOffline.a((String)localObject2, "platformId=qq_m");
      }
      paramString = paramString.trim();
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("uin", localStructMsgForGeneralShare.currentAccountUin);
      localIntent.putExtra("friendUin", localStructMsgForGeneralShare.uin);
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", l);
      if (paramString.startsWith("https://browserApp.p.qq.com/"))
      {
        localIntent.setClass(localContext, PublicAccountBrowser.class);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", localStructMsgForGeneralShare.uin);
        ((Bundle)localObject2).putInt("uin_type", localStructingMsgViewHolder.a.a);
        ((Bundle)localObject2).putString("uin_name", localStructingMsgViewHolder.a.d);
        ((Bundle)localObject2).putString("openid", null);
        ((Bundle)localObject2).putString("token", null);
        localIntent.putExtras((Bundle)localObject2);
      }
      if (localStructMsgForGeneralShare.mSourceAppid == 1101244924L)
      {
        localIntent.putExtra("BUDNLE_KEY_IS_MY_PROFILE", paramString.contains("gene/index.html?uin=" + localStructMsgForGeneralShare.currentAccountUin));
        localIntent.setClass(localContext, MusicGeneQQBrowserActivity.class);
      }
      PublicAccountUtil.a(localIntent, paramString);
      localIntent.putExtra("fromAio", true);
      localContext.startActivity(localIntent);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString, "", "", "");
      if (bool)
      {
        StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject1, str1, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localStructMsgForGeneralShare.mSourceAppid), null, null, null);
        break;
        i = 0;
        break label260;
        i = 0;
        break label270;
      }
      StatisticCollector.a(BaseApplication.getContext()).a((AppRuntime)localObject1, "sha_click", 1, "", "", String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
      break;
    }
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {}
    paramString3 = (ChatActivity)this.jdField_a_of_type_AndroidContentContext;
    int i = paramString3.a().a();
    paramString2 = paramString3.a().b();
    paramString3 = paramString3.a().a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString3);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("video_play_url", paramString1);
    localIntent.putExtra("video_play_msg", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uniseq);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "GeneralClickHandler clickPluginMsg actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString1 = JumpParser.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (paramString1 == null) {
        break;
      }
      paramString1.b();
      return true;
      paramString1 = paramString2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "GeneralShareMsg _ACTION_PLUGIN_ mContentOnClickListener: JumpAction is null.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler
 * JD-Core Version:    0.7.0.1
 */