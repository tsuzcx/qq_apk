package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public int awU;
  public c ciR;
  public int cjr;
  public RecordParam iqn;
  public long iqo;
  public a.a iqp;
  public c.a iqq;
  public int sampleRate;
  
  public a(RecordParam paramRecordParam)
  {
    AppMethodBeat.i(105658);
    this.ciR = null;
    this.sampleRate = 0;
    this.awU = 0;
    this.iqo = 0L;
    this.cjr = -1;
    this.iqq = new a.1(this);
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.awU = localRecordParam.ifH;
    this.cjr = localRecordParam.scene;
    this.iqn = localRecordParam;
    AppMethodBeat.o(105658);
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(105659);
    ab.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.ciR != null) {}
    for (boolean bool = this.ciR.Et();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.iqo -= l;
      ab.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.iqo) });
      AppMethodBeat.o(105659);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */