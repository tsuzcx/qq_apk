package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.i.h
  implements Comparable<c>
{
  public static final a skZ;
  public final m rQu;
  private b skW;
  public final String skX;
  public final String skY;
  public int weight;
  
  static
  {
    AppMethodBeat.i(203044);
    skZ = new a((byte)0);
    AppMethodBeat.o(203044);
  }
  
  public c(m paramm)
  {
    AppMethodBeat.i(203043);
    this.rQu = paramm;
    this.skW = b.slb;
    this.skX = this.rQu.aeA();
    paramm = this.rQu.siC.mediaId;
    p.g(paramm, "video.mediaObj.mediaId");
    this.skY = paramm;
    AppMethodBeat.o(203043);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203037);
    p.h(paramb, "<set-?>");
    this.skW = paramb;
    AppMethodBeat.o(203037);
  }
  
  public final void ahE(String paramString)
  {
    AppMethodBeat.i(203038);
    p.h(paramString, "value");
    this.videoFlag = paramString;
    AppMethodBeat.o(203038);
  }
  
  public final String cDc()
  {
    String str2 = this.videoFlag;
    String str1 = str2;
    if (str2 == null) {
      str1 = r.syF.detail;
    }
    return str1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203042);
    if ((paramObject instanceof c))
    {
      boolean bool = p.i(this.skX, ((c)paramObject).skX);
      AppMethodBeat.o(203042);
      return bool;
    }
    AppMethodBeat.o(203042);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203041);
    int i = this.skX.hashCode();
    AppMethodBeat.o(203041);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203039);
    String str;
    if (this.field_requestVideoFormat == 1) {
      str = "H264";
    }
    for (;;)
    {
      str = "[" + this.skW + "] " + a.ahF(this.skX) + ' ' + str + " percent=" + this.fJK + "% minSize=" + bt.sy(this.preloadMinSize) + " connection=" + this.connectionCount;
      AppMethodBeat.o(203039);
      return str;
      if (this.field_requestVideoFormat == 2) {
        str = "H265";
      } else {
        str = "";
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"})
  public static final class a
  {
    public static String ahF(String paramString)
    {
      AppMethodBeat.i(203033);
      p.h(paramString, "mediaId");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(203033);
        return "";
      }
      if (paramString.length() <= 13)
      {
        AppMethodBeat.o(203033);
        return paramString;
      }
      paramString = paramString.substring(13, d.k.h.lq(paramString.length(), 24));
      p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(203033);
      return paramString;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(203034);
      b localb1 = new b("LOADING", 0);
      sla = localb1;
      b localb2 = new b("PENDING", 1);
      slb = localb2;
      b localb3 = new b("WAITING", 2);
      slc = localb3;
      sld = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(203034);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c
 * JD-Core Version:    0.7.0.1
 */