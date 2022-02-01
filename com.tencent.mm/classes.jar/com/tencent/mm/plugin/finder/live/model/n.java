package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;", "", "text", "", "leftPading", "", "rightPading", "bgColor", "", "bgHeight", "textColor", "textSize", "radius", "(Ljava/lang/CharSequence;FFIIIIF)V", "getBgColor", "()I", "setBgColor", "(I)V", "getBgHeight", "setBgHeight", "getLeftPading", "()F", "getRadius", "getRightPading", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "getTextColor", "getTextSize", "Companion", "plugin-finder_release"})
public final class n
{
  private static final int ujn;
  private static final int ujo;
  private static final float ujp;
  private static final float ujq = -1.0F;
  public static final a ujr;
  int bgColor;
  int kcc;
  final float radius;
  CharSequence text;
  final int textColor;
  final int textSize;
  final float ujl;
  final float ujm;
  
  static
  {
    AppMethodBeat.i(246184);
    ujr = new a((byte)0);
    ujn = d.e(MMApplicationContext.getContext(), 18.0F);
    ujo = d.e(MMApplicationContext.getContext(), 12.0F);
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ujp = localContext.getResources().getDimension(2131165277);
    ujq = -1.0F;
    AppMethodBeat.o(246184);
  }
  
  private n(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat3)
  {
    AppMethodBeat.i(246182);
    this.text = paramCharSequence;
    this.ujl = paramFloat1;
    this.ujm = paramFloat2;
    this.bgColor = paramInt1;
    this.kcc = paramInt2;
    this.textColor = paramInt3;
    this.textSize = paramInt4;
    this.radius = paramFloat3;
    AppMethodBeat.o(246182);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig$Companion;", "", "()V", "DEFAULT_SPAN_HEIGHT", "", "getDEFAULT_SPAN_HEIGHT", "()I", "DEFAULT_TEXT_PADING", "", "getDEFAULT_TEXT_PADING", "()F", "DEFAULT_TEXT_SIZE", "getDEFAULT_TEXT_SIZE", "INVALID_RADIUS", "getINVALID_RADIUS", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.n
 * JD-Core Version:    0.7.0.1
 */