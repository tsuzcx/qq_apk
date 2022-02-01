package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ACCOUNT_TYPE_NORMAL", "ACCOUNT_TYPE_KIDS", "plugin-kidswatch_release"})
public enum c$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(256182);
    a locala1 = new a("ACCOUNT_TYPE_NORMAL", 0, 0);
    yAG = locala1;
    a locala2 = new a("ACCOUNT_TYPE_KIDS", 1, 1);
    yAH = locala2;
    yAI = new a[] { locala1, locala2 };
    AppMethodBeat.o(256182);
  }
  
  private c$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.c.a
 * JD-Core Version:    0.7.0.1
 */