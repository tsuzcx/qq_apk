package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cq;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "Lcom/tencent/mm/autogen/table/BaseFinderMediaCacheInfoV2;", "()V", "value", "", "cacheSize", "getCacheSize", "()J", "setCacheSize", "(J)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "firstPlay", "getFirstPlay", "()I", "setFirstPlay", "(I)V", "", "isMoovReady", "()Z", "setMoovReady", "(Z)V", "state", "getState", "setState", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "equals", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPercent", "hashCode", "isAllCompleted", "isDownloadFinish", "isDownloadFinishAndCheckFile", "path", "isPreLoadCompleted", "reset", "", "toString", "Companion", "State", "plugin-finder_release"})
public final class av
  extends cq
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a zBi;
  private String filePath = "";
  
  static
  {
    AppMethodBeat.i(166400);
    zBi = new a((byte)0);
    info = cq.aoY();
    AppMethodBeat.o(166400);
  }
  
  public final int aDv(String paramString)
  {
    AppMethodBeat.i(285797);
    p.k(paramString, "path");
    if ((this.field_totalSize > 0L) && (this.field_cacheSize == this.field_totalSize)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(285797);
      return 1;
    }
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(285797);
      return 2;
    }
    AppMethodBeat.o(285797);
    return 0;
  }
  
  public final boolean dKN()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state == 3);
  }
  
  public final boolean dKO()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state >= 2);
  }
  
  public final int dKP()
  {
    if (this.field_totalSize <= 0L) {
      return 0;
    }
    return (int)((float)this.field_cacheSize / (float)this.field_totalSize * 100.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(285800);
    if ((paramObject instanceof av))
    {
      boolean bool = p.h(this.field_mediaId, ((av)paramObject).field_mediaId);
      AppMethodBeat.o(285800);
      return bool;
    }
    AppMethodBeat.o(285800);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(166398);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.j(localMAutoDBInfo, "info");
    AppMethodBeat.o(166398);
    return localMAutoDBInfo;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(285796);
    Object localObject = com.tencent.mm.plugin.finder.utils.av.AJz;
    localObject = this.field_fileFormat;
    String str1 = this.field_originMediaId;
    String str2 = this.field_url;
    localObject = com.tencent.mm.plugin.finder.utils.av.AJq + com.tencent.mm.plugin.finder.utils.av.ai((String)localObject, str1, str2);
    AppMethodBeat.o(285796);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(285799);
    int i = this.field_mediaId.hashCode();
    AppMethodBeat.o(285799);
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
    String str = this.field_mediaId + ", " + this.field_fileFormat + ", codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + dKP() + ", " + getFilePath() + ", " + this.field_url;
    AppMethodBeat.o(166399);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.av
 * JD-Core Version:    0.7.0.1
 */