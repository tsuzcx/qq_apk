package com.tencent.mm.plugin.handoff.a;

import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.app.c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IService;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isSupportOpenInComputer", "", "mod", "modFromBallInfo", "notifyUserStatusChange", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "sendOpenRequest", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "uploadFail", "arg", "uploadStart", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void S(BallInfo paramBallInfo);
  
  public abstract void a(GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult);
  
  public abstract void a(HandOff paramHandOff);
  
  public abstract boolean a(String paramString, c paramc);
  
  public abstract HandOff aIc(String paramString);
  
  public abstract HandOff aId(String paramString);
  
  public abstract void aIe(String paramString);
  
  public abstract void aIf(String paramString);
  
  public abstract boolean aK(String paramString, long paramLong);
  
  public abstract void az(String paramString1, String paramString2, String paramString3);
  
  public abstract void b(HandOff paramHandOff);
  
  public abstract void c(HandOff paramHandOff);
  
  public abstract void d(HandOff paramHandOff);
  
  public abstract void d(MultiTaskInfo paramMultiTaskInfo);
  
  public abstract void del(String paramString);
  
  public abstract void e(HandOff paramHandOff);
  
  public abstract void e(MultiTaskInfo paramMultiTaskInfo);
  
  public abstract void f(HandOff paramHandOff);
  
  public abstract void f(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void fJJ();
  
  public abstract void fJK();
  
  public abstract boolean fJL();
  
  public abstract HandOff fJM();
  
  public abstract void g(HandOff paramHandOff);
  
  public abstract void h(HandOff paramHandOff);
  
  public abstract void i(HandOff paramHandOff);
  
  public abstract void iw(List<? extends BallInfo> paramList);
  
  public abstract void ix(List<? extends MultiTaskInfo> paramList);
  
  public abstract void j(HandOff paramHandOff);
  
  public abstract void jv(String paramString1, String paramString2);
  
  public abstract void processRequest(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.a.a
 * JD-Core Version:    0.7.0.1
 */