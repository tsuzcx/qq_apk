package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener
  implements f
{
  private boolean isStart = false;
  private e ndG;
  private AudioRecordVoIPInterruptListener.CheckInterruptTask ndR;
  private StartInterruptEventListenTask ndS;
  private StopInterruptEventListenTask ndT;
  
  public final void a(e parame)
  {
    this.ndG = parame;
  }
  
  public final boolean bOX()
  {
    AppMethodBeat.i(47610);
    if (this.ndG == null)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47610);
      return false;
    }
    if (this.ndR == null) {
      this.ndR = new AudioRecordVoIPInterruptListener.CheckInterruptTask(this.ndG);
    }
    AppBrandMainProcessService.b(this.ndR);
    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.ndR)) });
    boolean bool = AudioRecordVoIPInterruptListener.CheckInterruptTask.a(this.ndR);
    AppMethodBeat.o(47610);
    return bool;
  }
  
  public final void bOY()
  {
    AppMethodBeat.i(47611);
    if (this.ndG == null)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47611);
      return;
    }
    if (this.ndS == null) {
      this.ndS = new StartInterruptEventListenTask(this.ndG);
    }
    this.isStart = true;
    AppBrandMainProcessService.a(this.ndS);
    AppMethodBeat.o(47611);
  }
  
  public final void bOZ()
  {
    AppMethodBeat.i(47612);
    if (!this.isStart)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(47612);
      return;
    }
    this.isStart = false;
    if (this.ndT == null) {
      this.ndT = new StopInterruptEventListenTask();
    }
    AppBrandMainProcessService.b(this.ndT);
    AppMethodBeat.o(47612);
  }
  
  static class StartInterruptEventListenTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartInterruptEventListenTask> CREATOR;
    private e ndG;
    private int ndW;
    private final IListener ndX;
    private final IListener ndY;
    
    static
    {
      AppMethodBeat.i(47605);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47605);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47597);
      this.ndW = -1;
      this.ndX = new IListener() {};
      this.ndY = new IListener() {};
      f(paramParcel);
      AppMethodBeat.o(47597);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      AppMethodBeat.i(47596);
      this.ndW = -1;
      this.ndX = new IListener() {};
      this.ndY = new IListener() {};
      this.ndG = parame;
      AppMethodBeat.o(47596);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(47598);
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!EventCenter.instance.hadListened(this.ndX))
      {
        EventCenter.instance.addListener(this.ndX);
        AudioRecordVoIPInterruptListener.a.bPh();
        AudioRecordVoIPInterruptListener.a.a(this.ndX);
      }
      if (!EventCenter.instance.hadListened(this.ndY))
      {
        EventCenter.instance.addListener(this.ndY);
        AudioRecordVoIPInterruptListener.a.bPh();
        AudioRecordVoIPInterruptListener.a.a(this.ndY);
      }
      AppMethodBeat.o(47598);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(47599);
      if (this.ndG != null)
      {
        if (this.ndW != 11) {
          break label48;
        }
        Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.ndG.bOW();
      }
      for (;;)
      {
        this.ndW = -1;
        AppMethodBeat.o(47599);
        return;
        label48:
        if (this.ndW == 3)
        {
          Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.ndG.bOV();
        }
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(47600);
      this.ndW = paramParcel.readInt();
      AppMethodBeat.o(47600);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47601);
      paramParcel.writeInt(this.ndW);
      AppMethodBeat.o(47601);
    }
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
      f(paramParcel);
      AppMethodBeat.o(47607);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(47608);
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
      AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.bPh();
      try
      {
        Iterator localIterator = locala.ndV.iterator();
        while (localIterator.hasNext())
        {
          IListener localIListener = (IListener)localIterator.next();
          EventCenter.instance.removeListener(localIListener);
        }
        localObject.ndV.clear();
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
    private static a ndU;
    LinkedList<IListener<IEvent>> ndV;
    
    private a()
    {
      AppMethodBeat.i(47590);
      this.ndV = new LinkedList();
      AppMethodBeat.o(47590);
    }
    
    public static void a(IListener<IEvent> paramIListener)
    {
      AppMethodBeat.i(47592);
      try
      {
        bPh().ndV.add(paramIListener);
        return;
      }
      finally
      {
        AppMethodBeat.o(47592);
      }
    }
    
    public static a bPh()
    {
      AppMethodBeat.i(47591);
      if (ndU == null) {}
      try
      {
        if (ndU == null) {
          ndU = new a();
        }
        a locala = ndU;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */