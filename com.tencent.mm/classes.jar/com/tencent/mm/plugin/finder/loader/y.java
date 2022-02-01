package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class y
  implements w
{
  public static final a zuU;
  private String username;
  private csg ztO;
  private u ztP;
  
  static
  {
    AppMethodBeat.i(276726);
    zuU = new a((byte)0);
    AppMethodBeat.o(276726);
  }
  
  private y(csg paramcsg, u paramu, String paramString)
  {
    AppMethodBeat.i(276724);
    String str = z.bcZ();
    p.j(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.ztO = paramcsg;
    this.ztP = paramu;
    this.username = paramString;
    if (paramcsg.url == null) {
      b.e("FinderVideoCover", "mediaObj.url == null " + Util.getStack());
    }
    AppMethodBeat.o(276724);
  }
  
  public final String aBv()
  {
    AppMethodBeat.i(276720);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_cover_").append(this.ztP.detail).append('_');
    if (Util.isNullOrNil(this.ztO.mediaId)) {}
    for (String str = MD5Util.getMD5String(Util.nullAs(this.ztO.url, ""));; str = this.ztO.mediaId)
    {
      str = str;
      AppMethodBeat.o(276720);
      return str;
    }
  }
  
  public final String aJi()
  {
    AppMethodBeat.i(276722);
    String str2 = this.ztO.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "mediaObj.coverUrl ?: \"\"");
    AppMethodBeat.o(276722);
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
    String str2 = this.ztO.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String dJa()
  {
    String str2 = this.ztO.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(276718);
    Object localObject = av.AJz;
    localObject = av.a(this);
    AppMethodBeat.o(276718);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.ztO.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.y
 * JD-Core Version:    0.7.0.1
 */