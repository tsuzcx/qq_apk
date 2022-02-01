package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "Lcom/tencent/mm/autogen/table/BaseFinderMediaCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()J", "setCacheSize", "(J)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "firstPlay", "getFirstPlay", "()I", "setFirstPlay", "(I)V", "", "isMoovReady", "()Z", "setMoovReady", "(Z)V", "state", "getState", "setState", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "equals", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPercent", "hashCode", "isAllCompleted", "isDownloadFinish", "isDownloadFinishAndCheckFile", "path", "isPreLoadCompleted", "reset", "", "toString", "Companion", "State", "plugin-finder_release"})
public final class y
  extends ch
{
  private static final c.a info;
  public static final a skB;
  
  static
  {
    AppMethodBeat.i(166400);
    skB = new a((byte)0);
    info = ch.Vv();
    AppMethodBeat.o(166400);
  }
  
  public final int ahy(String paramString)
  {
    AppMethodBeat.i(202970);
    p.h(paramString, "path");
    if ((this.field_totalSize > 0L) && (this.field_cacheSize == this.field_totalSize)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(202970);
      return 1;
    }
    if (!i.fv(paramString))
    {
      AppMethodBeat.o(202970);
      return 2;
    }
    AppMethodBeat.o(202970);
    return 0;
  }
  
  public final boolean cCW()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state == 3);
  }
  
  public final boolean cCX()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state >= 2);
  }
  
  public final int cCY()
  {
    if (this.field_totalSize <= 0L) {
      return 0;
    }
    return (int)((float)this.field_cacheSize / (float)this.field_totalSize * 100.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202972);
    if ((paramObject instanceof y))
    {
      boolean bool = p.i(this.field_mediaId, ((y)paramObject).field_mediaId);
      AppMethodBeat.o(202972);
      return bool;
    }
    AppMethodBeat.o(202972);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(166398);
    c.a locala = info;
    p.g(locala, "info");
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
  
  public final int hashCode()
  {
    AppMethodBeat.i(202971);
    int i = this.field_mediaId.hashCode();
    AppMethodBeat.o(202971);
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
    String str = this.field_mediaId + ", " + this.field_fileFormat + ", codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + cCY() + ", " + this.field_filePath + ", " + this.field_url;
    AppMethodBeat.o(166399);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.y
 * JD-Core Version:    0.7.0.1
 */