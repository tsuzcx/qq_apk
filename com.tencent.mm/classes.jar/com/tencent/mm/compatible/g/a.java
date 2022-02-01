package com.tencent.mm.compatible.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int dGe;
  public String gLc;
  public long gLd;
  public int gLe;
  
  public a()
  {
    AppMethodBeat.i(155857);
    this.gLc = null;
    this.gLd = -1L;
    this.gLe = -1;
    this.dGe = -1;
    this.gLc = null;
    this.gLd = -1L;
    this.gLe = -1;
    this.dGe = -1;
    AppMethodBeat.o(155857);
  }
  
  public final String apk()
  {
    AppMethodBeat.i(155858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gLc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGe);
    Log.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155858);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.g.a
 * JD-Core Version:    0.7.0.1
 */