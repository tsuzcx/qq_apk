package com.tencent.mm.emoji.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bk;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "Lcom/tencent/mm/autogen/table/BaseEmojiSuggestCacheInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isValid", "", "needUpdate", "Companion", "plugin-emojisdk_release"})
public final class c
  extends bk
{
  static final String TAG = "MicroMsg.EmojiSuggestCacheInfo";
  private static final long goF = 86400L;
  public static final a goG;
  private static final com.tencent.mm.sdk.e.c.a info;
  
  static
  {
    AppMethodBeat.i(188576);
    goG = new a((byte)0);
    TAG = "MicroMsg.EmojiSuggestCacheInfo";
    info = bk.VD();
    goF = 86400L;
    AppMethodBeat.o(188576);
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(188575);
    com.tencent.mm.sdk.e.c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(188575);
    return locala;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo$Companion;", "", "()V", "TAG", "", "UpdateInterval", "", "getUpdateInterval", "()J", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c.c
 * JD-Core Version:    0.7.0.1
 */