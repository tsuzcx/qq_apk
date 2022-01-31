package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

class AudioRecordVoIPInterruptListener$StopInterruptEventListenTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<StopInterruptEventListenTask> CREATOR;
  
  static
  {
    AppMethodBeat.i(132186);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(132186);
  }
  
  public AudioRecordVoIPInterruptListener$StopInterruptEventListenTask() {}
  
  public AudioRecordVoIPInterruptListener$StopInterruptEventListenTask(Parcel paramParcel)
  {
    AppMethodBeat.i(132184);
    f(paramParcel);
    AppMethodBeat.o(132184);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(132185);
    ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
    AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.aHZ();
    try
    {
      Iterator localIterator = locala.ipW.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        a.ymk.d(localc);
      }
      localObject.ipW.clear();
    }
    finally
    {
      AppMethodBeat.o(132185);
    }
    AppMethodBeat.o(132185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.StopInterruptEventListenTask
 * JD-Core Version:    0.7.0.1
 */