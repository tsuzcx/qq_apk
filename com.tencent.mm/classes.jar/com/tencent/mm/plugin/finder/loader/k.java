package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderBlurUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "blurUrl", "", "blurMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "uniqueValue", "plugin-finder_release"})
public final class k
  extends x
{
  private final String ztw;
  private final u ztx;
  
  public k(String paramString, u paramu)
  {
    super(paramString, paramu);
    AppMethodBeat.i(281266);
    this.ztw = paramString;
    this.ztx = paramu;
    AppMethodBeat.o(281266);
  }
  
  public final String aBv()
  {
    AppMethodBeat.i(281265);
    String str = this.ztx.detail + "_finder_blur_" + getMd5();
    AppMethodBeat.o(281265);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.k
 * JD-Core Version:    0.7.0.1
 */