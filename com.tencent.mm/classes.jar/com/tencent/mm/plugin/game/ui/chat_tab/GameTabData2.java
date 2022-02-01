package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.dy;
import com.tencent.mm.plugin.game.d.dz;
import com.tencent.mm.plugin.game.d.ea;
import com.tencent.mm.plugin.game.d.eb;
import com.tencent.mm.plugin.game.d.ec;
import com.tencent.mm.plugin.game.d.ed;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public String jZm;
  public a uEZ;
  public String uFa;
  public String uFb;
  
  static
  {
    AppMethodBeat.i(195718);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(195718);
  }
  
  public GameTabData2()
  {
    AppMethodBeat.i(195707);
    this.uEZ = new a();
    AppMethodBeat.o(195707);
  }
  
  private GameTabData2(Parcel paramParcel)
  {
    AppMethodBeat.i(195708);
    e(paramParcel);
    AppMethodBeat.o(195708);
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, dy paramdy)
  {
    AppMethodBeat.i(195715);
    if ((paramdy == null) || (bu.ht(paramdy.uvp)))
    {
      AppMethodBeat.o(195715);
      return false;
    }
    paramGameTabData2.jZm = paramdy.uvr;
    paramGameTabData2.uFb = paramdy.uvs;
    Object localObject = paramdy.uvp.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = new TabItem((ec)((Iterator)localObject).next());
      if (!bu.isNullOrNil(localTabItem.upi)) {
        paramGameTabData2.uEZ.a(localTabItem.upi, localTabItem);
      }
    }
    if (paramGameTabData2.uEZ.size() == 0)
    {
      AppMethodBeat.o(195715);
      return false;
    }
    localObject = "";
    if (paramdy.uvq != null) {
      localObject = bu.nullAsNil(paramdy.uvq.uuW);
    }
    if (paramGameTabData2.uEZ.containsKey(localObject)) {}
    for (paramGameTabData2.uFa = ((String)localObject);; paramGameTabData2.uFa = am(paramGameTabData2.uEZ))
    {
      AppMethodBeat.o(195715);
      return true;
    }
  }
  
  private static boolean a(GameTabData2 paramGameTabData2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195716);
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.getJSONArray("TabList");
        int i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          TabItem localTabItem = new TabItem(((JSONArray)localObject).optJSONObject(i));
          if (!bu.isNullOrNil(localTabItem.upi)) {
            paramGameTabData2.uEZ.a(localTabItem.upi, localTabItem);
          }
        }
        else if (paramGameTabData2.uEZ.size() != 0)
        {
          localObject = paramJSONObject.optJSONObject("DefaultTab");
          paramJSONObject = "";
          if (localObject != null) {
            paramJSONObject = ((JSONObject)localObject).optString("Key");
          }
          if (paramGameTabData2.uEZ.containsKey(paramJSONObject))
          {
            paramGameTabData2.uFa = paramJSONObject;
            AppMethodBeat.o(195716);
            return true;
          }
          paramGameTabData2.uFa = am(paramGameTabData2.uEZ);
          continue;
        }
        i += 1;
      }
      catch (JSONException paramGameTabData2)
      {
        AppMethodBeat.o(195716);
        return false;
      }
    }
  }
  
  private static String am(Map<String, TabItem> paramMap)
  {
    AppMethodBeat.i(195717);
    try
    {
      paramMap = (String)((Map.Entry)paramMap.entrySet().iterator().next()).getKey();
      AppMethodBeat.o(195717);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(195717);
    }
    return "";
  }
  
  public static GameTabData2 dcU()
  {
    AppMethodBeat.i(195714);
    GameTabData2 localGameTabData2 = new GameTabData2();
    ah localah;
    Iterator localIterator;
    if (a.udz != null)
    {
      if (a.udz.uti == null) {
        break label152;
      }
      localah = a.udz.uti;
      if ((localah == null) || (bu.ht(localah.urP))) {
        break label167;
      }
      localIterator = localah.urP.iterator();
    }
    label152:
    label165:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label167;
      }
      ed localed = (ed)localIterator.next();
      long l2 = localed.nJL;
      if (localed.nJM == 0L) {}
      for (long l1 = 9223372036854775807L;; l1 = localed.nJM)
      {
        if ((bu.aRi() < l2) || (bu.aRi() > l1) || (!a(localGameTabData2, localed.urO))) {
          break label165;
        }
        ae.i("MicroMsg.GameTabData2", "Get GameTabData from TabStyleList");
        AppMethodBeat.o(195714);
        return localGameTabData2;
        a.cZs();
        localah = null;
        break;
      }
    }
    label167:
    if ((localah != null) && (a(localGameTabData2, localah.urO)))
    {
      ae.i("MicroMsg.GameTabData2", "Get GameTabData from globalConfig");
      AppMethodBeat.o(195714);
      return localGameTabData2;
    }
    try
    {
      if (a(localGameTabData2, new JSONObject("{\n        \"TabList\": [\n            {\n                \"Key\": \"home\",\n                \"Title\": \"首页\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/4f72b9a4850edcba7ff71688b17233b8224fcc357e2357c9c09f74efc5fbb32c\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/b18f15fb59987306a116b4c04929e10cfe08da24ba2d3467043ae3b0a68cc598\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/783ef37d09913c102b1647db4eefdce9823ed1351b850fcaf30650eec844cf82\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/index_single.html?wechat_pkgid=appcenter_index_single&ssid=901\"\n            },\n            {\n                \"Key\": \"gameindex\",\n                \"Title\": \"游戏\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/3379a7e14dacfc6c9eea1cc3bce1abc681634348b2d10cb741402f0a7afe1b99\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/e257a6c0d7dd13a2ec717ec5d370871f8624fed7fcf8bd0c9d3a29dee6d01d97\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d517ee0b80e2025c8e84c4247275ff9b52e8729c661b49556dc20cfbf717ef5a\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://game.weixin.qq.com/cgi-bin/h5/static/contentcenter/game.html?wechat_pkgid=contentcenter_game&ssid=901\"\n            },\n            {\n                \"Key\": \"community\",\n                \"Title\": \"游戏圈\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/090cb63e719dd5dee494f493d4dc7c767293046c8c37c3d620f3c426a4292806\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/3eea6be7fecf862137602860126a710860466bcb39f19a51d89664147c71aa3d\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/d78d45d5a0ff85d3fa7ef3012301b21e899408c71c9039ed0b7f32884033e329\",\n                \"Type\": 2,\n                \"JumpUrl\": \"https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/community.html?wechat_pkgid=appcenter_community&ssid=901\"\n            },\n            {\n                \"Key\": \"chat\",\n                \"Title\": \"消息\",\n                \"IconUrl\": \"https://mmgame.qpic.cn/image/70b7e084e27150c4e606618d72b3afd1c474039fead8dadabf5a3438159d3cd5\",\n                \"SelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"DarkModeIconUrl\": \"https://mmgame.qpic.cn/image/6c4e9abf2c66d9b10e7a8a446a7285c89d0e577a6183eb222708d0cb9fc33bf3\",\n                \"DarkModeSelectedIconUrl\": \"https://mmgame.qpic.cn/image/52ed44d8619a56364c712245b5426e4aed54091754fc174503f9114fb98d3256\",\n                \"Type\": 1\n            }\n        ],\n        \"DefaultTab\": {\n            \"Key\": \"home\"\n        }\n    }")))
      {
        ae.i("MicroMsg.GameTabData2", "Get GameTabData from local");
        AppMethodBeat.o(195714);
        return localGameTabData2;
      }
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.GameTabData2", localJSONException.getMessage());
      AppMethodBeat.o(195714);
    }
    return null;
  }
  
  private void e(Parcel paramParcel)
  {
    AppMethodBeat.i(195712);
    int j = paramParcel.readInt();
    if (this.uEZ == null) {
      this.uEZ = new a();
    }
    int i = 0;
    while (i < j)
    {
      TabItem localTabItem = (TabItem)paramParcel.readParcelable(TabItem.class.getClassLoader());
      if (localTabItem != null) {
        this.uEZ.a(localTabItem.upi, localTabItem);
      }
      i += 1;
    }
    this.uFa = paramParcel.readString();
    this.jZm = paramParcel.readString();
    this.uFb = paramParcel.readString();
    AppMethodBeat.o(195712);
  }
  
  public final List<TabItem> afz()
  {
    AppMethodBeat.i(195709);
    ArrayList localArrayList = new ArrayList();
    if (this.uEZ != null) {
      localArrayList.addAll(this.uEZ.values());
    }
    AppMethodBeat.o(195709);
    return localArrayList;
  }
  
  public final String dcT()
  {
    AppMethodBeat.i(195710);
    Object localObject = this.uEZ.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabItem localTabItem = (TabItem)((Iterator)localObject).next();
      if (localTabItem.dvm == 1)
      {
        localObject = localTabItem.upi;
        AppMethodBeat.o(195710);
        return localObject;
      }
    }
    AppMethodBeat.o(195710);
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(195711);
    Object localObject = new JSONArray();
    Iterator localIterator = this.uEZ.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        TabItem localTabItem = (TabItem)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("Key", localTabItem.upi);
          localJSONObject.put("Title", localTabItem.title);
          localJSONObject.put("JumpUrl", localTabItem.jumpUrl);
          if (bu.nullAsNil(this.uFa).equalsIgnoreCase(localTabItem.upi)) {
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
    AppMethodBeat.o(195711);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(195713);
    paramParcel.writeInt(this.uEZ.size());
    Iterator localIterator = this.uEZ.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Map.Entry)localIterator.next()).getValue(), paramInt);
    }
    paramParcel.writeString(this.uFa);
    paramParcel.writeString(this.jZm);
    paramParcel.writeString(this.uFb);
    AppMethodBeat.o(195713);
  }
  
  public static class TabItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItem> CREATOR;
    public int dvm;
    public String iconUrl;
    public String jumpUrl;
    public int position;
    public String title;
    public String titleColor;
    public String uFd;
    public String uFe;
    public String uFf;
    public String uFg;
    public String uFh;
    public String uFi;
    public GameTabData2.TabItemWeapp uFj;
    public GameTabData2.TabItemReport uFk;
    public boolean uFl;
    public int uFm;
    public int uFn;
    public String upi;
    public String upp;
    
    static
    {
      AppMethodBeat.i(195694);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195694);
    }
    
    private TabItem(Parcel paramParcel)
    {
      AppMethodBeat.i(195692);
      this.upi = paramParcel.readString();
      this.title = paramParcel.readString();
      this.titleColor = paramParcel.readString();
      this.uFd = paramParcel.readString();
      this.uFe = paramParcel.readString();
      this.uFf = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.uFg = paramParcel.readString();
      this.uFh = paramParcel.readString();
      this.uFi = paramParcel.readString();
      this.dvm = paramParcel.readInt();
      this.jumpUrl = paramParcel.readString();
      this.uFj = ((GameTabData2.TabItemWeapp)paramParcel.readParcelable(GameTabData2.TabItemWeapp.class.getClassLoader()));
      this.uFk = ((GameTabData2.TabItemReport)paramParcel.readParcelable(GameTabData2.TabItemReport.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.uFl = bool;
        this.uFm = paramParcel.readInt();
        this.upp = paramParcel.readString();
        this.position = paramParcel.readInt();
        AppMethodBeat.o(195692);
        return;
      }
    }
    
    public TabItem(ec paramec)
    {
      AppMethodBeat.i(195689);
      if (paramec == null)
      {
        AppMethodBeat.o(195689);
        return;
      }
      this.upi = paramec.uuW;
      this.title = paramec.Title;
      this.titleColor = paramec.uvu;
      this.uFd = paramec.uvv;
      this.uFe = paramec.uvw;
      this.uFf = paramec.uvx;
      this.iconUrl = paramec.IconUrl;
      this.uFg = paramec.uvy;
      this.uFh = paramec.uqL;
      this.uFi = paramec.uvz;
      this.dvm = paramec.nJA;
      this.jumpUrl = paramec.uqf;
      this.uFj = new GameTabData2.TabItemWeapp(paramec.uvA);
      this.uFk = new GameTabData2.TabItemReport(paramec.uvB);
      this.uFl = paramec.uvC;
      this.uFm = paramec.uvD;
      dcV();
      AppMethodBeat.o(195689);
    }
    
    public TabItem(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(195690);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(195690);
        return;
      }
      this.upi = paramJSONObject.optString("Key");
      this.title = paramJSONObject.optString("Title");
      this.iconUrl = paramJSONObject.optString("IconUrl");
      this.uFg = paramJSONObject.optString("SelectedIconUrl");
      this.uFh = paramJSONObject.optString("DarkModeIconUrl");
      this.uFi = paramJSONObject.optString("DarkModeSelectedIconUrl");
      this.dvm = paramJSONObject.optInt("Type");
      this.jumpUrl = paramJSONObject.optString("JumpUrl");
      this.uFj = new GameTabData2.TabItemWeapp(paramJSONObject.optJSONObject("JumpWeapp"));
      this.uFk = new GameTabData2.TabItemReport(paramJSONObject.optJSONObject("Report"));
      this.uFl = false;
      this.uFm = 2;
      dcV();
      AppMethodBeat.o(195690);
    }
    
    private void dcV()
    {
      AppMethodBeat.i(195691);
      switch (this.dvm)
      {
      default: 
        this.upp = "";
        AppMethodBeat.o(195691);
        return;
      case 1: 
        this.upp = GameChatTabUI.class.getName();
        AppMethodBeat.o(195691);
        return;
      }
      this.upp = GameWebTabUI.class.getName();
      AppMethodBeat.o(195691);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195693);
      paramParcel.writeString(this.upi);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.titleColor);
      paramParcel.writeString(this.uFd);
      paramParcel.writeString(this.uFe);
      paramParcel.writeString(this.uFf);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.uFg);
      paramParcel.writeString(this.uFh);
      paramParcel.writeString(this.uFi);
      paramParcel.writeInt(this.dvm);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeParcelable(this.uFj, paramInt);
      paramParcel.writeParcelable(this.uFk, paramInt);
      if (this.uFl) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.uFm);
        paramParcel.writeString(this.upp);
        paramParcel.writeInt(this.position);
        AppMethodBeat.o(195693);
        return;
      }
    }
  }
  
  public static class TabItemReport
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemReport> CREATOR;
    public int uFo;
    public String ulT;
    public int upr;
    
    static
    {
      AppMethodBeat.i(195700);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195700);
    }
    
    private TabItemReport(Parcel paramParcel)
    {
      AppMethodBeat.i(195698);
      this.uFo = paramParcel.readInt();
      this.upr = paramParcel.readInt();
      this.ulT = paramParcel.readString();
      AppMethodBeat.o(195698);
    }
    
    public TabItemReport(eb parameb)
    {
      AppMethodBeat.i(195696);
      if (parameb == null)
      {
        AppMethodBeat.o(195696);
        return;
      }
      this.uFo = parameb.uvt;
      this.upr = parameb.urc;
      this.ulT = parameb.ura;
      AppMethodBeat.o(195696);
    }
    
    public TabItemReport(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(195697);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(195697);
        return;
      }
      this.uFo = paramJSONObject.optInt("AreaId");
      this.upr = paramJSONObject.optInt("PositionId");
      this.ulT = paramJSONObject.optString("ExternInfo");
      AppMethodBeat.o(195697);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195699);
      paramParcel.writeInt(this.uFo);
      paramParcel.writeInt(this.upr);
      paramParcel.writeString(this.ulT);
      AppMethodBeat.o(195699);
    }
  }
  
  public static class TabItemWeapp
    implements Parcelable
  {
    public static final Parcelable.Creator<TabItemWeapp> CREATOR;
    public String ikm;
    public String uuA;
    
    static
    {
      AppMethodBeat.i(195706);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195706);
    }
    
    private TabItemWeapp(Parcel paramParcel)
    {
      AppMethodBeat.i(195704);
      this.ikm = paramParcel.readString();
      this.uuA = paramParcel.readString();
      AppMethodBeat.o(195704);
    }
    
    public TabItemWeapp(ea paramea)
    {
      AppMethodBeat.i(195702);
      if (paramea == null)
      {
        AppMethodBeat.o(195702);
        return;
      }
      this.ikm = paramea.ikm;
      this.uuA = paramea.uuA;
      AppMethodBeat.o(195702);
    }
    
    public TabItemWeapp(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(195703);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(195703);
        return;
      }
      this.ikm = paramJSONObject.optString("AppId");
      this.uuA = paramJSONObject.optString("Path");
      AppMethodBeat.o(195703);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195705);
      paramParcel.writeString(this.ikm);
      paramParcel.writeString(this.uuA);
      AppMethodBeat.o(195705);
    }
  }
  
  public final class a
    extends LinkedHashMap<String, GameTabData2.TabItem>
  {
    public a() {}
    
    public final GameTabData2.TabItem a(String paramString, GameTabData2.TabItem paramTabItem)
    {
      AppMethodBeat.i(195686);
      paramTabItem.position = (size() + 1);
      paramString = (GameTabData2.TabItem)super.put(paramString, paramTabItem);
      AppMethodBeat.o(195686);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2
 * JD-Core Version:    0.7.0.1
 */