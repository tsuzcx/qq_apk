package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-finder_release"})
public final class a$b
{
  private static final b rvS;
  public static final a.b.a rvT;
  public final String drn;
  public final int frB;
  public final long preloadMinSize;
  public final String rvP;
  public final com.tencent.mm.plugin.finder.loader.l rvQ;
  private final boolean rvR;
  
  static
  {
    AppMethodBeat.i(202627);
    rvT = new a.b.a((byte)0);
    rvS = new b(0, 0L, "", "", new com.tencent.mm.plugin.finder.loader.l(new bqs(), m.rEd, 0, null, 12), (byte)0);
    AppMethodBeat.o(202627);
  }
  
  private a$b(int paramInt, long paramLong, String paramString1, String paramString2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(202626);
    this.frB = paramInt;
    this.preloadMinSize = paramLong;
    this.drn = paramString1;
    this.rvP = paramString2;
    this.rvQ = paraml;
    this.rvR = false;
    AppMethodBeat.o(202626);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202629);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.frB != paramObject.frB) || (this.preloadMinSize != paramObject.preloadMinSize) || (!k.g(this.drn, paramObject.drn)) || (!k.g(this.rvP, paramObject.rvP)) || (!k.g(this.rvQ, paramObject.rvQ)) || (this.rvR != paramObject.rvR)) {}
      }
    }
    else
    {
      AppMethodBeat.o(202629);
      return true;
    }
    AppMethodBeat.o(202629);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202625);
    String str = this.frB + "%:" + this.preloadMinSize + "bytes:format=" + this.drn + ':' + this.rvP + " isLocalDefault=" + this.rvR;
    AppMethodBeat.o(202625);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a.b
 * JD-Core Version:    0.7.0.1
 */