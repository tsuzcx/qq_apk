package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener
  implements f
{
  private boolean bSr = false;
  private e gNW;
  private AudioRecordVoIPInterruptListener.CheckInterruptTask gOh;
  private StartInterruptEventListenTask gOi;
  private AudioRecordVoIPInterruptListener.StopInterruptEventListenTask gOj;
  
  public final void a(e parame)
  {
    this.gNW = parame;
  }
  
  public final boolean amj()
  {
    if (this.gNW == null)
    {
      y.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      return false;
    }
    if (this.gOh == null) {
      this.gOh = new AudioRecordVoIPInterruptListener.CheckInterruptTask(this.gNW);
    }
    AppBrandMainProcessService.b(this.gOh);
    y.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.gOh)) });
    return AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.gOh);
  }
  
  public final void amk()
  {
    if (this.gNW == null)
    {
      y.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      return;
    }
    if (this.gOi == null) {
      this.gOi = new StartInterruptEventListenTask(this.gNW);
    }
    this.bSr = true;
    AppBrandMainProcessService.a(this.gOi);
  }
  
  public final void aml()
  {
    if (!this.bSr)
    {
      y.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      return;
    }
    this.bSr = false;
    if (this.gOj == null) {
      this.gOj = new AudioRecordVoIPInterruptListener.StopInterruptEventListenTask();
    }
    AppBrandMainProcessService.b(this.gOj);
  }
  
  private static class StartInterruptEventListenTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartInterruptEventListenTask> CREATOR = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.1();
    private e gNW;
    private int gOm = -1;
    private final c gOn = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.2(this);
    private final c gOo = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.3(this);
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      e(paramParcel);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      this.gNW = parame;
    }
    
    public final void Zu()
    {
      y.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!a.udP.e(this.gOn))
      {
        a.udP.c(this.gOn);
        AudioRecordVoIPInterruptListener.a.amu();
        AudioRecordVoIPInterruptListener.a.a(this.gOn);
      }
      if (!a.udP.e(this.gOo))
      {
        a.udP.c(this.gOo);
        AudioRecordVoIPInterruptListener.a.amu();
        AudioRecordVoIPInterruptListener.a.a(this.gOo);
      }
    }
    
    public final void Zv()
    {
      if (this.gNW != null)
      {
        if (this.gOm != 11) {
          break label38;
        }
        y.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.gNW.ami();
      }
      for (;;)
      {
        this.gOm = -1;
        return;
        label38:
        if (this.gOm == 3)
        {
          y.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.gNW.amh();
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      this.gOm = paramParcel.readInt();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.gOm);
    }
  }
  
  private static class a
  {
    private static a gOk;
    LinkedList<c<b>> gOl = new LinkedList();
    
    public static void a(c<b> paramc)
    {
      try
      {
        amu().gOl.add(paramc);
        return;
      }
      finally {}
    }
    
    public static a amu()
    {
      if (gOk == null) {}
      try
      {
        if (gOk == null) {
          gOk = new a();
        }
        return gOk;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */