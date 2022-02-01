package oicq.wlogin_sdk.listener;

import android.content.Context;

public abstract interface PrivacyListener
{
  public abstract String getAndroidID(Context paramContext);
  
  public abstract String getBssid(Context paramContext);
  
  public abstract String getDeviceModel();
  
  public abstract String getImsi(Context paramContext);
  
  public abstract String getMac(Context paramContext);
  
  public abstract String getSsid(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.listener.PrivacyListener
 * JD-Core Version:    0.7.0.1
 */