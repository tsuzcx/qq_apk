package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.v;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderBlurUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "blurUrl", "", "blurMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "uniqueValue", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends s
{
  private final String Exo;
  private final v Exp;
  
  public g(String paramString, v paramv)
  {
    super(paramString, paramv);
    AppMethodBeat.i(331720);
    this.Exo = paramString;
    this.Exp = paramv;
    AppMethodBeat.o(331720);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(331723);
    String str = this.Exp.detail + "_finder_blur_" + getMd5();
    AppMethodBeat.o(331723);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.g
 * JD-Core Version:    0.7.0.1
 */