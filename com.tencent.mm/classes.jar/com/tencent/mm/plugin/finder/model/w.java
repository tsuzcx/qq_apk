package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "Lcom/tencent/mm/autogen/table/BaseFinderMediaCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()J", "setCacheSize", "(J)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "firstPlay", "getFirstPlay", "()I", "setFirstPlay", "(I)V", "", "isMoovReady", "()Z", "setMoovReady", "(Z)V", "state", "getState", "setState", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "equals", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPercent", "hashCode", "isAllCompleted", "isDownloadFinish", "isDownloadFinishAndCheckFile", "path", "isPreLoadCompleted", "reset", "", "toString", "Companion", "State", "plugin-finder_release"})
public final class w
  extends ce
{
  private static final c.a info;
  public static final w.a rvg;
  
  static
  {
    AppMethodBeat.i(166400);
    rvg = new w.a((byte)0);
    info = ce.Th();
    AppMethodBeat.o(166400);
  }
  
  public final int adF(String paramString)
  {
    AppMethodBeat.i(202569);
    k.h(paramString, "path");
    if ((this.field_totalSize > 0L) && (this.field_cacheSize == this.field_totalSize)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(202569);
      return 1;
    }
    if (!i.eA(paramString))
    {
      AppMethodBeat.o(202569);
      return 2;
    }
    AppMethodBeat.o(202569);
    return 0;
  }
  
  public final boolean cwG()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state == 3);
  }
  
  public final boolean cwH()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state >= 2);
  }
  
  public final int cwI()
  {
    if (this.field_totalSize <= 0L) {
      return 0;
    }
    return (int)((float)this.field_cacheSize / (float)this.field_totalSize * 100.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202571);
    if ((paramObject instanceof w))
    {
      boolean bool = k.g(this.field_mediaId, ((w)paramObject).field_mediaId);
      AppMethodBeat.o(202571);
      return bool;
    }
    AppMethodBeat.o(202571);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(166398);
    c.a locala = info;
    k.g(locala, "info");
    AppMethodBeat.o(166398);
    return locala;
  }
  
  public final String getFilePath()
  {
    String str2 = this.field_filePath;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getUrl()
  {
    String str2 = this.field_url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(202570);
    int i = this.field_mediaId.hashCode();
    AppMethodBeat.o(202570);
    return i;
  }
  
  public final void reset()
  {
    this.field_cacheSize = 0L;
    this.field_totalSize = 0L;
    this.field_hasPlayed = false;
    this.field_reqFormat = 0;
    this.field_fileFormat = "";
    this.field_state = 0;
    this.field_moovReady = false;
    this.field_audioBitrate = 0;
    this.field_videoBitrate = 0;
    this.field_frameRate = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166399);
    String str = this.field_mediaId + ", " + this.field_fileFormat + ", codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + cwI() + ", " + this.field_filePath + ", " + this.field_url;
    AppMethodBeat.o(166399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.w
 * JD-Core Version:    0.7.0.1
 */