package com.tencent.mm.plugin.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "", "domain", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "manifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "extInfo", "", "bizScene", "", "subBizScene", "debug", "", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;Ljava/lang/String;IIZ)V", "getBizScene", "()I", "setBizScene", "(I)V", "getDebug", "()Z", "getDomain", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getManifest", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "getSubBizScene", "setSubBizScene", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final ccy WmS;
  public final ccz WmT;
  public final boolean debug;
  public String extInfo;
  public int mUU;
  public int vBa;
  
  private a(ccy paramccy, ccz paramccz, boolean paramBoolean)
  {
    AppMethodBeat.i(260991);
    this.WmS = paramccy;
    this.WmT = paramccz;
    this.extInfo = null;
    this.mUU = 0;
    this.vBa = 0;
    this.debug = paramBoolean;
    AppMethodBeat.o(260991);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261014);
    if (this == paramObject)
    {
      AppMethodBeat.o(261014);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(261014);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.WmS, paramObject.WmS))
    {
      AppMethodBeat.o(261014);
      return false;
    }
    if (!s.p(this.WmT, paramObject.WmT))
    {
      AppMethodBeat.o(261014);
      return false;
    }
    if (!s.p(this.extInfo, paramObject.extInfo))
    {
      AppMethodBeat.o(261014);
      return false;
    }
    if (this.mUU != paramObject.mUU)
    {
      AppMethodBeat.o(261014);
      return false;
    }
    if (this.vBa != paramObject.vBa)
    {
      AppMethodBeat.o(261014);
      return false;
    }
    if (this.debug != paramObject.debug)
    {
      AppMethodBeat.o(261014);
      return false;
    }
    AppMethodBeat.o(261014);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(261001);
    String str = "PrefetchManifest(domain=" + this.WmS + ", manifest=" + this.WmT + ", extInfo=" + this.extInfo + ", bizScene=" + this.mUU + ", subBizScene=" + this.vBa + ", debug=" + this.debug + ')';
    AppMethodBeat.o(261001);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.az.a
 * JD-Core Version:    0.7.0.1
 */