package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
public final class e$c
  implements d
{
  private final e wiV;
  
  public e$c(e parame)
  {
    AppMethodBeat.i(254569);
    this.wiV = parame;
    AppMethodBeat.o(254569);
  }
  
  public final void ad(List<c> paramList)
  {
    AppMethodBeat.i(254564);
    p.h(paramList, "lensList");
    e locale = this.wiV;
    p.h(paramList, "lensList");
    Log.i(locale.TAG, "update: " + paramList.size());
    locale.rsC.clear();
    locale.rsC.addAll((Collection)paramList);
    AppMethodBeat.o(254564);
  }
  
  public final void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254565);
    this.wiV.as(paramInt1, paramInt2);
    AppMethodBeat.o(254565);
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254566);
    this.wiV.at(paramInt1, paramInt2);
    AppMethodBeat.o(254566);
  }
  
  public final void fJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254567);
    this.wiV.ar(paramInt1, paramInt2);
    AppMethodBeat.o(254567);
  }
  
  public final void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254568);
    this.wiV.aq(paramInt1, paramInt2);
    AppMethodBeat.o(254568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e.c
 * JD-Core Version:    0.7.0.1
 */