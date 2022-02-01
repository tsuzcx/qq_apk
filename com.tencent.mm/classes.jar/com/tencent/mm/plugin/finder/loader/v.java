package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.dji;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "media", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  implements x
{
  public final dji ExE;
  public final com.tencent.mm.plugin.finder.storage.v ExF;
  private String Exa;
  final int Ezm;
  private final String username;
  
  private v(dji paramdji, com.tencent.mm.plugin.finder.storage.v paramv, int paramInt, String paramString)
  {
    AppMethodBeat.i(331767);
    this.ExE = paramdji;
    this.ExF = paramv;
    this.Ezm = paramInt;
    this.username = paramString;
    AppMethodBeat.o(331767);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(331797);
    Object localObject1 = this.Exa;
    if (localObject1 == null)
    {
      localObject1 = (v)this;
      Object localObject2 = bm.GlZ;
      localObject2 = bm.aq(((v)localObject1).ExF.detail, ((v)localObject1).ExE.mediaId, ((v)localObject1).ExE.url);
      ((v)localObject1).Exa = ((String)localObject2);
      AppMethodBeat.o(331797);
      return localObject2;
    }
    AppMethodBeat.o(331797);
    return localObject1;
  }
  
  public final dji eCF()
  {
    return this.ExE;
  }
  
  public final int eCG()
  {
    return this.Ezm;
  }
  
  public final com.tencent.mm.plugin.finder.storage.v eCd()
  {
    return this.ExF;
  }
  
  public final String eCe()
  {
    String str2 = this.ExE.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String eCf()
  {
    String str2 = this.ExE.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String eCg()
  {
    String str2 = this.ExE.thumb_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String eCi()
  {
    String str2 = this.ExE.thumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(331790);
    Object localObject = bm.GlZ;
    localObject = bm.a(this);
    AppMethodBeat.o(331790);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.ExE.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(331819);
    String str = this.ExE.mediaId + " url=" + this.ExE.url;
    AppMethodBeat.o(331819);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.v
 * JD-Core Version:    0.7.0.1
 */