package com.tencent.matrix.mrs.core;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.strategy.c.a;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.o;

public abstract class MatrixStrategyCaller
  implements MrsCallback
{
  private static final int BYTE_DATA_REPORT_NEW_TYPE = 111;
  private static final int BYTE_DATA_REPORT_TYPE = 1;
  private static final int FILE_REPORT_TYPE = 19860829;
  private static final String TAG = "Matrix.MatrixStrategyCaller";
  
  public String getCryptKey(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    return com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.KyO), Long.valueOf(paramMatrixUploadDataSlice.getDataSize()) }).getBytes()).toLowerCase();
  }
  
  public String getHost(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    return WeChatHosts.domainString(2131761742);
  }
  
  public String getPublicSharePath()
  {
    try
    {
      Object localObject = o.X(MMApplicationContext.getContext().getFilesDir());
      if (!((o)localObject).exists()) {
        ((o)localObject).createNewFile();
      }
      localObject = ((o)localObject).toString();
      com.tencent.matrix.g.c.i("Matrix.MatrixStrategyCaller", "[TEST-PATH] getPublicSharePath, path: %s", new Object[] { localObject });
      localObject = (String)localObject + "/mrs/";
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("Matrix.MatrixStrategyCaller", localException.toString());
    }
    return "";
  }
  
  public String getUrl(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    String str = com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.KyO), Long.valueOf(paramMatrixUploadDataSlice.getDataSize()) }).getBytes()).toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder(512).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.KyO)).append("&devicetype=").append("android-" + Build.VERSION.SDK_INT).append("&filelength=").append(paramMatrixUploadDataSlice.getDataSize()).append("&sum=").append(str);
    long l;
    if ((MMApplicationContext.isMMProcess()) && (com.tencent.mm.kernel.g.aAc()))
    {
      str = z.aTY();
      if ((str != null) && (str.length() != 0)) {
        localStringBuilder.append("&username=").append(str);
      }
      if (1 != paramMatrixUploadDataSlice.getUploadIssue().getDataType()) {
        break label282;
      }
      if (paramMatrixUploadDataSlice.getUploadIssue().getId() >= 0L) {
        break label271;
      }
      l = -1L * paramMatrixUploadDataSlice.getUploadIssue().getId();
      label191:
      str = l + '.' + paramMatrixUploadDataSlice.getPackageIndex() + '.' + paramMatrixUploadDataSlice.getTotalPackage();
      localStringBuilder.append("&reporttype=19860829&reportvalue=").append(str).append("&rtxname=").append(paramMatrixUploadDataSlice.getUploadIssue().getTag());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      str = null;
      break;
      label271:
      l = paramMatrixUploadDataSlice.getUploadIssue().getId();
      break label191;
      label282:
      localStringBuilder.append("&reporttype=1&NewReportType=111");
    }
  }
  
  public boolean onRequestGetMrsStrategy(byte[] paramArrayOfByte)
  {
    try
    {
      if (!com.tencent.mm.kernel.g.aAc())
      {
        Log.e("Matrix.MatrixStrategyCaller", "onRequestGetMrsStrategy, account not ready");
        return false;
      }
      try
      {
        if (com.tencent.matrix.strategy.c.isRunning())
        {
          Log.i("Matrix.MatrixStrategyCaller", "NetSceneGetMatrixStrategy is already running, just return");
          return false;
        }
      }
      finally {}
      Log.i("Matrix.MatrixStrategyCaller", "onRequestGetMrsStrategy, try to request mrs strategy");
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("Matrix.MatrixStrategyCaller", "error: " + paramArrayOfByte.getMessage());
      return false;
    }
    paramArrayOfByte = new com.tencent.matrix.strategy.c(paramArrayOfByte, new c.a()
    {
      public void onStrategyResp(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        MrsLogic.onStrategyResp(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
      }
    });
    com.tencent.mm.kernel.g.aAg().hqi.a(paramArrayOfByte, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MatrixStrategyCaller
 * JD-Core Version:    0.7.0.1
 */