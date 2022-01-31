package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.z;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy
  extends com.tencent.mm.remoteservice.a
{
  private static CaptureMMProxy mfJ;
  private static String mfK = "";
  
  public CaptureMMProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
  }
  
  public static void createProxy(CaptureMMProxy paramCaptureMMProxy)
  {
    mfJ = paramCaptureMMProxy;
  }
  
  public static CaptureMMProxy getInstance()
  {
    return mfJ;
  }
  
  public boolean checkUseMMVideoPlayer()
  {
    Object localObject = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
    if (localObject != null)
    {
      y.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", new Object[] { localObject });
      return ((Boolean)localObject).booleanValue();
    }
    return true;
  }
  
  @f
  public boolean checkUseMMVideoPlayerInMM()
  {
    y.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
    com.tencent.mm.modelcontrol.d.Nl();
    boolean bool = com.tencent.mm.modelcontrol.d.Ns();
    y.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: " + bool);
    return bool;
  }
  
  public Object get(ac.a parama, Object paramObject)
  {
    y.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[] { parama, paramObject });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, paramObject });
    y.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[] { parama, paramObject, localObject });
    if (localObject == null) {
      return paramObject;
    }
    return localObject;
  }
  
  public String getAccVideoPath()
  {
    String str = (String)REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
    y.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + mfK);
    if (!bk.bl(str)) {
      mfK = str;
    }
    if (!bk.bl(mfK)) {
      str = mfK;
    }
    return str;
  }
  
  @f
  public String getAccVideoPathInMM()
  {
    y.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
    com.tencent.mm.modelvideo.o.Sq();
    return com.tencent.mm.modelvideo.o.getAccVideoPath();
  }
  
  public boolean getBoolean(ac.a parama, boolean paramBoolean)
  {
    y.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    y.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", new Object[] { parama, Boolean.valueOf(paramBoolean), localObject });
    if (localObject == null) {
      return paramBoolean;
    }
    return bk.getBoolean(localObject.toString(), paramBoolean);
  }
  
  @f
  public Object getConfigStorage(int paramInt, Object paramObject)
  {
    ac.a locala = ((ac.a[])ac.a.class.getEnumConstants())[paramInt];
    y.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().Dz().get(locala, paramObject);
  }
  
  public String getDeviceInfoConfig()
  {
    String str = (String)REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    y.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[] { str });
    return str;
  }
  
  @f
  public String getDeviceInfoConfigInMM()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().DA().cwa();
  }
  
  public String getDynamicConfig(String paramString)
  {
    String str = (String)REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    y.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, str });
    return str;
  }
  
  @f
  public String getDynamicConfigInMM(String paramString)
  {
    return ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue(paramString);
  }
  
  public int getInt(ac.a parama, int paramInt)
  {
    y.i("MicroMsg.CaptureMMProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    y.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null) {
      return paramInt;
    }
    return bk.getInt(localObject.toString(), paramInt);
  }
  
  public VideoTransPara getSnsAlbumVideoTransPara()
  {
    Parcelable localParcelable = (Parcelable)REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
    y.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: " + localParcelable);
    return (VideoTransPara)localParcelable;
  }
  
  @f
  public VideoTransPara getSnsAlbumVideoTransParaInMM()
  {
    y.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.Nl().No();
    y.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: " + localVideoTransPara);
    return localVideoTransPara;
  }
  
  public String getSubCoreImageFullPath(String paramString)
  {
    paramString = (String)REMOTE_CALL("getSubCoreImageFullPathInMM", new Object[] { paramString });
    y.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath " + paramString);
    return paramString;
  }
  
  @f
  public String getSubCoreImageFullPathInMM(String paramString)
  {
    y.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[] { paramString });
    return com.tencent.mm.as.o.OJ().getFullPath(paramString);
  }
  
  public byte[] getWeixinMeta()
  {
    byte[] arrayOfByte = (byte[])REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    y.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[] { arrayOfByte });
    return arrayOfByte;
  }
  
  @f
  public byte[] getWeixinMetaDataInMM()
  {
    return com.tencent.mm.modelcontrol.d.Nl().getWeixinMeta();
  }
  
  protected final Bundle objectsToBundle(Object... paramVarArgs)
  {
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
          y.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((ac.a)paramVarArgs[i]).ordinal()) });
          localBundle.putInt(String.valueOf(i), ((ac.a)paramVarArgs[i]).ordinal());
        }
        else
        {
          localBundle.putSerializable(String.valueOf(i), (Serializable)paramVarArgs[i]);
        }
      }
    }
    return localBundle;
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    y.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
          break label204;
        }
        localObject1 = arrayOfMethod[i];
        if (!((Method)localObject1).getName().equalsIgnoreCase(paramString)) {
          break label222;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[] { bk.j(paramString) });
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
            return;
          }
          if ("getConfigStorage".equals(paramString)) {
            y.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
          }
          paramBundle.putSerializable("result_key", (Serializable)localObject2);
          return;
          label204:
          if (localObject1 != null)
          {
            if (!paramBoolean) {
              break label231;
            }
            localObject2 = com.tencent.mm.remoteservice.e.class;
            continue;
          }
        }
      }
      return;
      label222:
      i += 1;
      continue;
      label231:
      localObject2 = f.class;
    }
  }
  
  public boolean set(ac.a parama, Object paramObject)
  {
    Boolean localBoolean = (Boolean)REMOTE_CALL("setConfigStorage", new Object[] { parama, paramObject });
    y.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { parama, paramObject });
    return localBoolean.booleanValue();
  }
  
  @f
  public boolean setConfigStorage(int paramInt, Object paramObject)
  {
    ac.a locala = ((ac.a[])ac.a.class.getEnumConstants())[paramInt];
    y.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[] { locala, paramObject });
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(locala, paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.CaptureMMProxy
 * JD-Core Version:    0.7.0.1
 */