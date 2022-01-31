package com.tencent.matrix.mrs.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mrs.a.c;
import com.tencent.mrs.util.MatrixReportBroadcast;
import com.tencent.mrs.util.MatrixStrategyNotifyBroadcast;
import java.io.File;
import org.json.JSONObject;

public class MatrixReport
{
  private static final String TAG = "Matrix.MatrixReport";
  private static MrsCallback mrsCallback;
  private static volatile MatrixReport sInstance;
  private final long clientVersion;
  private final Context context;
  private final boolean isDebug;
  private final boolean isReportProcess;
  private final String processName;
  private final String revision;
  private long uin = 0L;
  
  private MatrixReport(Context paramContext, String paramString1, long paramLong, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.clientVersion = paramLong;
    this.revision = paramString2;
    this.isDebug = paramBoolean1;
    this.context = paramContext;
    this.processName = paramString1;
    this.isReportProcess = paramBoolean2;
    if (paramBoolean2) {
      try
      {
        MrsLogic.init(paramLong, paramString2, paramBoolean1);
        return;
      }
      catch (Throwable paramContext)
      {
        com.tencent.matrix.d.b.printErrStackTrace("Matrix.MatrixReport", paramContext, "call oncreate err", new Object[0]);
        MrsLogic.init(paramLong, paramString2, paramBoolean1);
        return;
      }
    }
    paramString1 = new IntentFilter();
    paramString1.addAction("strategyNotify");
    paramContext.registerReceiver(new MatrixStrategyNotifyBroadcast(), paramString1, "com.tencent.mm.matrix.strategynotify", null);
  }
  
  public static MrsCallback getMrsCallback()
  {
    return mrsCallback;
  }
  
  /* Error */
  public static MatrixReport init(MatrixReport paramMatrixReport)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 93	java/lang/RuntimeException
    //   7: dup
    //   8: ldc 95
    //   10: invokespecial 97	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 99	com/tencent/matrix/mrs/core/MatrixReport:sInstance	Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: putstatic 99	com/tencent/matrix/mrs/core/MatrixReport:sInstance	Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   27: ldc 2
    //   29: monitorexit
    //   30: getstatic 99	com/tencent/matrix/mrs/core/MatrixReport:sInstance	Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   33: areturn
    //   34: ldc 13
    //   36: ldc 101
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 105	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: goto -18 -> 27
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramMatrixReport	MatrixReport
    // Exception table:
    //   from	to	target	type
    //   17	27	48	finally
    //   27	30	48	finally
    //   34	45	48	finally
    //   49	52	48	finally
  }
  
  public static boolean isInstalled()
  {
    return sInstance != null;
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
    if (this.isReportProcess) {
      MrsLogic.onForeground(paramBoolean);
    }
  }
  
  public void onReportResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    MrsLogic.onReportResp(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void onStrategyResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    MrsLogic.onStrategyResp(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void report(com.tencent.matrix.c.b paramb, File paramFile)
  {
    c.a(paramb, paramFile, true);
  }
  
  public void report(com.tencent.matrix.c.b paramb, File paramFile, boolean paramBoolean)
  {
    if ((paramb != null) && (paramFile != null)) {}
    try
    {
      if (!paramFile.exists())
      {
        com.tencent.matrix.d.b.e("Matrix.MatrixReport", "Matrix report, tag %s or file %s is null, just return", new Object[] { paramb, paramFile });
        return;
      }
      c.a(paramb, paramFile, paramBoolean);
      return;
    }
    catch (Throwable paramb)
    {
      com.tencent.matrix.d.b.e("Matrix.MatrixReport", "Matrix report occur error:" + paramb, new Object[0]);
    }
  }
  
  public void report(String paramString, JSONObject paramJSONObject)
  {
    if ((paramString == null) || (paramJSONObject == null)) {}
    try
    {
      com.tencent.matrix.d.b.e("Matrix.MatrixReport", "Matrix report, tag %s or data %s is null, just return", new Object[] { paramString, paramJSONObject });
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.matrix.d.b.e("Matrix.MatrixReport", "Matrix report occur error:" + paramString, new Object[0]);
      return;
    }
    if (this.isReportProcess)
    {
      with().reportLocal(paramString, paramJSONObject.toString());
      return;
    }
    Intent localIntent = new Intent(this.context, MatrixReportBroadcast.class);
    localIntent.putExtra("tag", paramString);
    localIntent.putExtra("value", paramJSONObject.toString());
    com.tencent.matrix.d.b.i("Matrix.MatrixReport", "Matrix report with broadcast tag:%s, data:%s", new Object[] { paramString, paramJSONObject.toString() });
    this.context.sendBroadcast(localIntent);
  }
  
  public void reportLocal(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      com.tencent.matrix.d.b.e("Matrix.MatrixReport", "Matrix reportLocal, tag %s or data %s is null, just return", new Object[] { paramString1, paramString2 });
      return;
    }
    if (!this.isReportProcess)
    {
      com.tencent.matrix.d.b.e("Matrix.MatrixReport", "Matrix reportLocal, only report process can report directly, current:%s", new Object[] { this.processName });
      return;
    }
    com.tencent.matrix.d.b.i("Matrix.MatrixReport", "Matrix reportLocal tag:%s, data:%s", new Object[] { paramString1, paramString2.toString() });
    MrsLogic.collectData(paramString1, paramString2.getBytes());
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
      if (this.isDebug == null) {
        this.isDebug = Boolean.valueOf(false);
      }
      if (this.isReportProcess == null) {
        this.isReportProcess = Boolean.valueOf(false);
      }
      return new MatrixReport(this.context, this.processName, this.clientVersion.longValue(), this.revision, this.isDebug.booleanValue(), this.isReportProcess.booleanValue(), null);
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