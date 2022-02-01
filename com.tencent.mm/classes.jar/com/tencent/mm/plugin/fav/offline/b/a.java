package com.tencent.mm.plugin.fav.offline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cc;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends cc
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public boolean Afr = true;
  
  static
  {
    AppMethodBeat.i(73565);
    info = cc.aJm();
    AppMethodBeat.o(73565);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(73564);
    String str = "FavOffline{isMustWifi=" + this.Afr + ", field_url='" + this.field_url + '\'' + ", field_size=" + this.field_size + ", field_path='" + this.field_path + '\'' + ", field_imgDirPath='" + this.field_imgDirPath + '\'' + ", field_imgPaths='" + this.field_imgPaths + '\'' + ", field_favTime=" + this.field_favTime + ", field_updateTime=" + this.field_updateTime + ", field_status=" + this.field_status + ", field_failNum=" + this.field_failNum + ", field_isReport=" + this.field_isReport + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(73564);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.b.a
 * JD-Core Version:    0.7.0.1
 */