import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class jwi
  implements Runnable
{
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new jwj(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  
  public jwi(MainAcitivityReportHelper paramMainAcitivityReportHelper) {}
  
  private void a()
  {
    SplashActivity localSplashActivity = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSplashActivity == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = localSplashActivity.app;
    } while (localQQAppInterface == null);
    String str = localQQAppInterface.a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(localSplashActivity);
    Object localObject = (EmoticonManager)localQQAppInterface.getManager(13);
    if (localObject != null)
    {
      localObject = ((EmoticonManager)localObject).b();
      if (localObject == null) {}
    }
    for (int i = ((List)localObject).size();; i = 0)
    {
      localObject = new HashMap();
      ((Map)localObject).put("Ep_amount", Integer.valueOf(i));
      localStatisticCollector.b(localQQAppInterface, str, (Map)localObject);
      i = 0;
      while (i < 3)
      {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "ep_tab2", 0, StatisticAssist.a(localSplashActivity, str, "ep_tab2" + i), 0, i);
        i += 1;
      }
      i = StatisticAssist.a(localSplashActivity, str, "Ep_manage");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Ep_manage", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Clk_ep_edit");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Clk_ep_edit", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Delete_ep");
      if (i > 0) {
        localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Delete_ep", 0, i, 0);
      }
      i = StatisticAssist.a(localSplashActivity, str, "Ep_order");
      if (i <= 0) {
        break;
      }
      localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "Ep_order", 0, i, 0);
      return;
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SplashActivity)localObject).app;
    } while (localObject == null);
    int i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_op4dongtai");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clk_data_wire_in", 8, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_op4buddylist");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clk_data_wire_in", 21, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_op4recent");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clk_data_wire_in", 22, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_ckpic");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_pic", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_ckvideo");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_video", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_ckfile");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_file", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_cktxt");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_text", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_cktkphoto");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Upload_photo", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_copy");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_copy", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_forward");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_retran", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_delete");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_delete", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_save2weiyun");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Long_press_weiyun", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_ckadv");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "data_wire_setting", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_ckviewrecvfile");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Chkfiles_data_wire", 0, i, 0);
    }
    i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_ckclearmsg");
    if (i > 0) {
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Clean_data_wire", 0, i, 0);
    }
    boolean bool = ((QQAppInterface)localObject).getPreferences().getBoolean("auto_receive_files", false);
    StatisticCollector localStatisticCollector = StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper));
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    if (bool) {}
    for (i = 1;; i = 0)
    {
      localHashMap.put("auto_receive_files", Integer.valueOf(i));
      localStatisticCollector.b((AppRuntime)localObject, paramString, localHashMap);
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_forwardin_text");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_text", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_forwardin_image");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_pic", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_forwardin_file");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_file", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_forwardin_link");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Retran_link", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_open_via_qq");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "Open_via_qq", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_share_my_pc");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "share_my_PC", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "dl_share_frd");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "data_wire", "share_frd", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "Clk_disconnect_wp");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "Wifiphoto", "Clk_disconnect_wp", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "Clk_wp_back");
      if (i > 0) {
        StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "Wifiphoto", "Clk_wp_back", 0, i, 0);
      }
      i = StatisticAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), paramString, "Open_wp");
      if (i <= 0) {
        break;
      }
      StatisticCollector.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper)).a((AppRuntime)localObject, paramString, paramString, "Wifiphoto", "Open_wp", 0, i, 0);
      return;
    }
  }
  
  private void b()
  {
    Object localObject1 = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {}
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject1 = ((SplashActivity)localObject1).app;
      } while (localObject1 == null);
      localObject2 = ((QQAppInterface)localObject1).a();
      localObject3 = (FriendsManagerImp)((QQAppInterface)localObject1).getManager(8);
    } while (localObject3 == null);
    Object localObject2 = ((FriendsManagerImp)localObject3).a((String)localObject2);
    if (localObject2 != null) {}
    for (long l = ((ExtensionInfo)localObject2).pendantId;; l = 0L)
    {
      localObject2 = new File(AvatarPendantUtil.a(l, 4));
      if (!((File)localObject2).exists())
      {
        localObject1 = (DownloaderFactory)((QQAppInterface)localObject1).getManager(46);
        String str = AvatarPendantUtil.b(l, 4);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putLong("id", l);
        localObject2 = new DownloadTask(str, (File)localObject2);
        ((DownloaderFactory)localObject1).a(1).a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject3);
        return;
      }
      ReportController.b((QQAppInterface)localObject1, "CliStatus", "", "", "AvatarPendant", "AvatarPendantOn", 0, 0, String.valueOf(l), AvatarPendantUtil.a((File)localObject2), "", "");
      return;
    }
  }
  
  private void c()
  {
    Object localObject1 = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ((SplashActivity)localObject1).app;
    } while (localQQAppInterface == null);
    List localList = ((EmoticonManager)localQQAppInterface.getManager(13)).b();
    localObject1 = "";
    Object localObject2 = localObject1;
    int i;
    if (localList != null)
    {
      i = 0;
      localObject2 = localObject1;
      if (i < localList.size())
      {
        localObject2 = (EmoticonPackage)localList.get(i);
        if (3 != ((EmoticonPackage)localObject2).jobType) {
          break label188;
        }
        if (!"100000".equals(((EmoticonPackage)localObject2).epId)) {}
      }
    }
    label188:
    for (;;)
    {
      i += 1;
      break;
      if (((String)localObject1).equals(""))
      {
        localObject1 = ((EmoticonPackage)localObject2).epId;
      }
      else
      {
        localObject1 = (String)localObject1 + "|" + ((EmoticonPackage)localObject2).epId;
        continue;
        ReportController.b(localQQAppInterface, "CliStatus", "", "", "MbBaoyou", "MbBaoyouID", 0, 0, (String)localObject2, "", "", "");
        return;
      }
    }
  }
  
  private void d()
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ((SplashActivity)localObject).app;
    } while (localQQAppInterface == null);
    localObject = "0X8004E0F";
    String str1 = "0X8004E0F";
    String str2 = ((ChatBackgroundManager)localQQAppInterface.getManager(61)).c(null);
    if (str2.equals("custom"))
    {
      localObject = "0X8004E10";
      str1 = "0X8004E10";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", (String)localObject, str1, 0, 0, "", str2, "", "");
  }
  
  private void e()
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SplashActivity)localObject).app;
    } while (localObject == null);
    String str = ThemeUtil.getUserCurrentThemeId((AppInterface)localObject);
    SVIPHandler localSVIPHandler = (SVIPHandler)((QQAppInterface)localObject).a(12);
    ReportController.b((QQAppInterface)localObject, "CliStatus", "", "", "0X800498F", "0X800498F", 0, 0, str, "", "", localSVIPHandler.f() + "");
  }
  
  private void f()
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SplashActivity)localObject).app;
    } while (localObject == null);
    SVIPHandler localSVIPHandler = (SVIPHandler)((QQAppInterface)localObject).a(12);
    int i = localSVIPHandler.e();
    ReportController.b((QQAppInterface)localObject, "CliStatus", "", "", "0X8004990", "0X8004990", 0, 0, i + "", "", "", localSVIPHandler.f() + "");
  }
  
  private void g()
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SplashActivity)localObject).app;
    } while (localObject == null);
    boolean bool1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
    boolean bool2 = ((QQAppInterface)localObject).a().getSharedPreferences("font_open_switch", 0).getBoolean("isUserOpenFontSwitch_" + ((QQAppInterface)localObject).getAccount(), false);
    int i;
    if (bool1) {
      i = 2;
    }
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject, "CliStatus", "", "", "font_switch", "switch_on", 0, 0, i + "", "", "", "");
      return;
      if (FontManager.b) {
        i = 3;
      } else if (bool2) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private void h()
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ((SplashActivity)localObject).app;
    } while (localQQAppInterface == null);
    localObject = ((SplashActivity)localObject).getSharedPreferences("sp_personal_dressup_preload_" + localQQAppInterface.a(), 0);
    int i = ((SharedPreferences)localObject).getInt("key_count_preload", 0);
    int j = ((SharedPreferences)localObject).getInt("key_count_enter_sub_item", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("key_count_preload", 0);
    ((SharedPreferences.Editor)localObject).putInt("key_count_enter_sub_item", 0);
    ((SharedPreferences.Editor)localObject).commit();
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "PersonalDressup", "preload", 0, 0, String.valueOf(i), String.valueOf(j), "", "");
  }
  
  private void i()
  {
    Object localObject = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    QQAppInterface localQQAppInterface;
    EntityManager localEntityManager;
    do
    {
      do
      {
        return;
        localQQAppInterface = ((SplashActivity)localObject).app;
      } while (localQQAppInterface == null);
      localEntityManager = localQQAppInterface.a().createEntityManager();
    } while (localEntityManager == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { localQQAppInterface.a() });
    if (localNearbyPeopleCard != null)
    {
      if (!localNearbyPeopleCard.switchHobby) {
        break label152;
      }
      localObject = "1";
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A12", "0X8004A12", 0, 0, (String)localObject, "", "", "");
      if (!localNearbyPeopleCard.switchQzone) {
        break label159;
      }
    }
    label152:
    label159:
    for (localObject = "1";; localObject = "0")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A13", "0X8004A13", 0, 0, (String)localObject, "", "", "");
      localEntityManager.a();
      return;
      localObject = "0";
      break;
    }
  }
  
  public void run()
  {
    Object localObject1 = (SplashActivity)this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ((SplashActivity)localObject1).app;
    } while (localQQAppInterface == null);
    SharedPreferences localSharedPreferences = ((SplashActivity)localObject1).getSharedPreferences("mobileQQ", 0);
    long l2 = localSharedPreferences.getLong("LastTimeLogin_" + localQQAppInterface.a(), 0L);
    long l3 = System.currentTimeMillis() - 10L;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(l2);
    localCalendar2.add(5, 1);
    localCalendar2.clear(10);
    localCalendar2.clear(12);
    localCalendar2.clear(13);
    localCalendar2.clear(14);
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).add(5, 1);
    ((Calendar)localObject1).clear(10);
    ((Calendar)localObject1).clear(12);
    ((Calendar)localObject1).clear(13);
    ((Calendar)localObject1).clear(14);
    long l1 = ((Calendar)localObject1).getTimeInMillis() - l3 - 100L;
    if (l1 < 0L) {
      l1 = 86400000L;
    }
    for (;;)
    {
      int i;
      Activity localActivity;
      String str;
      StatisticCollector localStatisticCollector;
      if ((l2 > 0L) && (localCalendar1.after(localCalendar2)))
      {
        QQSettingUtil.a(localQQAppInterface);
        NotifyPushSettingActivity.a(localQQAppInterface, localQQAppInterface.a());
        StatisticCollector.a(BaseApplication.getContext()).b(localQQAppInterface, localQQAppInterface.a());
        i();
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "friend", Contacts.c);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "troop", Contacts.b);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "discussion", Contacts.d);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "search", Contacts.a);
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "plugin_manage", Leba.f);
        if (DiscussionInfoCardActivity.c > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "share_discuss", 0, DiscussionInfoCardActivity.c, 0);
        }
        if (DiscussionInfoCardActivity.d > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "copy_link", 0, DiscussionInfoCardActivity.d, 0);
        }
        if (DiscussionInfoCardActivity.e > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "share_linkman", 0, DiscussionInfoCardActivity.e, 0);
        }
        if (MttBrowerWrapper.a > 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "", "discuss", "click_link", 0, MttBrowerWrapper.a, 0);
        }
        localObject1 = new HashMap();
        i = localSharedPreferences.getInt("online_friend_enter_count_" + localQQAppInterface.a(), 0);
        if (i > 0) {
          ((HashMap)localObject1).put("Click_online", Integer.valueOf(i));
        }
        if (AssistantSettingActivity.a > 0) {
          ((HashMap)localObject1).put("Cleancache_pic", Integer.valueOf(AssistantSettingActivity.a));
        }
        i = StatisticTroopAssist.a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject1).put("Click_grp_asst", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.b(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject1).put("grp_setting_asst", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.c(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject1).put("grp_setting_msg", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.d(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject1).put("grp_msg_equ", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.e(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject1).put("grp_msg_dec", Integer.valueOf(i));
        }
        i = StatisticTroopAssist.f(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
        if (i > 0) {
          ((HashMap)localObject1).put("grp_msg_inc", Integer.valueOf(i));
        }
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), (Map)localObject1);
        StatisticTroopAssist.h(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
        FileManagerUtil.a(localQQAppInterface, MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper));
        a(localQQAppInterface.a());
        localActivity = MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper);
        str = localQQAppInterface.a();
        localStatisticCollector = StatisticCollector.a(localActivity);
        i = StatisticAssist.a(localActivity, str, "ep_tab");
        if (i > 0) {
          localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "ep_tab", 1, i, 0);
        }
        i = StatisticAssist.a(localActivity, str, "ep_mall_in2");
        if (i > 0) {
          localStatisticCollector.a(localQQAppInterface, str, "", "ep_mall", "ep_mall_in", 2, i, 0);
        }
      }
      for (;;)
      {
        try
        {
          a();
          b();
          c();
          d();
          e();
          f();
          g();
          h();
          localObject1 = (FriendsManagerImp)localQQAppInterface.getManager(8);
          if (localObject1 == null) {
            break label2525;
          }
          localObject1 = ((FriendsManagerImp)localObject1).a(str);
          if (localObject1 != null) {
            ReportController.b(localQQAppInterface, "CliStatus", "", "", "FontStatus", "FontOn", 0, 0, String.valueOf(((ExtensionInfo)localObject1).uVipFont), "", "", "");
          }
          if (localObject1 != null)
          {
            j = ((SVIPHandler)localQQAppInterface.a(12)).f();
            if (j == 2)
            {
              i = 0;
              ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A26", "0X8004A26", 0, 0, "" + i, "" + ((ExtensionInfo)localObject1).colorRingId, "", "");
            }
          }
          else if (localObject1 != null)
          {
            i = ((SVIPHandler)localQQAppInterface.a(12)).f();
            ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8005005", "0X8005005", 0, 0, "" + i, "" + ((ExtensionInfo)localObject1).commingRingId, "", "");
          }
        }
        catch (Exception localException)
        {
          try
          {
            SecMsgManager.a(localQQAppInterface);
            localObject1 = StatisticAssist.a(localQQAppInterface);
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject3 = (MessageReportData)((Iterator)localObject1).next();
                if (((MessageReportData)localObject3).msgCount <= 0) {
                  continue;
                }
                localStatisticCollector.c(localQQAppInterface, ((MessageReportData)localObject3).getMsgReport());
                continue;
                localException = localException;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("MainAcitivityReportHelper", 2, "reportAioEmotionData", localException);
                continue;
                i = j;
                if (j != 3) {
                  continue;
                }
                i = 2;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            Object localObject3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("StatisticCollector", 2, "secmsg report fail err:" + localThrowable.getMessage());
            continue;
            i = localQQAppInterface.a().a(-2002);
            int j = localQQAppInterface.a().c();
            if (j > 0)
            {
              localObject2 = new BigDecimal(i * 100.0D / j).setScale(0, 4);
              localObject3 = new HashMap();
              ((HashMap)localObject3).put("pttPercent", Integer.toString(((BigDecimal)localObject2).intValue()));
              ((HashMap)localObject3).put("pttMsgNum", Integer.toString(i));
              ((HashMap)localObject3).put("totalMsgNum", Integer.toString(j));
              StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttMsg", true, 0L, 0L, (HashMap)localObject3, null);
              if (QLog.isColorLevel()) {
                QLog.d("SendMessageStatistic", 2, "pttMsgNum=" + i + ",totalMsgNum=" + j + ",pttPercent=" + localObject2);
              }
              localQQAppInterface.a().h();
            }
            j = localQQAppInterface.a().c("recv_msg_back_group");
            int k = localQQAppInterface.a().c("recv_msg_back_public");
            int m = localQQAppInterface.a().c("recv_msg_notify");
            i = localQQAppInterface.a().c("pull_num_group_msg");
            int n = localQQAppInterface.a().c("recv_msg_back_notify_group");
            int i1 = localQQAppInterface.a().c("recv_msg_fore_notify_group");
            int i2 = localQQAppInterface.a().c("recv_msg_fore_num_group");
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actBackNumGroupMsg", true, j, 0L, null, null);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actBackPublicMsg", true, k, 0L, null, null);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actNotifyMsg", true, m, 0L, null, null);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actPullNumGroupMsg", true, i, 0L, null, null);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actBackGroupMsg", true, n, 0L, null, null);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actForeGroupMsg", true, i1, 0L, null, null);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actForeNumGroupMsg", true, i2, 0L, null, null);
            i = 0;
            if (j + k + m > 0)
            {
              i = (k + j) * 100 / (j + k + m);
              StatisticCollector.a(BaseApplication.getContext()).a(null, "RecvSilentMsgPercent", true, i, 0L, null, null);
            }
            if (QLog.isColorLevel()) {
              QLog.d("RecvMessageStatistic", 2, "backNumGroup=" + j + ",backPub=" + k + ",notifyMsg=" + m + ",RecvSilentMsgPercent=" + i + ",backGroup=" + n + ",foreGroup=" + i1 + ",foreNumGroup=" + i2);
            }
            localQQAppInterface.a().i();
            i = MainAcitivityReportHelper.a(localActivity, str);
            if (i > 0) {
              StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "Menu_Quit", i);
            }
            i = QQSettingUtil.a(localActivity, str);
            if (i > 0) {
              StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "Setting_Quit", i);
            }
            i = StatisticAssist.a(localActivity, str, "public_account_search_list_click");
            if (i > 0) {
              localStatisticCollector.a(localQQAppInterface, str, "", "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot", 1, i, 0);
            }
            i = NotifyPushSettingActivity.b(localActivity, str, "LED_light");
            localObject2 = new HashMap();
            ((HashMap)localObject2).clear();
            ((HashMap)localObject2).put("LED_light", Integer.valueOf(i));
            localStatisticCollector.b(localQQAppInterface, str, (Map)localObject2);
            if (!BadgeUtils.a()) {
              break label2116;
            }
          }
        }
        if (SettingCloneUtil.readValue(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), null, null, "qqsetting_show_badgeunread_key", true))
        {
          localObject2 = "1";
          ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004BE8", "0X8004BE8", 0, 0, (String)localObject2, "", "", "");
          label2116:
          PicReporter.a();
          i = ThemeUtil.getThemeSwitchTimes(localQQAppInterface);
          if (i > 0) {
            localStatisticCollector.a(localQQAppInterface, str, "", "theme_mall", "theme_replace", 0, i, 0);
          }
          i = ((ChatBackgroundManager)localQQAppInterface.getManager(61)).a(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a());
          if (i > 0) {
            localStatisticCollector.a(localQQAppInterface, str, "", "background", "bkground_replace", 0, i, 0);
          }
          if (!Boolean.valueOf(SettingCloneUtil.readValue(MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper), localQQAppInterface.a(), MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper).getString(2131367906), "qqsetting_lock_screen_whenexit_key", true)).booleanValue()) {
            break label2517;
          }
        }
        label2517:
        for (Object localObject2 = "1";; localObject2 = "0")
        {
          ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject2, "", "", "");
          MainAcitivityReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper, localStatisticCollector);
          MainAcitivityReportHelper.b(this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper, localStatisticCollector);
          this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.a();
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, "**************report data below:*****************");
          }
          this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.b(localQQAppInterface.getAccount());
          localSharedPreferences.edit().putLong("LastTimeLogin_" + localQQAppInterface.a(), l3).commit();
          if (localCalendar1.after(localCalendar2))
          {
            ThemeUiPlugin.reportThemeNumAndCurrThemeName(localQQAppInterface, localQQAppInterface.a());
            ((ChatBackgroundManager)localQQAppInterface.getManager(61)).a(localQQAppInterface, localQQAppInterface.a());
          }
          if (l2 == 0L) {
            localSharedPreferences.edit().putLong("LastTimeLogin_" + localQQAppInterface.a(), l3).commit();
          }
          LebaShowListManager.a().a(localQQAppInterface);
          l2 = (Math.random() * 30.0D * 60.0D * 1000.0D);
          this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.jdField_a_of_type_AndroidOsHandler.postDelayed(this, l2 + l1 + 60000L);
          return;
          localObject2 = "0";
          break;
        }
        label2525:
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwi
 * JD-Core Version:    0.7.0.1
 */