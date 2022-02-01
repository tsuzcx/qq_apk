package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"})
public final class y
{
  public long qCP = 0L;
  public long qCQ = 0L;
  public long qCR = 0L;
  public long qCS = 0L;
  public long qCT = 0L;
  public long qCU = 0L;
  public long qCV = 0L;
  public long qCW = 0L;
  public long qCX = 0L;
  public long qCY = 0L;
  public long qCZ = 0L;
  public long qDa = 0L;
  long qDb = 0L;
  public long qDc = 0L;
  public long qDd = 0L;
  public long qDe = 0L;
  public long qDf = 0L;
  public long qDg = 0L;
  public long qDh = 0L;
  public long qDi = 0L;
  public long qDj = 0L;
  public long qDk = 0L;
  public long qDl = 0L;
  public long qDm = 0L;
  public long qDn = 0L;
  public long qDo = 0L;
  
  private y() {}
  
  public y(String paramString)
  {
    this((byte)0);
    AppMethodBeat.i(169647);
    try
    {
      paramString = new JSONObject(paramString);
      this.qCP = paramString.optLong("isBindPhone", 0L);
      this.qCQ = paramString.optLong("bindSuccess", 0L);
      this.qCR = paramString.optLong("getPhoneNumberCount", 0L);
      this.qCS = paramString.optLong("clickConfirmCount", 0L);
      this.qCT = paramString.optLong("clickDenyCount", 0L);
      this.qCU = paramString.optLong("clickCancelCount", 0L);
      this.qCV = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.qCW = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.qCX = paramString.optLong("clickInfoCount", 0L);
      this.qCY = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.qCZ = paramString.optLong("clickManagePhoneCount", 0L);
      this.qDa = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.qDb = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.qDc = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.qDd = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.qDe = paramString.optLong("addPhoneSuccessCount", 0L);
      this.qDf = paramString.optLong("addPhoneFailedCount", 0L);
      this.qDg = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.qDh = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.qDi = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.qDj = paramString.optLong("deletePhoneCount", 0L);
      this.qDk = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.qDl = paramString.optLong("deletePhoneFailedCount", 0L);
      this.qDm = paramString.optLong("verifyCodeCount", 0L);
      this.qDn = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.qDo = paramString.optLong("verifyCodeFailedCount", 0L);
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
    u localu = u.qCp;
    u.cgE().a(this);
    AppMethodBeat.o(169646);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169645);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.qCP);
    ((JSONObject)localObject).put("bindSuccess", this.qCQ);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.qCR);
    ((JSONObject)localObject).put("clickConfirmCount", this.qCS);
    ((JSONObject)localObject).put("clickDenyCount", this.qCT);
    ((JSONObject)localObject).put("clickCancelCount", this.qCU);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.qCV);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.qCW);
    ((JSONObject)localObject).put("clickInfoCount", this.qCX);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.qCY);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.qCZ);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.qDa);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.qDb);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.qDc);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.qDd);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.qDe);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.qDf);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.qDg);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.qDh);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.qDi);
    ((JSONObject)localObject).put("deletePhoneCount", this.qDj);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.qDk);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.qDl);
    ((JSONObject)localObject).put("verifyCodeCount", this.qDm);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.qDn);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.qDo);
    localObject = ((JSONObject)localObject).toString();
    p.j(localObject, "jsonObject.toString()");
    AppMethodBeat.o(169645);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.y
 * JD-Core Version:    0.7.0.1
 */