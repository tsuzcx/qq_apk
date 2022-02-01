package com.tencent.maas;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import com.facebook.jni.HybridData;
import com.tencent.maas.camerafun.MJCamFunSession;
import com.tencent.maas.instamovie.MJMaasCoreCallback.BoolCompleteCallback;
import com.tencent.maas.instamovie.MJMaasCoreCallback.CompleteCallback;
import com.tencent.maas.instamovie.MJMaasCoreCallback.ILinkLoginParamCallback;
import com.tencent.maas.instamovie.MJMovieSession;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.instamovie.base.MJLogLevel;
import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.maas.internal.NativeCallbackManager;
import com.tencent.maas.model.MJModelInfo;
import com.tencent.maas.model.MJTemplateMetadata;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class MJMaasCore
{
  private final NativeCallbackManager mCallbackManager;
  private final HybridData mHybridData;
  
  public MJMaasCore(Handler paramHandler)
  {
    AppMethodBeat.i(216795);
    this.mCallbackManager = new NativeCallbackManager(paramHandler.getLooper());
    this.mHybridData = initHybrid(paramHandler, this.mCallbackManager);
    AppMethodBeat.o(216795);
  }
  
  private native HybridData initHybrid(Handler paramHandler, NativeCallbackManager paramNativeCallbackManager);
  
  private native MJError nativeConnectToCamFunSession(MJCamFunSession paramMJCamFunSession);
  
  private native MJError nativeConnectToSession(MJMovieSession paramMJMovieSession);
  
  private native MJCamFunSession nativeNewCamFunSession(Handler paramHandler, List<MJModelInfo> paramList, int paramInt);
  
  private native MJMovieSession nativeNewMovieSession(Handler paramHandler, List<MJModelInfo> paramList);
  
  private native Object nativeNewRenderView();
  
  private native MJError nativeQueryCamFunTemplateResourcesStatus(String paramString, long paramLong, int paramInt);
  
  private native MJError nativeQueryInstaMovieTemplateResourcesStatus(String paramString, long paramLong, int paramInt);
  
  private native void nativeSetLogLevel(int paramInt);
  
  private native MJError nativeStartup(Context paramContext, ILinkParams paramILinkParams, MJMaasCore.EnvironmentParams paramEnvironmentParams, LoggingParams paramLoggingParams, MJMaasCore.WarmupParams paramWarmupParams, TemplateServiceParams paramTemplateServiceParams, int paramInt1, int paramInt2);
  
  private native MJError nativeTeardown(int paramInt);
  
  public MJError connectToSession(MJCamFunSession paramMJCamFunSession)
  {
    AppMethodBeat.i(216877);
    paramMJCamFunSession = nativeConnectToCamFunSession(paramMJCamFunSession);
    AppMethodBeat.o(216877);
    return paramMJCamFunSession;
  }
  
  public MJError connectToSession(MJMovieSession paramMJMovieSession)
  {
    AppMethodBeat.i(216868);
    paramMJMovieSession = nativeConnectToSession(paramMJMovieSession);
    AppMethodBeat.o(216868);
    return paramMJMovieSession;
  }
  
  public MJCamFunSession newCamFunSession(Handler paramHandler, List<MJModelInfo> paramList, b paramb)
  {
    AppMethodBeat.i(216860);
    paramHandler = nativeNewCamFunSession(paramHandler, paramList, paramb.id);
    AppMethodBeat.o(216860);
    return paramHandler;
  }
  
  public MJMovieSession newMovieSession(Handler paramHandler, List<MJModelInfo> paramList)
  {
    AppMethodBeat.i(216855);
    paramHandler = nativeNewMovieSession(paramHandler, paramList);
    AppMethodBeat.o(216855);
    return paramHandler;
  }
  
  public SurfaceView newRenderView()
  {
    AppMethodBeat.i(216852);
    SurfaceView localSurfaceView = (SurfaceView)nativeNewRenderView();
    AppMethodBeat.o(216852);
    return localSurfaceView;
  }
  
  public MJError queryCamFunTemplateResourcesStatus(String paramString, long paramLong, OnBoolComplete paramOnBoolComplete)
  {
    AppMethodBeat.i(216848);
    if (paramOnBoolComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMaasCoreCallback.BoolCompleteCallback(this, paramOnBoolComplete));; i = -1)
    {
      paramString = nativeQueryCamFunTemplateResourcesStatus(paramString, paramLong, i);
      AppMethodBeat.o(216848);
      return paramString;
    }
  }
  
  public MJError queryInstaMovieTemplateResourcesStatus(String paramString, long paramLong, OnBoolComplete paramOnBoolComplete)
  {
    AppMethodBeat.i(216843);
    if (paramOnBoolComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMaasCoreCallback.BoolCompleteCallback(this, paramOnBoolComplete));; i = -1)
    {
      paramString = nativeQueryInstaMovieTemplateResourcesStatus(paramString, paramLong, i);
      AppMethodBeat.o(216843);
      return paramString;
    }
  }
  
  public void setLogLevel(MJLogLevel paramMJLogLevel)
  {
    AppMethodBeat.i(216865);
    nativeSetLogLevel(paramMJLogLevel.getValue());
    AppMethodBeat.o(216865);
  }
  
  public MJError startup(Context paramContext, ILinkParams paramILinkParams, MJMaasCore.EnvironmentParams paramEnvironmentParams, LoggingParams paramLoggingParams, MJMaasCore.WarmupParams paramWarmupParams, TemplateServiceParams paramTemplateServiceParams, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(216833);
    PlatformComm.init(paramContext, new Handler(Looper.getMainLooper()));
    int i;
    if (paramILinkParams.getLoginParamsCallback() != null)
    {
      i = this.mCallbackManager.registerCallbackWithReturnValue(new MJMaasCoreCallback.ILinkLoginParamCallback(this, paramILinkParams.getLoginParamsCallback()));
      if (paramOnComplete == null) {
        break label102;
      }
    }
    label102:
    for (int j = this.mCallbackManager.registerCallback(new MJMaasCoreCallback.CompleteCallback(this, paramOnComplete));; j = -1)
    {
      paramContext = nativeStartup(paramContext, paramILinkParams, paramEnvironmentParams, paramLoggingParams, paramWarmupParams, paramTemplateServiceParams, j, i);
      AppMethodBeat.o(216833);
      return paramContext;
      i = -1;
      break;
    }
  }
  
  public MJError teardown(OnComplete paramOnComplete)
  {
    AppMethodBeat.i(216839);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMaasCoreCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramOnComplete = nativeTeardown(i);
      AppMethodBeat.o(216839);
      return paramOnComplete;
    }
  }
  
  public static class ILinkParams
  {
    private final String appID;
    private String authCode;
    private String clientInfo;
    private String debugServerIP;
    private MJMaasCore.LoginParamsCallback loginParamsCallback;
    private final int sessionModuleType;
    private boolean useDebugServer;
    
    public ILinkParams(String paramString, MJMaasCore.LoginParamsCallback paramLoginParamsCallback, int paramInt)
    {
      this.appID = paramString;
      this.loginParamsCallback = paramLoginParamsCallback;
      this.sessionModuleType = paramInt;
    }
    
    public ILinkParams(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.appID = paramString1;
      this.authCode = paramString2;
      this.clientInfo = paramString3;
      this.sessionModuleType = paramInt;
    }
    
    public ILinkParams(String paramString1, String paramString2, String paramString3, MJMaasCore.LoginParamsCallback paramLoginParamsCallback, int paramInt, boolean paramBoolean, String paramString4)
    {
      this.appID = paramString1;
      this.authCode = paramString2;
      this.clientInfo = paramString3;
      this.loginParamsCallback = paramLoginParamsCallback;
      this.sessionModuleType = paramInt;
      this.useDebugServer = paramBoolean;
      this.debugServerIP = paramString4;
    }
    
    public String getAppID()
    {
      return this.appID;
    }
    
    public String getAuthCode()
    {
      return this.authCode;
    }
    
    public String getClientInfo()
    {
      return this.clientInfo;
    }
    
    public String getDebugServerIP()
    {
      return this.debugServerIP;
    }
    
    public MJMaasCore.LoginParamsCallback getLoginParamsCallback()
    {
      return this.loginParamsCallback;
    }
    
    public int getSessionModuleType()
    {
      return this.sessionModuleType;
    }
    
    public boolean isUseDebugServer()
    {
      return this.useDebugServer;
    }
  }
  
  public static class LoggingParams
  {
    private volatile long logFuncPointer = 0L;
    private MJMaasCore.LogLevel maxLogLevel = MJMaasCore.LogLevel.INFO;
    
    public LoggingParams(long paramLong, MJMaasCore.LogLevel paramLogLevel)
    {
      this.logFuncPointer = paramLong;
      this.maxLogLevel = paramLogLevel;
    }
    
    public long getLogFuncPointer()
    {
      return this.logFuncPointer;
    }
    
    public MJMaasCore.LogLevel getMaxLogLevel()
    {
      return this.maxLogLevel;
    }
    
    public int getMaxLogLevelValue()
    {
      AppMethodBeat.i(216804);
      int i = this.maxLogLevel.getValue();
      AppMethodBeat.o(216804);
      return i;
    }
  }
  
  public static class LoginParams
  {
    private final String authCode;
    private final String clientInfo;
    
    public LoginParams(String paramString1, String paramString2)
    {
      this.authCode = paramString1;
      this.clientInfo = paramString2;
    }
    
    public String getAuthCode()
    {
      return this.authCode;
    }
    
    public String getClientInfo()
    {
      return this.clientInfo;
    }
  }
  
  public static abstract interface LoginParamsCallback
  {
    public abstract MJMaasCore.LoginParams onGetLoginParams();
  }
  
  public static abstract interface OnBoolComplete
  {
    public abstract void onComplete(boolean paramBoolean);
  }
  
  public static abstract interface OnComplete
  {
    public abstract void onComplete(MJError paramMJError);
  }
  
  public static class TemplateServiceParams
  {
    private MJMaasCore.TemplateServiceProvider camFunServiceProvider;
    private MJMaasCore.TemplateServiceProvider instaMovieServiceProvider;
    
    public TemplateServiceParams(MJMaasCore.TemplateServiceProvider paramTemplateServiceProvider1, MJMaasCore.TemplateServiceProvider paramTemplateServiceProvider2)
    {
      this.instaMovieServiceProvider = paramTemplateServiceProvider1;
      this.camFunServiceProvider = paramTemplateServiceProvider2;
    }
    
    public MJMaasCore.TemplateServiceProvider getCamFunServiceProvider()
    {
      return this.camFunServiceProvider;
    }
    
    public MJMaasCore.TemplateServiceProvider getInstaMovieServiceProvider()
    {
      return this.instaMovieServiceProvider;
    }
    
    public boolean hasCamFunServiceProvider()
    {
      return this.camFunServiceProvider != null;
    }
    
    public boolean hasInstaMovieServiceProvider()
    {
      return this.instaMovieServiceProvider != null;
    }
    
    public MJTemplateMetadata requestCamFunTemplateMetadata(String paramString)
    {
      AppMethodBeat.i(216783);
      if (this.camFunServiceProvider == null)
      {
        AppMethodBeat.o(216783);
        return null;
      }
      paramString = this.camFunServiceProvider.onRequestTemplateMetadata(paramString);
      AppMethodBeat.o(216783);
      return paramString;
    }
    
    public MJTemplateMetadata requestInstaMovieTemplateMetadata(String paramString)
    {
      AppMethodBeat.i(216780);
      if (this.instaMovieServiceProvider == null)
      {
        AppMethodBeat.o(216780);
        return null;
      }
      paramString = this.instaMovieServiceProvider.onRequestTemplateMetadata(paramString);
      AppMethodBeat.o(216780);
      return paramString;
    }
  }
  
  public static abstract interface TemplateServiceProvider
  {
    public abstract MJTemplateMetadata onRequestTemplateMetadata(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.MJMaasCore
 * JD-Core Version:    0.7.0.1
 */