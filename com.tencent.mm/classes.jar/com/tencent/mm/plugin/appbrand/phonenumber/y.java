package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"})
public final class y
{
  public long lLA = 0L;
  public long lLB = 0L;
  public long lLC = 0L;
  public long lLD = 0L;
  public long lLE = 0L;
  public long lLF = 0L;
  public long lLG = 0L;
  public long lLh = 0L;
  public long lLi = 0L;
  public long lLj = 0L;
  public long lLk = 0L;
  public long lLl = 0L;
  public long lLm = 0L;
  public long lLn = 0L;
  public long lLo = 0L;
  public long lLp = 0L;
  public long lLq = 0L;
  public long lLr = 0L;
  public long lLs = 0L;
  long lLt = 0L;
  public long lLu = 0L;
  public long lLv = 0L;
  public long lLw = 0L;
  public long lLx = 0L;
  public long lLy = 0L;
  public long lLz = 0L;
  
  private y() {}
  
  public y(String paramString)
  {
    this((byte)0);
    AppMethodBeat.i(169647);
    try
    {
      paramString = new JSONObject(paramString);
      this.lLh = paramString.optLong("isBindPhone", 0L);
      this.lLi = paramString.optLong("bindSuccess", 0L);
      this.lLj = paramString.optLong("getPhoneNumberCount", 0L);
      this.lLk = paramString.optLong("clickConfirmCount", 0L);
      this.lLl = paramString.optLong("clickDenyCount", 0L);
      this.lLm = paramString.optLong("clickCancelCount", 0L);
      this.lLn = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.lLo = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.lLp = paramString.optLong("clickInfoCount", 0L);
      this.lLq = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.lLr = paramString.optLong("clickManagePhoneCount", 0L);
      this.lLs = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.lLt = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.lLu = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.lLv = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.lLw = paramString.optLong("addPhoneSuccessCount", 0L);
      this.lLx = paramString.optLong("addPhoneFailedCount", 0L);
      this.lLy = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.lLz = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.lLA = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.lLB = paramString.optLong("deletePhoneCount", 0L);
      this.lLC = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.lLD = paramString.optLong("deletePhoneFailedCount", 0L);
      this.lLE = paramString.optLong("verifyCodeCount", 0L);
      this.lLF = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.lLG = paramString.optLong("verifyCodeFailedCount", 0L);
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
    u localu = u.lKF;
    u.bst().a(this);
    AppMethodBeat.o(169646);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169645);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.lLh);
    ((JSONObject)localObject).put("bindSuccess", this.lLi);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.lLj);
    ((JSONObject)localObject).put("clickConfirmCount", this.lLk);
    ((JSONObject)localObject).put("clickDenyCount", this.lLl);
    ((JSONObject)localObject).put("clickCancelCount", this.lLm);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.lLn);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.lLo);
    ((JSONObject)localObject).put("clickInfoCount", this.lLp);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.lLq);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.lLr);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.lLs);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.lLt);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.lLu);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.lLv);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.lLw);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.lLx);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.lLy);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.lLz);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.lLA);
    ((JSONObject)localObject).put("deletePhoneCount", this.lLB);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.lLC);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.lLD);
    ((JSONObject)localObject).put("verifyCodeCount", this.lLE);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.lLF);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.lLG);
    localObject = ((JSONObject)localObject).toString();
    k.g(localObject, "jsonObject.toString()");
    AppMethodBeat.o(169645);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.y
 * JD-Core Version:    0.7.0.1
 */