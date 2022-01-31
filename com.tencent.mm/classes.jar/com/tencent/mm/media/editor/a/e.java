package com.tencent.mm.media.editor.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/EditorDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "EMOJI", "LOCATION", "TIP", "LYRICS", "plugin-mediaeditor_release"})
public enum e
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(12880);
    e locale1 = new e("TEXT", 0, 1);
    eSC = locale1;
    e locale2 = new e("EMOJI", 1, 2);
    eSD = locale2;
    e locale3 = new e("LOCATION", 2, 3);
    eSE = locale3;
    e locale4 = new e("TIP", 3, 4);
    eSF = locale4;
    e locale5 = new e("LYRICS", 4, 5);
    eSG = locale5;
    eSH = new e[] { locale1, locale2, locale3, locale4, locale5 };
    AppMethodBeat.o(12880);
  }
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.e
 * JD-Core Version:    0.7.0.1
 */