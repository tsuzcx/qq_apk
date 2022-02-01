package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderFullThumbImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "uniqueValue", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getThumbUrl", "getThumbUrlToken", "plugin-finder_release"})
public final class i
  extends k
{
  private final String uId;
  
  private i(cjl paramcjl, x paramx, String paramString)
  {
    super(paramcjl, paramx, paramString, null, 8);
    AppMethodBeat.i(248215);
    this.uId = ("finder_image_" + paramx.detail + '_' + MD5Util.getMD5String(Util.nullAs(aBE(), "")));
    AppMethodBeat.o(248215);
  }
  
  public final Matrix D(float paramFloat1, float paramFloat2)
  {
    return null;
  }
  
  public final String aBE()
  {
    AppMethodBeat.i(248213);
    Object localObject = (CharSequence)this.uIw.MoR;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.uIw.MoR;
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "mediaObj.fullThumbUrl!!");
      AppMethodBeat.o(248213);
      return localObject;
    }
    localObject = super.aBE();
    AppMethodBeat.o(248213);
    return localObject;
  }
  
  public final String auA()
  {
    return this.uId;
  }
  
  public final String djX()
  {
    AppMethodBeat.i(248214);
    Object localObject = (CharSequence)this.uIw.MoS;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.uIw.MoS;
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "mediaObj.fullThumbUrlToken!!");
      AppMethodBeat.o(248214);
      return localObject;
    }
    localObject = super.djX();
    AppMethodBeat.o(248214);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.i
 * JD-Core Version:    0.7.0.1
 */