package com.tencent.matrix.mrs.core;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;

public abstract class MatrixStrategyCaller
  implements MrsCallback
{
  private static final int BYTE_DATA_REPORT_NEW_TYPE = 111;
  private static final int BYTE_DATA_REPORT_TYPE = 1;
  private static final int FILE_REPORT_TYPE = 19860829;
  private static final String TAG = "Matrix.MatrixStrategyCaller";
  
  public String getCryptKey(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    return com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.CpK), Long.valueOf(paramMatrixUploadDataSlice.getDataSize()) }).getBytes()).toLowerCase();
  }
  
  public String getHost(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    return "support.weixin.qq.com";
  }
  
  public String getPublicSharePath()
  {
    try
    {
      Object localObject = e.R(aj.getContext().getFilesDir());
      if (!((e)localObject).exists()) {
        ((e)localObject).createNewFile();
      }
      localObject = ((e)localObject).toString();
      com.tencent.matrix.g.c.i("Matrix.MatrixStrategyCaller", "[TEST-PATH] getPublicSharePath, path: %s", new Object[] { localObject });
      localObject = (String)localObject + "/mrs/";
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("Matrix.MatrixStrategyCaller", localException.toString());
    }
    return "";
  }
  
  public String getUrl(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    String str = com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.CpK), Long.valueOf(paramMatrixUploadDataSlice.getDataSize()) }).getBytes()).toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder(512).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.CpK)).append("&devicetype=").append("android-" + Build.VERSION.SDK_INT).append("&filelength=").append(paramMatrixUploadDataSlice.getDataSize()).append("&sum=").append(str);
    long l;
    if ((aj.cbv()) && (com.tencent.mm.kernel.g.afw()))
    {
      str = u.aqG();
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
      if (!com.tencent.mm.kernel.g.afw())
      {
        ad.e("Matrix.MatrixStrategyCaller", "onRequestGetMrsStrategy, account not ready");
        return false;
      }
      try
      {
        if (com.tencent.matrix.strategy.c.isRunning())
        {
          ad.i("Matrix.MatrixStrategyCaller", "NetSceneGetMatrixStrategy is already running, just return");
          return false;
        }
      }
      finally {}
      ad.i("Matrix.MatrixStrategyCaller", "onRequestGetMrsStrategy, try to request mrs strategy");
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("Matrix.MatrixStrategyCaller", "error: " + paramArrayOfByte.getMessage());
      return false;
    }
    paramArrayOfByte = new com.tencent.matrix.strategy.c(paramArrayOfByte, new MatrixStrategyCaller.1(this));
    com.tencent.mm.kernel.g.afA().gcy.a(paramArrayOfByte, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MatrixStrategyCaller
 * JD-Core Version:    0.7.0.1
 */