package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class zv
  extends IEvent
{
  public a efR;
  public b efS;
  
  public zv()
  {
    this((byte)0);
  }
  
  private zv(byte paramByte)
  {
    AppMethodBeat.i(63293);
    this.efR = new a();
    this.efS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63293);
  }
  
  public static final class a
  {
    public boolean efT;
    public boolean efU = false;
    public int retryCount = 0;
    public int scene;
  }
  
  public static final class b
  {
    public Runnable efJ;
    public boolean efV;
    public boolean efW;
    public boolean efX;
    public boolean efY;
    public String efZ;
    public String ega;
    public boolean egb;
    public boolean egc;
    public String egd;
    public String ege;
    public String egf;
    public String egg;
    public String egh;
    public String egi;
    public int egj;
    public String egk;
    public String egm;
    public String egn;
    public String ego;
    public LinkedList<String> egp;
    public ECardInfo egq;
    public boolean egr = false;
    public int egs;
    public int egt;
    public boolean egu;
    public String egv;
    public h egw;
    public boolean egx;
    public q egy;
    public int errCode = 0;
    public String errMsg;
    public int scene;
    public String subtitle;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zv
 * JD-Core Version:    0.7.0.1
 */