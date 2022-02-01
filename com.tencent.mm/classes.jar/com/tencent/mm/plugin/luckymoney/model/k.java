package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;

public final class k
{
  j vjG;
  private e vob;
  
  public k()
  {
    AppMethodBeat.i(65179);
    init();
    AppMethodBeat.o(65179);
  }
  
  private void init()
  {
    AppMethodBeat.i(65180);
    this.vjG = new j();
    g.ajD();
    String str = (String)g.ajC().ajl().get(356355, null);
    if (bt.isNullOrNil(str))
    {
      this.vjG.vjf = 2000.0D;
      this.vjG.vjc = 100;
      this.vjG.vjg = 200.0D;
      this.vjG.vje = 0.01D;
      this.vjG.vjd = 200.0D;
    }
    for (;;)
    {
      ad.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.vjG.vjf + " maxTotalNum:" + this.vjG.vjc + " perGroupMaxValue:" + this.vjG.vjg + " perMinValue:" + this.vjG.vje + " perPersonMaxValue:" + this.vjG.vjd);
      AppMethodBeat.o(65180);
      return;
      try
      {
        this.vjG.parseFrom(str.getBytes("ISO-8859-1"));
        dik();
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.vjG.vjf = 2000.0D;
        this.vjG.vjc = 100;
        this.vjG.vjg = 200.0D;
        this.vjG.vje = 0.01D;
        this.vjG.vjd = 200.0D;
      }
    }
  }
  
  final void dik()
  {
    AppMethodBeat.i(65181);
    if (this.vjG != null)
    {
      this.vob = e.aoS(this.vjG.vnZ);
      if ((this.vob != null) && (this.vob.vnI != null))
      {
        ((a)g.ab(a.class)).a(this.vob.vnI);
        g.ajC().ajl().set(al.a.ICu, Integer.valueOf(1));
        if (!bt.isNullOrNil(this.vjG.voa))
        {
          ad.d("MicroMsg.LuckyMoneyConfigManager", "parse cover info");
          try
          {
            csh localcsh = (csh)new csh().parseFrom(Base64.decode(this.vjG.voa, 0));
            this.vob.vnI.hzE = localcsh.hzE;
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
  
  public final j dil()
  {
    AppMethodBeat.i(65182);
    if (this.vjG == null) {
      init();
    }
    j localj = this.vjG;
    AppMethodBeat.o(65182);
    return localj;
  }
  
  public final e dim()
  {
    AppMethodBeat.i(65183);
    if (this.vob == null) {
      init();
    }
    e locale = this.vob;
    AppMethodBeat.o(65183);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.k
 * JD-Core Version:    0.7.0.1
 */