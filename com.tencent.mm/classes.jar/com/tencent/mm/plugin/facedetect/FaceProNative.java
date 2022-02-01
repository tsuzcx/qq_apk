package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  private static String[] cachedStr;
  public static volatile boolean hasDetectInit;
  private static long lastCheckTime;
  private long nativePtr;
  
  static
  {
    AppMethodBeat.i(103569);
    hasDetectInit = false;
    tryLoadLibrary();
    cachedStr = null;
    lastCheckTime = -1L;
    AppMethodBeat.o(103569);
  }
  
  public FaceProNative()
  {
    AppMethodBeat.i(103563);
    if (PluginFace.isEnabled())
    {
      tryLoadLibrary();
      NativeConstructor();
    }
    AppMethodBeat.o(103563);
  }
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static native String addVerifyData2Jpg(String paramString1, String paramString2, String paramString3);
  
  public static void checkInitDetectFace()
  {
    AppMethodBeat.i(103566);
    try
    {
      Log.printInfoStack("MicroMsg.FaceProNative", "checkInitDetectFace, hasDetectInit: %s", new Object[] { Boolean.valueOf(hasDetectInit) });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103548);
          if ((!FaceProNative.hasDetectInit) && (PluginFace.isEnabled()))
          {
            int i = FaceProNative.nativeFacedetectInitBin(u.aY(p.diq(), 0, -1));
            if (i == -1)
            {
              Log.w("MicroMsg.FaceProNative", "detectFaceCnt init failed: %s", new Object[] { p.diq() });
              AppMethodBeat.o(103548);
              return;
            }
            Log.i("MicroMsg.FaceProNative", "detectFaceCnt init:%d, %s", new Object[] { Integer.valueOf(i), p.diq() });
            FaceProNative.hasDetectInit = true;
          }
          AppMethodBeat.o(103548);
        }
      });
      return;
    }
    finally
    {
      AppMethodBeat.o(103566);
    }
  }
  
  public static int detectFaceCnt(String paramString)
  {
    return 0;
  }
  
  public static native int engineVersion();
  
  @Keep
  public static String[] getDynamicValue(String paramString)
  {
    AppMethodBeat.i(103568);
    if (System.currentTimeMillis() - lastCheckTime >= 3600000L)
    {
      lastCheckTime = System.currentTimeMillis();
      paramString = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue(paramString);
      if (Util.isNullOrNil(paramString)) {}
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
        Log.printErrStackTrace("MicroMsg.FaceProNative", paramString, "hy: array resolve failed", new Object[0]);
      }
    }
    paramString = cachedStr;
    AppMethodBeat.o(103568);
    return paramString;
  }
  
  public static native int nativeFacedetectInitBin(byte[] paramArrayOfByte);
  
  public static native void nativeFacedetectRelease();
  
  public static native int nativeFacedetectWithBitmap(Object paramObject);
  
  public static native boolean nativeInit();
  
  private static void tryLoadLibrary()
  {
    AppMethodBeat.i(103567);
    if (PluginFace.isEnabled())
    {
      com.tencent.mm.plugin.expansions.a.avY("wechatvoicereco");
      com.tencent.mm.plugin.expansions.a.avY("wechatxlog");
    }
    AppMethodBeat.o(103567);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(103564);
    if (PluginFace.isEnabled()) {
      NativeDestructor();
    }
    AppMethodBeat.o(103564);
  }
  
  public native FaceStatus engineFaceProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
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
    AppMethodBeat.i(103565);
    super.finalize();
    if (PluginFace.isEnabled()) {
      NativeDestructor();
    }
    AppMethodBeat.o(103565);
  }
  
  public static class FaceStatus
    implements Parcelable
  {
    public static final Parcelable.Creator<FaceStatus> CREATOR;
    public Rect facerect;
    public float pitch;
    public int result;
    public float roll;
    public float[] xys;
    public float yaw;
    
    static
    {
      AppMethodBeat.i(103562);
      CREATOR = new Parcelable.Creator()
      {
        public final FaceProNative.FaceStatus createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(103556);
          paramAnonymousParcel = new FaceProNative.FaceStatus(paramAnonymousParcel);
          AppMethodBeat.o(103556);
          return paramAnonymousParcel;
        }
        
        public final FaceProNative.FaceStatus[] newArray(int paramAnonymousInt)
        {
          return new FaceProNative.FaceStatus[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(103562);
    }
    
    public FaceStatus() {}
    
    protected FaceStatus(Parcel paramParcel)
    {
      AppMethodBeat.i(103559);
      this.result = paramParcel.readInt();
      this.facerect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
      this.xys = paramParcel.createFloatArray();
      this.pitch = paramParcel.readFloat();
      this.yaw = paramParcel.readFloat();
      this.roll = paramParcel.readFloat();
      AppMethodBeat.o(103559);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(103561);
      String str = "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
      AppMethodBeat.o(103561);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(103560);
      paramParcel.writeInt(this.result);
      paramParcel.writeParcelable(this.facerect, paramInt);
      paramParcel.writeFloatArray(this.xys);
      paramParcel.writeFloat(this.pitch);
      paramParcel.writeFloat(this.yaw);
      paramParcel.writeFloat(this.roll);
      AppMethodBeat.o(103560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative
 * JD-Core Version:    0.7.0.1
 */