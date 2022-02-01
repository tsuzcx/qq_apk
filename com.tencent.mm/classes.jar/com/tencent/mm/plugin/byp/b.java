package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.aq;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/BypMsgInfo;", "Lcom/tencent/mm/autogen/table/BaseBypMsgInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends aq
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a wag;
  
  static
  {
    AppMethodBeat.i(272007);
    wag = new a((byte)0);
    info = aq.aJm();
    AppMethodBeat.o(272007);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(272013);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(272013);
    return localMAutoDBInfo;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/BypMsgInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b
 * JD-Core Version:    0.7.0.1
 */