package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;

public final class k
{
  private e vAg;
  j vvL;
  
  public k()
  {
    AppMethodBeat.i(65179);
    init();
    AppMethodBeat.o(65179);
  }
  
  private void init()
  {
    AppMethodBeat.i(65180);
    this.vvL = new j();
    g.ajS();
    String str = (String)g.ajR().ajA().get(356355, null);
    if (bu.isNullOrNil(str))
    {
      this.vvL.vvk = 2000.0D;
      this.vvL.vvh = 100;
      this.vvL.vvl = 200.0D;
      this.vvL.vvj = 0.01D;
      this.vvL.vvi = 200.0D;
    }
    for (;;)
    {
      ae.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.vvL.vvk + " maxTotalNum:" + this.vvL.vvh + " perGroupMaxValue:" + this.vvL.vvl + " perMinValue:" + this.vvL.vvj + " perPersonMaxValue:" + this.vvL.vvi);
      AppMethodBeat.o(65180);
      return;
      try
      {
        this.vvL.parseFrom(str.getBytes("ISO-8859-1"));
        dlj();
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.vvL.vvk = 2000.0D;
        this.vvL.vvh = 100;
        this.vvL.vvl = 200.0D;
        this.vvL.vvj = 0.01D;
        this.vvL.vvi = 200.0D;
      }
    }
  }
  
  final void dlj()
  {
    AppMethodBeat.i(65181);
    if (this.vvL != null)
    {
      this.vAg = e.apX(this.vvL.vAe);
      if ((this.vAg != null) && (this.vAg.vzN != null))
      {
        ((a)g.ab(a.class)).a(this.vAg.vzN);
        g.ajR().ajA().set(am.a.IWU, Integer.valueOf(1));
        if (!bu.isNullOrNil(this.vvL.vAf))
        {
          ae.d("MicroMsg.LuckyMoneyConfigManager", "parse cover info");
          try
          {
            ctb localctb = (ctb)new ctb().parseFrom(Base64.decode(this.vvL.vAf, 0));
            this.vAg.vzN.hCs = localctb.hCs;
            AppMethodBeat.o(65181);
            return;
          }
          catch (IOException localIOException)
          {
            ae.printErrStackTrace("MicroMsg.LuckyMoneyConfigManager", localIOException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(65181);
  }
  
  public final j dlk()
  {
    AppMethodBeat.i(65182);
    if (this.vvL == null) {
      init();
    }
    j localj = this.vvL;
    AppMethodBeat.o(65182);
    return localj;
  }
  
  public final e dll()
  {
    AppMethodBeat.i(65183);
    if (this.vAg == null) {
      init();
    }
    e locale = this.vAg;
    AppMethodBeat.o(65183);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.k
 * JD-Core Version:    0.7.0.1
 */