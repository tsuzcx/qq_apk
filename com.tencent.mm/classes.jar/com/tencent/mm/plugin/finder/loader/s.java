package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.cjl;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "toString", "plugin-finder_release"})
public final class s
  implements o
{
  private String uId;
  public final cjl uIw;
  public final x uIx;
  public final int uJN;
  private final String username;
  
  private s(cjl paramcjl, x paramx, int paramInt, String paramString)
  {
    AppMethodBeat.i(248244);
    this.uIw = paramcjl;
    this.uIx = paramx;
    this.uJN = paramInt;
    this.username = paramString;
    AppMethodBeat.o(248244);
  }
  
  public final String aBE()
  {
    AppMethodBeat.i(248242);
    String str2 = this.uIw.thumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "mediaObj.thumbUrl ?: \"\"");
    AppMethodBeat.o(248242);
    return str1;
  }
  
  public final String auA()
  {
    AppMethodBeat.i(248241);
    Object localObject2 = this.uId;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (s)this;
      localObject1 = al.waC;
      localObject1 = al.an(((s)localObject2).uIx.detail, ((s)localObject2).uIw.mediaId, ((s)localObject2).uIw.url);
      ((s)localObject2).uId = ((String)localObject1);
    }
    AppMethodBeat.o(248241);
    return localObject1;
  }
  
  public final x djU()
  {
    return this.uIx;
  }
  
  public final String djV()
  {
    String str2 = this.uIw.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String djW()
  {
    String str2 = this.uIw.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String djX()
  {
    String str2 = this.uIw.thumb_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(248240);
    Object localObject = al.waC;
    localObject = al.c(this);
    AppMethodBeat.o(248240);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.uIw.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248243);
    String str = this.uIw.mediaId + " url=" + this.uIw.url;
    AppMethodBeat.o(248243);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.s
 * JD-Core Version:    0.7.0.1
 */