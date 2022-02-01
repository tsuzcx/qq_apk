package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "plugin-finder_release"})
public final class m
  implements w
{
  private final String url;
  public final String ztf;
  
  public m(String paramString)
  {
    AppMethodBeat.i(166310);
    this.url = paramString;
    this.ztf = ("finder_cover_" + MD5Util.getMD5String(this.url));
    AppMethodBeat.o(166310);
  }
  
  public final String aBv()
  {
    return this.ztf;
  }
  
  public final String aJi()
  {
    return this.url;
  }
  
  public final u dIX()
  {
    return u.Aly;
  }
  
  public final String dIY()
  {
    return "";
  }
  
  public final String dIZ()
  {
    return "";
  }
  
  public final String dJa()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166309);
    Object localObject = av.AJz;
    localObject = av.a(this);
    AppMethodBeat.o(166309);
    return localObject;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.m
 * JD-Core Version:    0.7.0.1
 */