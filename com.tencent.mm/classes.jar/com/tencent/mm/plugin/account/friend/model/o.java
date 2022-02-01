package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fs;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class o
  extends fs
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(184421);
    info = fs.aJm();
    AppMethodBeat.o(184421);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.o
 * JD-Core Version:    0.7.0.1
 */