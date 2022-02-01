package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeRequiredType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Required", "Optional", "Common", "plugin-hld_release"})
public enum l
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(214798);
    l locall1 = new l("Required", 0, 1);
    DDO = locall1;
    l locall2 = new l("Optional", 1, 2);
    DDP = locall2;
    l locall3 = new l("Common", 2, 3);
    DDQ = locall3;
    DDR = new l[] { locall1, locall2, locall3 };
    AppMethodBeat.o(214798);
  }
  
  private l(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.l
 * JD-Core Version:    0.7.0.1
 */