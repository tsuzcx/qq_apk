package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionManager;", "", "()V", "TAG", "", "approveMentionList", "Ljava/util/Vector;", "", "getApplyMentionState", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "removeMentionOp", "", "mentionId", "setMentionApprovedOp", "plugin-finder_release"})
public final class f
{
  private static final String TAG = "Finder.FinderMentionManager";
  private static final Vector<Long> vGU;
  public static final f vGV;
  
  static
  {
    AppMethodBeat.i(252096);
    vGV = new f();
    TAG = "Finder.FinderMentionManager";
    vGU = new Vector();
    AppMethodBeat.o(252096);
  }
  
  public static void FW(long paramLong)
  {
    AppMethodBeat.i(252094);
    vGU.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(252094);
  }
  
  public static void c(ao paramao)
  {
    AppMethodBeat.i(252093);
    p.h(paramao, "mention");
    vGU.add(Long.valueOf(paramao.field_id));
    AppMethodBeat.o(252093);
  }
  
  public static int d(ao paramao)
  {
    AppMethodBeat.i(252095);
    p.h(paramao, "mention");
    Log.i(TAG, "getApplyMentionState, cache exist:" + vGU.contains(Long.valueOf(paramao.field_id)) + ", item flag: " + paramao.field_extFlag + ", createTime:" + paramao.field_createTime);
    if (vGU.contains(Long.valueOf(paramao.field_id)))
    {
      AppMethodBeat.o(252095);
      return 2;
    }
    if ((paramao.field_extFlag & 0x8) > 0)
    {
      AppMethodBeat.o(252095);
      return 4;
    }
    if ((paramao.field_extFlag & 0x4) > 0)
    {
      AppMethodBeat.o(252095);
      return 2;
    }
    if (cl.aWB() > paramao.field_followExpireTime)
    {
      AppMethodBeat.o(252095);
      return 3;
    }
    AppMethodBeat.o(252095);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.f
 * JD-Core Version:    0.7.0.1
 */