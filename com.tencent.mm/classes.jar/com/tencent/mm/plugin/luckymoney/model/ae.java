package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;

public final class ae
{
  o yPZ;
  private h yVa;
  
  public ae()
  {
    AppMethodBeat.i(213307);
    init();
    AppMethodBeat.o(213307);
  }
  
  private void init()
  {
    AppMethodBeat.i(213308);
    this.yPZ = new o();
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.NTl, null);
    if (Util.isNullOrNil(str))
    {
      this.yPZ.yPy = 2000.0D;
      this.yPZ.yPv = 100;
      this.yPZ.yPz = 200.0D;
      this.yPZ.yPx = 0.01D;
      this.yPZ.yPw = 200.0D;
    }
    for (;;)
    {
      Log.i("MicroMsg.LuckyMoneyUnionConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.yPZ.yPy + " maxTotalNum:" + this.yPZ.yPv + " perGroupMaxValue:" + this.yPZ.yPz + " perMinValue:" + this.yPZ.yPx + " perPersonMaxValue:" + this.yPZ.yPw);
      AppMethodBeat.o(213308);
      return;
      try
      {
        this.yPZ.parseFrom(str.getBytes("ISO-8859-1"));
        efd();
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.LuckyMoneyUnionConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.yPZ.yPy = 2000.0D;
        this.yPZ.yPv = 100;
        this.yPZ.yPz = 200.0D;
        this.yPZ.yPx = 0.01D;
        this.yPZ.yPw = 200.0D;
      }
    }
  }
  
  final void efd()
  {
    AppMethodBeat.i(213309);
    if (this.yPZ != null)
    {
      this.yVa = h.aDt(this.yPZ.yUW);
      if ((this.yVa != null) && (this.yVa.yUC != null))
      {
        ((a)g.af(a.class)).a(this.yVa.yUC);
        g.aAh().azQ().set(ar.a.Ofn, Integer.valueOf(1));
        if (Util.isNullOrNil(this.yPZ.yUX)) {
          break label179;
        }
        Log.d("MicroMsg.LuckyMoneyUnionConfigManager", "parse cover info");
        try
        {
          dlr localdlr = (dlr)new dlr().parseFrom(Base64.decode(this.yPZ.yUX, 0));
          this.yVa.yUC.iwy = localdlr.iwy;
          AppMethodBeat.o(213309);
          return;
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.LuckyMoneyUnionConfigManager", localIOException, "", new Object[0]);
          AppMethodBeat.o(213309);
          return;
        }
      }
      g.aAh().azQ().set(ar.a.Ofn, Integer.valueOf(0));
    }
    label179:
    AppMethodBeat.o(213309);
  }
  
  public final o efe()
  {
    AppMethodBeat.i(213310);
    if (this.yPZ == null) {
      init();
    }
    o localo = this.yPZ;
    AppMethodBeat.o(213310);
    return localo;
  }
  
  public final h eff()
  {
    AppMethodBeat.i(213311);
    if (this.yVa == null) {
      init();
    }
    h localh = this.yVa;
    AppMethodBeat.o(213311);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ae
 * JD-Core Version:    0.7.0.1
 */