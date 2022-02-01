package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.df;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends df
{
  protected static c.a info;
  public List<Long> fOh;
  
  static
  {
    AppMethodBeat.i(182138);
    c.a locala = new c.a();
    locala.IBL = new Field[16];
    locala.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "todoid";
    locala.IBN.put("todoid", "TEXT");
    localStringBuilder.append(" todoid TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "roomname";
    locala.IBN.put("roomname", "TEXT");
    localStringBuilder.append(" roomname TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "path";
    locala.IBN.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "createtime";
    locala.IBN.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "updatetime";
    locala.IBN.put("updatetime", "LONG");
    localStringBuilder.append(" updatetime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "custominfo";
    locala.IBN.put("custominfo", "TEXT default '' ");
    localStringBuilder.append(" custominfo TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "title";
    locala.IBN.put("title", "TEXT default '' ");
    localStringBuilder.append(" title TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "creator";
    locala.IBN.put("creator", "TEXT");
    localStringBuilder.append(" creator TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "related_msgids";
    locala.IBN.put("related_msgids", "TEXT");
    localStringBuilder.append(" related_msgids TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "manager";
    locala.IBN.put("manager", "TEXT");
    localStringBuilder.append(" manager TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "nreply";
    locala.IBN.put("nreply", "INTEGER");
    localStringBuilder.append(" nreply INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "state";
    locala.IBN.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "netSceneState";
    locala.IBN.put("netSceneState", "INTEGER");
    localStringBuilder.append(" netSceneState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "shareKey";
    locala.IBN.put("shareKey", "TEXT");
    localStringBuilder.append(" shareKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "shareName";
    locala.IBN.put("shareName", "TEXT");
    localStringBuilder.append(" shareName TEXT");
    locala.columns[16] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(182138);
  }
  
  public c()
  {
    AppMethodBeat.i(182132);
    this.fOh = new ArrayList();
    AppMethodBeat.o(182132);
  }
  
  public final long Yx()
  {
    AppMethodBeat.i(182135);
    if (this.fOh.size() > 0)
    {
      long l = ((Long)this.fOh.get(0)).longValue();
      AppMethodBeat.o(182135);
      return l;
    }
    AppMethodBeat.o(182135);
    return 0L;
  }
  
  public final boolean Yy()
  {
    AppMethodBeat.i(182136);
    boolean bool = bu.lX("roomannouncement@app.origin", this.field_username);
    AppMethodBeat.o(182136);
    return bool;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(182133);
    super.convertFrom(paramCursor);
    this.fOh.clear();
    if (!bu.isNullOrNil(this.field_related_msgids))
    {
      paramCursor = this.field_related_msgids.split(",");
      int j = paramCursor.length;
      int i = 0;
      while (i < j)
      {
        String str = paramCursor[i];
        this.fOh.add(Long.valueOf(Long.parseLong(str)));
        i += 1;
      }
    }
    AppMethodBeat.o(182133);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182134);
    paramObject = (c)paramObject;
    if ((bu.lX(paramObject.field_todoid, this.field_todoid)) && (bu.lX(paramObject.field_roomname, this.field_roomname)))
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
  
  public final void qZ(long paramLong)
  {
    AppMethodBeat.i(217140);
    if (!this.fOh.contains(Long.valueOf(paramLong)))
    {
      this.fOh.add(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.fOh.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",");
      }
      if (localStringBuilder.length() - 1 >= 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      this.field_related_msgids = localStringBuilder.toString();
    }
    AppMethodBeat.o(217140);
  }
  
  public final boolean ra(long paramLong)
  {
    AppMethodBeat.i(182137);
    if (this.fOh.contains(Long.valueOf(paramLong)))
    {
      this.fOh.remove(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.fOh.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",");
      }
      if (localStringBuilder.length() - 1 >= 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      this.field_related_msgids = localStringBuilder.toString();
    }
    if (this.fOh.size() == 0)
    {
      AppMethodBeat.o(182137);
      return true;
    }
    AppMethodBeat.o(182137);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.c
 * JD-Core Version:    0.7.0.1
 */