package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCacheInfo;", "Lcom/tencent/mm/autogen/table/BaseEmojiSuggestCacheInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isValid", "", "needUpdate", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends bo
{
  static final String TAG;
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final c.a mjO;
  private static final long mjP;
  
  static
  {
    AppMethodBeat.i(242686);
    mjO = new c.a((byte)0);
    TAG = "MicroMsg.EmojiSuggestCacheInfo";
    info = bo.aJm();
    mjP = 86400L;
    AppMethodBeat.o(242686);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(242691);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(242691);
    return localMAutoDBInfo;
  }
  
  public final boolean isValid()
  {
    byte[] arrayOfByte = this.field_content;
    if (arrayOfByte == null) {}
    for (;;)
    {
      return false;
      if (arrayOfByte.length == 0) {}
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.c
 * JD-Core Version:    0.7.0.1
 */