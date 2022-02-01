package com.tencent.mm.compatible.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int hDx;
  public String lYI;
  public long lYJ;
  public int lYK;
  
  public a()
  {
    AppMethodBeat.i(155857);
    this.lYI = null;
    this.lYJ = -1L;
    this.lYK = -1;
    this.hDx = -1;
    this.lYI = null;
    this.lYJ = -1L;
    this.lYK = -1;
    this.hDx = -1;
    AppMethodBeat.o(155857);
  }
  
  public final String aPQ()
  {
    AppMethodBeat.i(155858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.lYI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hDx);
    Log.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155858);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.g.a
 * JD-Core Version:    0.7.0.1
 */