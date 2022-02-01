package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.i.h
  implements Comparable<c>
{
  public static final a KTJ;
  private b KTG;
  public final String KTH;
  public final String KTI;
  public final com.tencent.mm.plugin.finder.loader.l qCU;
  public int weight;
  
  static
  {
    AppMethodBeat.i(198696);
    KTJ = new a((byte)0);
    AppMethodBeat.o(198696);
  }
  
  public c(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(198695);
    this.qCU = paraml;
    this.KTG = b.KTL;
    this.KTH = this.qCU.aaX();
    paraml = this.qCU.qCj.mediaId;
    k.g(paraml, "video.mediaObj.mediaId");
    this.KTI = paraml;
    AppMethodBeat.o(198695);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(198689);
    k.h(paramb, "<set-?>");
    this.KTG = paramb;
    AppMethodBeat.o(198689);
  }
  
  public final void aVp(String paramString)
  {
    AppMethodBeat.i(198690);
    k.h(paramString, "value");
    this.videoFlag = paramString;
    AppMethodBeat.o(198690);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198694);
    if ((paramObject instanceof c))
    {
      boolean bool = k.g(this.KTH, ((c)paramObject).KTH);
      AppMethodBeat.o(198694);
      return bool;
    }
    AppMethodBeat.o(198694);
    return false;
  }
  
  public final String fTQ()
  {
    String str2 = this.videoFlag;
    String str1 = str2;
    if (str2 == null) {
      str1 = com.tencent.mm.plugin.finder.storage.h.KWP.detail;
    }
    return str1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198693);
    int i = this.KTH.hashCode();
    AppMethodBeat.o(198693);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198691);
    String str;
    if (this.field_requestVideoFormat == 1) {
      str = "H264";
    }
    for (;;)
    {
      str = "[" + this.KTG + "] " + a.aVq(this.KTH) + ' ' + str + " percent=" + this.foh + "% minSize=" + bt.mK(this.preloadMinSize);
      AppMethodBeat.o(198691);
      return str;
      if (this.field_requestVideoFormat == 2) {
        str = "H265";
      } else {
        str = "";
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"})
  public static final class a
  {
    public static String aVq(String paramString)
    {
      AppMethodBeat.i(198685);
      k.h(paramString, "mediaId");
      paramString = paramString.substring(13, d.k.h.kL(paramString.length(), 24));
      k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(198685);
      return paramString;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(198686);
      b localb1 = new b("LOADING", 0);
      KTK = localb1;
      b localb2 = new b("PENDING", 1);
      KTL = localb2;
      b localb3 = new b("WAITING", 2);
      KTM = localb3;
      KTN = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(198686);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c
 * JD-Core Version:    0.7.0.1
 */