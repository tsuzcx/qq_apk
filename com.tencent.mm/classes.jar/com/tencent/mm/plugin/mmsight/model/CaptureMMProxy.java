package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.co;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy
  extends com.tencent.mm.remoteservice.a
{
  private static CaptureMMProxy KUn;
  private static String KUo = "";
  
  public CaptureMMProxy(d paramd)
  {
    super(paramd);
  }
  
  public static void createProxy(CaptureMMProxy paramCaptureMMProxy)
  {
    KUn = paramCaptureMMProxy;
  }
  
  public static CaptureMMProxy getInstance()
  {
    return KUn;
  }
  
  public boolean checkUseMMVideoPlayer()
  {
    AppMethodBeat.i(89331);
    Object localObject = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
    if (localObject != null)
    {
      Log.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", new Object[] { localObject });
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(89331);
      return bool;
    }
    AppMethodBeat.o(89331);
    return true;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean checkUseMMVideoPlayerInMM()
  {
    AppMethodBeat.i(89338);
    Log.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
    com.tencent.mm.modelcontrol.e.bIg();
    boolean bool = com.tencent.mm.modelcontrol.e.bIv();
    Log.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(89338);
    return bool;
  }
  
  public void clearArtistCache()
  {
    AppMethodBeat.i(89332);
    REMOTE_CALL("clearArtistCacheInMM", new Object[0]);
    AppMethodBeat.o(89332);
  }
  
  @com.tencent.mm.remoteservice.f
  public void clearArtistCacheInMM()
  {
    AppMethodBeat.i(89335);
    Log.d("MicroMsg.CaptureMMProxy", "clearArtistCacheInMM() called");
    ac.hdY.aAA().aAz();
    AppMethodBeat.o(89335);
  }
  
  public Object get(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(89322);
    Log.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[] { parama, paramObject });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, paramObject });
    Log.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[] { parama, paramObject, localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(89322);
      return paramObject;
    }
    AppMethodBeat.o(89322);
    return localObject;
  }
  
  public String getAccVideoPath()
  {
    AppMethodBeat.i(89320);
    String str = (String)REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
    Log.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + KUo);
    if (!Util.isNullOrNil(str)) {
      KUo = str;
    }
    if (!Util.isNullOrNil(KUo))
    {
      str = KUo;
      AppMethodBeat.o(89320);
      return str;
    }
    AppMethodBeat.o(89320);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAccVideoPathInMM()
  {
    AppMethodBeat.i(89339);
    Log.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
    v.bOg();
    String str = v.getAccVideoPath();
    AppMethodBeat.o(89339);
    return str;
  }
  
  public boolean getBoolean(at.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(89324);
    Log.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", new Object[] { parama, Boolean.valueOf(paramBoolean), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(89324);
      return paramBoolean;
    }
    paramBoolean = Util.getBoolean(localObject.toString(), paramBoolean);
    AppMethodBeat.o(89324);
    return paramBoolean;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(89341);
    at.a locala = ((at.a[])at.a.class.getEnumConstants())[paramInt];
    Log.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[] { locala, paramObject });
    h.baF();
    paramObject = h.baE().ban().get(locala, paramObject);
    AppMethodBeat.o(89341);
    return paramObject;
  }
  
  public String getDeviceInfoConfig()
  {
    AppMethodBeat.i(89328);
    String str = (String)REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    Log.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[] { str });
    AppMethodBeat.o(89328);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getDeviceInfoConfigInMM()
  {
    AppMethodBeat.i(89343);
    h.baF();
    String str = h.baE().bao().jcN();
    AppMethodBeat.o(89343);
    return str;
  }
  
  public String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(89329);
    String str = (String)REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    Log.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, str });
    AppMethodBeat.o(89329);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getDynamicConfigInMM(String paramString)
  {
    AppMethodBeat.i(89344);
    paramString = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue(paramString);
    AppMethodBeat.o(89344);
    return paramString;
  }
  
  public VideoTransPara getGameVideoTransPara(int paramInt)
  {
    AppMethodBeat.i(89327);
    Object localObject = (Parcelable)REMOTE_CALL("getGameVideoTransParaInMM", new Object[] { Integer.valueOf(paramInt) });
    Log.d("MicroMsg.CaptureMMProxy", "getGameVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(89327);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public VideoTransPara getGameVideoTransParaInMM(int paramInt)
  {
    AppMethodBeat.i(89337);
    Log.d("MicroMsg.CaptureMMProxy", "getGameVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bIg().vZ(paramInt);
    Log.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(89337);
    return localVideoTransPara;
  }
  
  public int getInt(at.a parama, int paramInt)
  {
    AppMethodBeat.i(89323);
    Log.i("MicroMsg.CaptureMMProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    Log.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(89323);
      return paramInt;
    }
    paramInt = Util.getInt(localObject.toString(), paramInt);
    AppMethodBeat.o(89323);
    return paramInt;
  }
  
  public VideoTransPara getSnsAlbumVideoTransPara()
  {
    AppMethodBeat.i(89326);
    Object localObject = (Parcelable)REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
    Log.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(89326);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public VideoTransPara getSnsAlbumVideoTransParaInMM()
  {
    AppMethodBeat.i(89336);
    Log.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bIg().bIk();
    Log.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(89336);
    return localVideoTransPara;
  }
  
  public String getSubCoreImageFullPath(String paramString)
  {
    AppMethodBeat.i(89321);
    paramString = (String)REMOTE_CALL("getSubCoreImageFullPathInMM", new Object[] { paramString });
    Log.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89321);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSubCoreImageFullPathInMM(String paramString)
  {
    AppMethodBeat.i(89340);
    Log.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[] { paramString });
    paramString = r.bKa().getFullPath(paramString);
    AppMethodBeat.o(89340);
    return paramString;
  }
  
  public byte[] getWeixinMeta()
  {
    AppMethodBeat.i(89330);
    byte[] arrayOfByte = (byte[])REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    Log.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[] { arrayOfByte });
    AppMethodBeat.o(89330);
    return arrayOfByte;
  }
  
  @com.tencent.mm.remoteservice.f
  public byte[] getWeixinMetaDataInMM()
  {
    AppMethodBeat.i(89345);
    byte[] arrayOfByte = com.tencent.mm.modelcontrol.e.bIg().getWeixinMeta();
    AppMethodBeat.o(89345);
    return arrayOfByte;
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(89347);
    Log.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        Log.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(89347);
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
            AppMethodBeat.o(89347);
            return;
          }
          if ("getConfigStorage".equals(paramString)) {
            Log.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
          }
          paramBundle.putSerializable("result_key", (Serializable)localObject2);
        }
      }
      AppMethodBeat.o(89347);
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
          localObject2 = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  public final Bundle q(Object... paramVarArgs)
  {
    AppMethodBeat.i(89346);
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
        else if ((paramVarArgs[i] instanceof at.a))
        {
          Log.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((at.a)paramVarArgs[i]).ordinal()) });
          localBundle.putInt(String.valueOf(i), ((at.a)paramVarArgs[i]).ordinal());
        }
        else
        {
          localBundle.putSerializable(String.valueOf(i), (Serializable)paramVarArgs[i]);
        }
      }
    }
    AppMethodBeat.o(89346);
    return localBundle;
  }
  
  public boolean set(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(89325);
    Boolean localBoolean = (Boolean)REMOTE_CALL("setConfigStorage", new Object[] { parama, paramObject });
    Log.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { parama, paramObject });
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(89325);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean setConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(89342);
    at.a locala = ((at.a[])at.a.class.getEnumConstants())[paramInt];
    Log.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { locala, paramObject });
    h.baF();
    h.baE().ban().set(locala, paramObject);
    AppMethodBeat.o(89342);
    return true;
  }
  
  public boolean useMediaRecordNew()
  {
    AppMethodBeat.i(89333);
    Object localObject = REMOTE_CALL("useMediaRecordNewInMM", new Object[0]);
    if (localObject != null)
    {
      Log.i("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM[%b]", new Object[] { localObject });
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(89333);
      return bool;
    }
    AppMethodBeat.o(89333);
    return true;
  }
  
  @com.tencent.mm.remoteservice.f
  public Boolean useMediaRecordNewInMM()
  {
    AppMethodBeat.i(89334);
    Log.d("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM() called");
    boolean bool = ((c)h.ax(c.class)).a(c.a.yVi, true);
    AppMethodBeat.o(89334);
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.CaptureMMProxy
 * JD-Core Version:    0.7.0.1
 */