package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q
{
  public int scene;
  
  static
  {
    AppMethodBeat.i(88945);
    kCs = new q("EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND", 0, 1);
    kCt = new q("EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD", 1, 2);
    kCu = new q("EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL", 2, 3);
    kCv = new q[] { kCs, kCt, kCu };
    AppMethodBeat.o(88945);
  }
  
  private q(int paramInt)
  {
    this.scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.q
 * JD-Core Version:    0.7.0.1
 */