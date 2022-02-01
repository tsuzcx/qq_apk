package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class f
  implements j
{
  public static final a qCl;
  public bmd qCj;
  private h qCk;
  private String username;
  
  static
  {
    AppMethodBeat.i(178310);
    qCl = new a((byte)0);
    AppMethodBeat.o(178310);
  }
  
  private f(bmd parambmd, h paramh, String paramString)
  {
    AppMethodBeat.i(166318);
    String str = u.aqG();
    d.g.b.k.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.qCj = parambmd;
    this.qCk = paramh;
    this.username = paramString;
    if (parambmd.url == null) {
      b.e("FinderImage", "mediaObj.url == null " + bt.eGN());
    }
    AppMethodBeat.o(166318);
  }
  
  public final String aaX()
  {
    AppMethodBeat.i(166316);
    Object localObject1 = new StringBuilder("finder_image_");
    Object localObject2 = this.qCk;
    if (localObject2 == null) {
      d.g.b.k.aPZ("type");
    }
    localObject2 = ((StringBuilder)localObject1).append(((h)localObject2).detail).append('_');
    localObject1 = this.qCj;
    if (localObject1 == null) {
      d.g.b.k.aPZ("mediaObj");
    }
    if (bt.isNullOrNil(((bmd)localObject1).mediaId))
    {
      localObject1 = this.qCj;
      if (localObject1 == null) {
        d.g.b.k.aPZ("mediaObj");
      }
    }
    for (localObject1 = ai.du(bt.by(((bmd)localObject1).url, ""));; localObject1 = ((bmd)localObject1).mediaId)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(166316);
      return localObject1;
      localObject1 = this.qCj;
      if (localObject1 == null) {
        d.g.b.k.aPZ("mediaObj");
      }
    }
  }
  
  public final h cmR()
  {
    AppMethodBeat.i(178308);
    h localh = this.qCk;
    if (localh == null) {
      d.g.b.k.aPZ("type");
    }
    AppMethodBeat.o(178308);
    return localh;
  }
  
  public final String cmS()
  {
    AppMethodBeat.i(190864);
    Object localObject = this.qCj;
    if (localObject == null) {
      d.g.b.k.aPZ("mediaObj");
    }
    String str = ((bmd)localObject).decodeKey;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(190864);
    return localObject;
  }
  
  public final String cmT()
  {
    AppMethodBeat.i(178309);
    Object localObject = this.qCj;
    if (localObject == null) {
      d.g.b.k.aPZ("mediaObj");
    }
    String str = ((bmd)localObject).thumbUrl;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(178309);
    return localObject;
  }
  
  public final String fTN()
  {
    AppMethodBeat.i(198605);
    Object localObject = this.qCj;
    if (localObject == null) {
      d.g.b.k.aPZ("mediaObj");
    }
    String str = ((bmd)localObject).url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(198605);
    return localObject;
  }
  
  public final String fTO()
  {
    AppMethodBeat.i(198606);
    Object localObject = this.qCj;
    if (localObject == null) {
      d.g.b.k.aPZ("mediaObj");
    }
    String str = ((bmd)localObject).thumb_url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(198606);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166315);
    Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
    localObject = com.tencent.mm.plugin.finder.utils.k.a(this);
    AppMethodBeat.o(166315);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166317);
    Object localObject = this.qCj;
    if (localObject == null) {
      d.g.b.k.aPZ("mediaObj");
    }
    String str = ((bmd)localObject).url;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(166317);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderImage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.f
 * JD-Core Version:    0.7.0.1
 */