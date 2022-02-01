package com.tencent.mm.plugin.ipcall.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public long DOr = 0L;
  public long DPJ = 0L;
  public int DPL = 0;
  public int DQO = 0;
  public int DQP = 0;
  public int DQQ = 0;
  public int DQR = 0;
  public int DQS = 0;
  public long DQT = 0L;
  public long DQU = 0L;
  public int DQV = 0;
  public long DQW = 0L;
  public int DQX = 0;
  public long DQY = 0L;
  public int DQZ = 0;
  public String DRa = "";
  public long DRb = 0L;
  public long DRc = 0L;
  public long DRd = 0L;
  public long DRe = 0L;
  public String DRf = "";
  public String DRg = "";
  public String DRh = "";
  public long DRi = 0L;
  public long DRj = 0L;
  public long DRk = 0L;
  public int DRl = 0;
  public int DRm = 0;
  public int DRn = 0;
  public int DRo = 0;
  public String countryCode = "";
  public String mZK = "";
  public int roomId = 0;
  
  public final void eJM()
  {
    AppMethodBeat.i(25446);
    Log.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.DQS = 1;
    AppMethodBeat.o(25446);
  }
  
  public final void eJN()
  {
    AppMethodBeat.i(25447);
    Log.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.DQR = 1;
    if ((this.DRk == 0L) && (this.DRb != 0L))
    {
      this.DRk = (System.currentTimeMillis() - this.DRb);
      Log.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.DRk) });
    }
    AppMethodBeat.o(25447);
  }
  
  public final void eJO()
  {
    AppMethodBeat.i(25448);
    Log.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.DQV = 1;
    AppMethodBeat.o(25448);
  }
  
  public final void eJP()
  {
    if (this.DRn == 0) {
      this.DRn = 1;
    }
  }
  
  public final void eJQ()
  {
    AppMethodBeat.i(25449);
    Log.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.DRi == 0L)
    {
      this.DRi = System.currentTimeMillis();
      this.DRj = (this.DRi - this.DRb);
      Log.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.DRj) });
    }
    AppMethodBeat.o(25449);
  }
  
  public final void eJR()
  {
    AppMethodBeat.i(25450);
    Log.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.DRd == 0L) {
      this.DRd = System.currentTimeMillis();
    }
    AppMethodBeat.o(25450);
  }
  
  public final void hU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25445);
    if (this.DPL == paramInt1)
    {
      Log.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt2) });
      this.DQZ = paramInt2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.d.b
 * JD-Core Version:    0.7.0.1
 */