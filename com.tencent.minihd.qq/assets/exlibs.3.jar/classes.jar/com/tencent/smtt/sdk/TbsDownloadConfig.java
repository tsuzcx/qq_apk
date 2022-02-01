package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TbsDownloadConfig
{
  public static final int CMD_ID_DOWNLOAD_FILE = 101;
  public static final int CMD_ID_FILE_UPLOAD = 100;
  public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400L;
  public static final int ERROR_DOWNLOAD = 2;
  public static final int ERROR_INSTALL = 5;
  public static final int ERROR_LOAD = 6;
  public static final int ERROR_NONE = 1;
  public static final int ERROR_REPORTED = 0;
  public static final int ERROR_UNZIP = 4;
  public static final int ERROR_VERIFY = 3;
  private static TbsDownloadConfig a;
  private Context b;
  public SharedPreferences mPreferences;
  public Map<String, Object> mSyncMap = new HashMap();
  
  private TbsDownloadConfig(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = a;
      return localTbsDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new TbsDownloadConfig(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.mSyncMap.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void commit()
  {
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        Iterator localIterator = this.mSyncMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label203;
        }
        str = (String)localIterator.next();
        localObject2 = this.mSyncMap.get(str);
        if ((localObject2 instanceof String))
        {
          localEditor.putString(str, (String)localObject2);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
        if ((localObject2 instanceof Boolean))
        {
          localException.putBoolean(str, ((Boolean)localObject2).booleanValue());
          continue;
        }
      }
      finally {}
      if ((localObject2 instanceof Long))
      {
        localObject1.putLong(str, ((Long)localObject2).longValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        localObject1.putInt(str, ((Integer)localObject2).intValue());
      }
      else if ((localObject2 instanceof Float))
      {
        localObject1.putFloat(str, ((Float)localObject2).floatValue());
        continue;
        label203:
        localObject1.commit();
        this.mSyncMap.clear();
      }
    }
  }
  
  public int getDownloadFailedMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 100;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getDownloadInterruptCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: ldc 177
    //   8: invokeinterface 181 2 0
    //   13: istore_3
    //   14: iload_3
    //   15: ifne +124 -> 139
    //   18: new 183	java/io/File
    //   21: dup
    //   22: new 183	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:b	Landroid/content/Context;
    //   30: invokevirtual 187	android/content/Context:getFilesDir	()Ljava/io/File;
    //   33: ldc 189
    //   35: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: ldc 51
    //   40: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: invokevirtual 195	java/io/File:exists	()Z
    //   46: istore_3
    //   47: iload_3
    //   48: ifne +55 -> 103
    //   51: bipush 159
    //   53: istore_1
    //   54: aload_0
    //   55: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:b	Landroid/content/Context;
    //   58: ifnull +156 -> 214
    //   61: ldc 197
    //   63: aload_0
    //   64: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:b	Landroid/content/Context;
    //   67: invokevirtual 201	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   70: getfield 207	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   73: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +138 -> 214
    //   79: ldc 213
    //   81: invokestatic 219	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   84: invokevirtual 223	java/util/Locale:getCountry	()Ljava/lang/String;
    //   87: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: istore_3
    //   91: iload_3
    //   92: ifne +122 -> 214
    //   95: sipush -320
    //   98: istore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: iload_1
    //   102: ireturn
    //   103: aload_0
    //   104: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   107: ldc 225
    //   109: invokeinterface 181 2 0
    //   114: istore_3
    //   115: iload_3
    //   116: ifne +9 -> 125
    //   119: bipush 160
    //   121: istore_1
    //   122: goto -68 -> 54
    //   125: bipush 155
    //   127: istore_1
    //   128: goto -74 -> 54
    //   131: astore 4
    //   133: bipush 161
    //   135: istore_1
    //   136: goto -82 -> 54
    //   139: aload_0
    //   140: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   143: ldc 177
    //   145: bipush 157
    //   147: invokeinterface 172 3 0
    //   152: istore_1
    //   153: iload_1
    //   154: bipush 137
    //   156: if_icmpeq +11 -> 167
    //   159: iload_1
    //   160: istore_2
    //   161: iload_1
    //   162: bipush 135
    //   164: if_icmpne +17 -> 181
    //   167: aload_0
    //   168: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   171: ldc 227
    //   173: bipush 137
    //   175: invokeinterface 172 3 0
    //   180: istore_2
    //   181: iload_2
    //   182: istore_1
    //   183: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   186: aload_0
    //   187: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   190: ldc 234
    //   192: lconst_0
    //   193: invokeinterface 238 4 0
    //   198: lsub
    //   199: ldc2_w 239
    //   202: lcmp
    //   203: ifle -149 -> 54
    //   206: iload_2
    //   207: ldc 241
    //   209: isub
    //   210: istore_1
    //   211: goto -157 -> 54
    //   214: aload_0
    //   215: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   218: ldc 243
    //   220: iconst_m1
    //   221: invokeinterface 172 3 0
    //   226: istore_2
    //   227: iload_1
    //   228: sipush 1000
    //   231: imul
    //   232: iload_2
    //   233: iadd
    //   234: istore_1
    //   235: goto -136 -> 99
    //   238: astore 4
    //   240: aload_0
    //   241: monitorexit
    //   242: aload 4
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	TbsDownloadConfig
    //   53	182	1	i	int
    //   160	74	2	j	int
    //   13	103	3	bool	boolean
    //   131	1	4	localThrowable	java.lang.Throwable
    //   238	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	47	131	java/lang/Throwable
    //   103	115	131	java/lang/Throwable
    //   2	14	238	finally
    //   18	47	238	finally
    //   54	91	238	finally
    //   103	115	238	finally
    //   139	153	238	finally
    //   167	181	238	finally
    //   183	206	238	finally
    //   214	227	238	finally
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int j = i;
      if (i == 0) {
        j = 20;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public long getDownloadMinFreeSpace()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc 251
    //   10: iconst_0
    //   11: invokeinterface 172 3 0
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +18 -> 36
    //   21: iload_1
    //   22: sipush 1024
    //   25: imul
    //   26: i2l
    //   27: lstore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: lload_3
    //   31: ldc2_w 247
    //   34: lmul
    //   35: lreturn
    //   36: iload_2
    //   37: istore_1
    //   38: goto -17 -> 21
    //   41: astore 5
    //   43: aload_0
    //   44: monitorexit
    //   45: aload 5
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TbsDownloadConfig
    //   1	37	1	i	int
    //   16	21	2	j	int
    //   27	4	3	l	long
    //   41	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	41	finally
  }
  
  public long getDownloadSingleTimeout()
  {
    try
    {
      long l1 = this.mPreferences.getLong("tbs_single_timeout", 0L);
      long l2 = l1;
      if (l1 == 0L) {
        l2 = 1200000L;
      }
      return l2;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDownloadSuccessMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 3;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public long getRetryInterval()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 265	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   5: lconst_0
    //   6: lcmp
    //   7: iflt +11 -> 18
    //   10: invokestatic 265	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   13: lstore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: lload_1
    //   17: lreturn
    //   18: aload_0
    //   19: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   22: ldc_w 267
    //   25: ldc2_w 15
    //   28: invokeinterface 238 4 0
    //   33: lstore_1
    //   34: goto -20 -> 14
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TbsDownloadConfig
    //   13	21	1	l	long
    //   37	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	37	finally
    //   18	34	37	finally
  }
  
  /* Error */
  public boolean getTbsCoreLoadRenameFileLockWaitEnable()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc_w 270
    //   11: iconst_1
    //   12: invokeinterface 274 3 0
    //   17: istore_2
    //   18: iload_2
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: astore_3
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    //   29: astore_3
    //   30: goto -10 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadConfig
    //   1	22	1	bool1	boolean
    //   17	2	2	bool2	boolean
    //   24	4	3	localObject	Object
    //   29	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	18	24	finally
    //   4	18	29	java/lang/Exception
  }
  
  public boolean isOverSea()
  {
    try
    {
      boolean bool = this.mPreferences.getBoolean("is_oversea", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setDownloadInterruptCode(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 86 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc 177
    //   15: iload_1
    //   16: invokeinterface 155 3 0
    //   21: pop
    //   22: aload_2
    //   23: ldc 234
    //   25: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   28: invokeinterface 145 4 0
    //   33: pop
    //   34: aload_2
    //   35: invokeinterface 94 1 0
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    //   49: astore_2
    //   50: goto -9 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	TbsDownloadConfig
    //   0	53	1	paramInt	int
    //   11	24	2	localEditor	SharedPreferences.Editor
    //   44	4	2	localObject	Object
    //   49	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
    //   2	41	49	java/lang/Exception
  }
  
  public void setInstallInterruptCode(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.putInt("tbs_install_interrupt_code", paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setTbsCoreLoadRenameFileLockWaitEnable(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 86 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 270
    //   16: iload_1
    //   17: invokeinterface 135 3 0
    //   22: pop
    //   23: aload_2
    //   24: invokeinterface 94 1 0
    //   29: pop
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: goto -9 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TbsDownloadConfig
    //   0	42	1	paramBoolean	boolean
    //   11	13	2	localEditor	SharedPreferences.Editor
    //   33	4	2	localObject	Object
    //   38	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
    //   2	30	38	java/lang/Exception
  }
  
  /* Error */
  public void uploadDownloadInterruptCodeIfNeeded(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +144 -> 147
    //   6: ldc_w 285
    //   9: aload_1
    //   10: invokevirtual 63	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   13: invokevirtual 201	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   16: getfield 207	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   19: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +125 -> 147
    //   25: aload_0
    //   26: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   29: ldc 177
    //   31: invokeinterface 181 2 0
    //   36: istore 5
    //   38: iload 5
    //   40: ifne +150 -> 190
    //   43: new 183	java/io/File
    //   46: dup
    //   47: new 183	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:b	Landroid/content/Context;
    //   55: invokevirtual 187	android/content/Context:getFilesDir	()Ljava/io/File;
    //   58: ldc 189
    //   60: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: ldc 51
    //   65: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   68: invokevirtual 195	java/io/File:exists	()Z
    //   71: istore 5
    //   73: iload 5
    //   75: ifne +75 -> 150
    //   78: bipush 159
    //   80: istore_2
    //   81: iconst_1
    //   82: istore 4
    //   84: iload_2
    //   85: istore_3
    //   86: iload 4
    //   88: istore_2
    //   89: iload_2
    //   90: ifeq +57 -> 147
    //   93: aload_1
    //   94: invokestatic 290	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   97: invokevirtual 294	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   100: astore 6
    //   102: aload 6
    //   104: sipush 128
    //   107: invokevirtual 299	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   110: aload 6
    //   112: new 301	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 302	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 304
    //   122: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload_3
    //   126: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 318	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokestatic 290	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   139: getstatic 324	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   142: aload 6
    //   144: invokevirtual 328	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: aload_0
    //   151: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   154: ldc 225
    //   156: invokeinterface 181 2 0
    //   161: istore 5
    //   163: iload 5
    //   165: ifne +9 -> 174
    //   168: bipush 160
    //   170: istore_2
    //   171: goto -90 -> 81
    //   174: bipush 155
    //   176: istore_2
    //   177: goto -96 -> 81
    //   180: astore 6
    //   182: bipush 161
    //   184: istore_3
    //   185: iconst_1
    //   186: istore_2
    //   187: goto -98 -> 89
    //   190: aload_0
    //   191: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   194: ldc 177
    //   196: bipush 157
    //   198: invokeinterface 172 3 0
    //   203: istore_2
    //   204: iload_2
    //   205: sipush -206
    //   208: if_icmpgt +21 -> 229
    //   211: iload_2
    //   212: sipush -219
    //   215: if_icmplt +14 -> 229
    //   218: iconst_1
    //   219: istore 4
    //   221: iload_2
    //   222: istore_3
    //   223: iload 4
    //   225: istore_2
    //   226: goto -137 -> 89
    //   229: iload_2
    //   230: sipush -302
    //   233: if_icmpgt +21 -> 254
    //   236: iload_2
    //   237: sipush -316
    //   240: if_icmplt +14 -> 254
    //   243: iconst_1
    //   244: istore 4
    //   246: iload_2
    //   247: istore_3
    //   248: iload 4
    //   250: istore_2
    //   251: goto -162 -> 89
    //   254: iload_2
    //   255: sipush -318
    //   258: if_icmpgt +21 -> 279
    //   261: iload_2
    //   262: sipush -322
    //   265: if_icmplt +14 -> 279
    //   268: iconst_1
    //   269: istore 4
    //   271: iload_2
    //   272: istore_3
    //   273: iload 4
    //   275: istore_2
    //   276: goto -187 -> 89
    //   279: iconst_0
    //   280: istore 4
    //   282: iload_2
    //   283: istore_3
    //   284: iload 4
    //   286: istore_2
    //   287: goto -198 -> 89
    //   290: astore_1
    //   291: aload_0
    //   292: monitorexit
    //   293: aload_1
    //   294: athrow
    //   295: astore_1
    //   296: goto -149 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	TbsDownloadConfig
    //   0	299	1	paramContext	Context
    //   80	207	2	i	int
    //   85	199	3	j	int
    //   82	203	4	k	int
    //   36	128	5	bool	boolean
    //   100	43	6	localTbsLogInfo	TbsLogReport.TbsLogInfo
    //   180	1	6	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   43	73	180	java/lang/Throwable
    //   150	163	180	java/lang/Throwable
    //   6	38	290	finally
    //   43	73	290	finally
    //   93	147	290	finally
    //   150	163	290	finally
    //   190	204	290	finally
    //   6	38	295	java/lang/Throwable
    //   93	147	295	java/lang/Throwable
    //   190	204	295	java/lang/Throwable
  }
  
  public static abstract interface TbsConfigKey
  {
    public static final String KEY_APP_METADATA = "app_metadata";
    public static final String KEY_APP_VERSIONCODE = "app_versioncode";
    public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
    public static final String KEY_APP_VERSIONNAME = "app_versionname";
    public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
    public static final String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
    public static final String KEY_CPUTYPE_OTHER_STABLE_CORE = "tbs_cpu_type_other_stable_core";
    public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
    public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
    public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
    public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
    public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
    public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
    public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
    public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
    public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
    public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
    public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
    public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
    public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
    public static final String KEY_FULL_PACKAGE = "request_full_package";
    public static final String KEY_GUID = "tbs_guid";
    public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
    public static final String KEY_IS_OVERSEA = "is_oversea";
    public static final String KEY_LAST_CHECK = "last_check";
    public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
    public static final String KEY_LAST_DOWNLOAD_STABLE_CORE_OTHER_CPU = "last_download_stable_core_other_cpu";
    public static final String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
    public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
    public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
    public static final String KEY_REQUEST_FAIL = "request_fail";
    public static final String KEY_RESPONSECODE = "tbs_responsecode";
    public static final String KEY_RETRY_INTERVAL = "retry_interval";
    public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
    public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
    public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
    public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
    public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
    public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
    public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
    public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE = "tbs_core_load_rename_file_lock_wait_enable";
    public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
    public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
    public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
    public static final String KEY_USE_BUGLY = "tbs_use_bugly";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadConfig
 * JD-Core Version:    0.7.0.1
 */