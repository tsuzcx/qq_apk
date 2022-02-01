package com.tencent.luggage.sdk.launching;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActivityStarterIpcDelegate
  implements Parcelable
{
  public static final Parcelable.Creator<ActivityStarterIpcDelegate> CREATOR;
  public final ResultReceiver chN;
  
  static
  {
    AppMethodBeat.i(146870);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146870);
  }
  
  public ActivityStarterIpcDelegate(final Activity paramActivity)
  {
    AppMethodBeat.i(146867);
    this.chN = new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(146864);
        super.onReceiveResult(paramAnonymousInt, paramAnonymousBundle);
        if ((4660 == paramAnonymousInt) && (paramAnonymousBundle != null))
        {
          Object localObject = (Intent)paramAnonymousBundle.getParcelable("intent");
          if (localObject != null)
          {
            ((Intent)localObject).setFlags(((Intent)localObject).getFlags() & 0xEFFFFFFF);
            paramAnonymousBundle = paramActivity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate$1", "onReceiveResult", "(ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousBundle, "com/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate$1", "onReceiveResult", "(ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(146864);
      }
    };
    AppMethodBeat.o(146867);
  }
  
  private ActivityStarterIpcDelegate(Parcel paramParcel)
  {
    AppMethodBeat.i(146869);
    this.chN = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    AppMethodBeat.o(146869);
  }
  
  public static ActivityStarterIpcDelegate ay(Context paramContext)
  {
    AppMethodBeat.i(146866);
    if ((paramContext instanceof Activity))
    {
      paramContext = new ActivityStarterIpcDelegate((Activity)paramContext);
      AppMethodBeat.o(146866);
      return paramContext;
    }
    AppMethodBeat.o(146866);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146868);
    this.chN.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(146868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate
 * JD-Core Version:    0.7.0.1
 */