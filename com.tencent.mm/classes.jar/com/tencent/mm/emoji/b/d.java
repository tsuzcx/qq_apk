package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/report/EmojiPopupReport;", "", "()V", "ActionAddInDetail", "", "ActionDelete", "ActionDeleteConfirm", "ActionLongClick", "ActionTop", "ActionViewDetail", "SceneCapture", "SceneCustom", "SceneSimilar", "SceneStore", "TAG", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "report", "", "action", "setSceneFromType", "type", "plugin-emojisdk_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiPopupReport";
  private static final y goF;
  public static final d goG;
  
  static
  {
    AppMethodBeat.i(183966);
    goG = new d();
    TAG = "MicroMsg.EmojiPopupReport";
    goF = new y();
    AppMethodBeat.o(183966);
  }
  
  public static y aga()
  {
    return goF;
  }
  
  public static void ma(int paramInt)
  {
    AppMethodBeat.i(183964);
    goF.ik(paramInt);
    goF.aLk();
    AppMethodBeat.o(183964);
  }
  
  public static void mf(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(183965);
    y localy = goF;
    int i = j;
    switch (paramInt)
    {
    default: 
      ad.e(TAG, "type scene mismatch");
      i = j;
    }
    for (;;)
    {
      localy.il(i);
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