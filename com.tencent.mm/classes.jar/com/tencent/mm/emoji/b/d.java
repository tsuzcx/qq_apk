package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/report/EmojiPopupReport;", "", "()V", "ActionAddInDetail", "", "ActionDelete", "ActionDeleteConfirm", "ActionLongClick", "ActionTop", "ActionViewDetail", "SceneCapture", "SceneCustom", "SceneSimilar", "SceneStore", "TAG", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "report", "", "action", "setSceneFromType", "type", "plugin-emojisdk_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiPopupReport";
  private static final y gra;
  public static final d grb;
  
  static
  {
    AppMethodBeat.i(183966);
    grb = new d();
    TAG = "MicroMsg.EmojiPopupReport";
    gra = new y();
    AppMethodBeat.o(183966);
  }
  
  public static y ago()
  {
    return gra;
  }
  
  public static void md(int paramInt)
  {
    AppMethodBeat.i(183964);
    gra.im(paramInt);
    gra.aLH();
    AppMethodBeat.o(183964);
  }
  
  public static void mi(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(183965);
    y localy = gra;
    int i = j;
    switch (paramInt)
    {
    default: 
      ae.e(TAG, "type scene mismatch");
      i = j;
    }
    for (;;)
    {
      localy.in(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */