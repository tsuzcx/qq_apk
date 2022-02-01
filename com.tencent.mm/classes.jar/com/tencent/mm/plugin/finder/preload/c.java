package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"})
public final class c
  extends h
  implements Comparable<c>
{
  public static final c.a stW;
  public final m rYW;
  private c.b stT;
  public final String stU;
  public final String stV;
  public int weight;
  
  static
  {
    AppMethodBeat.i(203529);
    stW = new c.a((byte)0);
    AppMethodBeat.o(203529);
  }
  
  public c(m paramm)
  {
    AppMethodBeat.i(203528);
    this.rYW = paramm;
    this.stT = c.b.stY;
    this.stU = this.rYW.aeM();
    String str = this.rYW.srx.mediaId;
    paramm = str;
    if (str == null) {
      paramm = "";
    }
    this.stV = paramm;
    AppMethodBeat.o(203528);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(203522);
    p.h(paramb, "<set-?>");
    this.stT = paramb;
    AppMethodBeat.o(203522);
  }
  
  public final void aiB(String paramString)
  {
    AppMethodBeat.i(203523);
    p.h(paramString, "value");
    this.videoFlag = paramString;
    AppMethodBeat.o(203523);
  }
  
  public final String cEP()
  {
    String str2 = this.videoFlag;
    String str1 = str2;
    if (str2 == null) {
      str1 = r.sJw.detail;
    }
    return str1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203527);
    if ((paramObject instanceof c))
    {
      boolean bool = p.i(this.stU, ((c)paramObject).stU);
      AppMethodBeat.o(203527);
      return bool;
    }
    AppMethodBeat.o(203527);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203526);
    int i = this.stU.hashCode();
    AppMethodBeat.o(203526);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203524);
    String str;
    if (this.field_requestVideoFormat == 1) {
      str = "H264";
    }
    for (;;)
    {
      str = "[" + this.stT + "] " + c.a.aiC(this.stU) + ' ' + str + " percent=" + this.fLN + "% minSize=" + bu.sL(this.preloadMinSize) + " connection=" + this.connectionCount;
      AppMethodBeat.o(203524);
      return str;
      if (this.field_requestVideoFormat == 2) {
        str = "H265";
      } else {
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c
 * JD-Core Version:    0.7.0.1
 */