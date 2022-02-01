package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder_release"})
public final class e
  implements k
{
  public final String sis;
  private final String url;
  
  public e(String paramString)
  {
    AppMethodBeat.i(166310);
    this.url = paramString;
    this.sis = ("finder_cover_" + ai.ee(this.url));
    AppMethodBeat.o(166310);
  }
  
  public final String aeA()
  {
    return this.sis;
  }
  
  public final String akW()
  {
    return this.url;
  }
  
  public final String cCA()
  {
    return "";
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cCx()
  {
    return com.tencent.mm.plugin.finder.storage.r.syD;
  }
  
  public final String cCy()
  {
    return "";
  }
  
  public final String cCz()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166309);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sNc;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166309);
    return localObject;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.e
 * JD-Core Version:    0.7.0.1
 */