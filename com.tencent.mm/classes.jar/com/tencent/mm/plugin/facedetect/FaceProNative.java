package com.tencent.mm.plugin.facedetect;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.Keep;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class FaceProNative
{
  public static final int ROTFLIPHOR = 3;
  public static final int ROTFLIPLEFT = 4;
  public static final int ROTFLIPRIGHT = 5;
  public static final int ROTLEFT = 1;
  public static final int ROTRIGHT = 2;
  public static final int ROTSTABLE = 0;
  private static final String TAG = "MicroMsg.FaceProNative";
  private static final long TIMEOUT_CHECKER = 3600000L;
  private static String[] cachedStr = null;
  public static volatile boolean hasDetectInit = false;
  private static long lastCheckTime = -1L;
  private long nativePtr;
  
  static
  {
    k.b("FacePro", FaceProNative.class.getClassLoader());
    k.b("wechatvoicereco", FaceProNative.class.getClassLoader());
    k.b("wechatxlog", FaceProNative.class.getClassLoader());
    nativeInit();
  }
  
  public FaceProNative()
  {
    NativeConstructor();
  }
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static void checkInitDetectFace()
  {
    try
    {
      y.l("MicroMsg.FaceProNative", "checkInitDetectFace, hasDetectInit: %s", new Object[] { Boolean.valueOf(hasDetectInit) });
      ai.d(new FaceProNative.1());
      return;
    }
    finally {}
  }
  
  public static int detectFaceCnt(String paramString)
  {
    
    if (!hasDetectInit) {
      return 0;
    }
    Object localObject = c.YU(paramString);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    i = ((BitmapFactory.Options)localObject).outHeight * i / 270000;
    if (i >= 4) {}
    for (i = (int)Math.sqrt(i);; i = 1)
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        y.e("MicroMsg.FaceProNative", "detectFaceCnt  bitmap is null: %s", new Object[] { paramString });
        return 0;
      }
      y.i("MicroMsg.FaceProNative", "detectFaceCnt  bitmap is not  null: %s", new Object[] { localObject });
      return nativeFacedetectWithBitmap(localObject);
    }
  }
  
  public static native int engineVersion();
  
  @Keep
  public static String[] getDynamicValue(String paramString)
  {
    if (System.currentTimeMillis() - lastCheckTime >= 3600000L)
    {
      lastCheckTime = System.currentTimeMillis();
      paramString = ((a)g.r(a.class)).AA().getValue(paramString);
      if (bk.bl(paramString)) {}
    }
    try
    {
      paramString = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList(5);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramString.getString(i));
        i += 1;
      }
      cachedStr = new String[j];
      localArrayList.toArray(cachedStr);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FaceProNative", paramString, "hy: array resolve failed", new Object[0]);
      }
    }
    return cachedStr;
  }
  
  public static native int nativeFacedetectInitBin(byte[] paramArrayOfByte);
  
  public static native void nativeFacedetectRelease();
  
  public static native int nativeFacedetectWithBitmap(Object paramObject);
  
  public static native boolean nativeInit();
  
  public void destroy()
  {
    NativeDestructor();
  }
  
  public native FaceProNative.FaceStatus engineFaceProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int[] engineGetAllMotions();
  
  public native int engineGetCurrMotion();
  
  public native String engineGetCurrMotionData();
  
  public native int engineGroupChange();
  
  public native int engineInit(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3);
  
  public native int engineNextMotion();
  
  public native int engineRelease();
  
  public native int engineReleaseCurrMotion();
  
  public native FaceProNative.FaceResult engineReleaseOut();
  
  public native int engineSetVoiceData(byte[] paramArrayOfByte);
  
  public native int engineStartRecord();
  
  protected void finalize()
  {
    super.finalize();
    NativeDestructor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative
 * JD-Core Version:    0.7.0.1
 */