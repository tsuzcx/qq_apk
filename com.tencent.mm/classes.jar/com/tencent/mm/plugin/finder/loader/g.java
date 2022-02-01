package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder_release"})
public final class g
  implements o
{
  public final String uId;
  private final String url;
  
  public g(String paramString)
  {
    AppMethodBeat.i(166310);
    this.url = paramString;
    this.uId = ("finder_cover_" + MD5Util.getMD5String(this.url));
    AppMethodBeat.o(166310);
  }
  
  public final String aBE()
  {
    return this.url;
  }
  
  public final String auA()
  {
    return this.uId;
  }
  
  public final x djU()
  {
    return x.vEn;
  }
  
  public final String djV()
  {
    return "";
  }
  
  public final String djW()
  {
    return "";
  }
  
  public final String djX()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166309);
    Object localObject = al.waC;
    localObject = al.a(this);
    AppMethodBeat.o(166309);
    return localObject;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.g
 * JD-Core Version:    0.7.0.1
 */