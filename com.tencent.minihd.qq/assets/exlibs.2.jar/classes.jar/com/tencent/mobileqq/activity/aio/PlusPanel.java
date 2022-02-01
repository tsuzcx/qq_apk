package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.EnterConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.secmsg.SecMsgHelper;
import fph;
import fpi;
import fpj;
import fpl;
import fpn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;
import org.json.JSONException;
import org.json.JSONObject;

public class PlusPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final String a = "200002";
  private static final int[] l = { 2131369198, 2130838014 };
  private static final int[] m = { 2131369312, 2130839021 };
  private static final int[] n = { 2131364043, 2130839458 };
  private static final int[] o = { 2131364044, 2130839458 };
  private static final int[] p = { 2131365058, 2130838018 };
  private static final int[] q = { 2131369963, 2130838015 };
  private long jdField_a_of_type_Long = -1L;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public PanelAdapter a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131366474, 2130838012 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_secretfile", "chat_tool_audio", "chat_tool_gaudio", "chat_tool_qlink_file", "chat_tool_hongbao" };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.b };
  private final int[] b = { 2131366475, 2130838002 };
  private final int[] c = { 2131369237, 2130838019 };
  private final int[] d = { 2131362068, 2130838021 };
  private final int[] e = { 2131362314, 2130838020 };
  private final int[] f = { 2131366480, 2130838001 };
  private final int[] g = { 2131366070, 2130838016 };
  private final int[] h = { 2131366071, 2130838013 };
  private final int[] i = { 2131366072, 2130838016 };
  private final int[] j = { 2131366204, 2130838011 };
  private final int[] k = { 2131366073, 2130838017 };
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    for (;;)
    {
      return;
      if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        String str = "";
        switch (paramInt)
        {
        }
        while (!str.equals(""))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
          return;
          str = "0";
          continue;
          str = "1";
          continue;
          str = "2";
          continue;
          str = "3";
          continue;
          str = "4";
          continue;
          str = "5";
          continue;
          str = "6";
          continue;
          str = "8";
          continue;
          str = "9";
        }
      }
    }
  }
  
  private void c()
  {
    ThridAppShareHelper.a().b();
    if (ThridAppShareHelper.a().a("200002")) {}
  }
  
  private void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), null);
    localActionSheet.a(2131364019, 5);
    boolean bool = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (bool) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131364018);; str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131364017))
    {
      localActionSheet.a(str, 5);
      localActionSheet.a(new fpn(this, bool, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      return;
    }
  }
  
  public void a()
  {
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_hongbao.name(), "0"));
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "reload(): showHongBao=" + bool);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(this.jdField_a_of_type_Array2dOfInt));
    if (i1 == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
      if (bool) {}
      c();
    }
    Object localObject1;
    Object localObject2;
    PlusPanel.PluginData localPluginData;
    for (;;)
    {
      localObject1 = new ArrayList();
      i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label1392;
        }
        localObject2 = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localPluginData = new PlusPanel.PluginData();
        localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getDrawable(localObject2[1]);
        localPluginData.jdField_a_of_type_Int = localObject2[1];
        localPluginData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(localObject2[0]);
        GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if (localGameCenterManagerImp != null)
        {
          if (localGameCenterManagerImp.a("999999.100004") == -1) {
            break;
          }
          bool = true;
        }
        label235:
        localPluginData.jdField_a_of_type_Boolean = false;
        if (localObject2 != this.c) {
          break label1296;
        }
        localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131362937);
        label271:
        if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if (localObject2 != this.jdField_a_of_type_ArrayOfInt) {
            break label1359;
          }
          localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131364046);
        }
        label317:
        ((ArrayList)localObject1).add(localPluginData);
        i1 += 1;
      }
      if (i1 == 1)
      {
        localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
        if (((localObject1 == null) || (!((FriendManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && ((localObject2 == null) || (!((HotChatManager)localObject2).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
          if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(o);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
            if (bool) {
              this.jdField_a_of_type_JavaUtilArrayList.add(n);
            }
            for (;;)
            {
              c();
              break;
              this.jdField_a_of_type_JavaUtilArrayList.add(n);
            }
          }
        }
      }
      else
      {
        if ((i1 != 0) && (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label889;
        }
        if ((1024 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
    if (EnterConfigManager.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a("qqwallet", "transfer", 0) == 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(p);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
    }
    for (i1 = 1;; i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
      if (i1 != 0) {}
      this.jdField_a_of_type_JavaUtilArrayList.add(this.k);
      if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.h);
        this.jdField_a_of_type_JavaUtilArrayList.remove(p);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(p);
      }
      for (;;)
      {
        c();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        localObject1 = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if ((localObject1 == null) || (!((SecMsgManager)localObject1).c())) {
          break;
        }
        break;
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.h);
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.c);
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.g);
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.k);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        }
      }
      label889:
      if (i1 == 7100) {
        break;
      }
      if ((i1 == 1000) || (i1 == 1004) || (i1 == 1006))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i1 == 1020) {
        break;
      }
      if ((i1 == 1009) || (i1 == 1008) || (i1 == 1023) || (i1 == 1024))
      {
        if (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        break;
      }
      if ((i1 == 1005) || (i1 == 1003)) {
        break;
      }
      if (i1 == 1001)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i1 == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i1 == 1021)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i1 == 1022) {
        break;
      }
      if (i1 == 6000)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        break;
      }
      if (i1 == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i1 != 9501) {
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.e);
      break;
      bool = false;
      break label235;
      label1296:
      if (localObject2 == this.f)
      {
        localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131362880);
        break label271;
      }
      if (localObject2 == this.k)
      {
        localPluginData.b = "抖一抖按钮";
        break label271;
      }
      localPluginData.b = "";
      break label271;
      label1359:
      if (localObject2 != this.b) {
        break label317;
      }
      localPluginData.b = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131364045);
      break label317;
      label1392:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a((ArrayList)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() > 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount(), false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
        post(new fph(this));
        return;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131296724));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131296725));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    paramBaseChatPie = getResources().getDrawable(2130841714);
    if (paramBaseChatPie != null) {
      setBackgroundDrawable(paramBaseChatPie);
    }
    for (;;)
    {
      a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "PlusPanle background is null:");
      }
    }
  }
  
  void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getSharedPreferences("mobileQQ", 0);
    if (paramString.equals("chat_tool_audio")) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
      return;
      if (paramString.equals("chat_tool_gaudio")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else {
        localSharedPreferences.edit().putBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
      }
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void onClick(View paramView)
  {
    int i4 = ((PanelAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_Int;
    paramView = (SplashActivity)SplashActivity.a();
    switch (i4)
    {
    }
    for (;;)
    {
      a(i4);
      int i2;
      int i1;
      label998:
      do
      {
        do
        {
          return;
          if (AudioHelper.b(0))
          {
            ChatActivityUtils.b(getContext());
            break;
          }
          if (AudioHelper.a(0))
          {
            ChatActivityUtils.c(getContext());
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 2, 0, 0);
          }
          if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Y();
          paramView = ScreenShot.a();
          if (paramView != null)
          {
            localObject = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            String[] arrayOfString = getResources().getStringArray(2131230728);
            i2 = arrayOfString.length;
            i1 = 0;
            while (i1 < i2)
            {
              ((ActionSheet)localObject).c(arrayOfString[i1]);
              i1 += 1;
            }
            ((ActionSheet)localObject).e(2131365736);
            ((ActionSheet)localObject).a(new fpi(this, paramView, (ActionSheet)localObject));
            ((ActionSheet)localObject).show();
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
              SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 3, 0, 0);
            }
            if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            break;
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
            {
              paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
                paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            }
          }
          if (paramView.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
          {
            paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.ACCESS_FINE_LOCATION", 500) }).request(new fpj(this, paramView));
            break;
          }
          paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!paramView.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            d();
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
            break;
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
            if (LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              break label998;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131369577));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
            break;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131369577));
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Y();
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, null);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.V();
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004086", "0X8004086", 0, 0, "", "", "", "");
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
          {
            a("chat_tool_gaudio");
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.V();
            b();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            }
            Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            a("chat_tool_gaudio");
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.V();
            b();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            }
            Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
            if (LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              break label1471;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131369576));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
            break;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131369576));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
            break;
          }
          a("chat_tool_audio");
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.V();
          b();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {}
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407B", "0X800407B", 0, 0, "", "", "", "");
            break;
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null);
          }
          if (Environment.getExternalStorageState().equals("mounted"))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
              PlusPanelUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
            while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              break;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
              paramView = new FileManagerReporter.fileAssistantReportData();
              paramView.b = "send_file";
              paramView.jdField_a_of_type_Int = 1;
              FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
              PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2131366138, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getDimensionPixelSize(2131492923));
          break;
          a("chat_tool_qlink_file");
          b();
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407D", "0X800407D", 0, 0, "", "", "", "");
          break;
          i1 = 1;
          if (this.jdField_a_of_type_Long == -1L)
          {
            if (i1 == 0) {
              break label1955;
            }
            ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004081", "0X8004081", 0, 0, "", "", "", "");
            break;
            if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 10000L) {
              break label1873;
            }
            i1 = 0;
            break label1873;
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "歇一会再发送窗口抖动吧", 0).a();
          }
          a("chat_tool_remind");
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          b();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004080", "0X8004080", 0, 0, "", "", "", "");
          break;
          PlusPanelUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004083", "0X8004083", 0, 0, "", "", "", "");
          break;
          ThridAppShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "200002", "https://m.dianping.com/qq/aiodwonload", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          ThridAppShareHelper.a("200002", "click_app", "", "", "");
          break;
          paramView = new Bundle();
          paramView.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putBoolean("hide_operation_bar", true);
          paramView.putBoolean("hide_more_button", true);
          paramView.putBoolean("isScreenOrientationPortrait", true);
          TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView);
          break;
          if (paramView.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
          {
            paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.ACCESS_FINE_LOCATION", 500) }).request(new fpl(this, paramView));
            break;
          }
          paramView = new Bundle();
          paramView.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putBoolean("hide_operation_bar", true);
          paramView.putBoolean("hide_more_button", true);
          paramView.putBoolean("isScreenOrientationPortrait", true);
          TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView);
          break;
          if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label2464;
          }
          a("chat_tool_anonymous");
          b();
        } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie));
        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(2, "");
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
        break;
      } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie));
      label1471:
      label1873:
      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).f(false);
      label1955:
      ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
      label2464:
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TransactionActivity.class);
      paramView.putExtra("come_from", 2);
      paramView.putExtra("display_like_dialog", true);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("targetUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject).put("targetNickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        ((JSONObject)localObject).put("sign", "");
        paramView.putExtra("extra_data", ((JSONObject)localObject).toString());
        paramView.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
      DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
      {
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 4, 0, 0);
        continue;
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), LiteVideoActivity.class);
        paramView.putExtra("maxCount", 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivityForResult(paramView, 81);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
        {
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_SendMsg", 5, 0, 0);
          continue;
          a("chat_tool_hongbao");
          b();
          int i3 = 0;
          i1 = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
          {
            i1 = 1;
            i2 = i3;
          }
          for (;;)
          {
            paramView = new JSONObject();
            try
            {
              paramView.put("recv_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              paramView.put("recv_nick", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              if (i2 > 0) {
                paramView.put("people_num", i2);
              }
              paramView.put("recv_type", i1);
            }
            catch (JSONException localJSONException1)
            {
              for (;;)
              {
                localJSONException1.printStackTrace();
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("PlusPanel", 2, "click HongBao:params=" + paramView.toString());
            }
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), SendHbActivity.class);
            ((Intent)localObject).putExtra("display_like_dialog", true);
            ((Intent)localObject).putExtra("come_from", 2);
            ((Intent)localObject).putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#aio");
            ((Intent)localObject).putExtra("extra_data", paramView.toString());
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject);
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
            {
              i2 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              i1 = 2;
            }
            else
            {
              i2 = i3;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
              {
                i1 = 3;
                i2 = i3;
              }
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
          {
            paramView = new Intent();
            paramView.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramView.putExtra("nickName", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
            SecMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AnonyMsg", "clk_aio_creat", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */