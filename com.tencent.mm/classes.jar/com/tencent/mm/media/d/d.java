package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/DropFrameAlgo;", "", "()V", "dropFrames", "", "", "frames", "", "remains", "", "dropFrames2", "getDown", "", "i", "j", "x", "getUp", "f", "slope", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d nyu;
  
  static
  {
    AppMethodBeat.i(93530);
    nyu = new d();
    AppMethodBeat.o(93530);
  }
  
  static double a(int paramInt1, int paramInt2, List<Long> paramList)
  {
    AppMethodBeat.i(93529);
    double d = (((Number)paramList.get(paramInt1)).longValue() - ((Number)paramList.get(paramInt2)).longValue()) * 2L;
    AppMethodBeat.o(93529);
    return d;
  }
  
  static double a(int paramInt1, int paramInt2, List<Long> paramList1, List<Long> paramList2)
  {
    AppMethodBeat.i(93528);
    long l1 = ((Number)paramList1.get(paramInt1)).longValue();
    long l2 = ((Number)paramList2.get(paramInt1)).longValue();
    long l3 = ((Number)paramList2.get(paramInt1)).longValue();
    long l4 = ((Number)paramList1.get(paramInt2)).longValue();
    long l5 = ((Number)paramList2.get(paramInt2)).longValue();
    double d = l1 + l3 * l2 - (((Number)paramList2.get(paramInt2)).longValue() * l5 + l4);
    AppMethodBeat.o(93528);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.d.d
 * JD-Core Version:    0.7.0.1
 */