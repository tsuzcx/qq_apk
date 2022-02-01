package com.tencent.mm.plugin.hashinfo.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hashinfo.c.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hashinfo/model/storage/HashUserNameMap;", "Lcom/tencent/mm/plugin/hashinfo/storage/BaseHashUserNameMap;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-hashinfo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final a JmL;
  private static final IAutoDBItem.MAutoDBInfo JmM;
  
  static
  {
    AppMethodBeat.i(261039);
    JmL = new a((byte)0);
    JmM = a.aJm();
    AppMethodBeat.o(261039);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(261043);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = JmM;
    s.s(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(261043);
    return localMAutoDBInfo;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hashinfo/model/storage/HashUserNameMap$Companion;", "", "()V", "TAG", "", "_dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "get_dbInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-hashinfo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hashinfo.b.a.b
 * JD-Core Version:    0.7.0.1
 */