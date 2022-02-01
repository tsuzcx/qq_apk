package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "Lcom/tencent/mm/autogen/table/BaseFinderMediaCacheInfoV2;", "()V", "value", "", "cacheSize", "getCacheSize", "()J", "setCacheSize", "(J)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "firstPlay", "getFirstPlay", "()I", "setFirstPlay", "(I)V", "", "isMoovReady", "()Z", "setMoovReady", "(Z)V", "state", "getState", "setState", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "equals", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPercent", "hashCode", "isAllCompleted", "isDownloadFinish", "isDownloadFinishAndCheckFile", "path", "isPreLoadCompleted", "reset", "", "toString", "Companion", "State", "plugin-finder_release"})
public final class z
  extends ch
{
  private static final c.a info;
  public static final z.a sty;
  private String filePath = "";
  
  static
  {
    AppMethodBeat.i(166400);
    sty = new z.a((byte)0);
    info = ch.VD();
    AppMethodBeat.o(166400);
  }
  
  public final int aiv(String paramString)
  {
    AppMethodBeat.i(203454);
    p.h(paramString, "path");
    if ((this.field_totalSize > 0L) && (this.field_cacheSize == this.field_totalSize)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(203454);
      return 1;
    }
    if (!o.fB(paramString))
    {
      AppMethodBeat.o(203454);
      return 2;
    }
    AppMethodBeat.o(203454);
    return 0;
  }
  
  public final boolean cEJ()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state == 3);
  }
  
  public final boolean cEK()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state >= 2);
  }
  
  public final int cEL()
  {
    if (this.field_totalSize <= 0L) {
      return 0;
    }
    return (int)((float)this.field_cacheSize / (float)this.field_totalSize * 100.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203456);
    if ((paramObject instanceof z))
    {
      boolean bool = p.i(this.field_mediaId, ((z)paramObject).field_mediaId);
      AppMethodBeat.o(203456);
      return bool;
    }
    AppMethodBeat.o(203456);
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
    AppMethodBeat.i(224301);
    Object localObject = r.sYn;
    localObject = this.field_fileFormat;
    String str1 = this.field_originMediaId;
    String str2 = this.field_url;
    localObject = r.sYg + r.bw((String)localObject, str1, str2);
    AppMethodBeat.o(224301);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203455);
    int i = this.field_mediaId.hashCode();
    AppMethodBeat.o(203455);
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
    String str = this.field_mediaId + ", " + this.field_fileFormat + ", codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + cEL() + ", " + getFilePath() + ", " + this.field_url;
    AppMethodBeat.o(166399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.z
 * JD-Core Version:    0.7.0.1
 */