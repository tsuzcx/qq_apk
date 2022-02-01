package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;

public final class k
{
  j sYI;
  private e tdg;
  
  public k()
  {
    AppMethodBeat.i(65179);
    init();
    AppMethodBeat.o(65179);
  }
  
  private void init()
  {
    AppMethodBeat.i(65180);
    this.sYI = new j();
    g.afC();
    String str = (String)g.afB().afk().get(356355, null);
    if (bt.isNullOrNil(str))
    {
      this.sYI.sYh = 2000.0D;
      this.sYI.sYe = 100;
      this.sYI.sYi = 200.0D;
      this.sYI.sYg = 0.01D;
      this.sYI.sYf = 200.0D;
    }
    for (;;)
    {
      ad.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.sYI.sYh + " maxTotalNum:" + this.sYI.sYe + " perGroupMaxValue:" + this.sYI.sYi + " perMinValue:" + this.sYI.sYg + " perPersonMaxValue:" + this.sYI.sYf);
      AppMethodBeat.o(65180);
      return;
      try
      {
        this.sYI.parseFrom(str.getBytes("ISO-8859-1"));
        cLs();
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.sYI.sYh = 2000.0D;
        this.sYI.sYe = 100;
        this.sYI.sYi = 200.0D;
        this.sYI.sYg = 0.01D;
        this.sYI.sYf = 200.0D;
      }
    }
  }
  
  final void cLs()
  {
    AppMethodBeat.i(65181);
    if (this.sYI != null)
    {
      this.tdg = e.afl(this.sYI.tde);
      if ((this.tdg != null) && (this.tdg.tcN != null))
      {
        ((a)g.ab(a.class)).a(this.tdg.tcN);
        g.afB().afk().set(ae.a.Fsj, Integer.valueOf(1));
        if (!bt.isNullOrNil(this.sYI.tdf))
        {
          ad.d("MicroMsg.LuckyMoneyConfigManager", "parse cover info");
          try
          {
            cia localcia = (cia)new cia().parseFrom(Base64.decode(this.sYI.tdf, 0));
            this.tdg.tcN.gGU = localcia.gGU;
            AppMethodBeat.o(65181);
            return;
          }
          catch (IOException localIOException)
          {
            ad.printErrStackTrace("MicroMsg.LuckyMoneyConfigManager", localIOException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(65181);
  }
  
  public final j cLt()
  {
    AppMethodBeat.i(65182);
    if (this.sYI == null) {
      init();
    }
    j localj = this.sYI;
    AppMethodBeat.o(65182);
    return localj;
  }
  
  public final e cLu()
  {
    AppMethodBeat.i(65183);
    if (this.tdg == null) {
      init();
    }
    e locale = this.tdg;
    AppMethodBeat.o(65183);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.k
 * JD-Core Version:    0.7.0.1
 */