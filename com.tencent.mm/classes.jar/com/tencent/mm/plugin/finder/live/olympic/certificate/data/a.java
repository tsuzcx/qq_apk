package com.tencent.mm.plugin.finder.live.olympic.certificate.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fom;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData;", "", "torchCert", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData$TorchCert;", "verifyInfoCert", "", "(Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData$TorchCert;Ljava/lang/String;)V", "getTorchCert", "()Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData$TorchCert;", "setTorchCert", "(Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData$TorchCert;)V", "getVerifyInfoCert", "()Ljava/lang/String;", "setVerifyInfoCert", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "TorchCert", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a CPi;
  public b CPj;
  public String CPk;
  
  static
  {
    AppMethodBeat.i(360966);
    CPi = new a((byte)0);
    AppMethodBeat.o(360966);
  }
  
  public a(b paramb, String paramString)
  {
    AppMethodBeat.i(360958);
    this.CPj = paramb;
    this.CPk = paramString;
    AppMethodBeat.o(360958);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(360984);
    if (this == paramObject)
    {
      AppMethodBeat.o(360984);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(360984);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.CPj, paramObject.CPj))
    {
      AppMethodBeat.o(360984);
      return false;
    }
    if (!s.p(this.CPk, paramObject.CPk))
    {
      AppMethodBeat.o(360984);
      return false;
    }
    AppMethodBeat.o(360984);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(360978);
    int j = this.CPj.hashCode();
    if (this.CPk == null) {}
    for (int i = 0;; i = this.CPk.hashCode())
    {
      AppMethodBeat.o(360978);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(360972);
    String str = "CertificateData(torchCert=" + this.CPj + ", verifyInfoCert=" + this.CPk + ')';
    AppMethodBeat.o(360972);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData$Companion;", "", "()V", "convertCertificateData", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData;", "respose", "Lcom/tencent/mm/protocal/protobuf/AddTorchCertResponse;", "Lcom/tencent/mm/protocal/protobuf/GetTorchCertResponse;", "Lcom/tencent/mm/protocal/protobuf/UpdateTorchCertResponse;", "convertTorchCert", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData$TorchCert;", "torchCert", "Lcom/tencent/mm/protocal/protobuf/TorchCert;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a.b a(fom paramfom)
    {
      AppMethodBeat.i(360960);
      s.u(paramfom, "torchCert");
      long l = paramfom.aaIb;
      String str = paramfom.name;
      LinkedList localLinkedList = paramfom.CPm;
      s.s(localLinkedList, "torchCert.locations");
      paramfom = new a.b(l, str, localLinkedList, paramfom.aaYz, paramfom.abOT, paramfom.abOU, paramfom.YGe, paramfom.aaId, paramfom.abOW, paramfom.abOV);
      AppMethodBeat.o(360960);
      return paramfom;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData$TorchCert;", "", "certId", "", "name", "", "locations", "Ljava/util/LinkedList;", "fromNickname", "fromIcon", "sportStep", "isLightTorch", "", "isJoinRunWith", "isShowRunWith", "isAccessLocation", "(JLjava/lang/String;Ljava/util/LinkedList;Ljava/lang/String;Ljava/lang/String;JZZZZ)V", "getCertId", "()J", "setCertId", "(J)V", "getFromIcon", "()Ljava/lang/String;", "setFromIcon", "(Ljava/lang/String;)V", "getFromNickname", "setFromNickname", "()Z", "setAccessLocation", "(Z)V", "setJoinRunWith", "setLightTorch", "setShowRunWith", "getLocations", "()Ljava/util/LinkedList;", "setLocations", "(Ljava/util/LinkedList;)V", "getName", "setName", "getSportStep", "setSportStep", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public long CPl;
    public LinkedList<String> CPm;
    public String CPn;
    public long CPo;
    public boolean CPp;
    public boolean CPq;
    public boolean CPr;
    public boolean CPs;
    public String name;
    public String oyP;
    
    public b(long paramLong1, String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      AppMethodBeat.i(360964);
      this.CPl = paramLong1;
      this.name = paramString1;
      this.CPm = paramLinkedList;
      this.oyP = paramString2;
      this.CPn = paramString3;
      this.CPo = paramLong2;
      this.CPp = paramBoolean1;
      this.CPq = paramBoolean2;
      this.CPr = paramBoolean3;
      this.CPs = paramBoolean4;
      AppMethodBeat.o(360964);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(360986);
      if (this == paramObject)
      {
        AppMethodBeat.o(360986);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(360986);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.CPl != paramObject.CPl)
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (!s.p(this.name, paramObject.name))
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (!s.p(this.CPm, paramObject.CPm))
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (!s.p(this.oyP, paramObject.oyP))
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (!s.p(this.CPn, paramObject.CPn))
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (this.CPo != paramObject.CPo)
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (this.CPp != paramObject.CPp)
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (this.CPq != paramObject.CPq)
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (this.CPr != paramObject.CPr)
      {
        AppMethodBeat.o(360986);
        return false;
      }
      if (this.CPs != paramObject.CPs)
      {
        AppMethodBeat.o(360986);
        return false;
      }
      AppMethodBeat.o(360986);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(360971);
      String str = "TorchCert(certId=" + this.CPl + ", name=" + this.name + ", locations=" + this.CPm + ", fromNickname=" + this.oyP + ", fromIcon=" + this.CPn + ", sportStep=" + this.CPo + ", isLightTorch=" + this.CPp + ", isJoinRunWith=" + this.CPq + ", isShowRunWith=" + this.CPr + ", isAccessLocation=" + this.CPs + ')';
      AppMethodBeat.o(360971);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.data.a
 * JD-Core Version:    0.7.0.1
 */