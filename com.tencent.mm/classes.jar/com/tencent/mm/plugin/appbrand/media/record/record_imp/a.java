package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int channelCount;
  public c hvI;
  public int hwm;
  public int sampleRate;
  public RecordParam tjt;
  public long tju;
  public a tjv;
  public c.a tjw;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(146187);
    this.hvI = null;
    this.sampleRate = 0;
    this.channelCount = 0;
    this.tju = 0L;
    this.hwm = -1;
    this.tjw = new c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146186);
        Log.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (a.this.tjv != null) {
          a.this.tjv.ds(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(146186);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146185);
        Log.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
        if (a.this.tjv != null) {
          a.this.tjv.u(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(146185);
      }
    };
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.channelCount = localRecordParam.tjy;
    this.hwm = localRecordParam.scene;
    this.tjt = localRecordParam;
    AppMethodBeat.o(146187);
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(146188);
    Log.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.hvI != null) {}
    for (boolean bool = this.hvI.aGH();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.tju -= l;
      Log.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.tju) });
      AppMethodBeat.o(146188);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ds(int paramInt1, int paramInt2);
    
    public abstract void u(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */