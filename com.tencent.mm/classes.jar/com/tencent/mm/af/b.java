package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class b
  extends f
{
  public String cEg;
  public String ffA;
  public String ffB;
  public String ffC;
  public String ffD;
  public String ffE;
  public String ffF;
  public String ffG;
  public String ffH;
  public String ffI;
  public String ffJ;
  public String ffK;
  public String ffL;
  public String ffM;
  public String ffN;
  public String ffO;
  public String ffP;
  public String ffQ;
  public String ffR;
  public String ffS;
  public String ffT;
  public String ffU;
  public String ffy;
  public String ffz;
  
  private static String d(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(16186);
    paramMap = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(16186);
    return paramMap;
  }
  
  public final f Yk()
  {
    AppMethodBeat.i(16184);
    b localb = new b();
    AppMethodBeat.o(16184);
    return localb;
  }
  
  public final void a(Map<String, String> paramMap, j.b paramb)
  {
    AppMethodBeat.i(16185);
    if (paramb.type == 2002)
    {
      this.ffy = d(paramMap, "templateid");
      this.ffz = d(paramMap, "senderurl");
      this.ffA = d(paramMap, "sendernativeurl");
      this.ffB = d(paramMap, "receiverurl");
      this.ffC = d(paramMap, "receivernativeurl");
      this.ffD = d(paramMap, "iconurl");
      this.ffE = d(paramMap, "miniiconurl");
      this.ffF = d(paramMap, "backgroundurl");
      this.ffG = d(paramMap, "backgroundname");
      this.ffH = d(paramMap, "backgroundcolor");
      this.ffI = d(paramMap, "receivertitle");
      this.ffJ = d(paramMap, "sendertitle");
      this.ffK = d(paramMap, "titlecolor");
      this.ffL = d(paramMap, "senderscenetext");
      this.ffM = d(paramMap, "receiverscenetext");
      this.ffN = d(paramMap, "senderdes");
      this.ffO = d(paramMap, "receiverdes");
      this.ffP = d(paramMap, "descolor");
      this.ffQ = d(paramMap, "sceneid");
      this.cEg = d(paramMap, "paymsgid");
      this.ffR = d(paramMap, "senderbackgroundname");
      this.ffS = d(paramMap, "senderbackgroundurl");
      this.ffT = d(paramMap, "receiverbackgroundname");
      this.ffU = d(paramMap, "receiverbackgroundurl");
    }
    AppMethodBeat.o(16185);
  }
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.af.b
 * JD-Core Version:    0.7.0.1
 */