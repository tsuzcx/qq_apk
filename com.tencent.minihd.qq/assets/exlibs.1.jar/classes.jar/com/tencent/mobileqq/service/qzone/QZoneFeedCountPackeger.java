package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.get_relate_qq_count_req;
import NS_UNDEAL_COUNT.get_relate_qq_count_rsp;
import NS_UNDEAL_COUNT.master_info;
import NS_UNDEAL_COUNT.mobile_count_req;
import NS_UNDEAL_COUNT.mobile_count_rsp;
import NS_UNDEAL_COUNT.operat_data;
import NS_UNDEAL_COUNT.s_passive_detail_info;
import NS_UNDEAL_COUNT.single_count;
import NS_UNDEAL_COUNT.yellow_info;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.ExtraConfig;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.qzone.WNSStream;
import cooperation.qzone.util.ProtocolUtils;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import cooperation.qzone.util.QZoneLogTags;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import jvh;

public class QZoneFeedCountPackeger
{
  public static final int a = 0;
  public static String a;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  public static final String b = "getUndealCount";
  public static final int c = 2;
  public static final String c = "getRelateUserCount";
  public static final int d = 3;
  private static final String d = QZoneLogTags.b + QZoneFeedCountPackeger.class.getSimpleName();
  public static final int e = 4;
  private static String e = "key_personalization_undeal_Count";
  public static final int f = 5;
  public static final int g = 6;
  private static final int h = 1;
  private static int i;
  private static int j;
  
  static
  {
    jdField_a_of_type_JavaLangString = "hostuin";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
    i = 7;
    j = 3;
  }
  
  public static JceStruct a(int paramInt)
  {
    String str = QZConfigProviderUtil.a();
    if (QLog.isDevelopLevel()) {
      QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    }
    if (str != null) {}
    for (;;)
    {
      return new mobile_get_config_req(1000027, paramInt, str);
      str = "";
    }
  }
  
  private static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).a(ProtocolUtils.b(paramArrayOfByte));
      paramArrayOfByte = new UniAttribute();
      if ((localObject1 != null) && (((QmfDownstream)localObject1).WnsCode == 0))
      {
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        Object localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.b(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 == null) {
            break label182;
          }
          ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
        }
        localObject2 = new UniAttribute();
        ((UniAttribute)localObject2).setEncodeName("utf-8");
        ((UniAttribute)localObject2).decode(((QmfDownstream)localObject1).BusiBuff);
        paramString = (JceStruct)((UniAttribute)localObject2).get(paramString);
        ThreadManager.b(new jvh(paramArrayOfByte, paramQQAppInterface));
        return paramString;
      }
      if (localObject1 != null)
      {
        int k = ((QmfDownstream)localObject1).WnsCode;
        if (k != 0) {
          return null;
        }
      }
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label182:
    return null;
  }
  
  public static QZoneFeedCountPackeger.GetSubAccountUnreadResponse a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "get subaccount unread count,decode error");
      }
      return null;
    }
    paramArrayOfByte = (get_relate_qq_count_rsp)a(paramArrayOfByte, paramQQAppInterface, "getRelateUserCount");
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "get subaccount unread count,decode error");
      }
      return null;
    }
    paramArrayOfByte = (s_passive_detail_info)paramArrayOfByte.mapRelatePassiveInfo.get(Long.valueOf(paramLong));
    if (paramArrayOfByte == null) {
      return null;
    }
    paramQQAppInterface = new QZoneFeedCountPackeger.GetSubAccountUnreadResponse();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramArrayOfByte.sPassiveMessage;
    paramQQAppInterface.jdField_a_of_type_Long = paramArrayOfByte.uPassiveCount;
    paramQQAppInterface.b = paramArrayOfByte.uRecentPassvieTime;
    paramQQAppInterface.c = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "get subaccount unread count,decode succ");
    }
    return paramQQAppInterface;
  }
  
  public static Map a(long paramLong)
  {
    return a(LocalMultiProcConfig.a("CTIME_MAP" + paramLong, ""));
  }
  
  public static Map a(long paramLong, Integer paramInteger)
  {
    Object localObject = a(paramLong);
    HashMap localHashMap = new HashMap();
    localObject = (Long)((Map)localObject).get(paramInteger);
    if (localObject == null) {}
    for (paramLong = 0L;; paramLong = ((Long)localObject).longValue())
    {
      localHashMap.put(paramInteger, Long.valueOf(paramLong));
      return localHashMap;
    }
  }
  
  public static Map a(String paramString)
  {
    int k = 0;
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int m = paramString.length;
    if (k < m)
    {
      String[] arrayOfString = paramString[k].split("=");
      if (arrayOfString.length != 2) {}
      for (;;)
      {
        k += 1;
        break;
        try
        {
          localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), Long.valueOf(URLDecoder.decode(arrayOfString[1], "UTF-8")));
        }
        catch (UnsupportedEncodingException paramString)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramString);
        }
      }
    }
    return localHashMap;
  }
  
  private static void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, single_count paramsingle_count, long[] paramArrayOfLong, int paramInt4)
  {
    int k;
    int m;
    label31:
    String str;
    if ((paramInt1 & paramLong1) != 0L)
    {
      k = 1;
      m = 0;
      if (k != 0)
      {
        if ((paramInt2 & paramLong1) == 0L) {
          break label321;
        }
        paramInt1 = 1;
        str = "NavigatorItemShow" + paramInt3;
        if (paramInt1 == 0) {
          break label326;
        }
        paramInt2 = 1;
        label60:
        LocalMultiProcConfig.a(str, paramInt2, paramLong2);
        m = paramInt1;
        if (QLog.isDevelopLevel())
        {
          str = QZoneLogTags.c + "." + d;
          StringBuilder localStringBuilder = new StringBuilder().append("; save sharerefrence NavigatorItemFlagValid").append(paramInt3).append(": ");
          if (k == 0) {
            break label331;
          }
          paramInt2 = 1;
          label140:
          localStringBuilder = localStringBuilder.append(paramInt2).append(";NavigatorItemShow").append(paramInt3).append(": ");
          if (paramInt1 == 0) {
            break label336;
          }
          paramInt2 = 1;
          label171:
          QLog.d(str, 4, paramInt2);
          m = paramInt1;
        }
      }
      str = "NavigatorItemFlagValid" + paramInt3;
      if (k == 0) {
        break label341;
      }
    }
    label321:
    label326:
    label331:
    label336:
    label341:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      LocalMultiProcConfig.a(str, paramInt1, paramLong2);
      if (paramsingle_count != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(QZoneLogTags.c + "." + d, 4, "onResponse unread : " + paramsingle_count.uCount);
        }
        if ((k != 0) && (m != 0) && (paramArrayOfLong != null) && (paramInt4 >= 0)) {
          break label346;
        }
      }
      return;
      k = 0;
      break;
      paramInt1 = 0;
      break label31;
      paramInt2 = 0;
      break label60;
      paramInt2 = 0;
      break label140;
      paramInt2 = 0;
      break label171;
    }
    label346:
    if (QLog.isDevelopLevel()) {
      QLog.d(QZoneLogTags.c + "." + d, 4, "account: " + paramLong2 + " QZoneFeedCountPackeger mCountArray[xxx] = rsp.xxx.uCount");
    }
    paramArrayOfLong[paramInt4] = paramsingle_count.uCount;
  }
  
  private static void a(mobile_count_rsp parammobile_count_rsp, long[] paramArrayOfLong, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(QZoneLogTags.c + "." + d, 4, "account: " + paramQQAppInterface.getLongAccountUin() + " rsp.busiFlag: " + parammobile_count_rsp.busiFlag);
    }
    if (parammobile_count_rsp.stPersionalInfo != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(QZoneLogTags.i + d, 4, "account: " + paramQQAppInterface.getLongAccountUin() + "rsp stPersionalInfo unread count:" + parammobile_count_rsp.stPersionalInfo.uCount);
      }
      LocalMultiProcConfig.a(e, parammobile_count_rsp.stPersionalInfo.uCount);
      Intent localIntent = new Intent("action_undealCount_to_qzone");
      BaseApplication.getContext().sendBroadcast(localIntent);
    }
    a(parammobile_count_rsp.busiFlag, 1, 2, i, paramQQAppInterface.getLongAccountUin(), parammobile_count_rsp.stZebraAppInfo, paramArrayOfLong, 5);
    a(parammobile_count_rsp.busiFlag, 4, 8, j, paramQQAppInterface.getLongAccountUin(), null, null, -1);
  }
  
  private static void a(Context paramContext, mobile_get_config_rsp parammobile_get_config_rsp)
  {
    if ((parammobile_get_config_rsp != null) && (parammobile_get_config_rsp.config != null) && (!parammobile_get_config_rsp.config.isEmpty())) {}
    try
    {
      ExtraConfig.a(parammobile_get_config_rsp.config, true);
      label32:
      String str = BaseApplication.getContext().getPackageName();
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = "unknow";
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfigProvider", 2, "qq config update:" + paramContext);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(d, 4, d + " saveConfigToProvider");
      }
      QZConfigProviderUtil.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      break label32;
    }
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(d, 4, "QZoneFeedCountPackeger execCmds");
    }
    Object localObject1;
    Object localObject2;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (operat_data)((Iterator)localObject1).next();
        if ((localObject2 != null) && (QLog.isDevelopLevel()))
        {
          QLog.d(d, 4, "QZoneFeedCountPackeger operat_data cmd: " + ((operat_data)localObject2).cmd);
          QLog.d(d, 4, "QZoneFeedCountPackeger operat_data desc: " + ((operat_data)localObject2).desc);
        }
      }
    }
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (operat_data)paramArrayList.next();
        if (localObject1 != null)
        {
          localObject2 = new QZoneDistributedAppCtrl.Control();
          ((QZoneDistributedAppCtrl.Control)localObject2).jdField_a_of_type_Int = ((operat_data)localObject1).cmd;
          if ((((operat_data)localObject1).mapExt != null) && (((operat_data)localObject1).mapExt.size() > 0)) {
            ((QZoneDistributedAppCtrl.Control)localObject2).jdField_a_of_type_JavaUtilMap.putAll(((operat_data)localObject1).mapExt);
          }
          ((QZoneDistributedAppCtrl.Control)localObject2).jdField_a_of_type_JavaUtilMap.put("key_desc", ((operat_data)localObject1).desc);
          QZoneDistributedAppCtrl.a(BaseApplicationImpl.getContext(), paramString).a((QZoneDistributedAppCtrl.Control)localObject2);
        }
      }
    }
  }
  
  public static byte[] a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString = new mobile_count_req();
    paramString.uMask = 1041L;
    paramString.iRelationType = 1;
    paramString.iVisitQZoneType = paramInt3;
    paramString.mapTimeStamp = a(paramLong, Integer.valueOf(0));
    return a(paramString, "getUndealCount", paramLong, paramInt1, paramInt2, paramInt4);
  }
  
  public static byte[] a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return null;
    }
    paramString = new get_relate_qq_count_req();
    paramString.vecRelateUserlist = new ArrayList();
    paramString.vecRelateUserlist.add(Long.valueOf(paramLong2));
    return a(paramString, "getRelateUserCount", paramLong1, paramInt1, paramInt2, paramInt3);
  }
  
  private static byte[] a(JceStruct paramJceStruct, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject1 = new UniAttribute();
      ((UniAttribute)localObject1).setEncodeName("utf8");
      ((UniAttribute)localObject1).put(jdField_a_of_type_JavaLangString, Long.valueOf(paramLong));
      if ((paramJceStruct != null) && (paramString != null) && (paramString.length() > 0)) {
        ((UniAttribute)localObject1).put(paramString, paramJceStruct);
      }
      localObject1 = ((UniAttribute)localObject1).encode();
      paramJceStruct = QZoneHelper.a();
      Object localObject2 = "screen_width=" + paramInt1 + "&screen_height=" + paramInt2 + "&" + PlatformInfor.a().e();
      localObject2 = new WNSStream(1000027, paramJceStruct, paramLong, new byte[0], (String)localObject2);
      if (localObject1 != null) {
        try
        {
          paramJceStruct = a(paramInt3);
          return ProtocolUtils.a(((WNSStream)localObject2).a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement(), "QzoneNewService." + paramString, (byte[])localObject1, false, paramJceStruct));
        }
        catch (Error paramJceStruct)
        {
          for (;;)
          {
            paramJceStruct.printStackTrace();
            paramJceStruct = null;
          }
        }
      }
      return null;
    }
    catch (Exception paramJceStruct)
    {
      paramJceStruct.printStackTrace();
    }
    return null;
  }
  
  public static long[] a(byte[] arg0, QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(d, 4, "onResponse");
    }
    if (??? == null) {
      return null;
    }
    mobile_count_rsp localmobile_count_rsp = (mobile_count_rsp)a(???, paramQQAppInterface, "getUndealCount");
    if (localmobile_count_rsp == null) {
      return null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(d, 4, "onResponseCMD_STRING_GET_UNDEAL_COUNT has data");
    }
    a(localmobile_count_rsp.vecOperateInfo, paramQQAppInterface.a());
    synchronized (new long[6])
    {
      long l = localmobile_count_rsp.uRspMask;
      if ((0x2 & l) != 0L) {
        ???[0] = localmobile_count_rsp.stActiveCount.uCount;
      }
      if ((l & 1L) != 0L) {
        ???[1] = localmobile_count_rsp.stPassiveCount.uCount;
      }
      if ((localmobile_count_rsp.vecUpdateFeedFriendsList != null) && (localmobile_count_rsp.vecUpdateFeedFriendsList.size() >= 1))
      {
        ???[3] = ((feed_host_info)localmobile_count_rsp.vecUpdateFeedFriendsList.get(0)).uUin;
        paramArrayList.addAll(localmobile_count_rsp.vecUpdateFeedFriendsList);
      }
      if ((localmobile_count_rsp.vecUpdatePassiveList != null) && (localmobile_count_rsp.vecUpdatePassiveList.size() >= 1)) {
        ???[4] = ((feed_host_info)localmobile_count_rsp.vecUpdatePassiveList.get(0)).uUin;
      }
      ???[2] = localmobile_count_rsp.iNextTimeout;
      if (localmobile_count_rsp.stYellowInfo != null)
      {
        paramArrayList = paramQQAppInterface.a();
        if (!TextUtils.isEmpty(paramArrayList)) {
          QZoneVipInfoManager.a().a(paramArrayList, localmobile_count_rsp.stYellowInfo.iYellowType, localmobile_count_rsp.stYellowInfo.iYellowLevel, localmobile_count_rsp.stYellowInfo.isAnnualVip);
        }
      }
      if (localmobile_count_rsp.masterinfo != null)
      {
        paramArrayList = (QZoneManagerImp)paramQQAppInterface.getManager(9);
        paramArrayList.a(localmobile_count_rsp.masterinfo.iLevel, localmobile_count_rsp.masterinfo.strMessage);
        paramArrayList.a(localmobile_count_rsp.masterinfo.host_unimbitmap);
      }
      a(localmobile_count_rsp, ???, paramQQAppInterface);
      return ???;
    }
  }
  
  private static void b(UniAttribute paramUniAttribute, QQAppInterface paramQQAppInterface)
  {
    if (paramUniAttribute != null) {
      try
      {
        Object localObject = paramUniAttribute.get("conf_info_rsp_len");
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(d, 2, "processConfig pack get conf_info_rsp_len is null ");
          }
        }
        else
        {
          int k = ((Integer)localObject).intValue();
          localObject = (byte[])paramUniAttribute.get("conf_info_rsp");
          paramUniAttribute = (UniAttribute)localObject;
          if (localObject != null)
          {
            paramUniAttribute = (UniAttribute)localObject;
            if (k != 0) {
              paramUniAttribute = WNSStream.b((byte[])localObject);
            }
          }
          if (paramUniAttribute != null)
          {
            paramUniAttribute = WNSStream.a(mobile_get_config_rsp.class, paramUniAttribute);
            if ((paramQQAppInterface != null) && (paramQQAppInterface.a() != null) && (paramUniAttribute != null))
            {
              a(paramQQAppInterface.a(), (mobile_get_config_rsp)paramUniAttribute);
              return;
            }
          }
        }
      }
      catch (Error paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
        return;
      }
      catch (Exception paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger
 * JD-Core Version:    0.7.0.1
 */