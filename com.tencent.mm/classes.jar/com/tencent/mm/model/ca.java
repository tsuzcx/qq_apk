package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;

public final class ca
{
  public String cityCode = "";
  public String countryCode = "";
  public int hDk = 0;
  public String hDm = "";
  private String lvD = "";
  private String lvE = "";
  public String provinceCode = "";
  public int sex = 0;
  public String signature = "";
  
  public static czd a(ca paramca)
  {
    AppMethodBeat.i(42985);
    h.aHG().aHp().i(12289, Integer.valueOf(paramca.hDk));
    h.aHG().aHp().i(12290, Integer.valueOf(paramca.sex));
    if (ca.a.aU((String)h.aHG().aHp().b(12293, null), paramca.getProvince())) {
      h.aHG().aHp().i(12293, paramca.getProvince());
    }
    if (ca.a.aU((String)h.aHG().aHp().b(12292, null), paramca.getCity())) {
      h.aHG().aHp().i(12292, paramca.getCity());
    }
    if (ca.a.aU((String)h.aHG().aHp().b(12291, null), paramca.signature)) {
      h.aHG().aHp().i(12291, paramca.signature);
    }
    if (ca.a.aU((String)h.aHG().aHp().b(12307, null), paramca.hDm)) {
      h.aHG().aHp().i(12307, paramca.hDm);
    }
    if (ca.a.aU((String)h.aHG().aHp().b(12324, null), paramca.countryCode)) {
      h.aHG().aHp().i(12324, paramca.countryCode);
    }
    if (ca.a.aU((String)h.aHG().aHp().b(12325, null), paramca.provinceCode)) {
      h.aHG().aHp().i(12325, paramca.provinceCode);
    }
    if (ca.a.aU((String)h.aHG().aHp().b(12326, null), paramca.cityCode)) {
      h.aHG().aHp().i(12326, paramca.cityCode);
    }
    czd localczd = new czd();
    localczd.THd = 128;
    localczd.SrH = new eaf().btQ("");
    localczd.TtX = new eaf().btQ("");
    localczd.RFr = 0;
    localczd.THe = new eaf().btQ("");
    localczd.THf = new eaf().btQ("");
    localczd.rVU = 0;
    byte[] arrayOfByte2 = u.aY("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localczd.THb = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localczd.THa = i;
      localczd.mVy = paramca.sex;
      localczd.mVC = paramca.hDk;
      localczd.mVB = Util.nullAsNil(paramca.signature);
      localczd.mVA = Util.nullAsNil(paramca.cityCode);
      localczd.mVz = Util.nullAsNil(paramca.provinceCode);
      localczd.RFu = 0;
      localczd.TxH = Util.nullAsNil(paramca.hDm);
      localczd.THk = 0;
      localczd.mVD = "";
      localczd.TxJ = 0;
      localczd.TxI = "";
      localczd.mVH = Util.nullAsNil(paramca.countryCode);
      AppMethodBeat.o(42985);
      return localczd;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static ca bfn()
  {
    AppMethodBeat.i(42983);
    ca localca = new ca();
    localca.hDk = 1;
    localca.sex = Util.nullAs((Integer)h.aHG().aHp().b(12290, null), 0);
    localca.lvD = ((String)h.aHG().aHp().b(12293, null));
    localca.lvE = ((String)h.aHG().aHp().b(12292, null));
    localca.signature = ((String)h.aHG().aHp().b(12291, null));
    localca.hDm = ((String)h.aHG().aHp().b(12307, null));
    localca.countryCode = ((String)h.aHG().aHp().b(12324, null));
    localca.provinceCode = ((String)h.aHG().aHp().b(12325, null));
    localca.cityCode = ((String)h.aHG().aHp().b(12326, null));
    AppMethodBeat.o(42983);
    return localca;
  }
  
  public static ca bfo()
  {
    AppMethodBeat.i(42984);
    if (Util.nullAs((Integer)h.aHG().aHp().b(12289, null), 0) == 0)
    {
      AppMethodBeat.o(42984);
      return null;
    }
    ca localca = bfn();
    AppMethodBeat.o(42984);
    return localca;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(42986);
    if (!Util.isNullOrNil(this.countryCode))
    {
      if (Util.isNullOrNil(this.provinceCode)) {
        break label105;
      }
      if (!Util.isNullOrNil(this.cityCode)) {
        break label79;
      }
      RegionCodeDecoder.hAC();
      this.lvE = RegionCodeDecoder.nO(this.countryCode, this.provinceCode);
    }
    while (Util.isNullOrNil(this.lvE))
    {
      str = Util.nullAsNil(this.cityCode);
      AppMethodBeat.o(42986);
      return str;
      label79:
      RegionCodeDecoder.hAC();
      this.lvE = RegionCodeDecoder.bn(this.countryCode, this.provinceCode, this.cityCode);
      continue;
      label105:
      this.lvE = "";
    }
    String str = this.lvE;
    AppMethodBeat.o(42986);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(42987);
    if (!Util.isNullOrNil(this.countryCode))
    {
      if ((Util.isNullOrNil(this.provinceCode)) || (Util.isNullOrNil(this.cityCode)) || (!RegionCodeDecoder.bxn(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.hAC();
    }
    for (this.lvD = RegionCodeDecoder.nO(this.countryCode, this.provinceCode); Util.isNullOrNil(this.lvD); this.lvD = RegionCodeDecoder.bxp(this.countryCode))
    {
      str = Util.nullAsNil(this.provinceCode);
      AppMethodBeat.o(42987);
      return str;
      label89:
      RegionCodeDecoder.hAC();
    }
    String str = this.lvD;
    AppMethodBeat.o(42987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ca
 * JD-Core Version:    0.7.0.1
 */