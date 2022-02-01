package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.sdk.platformtools.ah;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder_release"})
public final class d
  implements j
{
  public final String rtf;
  private final String url;
  
  public d(String paramString)
  {
    AppMethodBeat.i(166310);
    this.url = paramString;
    this.rtf = ("finder_cover_" + ah.dg(this.url));
    AppMethodBeat.o(166310);
  }
  
  public final String abW()
  {
    return this.rtf;
  }
  
  public final String aik()
  {
    return this.url;
  }
  
  public final m cwj()
  {
    return m.rDQ;
  }
  
  public final String cwk()
  {
    return "";
  }
  
  public final String cwl()
  {
    return "";
  }
  
  public final String cwm()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166309);
    Object localObject = p.rQw;
    localObject = p.a(this);
    AppMethodBeat.o(166309);
    return localObject;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.d
 * JD-Core Version:    0.7.0.1
 */