package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class OpenVoiceVoIPInterruptListener
{
  boolean isStart = false;
  b wXG;
  StartInterruptEventListenTask wXH;
  private StopInterruptEventListenTask wXI;
  
  public final void cBJ()
  {
    AppMethodBeat.i(268365);
    if (!this.isStart)
    {
      Log.e("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "not start listen");
      AppMethodBeat.o(268365);
      return;
    }
    this.isStart = false;
    if (this.wXI == null) {
      this.wXI = new StopInterruptEventListenTask();
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "stopListenInterruptEvent");
    this.wXI.cpB();
    AppMethodBeat.o(268365);
  }
  
  static class StartInterruptEventListenTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartInterruptEventListenTask> CREATOR;
    private int tjc;
    private final IListener tje;
    private OpenVoiceVoIPInterruptListener.b wXG;
    
    static
    {
      AppMethodBeat.i(268280);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(268280);
    }
    
    public StartInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(268265);
      this.tjc = -1;
      this.tje = new IListener(f.hfK) {};
      h(paramParcel);
      AppMethodBeat.o(268265);
    }
    
    public StartInterruptEventListenTask(OpenVoiceVoIPInterruptListener.b paramb)
    {
      AppMethodBeat.i(268260);
      this.tjc = -1;
      this.tje = new IListener(f.hfK) {};
      this.wXG = paramb;
      AppMethodBeat.o(268260);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(268283);
      Log.i("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "addListener");
      if (!EventCenter.instance.hadListened(this.tje))
      {
        this.tje.alive();
        OpenVoiceVoIPInterruptListener.a.drt();
        OpenVoiceVoIPInterruptListener.a.a(this.tje);
      }
      AppMethodBeat.o(268283);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(268284);
      if (this.wXG != null)
      {
        if (this.tjc != 11) {
          break label48;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "onInterruptEnd");
        this.wXG.cBG();
      }
      for (;;)
      {
        this.tjc = -1;
        AppMethodBeat.o(268284);
        return;
        label48:
        if (this.tjc == 3)
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "onInterruptBegin");
          this.wXG.cBF();
        }
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(268285);
      this.tjc = paramParcel.readInt();
      AppMethodBeat.o(268285);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(268286);
      paramParcel.writeInt(this.tjc);
      AppMethodBeat.o(268286);
    }
  }
  
  static class StopInterruptEventListenTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopInterruptEventListenTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(268269);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(268269);
    }
    
    public StopInterruptEventListenTask() {}
    
    public StopInterruptEventListenTask(Parcel paramParcel)
    {
      AppMethodBeat.i(268266);
      h(paramParcel);
      AppMethodBeat.o(268266);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(268275);
      Log.i("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "removeListener");
      OpenVoiceVoIPInterruptListener.a locala = OpenVoiceVoIPInterruptListener.a.drt();
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
        AppMethodBeat.o(268275);
      }
      AppMethodBeat.o(268275);
    }
  }
  
  static class a
  {
    private static a wXJ;
    LinkedList<IListener<IEvent>> tjb;
    
    private a()
    {
      AppMethodBeat.i(268360);
      this.tjb = new LinkedList();
      AppMethodBeat.o(268360);
    }
    
    public static void a(IListener<IEvent> paramIListener)
    {
      AppMethodBeat.i(268371);
      try
      {
        drt().tjb.add(paramIListener);
        return;
      }
      finally
      {
        AppMethodBeat.o(268371);
      }
    }
    
    public static a drt()
    {
      AppMethodBeat.i(268366);
      if (wXJ == null) {}
      try
      {
        if (wXJ == null) {
          wXJ = new a();
        }
        a locala = wXJ;
        AppMethodBeat.o(268366);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(268366);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cBF();
    
    public abstract void cBG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.OpenVoiceVoIPInterruptListener
 * JD-Core Version:    0.7.0.1
 */