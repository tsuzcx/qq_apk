package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"})
public final class y
{
  public long mpS = 0L;
  public long mpT = 0L;
  public long mpU = 0L;
  public long mpV = 0L;
  public long mpW = 0L;
  public long mpX = 0L;
  public long mpY = 0L;
  public long mpZ = 0L;
  public long mqa = 0L;
  public long mqb = 0L;
  public long mqc = 0L;
  public long mqd = 0L;
  long mqe = 0L;
  public long mqf = 0L;
  public long mqg = 0L;
  public long mqh = 0L;
  public long mqi = 0L;
  public long mqj = 0L;
  public long mqk = 0L;
  public long mql = 0L;
  public long mqm = 0L;
  public long mqn = 0L;
  public long mqo = 0L;
  public long mqp = 0L;
  public long mqq = 0L;
  public long mqr = 0L;
  
  private y() {}
  
  public y(String paramString)
  {
    this((byte)0);
    AppMethodBeat.i(169647);
    try
    {
      paramString = new JSONObject(paramString);
      this.mpS = paramString.optLong("isBindPhone", 0L);
      this.mpT = paramString.optLong("bindSuccess", 0L);
      this.mpU = paramString.optLong("getPhoneNumberCount", 0L);
      this.mpV = paramString.optLong("clickConfirmCount", 0L);
      this.mpW = paramString.optLong("clickDenyCount", 0L);
      this.mpX = paramString.optLong("clickCancelCount", 0L);
      this.mpY = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.mpZ = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.mqa = paramString.optLong("clickInfoCount", 0L);
      this.mqb = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.mqc = paramString.optLong("clickManagePhoneCount", 0L);
      this.mqd = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.mqe = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.mqf = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.mqg = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.mqh = paramString.optLong("addPhoneSuccessCount", 0L);
      this.mqi = paramString.optLong("addPhoneFailedCount", 0L);
      this.mqj = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.mqk = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.mql = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.mqm = paramString.optLong("deletePhoneCount", 0L);
      this.mqn = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.mqo = paramString.optLong("deletePhoneFailedCount", 0L);
      this.mqp = paramString.optLong("verifyCodeCount", 0L);
      this.mqq = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.mqr = paramString.optLong("verifyCodeFailedCount", 0L);
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
    u localu = u.mps;
    u.bxp().a(this);
    AppMethodBeat.o(169646);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169645);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.mpS);
    ((JSONObject)localObject).put("bindSuccess", this.mpT);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.mpU);
    ((JSONObject)localObject).put("clickConfirmCount", this.mpV);
    ((JSONObject)localObject).put("clickDenyCount", this.mpW);
    ((JSONObject)localObject).put("clickCancelCount", this.mpX);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.mpY);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.mpZ);
    ((JSONObject)localObject).put("clickInfoCount", this.mqa);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.mqb);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.mqc);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.mqd);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.mqe);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.mqf);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.mqg);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.mqh);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.mqi);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.mqj);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.mqk);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.mql);
    ((JSONObject)localObject).put("deletePhoneCount", this.mqm);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.mqn);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.mqo);
    ((JSONObject)localObject).put("verifyCodeCount", this.mqp);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.mqq);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.mqr);
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