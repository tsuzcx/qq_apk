package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.z;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy
  extends com.tencent.mm.remoteservice.a
{
  private static CaptureMMProxy oGj;
  private static String oGk = "";
  
  public CaptureMMProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
  }
  
  public static void createProxy(CaptureMMProxy paramCaptureMMProxy)
  {
    oGj = paramCaptureMMProxy;
  }
  
  public static CaptureMMProxy getInstance()
  {
    return oGj;
  }
  
  public boolean checkUseMMVideoPlayer()
  {
    AppMethodBeat.i(76444);
    Object localObject = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
    if (localObject != null)
    {
      ab.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", new Object[] { localObject });
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(76444);
      return bool;
    }
    AppMethodBeat.o(76444);
    return true;
  }
  
  @f
  public boolean checkUseMMVideoPlayerInMM()
  {
    AppMethodBeat.i(76446);
    ab.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
    com.tencent.mm.modelcontrol.d.afW();
    boolean bool = com.tencent.mm.modelcontrol.d.agf();
    ab.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(76446);
    return bool;
  }
  
  public void clearArtistCache()
  {
    AppMethodBeat.i(140120);
    REMOTE_CALL("clearArtistCacheInMM", new Object[0]);
    AppMethodBeat.o(140120);
  }
  
  @f
  public void clearArtistCacheInMM()
  {
    AppMethodBeat.i(140123);
    ab.d("MicroMsg.CaptureMMProxy", "clearArtistCacheInMM() called");
    s.bWe.Ab().Aa();
    AppMethodBeat.o(140123);
  }
  
  public Object get(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(76436);
    ab.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[] { parama, paramObject });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, paramObject });
    ab.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[] { parama, paramObject, localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(76436);
      return paramObject;
    }
    AppMethodBeat.o(76436);
    return localObject;
  }
  
  public String getAccVideoPath()
  {
    AppMethodBeat.i(76434);
    String str = (String)REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
    ab.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + oGk);
    if (!bo.isNullOrNil(str)) {
      oGk = str;
    }
    if (!bo.isNullOrNil(oGk))
    {
      str = oGk;
      AppMethodBeat.o(76434);
      return str;
    }
    AppMethodBeat.o(76434);
    return str;
  }
  
  @f
  public String getAccVideoPathInMM()
  {
    AppMethodBeat.i(76447);
    ab.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
    com.tencent.mm.modelvideo.o.alD();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(76447);
    return str;
  }
  
  public boolean getBoolean(ac.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(76438);
    ab.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    ab.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", new Object[] { parama, Boolean.valueOf(paramBoolean), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(76438);
      return paramBoolean;
    }
    paramBoolean = bo.getBoolean(localObject.toString(), paramBoolean);
    AppMethodBeat.o(76438);
    return paramBoolean;
  }
  
  @f
  public Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(76449);
    ac.a locala = ((ac.a[])ac.a.class.getEnumConstants())[paramInt];
    ab.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.RM();
    paramObject = com.tencent.mm.kernel.g.RL().Ru().get(locala, paramObject);
    AppMethodBeat.o(76449);
    return paramObject;
  }
  
  public String getDeviceInfoConfig()
  {
    AppMethodBeat.i(76441);
    String str = (String)REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    ab.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[] { str });
    AppMethodBeat.o(76441);
    return str;
  }
  
  @f
  public String getDeviceInfoConfigInMM()
  {
    AppMethodBeat.i(76451);
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().Rv().dyM();
    AppMethodBeat.o(76451);
    return str;
  }
  
  public String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(76442);
    String str = (String)REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    ab.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, str });
    AppMethodBeat.o(76442);
    return str;
  }
  
  @f
  public String getDynamicConfigInMM(String paramString)
  {
    AppMethodBeat.i(76452);
    paramString = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue(paramString);
    AppMethodBeat.o(76452);
    return paramString;
  }
  
  public VideoTransPara getGameVideoTransPara(int paramInt)
  {
    AppMethodBeat.i(140119);
    Object localObject = (Parcelable)REMOTE_CALL("getGameVideoTransParaInMM", new Object[] { Integer.valueOf(paramInt) });
    ab.d("MicroMsg.CaptureMMProxy", "getGameVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(140119);
    return localObject;
  }
  
  @f
  public VideoTransPara getGameVideoTransParaInMM(int paramInt)
  {
    AppMethodBeat.i(140124);
    ab.d("MicroMsg.CaptureMMProxy", "getGameVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.afW().lf(paramInt);
    ab.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(140124);
    return localVideoTransPara;
  }
  
  public int getInt(ac.a parama, int paramInt)
  {
    AppMethodBeat.i(76437);
    ab.i("MicroMsg.CaptureMMProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    ab.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(76437);
      return paramInt;
    }
    paramInt = bo.getInt(localObject.toString(), paramInt);
    AppMethodBeat.o(76437);
    return paramInt;
  }
  
  public VideoTransPara getSnsAlbumVideoTransPara()
  {
    AppMethodBeat.i(76440);
    Object localObject = (Parcelable)REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
    ab.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(76440);
    return localObject;
  }
  
  @f
  public VideoTransPara getSnsAlbumVideoTransParaInMM()
  {
    AppMethodBeat.i(76445);
    ab.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.afW().afZ();
    ab.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(76445);
    return localVideoTransPara;
  }
  
  public String getSubCoreImageFullPath(String paramString)
  {
    AppMethodBeat.i(76435);
    paramString = (String)REMOTE_CALL("getSubCoreImageFullPathInMM", new Object[] { paramString });
    ab.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(76435);
    return paramString;
  }
  
  @f
  public String getSubCoreImageFullPathInMM(String paramString)
  {
    AppMethodBeat.i(76448);
    ab.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[] { paramString });
    paramString = com.tencent.mm.at.o.ahC().getFullPath(paramString);
    AppMethodBeat.o(76448);
    return paramString;
  }
  
  public byte[] getWeixinMeta()
  {
    AppMethodBeat.i(76443);
    byte[] arrayOfByte = (byte[])REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    ab.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[] { arrayOfByte });
    AppMethodBeat.o(76443);
    return arrayOfByte;
  }
  
  @f
  public byte[] getWeixinMetaDataInMM()
  {
    AppMethodBeat.i(76453);
    byte[] arrayOfByte = com.tencent.mm.modelcontrol.d.afW().getWeixinMeta();
    AppMethodBeat.o(76453);
    return arrayOfByte;
  }
  
  public final Bundle objectsToBundle(Object... paramVarArgs)
  {
    AppMethodBeat.i(76454);
    Bundle localBundle = new Bundle();
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      if ((paramVarArgs[i] instanceof Bundle)) {
        localBundle.putBundle(String.valueOf(i), (Bundle)paramVarArgs[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramVarArgs[i] instanceof Parcelable))
        {
          localBundle.putParcelable(String.valueOf(i), (Parcelable)paramVarArgs[i]);
        }
        else if ((paramVarArgs[i] instanceof ac.a))
        {
          ab.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((ac.a)paramVarArgs[i]).ordinal()) });
          localBundle.putInt(String.valueOf(i), ((ac.a)paramVarArgs[i]).ordinal());
        }
        else
        {
          localBundle.putSerializable(String.valueOf(i), (Serializable)paramVarArgs[i]);
        }
      }
    }
    AppMethodBeat.o(76454);
    return localBundle;
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(76455);
    ab.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label228;
        }
        localObject1 = arrayOfMethod[i];
        if (!((Method)localObject1).getName().equalsIgnoreCase(paramString)) {
          break label245;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[] { bo.l(paramString) });
        AppMethodBeat.o(76455);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent((Class)localObject2))
      {
        localObject2 = ((Method)localObject1).invoke(this, getArgs(paramBundle));
        if (((Method)localObject1).getReturnType() != Void.TYPE)
        {
          if ((localObject2 instanceof Parcelable))
          {
            paramBundle.putParcelable("result_key", (Parcelable)localObject2);
            AppMethodBeat.o(76455);
            return;
          }
          if ("getConfigStorage".equals(paramString)) {
            ab.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
          }
          paramBundle.putSerializable("result_key", (Serializable)localObject2);
        }
      }
      AppMethodBeat.o(76455);
      return;
      label228:
      if (localObject1 != null) {
        if (paramBoolean)
        {
          localObject2 = com.tencent.mm.remoteservice.e.class;
          continue;
          label245:
          i += 1;
        }
        else
        {
          localObject2 = f.class;
        }
      }
    }
  }
  
  public boolean set(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(76439);
    Boolean localBoolean = (Boolean)REMOTE_CALL("setConfigStorage", new Object[] { parama, paramObject });
    ab.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { parama, paramObject });
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(76439);
    return bool;
  }
  
  @f
  public boolean setConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(76450);
    ac.a locala = ((ac.a[])ac.a.class.getEnumConstants())[paramInt];
    ab.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().Ru().set(locala, paramObject);
    AppMethodBeat.o(76450);
    return true;
  }
  
  public boolean useMediaRecordNew()
  {
    AppMethodBeat.i(140121);
    Object localObject = REMOTE_CALL("useMediaRecordNewInMM", new Object[0]);
    if (localObject != null)
    {
      ab.i("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM[%b]", new Object[] { localObject });
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(140121);
      return bool;
    }
    AppMethodBeat.o(140121);
    return true;
  }
  
  @f
  public Boolean useMediaRecordNewInMM()
  {
    AppMethodBeat.i(140122);
    ab.d("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM() called");
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVQ, true);
    AppMethodBeat.o(140122);
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.CaptureMMProxy
 * JD-Core Version:    0.7.0.1
 */