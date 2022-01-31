package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MediaSdk
{
  private static final String CPPTAG = "[mediasdk][cpp]";
  private static final String TAG = "[mediasdk][java]";
  private static MediaSdk mInstance;
  private boolean mInited = false;
  
  static
  {
    AppMethodBeat.i(142855);
    mInstance = new MediaSdk();
    AppMethodBeat.o(142855);
  }
  
  public static MediaSdk getInstance()
  {
    return mInstance;
  }
  
  private native boolean nativeInit();
  
  private native boolean nativeRequest(int paramInt, byte[] paramArrayOfByte, MediaSdk.TransCallbacker paramTransCallbacker);
  
  private native void nativeUint();
  
  private void onStats(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142854);
    try
    {
      LogDelegate.i("[mediasdk][java]", "onStats, type:".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(142854);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      LogDelegate.e("[mediasdk][java]", "onStats, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(142854);
    }
  }
  
  private void onTrace(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142853);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142853);
      return;
      try
      {
        LogDelegate.d("[mediasdk][cpp]", new String(paramArrayOfByte), new Object[0]);
        AppMethodBeat.o(142853);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        LogDelegate.e("[mediasdk][java]", "trace, error:" + paramArrayOfByte.getMessage(), new Object[0]);
        AppMethodBeat.o(142853);
        return;
      }
      LogDelegate.i("[mediasdk][cpp]", new String(paramArrayOfByte), new Object[0]);
      AppMethodBeat.o(142853);
      return;
      LogDelegate.w("[mediasdk][cpp]", new String(paramArrayOfByte), new Object[0]);
      AppMethodBeat.o(142853);
      return;
      LogDelegate.e("[mediasdk][cpp]", new String(paramArrayOfByte), new Object[0]);
    }
  }
  
  public void fileAnalysis(InvokeEvent.IEAnalysis paramIEAnalysis, MediaSdk.Callbacker<FeedbackEvent.FEAnalysisResult> paramCallbacker)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(142851);
        try
        {
          LogDelegate.i("[mediasdk][java]", "fileAnalysis, filePath:" + paramIEAnalysis.filePath, new Object[0]);
          if (!this.mInited)
          {
            LogDelegate.i("[mediasdk][java]", "not init", new Object[0]);
            paramCallbacker.onResult(601, "sdk not ready", new FeedbackEvent.FEAnalysisResult());
            AppMethodBeat.o(142851);
            return;
          }
          if (!nativeRequest(2, paramIEAnalysis.format(), new MediaSdk.2(this, paramCallbacker)))
          {
            LogDelegate.i("[mediasdk][java]", "fileAnalysis nativeRequest failed", new Object[0]);
            continue;
          }
        }
        catch (Exception paramIEAnalysis)
        {
          LogDelegate.e("[mediasdk][java]", "fileAnalysis, error:" + paramIEAnalysis.getMessage(), new Object[0]);
          continue;
        }
        AppMethodBeat.o(142851);
      }
      finally {}
    }
  }
  
  public boolean init()
  {
    boolean bool1 = false;
    try
    {
      AppMethodBeat.i(142849);
      try
      {
        LogDelegate.i("[mediasdk][java]", "init", new Object[0]);
        LoadDelegate.loadLibraries();
        this.mInited = nativeInit();
        boolean bool2 = this.mInited;
        AppMethodBeat.o(142849);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogDelegate.e("[mediasdk][java]", "init failed, error:" + localException.getMessage(), new Object[0]);
          AppMethodBeat.o(142849);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean isInited()
  {
    try
    {
      boolean bool = this.mInited;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void remuxFile(InvokeEvent.IERemux paramIERemux, MediaSdk.Callbacker<FeedbackEvent.FERemuxResult> paramCallbacker)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(142850);
        try
        {
          LogDelegate.i("[mediasdk][java]", "remuxFile, video:" + paramIERemux.videoName + ", audio:" + paramIERemux.audioName + ", file:" + paramIERemux.fileName, new Object[0]);
          if (!this.mInited)
          {
            LogDelegate.e("[mediasdk][java]", "not init", new Object[0]);
            paramCallbacker.onResult(601, "sdk not ready", new FeedbackEvent.FERemuxResult());
            AppMethodBeat.o(142850);
            return;
          }
          if (!nativeRequest(1, paramIERemux.format(), new MediaSdk.1(this, paramCallbacker)))
          {
            LogDelegate.e("[mediasdk][java]", "remuxFile nativeRequest failed", new Object[0]);
            continue;
          }
        }
        catch (Exception paramIERemux)
        {
          LogDelegate.e("[mediasdk][java]", "remuxFile, error:" + paramIERemux.getMessage(), new Object[0]);
          continue;
        }
        AppMethodBeat.o(142850);
      }
      finally {}
    }
  }
  
  public void uint()
  {
    try
    {
      AppMethodBeat.i(142852);
      LogDelegate.i("[mediasdk][java]", "uint", new Object[0]);
      try
      {
        this.mInited = false;
        nativeUint();
        AppMethodBeat.o(142852);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogDelegate.e("[mediasdk][java]", "uint, error:" + localException.getMessage(), new Object[0]);
          AppMethodBeat.o(142852);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.hilive.mediasdk.MediaSdk
 * JD-Core Version:    0.7.0.1
 */