package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends cu
{
  protected static c.a info;
  public LinkedList<GroupToolItem> fpM;
  public LinkedList<GroupToolItem> fpN;
  
  static
  {
    AppMethodBeat.i(182159);
    c.a locala = new c.a();
    locala.EYt = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.EYv.put("chatroomname", "TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "chatroomname";
    locala.columns[1] = "stickToollist";
    locala.EYv.put("stickToollist", "TEXT");
    localStringBuilder.append(" stickToollist TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "recentUseToolList";
    locala.EYv.put("recentUseToolList", "TEXT");
    localStringBuilder.append(" recentUseToolList TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "queryState";
    locala.EYv.put("queryState", "INTEGER");
    localStringBuilder.append(" queryState INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(182159);
  }
  
  public c()
  {
    AppMethodBeat.i(182154);
    this.fpM = new LinkedList();
    this.fpN = new LinkedList();
    this.field_queryState = 0;
    AppMethodBeat.o(182154);
  }
  
  public static String X(List<GroupToolItem> paramList)
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
        localJSONObject.put("updateTime", localGroupToolItem.fpL);
        localJSONArray.put(localJSONObject);
      }
      return paramList;
    }
    catch (JSONException paramList)
    {
      ad.e("MicroMsg.roomtools.GroupTools", "getToolsJsonStr() Exception:%s", new Object[] { paramList.getMessage() });
      paramList = localJSONArray.toString();
      AppMethodBeat.o(182158);
    }
  }
  
  public final boolean Vb()
  {
    AppMethodBeat.i(182157);
    if (this.fpM.size() >= 8)
    {
      AppMethodBeat.o(182157);
      return true;
    }
    AppMethodBeat.o(182157);
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(182155);
    super.convertFrom(paramCursor);
    this.fpM.clear();
    int j;
    int i;
    JSONObject localJSONObject;
    GroupToolItem localGroupToolItem;
    if (!bt.isNullOrNil(this.field_stickToollist)) {
      try
      {
        paramCursor = new JSONArray(this.field_stickToollist);
        j = paramCursor.length();
        i = 0;
        while (i < j)
        {
          localJSONObject = new JSONObject(paramCursor.getString(i));
          localGroupToolItem = new GroupToolItem();
          localGroupToolItem.username = bt.by(localJSONObject.getString("username"), "");
          localGroupToolItem.path = bt.by(localJSONObject.getString("path"), "");
          this.fpM.add(localGroupToolItem);
          i += 1;
        }
        this.fpN.clear();
      }
      catch (Exception paramCursor)
      {
        ad.e("MicroMsg.roomtools.GroupTools", "parseStickTools() Exception:%s", new Object[] { paramCursor.getMessage() });
      }
    }
    if (!bt.isNullOrNil(this.field_recentUseToolList)) {
      try
      {
        paramCursor = new JSONArray(this.field_recentUseToolList);
        j = paramCursor.length();
        i = 0;
        while (i < j)
        {
          localJSONObject = new JSONObject(paramCursor.getString(i));
          localGroupToolItem = new GroupToolItem();
          localGroupToolItem.username = bt.by(localJSONObject.getString("username"), "");
          localGroupToolItem.path = bt.by(localJSONObject.getString("path"), "");
          localGroupToolItem.fpL = localJSONObject.getLong("updateTime");
          this.fpN.add(localGroupToolItem);
          i += 1;
        }
        AppMethodBeat.o(182155);
        return;
      }
      catch (Exception paramCursor)
      {
        ad.e("MicroMsg.roomtools.GroupTools", "parseRecentUseTools() Exception:%s", new Object[] { paramCursor.getMessage() });
      }
    }
    AppMethodBeat.o(182155);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182156);
    if (bt.kU(((c)paramObject).field_chatroomname, this.field_chatroomname))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.c
 * JD-Core Version:    0.7.0.1
 */