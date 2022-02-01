package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Vector;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionManager;", "", "()V", "TAG", "", "approveMentionList", "Ljava/util/Vector;", "", "getApplyMentionState", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "removeMentionOp", "", "mentionId", "setMentionApprovedOp", "plugin-finder_release"})
public final class e
{
  private static final String TAG = "Finder.FinderMentionManager";
  private static final Vector<Long> sLv;
  public static final e sLw;
  
  static
  {
    AppMethodBeat.i(204472);
    sLw = new e();
    TAG = "Finder.FinderMentionManager";
    sLv = new Vector();
    AppMethodBeat.o(204472);
  }
  
  public static void b(ac paramac)
  {
    AppMethodBeat.i(204469);
    p.h(paramac, "mention");
    sLv.add(Long.valueOf(paramac.field_id));
    AppMethodBeat.o(204469);
  }
  
  public static int c(ac paramac)
  {
    AppMethodBeat.i(204471);
    p.h(paramac, "mention");
    ae.i(TAG, "getApplyMentionState, cache exist:" + sLv.contains(Long.valueOf(paramac.field_id)) + ", item flag: " + paramac.field_extFlag + ", createTime:" + paramac.field_createTime);
    if (sLv.contains(Long.valueOf(paramac.field_id)))
    {
      AppMethodBeat.o(204471);
      return 2;
    }
    if ((paramac.field_extFlag & 0x8) > 0)
    {
      AppMethodBeat.o(204471);
      return 4;
    }
    if ((paramac.field_extFlag & 0x4) > 0)
    {
      AppMethodBeat.o(204471);
      return 2;
    }
    if (ch.aDd() > paramac.field_followExpireTime)
    {
      AppMethodBeat.o(204471);
      return 3;
    }
    AppMethodBeat.o(204471);
    return 1;
  }
  
  public static void xz(long paramLong)
  {
    AppMethodBeat.i(204470);
    sLv.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(204470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.e
 * JD-Core Version:    0.7.0.1
 */