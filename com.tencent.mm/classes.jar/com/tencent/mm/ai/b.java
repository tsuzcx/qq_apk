package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class b
  extends f
{
  public String duI;
  public String gFN;
  public String gFO;
  public String gFP;
  public String gFQ;
  public String gFR;
  public String gFS;
  public String gFT;
  public String gFU;
  public String gFV;
  public String gFW;
  public String gFX;
  public String gFY;
  public String gFZ;
  public String gGa;
  public String gGb;
  public String gGc;
  public String gGd;
  public String gGe;
  public String gGf;
  public String gGg;
  public String gGh;
  public String gGi;
  public String gGj;
  
  private static String c(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(20229);
    paramMap = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(20229);
    return paramMap;
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20228);
    if (paramb.type == 2002)
    {
      this.gFN = c(paramMap, "templateid");
      this.gFO = c(paramMap, "senderurl");
      this.gFP = c(paramMap, "sendernativeurl");
      this.gFQ = c(paramMap, "receiverurl");
      this.gFR = c(paramMap, "receivernativeurl");
      this.gFS = c(paramMap, "iconurl");
      this.gFT = c(paramMap, "miniiconurl");
      this.gFU = c(paramMap, "backgroundurl");
      this.gFV = c(paramMap, "backgroundname");
      this.gFW = c(paramMap, "backgroundcolor");
      this.gFX = c(paramMap, "receivertitle");
      this.gFY = c(paramMap, "sendertitle");
      this.gFZ = c(paramMap, "titlecolor");
      this.gGa = c(paramMap, "senderscenetext");
      this.gGb = c(paramMap, "receiverscenetext");
      this.gGc = c(paramMap, "senderdes");
      this.gGd = c(paramMap, "receiverdes");
      this.gGe = c(paramMap, "descolor");
      this.gGf = c(paramMap, "sceneid");
      this.duI = c(paramMap, "paymsgid");
      this.gGg = c(paramMap, "senderbackgroundname");
      this.gGh = c(paramMap, "senderbackgroundurl");
      this.gGi = c(paramMap, "receiverbackgroundname");
      this.gGj = c(paramMap, "receiverbackgroundurl");
    }
    AppMethodBeat.o(20228);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(20227);
    b localb = new b();
    AppMethodBeat.o(20227);
    return localb;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.b
 * JD-Core Version:    0.7.0.1
 */