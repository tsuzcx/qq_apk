package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.GameCenterServlet;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class BusinessInfoCheckUpdateItem
  implements CheckUpdateItemInterface
{
  public static final int A = 100017;
  public static final int B = 100014;
  public static final int C = 100015;
  public static final int D = 100100;
  public static final int E = 100120;
  public static final int F = 100400;
  public static final int G = 100012;
  public static final int H = 100200;
  public static final int I = 100450;
  public static final int J = 826;
  public static final int K = 100300;
  public static final int L = 100160;
  public static final int M = 100161;
  public static final int N = 100162;
  public static final int O = 100016;
  public static final int P = 886;
  public static final int Q = 100170;
  public static final int R = 100171;
  public static final int S = 100172;
  public static final int T = 769;
  public static final int U = 905;
  public static final int V = 100180;
  public static final int W = 100190;
  public static final int X = 100191;
  public static final int Y = 100510;
  public static final int Z = 100511;
  public static final int a = 100005;
  public static final String a = "BusinessInfoCheckUpdateItem";
  private static final String[][] jdField_a_of_type_Array2dOfJavaLangString;
  public static final int aa = 100512;
  public static final int ab = 100513;
  public static final int ac = 100514;
  public static final int ad = 100515;
  public static final int b = 100001;
  public static final String b = ".";
  public static final int c = 100002;
  public static final String c = "BusinessInfoCheckUpdateItem_new_1";
  public static final int d = 100003;
  public static final String d = "businessinfo_check_update_interval";
  public static final int e = 100006;
  public static final String e = "businessinfo_last_check_update_timestamp";
  public static final int f = 100011;
  public static final String f = "reader_zone_appinfo_last_pull_timestamp";
  public static final int g = 100018;
  public static final int h = 100019;
  public static final int i = 100020;
  public static final int j = 100021;
  public static final int k = 100022;
  public static final int l = 3;
  public static final int m = 999999;
  public static final int n = 100004;
  public static final int o = 1;
  public static final int p = -1;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 4;
  public static final int v = 100007;
  public static final int w = 100009;
  public static final int x = 100010;
  public static final int y = 100013;
  public static final int z = 100016;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int ah;
  
  static
  {
    String[] arrayOfString1 = { "100005", "100005", "1" };
    String[] arrayOfString2 = { "100005", "100005.100002", "1" };
    String[] arrayOfString3 = { "100005", "100005.100021", "1" };
    String[] arrayOfString4 = { "100005", "100005.100011", "1" };
    String[] arrayOfString5 = { "100005", "100005.100018", "1" };
    String[] arrayOfString6 = { "100005", "100005.100019", "1" };
    String[] arrayOfString7 = { "100007", "100007", "1" };
    String[] arrayOfString8 = { "100007", "100007.100009", "1" };
    String[] arrayOfString9 = { "100007", "100007.100014.100015", "1" };
    String[] arrayOfString10 = { String.valueOf(100100), "100100.100120", String.valueOf(3) };
    String[] arrayOfString11 = { "100400", "100400", "1" };
    String[] arrayOfString12 = { "100005", "100005.100012", "1" };
    String[] arrayOfString13 = { "100300", "100300", "2" };
    String[] arrayOfString14 = { "100160", "100160", "1" };
    String[] arrayOfString15 = { "100160", "100160.100161", "1" };
    String[] arrayOfString16 = { "100016", "100016", "1" };
    String[] arrayOfString17 = { "886", "886", "0" };
    String[] arrayOfString18 = { "886", "886.100170", "0" };
    String[] arrayOfString19 = { "886", "886.100172", "0" };
    String[] arrayOfString20 = { "100180", "100180", "1" };
    String[] arrayOfString21 = { "100190", "100190", "1" };
    String[] arrayOfString22 = { "100190", "100190.100191", "1" };
    String[] arrayOfString23 = { "100510", "100510", "0" };
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { arrayOfString1, { "100005", "100005.100001", "1" }, arrayOfString2, { "100005", "100005.100003", "1" }, { "100005", "100005.100020", "1" }, arrayOfString3, { "100005", "100005.100022", "1" }, { "100005", "100005.100006", "1" }, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, { "100007", "100007.100009.100010", "1" }, { "100007", "100007.100013", "1" }, { "100007", "100007.100016", "1" }, { "100007", "100007.100016.100017", "1" }, { "100007", "100007.100014", "1" }, arrayOfString9, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, { "826", "826", "0" }, { "100200", "100200", "1" }, { "100450", "100450", "1" }, arrayOfString14, arrayOfString15, { "100160", "100160.100162", "1" }, arrayOfString16, arrayOfString17, arrayOfString18, { "886", "886.100171", "0" }, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, { "100511", "100510.100511", "0" }, { "100512", "100510.100512", "0" }, { "100513", "100510.100513", "0" }, { "100514", "100510.100514", "0" }, { "100514", "100510.100515", "0" } };
  }
  
  public BusinessInfoCheckUpdateItem(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.ah = paramInt;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 24 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[2] & 0xFF) << 8 | paramArrayOfByte[3] & 0xFF;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = (RedTouchManager)paramAppInterface.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    paramAppInterface = new File(paramAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface.a());
    if ((paramAppInterface == null) || (!paramAppInterface.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      paramAppInterface = localAppInfo;
      return paramAppInterface;
    }
    if (((RedTouchManager)localObject).a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
      }
      return localAppInfo;
    }
    for (;;)
    {
      int i1;
      try
      {
        paramAppInterface = ((RedTouchManager)localObject).a();
        if (!paramAppInterface.rptMsgAppInfo.has()) {
          return localAppInfo;
        }
        i1 = 0;
        if (i1 >= paramAppInterface.rptMsgAppInfo.size()) {
          return localAppInfo;
        }
        localObject = (BusinessInfoCheckUpdate.AppInfo)paramAppInterface.rptMsgAppInfo.get(i1);
        if (paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get()))
        {
          paramAppInterface = (AppInterface)localObject;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BusinessInfoCheckUpdateItem", 2, "checkNewStatusByID path = " + paramString + ",Flag=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() + ",Type=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).type.get());
          return localObject;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return localAppInfo;
      }
      i1 += 1;
    }
    return localAppInfo;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    int i2 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("BusinessInfoCheckUpdateItem", 2, "setNewStatusByID,path=" + paramString);
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)paramAppInterface.getManager(35);
    if (localRedTouchManager.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i1;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = localRedTouchManager.a();
        if (localTimeRspBody.rptMsgAppInfo.has())
        {
          i1 = 0;
          if (i1 < localTimeRspBody.rptMsgAppInfo.size())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i1);
            if (!paramString.equals(localAppInfo.path.get())) {
              break label232;
            }
            if ((localAppInfo.iNewFlag.get() == 1) && (!paramBoolean)) {
              localAppInfo.modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = localAppInfo.iNewFlag;
            if (!paramBoolean) {
              break label226;
            }
            localPBInt32Field.set(i2);
            localTimeRspBody.rptMsgAppInfo.set(i1, localAppInfo);
            paramAppInterface = (GameCenterManagerImp)paramAppInterface.getManager(11);
            if (paramAppInterface != null) {
              paramAppInterface.a(paramString);
            }
          }
        }
        localRedTouchManager.a(localTimeRspBody);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return;
      }
      label226:
      i2 = 0;
      continue;
      label232:
      i1 += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    if (localObject != null) {
      ((GameCenterManagerImp)localObject).a();
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), GameCenterServlet.class);
    ((NewIntent)localObject).setAction("gc_refresh_ui");
    ((NewIntent)localObject).putExtra("gc_notify_type", 6);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static boolean a(List paramList, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return false;
      if (paramAppInfo.appset.get() == 3) {
        return true;
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i2 = paramList.size();
        i1 = 0;
        while (i1 < i2)
        {
          if ((((ResourcePluginInfo)paramList.get(i1)).uiResId + "").equals(paramAppInfo.path.get())) {
            return true;
          }
          i1 += 1;
        }
      }
      int i1 = 0;
      while (i1 < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        paramList = paramAppInfo.path.get();
        if (jdField_a_of_type_Array2dOfJavaLangString[i1][1].equals(paramList)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static byte[] a(int paramInt)
  {
    int i1 = (byte)(paramInt & 0xFF);
    int i2 = (byte)((0xFF00 & paramInt) >> 8);
    int i3 = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), i3, i2, i1 };
  }
  
  private ReqItem b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessInfoCheckUpdateItem", 2, "getNewFlagOp");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 110;
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("5.9.3.3468");
    localTimeReqBody.uiUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    List localList = ResourcePluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), 64, false);
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    Object localObject3;
    label140:
    int i2;
    if (localRedTouchManager == null)
    {
      localObject3 = null;
      if (localList == null) {
        break label412;
      }
      if (localObject3 != null) {
        break label316;
      }
      i1 = 0;
      localObject1 = null;
      i2 = 0;
    }
    Object localObject2;
    int i3;
    for (;;)
    {
      if (i2 >= localList.size()) {
        break label412;
      }
      localObject2 = new BusinessInfoCheckUpdate.AppInfo();
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.set(((ResourcePluginInfo)localList.get(i2)).uiResId + "");
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.set((int)((ResourcePluginInfo)localList.get(i2)).uiResId);
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).appset.set(0);
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(0);
      localTimeReqBody.rptMsgAppInfo.add((MessageMicro)localObject2);
      int i4 = (int)((ResourcePluginInfo)localList.get(i2)).uiResId;
      i3 = 0;
      label276:
      if (i3 < i1)
      {
        localObject1 = (BusinessInfoCheckUpdate.AppSetting)((List)localObject3).get(i3);
        if (localObject1 == null) {}
        label316:
        while (i4 != ((BusinessInfoCheckUpdate.AppSetting)localObject1).appid.get())
        {
          i3 += 1;
          break label276;
          localObject3 = localRedTouchManager.d();
          break;
          i1 = ((List)localObject3).size();
          break label140;
        }
      }
      if (i3 != i1)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        localObject2 = new BusinessInfoCheckUpdate.AppSetting();
        ((BusinessInfoCheckUpdate.AppSetting)localObject2).appid.set(i4);
        ((BusinessInfoCheckUpdate.AppSetting)localObject2).setting.set(true);
        ((BusinessInfoCheckUpdate.AppSetting)localObject2).modify_ts.set(0L);
      }
      localTimeReqBody.rptSetting.add((MessageMicro)localObject2);
      i2 += 1;
      localObject1 = localObject2;
    }
    label412:
    Object localObject1 = (MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    if ((localObject1 != null) && (((MyBusinessManager)localObject1).a())) {}
    for (int i1 = 1;; i1 = 0)
    {
      i2 = 0;
      if (i2 < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        if ((i1 == 0) && (Integer.parseInt(jdField_a_of_type_Array2dOfJavaLangString[i2][0]) == 100200)) {}
        for (;;)
        {
          i2 += 1;
          break;
          localObject1 = new BusinessInfoCheckUpdate.AppInfo();
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.set(Integer.parseInt(jdField_a_of_type_Array2dOfJavaLangString[i2][0]));
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.set(jdField_a_of_type_Array2dOfJavaLangString[i2][1]);
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).appset.set(Integer.parseInt(jdField_a_of_type_Array2dOfJavaLangString[i2][2]));
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(0);
          localTimeReqBody.rptMsgAppInfo.add((MessageMicro)localObject1);
        }
      }
      localObject1 = localRedTouchManager.a(3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject1).next();
        new BusinessInfoCheckUpdate.AppInfo().path.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
        localTimeReqBody.rptMsgAppInfo.add((MessageMicro)localObject2);
      }
      if (localRedTouchManager.a() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessInfoCheckUpdateItem", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
        }
        if ((!((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a) && (localTimeReqBody.rptMsgAppInfo.has())) {
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 < localTimeReqBody.rptMsgAppInfo.size())
        {
          if ("100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(i1)).path.get())) {
            localTimeReqBody.rptMsgAppInfo.remove(i1);
          }
        }
        else
        {
          localObject1 = localTimeReqBody.toByteArray();
          i1 = localObject1.length;
          i2 = i1 + 4;
          localObject2 = new byte[i2];
          System.arraycopy(a(i2), 0, localObject2, 0, 4);
          System.arraycopy(localObject1, 0, localObject2, 4, i1);
          localReqItem.vecParam = ((byte[])localObject2);
          return localReqItem;
          localObject1 = localRedTouchManager.a();
          if ((!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has()) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has())) {
            break;
          }
          i1 = 0;
          label812:
          if (i1 < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size()) {
            i2 = 0;
          }
          for (;;)
          {
            if (i2 < localTimeReqBody.rptMsgAppInfo.size())
            {
              localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(i1);
              localObject3 = (BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(i2);
              if (((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get()))
              {
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).path.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).modify_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).type.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).push_red_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).mission_level.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).mission_level.get());
                ((BusinessInfoCheckUpdate.AppInfo)localObject3).red_display_info.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info);
                i3 = 0;
                while (i3 < ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.size())
                {
                  ((BusinessInfoCheckUpdate.AppInfo)localObject3).missions.add(((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get(i3));
                  i3 += 1;
                }
                localTimeReqBody.rptMsgAppInfo.set(i2, (MessageMicro)localObject3);
              }
            }
            else
            {
              i1 += 1;
              break label812;
              break;
            }
            i2 += 1;
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void b(RespItem paramRespItem)
  {
    int i2 = 0;
    if (paramRespItem == null) {}
    int i1;
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody;
    for (;;)
    {
      return;
      i1 = paramRespItem.cResult;
      localObject1 = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "handleNewFlagOp,result:" + i1 + ",vecUpdate.length=" + paramRespItem.vecUpdate.length);
      }
      if (2 != i1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessInfoCheckUpdateItem", 2, "handleNewFlagOp,return fail ,RespItem result:" + i1);
        }
      }
      else
      {
        paramRespItem = new byte[localObject1.length - 4];
        PkgTools.a(paramRespItem, 0, (byte[])localObject1, 4, localObject1.length - 4);
        try
        {
          localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
          localTimeRspBody.mergeFrom(paramRespItem);
          if (localTimeRspBody.iResult.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("BusinessInfoCheckUpdateItem", 2, "handleNewFlagOp,return fail ,TimeRspBody result:" + localTimeRspBody.iResult.get());
          }
        }
        catch (Exception paramRespItem)
        {
          paramRespItem.printStackTrace();
          return;
        }
      }
    }
    paramRespItem = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("check_update_sp_key", 0);
    Object localObject1 = paramRespItem.edit();
    Object localObject2;
    if (localTimeRspBody.iInterval.has())
    {
      localObject2 = "businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localTimeRspBody.iInterval.get() > 0) {
        i1 = localTimeRspBody.iInterval.get();
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, i1);
      label289:
      paramRespItem.edit().putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
      ((SharedPreferences.Editor)localObject1).commit();
      localObject1 = ResourcePluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), 64, false);
      try
      {
        if (localTimeRspBody.rptMsgAppInfo.has())
        {
          int i3 = localTimeRspBody.rptMsgAppInfo.size();
          i1 = i2;
          label389:
          if (i1 < i3)
          {
            localObject2 = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i1);
            if ((localObject2 != null) && (1 == ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get()))
            {
              if (a((List)localObject1, (BusinessInfoCheckUpdate.AppInfo)localObject2)) {
                break label560;
              }
              ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
              ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(0);
              localTimeRspBody.rptMsgAppInfo.set(i1, (MessageMicro)localObject2);
              if (QLog.isColorLevel()) {
                QLog.d("BusinessInfoCheckUpdateItem", 2, "verifyDataCorrect,return false ,appInfo.path.get():" + ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
              }
            }
            for (;;)
            {
              i1 += 1;
              break label389;
              i1 = 0;
              break;
              ((SharedPreferences.Editor)localObject1).remove("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              break label289;
              label560:
              if (((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get() == 769) {
                paramRespItem.edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)).commit();
              }
            }
            ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(localTimeRspBody);
          }
        }
      }
      catch (Exception paramRespItem)
      {
        paramRespItem.printStackTrace();
      }
    }
    for (;;)
    {
      if ((localTimeRspBody != null) && (localTimeRspBody.rptSetting != null) && (localTimeRspBody.rptSetting.get() != null)) {
        LebaShowListManager.a().a(localTimeRspBody.rptSetting.get());
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localObject1 = localTimeRspBody.rptSetting.get();
      if (localObject1 != null)
      {
        paramRespItem = (RespItem)localObject1;
        if (((List)localObject1).size() != 0) {}
      }
      else
      {
        paramRespItem = new ArrayList();
        paramRespItem.addAll(((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).d());
      }
      localTimeRspBody.rptSetting.set(paramRespItem);
    }
  }
  
  public int a()
  {
    return 7;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessInfoCheckUpdateItem", 2, "getCheckUpdateItemData,uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ",serviceId=" + this.ah);
    }
    ReqItem localReqItem = new ReqItem();
    if (localReqItem != null) {}
    switch (this.ah)
    {
    default: 
      return localReqItem;
    }
    return b();
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessInfoCheckUpdateItem", 2, "handleCheckUpdateItemData,serviceId=" + paramRespItem.eServiceID);
      }
    }
    switch (paramRespItem.eServiceID)
    {
    default: 
      return;
    }
    b(paramRespItem);
  }
  
  public int b()
  {
    return this.ah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */