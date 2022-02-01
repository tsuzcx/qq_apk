package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ec;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends ec
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public LinkedList<GroupToolItem> lzE;
  public LinkedList<GroupToolItem> lzF;
  
  static
  {
    AppMethodBeat.i(182159);
    info = ec.aJm();
    AppMethodBeat.o(182159);
  }
  
  public e()
  {
    AppMethodBeat.i(182154);
    this.lzE = new LinkedList();
    this.lzF = new LinkedList();
    this.field_queryState = 0;
    AppMethodBeat.o(182154);
  }
  
  public static String bt(List<GroupToolItem> paramList)
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
        localJSONObject.put("updateTime", localGroupToolItem.egK);
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
    AppMethodBeat.i(241407);
    if (this.lzF.contains(paramGroupToolItem)) {
      this.lzF.remove(paramGroupToolItem);
    }
    this.lzF.add(paramGroupToolItem);
    Collections.sort(this.lzF, new Comparator() {});
    if (this.lzF.size() > 20) {
      this.lzF.remove(this.lzF.size() - 1);
    }
    this.field_recentUseToolList = bt(this.lzF);
    AppMethodBeat.o(241407);
  }
  
  public final boolean aMj()
  {
    AppMethodBeat.i(182157);
    if (this.lzE.size() >= 8)
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
    this.lzE.clear();
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
          this.lzE.add(localGroupToolItem);
          i += 1;
        }
        this.lzF.clear();
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
          localGroupToolItem.egK = localJSONObject.getLong("updateTime");
          this.lzF.add(localGroupToolItem);
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