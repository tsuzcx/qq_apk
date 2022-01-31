package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;

public class ActivityStarterIpcDelegate
  implements Parcelable
{
  public static final Parcelable.Creator<ActivityStarterIpcDelegate> CREATOR = new ActivityStarterIpcDelegate.2();
  public final ResultReceiver gIT;
  
  public ActivityStarterIpcDelegate(final Activity paramActivity)
  {
    this.gIT = new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        super.onReceiveResult(paramAnonymousInt, paramAnonymousBundle);
        if ((4660 == paramAnonymousInt) && (paramAnonymousBundle != null))
        {
          paramAnonymousBundle = (Intent)paramAnonymousBundle.getParcelable("intent");
          if (paramAnonymousBundle != null)
          {
            paramAnonymousBundle.setFlags(paramAnonymousBundle.getFlags() & 0xEFFFFFFF);
            paramActivity.startActivity(paramAnonymousBundle);
          }
        }
      }
    };
  }
  
  private ActivityStarterIpcDelegate(Parcel paramParcel)
  {
    this.gIT = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
  }
  
  public static ActivityStarterIpcDelegate cq(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return new ActivityStarterIpcDelegate((Activity)paramContext);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.gIT.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ActivityStarterIpcDelegate
 * JD-Core Version:    0.7.0.1
 */