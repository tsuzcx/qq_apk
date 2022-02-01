package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/GetImeDictListConfigStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "GetImeDictListConfigStatusSucc", "GetImeDictListConfigStatusRecommendationFail", "GetImeDictListConfigStatusLogicsvrFail", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(311883);
    Juf = new a("GetImeDictListConfigStatusSucc", 0, 0);
    Jug = new a("GetImeDictListConfigStatusRecommendationFail", 1, 1);
    Juh = new a("GetImeDictListConfigStatusLogicsvrFail", 2, 2);
    Jui = new a[] { Juf, Jug, Juh };
    AppMethodBeat.o(311883);
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