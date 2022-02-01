package com.tencent.mm.compatible.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public int doQ;
  public String gfv;
  public long gfw;
  public int gfx;
  
  public a()
  {
    AppMethodBeat.i(155857);
    this.gfv = null;
    this.gfw = -1L;
    this.gfx = -1;
    this.doQ = -1;
    this.gfv = null;
    this.gfw = -1L;
    this.gfx = -1;
    this.doQ = -1;
    AppMethodBeat.o(155857);
  }
  
  public final String abl()
  {
    AppMethodBeat.i(155858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.doQ);
    ae.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155858);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a
 * JD-Core Version:    0.7.0.1
 */