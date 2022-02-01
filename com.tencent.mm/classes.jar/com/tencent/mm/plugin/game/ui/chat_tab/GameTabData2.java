package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.ak;
import com.tencent.mm.plugin.game.protobuf.ed;
import com.tencent.mm.plugin.game.protobuf.ee;
import com.tencent.mm.plugin.game.protobuf.ef;
import com.tencent.mm.plugin.game.protobuf.eg;
import com.tencent.mm.plugin.game.protobuf.eh;
import com.tencent.mm.plugin.game.protobuf.ei;
import com.tencent.mm.plugin.game.protobuf.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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
  private static final String IVZ;
  public a IVW;
  public String IVX;
  public String IVY;
  public String qWk;
  
  static
  {
    AppMethodBeat.i(276747);
    CREATOR = new Parcelable.Creator() {};
    IVZ = "{\n        \"TabList\": [\n            {\n                \"Key\": \"home\",\n                \"Title\": \"首页\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/4f72b9a4850edcba7ff71688b17233b8224fcc357e2357c9c09f74efc5fbb32c\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/b18f15fb59987306a116b4c04929e10cfe08da24ba2d3467043ae3b0a68cc598\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(h.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/contentcenter/feeds.html?wechat_pkgid=contentcenter_feeds&abt=59&ssid=901\"\n            },\n            {\n                \"Key\": \"gameindex\",\n                \"Title\": \"游戏\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/3379a7e14dacfc6c9eea1cc3bce1abc681634348b2d10cb741402f0a7afe1b99\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/e257a6c0d7dd13a2ec717ec5d370871f8624fed7fcf8bd0c9d3a29dee6d01d97\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(h.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/contentcenter/game.html?wechat_pkgid=contentcenter_game&ssid=901\"\n            },\n            {\n                \"Key\": \"community\",\n                \"Title\": \"游戏圈\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/090cb63e719dd5dee494f493d4dc7c767293046c8c37c3d620f3c426a4292806\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/3eea6be7fecf862137602860126a710860466bcb39f19a51d89664147c71aa3d\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://" + WeChatHosts.domainString(h.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/appcenter/community.html?wechat_pkgid=appcenter_community&ssid=901\"\n            },\n            {\n                \"Key\": \"chat\",\n                \"Title\": \"消息\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/70b7e084e27150c4e606618d72b3afd1c474039fead8dadabf5a3438159d3cd5\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/6c4e9abf2c66d9b10e7a8a446a7285c89d0e577a6183eb222708d0cb9fc33bf3\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"Type\": 1\n            }\n        ],\n        \"DefaultTab\": {\n            \"Key\": \"home\"\n        }\n    }";
    AppMethodBeat.o(276747);
  }
  
  public GameTabData2()
  {
    AppMethodBeat.i(276699);
    this.IVW = new a();
    AppMethodBeat.o(276699);
  }
  
  private GameTabData2(Parcel paramParcel)
  {
    AppMethodBeat.i(276702);
    h(paramParcel);
    AppMethodBeat.o(276702);
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, ed paramed)
  {
    AppMethodBeat.i(276732);
    if ((paramed == null) || (Util.isNullOrNil(paramed.ILQ)))
    {
      AppMethodBeat.o(276732);
      return false;
    }
    paramGameTabData2.qWk = paramed.ILS;
    paramGameTabData2.IVY = paramed.ILT;
    Object localObject = paramed.ILQ.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = new TabItem((eh)((Iterator)localObject).next());
      if (!Util.isNullOrNil(localTabItem.IFL)) {
        paramGameTabData2.IVW.a(localTabItem.IFL, localTabItem);
      }
    }
    if (paramGameTabData2.IVW.size() == 0)
    {
      AppMethodBeat.o(276732);
      return false;
    }
    localObject = "";
    if (paramed.ILR != null) {
      localObject = Util.nullAsNil(paramed.ILR.ILw);
    }
    if (paramGameTabData2.IVW.containsKey(localObject)) {}
    for (paramGameTabData2.IVX = ((String)localObject);; paramGameTabData2.IVX = au(paramGameTabData2.IVW))
    {
      AppMethodBeat.o(276732);
      return true;
    }
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(276738);
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.getJSONArray("TabList");
        int i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          TabItem localTabItem = new TabItem(((JSONArray)localObject).optJSONObject(i));
          if (!Util.isNullOrNil(localTabItem.IFL)) {
            paramGameTabData2.IVW.a(localTabItem.IFL, localTabItem);
          }
        }
        else if (paramGameTabData2.IVW.size() != 0)
        {
          localObject = paramJSONObject.optJSONObject("DefaultTab");
          paramJSONObject = "";
          if (localObject != null) {
            paramJSONObject = ((JSONObject)localObject).optString("Key");
          }
          if (paramGameTabData2.IVW.containsKey(paramJSONObject))
          {
            paramGameTabData2.IVX = paramJSONObject;
            AppMethodBeat.o(276738);
            return true;
          }
          paramGameTabData2.IVX = au(paramGameTabData2.IVW);
          continue;
        }
        i += 1;
      }
      catch (JSONException paramGameTabData2)
      {
        AppMethodBeat.o(276738);
        return false;
      }
    }
  }
  
  private static String au(Map<String, TabItem> paramMap)
  {
    AppMethodBeat.i(276740);
    try
    {
      paramMap = (String)((Map.Entry)paramMap.entrySet().iterator().next()).getKey();
      AppMethodBeat.o(276740);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(276740);
    }
    return "";
  }
  
  public static GameTabData2 fHK()
  {
    AppMethodBeat.i(276724);
    GameTabData2 localGameTabData2 = new GameTabData2();
    ak localak;
    Iterator localIterator;
    if (a.IsN != null)
    {
      if (a.IsN.GameCenterTabSetting == null) {
        break label154;
      }
      localak = a.IsN.GameCenterTabSetting;
      if ((localak == null) || (Util.isNullOrNil(localak.IIy))) {
        break label169;
      }
      localIterator = localak.IIy.iterator();
    }
    label154:
    label167:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label169;
      }
      ei localei = (ei)localIterator.next();
      long l2 = localei.vhU;
      if (localei.vhV == 0L) {}
      for (long l1 = 9223372036854775807L;; l1 = localei.vhV)
      {
        if ((Util.nowSecond() < l2) || (Util.nowSecond() > l1) || (!a(localGameTabData2, localei.IIx))) {
          break label167;
        }
        Log.i("MicroMsg.GameTabData2", "Get GameTabData from TabStyleList");
        AppMethodBeat.o(276724);
        return localGameTabData2;
        a.fDQ();
        localak = null;
        break;
      }
    }
    label169:
    if ((localak != null) && (a(localGameTabData2, localak.IIx)))
    {
      Log.i("MicroMsg.GameTabData2", "Get GameTabData from globalConfig");
      AppMethodBeat.o(276724);
      return localGameTabData2;
    }
    try
    {
      if (a(localGameTabData2, new JSONObject(IVZ)))
      {
        Log.i("MicroMsg.GameTabData2", "Get GameTabData from local");
        AppMethodBeat.o(276724);
        return localGameTabData2;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.GameTabData2", localJSONException.getMessage());
      AppMethodBeat.o(276724);
    }
    return null;
  }
  
  private void h(Parcel paramParcel)
  {
    AppMethodBeat.i(276713);
    int j = paramParcel.readInt();
    if (this.IVW == null) {
      this.IVW = new a();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.IVW.a(localTabItem.IFL, localTabItem);
      }
      i += 1;
    }
    this.IVX = paramParcel.readString();
    this.qWk = paramParcel.readString();
    this.IVY = paramParcel.readString();
    AppMethodBeat.o(276713);
  }
  
  public final List<TabItem> aVf()
  {
    AppMethodBeat.i(276752);
    ArrayList localArrayList = new ArrayList();
    if (this.IVW != null) {
      localArrayList.addAll(this.IVW.values());
    }
    AppMethodBeat.o(276752);
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String fHI()
  {
    AppMethodBeat.i(276755);
    Object localObject = this.IVW.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = (TabItem)((Iterator)localObject).next();
      if (localTabItem.hJx == 1)
      {
        localObject = localTabItem.IFL;
        AppMethodBeat.o(276755);
        return localObject;
      }
    }
    AppMethodBeat.o(276755);
    return "";
  }
  
  public final boolean fHJ()
  {
    AppMethodBeat.i(276758);
    Iterator localIterator = this.IVW.values().iterator();
    while (localIterator.hasNext())
    {
      TabItem localTabItem = (TabItem)localIterator.next();
      if ((localTabItem.hJx == 1) && (localTabItem.Aeu))
      {
        AppMethodBeat.o(276758);
        return true;
      }
    }
    AppMethodBeat.o(276758);
    return false;
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(276763);
    Object localObject = new JSONArray();
    Iterator localIterator = this.IVW.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        TabItem localTabItem = (TabItem)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("Key", localTabItem.IFL);
          localJSONObject.put("Title", localTabItem.title);
          localJSONObject.put("JumpUrl", localTabItem.jumpUrl);
          if (Util.nullAsNil(this.IVX).equalsIgnoreCase(localTabItem.IFL)) {
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
    AppMethodBeat.o(276763);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(276767);
    paramParcel.writeInt(this.IVW.size());
    Iterator localIterator = this.IVW.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeString(this.IVX);
    paramParcel.writeString(this.qWk);
    paramParcel.writeString(this.IVY);
    AppMethodBeat.o(276767);
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public boolean Aeu;
    public String IFL;
    public String IFS;
    public String IWb;
    public String IWc;
    public String IWd;
    public String IWe;
    public String IWf;
    public String IWg;
    public GameTabData2.TabItemWeapp IWh;
    public GameTabData2.TabItemReport IWi;
    public boolean IWj;
    public int IWk;
    public int hJx;
    public int hTq;
    public String iconUrl;
    public String jumpUrl;
    public String nSx;
    public int position;
    public String title;
    
    static
    {
      AppMethodBeat.i(276742);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(276742);
    }
    
    private TabItem(Parcel paramParcel)
    {
      AppMethodBeat.i(276734);
      this.Aeu = false;
      this.IFL = paramParcel.readString();
      this.title = paramParcel.readString();
      this.nSx = paramParcel.readString();
      this.IWb = paramParcel.readString();
      this.IWc = paramParcel.readString();
      this.IWd = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.IWe = paramParcel.readString();
      this.IWf = paramParcel.readString();
      this.IWg = paramParcel.readString();
      this.hJx = paramParcel.readInt();
      this.jumpUrl = paramParcel.readString();
      this.IWh = ((GameTabData2.TabItemWeapp)paramParcel.readParcelable(GameTabData2.TabItemWeapp.class.getClassLoader()));
      this.IWi = ((GameTabData2.TabItemReport)paramParcel.readParcelable(GameTabData2.TabItemReport.class.getClassLoader()));
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.IWj = bool1;
        this.IWk = paramParcel.readInt();
        this.IFS = paramParcel.readString();
        this.position = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label207;
        }
      }
      label207:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.Aeu = bool1;
        AppMethodBeat.o(276734);
        return;
        bool1 = false;
        break;
      }
    }
    
    public TabItem(eh parameh)
    {
      AppMethodBeat.i(276709);
      this.Aeu = false;
      if (parameh == null)
      {
        AppMethodBeat.o(276709);
        return;
      }
      this.IFL = parameh.ILw;
      this.title = parameh.hAP;
      this.nSx = parameh.ILV;
      this.IWb = parameh.ILW;
      this.IWc = parameh.ILX;
      this.IWd = parameh.ILY;
      this.iconUrl = parameh.IHo;
      this.IWe = parameh.ILZ;
      this.IWf = parameh.IHp;
      this.IWg = parameh.IMa;
      this.hJx = parameh.vhJ;
      this.jumpUrl = parameh.IGI;
      this.IWh = new GameTabData2.TabItemWeapp(parameh.IMb);
      this.IWi = new GameTabData2.TabItemReport(parameh.IMc);
      this.IWj = parameh.IMd;
      this.IWk = parameh.IMe;
      fHM();
      AppMethodBeat.o(276709);
    }
    
    public TabItem(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(276721);
      this.Aeu = false;
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(276721);
        return;
      }
      this.IFL = paramJSONObject.optString("Key");
      this.title = paramJSONObject.optString("Title");
      this.iconUrl = paramJSONObject.optString("IconUrl");
      this.IWe = paramJSONObject.optString("SelectedIconUrl");
      this.IWf = paramJSONObject.optString("DarkModeIconUrl");
      this.IWg = paramJSONObject.optString("DarkModeSelectedIconUrl");
      this.hJx = paramJSONObject.optInt("Type");
      this.jumpUrl = paramJSONObject.optString("JumpUrl");
      this.IWh = new GameTabData2.TabItemWeapp(paramJSONObject.optJSONObject("JumpWeapp"));
      this.IWi = new GameTabData2.TabItemReport(paramJSONObject.optJSONObject("Report"));
      this.IWj = false;
      this.IWk = 2;
      fHM();
      AppMethodBeat.o(276721);
    }
    
    private void fHM()
    {
      AppMethodBeat.i(276729);
      switch (this.hJx)
      {
      default: 
        this.IFS = "";
        AppMethodBeat.o(276729);
        return;
      case 1: 
        Long localLong = Long.valueOf(Util.nullAsNil((Long)h.baE().ban().get(at.a.acST, Long.valueOf(0L))));
        if ((localLong.longValue() == 0L) || (Math.abs(Util.secondsToNow(localLong.longValue())) >= 172800L)) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.GameTabData2", "forceChatRoomEnable:%b", new Object[] { Boolean.valueOf(bool) });
        if (((a.fDY() != null) && (a.fDY().IHR)) || (bool))
        {
          this.IFS = ChatRoomTabUI.class.getName();
          this.Aeu = true;
          AppMethodBeat.o(276729);
          return;
        }
        this.IFS = GameChatTabUI.class.getName();
        AppMethodBeat.o(276729);
        return;
        this.IFS = GameWebTabUI.class.getName();
        AppMethodBeat.o(276729);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final boolean fHL()
    {
      return this.hJx == 1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(276750);
      paramParcel.writeString(this.IFL);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.nSx);
      paramParcel.writeString(this.IWb);
      paramParcel.writeString(this.IWc);
      paramParcel.writeString(this.IWd);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.IWe);
      paramParcel.writeString(this.IWf);
      paramParcel.writeString(this.IWg);
      paramParcel.writeInt(this.hJx);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeParcelable(this.IWh, paramInt);
      paramParcel.writeParcelable(this.IWi, paramInt);
      if (this.IWj)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.IWk);
        paramParcel.writeString(this.IFS);
        paramParcel.writeInt(this.position);
        if (!this.Aeu) {
          break label188;
        }
      }
      label188:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(276750);
        return;
        paramInt = 0;
        break;
      }
    }
  }
  
  public static class TabItemReport
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemReport> CREATOR;
    public String ICw;
    public int IFU;
    public int IWl;
    
    static
    {
      AppMethodBeat.i(276630);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(276630);
    }
    
    private TabItemReport(Parcel paramParcel)
    {
      AppMethodBeat.i(276619);
      this.IWl = paramParcel.readInt();
      this.IFU = paramParcel.readInt();
      this.ICw = paramParcel.readString();
      AppMethodBeat.o(276619);
    }
    
    public TabItemReport(eg parameg)
    {
      AppMethodBeat.i(276606);
      if (parameg == null)
      {
        AppMethodBeat.o(276606);
        return;
      }
      this.IWl = parameg.ILU;
      this.IFU = parameg.IHK;
      this.ICw = parameg.IHI;
      AppMethodBeat.o(276606);
    }
    
    public TabItemReport(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(276614);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(276614);
        return;
      }
      this.IWl = paramJSONObject.optInt("AreaId");
      this.IFU = paramJSONObject.optInt("PositionId");
      this.ICw = paramJSONObject.optString("ExternInfo");
      AppMethodBeat.o(276614);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(276643);
      paramParcel.writeInt(this.IWl);
      paramParcel.writeInt(this.IFU);
      paramParcel.writeString(this.ICw);
      AppMethodBeat.o(276643);
    }
  }
  
  public static class TabItemWeapp
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemWeapp> CREATOR;
    public String IcT;
    public String oOI;
    
    static
    {
      AppMethodBeat.i(276720);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(276720);
    }
    
    private TabItemWeapp(Parcel paramParcel)
    {
      AppMethodBeat.i(276706);
      this.oOI = paramParcel.readString();
      this.IcT = paramParcel.readString();
      AppMethodBeat.o(276706);
    }
    
    public TabItemWeapp(ef paramef)
    {
      AppMethodBeat.i(276694);
      if (paramef == null)
      {
        AppMethodBeat.o(276694);
        return;
      }
      this.oOI = paramef.oOI;
      this.IcT = paramef.IcT;
      AppMethodBeat.o(276694);
    }
    
    public TabItemWeapp(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(276701);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(276701);
        return;
      }
      this.oOI = paramJSONObject.optString("AppId");
      this.IcT = paramJSONObject.optString("Path");
      AppMethodBeat.o(276701);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(276731);
      paramParcel.writeString(this.oOI);
      paramParcel.writeString(this.IcT);
      AppMethodBeat.o(276731);
    }
  }
  
  public final class a
    extends LinkedHashMap<String, GameTabData2.TabItem>
  {
    public a() {}
    
    public final GameTabData2.TabItem a(String paramString, GameTabData2.TabItem paramTabItem)
    {
      AppMethodBeat.i(276631);
      paramTabItem.position = (size() + 1);
      paramString = (GameTabData2.TabItem)super.put(paramString, paramTabItem);
      AppMethodBeat.o(276631);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2
 * JD-Core Version:    0.7.0.1
 */