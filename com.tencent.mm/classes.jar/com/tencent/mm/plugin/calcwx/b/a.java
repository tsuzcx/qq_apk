package com.tencent.mm.plugin.calcwx.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ja;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends ja
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(22738);
    info = ja.aJm();
    AppMethodBeat.o(22738);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(22736);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(22736);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(22737);
    String str = "{  sys row id: " + this.systemRowid + " msg id : " + this.field_msgId + " msg talker: " + this.field_username + " msg type : " + this.field_msgType + " msg sub type : " + this.field_msgSubType + " path : " + this.field_path + " size : " + this.field_size + " msgtime : " + this.field_msgtime + " } ";
    AppMethodBeat.o(22737);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.b.a
 * JD-Core Version:    0.7.0.1
 */