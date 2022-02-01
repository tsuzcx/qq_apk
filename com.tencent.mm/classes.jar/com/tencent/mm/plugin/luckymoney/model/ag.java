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

public final class ag
{
  o KmF;
  private i KrK;
  
  public ag()
  {
    AppMethodBeat.i(283923);
    init();
    AppMethodBeat.o(283923);
  }
  
  private void init()
  {
    AppMethodBeat.i(283927);
    this.KmF = new o();
    h.baF();
    String str = (String)h.baE().ban().get(at.a.acIE, null);
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
      Log.i("MicroMsg.LuckyMoneyUnionConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.KmF.Kme + " maxTotalNum:" + this.KmF.Kmb + " perGroupMaxValue:" + this.KmF.Kmf + " perMinValue:" + this.KmF.Kmd + " perPersonMaxValue:" + this.KmF.Kmc);
      AppMethodBeat.o(283927);
      return;
      try
      {
        this.KmF.parseFrom(str.getBytes("ISO-8859-1"));
        fWV();
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.LuckyMoneyUnionConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
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
    AppMethodBeat.i(283930);
    if (this.KmF != null)
    {
      this.KrK = i.aKy(this.KmF.KrG);
      if ((this.KrK != null) && (this.KrK.Krm != null))
      {
        ((a)h.ax(a.class)).a(this.KrK.Krm);
        h.baE().ban().set(at.a.acVd, Integer.valueOf(1));
        if (!Util.isNullOrNil(this.KmF.KrH))
        {
          Log.d("MicroMsg.LuckyMoneyUnionConfigManager", "parse cover info");
          try
          {
            eof localeof = (eof)new eof().parseFrom(Base64.decode(this.KmF.KrH, 0));
            this.KrK.Krm.nQJ = localeof.nQJ;
            AppMethodBeat.o(283930);
            return;
          }
          catch (IOException localIOException)
          {
            Log.printErrStackTrace("MicroMsg.LuckyMoneyUnionConfigManager", localIOException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(283930);
  }
  
  public final o fWW()
  {
    AppMethodBeat.i(283934);
    if (this.KmF == null) {
      init();
    }
    o localo = this.KmF;
    AppMethodBeat.o(283934);
    return localo;
  }
  
  public final i fWX()
  {
    AppMethodBeat.i(283937);
    if (this.KrK == null) {
      init();
    }
    i locali = this.KrK;
    AppMethodBeat.o(283937);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ag
 * JD-Core Version:    0.7.0.1
 */