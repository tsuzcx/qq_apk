package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public int cVF;
  public c cVe;
  public int channelCount;
  public RecordParam ltc;
  public long ltd;
  public a lte;
  public c.a ltf;
  public int sampleRate;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(146187);
    this.cVe = null;
    this.sampleRate = 0;
    this.channelCount = 0;
    this.ltd = 0L;
    this.cVF = -1;
    this.ltf = new c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146186);
        ac.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (a.this.lte != null) {
          a.this.lte.cf(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(146186);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146185);
        ac.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (a.this.lte != null) {
          a.this.lte.u(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(146185);
      }
    };
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.channelCount = localRecordParam.kXq;
    this.cVF = localRecordParam.scene;
    this.ltc = localRecordParam;
    AppMethodBeat.o(146187);
  }
  
  public final boolean NX()
  {
    AppMethodBeat.i(146188);
    ac.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.cVe != null) {}
    for (boolean bool = this.cVe.NX();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.ltd -= l;
      ac.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.ltd) });
      AppMethodBeat.o(146188);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cf(int paramInt1, int paramInt2);
    
    public abstract void u(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */