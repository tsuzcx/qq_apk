package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static String iOp = "menu_click";
  public static String iOq = "menu_action_start";
  public static String iOr = "menu_action_success";
  public String content;
  public String egX;
  public List<k> iOs = null;
  public int iOt;
  public int id;
  public String key;
  public String name;
  public String state;
  public int type;
  public String value;
  
  public static LinkedList<k> E(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116433);
    if (paramMap == null)
    {
      AppMethodBeat.o(116433);
      return null;
    }
    int j = Util.getInt((String)paramMap.get(".msg.appmsg.buttonlist.$count"), 0);
    if (j > 0) {
      try
      {
        LinkedList localLinkedList = new LinkedList();
        Log.v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : ".concat(String.valueOf(j)));
        int i = 0;
        if (i < j)
        {
          k localk = new k();
          StringBuilder localStringBuilder = new StringBuilder(".msg.appmsg.buttonlist.button");
          if (i == 0) {}
          for (String str = "";; str = String.valueOf(i))
          {
            str = str;
            localk.id = Util.getInt((String)paramMap.get(str + ".id"), 0);
            localk.type = Util.getInt((String)paramMap.get(str + ".type"), 0);
            localk.name = ((String)paramMap.get(str + ".name"));
            localk.key = ((String)paramMap.get(str + ".key"));
            localk.value = ((String)paramMap.get(str + ".value"));
            localk.iOt = Util.getInt((String)paramMap.get(str + ".acttype"), 0);
            localLinkedList.add(localk);
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(116433);
        return localLinkedList;
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.BizMenuItem", "exception:%s", new Object[] { Util.stackTraceToString(paramMap) });
        AppMethodBeat.o(116433);
        return null;
      }
    }
    AppMethodBeat.o(116433);
    return null;
  }
  
  public static List<k> e(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(116432);
    Object localObject;
    if (paramJSONArray != null) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localObject = paramJSONArray.getJSONObject(i);
          k localk = new k();
          localk.id = ((JSONObject)localObject).getInt("id");
          localk.type = ((JSONObject)localObject).getInt("type");
          localk.name = ((JSONObject)localObject).getString("name");
          localk.key = ((JSONObject)localObject).getString("key");
          localk.value = ((JSONObject)localObject).optString("value");
          localk.egX = ((JSONObject)localObject).optString("native_url");
          Log.d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + localk.egX);
          localk.iOs = e(((JSONObject)localObject).optJSONArray("sub_button_list"));
          localk.iOt = ((JSONObject)localObject).optInt("acttype");
          localArrayList.add(localk);
          i += 1;
        }
        localObject = null;
      }
      catch (JSONException paramJSONArray)
      {
        Log.e("MicroMsg.BizMenuItem", "exception:%s", new Object[] { Util.stackTraceToString(paramJSONArray) });
        AppMethodBeat.o(116432);
        return null;
      }
    }
    AppMethodBeat.o(116432);
    return localObject;
  }
  
  public final void a(double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116429);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("x", String.valueOf(paramDouble1));
      localJSONObject.put("y", String.valueOf(paramDouble2));
      localJSONObject.put("scale", paramInt);
      localJSONObject.put("label", paramString1);
      localJSONObject.put("poiname", paramString2);
      paramString1 = new JSONObject();
      paramString1.put("location", localJSONObject);
      this.content = paramString1.toString();
      Log.v("MicroMsg.BizMenuItem", this.content);
      AppMethodBeat.o(116429);
      return;
    }
    catch (JSONException paramString1)
    {
      Log.e("MicroMsg.BizMenuItem", paramString1.toString());
      AppMethodBeat.o(116429);
    }
  }
  
  public final void bf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116427);
    Log.v("MicroMsg.BizMenuItem", "type is %s , result is %s", new Object[] { paramString1, paramString2 });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scan_type", paramString1);
      localJSONObject.put("scan_result", paramString2);
      paramString1 = new JSONObject();
      paramString1.put("scan_code", localJSONObject);
      this.content = paramString1.toString();
      Log.v("MicroMsg.BizMenuItem", "content: %s", new Object[] { this.content });
      AppMethodBeat.o(116427);
      return;
    }
    catch (JSONException paramString1)
    {
      Log.e("MicroMsg.BizMenuItem", paramString1.toString());
      AppMethodBeat.o(116427);
    }
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(116430);
    if (this.content == null) {
      this.content = "";
    }
    if (this.state == null) {
      if (this.type != 4) {
        break label97;
      }
    }
    label97:
    for (this.state = iOq;; this.state = iOp)
    {
      String str = String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", new Object[] { "#bizmenu#", Integer.valueOf(this.id), this.key, this.state, this.content });
      AppMethodBeat.o(116430);
      return str;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(116431);
    int i = this.id;
    int j = this.iOt;
    int k = this.type;
    String str1;
    String str2;
    label43:
    String str3;
    if (this.name == null)
    {
      str1 = "";
      if (this.key != null) {
        break label138;
      }
      str2 = "";
      if (this.value != null) {
        break label147;
      }
      str3 = "";
      label54:
      if (this.content != null) {
        break label156;
      }
    }
    label138:
    label147:
    label156:
    for (String str4 = "";; str4 = this.content)
    {
      str1 = String.format("id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str1, str2, str3, str4 });
      AppMethodBeat.o(116431);
      return str1;
      str1 = this.name;
      break;
      str2 = this.key;
      break label43;
      str3 = this.value;
      break label54;
    }
  }
  
  public final void u(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116428);
    if (paramArrayList.size() == 0)
    {
      Log.e("MicroMsg.BizMenuItem", "value null!");
      AppMethodBeat.o(116428);
      return;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("pic_md5", str);
        localJSONArray.put(localJSONObject);
      }
      paramArrayList = new JSONObject();
    }
    catch (JSONException paramArrayList)
    {
      Log.e("MicroMsg.BizMenuItem", paramArrayList.toString());
      AppMethodBeat.o(116428);
      return;
    }
    paramArrayList.put("pics", localJSONArray);
    this.content = paramArrayList.toString();
    Log.v("MicroMsg.BizMenuItem", this.content);
    AppMethodBeat.o(116428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.k
 * JD-Core Version:    0.7.0.1
 */