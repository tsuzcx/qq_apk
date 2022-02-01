package com.tencent.mm.plugin.ipcall.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public String countryCode = "";
  public String jhp = "";
  public int roomId = 0;
  public long uKb = 0L;
  public long uLt = 0L;
  public int uLv = 0;
  public int uMA = 0;
  public int uMB = 0;
  public int uMC = 0;
  public int uMD = 0;
  public long uME = 0L;
  public long uMF = 0L;
  public int uMG = 0;
  public long uMH = 0L;
  public int uMI = 0;
  public long uMJ = 0L;
  public int uMK = 0;
  public String uML = "";
  public long uMM = 0L;
  public long uMN = 0L;
  public long uMO = 0L;
  public long uMP = 0L;
  public String uMQ = "";
  public String uMR = "";
  public String uMS = "";
  public long uMT = 0L;
  public long uMU = 0L;
  public long uMV = 0L;
  public int uMW = 0;
  public int uMX = 0;
  public int uMY = 0;
  public int uMZ = 0;
  public int uMz = 0;
  
  public final void dec()
  {
    AppMethodBeat.i(25446);
    ad.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.uMD = 1;
    AppMethodBeat.o(25446);
  }
  
  public final void ded()
  {
    AppMethodBeat.i(25447);
    ad.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.uMC = 1;
    if ((this.uMV == 0L) && (this.uMM != 0L))
    {
      this.uMV = (System.currentTimeMillis() - this.uMM);
      ad.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.uMV) });
    }
    AppMethodBeat.o(25447);
  }
  
  public final void dee()
  {
    AppMethodBeat.i(25448);
    ad.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.uMG = 1;
    AppMethodBeat.o(25448);
  }
  
  public final void def()
  {
    if (this.uMY == 0) {
      this.uMY = 1;
    }
  }
  
  public final void deg()
  {
    AppMethodBeat.i(25449);
    ad.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.uMT == 0L)
    {
      this.uMT = System.currentTimeMillis();
      this.uMU = (this.uMT - this.uMM);
      ad.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.uMU) });
    }
    AppMethodBeat.o(25449);
  }
  
  public final void deh()
  {
    AppMethodBeat.i(25450);
    ad.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.uMO == 0L) {
      this.uMO = System.currentTimeMillis();
    }
    AppMethodBeat.o(25450);
  }
  
  public final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25445);
    if (this.uLv == paramInt1)
    {
      ad.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt2) });
      this.uMK = paramInt2;
    }
    AppMethodBeat.o(25445);
  }
  
  public final void setCountryCode(String paramString)
  {
    AppMethodBeat.i(25444);
    ad.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[] { paramString });
    if (!bt.isNullOrNil(paramString)) {
      this.countryCode = paramString;
    }
    AppMethodBeat.o(25444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.b
 * JD-Core Version:    0.7.0.1
 */