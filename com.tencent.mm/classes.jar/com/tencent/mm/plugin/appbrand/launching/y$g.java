package com.tencent.mm.plugin.appbrand.launching;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "", "()V", "toInt", "", "DESC", "LATEST", "SPECIFIED", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$DESC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class y$g
{
  public int cAf()
  {
    return -1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$DESC;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "desc", "", "(Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toInt", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends y.g
  {
    final String desc;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(320627);
      this.desc = paramString;
      AppMethodBeat.o(320627);
    }
    
    public final int cAf()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(320645);
      if (this == paramObject)
      {
        AppMethodBeat.o(320645);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(320645);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.desc, paramObject.desc))
      {
        AppMethodBeat.o(320645);
        return false;
      }
      AppMethodBeat.o(320645);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(320641);
      int i = this.desc.hashCode();
      AppMethodBeat.o(320641);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320633);
      String str = "DESC(" + this.desc + ')';
      AppMethodBeat.o(320633);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "forceUpdate", "", "(IZ)V", "getForceUpdate", "()Z", "getVersion", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toForceUpdate", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends y.g
  {
    final boolean tae;
    final int version;
    
    public b()
    {
      this(0, false, 3);
    }
    
    private b(int paramInt, boolean paramBoolean)
    {
      super();
      this.version = paramInt;
      this.tae = paramBoolean;
    }
    
    public final b cAg()
    {
      AppMethodBeat.i(320646);
      b localb = new b(this.version, true);
      AppMethodBeat.o(320646);
      return localb;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.version != paramObject.version) {
          return false;
        }
      } while (this.tae == paramObject.tae);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180579);
      String str = "LATEST(" + this.version + "|forceUpdate:" + this.tae + ')';
      AppMethodBeat.o(180579);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "templateId", "", "(IJ)V", "getTemplateId", "()J", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toInt", "toLong", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends y.g
  {
    final long rcA;
    public final int version;
    
    public c(int paramInt, long paramLong)
    {
      super();
      this.version = paramInt;
      this.rcA = paramLong;
    }
    
    public final int cAf()
    {
      return this.version;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.version != paramObject.version) {
          return false;
        }
      } while (this.rcA == paramObject.rcA);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(320647);
      int i = this.version;
      int j = q.a..ExternalSyntheticBackport0.m(this.rcA);
      AppMethodBeat.o(320647);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180580);
      if (this.rcA >= 0L)
      {
        str = "VERSION(" + this.version + '|' + this.rcA + ')';
        AppMethodBeat.o(180580);
        return str;
      }
      String str = "VERSION(" + this.version + ')';
      AppMethodBeat.o(180580);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y.g
 * JD-Core Version:    0.7.0.1
 */