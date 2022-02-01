package com.tencent.qav.monitor;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import com.tencent.qav.log.AVLog;

public class PhoneStatusTools
{
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static final String jdField_a_of_type_JavaLangString = "PhoneStatusTools";
  private static Boolean b = Boolean.valueOf(true);
  private static Boolean c = Boolean.valueOf(true);
  private static Boolean d = Boolean.valueOf(true);
  private static Boolean e = Boolean.valueOf(true);
  private static Boolean f = Boolean.valueOf(true);
  
  static
  {
    a = Boolean.valueOf(true);
  }
  
  /* Error */
  public static void a(Context paramContext, android.telephony.PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 43
    //   3: invokevirtual 49	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 51	android/telephony/TelephonyManager
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +140 -> 151
    //   14: aload_3
    //   15: ldc 53
    //   17: iconst_2
    //   18: anewarray 55	java/lang/Class
    //   21: dup
    //   22: iconst_0
    //   23: ldc 57
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   31: aastore
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: iload_2
    //   43: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 71	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_3
    //   52: ldc 73
    //   54: iconst_3
    //   55: anewarray 55	java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 57
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   74: aastore
    //   75: iconst_3
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: iload_2
    //   93: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 71	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_3
    //   102: ldc 73
    //   104: iconst_3
    //   105: anewarray 55	java/lang/Class
    //   108: dup
    //   109: iconst_0
    //   110: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: ldc 57
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   124: aastore
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iconst_1
    //   132: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload_2
    //   143: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 71	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: ldc 75
    //   154: invokevirtual 49	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   157: checkcast 51	android/telephony/TelephonyManager
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +140 -> 302
    //   165: aload_0
    //   166: ldc 53
    //   168: iconst_2
    //   169: anewarray 55	java/lang/Class
    //   172: dup
    //   173: iconst_0
    //   174: ldc 57
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   182: aastore
    //   183: iconst_2
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_1
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: iload_2
    //   194: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 71	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_0
    //   203: ldc 73
    //   205: iconst_3
    //   206: anewarray 55	java/lang/Class
    //   209: dup
    //   210: iconst_0
    //   211: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: ldc 57
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   225: aastore
    //   226: iconst_3
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: iconst_0
    //   233: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aload_1
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: iload_2
    //   244: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: invokestatic 71	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: aload_0
    //   253: ldc 73
    //   255: iconst_3
    //   256: anewarray 55	java/lang/Class
    //   259: dup
    //   260: iconst_0
    //   261: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: ldc 57
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   275: aastore
    //   276: iconst_3
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: iconst_1
    //   283: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_1
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: iload_2
    //   294: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 71	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: ldc 77
    //   304: ldc 79
    //   306: aconst_null
    //   307: aconst_null
    //   308: invokestatic 82	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   311: ldc 53
    //   313: iconst_2
    //   314: anewarray 55	java/lang/Class
    //   317: dup
    //   318: iconst_0
    //   319: ldc 57
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: getstatic 63	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   327: aastore
    //   328: iconst_2
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload_1
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: iload_2
    //   339: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 71	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: return
    //   348: astore_0
    //   349: return
    //   350: astore_0
    //   351: return
    //   352: astore_0
    //   353: goto -51 -> 302
    //   356: astore_0
    //   357: aload_3
    //   358: astore_0
    //   359: goto -198 -> 161
    //   362: astore 4
    //   364: goto -213 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramContext	Context
    //   0	367	1	paramPhoneStateListener	android.telephony.PhoneStateListener
    //   0	367	2	paramInt	int
    //   9	349	3	localTelephonyManager	TelephonyManager
    //   362	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	10	348	java/lang/Exception
    //   302	347	350	java/lang/Exception
    //   165	302	352	java/lang/Exception
    //   151	161	356	java/lang/Exception
    //   14	151	362	java/lang/Exception
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 0);
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 1);
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 2);
  }
  
  public static boolean d(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getStreamVolume(2) == 0);
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext == null)
    {
      AVLog.w("PhoneStatusTools", "isCalling context is null.");
      return false;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    boolean bool;
    if (localTelephonyManager != null) {
      if (localTelephonyManager.getCallState() != 0) {
        bool = true;
      }
    }
    for (;;)
    {
      AVLog.d("PhoneStatusTools", String.format("isCalling isCalling=%s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      if (a.booleanValue()) {}
      try
      {
        i = ((Integer)ReflecterHelper.a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) })).intValue();
        if (i != 0) {
          bool = true;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        int i;
        a = Boolean.valueOf(false);
        if (b.booleanValue()) {}
        try
        {
          i = ((Integer)ReflecterHelper.a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) })).intValue();
          if (i != 0) {
            bool = true;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          b = Boolean.valueOf(false);
          try
          {
            paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
            if (paramContext != null) {
              if (paramContext.getCallState() != 0) {
                bool = true;
              }
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              paramContext = localTelephonyManager;
            }
            if (c.booleanValue()) {}
            try
            {
              i = ((Integer)ReflecterHelper.a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(0) })).intValue();
              if (i != 0) {
                bool = true;
              }
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
              c = Boolean.valueOf(false);
              if (d.booleanValue()) {}
              try
              {
                i = ((Integer)ReflecterHelper.a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(1) })).intValue();
                if (i != 0) {
                  bool = true;
                }
              }
              catch (NoSuchMethodException paramContext)
              {
                d = Boolean.valueOf(false);
                if (e.booleanValue()) {}
                try
                {
                  i = ((Integer)ReflecterHelper.a(ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null), "getCallState", new Object[] { Integer.valueOf(0) })).intValue();
                  if (i != 0) {
                    bool = true;
                  }
                }
                catch (NoSuchMethodException paramContext)
                {
                  e = Boolean.valueOf(false);
                  if (f.booleanValue()) {
                    try
                    {
                      i = ((Integer)ReflecterHelper.a(ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null), "getCallState", new Object[] { Integer.valueOf(1) })).intValue();
                      if (i != 0) {
                        bool = true;
                      } else {
                        bool = false;
                      }
                    }
                    catch (NoSuchMethodException paramContext)
                    {
                      f = Boolean.valueOf(false);
                      bool = false;
                    }
                    catch (Exception paramContext)
                    {
                      bool = false;
                    }
                  }
                }
                catch (Exception paramContext)
                {
                  break label371;
                }
              }
              catch (Exception paramContext)
              {
                break label313;
              }
            }
            catch (Exception localException1)
            {
              break label263;
            }
          }
        }
        catch (Exception localException2)
        {
          label263:
          break label181;
        }
      }
      catch (Exception localException3)
      {
        label120:
        break label120;
        label181:
        label313:
        label371:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.monitor.PhoneStatusTools
 * JD-Core Version:    0.7.0.1
 */