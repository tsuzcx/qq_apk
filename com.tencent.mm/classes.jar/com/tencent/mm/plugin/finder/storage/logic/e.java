package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Vector;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionManager;", "", "()V", "TAG", "", "approveMentionList", "Ljava/util/Vector;", "", "getApplyMentionState", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "removeMentionOp", "", "mentionId", "setMentionApprovedOp", "plugin-finder_release"})
public final class e
{
  private static final String TAG = "Finder.FinderMentionManager";
  private static final Vector<Long> sAx;
  public static final e sAy;
  
  static
  {
    AppMethodBeat.i(203880);
    sAy = new e();
    TAG = "Finder.FinderMentionManager";
    sAx = new Vector();
    AppMethodBeat.o(203880);
  }
  
  public static void b(ac paramac)
  {
    AppMethodBeat.i(203877);
    p.h(paramac, "mention");
    sAx.add(Long.valueOf(paramac.field_id));
    AppMethodBeat.o(203877);
  }
  
  public static int c(ac paramac)
  {
    AppMethodBeat.i(203879);
    p.h(paramac, "mention");
    ad.i(TAG, "getApplyMentionState, cache exist:" + sAx.contains(Long.valueOf(paramac.field_id)) + ", item flag: " + paramac.field_extFlag + ", createTime:" + paramac.field_createTime);
    if (sAx.contains(Long.valueOf(paramac.field_id)))
    {
      AppMethodBeat.o(203879);
      return 2;
    }
    if ((paramac.field_extFlag & 0x8) > 0)
    {
      AppMethodBeat.o(203879);
      return 4;
    }
    if ((paramac.field_extFlag & 0x4) > 0)
    {
      AppMethodBeat.o(203879);
      return 2;
    }
    if (cf.aCN() > paramac.field_followExpireTime)
    {
      AppMethodBeat.o(203879);
      return 3;
    }
    AppMethodBeat.o(203879);
    return 1;
  }
  
  public static void xi(long paramLong)
  {
    AppMethodBeat.i(203878);
    sAx.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(203878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.e
 * JD-Core Version:    0.7.0.1
 */