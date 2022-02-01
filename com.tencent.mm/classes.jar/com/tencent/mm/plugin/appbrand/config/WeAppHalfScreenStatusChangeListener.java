package com.tencent.mm.plugin.appbrand.config;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "resultReceiver", "Landroid/os/ResultReceiver;", "describeContents", "", "notifyEnterFullScreen", "", "notifyEnterHalfScreen", "onEnterFullScreen", "onEnterHalfScreen", "writeToParcel", "flags", "CREATOR", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WeAppHalfScreenStatusChangeListener
  implements Parcelable
{
  public static final a CREATOR;
  public ResultReceiver ett;
  
  static
  {
    AppMethodBeat.i(323298);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(323298);
  }
  
  public WeAppHalfScreenStatusChangeListener()
  {
    AppMethodBeat.i(323296);
    this.ett = ((ResultReceiver)new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        paramAnonymousInt = -1;
        AppMethodBeat.i(323367);
        if (paramAnonymousBundle == null) {
          switch (paramAnonymousInt)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(323367);
          return;
          paramAnonymousInt = paramAnonymousBundle.getInt("Status", -1);
          break;
          this.raP.ckU();
          AppMethodBeat.o(323367);
          return;
          this.raP.ckV();
        }
      }
    });
    AppMethodBeat.o(323296);
  }
  
  public WeAppHalfScreenStatusChangeListener(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(323297);
    this.ett = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    AppMethodBeat.o(323297);
  }
  
  public void ckU() {}
  
  public void ckV() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323299);
    s.u(paramParcel, "parcel");
    ResultReceiver localResultReceiver = this.ett;
    if (localResultReceiver != null) {
      localResultReceiver.writeToParcel(paramParcel, paramInt);
    }
    AppMethodBeat.o(323299);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<WeAppHalfScreenStatusChangeListener>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener
 * JD-Core Version:    0.7.0.1
 */