package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  extends ct
{
  protected static c.a info;
  public List<Long> fpJ;
  
  static
  {
    AppMethodBeat.i(182138);
    c.a locala = new c.a();
    locala.EYt = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "todoid";
    locala.EYv.put("todoid", "TEXT");
    localStringBuilder.append(" todoid TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "roomname";
    locala.EYv.put("roomname", "TEXT");
    localStringBuilder.append(" roomname TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.EYv.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "path";
    locala.EYv.put("path", "TEXT default '小程序字段' ");
    localStringBuilder.append(" path TEXT default '小程序字段' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "createtime";
    locala.EYv.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "updatetime";
    locala.EYv.put("updatetime", "LONG");
    localStringBuilder.append(" updatetime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "custominfo";
    locala.EYv.put("custominfo", "TEXT default '' ");
    localStringBuilder.append(" custominfo TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "title";
    locala.EYv.put("title", "TEXT default '' ");
    localStringBuilder.append(" title TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "creator";
    locala.EYv.put("creator", "TEXT default '创建者username' ");
    localStringBuilder.append(" creator TEXT default '创建者username' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "related_msgids";
    locala.EYv.put("related_msgids", "TEXT");
    localStringBuilder.append(" related_msgids TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "manager";
    locala.EYv.put("manager", "TEXT default '管理员username' ");
    localStringBuilder.append(" manager TEXT default '管理员username' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "nreply";
    locala.EYv.put("nreply", "INTEGER default '完成人数' ");
    localStringBuilder.append(" nreply INTEGER default '完成人数' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "state";
    locala.EYv.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "netSceneState";
    locala.EYv.put("netSceneState", "INTEGER");
    localStringBuilder.append(" netSceneState INTEGER");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(182138);
  }
  
  public a()
  {
    AppMethodBeat.i(182132);
    this.fpJ = new ArrayList();
    AppMethodBeat.o(182132);
  }
  
  public final long UX()
  {
    AppMethodBeat.i(182135);
    if (this.fpJ.size() > 0)
    {
      long l = ((Long)this.fpJ.get(0)).longValue();
      AppMethodBeat.o(182135);
      return l;
    }
    AppMethodBeat.o(182135);
    return 0L;
  }
  
  public final boolean UY()
  {
    AppMethodBeat.i(182136);
    boolean bool = bt.kU("roomannouncement@app.origin", this.field_username);
    AppMethodBeat.o(182136);
    return bool;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(182133);
    super.convertFrom(paramCursor);
    this.fpJ.clear();
    if (!bt.isNullOrNil(this.field_related_msgids))
    {
      paramCursor = this.field_related_msgids.split(",");
      int j = paramCursor.length;
      int i = 0;
      while (i < j)
      {
        String str = paramCursor[i];
        this.fpJ.add(Long.valueOf(Long.parseLong(str)));
        i += 1;
      }
    }
    AppMethodBeat.o(182133);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182134);
    paramObject = (a)paramObject;
    if ((bt.kU(paramObject.field_todoid, this.field_todoid)) && (bt.kU(paramObject.field_roomname, this.field_roomname)))
    {
      AppMethodBeat.o(182134);
      return true;
    }
    AppMethodBeat.o(182134);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean lk(long paramLong)
  {
    AppMethodBeat.i(182137);
    if (this.fpJ.contains(Long.valueOf(paramLong)))
    {
      this.fpJ.remove(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.fpJ.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",");
      }
      if (localStringBuilder.length() - 1 >= 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      this.field_related_msgids = localStringBuilder.toString();
    }
    if (this.fpJ.size() == 0)
    {
      AppMethodBeat.o(182137);
      return true;
    }
    AppMethodBeat.o(182137);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.a
 * JD-Core Version:    0.7.0.1
 */