package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ACCOUNT_TYPE_NORMAL", "ACCOUNT_TYPE_KIDS", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(262283);
    JSZ = new a("ACCOUNT_TYPE_NORMAL", 0, 0);
    JTa = new a("ACCOUNT_TYPE_KIDS", 1, 1);
    JTb = new a[] { JSZ, JTa };
    AppMethodBeat.o(262283);
  }
  
  private b$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.b.a
 * JD-Core Version:    0.7.0.1
 */