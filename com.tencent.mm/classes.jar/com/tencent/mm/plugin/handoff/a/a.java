package com.tencent.mm.plugin.handoff.a;

import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.app.c;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IService;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isSupportOpenInComputer", "", "mod", "modFromBallInfo", "notifyUserStatusChange", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "sendOpenRequest", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "uploadFail", "arg", "uploadStart", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "api-handoff_release"})
public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void O(BallInfo paramBallInfo);
  
  public abstract void a(GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult);
  
  public abstract void a(HandOff paramHandOff);
  
  public abstract boolean a(String paramString, c paramc);
  
  public abstract void aBA(String paramString);
  
  public abstract HandOff aBx(String paramString);
  
  public abstract HandOff aBy(String paramString);
  
  public abstract void aBz(String paramString);
  
  public abstract void av(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean az(String paramString, long paramLong);
  
  public abstract void b(HandOff paramHandOff);
  
  public abstract void c(HandOff paramHandOff);
  
  public abstract void d(HandOff paramHandOff);
  
  public abstract void d(MultiTaskInfo paramMultiTaskInfo);
  
  public abstract void dYj();
  
  public abstract void dYk();
  
  public abstract boolean dYl();
  
  public abstract HandOff dYm();
  
  public abstract void del(String paramString);
  
  public abstract void e(HandOff paramHandOff);
  
  public abstract void e(MultiTaskInfo paramMultiTaskInfo);
  
  public abstract void e(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void f(HandOff paramHandOff);
  
  public abstract void ff(List<? extends BallInfo> paramList);
  
  public abstract void fg(List<? extends MultiTaskInfo> paramList);
  
  public abstract void g(HandOff paramHandOff);
  
  public abstract void h(HandOff paramHandOff);
  
  public abstract void i(HandOff paramHandOff);
  
  public abstract void jdMethod_if(String paramString1, String paramString2);
  
  public abstract void j(HandOff paramHandOff);
  
  public abstract void processRequest(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.a.a
 * JD-Core Version:    0.7.0.1
 */