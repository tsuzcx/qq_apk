package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static String fwo = "menu_click";
  public static String fwp = "menu_action_start";
  public static String fwq = "menu_action_success";
  public String cMO;
  public String content;
  public List<j> fwr = null;
  public int fws;
  public int id;
  public String key;
  public String name;
  public String state;
  public int type;
  public String value;
  
  public static List<j> e(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(105486);
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
          j localj = new j();
          localj.id = ((JSONObject)localObject).getInt("id");
          localj.type = ((JSONObject)localObject).getInt("type");
          localj.name = ((JSONObject)localObject).getString("name");
          localj.key = ((JSONObject)localObject).getString("key");
          localj.value = ((JSONObject)localObject).optString("value");
          localj.cMO = ((JSONObject)localObject).optString("native_url");
          ab.d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + localj.cMO);
          localj.fwr = e(((JSONObject)localObject).optJSONArray("sub_button_list"));
          localj.fws = ((JSONObject)localObject).optInt("acttype");
          localArrayList.add(localj);
          i += 1;
        }
        localObject = null;
      }
      catch (JSONException paramJSONArray)
      {
        ab.e("MicroMsg.BizMenuItem", "exception:%s", new Object[] { bo.l(paramJSONArray) });
        AppMethodBeat.o(105486);
        return null;
      }
    }
    AppMethodBeat.o(105486);
    return localObject;
  }
  
  public static LinkedList<j> p(Map<String, String> paramMap)
  {
    AppMethodBeat.i(105487);
    if (paramMap == null)
    {
      AppMethodBeat.o(105487);
      return null;
    }
    int j = bo.getInt((String)paramMap.get(".msg.appmsg.buttonlist.$count"), 0);
    if (j > 0) {
      try
      {
        LinkedList localLinkedList = new LinkedList();
        ab.v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : ".concat(String.valueOf(j)));
        int i = 0;
        if (i < j)
        {
          j localj = new j();
          StringBuilder localStringBuilder = new StringBuilder(".msg.appmsg.buttonlist.button");
          if (i == 0) {}
          for (String str = "";; str = String.valueOf(i))
          {
            str = str;
            localj.id = bo.getInt((String)paramMap.get(str + ".id"), 0);
            localj.type = bo.getInt((String)paramMap.get(str + ".type"), 0);
            localj.name = ((String)paramMap.get(str + ".name"));
            localj.key = ((String)paramMap.get(str + ".key"));
            localj.value = ((String)paramMap.get(str + ".value"));
            localj.fws = bo.getInt((String)paramMap.get(str + ".acttype"), 0);
            localLinkedList.add(localj);
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(105487);
        return localLinkedList;
      }
      catch (Exception paramMap)
      {
        ab.e("MicroMsg.BizMenuItem", "exception:%s", new Object[] { bo.l(paramMap) });
        AppMethodBeat.o(105487);
        return null;
      }
    }
    AppMethodBeat.o(105487);
    return null;
  }
  
  public final void a(double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(105483);
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
      ab.v("MicroMsg.BizMenuItem", this.content);
      AppMethodBeat.o(105483);
      return;
    }
    catch (JSONException paramString1)
    {
      ab.e("MicroMsg.BizMenuItem", paramString1.toString());
      AppMethodBeat.o(105483);
    }
  }
  
  public final void aD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105481);
    ab.v("MicroMsg.BizMenuItem", "type is %s , result is %s", new Object[] { paramString1, paramString2 });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scan_type", paramString1);
      localJSONObject.put("scan_result", paramString2);
      paramString1 = new JSONObject();
      paramString1.put("scan_code", localJSONObject);
      this.content = paramString1.toString();
      ab.v("MicroMsg.BizMenuItem", "content: %s", new Object[] { this.content });
      AppMethodBeat.o(105481);
      return;
    }
    catch (JSONException paramString1)
    {
      ab.e("MicroMsg.BizMenuItem", paramString1.toString());
      AppMethodBeat.o(105481);
    }
  }
  
  public final void f(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(105482);
    if (paramArrayList.size() == 0)
    {
      ab.e("MicroMsg.BizMenuItem", "value null!");
      AppMethodBeat.o(105482);
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
      ab.e("MicroMsg.BizMenuItem", paramArrayList.toString());
      AppMethodBeat.o(105482);
      return;
    }
    paramArrayList.put("pics", localJSONArray);
    this.content = paramArrayList.toString();
    ab.v("MicroMsg.BizMenuItem", this.content);
    AppMethodBeat.o(105482);
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(105484);
    if (this.content == null) {
      this.content = "";
    }
    if (this.state == null) {
      if (this.type != 4) {
        break label97;
      }
    }
    label97:
    for (this.state = fwp;; this.state = fwo)
    {
      String str = String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", new Object[] { "#bizmenu#", Integer.valueOf(this.id), this.key, this.state, this.content });
      AppMethodBeat.o(105484);
      return str;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105485);
    int i = this.id;
    int j = this.fws;
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
      AppMethodBeat.o(105485);
      return str1;
      str1 = this.name;
      break;
      str2 = this.key;
      break label43;
      str3 = this.value;
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aj.j
 * JD-Core Version:    0.7.0.1
 */