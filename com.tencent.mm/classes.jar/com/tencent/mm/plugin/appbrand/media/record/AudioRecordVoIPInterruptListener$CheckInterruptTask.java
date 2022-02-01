package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;

class AudioRecordVoIPInterruptListener$CheckInterruptTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
  private boolean lsq;
  private e lsu;
  
  static
  {
    AppMethodBeat.i(47589);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47589);
  }
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47585);
    this.lsq = false;
    e(paramParcel);
    AppMethodBeat.o(47585);
  }
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(e parame)
  {
    this.lsq = false;
    this.lsu = parame;
  }
  
  public final void aLq()
  {
    boolean bool1 = false;
    AppMethodBeat.i(47586);
    this.lsq = false;
    xg localxg = new xg();
    com.tencent.mm.sdk.b.a.GpY.l(localxg);
    boolean bool3 = localxg.dzZ.cYY;
    boolean bool2 = com.tencent.mm.r.a.aaZ();
    ac.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b, isAppBrandVoiceUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.r.a.abb()) });
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    this.lsq = bool1;
    bet();
    AppMethodBeat.o(47586);
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(47587);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.lsq = bool;
      AppMethodBeat.o(47587);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47588);
    if (this.lsq) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(47588);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.CheckInterruptTask
 * JD-Core Version:    0.7.0.1
 */