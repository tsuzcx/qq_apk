package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "id", "name", "isPreviewPag", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public final class s
  implements w
{
  private final String id;
  private final String name;
  private final String url;
  private final boolean ztS;
  
  public s(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(288494);
    this.url = paramString1;
    this.id = paramString2;
    this.name = paramString3;
    this.ztS = paramBoolean;
    AppMethodBeat.o(288494);
  }
  
  public final String aBv()
  {
    AppMethodBeat.i(288493);
    String str = this.id + '_' + dIX();
    AppMethodBeat.o(288493);
    return str;
  }
  
  public final String aJi()
  {
    return this.url;
  }
  
  public final u dIX()
  {
    if (this.ztS) {
      return u.AlN;
    }
    return u.AlM;
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
    return "";
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.s
 * JD-Core Version:    0.7.0.1
 */