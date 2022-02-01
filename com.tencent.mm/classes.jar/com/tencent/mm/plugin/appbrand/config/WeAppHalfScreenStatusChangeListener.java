package com.tencent.mm.plugin.appbrand.config;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "resultReceiver", "Landroid/os/ResultReceiver;", "describeContents", "", "notifyEnterFullScreen", "", "notifyEnterHalfScreen", "onEnterFullScreen", "onEnterHalfScreen", "writeToParcel", "flags", "CREATOR", "data-model_release"})
public class WeAppHalfScreenStatusChangeListener
  implements Parcelable
{
  public static final a CREATOR;
  public ResultReceiver cAX;
  
  static
  {
    AppMethodBeat.i(186674);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(186674);
  }
  
  public WeAppHalfScreenStatusChangeListener()
  {
    AppMethodBeat.i(186671);
    this.cAX = ((ResultReceiver)new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        paramAnonymousInt = -1;
        AppMethodBeat.i(187012);
        if (paramAnonymousBundle != null) {
          paramAnonymousInt = paramAnonymousBundle.getInt("Status", -1);
        }
        if (paramAnonymousInt == 1)
        {
          this.oam.bLx();
          AppMethodBeat.o(187012);
          return;
        }
        if (paramAnonymousInt == 0) {
          this.oam.bLy();
        }
        AppMethodBeat.o(187012);
      }
    });
    AppMethodBeat.o(186671);
  }
  
  public WeAppHalfScreenStatusChangeListener(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(186673);
    this.cAX = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    AppMethodBeat.o(186673);
  }
  
  public void bLx() {}
  
  public void bLy() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(186653);
    p.k(paramParcel, "parcel");
    ResultReceiver localResultReceiver = this.cAX;
    if (localResultReceiver != null)
    {
      localResultReceiver.writeToParcel(paramParcel, paramInt);
      AppMethodBeat.o(186653);
      return;
    }
    AppMethodBeat.o(186653);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "data-model_release"})
  public static final class a
    implements Parcelable.Creator<WeAppHalfScreenStatusChangeListener>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener
 * JD-Core Version:    0.7.0.1
 */