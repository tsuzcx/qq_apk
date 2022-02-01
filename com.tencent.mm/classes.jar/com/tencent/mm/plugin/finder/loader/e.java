package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder_release"})
public final class e
  implements k
{
  public final String srn;
  private final String url;
  
  public e(String paramString)
  {
    AppMethodBeat.i(166310);
    this.url = paramString;
    this.srn = ("finder_cover_" + aj.ej(this.url));
    AppMethodBeat.o(166310);
  }
  
  public final String aeM()
  {
    return this.srn;
  }
  
  public final String all()
  {
    return this.url;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cEj()
  {
    return com.tencent.mm.plugin.finder.storage.r.sJu;
  }
  
  public final String cEk()
  {
    return "";
  }
  
  public final String cEl()
  {
    return "";
  }
  
  public final String cEm()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166309);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sYn;
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