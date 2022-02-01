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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy
  extends com.tencent.mm.remoteservice.a
{
  private static CaptureMMProxy tBs;
  private static String tBt = "";
  
  public CaptureMMProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
  }
  
  public static void createProxy(CaptureMMProxy paramCaptureMMProxy)
  {
    tBs = paramCaptureMMProxy;
  }
  
  public static CaptureMMProxy getInstance()
  {
    return tBs;
  }
  
  public boolean checkUseMMVideoPlayer()
  {
    AppMethodBeat.i(89331);
    Object localObject = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
    if (localObject != null)
    {
      ad.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", new Object[] { localObject });
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
    ad.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
    com.tencent.mm.modelcontrol.d.awT();
    boolean bool = com.tencent.mm.modelcontrol.d.axf();
    ad.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: ".concat(String.valueOf(bool)));
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
    ad.d("MicroMsg.CaptureMMProxy", "clearArtistCacheInMM() called");
    y.cJB.IO().IN();
    AppMethodBeat.o(89335);
  }
  
  public Object get(ae.a parama, Object paramObject)
  {
    AppMethodBeat.i(89322);
    ad.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[] { parama, paramObject });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, paramObject });
    ad.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[] { parama, paramObject, localObject });
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
    ad.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + tBt);
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str)) {
      tBt = str;
    }
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(tBt))
    {
      str = tBt;
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
    ad.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
    com.tencent.mm.modelvideo.o.aCH();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(89339);
    return str;
  }
  
  public boolean getBoolean(ae.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(89324);
    ad.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", new Object[] { parama, Boolean.valueOf(paramBoolean), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(89324);
      return paramBoolean;
    }
    paramBoolean = com.tencent.mm.sdk.platformtools.bt.getBoolean(localObject.toString(), paramBoolean);
    AppMethodBeat.o(89324);
    return paramBoolean;
  }
  
  @f
  public Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(89341);
    ae.a locala = ((ae.a[])ae.a.class.getEnumConstants())[paramInt];
    ad.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.afC();
    paramObject = com.tencent.mm.kernel.g.afB().afk().get(locala, paramObject);
    AppMethodBeat.o(89341);
    return paramObject;
  }
  
  public String getDeviceInfoConfig()
  {
    AppMethodBeat.i(89328);
    String str = (String)REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    ad.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[] { str });
    AppMethodBeat.o(89328);
    return str;
  }
  
  @f
  public String getDeviceInfoConfigInMM()
  {
    AppMethodBeat.i(89343);
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().afl().eMW();
    AppMethodBeat.o(89343);
    return str;
  }
  
  public String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(89329);
    String str = (String)REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    ad.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, str });
    AppMethodBeat.o(89329);
    return str;
  }
  
  @f
  public String getDynamicConfigInMM(String paramString)
  {
    AppMethodBeat.i(89344);
    paramString = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue(paramString);
    AppMethodBeat.o(89344);
    return paramString;
  }
  
  public VideoTransPara getGameVideoTransPara(int paramInt)
  {
    AppMethodBeat.i(89327);
    Object localObject = (Parcelable)REMOTE_CALL("getGameVideoTransParaInMM", new Object[] { Integer.valueOf(paramInt) });
    ad.d("MicroMsg.CaptureMMProxy", "getGameVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(89327);
    return localObject;
  }
  
  @f
  public VideoTransPara getGameVideoTransParaInMM(int paramInt)
  {
    AppMethodBeat.i(89337);
    ad.d("MicroMsg.CaptureMMProxy", "getGameVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.awT().nO(paramInt);
    ad.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(89337);
    return localVideoTransPara;
  }
  
  public int getInt(ae.a parama, int paramInt)
  {
    AppMethodBeat.i(89323);
    ad.i("MicroMsg.CaptureMMProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    ad.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(89323);
      return paramInt;
    }
    paramInt = com.tencent.mm.sdk.platformtools.bt.getInt(localObject.toString(), paramInt);
    AppMethodBeat.o(89323);
    return paramInt;
  }
  
  public VideoTransPara getSnsAlbumVideoTransPara()
  {
    AppMethodBeat.i(89326);
    Object localObject = (Parcelable)REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
    ad.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: ".concat(String.valueOf(localObject)));
    localObject = (VideoTransPara)localObject;
    AppMethodBeat.o(89326);
    return localObject;
  }
  
  @f
  public VideoTransPara getSnsAlbumVideoTransParaInMM()
  {
    AppMethodBeat.i(89336);
    ad.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.awT().awW();
    ad.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(localVideoTransPara)));
    AppMethodBeat.o(89336);
    return localVideoTransPara;
  }
  
  public String getSubCoreImageFullPath(String paramString)
  {
    AppMethodBeat.i(89321);
    paramString = (String)REMOTE_CALL("getSubCoreImageFullPathInMM", new Object[] { paramString });
    ad.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89321);
    return paramString;
  }
  
  @f
  public String getSubCoreImageFullPathInMM(String paramString)
  {
    AppMethodBeat.i(89340);
    ad.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[] { paramString });
    paramString = com.tencent.mm.aw.o.ayF().getFullPath(paramString);
    AppMethodBeat.o(89340);
    return paramString;
  }
  
  public byte[] getWeixinMeta()
  {
    AppMethodBeat.i(89330);
    byte[] arrayOfByte = (byte[])REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    ad.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[] { arrayOfByte });
    AppMethodBeat.o(89330);
    return arrayOfByte;
  }
  
  @f
  public byte[] getWeixinMetaDataInMM()
  {
    AppMethodBeat.i(89345);
    byte[] arrayOfByte = com.tencent.mm.modelcontrol.d.awT().getWeixinMeta();
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
        else if ((paramVarArgs[i] instanceof ae.a))
        {
          ad.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((ae.a)paramVarArgs[i]).ordinal()) });
          localBundle.putInt(String.valueOf(i), ((ae.a)paramVarArgs[i]).ordinal());
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
    ad.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        ad.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(paramString) });
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
            ad.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
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
  
  public boolean set(ae.a parama, Object paramObject)
  {
    AppMethodBeat.i(89325);
    Boolean localBoolean = (Boolean)REMOTE_CALL("setConfigStorage", new Object[] { parama, paramObject });
    ad.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { parama, paramObject });
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(89325);
    return bool;
  }
  
  @f
  public boolean setConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(89342);
    ae.a locala = ((ae.a[])ae.a.class.getEnumConstants())[paramInt];
    ad.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(locala, paramObject);
    AppMethodBeat.o(89342);
    return true;
  }
  
  public boolean useMediaRecordNew()
  {
    AppMethodBeat.i(89333);
    Object localObject = REMOTE_CALL("useMediaRecordNewInMM", new Object[0]);
    if (localObject != null)
    {
      ad.i("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM[%b]", new Object[] { localObject });
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
    ad.d("MicroMsg.CaptureMMProxy", "useMediaRecordNewInMM() called");
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pqd, true);
    AppMethodBeat.o(89334);
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.CaptureMMProxy
 * JD-Core Version:    0.7.0.1
 */