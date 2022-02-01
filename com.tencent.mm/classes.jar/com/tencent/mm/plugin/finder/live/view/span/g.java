package com.tencent.mm.plugin.finder.live.view.span;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpanConfig;", "", "text", "", "leftPading", "", "rightPading", "bgColor", "", "bgHeight", "textColor", "textSize", "radius", "(Ljava/lang/CharSequence;FFIIIIF)V", "getBgColor", "()I", "setBgColor", "(I)V", "getBgHeight", "setBgHeight", "getLeftPading", "()F", "getRadius", "getRightPading", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "getTextColor", "getTextSize", "toString", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a DWI;
  private static final int DWL;
  private static final int DWM;
  private static final float DWN;
  private static final float DWO;
  final float DWJ;
  final float DWK;
  CharSequence bba;
  int bgColor;
  int pQi;
  final float radius;
  final int textColor;
  final int textSize;
  
  static
  {
    AppMethodBeat.i(358400);
    DWI = new a((byte)0);
    DWL = d.e(MMApplicationContext.getContext(), 18.0F);
    DWM = d.e(MMApplicationContext.getContext(), 12.0F);
    DWN = MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_0_5_A);
    DWO = -1.0F;
    AppMethodBeat.o(358400);
  }
  
  private g(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat3)
  {
    AppMethodBeat.i(358354);
    this.bba = paramCharSequence;
    this.DWJ = paramFloat1;
    this.DWK = paramFloat2;
    this.bgColor = paramInt1;
    this.pQi = paramInt2;
    this.textColor = paramInt3;
    this.textSize = paramInt4;
    this.radius = paramFloat3;
    AppMethodBeat.o(358354);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(358410);
    String str = "text:" + this.bba + ",leftPading:" + this.DWJ + ",rightPading:" + this.DWK + ",bgColor:" + this.bgColor + ",bgHeight:" + this.pQi + ",textColor:" + this.textColor + ",textSize:" + this.textSize + ",radius:" + this.radius;
    AppMethodBeat.o(358410);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpanConfig$Companion;", "", "()V", "DEFAULT_SPAN_HEIGHT", "", "getDEFAULT_SPAN_HEIGHT", "()I", "DEFAULT_TEXT_PADING", "", "getDEFAULT_TEXT_PADING", "()F", "DEFAULT_TEXT_SIZE", "getDEFAULT_TEXT_SIZE", "INVALID_RADIUS", "getINVALID_RADIUS", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.g
 * JD-Core Version:    0.7.0.1
 */