package com.tencent.mm.plugin.ipcall.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public long Hnt = 0L;
  public long JFG = 0L;
  public int JGW = 0;
  public int JHY = 0;
  public int JHZ = 0;
  public int JIa = 0;
  public int JIb = 0;
  public int JIc = 0;
  public long JId = 0L;
  public long JIe = 0L;
  public int JIf = 0;
  public long JIg = 0L;
  public int JIh = 0;
  public long JIi = 0L;
  public int JIj = 0;
  public String JIk = "";
  public long JIl = 0L;
  public long JIm = 0L;
  public long JIn = 0L;
  public long JIo = 0L;
  public String JIp = "";
  public String JIq = "";
  public String JIr = "";
  public long JIs = 0L;
  public long JIt = 0L;
  public long JIu = 0L;
  public int JIv = 0;
  public int JIw = 0;
  public int JIx = 0;
  public int JIy = 0;
  public String countryCode = "";
  public String pWt = "";
  public int roomId = 0;
  
  public final void fRM()
  {
    AppMethodBeat.i(25446);
    Log.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.JIc = 1;
    AppMethodBeat.o(25446);
  }
  
  public final void fRN()
  {
    AppMethodBeat.i(25447);
    Log.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.JIb = 1;
    if ((this.JIu == 0L) && (this.JIl != 0L))
    {
      this.JIu = (System.currentTimeMillis() - this.JIl);
      Log.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.JIu) });
    }
    AppMethodBeat.o(25447);
  }
  
  public final void fRO()
  {
    AppMethodBeat.i(25448);
    Log.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.JIf = 1;
    AppMethodBeat.o(25448);
  }
  
  public final void fRP()
  {
    if (this.JIx == 0) {
      this.JIx = 1;
    }
  }
  
  public final void fRQ()
  {
    AppMethodBeat.i(25449);
    Log.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.JIs == 0L)
    {
      this.JIs = System.currentTimeMillis();
      this.JIt = (this.JIs - this.JIl);
      Log.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.JIt) });
    }
    AppMethodBeat.o(25449);
  }
  
  public final void fRR()
  {
    AppMethodBeat.i(25450);
    Log.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.JIn == 0L) {
      this.JIn = System.currentTimeMillis();
    }
    AppMethodBeat.o(25450);
  }
  
  public final void jy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25445);
    if (this.JGW == paramInt1)
    {
      Log.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt2) });
      this.JIj = paramInt2;
    }
    AppMethodBeat.o(25445);
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(25444);
    Log.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString)) {
      this.countryCode = paramString;
    }
    AppMethodBeat.o(25444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.b
 * JD-Core Version:    0.7.0.1
 */