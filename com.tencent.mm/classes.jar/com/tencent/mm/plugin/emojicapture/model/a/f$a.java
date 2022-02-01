package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a
{
  public static boolean b(dhp paramdhp)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235);
    s.u(paramdhp, "lensInfo");
    if (!Util.isNullOrNil(paramdhp.LensId))
    {
      Object localObject1 = paramdhp.aaMT;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (Util.isNullOrNil((String)localObject1)) {
          break label84;
        }
        paramdhp = paramdhp.aaMU;
        if (paramdhp != null) {
          break label76;
        }
      }
      label76:
      for (paramdhp = localObject2;; paramdhp = paramdhp.YKw)
      {
        if (Util.isNullOrNil(paramdhp)) {
          break label84;
        }
        AppMethodBeat.o(235);
        return true;
        localObject1 = ((dho)localObject1).Url;
        break;
      }
    }
    label84:
    AppMethodBeat.o(235);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f.a
 * JD-Core Version:    0.7.0.1
 */