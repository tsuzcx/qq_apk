package com.tencent.mobileqq.mybusiness;

import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import MyCarrier.Carrier;
import MyCarrier.MQQ.PreLoadCarrierReq;
import MyCarrier.ReqCarrier;
import MyCarrier.RspCarrier;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

public class MyBusinessServlet
  extends MSFServlet
{
  public static final String a = "MyBusinessServlet";
  
  private LBSInfo a()
  {
    SosoInterface.a(60000L, getClass().getSimpleName());
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.a();
    GPS localGPS = new GPS((int)(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D), (int)(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D), -1, 0);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject2).b, ((SosoInterface.SosoCell)localObject2).c, ((SosoInterface.SosoCell)localObject2).d, (short)((SosoInterface.SosoCell)localObject2).e));
      }
    }
    Object localObject1 = new ArrayList();
    if (localSosoLbsInfo.b != null)
    {
      localObject2 = localSosoLbsInfo.b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
        ((ArrayList)localObject1).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
      }
    }
    return new LBSInfo(localGPS, (ArrayList)localObject1, localArrayList, new Attr(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a, localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.b, localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c));
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)getAppRuntime();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = false;
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RspCarrier)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspCarrier", new RspCarrier());
      localBundle.putSerializable("result", paramFromServiceMsg.carrrier);
      localBundle.putSerializable("refreshTime", Integer.valueOf(paramFromServiceMsg.refreshTime));
      Object localObject = paramFromServiceMsg.carrrier;
      if (QLog.isDevelopLevel())
      {
        QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess");
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierCity      " + ((Carrier)localObject).carrierCity);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierExtraInfo " + ((Carrier)localObject).carrierExtraInfo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierId        " + ((Carrier)localObject).carrierId);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierLogo      " + ((Carrier)localObject).carrierLogo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierName      " + ((Carrier)localObject).carrierName);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierProvince  " + ((Carrier)localObject).carrierProvince);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierURL       " + ((Carrier)localObject).carrierURL);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery redhotfilter     " + ((Carrier)localObject).redhotfilter);
      }
      if (paramFromServiceMsg.retWiFi == 0)
      {
        localObject = a().getApplication();
        String str = a().a();
        if (paramFromServiceMsg.wifiEnable == 1) {
          bool1 = true;
        }
        bool1 = QQWiFiHelper.a((Context)localObject, str, bool1);
        boolean bool2 = QQWiFiHelper.a(a().getApplication(), paramFromServiceMsg.vAvailSsids);
        boolean bool3 = QQWiFiHelper.a(a().getApplication(), a().a(), paramFromServiceMsg.freeTime);
        boolean bool4 = QQWiFiHelper.a(a().getApplication(), paramFromServiceMsg.mParams);
        if (QLog.isColorLevel()) {
          QLog.i("MyBusinessServlet", 2, "isUpdateEnableSuccess:" + bool1 + ",isUpdateSsidSuccess:" + bool2 + ",isUpdateFreeTimeSuccess:" + bool3 + ",isUpdateParamsSuccess:" + bool4);
        }
        if ((bool1) || (bool2) || (bool3) || (bool4))
        {
          if (QLog.isColorLevel()) {
            QLog.i("MyBusinessServlet", 2, "MyBusinessServlet send qqwifi broadcast");
          }
          paramFromServiceMsg = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
          paramFromServiceMsg.putExtra("enableChange", true);
          a().getApplication().sendBroadcast(paramFromServiceMsg);
        }
      }
      notifyObserver(paramIntent, 1, true, localBundle, MyBusinessObserver.class);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess failed");
    }
    notifyObserver(paramIntent, 1, false, localBundle, MyBusinessObserver.class);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "......onReceive cmd = " + paramFromServiceMsg.getServiceCmd());
    }
    if ("CarrierEntry.queryCarrier".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("cmd_id", -1);
    if (1 == i)
    {
      str = paramIntent.getStringExtra("phone_number");
      i = paramIntent.getIntExtra("bind_from", 0);
      paramIntent = paramIntent.getStringExtra("opt_info");
      new LBSInfo();
      localLBSInfo = a();
      if (QLog.isDevelopLevel()) {
        QLog.d("MyBusinessServlet", 4, "......onSend bindMobile = " + str + ", bindType = " + i + ", info = " + localLBSInfo);
      }
      paramIntent = new ReqCarrier(str, i, localLBSInfo, paramIntent);
      paramPacket.setSSOCommand("CarrierEntry.queryCarrier");
      paramPacket.setServantName("CarrierEntry");
      paramPacket.setFuncName("queryCarrier");
      paramPacket.addRequestPacket("ReqCarrier", paramIntent);
    }
    while (2 != i)
    {
      String str;
      LBSInfo localLBSInfo;
      return;
    }
    paramIntent = (PhoneContactManager)a().getManager(10);
    if (paramIntent.b() > 1)
    {
      paramIntent = paramIntent.a();
      if (paramIntent != null) {
        i = paramIntent.type;
      }
    }
    for (paramIntent = paramIntent.mobileNo;; paramIntent = "")
    {
      paramIntent = new PreLoadCarrierReq(paramIntent, i, 1, "5.9.3.3468");
      paramPacket.setSSOCommand("CarrierBizSvr.preLoadCarrierInfo");
      paramPacket.setServantName("MQQ.CarrierBizServer.CarrierBizObj");
      paramPacket.setFuncName("preLoadCarrierInfo");
      paramPacket.addRequestPacket("req", paramIntent);
      paramPacket.setNoResponse();
      paramPacket.setTimeout(20000L);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mybusiness.MyBusinessServlet
 * JD-Core Version:    0.7.0.1
 */