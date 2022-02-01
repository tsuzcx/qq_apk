package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int channelCount;
  public int frY;
  public c frx;
  public RecordParam qeF;
  public long qeG;
  public a qeH;
  public c.a qeI;
  public int sampleRate;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(146187);
    this.frx = null;
    this.sampleRate = 0;
    this.channelCount = 0;
    this.qeG = 0L;
    this.frY = -1;
    this.qeI = new c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146186);
        Log.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (a.this.qeH != null) {
          a.this.qeH.cC(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(146186);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146185);
        Log.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (a.this.qeH != null) {
          a.this.qeH.w(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(146185);
      }
    };
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.channelCount = localRecordParam.qeK;
    this.frY = localRecordParam.scene;
    this.qeF = localRecordParam;
    AppMethodBeat.o(146187);
  }
  
  public final boolean aeJ()
  {
    AppMethodBeat.i(146188);
    Log.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.frx != null) {}
    for (boolean bool = this.frx.aeJ();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.qeG -= l;
      Log.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.qeG) });
      AppMethodBeat.o(146188);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cC(int paramInt1, int paramInt2);
    
    public abstract void w(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */