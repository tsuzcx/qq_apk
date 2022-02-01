package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/report/EmojiPopupReport;", "", "()V", "ActionAddInDetail", "", "ActionDelete", "ActionDeleteConfirm", "ActionLongClick", "ActionTop", "ActionViewDetail", "SceneCapture", "SceneCustom", "SceneSimilar", "SceneStore", "TAG", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonFastManagementStruct;", "report", "", "action", "setSceneFromType", "type", "plugin-emojisdk_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiPopupReport";
  private static final t fRh;
  public static final d fRi;
  
  static
  {
    AppMethodBeat.i(183966);
    fRi = new d();
    TAG = "MicroMsg.EmojiPopupReport";
    fRh = new t();
    AppMethodBeat.o(183966);
  }
  
  public static t aco()
  {
    return fRh;
  }
  
  public static void lI(int paramInt)
  {
    AppMethodBeat.i(183964);
    fRh.ip(paramInt);
    fRh.aBj();
    AppMethodBeat.o(183964);
  }
  
  public static void lJ(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(183965);
    t localt = fRh;
    int i = j;
    switch (paramInt)
    {
    default: 
      ad.e(TAG, "type scene mismatch");
      i = j;
    }
    for (;;)
    {
      localt.iq(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */