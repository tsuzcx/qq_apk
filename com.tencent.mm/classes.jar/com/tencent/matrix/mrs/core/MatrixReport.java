package com.tencent.matrix.mrs.core;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mrs.util.MatrixStrategyNotifyBroadcast;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MatrixReport
{
  private static final String TAG = "Matrix.MatrixReport";
  private static a anrReportListener;
  private static IReportCallback mReportCallback;
  private static MrsCallback mrsCallback;
  private static volatile MatrixReport sInstance;
  private final long clientVersion;
  private final Context context;
  private final boolean isDebug;
  private final boolean isReportProcess;
  private final MatrixIdKeyReporter matrixIdKeyReporter;
  private final String processName;
  private final long publishType;
  private HashMap<String, Integer> reportFps = new HashMap();
  private final String revision;
  private long uin = 0L;
  
  private MatrixReport(Context paramContext, String paramString1, long paramLong1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    this.clientVersion = paramLong1;
    this.revision = paramString2;
    this.isDebug = paramBoolean1;
    this.context = paramContext;
    this.processName = paramString1;
    this.isReportProcess = paramBoolean2;
    this.publishType = paramLong2;
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        MrsLogic.init(paramLong1, paramString2, paramBoolean1, paramLong2);
        this.matrixIdKeyReporter = new MatrixIdKeyReporter();
        return;
      }
      catch (Throwable paramContext)
      {
        c.printErrStackTrace("Matrix.MatrixReport", paramContext, "call oncreate err", new Object[0]);
        MrsLogic.init(paramLong1, paramString2, paramBoolean1, paramLong2);
        continue;
      }
      paramString1 = new IntentFilter();
      paramString1.addAction("strategyNotify");
      paramContext.registerReceiver(new MatrixStrategyNotifyBroadcast(), paramString1, "com.tencent.mm.matrix.strategynotify", null);
    }
  }
  
  private static void checkStatusChange()
  {
    c.i("Matrix.MatrixReport", "schedule to check", new Object[0]);
    if (!com.tencent.matrix.b.isInstalled()) {
      c.i("Matrix.MatrixReport", "matrix not installed", new Object[0]);
    }
    HashMap localHashMap;
    do
    {
      do
      {
        do
        {
          return;
        } while (mReportCallback == null);
        localHashMap = new HashMap();
        Iterator localIterator = com.tencent.matrix.b.yD().bLY.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.matrix.d.b localb = (com.tencent.matrix.d.b)localIterator.next();
          if ((localb instanceof com.tencent.matrix.trace.b))
          {
            localHashMap.put("Trace_FPS", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_FPS")));
            localHashMap.put("Trace_EvilMethod", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_EvilMethod")));
            localHashMap.put("Trace_StartUp", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_StartUp")));
          }
          else
          {
            localHashMap.put(localb.getTag(), Boolean.valueOf(MrsLogic.isNeed2Report(localb.getTag())));
          }
        }
      } while (localHashMap.size() <= 0);
      c.i("Matrix.MatrixReport", "onStatusChange, map:%s", new Object[] { localHashMap });
    } while (mReportCallback == null);
    mReportCallback.onStatusChanged(localHashMap);
  }
  
  public static MrsCallback getMrsCallback()
  {
    return mrsCallback;
  }
  
  /* Error */
  public static MatrixReport init(MatrixReport paramMatrixReport, IReportCallback paramIReportCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 200	java/lang/RuntimeException
    //   7: dup
    //   8: ldc 202
    //   10: invokespecial 204	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 206	com/tencent/matrix/mrs/core/MatrixReport:sInstance	Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   20: ifnonnull +18 -> 38
    //   23: aload_0
    //   24: putstatic 206	com/tencent/matrix/mrs/core/MatrixReport:sInstance	Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_1
    //   31: putstatic 128	com/tencent/matrix/mrs/core/MatrixReport:mReportCallback	Lcom/tencent/matrix/mrs/core/IReportCallback;
    //   34: getstatic 206	com/tencent/matrix/mrs/core/MatrixReport:sInstance	Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   37: areturn
    //   38: ldc 13
    //   40: ldc 208
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 211	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: goto -22 -> 27
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramMatrixReport	MatrixReport
    //   0	58	1	paramIReportCallback	IReportCallback
    // Exception table:
    //   from	to	target	type
    //   17	27	52	finally
    //   27	30	52	finally
    //   38	49	52	finally
    //   53	56	52	finally
  }
  
  public static boolean isInstalled()
  {
    return sInstance != null;
  }
  
  public static void setAnrReportListener(a parama)
  {
    anrReportListener = parama;
  }
  
  public static void setMrsCallback(MrsCallback paramMrsCallback)
  {
    mrsCallback = paramMrsCallback;
    MrsLogic.setCallBack(paramMrsCallback);
  }
  
  public static MatrixReport with()
  {
    if (sInstance == null) {
      throw new RuntimeException("you must init Matrix report sdk first");
    }
    return sInstance;
  }
  
  public long getClientVersion()
  {
    return this.clientVersion;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public MrsLogic.PhoneInfo getPhoneInfo()
  {
    return MrsLogic.getPhoneInfo();
  }
  
  public String getProcessName()
  {
    return this.processName;
  }
  
  public long getPublishType()
  {
    return this.publishType;
  }
  
  public String getRevision()
  {
    return this.revision;
  }
  
  public long getUin()
  {
    return this.uin;
  }
  
  public boolean isDebug()
  {
    return this.isDebug;
  }
  
  public boolean isNeedReport(String paramString)
  {
    return MrsLogic.isNeed2Report(paramString);
  }
  
  public boolean isReportProcess()
  {
    return this.isReportProcess;
  }
  
  public void onCrash()
  {
    if (this.isReportProcess) {
      MrsLogic.onCrash();
    }
  }
  
  public void onDestroy()
  {
    if (this.isReportProcess) {
      MrsLogic.onDestroy();
    }
  }
  
  public void onForeground(boolean paramBoolean)
  {
    if (this.isReportProcess)
    {
      MrsLogic.onForeground(paramBoolean);
      if (!paramBoolean) {
        com.tencent.mm.sdk.g.d.ysm.b(new Runnable()
        {
          public void run() {}
        }, "Matrix.MatrixReport");
      }
    }
  }
  
  public void onStrategyResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    MrsLogic.onStrategyResp(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void report(com.tencent.matrix.e.b paramb, File paramFile)
  {
    report(paramb, paramFile, true);
  }
  
  public void report(com.tencent.matrix.e.b paramb, File paramFile, boolean paramBoolean)
  {
    if ((paramb != null) && (paramFile != null)) {}
    for (;;)
    {
      try
      {
        if (!paramFile.exists())
        {
          c.e("Matrix.MatrixReport", "Matrix report, tag %s or file %s is null, just return", new Object[] { paramb, paramFile });
          return;
        }
        MatrixUploadIssue localMatrixUploadIssue = new MatrixUploadIssue();
        localMatrixUploadIssue.setTag(paramb.tag);
        localMatrixUploadIssue.setCanSplitSlice(true);
        localMatrixUploadIssue.setDataType(1);
        localMatrixUploadIssue.setNeedDeleteFileAfterSucc(paramBoolean);
        if (paramb.bOw != null)
        {
          i = paramb.bOw.intValue();
          localMatrixUploadIssue.setType(i);
          localMatrixUploadIssue.setDesKey(paramb.key);
          localMatrixUploadIssue.setFilePath(paramFile.getAbsolutePath());
          MrsLogic.uploadMatrixIssue(localMatrixUploadIssue);
          return;
        }
      }
      catch (Throwable paramb)
      {
        c.e("Matrix.MatrixReport", "Matrix report occur error:".concat(String.valueOf(paramb)), new Object[0]);
        return;
      }
      int i = 0;
    }
  }
  
  /* Error */
  public void report(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_3
    //   5: ifnonnull +24 -> 29
    //   8: ldc 13
    //   10: ldc_w 341
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_3
    //   24: aastore
    //   25: invokestatic 211	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: return
    //   29: getstatic 215	com/tencent/matrix/mrs/core/MatrixReport:anrReportListener	Lcom/tencent/matrix/trace/a;
    //   32: ifnull +658 -> 690
    //   35: getstatic 215	com/tencent/matrix/mrs/core/MatrixReport:anrReportListener	Lcom/tencent/matrix/trace/a;
    //   38: astore 32
    //   40: invokestatic 346	android/os/SystemClock:uptimeMillis	()J
    //   43: lstore 16
    //   45: aload_3
    //   46: ldc_w 347
    //   49: invokevirtual 352	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: ldc 175
    //   54: invokevirtual 355	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   57: ifeq +608 -> 665
    //   60: aload_3
    //   61: ldc_w 357
    //   64: invokevirtual 352	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: getstatic 363	com/tencent/matrix/trace/b/a$a:bRc	Lcom/tencent/matrix/trace/b/a$a;
    //   70: invokevirtual 366	com/tencent/matrix/trace/b/a$a:toString	()Ljava/lang/String;
    //   73: invokevirtual 355	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   76: ifeq +589 -> 665
    //   79: aload_3
    //   80: ldc_w 368
    //   83: invokevirtual 352	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 31
    //   88: aload_2
    //   89: invokestatic 374	com/tencent/mm/sdk/platformtools/bo:apW	(Ljava/lang/String;)J
    //   92: lstore 8
    //   94: aload 31
    //   96: invokestatic 374	com/tencent/mm/sdk/platformtools/bo:apW	(Ljava/lang/String;)J
    //   99: lstore 18
    //   101: invokestatic 379	com/tencent/mm/kernel/g:RG	()Z
    //   104: ifeq +561 -> 665
    //   107: invokestatic 383	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   110: getfield 389	com/tencent/mm/kernel/e:eHS	Lcom/tencent/mm/cg/h;
    //   113: astore 31
    //   115: aload 31
    //   117: ifnull +675 -> 792
    //   120: aload 31
    //   122: invokevirtual 395	com/tencent/mm/cg/h:dzU	()Lcom/tencent/mm/cg/f;
    //   125: ifnull +667 -> 792
    //   128: invokestatic 401	com/tencent/mm/cg/f:dzN	()Lcom/tencent/mm/cg/f$a;
    //   131: astore 34
    //   133: aload 34
    //   135: getfield 406	com/tencent/mm/cg/f$a:time	J
    //   138: lstore 20
    //   140: ldc_w 408
    //   143: ldc_w 410
    //   146: iconst_4
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload 34
    //   154: getfield 414	com/tencent/mm/cg/f$a:status	I
    //   157: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload 34
    //   165: getfield 420	com/tencent/mm/cg/f$a:sql	Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: iconst_2
    //   171: lload 20
    //   173: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: aload 34
    //   181: getfield 429	com/tencent/mm/cg/f$a:ptp	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   184: aastore
    //   185: invokestatic 432	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 34
    //   190: getfield 429	com/tencent/mm/cg/f$a:ptp	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   193: ifnull +587 -> 780
    //   196: invokestatic 346	android/os/SystemClock:uptimeMillis	()J
    //   199: lstore 10
    //   201: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   204: lload 18
    //   206: lsub
    //   207: lload 10
    //   209: lload 8
    //   211: lload 18
    //   213: ladd
    //   214: lsub
    //   215: lsub
    //   216: lstore 22
    //   218: iconst_0
    //   219: istore 5
    //   221: lconst_0
    //   222: lstore 10
    //   224: lconst_0
    //   225: lstore 8
    //   227: new 349	org/json/JSONObject
    //   230: dup
    //   231: invokespecial 438	org/json/JSONObject:<init>	()V
    //   234: astore 33
    //   236: aload 34
    //   238: getfield 429	com/tencent/mm/cg/f$a:ptp	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   241: iconst_0
    //   242: invokevirtual 444	com/tencent/wcdb/database/SQLiteDatabase:dumpJSON	(Z)Lorg/json/JSONObject;
    //   245: astore 31
    //   247: ldc_w 408
    //   250: ldc_w 446
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 31
    //   261: aastore
    //   262: invokestatic 432	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload 31
    //   267: ldc_w 448
    //   270: invokevirtual 452	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   273: astore 35
    //   275: iconst_0
    //   276: istore 4
    //   278: iload 4
    //   280: aload 35
    //   282: invokevirtual 457	org/json/JSONArray:length	()I
    //   285: if_icmpge +637 -> 922
    //   288: aload 35
    //   290: iload 4
    //   292: invokevirtual 461	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   295: astore 38
    //   297: aload 38
    //   299: ldc_w 463
    //   302: invokevirtual 452	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   305: astore 36
    //   307: new 454	org/json/JSONArray
    //   310: dup
    //   311: invokespecial 464	org/json/JSONArray:<init>	()V
    //   314: astore 37
    //   316: aload 38
    //   318: ldc_w 463
    //   321: aload 37
    //   323: invokevirtual 467	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: iload 4
    //   329: ifne +557 -> 886
    //   332: aload 34
    //   334: getfield 414	com/tencent/mm/cg/f$a:status	I
    //   337: iconst_3
    //   338: if_icmpne +548 -> 886
    //   341: new 349	org/json/JSONObject
    //   344: dup
    //   345: invokespecial 438	org/json/JSONObject:<init>	()V
    //   348: astore 38
    //   350: aload 36
    //   352: aload 38
    //   354: invokevirtual 470	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   357: pop
    //   358: aload 38
    //   360: ldc_w 472
    //   363: lload 20
    //   365: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   368: pop
    //   369: aload 38
    //   371: ldc_w 477
    //   374: lload 18
    //   376: lload 22
    //   378: lload 18
    //   380: ladd
    //   381: lload 20
    //   383: lsub
    //   384: invokestatic 483	java/lang/Math:min	(JJ)J
    //   387: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload 38
    //   393: ldc_w 485
    //   396: getstatic 490	com/tencent/matrix/trace/a:bQK	J
    //   399: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   402: pop
    //   403: ldc_w 408
    //   406: ldc_w 492
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload 38
    //   417: aastore
    //   418: invokestatic 432	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: goto +465 -> 886
    //   424: iload 7
    //   426: aload 36
    //   428: invokevirtual 457	org/json/JSONArray:length	()I
    //   431: if_icmpge +482 -> 913
    //   434: aload 36
    //   436: iload 7
    //   438: invokevirtual 461	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   441: astore 38
    //   443: aload 38
    //   445: ldc_w 472
    //   448: invokevirtual 495	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   451: lstore 28
    //   453: aload 38
    //   455: ldc_w 477
    //   458: invokevirtual 495	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   461: lstore 24
    //   463: aload 38
    //   465: ldc_w 485
    //   468: invokevirtual 495	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   471: lstore 26
    //   473: lload 8
    //   475: lstore 12
    //   477: lload 10
    //   479: lstore 14
    //   481: iload 5
    //   483: istore 6
    //   485: lload 22
    //   487: lload 28
    //   489: lcmp
    //   490: ifgt +402 -> 892
    //   493: iload 5
    //   495: iconst_1
    //   496: iadd
    //   497: istore 5
    //   499: lload 8
    //   501: lload 24
    //   503: ladd
    //   504: lstore 8
    //   506: lload 24
    //   508: l2f
    //   509: lload 18
    //   511: l2f
    //   512: ldc_w 496
    //   515: fmul
    //   516: fcmpl
    //   517: iflt +11 -> 528
    //   520: aload 37
    //   522: aload 38
    //   524: invokevirtual 470	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   527: pop
    //   528: lload 8
    //   530: lstore 12
    //   532: lload 10
    //   534: lstore 14
    //   536: iload 5
    //   538: istore 6
    //   540: getstatic 490	com/tencent/matrix/trace/a:bQK	J
    //   543: lload 26
    //   545: lcmp
    //   546: ifne +346 -> 892
    //   549: lload 10
    //   551: lload 24
    //   553: ladd
    //   554: lstore 14
    //   556: lload 8
    //   558: lstore 12
    //   560: iload 5
    //   562: istore 6
    //   564: goto +328 -> 892
    //   567: aload 33
    //   569: ldc_w 498
    //   572: iload 30
    //   574: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   577: pop
    //   578: aload_3
    //   579: ldc_w 498
    //   582: iload 30
    //   584: invokevirtual 501	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   587: pop
    //   588: aload 33
    //   590: ldc_w 503
    //   593: iload 5
    //   595: invokevirtual 506	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   598: pop
    //   599: aload 33
    //   601: ldc_w 508
    //   604: lload 10
    //   606: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   609: pop
    //   610: aload 33
    //   612: ldc_w 510
    //   615: lload 8
    //   617: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   620: pop
    //   621: iload 30
    //   623: ifeq +117 -> 740
    //   626: aload 33
    //   628: ldc_w 357
    //   631: aload 31
    //   633: invokevirtual 467	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   636: pop
    //   637: aload_3
    //   638: ldc_w 512
    //   641: aload 33
    //   643: invokevirtual 467	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   646: pop
    //   647: getstatic 253	com/tencent/mm/sdk/g/d:ysm	Lcom/tencent/mm/sdk/g/a/e;
    //   650: new 514	com/tencent/matrix/trace/a$2
    //   653: dup
    //   654: aload 32
    //   656: aload_3
    //   657: invokespecial 517	com/tencent/matrix/trace/a$2:<init>	(Lcom/tencent/matrix/trace/a;Lorg/json/JSONObject;)V
    //   660: invokeinterface 521 2 0
    //   665: ldc_w 408
    //   668: ldc_w 523
    //   671: iconst_1
    //   672: anewarray 4	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: invokestatic 346	android/os/SystemClock:uptimeMillis	()J
    //   680: lload 16
    //   682: lsub
    //   683: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   686: aastore
    //   687: invokestatic 432	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   690: aload_0
    //   691: getfield 63	com/tencent/matrix/mrs/core/MatrixReport:isReportProcess	Z
    //   694: ifeq +110 -> 804
    //   697: invokestatic 525	com/tencent/matrix/mrs/core/MatrixReport:with	()Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   700: aload_1
    //   701: aload_2
    //   702: aload_3
    //   703: invokevirtual 526	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokevirtual 530	com/tencent/matrix/mrs/core/MatrixReport:reportLocal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   709: return
    //   710: astore_1
    //   711: ldc 13
    //   713: ldc_w 329
    //   716: aload_1
    //   717: invokestatic 334	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   720: invokevirtual 338	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   723: iconst_0
    //   724: anewarray 4	java/lang/Object
    //   727: invokestatic 211	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   730: return
    //   731: astore_1
    //   732: aload_1
    //   733: athrow
    //   734: iconst_0
    //   735: istore 30
    //   737: goto -170 -> 567
    //   740: new 349	org/json/JSONObject
    //   743: dup
    //   744: invokespecial 438	org/json/JSONObject:<init>	()V
    //   747: astore 31
    //   749: goto -123 -> 626
    //   752: astore_1
    //   753: ldc_w 408
    //   756: ldc_w 523
    //   759: iconst_1
    //   760: anewarray 4	java/lang/Object
    //   763: dup
    //   764: iconst_0
    //   765: invokestatic 346	android/os/SystemClock:uptimeMillis	()J
    //   768: lload 16
    //   770: lsub
    //   771: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   774: aastore
    //   775: invokestatic 432	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   778: aload_1
    //   779: athrow
    //   780: ldc_w 408
    //   783: ldc_w 532
    //   786: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: goto -142 -> 647
    //   792: ldc_w 408
    //   795: ldc_w 537
    //   798: invokestatic 540	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: goto -154 -> 647
    //   804: new 542	android/content/Intent
    //   807: dup
    //   808: aload_0
    //   809: getfield 59	com/tencent/matrix/mrs/core/MatrixReport:context	Landroid/content/Context;
    //   812: ldc_w 544
    //   815: invokespecial 547	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   818: astore 31
    //   820: aload 31
    //   822: ldc_w 347
    //   825: aload_1
    //   826: invokevirtual 551	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   829: pop
    //   830: aload 31
    //   832: ldc_w 347
    //   835: aload_2
    //   836: invokevirtual 551	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   839: pop
    //   840: aload 31
    //   842: ldc_w 553
    //   845: aload_3
    //   846: invokevirtual 526	org/json/JSONObject:toString	()Ljava/lang/String;
    //   849: invokevirtual 551	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   852: pop
    //   853: ldc 13
    //   855: ldc_w 555
    //   858: iconst_2
    //   859: anewarray 4	java/lang/Object
    //   862: dup
    //   863: iconst_0
    //   864: aload_1
    //   865: aastore
    //   866: dup
    //   867: iconst_1
    //   868: aload_3
    //   869: invokevirtual 526	org/json/JSONObject:toString	()Ljava/lang/String;
    //   872: aastore
    //   873: invokestatic 118	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   876: aload_0
    //   877: getfield 59	com/tencent/matrix/mrs/core/MatrixReport:context	Landroid/content/Context;
    //   880: aload 31
    //   882: invokevirtual 559	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   885: return
    //   886: iconst_0
    //   887: istore 7
    //   889: goto -465 -> 424
    //   892: iload 7
    //   894: iconst_1
    //   895: iadd
    //   896: istore 7
    //   898: lload 12
    //   900: lstore 8
    //   902: lload 14
    //   904: lstore 10
    //   906: iload 6
    //   908: istore 5
    //   910: goto -486 -> 424
    //   913: iload 4
    //   915: iconst_1
    //   916: iadd
    //   917: istore 4
    //   919: goto -641 -> 278
    //   922: lload 10
    //   924: l2f
    //   925: lload 18
    //   927: l2f
    //   928: ldc_w 560
    //   931: fmul
    //   932: fcmpl
    //   933: iflt -199 -> 734
    //   936: iconst_1
    //   937: istore 30
    //   939: goto -372 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	942	0	this	MatrixReport
    //   0	942	1	paramString1	String
    //   0	942	2	paramString2	String
    //   0	942	3	paramJSONObject	JSONObject
    //   276	642	4	i	int
    //   219	690	5	j	int
    //   483	424	6	k	int
    //   424	473	7	m	int
    //   92	809	8	l1	long
    //   199	724	10	l2	long
    //   475	424	12	l3	long
    //   479	424	14	l4	long
    //   43	726	16	l5	long
    //   99	827	18	l6	long
    //   138	244	20	l7	long
    //   216	270	22	l8	long
    //   461	91	24	l9	long
    //   471	73	26	l10	long
    //   451	37	28	l11	long
    //   572	366	30	bool	boolean
    //   86	795	31	localObject	Object
    //   38	617	32	locala	a
    //   234	408	33	localJSONObject1	JSONObject
    //   131	202	34	locala1	com.tencent.mm.cg.f.a
    //   273	16	35	localJSONArray1	org.json.JSONArray
    //   305	130	36	localJSONArray2	org.json.JSONArray
    //   314	207	37	localJSONArray3	org.json.JSONArray
    //   295	228	38	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	28	710	java/lang/Throwable
    //   29	45	710	java/lang/Throwable
    //   665	690	710	java/lang/Throwable
    //   690	709	710	java/lang/Throwable
    //   753	780	710	java/lang/Throwable
    //   804	885	710	java/lang/Throwable
    //   8	28	731	finally
    //   29	45	731	finally
    //   665	690	731	finally
    //   690	709	731	finally
    //   711	730	731	finally
    //   753	780	731	finally
    //   804	885	731	finally
    //   45	115	752	finally
    //   120	218	752	finally
    //   227	275	752	finally
    //   278	327	752	finally
    //   332	421	752	finally
    //   424	473	752	finally
    //   520	528	752	finally
    //   540	549	752	finally
    //   567	621	752	finally
    //   626	647	752	finally
    //   647	665	752	finally
    //   740	749	752	finally
    //   780	789	752	finally
    //   792	801	752	finally
  }
  
  public void reportLocal(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString3 == null))
    {
      c.e("Matrix.MatrixReport", "Matrix reportLocal, tag %s or data %s is null, just return", new Object[] { paramString1, paramString3 });
      return;
    }
    if (!this.isReportProcess)
    {
      c.e("Matrix.MatrixReport", "Matrix reportLocal, only report process can report directly, current:%s", new Object[] { this.processName });
      return;
    }
    localObject2 = null;
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString3);
      }
      catch (JSONException localJSONException1)
      {
        Object localObject1;
        String str;
        int i;
        paramString2 = (String)localObject2;
        ab.printErrStackTrace("Matrix.MatrixReport", localJSONException1, "data:%s", new Object[] { paramString2.toString() });
        bool = true;
        continue;
      }
      try
      {
        localObject1 = paramString2.getString("tag");
        if (!((String)localObject1).equalsIgnoreCase("Trace_EvilMethod")) {
          continue;
        }
        if (!paramString2.getString("detail").equalsIgnoreCase(a.a.bRc.toString())) {
          break label334;
        }
        bool = bo.isNullOrNil(paramString2.getString("stackKey"));
        if (bool) {
          continue;
        }
        bool = true;
      }
      catch (JSONException localJSONException2)
      {
        continue;
        bool = true;
        continue;
        bool = true;
        continue;
      }
      c.i("Matrix.MatrixReport", "Matrix reportLocal tag:%s, data:%s ClientVersion:%s isRealReportForMatrix:%s", new Object[] { paramString1, paramString3, Integer.valueOf(com.tencent.mm.protocal.d.whH), Boolean.valueOf(bool) });
      if (bool) {
        MrsLogic.collectData(paramString1, paramString2.toString().getBytes());
      }
      this.matrixIdKeyReporter.report(paramString1, paramString2);
      return;
      bool = false;
      continue;
      if (!((String)localObject1).equalsIgnoreCase("Trace_FPS")) {
        break label328;
      }
      str = paramString2.getString("scene");
      localObject2 = (Integer)this.reportFps.get(str);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Integer.valueOf(0);
      }
      localObject2 = this.reportFps;
      localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1);
      ((HashMap)localObject2).put(str, localObject1);
      i = ((Integer)localObject1).intValue();
      if (i <= 30) {
        break label328;
      }
      bool = false;
    }
  }
  
  public void setUin(long paramLong)
  {
    this.uin = paramLong;
    if (this.isReportProcess) {
      MrsLogic.setUin(paramLong);
    }
  }
  
  public static class Builder
  {
    private Long clientVersion;
    private final Context context;
    private Boolean isDebug;
    private Boolean isReportProcess;
    private String processName;
    private Long publishType;
    private String revision;
    
    public Builder(Context paramContext)
    {
      if (paramContext == null) {
        throw new RuntimeException("matrix report init, context is null");
      }
      this.context = paramContext;
    }
    
    public MatrixReport build()
    {
      if (this.processName == null) {
        throw new RuntimeException("matrix report init, processName is null");
      }
      if (this.clientVersion == null) {
        throw new RuntimeException("matrix report init, clientVersion is null");
      }
      if (this.revision == null) {
        throw new RuntimeException("matrix report init, revision is null");
      }
      if (this.publishType == null) {
        throw new RuntimeException("matrix report init, publishType is null");
      }
      if (this.isDebug == null) {
        this.isDebug = Boolean.FALSE;
      }
      if (this.isReportProcess == null) {
        this.isReportProcess = Boolean.FALSE;
      }
      return new MatrixReport(this.context, this.processName, this.clientVersion.longValue(), this.revision, this.isDebug.booleanValue(), this.isReportProcess.booleanValue(), this.publishType.longValue(), null);
    }
    
    public Builder clientVersion(long paramLong)
    {
      this.clientVersion = Long.valueOf(paramLong);
      return this;
    }
    
    public Builder isDebug(boolean paramBoolean)
    {
      this.isDebug = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public Builder isReportProcess(boolean paramBoolean)
    {
      this.isReportProcess = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public Builder processName(String paramString)
    {
      this.processName = paramString;
      return this;
    }
    
    public Builder publishType(long paramLong)
    {
      this.publishType = Long.valueOf(paramLong);
      return this;
    }
    
    public Builder revision(String paramString)
    {
      this.revision = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MatrixReport
 * JD-Core Version:    0.7.0.1
 */