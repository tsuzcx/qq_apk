package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public int channelCount;
  public int dhX;
  public c dhw;
  public RecordParam lWM;
  public long lWN;
  public a lWO;
  public c.a lWP;
  public int sampleRate;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(146187);
    this.dhw = null;
    this.sampleRate = 0;
    this.channelCount = 0;
    this.lWN = 0L;
    this.dhX = -1;
    this.lWP = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146186);
        ae.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (a.this.lWO != null) {
          a.this.lWO.ch(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(146186);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146185);
        ae.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (a.this.lWO != null) {
          a.this.lWO.u(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(146185);
      }
    };
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.channelCount = localRecordParam.lyO;
    this.dhX = localRecordParam.scene;
    this.lWM = localRecordParam;
    AppMethodBeat.o(146187);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(146188);
    ae.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.dhw != null) {}
    for (boolean bool = this.dhw.PF();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.lWN -= l;
      ae.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.lWN) });
      AppMethodBeat.o(146188);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ch(int paramInt1, int paramInt2);
    
    public abstract void u(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */