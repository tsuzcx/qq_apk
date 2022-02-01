package com.tencent.mm.plugin.ipcall.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  public String countryCode = "";
  public String jki = "";
  public int roomId = 0;
  public long uVO = 0L;
  public long uXg = 0L;
  public int uXi = 0;
  public long uYA = 0L;
  public long uYB = 0L;
  public long uYC = 0L;
  public String uYD = "";
  public String uYE = "";
  public String uYF = "";
  public long uYG = 0L;
  public long uYH = 0L;
  public long uYI = 0L;
  public int uYJ = 0;
  public int uYK = 0;
  public int uYL = 0;
  public int uYM = 0;
  public int uYm = 0;
  public int uYn = 0;
  public int uYo = 0;
  public int uYp = 0;
  public int uYq = 0;
  public long uYr = 0L;
  public long uYs = 0L;
  public int uYt = 0;
  public long uYu = 0L;
  public int uYv = 0;
  public long uYw = 0L;
  public int uYx = 0;
  public String uYy = "";
  public long uYz = 0L;
  
  public final void dgU()
  {
    AppMethodBeat.i(25446);
    ae.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.uYq = 1;
    AppMethodBeat.o(25446);
  }
  
  public final void dgV()
  {
    AppMethodBeat.i(25447);
    ae.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.uYp = 1;
    if ((this.uYI == 0L) && (this.uYz != 0L))
    {
      this.uYI = (System.currentTimeMillis() - this.uYz);
      ae.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.uYI) });
    }
    AppMethodBeat.o(25447);
  }
  
  public final void dgW()
  {
    AppMethodBeat.i(25448);
    ae.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.uYt = 1;
    AppMethodBeat.o(25448);
  }
  
  public final void dgX()
  {
    if (this.uYL == 0) {
      this.uYL = 1;
    }
  }
  
  public final void dgY()
  {
    AppMethodBeat.i(25449);
    ae.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.uYG == 0L)
    {
      this.uYG = System.currentTimeMillis();
      this.uYH = (this.uYG - this.uYz);
      ae.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.uYH) });
    }
    AppMethodBeat.o(25449);
  }
  
  public final void dgZ()
  {
    AppMethodBeat.i(25450);
    ae.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.uYB == 0L) {
      this.uYB = System.currentTimeMillis();
    }
    AppMethodBeat.o(25450);
  }
  
  public final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25445);
    if (this.uXi == paramInt1)
    {
      ae.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt2) });
      this.uYx = paramInt2;
    }
    AppMethodBeat.o(25445);
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(25444);
    ae.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[] { paramString });
    if (!bu.isNullOrNil(paramString)) {
      this.countryCode = paramString;
    }
    AppMethodBeat.o(25444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.b
 * JD-Core Version:    0.7.0.1
 */