package com.tencent.mobileqq.activity.flaotaio;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;

public class FloatHongbaoItemBuilder$HongbaoResultReceiver
  extends ResultReceiver
{
  public FloatHongbaoItemBuilder$HongbaoResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    Log.i("app2", "HongbaoResultReceiver-->onReceiveResult");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatHongbaoItemBuilder.HongbaoResultReceiver
 * JD-Core Version:    0.7.0.1
 */