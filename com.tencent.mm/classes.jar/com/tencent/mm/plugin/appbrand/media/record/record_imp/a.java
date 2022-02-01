package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int channelCount;
  public c dyI;
  public int dzj;
  public RecordParam neo;
  public long nep;
  public a neq;
  public c.a ner;
  public int sampleRate;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(146187);
    this.dyI = null;
    this.sampleRate = 0;
    this.channelCount = 0;
    this.nep = 0L;
    this.dzj = -1;
    this.ner = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146186);
        Log.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (a.this.neq != null) {
          a.this.neq.cj(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(146186);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146185);
        Log.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (a.this.neq != null) {
          a.this.neq.w(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(146185);
      }
    };
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.channelCount = localRecordParam.mFQ;
    this.dzj = localRecordParam.scene;
    this.neo = localRecordParam;
    AppMethodBeat.o(146187);
  }
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(146188);
    Log.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.dyI != null) {}
    for (boolean bool = this.dyI.ZZ();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.nep -= l;
      Log.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.nep) });
      AppMethodBeat.o(146188);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cj(int paramInt1, int paramInt2);
    
    public abstract void w(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */