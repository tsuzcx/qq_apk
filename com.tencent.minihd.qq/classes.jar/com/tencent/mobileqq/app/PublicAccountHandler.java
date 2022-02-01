package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendLBSInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPreMessageStatusResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendRequest;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.pb.secmsg.SecMsgConfig.SecMsgConfigsRequest;
import com.tencent.pb.secmsg.SecMsgConfig.SecMsgConfigsResponse;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hna;
import hnb;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.FollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;

public class PublicAccountHandler
  extends BusinessHandler
{
  private static final int jdField_a_of_type_Int = 20;
  public static final String a = "Pb_account_lifeservice";
  private static final int jdField_b_of_type_Int = 1;
  public static final String b = "PubAccountSvc.ReportLbs";
  private static final int jdField_c_of_type_Int = 2;
  private static final String jdField_c_of_type_JavaLangString = PublicAccountHandler.class.getSimpleName();
  private static final int jdField_d_of_type_Int = 1;
  private static final String jdField_d_of_type_JavaLangString = "PublicAccount_TotalSwitch";
  private static final int jdField_e_of_type_Int = 2;
  private static final String jdField_e_of_type_JavaLangString = "PublicAccount_SearchSwitch";
  private static final int jdField_f_of_type_Int = 3;
  private static final String jdField_f_of_type_JavaLangString = "PublicAccountFollowSeq2";
  private static final String g = "PublicAccountDataSeq2";
  private static final String h = "time_stamp";
  private static final String i = "get_user_follow_list_begin";
  private static final String j = "get_user_follow_list_follow_seq";
  private static final String k = "get_user_follow_list_data_seq";
  private static final String l = "get_user_follow_list_is_increment";
  public List a;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean = true;
  
  PublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = null;
    String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_TotalSwitch");
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Boolean = Boolean.parseBoolean(str);
      label37:
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_SearchSwitch");
      if (paramQQAppInterface != null) {}
      try
      {
        this.b = Boolean.parseBoolean(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
  
  private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_follow_list");
    mobileqq_mp.GetUserFollowListRequest localGetUserFollowListRequest = new mobileqq_mp.GetUserFollowListRequest();
    localGetUserFollowListRequest.follow_seqno.set(Utils.a(paramLong1));
    localGetUserFollowListRequest.public_account_seqno.set(Utils.a(paramLong2));
    localGetUserFollowListRequest.begin.set(Utils.a(paramLong3));
    localGetUserFollowListRequest.limit.set(Utils.a(paramLong4));
    localGetUserFollowListRequest.version.set(1);
    localGetUserFollowListRequest.is_increment.set(paramBoolean);
    localNewIntent.putExtra("data", localGetUserFollowListRequest.toByteArray());
    localNewIntent.putExtra("get_user_follow_list_begin", paramLong3);
    localNewIntent.putExtra("get_user_follow_list_follow_seq", paramLong1);
    localNewIntent.putExtra("get_user_follow_list_data_seq", paramLong2);
    localNewIntent.putExtra("time_stamp", paramLong5);
    localNewIntent.putExtra("get_user_follow_list_is_increment", paramBoolean);
    PublicAccountServlet.a(localNewIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    return 0;
  }
  
  private long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountFollowSeq2", 0L);
  }
  
  private void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountFollowSeq2", paramLong);
    localEditor.commit();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, paramString5, "", "");
  }
  
  private void a(List paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54)).a(paramList, paramLong, paramBoolean1, paramBoolean2);
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject1 = ((List)localObject1).iterator();
    int m = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
      localObject2 = paramList.a().b(((PublicAccountInfo)localObject2).getUin(), 1008);
      if (localObject2 == null) {
        break label131;
      }
      paramList.a().b((RecentUser)localObject2);
      m = 1;
    }
    label131:
    for (;;)
    {
      break;
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if ((m != 0) && (paramList != null)) {
        paramList.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  private void a(SubMsgType0x28.RspFollowList paramRspFollowList)
  {
    paramRspFollowList = paramRspFollowList.rpt_msg_followlist.get();
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramRspFollowList = paramRspFollowList.iterator();
    int m = 0;
    Object localObject2;
    Object localObject1;
    if (paramRspFollowList.hasNext())
    {
      localObject2 = (SubMsgType0x28.FollowList)paramRspFollowList.next();
      if (l1 == ((SubMsgType0x28.FollowList)localObject2).uint64_uin.get())
      {
        localObject1 = String.valueOf(((SubMsgType0x28.FollowList)localObject2).uint64_puin.get());
        switch (((SubMsgType0x28.FollowList)localObject2).uint32_type.get())
        {
        }
      }
    }
    for (;;)
    {
      break;
      localObject2 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
      ((PublicAccountDataManager)localObject2).a((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 1008);
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject2).a());
      PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject2).a());
      localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
      if (localObject1 != null)
      {
        ((EcShopAssistantManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject2).a());
        m = 1;
        continue;
        a();
        continue;
        if (m != 0) {
          a(103, true, null);
        }
      }
      else
      {
        m = 1;
      }
    }
  }
  
  private void a(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountDataSeq2", 0L);
  }
  
  private void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountDataSeq2", paramLong);
    localEditor.commit();
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      paramIntent = new SecMsgConfig.SecMsgConfigsResponse();
    }
    for (;;)
    {
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if (paramIntent.int32_ret.get() == 0)
        {
          int m = paramIntent.int32_show_in_palist.get();
          paramFromServiceMsg = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if (m != 1) {
            continue;
          }
          bool = true;
          paramFromServiceMsg.a(bool);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "secmsg.configs ret=" + paramIntent.int32_ret.get() + ",flag=" + paramIntent.int32_show_in_palist.get());
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        boolean bool;
        continue;
      }
      a(103, true, null);
      return;
      bool = false;
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      int m;
      try
      {
        paramIntent = new publicaccount_recommend.BusinessRecommendResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label186;
        }
        m = ((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.get();
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "handleGetRecommendList(): package size is " + paramArrayOfByte.length + " Byte");
      }
      if (paramIntent.business.has())
      {
        paramIntent = PublicRecommendAccountInfo.createPublicRecommendAccountInfoList(paramIntent.business.get());
        ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54)).a(paramIntent);
        a(104, true, null);
        return;
        a(104, false, null);
        return;
      }
      while (m != 0)
      {
        return;
        label186:
        m = -1;
      }
    }
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    hnb localhnb = new hnb();
    int n = 1;
    boolean bool2 = false;
    int m;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 2901) && (paramIntent != null))
    {
      m = paramIntent.getIntExtra("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "handleGetUserFollowListk_resend_cnt" + m);
      }
      if (m < 2)
      {
        paramIntent.putExtra("k_resend_cnt", m + 1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)paramIntent);
        return;
      }
    }
    long l1;
    long l2;
    long l3;
    long l4;
    boolean bool1;
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null))
    {
      localhnb.jdField_a_of_type_Int = 0;
      l1 = paramIntent.getLongExtra("time_stamp", 0L);
      l2 = paramIntent.getLongExtra("get_user_follow_list_begin", 0L);
      l3 = paramIntent.getLongExtra("get_user_follow_list_follow_seq", 0L);
      l4 = paramIntent.getLongExtra("get_user_follow_list_data_seq", 0L);
      bool2 = paramIntent.getBooleanExtra("get_user_follow_list_is_increment", true);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "handleGetUserFollowListtiem: " + l1 + "begin: " + l2 + "preFollowSeq: " + l3 + "preDataSeq: " + l4);
      }
      for (;;)
      {
        try
        {
          paramIntent = new mobileqq_mp.GetUserFollowListResponse();
          paramIntent.mergeFrom(paramArrayOfByte);
          if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
            continue;
          }
          m = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
          localhnb.jdField_a_of_type_Int = m;
          if (m == 0) {
            continue;
          }
          localhnb.jdField_a_of_type_Boolean = true;
          bool1 = false;
          m = 1;
        }
        catch (Exception paramIntent)
        {
          label370:
          long l5;
          label396:
          label463:
          localhnb.jdField_a_of_type_Int = -1;
          localhnb.jdField_a_of_type_Boolean = true;
          bool1 = false;
          m = 1;
          continue;
          a(l4);
          continue;
        }
        if (m == 0) {
          break;
        }
        a(100, bool1, localhnb);
        return;
        m = 0;
        continue;
        if (!paramIntent.follow_seqno.has()) {
          break label785;
        }
        m = paramIntent.follow_seqno.get();
        l4 = Utils.a(m);
        if (!paramIntent.public_account_seqno.has()) {
          break label791;
        }
        m = paramIntent.public_account_seqno.get();
        l5 = Utils.a(m);
        if ((l4 > l3) && (l3 != 0L))
        {
          a(l4, l5, 0L, 20L, SystemClock.uptimeMillis(), false);
          m = 0;
          bool1 = false;
        }
        else
        {
          if (!paramIntent.total_count.has()) {
            break label803;
          }
          m = paramIntent.total_count.get();
          l3 = Utils.a(m);
          paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoList(paramIntent.info.get(), l1);
          localhnb.jdField_a_of_type_JavaUtilList = paramFromServiceMsg;
          if (!paramIntent.has_next.has()) {
            break label797;
          }
          if (paramIntent.has_next.get()) {
            break label809;
          }
          break label797;
        }
      }
    }
    for (;;)
    {
      localhnb.jdField_a_of_type_Boolean = bool1;
      localhnb.jdField_a_of_type_Long = l3;
      paramIntent = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
      a(paramFromServiceMsg, l1, bool2, localhnb.jdField_a_of_type_Boolean);
      if (localhnb.jdField_a_of_type_Boolean)
      {
        PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.a());
        TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.a());
        paramFromServiceMsg = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.a());
        }
      }
      if (!localhnb.jdField_a_of_type_Boolean)
      {
        if (bool2) {
          a(l4, l5, 0L, 20L, l1, true);
        }
        for (;;)
        {
          b(l5);
          bool1 = true;
          m = 1;
          break;
          a(l4, l5, l2 + 20L, 20L, l1, false);
        }
      }
      localhnb.jdField_a_of_type_Int = -1;
      localhnb.jdField_a_of_type_Boolean = true;
      bool1 = bool2;
      m = n;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_c_of_type_JavaLangString, 2, "<<---handleGetUserFollowList " + localhnb.jdField_a_of_type_Int);
      bool1 = bool2;
      m = n;
      break;
      label785:
      m = 0;
      break label370;
      label791:
      m = 0;
      break label396;
      label797:
      bool1 = true;
      continue;
      label803:
      m = 0;
      break label463;
      label809:
      bool1 = false;
    }
  }
  
  public int a()
  {
    long l1 = a();
    long l2 = b();
    long l3 = SystemClock.uptimeMillis();
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(l3);
    }
    return a(l1, l2, 0L, 20L, l3, true);
  }
  
  public int a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_business_recommend");
    publicaccount_recommend.BusinessRecommendRequest localBusinessRecommendRequest = new publicaccount_recommend.BusinessRecommendRequest();
    localBusinessRecommendRequest.recomend_count.set(20);
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null) || (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString == null)) {
        break label232;
      }
    }
    label232:
    for (String str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "getRecommendList() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.jdField_b_of_type_Double + ", address=" + str);
      }
      localBusinessRecommendRequest.latitude.set(String.valueOf(paramSosoLbsInfo.a.a));
      localBusinessRecommendRequest.longitude.set(String.valueOf(paramSosoLbsInfo.a.jdField_b_of_type_Double));
      localBusinessRecommendRequest.city_info.set(str);
      localBusinessRecommendRequest.platform.set(109);
      localNewIntent.putExtra("data", localBusinessRecommendRequest.toByteArray());
      PublicAccountServlet.a(localNewIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return 0;
    }
  }
  
  protected Class a()
  {
    return PublicAccountObserver.class;
  }
  
  public void a()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "secmsg.configs");
    localNewIntent.putExtra("data", new SecMsgConfig.SecMsgConfigsRequest().toByteArray());
    PublicAccountServlet.a(localNewIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  /* Error */
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: lload_1
    //   1: l2i
    //   2: lookupswitch	default:+26->28, 40:+27->29, 63:+93->95
    //   29: new 613	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   32: dup
    //   33: invokespecial 614	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 615	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: checkcast 613	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   43: astore_3
    //   44: aload_3
    //   45: getfield 618	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   48: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   51: istore 4
    //   53: iload 4
    //   55: iconst_1
    //   56: if_icmpne +18 -> 74
    //   59: aload_0
    //   60: aload_3
    //   61: getfield 622	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_followlist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;
    //   64: invokevirtual 623	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 277	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList
    //   70: invokespecial 625	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;)V
    //   73: return
    //   74: iload 4
    //   76: iconst_2
    //   77: if_icmpne -49 -> 28
    //   80: aload_0
    //   81: aload_3
    //   82: getfield 629	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_typelist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;
    //   85: invokevirtual 632	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   88: checkcast 631	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList
    //   91: invokespecial 634	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;)V
    //   94: return
    //   95: new 636	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody
    //   98: dup
    //   99: invokespecial 637	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:<init>	()V
    //   102: astore 7
    //   104: aload 7
    //   106: aload_3
    //   107: invokevirtual 638	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: pop
    //   111: aload 7
    //   113: getfield 641	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:rpt_msg_pubunikey	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: invokevirtual 287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   119: invokeinterface 236 1 0
    //   124: astore_3
    //   125: aload_3
    //   126: invokeinterface 241 1 0
    //   131: ifeq -103 -> 28
    //   134: aload_3
    //   135: invokeinterface 245 1 0
    //   140: checkcast 643	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey
    //   143: astore 7
    //   145: aload 7
    //   147: getfield 646	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_fromPubUin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   150: invokevirtual 305	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   153: lstore_1
    //   154: aload 7
    //   156: getfield 649	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_qwMsgId	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: invokevirtual 305	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   162: lstore 5
    //   164: lload_1
    //   165: invokestatic 651	java/lang/Long:toString	(J)Ljava/lang/String;
    //   168: astore 7
    //   170: aload_0
    //   171: getfield 94	com/tencent/mobileqq/app/PublicAccountHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   174: invokevirtual 326	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   177: aload 7
    //   179: sipush 1008
    //   182: aconst_null
    //   183: invokevirtual 654	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I[I)Ljava/util/List;
    //   186: invokeinterface 236 1 0
    //   191: astore 8
    //   193: aload 8
    //   195: invokeinterface 241 1 0
    //   200: ifeq -75 -> 125
    //   203: aload 8
    //   205: invokeinterface 245 1 0
    //   210: checkcast 656	com/tencent/mobileqq/data/MessageRecord
    //   213: astore 9
    //   215: aload 9
    //   217: invokestatic 661	com/tencent/mobileqq/activity/aio/XMLMessageUtils:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/PAMessage;
    //   220: astore 10
    //   222: aload 10
    //   224: ifnull -31 -> 193
    //   227: aload 10
    //   229: getfield 666	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   232: lload 5
    //   234: lcmp
    //   235: ifne -42 -> 193
    //   238: aload_0
    //   239: getfield 94	com/tencent/mobileqq/app/PublicAccountHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   242: invokevirtual 326	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   245: aload 7
    //   247: sipush 1008
    //   250: aload 9
    //   252: getfield 669	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   255: invokevirtual 672	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)V
    //   258: goto -133 -> 125
    //   261: astore_3
    //   262: return
    //   263: astore_3
    //   264: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	PublicAccountHandler
    //   0	265	1	paramLong	long
    //   0	265	3	paramArrayOfByte	byte[]
    //   51	27	4	m	int
    //   162	71	5	l1	long
    //   102	144	7	localObject	Object
    //   191	13	8	localIterator	Iterator
    //   213	38	9	localMessageRecord	com.tencent.mobileqq.data.MessageRecord
    //   220	8	10	localPAMessage	com.tencent.mobileqq.data.PAMessage
    // Exception table:
    //   from	to	target	type
    //   95	125	261	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   125	193	261	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   193	222	261	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	258	261	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   29	53	263	java/lang/Exception
    //   59	73	263	java/lang/Exception
    //   80	94	263	java/lang/Exception
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    paramObject = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "<<---onReceive " + str);
    }
    if (str.equals("get_follow_list")) {
      d(paramIntent, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (str.equals("secmsg.configs"))
      {
        b(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equals("get_business_recommend"))
      {
        c(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!str.equals("send_pre_message_status"));
    a(paramIntent, paramFromServiceMsg, paramObject);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramIntent = new mobileqq_mp.SendPreMessageStatusResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label180;
        }
        m = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
        if (m != 0)
        {
          if (!QLog.isColorLevel()) {
            break label179;
          }
          QLog.d(jdField_c_of_type_JavaLangString, 2, "handlePreSendMsg error, errcode: " + m);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label179;
        }
        QLog.d(jdField_c_of_type_JavaLangString, 2, "handlePreSendMsg success: package size is " + paramArrayOfByte.length + " Byte");
        return;
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "handlePreSendMsg  failed!");
      }
      label179:
      return;
      label180:
      int m = -1;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {}
    while ((!"PubAccountSvc.ReportLbs".equalsIgnoreCase(paramToServiceMsg)) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    hna localhna = new hna();
    localhna.jdField_a_of_type_Int = 0;
    long l1 = SystemClock.uptimeMillis();
    if ((paramObject instanceof AccountDetail)) {
      localhna.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l1);
    }
    for (;;)
    {
      paramObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
      paramObject.a(localhna.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
      if (localEcShopAssistantManager != null) {
        localEcShopAssistantManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      }
      a(101, true, localhna);
      return;
      if ((paramObject instanceof EqqDetail)) {
        localhna.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l1);
      }
    }
  }
  
  public void a(String paramString1, double paramDouble1, double paramDouble2, String paramString2)
  {
    try
    {
      long l1 = Long.valueOf(paramString1).longValue();
      paramString1 = new mobileqq_mp.SendLBSInfoRequest();
      paramString1.luin.set(l1);
      paramString1.latitude.set(paramDouble1);
      paramString1.longitude.set(paramDouble2);
      paramString1.cityinfo.set(paramString2);
      paramString2 = a("PubAccountSvc.ReportLbs");
      paramString2.putWupBuffer(paramString1.toByteArray());
      b(paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    a(103, true, null);
  }
  
  public void b(Object paramObject)
  {
    hna localhna = new hna();
    localhna.jdField_a_of_type_Int = 0;
    long l1 = SystemClock.uptimeMillis();
    if ((paramObject instanceof AccountDetail)) {
      localhna.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l1);
    }
    for (;;)
    {
      paramObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
      paramObject.b(localhna.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83);
      if (localEcShopAssistantManager != null) {
        localEcShopAssistantManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      }
      a(102, true, localhna);
      return;
      if ((paramObject instanceof EqqDetail)) {
        localhna.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l1);
      }
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    b(0L);
    a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */