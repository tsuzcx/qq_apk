package com.tencent.mm.compatible.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int fyO;
  public String jvr;
  public long jvs;
  public int jvt;
  
  public a()
  {
    AppMethodBeat.i(155857);
    this.jvr = null;
    this.jvs = -1L;
    this.jvt = -1;
    this.fyO = -1;
    this.jvr = null;
    this.jvs = -1L;
    this.jvt = -1;
    this.fyO = -1;
    AppMethodBeat.o(155857);
  }
  
  public final String avw()
  {
    AppMethodBeat.i(155858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jvr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fyO);
    Log.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155858);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.g.a
 * JD-Core Version:    0.7.0.1
 */