package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderItem$PosTriggerConfig;", "", "maxUnreadCount", "", "showTime", "showPercentage", "preLoadTime", "preLoadPercentage", "logic", "", "isLocalDefault", "", "(IIIIILjava/lang/String;Z)V", "()Z", "setLocalDefault", "(Z)V", "getLogic", "()Ljava/lang/String;", "getMaxUnreadCount", "()I", "getPreLoadPercentage", "getPreLoadTime", "getShowPercentage", "getShowTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class FinderItem$c
{
  public final int FUF;
  public final int KQu;
  private boolean KTX;
  public final int KWD;
  public final int KWE;
  public final int KWF;
  public final String KWG;
  
  public FinderItem$c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198986);
    this.KQu = paramInt1;
    this.FUF = paramInt2;
    this.KWD = paramInt3;
    this.KWE = paramInt4;
    this.KWF = paramInt5;
    this.KWG = paramString;
    this.KTX = paramBoolean;
    AppMethodBeat.o(198986);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198988);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.KQu != paramObject.KQu) || (this.FUF != paramObject.FUF) || (this.KWD != paramObject.KWD) || (this.KWE != paramObject.KWE) || (this.KWF != paramObject.KWF) || (!k.g(this.KWG, paramObject.KWG)) || (this.KTX != paramObject.KTX)) {}
      }
    }
    else
    {
      AppMethodBeat.o(198988);
      return true;
    }
    AppMethodBeat.o(198988);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198985);
    String str = "maxUnreadCount=" + this.KQu + ",showTime=" + this.FUF + ",showPercentage=" + this.KWD + ",preLoadTime=" + this.KWE + ",preLoadPercentage=" + this.KWF + ",logic=" + this.KWG + ",isLocalDefault=" + this.KTX;
    AppMethodBeat.o(198985);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.FinderItem.c
 * JD-Core Version:    0.7.0.1
 */