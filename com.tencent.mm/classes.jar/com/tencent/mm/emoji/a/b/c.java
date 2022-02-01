package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bj;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "Lcom/tencent/mm/autogen/table/BaseEmojiSuggestCacheInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isValid", "", "needUpdate", "Companion", "plugin-emojisdk_release"})
public final class c
  extends bj
{
  static final String TAG = "MicroMsg.EmojiSuggestCacheInfo";
  private static final long fSF = 86400L;
  public static final a fSG;
  private static final com.tencent.mm.sdk.e.c.a info;
  
  static
  {
    AppMethodBeat.i(209837);
    fSG = new a((byte)0);
    TAG = "MicroMsg.EmojiSuggestCacheInfo";
    info = bj.Th();
    fSF = 86400L;
    AppMethodBeat.o(209837);
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(209836);
    com.tencent.mm.sdk.e.c.a locala = info;
    k.g(locala, "info");
    AppMethodBeat.o(209836);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo$Companion;", "", "()V", "TAG", "", "UpdateInterval", "", "getUpdateInterval", "()J", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.c
 * JD-Core Version:    0.7.0.1
 */