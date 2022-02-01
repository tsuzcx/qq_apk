package com.tencent.liteav.audio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.c;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TXCSoundEffectPlayer
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final String TAG = "AudioCenter:TXCSoundEffectPlayer";
  private static WeakReference<b> mWeakSoundEffectListener;
  private List<Integer> mShortEffectorIDList;
  
  static
  {
    AppMethodBeat.i(16342);
    f.f();
    AppMethodBeat.o(16342);
  }
  
  public TXCSoundEffectPlayer()
  {
    AppMethodBeat.i(221854);
    this.mShortEffectorIDList = new ArrayList();
    AppMethodBeat.o(221854);
  }
  
  private String checkIfAssetsFile(String paramString)
  {
    AppMethodBeat.i(221861);
    if ((TextUtils.isEmpty(paramString)) || (TXCCommonUtil.getAppContext() == null))
    {
      AppMethodBeat.o(221861);
      return paramString;
    }
    if (!paramString.startsWith("/assets/"))
    {
      AppMethodBeat.o(221861);
      return paramString;
    }
    String str3 = paramString.substring(8);
    for (;;)
    {
      long l;
      try
      {
        l = TXCCommonUtil.getAppContext().getAssets().openFd(str3).getLength();
      }
      catch (Exception localException1)
      {
        String str1;
        File localFile;
        try
        {
          str1 = getEffectCachePath();
          localFile = new File(str1);
          if (!localFile.exists())
          {
            localFile.mkdirs();
            int i = str3.lastIndexOf(File.separatorChar);
            if (i == -1) {
              break label273;
            }
            str1 = str1 + File.separator + l + "_" + str3.substring(i + 1);
            paramString = str1;
            str1 = paramString;
          }
        }
        catch (Exception localException2) {}
        try
        {
          if (!c.a(paramString))
          {
            c.a(TXCCommonUtil.getAppContext(), str3, paramString);
            str1 = paramString;
          }
          AppMethodBeat.o(221861);
          return str1;
        }
        catch (Exception localException3)
        {
          String str2;
          break label242;
        }
        localException1 = localException1;
        TXCLog.e("AudioCenter:TXCSoundEffectPlayer", "playAudioEffect openFd error " + localException1.toString());
        l = 0L;
        continue;
        if (!localFile.isFile()) {
          continue;
        }
        localFile.delete();
        localFile.mkdirs();
        continue;
      }
      label242:
      TXCLog.e("AudioCenter:TXCSoundEffectPlayer", "playAudioEffect error " + localException2.toString());
      str2 = paramString;
      continue;
      label273:
      str2 = str2 + File.separator + l + "_" + str3;
      paramString = str2;
    }
  }
  
  private String getEffectCachePath()
  {
    AppMethodBeat.i(221860);
    if (TXCCommonUtil.getAppContext() == null)
    {
      AppMethodBeat.o(221860);
      return "";
    }
    String str = TXCCommonUtil.getAppContext().getCacheDir() + File.separator + "liteav_effect";
    AppMethodBeat.o(221860);
    return str;
  }
  
  public static TXCSoundEffectPlayer getInstance()
  {
    AppMethodBeat.i(16331);
    TXCSoundEffectPlayer localTXCSoundEffectPlayer = a.a();
    AppMethodBeat.o(16331);
    return localTXCSoundEffectPlayer;
  }
  
  public void clearCache()
  {
    AppMethodBeat.i(221859);
    if (TXCCommonUtil.getAppContext() == null)
    {
      AppMethodBeat.o(221859);
      return;
    }
    try
    {
      Object localObject = new File(getEffectCachePath());
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (c.a((File)localObject) > 52428800L))
      {
        localObject = ((File)localObject).listFiles();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
      AppMethodBeat.o(221859);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.w("AudioCenter:TXCSoundEffectPlayer", "clearCache error " + localException.toString());
      AppMethodBeat.o(221859);
    }
  }
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221858);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "onMusicPlayFinish -> effect id = ".concat(String.valueOf(paramInt1)));
    if ((mWeakSoundEffectListener != null) && (mWeakSoundEffectListener.get() != null)) {
      ((b)mWeakSoundEffectListener.get()).onEffectPlayFinish(paramInt1);
    }
    AppMethodBeat.o(221858);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2) {}
  
  public void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221857);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "onStart -> effect id = " + paramInt1 + ", errCode = " + paramInt2);
    if ((mWeakSoundEffectListener != null) && (mWeakSoundEffectListener.get() != null)) {
      ((b)mWeakSoundEffectListener.get()).onEffectPlayStart(paramInt1, paramInt2);
    }
    AppMethodBeat.o(221857);
  }
  
  public void pauseEffectWithId(int paramInt)
  {
    AppMethodBeat.i(182286);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "pauseEffectWithId -> effect id = ".concat(String.valueOf(paramInt)));
    TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(paramInt);
    AppMethodBeat.o(182286);
  }
  
  public boolean playEffectWithId(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(16333);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "playEffectWithId -> effect id = " + paramInt1 + ", path = " + paramString + ", loop = " + paramInt2);
    paramString = new TXAudioEffectManager.AudioMusicParam(paramInt1, checkIfAssetsFile(paramString));
    paramString.publish = paramBoolean;
    paramString.loopCount = paramInt2;
    paramString.isShortFile = true;
    paramBoolean = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic(paramString);
    TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(paramInt1, this);
    this.mShortEffectorIDList.add(Integer.valueOf(paramInt1));
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "playEffectWithId ->effect id = " + paramInt1 + ", startPlayMusic result = " + paramBoolean);
    AppMethodBeat.o(16333);
    return paramBoolean;
  }
  
  public void resumeEffectWithId(int paramInt)
  {
    AppMethodBeat.i(182287);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "resumeEffectWithId -> effect id = ".concat(String.valueOf(paramInt)));
    TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(paramInt);
    AppMethodBeat.o(182287);
  }
  
  public void setEffectsVolume(float paramFloat)
  {
    AppMethodBeat.i(221855);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "setEffectsVolume -> volume = ".concat(String.valueOf(paramFloat)));
    Iterator localIterator = this.mShortEffectorIDList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(i, (int)(100.0F * paramFloat));
    }
    AppMethodBeat.o(221855);
  }
  
  public void setSoundEffectListener(b paramb)
  {
    AppMethodBeat.i(16339);
    if (paramb == null)
    {
      mWeakSoundEffectListener = null;
      AppMethodBeat.o(16339);
      return;
    }
    mWeakSoundEffectListener = new WeakReference(paramb);
    AppMethodBeat.o(16339);
  }
  
  public void setVolumeOfEffect(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221856);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "setVolumeOfEffect -> effect id = " + paramInt + ", volume = " + paramFloat);
    TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(paramInt, (int)(100.0F * paramFloat));
    AppMethodBeat.o(221856);
  }
  
  public void stopAllEffect()
  {
    AppMethodBeat.i(16335);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "stopAllEffect -> start");
    Iterator localIterator = this.mShortEffectorIDList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(i);
    }
    this.mShortEffectorIDList.clear();
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "stopAllEffect -> finish");
    AppMethodBeat.o(16335);
  }
  
  public void stopEffectWithId(int paramInt)
  {
    AppMethodBeat.i(16334);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "stopEffectWithId -> effect id = ".concat(String.valueOf(paramInt)));
    TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(paramInt, null);
    TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(paramInt);
    paramInt = this.mShortEffectorIDList.indexOf(Integer.valueOf(paramInt));
    if (paramInt >= 0) {
      this.mShortEffectorIDList.remove(paramInt);
    }
    AppMethodBeat.o(16334);
  }
  
  static class a
  {
    private static final TXCSoundEffectPlayer a;
    
    static
    {
      AppMethodBeat.i(16298);
      a = new TXCSoundEffectPlayer();
      AppMethodBeat.o(16298);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCSoundEffectPlayer
 * JD-Core Version:    0.7.0.1
 */