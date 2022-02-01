package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener
  implements f
{
  private boolean isStart = false;
  private AudioRecordVoIPInterruptListener.CheckInterruptTask lsF;
  private AudioRecordVoIPInterruptListener.StartInterruptEventListenTask lsG;
  private StopInterruptEventListenTask lsH;
  private e lsu;
  
  public final void a(e parame)
  {
    this.lsu = parame;
  }
  
  public final boolean boK()
  {
    AppMethodBeat.i(47610);
    if (this.lsu == null)
    {
      ac.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47610);
      return false;
    }
    if (this.lsF == null) {
      this.lsF = new AudioRecordVoIPInterruptListener.CheckInterruptTask(this.lsu);
    }
    AppBrandMainProcessService.b(this.lsF);
    ac.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.lsF)) });
    boolean bool = AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.lsF);
    AppMethodBeat.o(47610);
    return bool;
  }
  
  public final void boL()
  {
    AppMethodBeat.i(47611);
    if (this.lsu == null)
    {
      ac.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47611);
      return;
    }
    if (this.lsG == null) {
      this.lsG = new AudioRecordVoIPInterruptListener.StartInterruptEventListenTask(this.lsu);
    }
    this.isStart = true;
    AppBrandMainProcessService.a(this.lsG);
    AppMethodBeat.o(47611);
  }
  
  public final void boM()
  {
    AppMethodBeat.i(47612);
    if (!this.isStart)
    {
      ac.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(47612);
      return;
    }
    this.isStart = false;
    if (this.lsH == null) {
      this.lsH = new StopInterruptEventListenTask();
    }
    AppBrandMainProcessService.b(this.lsH);
    AppMethodBeat.o(47612);
  }
  
  static class StopInterruptEventListenTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopInterruptEventListenTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(47609);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47609);
    }
    
    public StopInterruptEventListenTask() {}
    
    public StopInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47607);
      e(paramParcel);
      AppMethodBeat.o(47607);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(47608);
      ac.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
      AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.boU();
      try
      {
        Iterator localIterator = locala.lsJ.iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          a.GpY.d(localc);
        }
        localObject.lsJ.clear();
      }
      finally
      {
        AppMethodBeat.o(47608);
      }
      AppMethodBeat.o(47608);
    }
  }
  
  static class a
  {
    private static a lsI;
    LinkedList<c<b>> lsJ;
    
    private a()
    {
      AppMethodBeat.i(47590);
      this.lsJ = new LinkedList();
      AppMethodBeat.o(47590);
    }
    
    public static void a(c<b> paramc)
    {
      AppMethodBeat.i(47592);
      try
      {
        boU().lsJ.add(paramc);
        return;
      }
      finally
      {
        AppMethodBeat.o(47592);
      }
    }
    
    public static a boU()
    {
      AppMethodBeat.i(47591);
      if (lsI == null) {}
      try
      {
        if (lsI == null) {
          lsI = new a();
        }
        a locala = lsI;
        AppMethodBeat.o(47591);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(47591);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */