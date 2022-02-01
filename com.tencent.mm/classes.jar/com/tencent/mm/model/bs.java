package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;

public final class bs
{
  public String cityCode = "";
  public String countryCode = "";
  public String evD = "";
  public int evp = 0;
  public int evy = 0;
  private String gPd = "";
  private String gPe = "";
  public String provinceCode = "";
  public String signature = "";
  
  public static brj a(bs parambs)
  {
    AppMethodBeat.i(42985);
    g.afB().afk().set(12289, Integer.valueOf(parambs.evy));
    g.afB().afk().set(12290, Integer.valueOf(parambs.evp));
    if (bs.a.aF((String)g.afB().afk().get(12293, null), parambs.getProvince())) {
      g.afB().afk().set(12293, parambs.getProvince());
    }
    if (bs.a.aF((String)g.afB().afk().get(12292, null), parambs.getCity())) {
      g.afB().afk().set(12292, parambs.getCity());
    }
    if (bs.a.aF((String)g.afB().afk().get(12291, null), parambs.signature)) {
      g.afB().afk().set(12291, parambs.signature);
    }
    if (bs.a.aF((String)g.afB().afk().get(12307, null), parambs.evD)) {
      g.afB().afk().set(12307, parambs.evD);
    }
    if (bs.a.aF((String)g.afB().afk().get(12324, null), parambs.countryCode)) {
      g.afB().afk().set(12324, parambs.countryCode);
    }
    if (bs.a.aF((String)g.afB().afk().get(12325, null), parambs.provinceCode)) {
      g.afB().afk().set(12325, parambs.provinceCode);
    }
    if (bs.a.aF((String)g.afB().afk().get(12326, null), parambs.cityCode)) {
      g.afB().afk().set(12326, parambs.cityCode);
    }
    brj localbrj = new brj();
    localbrj.DPj = 128;
    localbrj.Dby = new cmf().aEE("");
    localbrj.DFJ = new cmf().aEE("");
    localbrj.CuF = 0;
    localbrj.DPk = new cmf().aEE("");
    localbrj.DPl = new cmf().aEE("");
    localbrj.mBi = 0;
    byte[] arrayOfByte2 = i.aR("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localbrj.DPh = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localbrj.DPg = i;
      localbrj.ijM = parambs.evp;
      localbrj.ijQ = parambs.evy;
      localbrj.ijP = bt.nullAsNil(parambs.signature);
      localbrj.ijO = bt.nullAsNil(parambs.cityCode);
      localbrj.ijN = bt.nullAsNil(parambs.provinceCode);
      localbrj.CuI = 0;
      localbrj.DIX = bt.nullAsNil(parambs.evD);
      localbrj.DPq = 0;
      localbrj.ijR = "";
      localbrj.DIZ = 0;
      localbrj.DIY = "";
      localbrj.ijV = bt.nullAsNil(parambs.countryCode);
      AppMethodBeat.o(42985);
      return localbrj;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static bs asB()
  {
    AppMethodBeat.i(42983);
    bs localbs = new bs();
    localbs.evy = 1;
    localbs.evp = bt.a((Integer)g.afB().afk().get(12290, null), 0);
    localbs.gPd = ((String)g.afB().afk().get(12293, null));
    localbs.gPe = ((String)g.afB().afk().get(12292, null));
    localbs.signature = ((String)g.afB().afk().get(12291, null));
    localbs.evD = ((String)g.afB().afk().get(12307, null));
    localbs.countryCode = ((String)g.afB().afk().get(12324, null));
    localbs.provinceCode = ((String)g.afB().afk().get(12325, null));
    localbs.cityCode = ((String)g.afB().afk().get(12326, null));
    AppMethodBeat.o(42983);
    return localbs;
  }
  
  public static bs asC()
  {
    AppMethodBeat.i(42984);
    if (bt.a((Integer)g.afB().afk().get(12289, null), 0) == 0)
    {
      AppMethodBeat.o(42984);
      return null;
    }
    bs localbs = asB();
    AppMethodBeat.o(42984);
    return localbs;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(42986);
    if (!bt.isNullOrNil(this.countryCode))
    {
      if (bt.isNullOrNil(this.provinceCode)) {
        break label105;
      }
      if (!bt.isNullOrNil(this.cityCode)) {
        break label79;
      }
      RegionCodeDecoder.eMO();
      this.gPe = RegionCodeDecoder.lg(this.countryCode, this.provinceCode);
    }
    while (bt.isNullOrNil(this.gPe))
    {
      str = bt.nullAsNil(this.cityCode);
      AppMethodBeat.o(42986);
      return str;
      label79:
      RegionCodeDecoder.eMO();
      this.gPe = RegionCodeDecoder.aV(this.countryCode, this.provinceCode, this.cityCode);
      continue;
      label105:
      this.gPe = "";
    }
    String str = this.gPe;
    AppMethodBeat.o(42986);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(42987);
    if (!bt.isNullOrNil(this.countryCode))
    {
      if ((bt.isNullOrNil(this.provinceCode)) || (bt.isNullOrNil(this.cityCode)) || (!RegionCodeDecoder.aJc(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.eMO();
    }
    for (this.gPd = RegionCodeDecoder.lg(this.countryCode, this.provinceCode); bt.isNullOrNil(this.gPd); this.gPd = RegionCodeDecoder.aJd(this.countryCode))
    {
      str = bt.nullAsNil(this.provinceCode);
      AppMethodBeat.o(42987);
      return str;
      label89:
      RegionCodeDecoder.eMO();
    }
    String str = this.gPd;
    AppMethodBeat.o(42987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */