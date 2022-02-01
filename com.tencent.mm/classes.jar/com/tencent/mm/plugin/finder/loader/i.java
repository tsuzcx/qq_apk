package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements r
{
  public final String Exa;
  private final String url;
  
  public i(String paramString)
  {
    AppMethodBeat.i(166310);
    this.url = paramString;
    this.Exa = s.X("finder_cover_", MD5Util.getMD5String(this.url));
    AppMethodBeat.o(166310);
  }
  
  public final String aUt()
  {
    return this.Exa;
  }
  
  public final v eCd()
  {
    return v.FKY;
  }
  
  public final String eCe()
  {
    return "";
  }
  
  public final String eCf()
  {
    return "";
  }
  
  public final String eCg()
  {
    return "";
  }
  
  public final String eCi()
  {
    return this.url;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166309);
    Object localObject = bm.GlZ;
    localObject = bm.a(this);
    AppMethodBeat.o(166309);
    return localObject;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.i
 * JD-Core Version:    0.7.0.1
 */