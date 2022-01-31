package com.tencent.mm.plugin.ipcall.a.c;

import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public String countryCode = "";
  public String fjn = "";
  public long loq = 0L;
  public int lpD = 0;
  public long lpE = 0L;
  public int lpG = 0;
  public int lqN = 0;
  public int lqO = 0;
  public int lqP = 0;
  public int lqQ = 0;
  public int lqR = 0;
  public long lqS = 0L;
  public long lqT = 0L;
  public int lqU = 0;
  public long lqV = 0L;
  public int lqW = 0;
  public long lqX = 0L;
  public int lqY = 0;
  public String lqZ = "";
  public long lra = 0L;
  public long lrb = 0L;
  public long lrc = 0L;
  public long lrd = 0L;
  public String lre = "";
  public String lrf = "";
  public String lrg = "";
  public long lrh = 0L;
  public long lri = 0L;
  public long lrj = 0L;
  public int lrk = 0;
  public int lrl = 0;
  public int lrm = 0;
  public int lrn = 0;
  
  public final void bcC()
  {
    y.i("MicroMsg.IPCallReportHelper", "selfShutdown");
    this.lqR = 1;
  }
  
  public final void bcD()
  {
    y.i("MicroMsg.IPCallReportHelper", "selfCancel");
    this.lqQ = 1;
    if ((this.lrj == 0L) && (this.lra != 0L))
    {
      this.lrj = (System.currentTimeMillis() - this.lra);
      y.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[] { Long.valueOf(this.lrj) });
    }
  }
  
  public final void bcE()
  {
    y.i("MicroMsg.IPCallReportHelper", "channelConnect");
    this.lqU = 1;
  }
  
  public final void bcF()
  {
    if (this.lrm == 0) {
      this.lrm = 1;
    }
  }
  
  public final void bcG()
  {
    y.d("MicroMsg.IPCallReportHelper", "markConnect");
    if (this.lrh == 0L)
    {
      this.lrh = System.currentTimeMillis();
      this.lri = (this.lrh - this.lra);
      y.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[] { Long.valueOf(this.lri) });
    }
  }
  
  public final void bcH()
  {
    y.d("MicroMsg.IPCallReportHelper", "markStartTalk");
    if (this.lrc == 0L) {
      this.lrc = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c.b
 * JD-Core Version:    0.7.0.1
 */