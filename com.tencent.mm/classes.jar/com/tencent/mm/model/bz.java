package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.s;

public final class bz
{
  public String cityCode = "";
  public String countryCode = "";
  public int fuA = 0;
  public int fuI = 0;
  public String fuM = "";
  private String iFB = "";
  private String iFC = "";
  public String provinceCode = "";
  public String signature = "";
  
  public static cqm a(bz parambz)
  {
    AppMethodBeat.i(42985);
    g.aAh().azQ().set(12289, Integer.valueOf(parambz.fuI));
    g.aAh().azQ().set(12290, Integer.valueOf(parambz.fuA));
    if (bz.a.aQ((String)g.aAh().azQ().get(12293, null), parambz.getProvince())) {
      g.aAh().azQ().set(12293, parambz.getProvince());
    }
    if (bz.a.aQ((String)g.aAh().azQ().get(12292, null), parambz.getCity())) {
      g.aAh().azQ().set(12292, parambz.getCity());
    }
    if (bz.a.aQ((String)g.aAh().azQ().get(12291, null), parambz.signature)) {
      g.aAh().azQ().set(12291, parambz.signature);
    }
    if (bz.a.aQ((String)g.aAh().azQ().get(12307, null), parambz.fuM)) {
      g.aAh().azQ().set(12307, parambz.fuM);
    }
    if (bz.a.aQ((String)g.aAh().azQ().get(12324, null), parambz.countryCode)) {
      g.aAh().azQ().set(12324, parambz.countryCode);
    }
    if (bz.a.aQ((String)g.aAh().azQ().get(12325, null), parambz.provinceCode)) {
      g.aAh().azQ().set(12325, parambz.provinceCode);
    }
    if (bz.a.aQ((String)g.aAh().azQ().get(12326, null), parambz.cityCode)) {
      g.aAh().azQ().set(12326, parambz.cityCode);
    }
    cqm localcqm = new cqm();
    localcqm.Mwf = 128;
    localcqm.Lqk = new dqi().bhy("");
    localcqm.Mjj = new dqi().bhy("");
    localcqm.KDZ = 0;
    localcqm.Mwg = new dqi().bhy("");
    localcqm.Mwh = new dqi().bhy("");
    localcqm.oTW = 0;
    byte[] arrayOfByte2 = s.aW("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localcqm.Mwd = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localcqm.Mwc = i;
      localcqm.kdY = parambz.fuA;
      localcqm.kec = parambz.fuI;
      localcqm.keb = Util.nullAsNil(parambz.signature);
      localcqm.kea = Util.nullAsNil(parambz.cityCode);
      localcqm.kdZ = Util.nullAsNil(parambz.provinceCode);
      localcqm.KEc = 0;
      localcqm.MmM = Util.nullAsNil(parambz.fuM);
      localcqm.Mwm = 0;
      localcqm.ked = "";
      localcqm.MmO = 0;
      localcqm.MmN = "";
      localcqm.keh = Util.nullAsNil(parambz.countryCode);
      AppMethodBeat.o(42985);
      return localcqm;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static bz aWj()
  {
    AppMethodBeat.i(42983);
    bz localbz = new bz();
    localbz.fuI = 1;
    localbz.fuA = Util.nullAs((Integer)g.aAh().azQ().get(12290, null), 0);
    localbz.iFB = ((String)g.aAh().azQ().get(12293, null));
    localbz.iFC = ((String)g.aAh().azQ().get(12292, null));
    localbz.signature = ((String)g.aAh().azQ().get(12291, null));
    localbz.fuM = ((String)g.aAh().azQ().get(12307, null));
    localbz.countryCode = ((String)g.aAh().azQ().get(12324, null));
    localbz.provinceCode = ((String)g.aAh().azQ().get(12325, null));
    localbz.cityCode = ((String)g.aAh().azQ().get(12326, null));
    AppMethodBeat.o(42983);
    return localbz;
  }
  
  public static bz aWk()
  {
    AppMethodBeat.i(42984);
    if (Util.nullAs((Integer)g.aAh().azQ().get(12289, null), 0) == 0)
    {
      AppMethodBeat.o(42984);
      return null;
    }
    bz localbz = aWj();
    AppMethodBeat.o(42984);
    return localbz;
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
      RegionCodeDecoder.gEm();
      this.iFC = RegionCodeDecoder.mW(this.countryCode, this.provinceCode);
    }
    while (Util.isNullOrNil(this.iFC))
    {
      str = Util.nullAsNil(this.cityCode);
      AppMethodBeat.o(42986);
      return str;
      label79:
      RegionCodeDecoder.gEm();
      this.iFC = RegionCodeDecoder.bs(this.countryCode, this.provinceCode, this.cityCode);
      continue;
      label105:
      this.iFC = "";
    }
    String str = this.iFC;
    AppMethodBeat.o(42986);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(42987);
    if (!Util.isNullOrNil(this.countryCode))
    {
      if ((Util.isNullOrNil(this.provinceCode)) || (Util.isNullOrNil(this.cityCode)) || (!RegionCodeDecoder.bkO(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.gEm();
    }
    for (this.iFB = RegionCodeDecoder.mW(this.countryCode, this.provinceCode); Util.isNullOrNil(this.iFB); this.iFB = RegionCodeDecoder.bkP(this.countryCode))
    {
      str = Util.nullAsNil(this.provinceCode);
      AppMethodBeat.o(42987);
      return str;
      label89:
      RegionCodeDecoder.gEm();
    }
    String str = this.iFB;
    AppMethodBeat.o(42987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bz
 * JD-Core Version:    0.7.0.1
 */