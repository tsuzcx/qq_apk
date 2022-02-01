package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/report/EmojiPopupReport;", "", "()V", "ActionAddInDetail", "", "ActionDelete", "ActionDeleteConfirm", "ActionLongClick", "ActionTop", "ActionViewDetail", "SceneCapture", "SceneCustom", "SceneSimilar", "SceneStore", "TAG", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "report", "", "action", "setSceneFromType", "type", "plugin-emojisdk_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiPopupReport";
  private static final v fVc;
  public static final d fVd;
  
  static
  {
    AppMethodBeat.i(183966);
    fVd = new d();
    TAG = "MicroMsg.EmojiPopupReport";
    fVc = new v();
    AppMethodBeat.o(183966);
  }
  
  public static v adu()
  {
    return fVc;
  }
  
  public static void lA(int paramInt)
  {
    AppMethodBeat.i(183964);
    fVc.hZ(paramInt);
    fVc.aHZ();
    AppMethodBeat.o(183964);
  }
  
  public static void lF(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(183965);
    v localv = fVc;
    int i = j;
    switch (paramInt)
    {
    default: 
      ac.e(TAG, "type scene mismatch");
      i = j;
    }
    for (;;)
    {
      localv.ia(i);
      AppMethodBeat.o(183965);
      return;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */