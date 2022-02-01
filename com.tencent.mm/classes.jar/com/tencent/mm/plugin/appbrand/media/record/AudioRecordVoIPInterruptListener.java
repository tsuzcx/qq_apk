package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener
  implements f
{
  private boolean isStart = false;
  private e lRD;
  private CheckInterruptTask lRO;
  private StartInterruptEventListenTask lRP;
  private StopInterruptEventListenTask lRQ;
  
  public final void a(e parame)
  {
    this.lRD = parame;
  }
  
  public final boolean bsJ()
  {
    AppMethodBeat.i(47610);
    if (this.lRD == null)
    {
      ad.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47610);
      return false;
    }
    if (this.lRO == null) {
      this.lRO = new CheckInterruptTask(this.lRD);
    }
    AppBrandMainProcessService.b(this.lRO);
    ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(CheckInterruptTask.a(this.lRO)) });
    boolean bool = CheckInterruptTask.a(this.lRO);
    AppMethodBeat.o(47610);
    return bool;
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(47611);
    if (this.lRD == null)
    {
      ad.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47611);
      return;
    }
    if (this.lRP == null) {
      this.lRP = new StartInterruptEventListenTask(this.lRD);
    }
    this.isStart = true;
    AppBrandMainProcessService.a(this.lRP);
    AppMethodBeat.o(47611);
  }
  
  public final void bsL()
  {
    AppMethodBeat.i(47612);
    if (!this.isStart)
    {
      ad.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(47612);
      return;
    }
    this.isStart = false;
    if (this.lRQ == null) {
      this.lRQ = new StopInterruptEventListenTask();
    }
    AppBrandMainProcessService.b(this.lRQ);
    AppMethodBeat.o(47612);
  }
  
  static class CheckInterruptTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
    private e lRD;
    private boolean lRz;
    
    static
    {
      AppMethodBeat.i(47589);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47589);
    }
    
    public CheckInterruptTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47585);
      this.lRz = false;
      e(paramParcel);
      AppMethodBeat.o(47585);
    }
    
    public CheckInterruptTask(e parame)
    {
      this.lRz = false;
      this.lRD = parame;
    }
    
    public final void aOA()
    {
      boolean bool1 = false;
      AppMethodBeat.i(47586);
      this.lRz = false;
      ya localya = new ya();
      com.tencent.mm.sdk.b.a.IbL.l(localya);
      boolean bool3 = localya.dMm.dkq;
      boolean bool2 = com.tencent.mm.s.a.adC();
      ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b, isAppBrandVoiceUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.s.a.adE()) });
      if ((bool3) || (bool2)) {
        bool1 = true;
      }
      this.lRz = bool1;
      bhX();
      AppMethodBeat.o(47586);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(47587);
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lRz = bool;
        AppMethodBeat.o(47587);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47588);
      if (this.lRz) {}
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
    private e lRD;
    private int lRT;
    private final c lRU;
    private final c lRV;
    
    static
    {
      AppMethodBeat.i(47605);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47605);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47597);
      this.lRT = -1;
      this.lRU = new c() {};
      this.lRV = new c() {};
      e(paramParcel);
      AppMethodBeat.o(47597);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      AppMethodBeat.i(47596);
      this.lRT = -1;
      this.lRU = new c() {};
      this.lRV = new c() {};
      this.lRD = parame;
      AppMethodBeat.o(47596);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(47598);
      ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!com.tencent.mm.sdk.b.a.IbL.e(this.lRU))
      {
        com.tencent.mm.sdk.b.a.IbL.c(this.lRU);
        AudioRecordVoIPInterruptListener.a.bsT();
        AudioRecordVoIPInterruptListener.a.a(this.lRU);
      }
      if (!com.tencent.mm.sdk.b.a.IbL.e(this.lRV))
      {
        com.tencent.mm.sdk.b.a.IbL.c(this.lRV);
        AudioRecordVoIPInterruptListener.a.bsT();
        AudioRecordVoIPInterruptListener.a.a(this.lRV);
      }
      AppMethodBeat.o(47598);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(47599);
      if (this.lRD != null)
      {
        if (this.lRT != 11) {
          break label48;
        }
        ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.lRD.bsI();
      }
      for (;;)
      {
        this.lRT = -1;
        AppMethodBeat.o(47599);
        return;
        label48:
        if (this.lRT == 3)
        {
          ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.lRD.bsH();
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(47600);
      this.lRT = paramParcel.readInt();
      AppMethodBeat.o(47600);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47601);
      paramParcel.writeInt(this.lRT);
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
    
    public final void aOA()
    {
      AppMethodBeat.i(47608);
      ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
      AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.bsT();
      try
      {
        Iterator localIterator = locala.lRS.iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          com.tencent.mm.sdk.b.a.IbL.d(localc);
        }
        localObject.lRS.clear();
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
    private static a lRR;
    LinkedList<c<b>> lRS;
    
    private a()
    {
      AppMethodBeat.i(47590);
      this.lRS = new LinkedList();
      AppMethodBeat.o(47590);
    }
    
    public static void a(c<b> paramc)
    {
      AppMethodBeat.i(47592);
      try
      {
        bsT().lRS.add(paramc);
        return;
      }
      finally
      {
        AppMethodBeat.o(47592);
      }
    }
    
    public static a bsT()
    {
      AppMethodBeat.i(47591);
      if (lRR == null) {}
      try
      {
        if (lRR == null) {
          lRR = new a();
        }
        a locala = lRR;
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