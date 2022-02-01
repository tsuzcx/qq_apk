package com.tencent.mm.mj_template.maas.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$MaasMovieSessionInitialParams;", "", "scene", "", "musicMuted", "", "originMuted", "randomMusic", "maxDurationInSeconds", "", "shouldRetainOriginalMediaDuration", "defaultTemplateIDs", "", "retainOriginalMediaDurationThresholdInSeconds", "(Ljava/lang/String;ZZZIZLjava/util/List;I)V", "getDefaultTemplateIDs", "()Ljava/util/List;", "getMaxDurationInSeconds", "()I", "getMusicMuted", "()Z", "getOriginMuted", "getRandomMusic", "getRetainOriginalMediaDurationThresholdInSeconds", "getScene", "()Ljava/lang/String;", "getShouldRetainOriginalMediaDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
{
  public static final int Ue = 8;
  public final List<String> defaultTemplateIDs;
  public final boolean obW;
  public final boolean obX;
  public final boolean obY;
  public final int obZ;
  public final String scene;
  public final boolean shouldRetainOriginalMediaDuration;
  public final int uxv;
  
  public a$c(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, List<String> paramList, int paramInt2)
  {
    AppMethodBeat.i(369578);
    this.scene = paramString;
    this.obW = false;
    this.obX = paramBoolean1;
    this.obY = paramBoolean2;
    this.obZ = paramInt1;
    this.shouldRetainOriginalMediaDuration = paramBoolean3;
    this.defaultTemplateIDs = paramList;
    this.uxv = paramInt2;
    AppMethodBeat.o(369578);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(239952);
    if (this == paramObject)
    {
      AppMethodBeat.o(239952);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(239952);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.scene, paramObject.scene))
    {
      AppMethodBeat.o(239952);
      return false;
    }
    if (this.obW != paramObject.obW)
    {
      AppMethodBeat.o(239952);
      return false;
    }
    if (this.obX != paramObject.obX)
    {
      AppMethodBeat.o(239952);
      return false;
    }
    if (this.obY != paramObject.obY)
    {
      AppMethodBeat.o(239952);
      return false;
    }
    if (this.obZ != paramObject.obZ)
    {
      AppMethodBeat.o(239952);
      return false;
    }
    if (this.shouldRetainOriginalMediaDuration != paramObject.shouldRetainOriginalMediaDuration)
    {
      AppMethodBeat.o(239952);
      return false;
    }
    if (!s.p(this.defaultTemplateIDs, paramObject.defaultTemplateIDs))
    {
      AppMethodBeat.o(239952);
      return false;
    }
    if (this.uxv != paramObject.uxv)
    {
      AppMethodBeat.o(239952);
      return false;
    }
    AppMethodBeat.o(239952);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239936);
    String str = "MaasMovieSessionInitialParams(scene=" + this.scene + ", musicMuted=" + this.obW + ", originMuted=" + this.obX + ", randomMusic=" + this.obY + ", maxDurationInSeconds=" + this.obZ + ", shouldRetainOriginalMediaDuration=" + this.shouldRetainOriginalMediaDuration + ", defaultTemplateIDs=" + this.defaultTemplateIDs + ", retainOriginalMediaDurationThresholdInSeconds=" + this.uxv + ')';
    AppMethodBeat.o(239936);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.c.a.c
 * JD-Core Version:    0.7.0.1
 */