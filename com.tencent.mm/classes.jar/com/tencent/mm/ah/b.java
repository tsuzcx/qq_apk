package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class b
  extends f
{
  public String dFs;
  public String hBA;
  public String hBB;
  public String hBC;
  public String hBD;
  public String hBE;
  public String hBF;
  public String hBG;
  public String hBH;
  public String hBl;
  public String hBm;
  public String hBn;
  public String hBo;
  public String hBp;
  public String hBq;
  public String hBr;
  public String hBs;
  public String hBt;
  public String hBu;
  public String hBv;
  public String hBw;
  public String hBx;
  public String hBy;
  public String hBz;
  
  private static String c(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(20229);
    paramMap = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(20229);
    return paramMap;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20228);
    if (paramb.type == 2002)
    {
      this.hBl = c(paramMap, "templateid");
      this.hBm = c(paramMap, "senderurl");
      this.hBn = c(paramMap, "sendernativeurl");
      this.hBo = c(paramMap, "receiverurl");
      this.hBp = c(paramMap, "receivernativeurl");
      this.hBq = c(paramMap, "iconurl");
      this.hBr = c(paramMap, "miniiconurl");
      this.hBs = c(paramMap, "backgroundurl");
      this.hBt = c(paramMap, "backgroundname");
      this.hBu = c(paramMap, "backgroundcolor");
      this.hBv = c(paramMap, "receivertitle");
      this.hBw = c(paramMap, "sendertitle");
      this.hBx = c(paramMap, "titlecolor");
      this.hBy = c(paramMap, "senderscenetext");
      this.hBz = c(paramMap, "receiverscenetext");
      this.hBA = c(paramMap, "senderdes");
      this.hBB = c(paramMap, "receiverdes");
      this.hBC = c(paramMap, "descolor");
      this.hBD = c(paramMap, "sceneid");
      this.dFs = c(paramMap, "paymsgid");
      this.hBE = c(paramMap, "senderbackgroundname");
      this.hBF = c(paramMap, "senderbackgroundurl");
      this.hBG = c(paramMap, "receiverbackgroundname");
      this.hBH = c(paramMap, "receiverbackgroundurl");
    }
    AppMethodBeat.o(20228);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(20227);
    b localb = new b();
    AppMethodBeat.o(20227);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.b
 * JD-Core Version:    0.7.0.1
 */