package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class g
  implements k
{
  public static final a siE;
  public bvf siC;
  private com.tencent.mm.plugin.finder.storage.r siD;
  private String username;
  
  static
  {
    AppMethodBeat.i(178310);
    siE = new a((byte)0);
    AppMethodBeat.o(178310);
  }
  
  private g(bvf parambvf, com.tencent.mm.plugin.finder.storage.r paramr, String paramString)
  {
    AppMethodBeat.i(166318);
    String str = u.aAm();
    p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.siC = parambvf;
    this.siD = paramr;
    this.username = paramString;
    if (parambvf.url == null) {
      b.e("FinderImage", "mediaObj.url == null " + bt.flS());
    }
    AppMethodBeat.o(166318);
  }
  
  public final String aeA()
  {
    AppMethodBeat.i(166316);
    Object localObject1 = new StringBuilder("finder_image_");
    Object localObject2 = this.siD;
    if (localObject2 == null) {
      p.bcb("type");
    }
    localObject2 = ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.finder.storage.r)localObject2).detail).append('_');
    localObject1 = this.siC;
    if (localObject1 == null) {
      p.bcb("mediaObj");
    }
    if (bt.isNullOrNil(((bvf)localObject1).mediaId))
    {
      localObject1 = this.siC;
      if (localObject1 == null) {
        p.bcb("mediaObj");
      }
    }
    for (localObject1 = ai.ee(bt.bI(((bvf)localObject1).url, ""));; localObject1 = ((bvf)localObject1).mediaId)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(166316);
      return localObject1;
      localObject1 = this.siC;
      if (localObject1 == null) {
        p.bcb("mediaObj");
      }
    }
  }
  
  public final String akW()
  {
    AppMethodBeat.i(178309);
    Object localObject = this.siC;
    if (localObject == null) {
      p.bcb("mediaObj");
    }
    String str = ((bvf)localObject).thumbUrl;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(178309);
    return localObject;
  }
  
  public final String cCA()
  {
    AppMethodBeat.i(202917);
    Object localObject = this.siC;
    if (localObject == null) {
      p.bcb("mediaObj");
    }
    String str = ((bvf)localObject).thumb_url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(202917);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cCx()
  {
    AppMethodBeat.i(178308);
    com.tencent.mm.plugin.finder.storage.r localr = this.siD;
    if (localr == null) {
      p.bcb("type");
    }
    AppMethodBeat.o(178308);
    return localr;
  }
  
  public final String cCy()
  {
    AppMethodBeat.i(202915);
    Object localObject = this.siC;
    if (localObject == null) {
      p.bcb("mediaObj");
    }
    String str = ((bvf)localObject).decodeKey;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(202915);
    return localObject;
  }
  
  public final String cCz()
  {
    AppMethodBeat.i(202916);
    Object localObject = this.siC;
    if (localObject == null) {
      p.bcb("mediaObj");
    }
    String str = ((bvf)localObject).url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(202916);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166315);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sNc;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166315);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166317);
    Object localObject = this.siC;
    if (localObject == null) {
      p.bcb("mediaObj");
    }
    String str = ((bvf)localObject).url;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(166317);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderImage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.g
 * JD-Core Version:    0.7.0.1
 */