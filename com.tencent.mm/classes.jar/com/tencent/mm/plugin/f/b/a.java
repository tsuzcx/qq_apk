package com.tencent.mm.plugin.f.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends gv
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(22738);
    c.a locala = new c.a();
    locala.EYt = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.EYv.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "username";
    locala.EYv.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgType";
    locala.EYv.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgSubType";
    locala.EYv.put("msgSubType", "INTEGER");
    localStringBuilder.append(" msgSubType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "path";
    locala.EYv.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "size";
    locala.EYv.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "msgtime";
    locala.EYv.put("msgtime", "LONG");
    localStringBuilder.append(" msgtime LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(22738);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(22736);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(22736);
  }
  
  public final c.a getDBInfo()
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
 * Qualified Name:     com.tencent.mm.plugin.f.b.a
 * JD-Core Version:    0.7.0.1
 */