package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvz;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "toString", "plugin-finder_release"})
public final class m
  implements k
{
  private String srn;
  public final bvz srx;
  public final com.tencent.mm.plugin.finder.storage.r sry;
  public final int ssj;
  private final String username;
  
  private m(bvz parambvz, com.tencent.mm.plugin.finder.storage.r paramr, int paramInt, String paramString)
  {
    AppMethodBeat.i(203397);
    this.srx = parambvz;
    this.sry = paramr;
    this.ssj = paramInt;
    this.username = paramString;
    AppMethodBeat.o(203397);
  }
  
  public final String aeM()
  {
    AppMethodBeat.i(166334);
    Object localObject2 = this.srn;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (m)this;
      localObject1 = com.tencent.mm.plugin.finder.utils.r.sYn;
      localObject1 = com.tencent.mm.plugin.finder.utils.r.bw(((m)localObject2).sry.detail, ((m)localObject2).srx.mediaId, ((m)localObject2).srx.url);
      ((m)localObject2).srn = ((String)localObject1);
    }
    AppMethodBeat.o(166334);
    return localObject1;
  }
  
  public final String all()
  {
    AppMethodBeat.i(166336);
    String str2 = this.srx.thumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "mediaObj.thumbUrl ?: \"\"");
    AppMethodBeat.o(166336);
    return str1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cEj()
  {
    return this.sry;
  }
  
  public final String cEk()
  {
    String str2 = this.srx.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cEl()
  {
    String str2 = this.srx.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cEm()
  {
    String str2 = this.srx.thumb_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166333);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sYn;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166333);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166335);
    String str2 = this.srx.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(166335);
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166337);
    String str = this.srx.mediaId + " url=" + this.srx.url;
    AppMethodBeat.o(166337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.m
 * JD-Core Version:    0.7.0.1
 */