package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeDeviceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "General", "Android", "IOS", "plugin-hld_release"})
public enum e
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(211161);
    e locale1 = new e("General", 0, 0);
    DBE = locale1;
    e locale2 = new e("Android", 1, 1);
    DBF = locale2;
    e locale3 = new e("IOS", 2, 2);
    DBG = locale3;
    DBH = new e[] { locale1, locale2, locale3 };
    AppMethodBeat.o(211161);
  }
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.e
 * JD-Core Version:    0.7.0.1
 */