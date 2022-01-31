package com.tencent.mm.plugin.h.b;

import android.database.Cursor;
import com.tencent.mm.h.c.fi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fi
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.ujN.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "username";
    locala.ujN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgType";
    locala.ujN.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgSubType";
    locala.ujN.put("msgSubType", "INTEGER");
    localStringBuilder.append(" msgSubType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "path";
    locala.ujN.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "size";
    locala.ujN.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "msgtime";
    locala.ujN.put("msgtime", "LONG");
    localStringBuilder.append(" msgtime LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    return "{  sys row id: " + this.ujK + " msg id : " + this.field_msgId + " msg talker: " + this.field_username + " msg type : " + this.field_msgType + " msg sub type : " + this.field_msgSubType + " path : " + this.field_path + " size : " + this.field_size + " msgtime : " + this.field_msgtime + " } ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.a
 * JD-Core Version:    0.7.0.1
 */