package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderBlurUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "blurUrl", "", "blurMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "uniqueValue", "plugin-finder_release"})
public final class e
  extends p
{
  private final String uIm;
  private final x uIn;
  
  public e(String paramString, x paramx)
  {
    super(paramString, paramx);
    AppMethodBeat.i(248212);
    this.uIm = paramString;
    this.uIn = paramx;
    AppMethodBeat.o(248212);
  }
  
  public final String auA()
  {
    AppMethodBeat.i(248211);
    String str = this.uIn.detail + "_finder_blur_" + this.md5;
    AppMethodBeat.o(248211);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.e
 * JD-Core Version:    0.7.0.1
 */