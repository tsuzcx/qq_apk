package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aap;
import com.tencent.mm.f.a.aap.a;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.fu;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.q.a;
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
  private e qdX;
  private CheckInterruptTask qei;
  private StartInterruptEventListenTask qej;
  private StopInterruptEventListenTask qek;
  
  public final void a(e parame)
  {
    this.qdX = parame;
  }
  
  public final boolean cbn()
  {
    AppMethodBeat.i(47610);
    if (this.qdX == null)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47610);
      return false;
    }
    if (this.qei == null) {
      this.qei = new CheckInterruptTask(this.qdX);
    }
    this.qei.bPu();
    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", new Object[] { Boolean.valueOf(CheckInterruptTask.a(this.qei)) });
    boolean bool = CheckInterruptTask.a(this.qei);
    AppMethodBeat.o(47610);
    return bool;
  }
  
  public final void cbo()
  {
    AppMethodBeat.i(47611);
    if (this.qdX == null)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
      AppMethodBeat.o(47611);
      return;
    }
    if (this.qej == null) {
      this.qej = new StartInterruptEventListenTask(this.qdX);
    }
    this.isStart = true;
    this.qej.bsM();
    AppMethodBeat.o(47611);
  }
  
  public final void cbp()
  {
    AppMethodBeat.i(47612);
    if (!this.isStart)
    {
      Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(47612);
      return;
    }
    this.isStart = false;
    if (this.qek == null) {
      this.qek = new StopInterruptEventListenTask();
    }
    this.qek.bPu();
    AppMethodBeat.o(47612);
  }
  
  static class CheckInterruptTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckInterruptTask> CREATOR;
    private boolean qdT;
    private e qdX;
    
    static
    {
      AppMethodBeat.i(47589);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47589);
    }
    
    public CheckInterruptTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47585);
      this.qdT = false;
      f(paramParcel);
      AppMethodBeat.o(47585);
    }
    
    public CheckInterruptTask(e parame)
    {
      this.qdT = false;
      this.qdX = parame;
    }
    
    public final void RW()
    {
      boolean bool1 = false;
      AppMethodBeat.i(47586);
      this.qdT = false;
      aap localaap = new aap();
      EventCenter.instance.publish(localaap);
      boolean bool3 = localaap.fZK.fvp;
      boolean bool2 = a.aAj();
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b, isAppBrandVoiceUsing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(a.aAm()) });
      if ((bool3) || (bool2)) {
        bool1 = true;
      }
      this.qdT = bool1;
      bPt();
      AppMethodBeat.o(47586);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(47587);
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.qdT = bool;
        AppMethodBeat.o(47587);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47588);
      if (this.qdT) {}
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
    private e qdX;
    private int qen;
    private final IListener qeo;
    private final IListener qep;
    
    static
    {
      AppMethodBeat.i(47605);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47605);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47597);
      this.qen = -1;
      this.qeo = new IListener() {};
      this.qep = new IListener() {};
      f(paramParcel);
      AppMethodBeat.o(47597);
    }
    
    public StartInterruptEventListenTask(e parame)
    {
      AppMethodBeat.i(47596);
      this.qen = -1;
      this.qeo = new IListener() {};
      this.qep = new IListener() {};
      this.qdX = parame;
      AppMethodBeat.o(47596);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(47598);
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
      if (!EventCenter.instance.hadListened(this.qeo))
      {
        EventCenter.instance.addListener(this.qeo);
        AudioRecordVoIPInterruptListener.a.cbx();
        AudioRecordVoIPInterruptListener.a.a(this.qeo);
      }
      if (!EventCenter.instance.hadListened(this.qep))
      {
        EventCenter.instance.addListener(this.qep);
        AudioRecordVoIPInterruptListener.a.cbx();
        AudioRecordVoIPInterruptListener.a.a(this.qep);
      }
      AppMethodBeat.o(47598);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(47599);
      if (this.qdX != null)
      {
        if (this.qen != 11) {
          break label48;
        }
        Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
        this.qdX.cbm();
      }
      for (;;)
      {
        this.qen = -1;
        AppMethodBeat.o(47599);
        return;
        label48:
        if (this.qen == 3)
        {
          Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
          this.qdX.cbl();
        }
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(47600);
      this.qen = paramParcel.readInt();
      AppMethodBeat.o(47600);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47601);
      paramParcel.writeInt(this.qen);
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
    
    public final void RW()
    {
      AppMethodBeat.i(47608);
      Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
      AudioRecordVoIPInterruptListener.a locala = AudioRecordVoIPInterruptListener.a.cbx();
      try
      {
        Iterator localIterator = locala.qem.iterator();
        while (localIterator.hasNext())
        {
          IListener localIListener = (IListener)localIterator.next();
          EventCenter.instance.removeListener(localIListener);
        }
        localObject.qem.clear();
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
    private static a qel;
    LinkedList<IListener<IEvent>> qem;
    
    private a()
    {
      AppMethodBeat.i(47590);
      this.qem = new LinkedList();
      AppMethodBeat.o(47590);
    }
    
    public static void a(IListener<IEvent> paramIListener)
    {
      AppMethodBeat.i(47592);
      try
      {
        cbx().qem.add(paramIListener);
        return;
      }
      finally
      {
        AppMethodBeat.o(47592);
      }
    }
    
    public static a cbx()
    {
      AppMethodBeat.i(47591);
      if (qel == null) {}
      try
      {
        if (qel == null) {
          qel = new a();
        }
        a locala = qel;
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