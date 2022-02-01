package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.byp.b;
import com.tencent.mm.plugin.byp.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.e;
import junit.framework.Assert;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-gamelife_release"})
public final class d
  extends e
{
  public static final d.a DhQ;
  private static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(203881);
    DhQ = new d.a((byte)0);
    b.a locala = b.sVU;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.access$getInfo$cp(), "gamelifemessage"), "CREATE INDEX IF NOT EXISTS  gamelifemessageSvrIdIndex ON gamelifemessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerIndex ON gamelifemessage ( talker )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerStatusIndex ON gamelifemessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTimeIndex ON gamelifemessage ( createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTalkerTimeIndex ON gamelifemessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageSendCreateTimeIndex ON gamelifemessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerTypeIndex ON gamelifemessage ( talker,type )" };
    AppMethodBeat.o(203881);
  }
  
  public d(i parami)
  {
    super(parami);
    AppMethodBeat.i(203879);
    e(getDB(), "gamelifemessage");
    a(new i.b(1024, "gamelifemessage", i.b.b(4500001L, 5000000L, 208000001L, 308000000L)));
    AppMethodBeat.o(203879);
  }
  
  public final String aEK(String paramString)
  {
    AppMethodBeat.i(203878);
    int i;
    if (paramString != null) {
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label54;
        }
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!as.bvQ(paramString)) {
        break label59;
      }
      AppMethodBeat.o(203878);
      return "gamelifemessage";
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(203878);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.d
 * JD-Core Version:    0.7.0.1
 */