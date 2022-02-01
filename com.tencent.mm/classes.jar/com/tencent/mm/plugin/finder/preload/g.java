package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends h
  implements Comparable<g>
{
  public static final g.a EUP;
  private g.b EUQ;
  public final String EUR;
  public final String EUS;
  public final com.tencent.mm.plugin.finder.loader.v EyX;
  public long feedId;
  public int weight;
  
  static
  {
    AppMethodBeat.i(346256);
    EUP = new g.a((byte)0);
    AppMethodBeat.o(346256);
  }
  
  public g(com.tencent.mm.plugin.finder.loader.v paramv)
  {
    AppMethodBeat.i(346251);
    this.EyX = paramv;
    this.EUQ = g.b.EUU;
    this.EUR = this.EyX.aUt();
    String str = this.EyX.ExE.mediaId;
    paramv = str;
    if (str == null) {
      paramv = "";
    }
    this.EUS = paramv;
    AppMethodBeat.o(346251);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(346260);
    s.u(paramb, "<set-?>");
    this.EUQ = paramb;
    AppMethodBeat.o(346260);
  }
  
  public final void azj(String paramString)
  {
    AppMethodBeat.i(346268);
    s.u(paramString, "value");
    this.videoFlag = paramString;
    AppMethodBeat.o(346268);
  }
  
  public final String eHJ()
  {
    String str2 = this.videoFlag;
    String str1 = str2;
    if (str2 == null) {
      str1 = com.tencent.mm.plugin.finder.storage.v.FLa.detail;
    }
    return str1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(346286);
    if ((paramObject instanceof g))
    {
      boolean bool = s.p(this.EUR, ((g)paramObject).EUR);
      AppMethodBeat.o(346286);
      return bool;
    }
    AppMethodBeat.o(346286);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(346280);
    int i = this.EUR.hashCode();
    AppMethodBeat.o(346280);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(346276);
    String str;
    if (this.field_requestVideoFormat == 1) {
      str = "H264";
    }
    for (;;)
    {
      str = "[" + this.EUQ + "] " + g.a.azk(this.EUR) + ' ' + str + " percent=" + this.lxn + "% minSize=" + Util.getSizeKB(this.preloadMinSize) + " connection=" + this.connectionCount;
      AppMethodBeat.o(346276);
      return str;
      if (this.field_requestVideoFormat == 2) {
        str = "H265";
      } else {
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.g
 * JD-Core Version:    0.7.0.1
 */