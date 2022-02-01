package com.tencent.mm.plugin.ipcall.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public String countryCode = "";
  public String ioa = "";
  public int roomId = 0;
  public long sAY = 0L;
  public int sBa = 0;
  public long sCA = 0L;
  public int sCB = 0;
  public int sCC = 0;
  public int sCD = 0;
  public int sCE = 0;
  public int sCe = 0;
  public int sCf = 0;
  public int sCg = 0;
  public int sCh = 0;
  public int sCi = 0;
  public long sCj = 0L;
  public long sCk = 0L;
  public int sCl = 0;
  public long sCm = 0L;
  public int sCn = 0;
  public long sCo = 0L;
  public int sCp = 0;
  public String sCq = "";
  public long sCr = 0L;
  public long sCs = 0L;
  public long sCt = 0L;
  public long sCu = 0L;
  public String sCv = "";
  public String sCw = "";
  public String sCx = "";
  public long sCy = 0L;
  public long sCz = 0L;
  public long szE = 0L;
  
  public final void cHG()
  {
    AppMethodBeat.i(25446);
    ad.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.sCi = 1;
    AppMethodBeat.o(25446);
  }
  
  public final void cHH()
  {
    AppMethodBeat.i(25447);
    ad.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.sCh = 1;
    if ((this.sCA == 0L) && (this.sCr != 0L))
    {
      this.sCA = (System.currentTimeMillis() - this.sCr);
      ad.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.sCA) });
    }
    AppMethodBeat.o(25447);
  }
  
  public final void cHI()
  {
    AppMethodBeat.i(25448);
    ad.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.sCl = 1;
    AppMethodBeat.o(25448);
  }
  
  public final void cHJ()
  {
    if (this.sCD == 0) {
      this.sCD = 1;
    }
  }
  
  public final void cHK()
  {
    AppMethodBeat.i(25449);
    ad.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.sCy == 0L)
    {
      this.sCy = System.currentTimeMillis();
      this.sCz = (this.sCy - this.sCr);
      ad.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.sCz) });
    }
    AppMethodBeat.o(25449);
  }
  
  public final void cHL()
  {
    AppMethodBeat.i(25450);
    ad.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.sCt == 0L) {
      this.sCt = System.currentTimeMillis();
    }
    AppMethodBeat.o(25450);
  }
  
  public final void fU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25445);
    if (this.sBa == paramInt1)
    {
      ad.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt2) });
      this.sCp = paramInt2;
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