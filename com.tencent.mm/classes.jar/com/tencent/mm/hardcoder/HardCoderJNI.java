package com.tencent.mm.hardcoder;

import android.content.Context;
import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;

public class HardCoderJNI
{
  public static final int CPU_LEVEL_0 = 0;
  public static final int CPU_LEVEL_1 = 1;
  public static final int CPU_LEVEL_2 = 2;
  public static final int CPU_LEVEL_3 = 3;
  public static final int ERROR_CODE_CHECKENV_FAIL = -2;
  public static final int ERROR_CODE_FAILED = -1;
  public static final int ERROR_CODE_HCPERFMANAGER_NULL = -5;
  public static final int ERROR_CODE_NOT_ENABLE = -3;
  public static final int ERROR_CODE_NOT_FOREGROUND = -4;
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final int FUNC_BASE = 1000;
  public static final int FUNC_CANCEL_CPU_CORE_FOR_THREAD = 1005;
  public static final int FUNC_CANCEL_CPU_HIGH_FREQ = 1003;
  public static final int FUNC_CANCEL_HIGH_IO_FREQ = 1007;
  public static final int FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE = 1014;
  public static final int FUNC_CHECK_PERMISSION = 1001;
  public static final int FUNC_CPU_CORE_FOR_THREAD = 1004;
  public static final int FUNC_CPU_HIGH_FREQ = 1002;
  public static final int FUNC_HIGH_IO_FREQ = 1006;
  public static final int FUNC_REG_ANR_CALLBACK = 1010;
  public static final int FUNC_REG_PRELOAD_BOOT_RESOURCE = 1011;
  public static final int FUNC_RESET_SCREEN_RESOLUTION = 1009;
  public static final int FUNC_SET_SCREEN_RESOLUTION = 1008;
  public static final int FUNC_TERMINATE_APP = 1012;
  public static final int FUNC_UNIFY_CPU_IO_THREAD_CORE = 1013;
  public static final int IO_LEVEL_0 = 0;
  public static final int IO_LEVEL_1 = 1;
  public static final int IO_LEVEL_2 = 2;
  public static final int IO_LEVEL_3 = 3;
  private static final String TAG = "HardCoder.JNI";
  public static int TICK_RATE = 100;
  private static Callback callback;
  public static boolean checkEnv = false;
  public static final String clientSock = ".hardcoder.client.sock";
  public static boolean hcDebug = false;
  public static boolean hcEnable = true;
  private static a hcPerfManager;
  public static final boolean sHCDEBUG = false;
  public static final boolean sHCENABLE = true;
  public static SceneReportCallback sceneReportCallback;
  public static final String serverPropKey = "persist.sys.hardcoder.name";
  
  static
  {
    System.loadLibrary("hardcoder");
  }
  
  public static native int cancelCpuCoreForThread(int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native int cancelCpuHighFreq(int paramInt, long paramLong);
  
  public static native int cancelHighIOFreq(int paramInt, long paramLong);
  
  public static native int cancelUnifyCpuIOThreadCore(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native int checkPermission(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  /* Error */
  public static long getCpuFreqByCoreId(int paramInt)
  {
    // Byte code:
    //   0: new 127	java/io/File
    //   3: dup
    //   4: new 129	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 131
    //   10: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_0
    //   14: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17: ldc 139
    //   19: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 151	java/io/File:exists	()Z
    //   33: ifne +7 -> 40
    //   36: ldc2_w 152
    //   39: lreturn
    //   40: new 155	java/io/FileReader
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 158	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   48: astore 4
    //   50: new 160	java/io/BufferedReader
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_3
    //   60: aload_3
    //   61: astore 6
    //   63: aload 4
    //   65: astore 5
    //   67: aload_3
    //   68: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: lconst_0
    //   72: invokestatic 170	com/tencent/mm/hardcoder/HardCoderJNI:getLong	(Ljava/lang/String;J)J
    //   75: lstore_1
    //   76: aload_3
    //   77: invokevirtual 173	java/io/BufferedReader:close	()V
    //   80: aload 4
    //   82: invokevirtual 174	java/io/FileReader:close	()V
    //   85: lload_1
    //   86: lreturn
    //   87: astore_3
    //   88: ldc 71
    //   90: new 129	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 176
    //   96: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_3
    //   100: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: lload_1
    //   113: lreturn
    //   114: astore_3
    //   115: ldc 71
    //   117: new 129	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 187
    //   123: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: aload_3
    //   127: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: goto -59 -> 80
    //   142: astore 7
    //   144: aconst_null
    //   145: astore_3
    //   146: aconst_null
    //   147: astore 4
    //   149: aload_3
    //   150: astore 6
    //   152: aload 4
    //   154: astore 5
    //   156: ldc 71
    //   158: new 129	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 189
    //   164: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload 7
    //   169: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_3
    //   182: ifnull +7 -> 189
    //   185: aload_3
    //   186: invokevirtual 173	java/io/BufferedReader:close	()V
    //   189: aload 4
    //   191: ifnull +185 -> 376
    //   194: aload 4
    //   196: invokevirtual 174	java/io/FileReader:close	()V
    //   199: ldc2_w 152
    //   202: lreturn
    //   203: astore_3
    //   204: ldc 71
    //   206: new 129	java/lang/StringBuilder
    //   209: dup
    //   210: ldc 176
    //   212: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload_3
    //   216: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: ldc2_w 152
    //   231: lreturn
    //   232: astore_3
    //   233: ldc 71
    //   235: new 129	java/lang/StringBuilder
    //   238: dup
    //   239: ldc 187
    //   241: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload_3
    //   245: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   248: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto -68 -> 189
    //   260: astore_3
    //   261: aconst_null
    //   262: astore 6
    //   264: aconst_null
    //   265: astore 4
    //   267: aload 6
    //   269: ifnull +8 -> 277
    //   272: aload 6
    //   274: invokevirtual 173	java/io/BufferedReader:close	()V
    //   277: aload 4
    //   279: ifnull +8 -> 287
    //   282: aload 4
    //   284: invokevirtual 174	java/io/FileReader:close	()V
    //   287: aload_3
    //   288: athrow
    //   289: astore 5
    //   291: ldc 71
    //   293: new 129	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 187
    //   299: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload 5
    //   304: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: goto -39 -> 277
    //   319: astore 4
    //   321: ldc 71
    //   323: new 129	java/lang/StringBuilder
    //   326: dup
    //   327: ldc 176
    //   329: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   332: aload 4
    //   334: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: goto -59 -> 287
    //   349: astore_3
    //   350: aconst_null
    //   351: astore 6
    //   353: goto -86 -> 267
    //   356: astore_3
    //   357: aload 5
    //   359: astore 4
    //   361: goto -94 -> 267
    //   364: astore 7
    //   366: aconst_null
    //   367: astore_3
    //   368: goto -219 -> 149
    //   371: astore 7
    //   373: goto -224 -> 149
    //   376: ldc2_w 152
    //   379: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramInt	int
    //   75	38	1	l	long
    //   28	49	3	localObject1	Object
    //   87	13	3	localException1	java.lang.Exception
    //   114	13	3	localException2	java.lang.Exception
    //   145	41	3	localObject2	Object
    //   203	13	3	localException3	java.lang.Exception
    //   232	13	3	localException4	java.lang.Exception
    //   260	28	3	localObject3	Object
    //   349	1	3	localObject4	Object
    //   356	1	3	localObject5	Object
    //   367	1	3	localObject6	Object
    //   48	235	4	localFileReader1	java.io.FileReader
    //   319	14	4	localException5	java.lang.Exception
    //   359	1	4	localObject7	Object
    //   65	90	5	localFileReader2	java.io.FileReader
    //   289	69	5	localException6	java.lang.Exception
    //   61	291	6	localObject8	Object
    //   142	26	7	localException7	java.lang.Exception
    //   364	1	7	localException8	java.lang.Exception
    //   371	1	7	localException9	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/lang/Exception
    //   76	80	114	java/lang/Exception
    //   0	36	142	java/lang/Exception
    //   40	50	142	java/lang/Exception
    //   194	199	203	java/lang/Exception
    //   185	189	232	java/lang/Exception
    //   0	36	260	finally
    //   40	50	260	finally
    //   272	277	289	java/lang/Exception
    //   282	287	319	java/lang/Exception
    //   50	60	349	finally
    //   67	76	356	finally
    //   156	181	356	finally
    //   50	60	364	java/lang/Exception
    //   67	76	371	java/lang/Exception
  }
  
  /* Error */
  public static long[] getCurrCpuFreq()
  {
    // Byte code:
    //   0: new 193	java/util/Vector
    //   3: dup
    //   4: invokespecial 194	java/util/Vector:<init>	()V
    //   7: astore 7
    //   9: iconst_0
    //   10: istore_0
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore_2
    //   15: iload_0
    //   16: bipush 32
    //   18: if_icmpge +95 -> 113
    //   21: new 127	java/io/File
    //   24: dup
    //   25: new 129	java/lang/StringBuilder
    //   28: dup
    //   29: ldc 131
    //   31: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: iload_0
    //   35: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc 139
    //   40: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_3
    //   50: aload_3
    //   51: invokevirtual 151	java/io/File:exists	()Z
    //   54: ifeq +59 -> 113
    //   57: new 155	java/io/FileReader
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 158	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   65: astore_3
    //   66: new 160	java/io/BufferedReader
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   74: astore 6
    //   76: aload 6
    //   78: astore 5
    //   80: aload_3
    //   81: astore 4
    //   83: aload 7
    //   85: aload 6
    //   87: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   90: lconst_0
    //   91: invokestatic 170	com/tencent/mm/hardcoder/HardCoderJNI:getLong	(Ljava/lang/String;J)J
    //   94: invokestatic 200	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: invokevirtual 204	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: iload_0
    //   102: iconst_1
    //   103: iadd
    //   104: istore_0
    //   105: aload 6
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: goto -95 -> 15
    //   113: aload 7
    //   115: invokevirtual 208	java/util/Vector:size	()I
    //   118: istore_0
    //   119: iload_0
    //   120: ifgt +77 -> 197
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 173	java/io/BufferedReader:close	()V
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 174	java/io/FileReader:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_1
    //   142: ldc 71
    //   144: new 129	java/lang/StringBuilder
    //   147: dup
    //   148: ldc 210
    //   150: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: aload_1
    //   154: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -35 -> 131
    //   169: astore_1
    //   170: ldc 71
    //   172: new 129	java/lang/StringBuilder
    //   175: dup
    //   176: ldc 212
    //   178: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: aload_1
    //   182: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   185: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: goto -55 -> 139
    //   197: aload 7
    //   199: invokevirtual 208	java/util/Vector:size	()I
    //   202: newarray long
    //   204: astore_3
    //   205: iconst_0
    //   206: istore_0
    //   207: iload_0
    //   208: aload 7
    //   210: invokevirtual 208	java/util/Vector:size	()I
    //   213: if_icmpge +25 -> 238
    //   216: aload_3
    //   217: iload_0
    //   218: aload 7
    //   220: iload_0
    //   221: invokevirtual 216	java/util/Vector:get	(I)Ljava/lang/Object;
    //   224: checkcast 196	java/lang/Long
    //   227: invokevirtual 220	java/lang/Long:longValue	()J
    //   230: lastore
    //   231: iload_0
    //   232: iconst_1
    //   233: iadd
    //   234: istore_0
    //   235: goto -28 -> 207
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 173	java/io/BufferedReader:close	()V
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 174	java/io/FileReader:close	()V
    //   254: aload_3
    //   255: areturn
    //   256: astore_1
    //   257: ldc 71
    //   259: new 129	java/lang/StringBuilder
    //   262: dup
    //   263: ldc 210
    //   265: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   268: aload_1
    //   269: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: goto -35 -> 246
    //   284: astore_1
    //   285: ldc 71
    //   287: new 129	java/lang/StringBuilder
    //   290: dup
    //   291: ldc 212
    //   293: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   296: aload_1
    //   297: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   300: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: goto -55 -> 254
    //   312: astore_2
    //   313: aconst_null
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_3
    //   317: aload_1
    //   318: astore 5
    //   320: aload_3
    //   321: astore 4
    //   323: ldc 71
    //   325: new 129	java/lang/StringBuilder
    //   328: dup
    //   329: ldc 222
    //   331: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload_2
    //   335: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_1
    //   348: ifnull +7 -> 355
    //   351: aload_1
    //   352: invokevirtual 173	java/io/BufferedReader:close	()V
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 174	java/io/FileReader:close	()V
    //   363: aconst_null
    //   364: areturn
    //   365: astore_1
    //   366: ldc 71
    //   368: new 129	java/lang/StringBuilder
    //   371: dup
    //   372: ldc 210
    //   374: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   377: aload_1
    //   378: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: goto -35 -> 355
    //   393: astore_1
    //   394: ldc 71
    //   396: new 129	java/lang/StringBuilder
    //   399: dup
    //   400: ldc 212
    //   402: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   405: aload_1
    //   406: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: goto -55 -> 363
    //   421: astore_3
    //   422: aconst_null
    //   423: astore_1
    //   424: aconst_null
    //   425: astore_2
    //   426: aload_1
    //   427: ifnull +7 -> 434
    //   430: aload_1
    //   431: invokevirtual 173	java/io/BufferedReader:close	()V
    //   434: aload_2
    //   435: ifnull +7 -> 442
    //   438: aload_2
    //   439: invokevirtual 174	java/io/FileReader:close	()V
    //   442: aload_3
    //   443: athrow
    //   444: astore_1
    //   445: ldc 71
    //   447: new 129	java/lang/StringBuilder
    //   450: dup
    //   451: ldc 210
    //   453: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   456: aload_1
    //   457: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   460: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto -35 -> 434
    //   472: astore_1
    //   473: ldc 71
    //   475: new 129	java/lang/StringBuilder
    //   478: dup
    //   479: ldc 212
    //   481: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   484: aload_1
    //   485: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   488: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -55 -> 442
    //   500: astore_3
    //   501: aload 5
    //   503: astore_1
    //   504: aload 4
    //   506: astore_2
    //   507: goto -81 -> 426
    //   510: astore_3
    //   511: goto -85 -> 426
    //   514: astore 4
    //   516: aload_3
    //   517: astore_2
    //   518: aload 4
    //   520: astore_3
    //   521: goto -95 -> 426
    //   524: astore_2
    //   525: aload 6
    //   527: astore_1
    //   528: goto -211 -> 317
    //   531: astore 4
    //   533: aload_2
    //   534: astore_3
    //   535: aload 4
    //   537: astore_2
    //   538: goto -221 -> 317
    //   541: astore_2
    //   542: goto -225 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	225	0	i	int
    //   12	116	1	localObject1	Object
    //   141	13	1	localException1	java.lang.Exception
    //   169	74	1	localException2	java.lang.Exception
    //   256	13	1	localException3	java.lang.Exception
    //   284	13	1	localException4	java.lang.Exception
    //   314	38	1	localObject2	Object
    //   365	13	1	localException5	java.lang.Exception
    //   393	13	1	localException6	java.lang.Exception
    //   423	8	1	localObject3	Object
    //   444	13	1	localException7	java.lang.Exception
    //   472	13	1	localException8	java.lang.Exception
    //   503	25	1	localObject4	Object
    //   14	237	2	localObject5	Object
    //   312	23	2	localException9	java.lang.Exception
    //   425	93	2	localObject6	Object
    //   524	10	2	localException10	java.lang.Exception
    //   537	1	2	localObject7	Object
    //   541	1	2	localException11	java.lang.Exception
    //   49	311	3	localObject8	Object
    //   421	22	3	localObject9	Object
    //   500	1	3	localObject10	Object
    //   510	7	3	localObject11	Object
    //   520	15	3	localObject12	Object
    //   81	424	4	localObject13	Object
    //   514	5	4	localObject14	Object
    //   531	5	4	localException12	java.lang.Exception
    //   78	424	5	localObject15	Object
    //   74	452	6	localBufferedReader	BufferedReader
    //   7	212	7	localVector	java.util.Vector
    // Exception table:
    //   from	to	target	type
    //   127	131	141	java/lang/Exception
    //   135	139	169	java/lang/Exception
    //   242	246	256	java/lang/Exception
    //   250	254	284	java/lang/Exception
    //   0	9	312	java/lang/Exception
    //   351	355	365	java/lang/Exception
    //   359	363	393	java/lang/Exception
    //   0	9	421	finally
    //   430	434	444	java/lang/Exception
    //   438	442	472	java/lang/Exception
    //   83	101	500	finally
    //   323	347	500	finally
    //   21	66	510	finally
    //   113	119	510	finally
    //   197	205	510	finally
    //   207	231	510	finally
    //   66	76	514	finally
    //   83	101	524	java/lang/Exception
    //   21	66	531	java/lang/Exception
    //   113	119	531	java/lang/Exception
    //   197	205	531	java/lang/Exception
    //   207	231	531	java/lang/Exception
    //   66	76	541	java/lang/Exception
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramInt;
        }
        int i = Integer.decode(paramString).intValue();
        return i;
      }
      catch (NumberFormatException paramString)
      {
        c.printErrStackTrace("HardCoder.JNI", paramString, "", new Object[0]);
      }
    }
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramLong;
        }
        long l = Long.decode(paramString).longValue();
        return l;
      }
      catch (NumberFormatException paramString)
      {
        c.printErrStackTrace("HardCoder.JNI", paramString, "", new Object[0]);
      }
    }
    return paramLong;
  }
  
  /* Error */
  public static long[] getMyProcCpuTime()
  {
    // Byte code:
    //   0: new 155	java/io/FileReader
    //   3: dup
    //   4: new 129	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 252
    //   10: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: invokestatic 257	android/os/Process:myPid	()I
    //   16: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 259
    //   22: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 260	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: new 160	java/io/BufferedReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload_0
    //   46: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: ldc_w 262
    //   52: invokevirtual 266	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore 5
    //   57: aload_0
    //   58: astore_3
    //   59: aload_1
    //   60: astore_2
    //   61: iconst_2
    //   62: newarray long
    //   64: astore 4
    //   66: aload_0
    //   67: astore_3
    //   68: aload_1
    //   69: astore_2
    //   70: aload 4
    //   72: iconst_0
    //   73: aload 5
    //   75: bipush 13
    //   77: aaload
    //   78: invokestatic 270	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lastore
    //   82: aload_0
    //   83: astore_3
    //   84: aload_1
    //   85: astore_2
    //   86: aload 4
    //   88: iconst_1
    //   89: aload 5
    //   91: bipush 14
    //   93: aaload
    //   94: invokestatic 270	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   97: lastore
    //   98: aload_1
    //   99: invokevirtual 174	java/io/FileReader:close	()V
    //   102: aload_0
    //   103: invokevirtual 173	java/io/BufferedReader:close	()V
    //   106: aload 4
    //   108: areturn
    //   109: astore_1
    //   110: ldc 71
    //   112: new 129	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 272
    //   119: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -33 -> 102
    //   138: astore_0
    //   139: ldc 71
    //   141: new 129	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 274
    //   148: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 4
    //   166: areturn
    //   167: astore 4
    //   169: aconst_null
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_0
    //   174: astore_3
    //   175: aload_1
    //   176: astore_2
    //   177: ldc 71
    //   179: new 129	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 276
    //   186: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload 4
    //   191: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   194: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 174	java/io/FileReader:close	()V
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 173	java/io/BufferedReader:close	()V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_1
    //   222: ldc 71
    //   224: new 129	java/lang/StringBuilder
    //   227: dup
    //   228: ldc_w 272
    //   231: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   234: aload_1
    //   235: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   238: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: goto -36 -> 211
    //   250: astore_0
    //   251: ldc 71
    //   253: new 129	java/lang/StringBuilder
    //   256: dup
    //   257: ldc_w 274
    //   260: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   263: aload_0
    //   264: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   267: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: goto -57 -> 219
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_3
    //   282: aconst_null
    //   283: astore_1
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 174	java/io/FileReader:close	()V
    //   292: aload_3
    //   293: ifnull +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 173	java/io/BufferedReader:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: astore_1
    //   303: ldc 71
    //   305: new 129	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 272
    //   312: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload_1
    //   316: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: goto -36 -> 292
    //   331: astore_1
    //   332: ldc 71
    //   334: new 129	java/lang/StringBuilder
    //   337: dup
    //   338: ldc_w 274
    //   341: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   344: aload_1
    //   345: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   348: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: goto -57 -> 300
    //   360: astore_0
    //   361: aconst_null
    //   362: astore_3
    //   363: goto -79 -> 284
    //   366: astore_0
    //   367: aload_2
    //   368: astore_1
    //   369: goto -85 -> 284
    //   372: astore 4
    //   374: aconst_null
    //   375: astore_0
    //   376: goto -203 -> 173
    //   379: astore 4
    //   381: goto -208 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	63	0	localBufferedReader	BufferedReader
    //   138	14	0	localException1	java.lang.Exception
    //   170	46	0	localObject1	Object
    //   250	14	0	localException2	java.lang.Exception
    //   279	22	0	localObject2	Object
    //   360	1	0	localObject3	Object
    //   366	1	0	localObject4	Object
    //   375	1	0	localObject5	Object
    //   31	68	1	localFileReader	java.io.FileReader
    //   109	14	1	localException3	java.lang.Exception
    //   172	36	1	localObject6	Object
    //   221	14	1	localException4	java.lang.Exception
    //   283	6	1	localObject7	Object
    //   302	14	1	localException5	java.lang.Exception
    //   331	14	1	localException6	java.lang.Exception
    //   368	1	1	localObject8	Object
    //   44	324	2	localObject9	Object
    //   42	321	3	localObject10	Object
    //   64	101	4	arrayOfLong	long[]
    //   167	23	4	localException7	java.lang.Exception
    //   372	1	4	localException8	java.lang.Exception
    //   379	1	4	localException9	java.lang.Exception
    //   55	35	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   98	102	109	java/lang/Exception
    //   102	106	138	java/lang/Exception
    //   0	32	167	java/lang/Exception
    //   207	211	221	java/lang/Exception
    //   215	219	250	java/lang/Exception
    //   0	32	279	finally
    //   288	292	302	java/lang/Exception
    //   296	300	331	java/lang/Exception
    //   32	41	360	finally
    //   45	57	366	finally
    //   61	66	366	finally
    //   70	82	366	finally
    //   86	98	366	finally
    //   177	203	366	finally
    //   32	41	372	java/lang/Exception
    //   45	57	379	java/lang/Exception
    //   61	66	379	java/lang/Exception
    //   70	82	379	java/lang/Exception
    //   86	98	379	java/lang/Exception
  }
  
  /* Error */
  public static int getThreadCoreId(int paramInt)
  {
    // Byte code:
    //   0: new 155	java/io/FileReader
    //   3: dup
    //   4: new 129	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 252
    //   10: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: invokestatic 257	android/os/Process:myPid	()I
    //   16: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 280
    //   22: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_0
    //   26: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 259
    //   32: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 260	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   41: astore_2
    //   42: new 160	java/io/BufferedReader
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: aload_1
    //   57: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnonnull +70 -> 134
    //   67: aload_2
    //   68: invokevirtual 174	java/io/FileReader:close	()V
    //   71: aload_1
    //   72: invokevirtual 173	java/io/BufferedReader:close	()V
    //   75: iconst_m1
    //   76: ireturn
    //   77: astore_2
    //   78: ldc 71
    //   80: new 129	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 282
    //   87: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_2
    //   91: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   94: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: goto -32 -> 71
    //   106: astore_1
    //   107: ldc 71
    //   109: new 129	java/lang/StringBuilder
    //   112: dup
    //   113: ldc_w 284
    //   116: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: iconst_m1
    //   133: ireturn
    //   134: aload_1
    //   135: astore 4
    //   137: aload_2
    //   138: astore_3
    //   139: aload 5
    //   141: ldc_w 262
    //   144: invokevirtual 266	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   147: bipush 38
    //   149: aaload
    //   150: iconst_0
    //   151: invokestatic 286	com/tencent/mm/hardcoder/HardCoderJNI:getInt	(Ljava/lang/String;I)I
    //   154: istore_0
    //   155: aload_2
    //   156: invokevirtual 174	java/io/FileReader:close	()V
    //   159: aload_1
    //   160: invokevirtual 173	java/io/BufferedReader:close	()V
    //   163: iload_0
    //   164: ireturn
    //   165: astore_1
    //   166: ldc 71
    //   168: new 129	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 284
    //   175: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload_1
    //   179: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: iload_0
    //   192: ireturn
    //   193: astore_2
    //   194: ldc 71
    //   196: new 129	java/lang/StringBuilder
    //   199: dup
    //   200: ldc_w 282
    //   203: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: aload_2
    //   207: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   210: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -60 -> 159
    //   222: astore 5
    //   224: aconst_null
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_2
    //   228: aload_1
    //   229: astore 4
    //   231: aload_2
    //   232: astore_3
    //   233: ldc 71
    //   235: new 129	java/lang/StringBuilder
    //   238: dup
    //   239: ldc_w 288
    //   242: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: aload 5
    //   247: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 174	java/io/FileReader:close	()V
    //   267: aload_1
    //   268: ifnull -193 -> 75
    //   271: aload_1
    //   272: invokevirtual 173	java/io/BufferedReader:close	()V
    //   275: iconst_m1
    //   276: ireturn
    //   277: astore_1
    //   278: ldc 71
    //   280: new 129	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 284
    //   287: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload_1
    //   291: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: iconst_m1
    //   304: ireturn
    //   305: astore_2
    //   306: ldc 71
    //   308: new 129	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 282
    //   315: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload_2
    //   319: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: goto -64 -> 267
    //   334: astore_1
    //   335: aconst_null
    //   336: astore 4
    //   338: aconst_null
    //   339: astore_2
    //   340: aload_2
    //   341: ifnull +7 -> 348
    //   344: aload_2
    //   345: invokevirtual 174	java/io/FileReader:close	()V
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 173	java/io/BufferedReader:close	()V
    //   358: aload_1
    //   359: athrow
    //   360: astore_2
    //   361: ldc 71
    //   363: new 129	java/lang/StringBuilder
    //   366: dup
    //   367: ldc_w 282
    //   370: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   373: aload_2
    //   374: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   377: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: goto -38 -> 348
    //   389: astore_2
    //   390: ldc 71
    //   392: new 129	java/lang/StringBuilder
    //   395: dup
    //   396: ldc_w 284
    //   399: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   402: aload_2
    //   403: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   406: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: goto -57 -> 358
    //   418: astore_1
    //   419: aconst_null
    //   420: astore 4
    //   422: goto -82 -> 340
    //   425: astore_1
    //   426: aload_3
    //   427: astore_2
    //   428: goto -88 -> 340
    //   431: astore 5
    //   433: aconst_null
    //   434: astore_1
    //   435: goto -207 -> 228
    //   438: astore 5
    //   440: goto -212 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	paramInt	int
    //   50	22	1	localBufferedReader	BufferedReader
    //   106	54	1	localException1	java.lang.Exception
    //   165	14	1	localException2	java.lang.Exception
    //   225	47	1	localObject1	Object
    //   277	14	1	localException3	java.lang.Exception
    //   334	25	1	localObject2	Object
    //   418	1	1	localObject3	Object
    //   425	1	1	localObject4	Object
    //   434	1	1	localObject5	Object
    //   41	27	2	localFileReader	java.io.FileReader
    //   77	79	2	localException4	java.lang.Exception
    //   193	14	2	localException5	java.lang.Exception
    //   227	37	2	localObject6	Object
    //   305	14	2	localException6	java.lang.Exception
    //   339	6	2	localObject7	Object
    //   360	14	2	localException7	java.lang.Exception
    //   389	14	2	localException8	java.lang.Exception
    //   427	1	2	localObject8	Object
    //   55	372	3	localObject9	Object
    //   52	369	4	localObject10	Object
    //   60	80	5	str	String
    //   222	24	5	localException9	java.lang.Exception
    //   431	1	5	localException10	java.lang.Exception
    //   438	1	5	localException11	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   67	71	77	java/lang/Exception
    //   71	75	106	java/lang/Exception
    //   159	163	165	java/lang/Exception
    //   155	159	193	java/lang/Exception
    //   0	42	222	java/lang/Exception
    //   271	275	277	java/lang/Exception
    //   263	267	305	java/lang/Exception
    //   0	42	334	finally
    //   344	348	360	java/lang/Exception
    //   353	358	389	java/lang/Exception
    //   42	51	418	finally
    //   56	62	425	finally
    //   139	155	425	finally
    //   233	259	425	finally
    //   42	51	431	java/lang/Exception
    //   56	62	438	java/lang/Exception
    //   139	155	438	java/lang/Exception
  }
  
  /* Error */
  public static long[] getThreadCpuJiffies(int paramInt)
  {
    // Byte code:
    //   0: new 155	java/io/FileReader
    //   3: dup
    //   4: new 129	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 252
    //   10: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: invokestatic 257	android/os/Process:myPid	()I
    //   16: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 280
    //   22: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_0
    //   26: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 259
    //   32: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 260	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   41: astore 6
    //   43: new 160	java/io/BufferedReader
    //   46: dup
    //   47: aload 6
    //   49: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore 5
    //   54: aload 5
    //   56: astore 8
    //   58: aload 6
    //   60: astore 7
    //   62: aload 5
    //   64: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore 9
    //   69: aload 9
    //   71: ifnonnull +76 -> 147
    //   74: aload 6
    //   76: invokevirtual 174	java/io/FileReader:close	()V
    //   79: aload 5
    //   81: invokevirtual 173	java/io/BufferedReader:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore 6
    //   88: ldc 71
    //   90: new 129	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 292
    //   97: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload 6
    //   102: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: goto -35 -> 79
    //   117: astore 5
    //   119: ldc 71
    //   121: new 129	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 294
    //   128: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload 5
    //   133: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 5
    //   149: astore 8
    //   151: aload 6
    //   153: astore 7
    //   155: aload 9
    //   157: ldc_w 262
    //   160: invokevirtual 266	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   163: astore 9
    //   165: aload 5
    //   167: astore 8
    //   169: aload 6
    //   171: astore 7
    //   173: aload 9
    //   175: bipush 13
    //   177: aaload
    //   178: lconst_0
    //   179: invokestatic 170	com/tencent/mm/hardcoder/HardCoderJNI:getLong	(Ljava/lang/String;J)J
    //   182: lstore_1
    //   183: aload 5
    //   185: astore 8
    //   187: aload 6
    //   189: astore 7
    //   191: aload 9
    //   193: bipush 14
    //   195: aaload
    //   196: lconst_0
    //   197: invokestatic 170	com/tencent/mm/hardcoder/HardCoderJNI:getLong	(Ljava/lang/String;J)J
    //   200: lstore_3
    //   201: aload 6
    //   203: invokevirtual 174	java/io/FileReader:close	()V
    //   206: aload 5
    //   208: invokevirtual 173	java/io/BufferedReader:close	()V
    //   211: iconst_2
    //   212: newarray long
    //   214: dup
    //   215: iconst_0
    //   216: lload_1
    //   217: lastore
    //   218: dup
    //   219: iconst_1
    //   220: lload_3
    //   221: lastore
    //   222: areturn
    //   223: astore 6
    //   225: ldc 71
    //   227: new 129	java/lang/StringBuilder
    //   230: dup
    //   231: ldc_w 292
    //   234: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: aload 6
    //   239: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -45 -> 206
    //   254: astore 5
    //   256: ldc 71
    //   258: new 129	java/lang/StringBuilder
    //   261: dup
    //   262: ldc_w 294
    //   265: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   268: aload 5
    //   270: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   273: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: goto -71 -> 211
    //   285: astore 9
    //   287: aconst_null
    //   288: astore 5
    //   290: aconst_null
    //   291: astore 6
    //   293: aload 5
    //   295: astore 8
    //   297: aload 6
    //   299: astore 7
    //   301: ldc 71
    //   303: new 129	java/lang/StringBuilder
    //   306: dup
    //   307: ldc_w 296
    //   310: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   313: aload 9
    //   315: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload 6
    //   329: ifnull +8 -> 337
    //   332: aload 6
    //   334: invokevirtual 174	java/io/FileReader:close	()V
    //   337: aload 5
    //   339: ifnull -255 -> 84
    //   342: aload 5
    //   344: invokevirtual 173	java/io/BufferedReader:close	()V
    //   347: aconst_null
    //   348: areturn
    //   349: astore 5
    //   351: ldc 71
    //   353: new 129	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 294
    //   360: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload 5
    //   365: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   368: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aconst_null
    //   378: areturn
    //   379: astore 6
    //   381: ldc 71
    //   383: new 129	java/lang/StringBuilder
    //   386: dup
    //   387: ldc_w 292
    //   390: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   393: aload 6
    //   395: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   398: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: goto -70 -> 337
    //   410: astore 5
    //   412: aconst_null
    //   413: astore 8
    //   415: aconst_null
    //   416: astore 6
    //   418: aload 6
    //   420: ifnull +8 -> 428
    //   423: aload 6
    //   425: invokevirtual 174	java/io/FileReader:close	()V
    //   428: aload 8
    //   430: ifnull +8 -> 438
    //   433: aload 8
    //   435: invokevirtual 173	java/io/BufferedReader:close	()V
    //   438: aload 5
    //   440: athrow
    //   441: astore 6
    //   443: ldc 71
    //   445: new 129	java/lang/StringBuilder
    //   448: dup
    //   449: ldc_w 292
    //   452: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   455: aload 6
    //   457: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   460: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto -41 -> 428
    //   472: astore 6
    //   474: ldc 71
    //   476: new 129	java/lang/StringBuilder
    //   479: dup
    //   480: ldc_w 294
    //   483: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   486: aload 6
    //   488: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   491: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 185	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: goto -62 -> 438
    //   503: astore 5
    //   505: aconst_null
    //   506: astore 8
    //   508: goto -90 -> 418
    //   511: astore 5
    //   513: aload 7
    //   515: astore 6
    //   517: goto -99 -> 418
    //   520: astore 9
    //   522: aconst_null
    //   523: astore 5
    //   525: goto -232 -> 293
    //   528: astore 9
    //   530: goto -237 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	paramInt	int
    //   182	35	1	l1	long
    //   200	21	3	l2	long
    //   52	28	5	localBufferedReader	BufferedReader
    //   117	90	5	localException1	java.lang.Exception
    //   254	15	5	localException2	java.lang.Exception
    //   288	55	5	localObject1	Object
    //   349	15	5	localException3	java.lang.Exception
    //   410	29	5	localObject2	Object
    //   503	1	5	localObject3	Object
    //   511	1	5	localObject4	Object
    //   523	1	5	localObject5	Object
    //   41	34	6	localFileReader	java.io.FileReader
    //   86	116	6	localException4	java.lang.Exception
    //   223	15	6	localException5	java.lang.Exception
    //   291	42	6	localObject6	Object
    //   379	15	6	localException6	java.lang.Exception
    //   416	8	6	localObject7	Object
    //   441	15	6	localException7	java.lang.Exception
    //   472	15	6	localException8	java.lang.Exception
    //   515	1	6	localObject8	Object
    //   60	454	7	localObject9	Object
    //   56	451	8	localObject10	Object
    //   67	125	9	localObject11	Object
    //   285	29	9	localException9	java.lang.Exception
    //   520	1	9	localException10	java.lang.Exception
    //   528	1	9	localException11	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   74	79	86	java/lang/Exception
    //   79	84	117	java/lang/Exception
    //   201	206	223	java/lang/Exception
    //   206	211	254	java/lang/Exception
    //   0	43	285	java/lang/Exception
    //   342	347	349	java/lang/Exception
    //   332	337	379	java/lang/Exception
    //   0	43	410	finally
    //   423	428	441	java/lang/Exception
    //   433	438	472	java/lang/Exception
    //   43	54	503	finally
    //   62	69	511	finally
    //   155	165	511	finally
    //   173	183	511	finally
    //   191	201	511	finally
    //   301	327	511	finally
    //   43	54	520	java/lang/Exception
    //   62	69	528	java/lang/Exception
    //   155	165	528	java/lang/Exception
    //   173	183	528	java/lang/Exception
    //   191	201	528	java/lang/Exception
  }
  
  public static native int getTickRate();
  
  public static void initHCPerfManager(HCPerfManagerThread paramHCPerfManagerThread, Context paramContext)
  {
    if (hcPerfManager == null) {
      hcPerfManager = new a(paramHCPerfManagerThread, paramContext);
    }
  }
  
  public static native int initHardCoder(String paramString1, int paramInt, String paramString2, boolean paramBoolean);
  
  public static native int isRunning();
  
  public static void onData(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    c.i("HardCoder.JNI", "onData callbackType:" + paramInt1 + " timestamp:" + paramLong + " errCode:" + paramInt2 + " funcid:" + paramInt3 + " dataType:" + paramInt4);
    if (callback != null) {}
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      callback.onANR(paramArrayOfByte);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = "";
      }
    }
  }
  
  public static String readServerAddr(String paramString)
  {
    try
    {
      String str = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + paramString).getInputStream())).readLine();
      c.i("HardCoder.JNI", "Read " + paramString + " : " + str);
      return str;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static native int registerANRCallback(int paramInt, long paramLong);
  
  public static int registerANRCallback(Callback paramCallback)
  {
    callback = paramCallback;
    return registerANRCallback(android.os.Process.myTid(), SystemClock.elapsedRealtime());
  }
  
  public static native int registerBootPreloadResource(String[] paramArrayOfString, int paramInt, long paramLong);
  
  public static void reportInfo(e parame)
  {
    if (hcPerfManager == null)
    {
      c.e("HardCoder.JNI", "reportInfo error HCPerfManager is null, check process!");
      return;
    }
    hcPerfManager.dEf.T(parame);
  }
  
  public static native int requestCpuCoreForThread(int paramInt1, long paramLong1, int[] paramArrayOfInt, int paramInt2, int paramInt3, long paramLong2);
  
  public static native int requestCpuHighFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native int requestHighIOFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native int requestScreenResolution(int paramInt1, String paramString, int paramInt2, long paramLong);
  
  public static native int requestUnifyCpuIOThreadCore(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4, int paramInt5, long paramLong2);
  
  public static native int resetScreenResolution(int paramInt, long paramLong);
  
  public static native void setDebug(boolean paramBoolean);
  
  public static native void setHCEnable(boolean paramBoolean);
  
  public static native void setRetryConnectInterval(int paramInt);
  
  public static void setSceneReportCallback(SceneReportCallback paramSceneReportCallback)
  {
    sceneReportCallback = paramSceneReportCallback;
  }
  
  public static int startPerformance(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    if (hcPerfManager == null)
    {
      c.e("HardCoder.JNI", "startPerformance error HCPerfManager is null, check process!");
      return -5;
    }
    a locala = hcPerfManager;
    a.b localb = new a.b();
    localb.delay = paramInt1;
    localb.dEl = paramInt2;
    localb.dEm = paramInt3;
    localb.dEn = paramInt4;
    localb.dEk = paramInt5;
    localb.scene = paramInt6;
    localb.dEo = paramLong;
    localb.dEr = paramInt7;
    localb.dEp = System.currentTimeMillis();
    localb.startTime = (localb.dEp + paramInt1);
    localb.dEq = (localb.dEp + paramInt1 + paramInt5);
    localb.tag = paramString;
    localb.lastUpdateTime = localb.startTime;
    localb.dEE = localb.dEp;
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt5 <= 0) || ((paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))) {
      c.e("HardCoder.HCPerfManager", "ErrorParam task:" + localb.toString(localb.dEp));
    }
    for (paramInt1 = 0;; paramInt1 = localb.hashCode())
    {
      c.d("HardCoder.JNI", String.format("hcPerfManager startPerformance:%d, scene:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt6) }));
      return paramInt1;
      boolean bool = locala.dEi.offer(localb);
      if (hcDebug) {
        c.d("HardCoder.HCPerfManager", "OutCallAddTask ret:" + bool + " task:" + localb.toString(localb.dEp));
      }
      if (!bool) {
        break;
      }
    }
  }
  
  public static int startTraceCpuLoad(int paramInt)
  {
    return startTraceCpuLoad(paramInt, 20);
  }
  
  public static native int startTraceCpuLoad(int paramInt1, int paramInt2);
  
  public static int stopPerformace(int paramInt)
  {
    int i = 0;
    if (hcPerfManager == null)
    {
      c.e("HardCoder.JNI", "stopPerformace error HCPerfManager is null, check process!");
      paramInt = -5;
      return paramInt;
    }
    c.d("HardCoder.JNI", String.format("hcPerfManager stopPerformace:%d", new Object[] { Integer.valueOf(paramInt) }));
    a locala = hcPerfManager;
    a.c localc = new a.c();
    localc.dEF = System.currentTimeMillis();
    localc.auK = paramInt;
    if (paramInt != 0) {}
    for (boolean bool = locala.dEi.offer(localc);; bool = false)
    {
      if (hcDebug) {
        c.d("HardCoder.HCPerfManager", String.format("OutCallStopTask ret:%b, hashcode:%x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      }
      paramInt = i;
      if (bool) {
        break;
      }
      return -1;
    }
  }
  
  public static native int stopTraceCpuLoad(int paramInt);
  
  public static native int terminateApp(int paramInt, long paramLong);
  
  public static abstract interface Callback
  {
    public abstract void onANR(String paramString);
  }
  
  public static abstract interface HCPerfManagerThread
  {
    public abstract Thread newThread(Runnable paramRunnable, String paramString, int paramInt);
  }
  
  public static abstract interface SceneReportCallback
  {
    public abstract void sceneReport(int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderJNI
 * JD-Core Version:    0.7.0.1
 */