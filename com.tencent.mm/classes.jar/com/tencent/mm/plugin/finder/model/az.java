package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cy;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "Lcom/tencent/mm/autogen/table/BaseFinderMediaCacheInfoV2;", "()V", "value", "", "cacheSize", "getCacheSize", "()J", "setCacheSize", "(J)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "firstPlay", "getFirstPlay", "()I", "setFirstPlay", "(I)V", "", "isMoovReady", "()Z", "setMoovReady", "(Z)V", "state", "getState", "setState", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "equals", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPercent", "hashCode", "isAllCompleted", "isDownloadFinish", "isDownloadFinishAndCheckFile", "path", "isPreLoadCompleted", "reset", "", "toString", "Companion", "State", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
  extends cy
{
  public static final az.a EDr;
  private static final IAutoDBItem.MAutoDBInfo info;
  private String filePath = "";
  
  static
  {
    AppMethodBeat.i(166400);
    EDr = new az.a((byte)0);
    info = cy.aJm();
    AppMethodBeat.o(166400);
  }
  
  public final int ayR(String paramString)
  {
    AppMethodBeat.i(331925);
    s.u(paramString, "path");
    if ((this.field_totalSize > 0L) && (this.field_cacheSize == this.field_totalSize)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(331925);
      return 1;
    }
    if (!y.ZC(paramString))
    {
      AppMethodBeat.o(331925);
      return 2;
    }
    AppMethodBeat.o(331925);
    return 0;
  }
  
  public final boolean eDw()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state == 3);
  }
  
  public final boolean eDx()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state >= 2);
  }
  
  public final int eDy()
  {
    if (this.field_totalSize <= 0L) {
      return 0;
    }
    return (int)((float)this.field_cacheSize / (float)this.field_totalSize * 100.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(331960);
    if ((paramObject instanceof az))
    {
      boolean bool = s.p(this.field_mediaId, ((az)paramObject).field_mediaId);
      AppMethodBeat.o(331960);
      return bool;
    }
    AppMethodBeat.o(331960);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(166398);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(166398);
    return localMAutoDBInfo;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(331905);
    Object localObject = bm.GlZ;
    localObject = bm.ap(this.field_fileFormat, this.field_originMediaId, this.field_url);
    AppMethodBeat.o(331905);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(331953);
    int i = this.field_mediaId.hashCode();
    AppMethodBeat.o(331953);
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
    String str = this.field_mediaId + ", " + this.field_fileFormat + ' ' + this.field_moovReady + " state:" + this.field_state + " codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + eDy() + ", " + getFilePath() + ", " + this.field_url;
    AppMethodBeat.o(166399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.az
 * JD-Core Version:    0.7.0.1
 */