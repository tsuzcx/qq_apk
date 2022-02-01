package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"})
public final class c
  extends h
  implements Comparable<c>
{
  public static final a uUg;
  public final s tHN;
  private b uUd;
  public final String uUe;
  public final String uUf;
  public int weight;
  
  static
  {
    AppMethodBeat.i(249537);
    uUg = new a((byte)0);
    AppMethodBeat.o(249537);
  }
  
  public c(s params)
  {
    AppMethodBeat.i(249536);
    this.tHN = params;
    this.uUd = b.uUi;
    this.uUe = this.tHN.auA();
    String str = this.tHN.uIw.mediaId;
    params = str;
    if (str == null) {
      params = "";
    }
    this.uUf = params;
    AppMethodBeat.o(249536);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(249530);
    p.h(paramb, "<set-?>");
    this.uUd = paramb;
    AppMethodBeat.o(249530);
  }
  
  public final void auq(String paramString)
  {
    AppMethodBeat.i(249531);
    p.h(paramString, "value");
    this.videoFlag = paramString;
    AppMethodBeat.o(249531);
  }
  
  public final String dlG()
  {
    String str2 = this.videoFlag;
    String str1 = str2;
    if (str2 == null) {
      str1 = x.vEp.detail;
    }
    return str1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(249535);
    if ((paramObject instanceof c))
    {
      boolean bool = p.j(this.uUe, ((c)paramObject).uUe);
      AppMethodBeat.o(249535);
      return bool;
    }
    AppMethodBeat.o(249535);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(249534);
    int i = this.uUe.hashCode();
    AppMethodBeat.o(249534);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(249532);
    String str;
    if (this.field_requestVideoFormat == 1) {
      str = "H264";
    }
    for (;;)
    {
      str = "[" + this.uUd + "] " + a.aur(this.uUe) + ' ' + str + " percent=" + this.gqZ + "% minSize=" + Util.getSizeKB(this.preloadMinSize) + " connection=" + this.connectionCount;
      AppMethodBeat.o(249532);
      return str;
      if (this.field_requestVideoFormat == 2) {
        str = "H265";
      } else {
        str = "";
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"})
  public static final class a
  {
    public static String aur(String paramString)
    {
      AppMethodBeat.i(249526);
      p.h(paramString, "mediaId");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(249526);
        return "";
      }
      if (paramString.length() <= 13)
      {
        AppMethodBeat.o(249526);
        return paramString;
      }
      paramString = paramString.substring(13, j.na(paramString.length(), 24));
      p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(249526);
      return paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(249527);
      b localb1 = new b("LOADING", 0);
      uUh = localb1;
      b localb2 = new b("PENDING", 1);
      uUi = localb2;
      b localb3 = new b("WAITING", 2);
      uUj = localb3;
      uUk = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(249527);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c
 * JD-Core Version:    0.7.0.1
 */