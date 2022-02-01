package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.csg;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "media", "toString", "plugin-finder_release"})
public final class aa
  implements ac
{
  private final String username;
  public final csg ztO;
  public final u ztP;
  private String ztf;
  final int zvu;
  
  private aa(csg paramcsg, u paramu, int paramInt, String paramString)
  {
    AppMethodBeat.i(286467);
    this.ztO = paramcsg;
    this.ztP = paramu;
    this.zvu = paramInt;
    this.username = paramString;
    AppMethodBeat.o(286467);
  }
  
  public final String aBv()
  {
    AppMethodBeat.i(286464);
    Object localObject2 = this.ztf;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (aa)this;
      localObject1 = av.AJz;
      localObject1 = av.ai(((aa)localObject2).ztP.detail, ((aa)localObject2).ztO.mediaId, ((aa)localObject2).ztO.url);
      ((aa)localObject2).ztf = ((String)localObject1);
    }
    AppMethodBeat.o(286464);
    return localObject1;
  }
  
  public final String aJi()
  {
    AppMethodBeat.i(286465);
    String str2 = this.ztO.thumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "mediaObj.thumbUrl ?: \"\"");
    AppMethodBeat.o(286465);
    return str1;
  }
  
  public final u dIX()
  {
    return this.ztP;
  }
  
  public final String dIY()
  {
    String str2 = this.ztO.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String dIZ()
  {
    String str2 = this.ztO.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String dJa()
  {
    String str2 = this.ztO.thumb_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final csg dJw()
  {
    return this.ztO;
  }
  
  public final int dJx()
  {
    return this.zvu;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(286463);
    Object localObject = av.AJz;
    localObject = av.a(this);
    AppMethodBeat.o(286463);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.ztO.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286466);
    String str = this.ztO.mediaId + " url=" + this.ztO.url;
    AppMethodBeat.o(286466);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.aa
 * JD-Core Version:    0.7.0.1
 */