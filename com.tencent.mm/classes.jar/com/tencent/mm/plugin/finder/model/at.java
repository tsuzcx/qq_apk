package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cl;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "Lcom/tencent/mm/autogen/table/BaseFinderMediaCacheInfoV2;", "()V", "value", "", "cacheSize", "getCacheSize", "()J", "setCacheSize", "(J)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "firstPlay", "getFirstPlay", "()I", "setFirstPlay", "(I)V", "", "isMoovReady", "()Z", "setMoovReady", "(Z)V", "state", "getState", "setState", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "equals", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPercent", "hashCode", "isAllCompleted", "isDownloadFinish", "isDownloadFinishAndCheckFile", "path", "isPreLoadCompleted", "reset", "", "toString", "Companion", "State", "plugin-finder_release"})
public final class at
  extends cl
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a uON;
  private String filePath = "";
  
  static
  {
    AppMethodBeat.i(166400);
    uON = new a((byte)0);
    info = cl.ajs();
    AppMethodBeat.o(166400);
  }
  
  public final int aui(String paramString)
  {
    AppMethodBeat.i(248807);
    p.h(paramString, "path");
    if ((this.field_totalSize > 0L) && (this.field_cacheSize == this.field_totalSize)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(248807);
      return 1;
    }
    if (!s.YS(paramString))
    {
      AppMethodBeat.o(248807);
      return 2;
    }
    AppMethodBeat.o(248807);
    return 0;
  }
  
  public final boolean dkN()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state == 3);
  }
  
  public final boolean dkO()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state >= 2);
  }
  
  public final int dkP()
  {
    if (this.field_totalSize <= 0L) {
      return 0;
    }
    return (int)((float)this.field_cacheSize / (float)this.field_totalSize * 100.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(248809);
    if ((paramObject instanceof at))
    {
      boolean bool = p.j(this.field_mediaId, ((at)paramObject).field_mediaId);
      AppMethodBeat.o(248809);
      return bool;
    }
    AppMethodBeat.o(248809);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(166398);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(166398);
    return localMAutoDBInfo;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(248806);
    Object localObject = al.waC;
    localObject = al.am(this.field_fileFormat, this.field_originMediaId, this.field_url);
    AppMethodBeat.o(248806);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(248808);
    int i = this.field_mediaId.hashCode();
    AppMethodBeat.o(248808);
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
    String str = this.field_mediaId + ", " + this.field_fileFormat + ", codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + dkP() + ", " + getFilePath() + ", " + this.field_url;
    AppMethodBeat.o(166399);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.at
 * JD-Core Version:    0.7.0.1
 */