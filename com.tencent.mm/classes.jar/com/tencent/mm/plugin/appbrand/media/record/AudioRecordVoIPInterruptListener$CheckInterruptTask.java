package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

class AudioRecordVoIPInterruptListener$CheckInterruptTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
  private boolean ipE;
  private e ipH;
  
  static
  {
    AppMethodBeat.i(132164);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(132164);
  }
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(Parcel paramParcel)
  {
    AppMethodBeat.i(132160);
    this.ipE = false;
    f(paramParcel);
    AppMethodBeat.o(132160);
  }
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(e parame)
  {
    this.ipE = false;
    this.ipH = parame;
  }
  
  public final void ata()
  {
    boolean bool1 = false;
    AppMethodBeat.i(132161);
    this.ipE = false;
    uw localuw = new uw();
    com.tencent.mm.sdk.b.a.ymk.l(localuw);
    boolean bool3 = localuw.cLo.cLr;
    boolean bool2 = com.tencent.mm.r.a.Ok();
    ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    this.ipE = bool1;
    aBp();
    AppMethodBeat.o(132161);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(132162);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ipE = bool;
      AppMethodBeat.o(132162);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(132163);
    if (this.ipE) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(132163);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.CheckInterruptTask
 * JD-Core Version:    0.7.0.1
 */