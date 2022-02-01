package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "", "type", "", "subType", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubType", "()Ljava/lang/String;", "getType", "component1", "component2", "contains", "", "mimeType", "copy", "equals", "other", "hashCode", "", "isWildcard", "toString", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  private static final Comparator<c> nlt;
  public static final a nlu;
  final String nls;
  final String type;
  
  static
  {
    AppMethodBeat.i(229148);
    nlu = new a((byte)0);
    nlt = (Comparator)b.nlv;
    AppMethodBeat.o(229148);
  }
  
  private c(String paramString1, String paramString2)
  {
    this.type = paramString1;
    this.nls = paramString2;
  }
  
  public final boolean bQf()
  {
    AppMethodBeat.i(229147);
    boolean bool = p.j("*", this.nls);
    AppMethodBeat.o(229147);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229151);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.j(this.type, paramObject.type)) || (!p.j(this.nls, paramObject.nls))) {}
      }
    }
    else
    {
      AppMethodBeat.o(229151);
      return true;
    }
    AppMethodBeat.o(229151);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(229150);
    String str = this.type;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.nls;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(229150);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229149);
    String str = "MimeType(type=" + this.type + ", subType=" + this.nls + ")";
    AppMethodBeat.o(229149);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType$Companion;", "", "()V", "comparator", "Ljava/util/Comparator;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "getComparator", "()Ljava/util/Comparator;", "create", "mimeType", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static c adm(String paramString)
    {
      AppMethodBeat.i(229146);
      p.h(paramString, "mimeType");
      Log.d("MicroMsg.AppBrand.OpenMaterialMimeTypeWhiteList", "MimeType#create, mimeType: ".concat(String.valueOf(paramString)));
      Object localObject = Locale.US;
      p.g(localObject, "Locale.US");
      paramString = paramString.toLowerCase((Locale)localObject);
      p.g(paramString, "(this as java.lang.String).toLowerCase(locale)");
      paramString = n.a((CharSequence)paramString, new char[] { '/' });
      if (2 != paramString.size())
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialMimeTypeWhiteList", "MimeType#create, typeList is illegal");
        AppMethodBeat.o(229146);
        return null;
      }
      localObject = (String)paramString.get(0);
      if (p.j("*", localObject))
      {
        Log.w("MicroMsg.AppBrand.OpenMaterialMimeTypeWhiteList", "MimeType#create, type is wildcard");
        AppMethodBeat.o(229146);
        return null;
      }
      paramString = new c((String)localObject, (String)paramString.get(1), (byte)0);
      AppMethodBeat.o(229146);
      return paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "lhs", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "kotlin.jvm.PlatformType", "rhs", "compare"})
  static final class b<T>
    implements Comparator<c>
  {
    public static final b nlv;
    
    static
    {
      AppMethodBeat.i(229145);
      nlv = new b();
      AppMethodBeat.o(229145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.c
 * JD-Core Version:    0.7.0.1
 */