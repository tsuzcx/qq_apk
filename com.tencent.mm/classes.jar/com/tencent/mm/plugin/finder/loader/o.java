package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.v;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "id", "name", "isPreviewPag", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements r
{
  private final boolean ExH;
  private final String id;
  private final String name;
  private final String url;
  
  public o(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(331761);
    this.url = paramString1;
    this.id = paramString2;
    this.name = paramString3;
    this.ExH = paramBoolean;
    AppMethodBeat.o(331761);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(331804);
    String str = this.id + '_' + eCd();
    AppMethodBeat.o(331804);
    return str;
  }
  
  public final v eCd()
  {
    if (this.ExH) {
      return v.FLD;
    }
    return v.FLC;
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
    return "";
  }
  
  public final String getUrl()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.o
 * JD-Core Version:    0.7.0.1
 */