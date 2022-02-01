package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b
  extends f
{
  public String dXf;
  public String ivA;
  public String ivB;
  public String ivC;
  public String ivD;
  public String ivE;
  public String ivF;
  public String ivG;
  public String ivH;
  public String ivI;
  public String ivJ;
  public String ivK;
  public String ivL;
  public String ivM;
  public String ivN;
  public String ivr;
  public String ivs;
  public String ivt;
  public String ivu;
  public String ivv;
  public String ivw;
  public String ivx;
  public String ivy;
  public String ivz;
  
  private static String c(Map<String, String> paramMap, String paramString)
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
    if (paramb.type == 2002)
    {
      this.ivr = c(paramMap, "templateid");
      this.ivs = c(paramMap, "senderurl");
      this.ivt = c(paramMap, "sendernativeurl");
      this.ivu = c(paramMap, "receiverurl");
      this.ivv = c(paramMap, "receivernativeurl");
      this.ivw = c(paramMap, "iconurl");
      this.ivx = c(paramMap, "miniiconurl");
      this.ivy = c(paramMap, "backgroundurl");
      this.ivz = c(paramMap, "backgroundname");
      this.ivA = c(paramMap, "backgroundcolor");
      this.ivB = c(paramMap, "receivertitle");
      this.ivC = c(paramMap, "sendertitle");
      this.ivD = c(paramMap, "titlecolor");
      this.ivE = c(paramMap, "senderscenetext");
      this.ivF = c(paramMap, "receiverscenetext");
      this.ivG = c(paramMap, "senderdes");
      this.ivH = c(paramMap, "receiverdes");
      this.ivI = c(paramMap, "descolor");
      this.ivJ = c(paramMap, "sceneid");
      this.dXf = c(paramMap, "paymsgid");
      this.ivK = c(paramMap, "senderbackgroundname");
      this.ivL = c(paramMap, "senderbackgroundurl");
      this.ivM = c(paramMap, "receiverbackgroundname");
      this.ivN = c(paramMap, "receiverbackgroundurl");
    }
    AppMethodBeat.o(20228);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(20227);
    b localb = new b();
    AppMethodBeat.o(20227);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.b
 * JD-Core Version:    0.7.0.1
 */