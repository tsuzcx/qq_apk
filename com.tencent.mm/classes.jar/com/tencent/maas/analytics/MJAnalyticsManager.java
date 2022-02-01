package com.tencent.maas.analytics;

import com.facebook.jni.HybridData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJAnalyticsManager
{
  private static MJAnalyticsManager _sInstance = null;
  private MJAnalyticsEventBridge _eventBridge;
  private final HybridData mHybridData;
  
  private MJAnalyticsManager()
  {
    AppMethodBeat.i(216955);
    this._eventBridge = null;
    this.mHybridData = initHybrid();
    AppMethodBeat.o(216955);
  }
  
  private native HybridData initHybrid();
  
  private native void nativeInitReporter();
  
  private native void nativeRegisterEventBridge(MJAnalyticsEventBridge paramMJAnalyticsEventBridge);
  
  private native void nativeShutdownReporter();
  
  private native void nativeUnregisterEventBridge();
  
  public static MJAnalyticsManager sharedInstance()
  {
    AppMethodBeat.i(216948);
    if (_sInstance == null) {
      _sInstance = new MJAnalyticsManager();
    }
    MJAnalyticsManager localMJAnalyticsManager = _sInstance;
    AppMethodBeat.o(216948);
    return localMJAnalyticsManager;
  }
  
  public void initReporter()
  {
    AppMethodBeat.i(216985);
    nativeInitReporter();
    AppMethodBeat.o(216985);
  }
  
  public void registerEventSink(MJAnalyticsEventSink paramMJAnalyticsEventSink)
  {
    AppMethodBeat.i(216993);
    if (paramMJAnalyticsEventSink == null)
    {
      AppMethodBeat.o(216993);
      return;
    }
    if (this._eventBridge == null)
    {
      this._eventBridge = new MJAnalyticsEventBridge();
      nativeRegisterEventBridge(this._eventBridge);
    }
    this._eventBridge.addEventSink(paramMJAnalyticsEventSink);
    AppMethodBeat.o(216993);
  }
  
  public void shutdownReporter()
  {
    AppMethodBeat.i(216988);
    nativeUnregisterEventBridge();
    this._eventBridge = null;
    nativeShutdownReporter();
    AppMethodBeat.o(216988);
  }
  
  public void unregisterEventSink(MJAnalyticsEventSink paramMJAnalyticsEventSink)
  {
    AppMethodBeat.i(217003);
    if (paramMJAnalyticsEventSink == null)
    {
      AppMethodBeat.o(217003);
      return;
    }
    if (this._eventBridge == null)
    {
      AppMethodBeat.o(217003);
      return;
    }
    this._eventBridge.removeEventSink(paramMJAnalyticsEventSink);
    if (!this._eventBridge.hasAnyEventSink())
    {
      nativeUnregisterEventBridge();
      this._eventBridge = null;
    }
    AppMethodBeat.o(217003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.analytics.MJAnalyticsManager
 * JD-Core Version:    0.7.0.1
 */