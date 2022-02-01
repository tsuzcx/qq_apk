package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.eof;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;

public final class p
{
  o KmF;
  private i KrK;
  
  public p()
  {
    AppMethodBeat.i(65179);
    init();
    AppMethodBeat.o(65179);
  }
  
  private void init()
  {
    AppMethodBeat.i(65180);
    this.KmF = new o();
    h.baF();
    String str = (String)h.baE().ban().d(356355, null);
    if (Util.isNullOrNil(str))
    {
      this.KmF.Kme = 2000.0D;
      this.KmF.Kmb = 100;
      this.KmF.Kmf = 200.0D;
      this.KmF.Kmd = 0.01D;
      this.KmF.Kmc = 200.0D;
    }
    for (;;)
    {
      Log.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.KmF.Kme + " maxTotalNum:" + this.KmF.Kmb + " perGroupMaxValue:" + this.KmF.Kmf + " perMinValue:" + this.KmF.Kmd + " perPersonMaxValue:" + this.KmF.Kmc);
      AppMethodBeat.o(65180);
      return;
      try
      {
        this.KmF.parseFrom(str.getBytes("ISO-8859-1"));
        fWV();
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.KmF.Kme = 2000.0D;
        this.KmF.Kmb = 100;
        this.KmF.Kmf = 200.0D;
        this.KmF.Kmd = 0.01D;
        this.KmF.Kmc = 200.0D;
      }
    }
  }
  
  final void fWV()
  {
    AppMethodBeat.i(65181);
    if (this.KmF != null)
    {
      this.KrK = i.aKy(this.KmF.KrG);
      if ((this.KrK != null) && (this.KrK.Krm != null))
      {
        ((a)h.ax(a.class)).a(this.KrK.Krm);
        h.baE().ban().set(at.a.acVd, Integer.valueOf(1));
        if (!Util.isNullOrNil(this.KmF.KrH))
        {
          Log.d("MicroMsg.LuckyMoneyConfigManager", "parse cover info");
          try
          {
            eof localeof = (eof)new eof().parseFrom(Base64.decode(this.KmF.KrH, 0));
            this.KrK.Krm.nQJ = localeof.nQJ;
            AppMethodBeat.o(65181);
            return;
          }
          catch (IOException localIOException)
          {
            Log.printErrStackTrace("MicroMsg.LuckyMoneyConfigManager", localIOException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(65181);
  }
  
  public final o fWW()
  {
    AppMethodBeat.i(65182);
    if (this.KmF == null) {
      init();
    }
    o localo = this.KmF;
    AppMethodBeat.o(65182);
    return localo;
  }
  
  public final i fWX()
  {
    AppMethodBeat.i(65183);
    if (this.KrK == null) {
      init();
    }
    i locali = this.KrK;
    AppMethodBeat.o(65183);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.p
 * JD-Core Version:    0.7.0.1
 */