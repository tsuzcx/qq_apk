package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;

public final class cb
{
  public String cityCode = "";
  public String countryCode = "";
  public int kag = 0;
  public String kai = "";
  private String ona = "";
  private String onb = "";
  public String provinceCode = "";
  public int sex = 0;
  public String signature = "";
  
  public static dqk a(cb paramcb)
  {
    AppMethodBeat.i(42985);
    h.baE().ban().B(12289, Integer.valueOf(paramcb.kag));
    h.baE().ban().B(12290, Integer.valueOf(paramcb.sex));
    if (cb.a.be((String)h.baE().ban().d(12293, null), paramcb.getProvince())) {
      h.baE().ban().B(12293, paramcb.getProvince());
    }
    if (cb.a.be((String)h.baE().ban().d(12292, null), paramcb.getCity())) {
      h.baE().ban().B(12292, paramcb.getCity());
    }
    if (cb.a.be((String)h.baE().ban().d(12291, null), paramcb.signature)) {
      h.baE().ban().B(12291, paramcb.signature);
    }
    if (cb.a.be((String)h.baE().ban().d(12307, null), paramcb.kai)) {
      h.baE().ban().B(12307, paramcb.kai);
    }
    if (cb.a.be((String)h.baE().ban().d(12324, null), paramcb.countryCode)) {
      h.baE().ban().B(12324, paramcb.countryCode);
    }
    if (cb.a.be((String)h.baE().ban().d(12325, null), paramcb.provinceCode)) {
      h.baE().ban().B(12325, paramcb.provinceCode);
    }
    if (cb.a.be((String)h.baE().ban().d(12326, null), paramcb.cityCode)) {
      h.baE().ban().B(12326, paramcb.cityCode);
    }
    dqk localdqk = new dqk();
    localdqk.aaWL = 128;
    localdqk.ZqL = new etl().btH("");
    localdqk.aaIz = new etl().btH("");
    localdqk.YBU = 0;
    localdqk.aaWM = new etl().btH("");
    localdqk.aaWN = new etl().btH("");
    localdqk.vhk = 0;
    byte[] arrayOfByte2 = y.bi("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localdqk.aaWJ = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localdqk.aaWI = i;
      localdqk.pSf = paramcb.sex;
      localdqk.pSj = paramcb.kag;
      localdqk.pSi = Util.nullAsNil(paramcb.signature);
      localdqk.pSh = Util.nullAsNil(paramcb.cityCode);
      localdqk.pSg = Util.nullAsNil(paramcb.provinceCode);
      localdqk.YBX = 0;
      localdqk.aaMo = Util.nullAsNil(paramcb.kai);
      localdqk.aaWS = 0;
      localdqk.pSk = "";
      localdqk.aaMq = 0;
      localdqk.aaMp = "";
      localdqk.pSo = Util.nullAsNil(paramcb.countryCode);
      AppMethodBeat.o(42985);
      return localdqk;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static cb bDe()
  {
    AppMethodBeat.i(42983);
    cb localcb = new cb();
    localcb.kag = 1;
    localcb.sex = Util.nullAs((Integer)h.baE().ban().d(12290, null), 0);
    localcb.ona = ((String)h.baE().ban().d(12293, null));
    localcb.onb = ((String)h.baE().ban().d(12292, null));
    localcb.signature = ((String)h.baE().ban().d(12291, null));
    localcb.kai = ((String)h.baE().ban().d(12307, null));
    localcb.countryCode = ((String)h.baE().ban().d(12324, null));
    localcb.provinceCode = ((String)h.baE().ban().d(12325, null));
    localcb.cityCode = ((String)h.baE().ban().d(12326, null));
    AppMethodBeat.o(42983);
    return localcb;
  }
  
  public static cb bDf()
  {
    AppMethodBeat.i(42984);
    if (Util.nullAs((Integer)h.baE().ban().d(12289, null), 0) == 0)
    {
      AppMethodBeat.o(42984);
      return null;
    }
    cb localcb = bDe();
    AppMethodBeat.o(42984);
    return localcb;
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
      RegionCodeDecoder.jcF();
      this.onb = RegionCodeDecoder.pM(this.countryCode, this.provinceCode);
    }
    while (Util.isNullOrNil(this.onb))
    {
      str = Util.nullAsNil(this.cityCode);
      AppMethodBeat.o(42986);
      return str;
      label79:
      RegionCodeDecoder.jcF();
      this.onb = RegionCodeDecoder.bK(this.countryCode, this.provinceCode, this.cityCode);
      continue;
      label105:
      this.onb = "";
    }
    String str = this.onb;
    AppMethodBeat.o(42986);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(42987);
    if (!Util.isNullOrNil(this.countryCode))
    {
      if ((Util.isNullOrNil(this.provinceCode)) || (Util.isNullOrNil(this.cityCode)) || (!RegionCodeDecoder.byG(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.jcF();
    }
    for (this.ona = RegionCodeDecoder.pM(this.countryCode, this.provinceCode); Util.isNullOrNil(this.ona); this.ona = RegionCodeDecoder.byH(this.countryCode))
    {
      str = Util.nullAsNil(this.provinceCode);
      AppMethodBeat.o(42987);
      return str;
      label89:
      RegionCodeDecoder.jcF();
    }
    String str = this.ona;
    AppMethodBeat.o(42987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.cb
 * JD-Core Version:    0.7.0.1
 */