package com.tencent.mm.aj.b;

import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b.c;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/weui/MMLoadingSize;", "", "value", "Landroidx/compose/ui/unit/Dp;", "whiteRes", "", "blackRes", "(Ljava/lang/String;IFII)V", "getBlackRes", "()I", "getValue-D9Ej5fM", "()F", "F", "getWhiteRes", "getRes", "color", "Lcom/tencent/mm/mm_compose/weui/MMLoadingColor;", "Large", "Normal", "Small", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum f
{
  private final int ogK;
  private final int ogL;
  final float value;
  
  static
  {
    AppMethodBeat.i(238714);
    ogM = new f("Large", 0, g.ai(76.0F), b.c.spinner_white_76_outer_holo, b.c.spinner_76_outer_holo);
    ogN = new f("Normal", 1, g.ai(48.0F), b.c.spinner_white_48_outer_holo, b.c.spinner_48_outer_holo);
    ogO = new f("Small", 2, g.ai(16.0F), b.c.spinner_white_16_outer_holo, b.c.spinner_16_outer_holo);
    ogP = new f[] { ogM, ogN, ogO };
    AppMethodBeat.o(238714);
  }
  
  private f(float paramFloat, int paramInt1, int paramInt2)
  {
    this.value = paramFloat;
    this.ogK = paramInt1;
    this.ogL = paramInt2;
  }
  
  public final int a(e parame)
  {
    AppMethodBeat.i(238718);
    s.u(parame, "color");
    switch (a.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      parame = new p();
      AppMethodBeat.o(238718);
      throw parame;
    case 1: 
      i = this.ogL;
      AppMethodBeat.o(238718);
      return i;
    }
    int i = this.ogK;
    AppMethodBeat.o(238718);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.b.f
 * JD-Core Version:    0.7.0.1
 */