package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

class AudioRecordVoIPInterruptListener$StartInterruptEventListenTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<StartInterruptEventListenTask> CREATOR;
  private int lsK;
  private final c lsL;
  private final c lsM;
  private e lsu;
  
  static
  {
    AppMethodBeat.i(47605);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47605);
  }
  
  public AudioRecordVoIPInterruptListener$StartInterruptEventListenTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47597);
    this.lsK = -1;
    this.lsL = new c() {};
    this.lsM = new c() {};
    e(paramParcel);
    AppMethodBeat.o(47597);
  }
  
  public AudioRecordVoIPInterruptListener$StartInterruptEventListenTask(e parame)
  {
    AppMethodBeat.i(47596);
    this.lsK = -1;
    this.lsL = new c() {};
    this.lsM = new c() {};
    this.lsu = parame;
    AppMethodBeat.o(47596);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(47598);
    ac.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
    if (!a.GpY.e(this.lsL))
    {
      a.GpY.c(this.lsL);
      AudioRecordVoIPInterruptListener.a.boU();
      AudioRecordVoIPInterruptListener.a.a(this.lsL);
    }
    if (!a.GpY.e(this.lsM))
    {
      a.GpY.c(this.lsM);
      AudioRecordVoIPInterruptListener.a.boU();
      AudioRecordVoIPInterruptListener.a.a(this.lsM);
    }
    AppMethodBeat.o(47598);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(47599);
    if (this.lsu != null)
    {
      if (this.lsK != 11) {
        break label48;
      }
      ac.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
      this.lsu.boJ();
    }
    for (;;)
    {
      this.lsK = -1;
      AppMethodBeat.o(47599);
      return;
      label48:
      if (this.lsK == 3)
      {
        ac.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
        this.lsu.boI();
      }
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(47600);
    this.lsK = paramParcel.readInt();
    AppMethodBeat.o(47600);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47601);
    paramParcel.writeInt(this.lsK);
    AppMethodBeat.o(47601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.StartInterruptEventListenTask
 * JD-Core Version:    0.7.0.1
 */