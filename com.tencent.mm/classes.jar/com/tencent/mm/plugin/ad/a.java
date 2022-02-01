package com.tencent.mm.plugin.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "", "domain", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "manifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "extInfo", "", "bizScene", "", "subBizScene", "debug", "", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;Ljava/lang/String;IIZ)V", "getBizScene", "()I", "setBizScene", "(I)V", "getDebug", "()Z", "getDomain", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getManifest", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "getSubBizScene", "setSubBizScene", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "webview-sdk_release"})
public final class a
{
  public final bhc ICs;
  public final bhd ICt;
  public final boolean aXs;
  public String extInfo;
  public int hDa;
  public int pmN;
  
  private a(bhc parambhc, bhd parambhd, boolean paramBoolean)
  {
    AppMethodBeat.i(224904);
    this.ICs = parambhc;
    this.ICt = parambhd;
    this.extInfo = null;
    this.hDa = 0;
    this.pmN = 0;
    this.aXs = paramBoolean;
    AppMethodBeat.o(224904);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224908);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.ICs, paramObject.ICs)) || (!p.j(this.ICt, paramObject.ICt)) || (!p.j(this.extInfo, paramObject.extInfo)) || (this.hDa != paramObject.hDa) || (this.pmN != paramObject.pmN) || (this.aXs != paramObject.aXs)) {}
      }
    }
    else
    {
      AppMethodBeat.o(224908);
      return true;
    }
    AppMethodBeat.o(224908);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224906);
    String str = "PrefetchManifest(domain=" + this.ICs + ", manifest=" + this.ICt + ", extInfo=" + this.extInfo + ", bizScene=" + this.hDa + ", subBizScene=" + this.pmN + ", debug=" + this.aXs + ")";
    AppMethodBeat.o(224906);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a
 * JD-Core Version:    0.7.0.1
 */