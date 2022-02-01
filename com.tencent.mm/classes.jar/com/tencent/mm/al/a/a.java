package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.af;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends af
{
  public static final int hUe;
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(124174);
    hUe = j.hVa.hVd;
    c.a locala = new c.a();
    locala.IBL = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatId";
    locala.IBN.put("bizChatId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "bizChatId";
    locala.columns[1] = "brandUserName";
    locala.IBN.put("brandUserName", "TEXT");
    localStringBuilder.append(" brandUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "unReadCount";
    locala.IBN.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newUnReadCount";
    locala.IBN.put("newUnReadCount", "INTEGER");
    localStringBuilder.append(" newUnReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastMsgID";
    locala.IBN.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "lastMsgTime";
    locala.IBN.put("lastMsgTime", "LONG");
    localStringBuilder.append(" lastMsgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.IBN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "digest";
    locala.IBN.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "digestUser";
    locala.IBN.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "atCount";
    locala.IBN.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "editingMsg";
    locala.IBN.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatType";
    locala.IBN.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.IBN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "isSend";
    locala.IBN.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "msgType";
    locala.IBN.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "msgCount";
    locala.IBN.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "flag";
    locala.IBN.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "atAll";
    locala.IBN.put("atAll", "INTEGER default '0' ");
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
    private final int dEu;
    
    static
    {
      AppMethodBeat.i(188897);
      hUf = new a("ALL", 0, 2);
      hUg = new a("DEPARTMENT", 1, 32);
      hUh = new a("EXTERNAL", 2, 128);
      hUi = new a("NORMAL", 3, 0);
      hUj = new a[] { hUf, hUg, hUh, hUi };
      AppMethodBeat.o(188897);
    }
    
    private a(int paramInt)
    {
      this.dEu = paramInt;
    }
    
    public static a pc(int paramInt)
    {
      AppMethodBeat.i(188896);
      Object localObject = values();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        a locala = localObject[i];
        if ((locala.dEu & paramInt) != 0) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(188896);
          return locala;
        }
        i += 1;
      }
      localObject = hUi;
      AppMethodBeat.o(188896);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.a
 * JD-Core Version:    0.7.0.1
 */