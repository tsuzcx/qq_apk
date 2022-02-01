package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/Atom/EdtsAtom;", "Lcom/tencent/mm/plugin/Atom/Atom;", "atomSize", "", "beginPos", "", "type", "atomLargeSize", "(IJIJ)V", "mediaTimes", "", "getMediaTimes", "()Ljava/util/List;", "segmentDurations", "getSegmentDurations", "handleElstAtom", "", "source", "Ljava/io/RandomAccessFile;", "parse", "atomHead", "", "plugin-playvideo_release"})
public final class d
  extends a
{
  public final List<Long> iTg;
  public final List<Long> iTh;
  
  public d(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(134105);
    this.iTg = ((List)new ArrayList());
    this.iTh = ((List)new ArrayList());
    AppMethodBeat.o(134105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */