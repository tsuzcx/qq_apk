package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class yq
  extends b
{
  public a dNW;
  public b dNX;
  
  public yq()
  {
    this((byte)0);
  }
  
  private yq(byte paramByte)
  {
    AppMethodBeat.i(63293);
    this.dNW = new a();
    this.dNX = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(63293);
  }
  
  public static final class a
  {
    public boolean dNY;
    public boolean dNZ = false;
    public int retryCount = 0;
    public int scene;
  }
  
  public static final class b
  {
    public Runnable dNO;
    public h dOA;
    public boolean dOB;
    public n dOC;
    public boolean dOa;
    public boolean dOb;
    public boolean dOc;
    public boolean dOd;
    public String dOe;
    public String dOf;
    public boolean dOg;
    public boolean dOh;
    public String dOi;
    public String dOj;
    public String dOk;
    public String dOl;
    public String dOm;
    public String dOn;
    public int dOo;
    public String dOp;
    public String dOq;
    public String dOr;
    public String dOs;
    public LinkedList<String> dOt;
    public ECardInfo dOu;
    public boolean dOv = false;
    public int dOw;
    public int dOx;
    public boolean dOy;
    public String dOz;
    public int errCode = 0;
    public String errMsg;
    public int scene;
    public String subtitle;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.yq
 * JD-Core Version:    0.7.0.1
 */