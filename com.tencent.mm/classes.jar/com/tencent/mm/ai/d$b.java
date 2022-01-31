package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b
{
  private int dWx = 0;
  private String efA;
  private boolean efB = false;
  public d.b.a efC;
  private List<WxaAttributes.WxaEntryInfo> efD;
  public JSONObject efa = null;
  private boolean efb = true;
  public boolean efc = false;
  private boolean efd = false;
  public boolean efe = false;
  private String eff;
  private String efg;
  private List<d.b.f> efh = null;
  private d.b.d efi = null;
  private d.b.c efj = null;
  private d.b.e efk = null;
  d.b.c.a efl = null;
  private boolean efm = false;
  boolean efn = false;
  int efo;
  public boolean efp = false;
  public int efq = 0;
  private String efr;
  private d.b.b efs = null;
  private int eft = 0;
  private int efu = d.eeT;
  private String efv;
  private boolean efw = false;
  private int efx;
  private d.b.g efy;
  private String efz;
  
  static b kI(String paramString)
  {
    b localb = new b();
    if (bk.bl(paramString)) {
      return localb;
    }
    try
    {
      System.currentTimeMillis();
      localb.efa = new JSONObject(paramString);
      return localb;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return localb;
  }
  
  public final boolean LI()
  {
    if ((this.efa != null) && (this.efa.optJSONObject("WifiBizInfo") != null) && (this.efa.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
      this.efB = true;
    }
    return this.efB;
  }
  
  public final boolean LJ()
  {
    if (this.efa != null) {
      this.efd = "1".equals(this.efa.optString("IsShowMember"));
    }
    return this.efd;
  }
  
  public final boolean LK()
  {
    if (this.efa != null) {
      this.efu = bk.getInt(this.efa.optString("NotifyManage"), d.eeT);
    }
    return this.efu == d.eeS;
  }
  
  public final String LL()
  {
    if (this.efa != null) {
      this.eff = this.efa.optString("VerifyContactPromptTitle");
    }
    return this.eff;
  }
  
  public final String LM()
  {
    if (this.efa != null) {
      this.efz = this.efa.optString("TrademarkUrl");
    }
    return this.efz;
  }
  
  public final String LN()
  {
    if (this.efa != null) {
      this.efA = this.efa.optString("TrademarkName");
    }
    return this.efA;
  }
  
  public final String LO()
  {
    if (this.efa != null) {
      this.efg = this.efa.optString("ConferenceContactExpireTime");
    }
    return this.efg;
  }
  
  public final List<d.b.f> LP()
  {
    if ((this.efa != null) && (this.efh == null)) {
      this.efh = d.b.f.c(this.efa.optJSONArray("Privilege"));
    }
    return this.efh;
  }
  
  public final int LQ()
  {
    if (this.efa != null) {
      this.eft = this.efa.optInt("InteractiveMode");
    }
    return this.eft;
  }
  
  public final d.b.e LR()
  {
    if ((this.efa != null) && (this.efk == null)) {
      this.efk = d.b.e.kO(this.efa.optString("PayShowInfo"));
    }
    return this.efk;
  }
  
  public final d.b.b LS()
  {
    if ((this.efa != null) && (this.efs == null))
    {
      String str = this.efa.optString("HardwareBizInfo");
      if (str != null) {
        this.efs = d.b.b.kK(str);
      }
    }
    return this.efs;
  }
  
  public final d.b.d LT()
  {
    if ((this.efa != null) && (this.efi == null)) {
      this.efi = d.b.d.kN(this.efa.optString("VerifySource"));
    }
    return this.efi;
  }
  
  public final d.b.g LU()
  {
    if ((this.efa != null) && (this.efy == null))
    {
      String str = this.efa.optString("RegisterSource");
      if (str != null) {
        this.efy = d.b.g.kP(str);
      }
    }
    return this.efy;
  }
  
  public final boolean LV()
  {
    boolean bool = true;
    if (this.efa != null) {
      if (bk.getInt(this.efa.optString("IsTrademarkProtection"), 0) != 1) {
        break label37;
      }
    }
    for (;;)
    {
      this.efw = bool;
      return this.efw;
      label37:
      bool = false;
    }
  }
  
  public final int LW()
  {
    if (this.efa != null) {
      this.dWx = this.efa.optInt("ServiceType", 0);
    }
    return this.dWx;
  }
  
  public final String LX()
  {
    if (this.efa != null) {
      this.efr = this.efa.optString("SupportEmoticonLinkPrefix");
    }
    return this.efr;
  }
  
  public final d.b.c LY()
  {
    if ((this.efa != null) && (this.efj == null))
    {
      String str = this.efa.optString("MMBizMenu");
      if (str != null) {
        this.efj = d.b.c.kL(str);
      }
    }
    return this.efj;
  }
  
  public final String LZ()
  {
    if (this.efa != null) {
      this.efv = this.efa.optString("ServicePhone");
    }
    return this.efv;
  }
  
  public final boolean Lu()
  {
    boolean bool = false;
    if (this.efa != null)
    {
      if (bk.getInt(this.efa.optString("ReportLocationType"), 0) > 0) {
        bool = true;
      }
      this.efm = bool;
    }
    return this.efm;
  }
  
  public final boolean Ma()
  {
    if (this.efa != null) {
      this.efx = this.efa.optInt("FunctionFlag");
    }
    return (this.efx & d.eeU) > 0;
  }
  
  public final d.b.c.a Mb()
  {
    if ((this.efa != null) && (this.efl == null))
    {
      String str = this.efa.optString("EnterpriseBizInfo");
      if (str != null) {
        this.efl = d.b.c.a.kM(str);
      }
    }
    return this.efl;
  }
  
  public final List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList()
  {
    Object localObject1;
    if (this.efD == null)
    {
      this.efD = new LinkedList();
      if (this.efa != null)
      {
        localObject1 = this.efa.optString("BindWxaInfo");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 == null) {
          break label218;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("wxaEntryInfo");
        if (localObject1 == null) {
          break label213;
        }
        int i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label213;
        }
        Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject3 != null)
        {
          String str1 = ((JSONObject)localObject3).optString("username");
          String str2 = ((JSONObject)localObject3).optString("title");
          String str3 = ((JSONObject)localObject3).optString("title_key");
          localObject3 = ((JSONObject)localObject3).optString("icon_url");
          if ((!TextUtils.isEmpty(str1)) && ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3))))
          {
            WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
            localWxaEntryInfo.username = str1;
            localWxaEntryInfo.title = str2;
            localWxaEntryInfo.fRq = str3;
            localWxaEntryInfo.iconUrl = ((String)localObject3);
            this.efD.add(localWxaEntryInfo);
          }
        }
        i += 1;
        continue;
        localObject2 = null;
      }
      catch (JSONException localJSONException) {}
      continue;
      label213:
      return this.efD;
      label218:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ai.d.b
 * JD-Core Version:    0.7.0.1
 */