package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.ai;
import com.tencent.mm.plugin.game.protobuf.dy;
import com.tencent.mm.plugin.game.protobuf.dz;
import com.tencent.mm.plugin.game.protobuf.ec;
import com.tencent.mm.plugin.game.protobuf.ed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameTabData2
  implements Parcelable
{
  public static final Parcelable.Creator<GameTabData2> CREATOR;
  private static final String xXa;
  public String lco;
  public a xWX;
  public String xWY;
  public String xWZ;
  
  static
  {
    AppMethodBeat.i(204242);
    CREATOR = new Parcelable.Creator() {};
    xXa = "{\n        \"TabList\": [\n            {\n                \"Key\": \"home\",\n                \"Title\": \"首页\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/4f72b9a4850edcba7ff71688b17233b8224fcc357e2357c9c09f74efc5fbb32c\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/b18f15fb59987306a116b4c04929e10cfe08da24ba2d3467043ae3b0a68cc598\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/contentcenter/feeds.html?wechat_pkgid=contentcenter_feeds&abt=59&ssid=901\"\n            },\n            {\n                \"Key\": \"gameindex\",\n                \"Title\": \"游戏\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/3379a7e14dacfc6c9eea1cc3bce1abc681634348b2d10cb741402f0a7afe1b99\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/e257a6c0d7dd13a2ec717ec5d370871f8624fed7fcf8bd0c9d3a29dee6d01d97\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/contentcenter/game.html?wechat_pkgid=contentcenter_game&ssid=901\"\n            },\n            {\n                \"Key\": \"community\",\n                \"Title\": \"游戏圈\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/090cb63e719dd5dee494f493d4dc7c767293046c8c37c3d620f3c426a4292806\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/3eea6be7fecf862137602860126a710860466bcb39f19a51d89664147c71aa3d\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/appcenter/community.html?wechat_pkgid=appcenter_community&ssid=901\"\n            },\n            {\n                \"Key\": \"chat\",\n                \"Title\": \"消息\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/70b7e084e27150c4e606618d72b3afd1c474039fead8dadabf5a3438159d3cd5\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/6c4e9abf2c66d9b10e7a8a446a7285c89d0e577a6183eb222708d0cb9fc33bf3\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"Type\": 1\n            }\n        ],\n        \"DefaultTab\": {\n            \"Key\": \"home\"\n        }\n    }";
    AppMethodBeat.o(204242);
  }
  
  public GameTabData2()
  {
    AppMethodBeat.i(204231);
    this.xWX = new a();
    AppMethodBeat.o(204231);
  }
  
  private GameTabData2(Parcel paramParcel)
  {
    AppMethodBeat.i(204232);
    f(paramParcel);
    AppMethodBeat.o(204232);
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, dy paramdy)
  {
    AppMethodBeat.i(204239);
    if ((paramdy == null) || (Util.isNullOrNil(paramdy.xNq)))
    {
      AppMethodBeat.o(204239);
      return false;
    }
    paramGameTabData2.lco = paramdy.xNs;
    paramGameTabData2.xWZ = paramdy.xNt;
    Object localObject = paramdy.xNq.iterator();
    while (((Iterator)localObject).hasNext())
    {
      GameTabData2.TabItem localTabItem = new GameTabData2.TabItem((ec)((Iterator)localObject).next());
      if (!Util.isNullOrNil(localTabItem.xHB)) {
        paramGameTabData2.xWX.a(localTabItem.xHB, localTabItem);
      }
    }
    if (paramGameTabData2.xWX.size() == 0)
    {
      AppMethodBeat.o(204239);
      return false;
    }
    localObject = "";
    if (paramdy.xNr != null) {
      localObject = Util.nullAsNil(paramdy.xNr.xMX);
    }
    if (paramGameTabData2.xWX.containsKey(localObject)) {}
    for (paramGameTabData2.xWY = ((String)localObject);; paramGameTabData2.xWY = an(paramGameTabData2.xWX))
    {
      AppMethodBeat.o(204239);
      return true;
    }
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(204240);
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.getJSONArray("TabList");
        int i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          GameTabData2.TabItem localTabItem = new GameTabData2.TabItem(((JSONArray)localObject).optJSONObject(i));
          if (!Util.isNullOrNil(localTabItem.xHB)) {
            paramGameTabData2.xWX.a(localTabItem.xHB, localTabItem);
          }
        }
        else if (paramGameTabData2.xWX.size() != 0)
        {
          localObject = paramJSONObject.optJSONObject("DefaultTab");
          paramJSONObject = "";
          if (localObject != null) {
            paramJSONObject = ((JSONObject)localObject).optString("Key");
          }
          if (paramGameTabData2.xWX.containsKey(paramJSONObject))
          {
            paramGameTabData2.xWY = paramJSONObject;
            AppMethodBeat.o(204240);
            return true;
          }
          paramGameTabData2.xWY = an(paramGameTabData2.xWX);
          continue;
        }
        i += 1;
      }
      catch (JSONException paramGameTabData2)
      {
        AppMethodBeat.o(204240);
        return false;
      }
    }
  }
  
  private static String an(Map<String, GameTabData2.TabItem> paramMap)
  {
    AppMethodBeat.i(204241);
    try
    {
      paramMap = (String)((Map.Entry)paramMap.entrySet().iterator().next()).getKey();
      AppMethodBeat.o(204241);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(204241);
    }
    return "";
  }
  
  public static GameTabData2 dWB()
  {
    AppMethodBeat.i(204238);
    GameTabData2 localGameTabData2 = new GameTabData2();
    ai localai;
    Iterator localIterator;
    if (a.xvl != null)
    {
      if (a.xvl.GameCenterTabSetting == null) {
        break label154;
      }
      localai = a.xvl.GameCenterTabSetting;
      if ((localai == null) || (Util.isNullOrNil(localai.xKh))) {
        break label169;
      }
      localIterator = localai.xKh.iterator();
    }
    label154:
    label167:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label169;
      }
      ed localed = (ed)localIterator.next();
      long l2 = localed.oUG;
      if (localed.oUH == 0L) {}
      for (long l1 = 9223372036854775807L;; l1 = localed.oUH)
      {
        if ((Util.nowSecond() < l2) || (Util.nowSecond() > l1) || (!a(localGameTabData2, localed.xKg))) {
          break label167;
        }
        Log.i("MicroMsg.GameTabData2", "Get GameTabData from TabStyleList");
        AppMethodBeat.o(204238);
        return localGameTabData2;
        a.dSS();
        localai = null;
        break;
      }
    }
    label169:
    if ((localai != null) && (a(localGameTabData2, localai.xKg)))
    {
      Log.i("MicroMsg.GameTabData2", "Get GameTabData from globalConfig");
      AppMethodBeat.o(204238);
      return localGameTabData2;
    }
    try
    {
      if (a(localGameTabData2, new JSONObject(xXa)))
      {
        Log.i("MicroMsg.GameTabData2", "Get GameTabData from local");
        AppMethodBeat.o(204238);
        return localGameTabData2;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.GameTabData2", localJSONException.getMessage());
      AppMethodBeat.o(204238);
    }
    return null;
  }
  
  private void f(Parcel paramParcel)
  {
    AppMethodBeat.i(204236);
    int j = paramParcel.readInt();
    if (this.xWX == null) {
      this.xWX = new a();
    }
    int i = 0;
    while (i < j)
    {
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)paramParcel.readParcelable(GameTabData2.TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.xWX.a(localTabItem.xHB, localTabItem);
      }
      i += 1;
    }
    this.xWY = paramParcel.readString();
    this.lco = paramParcel.readString();
    this.xWZ = paramParcel.readString();
    AppMethodBeat.o(204236);
  }
  
  public final List<GameTabData2.TabItem> avn()
  {
    AppMethodBeat.i(204233);
    ArrayList localArrayList = new ArrayList();
    if (this.xWX != null) {
      localArrayList.addAll(this.xWX.values());
    }
    AppMethodBeat.o(204233);
    return localArrayList;
  }
  
  public final String dWA()
  {
    AppMethodBeat.i(204234);
    Object localObject = this.xWX.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)((Iterator)localObject).next();
      if (localTabItem.dLS == 1)
      {
        localObject = localTabItem.xHB;
        AppMethodBeat.o(204234);
        return localObject;
      }
    }
    AppMethodBeat.o(204234);
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(204235);
    Object localObject = new JSONArray();
    Iterator localIterator = this.xWX.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("Key", localTabItem.xHB);
          localJSONObject.put("Title", localTabItem.title);
          localJSONObject.put("JumpUrl", localTabItem.jumpUrl);
          if (Util.nullAsNil(this.xWY).equalsIgnoreCase(localTabItem.xHB)) {
            localJSONObject.put("isDefaultTab", 1);
          }
          for (;;)
          {
            label120:
            ((JSONArray)localObject).put(localJSONObject);
            break;
            localJSONObject.put("isDefaultTab", 0);
          }
        }
        catch (JSONException localJSONException)
        {
          break label120;
        }
      }
    }
    localObject = ((JSONArray)localObject).toString();
    AppMethodBeat.o(204235);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(204237);
    paramParcel.writeInt(this.xWX.size());
    Iterator localIterator = this.xWX.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeString(this.xWY);
    paramParcel.writeString(this.lco);
    paramParcel.writeString(this.xWZ);
    AppMethodBeat.o(204237);
  }
  
  public final class a
    extends LinkedHashMap<String, GameTabData2.TabItem>
  {
    public a() {}
    
    public final GameTabData2.TabItem a(String paramString, GameTabData2.TabItem paramTabItem)
    {
      AppMethodBeat.i(204210);
      paramTabItem.position = (size() + 1);
      paramString = (GameTabData2.TabItem)super.put(paramString, paramTabItem);
      AppMethodBeat.o(204210);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2
 * JD-Core Version:    0.7.0.1
 */