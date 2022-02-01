package com.tencent.mm.plugin.card.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum r
{
  public int scene;
  
  static
  {
    AppMethodBeat.i(113873);
    wKE = new r("EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND", 0, 1);
    wKF = new r("EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD", 1, 2);
    wKG = new r("EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL", 2, 3);
    wKH = new r[] { wKE, wKF, wKG };
    AppMethodBeat.o(113873);
  }
  
  private r(int paramInt)
  {
    this.scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.r
 * JD-Core Version:    0.7.0.1
 */