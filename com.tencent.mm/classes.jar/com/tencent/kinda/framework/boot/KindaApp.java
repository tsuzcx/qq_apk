package com.tencent.kinda.framework.boot;

import com.tencent.kinda.framework.WxCrossServices;
import com.tencent.kinda.framework.module.base.KindaBaseServiceModule;
import com.tencent.kinda.framework.module.base.KindaBaseViewModule;
import com.tencent.kinda.framework.module.pay.KindaPayServiceModule;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.modularize.KindaAppModuleManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpayreport.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class KindaApp
{
  private static final String TAG = "MicroMsg.Kinda.KindaApp";
  private static KindaApp instance;
  private KindaAppModuleManager appModuleManager;
  private IAppKinda kinda;
  private MMHandlerThread threadHandler;
  
  static
  {
    AppMethodBeat.i(18617);
    WxCrossServices.tryLoadLibrary();
    AppMethodBeat.o(18617);
  }
  
  private KindaApp()
  {
    AppMethodBeat.i(18612);
    Log.i("MicroMsg.Kinda.KindaApp", "create kinda app");
    h.OAn.kJ(782, 30);
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
    AppMethodBeat.i(226302);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new KindaApp();
      }
      KindaApp localKindaApp = instance;
      AppMethodBeat.o(226302);
      return localKindaApp;
    }
    finally
    {
      AppMethodBeat.o(226302);
    }
  }
  
  public static void reportFatalError(Throwable paramThrowable)
  {
    AppMethodBeat.i(226309);
    Object localObject = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
    localObject = ((StringWriter)localObject).toString();
    Log.e("MicroMsg.Kinda.KindaApp", "reportFatalError stack : ".concat(String.valueOf(localObject)));
    paramThrowable = (Throwable)localObject;
    if (((String)localObject).length() > 6000) {
      paramThrowable = ((String)localObject).substring(0, 6000);
    }
    localObject = g.XIU;
    g.O("6", "1", "1", paramThrowable);
    AppMethodBeat.o(226309);
  }
  
  public void notifyAllUseCases(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18616);
    Log.i("MicroMsg.Kinda.KindaApp", "notifyAllUseCases");
    this.kinda.notifyAllUseCases(paramITransmitKvData);
    AppMethodBeat.o(18616);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(18615);
    Log.i("MicroMsg.Kinda.KindaApp", "onBackground");
    this.kinda.applicationEnterBackground();
    AppMethodBeat.o(18615);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(18613);
    WxCrossServices.tryLoadLibrary();
    this.appModuleManager.onAppCreate();
    AppMethodBeat.o(18613);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(18614);
    Log.i("MicroMsg.Kinda.KindaApp", "onForeground");
    this.kinda.applicationEnterForeground();
    AppMethodBeat.o(18614);
  }
  
  public void reInitModule()
  {
    AppMethodBeat.i(226317);
    if (this.appModuleManager != null)
    {
      this.appModuleManager.initAllModule();
      this.kinda = IAppKinda.getInstance();
    }
    AppMethodBeat.o(226317);
  }
  
  public void releaseAppKinda()
  {
    this.kinda = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.boot.KindaApp
 * JD-Core Version:    0.7.0.1
 */