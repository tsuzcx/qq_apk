package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;

public final class k
{
  j ugW;
  private e ulv;
  
  public k()
  {
    AppMethodBeat.i(65179);
    init();
    AppMethodBeat.o(65179);
  }
  
  private void init()
  {
    AppMethodBeat.i(65180);
    this.ugW = new j();
    g.agS();
    String str = (String)g.agR().agA().get(356355, null);
    if (bs.isNullOrNil(str))
    {
      this.ugW.ugv = 2000.0D;
      this.ugW.ugs = 100;
      this.ugW.ugw = 200.0D;
      this.ugW.ugu = 0.01D;
      this.ugW.ugt = 200.0D;
    }
    for (;;)
    {
      ac.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.ugW.ugv + " maxTotalNum:" + this.ugW.ugs + " perGroupMaxValue:" + this.ugW.ugw + " perMinValue:" + this.ugW.ugu + " perPersonMaxValue:" + this.ugW.ugt);
      AppMethodBeat.o(65180);
      return;
      try
      {
        this.ugW.parseFrom(str.getBytes("ISO-8859-1"));
        cYY();
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.ugW.ugv = 2000.0D;
        this.ugW.ugs = 100;
        this.ugW.ugw = 200.0D;
        this.ugW.ugu = 0.01D;
        this.ugW.ugt = 200.0D;
      }
    }
  }
  
  final void cYY()
  {
    AppMethodBeat.i(65181);
    if (this.ugW != null)
    {
      this.ulv = e.akf(this.ugW.ult);
      if ((this.ulv != null) && (this.ulv.ulc != null))
      {
        ((a)g.ab(a.class)).a(this.ulv.ulc);
        g.agR().agA().set(ah.a.GQa, Integer.valueOf(1));
        if (!bs.isNullOrNil(this.ugW.ulu))
        {
          ac.d("MicroMsg.LuckyMoneyConfigManager", "parse cover info");
          try
          {
            cne localcne = (cne)new cne().parseFrom(Base64.decode(this.ugW.ulu, 0));
            this.ulv.ulc.hhv = localcne.hhv;
            AppMethodBeat.o(65181);
            return;
          }
          catch (IOException localIOException)
          {
            ac.printErrStackTrace("MicroMsg.LuckyMoneyConfigManager", localIOException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(65181);
  }
  
  public final j cYZ()
  {
    AppMethodBeat.i(65182);
    if (this.ugW == null) {
      init();
    }
    j localj = this.ugW;
    AppMethodBeat.o(65182);
    return localj;
  }
  
  public final e cZa()
  {
    AppMethodBeat.i(65183);
    if (this.ulv == null) {
      init();
    }
    e locale = this.ulv;
    AppMethodBeat.o(65183);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.k
 * JD-Core Version:    0.7.0.1
 */