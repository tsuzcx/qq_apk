package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acm.a;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.gf;
import com.tencent.mm.n.a;
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
  private e tiM;
  private CheckInterruptTask tiX;
  private StartInterruptEventListenTask tiY;
  private StopInterruptEventListenTask tiZ;
  
  public final void a(e parame)
  {
    this.tiM = parame;
  }
  
  public final boolean cBH()
  {
    AppMethodBeat.i(47610);
    if (this.tiM == null)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47610);
      return false;
    }
    if (this.tiX == null) {
      this.tiX = new CheckInterruptTask(this.tiM);
    }
    this.tiX.cpB();
    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(CheckInterruptTask.a(this.tiX)) });
    boolean bool = CheckInterruptTask.a(this.tiX);
    AppMethodBeat.o(47610);
    return bool;
  }
  
  public final void cBI()
  {
    AppMethodBeat.i(47611);
    if (this.tiM == null)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47611);
      return;
    }
    if (this.tiY == null) {
      this.tiY = new StartInterruptEventListenTask(this.tiM);
    }
    this.isStart = true;
    this.tiY.bQt();
    AppMethodBeat.o(47611);
  }
  
  public final void cBJ()
  {
    AppMethodBeat.i(47612);
    if (!this.isStart)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(47612);
      return;
    }
    this.isStart = false;
    if (this.tiZ == null) {
      this.tiZ = new StopInterruptEventListenTask();
    }
    this.tiZ.cpB();
    AppMethodBeat.o(47612);
  }
  
  static class CheckInterruptTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
    private boolean tiI;
    private e tiM;
    
    static
    {
      AppMethodBeat.i(47589);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47589);
    }
    
    public CheckInterruptTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47585);
      this.tiI = false;
      h(paramParcel);
      AppMethodBeat.o(47585);
    }
    
    public CheckInterruptTask(e parame)
    {
      this.tiI = false;
      this.tiM = parame;
    }
    
    public final void asn()
    {
      boolean bool1 = false;
      AppMethodBeat.i(47586);
      this.tiI = false;
      acm localacm = new acm();
      localacm.publish();
      boolean bool3 = localacm.ifS.hzK;
      boolean bool2 = a.aTe();
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b, isAppBrandVoiceUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(a.aTh()) });
      if ((bool3) || (bool2)) {
        bool1 = true;
      }
      this.tiI = bool1;
      cpA();
      AppMethodBeat.o(47586);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(47587);
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.tiI = bool;
        AppMethodBeat.o(47587);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47588);
      if (this.tiI) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(47588);
        return;
      }
    }
  }
  
  static class StartInterruptEventListenTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartInterruptEventListenTask> CREATOR;
    private e tiM;
    private int tjc;
    private final IListener tjd;
    private final IListener tje;
    
    static
    {
      AppMethodBeat.i(47605);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47605);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47597);
      this.tjc = -1;
      this.tjd = new IListener(com.tencent.mm.app.f.hfK) {};
      this.tje = new IListener(com.tencent.mm.app.f.hfK) {};
      h(paramParcel);
      AppMethodBeat.o(47597);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      AppMethodBeat.i(47596);
      this.tjc = -1;
      this.tjd = new IListener(com.tencent.mm.app.f.hfK) {};
      this.tje = new IListener(com.tencent.mm.app.f.hfK) {};
      this.tiM = parame;
      AppMethodBeat.o(47596);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(47598);
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!EventCenter.instance.hadListened(this.tjd))
      {
        this.tjd.alive();
        AudioRecordVoIPInterruptListener.a.cBR();
        AudioRecordVoIPInterruptListener.a.a(this.tjd);
      }
      if (!EventCenter.instance.hadListened(this.tje))
      {
        this.tje.alive();
        AudioRecordVoIPInterruptListener.a.cBR();
        AudioRecordVoIPInterruptListener.a.a(this.tje);
      }
      AppMethodBeat.o(47598);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(47599);
      if (this.tiM != null)
      {
        if (this.tjc != 11) {
          break label48;
        }
        Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.tiM.cBG();
      }
      for (;;)
      {
        this.tjc = -1;
        AppMethodBeat.o(47599);
        return;
        label48:
        if (this.tjc == 3)
        {
          Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.tiM.cBF();
        }
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(47600);
      this.tjc = paramParcel.readInt();
      AppMethodBeat.o(47600);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47601);
      paramParcel.writeInt(this.tjc);
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
      h(paramParcel);
      AppMethodBeat.o(47607);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(47608);
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
      AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.cBR();
      try
      {
        Iterator localIterator = locala.tjb.iterator();
        while (localIterator.hasNext()) {
          ((IListener)localIterator.next()).dead();
        }
        localObject.tjb.clear();
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
    private static a tja;
    LinkedList<IListener<IEvent>> tjb;
    
    private a()
    {
      AppMethodBeat.i(47590);
      this.tjb = new LinkedList();
      AppMethodBeat.o(47590);
    }
    
    public static void a(IListener<IEvent> paramIListener)
    {
      AppMethodBeat.i(47592);
      try
      {
        cBR().tjb.add(paramIListener);
        return;
      }
      finally
      {
        AppMethodBeat.o(47592);
      }
    }
    
    public static a cBR()
    {
      AppMethodBeat.i(47591);
      if (tja == null) {}
      try
      {
        if (tja == null) {
          tja = new a();
        }
        a locala = tja;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */