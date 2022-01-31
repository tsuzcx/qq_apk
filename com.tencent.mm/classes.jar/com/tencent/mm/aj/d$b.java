package com.tencent.mm.aj;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b
{
  private int fmF = 0;
  private d.b.g fvA;
  private String fvB;
  private String fvC;
  private boolean fvD = false;
  public d.b.a fvE;
  private List<WxaAttributes.WxaEntryInfo> fvF;
  public JSONObject fvc = null;
  private boolean fvd = true;
  public boolean fve = false;
  private boolean fvf = false;
  public boolean fvg = false;
  private String fvh;
  private String fvi;
  private List<d.b.f> fvj = null;
  private d.b.d fvk = null;
  private d.b.c fvl = null;
  private d.b.e fvm = null;
  d.b.c.a fvn = null;
  private boolean fvo = false;
  boolean fvp = false;
  int fvq;
  public boolean fvr = false;
  public int fvs = 0;
  private String fvt;
  private d.b.b fvu = null;
  private int fvv = 0;
  private int fvw = d.fuV;
  private String fvx;
  private boolean fvy = false;
  private int fvz;
  
  static b rC(String paramString)
  {
    AppMethodBeat.i(11300);
    b localb = new b();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11300);
      return localb;
    }
    try
    {
      System.currentTimeMillis();
      localb.fvc = new JSONObject(paramString);
      AppMethodBeat.o(11300);
      return localb;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramString) });
      }
    }
  }
  
  public final d.b.b aeA()
  {
    AppMethodBeat.i(11290);
    if ((this.fvc != null) && (this.fvu == null))
    {
      localObject = this.fvc.optString("HardwareBizInfo");
      if (localObject != null) {
        this.fvu = d.b.b.rE((String)localObject);
      }
    }
    Object localObject = this.fvu;
    AppMethodBeat.o(11290);
    return localObject;
  }
  
  public final d.b.d aeB()
  {
    AppMethodBeat.i(11291);
    if ((this.fvc != null) && (this.fvk == null)) {
      this.fvk = d.b.d.rH(this.fvc.optString("VerifySource"));
    }
    d.b.d locald = this.fvk;
    AppMethodBeat.o(11291);
    return locald;
  }
  
  public final d.b.g aeC()
  {
    AppMethodBeat.i(11292);
    if ((this.fvc != null) && (this.fvA == null))
    {
      localObject = this.fvc.optString("RegisterSource");
      if (localObject != null) {
        this.fvA = d.b.g.rJ((String)localObject);
      }
    }
    Object localObject = this.fvA;
    AppMethodBeat.o(11292);
    return localObject;
  }
  
  public final boolean aeD()
  {
    boolean bool = true;
    AppMethodBeat.i(11294);
    if (this.fvc != null) {
      if (bo.getInt(this.fvc.optString("IsTrademarkProtection"), 0) != 1) {
        break label50;
      }
    }
    for (;;)
    {
      this.fvy = bool;
      bool = this.fvy;
      AppMethodBeat.o(11294);
      return bool;
      label50:
      bool = false;
    }
  }
  
  public final String aeE()
  {
    AppMethodBeat.i(11296);
    if (this.fvc != null) {
      this.fvt = this.fvc.optString("SupportEmoticonLinkPrefix");
    }
    String str = this.fvt;
    AppMethodBeat.o(11296);
    return str;
  }
  
  public final d.b.c aeF()
  {
    AppMethodBeat.i(11297);
    if ((this.fvc != null) && (this.fvl == null))
    {
      localObject = this.fvc.optString("MMBizMenu");
      if (localObject != null) {
        this.fvl = d.b.c.rF((String)localObject);
      }
    }
    Object localObject = this.fvl;
    AppMethodBeat.o(11297);
    return localObject;
  }
  
  public final String aeG()
  {
    AppMethodBeat.i(11298);
    if (this.fvc != null) {
      this.fvx = this.fvc.optString("ServicePhone");
    }
    String str = this.fvx;
    AppMethodBeat.o(11298);
    return str;
  }
  
  public final boolean aeH()
  {
    AppMethodBeat.i(11299);
    if (this.fvc != null) {
      this.fvz = this.fvc.optInt("FunctionFlag");
    }
    if ((this.fvz & d.fuW) > 0)
    {
      AppMethodBeat.o(11299);
      return true;
    }
    AppMethodBeat.o(11299);
    return false;
  }
  
  public final d.b.c.a aeI()
  {
    AppMethodBeat.i(11301);
    if ((this.fvc != null) && (this.fvn == null))
    {
      localObject = this.fvc.optString("EnterpriseBizInfo");
      if (localObject != null) {
        this.fvn = d.b.c.a.rG((String)localObject);
      }
    }
    Object localObject = this.fvn;
    AppMethodBeat.o(11301);
    return localObject;
  }
  
  public final boolean aec()
  {
    boolean bool = false;
    AppMethodBeat.i(11293);
    if (this.fvc != null)
    {
      if (bo.getInt(this.fvc.optString("ReportLocationType"), 0) > 0) {
        bool = true;
      }
      this.fvo = bool;
    }
    bool = this.fvo;
    AppMethodBeat.o(11293);
    return bool;
  }
  
  public final boolean aeq()
  {
    AppMethodBeat.i(11280);
    if ((this.fvc != null) && (this.fvc.optJSONObject("WifiBizInfo") != null) && (this.fvc.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
      this.fvD = true;
    }
    boolean bool = this.fvD;
    AppMethodBeat.o(11280);
    return bool;
  }
  
  public final boolean aer()
  {
    AppMethodBeat.i(11281);
    if (this.fvc != null) {
      this.fvf = "1".equals(this.fvc.optString("IsShowMember"));
    }
    boolean bool = this.fvf;
    AppMethodBeat.o(11281);
    return bool;
  }
  
  public final boolean aes()
  {
    AppMethodBeat.i(11282);
    if (this.fvc != null) {
      this.fvw = bo.getInt(this.fvc.optString("NotifyManage"), d.fuV);
    }
    if (this.fvw == d.fuU)
    {
      AppMethodBeat.o(11282);
      return true;
    }
    AppMethodBeat.o(11282);
    return false;
  }
  
  public final String aet()
  {
    AppMethodBeat.i(11283);
    if (this.fvc != null) {
      this.fvh = this.fvc.optString("VerifyContactPromptTitle");
    }
    String str = this.fvh;
    AppMethodBeat.o(11283);
    return str;
  }
  
  public final String aeu()
  {
    AppMethodBeat.i(11284);
    if (this.fvc != null) {
      this.fvB = this.fvc.optString("TrademarkUrl");
    }
    String str = this.fvB;
    AppMethodBeat.o(11284);
    return str;
  }
  
  public final String aev()
  {
    AppMethodBeat.i(11285);
    if (this.fvc != null) {
      this.fvC = this.fvc.optString("TrademarkName");
    }
    String str = this.fvC;
    AppMethodBeat.o(11285);
    return str;
  }
  
  public final String aew()
  {
    AppMethodBeat.i(11286);
    if (this.fvc != null) {
      this.fvi = this.fvc.optString("ConferenceContactExpireTime");
    }
    String str = this.fvi;
    AppMethodBeat.o(11286);
    return str;
  }
  
  public final List<d.b.f> aex()
  {
    AppMethodBeat.i(11287);
    if ((this.fvc != null) && (this.fvj == null)) {
      this.fvj = d.b.f.d(this.fvc.optJSONArray("Privilege"));
    }
    List localList = this.fvj;
    AppMethodBeat.o(11287);
    return localList;
  }
  
  public final int aey()
  {
    AppMethodBeat.i(11288);
    if (this.fvc != null) {
      this.fvv = this.fvc.optInt("InteractiveMode");
    }
    int i = this.fvv;
    AppMethodBeat.o(11288);
    return i;
  }
  
  public final d.b.e aez()
  {
    AppMethodBeat.i(11289);
    if ((this.fvc != null) && (this.fvm == null)) {
      this.fvm = d.b.e.rI(this.fvc.optString("PayShowInfo"));
    }
    d.b.e locale = this.fvm;
    AppMethodBeat.o(11289);
    return locale;
  }
  
  public final int getServiceType()
  {
    AppMethodBeat.i(11295);
    if (this.fvc != null) {
      this.fmF = this.fvc.optInt("ServiceType", 0);
    }
    int i = this.fmF;
    AppMethodBeat.o(11295);
    return i;
  }
  
  public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    AppMethodBeat.i(11279);
    Object localObject1;
    if (this.fvF == null)
    {
      this.fvF = new LinkedList();
      if (this.fvc != null)
      {
        localObject1 = this.fvc.optString("BindWxaInfo");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 == null) {
          break label232;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("wxaEntryInfo");
        if (localObject1 == null) {
          break label219;
        }
        int i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label219;
        }
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 != null)
        {
          String str1 = ((JSONObject)localObject2).optString("username");
          String str2 = ((JSONObject)localObject2).optString("title");
          String str3 = ((JSONObject)localObject2).optString("title_key");
          localObject2 = ((JSONObject)localObject2).optString("icon_url");
          if ((!TextUtils.isEmpty(str1)) && ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3))))
          {
            WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
            localWxaEntryInfo.username = str1;
            localWxaEntryInfo.title = str2;
            localWxaEntryInfo.hkc = str3;
            localWxaEntryInfo.iconUrl = ((String)localObject2);
            this.fvF.add(localWxaEntryInfo);
          }
        }
        i += 1;
        continue;
        localList = null;
      }
      catch (JSONException localJSONException) {}
      continue;
      label219:
      List localList = this.fvF;
      AppMethodBeat.o(11279);
      return localList;
      label232:
      localList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aj.d.b
 * JD-Core Version:    0.7.0.1
 */