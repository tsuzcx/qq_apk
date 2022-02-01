package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SFSContext
{
  public long mNativePtr;
  
  private SFSContext(Builder paramBuilder)
  {
    AppMethodBeat.i(156021);
    Iterator localIterator = paramBuilder.mConf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof Integer)) {
        nativeSetIntConf(i, ((Integer)localObject).intValue());
      } else if ((localObject instanceof String)) {
        nativeSetStringConf(i, (String)localObject);
      } else if ((localObject instanceof int[])) {
        nativeSetIntArrayConf(i, (int[])localObject);
      }
    }
    long l = nativeInit(paramBuilder.mName);
    if (l == 0L)
    {
      paramBuilder = new RuntimeException(nativeErrorMessage());
      AppMethodBeat.o(156021);
      throw paramBuilder;
    }
    this.mNativePtr = l;
    AppMethodBeat.o(156021);
  }
  
  private static native int nativeClear(long paramLong);
  
  public static native String nativeErrorMessage();
  
  private static native boolean nativeExists(long paramLong, String paramString);
  
  private static native long nativeInit(String paramString);
  
  private static native int nativeList(long paramLong, String paramString, List<SFSContext.FileEntry> paramList);
  
  public static native long nativeOpenRead(long paramLong, String paramString);
  
  public static native long nativeOpenWrite(long paramLong, String paramString);
  
  private static native void nativeRelease(long paramLong);
  
  private static native void nativeSetIntArrayConf(int paramInt, int[] paramArrayOfInt);
  
  private static native void nativeSetIntConf(int paramInt1, int paramInt2);
  
  private static native void nativeSetStringConf(int paramInt, String paramString);
  
  private static native SFSContext.FileEntry nativeStat(long paramLong, String paramString);
  
  private static native SFSContext.Statistics nativeStatistics(long paramLong);
  
  public static native boolean nativeUnlink(long paramLong, String paramString);
  
  protected void finalize()
  {
    AppMethodBeat.i(156023);
    if (this.mNativePtr != 0L) {
      release();
    }
    super.finalize();
    AppMethodBeat.o(156023);
  }
  
  public final void release()
  {
    AppMethodBeat.i(156022);
    nativeRelease(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(156022);
  }
  
  public static class Builder
    implements Parcelable
  {
    public static final Parcelable.Creator<Builder> CREATOR;
    HashMap<Integer, Object> mConf;
    String mName;
    
    static
    {
      AppMethodBeat.i(156019);
      CREATOR = new Parcelable.Creator()
      {
        public final SFSContext.Builder createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(156001);
          paramAnonymousParcel = new SFSContext.Builder(paramAnonymousParcel, null);
          AppMethodBeat.o(156001);
          return paramAnonymousParcel;
        }
        
        public final SFSContext.Builder[] newArray(int paramAnonymousInt)
        {
          return new SFSContext.Builder[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(156019);
    }
    
    public Builder()
    {
      AppMethodBeat.i(156015);
      this.mName = null;
      this.mConf = new HashMap();
      AppMethodBeat.o(156015);
    }
    
    private Builder(Parcel paramParcel)
    {
      AppMethodBeat.i(156018);
      this.mName = paramParcel.readString();
      this.mConf = new HashMap();
      paramParcel = paramParcel.readArray(Builder.class.getClassLoader());
      if (paramParcel != null)
      {
        int i = 0;
        while (i < paramParcel.length)
        {
          if (paramParcel[i] != null) {
            this.mConf.put(Integer.valueOf(i), paramParcel[i]);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(156018);
    }
    
    public SFSContext create()
    {
      AppMethodBeat.i(156016);
      SFSContext localSFSContext = new SFSContext(this, (byte)0);
      AppMethodBeat.o(156016);
      return localSFSContext;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public Builder setBlockFileMaxSize(int paramInt)
    {
      AppMethodBeat.i(156009);
      this.mConf.put(Integer.valueOf(4), Integer.valueOf(paramInt));
      AppMethodBeat.o(156009);
      return this;
    }
    
    public Builder setBlockFilePrefix(String paramString)
    {
      AppMethodBeat.i(156005);
      this.mConf.put(Integer.valueOf(2), paramString);
      AppMethodBeat.o(156005);
      return this;
    }
    
    public Builder setBlockSizeArray(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(156008);
      this.mConf.put(Integer.valueOf(5), paramArrayOfInt);
      AppMethodBeat.o(156008);
      return this;
    }
    
    public Builder setConnectionPool(int paramInt)
    {
      AppMethodBeat.i(156010);
      this.mConf.put(Integer.valueOf(7), Integer.valueOf(paramInt));
      AppMethodBeat.o(156010);
      return this;
    }
    
    public Builder setDBDirectory(String paramString)
    {
      AppMethodBeat.i(156014);
      String str = paramString;
      if (paramString.endsWith("/")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      this.mConf.put(Integer.valueOf(1), str + "/%s.index");
      AppMethodBeat.o(156014);
      return this;
    }
    
    public Builder setIOMode(int paramInt)
    {
      AppMethodBeat.i(156007);
      this.mConf.put(Integer.valueOf(9), Integer.valueOf(paramInt));
      AppMethodBeat.o(156007);
      return this;
    }
    
    public Builder setIndexDBPath(String paramString)
    {
      AppMethodBeat.i(156004);
      this.mConf.put(Integer.valueOf(1), paramString);
      AppMethodBeat.o(156004);
      return this;
    }
    
    public Builder setMaxConcurrentIO(int paramInt)
    {
      AppMethodBeat.i(156011);
      this.mConf.put(Integer.valueOf(10), Integer.valueOf(paramInt));
      AppMethodBeat.o(156011);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setOverflowPrefix(String paramString)
    {
      AppMethodBeat.i(156006);
      this.mConf.put(Integer.valueOf(3), paramString);
      AppMethodBeat.o(156006);
      return this;
    }
    
    public Builder setStoragePath(String paramString)
    {
      AppMethodBeat.i(156013);
      String str = paramString;
      if (paramString.endsWith("/")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      this.mConf.put(Integer.valueOf(2), str + "/%s.block");
      this.mConf.put(Integer.valueOf(3), str + "/%s/");
      AppMethodBeat.o(156013);
      return this;
    }
    
    public Builder setSyncMode(int paramInt)
    {
      AppMethodBeat.i(156012);
      this.mConf.put(Integer.valueOf(11), Integer.valueOf(paramInt));
      AppMethodBeat.o(156012);
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(156017);
      paramParcel.writeString(this.mName);
      Object[] arrayOfObject = new Object[12];
      Iterator localIterator = this.mConf.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramInt = ((Integer)localEntry.getKey()).intValue();
        if ((paramInt < 12) && (paramInt >= 0)) {
          arrayOfObject[paramInt] = localEntry.getValue();
        }
      }
      paramParcel.writeArray(arrayOfObject);
      AppMethodBeat.o(156017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSContext
 * JD-Core Version:    0.7.0.1
 */