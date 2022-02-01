package com.tencent.mm.aj.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/weui/MMButtonSize;", "", "minWidthResId", "", "minHeightResId", "cornerRadiusResId", "textSizeResId", "paddingHorizontal", "(IIIII)V", "getCornerRadiusResId", "()I", "getMinHeightResId", "getMinWidthResId", "getPaddingHorizontal", "getTextSizeResId", "Large", "Middle", "Small", "Lcom/tencent/mm/mm_compose/weui/MMButtonSize$Large;", "Lcom/tencent/mm/mm_compose/weui/MMButtonSize$Middle;", "Lcom/tencent/mm/mm_compose/weui/MMButtonSize$Small;", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  final int ogA;
  final int ogB;
  final int ogC;
  final int ogD;
  final int ogE;
  
  private d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.ogA = paramInt1;
    this.ogB = paramInt2;
    this.ogC = paramInt3;
    this.ogD = paramInt4;
    this.ogE = paramInt5;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/weui/MMButtonSize$Large;", "Lcom/tencent/mm/mm_compose/weui/MMButtonSize;", "()V", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d
  {
    public static final a ogF;
    
    static
    {
      AppMethodBeat.i(238673);
      ogF = new a();
      AppMethodBeat.o(238673);
    }
    
    private a()
    {
      super(b.b.NormalButtonHeight, b.b.ButtonCornerSize, b.b.LargeBtnTextSize, b.b.LargeBtnPadding, (byte)0);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/weui/MMButtonSize$Small;", "Lcom/tencent/mm/mm_compose/weui/MMButtonSize;", "()V", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends d
  {
    public static final b ogG;
    
    static
    {
      AppMethodBeat.i(238671);
      ogG = new b();
      AppMethodBeat.o(238671);
    }
    
    private b()
    {
      super(b.b.SmallButtonHeight, b.b.ButtonSmallCornerSize, b.b.SmallBtnTextSize, b.b.SmallBtnPadding, (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.b.d
 * JD-Core Version:    0.7.0.1
 */