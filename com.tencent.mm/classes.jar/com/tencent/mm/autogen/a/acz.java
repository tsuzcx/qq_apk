package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public final class acz
  extends IEvent
{
  public a igq;
  public b igr;
  
  public acz()
  {
    this((byte)0);
  }
  
  private acz(byte paramByte)
  {
    AppMethodBeat.i(63293);
    this.igq = new a();
    this.igr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63293);
  }
  
  public static final class a
  {
    public boolean igs;
    public boolean igt = false;
    public int retryCount = 0;
    public int scene;
  }
  
  public static final class b
  {
    public int errCode = 0;
    public String errMsg;
    public boolean igA;
    public boolean igB;
    public String igC;
    public String igD;
    public String igE;
    public String igF;
    public String igG;
    public String igH;
    public int igI;
    public String igJ;
    public String igK;
    public String igL;
    public String igM;
    public String igN;
    public LinkedList<String> igO;
    public ECardInfo igP;
    public boolean igQ = false;
    public int igR;
    public int igS;
    public boolean igT;
    public String igU;
    public h igV;
    public boolean igW;
    public p igX;
    public ArrayList<t> igY;
    public Runnable igh;
    public boolean igu;
    public boolean igv;
    public boolean igw;
    public boolean igx;
    public String igy;
    public String igz;
    public int scene;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acz
 * JD-Core Version:    0.7.0.1
 */