package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

class AudioRecordVoIPInterruptListener$CheckInterruptTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
  private boolean ndC;
  private e ndG;
  
  static
  {
    AppMethodBeat.i(47589);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47589);
  }
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47585);
    this.ndC = false;
    f(paramParcel);
    AppMethodBeat.o(47585);
  }
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(e parame)
  {
    this.ndC = false;
    this.ndG = parame;
  }
  
  public final void bjj()
  {
    boolean bool1 = false;
    AppMethodBeat.i(47586);
    this.ndC = false;
    zi localzi = new zi();
    EventCenter.instance.publish(localzi);
    boolean bool3 = localzi.efv.dCI;
    boolean bool2 = a.att();
    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b, isAppBrandVoiceUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(a.atw()) });
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    this.ndC = bool1;
    bDU();
    AppMethodBeat.o(47586);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(47587);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ndC = bool;
      AppMethodBeat.o(47587);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47588);
    if (this.ndC) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(47588);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.CheckInterruptTask
 * JD-Core Version:    0.7.0.1
 */