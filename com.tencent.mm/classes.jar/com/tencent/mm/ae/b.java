package com.tencent.mm.ae;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public class b
  extends d
{
  public String bWt;
  public String dPQ;
  public String dPR;
  public String dPS;
  public String dPT;
  public String dPU;
  public String dPV;
  public String dPW;
  public String dPX;
  public String dPY;
  public String dPZ;
  public String dQa;
  public String dQb;
  public String dQc;
  public String dQd;
  public String dQe;
  public String dQf;
  public String dQg;
  public String dQh;
  public String dQi;
  public String dQj;
  public String dQk;
  public String dQl;
  public String dQm;
  
  private static String d(Map<String, String> paramMap, String paramString)
  {
    return bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo." + paramString));
  }
  
  public final d Fk()
  {
    return new b();
  }
  
  public final void a(StringBuilder paramStringBuilder, g.a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, g.a parama)
  {
    if (parama.type == 2002)
    {
      this.dPQ = d(paramMap, "templateid");
      this.dPR = d(paramMap, "senderurl");
      this.dPS = d(paramMap, "sendernativeurl");
      this.dPT = d(paramMap, "receiverurl");
      this.dPU = d(paramMap, "receivernativeurl");
      this.dPV = d(paramMap, "iconurl");
      this.dPW = d(paramMap, "miniiconurl");
      this.dPX = d(paramMap, "backgroundurl");
      this.dPY = d(paramMap, "backgroundname");
      this.dPZ = d(paramMap, "backgroundcolor");
      this.dQa = d(paramMap, "receivertitle");
      this.dQb = d(paramMap, "sendertitle");
      this.dQc = d(paramMap, "titlecolor");
      this.dQd = d(paramMap, "senderscenetext");
      this.dQe = d(paramMap, "receiverscenetext");
      this.dQf = d(paramMap, "senderdes");
      this.dQg = d(paramMap, "receiverdes");
      this.dQh = d(paramMap, "descolor");
      this.dQi = d(paramMap, "sceneid");
      this.bWt = d(paramMap, "paymsgid");
      this.dQj = d(paramMap, "senderbackgroundname");
      this.dQk = d(paramMap, "senderbackgroundurl");
      this.dQl = d(paramMap, "receiverbackgroundname");
      this.dQm = d(paramMap, "receiverbackgroundurl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ae.b
 * JD-Core Version:    0.7.0.1
 */