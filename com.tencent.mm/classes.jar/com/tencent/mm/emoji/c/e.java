package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.az;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/report/EmojiPopupReport;", "", "()V", "ActionAddInDetail", "", "ActionDelete", "ActionDeleteConfirm", "ActionLongClick", "ActionTop", "ActionViewDetail", "SceneCapture", "SceneCustom", "SceneSearch", "SceneSimilar", "SceneStore", "TAG", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "report", "", "action", "setSceneFromType", "type", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiPopupReport";
  private static final az jNu;
  public static final e jNv;
  
  static
  {
    AppMethodBeat.i(183966);
    jNv = new e();
    TAG = "MicroMsg.EmojiPopupReport";
    jNu = new az();
    AppMethodBeat.o(183966);
  }
  
  public static az aDd()
  {
    return jNu;
  }
  
  public static void rE(int paramInt)
  {
    AppMethodBeat.i(183964);
    jNu.ln(paramInt);
    jNu.bpa();
    AppMethodBeat.o(183964);
  }
  
  public static void rL(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(183965);
    az localaz = jNu;
    int i = j;
    switch (paramInt)
    {
    default: 
      Log.e(TAG, "type scene mismatch");
      i = j;
    }
    for (;;)
    {
      localaz.lo(i);
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
 * Qualified Name:     com.tencent.mm.emoji.c.e
 * JD-Core Version:    0.7.0.1
 */