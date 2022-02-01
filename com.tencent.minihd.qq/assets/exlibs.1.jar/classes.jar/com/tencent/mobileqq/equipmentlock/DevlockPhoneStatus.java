package com.tencent.mobileqq.equipmentlock;

import android.content.Context;
import android.text.format.Time;
import com.tencent.ims.devlock_mobile_phone.status;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import ihk;

public class DevlockPhoneStatus
{
  public static int a = 0;
  private static DevlockPhoneStatus jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus = null;
  public static final String a = "guard_phone_status";
  public static int b = 0;
  public static final String b = "guard_phone_effect_time";
  public static int c = 0;
  public static final String c = "emergency_phone_status";
  public static int d = 0;
  public static final String d = "emergency_phone_num";
  public static int e = 0;
  public static final String e = "emergency_phone_country_code";
  public static int f = 0;
  private static final String f = "DevlockPhoneStatus";
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  private long jdField_a_of_type_Long = 0L;
  private String g;
  private String h;
  private int k = -1;
  private int l = -1;
  
  static
  {
    jdField_a_of_type_Int = -1;
    b = 0;
    c = 1;
    d = 2;
    e = 3;
    f = -1;
    jdField_g_of_type_Int = 0;
    jdField_h_of_type_Int = 1;
    i = 2;
    j = 3;
  }
  
  private DevlockPhoneStatus()
  {
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
  }
  
  public static DevlockPhoneStatus a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus == null) {
      jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus = new DevlockPhoneStatus();
    }
    return jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockPhoneStatus", 2, "pre:" + this.k + " now:" + paramInt);
    }
    this.k = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext, String paramString)
  {
    ihk localihk = new ihk(this);
    String str2 = paramContext.getString(2131368927);
    String str1 = paramContext.getString(2131368931);
    long l1 = this.jdField_a_of_type_Long * 1000L;
    if (l1 > 0L)
    {
      localObject = new Time();
      ((Time)localObject).set(l1);
    }
    for (Object localObject = String.format(paramContext.getString(2131368929), new Object[] { Integer.valueOf(((Time)localObject).year), Integer.valueOf(((Time)localObject).month + 1), Integer.valueOf(((Time)localObject).monthDay), Integer.valueOf(((Time)localObject).hour), Integer.valueOf(((Time)localObject).minute) });; localObject = paramContext.getString(2131368930))
    {
      paramContext = DialogUtil.a(paramContext, 230, str2, String.format(paramContext.getString(2131368928), new Object[] { paramString, localObject }), null, localihk);
      if (paramContext != null)
      {
        paramContext.setNegativeButton(str1, localihk);
        paramContext.show();
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.k = jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = 0L;
    this.l = f;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockPhoneStatus", 2, "info is null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        devlock_mobile_phone.status localstatus = new devlock_mobile_phone.status();
        localstatus.mergeFrom(paramArrayOfByte);
        if (localstatus.u32_mb_mobile_state.has()) {
          this.k = localstatus.u32_mb_mobile_state.get();
        }
        if (localstatus.u32_audit_time.has()) {
          this.jdField_a_of_type_Long = localstatus.u32_audit_time.get();
        }
        if (localstatus.u32_bak_mobile_state.has()) {
          this.l = localstatus.u32_bak_mobile_state.get();
        }
        if (localstatus.str_bak_country_code.has()) {
          this.jdField_g_of_type_JavaLangString = localstatus.str_bak_country_code.get();
        }
        if (localstatus.str_bak_mobile.has())
        {
          this.jdField_h_of_type_JavaLangString = localstatus.str_bak_mobile.get();
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockPhoneStatus", 2, "exception occurs");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    return this.l;
  }
  
  public String b()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus
 * JD-Core Version:    0.7.0.1
 */