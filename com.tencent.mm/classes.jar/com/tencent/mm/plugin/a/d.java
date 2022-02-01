package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/Atom/EdtsAtom;", "Lcom/tencent/mm/plugin/Atom/Atom;", "atomSize", "", "beginPos", "", "type", "atomLargeSize", "(IJIJ)V", "mediaTimes", "", "getMediaTimes", "()Ljava/util/List;", "segmentDurations", "getSegmentDurations", "handleElstAtom", "", "source", "Ljava/io/RandomAccessFile;", "parse", "atomHead", "", "plugin-playvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public final List<Long> pDK;
  public final List<Long> pDL;
  
  public d(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(134105);
    this.pDK = ((List)new ArrayList());
    this.pDL = ((List)new ArrayList());
    AppMethodBeat.o(134105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */