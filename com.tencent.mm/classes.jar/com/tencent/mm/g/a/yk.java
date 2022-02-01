package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class yk
  extends b
{
  public a dMG;
  public b dMH;
  
  public yk()
  {
    this((byte)0);
  }
  
  private yk(byte paramByte)
  {
    AppMethodBeat.i(63293);
    this.dMG = new a();
    this.dMH = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(63293);
  }
  
  public static final class a
  {
    public boolean dMI;
    public boolean dMJ = false;
    public int retryCount = 0;
    public int scene;
  }
  
  public static final class b
  {
    public boolean dMK;
    public boolean dML;
    public boolean dMM;
    public boolean dMN;
    public String dMO;
    public String dMP;
    public boolean dMQ;
    public boolean dMR;
    public String dMS;
    public String dMT;
    public String dMU;
    public String dMV;
    public String dMW;
    public String dMX;
    public int dMY;
    public String dMZ;
    public Runnable dMy;
    public String dNa;
    public String dNb;
    public String dNc;
    public LinkedList<String> dNd;
    public ECardInfo dNe;
    public boolean dNf = false;
    public int dNg;
    public int dNh;
    public boolean dNi;
    public String dNj;
    public h dNk;
    public boolean dNl;
    public n dNm;
    public int errCode = 0;
    public String errMsg;
    public int scene;
    public String subtitle;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.yk
 * JD-Core Version:    0.7.0.1
 */