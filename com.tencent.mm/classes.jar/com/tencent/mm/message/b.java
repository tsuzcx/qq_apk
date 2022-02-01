package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b
  extends f
{
  public String hWO;
  public String nPA;
  public String nPB;
  public String nPC;
  public String nPD;
  public String nPE;
  public String nPF;
  public String nPG;
  public String nPH;
  public String nPI;
  public String nPJ;
  public String nPK;
  public String nPL;
  public String nPM;
  public String nPN;
  public String nPO;
  public String nPP;
  public String nPm;
  public String nPn;
  public String nPo;
  public String nPp;
  public String nPq;
  public String nPr;
  public String nPs;
  public String nPt;
  public String nPu;
  public String nPv;
  public String nPw;
  public String nPx;
  public String nPy;
  public String nPz;
  
  private static String d(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(20229);
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(20229);
    return paramMap;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20228);
    if ((paramb.type == 2002) || (paramb.type == 2003))
    {
      this.nPm = d(paramMap, "templateid");
      this.nPn = d(paramMap, "senderurl");
      this.nPo = d(paramMap, "sendernativeurl");
      this.nPp = d(paramMap, "receiverurl");
      this.nPq = d(paramMap, "receivernativeurl");
      this.nPr = d(paramMap, "iconurl");
      this.nPs = d(paramMap, "darkiconurl");
      this.nPt = d(paramMap, "miniiconurl");
      this.nPu = d(paramMap, "backgroundurl");
      this.nPv = d(paramMap, "backgroundname");
      this.nPw = d(paramMap, "backgroundcolor");
      this.nPx = d(paramMap, "receivertitle");
      this.nPy = d(paramMap, "sendertitle");
      this.nPz = d(paramMap, "titlecolor");
      this.nPK = d(paramMap, "titlecolordark");
      this.nPA = d(paramMap, "senderscenetext");
      this.nPB = d(paramMap, "receiverscenetext");
      this.nPC = d(paramMap, "senderdes");
      this.nPD = d(paramMap, "receiverdes");
      this.nPE = d(paramMap, "descolor");
      this.nPL = d(paramMap, "descolordark");
      this.nPN = d(paramMap, "scenetextcolor");
      this.nPM = d(paramMap, "scenetextcolordark");
      this.nPF = d(paramMap, "sceneid");
      this.hWO = d(paramMap, "paymsgid");
      this.nPG = d(paramMap, "senderbackgroundname");
      this.nPH = d(paramMap, "senderbackgroundurl");
      this.nPI = d(paramMap, "receiverbackgroundname");
      this.nPJ = d(paramMap, "receiverbackgroundurl");
      this.nPO = d(paramMap, "realtitlecolordark");
      this.nPP = d(paramMap, "realdescolordark");
    }
    AppMethodBeat.o(20228);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(20227);
    b localb = new b();
    AppMethodBeat.o(20227);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.b
 * JD-Core Version:    0.7.0.1
 */