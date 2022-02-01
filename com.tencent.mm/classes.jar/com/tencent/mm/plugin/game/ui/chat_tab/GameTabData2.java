package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.aj;
import com.tencent.mm.plugin.game.protobuf.dz;
import com.tencent.mm.plugin.game.protobuf.ea;
import com.tencent.mm.plugin.game.protobuf.eb;
import com.tencent.mm.plugin.game.protobuf.ec;
import com.tencent.mm.plugin.game.protobuf.ed;
import com.tencent.mm.plugin.game.protobuf.ee;
import com.tencent.mm.plugin.game.protobuf.q;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private static final String DbF;
  public a DbC;
  public String DbD;
  public String DbE;
  public String nWx;
  
  static
  {
    AppMethodBeat.i(205612);
    CREATOR = new Parcelable.Creator() {};
    DbF = "{\n        \"TabList\": [\n            {\n                \"Key\": \"home\",\n                \"Title\": \"首页\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/4f72b9a4850edcba7ff71688b17233b8224fcc357e2357c9c09f74efc5fbb32c\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/b18f15fb59987306a116b4c04929e10cfe08da24ba2d3467043ae3b0a68cc598\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(g.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/contentcenter/feeds.html?wechat_pkgid=contentcenter_feeds&abt=59&ssid=901\"\n            },\n            {\n                \"Key\": \"gameindex\",\n                \"Title\": \"游戏\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/3379a7e14dacfc6c9eea1cc3bce1abc681634348b2d10cb741402f0a7afe1b99\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/e257a6c0d7dd13a2ec717ec5d370871f8624fed7fcf8bd0c9d3a29dee6d01d97\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(g.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/contentcenter/game.html?wechat_pkgid=contentcenter_game&ssid=901\"\n            },\n            {\n                \"Key\": \"community\",\n                \"Title\": \"游戏圈\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/090cb63e719dd5dee494f493d4dc7c767293046c8c37c3d620f3c426a4292806\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/3eea6be7fecf862137602860126a710860466bcb39f19a51d89664147c71aa3d\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(g.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/appcenter/community.html?wechat_pkgid=appcenter_community&ssid=901\"\n            },\n            {\n                \"Key\": \"chat\",\n                \"Title\": \"消息\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/70b7e084e27150c4e606618d72b3afd1c474039fead8dadabf5a3438159d3cd5\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/6c4e9abf2c66d9b10e7a8a446a7285c89d0e577a6183eb222708d0cb9fc33bf3\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"Type\": 1\n            }\n        ],\n        \"DefaultTab\": {\n            \"Key\": \"home\"\n        }\n    }";
    AppMethodBeat.o(205612);
  }
  
  public GameTabData2()
  {
    AppMethodBeat.i(205590);
    this.DbC = new a();
    AppMethodBeat.o(205590);
  }
  
  private GameTabData2(Parcel paramParcel)
  {
    AppMethodBeat.i(205591);
    f(paramParcel);
    AppMethodBeat.o(205591);
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, dz paramdz)
  {
    AppMethodBeat.i(205605);
    if ((paramdz == null) || (Util.isNullOrNil(paramdz.CRA)))
    {
      AppMethodBeat.o(205605);
      return false;
    }
    paramGameTabData2.nWx = paramdz.CRC;
    paramGameTabData2.DbE = paramdz.CRD;
    Object localObject = paramdz.CRA.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = new TabItem((ed)((Iterator)localObject).next());
      if (!Util.isNullOrNil(localTabItem.CLE)) {
        paramGameTabData2.DbC.a(localTabItem.CLE, localTabItem);
      }
    }
    if (paramGameTabData2.DbC.size() == 0)
    {
      AppMethodBeat.o(205605);
      return false;
    }
    localObject = "";
    if (paramdz.CRB != null) {
      localObject = Util.nullAsNil(paramdz.CRB.CRg);
    }
    if (paramGameTabData2.DbC.containsKey(localObject)) {}
    for (paramGameTabData2.DbD = ((String)localObject);; paramGameTabData2.DbD = ag(paramGameTabData2.DbC))
    {
      AppMethodBeat.o(205605);
      return true;
    }
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205609);
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.getJSONArray("TabList");
        int i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          TabItem localTabItem = new TabItem(((JSONArray)localObject).optJSONObject(i));
          if (!Util.isNullOrNil(localTabItem.CLE)) {
            paramGameTabData2.DbC.a(localTabItem.CLE, localTabItem);
          }
        }
        else if (paramGameTabData2.DbC.size() != 0)
        {
          localObject = paramJSONObject.optJSONObject("DefaultTab");
          paramJSONObject = "";
          if (localObject != null) {
            paramJSONObject = ((JSONObject)localObject).optString("Key");
          }
          if (paramGameTabData2.DbC.containsKey(paramJSONObject))
          {
            paramGameTabData2.DbD = paramJSONObject;
            AppMethodBeat.o(205609);
            return true;
          }
          paramGameTabData2.DbD = ag(paramGameTabData2.DbC);
          continue;
        }
        i += 1;
      }
      catch (JSONException paramGameTabData2)
      {
        AppMethodBeat.o(205609);
        return false;
      }
    }
  }
  
  private static String ag(Map<String, TabItem> paramMap)
  {
    AppMethodBeat.i(205610);
    try
    {
      paramMap = (String)((Map.Entry)paramMap.entrySet().iterator().next()).getKey();
      AppMethodBeat.o(205610);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(205610);
    }
    return "";
  }
  
  public static GameTabData2 ezJ()
  {
    AppMethodBeat.i(205602);
    GameTabData2 localGameTabData2 = new GameTabData2();
    aj localaj;
    Iterator localIterator;
    if (a.Czb != null)
    {
      if (a.Czb.GameCenterTabSetting == null) {
        break label154;
      }
      localaj = a.Czb.GameCenterTabSetting;
      if ((localaj == null) || (Util.isNullOrNil(localaj.COo))) {
        break label169;
      }
      localIterator = localaj.COo.iterator();
    }
    label154:
    label167:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label169;
      }
      ee localee = (ee)localIterator.next();
      long l2 = localee.rWF;
      if (localee.rWG == 0L) {}
      for (long l1 = 9223372036854775807L;; l1 = localee.rWG)
      {
        if ((Util.nowSecond() < l2) || (Util.nowSecond() > l1) || (!a(localGameTabData2, localee.COn))) {
          break label167;
        }
        Log.i("MicroMsg.GameTabData2", "Get GameTabData from TabStyleList");
        AppMethodBeat.o(205602);
        return localGameTabData2;
        a.ewa();
        localaj = null;
        break;
      }
    }
    label169:
    if ((localaj != null) && (a(localGameTabData2, localaj.COn)))
    {
      Log.i("MicroMsg.GameTabData2", "Get GameTabData from globalConfig");
      AppMethodBeat.o(205602);
      return localGameTabData2;
    }
    try
    {
      if (a(localGameTabData2, new JSONObject(DbF)))
      {
        Log.i("MicroMsg.GameTabData2", "Get GameTabData from local");
        AppMethodBeat.o(205602);
        return localGameTabData2;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.GameTabData2", localJSONException.getMessage());
      AppMethodBeat.o(205602);
    }
    return null;
  }
  
  private void f(Parcel paramParcel)
  {
    AppMethodBeat.i(205599);
    int j = paramParcel.readInt();
    if (this.DbC == null) {
      this.DbC = new a();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.DbC.a(localTabItem.CLE, localTabItem);
      }
      i += 1;
    }
    this.DbD = paramParcel.readString();
    this.nWx = paramParcel.readString();
    this.DbE = paramParcel.readString();
    AppMethodBeat.o(205599);
  }
  
  public final List<TabItem> aCj()
  {
    AppMethodBeat.i(205592);
    ArrayList localArrayList = new ArrayList();
    if (this.DbC != null) {
      localArrayList.addAll(this.DbC.values());
    }
    AppMethodBeat.o(205592);
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String ezI()
  {
    AppMethodBeat.i(205594);
    Object localObject = this.DbC.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = (TabItem)((Iterator)localObject).next();
      if (localTabItem.fEH == 1)
      {
        localObject = localTabItem.CLE;
        AppMethodBeat.o(205594);
        return localObject;
      }
    }
    AppMethodBeat.o(205594);
    return "";
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(205596);
    Object localObject = new JSONArray();
    Iterator localIterator = this.DbC.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        TabItem localTabItem = (TabItem)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("Key", localTabItem.CLE);
          localJSONObject.put("Title", localTabItem.title);
          localJSONObject.put("JumpUrl", localTabItem.jumpUrl);
          if (Util.nullAsNil(this.DbD).equalsIgnoreCase(localTabItem.CLE)) {
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
    AppMethodBeat.o(205596);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(205600);
    paramParcel.writeInt(this.DbC.size());
    Iterator localIterator = this.DbC.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeString(this.DbD);
    paramParcel.writeString(this.nWx);
    paramParcel.writeString(this.DbE);
    AppMethodBeat.o(205600);
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public String CLE;
    public String CLL;
    public String DbH;
    public String DbI;
    public String DbJ;
    public String DbK;
    public String DbL;
    public String DbM;
    public GameTabData2.TabItemWeapp DbN;
    public GameTabData2.TabItemReport DbO;
    public boolean DbP;
    public int DbQ;
    public int DbR;
    public int fEH;
    public String iconUrl;
    public String jumpUrl;
    public String lnt;
    public int position;
    public String title;
    
    static
    {
      AppMethodBeat.i(206744);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(206744);
    }
    
    private TabItem(Parcel paramParcel)
    {
      AppMethodBeat.i(206742);
      this.CLE = paramParcel.readString();
      this.title = paramParcel.readString();
      this.lnt = paramParcel.readString();
      this.DbH = paramParcel.readString();
      this.DbI = paramParcel.readString();
      this.DbJ = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.DbK = paramParcel.readString();
      this.DbL = paramParcel.readString();
      this.DbM = paramParcel.readString();
      this.fEH = paramParcel.readInt();
      this.jumpUrl = paramParcel.readString();
      this.DbN = ((GameTabData2.TabItemWeapp)paramParcel.readParcelable(GameTabData2.TabItemWeapp.class.getClassLoader()));
      this.DbO = ((GameTabData2.TabItemReport)paramParcel.readParcelable(GameTabData2.TabItemReport.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.DbP = bool;
        this.DbQ = paramParcel.readInt();
        this.CLL = paramParcel.readString();
        this.position = paramParcel.readInt();
        AppMethodBeat.o(206742);
        return;
      }
    }
    
    public TabItem(ed paramed)
    {
      AppMethodBeat.i(206739);
      if (paramed == null)
      {
        AppMethodBeat.o(206739);
        return;
      }
      this.CLE = paramed.CRg;
      this.title = paramed.fwr;
      this.lnt = paramed.CRF;
      this.DbH = paramed.CRG;
      this.DbI = paramed.CRH;
      this.DbJ = paramed.CRI;
      this.iconUrl = paramed.CNj;
      this.DbK = paramed.CRJ;
      this.DbL = paramed.CNk;
      this.DbM = paramed.CRK;
      this.fEH = paramed.rWu;
      this.jumpUrl = paramed.CMD;
      this.DbN = new GameTabData2.TabItemWeapp(paramed.CRL);
      this.DbO = new GameTabData2.TabItemReport(paramed.CRM);
      this.DbP = paramed.CRN;
      this.DbQ = paramed.CRO;
      ezL();
      AppMethodBeat.o(206739);
    }
    
    public TabItem(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(206740);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(206740);
        return;
      }
      this.CLE = paramJSONObject.optString("Key");
      this.title = paramJSONObject.optString("Title");
      this.iconUrl = paramJSONObject.optString("IconUrl");
      this.DbK = paramJSONObject.optString("SelectedIconUrl");
      this.DbL = paramJSONObject.optString("DarkModeIconUrl");
      this.DbM = paramJSONObject.optString("DarkModeSelectedIconUrl");
      this.fEH = paramJSONObject.optInt("Type");
      this.jumpUrl = paramJSONObject.optString("JumpUrl");
      this.DbN = new GameTabData2.TabItemWeapp(paramJSONObject.optJSONObject("JumpWeapp"));
      this.DbO = new GameTabData2.TabItemReport(paramJSONObject.optJSONObject("Report"));
      this.DbP = false;
      this.DbQ = 2;
      ezL();
      AppMethodBeat.o(206740);
    }
    
    private static boolean eej()
    {
      return (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG);
    }
    
    private void ezL()
    {
      AppMethodBeat.i(206741);
      switch (this.fEH)
      {
      default: 
        this.CLL = "";
        AppMethodBeat.o(206741);
        return;
      case 1: 
        Long localLong = Long.valueOf(Util.nullAsNil((Long)h.aHG().aHp().get(ar.a.Vrr, Long.valueOf(0L))));
        if ((localLong.longValue() == 0L) || (Math.abs(Util.secondsToNow(localLong.longValue())) >= 172800L)) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.GameTabData2", "forceChatRoomEnable:%b", new Object[] { Boolean.valueOf(bool) });
        if (((a.ewj() != null) && (a.ewj().CNJ)) || (bool) || (eej()))
        {
          this.CLL = ChatRoomTabUI.class.getName();
          AppMethodBeat.o(206741);
          return;
        }
        this.CLL = GameChatTabUI.class.getName();
        AppMethodBeat.o(206741);
        return;
        this.CLL = GameWebTabUI.class.getName();
        AppMethodBeat.o(206741);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final boolean ezK()
    {
      return this.fEH == 1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(206743);
      paramParcel.writeString(this.CLE);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.lnt);
      paramParcel.writeString(this.DbH);
      paramParcel.writeString(this.DbI);
      paramParcel.writeString(this.DbJ);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.DbK);
      paramParcel.writeString(this.DbL);
      paramParcel.writeString(this.DbM);
      paramParcel.writeInt(this.fEH);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeParcelable(this.DbN, paramInt);
      paramParcel.writeParcelable(this.DbO, paramInt);
      if (this.DbP) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.DbQ);
        paramParcel.writeString(this.CLL);
        paramParcel.writeInt(this.position);
        AppMethodBeat.o(206743);
        return;
      }
    }
  }
  
  public static class TabItemReport
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemReport> CREATOR;
    public String CIm;
    public int CLN;
    public int DbS;
    
    static
    {
      AppMethodBeat.i(206518);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(206518);
    }
    
    private TabItemReport(Parcel paramParcel)
    {
      AppMethodBeat.i(206515);
      this.DbS = paramParcel.readInt();
      this.CLN = paramParcel.readInt();
      this.CIm = paramParcel.readString();
      AppMethodBeat.o(206515);
    }
    
    public TabItemReport(ec paramec)
    {
      AppMethodBeat.i(206513);
      if (paramec == null)
      {
        AppMethodBeat.o(206513);
        return;
      }
      this.DbS = paramec.CRE;
      this.CLN = paramec.CNC;
      this.CIm = paramec.CNA;
      AppMethodBeat.o(206513);
    }
    
    public TabItemReport(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(206514);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(206514);
        return;
      }
      this.DbS = paramJSONObject.optInt("AreaId");
      this.CLN = paramJSONObject.optInt("PositionId");
      this.CIm = paramJSONObject.optString("ExternInfo");
      AppMethodBeat.o(206514);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(206517);
      paramParcel.writeInt(this.DbS);
      paramParcel.writeInt(this.CLN);
      paramParcel.writeString(this.CIm);
      AppMethodBeat.o(206517);
    }
  }
  
  public static class TabItemWeapp
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemWeapp> CREATOR;
    public String CqK;
    public String lVG;
    
    static
    {
      AppMethodBeat.i(205070);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(205070);
    }
    
    private TabItemWeapp(Parcel paramParcel)
    {
      AppMethodBeat.i(205067);
      this.lVG = paramParcel.readString();
      this.CqK = paramParcel.readString();
      AppMethodBeat.o(205067);
    }
    
    public TabItemWeapp(eb parameb)
    {
      AppMethodBeat.i(205064);
      if (parameb == null)
      {
        AppMethodBeat.o(205064);
        return;
      }
      this.lVG = parameb.lVG;
      this.CqK = parameb.CqK;
      AppMethodBeat.o(205064);
    }
    
    public TabItemWeapp(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(205066);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(205066);
        return;
      }
      this.lVG = paramJSONObject.optString("AppId");
      this.CqK = paramJSONObject.optString("Path");
      AppMethodBeat.o(205066);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(205069);
      paramParcel.writeString(this.lVG);
      paramParcel.writeString(this.CqK);
      AppMethodBeat.o(205069);
    }
  }
  
  public final class a
    extends LinkedHashMap<String, GameTabData2.TabItem>
  {
    public a() {}
    
    public final GameTabData2.TabItem a(String paramString, GameTabData2.TabItem paramTabItem)
    {
      AppMethodBeat.i(195571);
      paramTabItem.position = (size() + 1);
      paramString = (GameTabData2.TabItem)super.put(paramString, paramTabItem);
      AppMethodBeat.o(195571);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2
 * JD-Core Version:    0.7.0.1
 */