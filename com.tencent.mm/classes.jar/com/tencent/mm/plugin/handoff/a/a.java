package com.tencent.mm.plugin.handoff.a;

import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.pluginsdk.model.app.c;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IService;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "mod", "modFromBallInfo", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "restoreFromBallInfoList", "ballInfoList", "", "sendOpenRequest", "uploadFail", "arg", "uploadStart", "", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "api-handoff_release"})
public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void L(BallInfo paramBallInfo);
  
  public abstract void M(BallInfo paramBallInfo);
  
  public abstract void a(HandOff paramHandOff);
  
  public abstract boolean a(String paramString, c paramc);
  
  public abstract void an(String paramString1, String paramString2, String paramString3);
  
  public abstract HandOff aod(String paramString);
  
  public abstract void aoe(String paramString);
  
  public abstract boolean az(String paramString, long paramLong);
  
  public abstract void b(HandOff paramHandOff);
  
  public abstract void c(HandOff paramHandOff);
  
  public abstract void d(HandOff paramHandOff);
  
  public abstract void deA();
  
  public abstract void deB();
  
  public abstract HandOff deC();
  
  public abstract void del(String paramString);
  
  public abstract void e(HandOff paramHandOff);
  
  public abstract void em(List<? extends BallInfo> paramList);
  
  public abstract void f(HandOff paramHandOff);
  
  public abstract void f(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void g(HandOff paramHandOff);
  
  public abstract void h(HandOff paramHandOff);
  
  public abstract void hy(String paramString1, String paramString2);
  
  public abstract void i(HandOff paramHandOff);
  
  public abstract void j(HandOff paramHandOff);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.a.a
 * JD-Core Version:    0.7.0.1
 */