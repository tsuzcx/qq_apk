package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.de;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderShareInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderShareInfo;", "()V", "equals", "", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getShareInfo", "", "limit", "", "hashCode", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends de
{
  public static final a AHe;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(335983);
    AHe = new a((byte)0);
    info = de.aJm();
    AppMethodBeat.o(335983);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof p))
    {
      bool1 = bool2;
      if (((p)paramObject).systemRowid == this.systemRowid) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(335988);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(335988);
    return localMAutoDBInfo;
  }
  
  public final int hashCode()
  {
    return (int)this.systemRowid;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderShareInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.p
 * JD-Core Version:    0.7.0.1
 */