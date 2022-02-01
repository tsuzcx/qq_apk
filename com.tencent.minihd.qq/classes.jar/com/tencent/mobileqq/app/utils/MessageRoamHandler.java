package com.tencent.mobileqq.app.utils;

import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import hur;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class MessageRoamHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = "Q.roammsg";
  private static final String b = "EndRoamYearKey";
  private static final String c = "EndRoamMonthKey";
  private static final String d = "EndRoamDayKey";
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new hur(this);
  
  public MessageRoamHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "handleTimeOut serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    paramToServiceMsg.sendMessageDelayed(paramToServiceMsg.obtainMessage(14), 0L);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "handleError serviceCmd:" + paramFromServiceMsg.getServiceCmd());
    }
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    paramToServiceMsg.sendMessageDelayed(paramToServiceMsg.obtainMessage(14), 0L);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j;
    label192:
    int k;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
        {
          j = paramToServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_1 ret = " + j);
          }
          if (j != 0) {
            break label192;
          }
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          i = paramToServiceMsg.length;
          long l = 0L;
          if (4 <= i) {
            PkgTools.a(paramToServiceMsg, 0);
          }
          if (8 <= i) {
            l = PkgTools.a(paramToServiceMsg, 4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_1 dwIndex = " + l);
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        do
        {
          paramToServiceMsg.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_1 error: ", paramToServiceMsg);
        return;
      }
      paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      k = paramFromServiceMsg.length;
      paramToServiceMsg = null;
      if (1 > k) {
        break label344;
      }
    }
    label344:
    for (int i = (short)paramFromServiceMsg[0];; i = 0)
    {
      if (i + 1 <= k) {
        paramToServiceMsg = PkgTools.a(paramFromServiceMsg, 1, i);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramFromServiceMsg = new StringBuilder().append("handle_oidb_0x42e_1 ret = ").append(j).append(", ");
      if (paramToServiceMsg != null) {}
      for (;;)
      {
        QLog.d("Q.roammsg", 2, paramToServiceMsg);
        return;
        paramToServiceMsg = "null";
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramObject = new StringBuilder().append("handle_oidb_0x42e_1 error: ");
      if (paramFromServiceMsg != null) {}
      for (paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());; paramToServiceMsg = "null")
      {
        QLog.d("Q.roammsg", 2, paramToServiceMsg);
        return;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      localObject = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      int j;
      int i3;
      long l;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          j = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.roammsg", 2, "handle_oidb_0x42e_3 ret = " + j);
          }
          if (j != 0) {
            break label633;
          }
          localObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          i3 = localObject.length;
          l = 0L;
          i = 0;
          j = 0;
          if (4 <= i3) {
            l = PkgTools.a((byte[])localObject, 0);
          }
          if (6 > i3) {
            break label820;
          }
          k = PkgTools.a((byte[])localObject, 4);
          if (8 > i3) {
            break label814;
          }
          m = PkgTools.a((byte[])localObject, 6);
          if (10 <= i3) {
            i = PkgTools.a((byte[])localObject, 8);
          }
          if (12 <= i3) {
            j = PkgTools.a((byte[])localObject, 10);
          }
          if ((i == 0) && (j == 0) && (k == 0) && (m == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 : wYearEnd = wMonthEnd = wYearStart = wMonthStart = 0");
            }
            paramObject.sendMessageDelayed(paramObject.obtainMessage(15), 0L);
          }
        }
        else
        {
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 error: ", paramToServiceMsg);
        }
        paramObject.sendMessageDelayed(paramObject.obtainMessage(14), 0L);
        return;
      }
      int i4 = (i - k) * 12 + (j - m) + 1;
      paramFromServiceMsg = new long[i4];
      int i1 = 12;
      int n = 0;
      while (n < i4)
      {
        i2 = i1;
        if (i1 + 4 <= i3)
        {
          paramFromServiceMsg[n] = PkgTools.a((byte[])localObject, i1);
          i2 = i1 + 4;
        }
        n += 1;
        i1 = i2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 : dwIndexes = " + Arrays.toString(paramFromServiceMsg));
      }
      i4 = paramToServiceMsg.extraData.getInt("EndRoamYearKey");
      int i5 = paramToServiceMsg.extraData.getInt("EndRoamMonthKey");
      int i2 = paramToServiceMsg.extraData.getInt("EndRoamDayKey");
      paramToServiceMsg = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(86);
      n = 0;
      for (;;)
      {
        i3 = 31;
        i1 = i3;
        if (i == i4)
        {
          i1 = i3;
          if (j == i5) {
            i1 = i2;
          }
        }
        paramToServiceMsg.a().a(l, i, j, (int)paramFromServiceMsg[n], i1);
        if (j - 1 > 0)
        {
          i1 = j - 1;
          j = i;
          i = i1;
        }
        while ((j < k) || ((j == k) && (i < m)))
        {
          paramToServiceMsg.b(i4, i5, i2);
          paramToServiceMsg.a().a(String.valueOf(l), k, m, i4, i5);
          paramToServiceMsg.e();
          paramObject.sendMessageDelayed(paramObject.obtainMessage(16), 0L);
          return;
          j = 12;
          i1 = i - 1;
          i = j;
          j = i1;
        }
        i1 = i;
        n += 1;
        i = j;
        j = i1;
      }
      label633:
      paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      int k = paramFromServiceMsg.length;
      int i = 0;
      paramToServiceMsg = null;
      if (1 <= k) {
        i = (short)paramFromServiceMsg[0];
      }
      if (i + 1 <= k) {
        paramToServiceMsg = PkgTools.a(paramFromServiceMsg, 1, i);
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("handle_oidb_0x42e_3 ret = ").append(j).append(", ");
        if (paramToServiceMsg == null) {
          break label742;
        }
      }
      for (;;)
      {
        QLog.d("Q.roammsg", 2, paramToServiceMsg);
        paramObject.sendMessageDelayed(paramObject.obtainMessage(14), 0L);
        return;
        label742:
        paramToServiceMsg = "null";
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handle_oidb_0x42e_3 error: ");
        if (paramFromServiceMsg == null) {
          break label808;
        }
      }
      label808:
      for (paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());; paramToServiceMsg = "null")
      {
        QLog.d("Q.roammsg", 2, paramToServiceMsg);
        paramObject.sendMessageDelayed(paramObject.obtainMessage(14), 0L);
        return;
      }
      label814:
      int m = 0;
      continue;
      label820:
      k = 0;
    }
  }
  
  public MessageObserver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ").append(paramToServiceMsg.getRequestSsoSeq()).append(", serviceCmd: ").append(str).append(", resultCode: ").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.roammsg", 2, localStringBuilder.toString());
    }
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"OidbSvc.0x42e_3".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[12];
      PkgTools.a(paramString, 0, l);
      PkgTools.a(paramString, 4, paramInt1);
      PkgTools.a(paramString, 6, paramInt2);
      PkgTools.a(paramString, 8, 0L);
      b(a("OidbSvc.0x42e_3", 1070, 1, paramString));
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.roammsg", 2, "send_oidb_0x42e_1 error: ", paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[12];
      PkgTools.a(paramString, 0, l);
      PkgTools.a(paramString, 4, paramInt1);
      PkgTools.a(paramString, 6, paramInt2);
      PkgTools.a(paramString, 8, paramInt3);
      PkgTools.a(paramString, 10, paramInt4);
      paramString = a("OidbSvc.0x42e_3", 1070, 3, paramString);
      paramString.extraData.putInt("EndRoamYearKey", paramInt3);
      paramString.extraData.putInt("EndRoamMonthKey", paramInt4);
      paramString.extraData.putInt("EndRoamDayKey", paramInt5);
      b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.roammsg", 2, "send_oidb_0x42e_3 error: ", paramString);
    }
  }
  
  public void a(String paramString, Calendar paramCalendar)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(86);
    paramCalendar = localMessageRoamManager.a((Calendar)paramCalendar.clone());
    long l1 = ((Long)paramCalendar.first).longValue();
    long l2 = ((Long)paramCalendar.second).longValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l1, 0L, l2, (short)0, 0L, 1, localMessageRoamManager.a(), localMessageRoamManager.b());
  }
  
  public void a(short paramShort, byte paramByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramShort, paramByte);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x42e_3");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessageRoamHandler
 * JD-Core Version:    0.7.0.1
 */