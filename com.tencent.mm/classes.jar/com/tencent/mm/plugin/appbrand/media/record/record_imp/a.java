package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.mm.f.b.c;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public int auC = 0;
  public int bCD = -1;
  public c bCc = null;
  public RecordParam gOB;
  public long gOC = 0L;
  public a.a gOD;
  public c.a gOE = new a.1(this);
  public int sampleRate = 0;
  
  public a(RecordParam paramRecordParam)
  {
    RecordParam localRecordParam = paramRecordParam;
    if (paramRecordParam == null) {
      localRecordParam = new RecordParam();
    }
    this.sampleRate = localRecordParam.sampleRate;
    this.auC = localRecordParam.gOG;
    this.bCD = localRecordParam.scene;
    this.gOB = localRecordParam;
  }
  
  public final boolean uh()
  {
    y.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
    if (this.bCc != null) {}
    for (boolean bool = this.bCc.uh();; bool = false)
    {
      long l = System.currentTimeMillis();
      this.gOC -= l;
      y.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[] { Long.valueOf(l), Long.valueOf(this.gOC) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a
 * JD-Core Version:    0.7.0.1
 */