package com.tencent.mm.aj.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/weui/MMButtonColor;", "", "color", "Landroidx/compose/ui/graphics/Color;", "textColor", "disableColor", "disableTextColor", "(JJJJ)V", "getColor-0d7_KjU", "()J", "J", "getDisableColor-0d7_KjU", "getDisableTextColor-0d7_KjU", "getTextColor-0d7_KjU", "Green", "Orange", "Other", "Red", "White", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor$Green;", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor$Orange;", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor$Red;", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor$White;", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor$Other;", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
{
  final long ayn;
  final long nYO;
  final long ogw;
  final long ogx;
  
  private c(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.ayn = paramLong1;
    this.nYO = paramLong2;
    this.ogw = paramLong3;
    this.ogx = paramLong4;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/weui/MMButtonColor$Green;", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor;", "()V", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c
  {
    public static final a ogy;
    
    static
    {
      AppMethodBeat.i(238695);
      ogy = new a();
      AppMethodBeat.o(238695);
    }
    
    private a()
    {
      super(a.b(i, localContext));
      AppMethodBeat.i(238689);
      AppMethodBeat.o(238689);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/weui/MMButtonColor$Orange;", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor;", "()V", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c
  {
    public static final b ogz;
    
    static
    {
      AppMethodBeat.i(238698);
      ogz = new b();
      AppMethodBeat.o(238698);
    }
    
    private b()
    {
      super(a.b(i, localContext));
      AppMethodBeat.i(238694);
      AppMethodBeat.o(238694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.b.c
 * JD-Core Version:    0.7.0.1
 */