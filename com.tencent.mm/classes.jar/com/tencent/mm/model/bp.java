package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.z;

public final class bp
{
  public String countryCode = "";
  public int dqC = 0;
  public int dqL = 0;
  public String dqO = "";
  private String fnA = "";
  public String fnB = "";
  public String fnC = "";
  private String fnz = "";
  public String signature = "";
  
  public static beq a(bp parambp)
  {
    AppMethodBeat.i(59929);
    g.RL().Ru().set(12289, Integer.valueOf(parambp.dqL));
    g.RL().Ru().set(12290, Integer.valueOf(parambp.dqC));
    if (a.aq((String)g.RL().Ru().get(12293, null), parambp.getProvince())) {
      g.RL().Ru().set(12293, parambp.getProvince());
    }
    if (a.aq((String)g.RL().Ru().get(12292, null), parambp.getCity())) {
      g.RL().Ru().set(12292, parambp.getCity());
    }
    if (a.aq((String)g.RL().Ru().get(12291, null), parambp.signature)) {
      g.RL().Ru().set(12291, parambp.signature);
    }
    if (a.aq((String)g.RL().Ru().get(12307, null), parambp.dqO)) {
      g.RL().Ru().set(12307, parambp.dqO);
    }
    if (a.aq((String)g.RL().Ru().get(12324, null), parambp.countryCode)) {
      g.RL().Ru().set(12324, parambp.countryCode);
    }
    if (a.aq((String)g.RL().Ru().get(12325, null), parambp.fnC)) {
      g.RL().Ru().set(12325, parambp.fnC);
    }
    if (a.aq((String)g.RL().Ru().get(12326, null), parambp.fnB)) {
      g.RL().Ru().set(12326, parambp.fnB);
    }
    beq localbeq = new beq();
    localbeq.xug = 128;
    localbeq.wOT = new bwc().aoF("");
    localbeq.xmi = new bwc().aoF("");
    localbeq.wmq = 0;
    localbeq.xuh = new bwc().aoF("");
    localbeq.xui = new bwc().aoF("");
    localbeq.jJS = 0;
    byte[] arrayOfByte2 = com.tencent.mm.vfs.e.i("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localbeq.xue = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label598;
      }
    }
    label598:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localbeq.xud = i;
      localbeq.gwP = parambp.dqC;
      localbeq.gwT = parambp.dqL;
      localbeq.gwS = bo.nullAsNil(parambp.signature);
      localbeq.gwR = bo.nullAsNil(parambp.fnB);
      localbeq.gwQ = bo.nullAsNil(parambp.fnC);
      localbeq.wmt = 0;
      localbeq.xpg = bo.nullAsNil(parambp.dqO);
      localbeq.xun = 0;
      localbeq.gwU = "";
      localbeq.xpi = 0;
      localbeq.xph = "";
      localbeq.gwY = bo.nullAsNil(parambp.countryCode);
      AppMethodBeat.o(59929);
      return localbeq;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static bp aba()
  {
    AppMethodBeat.i(59927);
    bp localbp = new bp();
    localbp.dqL = 1;
    localbp.dqC = bo.a((Integer)g.RL().Ru().get(12290, null), 0);
    localbp.fnz = ((String)g.RL().Ru().get(12293, null));
    localbp.fnA = ((String)g.RL().Ru().get(12292, null));
    localbp.signature = ((String)g.RL().Ru().get(12291, null));
    localbp.dqO = ((String)g.RL().Ru().get(12307, null));
    localbp.countryCode = ((String)g.RL().Ru().get(12324, null));
    localbp.fnC = ((String)g.RL().Ru().get(12325, null));
    localbp.fnB = ((String)g.RL().Ru().get(12326, null));
    AppMethodBeat.o(59927);
    return localbp;
  }
  
  public static bp abb()
  {
    AppMethodBeat.i(59928);
    if (bo.a((Integer)g.RL().Ru().get(12289, null), 0) == 0)
    {
      AppMethodBeat.o(59928);
      return null;
    }
    bp localbp = aba();
    AppMethodBeat.o(59928);
    return localbp;
  }
  
  public final String getCity()
  {
    AppMethodBeat.i(59930);
    if (!bo.isNullOrNil(this.countryCode))
    {
      if (bo.isNullOrNil(this.fnC)) {
        break label105;
      }
      if (!bo.isNullOrNil(this.fnB)) {
        break label79;
      }
      RegionCodeDecoder.dyE();
      this.fnA = RegionCodeDecoder.iq(this.countryCode, this.fnC);
    }
    while (bo.isNullOrNil(this.fnA))
    {
      str = bo.nullAsNil(this.fnB);
      AppMethodBeat.o(59930);
      return str;
      label79:
      RegionCodeDecoder.dyE();
      this.fnA = RegionCodeDecoder.aG(this.countryCode, this.fnC, this.fnB);
      continue;
      label105:
      this.fnA = "";
    }
    String str = this.fnA;
    AppMethodBeat.o(59930);
    return str;
  }
  
  public final String getProvince()
  {
    AppMethodBeat.i(59931);
    if (!bo.isNullOrNil(this.countryCode))
    {
      if ((bo.isNullOrNil(this.fnC)) || (bo.isNullOrNil(this.fnB)) || (!RegionCodeDecoder.asx(this.countryCode))) {
        break label89;
      }
      RegionCodeDecoder.dyE();
    }
    for (this.fnz = RegionCodeDecoder.iq(this.countryCode, this.fnC); bo.isNullOrNil(this.fnz); this.fnz = RegionCodeDecoder.asy(this.countryCode))
    {
      str = bo.nullAsNil(this.fnC);
      AppMethodBeat.o(59931);
      return str;
      label89:
      RegionCodeDecoder.dyE();
    }
    String str = this.fnz;
    AppMethodBeat.o(59931);
    return str;
  }
  
  static final class a
  {
    public static boolean aq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(59924);
      if (bo.isNullOrNil(paramString1))
      {
        AppMethodBeat.o(59924);
        return true;
      }
      paramString1 = decode(encode(paramString1));
      if ((bo.isNullOrNil(paramString1)) || (!paramString1.equals(paramString2)))
      {
        AppMethodBeat.o(59924);
        return true;
      }
      AppMethodBeat.o(59924);
      return false;
    }
    
    private static String decode(String paramString)
    {
      AppMethodBeat.i(59926);
      String str = "";
      if ((bo.isNullOrNil(paramString)) || (paramString.length() % 2 != 0))
      {
        AppMethodBeat.o(59926);
        return "";
      }
      int i = 0;
      try
      {
        while (i < paramString.length())
        {
          str = str + (char)Integer.parseInt(paramString.substring(i, i + 2), 16);
          i += 2;
        }
        AppMethodBeat.o(59926);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(59926);
        return "";
      }
      return str;
    }
    
    private static String encode(String paramString)
    {
      int i = 0;
      AppMethodBeat.i(59925);
      char[] arrayOfChar = paramString.toCharArray();
      paramString = "";
      try
      {
        int j = arrayOfChar.length;
        while (i < j)
        {
          int k = arrayOfChar[i];
          paramString = paramString + String.format("%02x", new Object[] { Integer.valueOf(k) });
          i += 1;
        }
        AppMethodBeat.o(59925);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(59925);
        return "";
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bp
 * JD-Core Version:    0.7.0.1
 */