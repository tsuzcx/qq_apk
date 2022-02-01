package com.tencent.biz.helper;

import cgh;
import cgi;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.AppInfo;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.AppTip;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.ReqBody;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.RspBody;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.AppBrief;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.ReqBody;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopCardAppInfoHelper
{
  private static final String jdField_a_of_type_JavaLangString = "TroopCardAppInfoHandler";
  private TroopCardAppInfoHelper.IGetAppInfoCB jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopCardAppInfoHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ArrayList a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x8cf.RspBody localRspBody = new oidb_0x8cf.RspBody();
    localArrayList = new ArrayList();
    try
    {
      localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = localRspBody.rpt_msg_app_brief.get().iterator();
      while (paramOIDBSSOPkg.hasNext()) {
        localArrayList.add(Long.valueOf(((oidb_0x8cf.AppBrief)paramOIDBSSOPkg.next()).opt_uint64_appid.get()));
      }
      return localArrayList;
    }
    catch (Exception paramOIDBSSOPkg)
    {
      paramOIDBSSOPkg.printStackTrace();
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB != null) {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB.a(paramArrayList);
    }
  }
  
  private void a(List paramList)
  {
    Object localObject = new oidb_0x8d3.ReqBody();
    ((oidb_0x8d3.ReqBody)localObject).rpt_uint64_appidlist.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2259);
    paramList.uint32_service_type.set(1);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8d3.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x8d3_1");
    ((NewIntent)localObject).putExtra("data", paramList.toByteArray());
    ((NewIntent)localObject).setObserver(new cgi(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private ArrayList b(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject1 = new oidb_0x8d3.RspBody();
      ((oidb_0x8d3.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = ((oidb_0x8d3.RspBody)localObject1).rpt_msg_appinfo_list.get();
      if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.size() > 0))
      {
        paramOIDBSSOPkg = paramOIDBSSOPkg.iterator();
        while (paramOIDBSSOPkg.hasNext())
        {
          Object localObject2 = (oidb_0x8d3.AppInfo)paramOIDBSSOPkg.next();
          localObject1 = new TroopAppInfo();
          ((TroopAppInfo)localObject1).appId = ((oidb_0x8d3.AppInfo)localObject2).opt_uint64_appid.get();
          ((TroopAppInfo)localObject1).appName = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_appname.get().toByteArray());
          ((TroopAppInfo)localObject1).appType = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_type.get();
          ((TroopAppInfo)localObject1).appFrom = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_from.get();
          ((TroopAppInfo)localObject1).appIntro = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_app_intro.get().toByteArray());
          ((TroopAppInfo)localObject1).appUrl = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_app_url.get().toByteArray());
          ((TroopAppInfo)localObject1).appIcon = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_app_icon.get().toByteArray());
          ((TroopAppInfo)localObject1).appWindowHeight = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_window_high.get();
          ((TroopAppInfo)localObject1).appWindowWidth = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_window_width.get();
          ((TroopAppInfo)localObject1).appUpdateTime = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_update_time.get();
          ((TroopAppInfo)localObject1).openParam = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_open_param.get().toByteArray());
          ((TroopAppInfo)localObject1).appStatus = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_status.get();
          ((TroopAppInfo)localObject1).appInnerType = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_inner_type.get();
          ((TroopAppInfo)localObject1).initFlag = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_init_flag.get();
          ((TroopAppInfo)localObject1).settingFlag = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_setting_flag.get();
          ((TroopAppInfo)localObject1).tags = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_tags.get().toByteArray());
          ((TroopAppInfo)localObject1).versionAndroid = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_version_android.get().toByteArray());
          ((TroopAppInfo)localObject1).androidDownloadUrl = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_android_download_url.get().toByteArray());
          ((TroopAppInfo)localObject1).androidOpen = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_android_open.get().toByteArray());
          ((TroopAppInfo)localObject1).appSortKey = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_sort_key.get();
          ((TroopAppInfo)localObject1).appIsNew = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_is_new.get();
          ((TroopAppInfo)localObject1).appNewTime = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_new_time.get();
          localObject2 = (oidb_0x8d3.AppTip)((oidb_0x8d3.AppInfo)localObject2).opt_msg_app_tip.get();
          if (localObject2 != null)
          {
            ((TroopAppInfo)localObject1).AppTipInfoSeq = ((oidb_0x8d3.AppTip)localObject2).uint32_tip_info_seq.get();
            ((TroopAppInfo)localObject1).AppTipIcon = new String(((oidb_0x8d3.AppTip)localObject2).bytes_icon.get().toByteArray());
            ((TroopAppInfo)localObject1).AppTipIconTimeStamp = ((oidb_0x8d3.AppTip)localObject2).uint32_icon_time_stamp.get();
            ((TroopAppInfo)localObject1).AppTipToolTip = new String(((oidb_0x8d3.AppTip)localObject2).bytes_tooltip.get().toByteArray());
            ((TroopAppInfo)localObject1).AppTipReportIdClick = ((oidb_0x8d3.AppTip)localObject2).uint32_reportid_click.get();
            ((TroopAppInfo)localObject1).AppTipReportIdShow = ((oidb_0x8d3.AppTip)localObject2).uint32_reportid_show.get();
          }
          localArrayList.add(localObject1);
        }
      }
      return localArrayList;
    }
    catch (Exception paramOIDBSSOPkg)
    {
      paramOIDBSSOPkg.printStackTrace();
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB != null) {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB.a();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a(String paramString, TroopCardAppInfoHelper.IGetAppInfoCB paramIGetAppInfoCB)
  {
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = paramIGetAppInfoCB;
    paramIGetAppInfoCB = new oidb_0x8cf.ReqBody();
    try
    {
      paramIGetAppInfoCB.opt_uint64_groupcode.set(Long.parseLong(paramString));
      paramIGetAppInfoCB.opt_uint32_need_mobile_sysapps.set(1);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2255);
      paramString.uint32_service_type.set(6);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIGetAppInfoCB.toByteArray()));
      paramIGetAppInfoCB = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
      paramIGetAppInfoCB.putExtra("cmd", "OidbSvc.0x8cf_6");
      paramIGetAppInfoCB.putExtra("data", paramString.toByteArray());
      paramIGetAppInfoCB.setObserver(new cgh(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramIGetAppInfoCB);
      return true;
    }
    catch (NumberFormatException paramIGetAppInfoCB)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCardAppInfoHandler", 2, "getTroopAppList, NumberFormatException, troopUin :" + paramString);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.helper.TroopCardAppInfoHelper
 * JD-Core Version:    0.7.0.1
 */