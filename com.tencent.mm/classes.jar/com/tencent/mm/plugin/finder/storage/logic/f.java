package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionManager;", "", "()V", "TAG", "", "approveMentionList", "Ljava/util/Vector;", "", "getApplyMentionState", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "removeMentionOp", "", "mentionId", "setMentionApprovedOp", "plugin-finder_release"})
public final class f
{
  private static final Vector<Long> AnQ;
  public static final f AnR;
  private static final String TAG = "Finder.FinderMentionManager";
  
  static
  {
    AppMethodBeat.i(275319);
    AnR = new f();
    TAG = "Finder.FinderMentionManager";
    AnQ = new Vector();
    AppMethodBeat.o(275319);
  }
  
  public static void MW(long paramLong)
  {
    AppMethodBeat.i(275316);
    AnQ.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(275316);
  }
  
  public static void c(an paraman)
  {
    AppMethodBeat.i(275315);
    p.k(paraman, "mention");
    AnQ.add(Long.valueOf(paraman.field_id));
    AppMethodBeat.o(275315);
  }
  
  public static int d(an paraman)
  {
    AppMethodBeat.i(275318);
    p.k(paraman, "mention");
    Log.i(TAG, "getApplyMentionState, cache exist:" + AnQ.contains(Long.valueOf(paraman.field_id)) + ", item flag: " + paraman.field_extFlag + ", createTime:" + paraman.field_createTime);
    if (AnQ.contains(Long.valueOf(paraman.field_id)))
    {
      AppMethodBeat.o(275318);
      return 2;
    }
    if ((paraman.field_extFlag & 0x8) > 0)
    {
      AppMethodBeat.o(275318);
      return 4;
    }
    if ((paraman.field_extFlag & 0x4) > 0)
    {
      AppMethodBeat.o(275318);
      return 2;
    }
    if (cm.bfF() > paraman.field_followExpireTime)
    {
      AppMethodBeat.o(275318);
      return 3;
    }
    AppMethodBeat.o(275318);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.f
 * JD-Core Version:    0.7.0.1
 */