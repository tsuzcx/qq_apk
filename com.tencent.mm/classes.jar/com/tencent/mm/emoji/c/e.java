package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/report/EmojiPopupReport;", "", "()V", "ActionAddInDetail", "", "ActionDelete", "ActionDeleteConfirm", "ActionLongClick", "ActionTop", "ActionViewDetail", "SceneCapture", "SceneCustom", "SceneSearch", "SceneSimilar", "SceneStore", "TAG", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "report", "", "action", "setSceneFromType", "type", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiPopupReport";
  private static final ar hck;
  public static final e hcl;
  
  static
  {
    AppMethodBeat.i(183966);
    hcl = new e();
    TAG = "MicroMsg.EmojiPopupReport";
    hck = new ar();
    AppMethodBeat.o(183966);
  }
  
  public static ar awe()
  {
    return hck;
  }
  
  public static void pl(int paramInt)
  {
    AppMethodBeat.i(183964);
    hck.jT(paramInt);
    hck.bfK();
    AppMethodBeat.o(183964);
  }
  
  public static void ps(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(183965);
    ar localar = hck;
    int i = j;
    switch (paramInt)
    {
    default: 
      Log.e(TAG, "type scene mismatch");
      i = j;
    }
    for (;;)
    {
      localar.jU(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.e
 * JD-Core Version:    0.7.0.1
 */