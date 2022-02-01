package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.QQDoyen;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DateUtil;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.ReqBasicInfo;
import tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.ReqBody;
import tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.RspBody;
import tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.RspLoginInfo;
import tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.login_date_info;
import tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.one_date;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QzoneMsgHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "OidbSvc.0x7d0_3";
  private static final String b = QzoneMsgHandler.class.getSimpleName();
  
  protected QzoneMsgHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
        }
      }
      paramObject = new oidb_cmd0x7d0.RspBody();
    }
    for (;;)
    {
      int i;
      try
      {
        paramToServiceMsg = new QQDoyen();
        paramToServiceMsg.uin = this.a.getLongAccountUin();
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i = paramObject.msg_rsp_login_info.msg_login_date_info.uint32_login_days.get();
        if (i > 30)
        {
          paramToServiceMsg.isDoyen = true;
          paramToServiceMsg.becomeDoyenNeedDays = 0;
          paramToServiceMsg.nowUserPer = paramObject.msg_rsp_login_info.msg_login_date_info.uint32_now_percent.get();
          paramToServiceMsg.nextUserPer = paramObject.msg_rsp_login_info.msg_login_date_info.uint32_next_percent.get();
          paramToServiceMsg.nextLevelDateDay = paramObject.msg_rsp_login_info.msg_login_date_info.msg_next_level_date.uint32_day.get();
          paramToServiceMsg.nextLevelDateMonth = paramObject.msg_rsp_login_info.msg_login_date_info.msg_next_level_date.uint32_month.get();
          paramToServiceMsg.nextLevelDateYear = paramObject.msg_rsp_login_info.msg_login_date_info.msg_next_level_date.uint32_year.get();
          paramToServiceMsg.nextDays = (paramObject.msg_rsp_login_info.msg_login_date_info.uint32_next_level_days.get() - paramObject.msg_rsp_login_info.msg_login_date_info.uint32_login_days.get());
          paramToServiceMsg.sequenceDays = i;
          a(0, true, paramToServiceMsg);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      paramToServiceMsg.becomeDoyenNeedDays = (30 - i);
      paramToServiceMsg.gapDateStartDay = paramObject.msg_rsp_login_info.msg_login_date_info.msg_gap_start_date.uint32_day.get();
      paramToServiceMsg.gapDateStartMonth = paramObject.msg_rsp_login_info.msg_login_date_info.msg_gap_start_date.uint32_month.get();
      paramToServiceMsg.gapDateStartYear = paramObject.msg_rsp_login_info.msg_login_date_info.msg_gap_start_date.uint32_year.get();
      paramToServiceMsg.gapDateEndDay = paramObject.msg_rsp_login_info.msg_login_date_info.msg_gap_end_date.uint32_day.get();
      paramToServiceMsg.gapDateEndMonth = paramObject.msg_rsp_login_info.msg_login_date_info.msg_gap_end_date.uint32_month.get();
      paramToServiceMsg.gapDateEndYear = paramObject.msg_rsp_login_info.msg_login_date_info.msg_gap_end_date.uint32_year.get();
      try
      {
        paramFromServiceMsg = paramToServiceMsg.getStartData();
        paramObject = paramToServiceMsg.getEndData();
        if ((!paramFromServiceMsg.equals("000")) || (!paramObject.equals("000"))) {
          break label456;
        }
        paramToServiceMsg.gapDays = 0;
      }
      catch (NullPointerException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      continue;
      label456:
      paramToServiceMsg.gapDays = DateUtil.a(paramFromServiceMsg, paramObject);
    }
  }
  
  protected Class a()
  {
    return QzoneMsgObserver.class;
  }
  
  public void a()
  {
    Object localObject1 = new oidb_cmd0x7d0.ReqBasicInfo();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(Long.valueOf(this.a.getLongAccountUin()));
    ((oidb_cmd0x7d0.ReqBasicInfo)localObject1).uint64_request_uin.set((List)localObject2);
    localObject2 = new oidb_cmd0x7d0.ReqBody();
    ((oidb_cmd0x7d0.ReqBody)localObject2).msg_req_basic_info.set((MessageMicro)localObject1);
    ((oidb_cmd0x7d0.ReqBody)localObject2).uint32_req_login_info.set(1);
    ((oidb_cmd0x7d0.ReqBody)localObject2).setHasFlag(true);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2000);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(3);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0x7d0.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x7d0_3");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x7d0_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QzoneMsgHandler
 * JD-Core Version:    0.7.0.1
 */