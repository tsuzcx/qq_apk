package com.tencent.mm.plugin.handoff.a;

import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.pluginsdk.model.app.c;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IService;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "mod", "modFromBallInfo", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "restoreFromBallInfoList", "ballInfoList", "", "uploadFail", "arg", "uploadStart", "", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "api-handoff_release"})
public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void J(BallInfo paramBallInfo);
  
  public abstract void K(BallInfo paramBallInfo);
  
  public abstract void a(HandOff paramHandOff);
  
  public abstract boolean a(String paramString, c paramc);
  
  public abstract void an(String paramString1, String paramString2, String paramString3);
  
  public abstract HandOff anc(String paramString);
  
  public abstract void and(String paramString);
  
  public abstract boolean az(String paramString, long paramLong);
  
  public abstract void b(HandOff paramHandOff);
  
  public abstract void c(HandOff paramHandOff);
  
  public abstract void d(HandOff paramHandOff);
  
  public abstract void dbJ();
  
  public abstract void dbK();
  
  public abstract HandOff dbL();
  
  public abstract void del(String paramString);
  
  public abstract void e(HandOff paramHandOff);
  
  public abstract void ei(List<? extends BallInfo> paramList);
  
  public abstract void f(HandOff paramHandOff);
  
  public abstract void f(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void g(HandOff paramHandOff);
  
  public abstract void h(HandOff paramHandOff);
  
  public abstract void hr(String paramString1, String paramString2);
  
  public abstract void i(HandOff paramHandOff);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.a.a
 * JD-Core Version:    0.7.0.1
 */