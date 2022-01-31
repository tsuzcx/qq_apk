package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener
  implements f
{
  private e ipH;
  private AudioRecordVoIPInterruptListener.CheckInterruptTask ipS;
  private StartInterruptEventListenTask ipT;
  private AudioRecordVoIPInterruptListener.StopInterruptEventListenTask ipU;
  private boolean isStart = false;
  
  public final void a(e parame)
  {
    this.ipH = parame;
  }
  
  public final boolean aHQ()
  {
    AppMethodBeat.i(132187);
    if (this.ipH == null)
    {
      ab.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(132187);
      return false;
    }
    if (this.ipS == null) {
      this.ipS = new AudioRecordVoIPInterruptListener.CheckInterruptTask(this.ipH);
    }
    AppBrandMainProcessService.b(this.ipS);
    ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.ipS)) });
    boolean bool = AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.ipS);
    AppMethodBeat.o(132187);
    return bool;
  }
  
  public final void aHR()
  {
    AppMethodBeat.i(132188);
    if (this.ipH == null)
    {
      ab.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(132188);
      return;
    }
    if (this.ipT == null) {
      this.ipT = new StartInterruptEventListenTask(this.ipH);
    }
    this.isStart = true;
    AppBrandMainProcessService.a(this.ipT);
    AppMethodBeat.o(132188);
  }
  
  public final void aHS()
  {
    AppMethodBeat.i(132189);
    if (!this.isStart)
    {
      ab.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(132189);
      return;
    }
    this.isStart = false;
    if (this.ipU == null) {
      this.ipU = new AudioRecordVoIPInterruptListener.StopInterruptEventListenTask();
    }
    AppBrandMainProcessService.b(this.ipU);
    AppMethodBeat.o(132189);
  }
  
  static class StartInterruptEventListenTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartInterruptEventListenTask> CREATOR;
    private e ipH;
    private int ipX;
    private final c ipY;
    private final c ipZ;
    
    static
    {
      AppMethodBeat.i(132182);
      CREATOR = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.1();
      AppMethodBeat.o(132182);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(132174);
      this.ipX = -1;
      this.ipY = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.2(this);
      this.ipZ = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.3(this);
      f(paramParcel);
      AppMethodBeat.o(132174);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      AppMethodBeat.i(132173);
      this.ipX = -1;
      this.ipY = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.2(this);
      this.ipZ = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.3(this);
      this.ipH = parame;
      AppMethodBeat.o(132173);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(132175);
      ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!a.ymk.e(this.ipY))
      {
        a.ymk.c(this.ipY);
        AudioRecordVoIPInterruptListener.a.aHZ();
        AudioRecordVoIPInterruptListener.a.a(this.ipY);
      }
      if (!a.ymk.e(this.ipZ))
      {
        a.ymk.c(this.ipZ);
        AudioRecordVoIPInterruptListener.a.aHZ();
        AudioRecordVoIPInterruptListener.a.a(this.ipZ);
      }
      AppMethodBeat.o(132175);
    }
    
    public final void atb()
    {
      AppMethodBeat.i(132176);
      if (this.ipH != null)
      {
        if (this.ipX != 11) {
          break label48;
        }
        ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.ipH.aHP();
      }
      for (;;)
      {
        this.ipX = -1;
        AppMethodBeat.o(132176);
        return;
        label48:
        if (this.ipX == 3)
        {
          ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.ipH.aHO();
        }
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(132177);
      this.ipX = paramParcel.readInt();
      AppMethodBeat.o(132177);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(132178);
      paramParcel.writeInt(this.ipX);
      AppMethodBeat.o(132178);
    }
  }
  
  static class a
  {
    private static a ipV;
    LinkedList<c<b>> ipW;
    
    private a()
    {
      AppMethodBeat.i(132165);
      this.ipW = new LinkedList();
      AppMethodBeat.o(132165);
    }
    
    public static void a(c<b> paramc)
    {
      AppMethodBeat.i(132167);
      try
      {
        aHZ().ipW.add(paramc);
        return;
      }
      finally
      {
        AppMethodBeat.o(132167);
      }
    }
    
    public static a aHZ()
    {
      AppMethodBeat.i(132166);
      if (ipV == null) {}
      try
      {
        if (ipV == null) {
          ipV = new a();
        }
        a locala = ipV;
        AppMethodBeat.o(132166);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(132166);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */