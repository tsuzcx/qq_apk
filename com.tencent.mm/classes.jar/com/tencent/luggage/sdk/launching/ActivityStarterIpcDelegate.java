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
  private final ResultReceiver cBu;
  
  static
  {
    AppMethodBeat.i(146870);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146870);
  }
  
  public ActivityStarterIpcDelegate(final Activity paramActivity)
  {
    AppMethodBeat.i(146867);
    this.cBu = new ResultReceiver(new Handler(Looper.getMainLooper()))
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate$1", "onReceiveResult", "(ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
    this.cBu = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    AppMethodBeat.o(146869);
  }
  
  public static ActivityStarterIpcDelegate aJ(Context paramContext)
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
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(229863);
    if (paramIntent == null)
    {
      AppMethodBeat.o(229863);
      return;
    }
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("intent", paramIntent);
    this.cBu.send(4660, localBundle);
    AppMethodBeat.o(229863);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146868);
    this.cBu.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(146868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate
 * JD-Core Version:    0.7.0.1
 */