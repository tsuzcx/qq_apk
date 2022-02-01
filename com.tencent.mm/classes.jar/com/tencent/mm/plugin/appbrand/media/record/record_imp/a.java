package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public c cXI;
  public int cYj;
  public int channelCount;
  public RecordParam kRC;
  public long kRD;
  public a kRE;
  public c.a kRF;
  public int sampleRate;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(146187);
    this.cXI = null;
    this.sampleRate = 0;
    this.channelCount = 0;
    this.kRD = 0L;
    this.cYj = -1;
    this.kRF = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146186);
        ad.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (a.this.kRE != null) {
          a.this.kRE.ch(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(146186);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146185);
        ad.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (a.this.kRE != null) {
          a.this.kRE.w(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(146185);
      }
    };
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.channelCount = localRecordParam.kwc;
    this.cYj = localRecordParam.scene;
    this.kRC = localRecordParam;
    AppMethodBeat.o(146187);
  }
  
  public final boolean Ob()
  {
    AppMethodBeat.i(146188);
    ad.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.cXI != null) {}
    for (boolean bool = this.cXI.Ob();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.kRD -= l;
      ad.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.kRD) });
      AppMethodBeat.o(146188);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ch(int paramInt1, int paramInt2);
    
    public abstract void w(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */