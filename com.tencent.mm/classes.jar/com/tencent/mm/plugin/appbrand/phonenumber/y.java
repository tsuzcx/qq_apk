package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"})
public final class y
{
  public long nAE = 0L;
  public long nAF = 0L;
  public long nAG = 0L;
  public long nAH = 0L;
  public long nAI = 0L;
  public long nAJ = 0L;
  public long nAK = 0L;
  public long nAL = 0L;
  public long nAM = 0L;
  public long nAN = 0L;
  public long nAO = 0L;
  public long nAP = 0L;
  long nAQ = 0L;
  public long nAR = 0L;
  public long nAS = 0L;
  public long nAT = 0L;
  public long nAU = 0L;
  public long nAV = 0L;
  public long nAW = 0L;
  public long nAX = 0L;
  public long nAY = 0L;
  public long nAZ = 0L;
  public long nBa = 0L;
  public long nBb = 0L;
  public long nBc = 0L;
  public long nBd = 0L;
  
  private y() {}
  
  public y(String paramString)
  {
    this((byte)0);
    AppMethodBeat.i(169647);
    try
    {
      paramString = new JSONObject(paramString);
      this.nAE = paramString.optLong("isBindPhone", 0L);
      this.nAF = paramString.optLong("bindSuccess", 0L);
      this.nAG = paramString.optLong("getPhoneNumberCount", 0L);
      this.nAH = paramString.optLong("clickConfirmCount", 0L);
      this.nAI = paramString.optLong("clickDenyCount", 0L);
      this.nAJ = paramString.optLong("clickCancelCount", 0L);
      this.nAK = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.nAL = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.nAM = paramString.optLong("clickInfoCount", 0L);
      this.nAN = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.nAO = paramString.optLong("clickManagePhoneCount", 0L);
      this.nAP = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.nAQ = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.nAR = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.nAS = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.nAT = paramString.optLong("addPhoneSuccessCount", 0L);
      this.nAU = paramString.optLong("addPhoneFailedCount", 0L);
      this.nAV = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.nAW = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.nAX = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.nAY = paramString.optLong("deletePhoneCount", 0L);
      this.nAZ = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.nBa = paramString.optLong("deletePhoneFailedCount", 0L);
      this.nBb = paramString.optLong("verifyCodeCount", 0L);
      this.nBc = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.nBd = paramString.optLong("verifyCodeFailedCount", 0L);
      AppMethodBeat.o(169647);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(169647);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(169646);
    u localu = u.nAe;
    u.bTz().a(this);
    AppMethodBeat.o(169646);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169645);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.nAE);
    ((JSONObject)localObject).put("bindSuccess", this.nAF);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.nAG);
    ((JSONObject)localObject).put("clickConfirmCount", this.nAH);
    ((JSONObject)localObject).put("clickDenyCount", this.nAI);
    ((JSONObject)localObject).put("clickCancelCount", this.nAJ);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.nAK);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.nAL);
    ((JSONObject)localObject).put("clickInfoCount", this.nAM);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.nAN);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.nAO);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.nAP);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.nAQ);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.nAR);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.nAS);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.nAT);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.nAU);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.nAV);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.nAW);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.nAX);
    ((JSONObject)localObject).put("deletePhoneCount", this.nAY);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.nAZ);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.nBa);
    ((JSONObject)localObject).put("verifyCodeCount", this.nBb);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.nBc);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.nBd);
    localObject = ((JSONObject)localObject).toString();
    p.g(localObject, "jsonObject.toString()");
    AppMethodBeat.o(169645);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.y
 * JD-Core Version:    0.7.0.1
 */