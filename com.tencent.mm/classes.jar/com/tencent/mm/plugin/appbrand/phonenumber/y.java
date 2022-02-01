package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"})
public final class y
{
  public long llA = 0L;
  public long llB = 0L;
  long llC = 0L;
  public long llD = 0L;
  public long llE = 0L;
  public long llF = 0L;
  public long llG = 0L;
  public long llH = 0L;
  public long llI = 0L;
  public long llJ = 0L;
  public long llK = 0L;
  public long llL = 0L;
  public long llM = 0L;
  public long llN = 0L;
  public long llO = 0L;
  public long llP = 0L;
  public long llq = 0L;
  public long llr = 0L;
  public long lls = 0L;
  public long llt = 0L;
  public long llu = 0L;
  public long llv = 0L;
  public long llw = 0L;
  public long llx = 0L;
  public long lly = 0L;
  public long llz = 0L;
  
  private y() {}
  
  public y(String paramString)
  {
    this((byte)0);
    AppMethodBeat.i(169647);
    try
    {
      paramString = new JSONObject(paramString);
      this.llq = paramString.optLong("isBindPhone", 0L);
      this.llr = paramString.optLong("bindSuccess", 0L);
      this.lls = paramString.optLong("getPhoneNumberCount", 0L);
      this.llt = paramString.optLong("clickConfirmCount", 0L);
      this.llu = paramString.optLong("clickDenyCount", 0L);
      this.llv = paramString.optLong("clickCancelCount", 0L);
      this.llw = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.llx = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.lly = paramString.optLong("clickInfoCount", 0L);
      this.llz = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.llA = paramString.optLong("clickManagePhoneCount", 0L);
      this.llB = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.llC = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.llD = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.llE = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.llF = paramString.optLong("addPhoneSuccessCount", 0L);
      this.llG = paramString.optLong("addPhoneFailedCount", 0L);
      this.llH = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.llI = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.llJ = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.llK = paramString.optLong("deletePhoneCount", 0L);
      this.llL = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.llM = paramString.optLong("deletePhoneFailedCount", 0L);
      this.llN = paramString.optLong("verifyCodeCount", 0L);
      this.llO = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.llP = paramString.optLong("verifyCodeFailedCount", 0L);
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
    u localu = u.lkN;
    u.blE().a(this);
    AppMethodBeat.o(169646);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169645);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.llq);
    ((JSONObject)localObject).put("bindSuccess", this.llr);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.lls);
    ((JSONObject)localObject).put("clickConfirmCount", this.llt);
    ((JSONObject)localObject).put("clickDenyCount", this.llu);
    ((JSONObject)localObject).put("clickCancelCount", this.llv);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.llw);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.llx);
    ((JSONObject)localObject).put("clickInfoCount", this.lly);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.llz);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.llA);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.llB);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.llC);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.llD);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.llE);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.llF);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.llG);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.llH);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.llI);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.llJ);
    ((JSONObject)localObject).put("deletePhoneCount", this.llK);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.llL);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.llM);
    ((JSONObject)localObject).put("verifyCodeCount", this.llN);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.llO);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.llP);
    localObject = ((JSONObject)localObject).toString();
    k.g(localObject, "jsonObject.toString()");
    AppMethodBeat.o(169645);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.y
 * JD-Core Version:    0.7.0.1
 */