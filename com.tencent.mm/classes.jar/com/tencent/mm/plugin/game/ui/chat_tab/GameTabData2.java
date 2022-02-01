package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.dp;
import com.tencent.mm.plugin.game.d.dq;
import com.tencent.mm.plugin.game.d.dr;
import com.tencent.mm.plugin.game.d.ds;
import com.tencent.mm.plugin.game.d.dt;
import com.tencent.mm.plugin.game.d.du;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public String jVX;
  public a utG;
  public String utH;
  public String utI;
  
  static
  {
    AppMethodBeat.i(206896);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(206896);
  }
  
  public GameTabData2()
  {
    AppMethodBeat.i(206885);
    this.utG = new a();
    AppMethodBeat.o(206885);
  }
  
  private GameTabData2(Parcel paramParcel)
  {
    AppMethodBeat.i(206886);
    e(paramParcel);
    AppMethodBeat.o(206886);
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, dp paramdp)
  {
    AppMethodBeat.i(206893);
    if ((paramdp == null) || (bt.hj(paramdp.ujR)))
    {
      AppMethodBeat.o(206893);
      return false;
    }
    paramGameTabData2.jVX = paramdp.ujT;
    paramGameTabData2.utI = paramdp.ujU;
    Object localObject = paramdp.ujR.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = new TabItem((dt)((Iterator)localObject).next());
      if (!bt.isNullOrNil(localTabItem.uea)) {
        paramGameTabData2.utG.a(localTabItem.uea, localTabItem);
      }
    }
    if (paramGameTabData2.utG.size() == 0)
    {
      AppMethodBeat.o(206893);
      return false;
    }
    localObject = "";
    if (paramdp.ujS != null) {
      localObject = bt.nullAsNil(paramdp.ujS.ujy);
    }
    if (paramGameTabData2.utG.containsKey(localObject)) {}
    for (paramGameTabData2.utH = ((String)localObject);; paramGameTabData2.utH = ag(paramGameTabData2.utG))
    {
      AppMethodBeat.o(206893);
      return true;
    }
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(206894);
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.getJSONArray("TabList");
        int i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          TabItem localTabItem = new TabItem(((JSONArray)localObject).optJSONObject(i));
          if (!bt.isNullOrNil(localTabItem.uea)) {
            paramGameTabData2.utG.a(localTabItem.uea, localTabItem);
          }
        }
        else if (paramGameTabData2.utG.size() != 0)
        {
          localObject = paramJSONObject.optJSONObject("DefaultTab");
          paramJSONObject = "";
          if (localObject != null) {
            paramJSONObject = ((JSONObject)localObject).optString("Key");
          }
          if (paramGameTabData2.utG.containsKey(paramJSONObject))
          {
            paramGameTabData2.utH = paramJSONObject;
            AppMethodBeat.o(206894);
            return true;
          }
          paramGameTabData2.utH = ag(paramGameTabData2.utG);
          continue;
        }
        i += 1;
      }
      catch (JSONException paramGameTabData2)
      {
        AppMethodBeat.o(206894);
        return false;
      }
    }
  }
  
  private static String ag(Map<String, TabItem> paramMap)
  {
    AppMethodBeat.i(206895);
    try
    {
      paramMap = (String)((Map.Entry)paramMap.entrySet().iterator().next()).getKey();
      AppMethodBeat.o(206895);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(206895);
    }
    return "";
  }
  
  public static GameTabData2 daj()
  {
    AppMethodBeat.i(206892);
    GameTabData2 localGameTabData2 = new GameTabData2();
    ac localac;
    Iterator localIterator;
    if (a.tSI != null)
    {
      if (a.tSI.uhK == null) {
        break label152;
      }
      localac = a.tSI.uhK;
      if ((localac == null) || (bt.hj(localac.ugs))) {
        break label167;
      }
      localIterator = localac.ugs.iterator();
    }
    label152:
    label165:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label167;
      }
      du localdu = (du)localIterator.next();
      long l2 = localdu.nEq;
      if (localdu.nEr == 0L) {}
      for (long l1 = 9223372036854775807L;; l1 = localdu.nEr)
      {
        if ((bt.aQJ() < l2) || (bt.aQJ() > l1) || (!a(localGameTabData2, localdu.ugr))) {
          break label165;
        }
        ad.i("MicroMsg.GameTabData2", "Get GameTabData from TabStyleList");
        AppMethodBeat.o(206892);
        return localGameTabData2;
        a.cWO();
        localac = null;
        break;
      }
    }
    label167:
    if ((localac != null) && (a(localGameTabData2, localac.ugr)))
    {
      ad.i("MicroMsg.GameTabData2", "Get GameTabData from globalConfig");
      AppMethodBeat.o(206892);
      return localGameTabData2;
    }
    try
    {
      if (a(localGameTabData2, new JSONObject("{\n        \"TabList\": [\n            {\n                \"Key\": \"home\",\n                \"Title\": \"首页\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/4f72b9a4850edcba7ff71688b17233b8224fcc357e2357c9c09f74efc5fbb32c\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/b18f15fb59987306a116b4c04929e10cfe08da24ba2d3467043ae3b0a68cc598\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/index_single.html?wechat_pkgid=appcenter_index_single&ssid=901\"\n            },\n            {\n                \"Key\": \"gameindex\",\n                \"Title\": \"游戏\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/3379a7e14dacfc6c9eea1cc3bce1abc681634348b2d10cb741402f0a7afe1b99\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/e257a6c0d7dd13a2ec717ec5d370871f8624fed7fcf8bd0c9d3a29dee6d01d97\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://game.weixin.qq.com/cgi-bin/h5/static/contentcenter/game.html?wechat_pkgid=contentcenter_game&ssid=901\"\n            },\n            {\n                \"Key\": \"community\",\n                \"Title\": \"游戏圈\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/090cb63e719dd5dee494f493d4dc7c767293046c8c37c3d620f3c426a4292806\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/3eea6be7fecf862137602860126a710860466bcb39f19a51d89664147c71aa3d\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/community.html?wechat_pkgid=appcenter_community&ssid=901\"\n            },\n            {\n                \"Key\": \"chat\",\n                \"Title\": \"消息\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/70b7e084e27150c4e606618d72b3afd1c474039fead8dadabf5a3438159d3cd5\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/6c4e9abf2c66d9b10e7a8a446a7285c89d0e577a6183eb222708d0cb9fc33bf3\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"Type\": 1\n            }\n        ],\n        \"DefaultTab\": {\n            \"Key\": \"home\"\n        }\n    }")))
      {
        ad.i("MicroMsg.GameTabData2", "Get GameTabData from local");
        AppMethodBeat.o(206892);
        return localGameTabData2;
      }
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.GameTabData2", localJSONException.getMessage());
      AppMethodBeat.o(206892);
    }
    return null;
  }
  
  private void e(Parcel paramParcel)
  {
    AppMethodBeat.i(206890);
    int j = paramParcel.readInt();
    if (this.utG == null) {
      this.utG = new a();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.utG.a(localTabItem.uea, localTabItem);
      }
      i += 1;
    }
    this.utH = paramParcel.readString();
    this.jVX = paramParcel.readString();
    this.utI = paramParcel.readString();
    AppMethodBeat.o(206890);
  }
  
  public final List<TabItem> afl()
  {
    AppMethodBeat.i(206887);
    ArrayList localArrayList = new ArrayList();
    if (this.utG != null) {
      localArrayList.addAll(this.utG.values());
    }
    AppMethodBeat.o(206887);
    return localArrayList;
  }
  
  public final String dai()
  {
    AppMethodBeat.i(206888);
    Object localObject = this.utG.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = (TabItem)((Iterator)localObject).next();
      if (localTabItem.duh == 1)
      {
        localObject = localTabItem.uea;
        AppMethodBeat.o(206888);
        return localObject;
      }
    }
    AppMethodBeat.o(206888);
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(206889);
    Object localObject = new JSONArray();
    Iterator localIterator = this.utG.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        TabItem localTabItem = (TabItem)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("Key", localTabItem.uea);
          localJSONObject.put("Title", localTabItem.title);
          localJSONObject.put("JumpUrl", localTabItem.jumpUrl);
          if (bt.nullAsNil(this.utH).equalsIgnoreCase(localTabItem.uea)) {
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
    AppMethodBeat.o(206889);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(206891);
    paramParcel.writeInt(this.utG.size());
    Iterator localIterator = this.utG.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeString(this.utH);
    paramParcel.writeString(this.jVX);
    paramParcel.writeString(this.utI);
    AppMethodBeat.o(206891);
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public int duh;
    public String iconUrl;
    public String jumpUrl;
    public int position;
    public String title;
    public String titleColor;
    public String uea;
    public String uei;
    public String utK;
    public String utL;
    public String utM;
    public String utN;
    public String utO;
    public String utP;
    public GameTabData2.TabItemWeapp utQ;
    public GameTabData2.TabItemReport utR;
    public boolean utS;
    public int utT;
    public int utU;
    
    static
    {
      AppMethodBeat.i(206872);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(206872);
    }
    
    private TabItem(Parcel paramParcel)
    {
      AppMethodBeat.i(206870);
      this.uea = paramParcel.readString();
      this.title = paramParcel.readString();
      this.titleColor = paramParcel.readString();
      this.utK = paramParcel.readString();
      this.utL = paramParcel.readString();
      this.utM = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.utN = paramParcel.readString();
      this.utO = paramParcel.readString();
      this.utP = paramParcel.readString();
      this.duh = paramParcel.readInt();
      this.jumpUrl = paramParcel.readString();
      this.utQ = ((GameTabData2.TabItemWeapp)paramParcel.readParcelable(GameTabData2.TabItemWeapp.class.getClassLoader()));
      this.utR = ((GameTabData2.TabItemReport)paramParcel.readParcelable(GameTabData2.TabItemReport.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.utS = bool;
        this.utT = paramParcel.readInt();
        this.uei = paramParcel.readString();
        this.position = paramParcel.readInt();
        AppMethodBeat.o(206870);
        return;
      }
    }
    
    public TabItem(dt paramdt)
    {
      AppMethodBeat.i(206867);
      if (paramdt == null)
      {
        AppMethodBeat.o(206867);
        return;
      }
      this.uea = paramdt.ujy;
      this.title = paramdt.Title;
      this.titleColor = paramdt.ujW;
      this.utK = paramdt.ujX;
      this.utL = paramdt.ujY;
      this.utM = paramdt.ujZ;
      this.iconUrl = paramdt.IconUrl;
      this.utN = paramdt.uka;
      this.utO = paramdt.ukb;
      this.utP = paramdt.ukc;
      this.duh = paramdt.nEf;
      this.jumpUrl = paramdt.ueY;
      this.utQ = new GameTabData2.TabItemWeapp(paramdt.ukd);
      this.utR = new GameTabData2.TabItemReport(paramdt.uke);
      this.utS = paramdt.ukf;
      this.utT = paramdt.ukg;
      dak();
      AppMethodBeat.o(206867);
    }
    
    public TabItem(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(206868);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(206868);
        return;
      }
      this.uea = paramJSONObject.optString("Key");
      this.title = paramJSONObject.optString("Title");
      this.iconUrl = paramJSONObject.optString("IconUrl");
      this.utN = paramJSONObject.optString("SelectedIconUrl");
      this.utO = paramJSONObject.optString("DarkModeIconUrl");
      this.utP = paramJSONObject.optString("DarkModeSelectedIconUrl");
      this.duh = paramJSONObject.optInt("Type");
      this.jumpUrl = paramJSONObject.optString("JumpUrl");
      this.utQ = new GameTabData2.TabItemWeapp(paramJSONObject.optJSONObject("JumpWeapp"));
      this.utR = new GameTabData2.TabItemReport(paramJSONObject.optJSONObject("Report"));
      this.utS = false;
      this.utT = 2;
      dak();
      AppMethodBeat.o(206868);
    }
    
    private void dak()
    {
      AppMethodBeat.i(206869);
      switch (this.duh)
      {
      default: 
        this.uei = "";
        AppMethodBeat.o(206869);
        return;
      case 1: 
        this.uei = GameChatTabUI.class.getName();
        AppMethodBeat.o(206869);
        return;
      }
      this.uei = GameWebTabUI.class.getName();
      AppMethodBeat.o(206869);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(206871);
      paramParcel.writeString(this.uea);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.titleColor);
      paramParcel.writeString(this.utK);
      paramParcel.writeString(this.utL);
      paramParcel.writeString(this.utM);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.utN);
      paramParcel.writeString(this.utO);
      paramParcel.writeString(this.utP);
      paramParcel.writeInt(this.duh);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeParcelable(this.utQ, paramInt);
      paramParcel.writeParcelable(this.utR, paramInt);
      if (this.utS) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.utT);
        paramParcel.writeString(this.uei);
        paramParcel.writeInt(this.position);
        AppMethodBeat.o(206871);
        return;
      }
    }
  }
  
  public static class TabItemReport
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemReport> CREATOR;
    public String uaR;
    public int uek;
    public int utV;
    
    static
    {
      AppMethodBeat.i(206878);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(206878);
    }
    
    private TabItemReport(Parcel paramParcel)
    {
      AppMethodBeat.i(206876);
      this.utV = paramParcel.readInt();
      this.uek = paramParcel.readInt();
      this.uaR = paramParcel.readString();
      AppMethodBeat.o(206876);
    }
    
    public TabItemReport(ds paramds)
    {
      AppMethodBeat.i(206874);
      if (paramds == null)
      {
        AppMethodBeat.o(206874);
        return;
      }
      this.utV = paramds.ujV;
      this.uek = paramds.ufI;
      this.uaR = paramds.ufG;
      AppMethodBeat.o(206874);
    }
    
    public TabItemReport(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(206875);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(206875);
        return;
      }
      this.utV = paramJSONObject.optInt("AreaId");
      this.uek = paramJSONObject.optInt("PositionId");
      this.uaR = paramJSONObject.optString("ExternInfo");
      AppMethodBeat.o(206875);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(206877);
      paramParcel.writeInt(this.utV);
      paramParcel.writeInt(this.uek);
      paramParcel.writeString(this.uaR);
      AppMethodBeat.o(206877);
    }
  }
  
  public static class TabItemWeapp
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemWeapp> CREATOR;
    public String iht;
    public String ujc;
    
    static
    {
      AppMethodBeat.i(206884);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(206884);
    }
    
    private TabItemWeapp(Parcel paramParcel)
    {
      AppMethodBeat.i(206882);
      this.iht = paramParcel.readString();
      this.ujc = paramParcel.readString();
      AppMethodBeat.o(206882);
    }
    
    public TabItemWeapp(dr paramdr)
    {
      AppMethodBeat.i(206880);
      if (paramdr == null)
      {
        AppMethodBeat.o(206880);
        return;
      }
      this.iht = paramdr.iht;
      this.ujc = paramdr.ujc;
      AppMethodBeat.o(206880);
    }
    
    public TabItemWeapp(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(206881);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(206881);
        return;
      }
      this.iht = paramJSONObject.optString("AppId");
      this.ujc = paramJSONObject.optString("Path");
      AppMethodBeat.o(206881);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(206883);
      paramParcel.writeString(this.iht);
      paramParcel.writeString(this.ujc);
      AppMethodBeat.o(206883);
    }
  }
  
  public final class a
    extends LinkedHashMap<String, GameTabData2.TabItem>
  {
    public a() {}
    
    public final GameTabData2.TabItem a(String paramString, GameTabData2.TabItem paramTabItem)
    {
      AppMethodBeat.i(206864);
      paramTabItem.position = (size() + 1);
      paramString = (GameTabData2.TabItem)super.put(paramString, paramTabItem);
      AppMethodBeat.o(206864);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2
 * JD-Core Version:    0.7.0.1
 */