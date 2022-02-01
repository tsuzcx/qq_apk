package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class xq
  extends b
{
  public a dAt;
  public b dAu;
  
  public xq()
  {
    this((byte)0);
  }
  
  private xq(byte paramByte)
  {
    AppMethodBeat.i(63293);
    this.dAt = new a();
    this.dAu = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(63293);
  }
  
  public static final class a
  {
    public boolean dAv;
    public boolean dAw = false;
    public int retryCount = 0;
    public int scene;
  }
  
  public static final class b
  {
    public boolean dAA;
    public String dAB;
    public String dAC;
    public boolean dAD;
    public boolean dAE;
    public String dAF;
    public String dAG;
    public String dAH;
    public String dAI;
    public String dAJ;
    public String dAK;
    public int dAL;
    public String dAM;
    public String dAN;
    public String dAO;
    public String dAP;
    public LinkedList<String> dAQ;
    public ECardInfo dAR;
    public boolean dAS = false;
    public int dAT;
    public int dAU;
    public boolean dAV;
    public String dAW;
    public h dAX;
    public boolean dAY;
    public n dAZ;
    public Runnable dAl;
    public boolean dAx;
    public boolean dAy;
    public boolean dAz;
    public int errCode = 0;
    public String errMsg;
    public int scene;
    public String subtitle;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.xq
 * JD-Core Version:    0.7.0.1
 */