package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.ww;
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
  private e kQU;
  private CheckInterruptTask kRf;
  private StartInterruptEventListenTask kRg;
  private StopInterruptEventListenTask kRh;
  
  public final void a(e parame)
  {
    this.kQU = parame;
  }
  
  public final boolean bhQ()
  {
    AppMethodBeat.i(47610);
    if (this.kQU == null)
    {
      ad.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47610);
      return false;
    }
    if (this.kRf == null) {
      this.kRf = new CheckInterruptTask(this.kQU);
    }
    AppBrandMainProcessService.b(this.kRf);
    ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(CheckInterruptTask.a(this.kRf)) });
    boolean bool = CheckInterruptTask.a(this.kRf);
    AppMethodBeat.o(47610);
    return bool;
  }
  
  public final void bhR()
  {
    AppMethodBeat.i(47611);
    if (this.kQU == null)
    {
      ad.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47611);
      return;
    }
    if (this.kRg == null) {
      this.kRg = new StartInterruptEventListenTask(this.kQU);
    }
    this.isStart = true;
    AppBrandMainProcessService.a(this.kRg);
    AppMethodBeat.o(47611);
  }
  
  public final void bhS()
  {
    AppMethodBeat.i(47612);
    if (!this.isStart)
    {
      ad.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(47612);
      return;
    }
    this.isStart = false;
    if (this.kRh == null) {
      this.kRh = new StopInterruptEventListenTask();
    }
    AppBrandMainProcessService.b(this.kRh);
    AppMethodBeat.o(47612);
  }
  
  static class CheckInterruptTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
    private boolean kQQ;
    private e kQU;
    
    static
    {
      AppMethodBeat.i(47589);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47589);
    }
    
    public CheckInterruptTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47585);
      this.kQQ = false;
      e(paramParcel);
      AppMethodBeat.o(47585);
    }
    
    public CheckInterruptTask(e parame)
    {
      this.kQQ = false;
      this.kQU = parame;
    }
    
    public final void aEz()
    {
      boolean bool1 = false;
      AppMethodBeat.i(47586);
      this.kQQ = false;
      wv localwv = new wv();
      com.tencent.mm.sdk.b.a.ESL.l(localwv);
      boolean bool3 = localwv.dCl.dCo;
      boolean bool2 = com.tencent.mm.r.a.aad();
      ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
      if ((bool3) || (bool2)) {
        bool1 = true;
      }
      this.kQQ = bool1;
      aXw();
      AppMethodBeat.o(47586);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(47587);
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kQQ = bool;
        AppMethodBeat.o(47587);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47588);
      if (this.kQQ) {}
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
    private e kQU;
    private int kRk;
    private final c kRl;
    private final c kRm;
    
    static
    {
      AppMethodBeat.i(47605);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47605);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47597);
      this.kRk = -1;
      this.kRl = new c() {};
      this.kRm = new c() {};
      e(paramParcel);
      AppMethodBeat.o(47597);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      AppMethodBeat.i(47596);
      this.kRk = -1;
      this.kRl = new c() {};
      this.kRm = new c() {};
      this.kQU = parame;
      AppMethodBeat.o(47596);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(47599);
      if (this.kQU != null)
      {
        if (this.kRk != 11) {
          break label48;
        }
        ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.kQU.bhP();
      }
      for (;;)
      {
        this.kRk = -1;
        AppMethodBeat.o(47599);
        return;
        label48:
        if (this.kRk == 3)
        {
          ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.kQU.bhO();
        }
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(47598);
      ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!com.tencent.mm.sdk.b.a.ESL.e(this.kRl))
      {
        com.tencent.mm.sdk.b.a.ESL.c(this.kRl);
        AudioRecordVoIPInterruptListener.a.bia();
        AudioRecordVoIPInterruptListener.a.a(this.kRl);
      }
      if (!com.tencent.mm.sdk.b.a.ESL.e(this.kRm))
      {
        com.tencent.mm.sdk.b.a.ESL.c(this.kRm);
        AudioRecordVoIPInterruptListener.a.bia();
        AudioRecordVoIPInterruptListener.a.a(this.kRm);
      }
      AppMethodBeat.o(47598);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(47600);
      this.kRk = paramParcel.readInt();
      AppMethodBeat.o(47600);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47601);
      paramParcel.writeInt(this.kRk);
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
    
    public final void aEz()
    {
      AppMethodBeat.i(47608);
      ad.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
      AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.bia();
      try
      {
        Iterator localIterator = locala.kRj.iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          com.tencent.mm.sdk.b.a.ESL.d(localc);
        }
        localObject.kRj.clear();
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
    private static a kRi;
    LinkedList<c<b>> kRj;
    
    private a()
    {
      AppMethodBeat.i(47590);
      this.kRj = new LinkedList();
      AppMethodBeat.o(47590);
    }
    
    public static void a(c<b> paramc)
    {
      AppMethodBeat.i(47592);
      try
      {
        bia().kRj.add(paramc);
        return;
      }
      finally
      {
        AppMethodBeat.o(47592);
      }
    }
    
    public static a bia()
    {
      AppMethodBeat.i(47591);
      if (kRi == null) {}
      try
      {
        if (kRi == null) {
          kRi = new a();
        }
        a locala = kRi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */