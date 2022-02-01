package com.tencent.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.n;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/video_editor_videocomposition/EffectManagerData;", "", "()V", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getEffectManager", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "effectMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lkotlin/collections/HashMap;", "getEffectMap", "()Ljava/util/HashMap;", "imageEnhanceEffect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "getImageEnhanceEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "setImageEnhanceEffect", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "video_editor_videocomposition_release"})
public final class a
{
  final HashMap<Long, ad> Sty;
  n Stz;
  final EffectManager wet;
  
  public a()
  {
    AppMethodBeat.i(199290);
    this.Sty = new HashMap();
    this.wet = new EffectManager();
    AppMethodBeat.o(199290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.j.a
 * JD-Core Version:    0.7.0.1
 */