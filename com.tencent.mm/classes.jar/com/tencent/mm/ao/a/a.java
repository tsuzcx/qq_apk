package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ag;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ag
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public static final int lFH;
  
  static
  {
    AppMethodBeat.i(124174);
    lFH = j.lGD.lGG;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bizChatId";
    localMAutoDBInfo.colsMap.put("bizChatId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bizChatId";
    localMAutoDBInfo.columns[1] = "brandUserName";
    localMAutoDBInfo.colsMap.put("brandUserName", "TEXT");
    localStringBuilder.append(" brandUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "newUnReadCount";
    localMAutoDBInfo.colsMap.put("newUnReadCount", "INTEGER");
    localStringBuilder.append(" newUnReadCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "lastMsgID";
    localMAutoDBInfo.colsMap.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "lastMsgTime";
    localMAutoDBInfo.colsMap.put("lastMsgTime", "LONG");
    localStringBuilder.append(" lastMsgTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "digest";
    localMAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "digestUser";
    localMAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "atCount";
    localMAutoDBInfo.colsMap.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "editingMsg";
    localMAutoDBInfo.colsMap.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "chatType";
    localMAutoDBInfo.colsMap.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "msgCount";
    localMAutoDBInfo.colsMap.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "atAll";
    localMAutoDBInfo.colsMap.put("atAll", "INTEGER default '0' ");
    localStringBuilder.append(" atAll INTEGER default '0' ");
    localMAutoDBInfo.columns[18] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(124174);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public static enum a
  {
    private final int cUP;
    
    static
    {
      AppMethodBeat.i(205967);
      lFI = new a("ALL", 0, 2);
      lFJ = new a("DEPARTMENT", 1, 32);
      lFK = new a("EXTERNAL", 2, 128);
      lFL = new a("NORMAL", 3, 0);
      lFM = new a[] { lFI, lFJ, lFK, lFL };
      AppMethodBeat.o(205967);
    }
    
    private a(int paramInt)
    {
      this.cUP = paramInt;
    }
    
    public static a vO(int paramInt)
    {
      AppMethodBeat.i(205966);
      Object localObject = values();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        a locala = localObject[i];
        if ((locala.cUP & paramInt) != 0) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(205966);
          return locala;
        }
        i += 1;
      }
      localObject = lFL;
      AppMethodBeat.o(205966);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.a.a
 * JD-Core Version:    0.7.0.1
 */