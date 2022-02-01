package com.tencent.mobileqq.app.activateFriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hqo;
import hqp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;

public class ActivateFriendsManager
  implements Manager
{
  public static final int a = -1;
  private static final long jdField_a_of_type_Long = 120000L;
  public static final String a = "pref_act_frd";
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  private static final long jdField_b_of_type_Long = 60000L;
  private static final String jdField_b_of_type_JavaLangString = "ActivateFriends.Manager";
  public static final int c = 2;
  private static final long jdField_c_of_type_Long = 1L;
  private static final String jdField_c_of_type_JavaLangString = "key_uin_sended_";
  private static final String jdField_d_of_type_JavaLangString = "key_check_stamp";
  private static final String jdField_e_of_type_JavaLangString = "key_check_interval";
  private static final String f = "-";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new hqo(this);
  Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private volatile Set jdField_b_of_type_JavaUtilSet;
  private volatile Set jdField_c_of_type_JavaUtilSet;
  private int jdField_d_of_type_Int = -2147483648;
  private long jdField_d_of_type_Long;
  private long jdField_e_of_type_Long;
  
  public ActivateFriendsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences("pref_act_frd" + paramQQAppInterface.a(), 0);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_stamp", 0L);
    this.e = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_interval", 120000L);
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      int i = localMsgBody.uint32_msg_type.get();
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "ParseMessageType catch error.", paramArrayOfByte);
      }
    }
    return 1;
  }
  
  public static String a(Context paramContext)
  {
    int[] arrayOfInt = new int[10];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131369463;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131369464;
    int[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 2131369465;
    int[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 2131369466;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 2131369467;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2131369468;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 2131369469;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 2131369470;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 2131369471;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 2131369472;
    tmp54_48;
    return paramContext.getString(arrayOfInt[new java.util.Random().nextInt(arrayOfInt.length)]);
  }
  
  public static String a(Context paramContext, SubMsgType0x76.MsgBody paramMsgBody)
  {
    String str2 = paramMsgBody.bytes_notify_wording.get().toStringUtf8();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (paramMsgBody.uint32_msg_type.get() != 1) {
        break label63;
      }
      str1 = String.format(paramContext.getString(2131369421), new Object[] { paramMsgBody.msg_geographic_notify.bytes_local_city.get().toStringUtf8() });
    }
    label63:
    do
    {
      return str1;
      str1 = str2;
    } while (paramMsgBody.uint32_msg_type.get() != 2);
    return paramContext.getString(2131369422);
  }
  
  private Set a(int paramInt)
  {
    if (paramInt == 1) {}
    Object localObject2;
    for (Object localObject1 = this.b;; localObject1 = this.c)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label181;
      }
      localObject2 = new HashSet(6);
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_uin_sended_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinSendedSet, str = " + (String)localObject1 + ", msgType = " + paramInt);
      }
      localObject1 = ((String)localObject1).split("-");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject1[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          ((Set)localObject2).add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        i += 1;
      }
    }
    if (paramInt == 1)
    {
      this.b = ((Set)localObject2);
      label181:
      return localObject2;
    }
    this.c = ((Set)localObject2);
    return localObject2;
  }
  
  String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 3);
    return paramString.substring(paramString.length() - 3, paramString.length());
  }
  
  public void a()
  {
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_sended_" + paramInt, "").commit();
    if (paramInt == 1)
    {
      this.b = new HashSet();
      return;
    }
    this.c = new HashSet();
  }
  
  public void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString)
  {
    int j = 0;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMessages | uin = ");
      if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
        break label104;
      }
      localStringBuilder.append("null");
      localStringBuilder.append(" | time = ");
      if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length != 0)) {
        break label150;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
      ThreadManager.b().post(new hqp(this, paramInt, paramArrayOfLong1, paramString, paramArrayOfLong2));
      return;
      label104:
      int k = paramArrayOfLong1.length;
      int i = 0;
      while (i < k)
      {
        localStringBuilder.append(a(String.valueOf(paramArrayOfLong1[i]))).append(",");
        i += 1;
      }
      break;
      label150:
      k = paramArrayOfLong2.length;
      i = j;
      while (i < k)
      {
        localStringBuilder.append(paramArrayOfLong2[i]).append(",");
        i += 1;
      }
    }
  }
  
  void a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 120000L) {
      l = 120000L;
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.e = l;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_check_stamp", System.currentTimeMillis()).putLong("key_check_interval", l).commit();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).d(paramBoolean1);
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366278) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean1).commit();
  }
  
  public void a(long[] paramArrayOfLong, int paramInt)
  {
    HashSet localHashSet = new HashSet(6);
    localHashSet.addAll(a(paramInt));
    int j = localHashSet.size();
    int k = paramArrayOfLong.length;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((Long)localIterator.next()).append("-");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_sended_" + paramInt, localStringBuilder.toString()).commit();
    if (paramInt == 1) {
      this.b = localHashSet;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "onSendTimingMsgSuc, send count = " + paramArrayOfLong.length + ", orginal count = " + j + ", new count = " + localHashSet.size());
      }
      return;
      this.c = localHashSet;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_d_of_type_Int == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Int = paramInt;
      return bool;
    }
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    return a(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).l();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366278) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      boolean bool = localMsgBody.bool_strong_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "shouldMsgTips | " + bool);
      }
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "IsMessageTipsInBackground catch error.", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
  }
  
  public boolean b(byte[] arg1)
  {
    int i = a(???);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i)))
        {
          bool = true;
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i));
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void onDestroy()
  {
    ThreadManager.b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager
 * JD-Core Version:    0.7.0.1
 */