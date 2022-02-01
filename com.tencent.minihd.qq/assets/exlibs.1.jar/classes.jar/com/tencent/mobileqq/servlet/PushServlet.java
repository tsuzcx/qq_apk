package com.tencent.mobileqq.servlet;

import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.PushReq;
import KQQ.CheckUpdateResp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SaveTrafficHandler;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavSrvAddrProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.Constants.Key;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class PushServlet
  extends MSFServlet
{
  private void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null))
    {
      Object localObject = paramFileStoragePushFSSvcList.vUrlEncodeServiceList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("PushServlet", 2, "info.sip" + localFileStorageServerListInfo.sIP + ",info.port" + localFileStorageServerListInfo.iPort);
        }
      }
      localObject = (QQAppInterface)getAppRuntime();
      SosoSrvAddrProvider.a().a(paramFileStoragePushFSSvcList.vUrlEncodeServiceList);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "RECEIVED PUSH: FMT SERVER ADDR LIST");
    }
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    Object localObject = new FileStoragePushFSSvcList();
    ((FileStoragePushFSSvcList)localObject).readFrom(paramArrayOfByte);
    FMTSrvAddrProvider.a().a((FileStoragePushFSSvcList)localObject);
    a((FileStoragePushFSSvcList)localObject);
    b((FileStoragePushFSSvcList)localObject);
    c((FileStoragePushFSSvcList)localObject);
    if ((((FileStoragePushFSSvcList)localObject).vGPicDownLoadList == null) && (QLog.isColorLevel())) {
      QLog.d("FMT_ADDR", 2, "RECEIVED PUSH: vGPicDownLoadList ==null");
    }
    paramArrayOfByte = (QQAppInterface)getAppRuntime();
    paramArrayOfByte.a();
    localObject = BaseApplication.getContext();
    String str = paramArrayOfByte.a();
    HwConfig localHwConfig = FMTSrvAddrProvider.a().a();
    ConfigManager.getInstance((Context)localObject, paramArrayOfByte, paramArrayOfByte.a(), str).onSrvAddrPush((Context)localObject, paramArrayOfByte, str, localHwConfig);
  }
  
  private void b(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    QQAppInterface localQQAppInterface;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.bigDataChannel != null))
    {
      paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.bigDataChannel;
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      long l = paramFileStoragePushFSSvcList.uSig_Uin;
      if (localQQAppInterface.getLongAccountUin() == l)
      {
        arrayOfByte1 = paramFileStoragePushFSSvcList.sBigdata_key_session;
        arrayOfByte2 = paramFileStoragePushFSSvcList.sBigdata_sig_session;
        paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.vBigdata_iplists.iterator();
        while (paramFileStoragePushFSSvcList.hasNext())
        {
          Object localObject = (BigDataIpList)paramFileStoragePushFSSvcList.next();
          if (((BigDataIpList)localObject).uService_type == 5L)
          {
            localObject = ((BigDataIpList)localObject).vIplist;
            if (localObject != null)
            {
              paramFileStoragePushFSSvcList = new String[((ArrayList)localObject).size()];
              int i = 0;
              while (i < ((ArrayList)localObject).size())
              {
                BigDataIpInfo localBigDataIpInfo = (BigDataIpInfo)((ArrayList)localObject).get(i);
                paramFileStoragePushFSSvcList[i] = CircleManager.a(localBigDataIpInfo.sIp, (int)localBigDataIpInfo.uPort);
                i += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((CircleManager)localQQAppInterface.getManager(34)).a(arrayOfByte1, arrayOfByte2, paramFileStoragePushFSSvcList);
      return;
      paramFileStoragePushFSSvcList = null;
    }
  }
  
  private void c(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    new QfavSrvAddrProvider().a(paramFileStoragePushFSSvcList);
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "cmd_connOpened", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PbGetMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullDisGroupSeq", "RegPrxySvc.NoticeEnd", "cmd_connClosed", "ConfigPushSvc.PushReq", "StatSvc.register", "cmd_connAllFailed", "cmd_recvFirstResp", "cmd_connWeakNet", "MultiVideo.s2c", "MultiVideo.c2sack", "ProfileService.CheckUpdateReq", "cmd_netNeedSignon", "qqwifi.notifyAvail", "RegPrxySvc.QueryIpwdStat" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = true;
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    String str = paramFromServiceMsg.getServiceCmd();
    if ("cmd_connOpened".equals(str)) {
      localQQAppInterface.d();
    }
    label566:
    label956:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if ("cmd_connClosed".equals(str))
            {
              ((SaveTrafficHandler)localQQAppInterface.a(18)).a();
              localQQAppInterface.g();
              return;
            }
            if ("cmd_connWeakNet".equals(str))
            {
              localQQAppInterface.f();
              return;
            }
            if ("cmd_netNeedSignon".equals(str))
            {
              localQQAppInterface.b((String)paramFromServiceMsg.getAttribute("signonurl"));
              return;
            }
            boolean bool1;
            if ("qqwifi.notifyAvail".equals(str))
            {
              bool1 = ((Boolean)paramFromServiceMsg.getAttribute("has_avail_qqwifi", Boolean.valueOf(false))).booleanValue();
              if (QLog.isColorLevel()) {
                QLog.i("PushServlet", 2, "QQWiFi : recv broadcast -" + str + "hasAvailWiFi = " + bool1);
              }
              paramIntent = localQQAppInterface.a(Conversation.class);
              if (paramIntent != null)
              {
                if (bool1) {}
                for (int i = 1032;; i = 1033)
                {
                  paramIntent.sendEmptyMessage(i);
                  if (!bool1) {
                    break;
                  }
                  ReportController.b(localQQAppInterface, "CliOper", "", "", "QQWIFI", "show_buleNotify", 0, 0, "", "", "", "");
                  return;
                }
              }
            }
            else
            {
              if ("cmd_recvFirstResp".equals(str))
              {
                localQQAppInterface.h();
                return;
              }
              if ("cmd_connAllFailed".equals(str))
              {
                localQQAppInterface.i();
                return;
              }
              if ("ConfigPushSvc.PushReq".equals(str))
              {
                paramIntent = new UniPacket(true);
                paramIntent.setEncodeName("utf-8");
                paramIntent.decode(paramFromServiceMsg.getWupBuffer());
                paramIntent = (PushReq)paramIntent.getByClass("PushReq", new PushReq());
                if ((paramIntent != null) && (paramIntent.type == 2)) {
                  a(paramIntent.jcebuf);
                }
              }
              else if ("StatSvc.register".equals(paramFromServiceMsg.getServiceCmd()))
              {
                paramIntent = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
                if ((paramIntent != null) && (paramIntent.cReplyCode == 0))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.contacts.", 2, "PushServlet.onReceive " + paramIntent.timeStamp + ", " + paramIntent.bUpdateFlag);
                  }
                  long l = paramIntent.timeStamp;
                  if (paramIntent.timeStamp == 0L) {
                    l = localQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
                  }
                  if ((l == 0L) || (paramIntent.bUpdateFlag == 1) || (paramIntent.bLargeSeqUpdate == 1))
                  {
                    paramFromServiceMsg = localQQAppInterface.a;
                    if ((l == 0L) || (paramIntent.bUpdateFlag == 1))
                    {
                      bool1 = true;
                      l = paramIntent.timeStamp;
                      if (paramIntent.bLargeSeqUpdate != 1) {
                        break label566;
                      }
                    }
                    for (;;)
                    {
                      paramFromServiceMsg.a(bool1, l, bool2);
                      return;
                      bool1 = false;
                      break;
                      bool2 = false;
                    }
                  }
                }
              }
              else
              {
                if ((!"RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.GetMsgV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullDisMsgSeq".equals(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.NoticeEnd".equals(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
                  break label1056;
                }
                if (paramIntent != null)
                {
                  paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
                  paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
                  if ((!"RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
                    try
                    {
                      if (localQQAppInterface.a().c != 0L)
                      {
                        if (paramFromServiceMsg.getAttributes().containsKey("_attr_regprxy_random_code")) {
                          break label956;
                        }
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d("Q.msg.register_proxy", 2, "[ReSendProxy]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " No Random!");
                      }
                    }
                    catch (Exception localException)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.register_proxy", 2, "[ReSendProxy] PushServletException", localException);
                      }
                    }
                  }
                }
              }
            }
          }
          do
          {
            if (("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
              paramIntent.extraData.putBoolean("req_pb_protocol_flag", true);
            }
            paramIntent.extraData.putBoolean("used_register_proxy", true);
            localQQAppInterface.a.f();
            ((QQAppInterface)getAppRuntime()).a(paramIntent, paramFromServiceMsg);
            return;
            paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
            break;
          } while (((Long)paramFromServiceMsg.getAttributes().get("_attr_regprxy_random_code")).longValue() == localQQAppInterface.a().c);
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.register_proxy", 2, "[ReSendProxy]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " Diff Random=" + (Long)paramFromServiceMsg.getAttributes().get("_attr_regprxy_random_code"));
        return;
        if (("MultiVideo.s2c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("MultiVideo.c2sack".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("dimontang", 2, "RECEIVED PUSH: MULTI VIDEO S2C");
          }
          if (paramIntent != null)
          {
            paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
          }
          for (;;)
          {
            ((QQAppInterface)getAppRuntime()).a(paramIntent, paramFromServiceMsg);
            return;
            paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          }
        }
      } while (!"ProfileService.CheckUpdateReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "push command:" + paramFromServiceMsg.getServiceCmd() + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq());
      }
    } while (paramFromServiceMsg.getRequestSsoSeq() > 0);
    label1056:
    paramIntent = new UniPacket(true);
    try
    {
      paramIntent.setEncodeName("utf-8");
      paramIntent.decode(paramFromServiceMsg.getWupBuffer());
      label1257:
      paramIntent = (CheckUpdateResp)paramIntent.getByClass("CheckUpdateResp", new CheckUpdateResp());
      ((FriendListHandler)localQQAppInterface.a(1)).a(paramIntent);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      break label1257;
    }
    catch (RuntimeException paramFromServiceMsg)
    {
      break label1257;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.PushServlet
 * JD-Core Version:    0.7.0.1
 */