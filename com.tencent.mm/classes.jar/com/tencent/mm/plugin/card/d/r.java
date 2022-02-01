package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum r
{
  public int scene;
  
  static
  {
    AppMethodBeat.i(113873);
    qlh = new r("EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND", 0, 1);
    qli = new r("EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD", 1, 2);
    qlj = new r("EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL", 2, 3);
    qlk = new r[] { qlh, qli, qlj };
    AppMethodBeat.o(113873);
  }
  
  private r(int paramInt)
  {
    this.scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.r
 * JD-Core Version:    0.7.0.1
 */