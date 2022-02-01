package com.tencent.kinda.framework.boot;

import com.tencent.kinda.framework.WxCrossServices;
import com.tencent.kinda.framework.module.base.KindaBaseServiceModule;
import com.tencent.kinda.framework.module.base.KindaBaseViewModule;
import com.tencent.kinda.framework.module.pay.KindaPayServiceModule;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.modularize.KindaAppModuleManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public class KindaApp
{
  private static final String TAG = "MicroMsg.Kinda.KindaApp";
  private static KindaApp instance;
  private KindaAppModuleManager appModuleManager;
  private IAppKinda kinda;
  private aq threadHandler;
  
  static
  {
    AppMethodBeat.i(18617);
    tryLoadLibrary();
    instance = new KindaApp();
    AppMethodBeat.o(18617);
  }
  
  public KindaApp()
  {
    AppMethodBeat.i(18612);
    ad.i("MicroMsg.Kinda.KindaApp", "create kinda app");
    g.yhR.dD(782, 30);
    this.appModuleManager = new KindaAppModuleManager();
    this.appModuleManager.registerModule(new KindaBaseViewModule());
    this.appModuleManager.registerModule(new KindaBaseServiceModule());
    this.appModuleManager.registerModule(new KindaPayServiceModule());
    this.appModuleManager.initAllModule();
    this.kinda = IAppKinda.getInstance();
    AppMethodBeat.o(18612);
  }
  
  public static IAppKinda appKinda()
  {
    AppMethodBeat.i(18611);
    IAppKinda localIAppKinda = instance().kinda;
    AppMethodBeat.o(18611);
    return localIAppKinda;
  }
  
  public static KindaApp instance()
  {
    return instance;
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(18609);
    boolean bool = a.cmP();
    AppMethodBeat.o(18609);
    return bool;
  }
  
  private static void tryLoadLibrary()
  {
    AppMethodBeat.i(18610);
    if (isEnabled()) {
      WxCrossServices.tryLoadLibrary();
    }
    AppMethodBeat.o(18610);
  }
  
  public void notifyAllUseCases(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18616);
    ad.i("MicroMsg.Kinda.KindaApp", "notifyAllUseCases");
    this.kinda.notifyAllUseCases(paramITransmitKvData);
    AppMethodBeat.o(18616);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(18615);
    ad.i("MicroMsg.Kinda.KindaApp", "onBackground");
    this.kinda.applicationEnterBackground();
    AppMethodBeat.o(18615);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(18613);
    tryLoadLibrary();
    this.appModuleManager.onAppCreate();
    AppMethodBeat.o(18613);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(18614);
    ad.i("MicroMsg.Kinda.KindaApp", "onForeground");
    this.kinda.applicationEnterForeground();
    AppMethodBeat.o(18614);
  }
  
  public void reInitModule()
  {
    AppMethodBeat.i(199438);
    if (this.appModuleManager != null)
    {
      this.appModuleManager.initAllModule();
      this.kinda = IAppKinda.getInstance();
    }
    AppMethodBeat.o(199438);
  }
  
  public void releaseAppKinda()
  {
    this.kinda = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.boot.KindaApp
 * JD-Core Version:    0.7.0.1
 */