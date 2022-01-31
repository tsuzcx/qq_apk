package com.tencent.luggage.sdk.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActivityStarterIpcDelegate
  implements Parcelable
{
  public static final Parcelable.Creator<ActivityStarterIpcDelegate> CREATOR;
  public final ResultReceiver bES;
  
  static
  {
    AppMethodBeat.i(101668);
    CREATOR = new ActivityStarterIpcDelegate.2();
    AppMethodBeat.o(101668);
  }
  
  public ActivityStarterIpcDelegate(Activity paramActivity)
  {
    AppMethodBeat.i(101665);
    this.bES = new ActivityStarterIpcDelegate.1(this, new Handler(Looper.getMainLooper()), paramActivity);
    AppMethodBeat.o(101665);
  }
  
  private ActivityStarterIpcDelegate(Parcel paramParcel)
  {
    AppMethodBeat.i(101667);
    this.bES = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    AppMethodBeat.o(101667);
  }
  
  public static ActivityStarterIpcDelegate as(Context paramContext)
  {
    AppMethodBeat.i(101664);
    if ((paramContext instanceof Activity))
    {
      paramContext = new ActivityStarterIpcDelegate((Activity)paramContext);
      AppMethodBeat.o(101664);
      return paramContext;
    }
    AppMethodBeat.o(101664);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101666);
    this.bES.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(101666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate
 * JD-Core Version:    0.7.0.1
 */