package com.tencent.mm.media.editor.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/EditorDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "EMOJI", "LOCATION", "TIP", "LYRICS", "plugin-mediaeditor_release"})
public enum e
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(93564);
    e locale1 = new e("TEXT", 0, 1);
    gPo = locale1;
    e locale2 = new e("EMOJI", 1, 2);
    gPp = locale2;
    e locale3 = new e("LOCATION", 2, 3);
    gPq = locale3;
    e locale4 = new e("TIP", 3, 4);
    gPr = locale4;
    e locale5 = new e("LYRICS", 4, 5);
    gPs = locale5;
    gPt = new e[] { locale1, locale2, locale3, locale4, locale5 };
    AppMethodBeat.o(93564);
  }
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.e
 * JD-Core Version:    0.7.0.1
 */