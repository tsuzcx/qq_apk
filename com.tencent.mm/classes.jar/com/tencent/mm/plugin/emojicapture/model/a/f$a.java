package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"})
public final class f$a
{
  public static boolean b(cqv paramcqv)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235);
    p.k(paramcqv, "lensInfo");
    if (!Util.isNullOrNil(paramcqv.LensId))
    {
      Object localObject1 = paramcqv.Tym;
      if (localObject1 != null) {}
      for (localObject1 = ((cqu)localObject1).Url; !Util.isNullOrNil((String)localObject1); localObject1 = null)
      {
        localObject1 = paramcqv.Tyn;
        paramcqv = localObject2;
        if (localObject1 != null) {
          paramcqv = ((cqx)localObject1).RNi;
        }
        if (Util.isNullOrNil(paramcqv)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f.a
 * JD-Core Version:    0.7.0.1
 */