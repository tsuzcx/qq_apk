package com.tencent.mm.plugin.ipcall.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
{
  public String countryCode = "";
  public String iOg = "";
  public int roomId = 0;
  public long tHo = 0L;
  public long tIG = 0L;
  public int tII = 0;
  public int tJM = 0;
  public int tJN = 0;
  public int tJO = 0;
  public int tJP = 0;
  public int tJQ = 0;
  public long tJR = 0L;
  public long tJS = 0L;
  public int tJT = 0;
  public long tJU = 0L;
  public int tJV = 0;
  public long tJW = 0L;
  public int tJX = 0;
  public String tJY = "";
  public long tJZ = 0L;
  public long tKa = 0L;
  public long tKb = 0L;
  public long tKc = 0L;
  public String tKd = "";
  public String tKe = "";
  public String tKf = "";
  public long tKg = 0L;
  public long tKh = 0L;
  public long tKi = 0L;
  public int tKj = 0;
  public int tKk = 0;
  public int tKl = 0;
  public int tKm = 0;
  
  public final void cUR()
  {
    AppMethodBeat.i(25446);
    ac.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.tJQ = 1;
    AppMethodBeat.o(25446);
  }
  
  public final void cUS()
  {
    AppMethodBeat.i(25447);
    ac.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.tJP = 1;
    if ((this.tKi == 0L) && (this.tJZ != 0L))
    {
      this.tKi = (System.currentTimeMillis() - this.tJZ);
      ac.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.tKi) });
    }
    AppMethodBeat.o(25447);
  }
  
  public final void cUT()
  {
    AppMethodBeat.i(25448);
    ac.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.tJT = 1;
    AppMethodBeat.o(25448);
  }
  
  public final void cUU()
  {
    if (this.tKl == 0) {
      this.tKl = 1;
    }
  }
  
  public final void cUV()
  {
    AppMethodBeat.i(25449);
    ac.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.tKg == 0L)
    {
      this.tKg = System.currentTimeMillis();
      this.tKh = (this.tKg - this.tJZ);
      ac.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.tKh) });
    }
    AppMethodBeat.o(25449);
  }
  
  public final void cUW()
  {
    AppMethodBeat.i(25450);
    ac.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.tKb == 0L) {
      this.tKb = System.currentTimeMillis();
    }
    AppMethodBeat.o(25450);
  }
  
  public final void gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25445);
    if (this.tII == paramInt1)
    {
      ac.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt2) });
      this.tJX = paramInt2;
    }
    AppMethodBeat.o(25445);
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(25444);
    ac.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[] { paramString });
    if (!bs.isNullOrNil(paramString)) {
      this.countryCode = paramString;
    }
    AppMethodBeat.o(25444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.b
 * JD-Core Version:    0.7.0.1
 */