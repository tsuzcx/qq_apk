package com.tencent.mm.plugin.gamelife.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.byp.b;
import com.tencent.mm.plugin.byp.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.e;
import junit.framework.Assert;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends e
{
  public static final d.a JbI;
  private static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(267774);
    JbI = new d.a((byte)0);
    b.a locala = b.wag;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.access$getInfo$cp(), "gamelifemessage"), "CREATE INDEX IF NOT EXISTS  gamelifemessageSvrIdIndex ON gamelifemessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerIndex ON gamelifemessage ( talker )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerStatusIndex ON gamelifemessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTimeIndex ON gamelifemessage ( createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTalkerTimeIndex ON gamelifemessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageSendCreateTimeIndex ON gamelifemessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerTypeIndex ON gamelifemessage ( talker,type )" };
    AppMethodBeat.o(267774);
  }
  
  public d(i parami)
  {
    super(parami);
    AppMethodBeat.i(267764);
    e(getDB(), "gamelifemessage");
    a(new i.b(1024, "gamelifemessage", i.b.d(4500001L, 5000000L, 208000001L, 308000000L)));
    AppMethodBeat.o(267764);
  }
  
  public final String aAD(String paramString)
  {
    AppMethodBeat.i(267779);
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
      if (!au.bwW(paramString)) {
        break label59;
      }
      AppMethodBeat.o(267779);
      return "gamelifemessage";
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(267779);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.h.d
 * JD-Core Version:    0.7.0.1
 */