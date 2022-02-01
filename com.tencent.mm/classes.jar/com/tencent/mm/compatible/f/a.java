package com.tencent.mm.compatible.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public int deV;
  public String fGf;
  public long fGg;
  public int fGh;
  
  public a()
  {
    AppMethodBeat.i(155857);
    this.fGf = null;
    this.fGg = -1L;
    this.fGh = -1;
    this.deV = -1;
    this.fGf = null;
    this.fGg = -1L;
    this.fGh = -1;
    this.deV = -1;
    AppMethodBeat.o(155857);
  }
  
  public final String XD()
  {
    AppMethodBeat.i(155858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fGf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fGg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fGh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deV);
    ad.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155858);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a
 * JD-Core Version:    0.7.0.1
 */