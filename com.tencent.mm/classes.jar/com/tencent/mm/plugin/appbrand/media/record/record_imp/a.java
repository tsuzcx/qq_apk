package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public int channelCount;
  public int dgV;
  public c dgu;
  public RecordParam lSl;
  public long lSm;
  public a lSn;
  public c.a lSo;
  public int sampleRate;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(146187);
    this.dgu = null;
    this.sampleRate = 0;
    this.channelCount = 0;
    this.lSm = 0L;
    this.dgV = -1;
    this.lSo = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146186);
        ad.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (a.this.lSn != null) {
          a.this.lSn.ch(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(146186);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146185);
        ad.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (a.this.lSn != null) {
          a.this.lSn.u(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(146185);
      }
    };
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.channelCount = localRecordParam.lup;
    this.dgV = localRecordParam.scene;
    this.lSl = localRecordParam;
    AppMethodBeat.o(146187);
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(146188);
    ad.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.dgu != null) {}
    for (boolean bool = this.dgu.PG();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.lSm -= l;
      ad.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.lSm) });
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