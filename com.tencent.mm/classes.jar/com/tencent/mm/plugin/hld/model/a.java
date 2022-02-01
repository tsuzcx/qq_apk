package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/GetImeDictListConfigStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "GetImeDictListConfigStatusSucc", "GetImeDictListConfigStatusRecommendationFail", "GetImeDictListConfigStatusLogicsvrFail", "plugin-hld_release"})
public enum a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(213993);
    a locala1 = new a("GetImeDictListConfigStatusSucc", 0, 0);
    DBg = locala1;
    a locala2 = new a("GetImeDictListConfigStatusRecommendationFail", 1, 1);
    DBh = locala2;
    a locala3 = new a("GetImeDictListConfigStatusLogicsvrFail", 2, 2);
    DBi = locala3;
    DBj = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(213993);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.a
 * JD-Core Version:    0.7.0.1
 */