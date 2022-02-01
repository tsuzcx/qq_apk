package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"})
public final class y
{
  public long mkV = 0L;
  public long mkW = 0L;
  public long mkX = 0L;
  public long mkY = 0L;
  public long mkZ = 0L;
  public long mla = 0L;
  public long mlb = 0L;
  public long mlc = 0L;
  public long mld = 0L;
  public long mle = 0L;
  public long mlf = 0L;
  public long mlg = 0L;
  long mlh = 0L;
  public long mli = 0L;
  public long mlj = 0L;
  public long mlk = 0L;
  public long mll = 0L;
  public long mlm = 0L;
  public long mln = 0L;
  public long mlo = 0L;
  public long mlp = 0L;
  public long mlq = 0L;
  public long mlr = 0L;
  public long mls = 0L;
  public long mlt = 0L;
  public long mlu = 0L;
  
  private y() {}
  
  public y(String paramString)
  {
    this((byte)0);
    AppMethodBeat.i(169647);
    try
    {
      paramString = new JSONObject(paramString);
      this.mkV = paramString.optLong("isBindPhone", 0L);
      this.mkW = paramString.optLong("bindSuccess", 0L);
      this.mkX = paramString.optLong("getPhoneNumberCount", 0L);
      this.mkY = paramString.optLong("clickConfirmCount", 0L);
      this.mkZ = paramString.optLong("clickDenyCount", 0L);
      this.mla = paramString.optLong("clickCancelCount", 0L);
      this.mlb = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.mlc = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.mld = paramString.optLong("clickInfoCount", 0L);
      this.mle = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.mlf = paramString.optLong("clickManagePhoneCount", 0L);
      this.mlg = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.mlh = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.mli = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.mlj = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.mlk = paramString.optLong("addPhoneSuccessCount", 0L);
      this.mll = paramString.optLong("addPhoneFailedCount", 0L);
      this.mlm = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.mln = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.mlo = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.mlp = paramString.optLong("deletePhoneCount", 0L);
      this.mlq = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.mlr = paramString.optLong("deletePhoneFailedCount", 0L);
      this.mls = paramString.optLong("verifyCodeCount", 0L);
      this.mlt = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.mlu = paramString.optLong("verifyCodeFailedCount", 0L);
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
    u localu = u.mkv;
    u.bwy().a(this);
    AppMethodBeat.o(169646);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169645);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.mkV);
    ((JSONObject)localObject).put("bindSuccess", this.mkW);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.mkX);
    ((JSONObject)localObject).put("clickConfirmCount", this.mkY);
    ((JSONObject)localObject).put("clickDenyCount", this.mkZ);
    ((JSONObject)localObject).put("clickCancelCount", this.mla);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.mlb);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.mlc);
    ((JSONObject)localObject).put("clickInfoCount", this.mld);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.mle);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.mlf);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.mlg);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.mlh);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.mli);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.mlj);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.mlk);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.mll);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.mlm);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.mln);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.mlo);
    ((JSONObject)localObject).put("deletePhoneCount", this.mlp);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.mlq);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.mlr);
    ((JSONObject)localObject).put("verifyCodeCount", this.mls);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.mlt);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.mlu);
    localObject = ((JSONObject)localObject).toString();
    p.g(localObject, "jsonObject.toString()");
    AppMethodBeat.o(169645);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.y
 * JD-Core Version:    0.7.0.1
 */