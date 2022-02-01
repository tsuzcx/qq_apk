package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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
  
  public static void checkInitDetectFace()
  {
    AppMethodBeat.i(103566);
    try
    {
      ad.m("MicroMsg.FaceProNative", "checkInitDetectFace, hasDetectInit: %s", new Object[] { Boolean.valueOf(hasDetectInit) });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103548);
          if ((!FaceProNative.hasDetectInit) && (PluginFace.isEnabled()))
          {
            int i = FaceProNative.nativeFacedetectInitBin(i.aR(p.cgd(), 0, -1));
            if (i == -1)
            {
              ad.w("MicroMsg.FaceProNative", "detectFaceCnt init failed: %s", new Object[] { p.cgd() });
              AppMethodBeat.o(103548);
              return;
            }
            ad.i("MicroMsg.FaceProNative", "detectFaceCnt init:%d, %s", new Object[] { Integer.valueOf(i), p.cgd() });
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
      paramString = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue(paramString);
      if (bt.isNullOrNil(paramString)) {}
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
        ad.printErrStackTrace("MicroMsg.FaceProNative", paramString, "hy: array resolve failed", new Object[0]);
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
      com.tencent.mm.plugin.expansions.a.Vi("FacePro");
      com.tencent.mm.plugin.expansions.a.Vi("wechatvoicereco");
      com.tencent.mm.plugin.expansions.a.Vi("wechatxlog");
      nativeInit();
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
  
  public native FaceProNative.FaceStatus engineFaceProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int[] engineGetAllMotions();
  
  public native int engineGetCurrMotion();
  
  public native String engineGetCurrMotionData();
  
  public native int engineGroupChange();
  
  public native int engineInit(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3);
  
  public native int engineNextMotion();
  
  public native int engineRelease();
  
  public native int engineReleaseCurrMotion();
  
  public native FaceResult engineReleaseOut();
  
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
  
  public static class FaceResult
    implements Parcelable
  {
    public static final Parcelable.Creator<FaceResult> CREATOR;
    public byte[] data;
    public int result;
    public byte[] sidedata;
    
    static
    {
      AppMethodBeat.i(103555);
      CREATOR = new Parcelable.Creator()
      {
        public final FaceProNative.FaceResult createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(103549);
          paramAnonymousParcel = new FaceProNative.FaceResult(paramAnonymousParcel);
          AppMethodBeat.o(103549);
          return paramAnonymousParcel;
        }
        
        public final FaceProNative.FaceResult[] newArray(int paramAnonymousInt)
        {
          return new FaceProNative.FaceResult[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(103555);
    }
    
    public FaceResult() {}
    
    protected FaceResult(Parcel paramParcel)
    {
      AppMethodBeat.i(103552);
      this.result = paramParcel.readInt();
      this.data = paramParcel.createByteArray();
      this.sidedata = paramParcel.createByteArray();
      AppMethodBeat.o(103552);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      int j = 0;
      AppMethodBeat.i(103554);
      Object localObject = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=");
      if (this.sidedata == null)
      {
        i = 0;
        localObject = ((StringBuilder)localObject).append(i).append(", dataLen=");
        if (this.data != null) {
          break label88;
        }
      }
      label88:
      for (int i = j;; i = this.data.length)
      {
        localObject = i + '}';
        AppMethodBeat.o(103554);
        return localObject;
        i = this.sidedata.length;
        break;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(103553);
      paramParcel.writeInt(this.result);
      paramParcel.writeByteArray(this.data);
      paramParcel.writeByteArray(this.sidedata);
      AppMethodBeat.o(103553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative
 * JD-Core Version:    0.7.0.1
 */