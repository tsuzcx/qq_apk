package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fe;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class t
  extends fe
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(65223);
    info = fe.aJm();
    AppMethodBeat.o(65223);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.t
 * JD-Core Version:    0.7.0.1
 */