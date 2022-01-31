package com.tencent.mm.ae;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public class a
  extends d
{
  public boolean dPD;
  public String dPE;
  public int dPF;
  public boolean dPG;
  public String dPH;
  public String dPI;
  public String dPJ;
  public String dPK;
  public String dPL;
  public String dPM;
  public int dPN;
  public int dPO;
  public String dPP;
  
  public final d Fk()
  {
    a locala = new a();
    locala.dPD = this.dPD;
    locala.dPE = this.dPE;
    locala.dPF = this.dPF;
    locala.dPG = this.dPG;
    locala.dPH = this.dPH;
    locala.dPI = this.dPI;
    locala.dPJ = this.dPJ;
    locala.dPK = this.dPK;
    locala.dPL = this.dPL;
    locala.dPN = this.dPN;
    locala.dPO = this.dPO;
    locala.dPP = this.dPP;
    return locala;
  }
  
  public final void a(StringBuilder paramStringBuilder, g.a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append("<weappinfo>");
    if (!bk.bl(parama.dSX)) {
      paramStringBuilder.append("<pagepath>" + g.a.gq(parama.dSX) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + bk.ZP(parama.dSY) + "</username>");
    paramStringBuilder.append("<appid>" + bk.ZP(parama.dSZ) + "</appid>");
    if (parama.dTg != 0) {
      paramStringBuilder.append("<version>" + parama.dTg + "</version>");
    }
    if (parama.dTa != 0) {
      paramStringBuilder.append("<type>" + parama.dTa + "</type>");
    }
    if (!bk.bl(parama.dTh)) {
      paramStringBuilder.append("<weappiconurl>" + g.a.gq(parama.dTh) + "</weappiconurl>");
    }
    if (!bk.bl(parama.dTd)) {
      paramStringBuilder.append("<shareId>" + g.a.gq(parama.dTd) + "</shareId>");
    }
    if ((parama.dTf == 1) || (parama.dTf == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(parama.dTf);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(parama.dTb);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!bk.bl(parama.dTe)) {
      paramStringBuilder.append("<sharekey>" + g.a.gq(parama.dTe) + "</sharekey>");
    }
    if (!bk.bl(this.dPP)) {
      paramStringBuilder.append("<messageextradata>").append(g.a.gq(this.dPP)).append("</messageextradata>");
    }
    if (this.dPD)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(g.a.gq(this.dPE));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.dPG)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.dPN);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.dPO);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(g.a.gq(this.dPH));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(g.a.gq(this.dPI));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(g.a.gq(this.dPJ));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(g.a.gq(this.dPK));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(g.a.gq(this.dPL));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(g.a.gq(this.dPM));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.dPF + "</appservicetype>");
    paramStringBuilder.append("</weappinfo>");
  }
  
  public final void a(Map<String, String> paramMap, g.a parama)
  {
    boolean bool2 = false;
    if (bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.dPD = bool1;
      this.dPE = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.dPF = bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.dPF);
      this.dPP = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      bool1 = bool2;
      if (bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) == 1) {
        bool1 = true;
      }
      this.dPG = bool1;
      this.dPH = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.dPI = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.dPJ = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.dPK = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.dPL = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.dPM = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.dPO = bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.dPN = bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ae.a
 * JD-Core Version:    0.7.0.1
 */