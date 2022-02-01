package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.db;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class f
  extends db
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(267372);
    info = db.aJm();
    AppMethodBeat.o(267372);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(267388);
    String str = "FinderRedDotHistory{field_ds=" + this.field_ds + ", field_hour=" + this.field_hour + ", field_actionMs=" + this.field_actionMs + ", field_isGoToFinderUI=" + this.field_isGoToFinderUI + ", field_hadFinderRedDot=" + this.field_hadFinderRedDot + ", field_hadFinderLiveRedDot=" + this.field_hadFinderLiveRedDot + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(267388);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.f
 * JD-Core Version:    0.7.0.1
 */