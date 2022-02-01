package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionManager;", "", "()V", "TAG", "", "approveMentionList", "Ljava/util/Vector;", "", "getApplyMentionState", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "removeMentionOp", "", "mentionId", "setMentionApprovedOp", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g FNK;
  private static final Vector<Long> FNL;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(339486);
    FNK = new g();
    TAG = "Finder.FinderMentionManager";
    FNL = new Vector();
    AppMethodBeat.o(339486);
  }
  
  public static void d(av paramav)
  {
    AppMethodBeat.i(339471);
    s.u(paramav, "mention");
    FNL.add(Long.valueOf(paramav.field_id));
    AppMethodBeat.o(339471);
  }
  
  public static int e(av paramav)
  {
    AppMethodBeat.i(339482);
    s.u(paramav, "mention");
    Log.i(TAG, "getApplyMentionState, cache exist:" + FNL.contains(Long.valueOf(paramav.field_id)) + ", item flag: " + paramav.field_extFlag + ", createTime:" + paramav.field_createTime);
    if (FNL.contains(Long.valueOf(paramav.field_id)))
    {
      AppMethodBeat.o(339482);
      return 2;
    }
    if ((paramav.field_extFlag & 0x8) > 0)
    {
      AppMethodBeat.o(339482);
      return 4;
    }
    if ((paramav.field_extFlag & 0x4) > 0)
    {
      AppMethodBeat.o(339482);
      return 2;
    }
    if (cn.getSyncServerTimeSecond() > paramav.field_followExpireTime)
    {
      AppMethodBeat.o(339482);
      return 3;
    }
    AppMethodBeat.o(339482);
    return 1;
  }
  
  public static void qv(long paramLong)
  {
    AppMethodBeat.i(339476);
    FNL.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(339476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.g
 * JD-Core Version:    0.7.0.1
 */