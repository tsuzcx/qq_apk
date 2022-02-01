package com.tencent.mm.compatible.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public int dcp;
  public String fJM;
  public long fJN;
  public int fJO;
  
  public a()
  {
    AppMethodBeat.i(155857);
    this.fJM = null;
    this.fJN = -1L;
    this.fJO = -1;
    this.dcp = -1;
    this.fJM = null;
    this.fJN = -1L;
    this.fJO = -1;
    this.dcp = -1;
    AppMethodBeat.o(155857);
  }
  
  public final String YA()
  {
    AppMethodBeat.i(155858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fJO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dcp);
    ac.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155858);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a
 * JD-Core Version:    0.7.0.1
 */