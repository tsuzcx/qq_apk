package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.byp.b;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$c
  implements h.b
{
  public static final c rOU;
  
  static
  {
    AppMethodBeat.i(165057);
    rOU = new c();
    AppMethodBeat.o(165057);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(165056);
    Object localObject = s.sJJ;
    p.h("findermessage006", "table");
    localObject = b.oBl;
    localObject = j.getCreateSQLs(b.access$getInfo$cp(), "findermessage006");
    p.g(localObject, "getCreateSQLs(BypMsgInfo.info, table)");
    String str1 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SvrIdIndex ON " + "findermessage006" + " ( msgSvrId )";
    String str2 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerIndex ON " + "findermessage006" + " ( talker )";
    String str3 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerStatusIndex ON " + "findermessage006" + " ( talker,status )";
    String str4 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTimeIndex ON " + "findermessage006" + " ( createTime )";
    String str5 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTalkerTimeIndex ON " + "findermessage006" + " ( talker,createTime )";
    String str6 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SendCreateTimeIndex ON " + "findermessage006" + " ( status,isSend,createTime )";
    String str7 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerTypeIndex ON " + "findermessage006" + " ( talker,type )";
    AppMethodBeat.o(165056);
    return new String[] { localObject, str1, str2, str3, str4, str5, str6, str7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.c
 * JD-Core Version:    0.7.0.1
 */