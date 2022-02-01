package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;

public final class bt
{
  public String cityCode = "";
  public String countryCode = "";
  public int ePk = 0;
  public int ePt = 0;
  public String ePy = "";
  private String hHV = "";
  private String hHW = "";
  public String provinceCode = "";
  public String signature = "";
  
  public static caq a(bt parambt)
  {
    AppMethodBeat.i(42985);
    g.ajC().ajl().set(12289, Integer.valueOf(parambt.ePt));
    g.ajC().ajl().set(12290, Integer.valueOf(parambt.ePk));
    if (bt.a.aO((String)g.ajC().ajl().get(12293, null), parambt.getProvince())) {
      g.ajC().ajl().set(12293, parambt.getProvince());
    }
    if (bt.a.aO((String)g.ajC().ajl().get(12292, null), parambt.getCity())) {
      g.ajC().ajl().set(12292, parambt.getCity());
    }
    if (bt.a.aO((String)g.ajC().ajl().get(12291, null), parambt.signature)) {
      g.ajC().ajl().set(12291, parambt.signature);
    }
    if (bt.a.aO((String)g.ajC().ajl().get(12307, null), parambt.ePy)) {
      g.ajC().ajl().set(12307, parambt.ePy);
    }
    if (bt.a.aO((String)g.ajC().ajl().get(12324, null), parambt.countryCode)) {
      g.ajC().ajl().set(12324, parambt.countryCode);
    }
    if (bt.a.aO((String)g.ajC().ajl().get(12325, null), parambt.provinceCode)) {
      g.ajC().ajl().set(12325, parambt.provinceCode);
    }
    if (bt.a.aO((String)g.ajC().ajl().get(12326, null), parambt.cityCode)) {
      g.ajC().ajl().set(12326, parambt.cityCode);
    }
    caq localcaq = new caq();
    localcaq.GVj = 128;
    localcaq.GbY = new cwt().aPy("");
    localcaq.GKC = new cwt().aPy("");
    localcaq.Fsf = 0;
    localcaq.GVk = new cwt().aPy("");
    localcaq.GVl = new cwt().aPy("");
    localcaq.nDG = 0;
    byte[] arrayOfByte2 = i.aY("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localcaq.GVh = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localcaq.GVg = i;
      localcaq.jdc = parambt.ePk;
      localcaq.jdg = parambt.ePt;
      localcaq.jdf = com.tencent.mm.sdk.platformtools.bt.nullAsNil(parambt.signature);
      localcaq.jde = com.tencent.mm.sdk.platformtools.bt.nullAsNil(parambt.cityCode);
      localcaq.jdd = com.tencent.mm.sdk.platformtools.bt.nullAsNil(parambt.provinceCode);
      localcaq.Fsi = 0;
      localcaq.GNW = com.tencent.mm.sdk.platformtools.bt.nullAsNil(parambt.ePy);
      localcaq.GVq = 0;
      localcaq.jdh = "";
      localcaq.GNY = 0;
      localcaq.GNX = "";
      localcaq.jdl = com.tencent.mm.sdk.platformtools.bt.nullAsNil(parambt.countryCode);
      AppMethodBeat.o(42985);
      return localcaq;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static bt aCv()
  {
    AppMethodBeat.i(42983);
    bt localbt = new bt();
    localbt.ePt = 1;
    localbt.ePk = com.tencent.mm.sdk.platformtools.bt.a((Integer)g.ajC().ajl().get(12290, null), 0);
    localbt.hHV = ((String)g.ajC().ajl().get(12293, null));
    localbt.hHW = ((String)g.ajC().ajl().get(12292, null));
    localbt.signature = ((String)g.ajC().ajl().get(12291, null));
    localbt.ePy = ((String)g.ajC().ajl().get(12307, null));
    localbt.countryCode = ((String)g.ajC().ajl().get(12324, null));
    localbt.provinceCode = ((String)g.ajC().ajl().get(12325, null));
    localbt.cityCode = ((String)g.ajC().ajl().get(12326, null));
    AppMethodBeat.o(42983);
    return localbt;
  }
  
  public static bt aCw()
  {
    AppMethodBeat.i(42984);
    if (com.tencent.mm.sdk.platformtools.bt.a((Integer)g.ajC().ajl().get(12289, null), 0) == 0)
    {
      AppMethodBeat.o(42984);
      return null;
    }
    bt localbt = aCv();
    AppMethodBeat.o(42984);
    return localbt;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(42986);
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.countryCode))
    {
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.provinceCode)) {
        break label105;
      }
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.cityCode)) {
        break label79;
      }
      RegionCodeDecoder.fsz();
      this.hHW = RegionCodeDecoder.mb(this.countryCode, this.provinceCode);
    }
    while (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.hHW))
    {
      str = com.tencent.mm.sdk.platformtools.bt.nullAsNil(this.cityCode);
      AppMethodBeat.o(42986);
      return str;
      label79:
      RegionCodeDecoder.fsz();
      this.hHW = RegionCodeDecoder.bh(this.countryCode, this.provinceCode, this.cityCode);
      continue;
      label105:
      this.hHW = "";
    }
    String str = this.hHW;
    AppMethodBeat.o(42986);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(42987);
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.countryCode))
    {
      if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.provinceCode)) || (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.cityCode)) || (!RegionCodeDecoder.aUp(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.fsz();
    }
    for (this.hHV = RegionCodeDecoder.mb(this.countryCode, this.provinceCode); com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.hHV); this.hHV = RegionCodeDecoder.aUq(this.countryCode))
    {
      str = com.tencent.mm.sdk.platformtools.bt.nullAsNil(this.provinceCode);
      AppMethodBeat.o(42987);
      return str;
      label89:
      RegionCodeDecoder.fsz();
    }
    String str = this.hHV;
    AppMethodBeat.o(42987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bt
 * JD-Core Version:    0.7.0.1
 */