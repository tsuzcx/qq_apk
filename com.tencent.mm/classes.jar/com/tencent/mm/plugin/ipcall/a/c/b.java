package com.tencent.mm.plugin.ipcall.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public String countryCode = "";
  public String gAF = "";
  public long nLM = 0L;
  public int nMZ = 0;
  public long nNa = 0L;
  public int nNc = 0;
  public String nOA = "";
  public String nOB = "";
  public String nOC = "";
  public long nOD = 0L;
  public long nOE = 0L;
  public long nOF = 0L;
  public int nOG = 0;
  public int nOH = 0;
  public int nOI = 0;
  public int nOJ = 0;
  public int nOj = 0;
  public int nOk = 0;
  public int nOl = 0;
  public int nOm = 0;
  public int nOn = 0;
  public long nOo = 0L;
  public long nOp = 0L;
  public int nOq = 0;
  public long nOr = 0L;
  public int nOs = 0;
  public long nOt = 0L;
  public int nOu = 0;
  public String nOv = "";
  public long nOw = 0L;
  public long nOx = 0L;
  public long nOy = 0L;
  public long nOz = 0L;
  
  public final void bJJ()
  {
    AppMethodBeat.i(21831);
    ab.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.nOn = 1;
    AppMethodBeat.o(21831);
  }
  
  public final void bJK()
  {
    AppMethodBeat.i(21832);
    ab.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.nOm = 1;
    if ((this.nOF == 0L) && (this.nOw != 0L))
    {
      this.nOF = (System.currentTimeMillis() - this.nOw);
      ab.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.nOF) });
    }
    AppMethodBeat.o(21832);
  }
  
  public final void bJL()
  {
    AppMethodBeat.i(21833);
    ab.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.nOq = 1;
    AppMethodBeat.o(21833);
  }
  
  public final void bJM()
  {
    if (this.nOI == 0) {
      this.nOI = 1;
    }
  }
  
  public final void bJN()
  {
    AppMethodBeat.i(21834);
    ab.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.nOD == 0L)
    {
      this.nOD = System.currentTimeMillis();
      this.nOE = (this.nOD - this.nOw);
      ab.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.nOE) });
    }
    AppMethodBeat.o(21834);
  }
  
  public final void bJO()
  {
    AppMethodBeat.i(21835);
    ab.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.nOy == 0L) {
      this.nOy = System.currentTimeMillis();
    }
    AppMethodBeat.o(21835);
  }
  
  public final void ey(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21830);
    if (this.nNc == paramInt1)
    {
      ab.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt2) });
      this.nOu = paramInt2;
    }
    AppMethodBeat.o(21830);
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(21829);
    ab.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[] { paramString });
    if (!bo.isNullOrNil(paramString)) {
      this.countryCode = paramString;
    }
    AppMethodBeat.o(21829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c.b
 * JD-Core Version:    0.7.0.1
 */