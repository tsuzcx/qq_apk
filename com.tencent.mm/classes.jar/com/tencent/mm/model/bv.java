package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;

public final class bv
{
  public String cityCode = "";
  public String countryCode = "";
  public int eQV = 0;
  public int eRe = 0;
  public String eRj = "";
  private String hKN = "";
  private String hKO = "";
  public String provinceCode = "";
  public String signature = "";
  
  public static cbk a(bv parambv)
  {
    AppMethodBeat.i(42985);
    g.ajR().ajA().set(12289, Integer.valueOf(parambv.eRe));
    g.ajR().ajA().set(12290, Integer.valueOf(parambv.eQV));
    if (bv.a.aO((String)g.ajR().ajA().get(12293, null), parambv.getProvince())) {
      g.ajR().ajA().set(12293, parambv.getProvince());
    }
    if (bv.a.aO((String)g.ajR().ajA().get(12292, null), parambv.getCity())) {
      g.ajR().ajA().set(12292, parambv.getCity());
    }
    if (bv.a.aO((String)g.ajR().ajA().get(12291, null), parambv.signature)) {
      g.ajR().ajA().set(12291, parambv.signature);
    }
    if (bv.a.aO((String)g.ajR().ajA().get(12307, null), parambv.eRj)) {
      g.ajR().ajA().set(12307, parambv.eRj);
    }
    if (bv.a.aO((String)g.ajR().ajA().get(12324, null), parambv.countryCode)) {
      g.ajR().ajA().set(12324, parambv.countryCode);
    }
    if (bv.a.aO((String)g.ajR().ajA().get(12325, null), parambv.provinceCode)) {
      g.ajR().ajA().set(12325, parambv.provinceCode);
    }
    if (bv.a.aO((String)g.ajR().ajA().get(12326, null), parambv.cityCode)) {
      g.ajR().ajA().set(12326, parambv.cityCode);
    }
    cbk localcbk = new cbk();
    localcbk.HoK = 128;
    localcbk.GuF = new cxn().aQV("");
    localcbk.Hed = new cxn().aQV("");
    localcbk.FKD = 0;
    localcbk.HoL = new cxn().aQV("");
    localcbk.HoM = new cxn().aQV("");
    localcbk.nJb = 0;
    byte[] arrayOfByte2 = o.bb("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localcbk.HoI = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localcbk.HoH = i;
      localcbk.jfV = parambv.eQV;
      localcbk.jfZ = parambv.eRe;
      localcbk.jfY = bu.nullAsNil(parambv.signature);
      localcbk.jfX = bu.nullAsNil(parambv.cityCode);
      localcbk.jfW = bu.nullAsNil(parambv.provinceCode);
      localcbk.FKG = 0;
      localcbk.Hhw = bu.nullAsNil(parambv.eRj);
      localcbk.HoR = 0;
      localcbk.jga = "";
      localcbk.Hhy = 0;
      localcbk.Hhx = "";
      localcbk.jge = bu.nullAsNil(parambv.countryCode);
      AppMethodBeat.o(42985);
      return localcbk;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static bv aCL()
  {
    AppMethodBeat.i(42983);
    bv localbv = new bv();
    localbv.eRe = 1;
    localbv.eQV = bu.a((Integer)g.ajR().ajA().get(12290, null), 0);
    localbv.hKN = ((String)g.ajR().ajA().get(12293, null));
    localbv.hKO = ((String)g.ajR().ajA().get(12292, null));
    localbv.signature = ((String)g.ajR().ajA().get(12291, null));
    localbv.eRj = ((String)g.ajR().ajA().get(12307, null));
    localbv.countryCode = ((String)g.ajR().ajA().get(12324, null));
    localbv.provinceCode = ((String)g.ajR().ajA().get(12325, null));
    localbv.cityCode = ((String)g.ajR().ajA().get(12326, null));
    AppMethodBeat.o(42983);
    return localbv;
  }
  
  public static bv aCM()
  {
    AppMethodBeat.i(42984);
    if (bu.a((Integer)g.ajR().ajA().get(12289, null), 0) == 0)
    {
      AppMethodBeat.o(42984);
      return null;
    }
    bv localbv = aCL();
    AppMethodBeat.o(42984);
    return localbv;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(42986);
    if (!bu.isNullOrNil(this.countryCode))
    {
      if (bu.isNullOrNil(this.provinceCode)) {
        break label105;
      }
      if (!bu.isNullOrNil(this.cityCode)) {
        break label79;
      }
      RegionCodeDecoder.fwA();
      this.hKO = RegionCodeDecoder.mi(this.countryCode, this.provinceCode);
    }
    while (bu.isNullOrNil(this.hKO))
    {
      str = bu.nullAsNil(this.cityCode);
      AppMethodBeat.o(42986);
      return str;
      label79:
      RegionCodeDecoder.fwA();
      this.hKO = RegionCodeDecoder.bi(this.countryCode, this.provinceCode, this.cityCode);
      continue;
      label105:
      this.hKO = "";
    }
    String str = this.hKO;
    AppMethodBeat.o(42986);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(42987);
    if (!bu.isNullOrNil(this.countryCode))
    {
      if ((bu.isNullOrNil(this.provinceCode)) || (bu.isNullOrNil(this.cityCode)) || (!RegionCodeDecoder.aVQ(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.fwA();
    }
    for (this.hKN = RegionCodeDecoder.mi(this.countryCode, this.provinceCode); bu.isNullOrNil(this.hKN); this.hKN = RegionCodeDecoder.aVR(this.countryCode))
    {
      str = bu.nullAsNil(this.provinceCode);
      AppMethodBeat.o(42987);
      return str;
      label89:
      RegionCodeDecoder.fwA();
    }
    String str = this.hKN;
    AppMethodBeat.o(42987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bv
 * JD-Core Version:    0.7.0.1
 */