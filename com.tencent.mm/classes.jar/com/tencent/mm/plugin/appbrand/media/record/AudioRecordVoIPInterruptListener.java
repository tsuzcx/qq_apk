package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener
  implements f
{
  private boolean isStart = false;
  private e lWe;
  private CheckInterruptTask lWp;
  private StartInterruptEventListenTask lWq;
  private StopInterruptEventListenTask lWr;
  
  public final void a(e parame)
  {
    this.lWe = parame;
  }
  
  public final boolean btu()
  {
    AppMethodBeat.i(47610);
    if (this.lWe == null)
    {
      ae.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47610);
      return false;
    }
    if (this.lWp == null) {
      this.lWp = new CheckInterruptTask(this.lWe);
    }
    AppBrandMainProcessService.b(this.lWp);
    ae.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(CheckInterruptTask.a(this.lWp)) });
    boolean bool = CheckInterruptTask.a(this.lWp);
    AppMethodBeat.o(47610);
    return bool;
  }
  
  public final void btv()
  {
    AppMethodBeat.i(47611);
    if (this.lWe == null)
    {
      ae.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47611);
      return;
    }
    if (this.lWq == null) {
      this.lWq = new StartInterruptEventListenTask(this.lWe);
    }
    this.isStart = true;
    AppBrandMainProcessService.a(this.lWq);
    AppMethodBeat.o(47611);
  }
  
  public final void btw()
  {
    AppMethodBeat.i(47612);
    if (!this.isStart)
    {
      ae.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(47612);
      return;
    }
    this.isStart = false;
    if (this.lWr == null) {
      this.lWr = new StopInterruptEventListenTask();
    }
    AppBrandMainProcessService.b(this.lWr);
    AppMethodBeat.o(47612);
  }
  
  static class CheckInterruptTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
    private boolean lWa;
    private e lWe;
    
    static
    {
      AppMethodBeat.i(47589);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47589);
    }
    
    public CheckInterruptTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47585);
      this.lWa = false;
      e(paramParcel);
      AppMethodBeat.o(47585);
    }
    
    public CheckInterruptTask(e parame)
    {
      this.lWa = false;
      this.lWe = parame;
    }
    
    public final void aOX()
    {
      boolean bool1 = false;
      AppMethodBeat.i(47586);
      this.lWa = false;
      yg localyg = new yg();
      com.tencent.mm.sdk.b.a.IvT.l(localyg);
      boolean bool3 = localyg.dNC.dls;
      boolean bool2 = com.tencent.mm.r.a.adO();
      ae.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b, isAppBrandVoiceUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.r.a.adQ()) });
      if ((bool3) || (bool2)) {
        bool1 = true;
      }
      this.lWa = bool1;
      biG();
      AppMethodBeat.o(47586);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(47587);
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lWa = bool;
        AppMethodBeat.o(47587);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47588);
      if (this.lWa) {}
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
    private e lWe;
    private int lWu;
    private final c lWv;
    private final c lWw;
    
    static
    {
      AppMethodBeat.i(47605);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47605);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47597);
      this.lWu = -1;
      this.lWv = new c() {};
      this.lWw = new c() {};
      e(paramParcel);
      AppMethodBeat.o(47597);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      AppMethodBeat.i(47596);
      this.lWu = -1;
      this.lWv = new c() {};
      this.lWw = new c() {};
      this.lWe = parame;
      AppMethodBeat.o(47596);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(47598);
      ae.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!com.tencent.mm.sdk.b.a.IvT.e(this.lWv))
      {
        com.tencent.mm.sdk.b.a.IvT.c(this.lWv);
        AudioRecordVoIPInterruptListener.a.btE();
        AudioRecordVoIPInterruptListener.a.a(this.lWv);
      }
      if (!com.tencent.mm.sdk.b.a.IvT.e(this.lWw))
      {
        com.tencent.mm.sdk.b.a.IvT.c(this.lWw);
        AudioRecordVoIPInterruptListener.a.btE();
        AudioRecordVoIPInterruptListener.a.a(this.lWw);
      }
      AppMethodBeat.o(47598);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(47599);
      if (this.lWe != null)
      {
        if (this.lWu != 11) {
          break label48;
        }
        ae.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.lWe.btt();
      }
      for (;;)
      {
        this.lWu = -1;
        AppMethodBeat.o(47599);
        return;
        label48:
        if (this.lWu == 3)
        {
          ae.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.lWe.bts();
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(47600);
      this.lWu = paramParcel.readInt();
      AppMethodBeat.o(47600);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47601);
      paramParcel.writeInt(this.lWu);
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
      e(paramParcel);
      AppMethodBeat.o(47607);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(47608);
      ae.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
      AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.btE();
      try
      {
        Iterator localIterator = locala.lWt.iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          com.tencent.mm.sdk.b.a.IvT.d(localc);
        }
        localObject.lWt.clear();
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
    private static a lWs;
    LinkedList<c<b>> lWt;
    
    private a()
    {
      AppMethodBeat.i(47590);
      this.lWt = new LinkedList();
      AppMethodBeat.o(47590);
    }
    
    public static void a(c<b> paramc)
    {
      AppMethodBeat.i(47592);
      try
      {
        btE().lWt.add(paramc);
        return;
      }
      finally
      {
        AppMethodBeat.o(47592);
      }
    }
    
    public static a btE()
    {
      AppMethodBeat.i(47591);
      if (lWs == null) {}
      try
      {
        if (lWs == null) {
          lWs = new a();
        }
        a locala = lWs;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */