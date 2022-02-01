package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;", "", "text", "", "leftPading", "", "rightPading", "bgColor", "", "bgHeight", "textColor", "textSize", "radius", "(Ljava/lang/CharSequence;FFIIIIF)V", "getBgColor", "()I", "setBgColor", "(I)V", "getBgHeight", "setBgHeight", "getLeftPading", "()F", "getRadius", "getRightPading", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "getTextColor", "getTextSize", "Companion", "plugin-finder_release"})
public final class ag
{
  private static final int yfQ;
  private static final int yfS;
  private static final float ygZ;
  private static final float yha = -1.0F;
  public static final a yhb;
  CharSequence LV;
  int bgColor;
  int mTB;
  final float radius;
  final int textColor;
  final int textSize;
  final float yfY;
  final float yfZ;
  
  static
  {
    AppMethodBeat.i(249053);
    yhb = new a((byte)0);
    yfQ = d.e(MMApplicationContext.getContext(), 18.0F);
    yfS = d.e(MMApplicationContext.getContext(), 12.0F);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ygZ = localContext.getResources().getDimension(b.d.Edge_0_5_A);
    yha = -1.0F;
    AppMethodBeat.o(249053);
  }
  
  private ag(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat3)
  {
    AppMethodBeat.i(249048);
    this.LV = paramCharSequence;
    this.yfY = paramFloat1;
    this.yfZ = paramFloat2;
    this.bgColor = paramInt1;
    this.mTB = paramInt2;
    this.textColor = paramInt3;
    this.textSize = paramInt4;
    this.radius = paramFloat3;
    AppMethodBeat.o(249048);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig$Companion;", "", "()V", "DEFAULT_SPAN_HEIGHT", "", "getDEFAULT_SPAN_HEIGHT", "()I", "DEFAULT_TEXT_PADING", "", "getDEFAULT_TEXT_PADING", "()F", "DEFAULT_TEXT_SIZE", "getDEFAULT_TEXT_SIZE", "INVALID_RADIUS", "getINVALID_RADIUS", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ag
 * JD-Core Version:    0.7.0.1
 */