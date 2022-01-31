package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

public final class zzff
  extends BaseGmsClient<zzey>
{
  public zzff(Context paramContext, Looper paramLooper, BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 93, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, null);
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.measurement.START";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzff
 * JD-Core Version:    0.7.0.1
 */