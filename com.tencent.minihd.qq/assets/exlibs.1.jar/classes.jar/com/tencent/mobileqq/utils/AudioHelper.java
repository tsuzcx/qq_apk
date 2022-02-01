package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import mqq.app.MobileQQ;

public class AudioHelper
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 2000L;
  private static final String jdField_a_of_type_JavaLangString = "!@$#_";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "appops";
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static final int c = 2;
  private static final String c = "AppOpsManager";
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  private static int g = 0;
  private static final int h = 35;
  private static final int i = 36;
  private static final int j = 26;
  private static final int k = 27;
  private static final int l = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = null;
    jdField_a_of_type_ArrayOfInt = new int[] { 35, 36 };
    b = new int[] { 26, 27 };
  }
  
  public static long a()
  {
    return 0L;
  }
  
  /* Error */
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 42	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   6: ifne +27 -> 33
    //   9: getstatic 44	com/tencent/mobileqq/utils/AudioHelper:g	I
    //   12: iconst_3
    //   13: if_icmpge +20 -> 33
    //   16: getstatic 44	com/tencent/mobileqq/utils/AudioHelper:g	I
    //   19: iconst_1
    //   20: iadd
    //   21: putstatic 44	com/tencent/mobileqq/utils/AudioHelper:g	I
    //   24: aload_0
    //   25: ldc 58
    //   27: invokestatic 64	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   30: putstatic 42	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   33: getstatic 42	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   36: ifeq +17 -> 53
    //   39: aload_1
    //   40: iload_2
    //   41: fload_3
    //   42: invokestatic 68	com/tencent/mobileqq/utils/AudioHelper:enlargeVolum	([BIF)J
    //   45: lstore 4
    //   47: ldc 2
    //   49: monitorexit
    //   50: lload 4
    //   52: lreturn
    //   53: ldc2_w 9
    //   56: lstore 4
    //   58: goto -11 -> 47
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	Context
    //   0	67	1	paramArrayOfByte	byte[]
    //   0	67	2	paramInt	int
    //   0	67	3	paramFloat	float
    //   45	12	4	l1	long
    // Exception table:
    //   from	to	target	type
    //   3	33	61	finally
    //   33	47	61	finally
  }
  
  public static AudioHelper.AudioPlayerParameter a()
  {
    if (b()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, true);
    }
    return new AudioHelper.AudioPlayerParameter(3, 0, true);
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt)
  {
    AudioHelper.AudioPlayerParameter localAudioPlayerParameter;
    if (paramInt == 0) {
      localAudioPlayerParameter = a();
    }
    for (;;)
    {
      String str = "!@$#_" + paramInt + "_";
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext());
      localAudioPlayerParameter.jdField_a_of_type_Int = localSharedPreferences.getInt(str + "m", localAudioPlayerParameter.jdField_a_of_type_Int);
      localAudioPlayerParameter.b = localSharedPreferences.getInt(str + "s", localAudioPlayerParameter.b);
      localAudioPlayerParameter.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(str + "so", localAudioPlayerParameter.jdField_a_of_type_Boolean);
      return a(paramInt, localAudioPlayerParameter);
      if (paramInt == 1)
      {
        localAudioPlayerParameter = b();
      }
      else if (paramInt == 2)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    paramAudioPlayerParameter = new AudioHelper.AudioPlayerParameter(paramAudioPlayerParameter.b, paramAudioPlayerParameter.jdField_a_of_type_Int, paramAudioPlayerParameter.jdField_a_of_type_Boolean);
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.qq_audio_play_fix.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (paramInt == 0)
        {
          if (!"-1".equals(localObject[0])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[0]);
          }
          if (!"-1".equals(localObject[1]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[1]);
            return paramAudioPlayerParameter;
          }
        }
        else if (paramInt == 1)
        {
          if (!"-1".equals(localObject[2])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
          }
          if (!"-1".equals(localObject[3]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[3]);
            return paramAudioPlayerParameter;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig error.", localException);
        }
      }
    }
    return paramAudioPlayerParameter;
  }
  
  public static void a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    String str = "!@$#_" + paramInt + "_";
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit().putInt(str + "m", paramAudioPlayerParameter.jdField_a_of_type_Int).putInt(str + "s", paramAudioPlayerParameter.b).putBoolean(str + "so", paramAudioPlayerParameter.jdField_a_of_type_Boolean).commit();
  }
  
  public static boolean a()
  {
    return (o()) || (n());
  }
  
  public static boolean a(int paramInt)
  {
    if ((!r()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      Object localObject = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject != null) && (localObject.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = localObject.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int m = b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            m = jdField_a_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(m), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, localException.toString());
    return false;
  }
  
  public static boolean a(BluetoothDevice paramBluetoothDevice)
  {
    Object localObject = paramBluetoothDevice.getUuids();
    if (localObject == null) {}
    for (;;)
    {
      return false;
      paramBluetoothDevice = new ParcelUuid[2];
      paramBluetoothDevice[0] = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
      paramBluetoothDevice[1] = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
      localObject = new HashSet(Arrays.asList((Object[])localObject));
      int n = paramBluetoothDevice.length;
      int m = 0;
      while (m < n)
      {
        if (((HashSet)localObject).contains(paramBluetoothDevice[m])) {
          return true;
        }
        m += 1;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
  }
  
  public static AudioHelper.AudioPlayerParameter[] a()
  {
    try
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null)
      {
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = new AudioHelper.AudioPlayerParameter[4];
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[0] = a(0);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[1] = a(1);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2] = a(2);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3] = a(3);
      }
      AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
      return arrayOfAudioPlayerParameter;
    }
    finally {}
  }
  
  @TargetApi(11)
  public static AudioHelper.AudioPlayerParameter b()
  {
    if (l()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (c()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (d()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (e()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (f()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (h()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (g()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (i()) {
      return new AudioHelper.AudioPlayerParameter(0, 2, false);
    }
    if (j()) {
      return new AudioHelper.AudioPlayerParameter(0, 2, false);
    }
    if (k()) {
      return new AudioHelper.AudioPlayerParameter(3, 3, false);
    }
    if (m()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new AudioHelper.AudioPlayerParameter(0, 3, false);
    }
    return new AudioHelper.AudioPlayerParameter(0, 2, false);
  }
  
  private static boolean b()
  {
    String str = Build.MODEL;
    int m;
    if (((Build.MANUFACTURER.equalsIgnoreCase("Samsung")) || (str.contains("MI 2")) || (str.contains("Nexus 4"))) && (Build.VERSION.SDK_INT >= 11))
    {
      m = 1;
      if (m == 0) {
        break label57;
      }
    }
    label57:
    while ((str.contains("SCH-I699")) && (Build.VERSION.SDK_INT == 10))
    {
      return true;
      m = 0;
      break;
    }
    return false;
  }
  
  public static boolean b(int paramInt)
  {
    if ((!p()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      Object localObject = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject != null) && (localObject.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = localObject.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int m = b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            m = jdField_a_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(m), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, localException.toString());
    return false;
  }
  
  private static boolean c()
  {
    return (Build.MODEL.contains("HUAWEI Y 200T")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean d()
  {
    return (Build.MODEL.contains("Lenovo A278t")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean e()
  {
    return (Build.MODEL.contains("ZTE-T U960s")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  @Deprecated
  public static native long enlargeVolum(byte[] paramArrayOfByte, int paramInt, float paramFloat);
  
  private static boolean f()
  {
    return Build.MODEL.contains("5910");
  }
  
  private static boolean g()
  {
    return Build.MODEL.contains("Lenovo K900");
  }
  
  private static boolean h()
  {
    return Build.MODEL.contains("V926");
  }
  
  private static boolean i()
  {
    return Build.MODEL.contains("ZTE N881E");
  }
  
  private static boolean j()
  {
    return Build.MODEL.contains("LNV-Lenovo S870e");
  }
  
  private static boolean k()
  {
    return Build.MODEL.contains("Coolpad 5891Q");
  }
  
  private static boolean l()
  {
    return (Build.MODEL.contains("ME860")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean m()
  {
    return Build.MODEL.contains("GT-S7500");
  }
  
  private static boolean n()
  {
    return Build.MODEL.contains("Lenovo A750");
  }
  
  private static boolean o()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (str.contains("X907"));
  }
  
  private static boolean p()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean q()
  {
    String str = Build.MODEL;
    return (str != null) && (str.contains("PAD"));
  }
  
  private static boolean r()
  {
    return ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && (!q());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */