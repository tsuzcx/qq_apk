package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.y;

class AudioRecordVoIPInterruptListener$CheckInterruptTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CheckInterruptTask> CREATOR = new Parcelable.Creator() {};
  private boolean gNS = false;
  private e gNW;
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public AudioRecordVoIPInterruptListener$CheckInterruptTask(e parame)
  {
    this.gNW = parame;
  }
  
  public final void Zu()
  {
    boolean bool1 = false;
    this.gNS = false;
    boolean bool3 = com.tencent.mm.plugin.voip.e.bPA();
    boolean bool2 = a.Bv();
    y.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    this.gNS = bool1;
    ahI();
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.gNS = bool;
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.gNS) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.CheckInterruptTask
 * JD-Core Version:    0.7.0.1
 */