package com.tencent.mobileqq.app;

import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import KQQ.SetUserInfoResp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.CommonCard;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.MakeFriendsCard;
import QQService.PushVoteIncreaseInfo;
import QQService.RespAddFace;
import QQService.RespCommonCard;
import QQService.RespDelFace;
import QQService.RespFaceInfo;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetFavoriteList;
import QQService.RespGetVisitorList;
import QQService.RespGetVoterList;
import QQService.RespHYCommonCard;
import QQService.RespHYMakeFriendsCard;
import QQService.RespMakeFriendsCard;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespUpdateQQFace;
import QQService.RespVote;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.RespVoiceManage;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DateEventManager;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hgy;
import hgz;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CardHandler
  extends BusinessHandler
{
  public static final int A = 29;
  public static final String A = "key_new_nickname";
  public static final int B = 30;
  public static final String B = "key_marital_status";
  public static final int C = 31;
  public static final String C = "key_qzone_switch";
  public static final int D = 32;
  public static final String D = "key_hobby_switch";
  public static final int E = 33;
  public static final String E = "key_new_profile_modified_flag";
  public static final int F = 34;
  public static final String F = "key_is_nearby_people_card";
  public static final int G = 35;
  public static final String G = "key_interest_switch";
  public static final int H = 36;
  public static final String H = "key_music_switch";
  public static final int I = 37;
  public static final String I = "key_recent_activity_switch";
  public static final int J = 38;
  public static final String J = "key_star_switch";
  public static final int K = 39;
  public static final String K = "key_joined_group_switch";
  public static final int L = 40;
  public static final String L = "key_ktv_switch";
  public static final int M = 41;
  public static final String M = "key_eat_switch";
  public static final int N = 42;
  public static final int O = 43;
  public static final int P = 44;
  public static final int Q = 45;
  public static final int R = 46;
  public static final int S = 47;
  public static final int T = 48;
  public static final int U = 49;
  public static final int V = 50;
  public static final int W = 51;
  public static final int X = 52;
  public static final int Y = 53;
  public static final int Z = 54;
  public static final int a = 0;
  public static final String a;
  public static final Vector a;
  static final boolean jdField_a_of_type_Boolean = true;
  public static final int aa = 55;
  public static final int ab = 56;
  public static final int ac = 57;
  public static final int ad = 58;
  public static final int ae = 59;
  public static final int af = 0;
  public static final int ag = 60;
  public static final int ah = 100;
  public static final int ai = 160;
  public static final int aj = 640;
  public static final int ak = 960;
  public static final int al = 120;
  public static final int am = 1000277;
  public static final int b = 1;
  public static final String b = "background";
  public static final Vector b;
  public static final int c = 2;
  public static final String c = "temp";
  public static final int d = 3;
  public static final String d = "HDAvatar";
  public static final int e = 5;
  public static final String e = "voice";
  public static final int f = 6;
  public static final String f = ";";
  public static final int g = 7;
  public static final String g = "_TIMESTAMP";
  public static final int h = 8;
  public static final String h = "_TEMP_COVER_FILEKEY";
  public static final int i = 9;
  public static final String i = "com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive";
  public static final int j = 10;
  public static final String j = "com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive";
  public static final int k = 11;
  public static final String k = "nick";
  public static final int l = 12;
  public static final String l = "sex";
  public static final int m = 13;
  public static final String m = "birthday";
  public static final int n = 16;
  public static final String n = "age";
  public static final int o = 17;
  public static final String o = "key_constellation";
  public static final int p = 19;
  public static final String p = "profession";
  public static final int q = 20;
  public static final String q = "company";
  public static final int r = 20;
  public static final String r = "college";
  public static final int s = 21;
  public static final String s = "location";
  public static final int t = 22;
  public static final String t = "locationo_desc";
  public static final int u = 23;
  public static final String u = "location_name";
  public static final int v = 24;
  public static final String v = "hometown";
  public static final int w = 25;
  public static final String w = "hometown_desc";
  public static final int x = 26;
  public static final String x = "email";
  public static final int y = 27;
  public static final String y = "personalNote";
  public static final int z = 28;
  public static final String z = "key_xuan_yan";
  short jdField_a_of_type_Short = 9;
  short b;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aG + "portrait/";
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  CardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Short = -25044;
    if (jdField_a_of_type_JavaUtilVector.size() == 0)
    {
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
    }
    if (jdField_b_of_type_JavaUtilVector.size() == 0)
    {
      jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(960));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(120));
    }
  }
  
  protected static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i1 = paramContext.widthPixels;
    int i2 = paramContext.heightPixels;
    if (i1 > i2) {
      return i1;
    }
    return i2;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0).getString(paramString + "_TEMP_COVER_FILEKEY", null);
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      return "";
    }
    return jdField_a_of_type_JavaLangString + paramInt + "/" + paramString + ".jpg";
  }
  
  public static String a(List paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.clear();
    if (paramList.size() > 0)
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        localLinkedList.add(HexUtil.a(((FaceInfo)paramList.get(i1)).vFaceID));
        i1 += 1;
      }
      return b(localLinkedList);
    }
    return ";";
  }
  
  public static LinkedList a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i1 = 0;
      while (i1 < paramString.length)
      {
        if ((paramString[i1] != null) && (!"".equals(paramString[i1]))) {
          localLinkedList.add(paramString[i1]);
        }
        i1 += 1;
      }
    }
    return localLinkedList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, "_TEMP_COVER_FILEKEY", paramString2);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ((paramString3 == null) || ("".equals(paramString3))) {
      paramContext.remove(paramString1 + paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + paramString2, paramString3);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = (RespVote)paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
    paramBundle.putString("targetUin", paramFromServiceMsg);
    paramBundle.putString("selfUin", paramToServiceMsg);
    if ((paramObject != null) && (((RespVote)paramObject).stHeader.iReplyCode == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (!TextUtils.isEmpty(paramFromServiceMsg)))
      {
        paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
        }
      }
      a(5, bool, paramBundle);
      return;
    }
  }
  
  public static void a(String paramString, List paramList) {}
  
  private void a(List paramList, Bundle paramBundle)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramList.size() * 2 + 7);
    localByteBuffer.putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localByteBuffer.put((byte)0);
    localByteBuffer.putShort((short)paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localByteBuffer.putShort(((Short)paramList.next()).shortValue());
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramList = a("OidbSvc.0x480_9");
    paramList.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBundle != null) {
      paramList.extraData.putAll(paramBundle);
    }
    paramList.extraData.putBoolean("reqFromCardHandler", true);
    b(paramList);
  }
  
  public static int b(Context paramContext)
  {
    return 640;
  }
  
  public static String b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuffer.append((String)paramList.get(i1));
      if (i1 < i2 - 1) {
        localStringBuffer.append(";");
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l1 = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = bool2;
        bool2 = false;
        continue;
      }
      if (!bool2) {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
      }
      a(38, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject = paramFromServiceMsg.getAttribute("result");
    paramObject = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    paramBundle.putString("targetUin", Long.toString(l1));
    paramBundle.putString("selfUin", Long.toString(l2));
    if ((localObject != null) && ((localObject instanceof RespFavorite)))
    {
      paramFromServiceMsg = (RespFavorite)localObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramObject.put("param_FailCode", "0");
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramObject, "", false);
        bool2 = paramToServiceMsg.extraData.getBoolean("nearby_people");
        if (!bool1) {
          break label509;
        }
        if ((l1 > 0L) && (bool2))
        {
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          paramFromServiceMsg = (NearbyPeopleCard)paramToServiceMsg.a(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg.likeCount += 1;
            paramFromServiceMsg.bVoted = 1;
            paramToServiceMsg.a(paramFromServiceMsg);
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1);
      }
      a(32, bool1, paramBundle);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramFromServiceMsg.stHeader.iReplyCode);
      }
      paramObject.put("param_FailCode", String.valueOf(paramFromServiceMsg.stHeader.iReplyCode));
      break;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
        if (localObject != null)
        {
          paramFromServiceMsg = "not RespFavorite";
          label425:
          QLog.i("Q.profilecard.", 2, paramFromServiceMsg);
        }
      }
      else
      {
        if (localObject == null) {
          break label502;
        }
      }
      label502:
      for (paramFromServiceMsg = "-201";; paramFromServiceMsg = "-202")
      {
        paramObject.put("param_FailCode", paramFromServiceMsg);
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramObject, "", false);
        bool1 = bool2;
        break;
        paramFromServiceMsg = "null";
        break label425;
      }
      label509:
      if ((l1 > 0L) && (!bool2))
      {
        paramToServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg = paramToServiceMsg.a(String.valueOf(l1));
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.", 2, "reqFavorite fail, revertdata | lVoteCount = " + paramFromServiceMsg.lVoteCount);
          }
        }
      }
    }
  }
  
  public static int c(Context paramContext)
  {
    int i1 = a(paramContext);
    if (i1 <= 240) {
      return 60;
    }
    if (i1 <= 320) {
      return 100;
    }
    return 160;
  }
  
  public static void c()
  {
    int i3 = 0;
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!((File)localObject).exists()) {}
    try
    {
      bool1 = ((File)localObject).mkdirs();
      if (bool1)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add("background");
        ((ArrayList)localObject).add("temp");
        ((ArrayList)localObject).add("HDAvatar");
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= jdField_a_of_type_JavaUtilVector.size()) {
            break;
          }
          ((ArrayList)localObject).add(String.valueOf(((Integer)jdField_a_of_type_JavaUtilVector.get(i1)).intValue()));
          i1 += 1;
        }
        if (i2 < ((ArrayList)localObject).size())
        {
          localFile = new File(jdField_a_of_type_JavaLangString + "/" + (String)((ArrayList)localObject).get(i2));
          if (localFile.exists()) {}
        }
      }
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        for (;;)
        {
          int i2;
          File localFile;
          localFile.mkdir();
          label180:
          i2 += 1;
        }
        localSecurityException1 = localSecurityException1;
        bool1 = bool2;
      }
      catch (SecurityException localSecurityException2)
      {
        break label180;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_searchable", true);
      if (!bool1) {
        break label148;
      }
    }
    label148:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
        a(39, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = b();
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(42, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vFavoriteInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        if (QLog.isDevelopLevel()) {
          QLog.d("favolist", 4, "bConstellation=" + localUserProfile.bConstellation + " vipInfo=" + localUserProfile.stVipInfo + " richSign=" + localUserProfile.vRichSign);
        }
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.setType(3);
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      b(paramToServiceMsg.getUin(), localArrayList);
      new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
      a(42, true, new Object[] { paramObject, paramBundle, localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(42, false, new Object[] { paramToServiceMsg, paramBundle, b() });
  }
  
  private void c(String paramString, List paramList)
  {
    b(paramString, paramList);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    Object localObject3;
    Object localObject1;
    NearbyPeopleCard localNearbyPeopleCard;
    boolean bool3;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      i2 = -1000;
      localFriendsManager = null;
      localObject3 = null;
      localObject1 = null;
      localObject4 = null;
      localNearbyPeopleCard = null;
      paramFromServiceMsg = null;
      bool3 = paramToServiceMsg.extraData.getBoolean("key_is_nearby_people_card", false);
      bool2 = bool1;
      i1 = i2;
      if (bool1) {
        i1 = i2;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null) {
        break label733;
      }
      i1 = i2;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label733;
      }
      i1 = i2;
      i2 = paramFromServiceMsg.uint32_result.get();
      if (i2 != 0) {
        break label727;
      }
      bool1 = true;
      label128:
      i1 = i2;
      if (!QLog.isColorLevel()) {
        break label1857;
      }
      i1 = i2;
      QLog.d("CardHandler", 2, "handleSetDetailInfo, ret = " + i2 + ", isNearbyPeopleCard = " + bool3);
      i1 = i2;
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        label185:
        label638:
        paramToServiceMsg = (ToServiceMsg)localObject4;
        label671:
        label727:
        label733:
        label750:
        label756:
        paramObject = localFriendsManager;
        label813:
        continue;
        label1793:
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        continue;
        i1 = i2;
      }
    }
    if (i1 == 0)
    {
      if (bool3)
      {
        localObject1 = localNearbyPeopleCard;
        paramObject = localObject3;
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
            localObject1 = localNearbyPeopleCard;
            paramObject = localObject3;
            paramFromServiceMsg = (NearbyPeopleCard)((EntityManager)localObject4).a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() });
            if (paramFromServiceMsg != null) {
              continue;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            Object localObject2;
            paramToServiceMsg = localObject2;
            continue;
            continue;
          }
          try
          {
            for (;;)
            {
              localNearbyPeopleCard = new NearbyPeopleCard();
              localObject1 = localNearbyPeopleCard;
              paramObject = localObject3;
              localNearbyPeopleCard.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              paramFromServiceMsg = localNearbyPeopleCard;
              try
              {
                if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
                  paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
                }
                if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
                  paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
                }
                if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
                  paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
                }
                if (paramToServiceMsg.extraData.containsKey("sex"))
                {
                  paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
                  paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
                  if (paramObject != null) {
                    paramObject.b(paramFromServiceMsg.gender);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("birthday"))
                {
                  paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
                  paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
                  paramFromServiceMsg.constellation = paramToServiceMsg.extraData.getByte("key_constellation");
                  paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
                  if (paramObject != null) {
                    paramObject.a(paramFromServiceMsg.age);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("profession")) {
                  paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
                }
                if (paramToServiceMsg.extraData.containsKey("company")) {
                  paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
                }
                if (paramToServiceMsg.extraData.containsKey("college")) {
                  paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
                }
                if (paramToServiceMsg.extraData.containsKey("hometown"))
                {
                  paramObject = paramToServiceMsg.extraData.getStringArray("hometown");
                  paramFromServiceMsg.hometownCountry = paramObject[0];
                  paramFromServiceMsg.hometownProvice = paramObject[1];
                  paramFromServiceMsg.hometownCity = paramObject[2];
                  paramFromServiceMsg.hometownDistrict = paramObject[3];
                }
                if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
                {
                  if (paramToServiceMsg.extraData.getShort("key_qzone_switch") == 0)
                  {
                    bool2 = true;
                    paramFromServiceMsg.switchQzone = bool2;
                  }
                }
                else
                {
                  if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
                  {
                    if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                      break label750;
                    }
                    bool2 = true;
                    paramFromServiceMsg.switchHobby = bool2;
                  }
                  if (paramFromServiceMsg.getStatus() != 1000) {
                    break label756;
                  }
                  ((EntityManager)localObject4).b(paramFromServiceMsg);
                }
                for (;;)
                {
                  paramToServiceMsg = paramFromServiceMsg;
                  paramFromServiceMsg = null;
                  localObject1 = paramFromServiceMsg;
                  paramFromServiceMsg = paramToServiceMsg;
                  bool2 = bool1;
                  if (!bool3) {
                    break label1793;
                  }
                  a(49, bool2, paramFromServiceMsg);
                  return;
                  bool1 = false;
                  break;
                  bool1 = false;
                  break label128;
                  bool1 = false;
                  i1 = -1000;
                  break label185;
                  bool2 = false;
                  break label638;
                  bool2 = false;
                  break label671;
                  if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
                    ((EntityManager)localObject4).a(paramFromServiceMsg);
                  }
                }
                if (!QLog.isColorLevel()) {
                  break label813;
                }
              }
              catch (Exception localException)
              {
                paramToServiceMsg = paramFromServiceMsg;
                paramObject = localFriendsManager;
                paramFromServiceMsg = localException;
              }
            }
          }
          catch (Exception paramObject)
          {
            paramToServiceMsg = paramFromServiceMsg;
            paramFromServiceMsg = paramObject;
            paramObject = localFriendsManager;
          }
        }
        QLog.d("CardHandler", 2, "handleGetDetailInfo", paramFromServiceMsg);
        bool2 = false;
        paramFromServiceMsg = paramToServiceMsg;
        localObject2 = paramObject;
        continue;
        localObject2 = localNearbyPeopleCard;
        paramObject = localObject3;
        localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        localObject2 = localNearbyPeopleCard;
        paramObject = localObject3;
        paramFromServiceMsg = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("nick"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strNick = paramToServiceMsg.extraData.getString("nick");
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFromServiceMsg.strNick);
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("sex"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.shGender = ((short)paramToServiceMsg.extraData.getByte("sex"));
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localObject3 = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          if (localObject3 != null)
          {
            localObject2 = localNearbyPeopleCard;
            paramObject = paramFromServiceMsg;
            ((DatingManager)localObject3).b(paramFromServiceMsg.shGender);
          }
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("birthday"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.lBirthday = paramToServiceMsg.extraData.getInt("birthday");
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.age = ((byte)paramToServiceMsg.extraData.getInt("age"));
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.constellation = paramToServiceMsg.extraData.getInt("key_constellation");
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localObject3 = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          if (localObject3 != null)
          {
            localObject2 = localNearbyPeopleCard;
            paramObject = paramFromServiceMsg;
            ((DatingManager)localObject3).a(paramFromServiceMsg.age);
          }
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("profession"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.iProfession = paramToServiceMsg.extraData.getInt("profession");
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("company"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strCompany = paramToServiceMsg.extraData.getString("company");
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("college"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strSchool = paramToServiceMsg.extraData.getString("college");
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("location"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localObject3 = paramToServiceMsg.extraData.getStringArray("location");
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localObject4 = new StringBuilder();
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          ((StringBuilder)localObject4).append(localObject3[0]).append("-").append(localObject3[1]).append("-").append(localObject3[2]).append("-").append(localObject3[3]);
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strLocationCodes = ((StringBuilder)localObject4).toString();
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strLocationDesc = paramToServiceMsg.extraData.getString("locationo_desc");
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localObject3 = paramToServiceMsg.extraData.getStringArray("location_name");
          if (localObject3 != null)
          {
            localObject2 = localNearbyPeopleCard;
            paramObject = paramFromServiceMsg;
            if (localObject3.length == 4)
            {
              localObject2 = localNearbyPeopleCard;
              paramObject = paramFromServiceMsg;
              if (QLog.isColorLevel())
              {
                localObject2 = localNearbyPeopleCard;
                paramObject = paramFromServiceMsg;
                localObject4 = new StringBuilder("nameArray: ");
                i2 = 0;
                if (i2 < 4)
                {
                  localObject2 = localNearbyPeopleCard;
                  paramObject = paramFromServiceMsg;
                  ((StringBuilder)localObject4).append(localObject3[i2]).append(" ");
                  i2 += 1;
                  continue;
                }
                localObject2 = localNearbyPeopleCard;
                paramObject = paramFromServiceMsg;
                QLog.d("CardHandler", 2, ((StringBuilder)localObject4).toString());
              }
              localObject2 = localNearbyPeopleCard;
              paramObject = paramFromServiceMsg;
              paramFromServiceMsg.strCountry = localObject3[0];
              localObject2 = localNearbyPeopleCard;
              paramObject = paramFromServiceMsg;
              paramFromServiceMsg.strProvince = localObject3[1];
              localObject2 = localNearbyPeopleCard;
              paramObject = paramFromServiceMsg;
              paramFromServiceMsg.strCity = localObject3[2];
            }
          }
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("hometown"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localObject3 = paramToServiceMsg.extraData.getStringArray("hometown");
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          localObject4 = new StringBuilder();
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          ((StringBuilder)localObject4).append(localObject3[0]).append("-").append(localObject3[1]).append("-").append(localObject3[2]).append("-").append(localObject3[3]);
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strHometownCodes = ((StringBuilder)localObject4).toString();
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strHometownDesc = paramToServiceMsg.extraData.getString("hometown_desc");
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("email"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strEmail = paramToServiceMsg.extraData.getString("email");
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        if (paramToServiceMsg.extraData.containsKey("personalNote"))
        {
          localObject2 = localNearbyPeopleCard;
          paramObject = paramFromServiceMsg;
          paramFromServiceMsg.strPersonalNote = paramToServiceMsg.extraData.getString("personalNote");
        }
        localObject2 = localNearbyPeopleCard;
        paramObject = paramFromServiceMsg;
        localFriendsManager.a(paramFromServiceMsg);
        paramToServiceMsg = null;
      }
      a(31, bool2, new Object[] { Integer.valueOf(i1), localObject2 });
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a();
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(6, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vVoterInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.setType(2);
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      d(paramToServiceMsg.getUin(), localArrayList);
      new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
      a(6, true, new Object[] { paramObject, paramBundle, localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(6, false, new Object[] { paramToServiceMsg, paramBundle, a() });
  }
  
  private void d(String paramString, List paramList)
  {
    b(paramString, paramList);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    int i1;
    int i2;
    int i3;
    label215:
    int i4;
    int i6;
    label464:
    Object localObject7;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    boolean bool2;
    label805:
    int i7;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      if (bool1)
      {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
            break label4037;
          }
          localLong = Long.valueOf(localByteBuffer.getInt());
          localByteBuffer.get();
          int i5 = localByteBuffer.getShort();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetDetailInfo, request success, tlvCount = " + i5);
          }
          localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
          localCard = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramFromServiceMsg = "0";
          paramObject = "0";
          localObject1 = "0";
          localObject2 = "0";
          localObject3 = "0";
          localObject4 = "0";
          localObject5 = "0";
          localObject6 = "0";
          i1 = 0;
          i2 = 0;
          i3 = 0;
          try
          {
            if ((!localByteBuffer.hasRemaining()) || (i3 >= i5)) {
              break label3839;
            }
            i4 = localByteBuffer.getShort();
            i6 = localByteBuffer.getShort();
            switch (i4)
            {
            case 20002: 
              if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "invalid type: " + i4);
              }
              localByteBuffer.position(localByteBuffer.position() + i6);
            }
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = localCard;
          }
          localObject7 = new byte[i6];
          localByteBuffer.get((byte[])localObject7);
          localCard.strNick = new String((byte[])localObject7);
          if (!QLog.isColorLevel()) {
            break label4124;
          }
          QLog.d("CardHandler", 2, "strNick = " + localCard.strNick);
          i4 = i1;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localObject9 = paramObject;
          localObject10 = paramFromServiceMsg;
          i1 = i2;
          i2 = i4;
          paramFromServiceMsg = (FromServiceMsg)localObject6;
          paramObject = localObject5;
          localObject1 = localObject4;
          localObject2 = localObject3;
          localObject3 = localObject7;
          localObject4 = localObject8;
          localObject5 = localObject9;
          localObject6 = localObject10;
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            ByteBuffer localByteBuffer;
            Long localLong;
            FriendsManager localFriendsManager;
            Card localCard;
            label2631:
            label3064:
            paramFromServiceMsg = null;
            continue;
            i1 = -1111;
          }
        }
        i4 = localByteBuffer.get();
        if (i4 == 1) {
          localCard.shGender = 0;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "shGender = " + localCard.shGender);
          i4 = i1;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localObject9 = paramObject;
          localObject10 = paramFromServiceMsg;
          i1 = i2;
          i2 = i4;
          paramFromServiceMsg = (FromServiceMsg)localObject6;
          paramObject = localObject5;
          localObject1 = localObject4;
          localObject2 = localObject3;
          localObject3 = localObject7;
          localObject4 = localObject8;
          localObject5 = localObject9;
          localObject6 = localObject10;
          break label4180;
          if (i4 == 2)
          {
            localCard.shGender = 1;
            continue;
            bool2 = false;
            paramToServiceMsg = paramFromServiceMsg;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("CardHandler", 2, "handleGetDetailInfo", paramObject);
              bool1 = bool2;
              paramToServiceMsg = paramFromServiceMsg;
            }
            a(20, bool1, paramToServiceMsg);
          }
          else
          {
            localCard.shGender = -1;
            continue;
            i4 = localByteBuffer.getInt();
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "profession = " + i4);
            }
            if (NearbyProfileUtil.a(i4))
            {
              localCard.iProfession = i4;
              i4 = i1;
              localObject7 = localObject2;
              localObject8 = localObject1;
              localObject9 = paramObject;
              localObject10 = paramFromServiceMsg;
              i1 = i2;
              i2 = i4;
              paramFromServiceMsg = (FromServiceMsg)localObject6;
              paramObject = localObject5;
              localObject1 = localObject4;
              localObject2 = localObject3;
              localObject3 = localObject7;
              localObject4 = localObject8;
              localObject5 = localObject9;
              localObject6 = localObject10;
              break label4180;
            }
            localCard.iProfession = -1;
            i4 = i1;
            localObject7 = localObject2;
            localObject8 = localObject1;
            localObject9 = paramObject;
            localObject10 = paramFromServiceMsg;
            i1 = i2;
            i2 = i4;
            paramFromServiceMsg = (FromServiceMsg)localObject6;
            paramObject = localObject5;
            localObject1 = localObject4;
            localObject2 = localObject3;
            localObject3 = localObject7;
            localObject4 = localObject8;
            localObject5 = localObject9;
            localObject6 = localObject10;
            break label4180;
            localCard.lBirthday = localByteBuffer.getInt();
            if (localCard.lBirthday == 0L) {
              localCard.constellation = 0;
            }
            while (QLog.isColorLevel())
            {
              QLog.d("CardHandler", 2, "birth = " + localCard.lBirthday + ", constellation = " + localCard.constellation);
              i4 = i1;
              localObject7 = localObject2;
              localObject8 = localObject1;
              localObject9 = paramObject;
              localObject10 = paramFromServiceMsg;
              i1 = i2;
              i2 = i4;
              paramFromServiceMsg = (FromServiceMsg)localObject6;
              paramObject = localObject5;
              localObject1 = localObject4;
              localObject2 = localObject3;
              localObject3 = localObject7;
              localObject4 = localObject8;
              localObject5 = localObject9;
              localObject6 = localObject10;
              break label4180;
              localCard.constellation = Utils.a((int)((localCard.lBirthday & 0xFF00) >> 8), (int)(localCard.lBirthday & 0xFF));
              continue;
              localObject7 = new byte[i6];
              localByteBuffer.get((byte[])localObject7);
              localObject7 = new String((byte[])localObject7);
              localCard.strCompany = ((String)localObject7);
              if (QLog.isColorLevel())
              {
                QLog.d("CardHandler", 2, "company = " + (String)localObject7);
                i4 = i1;
                localObject7 = localObject2;
                localObject8 = localObject1;
                localObject9 = paramObject;
                localObject10 = paramFromServiceMsg;
                i1 = i2;
                i2 = i4;
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                paramObject = localObject5;
                localObject1 = localObject4;
                localObject2 = localObject3;
                localObject3 = localObject7;
                localObject4 = localObject8;
                localObject5 = localObject9;
                localObject6 = localObject10;
                break label4180;
                i4 = 1;
                i2 = localByteBuffer.getInt();
                i6 = localByteBuffer.getInt();
                i7 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "hometown, countryId " + i2 + ", provinceId " + i6 + ", cityId " + i7);
                }
                localObject7 = ConditionSearchManager.a(i2);
                localObject8 = ConditionSearchManager.a(i6);
                localObject9 = ConditionSearchManager.a(i7);
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                paramObject = localObject5;
                localObject1 = localObject4;
                localObject4 = localObject2;
                localObject5 = localObject9;
                i2 = i1;
                i1 = i4;
                localObject2 = localObject3;
                localObject3 = localObject4;
                localObject4 = localObject5;
                localObject5 = localObject8;
                localObject6 = localObject7;
                break label4180;
                i4 = 1;
                i2 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "hometown, districtId " + i2);
                }
                localObject10 = ConditionSearchManager.a(i2);
                localObject7 = localObject1;
                localObject8 = paramObject;
                localObject9 = paramFromServiceMsg;
                localObject2 = localObject3;
                localObject3 = localObject10;
                i2 = i1;
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                paramObject = localObject5;
                localObject1 = localObject4;
                i1 = i4;
                localObject4 = localObject7;
                localObject5 = localObject8;
                localObject6 = localObject9;
                break label4180;
                i1 = localByteBuffer.getInt();
                i4 = localByteBuffer.getInt();
                i6 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "location, countryId " + i1 + ", provinceId " + i4 + ", cityId " + i6);
                }
                localObject8 = ConditionSearchManager.a(i1);
                localObject9 = ConditionSearchManager.a(i4);
                localObject10 = ConditionSearchManager.a(i6);
                localObject3 = localObject2;
                localObject4 = localObject1;
                localObject5 = paramObject;
                localObject7 = paramFromServiceMsg;
                i4 = 1;
                i1 = i2;
                paramObject = localObject10;
                paramFromServiceMsg = (FromServiceMsg)localObject6;
                i2 = i4;
                localObject1 = localObject9;
                localObject2 = localObject8;
                localObject6 = localObject7;
                break label4180;
                i1 = localByteBuffer.getInt();
                if (QLog.isColorLevel()) {
                  QLog.d("CardHandler", 2, "location, districtId " + i1);
                }
                localObject10 = ConditionSearchManager.a(i1);
                localObject6 = localObject2;
                localObject7 = localObject1;
                localObject8 = paramObject;
                localObject9 = paramFromServiceMsg;
                i1 = i2;
                i2 = 1;
                paramFromServiceMsg = (FromServiceMsg)localObject10;
                paramObject = localObject5;
                localObject1 = localObject4;
                localObject2 = localObject3;
                localObject3 = localObject6;
                localObject4 = localObject7;
                localObject5 = localObject8;
                localObject6 = localObject9;
                break label4180;
                localObject7 = new byte[i6];
                localByteBuffer.get((byte[])localObject7);
                localObject7 = new String((byte[])localObject7);
                localCard.strEmail = ((String)localObject7);
                if (QLog.isColorLevel())
                {
                  QLog.d("CardHandler", 2, "email = " + (String)localObject7);
                  i4 = i1;
                  localObject7 = localObject2;
                  localObject8 = localObject1;
                  localObject9 = paramObject;
                  localObject10 = paramFromServiceMsg;
                  i1 = i2;
                  i2 = i4;
                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                  paramObject = localObject5;
                  localObject1 = localObject4;
                  localObject2 = localObject3;
                  localObject3 = localObject7;
                  localObject4 = localObject8;
                  localObject5 = localObject9;
                  localObject6 = localObject10;
                  break label4180;
                  localObject7 = new byte[i6];
                  localByteBuffer.get((byte[])localObject7);
                  localObject7 = new String((byte[])localObject7);
                  localCard.strPersonalNote = ((String)localObject7);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("CardHandler", 2, "personal note = " + (String)localObject7);
                    i4 = i1;
                    localObject7 = localObject2;
                    localObject8 = localObject1;
                    localObject9 = paramObject;
                    localObject10 = paramFromServiceMsg;
                    i1 = i2;
                    i2 = i4;
                    paramFromServiceMsg = (FromServiceMsg)localObject6;
                    paramObject = localObject5;
                    localObject1 = localObject4;
                    localObject2 = localObject3;
                    localObject3 = localObject7;
                    localObject4 = localObject8;
                    localObject5 = localObject9;
                    localObject6 = localObject10;
                    break label4180;
                    localObject7 = new byte[i6];
                    localByteBuffer.get((byte[])localObject7);
                    localObject7 = new String((byte[])localObject7);
                    localCard.strSchool = ((String)localObject7);
                    if (QLog.isColorLevel())
                    {
                      QLog.d("CardHandler", 2, "school = " + (String)localObject7);
                      i4 = i1;
                      localObject7 = localObject2;
                      localObject8 = localObject1;
                      localObject9 = paramObject;
                      localObject10 = paramFromServiceMsg;
                      i1 = i2;
                      i2 = i4;
                      paramFromServiceMsg = (FromServiceMsg)localObject6;
                      paramObject = localObject5;
                      localObject1 = localObject4;
                      localObject2 = localObject3;
                      localObject3 = localObject7;
                      localObject4 = localObject8;
                      localObject5 = localObject9;
                      localObject6 = localObject10;
                      break label4180;
                      localCard.age = localByteBuffer.get();
                      localCard.shAge = ((short)localCard.age);
                      if (QLog.isColorLevel())
                      {
                        QLog.d("CardHandler", 2, "age = " + localCard.age);
                        i4 = i1;
                        localObject7 = localObject2;
                        localObject8 = localObject1;
                        localObject9 = paramObject;
                        localObject10 = paramFromServiceMsg;
                        i1 = i2;
                        i2 = i4;
                        paramFromServiceMsg = (FromServiceMsg)localObject6;
                        paramObject = localObject5;
                        localObject1 = localObject4;
                        localObject2 = localObject3;
                        localObject3 = localObject7;
                        localObject4 = localObject8;
                        localObject5 = localObject9;
                        localObject6 = localObject10;
                        break label4180;
                        localCard.constellation = localByteBuffer.get();
                        if (QLog.isColorLevel())
                        {
                          QLog.d("CardHandler", 2, "constellation = " + localCard.constellation);
                          i4 = i1;
                          localObject7 = localObject2;
                          localObject8 = localObject1;
                          localObject9 = paramObject;
                          localObject10 = paramFromServiceMsg;
                          i1 = i2;
                          i2 = i4;
                          paramFromServiceMsg = (FromServiceMsg)localObject6;
                          paramObject = localObject5;
                          localObject1 = localObject4;
                          localObject2 = localObject3;
                          localObject3 = localObject7;
                          localObject4 = localObject8;
                          localObject5 = localObject9;
                          localObject6 = localObject10;
                          break label4180;
                          i4 = localByteBuffer.getShort();
                          i6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1);
                          if (QLog.isColorLevel()) {
                            QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyprofile local is :" + i6 + " server is: " + i4);
                          }
                          if ((i6 != i4) && (i6 != 1))
                          {
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_people_profile_ok_new", i4).commit();
                            i4 = i1;
                            localObject7 = localObject2;
                            localObject8 = localObject1;
                            localObject9 = paramObject;
                            localObject10 = paramFromServiceMsg;
                            i1 = i2;
                            i2 = i4;
                            paramFromServiceMsg = (FromServiceMsg)localObject6;
                            paramObject = localObject5;
                            localObject1 = localObject4;
                            localObject2 = localObject3;
                            localObject3 = localObject7;
                            localObject4 = localObject8;
                            localObject5 = localObject9;
                            localObject6 = localObject10;
                            break label4180;
                            boolean bool3 = false;
                            if (2 == i6)
                            {
                              boolean bool4 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", false);
                              localObject7 = new byte[i6];
                              localByteBuffer.get((byte[])localObject7);
                              if (Utils.a((byte[])localObject7, 0) != 0) {
                                break label4251;
                              }
                              bool2 = false;
                              bool3 = bool2;
                              if (bool4 != bool2)
                              {
                                if (localByteBuffer.getShort() == 0) {
                                  SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", bool2);
                                }
                                localObject7 = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
                                ((Intent)localObject7).putExtra("pcActive", bool2);
                                ((Intent)localObject7).putExtra("uin", localLong.toString());
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject7);
                                bool3 = bool2;
                              }
                            }
                            if (QLog.isColorLevel())
                            {
                              QLog.d("PCActiveState", 2, "Get PCActiveState=" + bool3);
                              i4 = i1;
                              localObject7 = localObject2;
                              localObject8 = localObject1;
                              localObject9 = paramObject;
                              localObject10 = paramFromServiceMsg;
                              i1 = i2;
                              i2 = i4;
                              paramFromServiceMsg = (FromServiceMsg)localObject6;
                              paramObject = localObject5;
                              localObject1 = localObject4;
                              localObject2 = localObject3;
                              localObject3 = localObject7;
                              localObject4 = localObject8;
                              localObject5 = localObject9;
                              localObject6 = localObject10;
                              break label4180;
                              short s1 = localByteBuffer.getShort();
                              if (QLog.isColorLevel()) {
                                QLog.i("CardHandler", 2, "handleGetDetalInfo server dating symbol is :" + s1);
                              }
                              localObject7 = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
                              if (localObject7 != null)
                              {
                                ((DatingManager)localObject7).a().a(s1);
                                i4 = i1;
                                localObject7 = localObject2;
                                localObject8 = localObject1;
                                localObject9 = paramObject;
                                localObject10 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject6;
                                paramObject = localObject5;
                                localObject1 = localObject4;
                                localObject2 = localObject3;
                                localObject3 = localObject7;
                                localObject4 = localObject8;
                                localObject5 = localObject9;
                                localObject6 = localObject10;
                                break label4180;
                              }
                              if (QLog.isColorLevel())
                              {
                                QLog.i("Q.dating", 2, "handleGetDetalInfo mng is null");
                                i4 = i1;
                                localObject7 = localObject2;
                                localObject8 = localObject1;
                                localObject9 = paramObject;
                                localObject10 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject6;
                                paramObject = localObject5;
                                localObject1 = localObject4;
                                localObject2 = localObject3;
                                localObject3 = localObject7;
                                localObject4 = localObject8;
                                localObject5 = localObject9;
                                localObject6 = localObject10;
                                break label4180;
                                i4 = localByteBuffer.getShort();
                                if (!QLog.isColorLevel()) {
                                  break label4257;
                                }
                                QLog.i("CardHandler", 2, "handleGetDetalInfo server calltab visible is :" + i4);
                                break label4257;
                                i6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
                                i7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
                                if (i7 != 0) {
                                  break label4274;
                                }
                                localObject7 = new Integer[7];
                                localObject7[3] = Integer.valueOf(i4);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((Integer[])localObject7);
                                i4 = i1;
                                localObject7 = localObject2;
                                localObject8 = localObject1;
                                localObject9 = paramObject;
                                localObject10 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject6;
                                paramObject = localObject5;
                                localObject1 = localObject4;
                                localObject2 = localObject3;
                                localObject3 = localObject7;
                                localObject4 = localObject8;
                                localObject5 = localObject9;
                                localObject6 = localObject10;
                                break label4180;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      b(bool2, false);
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      localCard.switch_interest = localByteBuffer.getShort();
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      localCard.switch_music = localByteBuffer.getShort();
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      localCard.switch_recent_activity = localByteBuffer.getShort();
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      localCard.switch_star = localByteBuffer.getShort();
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      localCard.switch_joined_troop = localByteBuffer.getShort();
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      localCard.switch_ktv = localByteBuffer.getShort();
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      localCard.switch_eat = localByteBuffer.getShort();
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      i4 = localByteBuffer.getShort();
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, "handleGetDetalInfo server has device bind symbol is :" + i4);
      }
      ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(i4);
      i4 = i1;
      localObject7 = localObject2;
      localObject8 = localObject1;
      localObject9 = paramObject;
      localObject10 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject7;
      localObject4 = localObject8;
      localObject5 = localObject9;
      localObject6 = localObject10;
      break label4180;
      label3839:
      if (i1 != 0)
      {
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append((String)localObject3).append("-");
        ((StringBuilder)localObject7).append((String)localObject4).append("-");
        ((StringBuilder)localObject7).append((String)localObject5).append("-");
        ((StringBuilder)localObject7).append((String)localObject6);
        localCard.strLocationCodes = ((StringBuilder)localObject7).toString();
      }
      if (i2 != 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramFromServiceMsg).append("-");
        ((StringBuilder)localObject3).append(paramObject).append("-");
        ((StringBuilder)localObject3).append((String)localObject1).append("-");
        ((StringBuilder)localObject3).append((String)localObject2);
        localCard.strHometownCodes = ((StringBuilder)localObject3).toString();
      }
      localFriendsManager.a(localCard);
      if (((i1 != 0) || (i2 != 0)) && (paramToServiceMsg.extraData.getBoolean("reqFromDetailActivity"))) {
        ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57)).a();
      }
      paramToServiceMsg = localCard;
      break label805;
      label4037:
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        i1 = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "request error, ret " + i1);
        }
        paramToServiceMsg = null;
        bool1 = false;
        break label805;
      }
      paramToServiceMsg = null;
      break label805;
      break label464;
      label4124:
      label4180:
      do
      {
        i4 = i2;
        localObject7 = localObject6;
        localObject8 = localObject5;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject6 = paramFromServiceMsg;
        localObject5 = paramObject;
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject10;
        localObject1 = localObject9;
        paramObject = localObject8;
        paramFromServiceMsg = (FromServiceMsg)localObject7;
        i2 = i1;
        i1 = i4;
        localObject7 = localObject6;
        localObject8 = localObject5;
        localObject9 = localObject4;
        localObject10 = localObject3;
        i4 = i2;
        i3 += 1;
        i2 = i1;
        i1 = i4;
        localObject6 = paramFromServiceMsg;
        localObject5 = paramObject;
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject10;
        localObject1 = localObject9;
        paramObject = localObject8;
        paramFromServiceMsg = (FromServiceMsg)localObject7;
        break label215;
        bool1 = false;
        break;
        bool2 = true;
        break label2631;
        if (i4 == 0)
        {
          i4 = 1;
          break label3064;
        }
        i4 = 0;
        break label3064;
      } while ((i7 != 1) || (i4 == i6));
      label4251:
      label4257:
      label4274:
      if (i6 == 0) {
        bool2 = false;
      } else {
        bool2 = true;
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = new ArrayList();
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespGetVisitorList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramObject = c();
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        a(7, false, new Object[] { paramBundle, paramObject });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vEncounterInfos.iterator();
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.setType(1);
        paramObject.add(localCardProfile);
      }
      c(paramToServiceMsg.getUin(), paramObject);
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      a(7, true, new Object[] { paramBundle, paramObject });
      return;
    }
    paramToServiceMsg = c();
    paramBundle.putLong("startMid", -1L);
    a(7, false, new Object[] { paramBundle, paramToServiceMsg });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i1;
    int i2;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      i1 = -1;
      if (bool1) {
        i2 = i1;
      }
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        i2 = i1;
        paramFromServiceMsg = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray());
        if (paramObject == null) {
          break label680;
        }
        i2 = i1;
        if (!paramObject.uint32_result.has()) {
          break label680;
        }
        i2 = i1;
        if (paramObject.uint32_result.get() != 0) {
          break label680;
        }
        i2 = i1;
        long l1 = paramFromServiceMsg.getInt();
        i2 = i1;
        paramFromServiceMsg.get();
        i2 = i1;
        i4 = paramFromServiceMsg.getShort();
        i2 = i1;
        if (!QLog.isColorLevel()) {
          break label810;
        }
        i2 = i1;
        QLog.d("CardHandler", 2, "handleGetNearbySymbol, request success, tlvCount = " + i4);
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          int i4;
          int i5;
          int i6;
          i1 = i2;
          continue;
          int i3 = -1111;
          continue;
          i3 = 0;
          continue;
          continue;
          i3 += 1;
        }
      }
      i2 = i1;
      if ((!paramFromServiceMsg.hasRemaining()) || (i3 >= i4)) {
        break label834;
      }
      i2 = i1;
      i5 = paramFromServiceMsg.getShort();
      i2 = i1;
      i6 = paramFromServiceMsg.getShort();
      switch (i5)
      {
      case -25040: 
        i2 = i1;
        if (QLog.isColorLevel())
        {
          i2 = i1;
          QLog.d("CardHandler", 2, "handleGetNearbySymbol invaild type: " + i5);
        }
        i2 = i1;
        paramFromServiceMsg.position(paramFromServiceMsg.position() + i6);
        break label819;
        i2 = i1;
        i1 = paramFromServiceMsg.getShort();
        i2 = i1;
        try
        {
          i5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1);
          if (QLog.isColorLevel()) {
            QLog.i("CardHandler", 2, "handleGetNearbySymbol nearbyprofile ok local is :" + i5 + " server is: " + i2);
          }
          i1 = i2;
          if (i5 == i2) {
            break label819;
          }
          i1 = i2;
          if (i5 == 1) {
            break label819;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_people_profile_ok_new", i2).commit();
          i1 = i2;
        }
        catch (Exception paramFromServiceMsg)
        {
          i1 = i2;
        }
        bool1 = false;
        i2 = i1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "handleGetNearbySymbol", paramFromServiceMsg);
          bool2 = bool1;
          i2 = i1;
        }
        break;
      }
    }
    for (;;)
    {
      if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && (paramToServiceMsg.extraData.getBoolean("nearby_people_profile_ok_new")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "handleGetNearbySymbol server nearby profile get is : " + bool2 + " symbol is: " + i2 + " to notifyUI");
        }
        a(56, bool2, Integer.valueOf(i2));
      }
      return;
      i2 = i1;
      short s1 = paramFromServiceMsg.getShort();
      i2 = i1;
      if (QLog.isColorLevel())
      {
        i2 = i1;
        QLog.i("CardHandler", 2, "handleGetNearbySymbol server dating symbol is :" + s1);
      }
      i2 = i1;
      paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if (paramObject != null)
      {
        i2 = i1;
        paramObject.a().a(s1);
      }
      else
      {
        i2 = i1;
        if (QLog.isColorLevel())
        {
          i2 = i1;
          QLog.i("Q.dating", 2, "handleGetNearbySymbol mng is null");
          break label819;
          label680:
          if (paramObject != null)
          {
            i2 = i1;
            if (paramObject.uint32_result.has())
            {
              i2 = i1;
              i3 = paramObject.uint32_result.get();
              i2 = i1;
              if (QLog.isColorLevel())
              {
                i2 = i1;
                QLog.d("CardHandler", 2, "handleGetNearbySymbol request error, ret " + i3);
              }
              bool1 = false;
              break label834;
              i2 = i1;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("CardHandler", 2, "handleGetNearbySymbol get not success.");
              i2 = i1;
              bool2 = bool1;
              continue;
            }
          }
        }
      }
      label810:
      label819:
      bool1 = false;
      break;
      label834:
      i2 = i1;
      bool2 = bool1;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "handleReqSynPCPortrait|res.resultCode = " + paramFromServiceMsg.getResultCode());
    }
    boolean bool;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespUpdateQQFace)paramObject;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "handleReqSynPCPortrait|iReplyCode = " + paramFromServiceMsg.stHeader.iReplyCode);
      }
      if (paramFromServiceMsg.stHeader.iReplyCode == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      a(bool, paramToServiceMsg.getUin(), 0);
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      paramObject = (QZoneCover)localEntityManager.a(QZoneCover.class, str);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZoneCover();
        paramToServiceMsg.uin = str;
      }
      paramToServiceMsg.updateQzoneCover(paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.a(paramToServiceMsg);
        localEntityManager.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      a(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      localEntityManager.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespAddFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramObject = paramToServiceMsg.extraData.getByteArray("filekey");
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        Card localCard = localFriendsManagerImp.b(paramToServiceMsg.getUin());
        localCard.uin = paramToServiceMsg.getUin();
        if (paramFromServiceMsg.uFaceTimeStamp > localCard.uFaceTimeStamp)
        {
          localCard.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
          localCard.addHeadPortrait(paramObject);
        }
        localCard.iFaceNum += 1;
        localFriendsManagerImp.a(localCard);
        ProfileCardUtil.a(paramObject);
        a(11, true, new Object[] { localCard, paramBundle });
        return;
      }
      paramBundle.putInt("retCode", paramFromServiceMsg.stHeader.iReplyCode);
      a(11, false, paramBundle);
      return;
    }
    a(11, false, paramBundle);
  }
  
  /* Error */
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 13
    //   6: iconst_0
    //   7: istore 14
    //   9: iconst_0
    //   10: istore 12
    //   12: aload_2
    //   13: invokevirtual 562	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +472 -> 488
    //   19: aload_3
    //   20: ifnull +468 -> 488
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 674
    //   35: iconst_2
    //   36: new 214	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1291
    //   46: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 6
    //   64: iload 12
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +343 -> 413
    //   73: iload 5
    //   75: istore 10
    //   77: iload 5
    //   79: istore 7
    //   81: iload 14
    //   83: istore 9
    //   85: new 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 445	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 563	[B
    //   96: checkcast 563	[B
    //   99: invokevirtual 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +387 -> 494
    //   110: iload 5
    //   112: istore 10
    //   114: iload 5
    //   116: istore 7
    //   118: iload 14
    //   120: istore 9
    //   122: aload_2
    //   123: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +365 -> 494
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: istore 10
    //   139: iload 5
    //   141: istore 7
    //   143: iload 14
    //   145: istore 9
    //   147: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +43 -> 193
    //   153: iload 5
    //   155: istore 10
    //   157: iload 5
    //   159: istore 7
    //   161: iload 14
    //   163: istore 9
    //   165: ldc_w 674
    //   168: iconst_2
    //   169: new 214	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1293
    //   179: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 5
    //   184: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload 5
    //   195: istore 6
    //   197: iload 12
    //   199: istore 8
    //   201: iload 5
    //   203: ifeq +210 -> 413
    //   206: iload 5
    //   208: istore 6
    //   210: iload 12
    //   212: istore 8
    //   214: iload 5
    //   216: istore 10
    //   218: iload 5
    //   220: istore 7
    //   222: iload 14
    //   224: istore 9
    //   226: aload_2
    //   227: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 1294	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   233: ifeq +180 -> 413
    //   236: iload 5
    //   238: istore 6
    //   240: iload 12
    //   242: istore 8
    //   244: iload 5
    //   246: istore 10
    //   248: iload 5
    //   250: istore 7
    //   252: iload 14
    //   254: istore 9
    //   256: aload_2
    //   257: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   260: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   263: ifnull +150 -> 413
    //   266: iload 5
    //   268: istore 10
    //   270: iload 5
    //   272: istore 7
    //   274: iload 14
    //   276: istore 9
    //   278: aload_2
    //   279: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   282: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   285: invokevirtual 573	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   288: invokestatic 577	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   291: astore_2
    //   292: iload 5
    //   294: istore 10
    //   296: iload 5
    //   298: istore 7
    //   300: iload 14
    //   302: istore 9
    //   304: aload_2
    //   305: invokevirtual 580	java/nio/ByteBuffer:getInt	()I
    //   308: istore 4
    //   310: iload 4
    //   312: i2l
    //   313: lstore 15
    //   315: iload 4
    //   317: ifge +12 -> 329
    //   320: iload 4
    //   322: ldc_w 1295
    //   325: iand
    //   326: i2l
    //   327: lstore 15
    //   329: iload 5
    //   331: istore 10
    //   333: iload 5
    //   335: istore 7
    //   337: iload 14
    //   339: istore 9
    //   341: aload_2
    //   342: invokevirtual 583	java/nio/ByteBuffer:get	()B
    //   345: pop
    //   346: iload 5
    //   348: istore 6
    //   350: iload 12
    //   352: istore 8
    //   354: iload 5
    //   356: istore 10
    //   358: iload 5
    //   360: istore 7
    //   362: iload 14
    //   364: istore 9
    //   366: aload_2
    //   367: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   370: invokestatic 1298	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   373: invokevirtual 505	java/lang/Short:shortValue	()S
    //   376: iconst_1
    //   377: if_icmpne +36 -> 413
    //   380: iload 5
    //   382: istore 10
    //   384: iload 5
    //   386: istore 7
    //   388: iload 14
    //   390: istore 9
    //   392: aload_2
    //   393: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   396: istore 4
    //   398: iload 4
    //   400: sipush -25042
    //   403: if_icmpeq +97 -> 500
    //   406: iconst_0
    //   407: istore 6
    //   409: iload 12
    //   411: istore 8
    //   413: iload 6
    //   415: istore 7
    //   417: iload 8
    //   419: istore 9
    //   421: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +50 -> 474
    //   427: ldc_w 674
    //   430: iconst_2
    //   431: new 214	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 1293
    //   441: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 6
    //   446: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   449: ldc_w 1300
    //   452: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload 8
    //   457: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: iload 8
    //   468: istore 9
    //   470: iload 6
    //   472: istore 7
    //   474: aload_0
    //   475: bipush 54
    //   477: iload 7
    //   479: iload 9
    //   481: invokestatic 594	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   484: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   487: return
    //   488: iconst_0
    //   489: istore 5
    //   491: goto -465 -> 26
    //   494: iconst_0
    //   495: istore 5
    //   497: goto -362 -> 135
    //   500: iload 5
    //   502: istore 10
    //   504: iload 5
    //   506: istore 7
    //   508: iload 14
    //   510: istore 9
    //   512: aload_2
    //   513: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   516: istore 4
    //   518: iload 4
    //   520: iconst_2
    //   521: if_icmpne +123 -> 644
    //   524: iload 5
    //   526: istore 10
    //   528: iload 5
    //   530: istore 7
    //   532: iload 14
    //   534: istore 9
    //   536: iload 4
    //   538: newarray byte
    //   540: astore_3
    //   541: iload 5
    //   543: istore 10
    //   545: iload 5
    //   547: istore 7
    //   549: iload 14
    //   551: istore 9
    //   553: aload_2
    //   554: aload_3
    //   555: invokevirtual 1028	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   558: pop
    //   559: iload 5
    //   561: istore 10
    //   563: iload 5
    //   565: istore 7
    //   567: iload 14
    //   569: istore 9
    //   571: aload_3
    //   572: iconst_0
    //   573: invokestatic 1117	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   576: istore 4
    //   578: iload 4
    //   580: ifne +32 -> 612
    //   583: iconst_0
    //   584: istore 6
    //   586: aload_2
    //   587: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   590: istore 4
    //   592: iload 4
    //   594: ifeq +24 -> 618
    //   597: iload 11
    //   599: istore 5
    //   601: iload 6
    //   603: istore 8
    //   605: iload 5
    //   607: istore 6
    //   609: goto -196 -> 413
    //   612: iconst_1
    //   613: istore 6
    //   615: goto -29 -> 586
    //   618: aload_0
    //   619: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: invokevirtual 1105	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   625: aload_1
    //   626: invokevirtual 750	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   629: aconst_null
    //   630: ldc_w 1108
    //   633: iload 6
    //   635: invokestatic 1121	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   638: iconst_1
    //   639: istore 5
    //   641: goto -40 -> 601
    //   644: iconst_0
    //   645: istore 6
    //   647: iload 12
    //   649: istore 8
    //   651: goto -238 -> 413
    //   654: astore_1
    //   655: iload 13
    //   657: istore 6
    //   659: iload 10
    //   661: istore 5
    //   663: iload 5
    //   665: istore 7
    //   667: iload 6
    //   669: istore 9
    //   671: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +22 -> 696
    //   677: iload 5
    //   679: istore 7
    //   681: iload 6
    //   683: istore 9
    //   685: ldc_w 674
    //   688: iconst_2
    //   689: ldc_w 1302
    //   692: aload_1
    //   693: invokestatic 932	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   696: iload 5
    //   698: istore 7
    //   700: iload 6
    //   702: istore 9
    //   704: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq -233 -> 474
    //   710: ldc_w 674
    //   713: iconst_2
    //   714: new 214	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 1293
    //   724: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: iload 5
    //   729: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   732: ldc_w 1300
    //   735: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: iload 6
    //   740: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   743: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: iload 5
    //   751: istore 7
    //   753: iload 6
    //   755: istore 9
    //   757: goto -283 -> 474
    //   760: astore_1
    //   761: iload 7
    //   763: istore 5
    //   765: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +42 -> 810
    //   771: ldc_w 674
    //   774: iconst_2
    //   775: new 214	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 1293
    //   785: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 5
    //   790: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   793: ldc_w 1300
    //   796: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: iload 9
    //   801: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   804: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: aload_1
    //   811: athrow
    //   812: astore_1
    //   813: iload 6
    //   815: istore 9
    //   817: goto -52 -> 765
    //   820: astore_1
    //   821: iconst_1
    //   822: istore 5
    //   824: iload 6
    //   826: istore 9
    //   828: goto -63 -> 765
    //   831: astore_1
    //   832: goto -169 -> 663
    //   835: astore_1
    //   836: iconst_1
    //   837: istore 5
    //   839: goto -176 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	CardHandler
    //   0	842	1	paramToServiceMsg	ToServiceMsg
    //   0	842	2	paramFromServiceMsg	FromServiceMsg
    //   0	842	3	paramObject	Object
    //   308	285	4	i1	int
    //   24	814	5	bool1	boolean
    //   62	763	6	bool2	boolean
    //   79	683	7	bool3	boolean
    //   66	584	8	bool4	boolean
    //   83	744	9	bool5	boolean
    //   75	585	10	bool6	boolean
    //   1	597	11	bool7	boolean
    //   10	638	12	bool8	boolean
    //   4	652	13	bool9	boolean
    //   7	561	14	bool10	boolean
    //   313	15	15	l1	long
    // Exception table:
    //   from	to	target	type
    //   85	106	654	java/lang/Exception
    //   122	132	654	java/lang/Exception
    //   147	153	654	java/lang/Exception
    //   165	193	654	java/lang/Exception
    //   226	236	654	java/lang/Exception
    //   256	266	654	java/lang/Exception
    //   278	292	654	java/lang/Exception
    //   304	310	654	java/lang/Exception
    //   341	346	654	java/lang/Exception
    //   366	380	654	java/lang/Exception
    //   392	398	654	java/lang/Exception
    //   512	518	654	java/lang/Exception
    //   536	541	654	java/lang/Exception
    //   553	559	654	java/lang/Exception
    //   571	578	654	java/lang/Exception
    //   85	106	760	finally
    //   122	132	760	finally
    //   147	153	760	finally
    //   165	193	760	finally
    //   226	236	760	finally
    //   256	266	760	finally
    //   278	292	760	finally
    //   304	310	760	finally
    //   341	346	760	finally
    //   366	380	760	finally
    //   392	398	760	finally
    //   512	518	760	finally
    //   536	541	760	finally
    //   553	559	760	finally
    //   571	578	760	finally
    //   671	677	760	finally
    //   685	696	760	finally
    //   586	592	812	finally
    //   618	638	820	finally
    //   586	592	831	java/lang/Exception
    //   618	638	835	java/lang/Exception
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l1 = paramToServiceMsg.extraData.getLong("uin");
    int i1 = paramToServiceMsg.extraData.getInt("timestamp");
    paramToServiceMsg = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(String.valueOf(Long.valueOf(l1)));
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespFaceInfo)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        if ((i1 != 0) && (paramFromServiceMsg.uFaceTimeStamp == paramToServiceMsg.uFaceTimeStamp)) {
          break label177;
        }
        paramToServiceMsg.iFaceNum = paramFromServiceMsg.iFaceNum;
        paramToServiceMsg.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
        paramToServiceMsg.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
      }
    }
    label177:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(paramToServiceMsg);
      a(10, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
      return;
      a(10, false, paramToServiceMsg);
      return;
      a(10, false, paramToServiceMsg);
      return;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    String str;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState success=" + bool1);
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131369652);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      bool3 = bool1;
      if (!bool1) {
        break label610;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool1);
        }
        bool3 = bool1;
        if (!bool1) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i1 = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt();
        long l1 = i1;
        if (i1 < 0) {
          l1 = i1 & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1))) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool1 = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = true;
        bool3 = bool1;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool4 = bool2;
          bool3 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState ex", paramObject);
        if (!QLog.isColorLevel()) {
          break label600;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = false;
        bool4 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      a(55, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label600:
      bool3 = false;
      bool4 = bool2;
      continue;
      label610:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      paramToServiceMsg = (RespMakeFriendsCard)paramObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        paramBundle = paramToServiceMsg.stHeader.lUIN + "";
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramObject = paramFromServiceMsg.b(paramBundle);
        paramObject.uin = paramBundle;
        paramObject.strNick = paramToServiceMsg.stMakeFriendsCard.strNick;
        paramObject.shGender = paramToServiceMsg.stMakeFriendsCard.shGender;
        paramObject.shAge = paramToServiceMsg.stMakeFriendsCard.shAge;
        paramObject.nFaceID = paramToServiceMsg.stMakeFriendsCard.nFaceID;
        paramObject.strCertificationInfo = paramToServiceMsg.stMakeFriendsCard.strCertificationInfo;
        paramObject.shType = paramToServiceMsg.stMakeFriendsCard.stIntro.shType;
        paramObject.vContent = paramToServiceMsg.stMakeFriendsCard.stIntro.vContent;
        paramObject.vQQFaceID = paramToServiceMsg.stMakeFriendsCard.vQQFaceID;
        paramObject.lCardShowNum = paramToServiceMsg.lCardShowNum;
        paramObject.bSingle = paramToServiceMsg.stMakeFriendsCard.bSingle;
        paramObject.lVisitCount = paramToServiceMsg.stMakeFriendsCard.lVisitCount;
        if (paramToServiceMsg.stMakeFriendsCard.lVoteCount > paramObject.lVoteCount) {
          paramObject.lVoteCount = paramToServiceMsg.stMakeFriendsCard.lVoteCount;
        }
        if ((i1 == 0) || (paramToServiceMsg.stMakeFriendsCard.uFaceTimeStamp > paramObject.uFaceTimeStamp))
        {
          paramObject.uFaceTimeStamp = paramToServiceMsg.stMakeFriendsCard.uFaceTimeStamp;
          paramObject.setStrJoinHexAlbumFileKey(a(paramToServiceMsg.vFaceInfo));
        }
        paramObject.iVoteIncrement = paramToServiceMsg.iVoteIncrement;
        paramBundle = paramToServiceMsg.stMakeFriendsCard.vTags;
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle);
          paramObject.setTagInfosByte(paramBundle);
        }
        paramObject.eUserIdentityType = ((byte)paramToServiceMsg.stMakeFriendsCard.eUserIdentityType);
        paramObject.vBackground = paramToServiceMsg.stMakeFriendsCard.vBackground;
        paramObject.iFaceNum = paramToServiceMsg.stMakeFriendsCard.iFaceNum;
        paramObject.cSqqLevel = paramToServiceMsg.cSqqLevel;
        paramFromServiceMsg.a(paramObject);
        paramFromServiceMsg.a(paramObject.uin, (short)paramObject.nFaceID, paramObject.strNick, paramObject.strSign);
        a(1, true, paramObject);
        return;
      }
      if ((3 == paramToServiceMsg.stHeader.iReplyCode) || (56 == paramToServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  /* Error */
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 562	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +419 -> 426
    //   10: aload_3
    //   11: ifnull +415 -> 426
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 674
    //   26: iconst_2
    //   27: new 214	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1428
    //   37: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: bipush 49
    //   57: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   60: checkcast 423	com/tencent/mobileqq/app/FriendsManager
    //   63: astore_1
    //   64: aload_1
    //   65: aload_0
    //   66: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   72: invokevirtual 933	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   75: astore_2
    //   76: iload 6
    //   78: istore 9
    //   80: iload 6
    //   82: ifeq +636 -> 718
    //   85: iload 6
    //   87: istore 7
    //   89: iload 6
    //   91: istore 8
    //   93: new 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 445	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: aload_3
    //   101: checkcast 563	[B
    //   104: checkcast 563	[B
    //   107: invokevirtual 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: checkcast 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +317 -> 432
    //   118: iload 6
    //   120: istore 7
    //   122: iload 6
    //   124: istore 8
    //   126: aload_3
    //   127: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: ifne +299 -> 432
    //   136: iconst_1
    //   137: istore 6
    //   139: iload 6
    //   141: istore 7
    //   143: iload 6
    //   145: istore 8
    //   147: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +39 -> 189
    //   153: iload 6
    //   155: istore 7
    //   157: iload 6
    //   159: istore 8
    //   161: ldc_w 674
    //   164: iconst_2
    //   165: new 214	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 1430
    //   175: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 6
    //   180: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload 6
    //   191: istore 9
    //   193: iload 6
    //   195: ifeq +523 -> 718
    //   198: iload 6
    //   200: istore 7
    //   202: iload 6
    //   204: istore 8
    //   206: iload 6
    //   208: istore 9
    //   210: aload_3
    //   211: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   214: invokevirtual 1294	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   217: ifeq +501 -> 718
    //   220: iload 6
    //   222: istore 7
    //   224: iload 6
    //   226: istore 8
    //   228: iload 6
    //   230: istore 9
    //   232: aload_3
    //   233: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: ifnull +479 -> 718
    //   242: iload 6
    //   244: istore 7
    //   246: iload 6
    //   248: istore 8
    //   250: aload_3
    //   251: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 573	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   260: invokestatic 577	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   263: astore_3
    //   264: iload 6
    //   266: istore 7
    //   268: iload 6
    //   270: istore 8
    //   272: aload_3
    //   273: invokevirtual 580	java/nio/ByteBuffer:getInt	()I
    //   276: pop
    //   277: iload 6
    //   279: istore 7
    //   281: iload 6
    //   283: istore 8
    //   285: aload_3
    //   286: invokevirtual 583	java/nio/ByteBuffer:get	()B
    //   289: pop
    //   290: iload 6
    //   292: istore 7
    //   294: iload 6
    //   296: istore 8
    //   298: iload 6
    //   300: istore 9
    //   302: aload_3
    //   303: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   306: invokestatic 1298	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   309: invokevirtual 505	java/lang/Short:shortValue	()S
    //   312: iconst_1
    //   313: if_icmpne +405 -> 718
    //   316: iload 6
    //   318: istore 7
    //   320: iload 6
    //   322: istore 8
    //   324: aload_3
    //   325: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   328: istore 4
    //   330: iload 6
    //   332: istore 7
    //   334: iload 6
    //   336: istore 8
    //   338: aload_0
    //   339: getfield 249	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_Short	S
    //   342: istore 5
    //   344: iload 4
    //   346: iload 5
    //   348: if_icmpeq +90 -> 438
    //   351: iload 10
    //   353: istore 7
    //   355: iload 7
    //   357: istore 8
    //   359: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +48 -> 410
    //   365: ldc_w 674
    //   368: iconst_2
    //   369: new 214	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 1430
    //   379: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 7
    //   384: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: ldc_w 1300
    //   390: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: getfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   397: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload 7
    //   408: istore 8
    //   410: aload_0
    //   411: bipush 44
    //   413: iload 8
    //   415: aload_2
    //   416: getfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   419: invokestatic 594	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   422: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   425: return
    //   426: iconst_0
    //   427: istore 6
    //   429: goto -412 -> 17
    //   432: iconst_0
    //   433: istore 6
    //   435: goto -296 -> 139
    //   438: iload 6
    //   440: istore 7
    //   442: iload 6
    //   444: istore 8
    //   446: aload_3
    //   447: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   450: istore 4
    //   452: iload 10
    //   454: istore 7
    //   456: iload 4
    //   458: iconst_2
    //   459: if_icmpne -104 -> 355
    //   462: iload 6
    //   464: istore 7
    //   466: iload 6
    //   468: istore 8
    //   470: iload 4
    //   472: newarray byte
    //   474: astore 11
    //   476: iload 6
    //   478: istore 7
    //   480: iload 6
    //   482: istore 8
    //   484: aload_3
    //   485: aload 11
    //   487: invokevirtual 1028	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   490: pop
    //   491: iload 6
    //   493: istore 7
    //   495: iload 6
    //   497: istore 8
    //   499: aload 11
    //   501: iconst_0
    //   502: invokestatic 1117	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   505: ifne +55 -> 560
    //   508: iconst_0
    //   509: istore 9
    //   511: iload 6
    //   513: istore 7
    //   515: iload 6
    //   517: istore 8
    //   519: aload_2
    //   520: iload 9
    //   522: putfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   525: iload 6
    //   527: istore 7
    //   529: iload 6
    //   531: istore 8
    //   533: aload_3
    //   534: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   537: istore 4
    //   539: iload 10
    //   541: istore 7
    //   543: iload 4
    //   545: ifne -190 -> 355
    //   548: aload_1
    //   549: aload_2
    //   550: invokevirtual 437	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   553: pop
    //   554: iconst_1
    //   555: istore 7
    //   557: goto -202 -> 355
    //   560: iconst_1
    //   561: istore 9
    //   563: goto -52 -> 511
    //   566: astore_1
    //   567: iload 7
    //   569: istore 6
    //   571: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +14 -> 588
    //   577: ldc_w 674
    //   580: iconst_2
    //   581: ldc_w 1435
    //   584: aload_1
    //   585: invokestatic 932	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: iload 6
    //   590: istore 8
    //   592: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq -185 -> 410
    //   598: ldc_w 674
    //   601: iconst_2
    //   602: new 214	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 1430
    //   612: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: iload 6
    //   617: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   620: ldc_w 1300
    //   623: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_2
    //   627: getfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   630: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   633: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: iload 6
    //   641: istore 8
    //   643: goto -233 -> 410
    //   646: astore_1
    //   647: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +44 -> 694
    //   653: ldc_w 674
    //   656: iconst_2
    //   657: new 214	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 1430
    //   667: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: iload 8
    //   672: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: ldc_w 1300
    //   678: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_2
    //   682: getfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   685: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   688: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: aload_1
    //   695: athrow
    //   696: astore_1
    //   697: iconst_1
    //   698: istore 8
    //   700: goto -53 -> 647
    //   703: astore_1
    //   704: iload 6
    //   706: istore 8
    //   708: goto -61 -> 647
    //   711: astore_1
    //   712: iconst_1
    //   713: istore 6
    //   715: goto -144 -> 571
    //   718: iload 9
    //   720: istore 7
    //   722: goto -367 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	CardHandler
    //   0	725	1	paramToServiceMsg	ToServiceMsg
    //   0	725	2	paramFromServiceMsg	FromServiceMsg
    //   0	725	3	paramObject	Object
    //   328	216	4	i1	int
    //   342	7	5	i2	int
    //   15	699	6	bool1	boolean
    //   87	634	7	bool2	boolean
    //   91	616	8	bool3	boolean
    //   78	641	9	bool4	boolean
    //   1	539	10	bool5	boolean
    //   474	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   93	114	566	java/lang/Exception
    //   126	136	566	java/lang/Exception
    //   147	153	566	java/lang/Exception
    //   161	189	566	java/lang/Exception
    //   210	220	566	java/lang/Exception
    //   232	242	566	java/lang/Exception
    //   250	264	566	java/lang/Exception
    //   272	277	566	java/lang/Exception
    //   285	290	566	java/lang/Exception
    //   302	316	566	java/lang/Exception
    //   324	330	566	java/lang/Exception
    //   338	344	566	java/lang/Exception
    //   446	452	566	java/lang/Exception
    //   470	476	566	java/lang/Exception
    //   484	491	566	java/lang/Exception
    //   499	508	566	java/lang/Exception
    //   519	525	566	java/lang/Exception
    //   533	539	566	java/lang/Exception
    //   93	114	646	finally
    //   126	136	646	finally
    //   147	153	646	finally
    //   161	189	646	finally
    //   210	220	646	finally
    //   232	242	646	finally
    //   250	264	646	finally
    //   272	277	646	finally
    //   285	290	646	finally
    //   302	316	646	finally
    //   324	330	646	finally
    //   338	344	646	finally
    //   446	452	646	finally
    //   470	476	646	finally
    //   484	491	646	finally
    //   499	508	646	finally
    //   519	525	646	finally
    //   533	539	646	finally
    //   548	554	696	finally
    //   571	588	703	finally
    //   548	554	711	java/lang/Exception
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespGetCardSwitch)paramObject;
      long l1 = paramFromServiceMsg.uCloseNeighborVote;
      long l2 = paramFromServiceMsg.uCloseTimeGateVote;
      paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
      if (l1 == 0L)
      {
        bool = true;
        paramObject.setZanShowFlag(bool);
        paramFromServiceMsg.a(paramObject);
        paramFromServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).edit();
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131366275) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (l2 != 0L) {
          break label194;
        }
      }
      label194:
      for (boolean bool = true;; bool = false)
      {
        paramFromServiceMsg.putBoolean(paramObject, bool).commit();
        paramBundle.putLong("uCloseNeighborVote", l1);
        paramBundle.putLong("uColseTimeEntityManager", l2);
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        a(33, true, paramBundle);
        return;
        bool = false;
        break;
      }
    }
    paramBundle.putString("uin", paramToServiceMsg.getUin());
    a(33, false, paramBundle);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label607;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1);
        }
        bool4 = bool1;
        if (!bool1) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        i1 = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i1 >= 0) {
          continue;
        }
        l1 = i1 + 4294967296L;
        bool2 = bool1;
        bool3 = bool1;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        bool2 = bool1;
        bool3 = bool1;
        paramObject.allowPeopleSee = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.a(paramObject);
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          int i1;
          long l1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      a(45, bool3, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l1 = i1;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label607:
      bool1 = bool4;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespSetCardSwitch)paramObject;
      if (bool2)
      {
        l1 = paramFromServiceMsg.uCloseNeighborVote;
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
        if (l1 == 0L)
        {
          bool1 = true;
          paramObject.setZanShowFlag(bool1);
          paramFromServiceMsg.a(paramObject);
          if (l1 != 0L) {
            break label150;
          }
        }
        label150:
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.putBoolean("modify_switch_for_near_people", bool2);
          paramBundle.putBoolean("target_switch", bool1);
          paramBundle.putString("uin", paramToServiceMsg.getUin());
          a(34, true, paramBundle);
          return;
          bool1 = false;
          break;
        }
      }
      if (paramFromServiceMsg.uCloseTimeGateVote == 0L) {}
      for (bool1 = true;; bool1 = false)
      {
        localSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131366275) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), bool1).commit();
        break;
      }
    }
    long l1 = paramToServiceMsg.extraData.getLong("target_value");
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (l1 == 0L)
    {
      bool1 = true;
      label260:
      if (paramFromServiceMsg.a(bool2, bool1)) {
        break label362;
      }
      if (!bool2) {
        break label370;
      }
      paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
      if (l1 != 0L) {
        break label364;
      }
      bool1 = true;
      label308:
      paramObject.setZanShowFlag(bool1);
      paramFromServiceMsg.a(paramObject);
    }
    label362:
    label364:
    label370:
    for (boolean bool1 = paramObject.isShowZan();; bool1 = localSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131366275) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false))
    {
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      paramBundle.putBoolean("current_switch", bool1);
      a(34, false, paramBundle);
      return;
      bool1 = false;
      break label260;
      break;
      bool1 = false;
      break label308;
    }
  }
  
  /* Error */
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 562	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +409 -> 422
    //   16: aload_3
    //   17: ifnull +405 -> 422
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 674
    //   32: iconst_2
    //   33: new 214	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 1489
    //   43: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: bipush 80
    //   63: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   66: checkcast 1491	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   69: astore_1
    //   70: aload_1
    //   71: iconst_0
    //   72: invokevirtual 1493	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(Z)Z
    //   75: istore 6
    //   77: iload 5
    //   79: istore 9
    //   81: iload 5
    //   83: ifeq +608 -> 691
    //   86: iload 5
    //   88: istore 7
    //   90: iload 5
    //   92: istore 8
    //   94: new 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 445	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: aload_3
    //   102: checkcast 563	[B
    //   105: checkcast 563	[B
    //   108: invokevirtual 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +312 -> 428
    //   119: iload 5
    //   121: istore 7
    //   123: iload 5
    //   125: istore 8
    //   127: aload_2
    //   128: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +294 -> 428
    //   137: iconst_1
    //   138: istore 5
    //   140: iload 5
    //   142: istore 7
    //   144: iload 5
    //   146: istore 8
    //   148: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: iload 5
    //   156: istore 7
    //   158: iload 5
    //   160: istore 8
    //   162: ldc_w 674
    //   165: iconst_2
    //   166: new 214	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 1495
    //   176: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 5
    //   192: istore 9
    //   194: iload 5
    //   196: ifeq +495 -> 691
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: iload 5
    //   209: istore 9
    //   211: aload_2
    //   212: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 1294	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +473 -> 691
    //   221: iload 5
    //   223: istore 7
    //   225: iload 5
    //   227: istore 8
    //   229: iload 5
    //   231: istore 9
    //   233: aload_2
    //   234: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +451 -> 691
    //   243: iload 5
    //   245: istore 7
    //   247: iload 5
    //   249: istore 8
    //   251: aload_2
    //   252: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 573	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 577	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: astore_2
    //   265: iload 5
    //   267: istore 7
    //   269: iload 5
    //   271: istore 8
    //   273: aload_2
    //   274: invokevirtual 580	java/nio/ByteBuffer:getInt	()I
    //   277: pop
    //   278: iload 5
    //   280: istore 7
    //   282: iload 5
    //   284: istore 8
    //   286: aload_2
    //   287: invokevirtual 583	java/nio/ByteBuffer:get	()B
    //   290: pop
    //   291: iload 5
    //   293: istore 7
    //   295: iload 5
    //   297: istore 8
    //   299: iload 5
    //   301: istore 9
    //   303: aload_2
    //   304: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   307: invokestatic 1298	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   310: invokevirtual 505	java/lang/Short:shortValue	()S
    //   313: iconst_1
    //   314: if_icmpne +377 -> 691
    //   317: iload 5
    //   319: istore 7
    //   321: iload 5
    //   323: istore 8
    //   325: aload_2
    //   326: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   329: istore 4
    //   331: iload 4
    //   333: sipush -25031
    //   336: if_icmpeq +98 -> 434
    //   339: iload 6
    //   341: istore 5
    //   343: iload 11
    //   345: istore 6
    //   347: iload 5
    //   349: istore 7
    //   351: iload 6
    //   353: istore 8
    //   355: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +50 -> 408
    //   361: ldc_w 674
    //   364: iconst_2
    //   365: new 214	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 1495
    //   375: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 6
    //   380: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: ldc_w 1300
    //   386: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: iload 5
    //   391: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   394: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: iload 6
    //   402: istore 8
    //   404: iload 5
    //   406: istore 7
    //   408: aload_0
    //   409: bipush 58
    //   411: iload 8
    //   413: iload 7
    //   415: invokestatic 594	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   421: return
    //   422: iconst_0
    //   423: istore 5
    //   425: goto -402 -> 23
    //   428: iconst_0
    //   429: istore 5
    //   431: goto -291 -> 140
    //   434: iload 5
    //   436: istore 7
    //   438: iload 5
    //   440: istore 8
    //   442: aload_2
    //   443: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   446: istore 4
    //   448: iload 4
    //   450: iconst_2
    //   451: if_icmpne +80 -> 531
    //   454: iload 5
    //   456: istore 7
    //   458: iload 5
    //   460: istore 8
    //   462: iload 4
    //   464: newarray byte
    //   466: astore_3
    //   467: iload 5
    //   469: istore 7
    //   471: iload 5
    //   473: istore 8
    //   475: aload_2
    //   476: aload_3
    //   477: invokevirtual 1028	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   480: pop
    //   481: iload 5
    //   483: istore 7
    //   485: iload 5
    //   487: istore 8
    //   489: aload_3
    //   490: iconst_0
    //   491: invokestatic 1117	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   494: istore 4
    //   496: iload 4
    //   498: ifne +215 -> 713
    //   501: iconst_1
    //   502: istore 6
    //   504: aload_2
    //   505: invokevirtual 1013	java/nio/ByteBuffer:getShort	()S
    //   508: ifeq +10 -> 518
    //   511: iload 12
    //   513: istore 7
    //   515: goto +187 -> 702
    //   518: aload_1
    //   519: iload 6
    //   521: iconst_0
    //   522: invokevirtual 1496	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(ZZ)V
    //   525: iconst_1
    //   526: istore 7
    //   528: goto +174 -> 702
    //   531: iload 6
    //   533: istore 5
    //   535: iload 11
    //   537: istore 6
    //   539: goto -192 -> 347
    //   542: astore_1
    //   543: iload 7
    //   545: istore 5
    //   547: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +14 -> 564
    //   553: ldc_w 674
    //   556: iconst_2
    //   557: ldc_w 1498
    //   560: aload_1
    //   561: invokestatic 932	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: iload 6
    //   566: istore 7
    //   568: iload 10
    //   570: istore 8
    //   572: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq -167 -> 408
    //   578: ldc_w 674
    //   581: iconst_2
    //   582: new 214	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 1495
    //   592: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iconst_0
    //   596: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   599: ldc_w 1300
    //   602: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: iload 6
    //   607: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   610: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: iload 6
    //   618: istore 7
    //   620: iload 10
    //   622: istore 8
    //   624: goto -216 -> 408
    //   627: astore_1
    //   628: iload 8
    //   630: istore 5
    //   632: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +42 -> 677
    //   638: ldc_w 674
    //   641: iconst_2
    //   642: new 214	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 1495
    //   652: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: iload 5
    //   657: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: ldc_w 1300
    //   663: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 6
    //   668: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_1
    //   678: athrow
    //   679: astore_1
    //   680: goto -48 -> 632
    //   683: astore_1
    //   684: goto -52 -> 632
    //   687: astore_1
    //   688: goto -141 -> 547
    //   691: iload 6
    //   693: istore 5
    //   695: iload 9
    //   697: istore 6
    //   699: goto -352 -> 347
    //   702: iload 6
    //   704: istore 5
    //   706: iload 7
    //   708: istore 6
    //   710: goto -363 -> 347
    //   713: iconst_0
    //   714: istore 6
    //   716: goto -212 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	CardHandler
    //   0	719	1	paramToServiceMsg	ToServiceMsg
    //   0	719	2	paramFromServiceMsg	FromServiceMsg
    //   0	719	3	paramObject	Object
    //   329	168	4	i1	int
    //   21	684	5	bool1	boolean
    //   75	640	6	bool2	boolean
    //   88	619	7	bool3	boolean
    //   92	537	8	bool4	boolean
    //   79	617	9	bool5	boolean
    //   1	620	10	bool6	boolean
    //   7	529	11	bool7	boolean
    //   4	508	12	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   94	115	542	java/lang/Exception
    //   127	137	542	java/lang/Exception
    //   148	154	542	java/lang/Exception
    //   162	190	542	java/lang/Exception
    //   211	221	542	java/lang/Exception
    //   233	243	542	java/lang/Exception
    //   251	265	542	java/lang/Exception
    //   273	278	542	java/lang/Exception
    //   286	291	542	java/lang/Exception
    //   303	317	542	java/lang/Exception
    //   325	331	542	java/lang/Exception
    //   442	448	542	java/lang/Exception
    //   462	467	542	java/lang/Exception
    //   475	481	542	java/lang/Exception
    //   489	496	542	java/lang/Exception
    //   94	115	627	finally
    //   127	137	627	finally
    //   148	154	627	finally
    //   162	190	627	finally
    //   211	221	627	finally
    //   233	243	627	finally
    //   251	265	627	finally
    //   273	278	627	finally
    //   286	291	627	finally
    //   303	317	627	finally
    //   325	331	627	finally
    //   442	448	627	finally
    //   462	467	627	finally
    //   475	481	627	finally
    //   489	496	627	finally
    //   504	511	679	finally
    //   518	525	679	finally
    //   547	564	683	finally
    //   504	511	687	java/lang/Exception
    //   518	525	687	java/lang/Exception
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int i1 = paramToServiceMsg.extraData.getInt("eSubCmd");
    paramBundle.putInt("eSubCmd", i1);
    paramBundle.putByte("bIsSingle", paramToServiceMsg.extraData.getByte("bIsSingle"));
    paramBundle.putByteArray("vBackground", paramToServiceMsg.extraData.getByteArray("vBackground"));
    paramBundle.putByteArray("vReqSetTemplate", paramToServiceMsg.extraData.getByteArray("vReqSetTemplate"));
    switch (i1)
    {
    default: 
      i1 = 3;
      if (26 == i1) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      }
      paramBundle = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      if (paramFromServiceMsg.isSuccess()) {
        if (26 == i1)
        {
          paramObject = paramBundle.a(paramToServiceMsg.getUin());
          paramFromServiceMsg = paramObject;
          if (paramObject == null) {
            break label737;
          }
          paramObject.vBackground = paramToServiceMsg.extraData.getByteArray("vBackground");
          paramBundle.a(paramObject);
          paramToServiceMsg = paramObject;
        }
      }
      break;
    }
    label906:
    label911:
    for (;;)
    {
      if (i1 != 41) {
        a(i1, true, paramToServiceMsg);
      }
      return;
      i1 = 24;
      break;
      i1 = 25;
      break;
      i1 = 26;
      break;
      i1 = 41;
      break;
      if (i1 == 25)
      {
        try
        {
          paramFromServiceMsg = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vTagsID"))).readObject();
          paramToServiceMsg = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
        }
        catch (Exception paramFromServiceMsg)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramFromServiceMsg);
            paramToServiceMsg.setTagInfosByte(paramFromServiceMsg);
            paramBundle.a(paramToServiceMsg);
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              boolean bool;
              continue;
              paramFromServiceMsg = null;
              continue;
              paramFromServiceMsg = null;
              paramToServiceMsg = null;
            }
            paramToServiceMsg = null;
          }
          paramFromServiceMsg = paramFromServiceMsg;
          paramToServiceMsg = null;
        }
        paramFromServiceMsg.printStackTrace();
      }
      else if (i1 == 24)
      {
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.extraData.getByte("bIsSingle"));
        paramToServiceMsg = paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      else if (i1 == 41)
      {
        if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespSetCard)))
        {
          bool = true;
          label423:
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard success : " + bool + ", data : " + paramObject);
          }
          if ((paramObject == null) || (!bool)) {
            break label911;
          }
          paramToServiceMsg = (RespSetCard)paramObject;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard RespSetCard : " + paramToServiceMsg.toString());
          }
          if ((paramToServiceMsg.stHeader == null) || (paramToServiceMsg.stHeader.iReplyCode != 0) || (paramToServiceMsg.vRespSetTemplate == null)) {
            break label911;
          }
          paramFromServiceMsg = (SSummaryCardRsp)a(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
          if (paramFromServiceMsg == null) {
            break label911;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard cardRsp res : " + paramFromServiceMsg.res);
          }
          if (paramFromServiceMsg.res != 0) {
            break label748;
          }
          paramToServiceMsg = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (paramToServiceMsg == null) {
            break label906;
          }
          paramToServiceMsg.lCurrentStyleId = paramFromServiceMsg.styleid;
          paramToServiceMsg.backgroundUrl = paramFromServiceMsg.bgurl;
          paramToServiceMsg.lCurrentBgId = paramFromServiceMsg.bgid;
          paramToServiceMsg.backgroundColor = paramFromServiceMsg.color;
          paramFromServiceMsg = paramFromServiceMsg.bgtype;
          if (paramFromServiceMsg != null) {
            paramToServiceMsg.setBgType(paramFromServiceMsg);
          }
          paramToServiceMsg.templateRet = 0;
          paramBundle.a(paramToServiceMsg);
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.edit().putBoolean("svip_profile_use_guide_shown_flag", false).commit();
          }
          paramFromServiceMsg = null;
        }
        for (;;)
        {
          if (paramToServiceMsg != null) {
            paramFromServiceMsg = paramToServiceMsg;
          }
          a(i1, true, paramFromServiceMsg);
          paramFromServiceMsg = paramToServiceMsg;
          label737:
          paramToServiceMsg = paramFromServiceMsg;
          break;
          bool = false;
          break label423;
          label748:
          paramToServiceMsg = "";
          if (!TextUtils.isEmpty(paramFromServiceMsg.emsg)) {
            paramToServiceMsg = paramFromServiceMsg.emsg;
          }
          paramFromServiceMsg = new Pair(Integer.valueOf(paramFromServiceMsg.res), paramToServiceMsg);
          paramToServiceMsg = null;
        }
        a(i1, false, paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        if (QLog.isColorLevel()) {
          QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        }
        ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[资料卡]设置个性名片失败", true);
        return;
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool7 = true;
    boolean bool6 = false;
    boolean bool1;
    boolean bool2;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch success=" + bool1);
      }
      paramFromServiceMsg = (ActivateFriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
      bool2 = paramFromServiceMsg.a(false);
      bool5 = bool1;
      if (!bool1) {
        break label661;
      }
      bool4 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject != null)
        {
          bool4 = bool1;
          bool3 = bool1;
          if (paramObject.uint32_result.get() == 0)
          {
            bool1 = true;
            bool4 = bool1;
            bool3 = bool1;
            if (QLog.isColorLevel())
            {
              bool4 = bool1;
              bool3 = bool1;
              QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1);
            }
            bool5 = bool1;
            if (!bool1) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (!paramObject.bytes_bodybuffer.has()) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (paramObject.bytes_bodybuffer.get() == null) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            l1 = Utils.a(ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt());
            bool4 = bool1;
            bool3 = bool1;
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1))) {
              continue;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = paramToServiceMsg.extraData.getBoolean("switch");
            bool3 = bool1;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l1;
        bool1 = bool4;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch ex", paramFromServiceMsg);
        }
        bool3 = bool2;
        bool1 = bool6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + false + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
        bool1 = bool6;
        continue;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        }
      }
      try
      {
        paramFromServiceMsg.a(bool5, false);
        bool2 = bool5;
        bool1 = bool7;
        if (!QLog.isColorLevel()) {
          break label654;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool5;
        continue;
        bool3 = bool2;
        continue;
      }
      a(57, bool1, Boolean.valueOf(bool3));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool4 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool4 = bool1;
        bool3 = bool1;
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch cur:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + " dwUin:" + l1);
      }
      bool1 = false;
      continue;
      label654:
      label661:
      bool1 = bool5;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel success : " + bool + ", data : " + paramObject);
      }
      if ((!bool) || (paramObject == null)) {
        break label210;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        paramBundle = paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramBundle.setLabelList(paramToServiceMsg.likes.label);
        paramFromServiceMsg.a(paramBundle);
      }
      a(52, true, paramObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(52, false, paramObject);
    return;
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(52, false, paramObject);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[资料卡]设置标签失败", true);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool4;
      }
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        bool1 = bool5;
        bool2 = bool4;
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool1 = true;
        }
        bool3 = bool1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
          bool3 = bool1;
        }
      }
      bool1 = bool3;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
          bool1 = bool2;
        }
      }
    }
    a(46, bool1, null);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    Card localCard;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + bool + ", data : " + paramObject);
      }
      paramBundle = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      localCard = paramBundle.b(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
      long l1 = paramToServiceMsg.extraData.getLong("labelId");
      if ((!bool) || (paramObject == null)) {
        break label254;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        localCard.setLabelList(paramToServiceMsg.likes.label);
        paramBundle.a(localCard);
      }
      a(53, true, new Object[] { localCard, Long.valueOf(Long.valueOf(l1).longValue()) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(53, false, localCard);
    return;
    label254:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(53, false, localCard);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[资料卡]设置标签失败", true);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    paramToServiceMsg = null;
    localToServiceMsg = paramToServiceMsg;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      localToServiceMsg = paramToServiceMsg;
      bool1 = bool2;
      if (paramObject != null)
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg = localObject;
        bool2 = bool4;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      bool3 = bool6;
      if (paramFromServiceMsg == null) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool4;
      bool3 = bool6;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label409;
      }
      bool1 = bool5;
      paramToServiceMsg = localObject;
      bool2 = bool4;
      if (paramFromServiceMsg.uint32_result.get() == 0) {
        bool1 = true;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = localObject;
        bool2 = bool1;
        QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "oidbPkg.uint32_result = " + paramFromServiceMsg.uint32_result.get());
      }
      bool3 = bool1;
      if (!bool1) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramFromServiceMsg = new Object[5];
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[0] = paramObject.rpt_msg_headinfo.get();
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[1] = Integer.valueOf(paramObject.uint32_import_state.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[2] = Integer.valueOf(paramObject.uint32_import_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[3] = Integer.valueOf(paramObject.uint32_import_rest_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[4] = Integer.valueOf(paramObject.uint32_rest_count_in_qzone.get());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        boolean bool3;
        localToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramFromServiceMsg.toString());
          localToServiceMsg = paramToServiceMsg;
          bool1 = bool2;
          continue;
          paramToServiceMsg = null;
          bool1 = bool3;
        }
      }
    }
    localToServiceMsg = paramToServiceMsg;
    a(48, bool1, localToServiceMsg);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYMakeFriendsCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        paramBundle = paramToServiceMsg.b(paramObject);
        paramBundle.uin = paramObject;
        paramBundle.strNick = paramFromServiceMsg.stMakeFriendsCard.strNick;
        paramBundle.shGender = paramFromServiceMsg.stMakeFriendsCard.shGender;
        paramBundle.shAge = paramFromServiceMsg.stMakeFriendsCard.shAge;
        paramBundle.nFaceID = paramFromServiceMsg.stMakeFriendsCard.nFaceID;
        paramBundle.strCertificationInfo = paramFromServiceMsg.stMakeFriendsCard.strCertificationInfo;
        paramBundle.shType = paramFromServiceMsg.stMakeFriendsCard.stIntro.shType;
        paramBundle.vContent = paramFromServiceMsg.stMakeFriendsCard.stIntro.vContent;
        paramBundle.vQQFaceID = paramFromServiceMsg.stMakeFriendsCard.vQQFaceID;
        paramBundle.bWeiboInfo = paramFromServiceMsg.bWeiboInfo;
        paramBundle.bQzoneInfo = paramFromServiceMsg.bQzoneInfo;
        paramBundle.nSameFriendsNum = paramFromServiceMsg.nSameFriendsNum;
        paramBundle.strCompanySame = paramFromServiceMsg.strCompany;
        paramBundle.strSchoolSame = paramFromServiceMsg.strSchool;
        paramBundle.bSingle = paramFromServiceMsg.stMakeFriendsCard.bSingle;
        paramBundle.lVisitCount = paramFromServiceMsg.stMakeFriendsCard.lVisitCount;
        if ((i1 == 0) || (paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp > paramBundle.uFaceTimeStamp))
        {
          paramBundle.uFaceTimeStamp = paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp;
          paramBundle.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        if (paramFromServiceMsg.stMakeFriendsCard.lVoteCount > paramBundle.lVoteCount) {
          paramBundle.lVoteCount = paramFromServiceMsg.stMakeFriendsCard.lVoteCount;
        }
        paramObject = paramFromServiceMsg.stMakeFriendsCard.vTags;
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramObject);
          paramBundle.setTagInfosByte(paramObject);
        }
        paramBundle.eUserIdentityType = ((byte)paramFromServiceMsg.stMakeFriendsCard.eUserIdentityType);
        paramBundle.vBackground = paramFromServiceMsg.stMakeFriendsCard.vBackground;
        paramBundle.bVoted = paramFromServiceMsg.bVoted;
        paramBundle.iFaceNum = paramFromServiceMsg.stMakeFriendsCard.iFaceNum;
        paramBundle.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramBundle.iQQLevel = paramFromServiceMsg.stMakeFriendsCard.iQQLevel;
        paramToServiceMsg.a(paramBundle);
        paramToServiceMsg.a(paramBundle.uin, (short)paramBundle.nFaceID, paramBundle.strNick, paramBundle.strSign);
        a(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  /* Error */
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 4
    //   12: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 1759
    //   21: iconst_2
    //   22: new 214	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 1761
    //   32: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 562	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aload 11
    //   56: astore_1
    //   57: iload 8
    //   59: istore 7
    //   61: aload_2
    //   62: invokevirtual 562	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 11
    //   70: astore_1
    //   71: iload 8
    //   73: istore 7
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 445	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 563	[B
    //   92: checkcast 563	[B
    //   95: invokevirtual 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 840	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +406 -> 533
    //   130: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 1759
    //   139: iconst_2
    //   140: new 214	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1763
    //   150: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 1700	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 1701	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 573	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 1702	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 1700	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 792	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 1706	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 1711	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 1714	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 1717	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 1720	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 1723	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 214	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 1765
    //   283: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 322	java/util/List
    //   299: astore_3
    //   300: iload 4
    //   302: aload_3
    //   303: invokeinterface 323 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 4
    //   314: invokeinterface 327 2 0
    //   319: checkcast 1767	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 1769
    //   328: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 1772	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 1774
    //   345: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 1778	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 1784
    //   362: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 1787	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 1789
    //   379: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 1791
    //   396: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 820	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 1793
    //   408: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 820	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 1795
    //   420: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 820	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 1797
    //   432: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 820	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 1759
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 6
    //   455: istore 7
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 7
    //   462: aload_1
    //   463: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   466: return
    //   467: astore_2
    //   468: iload 9
    //   470: istore 6
    //   472: aload 10
    //   474: astore_3
    //   475: aload_3
    //   476: astore_1
    //   477: iload 6
    //   479: istore 7
    //   481: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 1759
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 1678	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_3
    //   499: astore_1
    //   500: iload 6
    //   502: istore 7
    //   504: goto -47 -> 457
    //   507: astore_2
    //   508: aload 10
    //   510: astore_3
    //   511: goto -36 -> 475
    //   514: astore_2
    //   515: aload_1
    //   516: astore_3
    //   517: goto -42 -> 475
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -69 -> 453
    //   525: aconst_null
    //   526: astore_1
    //   527: iconst_0
    //   528: istore 6
    //   530: goto -77 -> 453
    //   533: iconst_0
    //   534: istore 6
    //   536: goto -406 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	CardHandler
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   10	378	4	i1	int
    //   123	3	5	i2	int
    //   1	534	6	bool1	boolean
    //   59	444	7	bool2	boolean
    //   4	68	8	bool3	boolean
    //   7	462	9	bool4	boolean
    //   49	460	10	localHeadInfo	tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo
    //   52	17	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   87	102	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	169	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	203	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	287	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   293	300	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	383	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   392	453	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYCommonCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        paramBundle = paramToServiceMsg.b(paramObject);
        paramBundle.uin = paramObject;
        paramBundle.iQQLevel = paramFromServiceMsg.stCommonCard.iQQLevel;
        paramBundle.strNick = paramFromServiceMsg.stCommonCard.strNick;
        paramBundle.shGender = paramFromServiceMsg.stCommonCard.shGender;
        paramBundle.shAge = paramFromServiceMsg.stCommonCard.shAge;
        paramBundle.nFaceID = paramFromServiceMsg.stCommonCard.nFaceID;
        paramBundle.strSign = paramFromServiceMsg.stCommonCard.strSign;
        paramBundle.strCompany = paramFromServiceMsg.stCommonCard.strCompany;
        paramBundle.strSchool = paramFromServiceMsg.stCommonCard.strSchool;
        paramBundle.strReMark = paramFromServiceMsg.strReMark;
        paramBundle.bWeiboInfo = paramFromServiceMsg.bWeiboInfo;
        paramBundle.bQzoneInfo = paramFromServiceMsg.bQzoneInfo;
        paramBundle.bSingle = paramFromServiceMsg.stCommonCard.bSingle;
        paramBundle.lVisitCount = paramFromServiceMsg.stCommonCard.lVisitCount;
        if (paramFromServiceMsg.stCommonCard.lVoteCount > paramBundle.lVoteCount) {
          paramBundle.lVoteCount = paramFromServiceMsg.stCommonCard.lVoteCount;
        }
        if ((i1 == 0) || (paramFromServiceMsg.stCommonCard.uFaceTimeStamp > paramBundle.uFaceTimeStamp))
        {
          paramBundle.uFaceTimeStamp = paramFromServiceMsg.stCommonCard.uFaceTimeStamp;
          paramBundle.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        paramObject = paramFromServiceMsg.stCommonCard.vTags;
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramObject);
          paramBundle.setTagInfosByte(paramObject);
        }
        paramBundle.eUserIdentityType = ((byte)paramFromServiceMsg.stCommonCard.eUserIdentityType);
        paramBundle.vBackground = paramFromServiceMsg.stCommonCard.vBackground;
        paramBundle.bVoted = paramFromServiceMsg.bVoted;
        paramBundle.iFaceNum = paramFromServiceMsg.stCommonCard.iFaceNum;
        paramBundle.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramToServiceMsg.a(paramBundle);
        paramToServiceMsg.b(paramBundle.uin, paramBundle.strReMark);
        paramToServiceMsg.a(paramBundle.uin, (short)paramBundle.nFaceID, paramBundle.strNick, paramBundle.strSign);
        a(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  /* Error */
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_2
    //   4: invokevirtual 562	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +372 -> 379
    //   10: aload_3
    //   11: ifnull +368 -> 379
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 674
    //   26: iconst_2
    //   27: new 214	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1835
    //   37: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 1105	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 1323
    //   61: invokevirtual 1327	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   72: pop
    //   73: iload 5
    //   75: ifeq +465 -> 540
    //   78: iload 5
    //   80: istore 6
    //   82: iload 5
    //   84: istore 7
    //   86: new 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   89: dup
    //   90: invokespecial 445	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   93: aload_3
    //   94: checkcast 563	[B
    //   97: checkcast 563	[B
    //   100: invokevirtual 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 444	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +277 -> 385
    //   111: iload 5
    //   113: istore 6
    //   115: iload 5
    //   117: istore 7
    //   119: aload_2
    //   120: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: ifne +259 -> 385
    //   129: iconst_1
    //   130: istore 5
    //   132: iload 5
    //   134: istore 6
    //   136: iload 5
    //   138: istore 7
    //   140: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +39 -> 182
    //   146: iload 5
    //   148: istore 6
    //   150: iload 5
    //   152: istore 7
    //   154: ldc_w 674
    //   157: iconst_2
    //   158: new 214	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 1837
    //   168: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload 5
    //   173: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   176: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iload 5
    //   184: ifeq +426 -> 610
    //   187: iload 5
    //   189: istore 6
    //   191: iload 5
    //   193: istore 7
    //   195: aload_2
    //   196: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 1294	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   202: ifeq +408 -> 610
    //   205: iload 5
    //   207: istore 6
    //   209: iload 5
    //   211: istore 7
    //   213: aload_2
    //   214: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +390 -> 610
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: aload_2
    //   232: getfield 509	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 572	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 573	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 577	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 580	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: i2l
    //   252: lstore 10
    //   254: iload 4
    //   256: ifge +16 -> 272
    //   259: iload 4
    //   261: ldc_w 1295
    //   264: iand
    //   265: i2l
    //   266: ldc2_w 1330
    //   269: lor
    //   270: lstore 10
    //   272: iload 5
    //   274: istore 6
    //   276: iload 5
    //   278: istore 7
    //   280: aload_1
    //   281: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   284: ldc_w 1333
    //   287: invokevirtual 647	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   290: istore 9
    //   292: iload 5
    //   294: istore 6
    //   296: iload 5
    //   298: istore 7
    //   300: aload_0
    //   301: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   304: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   307: lload 10
    //   309: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: istore 5
    //   317: iload 5
    //   319: ifeq +72 -> 391
    //   322: iconst_1
    //   323: istore 5
    //   325: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +50 -> 378
    //   331: ldc_w 674
    //   334: iconst_2
    //   335: new 214	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 1837
    //   345: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 5
    //   350: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   353: ldc_w 1300
    //   356: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   363: ldc_w 1333
    //   366: invokevirtual 647	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   369: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   372: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: iconst_0
    //   380: istore 5
    //   382: goto -365 -> 17
    //   385: iconst_0
    //   386: istore 5
    //   388: goto -256 -> 132
    //   391: iload 9
    //   393: ifne +3 -> 396
    //   396: iload 8
    //   398: istore 5
    //   400: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -78 -> 325
    //   406: ldc_w 674
    //   409: iconst_2
    //   410: new 214	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 1839
    //   420: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: lload 10
    //   425: invokevirtual 684	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 681
    //   431: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   441: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: iload 8
    //   452: istore 5
    //   454: goto -129 -> 325
    //   457: astore_2
    //   458: iconst_0
    //   459: istore 7
    //   461: iload 7
    //   463: istore 6
    //   465: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +18 -> 486
    //   471: iload 7
    //   473: istore 6
    //   475: ldc_w 674
    //   478: iconst_2
    //   479: ldc_w 1841
    //   482: aload_2
    //   483: invokestatic 932	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -111 -> 378
    //   492: ldc_w 674
    //   495: iconst_2
    //   496: new 214	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 1837
    //   506: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: iload 7
    //   511: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: ldc_w 1300
    //   517: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   524: ldc_w 1333
    //   527: invokevirtual 647	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   530: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: return
    //   540: goto -215 -> 325
    //   543: astore_2
    //   544: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +50 -> 597
    //   550: ldc_w 674
    //   553: iconst_2
    //   554: new 214	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 1837
    //   564: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: iload 6
    //   569: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: ldc_w 1300
    //   575: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   582: ldc_w 1333
    //   585: invokevirtual 647	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   588: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   591: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload_2
    //   598: athrow
    //   599: astore_2
    //   600: iconst_0
    //   601: istore 6
    //   603: goto -59 -> 544
    //   606: astore_2
    //   607: goto -146 -> 461
    //   610: goto -285 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	CardHandler
    //   0	613	1	paramToServiceMsg	ToServiceMsg
    //   0	613	2	paramFromServiceMsg	FromServiceMsg
    //   0	613	3	paramObject	Object
    //   247	18	4	i1	int
    //   15	438	5	bool1	boolean
    //   80	522	6	bool2	boolean
    //   84	426	7	bool3	boolean
    //   1	450	8	bool4	boolean
    //   290	102	9	bool5	boolean
    //   252	172	10	l1	long
    // Exception table:
    //   from	to	target	type
    //   400	450	457	java/lang/Exception
    //   86	107	543	finally
    //   119	129	543	finally
    //   140	146	543	finally
    //   154	182	543	finally
    //   195	205	543	finally
    //   213	223	543	finally
    //   231	249	543	finally
    //   280	292	543	finally
    //   300	317	543	finally
    //   465	471	543	finally
    //   475	486	543	finally
    //   400	450	599	finally
    //   86	107	606	java/lang/Exception
    //   119	129	606	java/lang/Exception
    //   140	146	606	java/lang/Exception
    //   154	182	606	java/lang/Exception
    //   195	205	606	java/lang/Exception
    //   213	223	606	java/lang/Exception
    //   231	249	606	java/lang/Exception
    //   280	292	606	java/lang/Exception
    //   300	317	606	java/lang/Exception
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramFromServiceMsg = (RespCommonCard)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramBundle = paramFromServiceMsg.stHeader.lUIN + "";
        int i1 = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
        paramObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramToServiceMsg = paramObject.b(paramToServiceMsg.getUin());
        paramToServiceMsg.uin = paramBundle;
        paramToServiceMsg.iQQLevel = paramFromServiceMsg.stCommonCard.iQQLevel;
        paramToServiceMsg.strNick = paramFromServiceMsg.stCommonCard.strNick;
        paramToServiceMsg.shGender = paramFromServiceMsg.stCommonCard.shGender;
        paramToServiceMsg.shAge = paramFromServiceMsg.stCommonCard.shAge;
        paramToServiceMsg.nFaceID = paramFromServiceMsg.stCommonCard.nFaceID;
        paramToServiceMsg.strSign = paramFromServiceMsg.stCommonCard.strSign;
        paramToServiceMsg.strCompany = paramFromServiceMsg.stCommonCard.strCompany;
        paramToServiceMsg.strSchool = paramFromServiceMsg.stCommonCard.strSchool;
        paramToServiceMsg.vQQFaceID = paramFromServiceMsg.vQQFaceID;
        paramToServiceMsg.bSingle = paramFromServiceMsg.stCommonCard.bSingle;
        paramToServiceMsg.lVisitCount = paramFromServiceMsg.stCommonCard.lVisitCount;
        if (paramFromServiceMsg.stCommonCard.lVoteCount > paramToServiceMsg.lVoteCount) {
          paramToServiceMsg.lVoteCount = paramFromServiceMsg.stCommonCard.lVoteCount;
        }
        if ((i1 == 0) || (paramFromServiceMsg.stCommonCard.uFaceTimeStamp > paramToServiceMsg.uFaceTimeStamp))
        {
          paramToServiceMsg.uFaceTimeStamp = paramFromServiceMsg.stCommonCard.uFaceTimeStamp;
          paramToServiceMsg.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        paramToServiceMsg.iVoteIncrement = paramFromServiceMsg.iVoteIncrement;
        paramBundle = paramFromServiceMsg.stCommonCard.vTags;
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle);
          paramToServiceMsg.setTagInfosByte(paramBundle);
        }
        paramToServiceMsg.eUserIdentityType = ((byte)paramFromServiceMsg.stCommonCard.eUserIdentityType);
        paramToServiceMsg.vBackground = paramFromServiceMsg.stCommonCard.vBackground;
        paramToServiceMsg.iFaceNum = paramFromServiceMsg.stCommonCard.iFaceNum;
        paramToServiceMsg.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramObject.a(paramToServiceMsg.uin, (short)paramToServiceMsg.nFaceID, paramToServiceMsg.strNick, paramToServiceMsg.strSign);
        paramFromServiceMsg = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.a(paramToServiceMsg.uin) != null)) {
          paramFromServiceMsg.e();
        }
        a(1, true, paramToServiceMsg);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() , resp.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    long l1 = paramToServiceMsg.extraData.getLong("pttcenter_targetuin");
    int i2 = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    int i1 = 9006;
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    boolean bool1;
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespVoiceManage)))
    {
      bool1 = true;
      if (!bool1) {}
    }
    else
    {
      try
      {
        localRespHead = (SummaryCard.RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("handleVoiceManager() respHead.iResult = ");
          if (localRespHead == null) {
            break label501;
          }
          paramBundle = Integer.valueOf(localRespHead.iResult);
          label160:
          QLog.d("Q.profilecard.SummaryCard", 2, paramBundle);
        }
        if (localRespHead != null) {
          break label507;
        }
        bool1 = false;
        i1 = 9045;
        localStringBuilder1.append("|wupbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          SummaryCard.RespHead localRespHead;
          label209:
          short s1;
          label377:
          boolean bool2;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.SummaryCard", 2, paramBundle.toString());
          }
          bool1 = false;
          i1 = 9045;
          localStringBuilder1.append("|exception: ").append(paramBundle.toString()).append("|wufbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() lUin = " + l1 + ", eOptype = " + i2 + ", success = " + bool1);
      }
      if (!bool1) {
        break label741;
      }
      paramBundle = (RespVoiceManage)paramObject;
      if (l1 > 0L)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        paramObject = paramFromServiceMsg.b(String.valueOf(l1));
        if (paramBundle.eOpType != 1) {
          break label650;
        }
        paramBundle = paramToServiceMsg.extraData.getString("pttcenter_filekey");
        s1 = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
        paramObject.strVoiceFilekey = paramBundle;
        paramObject.shDuration = s1;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "上传成功");
        }
        bool2 = paramFromServiceMsg.a(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "更新结果  bRet = " + bool2);
        }
        a(35, true, new Object[] { String.valueOf(l1), Integer.valueOf(i2), paramObject });
      }
    }
    for (;;)
    {
      if (i2 == 1) {
        ProfileCardUtil.a(String.valueOf(l1), 0, bool1, paramToServiceMsg.extraData.getString("pttcenter_filekey"), "0", ProfileCardUtil.a(), 0, i1, 0L, localStringBuilder1.toString(), "");
      }
      return;
      bool1 = false;
      break;
      label501:
      paramBundle = null;
      break label160;
      label507:
      if (localRespHead.iResult != 0)
      {
        localStringBuilder1.append("|iResult: ").append(localRespHead.iResult);
        bool1 = false;
        i1 = 9007;
        break label209;
      }
      bool1 = true;
      break label209;
      i1 = 9311;
      localStringBuilder1.append("|resultcode: ").append(paramFromServiceMsg.getResultCode()).append("|reason: ").append(MessageHandler.a(paramFromServiceMsg));
      break label209;
      label650:
      if (paramBundle.eOpType == 2)
      {
        paramObject.strVoiceFilekey = "";
        paramObject.shDuration = 0;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (!QLog.isColorLevel()) {
          break label377;
        }
        QLog.d("Q.profilecard.SummaryCard", 2, "删除成功");
        break label377;
      }
      if (paramBundle.eOpType != 3) {
        break label377;
      }
      if (paramObject.bRead != 1) {
        paramObject.bRead = 1;
      }
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("Q.profilecard.SummaryCard", 2, "已读标识设置成功");
      break label377;
      label741:
      a(35, false, new Object[] { String.valueOf(l1), Integer.valueOf(i2), null });
    }
  }
  
  /* Error */
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc_w 1858
    //   9: iconst_2
    //   10: new 214	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1938
    //   20: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 747	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   27: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 804	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   39: ifeq +4791 -> 4830
    //   42: invokestatic 1943	java/lang/System:currentTimeMillis	()J
    //   45: lstore 11
    //   47: aconst_null
    //   48: astore 4
    //   50: aload_2
    //   51: invokevirtual 562	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   54: ifeq +310 -> 364
    //   57: aload_3
    //   58: instanceof 1945
    //   61: ifeq +303 -> 364
    //   64: iconst_1
    //   65: istore 6
    //   67: iload 6
    //   69: ifeq +4756 -> 4825
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual 1870	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   77: ldc_w 1872
    //   80: new 1874	SummaryCard/RespHead
    //   83: dup
    //   84: invokespecial 1875	SummaryCard/RespHead:<init>	()V
    //   87: invokevirtual 1552	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 1874	SummaryCard/RespHead
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +275 -> 370
    //   98: aload_2
    //   99: getfield 1880	SummaryCard/RespHead:iResult	I
    //   102: ifne +268 -> 370
    //   105: iconst_1
    //   106: istore 6
    //   108: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +33 -> 144
    //   114: ldc_w 1858
    //   117: iconst_2
    //   118: new 214	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 1947
    //   128: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: getfield 1880	SummaryCard/RespHead:iResult	I
    //   135: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_1
    //   145: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   148: ldc_w 387
    //   151: invokevirtual 613	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   154: lstore 13
    //   156: aload_1
    //   157: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   160: ldc_w 1949
    //   163: invokevirtual 392	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 4
    //   168: aload_1
    //   169: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   172: ldc_w 1951
    //   175: invokevirtual 880	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   178: istore 8
    //   180: iload 6
    //   182: ifeq +4563 -> 4745
    //   185: aload_0
    //   186: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   189: bipush 49
    //   191: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   194: checkcast 423	com/tencent/mobileqq/app/FriendsManager
    //   197: astore 17
    //   199: aload_0
    //   200: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   203: bipush 50
    //   205: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   208: checkcast 1953	com/tencent/mobileqq/app/TroopManager
    //   211: astore 18
    //   213: aload_3
    //   214: checkcast 1945	SummaryCard/RespSummaryCard
    //   217: astore 16
    //   219: lload 13
    //   221: lconst_0
    //   222: lcmp
    //   223: ifgt +186 -> 409
    //   226: iload 8
    //   228: bipush 41
    //   230: if_icmpeq +179 -> 409
    //   233: iload 8
    //   235: bipush 6
    //   237: if_icmpeq +172 -> 409
    //   240: aload 17
    //   242: aload 4
    //   244: invokevirtual 1956	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   247: astore_1
    //   248: aload_1
    //   249: aload 16
    //   251: getfield 1959	SummaryCard/RespSummaryCard:bAge	B
    //   254: putfield 1962	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   257: aload_1
    //   258: aload 16
    //   260: getfield 1965	SummaryCard/RespSummaryCard:bSex	B
    //   263: putfield 1966	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   266: aload_1
    //   267: aload 16
    //   269: getfield 1967	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   272: putfield 1970	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   275: aload_1
    //   276: aload 16
    //   278: getfield 1971	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   281: putfield 1972	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   284: aload_1
    //   285: aload 16
    //   287: getfield 1973	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   290: putfield 1974	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   293: aload_1
    //   294: aload 16
    //   296: getfield 1975	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   299: putfield 1976	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   302: aload_1
    //   303: aload 16
    //   305: getfield 1979	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   308: putfield 1980	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   311: aload 17
    //   313: aload_1
    //   314: invokevirtual 1983	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   317: pop
    //   318: aload_0
    //   319: iconst_1
    //   320: iconst_1
    //   321: aload_1
    //   322: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   325: invokestatic 804	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   328: ifeq +35 -> 363
    //   331: ldc_w 1858
    //   334: iconst_4
    //   335: new 214	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 1985
    //   345: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokestatic 1943	java/lang/System:currentTimeMillis	()J
    //   351: lload 11
    //   353: lsub
    //   354: invokevirtual 684	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   357: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: return
    //   364: iconst_0
    //   365: istore 6
    //   367: goto -300 -> 67
    //   370: iconst_0
    //   371: istore 6
    //   373: goto -265 -> 108
    //   376: astore 16
    //   378: aload 4
    //   380: astore_2
    //   381: aload 16
    //   383: astore 4
    //   385: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +15 -> 403
    //   391: ldc_w 1858
    //   394: iconst_2
    //   395: aload 4
    //   397: invokevirtual 1919	java/lang/Exception:toString	()Ljava/lang/String;
    //   400: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iconst_0
    //   404: istore 6
    //   406: goto -262 -> 144
    //   409: aload_1
    //   410: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   413: ldc_w 1987
    //   416: invokevirtual 647	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   419: iconst_1
    //   420: if_icmpne +1292 -> 1712
    //   423: aload_0
    //   424: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: invokevirtual 650	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   430: invokevirtual 656	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   433: astore 4
    //   435: aload_1
    //   436: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   439: ldc_w 1989
    //   442: lconst_0
    //   443: invokevirtual 1992	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   446: lstore 11
    //   448: aconst_null
    //   449: astore_1
    //   450: lload 11
    //   452: lconst_0
    //   453: lcmp
    //   454: ifle +30 -> 484
    //   457: aload 4
    //   459: ldc_w 658
    //   462: ldc_w 1994
    //   465: iconst_1
    //   466: anewarray 300	java/lang/String
    //   469: dup
    //   470: iconst_0
    //   471: lload 11
    //   473: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   476: aastore
    //   477: invokevirtual 665	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   480: checkcast 658	com/tencent/mobileqq/data/NearbyPeopleCard
    //   483: astore_1
    //   484: aload_1
    //   485: astore_3
    //   486: aload_1
    //   487: ifnonnull +42 -> 529
    //   490: aload_1
    //   491: astore_3
    //   492: aload 16
    //   494: getfield 1995	SummaryCard/RespSummaryCard:lUIN	J
    //   497: lconst_0
    //   498: lcmp
    //   499: ifle +30 -> 529
    //   502: aload 4
    //   504: ldc_w 658
    //   507: ldc_w 660
    //   510: iconst_1
    //   511: anewarray 300	java/lang/String
    //   514: dup
    //   515: iconst_0
    //   516: lload 13
    //   518: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   521: aastore
    //   522: invokevirtual 665	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   525: checkcast 658	com/tencent/mobileqq/data/NearbyPeopleCard
    //   528: astore_3
    //   529: aload_3
    //   530: ifnonnull +4290 -> 4820
    //   533: new 658	com/tencent/mobileqq/data/NearbyPeopleCard
    //   536: dup
    //   537: invokespecial 847	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   540: astore_1
    //   541: aload 16
    //   543: getfield 1999	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   546: astore_3
    //   547: aload_1
    //   548: aload 16
    //   550: getfield 1995	SummaryCard/RespSummaryCard:lUIN	J
    //   553: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   556: putfield 850	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   559: lload 11
    //   561: lconst_0
    //   562: lcmp
    //   563: ifle +9 -> 572
    //   566: aload_1
    //   567: lload 11
    //   569: putfield 2001	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   572: iload 8
    //   574: ifeq +21 -> 595
    //   577: lload 13
    //   579: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   582: aload_0
    //   583: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   586: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   589: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   592: ifeq +524 -> 1116
    //   595: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   598: ifeq +48 -> 646
    //   601: ldc_w 1858
    //   604: iconst_2
    //   605: new 214	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 2003
    //   615: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 16
    //   620: getfield 2006	SummaryCard/RespSummaryCard:iVoteCount	I
    //   623: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   626: ldc_w 2008
    //   629: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload 16
    //   634: getfield 2011	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   637: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload_1
    //   647: aload 16
    //   649: getfield 2006	SummaryCard/RespSummaryCard:iVoteCount	I
    //   652: putfield 668	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   655: aload_1
    //   656: aload 16
    //   658: getfield 2011	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   661: putfield 2014	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   664: aload 17
    //   666: lload 13
    //   668: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   671: invokevirtual 933	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   674: astore 18
    //   676: aload 18
    //   678: aload_1
    //   679: getfield 2014	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   682: putfield 1396	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   685: aload 18
    //   687: aload_1
    //   688: getfield 668	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   691: i2l
    //   692: putfield 431	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   695: aload 17
    //   697: aload 18
    //   699: invokevirtual 437	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   702: pop
    //   703: aload_1
    //   704: aload 16
    //   706: getfield 1967	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   709: putfield 863	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   712: aload_1
    //   713: aload 16
    //   715: getfield 2015	SummaryCard/RespSummaryCard:vRichSign	[B
    //   718: putfield 860	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   721: aload_1
    //   722: aload_3
    //   723: getfield 2020	SummaryCard/DateCard:bMarriage	B
    //   726: putfield 870	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   729: aload_1
    //   730: aload 16
    //   732: getfield 1965	SummaryCard/RespSummaryCard:bSex	B
    //   735: putfield 873	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   738: aload_1
    //   739: aload 16
    //   741: getfield 1959	SummaryCard/RespSummaryCard:bAge	B
    //   744: putfield 884	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   747: aload_1
    //   748: aload 16
    //   750: getfield 2023	SummaryCard/RespSummaryCard:iBirthday	I
    //   753: putfield 882	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   756: aload_1
    //   757: aload_3
    //   758: getfield 2026	SummaryCard/DateCard:uProfession	J
    //   761: l2i
    //   762: putfield 892	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   765: aload_1
    //   766: aload_3
    //   767: getfield 2027	SummaryCard/DateCard:bConstellation	B
    //   770: putfield 887	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   773: aload_1
    //   774: aload_3
    //   775: getfield 2030	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   778: putfield 2033	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   781: aload_1
    //   782: aload_3
    //   783: getfield 2036	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   786: putfield 2039	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   789: aload_1
    //   790: aload_3
    //   791: getfield 2042	SummaryCard/DateCard:vFaces	[B
    //   794: putfield 2045	com/tencent/mobileqq/data/NearbyPeopleCard:photoInfoes	[B
    //   797: aload_1
    //   798: aload 16
    //   800: getfield 2048	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   803: putfield 2051	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   806: aload_1
    //   807: aload_3
    //   808: getfield 2054	SummaryCard/DateCard:vDateInfo	[B
    //   811: putfield 2057	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   814: aload_1
    //   815: aload_3
    //   816: getfield 2058	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   819: putfield 894	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   822: aload_1
    //   823: aload_3
    //   824: getfield 2059	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   827: putfield 896	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   830: aload_1
    //   831: aload_3
    //   832: getfield 2062	SummaryCard/DateCard:uHomeCountry	J
    //   835: invokestatic 1066	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   838: putfield 902	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   841: aload_1
    //   842: aload_3
    //   843: getfield 2065	SummaryCard/DateCard:uHomeProvince	J
    //   846: invokestatic 1066	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   849: putfield 905	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   852: aload_1
    //   853: aload_3
    //   854: getfield 2068	SummaryCard/DateCard:uHomeCity	J
    //   857: invokestatic 1066	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   860: putfield 908	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   863: aload_1
    //   864: aload_3
    //   865: getfield 2071	SummaryCard/DateCard:uHomeZone	J
    //   868: invokestatic 1066	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   871: putfield 911	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   874: aload_1
    //   875: aload 16
    //   877: getfield 2074	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   880: putfield 2077	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   883: aload_1
    //   884: aload 16
    //   886: getfield 2080	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   889: putfield 2083	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   892: aload_1
    //   893: aload 16
    //   895: getfield 2086	SummaryCard/RespSummaryCard:ulShowControl	J
    //   898: putfield 2089	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   901: aload_1
    //   902: aload 16
    //   904: getfield 2092	SummaryCard/RespSummaryCard:lUserFlag	J
    //   907: putfield 2095	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   910: aload_1
    //   911: aload 16
    //   913: getfield 2098	SummaryCard/RespSummaryCard:vSeed	[B
    //   916: putfield 2099	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   919: aload_1
    //   920: aload 16
    //   922: getfield 2102	SummaryCard/RespSummaryCard:lCacheControl	J
    //   925: invokevirtual 2106	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   928: aload_1
    //   929: invokestatic 1943	java/lang/System:currentTimeMillis	()J
    //   932: putfield 2109	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   935: aload_1
    //   936: iload 8
    //   938: putfield 2112	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   941: aload 17
    //   943: ifnull +9 -> 952
    //   946: aload 17
    //   948: aload_1
    //   949: invokevirtual 2115	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   952: aload 16
    //   954: getfield 2118	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   957: ifne +180 -> 1137
    //   960: aload_1
    //   961: iconst_1
    //   962: putfield 669	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   965: aload_2
    //   966: ifnull +11 -> 977
    //   969: aload_1
    //   970: aload_2
    //   971: getfield 2121	SummaryCard/RespHead:vCookies	[B
    //   974: putfield 2122	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   977: aload_1
    //   978: getfield 2095	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   981: ldc2_w 2123
    //   984: land
    //   985: lconst_0
    //   986: lcmp
    //   987: ifeq +158 -> 1145
    //   990: aload_1
    //   991: iconst_1
    //   992: putfield 918	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   995: aload_1
    //   996: getfield 2095	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   999: ldc2_w 2125
    //   1002: land
    //   1003: lconst_0
    //   1004: lcmp
    //   1005: ifeq +148 -> 1153
    //   1008: aload_1
    //   1009: iconst_1
    //   1010: putfield 921	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1013: aload_1
    //   1014: invokevirtual 2129	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1017: ifne +200 -> 1217
    //   1020: aload_1
    //   1021: ldc_w 298
    //   1024: putfield 2132	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1027: aload_1
    //   1028: ldc_w 298
    //   1031: putfield 2135	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1034: aload_1
    //   1035: ldc_w 298
    //   1038: putfield 2138	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1041: aload 16
    //   1043: getfield 2142	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1046: astore_2
    //   1047: aload_2
    //   1048: ifnull +169 -> 1217
    //   1051: aload_2
    //   1052: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1055: ifnull +162 -> 1217
    //   1058: aload_2
    //   1059: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1062: invokevirtual 733	java/util/ArrayList:size	()I
    //   1065: ifle +152 -> 1217
    //   1068: iconst_0
    //   1069: istore 6
    //   1071: iload 6
    //   1073: aload_2
    //   1074: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1077: invokevirtual 733	java/util/ArrayList:size	()I
    //   1080: if_icmpge +137 -> 1217
    //   1083: iload 6
    //   1085: ifne +76 -> 1161
    //   1088: aload_1
    //   1089: aload_2
    //   1090: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1093: iload 6
    //   1095: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1098: checkcast 2149	SummaryCard/PhotoInfo
    //   1101: getfield 2152	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1104: putfield 2132	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1107: iload 6
    //   1109: iconst_1
    //   1110: iadd
    //   1111: istore 6
    //   1113: goto -42 -> 1071
    //   1116: aload_1
    //   1117: aload 16
    //   1119: getfield 2006	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1122: putfield 668	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1125: aload_1
    //   1126: aload 16
    //   1128: getfield 2011	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1131: putfield 2014	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1134: goto -431 -> 703
    //   1137: aload_1
    //   1138: iconst_0
    //   1139: putfield 669	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1142: goto -177 -> 965
    //   1145: aload_1
    //   1146: iconst_0
    //   1147: putfield 918	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1150: goto -155 -> 995
    //   1153: aload_1
    //   1154: iconst_0
    //   1155: putfield 921	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1158: goto -145 -> 1013
    //   1161: iload 6
    //   1163: iconst_1
    //   1164: if_icmpne +25 -> 1189
    //   1167: aload_1
    //   1168: aload_2
    //   1169: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1172: iload 6
    //   1174: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1177: checkcast 2149	SummaryCard/PhotoInfo
    //   1180: getfield 2152	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1183: putfield 2135	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1186: goto -79 -> 1107
    //   1189: iload 6
    //   1191: iconst_2
    //   1192: if_icmpne -85 -> 1107
    //   1195: aload_1
    //   1196: aload_2
    //   1197: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1200: iload 6
    //   1202: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1205: checkcast 2149	SummaryCard/PhotoInfo
    //   1208: getfield 2152	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1211: putfield 2138	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1214: goto -107 -> 1107
    //   1217: aload 16
    //   1219: getfield 2155	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1222: ifnull +29 -> 1251
    //   1225: aload_1
    //   1226: aload_0
    //   1227: aload 16
    //   1229: getfield 2155	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1232: ldc_w 2157
    //   1235: new 2159	GameCenter/RespLastGameInfo
    //   1238: dup
    //   1239: invokespecial 2160	GameCenter/RespLastGameInfo:<init>	()V
    //   1242: invokevirtual 1552	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1245: checkcast 2159	GameCenter/RespLastGameInfo
    //   1248: invokevirtual 2164	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1251: new 726	java/util/ArrayList
    //   1254: dup
    //   1255: invokespecial 727	java/util/ArrayList:<init>	()V
    //   1258: astore_2
    //   1259: aload 16
    //   1261: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1264: ifnull +383 -> 1647
    //   1267: aload 16
    //   1269: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1272: invokevirtual 733	java/util/ArrayList:size	()I
    //   1275: ifle +372 -> 1647
    //   1278: iconst_0
    //   1279: istore 6
    //   1281: iload 6
    //   1283: aload 16
    //   1285: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1288: invokevirtual 733	java/util/ArrayList:size	()I
    //   1291: if_icmpge +356 -> 1647
    //   1294: aload 16
    //   1296: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1299: iload 6
    //   1301: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1304: checkcast 563	[B
    //   1307: astore 17
    //   1309: aload 17
    //   1311: ifnonnull +22 -> 1333
    //   1314: iconst_0
    //   1315: istore 7
    //   1317: iload 7
    //   1319: bipush 10
    //   1321: if_icmpgt +20 -> 1341
    //   1324: iload 6
    //   1326: iconst_1
    //   1327: iadd
    //   1328: istore 6
    //   1330: goto -49 -> 1281
    //   1333: aload 17
    //   1335: arraylength
    //   1336: istore 7
    //   1338: goto -21 -> 1317
    //   1341: aload 17
    //   1343: iconst_1
    //   1344: invokestatic 2172	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   1347: l2i
    //   1348: istore 8
    //   1350: aload 17
    //   1352: iconst_5
    //   1353: invokestatic 2172	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   1356: l2i
    //   1357: istore 9
    //   1359: iload 8
    //   1361: ifle -37 -> 1324
    //   1364: iload 8
    //   1366: bipush 9
    //   1368: iadd
    //   1369: iload 7
    //   1371: if_icmpge -47 -> 1324
    //   1374: iload 8
    //   1376: newarray byte
    //   1378: astore_3
    //   1379: aload_3
    //   1380: iconst_0
    //   1381: aload 17
    //   1383: bipush 9
    //   1385: iload 8
    //   1387: invokestatic 2175	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   1390: new 2177	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   1393: dup
    //   1394: invokespecial 2178	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   1397: astore 17
    //   1399: aload 17
    //   1401: aload_3
    //   1402: invokevirtual 2179	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1405: pop
    //   1406: aload 17
    //   1408: getfield 2182	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1411: invokevirtual 2185	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1414: istore 7
    //   1416: iload 7
    //   1418: ifne +161 -> 1579
    //   1421: new 2187	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   1424: dup
    //   1425: invokespecial 2188	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   1428: astore_3
    //   1429: aload_3
    //   1430: aload 17
    //   1432: getfield 2191	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1435: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1438: putfield 2193	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   1441: aload 17
    //   1443: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1446: ifnull +102 -> 1548
    //   1449: aload_3
    //   1450: aload 17
    //   1452: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1455: getfield 2202	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1458: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1461: putfield 2203	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1464: aload_3
    //   1465: aload 17
    //   1467: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1470: getfield 2206	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1473: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1476: putfield 2208	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   1479: aload_3
    //   1480: aload 17
    //   1482: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1485: getfield 2211	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1488: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1491: putfield 2213	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   1494: aload_3
    //   1495: aload 17
    //   1497: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1500: getfield 2216	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1503: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1506: putfield 2218	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   1509: aload_3
    //   1510: invokevirtual 2220	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   1513: ifne -189 -> 1324
    //   1516: aload_2
    //   1517: aload_3
    //   1518: invokeinterface 2221 2 0
    //   1523: pop
    //   1524: goto -200 -> 1324
    //   1527: astore_3
    //   1528: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1531: ifeq -207 -> 1324
    //   1534: ldc_w 1858
    //   1537: iconst_2
    //   1538: aload_3
    //   1539: invokevirtual 1919	java/lang/Exception:toString	()Ljava/lang/String;
    //   1542: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1545: goto -221 -> 1324
    //   1548: aload_3
    //   1549: ldc_w 298
    //   1552: putfield 2203	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1555: aload_3
    //   1556: ldc_w 298
    //   1559: putfield 2208	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   1562: aload_3
    //   1563: ldc_w 298
    //   1566: putfield 2213	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   1569: aload_3
    //   1570: ldc_w 298
    //   1573: putfield 2218	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   1576: goto -67 -> 1509
    //   1579: invokestatic 804	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1582: ifeq -258 -> 1324
    //   1585: ldc_w 1858
    //   1588: iconst_4
    //   1589: new 214	java/lang/StringBuilder
    //   1592: dup
    //   1593: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   1596: ldc_w 2223
    //   1599: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: aload 17
    //   1604: getfield 2191	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1607: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1610: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1613: ldc_w 681
    //   1616: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: iload 7
    //   1621: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1624: ldc_w 681
    //   1627: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: aload 17
    //   1632: getfield 2226	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1635: invokevirtual 820	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1644: goto -320 -> 1324
    //   1647: aload_1
    //   1648: aload_2
    //   1649: invokevirtual 2230	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   1652: aload_1
    //   1653: invokevirtual 924	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1656: sipush 1000
    //   1659: if_icmpne +23 -> 1682
    //   1662: aload 4
    //   1664: aload_1
    //   1665: invokevirtual 927	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1668: aload 4
    //   1670: invokevirtual 1264	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1673: aload_0
    //   1674: bipush 51
    //   1676: iconst_1
    //   1677: aload_1
    //   1678: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   1681: return
    //   1682: aload_1
    //   1683: invokevirtual 924	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1686: sipush 1001
    //   1689: if_icmpeq +13 -> 1702
    //   1692: aload_1
    //   1693: invokevirtual 924	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1696: sipush 1002
    //   1699: if_icmpne -31 -> 1668
    //   1702: aload 4
    //   1704: aload_1
    //   1705: invokevirtual 672	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1708: pop
    //   1709: goto -41 -> 1668
    //   1712: lload 13
    //   1714: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1717: astore 19
    //   1719: aload 17
    //   1721: aload 19
    //   1723: invokevirtual 933	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1726: astore 4
    //   1728: aload 4
    //   1730: aload 16
    //   1732: getfield 2233	SummaryCard/RespSummaryCard:iLevel	I
    //   1735: putfield 1756	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   1738: aload 4
    //   1740: aload 16
    //   1742: getfield 1967	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   1745: putfield 936	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   1748: aload 4
    //   1750: aload 16
    //   1752: getfield 1965	SummaryCard/RespSummaryCard:bSex	B
    //   1755: i2s
    //   1756: putfield 946	com/tencent/mobileqq/data/Card:shGender	S
    //   1759: aload 4
    //   1761: aload 16
    //   1763: getfield 1959	SummaryCard/RespSummaryCard:bAge	B
    //   1766: i2s
    //   1767: putfield 1081	com/tencent/mobileqq/data/Card:shAge	S
    //   1770: aload 4
    //   1772: aload 16
    //   1774: getfield 1959	SummaryCard/RespSummaryCard:bAge	B
    //   1777: putfield 951	com/tencent/mobileqq/data/Card:age	B
    //   1780: aload 4
    //   1782: aload 16
    //   1784: getfield 2236	SummaryCard/RespSummaryCard:iFace	I
    //   1787: putfield 1355	com/tencent/mobileqq/data/Card:nFaceID	I
    //   1790: aload 4
    //   1792: aload 16
    //   1794: getfield 2237	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   1797: putfield 1423	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   1800: aload 4
    //   1802: aload 16
    //   1804: getfield 1975	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   1807: putfield 984	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   1810: aload 4
    //   1812: aload 16
    //   1814: getfield 1971	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   1817: putfield 981	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   1820: aload 4
    //   1822: aload 16
    //   1824: getfield 1973	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   1827: putfield 978	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   1830: aload 4
    //   1832: aload 16
    //   1834: getfield 2240	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   1837: putfield 1818	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   1840: aload 4
    //   1842: aload 16
    //   1844: getfield 2048	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   1847: putfield 1280	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   1850: aload 4
    //   1852: aload 16
    //   1854: getfield 2243	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   1857: putfield 2246	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   1860: aload 4
    //   1862: aload 16
    //   1864: getfield 2249	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   1867: putfield 2252	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   1870: aload 4
    //   1872: aload 16
    //   1874: getfield 2255	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   1877: putfield 2256	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   1880: aload 4
    //   1882: aload 16
    //   1884: getfield 1979	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   1887: putfield 2257	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   1890: aload 4
    //   1892: aload 16
    //   1894: getfield 2260	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   1897: putfield 2261	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   1900: aload 4
    //   1902: aload 16
    //   1904: getfield 2264	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   1907: putfield 2265	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   1910: aload 4
    //   1912: aload 16
    //   1914: getfield 2098	SummaryCard/RespSummaryCard:vSeed	[B
    //   1917: putfield 2266	com/tencent/mobileqq/data/Card:vSeed	[B
    //   1920: aload 4
    //   1922: aload 16
    //   1924: getfield 2006	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1927: i2l
    //   1928: putfield 1389	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   1931: aload 4
    //   1933: aload 16
    //   1935: getfield 2269	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   1938: putfield 2272	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   1941: aload 4
    //   1943: iload 8
    //   1945: putfield 2273	com/tencent/mobileqq/data/Card:favoriteSource	I
    //   1948: aload 16
    //   1950: getfield 2277	SummaryCard/RespSummaryCard:stQCallInfo	LSummaryCard/QCallInfo;
    //   1953: astore_3
    //   1954: aload_3
    //   1955: ifnull +664 -> 2619
    //   1958: aload_3
    //   1959: getfield 2282	SummaryCard/QCallInfo:bStatus	I
    //   1962: iconst_1
    //   1963: if_icmpne +635 -> 2598
    //   1966: aload 4
    //   1968: iconst_1
    //   1969: putfield 2285	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   1972: aload 4
    //   1974: aload_3
    //   1975: getfield 2286	SummaryCard/QCallInfo:strNick	Ljava/lang/String;
    //   1978: putfield 2289	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   1981: aload 4
    //   1983: aload_3
    //   1984: getfield 2292	SummaryCard/QCallInfo:uQCallId	J
    //   1987: invokestatic 2295	com/tencent/mobileqq/utils/StringUtil:a	(J)Ljava/lang/String;
    //   1990: putfield 2298	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   1993: invokestatic 804	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1996: ifeq +75 -> 2071
    //   1999: ldc_w 2300
    //   2002: iconst_4
    //   2003: new 214	java/lang/StringBuilder
    //   2006: dup
    //   2007: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   2010: ldc_w 2302
    //   2013: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: aload 4
    //   2018: getfield 2285	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   2021: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2024: ldc_w 2304
    //   2027: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: aload 4
    //   2032: getfield 2289	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   2035: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: ldc_w 2306
    //   2041: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2044: aload_3
    //   2045: getfield 2282	SummaryCard/QCallInfo:bStatus	I
    //   2048: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2051: ldc_w 2308
    //   2054: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2057: aload 4
    //   2059: getfield 2298	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   2062: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2068: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2071: aload 19
    //   2073: aload_0
    //   2074: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2077: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2080: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2083: ifeq +38 -> 2121
    //   2086: aload_0
    //   2087: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2090: bipush 67
    //   2092: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2095: checkcast 875	com/tencent/mobileqq/dating/DatingManager
    //   2098: astore_3
    //   2099: aload_3
    //   2100: ifnull +21 -> 2121
    //   2103: aload_3
    //   2104: aload 16
    //   2106: getfield 1965	SummaryCard/RespSummaryCard:bSex	B
    //   2109: invokevirtual 877	com/tencent/mobileqq/dating/DatingManager:b	(I)V
    //   2112: aload_3
    //   2113: aload 16
    //   2115: getfield 1959	SummaryCard/RespSummaryCard:bAge	B
    //   2118: invokevirtual 889	com/tencent/mobileqq/dating/DatingManager:a	(I)V
    //   2121: aload_1
    //   2122: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   2125: ldc_w 1951
    //   2128: invokevirtual 880	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2131: bipush 37
    //   2133: if_icmpne +18 -> 2151
    //   2136: aload 4
    //   2138: aload_1
    //   2139: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   2142: ldc_w 1949
    //   2145: invokevirtual 392	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2148: putfield 2311	com/tencent/mobileqq/data/Card:encId	Ljava/lang/String;
    //   2151: aload_2
    //   2152: ifnull +12 -> 2164
    //   2155: aload 4
    //   2157: aload_2
    //   2158: getfield 2121	SummaryCard/RespHead:vCookies	[B
    //   2161: putfield 2312	com/tencent/mobileqq/data/Card:vCookies	[B
    //   2164: aload 16
    //   2166: getfield 2118	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   2169: ifne +469 -> 2638
    //   2172: aload 4
    //   2174: iconst_1
    //   2175: putfield 434	com/tencent/mobileqq/data/Card:bVoted	B
    //   2178: aload 4
    //   2180: aload 16
    //   2182: getfield 2086	SummaryCard/RespSummaryCard:ulShowControl	J
    //   2185: l2i
    //   2186: putfield 2314	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   2189: aload 19
    //   2191: aload_0
    //   2192: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2195: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2198: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2201: ifeq +476 -> 2677
    //   2204: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2207: ifeq +48 -> 2255
    //   2210: ldc_w 1858
    //   2213: iconst_2
    //   2214: new 214	java/lang/StringBuilder
    //   2217: dup
    //   2218: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   2221: ldc_w 2003
    //   2224: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: aload 16
    //   2229: getfield 2006	SummaryCard/RespSummaryCard:iVoteCount	I
    //   2232: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2235: ldc_w 2008
    //   2238: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: aload 16
    //   2243: getfield 2011	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   2246: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2249: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2252: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2255: aload 4
    //   2257: aload 16
    //   2259: getfield 2006	SummaryCard/RespSummaryCard:iVoteCount	I
    //   2262: i2l
    //   2263: putfield 431	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2266: aload 4
    //   2268: aload 16
    //   2270: getfield 2011	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   2273: putfield 1396	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2276: aload_0
    //   2277: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2280: invokevirtual 650	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   2283: invokevirtual 656	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   2286: astore 20
    //   2288: aload 20
    //   2290: ldc_w 658
    //   2293: ldc_w 660
    //   2296: iconst_1
    //   2297: anewarray 300	java/lang/String
    //   2300: dup
    //   2301: iconst_0
    //   2302: aload 19
    //   2304: aastore
    //   2305: invokevirtual 665	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   2308: checkcast 658	com/tencent/mobileqq/data/NearbyPeopleCard
    //   2311: astore_3
    //   2312: aload_3
    //   2313: astore_2
    //   2314: aload_3
    //   2315: ifnonnull +11 -> 2326
    //   2318: new 658	com/tencent/mobileqq/data/NearbyPeopleCard
    //   2321: dup
    //   2322: invokespecial 847	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   2325: astore_2
    //   2326: aload_2
    //   2327: aload 4
    //   2329: getfield 431	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2332: l2i
    //   2333: putfield 668	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   2336: aload_2
    //   2337: aload 4
    //   2339: getfield 1396	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2342: putfield 2014	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   2345: aload_2
    //   2346: invokevirtual 924	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2349: sipush 1000
    //   2352: if_icmpne +295 -> 2647
    //   2355: aload 20
    //   2357: aload_2
    //   2358: invokevirtual 927	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   2361: aload 20
    //   2363: invokevirtual 1264	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   2366: aload 16
    //   2368: getfield 2086	SummaryCard/RespSummaryCard:ulShowControl	J
    //   2371: ldc2_w 2125
    //   2374: land
    //   2375: lconst_0
    //   2376: lcmp
    //   2377: ifne +324 -> 2701
    //   2380: iconst_0
    //   2381: istore 15
    //   2383: aload 4
    //   2385: iload 15
    //   2387: invokevirtual 1447	com/tencent/mobileqq/data/Card:setZanShowFlag	(Z)V
    //   2390: aload 16
    //   2392: getfield 2086	SummaryCard/RespSummaryCard:ulShowControl	J
    //   2395: lconst_1
    //   2396: land
    //   2397: lconst_0
    //   2398: lcmp
    //   2399: ifne +308 -> 2707
    //   2402: iconst_0
    //   2403: istore 15
    //   2405: aload 4
    //   2407: iload 15
    //   2409: invokevirtual 2317	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   2412: aload 16
    //   2414: getfield 2086	SummaryCard/RespSummaryCard:ulShowControl	J
    //   2417: ldc2_w 2123
    //   2420: land
    //   2421: lconst_0
    //   2422: lcmp
    //   2423: ifne +290 -> 2713
    //   2426: iconst_0
    //   2427: istore 15
    //   2429: aload 4
    //   2431: iload 15
    //   2433: invokevirtual 2320	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   2436: aload 16
    //   2438: getfield 2102	SummaryCard/RespSummaryCard:lCacheControl	J
    //   2441: lconst_0
    //   2442: lcmp
    //   2443: ifne +276 -> 2719
    //   2446: iconst_0
    //   2447: istore 15
    //   2449: aload 4
    //   2451: iload 15
    //   2453: invokevirtual 2323	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   2456: aload 16
    //   2458: getfield 2086	SummaryCard/RespSummaryCard:ulShowControl	J
    //   2461: ldc2_w 2324
    //   2464: land
    //   2465: lconst_0
    //   2466: lcmp
    //   2467: ifne +258 -> 2725
    //   2470: iconst_0
    //   2471: istore 15
    //   2473: aload 4
    //   2475: iload 15
    //   2477: invokevirtual 2328	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   2480: aload 4
    //   2482: aload 16
    //   2484: getfield 2074	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   2487: putfield 2329	com/tencent/mobileqq/data/Card:strQzoneFeedsDesc	Ljava/lang/String;
    //   2490: aload 4
    //   2492: aload 16
    //   2494: getfield 2080	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   2497: putfield 2330	com/tencent/mobileqq/data/Card:strSpaceName	Ljava/lang/String;
    //   2500: aload 4
    //   2502: invokevirtual 2331	com/tencent/mobileqq/data/Card:isPhotoUseCache	()Z
    //   2505: ifne +284 -> 2789
    //   2508: aload 4
    //   2510: ldc_w 298
    //   2513: putfield 2334	com/tencent/mobileqq/data/Card:strQzonePicUrl1	Ljava/lang/String;
    //   2516: aload 4
    //   2518: ldc_w 298
    //   2521: putfield 2337	com/tencent/mobileqq/data/Card:strQzonePicUrl2	Ljava/lang/String;
    //   2524: aload 4
    //   2526: ldc_w 298
    //   2529: putfield 2340	com/tencent/mobileqq/data/Card:strQzonePicUrl3	Ljava/lang/String;
    //   2532: aload 16
    //   2534: getfield 2142	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   2537: astore_2
    //   2538: aload_2
    //   2539: ifnull +250 -> 2789
    //   2542: aload_2
    //   2543: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   2546: ifnull +243 -> 2789
    //   2549: iconst_0
    //   2550: istore 6
    //   2552: iload 6
    //   2554: aload_2
    //   2555: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   2558: invokevirtual 733	java/util/ArrayList:size	()I
    //   2561: if_icmpge +228 -> 2789
    //   2564: iload 6
    //   2566: ifne +165 -> 2731
    //   2569: aload 4
    //   2571: aload_2
    //   2572: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   2575: iload 6
    //   2577: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2580: checkcast 2149	SummaryCard/PhotoInfo
    //   2583: getfield 2152	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   2586: putfield 2334	com/tencent/mobileqq/data/Card:strQzonePicUrl1	Ljava/lang/String;
    //   2589: iload 6
    //   2591: iconst_1
    //   2592: iadd
    //   2593: istore 6
    //   2595: goto -43 -> 2552
    //   2598: aload 4
    //   2600: iconst_0
    //   2601: putfield 2285	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   2604: aload 4
    //   2606: aconst_null
    //   2607: putfield 2289	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   2610: aload 4
    //   2612: aconst_null
    //   2613: putfield 2298	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   2616: goto -623 -> 1993
    //   2619: invokestatic 804	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2622: ifeq -551 -> 2071
    //   2625: ldc_w 2300
    //   2628: iconst_4
    //   2629: ldc_w 2342
    //   2632: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2635: goto -564 -> 2071
    //   2638: aload 4
    //   2640: iconst_0
    //   2641: putfield 434	com/tencent/mobileqq/data/Card:bVoted	B
    //   2644: goto -466 -> 2178
    //   2647: aload_2
    //   2648: invokevirtual 924	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2651: sipush 1001
    //   2654: if_icmpeq +13 -> 2667
    //   2657: aload_2
    //   2658: invokevirtual 924	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2661: sipush 1002
    //   2664: if_icmpne -303 -> 2361
    //   2667: aload 20
    //   2669: aload_2
    //   2670: invokevirtual 672	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   2673: pop
    //   2674: goto -313 -> 2361
    //   2677: aload 4
    //   2679: aload 16
    //   2681: getfield 2006	SummaryCard/RespSummaryCard:iVoteCount	I
    //   2684: i2l
    //   2685: putfield 431	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2688: aload 4
    //   2690: aload 16
    //   2692: getfield 2011	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   2695: putfield 1396	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2698: goto -332 -> 2366
    //   2701: iconst_1
    //   2702: istore 15
    //   2704: goto -321 -> 2383
    //   2707: iconst_1
    //   2708: istore 15
    //   2710: goto -305 -> 2405
    //   2713: iconst_1
    //   2714: istore 15
    //   2716: goto -287 -> 2429
    //   2719: iconst_1
    //   2720: istore 15
    //   2722: goto -273 -> 2449
    //   2725: iconst_1
    //   2726: istore 15
    //   2728: goto -255 -> 2473
    //   2731: iload 6
    //   2733: iconst_1
    //   2734: if_icmpne +26 -> 2760
    //   2737: aload 4
    //   2739: aload_2
    //   2740: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   2743: iload 6
    //   2745: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2748: checkcast 2149	SummaryCard/PhotoInfo
    //   2751: getfield 2152	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   2754: putfield 2337	com/tencent/mobileqq/data/Card:strQzonePicUrl2	Ljava/lang/String;
    //   2757: goto -168 -> 2589
    //   2760: iload 6
    //   2762: iconst_2
    //   2763: if_icmpne -174 -> 2589
    //   2766: aload 4
    //   2768: aload_2
    //   2769: getfield 2147	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   2772: iload 6
    //   2774: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2777: checkcast 2149	SummaryCard/PhotoInfo
    //   2780: getfield 2152	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   2783: putfield 2340	com/tencent/mobileqq/data/Card:strQzonePicUrl3	Ljava/lang/String;
    //   2786: goto -197 -> 2589
    //   2789: aload 4
    //   2791: aload 16
    //   2793: getfield 2343	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   2796: invokevirtual 2347	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   2799: aload_1
    //   2800: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   2803: ldc_w 2349
    //   2806: invokevirtual 613	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   2809: lstore 13
    //   2811: lconst_1
    //   2812: lload 13
    //   2814: land
    //   2815: lconst_0
    //   2816: lcmp
    //   2817: ifeq +71 -> 2888
    //   2820: aload 4
    //   2822: aload 16
    //   2824: getfield 2352	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   2827: putfield 2353	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   2830: aload 4
    //   2832: getfield 2353	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   2835: invokestatic 412	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2838: ifeq +10 -> 2848
    //   2841: aload 4
    //   2843: aload 19
    //   2845: putfield 2353	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   2848: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2851: ifeq +37 -> 2888
    //   2854: ldc_w 1858
    //   2857: iconst_2
    //   2858: new 214	java/lang/StringBuilder
    //   2861: dup
    //   2862: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   2865: ldc_w 2355
    //   2868: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2871: aload 16
    //   2873: getfield 2352	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   2876: invokestatic 2357	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2879: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2882: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2885: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2888: ldc2_w 2358
    //   2891: lload 13
    //   2893: land
    //   2894: lconst_0
    //   2895: lcmp
    //   2896: ifeq +13 -> 2909
    //   2899: aload 4
    //   2901: aload 16
    //   2903: getfield 2362	SummaryCard/RespSummaryCard:uAccelerateMultiple	J
    //   2906: putfield 2363	com/tencent/mobileqq/data/Card:uAccelerateMultiple	J
    //   2909: ldc2_w 2125
    //   2912: lload 13
    //   2914: land
    //   2915: lconst_0
    //   2916: lcmp
    //   2917: ifeq +23 -> 2940
    //   2920: aload 4
    //   2922: aload 16
    //   2924: getfield 2015	SummaryCard/RespSummaryCard:vRichSign	[B
    //   2927: putfield 2364	com/tencent/mobileqq/data/Card:vRichSign	[B
    //   2930: aload 4
    //   2932: aload 16
    //   2934: getfield 2367	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   2937: putfield 2370	com/tencent/mobileqq/data/Card:lSignModifyTime	J
    //   2940: aload 16
    //   2942: getfield 2155	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   2945: ifnull +30 -> 2975
    //   2948: aload 4
    //   2950: aload_0
    //   2951: aload 16
    //   2953: getfield 2155	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   2956: ldc_w 2157
    //   2959: new 2159	GameCenter/RespLastGameInfo
    //   2962: dup
    //   2963: invokespecial 2160	GameCenter/RespLastGameInfo:<init>	()V
    //   2966: invokevirtual 1552	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2969: checkcast 2159	GameCenter/RespLastGameInfo
    //   2972: invokevirtual 2371	com/tencent/mobileqq/data/Card:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   2975: ldc2_w 2372
    //   2978: lload 13
    //   2980: land
    //   2981: lconst_0
    //   2982: lcmp
    //   2983: ifeq +54 -> 3037
    //   2986: new 609	java/util/HashMap
    //   2989: dup
    //   2990: invokespecial 610	java/util/HashMap:<init>	()V
    //   2993: astore_2
    //   2994: aload 16
    //   2996: getfield 2376	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   2999: ifnull +437 -> 3436
    //   3002: aload_0
    //   3003: aload 16
    //   3005: getfield 2376	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   3008: ldc_w 1546
    //   3011: new 1548	SummaryCardTaf/SSummaryCardRsp
    //   3014: dup
    //   3015: invokespecial 1549	SummaryCardTaf/SSummaryCardRsp:<init>	()V
    //   3018: invokevirtual 1552	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3021: checkcast 1548	SummaryCardTaf/SSummaryCardRsp
    //   3024: astore_2
    //   3025: aload 4
    //   3027: aload_0
    //   3028: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3031: aload 19
    //   3033: aload_2
    //   3034: invokevirtual 2380	com/tencent/mobileqq/data/Card:updateCardTemplate	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;LSummaryCardTaf/SSummaryCardRsp;)V
    //   3037: ldc2_w 2381
    //   3040: lload 13
    //   3042: land
    //   3043: lconst_0
    //   3044: lcmp
    //   3045: ifeq +50 -> 3095
    //   3048: aload 4
    //   3050: aload 16
    //   3052: getfield 2092	SummaryCard/RespSummaryCard:lUserFlag	J
    //   3055: putfield 2383	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   3058: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3061: ifeq +34 -> 3095
    //   3064: ldc_w 1858
    //   3067: iconst_2
    //   3068: new 214	java/lang/StringBuilder
    //   3071: dup
    //   3072: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   3075: ldc_w 2385
    //   3078: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3081: aload 4
    //   3083: getfield 2383	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   3086: invokevirtual 684	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3089: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3092: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3095: ldc2_w 2324
    //   3098: lload 13
    //   3100: land
    //   3101: lconst_0
    //   3102: lcmp
    //   3103: ifeq +74 -> 3177
    //   3106: aload 4
    //   3108: aload 16
    //   3110: getfield 2388	SummaryCard/RespSummaryCard:uLoginDays	J
    //   3113: putfield 2391	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   3116: aload 4
    //   3118: aload 16
    //   3120: getfield 2394	SummaryCard/RespSummaryCard:strLoginDesc	Ljava/lang/String;
    //   3123: putfield 2397	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   3126: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3129: ifeq +48 -> 3177
    //   3132: ldc_w 1858
    //   3135: iconst_2
    //   3136: new 214	java/lang/StringBuilder
    //   3139: dup
    //   3140: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   3143: ldc_w 2399
    //   3146: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: aload 4
    //   3151: getfield 2391	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   3154: invokevirtual 684	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3157: ldc_w 2401
    //   3160: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3163: aload 4
    //   3165: getfield 2397	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   3168: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3171: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3174: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3177: aload 16
    //   3179: getfield 2404	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   3182: ifnull +172 -> 3354
    //   3185: aload 16
    //   3187: getfield 2404	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   3190: invokevirtual 2410	QQService/VipBaseInfo:getMOpenInfo	()Ljava/util/Map;
    //   3193: astore_2
    //   3194: aload_2
    //   3195: ifnull +159 -> 3354
    //   3198: aload_2
    //   3199: bipush 101
    //   3201: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3204: invokeinterface 2415 2 0
    //   3209: checkcast 2417	QQService/VipOpenInfo
    //   3212: astore_3
    //   3213: aload_3
    //   3214: getfield 2420	QQService/VipOpenInfo:bOpen	Z
    //   3217: ifeq +24 -> 3241
    //   3220: aload 4
    //   3222: iconst_1
    //   3223: putfield 2423	com/tencent/mobileqq/data/Card:isRedDiamond	Z
    //   3226: aload_3
    //   3227: getfield 2426	QQService/VipOpenInfo:iVipFlag	I
    //   3230: iconst_1
    //   3231: iand
    //   3232: ifle +9 -> 3241
    //   3235: aload 4
    //   3237: iconst_1
    //   3238: putfield 2429	com/tencent/mobileqq/data/Card:isSuperRedDiamond	Z
    //   3241: aload 4
    //   3243: aload_3
    //   3244: getfield 2432	QQService/VipOpenInfo:iVipLevel	I
    //   3247: putfield 2435	com/tencent/mobileqq/data/Card:redLevel	I
    //   3250: aload_2
    //   3251: bipush 102
    //   3253: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3256: invokeinterface 2415 2 0
    //   3261: checkcast 2417	QQService/VipOpenInfo
    //   3264: astore_3
    //   3265: aload_3
    //   3266: getfield 2420	QQService/VipOpenInfo:bOpen	Z
    //   3269: ifeq +24 -> 3293
    //   3272: aload 4
    //   3274: iconst_1
    //   3275: putfield 2438	com/tencent/mobileqq/data/Card:isYellowDiamond	Z
    //   3278: aload_3
    //   3279: getfield 2426	QQService/VipOpenInfo:iVipFlag	I
    //   3282: iconst_1
    //   3283: iand
    //   3284: ifle +9 -> 3293
    //   3287: aload 4
    //   3289: iconst_1
    //   3290: putfield 2441	com/tencent/mobileqq/data/Card:isSuperYellowDiamond	Z
    //   3293: aload 4
    //   3295: aload_3
    //   3296: getfield 2432	QQService/VipOpenInfo:iVipLevel	I
    //   3299: putfield 2444	com/tencent/mobileqq/data/Card:yellowLevel	I
    //   3302: aload_2
    //   3303: bipush 103
    //   3305: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3308: invokeinterface 2415 2 0
    //   3313: checkcast 2417	QQService/VipOpenInfo
    //   3316: astore_2
    //   3317: aload_2
    //   3318: getfield 2420	QQService/VipOpenInfo:bOpen	Z
    //   3321: ifeq +24 -> 3345
    //   3324: aload 4
    //   3326: iconst_1
    //   3327: putfield 2447	com/tencent/mobileqq/data/Card:isGreenDiamond	Z
    //   3330: aload_2
    //   3331: getfield 2426	QQService/VipOpenInfo:iVipFlag	I
    //   3334: iconst_1
    //   3335: iand
    //   3336: ifle +9 -> 3345
    //   3339: aload 4
    //   3341: iconst_1
    //   3342: putfield 2450	com/tencent/mobileqq/data/Card:isSuperGreenDiamond	Z
    //   3345: aload 4
    //   3347: aload_2
    //   3348: getfield 2432	QQService/VipOpenInfo:iVipLevel	I
    //   3351: putfield 2453	com/tencent/mobileqq/data/Card:greenLevel	I
    //   3354: new 726	java/util/ArrayList
    //   3357: dup
    //   3358: invokespecial 727	java/util/ArrayList:<init>	()V
    //   3361: astore_2
    //   3362: aload 16
    //   3364: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3367: ifnull +420 -> 3787
    //   3370: aload 16
    //   3372: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3375: invokevirtual 733	java/util/ArrayList:size	()I
    //   3378: ifle +409 -> 3787
    //   3381: iconst_0
    //   3382: istore 6
    //   3384: iload 6
    //   3386: aload 16
    //   3388: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3391: invokevirtual 733	java/util/ArrayList:size	()I
    //   3394: if_icmpge +393 -> 3787
    //   3397: aload 16
    //   3399: getfield 2167	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3402: iload 6
    //   3404: invokevirtual 734	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3407: checkcast 563	[B
    //   3410: astore 20
    //   3412: aload 20
    //   3414: ifnonnull +62 -> 3476
    //   3417: iconst_0
    //   3418: istore 7
    //   3420: iload 7
    //   3422: bipush 10
    //   3424: if_icmpgt +60 -> 3484
    //   3427: iload 6
    //   3429: iconst_1
    //   3430: iadd
    //   3431: istore 6
    //   3433: goto -49 -> 3384
    //   3436: aload_2
    //   3437: ldc_w 621
    //   3440: ldc_w 2455
    //   3443: invokevirtual 626	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3446: pop
    //   3447: aload_0
    //   3448: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3451: invokevirtual 629	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3454: invokestatic 634	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3457: aload 19
    //   3459: ldc_w 2457
    //   3462: iconst_0
    //   3463: lconst_0
    //   3464: lconst_0
    //   3465: aconst_null
    //   3466: ldc_w 298
    //   3469: iconst_0
    //   3470: invokevirtual 641	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   3473: goto -436 -> 3037
    //   3476: aload 20
    //   3478: arraylength
    //   3479: istore 7
    //   3481: goto -61 -> 3420
    //   3484: aload 20
    //   3486: iconst_1
    //   3487: invokestatic 2172	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   3490: l2i
    //   3491: istore 9
    //   3493: aload 20
    //   3495: iconst_5
    //   3496: invokestatic 2172	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   3499: l2i
    //   3500: istore 10
    //   3502: iload 9
    //   3504: ifle -77 -> 3427
    //   3507: iload 9
    //   3509: bipush 9
    //   3511: iadd
    //   3512: iload 7
    //   3514: if_icmpge -87 -> 3427
    //   3517: iload 9
    //   3519: newarray byte
    //   3521: astore_3
    //   3522: aload_3
    //   3523: iconst_0
    //   3524: aload 20
    //   3526: bipush 9
    //   3528: iload 9
    //   3530: invokestatic 2175	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   3533: new 2177	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   3536: dup
    //   3537: invokespecial 2178	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   3540: astore 20
    //   3542: aload 20
    //   3544: aload_3
    //   3545: invokevirtual 2179	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3548: pop
    //   3549: aload 20
    //   3551: getfield 2182	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3554: invokevirtual 2185	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3557: istore 7
    //   3559: iload 7
    //   3561: ifne +106 -> 3667
    //   3564: new 2187	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   3567: dup
    //   3568: invokespecial 2188	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   3571: astore_3
    //   3572: aload_3
    //   3573: aload 20
    //   3575: getfield 2191	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3578: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3581: putfield 2193	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   3584: aload 20
    //   3586: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3589: ifnull +167 -> 3756
    //   3592: aload_3
    //   3593: aload 20
    //   3595: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3598: getfield 2202	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3601: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3604: putfield 2203	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3607: aload_3
    //   3608: aload 20
    //   3610: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3613: getfield 2206	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3616: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3619: putfield 2208	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   3622: aload_3
    //   3623: aload 20
    //   3625: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3628: getfield 2211	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3631: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3634: putfield 2213	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   3637: aload_3
    //   3638: aload 20
    //   3640: getfield 2197	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3643: getfield 2216	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3646: invokevirtual 1782	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3649: putfield 2218	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3652: aload_3
    //   3653: invokevirtual 2220	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   3656: ifne +11 -> 3667
    //   3659: aload_2
    //   3660: aload_3
    //   3661: invokeinterface 2221 2 0
    //   3666: pop
    //   3667: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3670: ifeq -243 -> 3427
    //   3673: ldc_w 1858
    //   3676: iconst_2
    //   3677: new 214	java/lang/StringBuilder
    //   3680: dup
    //   3681: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   3684: ldc_w 2459
    //   3687: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3690: aload 20
    //   3692: getfield 2191	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3695: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3698: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3701: ldc_w 2461
    //   3704: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3707: iload 7
    //   3709: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3712: ldc_w 2463
    //   3715: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3718: aload 20
    //   3720: getfield 2226	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3723: invokevirtual 820	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3726: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3729: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3732: goto -305 -> 3427
    //   3735: astore_3
    //   3736: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3739: ifeq -312 -> 3427
    //   3742: ldc_w 1858
    //   3745: iconst_2
    //   3746: aload_3
    //   3747: invokevirtual 1919	java/lang/Exception:toString	()Ljava/lang/String;
    //   3750: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3753: goto -326 -> 3427
    //   3756: aload_3
    //   3757: ldc_w 298
    //   3760: putfield 2203	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3763: aload_3
    //   3764: ldc_w 298
    //   3767: putfield 2208	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   3770: aload_3
    //   3771: ldc_w 298
    //   3774: putfield 2213	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   3777: aload_3
    //   3778: ldc_w 298
    //   3781: putfield 2218	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3784: goto -132 -> 3652
    //   3787: aload 4
    //   3789: aload_2
    //   3790: invokevirtual 2464	com/tencent/mobileqq/data/Card:saveBusiEntrys	(Ljava/util/List;)V
    //   3793: aload 4
    //   3795: getfield 2383	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   3798: ldc2_w 2381
    //   3801: land
    //   3802: lconst_0
    //   3803: lcmp
    //   3804: ifeq +722 -> 4526
    //   3807: aload 4
    //   3809: iconst_1
    //   3810: putfield 2467	com/tencent/mobileqq/data/Card:allowClick	Z
    //   3813: aload 19
    //   3815: aload_0
    //   3816: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3819: invokevirtual 469	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3822: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3825: ifne +23 -> 3848
    //   3828: aload 4
    //   3830: getfield 2383	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   3833: ldc2_w 2324
    //   3836: land
    //   3837: lconst_0
    //   3838: lcmp
    //   3839: ifeq +696 -> 4535
    //   3842: aload 4
    //   3844: iconst_1
    //   3845: putfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   3848: aload 17
    //   3850: aload 4
    //   3852: invokevirtual 437	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   3855: pop
    //   3856: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3859: ifeq +94 -> 3953
    //   3862: new 214	java/lang/StringBuilder
    //   3865: dup
    //   3866: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   3869: astore_2
    //   3870: aload_2
    //   3871: ldc_w 2399
    //   3874: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: aload 4
    //   3879: getfield 2391	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   3882: invokevirtual 684	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3885: ldc_w 2469
    //   3888: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3891: aload 4
    //   3893: getfield 2397	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   3896: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3899: ldc_w 2471
    //   3902: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3905: aload 4
    //   3907: getfield 2467	com/tencent/mobileqq/data/Card:allowClick	Z
    //   3910: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3913: ldc_w 2473
    //   3916: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3919: aload 4
    //   3921: getfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   3924: invokevirtual 679	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3927: ldc_w 2475
    //   3930: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3933: aload 4
    //   3935: getfield 2314	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   3938: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3941: pop
    //   3942: ldc_w 1858
    //   3945: iconst_2
    //   3946: aload_2
    //   3947: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3950: invokestatic 686	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3953: aload_0
    //   3954: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3957: bipush 34
    //   3959: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3962: checkcast 2477	com/tencent/mobileqq/app/CircleManager
    //   3965: aload 4
    //   3967: invokevirtual 2478	com/tencent/mobileqq/app/CircleManager:a	(Lcom/tencent/mobileqq/data/Card;)V
    //   3970: aload 17
    //   3972: aload 19
    //   3974: invokevirtual 2481	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   3977: astore_3
    //   3978: aload_3
    //   3979: astore_2
    //   3980: aload_3
    //   3981: ifnonnull +17 -> 3998
    //   3984: new 2483	com/tencent/mobileqq/data/ExtensionInfo
    //   3987: dup
    //   3988: invokespecial 2484	com/tencent/mobileqq/data/ExtensionInfo:<init>	()V
    //   3991: astore_2
    //   3992: aload_2
    //   3993: aload 19
    //   3995: putfield 2485	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   3998: aload_2
    //   3999: aload 16
    //   4001: getfield 2488	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   4004: putfield 2491	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   4007: aload_2
    //   4008: invokestatic 1943	java/lang/System:currentTimeMillis	()J
    //   4011: putfield 2493	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   4014: aload 17
    //   4016: aload 19
    //   4018: invokevirtual 2496	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   4021: astore 20
    //   4023: aload 20
    //   4025: aload 4
    //   4027: getfield 1423	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   4030: putfield 2501	com/tencent/mobileqq/data/Friends:signature	Ljava/lang/String;
    //   4033: aload 20
    //   4035: aload 4
    //   4037: getfield 936	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   4040: putfield 2504	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   4043: aload 20
    //   4045: aload 4
    //   4047: getfield 1818	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   4050: putfield 2507	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   4053: lconst_1
    //   4054: lload 13
    //   4056: land
    //   4057: lconst_0
    //   4058: lcmp
    //   4059: ifeq +485 -> 4544
    //   4062: aload 4
    //   4064: getfield 2353	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   4067: astore_3
    //   4068: aload 20
    //   4070: aload_3
    //   4071: putfield 2510	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   4074: aload 4
    //   4076: getfield 946	com/tencent/mobileqq/data/Card:shGender	S
    //   4079: ifne +474 -> 4553
    //   4082: iconst_1
    //   4083: istore 5
    //   4085: aload 20
    //   4087: iload 5
    //   4089: putfield 2511	com/tencent/mobileqq/data/Friends:gender	B
    //   4092: aload 20
    //   4094: aload 4
    //   4096: getfield 951	com/tencent/mobileqq/data/Card:age	B
    //   4099: putfield 2512	com/tencent/mobileqq/data/Friends:age	I
    //   4102: ldc2_w 2125
    //   4105: lload 13
    //   4107: land
    //   4108: lconst_0
    //   4109: lcmp
    //   4110: ifeq +47 -> 4157
    //   4113: aload_2
    //   4114: getfield 2515	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   4117: aload 16
    //   4119: getfield 2367	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   4122: lcmp
    //   4123: ifeq +34 -> 4157
    //   4126: aload_2
    //   4127: aload 16
    //   4129: getfield 2015	SummaryCard/RespSummaryCard:vRichSign	[B
    //   4132: aload 16
    //   4134: getfield 2367	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   4137: invokevirtual 2519	com/tencent/mobileqq/data/ExtensionInfo:setRichBuffer	([BJ)V
    //   4140: aload_2
    //   4141: aload_0
    //   4142: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4145: aload 19
    //   4147: aload_2
    //   4148: invokevirtual 2523	com/tencent/mobileqq/data/ExtensionInfo:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   4151: invokestatic 2528	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/richstatus/RichStatus;)Z
    //   4154: putfield 2531	com/tencent/mobileqq/data/ExtensionInfo:isAdded2C2C	Z
    //   4157: aload 17
    //   4159: aload_2
    //   4160: invokevirtual 2534	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   4163: invokestatic 599	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4166: ifeq +44 -> 4210
    //   4169: ldc_w 1858
    //   4172: iconst_2
    //   4173: new 214	java/lang/StringBuilder
    //   4176: dup
    //   4177: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   4180: ldc_w 2536
    //   4183: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4186: aload 19
    //   4188: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4191: ldc_w 2538
    //   4194: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4197: aload_2
    //   4198: getfield 2491	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   4201: invokevirtual 684	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4204: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4207: invokestatic 607	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4210: aload 16
    //   4212: getfield 2343	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   4215: ifnull +75 -> 4290
    //   4218: aload 20
    //   4220: aload 16
    //   4222: getfield 2343	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   4225: getstatic 2544	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   4228: invokevirtual 2547	QQService/EVIPSPEC:value	()I
    //   4231: aload 20
    //   4233: getfield 2550	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   4236: invokestatic 2555	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   4239: putfield 2550	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   4242: aload 20
    //   4244: aload 16
    //   4246: getfield 2343	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   4249: getstatic 2558	QQService/EVIPSPEC:E_SP_SUPERQQ	LQQService/EVIPSPEC;
    //   4252: invokevirtual 2547	QQService/EVIPSPEC:value	()I
    //   4255: aload 20
    //   4257: getfield 2561	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   4260: invokestatic 2555	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   4263: putfield 2561	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   4266: aload 20
    //   4268: aload 16
    //   4270: getfield 2343	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   4273: getstatic 2564	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   4276: invokevirtual 2547	QQService/EVIPSPEC:value	()I
    //   4279: aload 20
    //   4281: getfield 2567	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   4284: invokestatic 2555	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   4287: putfield 2567	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   4290: ldc2_w 2381
    //   4293: lload 13
    //   4295: land
    //   4296: lconst_0
    //   4297: lcmp
    //   4298: ifeq +28 -> 4326
    //   4301: aload 4
    //   4303: getfield 2383	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   4306: lconst_1
    //   4307: land
    //   4308: lconst_0
    //   4309: lcmp
    //   4310: ifeq +264 -> 4574
    //   4313: aload 20
    //   4315: aload 20
    //   4317: getfield 2570	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   4320: iconst_1
    //   4321: ior
    //   4322: i2b
    //   4323: putfield 2570	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   4326: aload 17
    //   4328: aload 20
    //   4330: invokevirtual 2573	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   4333: aload_0
    //   4334: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4337: bipush 10
    //   4339: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4342: checkcast 1851	com/tencent/mobileqq/model/PhoneContactManager
    //   4345: astore_2
    //   4346: aload_2
    //   4347: ifnull +23 -> 4370
    //   4350: aload_2
    //   4351: aload 20
    //   4353: getfield 2574	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   4356: invokeinterface 1854 2 0
    //   4361: ifnull +9 -> 4370
    //   4364: aload_2
    //   4365: invokeinterface 1856 1 0
    //   4370: aload_1
    //   4371: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4374: ldc_w 2576
    //   4377: lconst_0
    //   4378: invokevirtual 1992	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   4381: lstore 13
    //   4383: lload 13
    //   4385: lconst_0
    //   4386: lcmp
    //   4387: ifle +128 -> 4515
    //   4390: iload 8
    //   4392: iconst_2
    //   4393: if_icmpeq +16 -> 4409
    //   4396: iload 8
    //   4398: iconst_5
    //   4399: if_icmpeq +10 -> 4409
    //   4402: iload 8
    //   4404: bipush 7
    //   4406: if_icmpne +211 -> 4617
    //   4409: aload 18
    //   4411: lload 13
    //   4413: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4416: invokevirtual 2579	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   4419: astore_1
    //   4420: aload_1
    //   4421: ifnull +94 -> 4515
    //   4424: aload_1
    //   4425: getfield 2584	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   4428: ifnull +163 -> 4591
    //   4431: aload_1
    //   4432: getfield 2584	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   4435: aload 16
    //   4437: getfield 2243	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   4440: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4443: ifne +18 -> 4461
    //   4446: aload_1
    //   4447: aload 16
    //   4449: getfield 2243	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   4452: putfield 2584	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   4455: aload 18
    //   4457: aload_1
    //   4458: invokevirtual 2587	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   4461: aload_0
    //   4462: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4465: bipush 8
    //   4467: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4470: checkcast 703	com/tencent/mobileqq/app/FriendsManagerImp
    //   4473: lload 13
    //   4475: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4478: aload 16
    //   4480: getfield 1995	SummaryCard/RespSummaryCard:lUIN	J
    //   4483: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4486: aload 16
    //   4488: getfield 2249	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   4491: bipush 156
    //   4493: aload 16
    //   4495: getfield 1967	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   4498: aconst_null
    //   4499: bipush 156
    //   4501: bipush 156
    //   4503: bipush 156
    //   4505: ldc2_w 2588
    //   4508: ldc2_w 2588
    //   4511: invokevirtual 2592	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   4514: pop
    //   4515: aload_0
    //   4516: iconst_1
    //   4517: iconst_1
    //   4518: aload 4
    //   4520: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   4523: goto -4198 -> 325
    //   4526: aload 4
    //   4528: iconst_0
    //   4529: putfield 2467	com/tencent/mobileqq/data/Card:allowClick	Z
    //   4532: goto -719 -> 3813
    //   4535: aload 4
    //   4537: iconst_0
    //   4538: putfield 1433	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   4541: goto -693 -> 3848
    //   4544: aload 20
    //   4546: getfield 2510	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   4549: astore_3
    //   4550: goto -482 -> 4068
    //   4553: aload 4
    //   4555: getfield 946	com/tencent/mobileqq/data/Card:shGender	S
    //   4558: iconst_1
    //   4559: if_icmpne +9 -> 4568
    //   4562: iconst_2
    //   4563: istore 5
    //   4565: goto -480 -> 4085
    //   4568: iconst_0
    //   4569: istore 5
    //   4571: goto -486 -> 4085
    //   4574: aload 20
    //   4576: aload 20
    //   4578: getfield 2570	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   4581: bipush 254
    //   4583: iand
    //   4584: i2b
    //   4585: putfield 2570	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   4588: goto -262 -> 4326
    //   4591: aload 16
    //   4593: getfield 2243	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   4596: ifnull -135 -> 4461
    //   4599: aload_1
    //   4600: aload 16
    //   4602: getfield 2243	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   4605: putfield 2584	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   4608: aload 18
    //   4610: aload_1
    //   4611: invokevirtual 2587	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   4614: goto -153 -> 4461
    //   4617: iload 8
    //   4619: iconst_4
    //   4620: if_icmpne -105 -> 4515
    //   4623: aload_0
    //   4624: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4627: bipush 51
    //   4629: invokevirtual 421	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4632: checkcast 2594	com/tencent/mobileqq/app/DiscussionManager
    //   4635: astore_1
    //   4636: aload_1
    //   4637: lload 13
    //   4639: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4642: aload 19
    //   4644: invokevirtual 2597	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   4647: astore_2
    //   4648: aload_2
    //   4649: ifnull -134 -> 4515
    //   4652: aload_2
    //   4653: aload 16
    //   4655: getfield 1967	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   4658: putfield 2602	com/tencent/mobileqq/data/DiscussionMemberInfo:memberName	Ljava/lang/String;
    //   4661: aload 16
    //   4663: getfield 2264	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4666: ifnull +61 -> 4727
    //   4669: aload 16
    //   4671: getfield 2264	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4674: invokevirtual 2605	java/lang/String:length	()I
    //   4677: ifle +50 -> 4727
    //   4680: aload 16
    //   4682: getfield 2264	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4685: aload_2
    //   4686: getfield 2608	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   4689: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4692: ifne +35 -> 4727
    //   4695: aload_2
    //   4696: aload 16
    //   4698: getfield 2264	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4701: putfield 2608	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   4704: aload 16
    //   4706: getfield 2264	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   4709: aload 16
    //   4711: getfield 1967	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   4714: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4717: ifeq +18 -> 4735
    //   4720: aload_2
    //   4721: ldc2_w 2609
    //   4724: putfield 2613	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   4727: aload_1
    //   4728: aload_2
    //   4729: invokevirtual 2616	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   4732: goto -217 -> 4515
    //   4735: aload_2
    //   4736: ldc2_w 2617
    //   4739: putfield 2613	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   4742: goto -15 -> 4727
    //   4745: aload_1
    //   4746: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4749: ldc_w 1951
    //   4752: invokevirtual 880	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   4755: bipush 41
    //   4757: if_icmpeq +18 -> 4775
    //   4760: aload_1
    //   4761: getfield 385	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4764: ldc_w 1951
    //   4767: invokevirtual 880	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   4770: bipush 6
    //   4772: if_icmpne +14 -> 4786
    //   4775: aload_0
    //   4776: bipush 51
    //   4778: iconst_0
    //   4779: aconst_null
    //   4780: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   4783: goto -4458 -> 325
    //   4786: lload 13
    //   4788: lconst_0
    //   4789: lcmp
    //   4790: ifgt +16 -> 4806
    //   4793: aload 4
    //   4795: astore_1
    //   4796: aload_0
    //   4797: iconst_1
    //   4798: iconst_0
    //   4799: aload_1
    //   4800: invokevirtual 440	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   4803: goto -4478 -> 325
    //   4806: lload 13
    //   4808: invokestatic 636	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4811: astore_1
    //   4812: goto -16 -> 4796
    //   4815: astore 4
    //   4817: goto -4432 -> 385
    //   4820: aload_3
    //   4821: astore_1
    //   4822: goto -4281 -> 541
    //   4825: aconst_null
    //   4826: astore_2
    //   4827: goto -4683 -> 144
    //   4830: lconst_0
    //   4831: lstore 11
    //   4833: goto -4786 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4836	0	this	CardHandler
    //   0	4836	1	paramToServiceMsg	ToServiceMsg
    //   0	4836	2	paramFromServiceMsg	FromServiceMsg
    //   0	4836	3	paramObject	Object
    //   0	4836	4	paramBundle	Bundle
    //   4083	487	5	b1	byte
    //   65	3367	6	i1	int
    //   1315	2393	7	i2	int
    //   178	4443	8	i3	int
    //   1357	2172	9	i4	int
    //   3500	1	10	i5	int
    //   45	4787	11	l1	long
    //   154	4653	13	l2	long
    //   2381	346	15	bool	boolean
    //   217	87	16	localRespSummaryCard	SummaryCard.RespSummaryCard
    //   376	4334	16	localException	Exception
    //   197	4130	17	localObject1	Object
    //   211	4398	18	localObject2	Object
    //   1717	2926	19	str	String
    //   2286	2291	20	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   72	94	376	java/lang/Exception
    //   1399	1416	1527	java/lang/Exception
    //   1421	1509	1527	java/lang/Exception
    //   1509	1524	1527	java/lang/Exception
    //   1548	1576	1527	java/lang/Exception
    //   1579	1644	1527	java/lang/Exception
    //   3542	3559	3735	java/lang/Exception
    //   3564	3652	3735	java/lang/Exception
    //   3652	3667	3735	java/lang/Exception
    //   3667	3732	3735	java/lang/Exception
    //   3756	3784	3735	java/lang/Exception
    //   98	105	4815	java/lang/Exception
    //   108	144	4815	java/lang/Exception
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("filekey");
    paramBundle.putByteArray("fileKey", arrayOfByte);
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      RespDelFace localRespDelFace = (RespDelFace)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg.getUin());
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramObject = localFriendsManagerImp.a(paramToServiceMsg.getUin());
      paramFromServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new Card();
        paramFromServiceMsg.uin = paramToServiceMsg.getUin();
      }
      paramBundle.putInt("result", localRespDelFace.stHeader.iReplyCode);
      switch (localRespDelFace.stHeader.iReplyCode)
      {
      }
      for (;;)
      {
        localFriendsManagerImp.a(paramFromServiceMsg);
        return;
        if (localRespDelFace.uFaceTimeStamp > paramFromServiceMsg.uFaceTimeStamp) {
          paramFromServiceMsg.uFaceTimeStamp = localRespDelFace.uFaceTimeStamp;
        }
        paramFromServiceMsg.removePortrait(arrayOfByte);
        a(12, true, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
      }
    }
    paramBundle.putInt("result", -1);
    a(12, false, new Object[] { paramBundle, ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin()) });
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespGetFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        long l1 = paramToServiceMsg.extraData.getLong("lNextMid");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("lUin");
        paramBundle.putString("lUin", paramToServiceMsg);
        paramBundle.putLong("nextMid", l1);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramObject = paramFromServiceMsg.vFaceInfo;
        paramFromServiceMsg = new ArrayList();
        int i1 = 0;
        while (i1 < paramObject.size())
        {
          paramFromServiceMsg.add(HexUtil.a(((FaceInfo)paramObject.get(i1)).vFaceID));
          i1 += 1;
        }
        paramBundle.putStringArrayList("hexFaceInfo", paramFromServiceMsg);
        paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        paramToServiceMsg = paramObject.a(paramToServiceMsg);
        i1 = paramToServiceMsg.getLocalPicKeysCount();
        if ((paramToServiceMsg != null) && (l1 == i1) && (i1 < paramToServiceMsg.getPicCountInAlbum()))
        {
          paramToServiceMsg.appendPortrait(paramFromServiceMsg);
          paramObject.a(paramToServiceMsg);
        }
        a(27, true, paramBundle);
        return;
      }
      paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
      paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
      paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
      paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
      a(27, false, paramBundle);
      return;
    }
    paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
    paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
    paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
    paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
    a(27, false, paramBundle);
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject = (String)paramToServiceMsg.getAttribute("nickname");
    paramBundle = (Byte)paramToServiceMsg.getAttribute("gender");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("birthday");
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|resp.getResultCode = " + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof SetUserInfoResp)))
    {
      paramObject = (SetUserInfoResp)paramObject;
      paramFromServiceMsg = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|setUserInfoResp.result = " + paramObject.result);
      }
    }
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 0))
      {
        String str = paramToServiceMsg.getUin();
        paramFromServiceMsg = paramObject.a(paramToServiceMsg.getUin());
        Friends localFriends = paramObject.c(str);
        if (localObject != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.strNick = ((String)localObject);
          }
          if (localFriends != null)
          {
            localFriends.name = ((String)localObject);
            paramObject.a(localFriends);
          }
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, (String)localObject);
          }
        }
        if (paramBundle != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.shGender = ((short)paramBundle.byteValue());
          }
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str))
          {
            localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
            if (localObject != null) {
              ((DatingManager)localObject).b(paramBundle.byteValue());
            }
          }
        }
        if ((localInteger != null) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.lBirthday = localInteger.intValue();
          paramFromServiceMsg.shAge = ((short)ProfileUtil.a(localInteger.intValue()));
          paramFromServiceMsg.age = ((byte)paramFromServiceMsg.shAge);
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str))
          {
            paramBundle = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
            if (paramBundle != null) {
              paramBundle.a(paramFromServiceMsg.age);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo()  age = " + paramFromServiceMsg.age);
          }
        }
        if (paramFromServiceMsg != null) {
          paramObject.a(paramFromServiceMsg);
        }
        a(paramToServiceMsg, 31, true, paramFromServiceMsg);
        return;
      }
      a(paramToServiceMsg, 31, false, paramObject.b(paramToServiceMsg.getUin()));
      return;
    }
  }
  
  protected Class a()
  {
    return CardObserver.class;
  }
  
  public ArrayList a()
  {
    Object localObject1 = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)localEntityManager.a(CardProfile.class, true, "type=?", new String[] { String.valueOf(2) }, null, null, "lTime desc", "7");
        localEntityManager.a();
        localObject1 = localArrayList;
        if (localArrayList == null) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      finally
      {
        localEntityManager.a();
        if (0 == 0) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public void a()
  {
    a(a("MCardSvc.ReqGetCardSwitch"));
  }
  
  public void a(byte paramByte, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setSelfGender|gender = " + paramByte);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("gender", Byte.valueOf(paramByte));
    a(paramCardObserver);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(3);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setBirthday|birthday = " + paramInt);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("birthday", Integer.valueOf(paramInt));
    a(paramCardObserver);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqVote");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "MCardSvc.ReqPicSafetyCheck");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("lToUIN", paramLong2);
    localToServiceMsg.extraData.putLong("friendUin", paramLong2);
    localToServiceMsg.extraData.putInt("iScene", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.ac;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    new hgy(this, paramPushVoteIncreaseInfo.iIncrement, paramPushVoteIncreaseInfo.vVoterList).start();
    try
    {
      Object localObject1 = new String(localVisitor.vecNick, "UTF8");
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131367541), new Object[] { localObject2 });
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, paramString1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        a(28, true, new Object[] { ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), localObject1 });
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.w("accost", 2, "last voter's name. unsupported encoding.");
        }
        String str = "";
        continue;
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131367542), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putString("uin", (String)localObject1);
                  if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    s(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    r(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqCommonCard".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    q(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    i(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqHYCommonCard".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    p(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    o(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    l(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    m(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    n(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    j(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    k(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    d(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    c(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("VisitorSvc.ReqGetVisitorList".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    e(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqUpdateQQFace".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    f(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    h(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    g(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
                    {
                      if (((RespUpdateIntro)paramObject).stHeader.iReplyCode == 0)
                      {
                        a(9, true, ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin()));
                        return;
                      }
                      a(9, false, localObject2);
                      return;
                    }
                    a(9, false, localObject2);
                    return;
                  }
                  if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    t(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if ("ProfileService.getFriendInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    if (paramFromServiceMsg.getResultCode() == 1000)
                    {
                      a(16, true, localObject2);
                      return;
                    }
                    a(16, false, localObject2);
                    return;
                  }
                  if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    if (paramFromServiceMsg.getResultCode() == 1000)
                    {
                      a(17, true, ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramToServiceMsg.getUin()));
                      return;
                    }
                    a(17, false, localObject2);
                    return;
                  }
                  if ("ProfileService.SetUserInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    v(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                    return;
                  }
                  if (!"AccostSvc.ClientMsg".equals(paramFromServiceMsg.getServiceCmd())) {
                    break;
                  }
                } while (paramFromServiceMsg.getResultCode() != 1000);
                paramToServiceMsg = (RespClientMsg)paramFromServiceMsg.getAttribute("result");
              } while ((paramToServiceMsg == null) || (1 != paramToServiceMsg.stMsg.eAccostType));
              a(22, true, localObject2);
              return;
              if ("AccostSvc.SvrMsg".equals(paramFromServiceMsg.getServiceCmd()))
              {
                if (paramFromServiceMsg.getResultCode() == 1000) {}
                for (boolean bool = true;; bool = false)
                {
                  a(29, bool, localObject2);
                  return;
                }
              }
              if ("MobileQQ.SendPortraitDownloadVerifyCode".equals(paramFromServiceMsg.getServiceCmd()))
              {
                paramToServiceMsg = paramFromServiceMsg.extraData.getString("filekey");
                ((Bundle)localObject2).putString("filekey", paramToServiceMsg);
                if ((paramToServiceMsg != null) && (!"".equals(paramToServiceMsg)))
                {
                  a(21, true, localObject2);
                  return;
                }
                a(21, false, localObject2);
                return;
              }
              if ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()))
              {
                ((Bundle)localObject2).putString("uin", String.valueOf(paramToServiceMsg.extraData.getLong("lToUIN")));
                if (paramFromServiceMsg.getResultCode() == 1000)
                {
                  a(23, true, localObject2);
                  return;
                }
                a(23, false, localObject2);
                return;
              }
              if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd()))
              {
                u(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                return;
              }
            } while ("PttCenterSvr.ReqBody".equals(paramFromServiceMsg.getServiceCmd()));
            if ("OidbSvc.0x490_100".equals(paramFromServiceMsg.getServiceCmd()))
            {
              b(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("OidbSvc.0x491_100".equals(paramFromServiceMsg.getServiceCmd()))
            {
              c(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
            {
              g(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (!"OidbSvc.0x480_9".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
          } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
          if (paramToServiceMsg.extraData.getBoolean("isGetLoginDays", false))
          {
            j(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ((paramToServiceMsg.extraData.getBoolean("activeGetDatingSymbol", false)) || (paramToServiceMsg.extraData.getBoolean("nearby_people_profile_ok_new", false)))
          {
            f(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
          {
            h(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getBoolean("isGetActivateFriend", false))
          {
            l(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          e(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          if (!"OidbSvc.0x4ff_9".equals(paramFromServiceMsg.getServiceCmd())) {
            break;
          }
        } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
        if (paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false))
        {
          k(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
        {
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.extraData.getBoolean("isSetActivateFriend", false))
        {
          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.extraData.getBoolean("calltabstate", false))
        {
          q(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
        {
          n(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x5ea_2".equals(paramFromServiceMsg.getServiceCmd()));
      if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()));
    p(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonecover.", 2, "getQzoneCover");
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.getCover");
    localToServiceMsg.addAttribute("uin", paramString);
    localToServiceMsg.addAttribute("flag", Integer.valueOf(paramInt));
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, byte paramByte, ArrayList paramArrayList1, byte[] paramArrayOfByte1, ArrayList paramArrayList2, ArrayList paramArrayList3, byte[] paramArrayOfByte2)
  {
    paramString = a("MCardSvc.ReqSetCard");
    paramString.extraData.putInt("eSubCmd", paramInt);
    paramString.extraData.putByte("bIsSingle", paramByte);
    paramString.extraData.putByteArray("vBackground", paramArrayOfByte1);
    paramString.extraData.putByteArray("vReqSetTemplate", paramArrayOfByte2);
    try
    {
      paramArrayOfByte1 = new ByteArrayOutputStream();
      paramArrayOfByte2 = new ObjectOutputStream(paramArrayOfByte1);
      paramArrayOfByte2.writeObject(paramArrayList1);
      paramArrayOfByte2.flush();
      paramString.extraData.putByteArray("vTagsID", paramArrayOfByte1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList2);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vDelTags", paramArrayList1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList3);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vAddTags", paramArrayList1.toByteArray());
      a(paramString);
      return;
    }
    catch (IOException paramArrayList1)
    {
      for (;;)
      {
        paramArrayList1.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqGetFace");
    localToServiceMsg.extraData.putString("lUin", paramString);
    localToServiceMsg.extraData.putLong("lNextMid", paramLong);
    localToServiceMsg.extraData.putInt("iPageSize", paramInt);
    localToServiceMsg.extraData.putByteArray("strCookie", paramArrayOfByte);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "deleteLbsPortrait() uin = " + paramString);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqDelFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    localToServiceMsg.extraData.putLong("timestamp", paramLong);
    localToServiceMsg.extraData.putString("touin", paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localToServiceMsg);
  }
  
  public void a(String paramString, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setSelfNickname|nickName = " + paramString);
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("nickname", paramString);
    a(paramCardObserver);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqHYMakeFriendsCard");
    paramString1.extraData.putString("friendUin", paramString2);
    paramString1.extraData.putByte("bReqType", paramByte);
    paramString1.extraData.putInt("uFaceTimeStamp", paramInt);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2)
  {
    a(paramString1, paramString2, paramInt1, paramLong1, paramByte, paramLong2, paramLong3, paramArrayOfByte1, paramString3, paramLong4, paramInt2, paramArrayOfByte2, 0L, false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt1);
      paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      paramString1.extraData.putByte("isFriend", paramByte);
      paramString1.extraData.putLong("troopCode", paramLong2);
      paramString1.extraData.putLong("troopUin", paramLong3);
      paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
      paramString1.extraData.putString("strSearchName", paramString3);
      paramString1.extraData.putLong("lGetControl", paramLong4);
      paramString1.extraData.putInt("EAddFriendSource", paramInt2);
      paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      paramString1.extraData.putLong("tinyId", paramLong5);
      paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean);
      a(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "qq_error|getSummayCard() " + paramString1.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVoterList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.LikeIt");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("destUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("labelId", paramLong.longValue());
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, short paramShort)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqUpdateIntro");
    paramString1.extraData.putString("vContent", paramString2);
    paramString1.extraData.putShort("shType", paramShort);
    a(paramString1);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(paramArrayList.get(i1)).append(", ");
        i1 += 1;
      }
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.updateNearbyPeoplePhotoList(), photo_ids = " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    localReqBody.rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = a("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    b(paramArrayList);
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)paramList.next()).labelId);
      }
      paramList = a("SummaryCard.SetLabel");
      paramList.extraData.putSerializable("labels", (Serializable)localArrayList);
      a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i1 = 0;
    }
    ((ByteBuffer)localObject).put((byte)i1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_searchable", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "uploadAvatarResult|isSuc = " + paramBoolean);
    }
    String str = ProfileCardUtil.c();
    ProfileCardUtil.a(null);
    EntityManager localEntityManager;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = (Setting)localEntityManager.a(Setting.class, paramString);
      if (localObject2 != null) {
        break label264;
      }
      localObject1 = new Setting();
      ((Setting)localObject1).uin = paramString;
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).bUsrType = 1;
      localEntityManager.a((Entity)localObject1);
    }
    for (;;)
    {
      localEntityManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((Setting)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.d((String)localObject1);
      }
      localObject2 = ProfileCardUtil.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.d((String)localObject2);
      }
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        ImageUtil.a(null, str, (String)localObject1, 100, 100);
        FileUtils.c(str, (String)localObject2);
      }
      if (!TextUtils.isEmpty(str)) {
        FileUtils.d(str);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", paramString);
      a(8, paramBoolean, localObject1);
      return;
      label264:
      localObject1 = localObject2;
      if (((Setting)localObject2).bHeadType == 0)
      {
        ((Setting)localObject2).bHeadType = 1;
        localEntityManager.a((Entity)localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = a("MCardSvc.ReqSetCardSwitch");
    localToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", paramBoolean1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramBoolean2) {}
    for (long l1 = 0L;; l1 = 1L)
    {
      localBundle.putLong("target_value", l1);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCardSvc.ReqAddFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localToServiceMsg.extraData.putInt("timestamp", paramInt);
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    a(localToServiceMsg);
  }
  
  public void a(int[] paramArrayOfInt, CardObserver paramCardObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "setCity");
    }
    paramCardObserver = a("ProfileService.SetUserInfoReq", paramCardObserver);
    paramCardObserver.addAttribute("city", paramArrayOfInt);
    a(paramCardObserver);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqVoiceManage");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqCommonCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqMakeFriendsCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqHYCommonCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqHYMakeFriendsCard");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqSetCard");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.SetLabel");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.LikeIt");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqGetCardSwitch");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqSetCardSwitch");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqVote");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqGetVoterList");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqGetFavoriteList");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqGetVisitorList");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqUpdateQQFace");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqFaceInfo");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqAddFace");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqUpdateIntro");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqDelFace");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.getFriendInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.getGroupInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GetSglUsrFullInfo");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.SetUserInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.ClientMsg");
      this.jdField_a_of_type_JavaUtilSet.add("AccostSvc.SvrMsg");
      this.jdField_a_of_type_JavaUtilSet.add("MobileQQ.SendPortraitDownloadVerifyCode");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqPicSafetyCheck");
      this.jdField_a_of_type_JavaUtilSet.add("MCardSvc.ReqGetFace");
      this.jdField_a_of_type_JavaUtilSet.add("PttCenterSvr.ReqBody");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x490_100");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x491_100");
      this.jdField_a_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x480_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public ArrayList b()
  {
    Object localObject1 = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)localEntityManager.a(CardProfile.class, true, "type=?", new String[] { String.valueOf(3) }, null, null, "lTime desc", "7");
        localEntityManager.a();
        localObject1 = localArrayList;
        if (localArrayList == null) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      finally
      {
        localEntityManager.a();
        if (0 == 0) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt);
    a(localToServiceMsg);
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hgz(this, paramBundle));
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetFavoriteList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  /* Error */
  protected void b(String paramString, List paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokeinterface 323 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 415	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 650	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   20: invokevirtual 656	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 3235	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 3238	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   35: aload_2
    //   36: invokeinterface 490 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 495 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 499 1 0
    //   58: checkcast 827	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 927	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 1527	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 3235	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 3240	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   79: aload_1
    //   80: invokevirtual 1264	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 3235	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 3242	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   91: aload_1
    //   92: invokevirtual 3235	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 3240	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   98: aload_1
    //   99: invokevirtual 1264	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 3235	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 3240	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   111: aload_1
    //   112: invokevirtual 1264	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	CardHandler
    //   0	117	1	paramString	String
    //   0	117	2	paramList	List
    // Exception table:
    //   from	to	target	type
    //   28	42	67	java/lang/Exception
    //   42	64	67	java/lang/Exception
    //   84	91	67	java/lang/Exception
    //   28	42	103	finally
    //   42	64	103	finally
    //   68	72	103	finally
    //   84	91	103	finally
  }
  
  public void b(boolean paramBoolean)
  {
    short s1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setPCActiveState OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)-25042).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isGetLoginDays", false);
          ((ToServiceMsg)localObject).extraData.putBoolean("pcActiveState", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPCActiveState ex", localException);
      }
      s1 = 0;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    short s1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setCallTabState open=" + paramBoolean1);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean1 == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)-25217).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean1);
          ((ToServiceMsg)localObject).extraData.putBoolean("calltabstate", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setCallTabState ex", localException);
      }
      s1 = 1;
    }
  }
  
  public ArrayList c()
  {
    Object localObject1 = null;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)localEntityManager.a(CardProfile.class, true, "type=?", new String[] { String.valueOf(1) }, null, null, "lTime desc", "8");
        localEntityManager.a();
        localObject1 = localArrayList;
        if (localArrayList == null) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      finally
      {
        localEntityManager.a();
        if (0 == 0) {
          localObject1 = new ArrayList(0);
        }
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public void c(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVisitorList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  public void c(boolean paramBoolean)
  {
    short s1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setLoginDaysSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetLoginDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
      }
      s1 = 0;
    }
  }
  
  public void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)-25217));
    localArrayList.add(Short.valueOf((short)-25040));
    localArrayList.add(Short.valueOf((short)-23754));
    localArrayList.add(Short.valueOf((short)-23776));
    localArrayList.add(Short.valueOf((short)-25042));
    a(localArrayList, null);
  }
  
  public void d(boolean paramBoolean)
  {
    short s1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l1)).put((byte)0).putShort((short)1).putShort((short)-25031).putShort((short)2).putShort(s1);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetActivateFriend", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch ex", localException);
      }
      s1 = 1;
    }
  }
  
  public void f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)27037));
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)24008));
    localArrayList.add(Short.valueOf((short)24002));
    localArrayList.add(Short.valueOf((short)20043));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)20011));
    localArrayList.add(Short.valueOf((short)20019));
    localArrayList.add(Short.valueOf((short)20021));
    localArrayList.add(Short.valueOf((short)20037));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("reqFromDetailActivity", true);
    a(localArrayList, localBundle);
  }
  
  public void g()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject = ByteBuffer.allocate(21);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)7);
    ((ByteBuffer)localObject).putShort((short)-25223);
    ((ByteBuffer)localObject).putShort((short)-25222);
    ((ByteBuffer)localObject).putShort((short)-25221);
    ((ByteBuffer)localObject).putShort((short)-25220);
    ((ByteBuffer)localObject).putShort((short)-25219);
    ((ByteBuffer)localObject).putShort((short)-25218);
    ((ByteBuffer)localObject).putShort((short)-25216);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x480_9");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
    b((ToServiceMsg)localObject);
  }
  
  public void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25040));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("nearby_people_profile_ok_new", true);
    a(localArrayList, localBundle);
  }
  
  public void i()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23776));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("activeGetDatingSymbol", true);
    a(localArrayList, localBundle);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getPCActiveState");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25042));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("pcActiveState", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getPCActiveState ex", localException);
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_b_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetLoginDays", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25031));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetActivateFriend", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch ex", localException);
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler
 * JD-Core Version:    0.7.0.1
 */