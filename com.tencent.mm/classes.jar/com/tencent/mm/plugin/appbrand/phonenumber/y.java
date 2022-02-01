package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "appId", "phoneNumber", "(JJJJJJJJJJJJJJJJJJJJJJJJJJLjava/lang/String;Ljava/lang/String;)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getAppId", "()Ljava/lang/String;", "setAppId", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getPhoneNumber", "setPhoneNumber", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  public String appId;
  public String iaX;
  public long tHM;
  public long tHN;
  public long tHO;
  public long tHP;
  public long tHQ;
  public long tHR;
  public long tHS;
  public long tHT;
  public long tHU;
  public long tHV;
  public long tHW;
  public long tHX;
  long tHY;
  public long tHZ;
  public long tIa;
  public long tIb;
  public long tIc;
  public long tId;
  public long tIe;
  public long tIf;
  public long tIg;
  public long tIh;
  public long tIi;
  public long tIj;
  public long tIk;
  public long tIl;
  
  public y(String paramString)
  {
    this();
    AppMethodBeat.i(169647);
    try
    {
      paramString = new JSONObject(paramString);
      this.tHM = paramString.optLong("isBindPhone", 0L);
      this.tHN = paramString.optLong("bindSuccess", 0L);
      this.tHO = paramString.optLong("getPhoneNumberCount", 0L);
      this.tHP = paramString.optLong("clickConfirmCount", 0L);
      this.tHQ = paramString.optLong("clickDenyCount", 0L);
      this.tHR = paramString.optLong("clickCancelCount", 0L);
      this.tHS = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.tHT = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.tHU = paramString.optLong("clickInfoCount", 0L);
      this.tHV = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.tHW = paramString.optLong("clickManagePhoneCount", 0L);
      this.tHX = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.tHY = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.tHZ = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.tIa = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.tIb = paramString.optLong("addPhoneSuccessCount", 0L);
      this.tIc = paramString.optLong("addPhoneFailedCount", 0L);
      this.tId = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.tIe = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.tIf = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.tIg = paramString.optLong("deletePhoneCount", 0L);
      this.tIh = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.tIi = paramString.optLong("deletePhoneFailedCount", 0L);
      this.tIj = paramString.optLong("verifyCodeCount", 0L);
      this.tIk = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.tIl = paramString.optLong("verifyCodeFailedCount", 0L);
      String str = paramString.optString("appId", "");
      s.s(str, "jsonObject.optString(\"appId\", \"\")");
      this.appId = str;
      paramString = paramString.optString("phoneNumber", "");
      s.s(paramString, "jsonObject.optString(\"phoneNumber\", \"\")");
      this.iaX = paramString;
      AppMethodBeat.o(169647);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(169647);
    }
  }
  
  private y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318864);
    this.tHM = 0L;
    this.tHN = 0L;
    this.tHO = 0L;
    this.tHP = 0L;
    this.tHQ = 0L;
    this.tHR = 0L;
    this.tHS = 0L;
    this.tHT = 0L;
    this.tHU = 0L;
    this.tHV = 0L;
    this.tHW = 0L;
    this.tHX = 0L;
    this.tHY = 0L;
    this.tHZ = 0L;
    this.tIa = 0L;
    this.tIb = 0L;
    this.tIc = 0L;
    this.tId = 0L;
    this.tIe = 0L;
    this.tIf = 0L;
    this.tIg = 0L;
    this.tIh = 0L;
    this.tIi = 0L;
    this.tIj = 0L;
    this.tIk = 0L;
    this.tIl = 0L;
    this.appId = paramString1;
    this.iaX = paramString2;
    AppMethodBeat.o(318864);
  }
  
  public final void afA(String paramString)
  {
    AppMethodBeat.i(318882);
    s.u(paramString, "<set-?>");
    this.iaX = paramString;
    AppMethodBeat.o(318882);
  }
  
  public final void report()
  {
    AppMethodBeat.i(169646);
    u localu = u.tHm;
    u.cHB().a(this);
    AppMethodBeat.o(169646);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(318878);
    s.u(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(318878);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169645);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.tHM);
    ((JSONObject)localObject).put("bindSuccess", this.tHN);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.tHO);
    ((JSONObject)localObject).put("clickConfirmCount", this.tHP);
    ((JSONObject)localObject).put("clickDenyCount", this.tHQ);
    ((JSONObject)localObject).put("clickCancelCount", this.tHR);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.tHS);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.tHT);
    ((JSONObject)localObject).put("clickInfoCount", this.tHU);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.tHV);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.tHW);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.tHX);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.tHY);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.tHZ);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.tIa);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.tIb);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.tIc);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.tId);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.tIe);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.tIf);
    ((JSONObject)localObject).put("deletePhoneCount", this.tIg);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.tIh);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.tIi);
    ((JSONObject)localObject).put("verifyCodeCount", this.tIj);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.tIk);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.tIl);
    ((JSONObject)localObject).put("appId", this.appId);
    ((JSONObject)localObject).put("phoneNumber", this.iaX);
    localObject = ((JSONObject)localObject).toString();
    s.s(localObject, "jsonObject.toString()");
    AppMethodBeat.o(169645);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.y
 * JD-Core Version:    0.7.0.1
 */