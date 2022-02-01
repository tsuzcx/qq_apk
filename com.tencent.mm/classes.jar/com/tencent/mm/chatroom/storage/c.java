package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.dp;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends dp
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public List<Long> iXE;
  
  static
  {
    AppMethodBeat.i(182138);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[16];
    localMAutoDBInfo.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "todoid";
    localMAutoDBInfo.colsMap.put("todoid", "TEXT");
    localStringBuilder.append(" todoid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "roomname";
    localMAutoDBInfo.colsMap.put("roomname", "TEXT");
    localStringBuilder.append(" roomname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updatetime";
    localMAutoDBInfo.colsMap.put("updatetime", "LONG");
    localStringBuilder.append(" updatetime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "custominfo";
    localMAutoDBInfo.colsMap.put("custominfo", "TEXT default '' ");
    localStringBuilder.append(" custominfo TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT default '' ");
    localStringBuilder.append(" title TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "creator";
    localMAutoDBInfo.colsMap.put("creator", "TEXT");
    localStringBuilder.append(" creator TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "related_msgids";
    localMAutoDBInfo.colsMap.put("related_msgids", "TEXT");
    localStringBuilder.append(" related_msgids TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "manager";
    localMAutoDBInfo.colsMap.put("manager", "TEXT");
    localStringBuilder.append(" manager TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "nreply";
    localMAutoDBInfo.colsMap.put("nreply", "INTEGER");
    localStringBuilder.append(" nreply INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "netSceneState";
    localMAutoDBInfo.colsMap.put("netSceneState", "INTEGER");
    localStringBuilder.append(" netSceneState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "shareKey";
    localMAutoDBInfo.colsMap.put("shareKey", "TEXT");
    localStringBuilder.append(" shareKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "shareName";
    localMAutoDBInfo.colsMap.put("shareName", "TEXT");
    localStringBuilder.append(" shareName TEXT");
    localMAutoDBInfo.columns[16] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(182138);
  }
  
  public c()
  {
    AppMethodBeat.i(182132);
    this.iXE = new ArrayList();
    AppMethodBeat.o(182132);
  }
  
  public final void ET(long paramLong)
  {
    AppMethodBeat.i(189484);
    if (!this.iXE.contains(Long.valueOf(paramLong)))
    {
      this.iXE.add(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.iXE.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",");
      }
      if (localStringBuilder.length() - 1 >= 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      this.field_related_msgids = localStringBuilder.toString();
    }
    AppMethodBeat.o(189484);
  }
  
  public final boolean EU(long paramLong)
  {
    AppMethodBeat.i(182137);
    if (this.iXE.contains(Long.valueOf(paramLong)))
    {
      this.iXE.remove(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.iXE.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",");
      }
      if (localStringBuilder.length() - 1 >= 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      this.field_related_msgids = localStringBuilder.toString();
    }
    if (this.iXE.size() == 0)
    {
      AppMethodBeat.o(182137);
      return true;
    }
    AppMethodBeat.o(182137);
    return false;
  }
  
  public final long asl()
  {
    AppMethodBeat.i(182135);
    if (this.iXE.size() > 0)
    {
      long l = ((Long)this.iXE.get(0)).longValue();
      AppMethodBeat.o(182135);
      return l;
    }
    AppMethodBeat.o(182135);
    return 0L;
  }
  
  public final boolean asm()
  {
    AppMethodBeat.i(182136);
    boolean bool = Util.isEqual("roomannouncement@app.origin", this.field_username);
    AppMethodBeat.o(182136);
    return bool;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(182133);
    super.convertFrom(paramCursor);
    this.iXE.clear();
    if (!Util.isNullOrNil(this.field_related_msgids))
    {
      paramCursor = this.field_related_msgids.split(",");
      int j = paramCursor.length;
      int i = 0;
      while (i < j)
      {
        String str = paramCursor[i];
        this.iXE.add(Long.valueOf(Long.parseLong(str)));
        i += 1;
      }
    }
    AppMethodBeat.o(182133);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182134);
    paramObject = (c)paramObject;
    if ((Util.isEqual(paramObject.field_todoid, this.field_todoid)) && (Util.isEqual(paramObject.field_roomname, this.field_roomname)))
    {
      AppMethodBeat.o(182134);
      return true;
    }
    AppMethodBeat.o(182134);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.c
 * JD-Core Version:    0.7.0.1
 */