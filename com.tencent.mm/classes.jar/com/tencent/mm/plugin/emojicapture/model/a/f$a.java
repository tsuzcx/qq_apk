package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"})
public final class f$a
{
  public static boolean b(chz paramchz)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235);
    p.h(paramchz, "lensInfo");
    if (!Util.isNullOrNil(paramchz.Lso))
    {
      Object localObject1 = paramchz.Mnr;
      if (localObject1 != null) {}
      for (localObject1 = ((chy)localObject1).Url; !Util.isNullOrNil((String)localObject1); localObject1 = null)
      {
        localObject1 = paramchz.Mns;
        paramchz = localObject2;
        if (localObject1 != null) {
          paramchz = ((cib)localObject1).KMl;
        }
        if (Util.isNullOrNil(paramchz)) {
          break;
        }
        AppMethodBeat.o(235);
        return true;
      }
    }
    AppMethodBeat.o(235);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f.a
 * JD-Core Version:    0.7.0.1
 */