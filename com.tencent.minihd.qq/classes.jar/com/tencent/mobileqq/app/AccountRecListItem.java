package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import SecurityAccountServer.RequestGetRecommendedListV2;
import SecurityAccountServer.RequestHeader;
import SecurityAccountServer.RespondHeader;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SecurityAccountServer.ResponseGetRecommendedListV2;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

public class AccountRecListItem
  implements CheckUpdateItemInterface
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = null;
  private final String jdField_a_of_type_JavaLangString = "AccountRecListItem";
  private boolean jdField_a_of_type_Boolean = false;
  
  public AccountRecListItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private PhoneContactManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    }
    return this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  }
  
  private void b(ResponseGetRecommendedListV2 paramResponseGetRecommendedListV2)
  {
    boolean bool2 = true;
    Object localObject1 = new RespondQueryQQBindingStat();
    Object localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramResponseGetRecommendedListV2 != null)
    {
      ((RespondQueryQQBindingStat)localObject1).mobileNo = paramResponseGetRecommendedListV2.mobileNo;
      ((RespondQueryQQBindingStat)localObject1).nationCode = paramResponseGetRecommendedListV2.nationCode;
      ((RespondQueryQQBindingStat)localObject1).lastUsedFlag = paramResponseGetRecommendedListV2.lastUsedFlag;
      ((RespondQueryQQBindingStat)localObject1).MobileUniqueNo = paramResponseGetRecommendedListV2.MobileUniqueNo;
      ((RespondQueryQQBindingStat)localObject1).originBinder = paramResponseGetRecommendedListV2.originBinder;
      ((RespondQueryQQBindingStat)localObject1).isRecommend = 1L;
      ((RespondQueryQQBindingStat)localObject1).type = paramResponseGetRecommendedListV2.type;
      ((PhoneContactManagerImp)localObject2).a(paramResponseGetRecommendedListV2.ConfigVersion, paramResponseGetRecommendedListV2.PopWindowsCount, paramResponseGetRecommendedListV2.PopWindowsTime, paramResponseGetRecommendedListV2.PopCloseCount, paramResponseGetRecommendedListV2.ForcePopSwitch);
    }
    ((PhoneContactManagerImp)localObject2).a((RespondQueryQQBindingStat)localObject1);
    localObject2 = new Bundle();
    if (((RespondQueryQQBindingStat)localObject1).mobileNo != null)
    {
      bool1 = true;
      ((Bundle)localObject2).putBoolean("bind_state", bool1);
      ((Bundle)localObject2).putBoolean("bind_strategy", true);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramResponseGetRecommendedListV2 == null) {
        break label186;
      }
    }
    label186:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQAppInterface)localObject1).notifyObservers(ContactBindObserver.class, 12, bool1, (Bundle)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountRecListItem", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 112;
    RequestHeader localRequestHeader = ContactBindServlet.a(0, 0, 0);
    localRequestHeader.cmd = 29;
    RequestGetRecommendedListV2 localRequestGetRecommendedListV2 = new RequestGetRecommendedListV2();
    localRequestGetRecommendedListV2.nextFlag = 0L;
    localRequestGetRecommendedListV2.sessionSid = new byte[0];
    localRequestGetRecommendedListV2.timeStamp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L);
    localRequestGetRecommendedListV2.type = 2;
    localRequestGetRecommendedListV2.PopVersion = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("contact_bind_strategy_version", 0L);
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("AccountServer");
    localUniPacket.setFuncName("AccountServerFunc");
    localUniPacket.put("RequestGetRecommendedListV2", localRequestGetRecommendedListV2);
    localUniPacket.put("RequestHeader", localRequestHeader);
    localReqItem.vecParam = localUniPacket.encode();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountRecListItem", 2, "handleCheckUpdateItemData respitem.cResult:" + paramRespItem.cResult);
    }
    Object localObject = null;
    MyBusinessManager localMyBusinessManager;
    int i;
    if (paramRespItem.cResult == 2)
    {
      localObject = new UniPacket();
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramRespItem.vecUpdate);
      if (((RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader())).result == 0)
      {
        paramRespItem = (ResponseGetRecommendedListV2)((UniPacket)localObject).getByClass("ResponseGetRecommendedListV2", new ResponseGetRecommendedListV2());
        b(paramRespItem);
        a(paramRespItem);
        localMyBusinessManager = (MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
        if (paramRespItem == null) {
          break label220;
        }
        localObject = paramRespItem.mobileNo;
        i = paramRespItem.type;
      }
    }
    for (paramRespItem = (RespItem)localObject;; paramRespItem = "")
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        localMyBusinessManager.a(paramRespItem, i, "");
        return;
        ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c();
        paramRespItem = null;
        break;
        ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c();
        paramRespItem = (RespItem)localObject;
        break;
      }
      localMyBusinessManager.b(paramRespItem, i, "");
      return;
      label220:
      i = 0;
    }
  }
  
  public void a(ResponseGetRecommendedListV2 paramResponseGetRecommendedListV2)
  {
    Object localObject = paramResponseGetRecommendedListV2.alreadyBindContacts;
    ArrayList localArrayList = paramResponseGetRecommendedListV2.circleInfo;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      a().b(localArrayList, paramResponseGetRecommendedListV2.timeStamp);
    }
    if ((localObject != null) && (((List)localObject).size() != 0)) {
      a().a((List)localObject, paramResponseGetRecommendedListV2.timeStamp);
    }
    if (paramResponseGetRecommendedListV2.nextFlag != 4294967295L)
    {
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
      ((NewIntent)localObject).putExtra("req_type", 29);
      ((NewIntent)localObject).putExtra("next_flag", paramResponseGetRecommendedListV2.nextFlag);
      ((NewIntent)localObject).putExtra("time_stamp", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L));
      ((NewIntent)localObject).putExtra("session_id", paramResponseGetRecommendedListV2.sessionSid);
      ((NewIntent)localObject).putExtra("recommend_type", 2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    ((SharedPreferences.Editor)localObject).putLong("getRecommendedTimeStamp", paramResponseGetRecommendedListV2.timeStamp);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new Bundle();
    if ((paramResponseGetRecommendedListV2.alreadyBindContacts != null) && (paramResponseGetRecommendedListV2.alreadyBindContacts.size() > 0)) {
      ((Bundle)localObject).putBoolean("hasUpdate", true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(ContactBindObserver.class, 29, true, (Bundle)localObject);
      return;
      ((Bundle)localObject).putBoolean("hasUpdate", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.AccountRecListItem
 * JD-Core Version:    0.7.0.1
 */