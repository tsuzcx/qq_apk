package com.tencent.kinda.framework.module.base;

import com.tencent.kinda.framework.animate.MMKAnimator;
import com.tencent.kinda.framework.app.KLogServiceImpl;
import com.tencent.kinda.framework.app.KOfflinePayServiceImpl;
import com.tencent.kinda.framework.app.KWCPayServiceImpl;
import com.tencent.kinda.framework.app.KindaAddPayCardServiceImpl;
import com.tencent.kinda.framework.app.KindaDeviceFrameDrawLoopCallback;
import com.tencent.kinda.framework.app.KindaDeviceServiceImpl;
import com.tencent.kinda.framework.app.KindaFileServiceImpl;
import com.tencent.kinda.framework.app.KindaFingerprintImpl;
import com.tencent.kinda.framework.app.KindaJumpRemindManagerImpl;
import com.tencent.kinda.framework.app.KindaLocationManagerImpl;
import com.tencent.kinda.framework.app.KindaOpenBiometricVerifyManagerImpl;
import com.tencent.kinda.framework.app.KindaPasswordManagerImpl;
import com.tencent.kinda.framework.app.KindaPayCardManagerImpl;
import com.tencent.kinda.framework.app.KindaPlatformUtil;
import com.tencent.kinda.framework.app.KindaRealNameManagerImpl;
import com.tencent.kinda.framework.app.KindaRealNameServiceImpl;
import com.tencent.kinda.framework.app.KindaShakeCheckingManager;
import com.tencent.kinda.framework.app.KindaTimerService;
import com.tencent.kinda.framework.app.KindaUtilityServiceImpl;
import com.tencent.kinda.framework.app.MMKindaFaceRegManagerImpl;
import com.tencent.kinda.framework.app.UIPageControllerImpl;
import com.tencent.kinda.framework.module.impl.ContactServiceImpl;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
import com.tencent.kinda.framework.module.impl.KindaCrtServiceImpl;
import com.tencent.kinda.framework.module.impl.KindaEventLoopManagerImpl;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.framework.module.impl.KindaModalManagerImpl;
import com.tencent.kinda.framework.module.impl.KindaNotifyImpl;
import com.tencent.kinda.framework.module.impl.KindaResultImpl;
import com.tencent.kinda.framework.module.impl.KindaScanWidgetImpl;
import com.tencent.kinda.framework.module.impl.KindaSecureCtrItemImpl;
import com.tencent.kinda.framework.module.impl.KindaUUIDService;
import com.tencent.kinda.framework.module.impl.KindaWalletMixManagerImpl;
import com.tencent.kinda.framework.module.impl.KindaWebServiceImpl;
import com.tencent.kinda.framework.module.impl.KindaWordingServiceImpl;
import com.tencent.kinda.framework.module.impl.NetworkServiceImpl;
import com.tencent.kinda.framework.module.impl.PlatformUIRouterImpl;
import com.tencent.kinda.framework.module.impl.ReportServiceImpl;
import com.tencent.kinda.framework.module.impl.RsaCryptUtilImpl;
import com.tencent.kinda.modularize.KindaModule;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaBaseServiceModule
  extends KindaModule
{
  public void configModule()
  {
    AppMethodBeat.i(18618);
    registerNativeModule("kContactService", ContactServiceImpl.class);
    registerNativeModule("KCacheService", KindaCacheServiceImpl.class);
    registerNativeModule("KPlatformUIRouter", PlatformUIRouterImpl.class);
    registerNativeModule("KNetworkService", NetworkServiceImpl.class);
    registerNativeModule("IPlatformUtil", KindaPlatformUtil.class);
    registerNativeModule("KLogService", KLogServiceImpl.class);
    registerNativeModule("KDeviceService", KindaDeviceServiceImpl.class);
    registerNativeModule("KReportService", ReportServiceImpl.class);
    registerNativeModule("IDeviceFrameDrawLoopCallback", KindaDeviceFrameDrawLoopCallback.class);
    registerNativeModule("KPlatformUIRouter", PlatformUIRouterImpl.class);
    registerNativeModule("KCrtService", KindaCrtServiceImpl.class);
    registerNativeModule("KRealNameService", KindaRealNameServiceImpl.class);
    registerNativeModule("KindaAnimator", MMKAnimator.class);
    registerNativeModule("KTimerService", KindaTimerService.class);
    registerNativeModule("KindaModalManager", KindaModalManagerImpl.class);
    registerNativeModule("KUUIDService", KindaUUIDService.class);
    registerNativeModule("KFingerprintService", KindaFingerprintImpl.class);
    registerNativeModule("IKindaResult", KindaResultImpl.class);
    registerNativeModule("IUIPageController", UIPageControllerImpl.class);
    registerNativeModule("EventLoopManager", KindaEventLoopManagerImpl.class);
    registerNativeModule("KindaPasswordManager", KindaPasswordManagerImpl.class);
    registerNativeModule("KindaRealNameManager", KindaRealNameManagerImpl.class);
    registerNativeModule("IShakeCheckingManager", KindaShakeCheckingManager.class);
    registerNativeModule("kFileService", KindaFileServiceImpl.class);
    registerNativeModule("kWordingService", KindaWordingServiceImpl.class);
    registerNativeModule("kScanWidget", KindaScanWidgetImpl.class);
    registerNativeModule("KindaWalletMixManager", KindaWalletMixManagerImpl.class);
    registerNativeModule("KJSEvent", KindaJSEvent.class);
    registerNativeModule("KindaOpenBiometricVerifyManager", KindaOpenBiometricVerifyManagerImpl.class);
    registerNativeModule("KindaJumpRemindManager", KindaJumpRemindManagerImpl.class);
    registerNativeModule("KindaLocationManager", KindaLocationManagerImpl.class);
    registerNativeModule("KOfflinePayService", KOfflinePayServiceImpl.class);
    registerNativeModule("KWCPayService", KWCPayServiceImpl.class);
    registerNativeModule("KindaPayCardManager", KindaPayCardManagerImpl.class);
    registerNativeModule("KindaFaceRegManager", MMKindaFaceRegManagerImpl.class);
    registerNativeModule("RsaCryptUtil", RsaCryptUtilImpl.class);
    registerNativeModule("SecureCtrItem", KindaSecureCtrItemImpl.class);
    registerNativeModule("KAddPayCardService", KindaAddPayCardServiceImpl.class);
    registerNativeModule("KindaNotify", KindaNotifyImpl.class);
    registerNativeModule("KUtilityService", KindaUtilityServiceImpl.class);
    registerNativeModule("KindaWebService", KindaWebServiceImpl.class);
    AppMethodBeat.o(18618);
  }
  
  public void onAppCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.base.KindaBaseServiceModule
 * JD-Core Version:    0.7.0.1
 */