package com.tencent.mm.compatible.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public int dnL;
  public String gdn;
  public long gdo;
  public int gdp;
  
  public a()
  {
    AppMethodBeat.i(155857);
    this.gdn = null;
    this.gdo = -1L;
    this.gdp = -1;
    this.dnL = -1;
    this.gdn = null;
    this.gdo = -1L;
    this.gdp = -1;
    this.dnL = -1;
    AppMethodBeat.o(155857);
  }
  
  public final String abc()
  {
    AppMethodBeat.i(155858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dnL);
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