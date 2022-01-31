package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class j
{
  i oiV;
  private d onp;
  
  public j()
  {
    AppMethodBeat.i(42289);
    init();
    AppMethodBeat.o(42289);
  }
  
  private void init()
  {
    AppMethodBeat.i(42290);
    this.oiV = new i();
    g.RM();
    String str = (String)g.RL().Ru().get(356355, null);
    if (bo.isNullOrNil(str))
    {
      this.oiV.oiu = 2000.0D;
      this.oiV.oir = 100;
      this.oiV.oiv = 200.0D;
      this.oiV.oit = 0.01D;
      this.oiV.ois = 200.0D;
    }
    for (;;)
    {
      ab.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.oiV.oiu + " maxTotalNum:" + this.oiV.oir + " perGroupMaxValue:" + this.oiV.oiv + " perMinValue:" + this.oiV.oit + " perPersonMaxValue:" + this.oiV.ois);
      AppMethodBeat.o(42290);
      return;
      try
      {
        this.oiV.parseFrom(str.getBytes("ISO-8859-1"));
        bNj();
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.oiV.oiu = 2000.0D;
        this.oiV.oir = 100;
        this.oiV.oiv = 200.0D;
        this.oiV.oit = 0.01D;
        this.oiV.ois = 200.0D;
      }
    }
  }
  
  final void bNj()
  {
    AppMethodBeat.i(42291);
    if (this.oiV != null)
    {
      this.onp = d.Sq(this.oiV.ono);
      if ((this.onp != null) && (this.onp.omW != null))
      {
        ((a)g.E(a.class)).a(this.onp.omW.xjM);
        g.RL().Ru().set(ac.a.yJl, Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(42291);
  }
  
  public final i bNk()
  {
    AppMethodBeat.i(42292);
    if (this.oiV == null) {
      init();
    }
    i locali = this.oiV;
    AppMethodBeat.o(42292);
    return locali;
  }
  
  public final d bNl()
  {
    AppMethodBeat.i(42293);
    if (this.onp == null) {
      init();
    }
    d locald = this.onp;
    AppMethodBeat.o(42293);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.j
 * JD-Core Version:    0.7.0.1
 */