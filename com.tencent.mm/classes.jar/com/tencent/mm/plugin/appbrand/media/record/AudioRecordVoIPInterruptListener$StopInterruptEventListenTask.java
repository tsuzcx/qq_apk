package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

class AudioRecordVoIPInterruptListener$StopInterruptEventListenTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<StopInterruptEventListenTask> CREATOR = new Parcelable.Creator() {};
  
  public AudioRecordVoIPInterruptListener$StopInterruptEventListenTask() {}
  
  public AudioRecordVoIPInterruptListener$StopInterruptEventListenTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
    AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.amu();
    try
    {
      Iterator localIterator = locala.gOl.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        a.udP.d(localc);
      }
      localObject.gOl.clear();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.StopInterruptEventListenTask
 * JD-Core Version:    0.7.0.1
 */