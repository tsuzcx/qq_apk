package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"})
public final class d
  extends h
  implements Comparable<d>
{
  public static final a zKw;
  public int weight;
  private b zKt;
  public final String zKu;
  public final String zKv;
  public final aa zuY;
  
  static
  {
    AppMethodBeat.i(289982);
    zKw = new a((byte)0);
    AppMethodBeat.o(289982);
  }
  
  public d(aa paramaa)
  {
    AppMethodBeat.i(289981);
    this.zuY = paramaa;
    this.zKt = b.zKy;
    this.zKu = this.zuY.aBv();
    String str = this.zuY.ztO.mediaId;
    paramaa = str;
    if (str == null) {
      paramaa = "";
    }
    this.zKv = paramaa;
    AppMethodBeat.o(289981);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(289975);
    p.k(paramb, "<set-?>");
    this.zKt = paramb;
    AppMethodBeat.o(289975);
  }
  
  public final void aDG(String paramString)
  {
    AppMethodBeat.i(289976);
    p.k(paramString, "value");
    this.videoFlag = paramString;
    AppMethodBeat.o(289976);
  }
  
  public final String dMH()
  {
    String str2 = this.videoFlag;
    String str1 = str2;
    if (str2 == null) {
      str1 = u.AlA.detail;
    }
    return str1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(289980);
    if ((paramObject instanceof d))
    {
      boolean bool = p.h(this.zKu, ((d)paramObject).zKu);
      AppMethodBeat.o(289980);
      return bool;
    }
    AppMethodBeat.o(289980);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(289979);
    int i = this.zKu.hashCode();
    AppMethodBeat.o(289979);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(289977);
    String str;
    if (this.field_requestVideoFormat == 1) {
      str = "H264";
    }
    for (;;)
    {
      str = "[" + this.zKt + "] " + a.aDH(this.zKu) + ' ' + str + " percent=" + this.iVi + "% minSize=" + Util.getSizeKB(this.preloadMinSize) + " connection=" + this.connectionCount;
      AppMethodBeat.o(289977);
      return str;
      if (this.field_requestVideoFormat == 2) {
        str = "H265";
      } else {
        str = "";
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"})
  public static final class a
  {
    public static String aDH(String paramString)
    {
      AppMethodBeat.i(288266);
      p.k(paramString, "mediaId");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(288266);
        return "";
      }
      if (paramString.length() <= 13)
      {
        AppMethodBeat.o(288266);
        return paramString;
      }
      paramString = paramString.substring(13, i.ow(paramString.length(), 24));
      p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(288266);
      return paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(271541);
      b localb1 = new b("LOADING", 0);
      zKx = localb1;
      b localb2 = new b("PENDING", 1);
      zKy = localb2;
      b localb3 = new b("WAITING", 2);
      zKz = localb3;
      zKA = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(271541);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.d
 * JD-Core Version:    0.7.0.1
 */