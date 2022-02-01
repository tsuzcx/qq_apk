package com.tencent.mm.plugin.expt.edge.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends bj
{
  public static IAutoDBItem.MAutoDBInfo info;
  public String data;
  public String zzS;
  public long zzT;
  
  static
  {
    AppMethodBeat.i(299639);
    info = bj.aJm();
    AppMethodBeat.o(299639);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(299647);
    String str = "EdgeComputingCacheDataModel{, reportTimeEC=" + this.zzT + ", configID=" + this.zzS + ", data='" + this.data + '\'' + '}';
    AppMethodBeat.o(299647);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.e.a
 * JD-Core Version:    0.7.0.1
 */