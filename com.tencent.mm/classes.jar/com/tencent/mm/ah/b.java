package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class b
  extends f
{
  public String dsu;
  public String hgA;
  public String hgB;
  public String hgC;
  public String hgD;
  public String hgE;
  public String hgF;
  public String hgG;
  public String hgH;
  public String hgI;
  public String hgJ;
  public String hgK;
  public String hgo;
  public String hgp;
  public String hgq;
  public String hgr;
  public String hgs;
  public String hgt;
  public String hgu;
  public String hgv;
  public String hgw;
  public String hgx;
  public String hgy;
  public String hgz;
  
  private static String c(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(20229);
    paramMap = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(paramString))));
    AppMethodBeat.o(20229);
    return paramMap;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20228);
    if (paramb.type == 2002)
    {
      this.hgo = c(paramMap, "templateid");
      this.hgp = c(paramMap, "senderurl");
      this.hgq = c(paramMap, "sendernativeurl");
      this.hgr = c(paramMap, "receiverurl");
      this.hgs = c(paramMap, "receivernativeurl");
      this.hgt = c(paramMap, "iconurl");
      this.hgu = c(paramMap, "miniiconurl");
      this.hgv = c(paramMap, "backgroundurl");
      this.hgw = c(paramMap, "backgroundname");
      this.hgx = c(paramMap, "backgroundcolor");
      this.hgy = c(paramMap, "receivertitle");
      this.hgz = c(paramMap, "sendertitle");
      this.hgA = c(paramMap, "titlecolor");
      this.hgB = c(paramMap, "senderscenetext");
      this.hgC = c(paramMap, "receiverscenetext");
      this.hgD = c(paramMap, "senderdes");
      this.hgE = c(paramMap, "receiverdes");
      this.hgF = c(paramMap, "descolor");
      this.hgG = c(paramMap, "sceneid");
      this.dsu = c(paramMap, "paymsgid");
      this.hgH = c(paramMap, "senderbackgroundname");
      this.hgI = c(paramMap, "senderbackgroundurl");
      this.hgJ = c(paramMap, "receiverbackgroundname");
      this.hgK = c(paramMap, "receiverbackgroundurl");
    }
    AppMethodBeat.o(20228);
  }
  
  public final f alG()
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