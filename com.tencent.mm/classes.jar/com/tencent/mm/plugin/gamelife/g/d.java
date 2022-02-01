package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.byp.b;
import com.tencent.mm.plugin.byp.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.e;
import d.l;
import junit.framework.Assert;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-gamelife_release"})
public final class d
  extends e
{
  private static final String[] SQL_CREATE;
  public static final a uyq;
  
  static
  {
    AppMethodBeat.i(211388);
    uyq = new a((byte)0);
    b.a locala = b.ouL;
    SQL_CREATE = new String[] { j.getCreateSQLs(b.access$getInfo$cp(), "gamelifemessage"), "CREATE INDEX IF NOT EXISTS  gamelifemessageSvrIdIndex ON gamelifemessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerIndex ON gamelifemessage ( talker )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerStatusIndex ON gamelifemessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTimeIndex ON gamelifemessage ( createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageCreateTalkerTimeIndex ON gamelifemessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageSendCreateTimeIndex ON gamelifemessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  gamelifemessageTalkerTypeIndex ON gamelifemessage ( talker,type )" };
    AppMethodBeat.o(211388);
  }
  
  public d(i parami)
  {
    super(parami);
    AppMethodBeat.i(211387);
    d(getDB(), "gamelifemessage");
    a(new i.b(1024, "gamelifemessage", i.b.a(4500001L, 5000000L, 208000001L, 308000000L)));
    AppMethodBeat.o(211387);
  }
  
  public final String aiu(String paramString)
  {
    AppMethodBeat.i(211386);
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
      if (!am.aSV(paramString)) {
        break label59;
      }
      AppMethodBeat.o(211386);
      return "gamelifemessage";
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(211386);
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.d
 * JD-Core Version:    0.7.0.1
 */