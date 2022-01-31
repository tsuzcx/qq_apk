package com.tencent.kinda.framework.boot;

import com.tencent.kinda.framework.module.base.KindaBaseServiceModule;
import com.tencent.kinda.framework.module.base.KindaBaseViewModule;
import com.tencent.kinda.framework.module.pay.KindaPayServiceModule;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.modularize.KindaAppModuleManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public class KindaApp
{
  private static final String TAG = "MicroMsg.Kinda.KindaApp";
  private static KindaApp instance;
  private KindaAppModuleManager appModuleManager;
  private IAppKinda kinda;
  private al threadHandler;
  
  static
  {
    AppMethodBeat.i(144504);
    System.loadLibrary("kinda_android");
    instance = new KindaApp();
    AppMethodBeat.o(144504);
  }
  
  public KindaApp()
  {
    AppMethodBeat.i(144500);
    ab.i("MicroMsg.Kinda.KindaApp", "create kinda app");
    h.qsU.cT(782, 30);
    this.appModuleManager = new KindaAppModuleManager();
    this.appModuleManager.registerModule(new KindaBaseViewModule());
    this.appModuleManager.registerModule(new KindaBaseServiceModule());
    this.appModuleManager.registerModule(new KindaPayServiceModule());
    this.appModuleManager.initAllModule();
    this.kinda = IAppKinda.getInstance();
    AppMethodBeat.o(144500);
  }
  
  public static IAppKinda appKinda()
  {
    AppMethodBeat.i(144499);
    IAppKinda localIAppKinda = instance().kinda;
    AppMethodBeat.o(144499);
    return localIAppKinda;
  }
  
  public static KindaApp instance()
  {
    return instance;
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(144503);
    ab.i("MicroMsg.Kinda.KindaApp", "onBackground");
    this.kinda.applicationEnterBackground();
    AppMethodBeat.o(144503);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(144501);
    this.appModuleManager.onAppCreate();
    AppMethodBeat.o(144501);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(144502);
    ab.i("MicroMsg.Kinda.KindaApp", "onForeground");
    this.kinda.applicationEnterForeground();
    AppMethodBeat.o(144502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.boot.KindaApp
 * JD-Core Version:    0.7.0.1
 */