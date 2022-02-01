package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements r
{
  public static final a EyT;
  private dji ExE;
  private v ExF;
  private String username;
  
  static
  {
    AppMethodBeat.i(331788);
    EyT = new a((byte)0);
    AppMethodBeat.o(331788);
  }
  
  private t(dji paramdji, v paramv, String paramString)
  {
    AppMethodBeat.i(331776);
    String str = z.bAM();
    s.s(str, "getUsernameFromUserInfo()");
    this.username = str;
    this.ExE = paramdji;
    this.ExF = paramv;
    this.username = paramString;
    if (paramdji.url == null) {
      b.e("FinderVideoCover", s.X("mediaObj.url == null ", Util.getStack()));
    }
    AppMethodBeat.o(331776);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(331811);
    String str = "finder_video_cover_" + this.ExF.detail + '_' + MD5Util.getMD5String(Util.nullAs(this.ExE.coverUrl, ""));
    AppMethodBeat.o(331811);
    return str;
  }
  
  public final v eCd()
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
    String str2 = this.ExE.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String eCg()
  {
    String str2 = this.ExE.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String eCi()
  {
    String str2 = this.ExE.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(331802);
    Object localObject = bm.GlZ;
    localObject = bm.a(this);
    AppMethodBeat.o(331802);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.ExE.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.t
 * JD-Core Version:    0.7.0.1
 */