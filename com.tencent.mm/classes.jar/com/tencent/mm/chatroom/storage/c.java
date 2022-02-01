package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends cw
{
  protected static c.a info;
  public LinkedList<GroupToolItem> ftp;
  public LinkedList<GroupToolItem> ftq;
  
  static
  {
    AppMethodBeat.i(182159);
    c.a locala = new c.a();
    locala.GvF = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.GvH.put("chatroomname", "TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "chatroomname";
    locala.columns[1] = "stickToollist";
    locala.GvH.put("stickToollist", "TEXT");
    localStringBuilder.append(" stickToollist TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "recentUseToolList";
    locala.GvH.put("recentUseToolList", "TEXT");
    localStringBuilder.append(" recentUseToolList TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "queryState";
    locala.GvH.put("queryState", "INTEGER");
    localStringBuilder.append(" queryState INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(182159);
  }
  
  public c()
  {
    AppMethodBeat.i(182154);
    this.ftp = new LinkedList();
    this.ftq = new LinkedList();
    this.field_queryState = 0;
    AppMethodBeat.o(182154);
  }
  
  public static String O(List<GroupToolItem> paramList)
  {
    AppMethodBeat.i(182158);
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupToolItem localGroupToolItem = (GroupToolItem)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("username", localGroupToolItem.username);
        localJSONObject.put("path", localGroupToolItem.path);
        localJSONObject.put("updateTime", localGroupToolItem.fto);
        localJSONArray.put(localJSONObject);
      }
      return paramList;
    }
    catch (JSONException paramList)
    {
      ac.e("MicroMsg.roomtools.GroupTools", "getToolsJsonStr() Exception:%s", new Object[] { paramList.getMessage() });
      paramList = localJSONArray.toString();
      AppMethodBeat.o(182158);
    }
  }
  
  public final boolean VY()
  {
    AppMethodBeat.i(182157);
    if (this.ftp.size() >= 8)
    {
      AppMethodBeat.o(182157);
      return true;
    }
    AppMethodBeat.o(182157);
    return false;
  }
  
  public final void b(GroupToolItem paramGroupToolItem)
  {
    AppMethodBeat.i(210020);
    if (this.ftq.contains(paramGroupToolItem)) {
      this.ftq.remove(paramGroupToolItem);
    }
    this.ftq.add(paramGroupToolItem);
    Collections.sort(this.ftq, new Comparator() {});
    if (this.ftq.size() > 20) {
      this.ftq.remove(this.ftq.size() - 1);
    }
    this.field_recentUseToolList = O(this.ftq);
    AppMethodBeat.o(210020);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(182155);
    super.convertFrom(paramCursor);
    this.ftp.clear();
    int j;
    int i;
    JSONObject localJSONObject;
    GroupToolItem localGroupToolItem;
    if (!bs.isNullOrNil(this.field_stickToollist)) {
      try
      {
        paramCursor = new JSONArray(this.field_stickToollist);
        j = paramCursor.length();
        i = 0;
        while (i < j)
        {
          localJSONObject = new JSONObject(paramCursor.getString(i));
          localGroupToolItem = new GroupToolItem();
          localGroupToolItem.username = bs.bG(localJSONObject.getString("username"), "");
          localGroupToolItem.path = bs.bG(localJSONObject.getString("path"), "");
          this.ftp.add(localGroupToolItem);
          i += 1;
        }
        this.ftq.clear();
      }
      catch (Exception paramCursor)
      {
        ac.e("MicroMsg.roomtools.GroupTools", "parseStickTools() Exception:%s", new Object[] { paramCursor.getMessage() });
      }
    }
    if (!bs.isNullOrNil(this.field_recentUseToolList)) {
      try
      {
        paramCursor = new JSONArray(this.field_recentUseToolList);
        j = paramCursor.length();
        i = 0;
        while (i < j)
        {
          localJSONObject = new JSONObject(paramCursor.getString(i));
          localGroupToolItem = new GroupToolItem();
          localGroupToolItem.username = bs.bG(localJSONObject.getString("username"), "");
          localGroupToolItem.path = bs.bG(localJSONObject.getString("path"), "");
          localGroupToolItem.fto = localJSONObject.getLong("updateTime");
          this.ftq.add(localGroupToolItem);
          i += 1;
        }
        AppMethodBeat.o(182155);
        return;
      }
      catch (Exception paramCursor)
      {
        ac.e("MicroMsg.roomtools.GroupTools", "parseRecentUseTools() Exception:%s", new Object[] { paramCursor.getMessage() });
      }
    }
    AppMethodBeat.o(182155);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182156);
    if (bs.lr(((c)paramObject).field_chatroomname, this.field_chatroomname))
    {
      AppMethodBeat.o(182156);
      return true;
    }
    AppMethodBeat.o(182156);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.c
 * JD-Core Version:    0.7.0.1
 */