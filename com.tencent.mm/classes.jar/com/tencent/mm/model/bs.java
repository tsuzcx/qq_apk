package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;

public final class bs
{
  public String cityCode = "";
  public String countryCode = "";
  public int exL = 0;
  public int exU = 0;
  public String exZ = "";
  private String hpD = "";
  private String hpE = "";
  public String provinceCode = "";
  public String signature = "";
  
  public static bwa a(bs parambs)
  {
    AppMethodBeat.i(42985);
    g.agR().agA().set(12289, Integer.valueOf(parambs.exU));
    g.agR().agA().set(12290, Integer.valueOf(parambs.exL));
    if (bs.a.aN((String)g.agR().agA().get(12293, null), parambs.getProvince())) {
      g.agR().agA().set(12293, parambs.getProvince());
    }
    if (bs.a.aN((String)g.agR().agA().get(12292, null), parambs.getCity())) {
      g.agR().agA().set(12292, parambs.getCity());
    }
    if (bs.a.aN((String)g.agR().agA().get(12291, null), parambs.signature)) {
      g.agR().agA().set(12291, parambs.signature);
    }
    if (bs.a.aN((String)g.agR().agA().get(12307, null), parambs.exZ)) {
      g.agR().agA().set(12307, parambs.exZ);
    }
    if (bs.a.aN((String)g.agR().agA().get(12324, null), parambs.countryCode)) {
      g.agR().agA().set(12324, parambs.countryCode);
    }
    if (bs.a.aN((String)g.agR().agA().get(12325, null), parambs.provinceCode)) {
      g.agR().agA().set(12325, parambs.provinceCode);
    }
    if (bs.a.aN((String)g.agR().agA().get(12326, null), parambs.cityCode)) {
      g.agR().agA().set(12326, parambs.cityCode);
    }
    bwa localbwa = new bwa();
    localbwa.FlA = 128;
    localbwa.EuE = new crm().aJV("");
    localbwa.Fbd = new crm().aJV("");
    localbwa.DNa = 0;
    localbwa.FlB = new crm().aJV("");
    localbwa.FlC = new crm().aJV("");
    localbwa.ndj = 0;
    byte[] arrayOfByte2 = i.aU("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localbwa.Fly = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localbwa.Flx = i;
      localbwa.iJT = parambs.exL;
      localbwa.iJX = parambs.exU;
      localbwa.iJW = com.tencent.mm.sdk.platformtools.bs.nullAsNil(parambs.signature);
      localbwa.iJV = com.tencent.mm.sdk.platformtools.bs.nullAsNil(parambs.cityCode);
      localbwa.iJU = com.tencent.mm.sdk.platformtools.bs.nullAsNil(parambs.provinceCode);
      localbwa.DNd = 0;
      localbwa.Fes = com.tencent.mm.sdk.platformtools.bs.nullAsNil(parambs.exZ);
      localbwa.FlH = 0;
      localbwa.iJY = "";
      localbwa.Feu = 0;
      localbwa.Fet = "";
      localbwa.iKc = com.tencent.mm.sdk.platformtools.bs.nullAsNil(parambs.countryCode);
      AppMethodBeat.o(42985);
      return localbwa;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static bs azs()
  {
    AppMethodBeat.i(42983);
    bs localbs = new bs();
    localbs.exU = 1;
    localbs.exL = com.tencent.mm.sdk.platformtools.bs.a((Integer)g.agR().agA().get(12290, null), 0);
    localbs.hpD = ((String)g.agR().agA().get(12293, null));
    localbs.hpE = ((String)g.agR().agA().get(12292, null));
    localbs.signature = ((String)g.agR().agA().get(12291, null));
    localbs.exZ = ((String)g.agR().agA().get(12307, null));
    localbs.countryCode = ((String)g.agR().agA().get(12324, null));
    localbs.provinceCode = ((String)g.agR().agA().get(12325, null));
    localbs.cityCode = ((String)g.agR().agA().get(12326, null));
    AppMethodBeat.o(42983);
    return localbs;
  }
  
  public static bs azt()
  {
    AppMethodBeat.i(42984);
    if (com.tencent.mm.sdk.platformtools.bs.a((Integer)g.agR().agA().get(12289, null), 0) == 0)
    {
      AppMethodBeat.o(42984);
      return null;
    }
    bs localbs = azs();
    AppMethodBeat.o(42984);
    return localbs;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(42986);
    if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.countryCode))
    {
      if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.provinceCode)) {
        break label105;
      }
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.cityCode)) {
        break label79;
      }
      RegionCodeDecoder.fcs();
      this.hpE = RegionCodeDecoder.lD(this.countryCode, this.provinceCode);
    }
    while (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.hpE))
    {
      str = com.tencent.mm.sdk.platformtools.bs.nullAsNil(this.cityCode);
      AppMethodBeat.o(42986);
      return str;
      label79:
      RegionCodeDecoder.fcs();
      this.hpE = RegionCodeDecoder.aY(this.countryCode, this.provinceCode, this.cityCode);
      continue;
      label105:
      this.hpE = "";
    }
    String str = this.hpE;
    AppMethodBeat.o(42986);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(42987);
    if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.countryCode))
    {
      if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.provinceCode)) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.cityCode)) || (!RegionCodeDecoder.aOy(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.fcs();
    }
    for (this.hpD = RegionCodeDecoder.lD(this.countryCode, this.provinceCode); com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.hpD); this.hpD = RegionCodeDecoder.aOz(this.countryCode))
    {
      str = com.tencent.mm.sdk.platformtools.bs.nullAsNil(this.provinceCode);
      AppMethodBeat.o(42987);
      return str;
      label89:
      RegionCodeDecoder.fcs();
    }
    String str = this.hpD;
    AppMethodBeat.o(42987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */