package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bw;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy
  extends com.tencent.mm.remoteservice.a
{
  private static CaptureMMProxy uJP;
  private static String uJQ = "";
  
  public CaptureMMProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
  }
  
  public static void createProxy(CaptureMMProxy paramCaptureMMProxy)
  {
    uJP = paramCaptureMMProxy;
  }
  
  public static CaptureMMProxy getInstance()
  {
    return uJP;
  }
  
  public boolean checkUseMMVideoPlayer()
  {
    AppMethodBeat.i(89331);
    Object localObject = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
    if (localObject != null)
    {
      ac.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", new Object[] { localObject });
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(89331);
      return bool;
    }
    AppMethodBeat.o(89331);
    return true;
  }
  
  @f
  public boolean checkUseMMVideoPlayerInMM()
  {
    AppMethodBeat.i(89338);
    ac.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
    com.tencent.mm.modelcontrol.d.aDL();
    boolean bool = com.tencent.mm.modelcontrol.d.aDX();
    ac.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(89338);
    return bool;
  }
  
  public void clearArtistCache()
  {
    AppMethodBeat.i(89332);
    REMOTE_CALL("clearArtistCacheInMM", new Object[0]);
    AppMethodBeat.o(89332);
  }
  
  @f
  public void clearArtistCacheInMM()
  {
    AppMethodBeat.i(89335);
    ac.d("MicroMsg.CaptureMMProxy", "clearArtistCacheInMM() called");
    y.cGI.Ix().Iw();
    AppMethodBeat.o(89335);
  }
  
  public Object get(ah.a parama, Object paramObject)
  {
    AppMethodBeat.i(89322);
    ac.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[] { parama, paramObject });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, paramObject });
    ac.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[] { parama, paramObject, localObject });
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
    ac.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + uJQ);
    if (!bs.isNullOrNil(str)) {
      uJQ = str;
    }
    if (!bs.isNullOrNil(uJQ))
    {
      str = uJQ;
      AppMethodBeat.o(89320);
      return str;
    }
    AppMethodBeat.o(89320);
    return str;
  }
  
  @f
  public String getAccVideoPathInMM()
  {
    AppMethodBeat.i(89339);
    ac.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
    com.tencent.mm.modelvideo.o.aJx();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(89339);
    return str;
  }
  
  public boolean getBoolean(ah.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(89324);
    ac.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    ac.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", new Object[] { parama, Boolean.valueOf(paramBoolean), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(89324);
      return paramBoolean;
    }
    paramBoolean = bs.getBoolean(localObject.toString(), paramBoolean);
    AppMethodBeat.o(89324);
    return paramBoolean;
  }
  
  @f
  public Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(89341);
    ah.a locala = ((ah.a[])ah.a.class.getEnumConstants())[paramInt];
    ac.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.agS();
    paramObject = com.tencent.mm.kernel.g.agR().agA().get(locala, paramObject);
    AppMethodBeat.o(89341);
    return paramObject;
  }
  
  public String getDeviceInfoConfig()
  {
    AppMethodBeat.i(89328);
    String str = (String)REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    ac.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[] { str });
    AppMethodBeat.o(89328);
    return str;
  }
  
  @f
  public String getDeviceInfoConfigInMM()
  {
    AppMethodBeat.i(89343);
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().agB().fcA();
    AppMethodBeat.o(89343);
    return str;
  }
  
  public String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(89329);
    String str = (String)REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    ac.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, str });
    AppMethodBeat.o(89329);
    return str;
  }
  
  @f
  public String getDynamicConfigInMM(String paramString)
  {
    AppMethodBeat.i(89344);
    paramString = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue(paramString);
    AppMethodBeat.o(89344);
    return paramString;
  }
  
  public VideoTransPara getGameVideoTransPara(int paramInt)
  {
    AppMethodBeat.i(89327);
    Object localObject = (Parcelable)REMOTE_CALL("getGameVideoTransParaInMM", new Object[] { Integer.valueOf(paramInt) });
    ac.d("MicroMsg.CaptureMMProxy", "getGameVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(89327);
    return localObject;
  }
  
  @f
  public VideoTransPara getGameVideoTransParaInMM(int paramInt)
  {
    AppMethodBeat.i(89337);
    ac.d("MicroMsg.CaptureMMProxy", "getGameVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.aDL().oC(paramInt);
    ac.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(89337);
    return localVideoTransPara;
  }
  
  public int getInt(ah.a parama, int paramInt)
  {
    AppMethodBeat.i(89323);
    ac.i("MicroMsg.CaptureMMProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    ac.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(89323);
      return paramInt;
    }
    paramInt = bs.getInt(localObject.toString(), paramInt);
    AppMethodBeat.o(89323);
    return paramInt;
  }
  
  public VideoTransPara getSnsAlbumVideoTransPara()
  {
    AppMethodBeat.i(89326);
    Object localObject = (Parcelable)REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
    ac.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(89326);
    return localObject;
  }
  
  @f
  public VideoTransPara getSnsAlbumVideoTransParaInMM()
  {
    AppMethodBeat.i(89336);
    ac.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.aDL().aDO();
    ac.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(89336);
    return localVideoTransPara;
  }
  
  public String getSubCoreImageFullPath(String paramString)
  {
    AppMethodBeat.i(89321);
    paramString = (String)REMOTE_CALL("getSubCoreImageFullPathInMM", new Object[] { paramString });
    ac.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89321);
    return paramString;
  }
  
  @f
  public String getSubCoreImageFullPathInMM(String paramString)
  {
    AppMethodBeat.i(89340);
    ac.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[] { paramString });
    paramString = com.tencent.mm.av.o.aFx().getFullPath(paramString);
    AppMethodBeat.o(89340);
    return paramString;
  }
  
  public byte[] getWeixinMeta()
  {
    AppMethodBeat.i(89330);
    byte[] arrayOfByte = (byte[])REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    ac.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[] { arrayOfByte });
    AppMethodBeat.o(89330);
    return arrayOfByte;
  }
  
  @f
  public byte[] getWeixinMetaDataInMM()
  {
    AppMethodBeat.i(89345);
    byte[] arrayOfByte = com.tencent.mm.modelcontrol.d.aDL().getWeixinMeta();
    AppMethodBeat.o(89345);
    return arrayOfByte;
  }
  
  public final Bundle objectsToBundle(Object... paramVarArgs)
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
        else if ((paramVarArgs[i] instanceof ah.a))
        {
          ac.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((ah.a)paramVarArgs[i]).ordinal()) });
          localBundle.putInt(String.valueOf(i), ((ah.a)paramVarArgs[i]).ordinal());
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
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(89347);
    ac.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        ac.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[] { bs.m(paramString) });
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
            ac.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
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
          localObject2 = f.class;
        }
      }
    }
  }
  
  public boolean set(ah.a parama, Object paramObject)
  {
    AppMethodBeat.i(89325);
    Boolean localBoolean = (Boolean)REMOTE_CALL("setConfigStorage", new Object[] { parama, paramObject });
    ac.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { parama, paramObject });
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(89325);
    return bool;
  }
  
  @f
  public boolean setConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(89342);
    ah.a locala = ((ah.a[])ah.a.class.getEnumConstants())[paramInt];
    ac.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(locala, paramObject);
    AppMethodBeat.o(89342);
    return true;
  }
  
  public boolean useMediaRecordNew()
  {
    AppMethodBeat.i(89333);
    Object localObject = REMOTE_CALL("useMediaRecordNewInMM", new Object[0]);
    if (localObject != null)
    {
      ac.i("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM[%b]", new Object[] { localObject });
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(89333);
      return bool;
    }
    AppMethodBeat.o(89333);
    return true;
  }
  
  @f
  public Boolean useMediaRecordNewInMM()
  {
    AppMethodBeat.i(89334);
    ac.d("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM() called");
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pTO, true);
    AppMethodBeat.o(89334);
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.CaptureMMProxy
 * JD-Core Version:    0.7.0.1
 */