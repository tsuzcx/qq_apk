package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class g
  implements k
{
  public static final a srz;
  public bvz srx;
  private com.tencent.mm.plugin.finder.storage.r sry;
  private String username;
  
  static
  {
    AppMethodBeat.i(178310);
    srz = new a((byte)0);
    AppMethodBeat.o(178310);
  }
  
  private g(bvz parambvz, com.tencent.mm.plugin.finder.storage.r paramr, String paramString)
  {
    AppMethodBeat.i(166318);
    String str = v.aAC();
    p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.srx = parambvz;
    this.sry = paramr;
    this.username = paramString;
    if (parambvz.url == null) {
      b.e("FinderImage", "mediaObj.url == null " + bu.fpN());
    }
    AppMethodBeat.o(166318);
  }
  
  public final String aeM()
  {
    AppMethodBeat.i(166316);
    Object localObject1 = new StringBuilder("finder_image_");
    Object localObject2 = this.sry;
    if (localObject2 == null) {
      p.bdF("type");
    }
    localObject2 = ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.finder.storage.r)localObject2).detail).append('_');
    localObject1 = this.srx;
    if (localObject1 == null) {
      p.bdF("mediaObj");
    }
    if (bu.isNullOrNil(((bvz)localObject1).mediaId))
    {
      localObject1 = this.srx;
      if (localObject1 == null) {
        p.bdF("mediaObj");
      }
    }
    for (localObject1 = aj.ej(bu.bI(((bvz)localObject1).url, ""));; localObject1 = ((bvz)localObject1).mediaId)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(166316);
      return localObject1;
      localObject1 = this.srx;
      if (localObject1 == null) {
        p.bdF("mediaObj");
      }
    }
  }
  
  public final String all()
  {
    AppMethodBeat.i(178309);
    Object localObject = this.srx;
    if (localObject == null) {
      p.bdF("mediaObj");
    }
    String str = ((bvz)localObject).thumbUrl;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    p.g(localObject, "mediaObj.thumbUrl ?: \"\"");
    AppMethodBeat.o(178309);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cEj()
  {
    AppMethodBeat.i(178308);
    com.tencent.mm.plugin.finder.storage.r localr = this.sry;
    if (localr == null) {
      p.bdF("type");
    }
    AppMethodBeat.o(178308);
    return localr;
  }
  
  public final String cEk()
  {
    AppMethodBeat.i(203394);
    Object localObject = this.srx;
    if (localObject == null) {
      p.bdF("mediaObj");
    }
    String str = ((bvz)localObject).decodeKey;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(203394);
    return localObject;
  }
  
  public final String cEl()
  {
    AppMethodBeat.i(203395);
    Object localObject = this.srx;
    if (localObject == null) {
      p.bdF("mediaObj");
    }
    String str = ((bvz)localObject).url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(203395);
    return localObject;
  }
  
  public final String cEm()
  {
    AppMethodBeat.i(203396);
    Object localObject = this.srx;
    if (localObject == null) {
      p.bdF("mediaObj");
    }
    String str = ((bvz)localObject).thumb_url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(203396);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166315);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sYn;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166315);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166317);
    Object localObject = this.srx;
    if (localObject == null) {
      p.bdF("mediaObj");
    }
    String str = ((bvz)localObject).url;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(166317);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderImage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.g
 * JD-Core Version:    0.7.0.1
 */