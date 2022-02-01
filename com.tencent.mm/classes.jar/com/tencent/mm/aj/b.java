package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b
  extends f
{
  public String fQR;
  public String lkA;
  public String lkB;
  public String lkC;
  public String lkD;
  public String lkE;
  public String lkF;
  public String lkG;
  public String lkH;
  public String lkI;
  public String lkJ;
  public String lkK;
  public String lkL;
  public String lkM;
  public String lkN;
  public String lkO;
  public String lkP;
  public String lkQ;
  public String lkR;
  public String lkS;
  public String lkT;
  public String lkU;
  public String lkV;
  public String lkW;
  public String lkX;
  public String lkY;
  public String lkZ;
  public String lla;
  
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
    if ((paramb.type == 2002) || (paramb.type == 2003))
    {
      this.lkA = c(paramMap, "templateid");
      this.lkB = c(paramMap, "senderurl");
      this.lkC = c(paramMap, "sendernativeurl");
      this.lkD = c(paramMap, "receiverurl");
      this.lkE = c(paramMap, "receivernativeurl");
      this.lkF = c(paramMap, "iconurl");
      this.lkG = c(paramMap, "miniiconurl");
      this.lkH = c(paramMap, "backgroundurl");
      this.lkI = c(paramMap, "backgroundname");
      this.lkJ = c(paramMap, "backgroundcolor");
      this.lkK = c(paramMap, "receivertitle");
      this.lkL = c(paramMap, "sendertitle");
      this.lkM = c(paramMap, "titlecolor");
      this.lkX = c(paramMap, "titlecolordark");
      this.lkN = c(paramMap, "senderscenetext");
      this.lkO = c(paramMap, "receiverscenetext");
      this.lkP = c(paramMap, "senderdes");
      this.lkQ = c(paramMap, "receiverdes");
      this.lkR = c(paramMap, "descolor");
      this.lkY = c(paramMap, "descolordark");
      this.lla = c(paramMap, "scenetextcolor");
      this.lkZ = c(paramMap, "scenetextcolordark");
      this.lkS = c(paramMap, "sceneid");
      this.fQR = c(paramMap, "paymsgid");
      this.lkT = c(paramMap, "senderbackgroundname");
      this.lkU = c(paramMap, "senderbackgroundurl");
      this.lkV = c(paramMap, "receiverbackgroundname");
      this.lkW = c(paramMap, "receiverbackgroundurl");
    }
    AppMethodBeat.o(20228);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(20227);
    b localb = new b();
    AppMethodBeat.o(20227);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.b
 * JD-Core Version:    0.7.0.1
 */