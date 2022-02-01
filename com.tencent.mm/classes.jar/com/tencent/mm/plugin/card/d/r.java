package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum r
{
  public int scene;
  
  static
  {
    AppMethodBeat.i(113873);
    oPL = new r("EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND", 0, 1);
    oPM = new r("EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD", 1, 2);
    oPN = new r("EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL", 2, 3);
    oPO = new r[] { oPL, oPM, oPN };
    AppMethodBeat.o(113873);
  }
  
  private r(int paramInt)
  {
    this.scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.r
 * JD-Core Version:    0.7.0.1
 */