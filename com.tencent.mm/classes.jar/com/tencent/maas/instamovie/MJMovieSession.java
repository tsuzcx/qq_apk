package com.tencent.maas.instamovie;

import android.os.Handler;
import com.facebook.jni.HybridData;
import com.facebook.soloader.a.a;
import com.facebook.soloader.a.c;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.instamovie.base.asset.MJAssetInfo;
import com.tencent.maas.internal.NativeCallbackManager;
import com.tencent.maas.model.MJLyricInfo;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.maas.model.MJTemplateCategory;
import com.tencent.maas.model.MJTemplateInfo;
import com.tencent.maas.model.time.MJTime;
import com.tencent.maas.model.time.MJTimeRange;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class MJMovieSession
{
  private final NativeCallbackManager mCallbackManager;
  private final HybridData mHybridData;
  
  static
  {
    AppMethodBeat.i(217046);
    if (!a.isInitialized()) {
      a.a(new c());
    }
    a.loadLibrary("MaasSDK");
    AppMethodBeat.o(217046);
  }
  
  public MJMovieSession(Handler paramHandler)
  {
    AppMethodBeat.i(216915);
    this.mCallbackManager = new NativeCallbackManager(paramHandler.getLooper());
    this.mHybridData = initHybrid(paramHandler, this.mCallbackManager);
    AppMethodBeat.o(216915);
  }
  
  private native HybridData initHybrid(Handler paramHandler, NativeCallbackManager paramNativeCallbackManager);
  
  private native MJError nativeCancelExporting(int paramInt);
  
  private native MJError nativeCancelMovieCreation(int paramInt);
  
  private native MJError nativeCancelRecreation(int paramInt);
  
  private native void nativeExportClipBundle(int paramInt);
  
  private native Object[] nativeGetCurrentLyricInfos();
  
  private native MJMovieOptions nativeGetCurrentMovieOptions();
  
  private native MJMusicInfo nativeGetCurrentMusicInfo();
  
  private native MJTime nativeGetCurrentPlaybackTime();
  
  private native int nativeGetCurrentState();
  
  private native MJTemplateInfo nativeGetCurrentTemplateInfo();
  
  private native Object[] nativeGetCurrentTemplateMusicInfos();
  
  private native MJTime nativeGetPlaybackDuration();
  
  private native Object[] nativeGetRecommendedTemplateCategories();
  
  private native Object[] nativeGetRecommendedTemplateInfos();
  
  private native MJAsyncTaskInfo nativeRecreateUsingBlankTemplate(MJMovieOptions paramMJMovieOptions, int paramInt1, int paramInt2);
  
  private native MJAsyncTaskInfo nativeRecreateWithMusic(String paramString, MJMovieOptions paramMJMovieOptions, MJMovieOutroInfo paramMJMovieOutroInfo, int paramInt1, int paramInt2);
  
  private native MJAsyncTaskInfo nativeRecreateWithTemplate(String paramString, MJMovieOptions paramMJMovieOptions, MJMovieOutroInfo paramMJMovieOutroInfo, int paramInt1, int paramInt2);
  
  private native void nativeSetOnPlaybackMediaTimeDidChangeFunc(int paramInt);
  
  private native void nativeSetTextResolver(MJTextResolver paramMJTextResolver);
  
  private native MJError nativeSkimTo(MJTime paramMJTime, long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private native MJAsyncTaskInfo nativeStartExporting(String paramString, MJTimeRange paramMJTimeRange, MJExportSettings paramMJExportSettings, int paramInt1, int paramInt2);
  
  private native MJAsyncTaskInfo nativeStartMovieCreationAutoRecommendTemplate(List<MJAssetInfo> paramList, MJMovieOptions paramMJMovieOptions, MJRecommendOptions paramMJRecommendOptions, MJMovieOutroInfo paramMJMovieOutroInfo, int paramInt1, int paramInt2);
  
  private native MJAsyncTaskInfo nativeStartMovieCreationUsingBlankTemplate(List<MJAssetInfo> paramList, MJMovieOptions paramMJMovieOptions, MJRecommendOptions paramMJRecommendOptions, int paramInt1, int paramInt2, int paramInt3);
  
  private native MJAsyncTaskInfo nativeStartMovieCreationUsingTemplate(String paramString1, String paramString2, List<MJAssetInfo> paramList, MJMovieOptions paramMJMovieOptions, MJRecommendOptions paramMJRecommendOptions, MJMovieOutroInfo paramMJMovieOutroInfo, int paramInt1, int paramInt2, int paramInt3);
  
  private native MJError nativeStartPlaying(MJTimeRange paramMJTimeRange, MJTime paramMJTime, int paramInt1, boolean paramBoolean, int paramInt2);
  
  private native MJError nativeStopPlaying(int paramInt);
  
  private native MJError nativeTeardown(int paramInt);
  
  private native MJError nativeUpdateMovieOptions(MJMovieOptions paramMJMovieOptions, int paramInt);
  
  public MJTime GetCurrentPlaybackTime()
  {
    AppMethodBeat.i(217225);
    MJTime localMJTime = nativeGetCurrentPlaybackTime();
    AppMethodBeat.o(217225);
    return localMJTime;
  }
  
  public MJError cancelExporting(OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217258);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramOnComplete = nativeCancelExporting(i);
      AppMethodBeat.o(217258);
      return paramOnComplete;
    }
  }
  
  public MJError cancelMovieCreation(OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217109);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramOnComplete = nativeCancelMovieCreation(i);
      AppMethodBeat.o(217109);
      return paramOnComplete;
    }
  }
  
  public MJError cancelRecreation(OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217178);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramOnComplete = nativeCancelRecreation(i);
      AppMethodBeat.o(217178);
      return paramOnComplete;
    }
  }
  
  public void exportClipBundle(OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217266);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      nativeExportClipBundle(i);
      AppMethodBeat.o(217266);
      return;
    }
  }
  
  public List<MJLyricInfo> getCurrentLyricInfos()
  {
    AppMethodBeat.i(217127);
    Object localObject = nativeGetCurrentLyricInfos();
    if (localObject == null)
    {
      localObject = new ArrayList();
      AppMethodBeat.o(217127);
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add((MJLyricInfo)localObject[i]);
      i += 1;
    }
    AppMethodBeat.o(217127);
    return localArrayList;
  }
  
  public MJMovieOptions getCurrentMovieOptions()
  {
    AppMethodBeat.i(217184);
    MJMovieOptions localMJMovieOptions = nativeGetCurrentMovieOptions();
    AppMethodBeat.o(217184);
    return localMJMovieOptions;
  }
  
  public MJMusicInfo getCurrentMusicInfo()
  {
    AppMethodBeat.i(217114);
    MJMusicInfo localMJMusicInfo = nativeGetCurrentMusicInfo();
    AppMethodBeat.o(217114);
    return localMJMusicInfo;
  }
  
  public MJMovieSessionState getCurrentState()
  {
    AppMethodBeat.i(217064);
    MJMovieSessionState localMJMovieSessionState = MJMovieSessionState.fromInt(nativeGetCurrentState());
    AppMethodBeat.o(217064);
    return localMJMovieSessionState;
  }
  
  public MJTemplateInfo getCurrentTemplateInfo()
  {
    AppMethodBeat.i(217134);
    MJTemplateInfo localMJTemplateInfo = nativeGetCurrentTemplateInfo();
    AppMethodBeat.o(217134);
    return localMJTemplateInfo;
  }
  
  public List<MJMusicInfo> getCurrentTemplateMusicInfos()
  {
    AppMethodBeat.i(217122);
    Object[] arrayOfObject = nativeGetCurrentTemplateMusicInfos();
    ArrayList localArrayList = new ArrayList();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add((MJMusicInfo)arrayOfObject[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(217122);
    return localArrayList;
  }
  
  public MJTime getPlaybackDuration()
  {
    AppMethodBeat.i(217232);
    MJTime localMJTime = nativeGetPlaybackDuration();
    AppMethodBeat.o(217232);
    return localMJTime;
  }
  
  public ArrayList<MJTemplateCategory> getRecommendedTemplateCategories()
  {
    AppMethodBeat.i(217140);
    Object[] arrayOfObject = nativeGetRecommendedTemplateCategories();
    ArrayList localArrayList = new ArrayList();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add((MJTemplateCategory)arrayOfObject[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(217140);
    return localArrayList;
  }
  
  public ArrayList<MJTemplateInfo> getRecommendedTemplateInfos()
  {
    AppMethodBeat.i(217144);
    Object[] arrayOfObject = nativeGetRecommendedTemplateInfos();
    ArrayList localArrayList = new ArrayList();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add((MJTemplateInfo)arrayOfObject[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(217144);
    return localArrayList;
  }
  
  public MJAsyncTaskInfo recreateUsingBlankTemplate(MJMovieOptions paramMJMovieOptions, OnProgress paramOnProgress, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217169);
    paramOnProgress = this.mCallbackManager.registerProgressWithComplete(new MJMovieSessionCallback.ProgressCallback(this, paramOnProgress, false), new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));
    paramMJMovieOptions = nativeRecreateUsingBlankTemplate(paramMJMovieOptions, paramOnProgress[0], paramOnProgress[1]);
    AppMethodBeat.o(217169);
    return paramMJMovieOptions;
  }
  
  public MJAsyncTaskInfo recreateWithMusicID(String paramString, MJMovieOptions paramMJMovieOptions, MJMovieOutroInfo paramMJMovieOutroInfo, OnProgress paramOnProgress, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217161);
    paramOnProgress = this.mCallbackManager.registerProgressWithComplete(new MJMovieSessionCallback.ProgressCallback(this, paramOnProgress, false), new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));
    paramString = nativeRecreateWithMusic(paramString, paramMJMovieOptions, paramMJMovieOutroInfo, paramOnProgress[0], paramOnProgress[1]);
    AppMethodBeat.o(217161);
    return paramString;
  }
  
  public MJAsyncTaskInfo recreateWithTemplate(String paramString, MJMovieOptions paramMJMovieOptions, MJMovieOutroInfo paramMJMovieOutroInfo, OnProgress paramOnProgress, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217152);
    paramOnProgress = this.mCallbackManager.registerProgressWithComplete(new MJMovieSessionCallback.ProgressCallback(this, paramOnProgress, false), new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));
    paramString = nativeRecreateWithTemplate(paramString, paramMJMovieOptions, paramMJMovieOutroInfo, paramOnProgress[0], paramOnProgress[1]);
    AppMethodBeat.o(217152);
    return paramString;
  }
  
  public void release()
  {
    AppMethodBeat.i(217055);
    this.mHybridData.resetNative();
    AppMethodBeat.o(217055);
  }
  
  public void setOnPlaybackMediaTimeDidChange(OnMediaTimeChange paramOnMediaTimeChange)
  {
    AppMethodBeat.i(217239);
    if (paramOnMediaTimeChange != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.MediaTimeChangeCallback(this, paramOnMediaTimeChange, false));; i = -1)
    {
      nativeSetOnPlaybackMediaTimeDidChangeFunc(i);
      AppMethodBeat.o(217239);
      return;
    }
  }
  
  public void setTextResolver(MJTextResolver paramMJTextResolver)
  {
    AppMethodBeat.i(217074);
    nativeSetTextResolver(paramMJTextResolver);
    AppMethodBeat.o(217074);
  }
  
  public MJError skimTo(MJTime paramMJTime, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217213);
    paramMJTime = nativeSkimTo(paramMJTime, paramLong, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(217213);
    return paramMJTime;
  }
  
  public MJAsyncTaskInfo startExporting(String paramString, MJTimeRange paramMJTimeRange, MJExportSettings paramMJExportSettings, OnProgress paramOnProgress, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217251);
    paramOnProgress = this.mCallbackManager.registerProgressWithComplete(new MJMovieSessionCallback.ProgressCallback(this, paramOnProgress, false), new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));
    paramString = nativeStartExporting(paramString, paramMJTimeRange, paramMJExportSettings, paramOnProgress[0], paramOnProgress[1]);
    AppMethodBeat.o(217251);
    return paramString;
  }
  
  public MJAsyncTaskInfo startMovieCreationAutoRecommendTemplate(List<MJAssetInfo> paramList, MJMovieOptions paramMJMovieOptions, MJRecommendOptions paramMJRecommendOptions, MJMovieOutroInfo paramMJMovieOutroInfo, OnProgress paramOnProgress, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217085);
    paramOnProgress = this.mCallbackManager.registerProgressWithComplete(new MJMovieSessionCallback.ProgressCallback(this, paramOnProgress, false), new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));
    paramList = nativeStartMovieCreationAutoRecommendTemplate(paramList, paramMJMovieOptions, paramMJRecommendOptions, paramMJMovieOutroInfo, paramOnProgress[0], paramOnProgress[1]);
    AppMethodBeat.o(217085);
    return paramList;
  }
  
  public MJAsyncTaskInfo startMovieCreationUsingBlankTemplate(List<MJAssetInfo> paramList, MJMovieOptions paramMJMovieOptions, MJRecommendOptions paramMJRecommendOptions, OnProgress paramOnProgress, OnComplete paramOnComplete1, OnComplete paramOnComplete2)
  {
    AppMethodBeat.i(217101);
    paramOnProgress = this.mCallbackManager.registerProgressWithComplete(new MJMovieSessionCallback.ProgressCallback(this, paramOnProgress, false), new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete1));
    if (paramOnComplete2 != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete2));; i = -1)
    {
      paramList = nativeStartMovieCreationUsingBlankTemplate(paramList, paramMJMovieOptions, paramMJRecommendOptions, paramOnProgress[0], paramOnProgress[1], i);
      AppMethodBeat.o(217101);
      return paramList;
    }
  }
  
  public MJAsyncTaskInfo startMovieCreationUsingTemplate(String paramString1, String paramString2, List<MJAssetInfo> paramList, MJMovieOptions paramMJMovieOptions, MJRecommendOptions paramMJRecommendOptions, MJMovieOutroInfo paramMJMovieOutroInfo, OnProgress paramOnProgress, OnComplete paramOnComplete1, OnComplete paramOnComplete2)
  {
    AppMethodBeat.i(217094);
    paramOnProgress = this.mCallbackManager.registerProgressWithComplete(new MJMovieSessionCallback.ProgressCallback(this, paramOnProgress, false), new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete1));
    if (paramOnComplete2 != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete2));; i = -1)
    {
      paramString1 = nativeStartMovieCreationUsingTemplate(paramString1, paramString2, paramList, paramMJMovieOptions, paramMJRecommendOptions, paramMJMovieOutroInfo, paramOnProgress[0], paramOnProgress[1], i);
      AppMethodBeat.o(217094);
      return paramString1;
    }
  }
  
  public MJError startPlaying(MJTimeRange paramMJTimeRange, MJTime paramMJTime, int paramInt, boolean paramBoolean, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217199);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramMJTimeRange = nativeStartPlaying(paramMJTimeRange, paramMJTime, paramInt, paramBoolean, i);
      AppMethodBeat.o(217199);
      return paramMJTimeRange;
    }
  }
  
  public MJError stopPlaying(OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217207);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramOnComplete = nativeStopPlaying(i);
      AppMethodBeat.o(217207);
      return paramOnComplete;
    }
  }
  
  public MJError tearDown(OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217276);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramOnComplete = nativeTeardown(i);
      AppMethodBeat.o(217276);
      return paramOnComplete;
    }
  }
  
  public MJError updateMovieOptions(MJMovieOptions paramMJMovieOptions, OnComplete paramOnComplete)
  {
    AppMethodBeat.i(217192);
    if (paramOnComplete != null) {}
    for (int i = this.mCallbackManager.registerCallback(new MJMovieSessionCallback.CompleteCallback(this, paramOnComplete));; i = -1)
    {
      paramMJMovieOptions = nativeUpdateMovieOptions(paramMJMovieOptions, i);
      AppMethodBeat.o(217192);
      return paramMJMovieOptions;
    }
  }
  
  public static abstract interface OnComplete
  {
    public abstract void onComplete(MJError paramMJError);
  }
  
  public static abstract interface OnExportClipBundle
  {
    public abstract void onExportClipBundle(String paramString, MJError paramMJError);
  }
  
  public static abstract interface OnMediaTimeChange
  {
    public abstract void onMediaTimeChange(MJTime paramMJTime, MJTimeRange paramMJTimeRange, long paramLong);
  }
  
  public static abstract interface OnProgress
  {
    public abstract void onProgress(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSession
 * JD-Core Version:    0.7.0.1
 */