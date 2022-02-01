package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder_release"})
public final class d
  implements j
{
  public final String qCd;
  private final String url;
  
  public d(String paramString)
  {
    AppMethodBeat.i(166310);
    this.url = paramString;
    this.qCd = ("finder_cover_" + ai.du(this.url));
    AppMethodBeat.o(166310);
  }
  
  public final String aaX()
  {
    return this.qCd;
  }
  
  public final h cmR()
  {
    return h.qJY;
  }
  
  public final String cmS()
  {
    return "";
  }
  
  public final String cmT()
  {
    return this.url;
  }
  
  public final String fTN()
  {
    return "";
  }
  
  public final String fTO()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166309);
    Object localObject = k.qTp;
    localObject = k.a(this);
    AppMethodBeat.o(166309);
    return localObject;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.d
 * JD-Core Version:    0.7.0.1
 */