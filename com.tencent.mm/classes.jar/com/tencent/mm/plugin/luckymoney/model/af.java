package com.tencent.mm.plugin.luckymoney.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;

public final class af
{
  o EtY;
  private h EyX;
  
  public af()
  {
    AppMethodBeat.i(272482);
    init();
    AppMethodBeat.o(272482);
  }
  
  private void init()
  {
    AppMethodBeat.i(272484);
    this.EtY = new o();
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vhk, null);
    if (Util.isNullOrNil(str))
    {
      this.EtY.Etx = 2000.0D;
      this.EtY.Etu = 100;
      this.EtY.Ety = 200.0D;
      this.EtY.Etw = 0.01D;
      this.EtY.Etv = 200.0D;
    }
    for (;;)
    {
      Log.i("MicroMsg.LuckyMoneyUnionConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.EtY.Etx + " maxTotalNum:" + this.EtY.Etu + " perGroupMaxValue:" + this.EtY.Ety + " perMinValue:" + this.EtY.Etw + " perPersonMaxValue:" + this.EtY.Etv);
      AppMethodBeat.o(272484);
      return;
      try
      {
        this.EtY.parseFrom(str.getBytes("ISO-8859-1"));
        eOy();
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.LuckyMoneyUnionConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.EtY.Etx = 2000.0D;
        this.EtY.Etu = 100;
        this.EtY.Ety = 200.0D;
        this.EtY.Etw = 0.01D;
        this.EtY.Etv = 200.0D;
      }
    }
  }
  
  public final h eOA()
  {
    AppMethodBeat.i(272487);
    if (this.EyX == null) {
      init();
    }
    h localh = this.EyX;
    AppMethodBeat.o(272487);
    return localh;
  }
  
  final void eOy()
  {
    AppMethodBeat.i(272485);
    if (this.EtY != null)
    {
      this.EyX = h.aNC(this.EtY.EyT);
      if ((this.EyX != null) && (this.EyX.Eyz != null))
      {
        ((a)com.tencent.mm.kernel.h.ae(a.class)).a(this.EyX.Eyz);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtz, Integer.valueOf(1));
        if (Util.isNullOrNil(this.EtY.EyU)) {
          break label179;
        }
        Log.d("MicroMsg.LuckyMoneyUnionConfigManager", "parse cover info");
        try
        {
          dvj localdvj = (dvj)new dvj().parseFrom(Base64.decode(this.EtY.EyU, 0));
          this.EyX.Eyz.llL = localdvj.llL;
          AppMethodBeat.o(272485);
          return;
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.LuckyMoneyUnionConfigManager", localIOException, "", new Object[0]);
          AppMethodBeat.o(272485);
          return;
        }
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtz, Integer.valueOf(0));
    }
    label179:
    AppMethodBeat.o(272485);
  }
  
  public final o eOz()
  {
    AppMethodBeat.i(272486);
    if (this.EtY == null) {
      init();
    }
    o localo = this.EtY;
    AppMethodBeat.o(272486);
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */