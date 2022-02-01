package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderFullThumbImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "uniqueValue", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getThumbUrl", "getThumbUrlToken", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends n
{
  private final String Exa;
  
  public k(dji paramdji, v paramv, String paramString)
  {
    super(paramdji, paramv, paramString, null, 8);
    AppMethodBeat.i(331745);
    this.Exa = ("finder_image_" + paramv.detail + '_' + MD5Util.getMD5String(Util.nullAs(eCi(), "")));
    AppMethodBeat.o(331745);
  }
  
  public final String aUt()
  {
    return this.Exa;
  }
  
  public final Matrix aj(float paramFloat1, float paramFloat2)
  {
    return null;
  }
  
  public final String eCg()
  {
    AppMethodBeat.i(331762);
    Object localObject = (CharSequence)eCk().aaPj;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = eCk().aaPj;
      s.checkNotNull(localObject);
      s.s(localObject, "mediaObj.fullThumbUrlToken!!");
      AppMethodBeat.o(331762);
      return localObject;
    }
    localObject = super.eCg();
    AppMethodBeat.o(331762);
    return localObject;
  }
  
  public final String eCi()
  {
    AppMethodBeat.i(331756);
    Object localObject = (CharSequence)eCk().aaPi;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = eCk().aaPi;
      s.checkNotNull(localObject);
      s.s(localObject, "mediaObj.fullThumbUrl!!");
      AppMethodBeat.o(331756);
      return localObject;
    }
    localObject = super.eCi();
    AppMethodBeat.o(331756);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.k
 * JD-Core Version:    0.7.0.1
 */