package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public final class abc
  extends IEvent
{
  public a gah;
  public b gai;
  
  public abc()
  {
    this((byte)0);
  }
  
  private abc(byte paramByte)
  {
    AppMethodBeat.i(63293);
    this.gah = new a();
    this.gai = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63293);
  }
  
  public static final class a
  {
    public boolean gaj;
    public boolean gak = false;
    public int retryCount = 0;
    public int scene;
  }
  
  public static final class b
  {
    public int errCode = 0;
    public String errMsg;
    public Runnable fZZ;
    public String gaA;
    public String gaB;
    public String gaC;
    public String gaD;
    public LinkedList<String> gaE;
    public ECardInfo gaF;
    public boolean gaG = false;
    public int gaH;
    public int gaI;
    public boolean gaJ;
    public String gaK;
    public h gaL;
    public boolean gaM;
    public q gaN;
    public ArrayList<t> gaO;
    public boolean gal;
    public boolean gam;
    public boolean gan;
    public boolean gao;
    public String gap;
    public String gaq;
    public boolean gar;
    public boolean gas;
    public String gat;
    public String gau;
    public String gav;
    public String gaw;
    public String gax;
    public String gay;
    public int gaz;
    public int scene;
    public String subtitle;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abc
 * JD-Core Version:    0.7.0.1
 */