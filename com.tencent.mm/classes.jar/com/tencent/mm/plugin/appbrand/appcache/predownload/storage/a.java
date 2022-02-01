package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends gl
{
  static final IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(44432);
    nVV = gl.aJm();
    AppMethodBeat.o(44432);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(44431);
    String str = "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
    AppMethodBeat.o(44431);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.a
 * JD-Core Version:    0.7.0.1
 */