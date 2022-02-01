package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "Lcom/tencent/mm/autogen/table/BaseEmojiSuggestCacheInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isValid", "", "needUpdate", "Companion", "plugin-emojisdk_release"})
public final class c
  extends bl
{
  static final String TAG = "MicroMsg.EmojiSuggestCacheInfo";
  private static final long gZy = 86400L;
  public static final a gZz;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(199937);
    gZz = new a((byte)0);
    TAG = "MicroMsg.EmojiSuggestCacheInfo";
    info = bl.ajs();
    gZy = 86400L;
    AppMethodBeat.o(199937);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(199936);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(199936);
    return localMAutoDBInfo;
  }
  
  public final boolean isValid()
  {
    byte[] arrayOfByte = this.field_content;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length == 0) {}
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo$Companion;", "", "()V", "TAG", "", "UpdateInterval", "", "getUpdateInterval", "()J", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.c
 * JD-Core Version:    0.7.0.1
 */