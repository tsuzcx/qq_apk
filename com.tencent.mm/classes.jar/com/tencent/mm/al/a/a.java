package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.af;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends af
{
  public static final int hyS;
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(124174);
    hyS = j.hzN.hzQ;
    c.a locala = new c.a();
    locala.GvF = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatId";
    locala.GvH.put("bizChatId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "bizChatId";
    locala.columns[1] = "brandUserName";
    locala.GvH.put("brandUserName", "TEXT");
    localStringBuilder.append(" brandUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "unReadCount";
    locala.GvH.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newUnReadCount";
    locala.GvH.put("newUnReadCount", "INTEGER");
    localStringBuilder.append(" newUnReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastMsgID";
    locala.GvH.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "lastMsgTime";
    locala.GvH.put("lastMsgTime", "LONG");
    localStringBuilder.append(" lastMsgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.GvH.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "digest";
    locala.GvH.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "digestUser";
    locala.GvH.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "atCount";
    locala.GvH.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "editingMsg";
    locala.GvH.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatType";
    locala.GvH.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.GvH.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "isSend";
    locala.GvH.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "msgType";
    locala.GvH.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "msgCount";
    locala.GvH.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "flag";
    locala.GvH.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "atAll";
    locala.GvH.put("atAll", "INTEGER default '0' ");
    localStringBuilder.append(" atAll INTEGER default '0' ");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124174);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public static enum a
  {
    private final int drx;
    
    static
    {
      AppMethodBeat.i(209548);
      hyT = new a("ALL", 0, 2);
      hyU = new a("DEPARTMENT", 1, 32);
      hyV = new a("EXTERNAL", 2, 128);
      hyW = new a("NORMAL", 3, 0);
      hyX = new a[] { hyT, hyU, hyV, hyW };
      AppMethodBeat.o(209548);
    }
    
    private a(int paramInt)
    {
      this.drx = paramInt;
    }
    
    public static a oy(int paramInt)
    {
      AppMethodBeat.i(209547);
      Object localObject = values();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        a locala = localObject[i];
        if ((locala.drx & paramInt) != 0) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(209547);
          return locala;
        }
        i += 1;
      }
      localObject = hyW;
      AppMethodBeat.o(209547);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.a
 * JD-Core Version:    0.7.0.1
 */