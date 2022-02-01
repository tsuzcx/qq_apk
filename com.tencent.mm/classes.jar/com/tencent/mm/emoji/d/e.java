package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bv;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/report/EmojiPopupReport;", "", "()V", "ActionAddInDetail", "", "ActionDelete", "ActionDeleteConfirm", "ActionLongClick", "ActionTop", "ActionViewDetail", "SceneCapture", "SceneCustom", "SceneSearch", "SceneSimilar", "SceneStore", "TAG", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "report", "", "action", "setSceneFromType", "type", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e mmt;
  private static final bv mmu;
  
  static
  {
    AppMethodBeat.i(183966);
    mmt = new e();
    TAG = "MicroMsg.EmojiPopupReport";
    mmu = new bv();
    AppMethodBeat.o(183966);
  }
  
  public static bv aWd()
  {
    return mmu;
  }
  
  public static void rG(int paramInt)
  {
    AppMethodBeat.i(183964);
    mmu.ilm = paramInt;
    mmu.bMH();
    AppMethodBeat.o(183964);
  }
  
  public static void rN(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(183965);
    bv localbv = mmu;
    int i = j;
    switch (paramInt)
    {
    default: 
      Log.e(TAG, "type scene mismatch");
      i = j;
    }
    for (;;)
    {
      localbv.imW = i;
      AppMethodBeat.o(183965);
      return;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.e
 * JD-Core Version:    0.7.0.1
 */