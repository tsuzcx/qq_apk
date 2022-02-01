package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopProxyActivity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import koj;
import kok;
import kom;

public class TroopFeedViewFactory
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  long a;
  public Context a;
  public Drawable a;
  public SessionInfo a;
  public QQAppInterface a;
  public TroopFeedsDataManager a;
  protected HashMap a;
  public koj a;
  public boolean a;
  public Drawable b;
  public boolean b;
  int c;
  public Drawable c;
  
  public TroopFeedViewFactory(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopFeedsDataManager paramTroopFeedsDataManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Koj = new koj(this, null);
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 1000;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramTroopFeedsDataManager;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    int i = a(paramTroopFeedItem.type);
    TroopFeedViewFactory.ViewProvider localViewProvider2 = (TroopFeedViewFactory.ViewProvider)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    TroopFeedViewFactory.ViewProvider localViewProvider1 = localViewProvider2;
    if (localViewProvider2 == null)
    {
      localViewProvider1 = a(i);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localViewProvider1);
    }
    if (localViewProvider1 != null) {
      return localViewProvider1.a(paramTroopFeedItem, paramInt, paramBoolean);
    }
    return null;
  }
  
  protected TroopFeedViewFactory.ViewProvider a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new kok(this);
    case 0: 
      return new kok(this);
    }
    return new kom(this);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    TroopFeedViewFactory.ViewHolder localViewHolder;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localViewHolder = (TroopFeedViewFactory.ViewHolder)paramView.getTag();
        } while (localViewHolder == null);
        localObject = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
      } while (localObject == null);
      int i = a(((TroopFeedItem)localObject).type);
      localObject = (TroopFeedViewFactory.ViewProvider)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    } while (localObject == null);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
    ((TroopFeedViewFactory.ViewProvider)localObject).a(paramView);
  }
  
  protected void a(TroopFeedItem paramTroopFeedItem)
  {
    if ((paramTroopFeedItem == null) || (!paramTroopFeedItem.isVaild())) {}
    Activity localActivity;
    Intent localIntent;
    TroopFileStatusInfo localTroopFileStatusInfo;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localIntent = new Intent();
      localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), null, paramTroopFeedItem.linkUrl, paramTroopFeedItem.title, Long.parseLong(paramTroopFeedItem.ex_1), Integer.parseInt(paramTroopFeedItem.content));
    } while (localTroopFileStatusInfo == null);
    switch (localTroopFileStatusInfo.b)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localIntent.putExtra(TroopProxyActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      TroopProxyActivity.b(localActivity, localIntent);
      return;
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      new TroopFileItemOperation(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity).a(localTroopFileStatusInfo, paramTroopFeedItem.shareFromUin, paramTroopFeedItem.shareExpire);
      return;
    }
    TroopFileError.a(localActivity, String.format(localActivity.getString(2131363383), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.e) }));
  }
  
  void a(TroopFeedItem paramTroopFeedItem, int paramInt)
  {
    if (paramTroopFeedItem == null) {
      return;
    }
    int i = paramTroopFeedItem.type;
    if (paramInt == 0) {}
    for (String str = "0";; str = "1") {
      switch (i)
      {
      default: 
        return;
      case 0: 
      case 131: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
        return;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_bulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_vote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_other", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramTroopFeedItem.ex_1, "");
  }
  
  protected void b(TroopFeedItem paramTroopFeedItem)
  {
    if ((paramTroopFeedItem == null) || (!paramTroopFeedItem.isVaild())) {
      return;
    }
    Object localObject = paramTroopFeedItem.linkUrl.trim();
    boolean bool = ((String)localObject).startsWith("https://gamecenter.qq.com");
    int i;
    label62:
    Intent localIntent;
    String str;
    if ((((String)localObject).startsWith("https://m.qzone.com")) || (((String)localObject).startsWith("https://mobile.qzone.qq.com")))
    {
      i = 1;
      if ((!bool) && (i == 0)) {
        break label400;
      }
      i = 1;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
      str = HtmlOffline.a((String)localObject, "from=androidqq");
      if (i == 0) {
        break label405;
      }
      str = HtmlOffline.a((String)localObject, "sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    }
    label400:
    label405:
    for (;;)
    {
      localIntent.putExtra("param_force_internal_browser", true);
      if (bool) {
        str = HtmlOffline.a((String)localObject, "platformId=qq_m");
      }
      str = str.trim();
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", str);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (str.startsWith("https://browserApp.p.qq.com/"))
      {
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
        localObject = new Bundle();
        ((Bundle)localObject).putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((Bundle)localObject).putString("uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        localIntent.putExtras((Bundle)localObject);
      }
      if (paramTroopFeedItem.type == 132)
      {
        localIntent.putExtra("BUDNLE_KEY_IS_MY_PROFILE", str.contains("gene/index.html?uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, MusicGeneQQBrowserActivity.class);
      }
      PublicAccountUtil.a(localIntent, str);
      localIntent.putExtra("fromAio", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      i = 0;
      break;
      i = 0;
      break label62;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    do
    {
      do
      {
        return;
      } while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      paramView = paramView.getTag();
    } while (!(paramView instanceof TroopFeedViewFactory.ViewHolder));
    Object localObject = (TroopFeedViewFactory.ViewHolder)paramView;
    paramView = ((TroopFeedViewFactory.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
    a(paramView, ((TroopFeedViewFactory.ViewHolder)localObject).jdField_a_of_type_Int);
    if (paramView.orginType == 99)
    {
      b(paramView);
      return;
    }
    switch (paramView.type)
    {
    default: 
      b(paramView);
      return;
    case 18: 
      paramView = paramView.linkUrl.trim();
      localObject = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((QZoneHelper.UserInfo)localObject).b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      ((QZoneHelper.UserInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, (QZoneHelper.UserInfo)localObject, paramView, "mqqChat.QzoneCard", -1);
      return;
    case 0: 
    case 131: 
      a(paramView);
      return;
    }
    localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if ((localObject != null) && (((TroopInfoManager)localObject).b(paramView.linkUrl)) && (((TroopInfoManager)localObject).b()))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      ((Intent)localObject).putExtra("video_play_url", paramView.linkUrl);
      ((Intent)localObject).putExtra("video_play_feed", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory
 * JD-Core Version:    0.7.0.1
 */