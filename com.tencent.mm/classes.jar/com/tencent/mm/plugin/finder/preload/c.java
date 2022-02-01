package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"})
public final class c
  extends h
  implements Comparable<c>
{
  public static final c.a rvy;
  public final com.tencent.mm.plugin.finder.loader.l rcZ;
  private c.b rvv;
  public final String rvw;
  public final String rvx;
  public int weight;
  
  static
  {
    AppMethodBeat.i(202623);
    rvy = new c.a((byte)0);
    AppMethodBeat.o(202623);
  }
  
  public c(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(202622);
    this.rcZ = paraml;
    this.rvv = c.b.rvA;
    this.rvw = this.rcZ.abW();
    paraml = this.rcZ.rtl.mediaId;
    k.g(paraml, "video.mediaObj.mediaId");
    this.rvx = paraml;
    AppMethodBeat.o(202622);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(202616);
    k.h(paramb, "<set-?>");
    this.rvv = paramb;
    AppMethodBeat.o(202616);
  }
  
  public final void adI(String paramString)
  {
    AppMethodBeat.i(202617);
    k.h(paramString, "value");
    this.videoFlag = paramString;
    AppMethodBeat.o(202617);
  }
  
  public final String cwK()
  {
    String str2 = this.videoFlag;
    String str1 = str2;
    if (str2 == null) {
      str1 = m.rDS.detail;
    }
    return str1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202621);
    if ((paramObject instanceof c))
    {
      boolean bool = k.g(this.rvw, ((c)paramObject).rvw);
      AppMethodBeat.o(202621);
      return bool;
    }
    AppMethodBeat.o(202621);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(202620);
    int i = this.rvw.hashCode();
    AppMethodBeat.o(202620);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202618);
    String str;
    if (this.field_requestVideoFormat == 1) {
      str = "H264";
    }
    for (;;)
    {
      str = "[" + this.rvv + "] " + c.a.adJ(this.rvw) + ' ' + str + " percent=" + this.frB + "% minSize=" + bs.qz(this.preloadMinSize);
      AppMethodBeat.o(202618);
      return str;
      if (this.field_requestVideoFormat == 2) {
        str = "H265";
      } else {
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c
 * JD-Core Version:    0.7.0.1
 */