package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class b
  extends f
{
  public String dEn;
  public String hyA;
  public String hyB;
  public String hyC;
  public String hyD;
  public String hyE;
  public String hyF;
  public String hyG;
  public String hyH;
  public String hyI;
  public String hyJ;
  public String hyK;
  public String hyL;
  public String hyM;
  public String hyN;
  public String hyO;
  public String hyP;
  public String hyQ;
  public String hyR;
  public String hyS;
  public String hyT;
  public String hyx;
  public String hyy;
  public String hyz;
  
  private static String c(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(20229);
    paramMap = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(20229);
    return paramMap;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20228);
    if (paramb.type == 2002)
    {
      this.hyx = c(paramMap, "templateid");
      this.hyy = c(paramMap, "senderurl");
      this.hyz = c(paramMap, "sendernativeurl");
      this.hyA = c(paramMap, "receiverurl");
      this.hyB = c(paramMap, "receivernativeurl");
      this.hyC = c(paramMap, "iconurl");
      this.hyD = c(paramMap, "miniiconurl");
      this.hyE = c(paramMap, "backgroundurl");
      this.hyF = c(paramMap, "backgroundname");
      this.hyG = c(paramMap, "backgroundcolor");
      this.hyH = c(paramMap, "receivertitle");
      this.hyI = c(paramMap, "sendertitle");
      this.hyJ = c(paramMap, "titlecolor");
      this.hyK = c(paramMap, "senderscenetext");
      this.hyL = c(paramMap, "receiverscenetext");
      this.hyM = c(paramMap, "senderdes");
      this.hyN = c(paramMap, "receiverdes");
      this.hyO = c(paramMap, "descolor");
      this.hyP = c(paramMap, "sceneid");
      this.dEn = c(paramMap, "paymsgid");
      this.hyQ = c(paramMap, "senderbackgroundname");
      this.hyR = c(paramMap, "senderbackgroundurl");
      this.hyS = c(paramMap, "receiverbackgroundname");
      this.hyT = c(paramMap, "receiverbackgroundurl");
    }
    AppMethodBeat.o(20228);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(20227);
    b localb = new b();
    AppMethodBeat.o(20227);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.b
 * JD-Core Version:    0.7.0.1
 */