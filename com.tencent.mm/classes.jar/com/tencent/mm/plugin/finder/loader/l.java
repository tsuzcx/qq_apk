package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "id", "name", "isPreviewPag", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public final class l
  implements o
{
  private final String id;
  private final String name;
  private final boolean uIA;
  private final String url;
  
  public l(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(248226);
    this.url = paramString1;
    this.id = paramString2;
    this.name = paramString3;
    this.uIA = paramBoolean;
    AppMethodBeat.o(248226);
  }
  
  public final String aBE()
  {
    return this.url;
  }
  
  public final String auA()
  {
    AppMethodBeat.i(248225);
    String str = this.id + '_' + djU();
    AppMethodBeat.o(248225);
    return str;
  }
  
  public final x djU()
  {
    if (this.uIA) {
      return x.vEC;
    }
    return x.vEB;
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
    return "";
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.l
 * JD-Core Version:    0.7.0.1
 */