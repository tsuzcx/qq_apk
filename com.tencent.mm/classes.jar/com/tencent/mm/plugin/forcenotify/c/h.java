package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dg;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.au;

public final class h
  extends dg
{
  public static IAutoDBItem.MAutoDBInfo info;
  public au contact = null;
  
  static
  {
    AppMethodBeat.i(149136);
    info = dg.aJm();
    AppMethodBeat.o(149136);
  }
  
  public final boolean dgl()
  {
    AppMethodBeat.i(149134);
    if (cn.bDu() >= this.field_ExpiredTime)
    {
      AppMethodBeat.o(149134);
      return true;
    }
    AppMethodBeat.o(149134);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean isEnable()
  {
    return this.field_Status == 1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149135);
    String str = this.field_ForcePushId + " " + this.field_UserName + " " + this.field_CreateTime + " " + this.field_ExpiredTime + " " + this.field_Status;
    AppMethodBeat.o(149135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.h
 * JD-Core Version:    0.7.0.1
 */