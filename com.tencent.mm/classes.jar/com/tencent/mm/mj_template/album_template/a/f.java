package com.tencent.mm.mj_template.album_template.a;

import androidx.compose.ui.e.z;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.mj_template.plugin.c.a;
import com.tencent.mm.mj_template.plugin.c.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/widget/MusicSelectorTheme;", "", "selectorBgColor", "Landroidx/compose/ui/graphics/Color;", "cardBgColor", "cardSelectedBgColor", "soundsAnimationColor", "textColor", "movieOptionColor", "musicIconRes", "", "cardEdgePadding", "Landroidx/compose/ui/unit/Dp;", "cardDividerPadding", "(JJJJJJIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCardBgColor-0d7_KjU", "()J", "J", "getCardDividerPadding-D9Ej5fM", "()F", "F", "getCardEdgePadding-D9Ej5fM", "getCardSelectedBgColor-0d7_KjU", "getMovieOptionColor-0d7_KjU", "getMusicIconRes", "()I", "getSelectorBgColor-0d7_KjU", "getSoundsAnimationColor-0d7_KjU", "getTextColor-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component8", "component8-D9Ej5fM", "component9", "component9-D9Ej5fM", "copy", "copy-89RdATc", "(JJJJJJIFF)Lcom/tencent/mm/mj_template/album_template/widget/MusicSelectorTheme;", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a nYJ;
  private static final f nYT;
  private static final f nYU;
  final long nYK;
  final long nYL;
  final long nYM;
  final long nYN;
  final long nYO;
  final long nYP;
  final int nYQ;
  final float nYR;
  final float nYS;
  
  static
  {
    AppMethodBeat.i(240608);
    nYJ = new f.a((byte)0);
    nYT = new f(a.uO(c.a.ocJ), a.uO(c.a.ocJ), a.uO(c.a.ocJ), a.uO(c.a.UN_BW_0_Alpha_0_3), a.uO(c.a.UN_BW_0_Alpha_0_9), a.uO(c.a.BW_100_Alpha_0_9), c.f.icons_filled_music, g.ai(24.0F), g.ai(16.0F), (byte)0);
    nYU = new f(a.uO(c.a.BW_100_Alpha_0_0_5), a.uO(c.a.Dark_5), a.uO(c.a.Dark_4), a.uO(c.a.BW_100_Alpha_0_5), a.uO(c.a.BW_100_Alpha_0_8), a.uO(c.a.BW_100_Alpha_0_8), c.f.icons_filled_music, g.ai(40.0F), g.ai(16.0F), (byte)0);
    AppMethodBeat.o(240608);
  }
  
  private f(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.nYK = paramLong1;
    this.nYL = paramLong2;
    this.nYM = paramLong3;
    this.nYN = paramLong4;
    this.nYO = paramLong5;
    this.nYP = paramLong6;
    this.nYQ = paramInt;
    this.nYR = paramFloat1;
    this.nYS = paramFloat2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(240634);
    if (this == paramObject)
    {
      AppMethodBeat.o(240634);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    paramObject = (f)paramObject;
    if (!z.e(this.nYK, paramObject.nYK))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (!z.e(this.nYL, paramObject.nYL))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (!z.e(this.nYM, paramObject.nYM))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (!z.e(this.nYN, paramObject.nYN))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (!z.e(this.nYO, paramObject.nYO))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (!z.e(this.nYP, paramObject.nYP))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (this.nYQ != paramObject.nYQ)
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (!g.G(this.nYR, paramObject.nYR))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    if (!g.G(this.nYS, paramObject.nYS))
    {
      AppMethodBeat.o(240634);
      return false;
    }
    AppMethodBeat.o(240634);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(240622);
    int i = z.I(this.nYK);
    int j = z.I(this.nYL);
    int k = z.I(this.nYM);
    int m = z.I(this.nYN);
    int n = z.I(this.nYO);
    int i1 = z.I(this.nYP);
    int i2 = this.nYQ;
    int i3 = g.ah(this.nYR);
    int i4 = g.ah(this.nYS);
    AppMethodBeat.o(240622);
    return (((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240616);
    String str = "MusicSelectorTheme(selectorBgColor=" + z.H(this.nYK) + ", cardBgColor=" + z.H(this.nYL) + ", cardSelectedBgColor=" + z.H(this.nYM) + ", soundsAnimationColor=" + z.H(this.nYN) + ", textColor=" + z.H(this.nYO) + ", movieOptionColor=" + z.H(this.nYP) + ", musicIconRes=" + this.nYQ + ", cardEdgePadding=" + g.ak(this.nYR) + ", cardDividerPadding=" + g.ak(this.nYS) + ')';
    AppMethodBeat.o(240616);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.f
 * JD-Core Version:    0.7.0.1
 */