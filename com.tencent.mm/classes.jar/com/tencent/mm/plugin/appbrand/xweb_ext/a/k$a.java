package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.e;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
final class k$a
  implements z
{
  k$a(e parame) {}
  
  public final boolean accept(q paramq, String paramString)
  {
    AppMethodBeat.i(266474);
    p.k(paramString, "name");
    paramq = n.a((CharSequence)paramString, new char[] { '.' });
    if ((2 > paramq.size()) || ((p.h("png", (String)j.lq(paramq)) ^ true)))
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, invalid res: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(266474);
      return false;
    }
    paramq = n.a((CharSequence)paramq.get(0), new char[] { '_' });
    StringBuilder localStringBuilder = new StringBuilder("copyStickerItemResourcesIfNeed, nameList2: ");
    Object localObject = ((Collection)paramq).toArray(new String[0]);
    if (localObject == null)
    {
      paramq = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(266474);
      throw paramq;
    }
    localObject = Arrays.toString((Object[])localObject);
    p.j(localObject, "java.util.Arrays.toString(this)");
    Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", (String)localObject);
    if (2 > paramq.size())
    {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, invalid res: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(266474);
      return false;
    }
    paramString = this.rII;
    paramq = n.bHC((String)j.lq(paramq));
    if ((paramq != null) && (paramString.contains(paramq.intValue())))
    {
      AppMethodBeat.o(266474);
      return true;
    }
    AppMethodBeat.o(266474);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.k.a
 * JD-Core Version:    0.7.0.1
 */