package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
final class k$a
  implements w
{
  k$a(f paramf) {}
  
  public final boolean accept(o paramo, String paramString)
  {
    AppMethodBeat.i(229740);
    p.h(paramString, "name");
    paramo = n.a((CharSequence)paramString, new char[] { '.' });
    if ((2 > paramo.size()) || ((p.j("png", (String)j.ku(paramo)) ^ true)))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, invalid res: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(229740);
      return false;
    }
    paramo = n.a((CharSequence)paramo.get(0), new char[] { '_' });
    StringBuilder localStringBuilder = new StringBuilder("copyStickerItemResourcesIfNeed, nameList2: ");
    Object localObject = ((Collection)paramo).toArray(new String[0]);
    if (localObject == null)
    {
      paramo = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(229740);
      throw paramo;
    }
    localObject = Arrays.toString((Object[])localObject);
    p.g(localObject, "java.util.Arrays.toString(this)");
    Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", (String)localObject);
    if (2 > paramo.size())
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, invalid res: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(229740);
      return false;
    }
    paramString = this.oGS;
    paramo = n.buA((String)j.ku(paramo));
    if ((paramo != null) && (paramString.contains(paramo.intValue())))
    {
      AppMethodBeat.o(229740);
      return true;
    }
    AppMethodBeat.o(229740);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.k.a
 * JD-Core Version:    0.7.0.1
 */