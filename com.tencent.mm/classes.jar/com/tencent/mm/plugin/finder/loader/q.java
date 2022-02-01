package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class q
  implements o
{
  public static final a uJo;
  private cjl uIw;
  private x uIx;
  private String username;
  
  static
  {
    AppMethodBeat.i(248232);
    uJo = new a((byte)0);
    AppMethodBeat.o(248232);
  }
  
  private q(cjl paramcjl, x paramx, String paramString)
  {
    AppMethodBeat.i(248230);
    String str = z.aTY();
    p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.uIw = paramcjl;
    this.uIx = paramx;
    this.username = paramString;
    if (paramcjl.url == null) {
      b.e("FinderVideoCover", "mediaObj.url == null " + Util.getStack());
    }
    AppMethodBeat.o(248230);
  }
  
  public final String aBE()
  {
    AppMethodBeat.i(248229);
    String str2 = this.uIw.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "mediaObj.coverUrl ?: \"\"");
    AppMethodBeat.o(248229);
    return str1;
  }
  
  public final String auA()
  {
    AppMethodBeat.i(248228);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_cover_").append(this.uIx.detail).append('_');
    if (Util.isNullOrNil(this.uIw.mediaId)) {}
    for (String str = MD5Util.getMD5String(Util.nullAs(this.uIw.url, ""));; str = this.uIw.mediaId)
    {
      str = str;
      AppMethodBeat.o(248228);
      return str;
    }
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
    String str2 = this.uIw.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String djX()
  {
    String str2 = this.uIw.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(248227);
    Object localObject = al.waC;
    localObject = al.a(this);
    AppMethodBeat.o(248227);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.uIw.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.q
 * JD-Core Version:    0.7.0.1
 */