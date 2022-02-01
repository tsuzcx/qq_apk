package com.tencent.mobileqq.activity.photo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public class PeakService
  extends IntentService
{
  public static final int a = 1;
  public static final String a = "CompressCallback";
  public static final String b = "PicOperator";
  public static final String c = "CompressInfo";
  public static final String d = "ServiceAction";
  private static final String e = "PeakService";
  
  public PeakService()
  {
    super("PeakService");
  }
  
  public void a(CompressInfo paramCompressInfo, ICompressionCallBack paramICompressionCallBack)
  {
    CompressOperator.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramICompressionCallBack != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramICompressionCallBack.a(paramCompressInfo);
    }
    for (;;)
    {
      paramICompressionCallBack.c(paramCompressInfo);
      return;
      label64:
      paramICompressionCallBack.b(paramCompressInfo);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      Parcelable localParcelable;
      do
      {
        return;
        if (paramIntent.getIntExtra("ServiceAction", -1) != 1) {
          break;
        }
        localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        paramIntent = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
      } while ((!(localParcelable instanceof CompressInfo)) || (paramIntent == null));
      paramIntent = ICompressionCallBack.Stub.a(paramIntent.a);
      a((CompressInfo)localParcelable, paramIntent);
      return;
      paramIntent = ThreadManager.a();
    } while (paramIntent == null);
    paramIntent.removeCallbacks(FileUtils.a);
    paramIntent.postDelayed(FileUtils.a, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */