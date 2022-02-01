package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderFullThumbImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "uniqueValue", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getThumbUrl", "getThumbUrlToken", "plugin-finder_release"})
public final class o
  extends r
{
  private final String ztf;
  
  private o(csg paramcsg, u paramu, String paramString)
  {
    super(paramcsg, paramu, paramString, null, 8);
    AppMethodBeat.i(290197);
    this.ztf = ("finder_image_" + paramu.detail + '_' + MD5Util.getMD5String(Util.nullAs(aJi(), "")));
    AppMethodBeat.o(290197);
  }
  
  public final Matrix F(float paramFloat1, float paramFloat2)
  {
    return null;
  }
  
  public final String aBv()
  {
    return this.ztf;
  }
  
  public final String aJi()
  {
    AppMethodBeat.i(290194);
    Object localObject = (CharSequence)dJd().TzX;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = dJd().TzX;
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "mediaObj.fullThumbUrl!!");
      AppMethodBeat.o(290194);
      return localObject;
    }
    localObject = super.aJi();
    AppMethodBeat.o(290194);
    return localObject;
  }
  
  public final String dJa()
  {
    AppMethodBeat.i(290195);
    Object localObject = (CharSequence)dJd().TzY;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = dJd().TzY;
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "mediaObj.fullThumbUrlToken!!");
      AppMethodBeat.o(290195);
      return localObject;
    }
    localObject = super.dJa();
    AppMethodBeat.o(290195);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.o
 * JD-Core Version:    0.7.0.1
 */