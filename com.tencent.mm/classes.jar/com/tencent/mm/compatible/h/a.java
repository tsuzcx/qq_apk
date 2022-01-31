package com.tencent.mm.compatible.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public int cpX;
  public String ese;
  public long esf;
  public int esg;
  
  public a()
  {
    AppMethodBeat.i(93052);
    this.ese = null;
    this.esf = -1L;
    this.esg = -1;
    this.cpX = -1;
    this.ese = null;
    this.esf = -1L;
    this.esg = -1;
    this.cpX = -1;
    AppMethodBeat.o(93052);
  }
  
  public final String Mf()
  {
    AppMethodBeat.i(93053);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ese);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpX);
    ab.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(93053);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.h.a
 * JD-Core Version:    0.7.0.1
 */