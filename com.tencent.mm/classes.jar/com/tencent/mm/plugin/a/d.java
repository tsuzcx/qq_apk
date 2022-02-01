package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/Atom/EdtsAtom;", "Lcom/tencent/mm/plugin/Atom/Atom;", "atomSize", "", "beginPos", "", "type", "atomLargeSize", "(IJIJ)V", "mediaTimes", "", "getMediaTimes", "()Ljava/util/List;", "segmentDurations", "getSegmentDurations", "handleElstAtom", "", "source", "Ljava/io/RandomAccessFile;", "parse", "atomHead", "", "plugin-playvideo_release"})
public final class d
  extends a
{
  public final List<Long> iQn;
  public final List<Long> iQo;
  
  public d(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(134105);
    this.iQn = ((List)new ArrayList());
    this.iQo = ((List)new ArrayList());
    AppMethodBeat.o(134105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */