package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/CdnQualityTag;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CDN_QUALITY_HD", "CDN_QUALITY_SD1", "CDN_QUALITY_SD2", "CDN_QUALITY_SM", "CDN_QUALITY_SB", "CDN_QUALITY_HEVC", "CDN_QUALITY_AUTO_CLIQOS", "CDN_QUALITY_AUTO_SVRML", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(247895);
    mJp = new a("CDN_QUALITY_HD", 0, 0);
    mJq = new a("CDN_QUALITY_SD1", 1, 1);
    mJr = new a("CDN_QUALITY_SD2", 2, 2);
    mJs = new a("CDN_QUALITY_SM", 3, 3);
    mJt = new a("CDN_QUALITY_SB", 4, 4);
    mJu = new a("CDN_QUALITY_HEVC", 5, 5);
    mJv = new a("CDN_QUALITY_AUTO_CLIQOS", 6, 101);
    mJw = new a("CDN_QUALITY_AUTO_SVRML", 7, 102);
    mJx = new a[] { mJp, mJq, mJr, mJs, mJt, mJu, mJv, mJw };
    AppMethodBeat.o(247895);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a
 * JD-Core Version:    0.7.0.1
 */