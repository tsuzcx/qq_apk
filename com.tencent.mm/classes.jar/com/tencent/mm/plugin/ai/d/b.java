package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.h;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class b
  extends h
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(267379);
    info = h.aJm();
    AppMethodBeat.o(267379);
  }
  
  public b() {}
  
  public b(String paramString)
  {
    this.field_tipsId = paramString;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(267396);
    String str = "AiFinderRedDotInfo{field_tipsId='" + this.field_tipsId + '\'' + ", field_ds=" + this.field_ds + ", field_ctrlType=" + this.field_ctrlType + ", field_showType=" + this.field_showType + ", field_path='" + this.field_path + '\'' + ", field_scene=" + this.field_scene + ", field_urlHash=" + this.field_urlHash + ", field_receTimeMs=" + this.field_receTimeMs + ", field_exposeCount=" + this.field_exposeCount + ", field_exposeDuration=" + this.field_exposeDuration + ", field_exposeFirstMs=" + this.field_exposeFirstMs + ", field_exposeLastMs=" + this.field_exposeLastMs + ", field_enterBusinessMs=" + this.field_enterBusinessMs + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(267396);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.b
 * JD-Core Version:    0.7.0.1
 */