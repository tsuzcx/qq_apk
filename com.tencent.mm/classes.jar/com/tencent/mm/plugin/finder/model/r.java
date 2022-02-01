package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "Lcom/tencent/mm/autogen/table/BaseFinderMediaCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()J", "setCacheSize", "(J)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "firstPlay", "getFirstPlay", "()I", "setFirstPlay", "(I)V", "state", "getState", "setState", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "equals", "", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPercent", "hashCode", "isAllCompleted", "isDownloadFinish", "isDownloadFinishAndCheckFile", "path", "isPreLoadCompleted", "reset", "", "toString", "Companion", "State", "plugin-finder_release"})
public final class r
  extends cc
{
  private static final c.a info;
  public static final a qDQ;
  
  static
  {
    AppMethodBeat.i(166400);
    qDQ = new a((byte)0);
    info = cc.So();
    AppMethodBeat.o(166400);
  }
  
  public final int aVm(String paramString)
  {
    AppMethodBeat.i(198642);
    k.h(paramString, "path");
    if ((this.field_totalSize > 0L) && (this.field_cacheSize == this.field_totalSize)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(198642);
      return 1;
    }
    if (!i.eK(paramString))
    {
      AppMethodBeat.o(198642);
      return 2;
    }
    AppMethodBeat.o(198642);
    return 0;
  }
  
  public final boolean cnm()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state == 3);
  }
  
  public final boolean cnn()
  {
    return (this.field_totalSize > 0L) && (this.field_cacheSize > 0L) && (this.field_state >= 2);
  }
  
  public final int cno()
  {
    if (this.field_totalSize <= 0L) {
      return 0;
    }
    return (int)((float)this.field_cacheSize / (float)this.field_totalSize * 100.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198644);
    if ((paramObject instanceof r))
    {
      boolean bool = k.g(this.field_mediaId, ((r)paramObject).field_mediaId);
      AppMethodBeat.o(198644);
      return bool;
    }
    AppMethodBeat.o(198644);
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
    AppMethodBeat.i(198643);
    int i = this.field_mediaId.hashCode();
    AppMethodBeat.o(198643);
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
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166399);
    String str = this.field_mediaId + ", " + this.field_fileFormat + ", codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + cno() + ", " + this.field_filePath + ", " + this.field_url;
    AppMethodBeat.o(166399);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderMediaCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.r
 * JD-Core Version:    0.7.0.1
 */