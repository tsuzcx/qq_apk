package com.tencent.mm.model;

import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.z;

public final class bn
{
  public String cCE = "";
  public int cCz = 0;
  public String countryCode = "";
  private String dXs = "";
  private String dXt = "";
  public String dXu = "";
  public String dXv = "";
  public int sex = 0;
  public String signature = "";
  
  public static bn Id()
  {
    bn localbn = new bn();
    localbn.cCz = 1;
    localbn.sex = bk.a((Integer)g.DP().Dz().get(12290, null), 0);
    localbn.dXs = ((String)g.DP().Dz().get(12293, null));
    localbn.dXt = ((String)g.DP().Dz().get(12292, null));
    localbn.signature = ((String)g.DP().Dz().get(12291, null));
    localbn.cCE = ((String)g.DP().Dz().get(12307, null));
    localbn.countryCode = ((String)g.DP().Dz().get(12324, null));
    localbn.dXv = ((String)g.DP().Dz().get(12325, null));
    localbn.dXu = ((String)g.DP().Dz().get(12326, null));
    return localbn;
  }
  
  public static bn Ie()
  {
    if (bk.a((Integer)g.DP().Dz().get(12289, null), 0) == 0) {
      return null;
    }
    return Id();
  }
  
  public static axx a(bn parambn)
  {
    g.DP().Dz().o(12289, Integer.valueOf(parambn.cCz));
    g.DP().Dz().o(12290, Integer.valueOf(parambn.sex));
    if (bn.a.aa((String)g.DP().Dz().get(12293, null), parambn.getProvince())) {
      g.DP().Dz().o(12293, parambn.getProvince());
    }
    if (bn.a.aa((String)g.DP().Dz().get(12292, null), parambn.getCity())) {
      g.DP().Dz().o(12292, parambn.getCity());
    }
    if (bn.a.aa((String)g.DP().Dz().get(12291, null), parambn.signature)) {
      g.DP().Dz().o(12291, parambn.signature);
    }
    if (bn.a.aa((String)g.DP().Dz().get(12307, null), parambn.cCE)) {
      g.DP().Dz().o(12307, parambn.cCE);
    }
    if (bn.a.aa((String)g.DP().Dz().get(12324, null), parambn.countryCode)) {
      g.DP().Dz().o(12324, parambn.countryCode);
    }
    if (bn.a.aa((String)g.DP().Dz().get(12325, null), parambn.dXv)) {
      g.DP().Dz().o(12325, parambn.dXv);
    }
    if (bn.a.aa((String)g.DP().Dz().get(12326, null), parambn.dXu)) {
      g.DP().Dz().o(12326, parambn.dXu);
    }
    axx localaxx = new axx();
    localaxx.tue = 128;
    localaxx.sQs = new bml().YI("");
    localaxx.tmw = new bml().YI("");
    localaxx.stM = 0;
    localaxx.tuf = new bml().YI("");
    localaxx.tug = new bml().YI("");
    localaxx.hQq = 0;
    byte[] arrayOfByte2 = com.tencent.mm.vfs.e.c("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localaxx.tuc = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label588;
      }
    }
    label588:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localaxx.tub = i;
      localaxx.ffh = parambn.sex;
      localaxx.ffl = parambn.cCz;
      localaxx.ffk = bk.pm(parambn.signature);
      localaxx.ffj = bk.pm(parambn.dXu);
      localaxx.ffi = bk.pm(parambn.dXv);
      localaxx.stP = 0;
      localaxx.tpi = bk.pm(parambn.cCE);
      localaxx.tul = 0;
      localaxx.ffm = "";
      localaxx.tpk = 0;
      localaxx.tpj = "";
      localaxx.ffq = bk.pm(parambn.countryCode);
      return localaxx;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public final String getCity()
  {
    if (!bk.bl(this.countryCode))
    {
      if (bk.bl(this.dXv)) {
        break label93;
      }
      if (!bk.bl(this.dXu)) {
        break label67;
      }
      RegionCodeDecoder.cvV();
      this.dXt = RegionCodeDecoder.gp(this.countryCode, this.dXv);
    }
    while (bk.bl(this.dXt))
    {
      return bk.pm(this.dXu);
      label67:
      RegionCodeDecoder.cvV();
      this.dXt = RegionCodeDecoder.ap(this.countryCode, this.dXv, this.dXu);
      continue;
      label93:
      this.dXt = "";
    }
    return this.dXt;
  }
  
  public final String getProvince()
  {
    if (!bk.bl(this.countryCode))
    {
      if ((bk.bl(this.dXv)) || (bk.bl(this.dXu)) || (!RegionCodeDecoder.acl(this.countryCode))) {
        break label77;
      }
      RegionCodeDecoder.cvV();
    }
    for (this.dXs = RegionCodeDecoder.gp(this.countryCode, this.dXv); bk.bl(this.dXs); this.dXs = RegionCodeDecoder.acm(this.countryCode))
    {
      return bk.pm(this.dXv);
      label77:
      RegionCodeDecoder.cvV();
    }
    return this.dXs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.bn
 * JD-Core Version:    0.7.0.1
 */