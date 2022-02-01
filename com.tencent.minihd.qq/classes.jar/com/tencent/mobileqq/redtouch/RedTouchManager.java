package com.tencent.mobileqq.redtouch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import jqd;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.RedDisplayInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.RedTypeInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.ReportAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.ReportVersion;

public class RedTouchManager
  extends Observable
  implements Manager
{
  public static final int a = 0;
  public static final String a = "RedTouchSvc.ClientReport";
  public static final int b = 1;
  public static final String b = "RedTouchSvc.EntranceSetting";
  public static final int c = 2;
  public static final String c = "redTouchPref";
  public static final int d = 3;
  public static final String d = "lastClickPath";
  public static final int e = 0;
  private static final String e = "RedPointManage";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 113;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new jqd(this);
  
  public RedTouchManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppInterface.a().getSharedPreferences("redTouchPref", 4);
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      a("input path is empty");
    }
    do
    {
      return -1;
      if (!paramString.contains(".")) {
        break;
      }
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    int k;
    try
    {
      k = Integer.parseInt(paramString[(paramString.length - 1)]);
      return k;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    try
    {
      k = Integer.parseInt(paramString);
      return k;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return 0;
    }
    if ((paramString1 != null) && (paramString2 == null)) {
      return 1;
    }
    if ((paramString1 == null) && (paramString2 != null)) {
      return -1;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int k = 0;
    for (;;)
    {
      int m;
      int n;
      try
      {
        if ((k < arrayOfString1.length) && (k < arrayOfString2.length))
        {
          m = Integer.parseInt(arrayOfString1[k]);
          n = Integer.parseInt(arrayOfString2[k]);
          if (m < n) {
            return -1;
          }
        }
        else
        {
          if (arrayOfString1.length > k) {
            return 1;
          }
          m = arrayOfString2.length;
          if (m <= k) {
            break;
          }
          return -1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return paramString1.compareTo(paramString2);
      }
      if (m > n) {
        return 1;
      }
      k += 1;
    }
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(Submsgtype0x71.RedTypeInfo paramRedTypeInfo)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(paramRedTypeInfo.uint32_red_type.get());
    localRedTypeInfo.red_content.set(paramRedTypeInfo.str_red_content.get());
    localRedTypeInfo.red_desc.set(paramRedTypeInfo.str_red_desc.get());
    localRedTypeInfo.red_priority.set(paramRedTypeInfo.uint32_red_priority.get());
    return localRedTypeInfo;
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
      localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()));
      localReportReqBody.clientver.set("5.9.3.3468");
      localReportReqBody.platid.set(109);
      localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
      localReportReqBody.buffer.set(paramJSONObject.toString());
      if (paramAppInfo != null)
      {
        localReportReqBody.appid.set(a(paramAppInfo.path.get()));
        if (paramAppInfo.missions.has()) {
          localReportReqBody.missionid.set(paramAppInfo.missions.get());
        }
      }
      paramAppInfo = a("RedTouchSvc.ClientReport");
      paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
      a(paramAppInfo);
    }
  }
  
  private final void a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg == null) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(paramToServiceMsg);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointManage", 2, paramString);
    }
  }
  
  private boolean a(String paramString)
  {
    paramString = a(paramString);
    Object localObject = (BusinessInfoCheckUpdate.RedDisplayInfo)paramString.red_display_info.get();
    if (localObject == null) {
      return false;
    }
    localObject = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.get();
    if ((localObject == null) || (((List)localObject).size() < 2)) {
      return false;
    }
    localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject).get(1);
    if (localObject == null) {
      return false;
    }
    return (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 5) && (paramString.iNewFlag.get() != 0);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((a(paramString1, "5.9.3") == 1) && (!paramString1.equals("0"))) {}
    while ((a("5.9.3", paramString2) == -1) && (!paramString2.equals("0"))) {
      return false;
    }
    return true;
  }
  
  private boolean a(Submsgtype0x71.ReportVersion paramReportVersion)
  {
    if ((paramReportVersion.int32_plant_id.get() != 109) && (paramReportVersion.int32_plant_id.get() != 109110)) {
      return false;
    }
    if (paramReportVersion.bool_allver.get()) {
      return true;
    }
    if ((paramReportVersion.rpt_str_version == null) || (paramReportVersion.rpt_str_version.get().size() < 1)) {
      return false;
    }
    paramReportVersion = paramReportVersion.rpt_str_version.get().iterator();
    while (paramReportVersion.hasNext())
    {
      String[] arrayOfString = ((String)paramReportVersion.next()).split("\\,");
      if (a(arrayOfString[0], arrayOfString[1])) {
        return true;
      }
    }
    return false;
  }
  
  private BusinessInfoCheckUpdate.AppInfo b(String paramString)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    return localAppInfo;
  }
  
  public int a(int paramInt, boolean paramBoolean, long paramLong)
  {
    BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
    localAppSetting.appid.set(paramInt);
    localAppSetting.setting.set(paramBoolean);
    localAppSetting.modify_ts.set(paramLong);
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
    if ((localTimeRspBody != null) && ((localTimeRspBody.has()) || (localTimeRspBody.rptSetting.has())))
    {
      List localList = localTimeRspBody.rptSetting.get();
      int m = localList.size();
      int k = 0;
      for (;;)
      {
        if (k < m)
        {
          if (paramInt == ((BusinessInfoCheckUpdate.AppSetting)((BusinessInfoCheckUpdate.AppSetting)localList.get(k)).get()).appid.get()) {
            localList.set(k, localAppSetting);
          }
        }
        else
        {
          if (k == m) {
            localList.add(localAppSetting);
          }
          if (a(localTimeRspBody)) {
            break;
          }
          return -4;
        }
        k += 1;
      }
    }
    localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    localTimeRspBody.rptSetting.add(localAppSetting);
    if (!a(localTimeRspBody)) {
      return -4;
    }
    return 0;
  }
  
  public int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if ((paramAppInfo == null) || (!paramAppInfo.path.has()))
    {
      a("updateAppInfo failed , appInfo is empty or appInfo path is null");
      return -3;
    }
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
    if (localTimeRspBody == null)
    {
      a("updateAppInfo failed,TimeRspBody is Empty");
      return -3;
    }
    List localList = localTimeRspBody.rptMsgAppInfo.get();
    int m = localList.size();
    int k = 0;
    for (;;)
    {
      if (k < m)
      {
        if (paramAppInfo.path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localList.get(k)).path.get()))
        {
          a("path is same = " + paramAppInfo.path);
          localList.set(k, paramAppInfo);
        }
      }
      else
      {
        if (k == m)
        {
          if (!paramBoolean) {
            break;
          }
          localTimeRspBody.rptMsgAppInfo.add(paramAppInfo);
        }
        if (a(localTimeRspBody)) {
          break label177;
        }
        return -4;
      }
      k += 1;
    }
    return -3;
    label177:
    return 0;
  }
  
  public BusinessObserver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = b(paramString);
    paramString.uiAppId.set(paramInt1);
    paramString.type.set(5);
    paramString.iNewFlag.set(1);
    paramString.appset.set(0);
    paramString.mission_level.set(0);
    BusinessInfoCheckUpdate.RedDisplayInfo localRedDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(9);
    localRedTypeInfo.red_content.set("-1");
    localRedTypeInfo.red_desc.set("");
    localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
    localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(5);
    localRedTypeInfo.red_content.set(paramInt2 + "");
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    localRedDisplayInfo.tab_display_info.set(localRedTypeInfo);
    localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
    paramString.red_display_info.set(localRedDisplayInfo);
    a(paramString, true);
    BusinessInfoCheckUpdateItem.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    return paramString;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    Object localObject = a();
    if ((localObject == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptMsgAppInfo.has()))
    {
      a("TimeRspBody is Empty or msgAppInfo is Empty");
      return b(paramString);
    }
    localObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptMsgAppInfo.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
      if (localAppInfo.path.get().equals(paramString)) {
        return localAppInfo;
      }
    }
    return b(paramString);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    return a(0);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    List localList1 = a(paramInt);
    Object localObject4 = localObject2;
    if (localList1 != null)
    {
      if (localList1.size() == 0) {
        localObject4 = localObject2;
      }
    }
    else {
      return localObject4;
    }
    List localList2 = d();
    paramInt = 0;
    localObject2 = null;
    label49:
    if (paramInt < localList1.size())
    {
      localObject4 = (BusinessInfoCheckUpdate.AppInfo)localList1.get(paramInt);
      if (((BusinessInfoCheckUpdate.AppInfo)localObject4).mission_level.get() != 0)
      {
        localObject4 = localObject2;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      label91:
      paramInt += 1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break label49;
      label256:
      Object localObject3;
      if (999999 != ((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get())
      {
        if (((BusinessInfoCheckUpdate.AppInfo)localObject4).path.get().contains("."))
        {
          localObject4 = localObject2;
          localObject2 = localObject1;
        }
        else if (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 1)
        {
          localObject4 = localObject2;
          localObject2 = localObject1;
        }
        else
        {
          int k = 0;
          for (;;)
          {
            if ((k >= localList2.size()) || (((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(k)).appid.get()))
            {
              if ((k >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(k)).setting.get())) {
                break label256;
              }
              localObject4 = localObject2;
              localObject2 = localObject1;
              break;
            }
            k += 1;
          }
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.AppInfo)localObject4).red_display_info.tab_display_info.get();
          if ((localObject2 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() < localRedTypeInfo.red_priority.get())) {}
          for (Object localObject5 = localRedTypeInfo;; localObject5 = localObject3)
          {
            for (;;)
            {
              if (localRedTypeInfo.red_type.get() != 5) {
                break label408;
              }
              localObject2 = localRedTypeInfo;
              localObject4 = localObject5;
              if (localObject1 == null) {
                break;
              }
              try
              {
                localObject2 = localObject1.red_content;
                localObject4 = new StringBuilder();
                k = Integer.parseInt(localObject1.red_content.get());
                ((PBStringField)localObject2).set(Integer.parseInt(localRedTypeInfo.red_content.get()) + k + "");
                localObject2 = localObject1;
                localObject4 = localObject5;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localNumberFormatException.printStackTrace();
                localObject3 = localObject1;
                localObject4 = localObject5;
              }
            }
            break label91;
            label408:
            if ((localObject5 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_priority.get() < localRedTypeInfo.red_priority.get()))
            {
              localObject4 = localRedTypeInfo;
              localObject3 = localObject1;
              break label91;
              localObject4 = localObject1;
              if (localObject1 != null) {
                break;
              }
              return localObject3;
            }
            localObject3 = localObject1;
            localObject4 = localObject5;
            break label91;
          }
        }
      }
      else
      {
        localObject4 = localObject3;
        localObject3 = localObject1;
      }
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a()
  {
    Object localObject = new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
    if (!((File)localObject).exists()) {
      a("BusinessInfoCheckUpdateItem pb file does not exist");
    }
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          localObject = FileUtils.a((File)localObject);
          if (localObject != null) {
            break;
          }
          a("Can not translate BusinessInfoCheckUpdateItem pb file to byte");
          return null;
        }
        finally {}
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    try
    {
      localTimeRspBody.mergeFrom(arrayOfByte);
      return localTimeRspBody;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return "";
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("lastClickPath", "");
  }
  
  public String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      paramAppInfo = null;
    }
    for (;;)
    {
      return paramAppInfo;
      paramAppInfo = paramAppInfo.buffer.get();
      if (!StringUtil.b(paramAppInfo)) {
        try
        {
          paramAppInfo = new JSONObject(paramAppInfo).getJSONObject("text");
          Iterator localIterator = paramAppInfo.keys();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              Object localObject = (String)localIterator.next();
              if (!StringUtil.b((String)localObject))
              {
                localObject = paramAppInfo.getJSONObject((String)localObject);
                if (localObject != null)
                {
                  localObject = ((JSONObject)localObject).getString("text_red_content");
                  if (!StringUtil.b((String)localObject))
                  {
                    paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject;
                    if (((String)localObject).length() <= 3) {
                      break;
                    }
                    paramAppInfo = ((String)localObject).substring(0, 3);
                    return paramAppInfo;
                  }
                }
              }
            }
          }
        }
        catch (JSONException paramAppInfo)
        {
          paramAppInfo.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInfo == null))
    {
      a("url is empty or appInfo is Empty");
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    paramString.append("&status=").append(paramAppInfo.type.get()).append("&number=").append(paramAppInfo.num.get()).append("&path=").append(paramAppInfo.path.get());
    return paramString.toString();
  }
  
  public List a()
  {
    a("getLebaAppInfoList");
    return a(0);
  }
  
  public List a(int paramInt)
  {
    Object localObject1 = a();
    if ((localObject1 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has())) {
      return new ArrayList();
    }
    Object localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
      if (localAppInfo.appset.get() == paramInt) {
        ((List)localObject1).add(localAppInfo);
      }
    }
    return localObject1;
  }
  
  public List a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = a(paramAppInfo);
    ArrayList localArrayList;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localArrayList = new ArrayList();
      try
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (JSONObject)((Map.Entry)localObject2).getValue();
          if ((str != null) && (localObject2 != null) && (((JSONObject)localObject2).has("blue_bar_stat")))
          {
            VipBannerInfo localVipBannerInfo = new VipBannerInfo();
            localVipBannerInfo.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
            localVipBannerInfo.jdField_f_of_type_Int = ((JSONObject)localObject2).getInt("blue_bar_stat");
            localVipBannerInfo.b = ((JSONObject)localObject2).getString("blue_content");
            localVipBannerInfo.jdField_e_of_type_Int = ((JSONObject)localObject2).getInt("blue_type");
            localVipBannerInfo.jdField_a_of_type_JavaLangString = str;
            localVipBannerInfo.jdField_a_of_type_Long = (((JSONObject)localObject2).getLong("duration") * 1000L);
            localVipBannerInfo.c = ((JSONObject)localObject2).getString("blue_aid");
            localVipBannerInfo.d = ((JSONObject)localObject2).getString("link");
            localVipBannerInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).getString("blue_icon_url");
            localVipBannerInfo.jdField_f_of_type_JavaLangString = ((JSONObject)localObject2).getString("blue_button_text");
            localArrayList.add(localVipBannerInfo);
            continue;
            return null;
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public Map a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      Object localObject = paramAppInfo.buffer.get();
      if (!StringUtil.b((String)localObject)) {
        try
        {
          paramAppInfo = new HashMap();
          localObject = new JSONObject((String)localObject).getJSONObject("msg");
          Iterator localIterator = ((JSONObject)localObject).keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!StringUtil.b(str))
            {
              JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject(str);
              if (localJSONObject != null)
              {
                paramAppInfo.put(str, localJSONObject);
                continue;
                return null;
              }
            }
          }
        }
        catch (JSONException paramAppInfo)
        {
          paramAppInfo.printStackTrace();
        }
      }
    }
    return paramAppInfo;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      a("onReportRedPointExposure Failed:tabIndex's value is wrong");
      return;
    }
    a("onReportRedPointExposure");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", 1);
      localJSONObject.put("appset", paramInt);
      a(null, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(RedTouchManager.BannerInfoHandler paramBannerInfoHandler)
  {
    label4:
    Object localObject1;
    if (paramBannerInfoHandler == null) {
      return;
    } else {
      do
      {
        localObject1 = c();
      } while (localObject1 == null);
    }
    Object localObject2;
    label64:
    do
    {
      localObject1 = ((List)localObject1).iterator();
      break label64;
      if (!((Iterator)localObject1).hasNext()) {
        break label4;
      }
      localObject2 = a((BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject1).next());
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!paramBannerInfoHandler.a((VipBannerInfo)((Iterator)localObject2).next()));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (!paramAppInfo.path.has()))
    {
      a("onReportRedTouchFailed:appInfo or path is null");
      return;
    }
    a("onReportRedTouch");
    setChanged();
    notifyObservers(paramAppInfo);
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()));
    localReportReqBody.clientver.set("5.9.3.3468");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(a(paramAppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    if (paramAppInfo.missions.has()) {
      localReportReqBody.missionid.set(paramAppInfo.missions.get());
    }
    paramAppInfo = a("RedTouchSvc.ClientReport");
    paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
    a(paramAppInfo);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject;
    if ((paramAppInfo != null) && (paramString != null))
    {
      localObject = paramAppInfo.buffer.get();
      if (StringUtil.b((String)localObject)) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("msg").getJSONObject(paramString);
      if ((localJSONObject != null) && (localJSONObject.getInt("blue_bar_stat") == 1))
      {
        localJSONObject.put("blue_bar_stat", 2);
        paramAppInfo.buffer.set(((JSONObject)localObject).toString());
        a(paramAppInfo, false);
        a(paramAppInfo, paramString, 2);
      }
      return;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, int paramInt)
  {
    JSONObject localJSONObject;
    if (((paramAppInfo != null) && (3 == paramInt)) || (2 == paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointManage", 2, "onReportRenewBannerExposure");
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("missionid", paramString);
      a(paramAppInfo, localJSONObject);
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    BusinessInfoCheckUpdateItem.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, paramBoolean);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    Object localObject = a();
    if (localObject == null) {
      return true;
    }
    localObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptMsgNumRedInfo.get();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject).next();
        if (localNumRedInfo.appid.get() == paramInt) {
          return localNumRedInfo.flag.get();
        }
      }
    }
    return true;
  }
  
  public boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    try
    {
      boolean bool = FileUtils.a(new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()).getAbsolutePath(), paramTimeRspBody.toByteArray(), false);
      return bool;
    }
    finally
    {
      paramTimeRspBody = finally;
      throw paramTimeRspBody;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool3 = false;
    boolean bool2;
    if (paramArrayOfByte != null)
    {
      try
      {
        localObject1 = new Submsgtype0x71.MsgBody();
        ((Submsgtype0x71.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((Submsgtype0x71.MsgBody)localObject1).rpt_msg_app_info.get().iterator();
        bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          try
          {
            if (!paramArrayOfByte.hasNext()) {
              break label142;
            }
            localObject3 = (Submsgtype0x71.ReportAppInfo)paramArrayOfByte.next();
            if (a((Submsgtype0x71.ReportVersion)((Submsgtype0x71.ReportAppInfo)localObject3).msg_version_info.get()))
            {
              localObject1 = a(((Submsgtype0x71.ReportAppInfo)localObject3).str_android_path.get());
              if (!a(((Submsgtype0x71.ReportAppInfo)localObject3).str_android_path.get())) {
                break label144;
              }
              ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.add(((Submsgtype0x71.ReportAppInfo)localObject3).str_mission.get());
              a((BusinessInfoCheckUpdate.AppInfo)localObject1, true);
            }
          }
          catch (Exception paramArrayOfByte) {}
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject3;
          boolean bool1 = false;
        }
      }
      paramArrayOfByte.printStackTrace();
      bool2 = bool1;
    }
    for (;;)
    {
      label142:
      return bool2;
      label144:
      if (localObject1 != null)
      {
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.set(((Submsgtype0x71.ReportAppInfo)localObject3).uint32_android_app_id.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).appset.set(((Submsgtype0x71.ReportAppInfo)localObject3).int32_appset.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(((Submsgtype0x71.ReportAppInfo)localObject3).int32_new_flag.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).type.set(((Submsgtype0x71.ReportAppInfo)localObject3).uint32_type.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.set(((Submsgtype0x71.ReportAppInfo)localObject3).str_buffer.get());
        Object localObject2 = new ArrayList();
        ((List)localObject2).add(((Submsgtype0x71.ReportAppInfo)localObject3).str_mission.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.set((List)localObject2);
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).num.set(((Submsgtype0x71.ReportAppInfo)localObject3).int32_num.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).icon_url.set(((Submsgtype0x71.ReportAppInfo)localObject3).str_icon_url.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).icon_flag.set(((Submsgtype0x71.ReportAppInfo)localObject3).int32_icon_flag.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).icon_type.set(((Submsgtype0x71.ReportAppInfo)localObject3).int32_icon_type.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).push_red_ts.set(((Submsgtype0x71.ReportAppInfo)localObject3).uint32_push_red_ts.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).mission_level.set(((Submsgtype0x71.ReportAppInfo)localObject3).int32_mission_level.get());
        localObject2 = new BusinessInfoCheckUpdate.RedDisplayInfo();
        if (((Submsgtype0x71.ReportAppInfo)localObject3).msg_display_desc.has())
        {
          ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject2).tab_display_info.set(a((Submsgtype0x71.RedTypeInfo)((Submsgtype0x71.ReportAppInfo)localObject3).msg_display_desc.msg_tab_display_info.get()));
          localObject3 = ((Submsgtype0x71.ReportAppInfo)localObject3).msg_display_desc.rpt_msg_red_type_info.get().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Submsgtype0x71.RedTypeInfo localRedTypeInfo = (Submsgtype0x71.RedTypeInfo)((Iterator)localObject3).next();
            ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject2).red_type_info.add(a((Submsgtype0x71.RedTypeInfo)localRedTypeInfo.get()));
          }
        }
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.set((MessageMicro)localObject2);
        bool2 = bool3;
        if (!BusinessInfoCheckUpdateItem.a(ResourcePluginInfo.getAll(((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().createEntityManager(), 64, false), (BusinessInfoCheckUpdate.AppInfo)localObject1)) {
          continue;
        }
        a((BusinessInfoCheckUpdate.AppInfo)localObject1, true);
        bool1 = true;
        break;
      }
      bool2 = false;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo b()
  {
    return a(1);
  }
  
  public List b()
  {
    a("getSettingAppInfoList");
    return a(1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (a() == null);
      a(0);
      return;
    } while (b() == null);
    a(1);
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()));
    localReportReqBody.clientver.set("5.9.3.3468");
    localReportReqBody.platid.set(109);
    localReportReqBody.missionid.set(paramAppInfo.missions.get());
    localReportReqBody.appid.set(paramAppInfo.uiAppId.get());
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramAppInfo = new JSONObject();
      if (paramAppInfo != null) {}
      try
      {
        paramAppInfo.put("cmd", 5);
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = paramAppInfo;
        if (localJSONObject == null) {
          break label240;
        }
        Iterator localIterator = localJSONObject.keys();
        for (;;)
        {
          paramString = paramAppInfo;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
          localReportStaticsData.key.set(paramString);
          localReportStaticsData.value.set(localJSONObject.getString(paramString));
          localArrayList.add(localReportStaticsData);
        }
        paramString.printStackTrace();
      }
      catch (JSONException paramString) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramAppInfo = null;
      }
    }
    paramString = paramAppInfo;
    label240:
    if (paramString != null) {
      localReportReqBody.buffer.set(paramString.toString());
    }
    localReportReqBody.reportdata.set(localArrayList);
    paramAppInfo = a("RedTouchSvc.ClientReport");
    paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
    a(paramAppInfo);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      if (a(paramString).iNewFlag.get() != 1) {
        break label75;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("lastClickPath", paramString).commit();
    }
    for (;;)
    {
      a(paramString, false);
      a(a(paramString));
      return;
      label75:
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("lastClickPath", "").commit();
    }
  }
  
  public List c()
  {
    a("getVirtualAppInfoList");
    return a(3);
  }
  
  public List d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a();
    if ((localObject == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptSetting.has())) {}
    do
    {
      return localArrayList;
      localObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptSetting.get();
    } while (localObject == null);
    localArrayList.addAll((Collection)localObject);
    return localArrayList;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager
 * JD-Core Version:    0.7.0.1
 */