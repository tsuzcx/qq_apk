package com.tencent.mm.plugin.finder.upload.postlogic.mvstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.postlogic.base.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/mvstage/MvWaitStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/WaitStage;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "reason", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getReason", "()I", "exec", "", "getStageType", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends k
{
  private static final int Gea;
  private static final int Geb;
  public static final f.a Gfh;
  private final FinderItem Ged;
  private final int reason;
  
  static
  {
    AppMethodBeat.i(343228);
    Gfh = new f.a((byte)0);
    Gea = 1;
    Geb = 2;
    AppMethodBeat.o(343228);
  }
  
  public f(FinderItem paramFinderItem, int paramInt)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343218);
    this.Ged = paramFinderItem;
    this.reason = paramInt;
    AppMethodBeat.o(343218);
  }
  
  public final void cpv()
  {
    AppMethodBeat.i(343234);
    if (this.reason != Gea)
    {
      localObject = ah.d.Ftw;
      ah.d.tU(this.Ged.isLongVideo());
    }
    Object localObject = g.GbJ;
    g.fdW().qy(this.Ged.getLocalId());
    AppMethodBeat.o(343234);
  }
  
  public final int fer()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.mvstage.f
 * JD-Core Version:    0.7.0.1
 */