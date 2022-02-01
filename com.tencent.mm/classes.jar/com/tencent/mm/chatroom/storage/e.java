package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.dq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
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

public final class e
  extends dq
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public LinkedList<GroupToolItem> iXI;
  public LinkedList<GroupToolItem> iXJ;
  
  static
  {
    AppMethodBeat.i(182159);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "chatroomname";
    localMAutoDBInfo.colsMap.put("chatroomname", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "chatroomname";
    localMAutoDBInfo.columns[1] = "stickToollist";
    localMAutoDBInfo.colsMap.put("stickToollist", "TEXT");
    localStringBuilder.append(" stickToollist TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "recentUseToolList";
    localMAutoDBInfo.colsMap.put("recentUseToolList", "TEXT");
    localStringBuilder.append(" recentUseToolList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "queryState";
    localMAutoDBInfo.colsMap.put("queryState", "INTEGER");
    localStringBuilder.append(" queryState INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(182159);
  }
  
  public e()
  {
    AppMethodBeat.i(182154);
    this.iXI = new LinkedList();
    this.iXJ = new LinkedList();
    this.field_queryState = 0;
    AppMethodBeat.o(182154);
  }
  
  public static String T(List<GroupToolItem> paramList)
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
        localJSONObject.put("updateTime", localGroupToolItem.coZ);
        localJSONArray.put(localJSONObject);
      }
      return paramList;
    }
    catch (JSONException paramList)
    {
      Log.e("MicroMsg.roomtools.GroupTools", "getToolsJsonStr() Exception:%s", new Object[] { paramList.getMessage() });
      paramList = localJSONArray.toString();
      AppMethodBeat.o(182158);
    }
  }
  
  public final void a(GroupToolItem paramGroupToolItem)
  {
    AppMethodBeat.i(186280);
    if (this.iXJ.contains(paramGroupToolItem)) {
      this.iXJ.remove(paramGroupToolItem);
    }
    this.iXJ.add(paramGroupToolItem);
    Collections.sort(this.iXJ, new Comparator() {});
    if (this.iXJ.size() > 20) {
      this.iXJ.remove(this.iXJ.size() - 1);
    }
    this.field_recentUseToolList = T(this.iXJ);
    AppMethodBeat.o(186280);
  }
  
  public final boolean asp()
  {
    AppMethodBeat.i(182157);
    if (this.iXI.size() >= 8)
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
    this.iXI.clear();
    int j;
    int i;
    JSONObject localJSONObject;
    GroupToolItem localGroupToolItem;
    if (!Util.isNullOrNil(this.field_stickToollist)) {
      try
      {
        paramCursor = new JSONArray(this.field_stickToollist);
        j = paramCursor.length();
        i = 0;
        while (i < j)
        {
          localJSONObject = new JSONObject(paramCursor.getString(i));
          localGroupToolItem = new GroupToolItem();
          localGroupToolItem.username = Util.nullAs(localJSONObject.getString("username"), "");
          localGroupToolItem.path = Util.nullAs(localJSONObject.getString("path"), "");
          this.iXI.add(localGroupToolItem);
          i += 1;
        }
        this.iXJ.clear();
      }
      catch (Exception paramCursor)
      {
        Log.e("MicroMsg.roomtools.GroupTools", "parseStickTools() Exception:%s", new Object[] { paramCursor.getMessage() });
      }
    }
    if (!Util.isNullOrNil(this.field_recentUseToolList)) {
      try
      {
        paramCursor = new JSONArray(this.field_recentUseToolList);
        j = paramCursor.length();
        i = 0;
        while (i < j)
        {
          localJSONObject = new JSONObject(paramCursor.getString(i));
          localGroupToolItem = new GroupToolItem();
          localGroupToolItem.username = Util.nullAs(localJSONObject.getString("username"), "");
          localGroupToolItem.path = Util.nullAs(localJSONObject.getString("path"), "");
          localGroupToolItem.coZ = localJSONObject.getLong("updateTime");
          this.iXJ.add(localGroupToolItem);
          i += 1;
        }
        AppMethodBeat.o(182155);
        return;
      }
      catch (Exception paramCursor)
      {
        Log.e("MicroMsg.roomtools.GroupTools", "parseRecentUseTools() Exception:%s", new Object[] { paramCursor.getMessage() });
      }
    }
    AppMethodBeat.o(182155);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182156);
    if (Util.isEqual(((e)paramObject).field_chatroomname, this.field_chatroomname))
    {
      AppMethodBeat.o(182156);
      return true;
    }
    AppMethodBeat.o(182156);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.e
 * JD-Core Version:    0.7.0.1
 */