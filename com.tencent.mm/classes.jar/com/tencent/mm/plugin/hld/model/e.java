package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeDeviceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "General", "Android", "IOS", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum e
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(311901);
    JuD = new e("General", 0, 0);
    JuE = new e("Android", 1, 1);
    JuF = new e("IOS", 2, 2);
    JuG = new e[] { JuD, JuE, JuF };
    AppMethodBeat.o(311901);
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