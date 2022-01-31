package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SFSContext
{
  long mNativePtr;
  
  private SFSContext(Builder paramBuilder)
  {
    AppMethodBeat.i(93231);
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
      AppMethodBeat.o(93231);
      throw paramBuilder;
    }
    this.mNativePtr = l;
    AppMethodBeat.o(93231);
  }
  
  static native int nativeClear(long paramLong);
  
  static native String nativeErrorMessage();
  
  private static native boolean nativeExists(long paramLong, String paramString);
  
  private static native long nativeInit(String paramString);
  
  private static native int nativeList(long paramLong, String paramString, List<FileEntry> paramList);
  
  private static native long nativeOpenRead(long paramLong, String paramString);
  
  private static native long nativeOpenWrite(long paramLong, String paramString);
  
  private static native void nativeRelease(long paramLong);
  
  private static native void nativeSetIntArrayConf(int paramInt, int[] paramArrayOfInt);
  
  private static native void nativeSetIntConf(int paramInt1, int paramInt2);
  
  private static native void nativeSetStringConf(int paramInt, String paramString);
  
  private static native FileEntry nativeStat(long paramLong, String paramString);
  
  static native Statistics nativeStatistics(long paramLong);
  
  private static native boolean nativeUnlink(long paramLong, String paramString);
  
  public final OutputStream aU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93235);
    if (this.mNativePtr == 0L)
    {
      paramString1 = new IllegalArgumentException("Reuse already released SFSContext.");
      AppMethodBeat.o(93235);
      throw paramString1;
    }
    long l = nativeOpenWrite(this.mNativePtr, paramString1);
    if (l == 0L)
    {
      paramString1 = new IOException(paramString1 + ": " + nativeErrorMessage());
      AppMethodBeat.o(93235);
      throw paramString1;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new e(l, paramString2);
      AppMethodBeat.o(93235);
      return paramString1;
    }
    paramString1 = new SFSOutputStream(l);
    AppMethodBeat.o(93235);
    return paramString1;
  }
  
  public final boolean exists(String paramString)
  {
    AppMethodBeat.i(93237);
    if (this.mNativePtr == 0L)
    {
      paramString = new IllegalArgumentException("Reuse already released SFSContext.");
      AppMethodBeat.o(93237);
      throw paramString;
    }
    String str = paramString;
    if (f.ue(paramString))
    {
      f.ug(paramString);
      str = f.uf(paramString);
    }
    boolean bool = nativeExists(this.mNativePtr, str);
    AppMethodBeat.o(93237);
    return bool;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(93240);
    if (this.mNativePtr != 0L) {
      release();
    }
    super.finalize();
    AppMethodBeat.o(93240);
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(93233);
    if (this.mNativePtr == 0L)
    {
      paramString = new IllegalArgumentException("Reuse already released SFSContext.");
      AppMethodBeat.o(93233);
      throw paramString;
    }
    long l1;
    if (f.ue(paramString))
    {
      l1 = f.ug(paramString);
      paramString = f.uf(paramString);
    }
    for (;;)
    {
      long l2 = nativeOpenRead(this.mNativePtr, paramString);
      if (l2 == 0L)
      {
        paramString = new FileNotFoundException(paramString + ": " + nativeErrorMessage());
        AppMethodBeat.o(93233);
        throw paramString;
      }
      if (l1 != 0L)
      {
        paramString = new d(l2, l1);
        AppMethodBeat.o(93233);
        return paramString;
      }
      paramString = new SFSInputStream(l2);
      AppMethodBeat.o(93233);
      return paramString;
      l1 = 0L;
    }
  }
  
  public final OutputStream qC(String paramString)
  {
    AppMethodBeat.i(93234);
    if (this.mNativePtr == 0L)
    {
      paramString = new IllegalArgumentException("Reuse already released SFSContext.");
      AppMethodBeat.o(93234);
      throw paramString;
    }
    String str2 = "";
    String str1 = paramString;
    if (f.ue(paramString))
    {
      str2 = f.uh(paramString);
      str1 = f.uf(paramString);
    }
    paramString = aU(str1, str2);
    AppMethodBeat.o(93234);
    return paramString;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(93239);
    if (this.mNativePtr == 0L)
    {
      paramString = new IllegalArgumentException("Reuse already released SFSContext.");
      AppMethodBeat.o(93239);
      throw paramString;
    }
    String str = paramString;
    if (f.ue(paramString))
    {
      f.ug(paramString);
      str = f.uf(paramString);
    }
    boolean bool = nativeUnlink(this.mNativePtr, str);
    AppMethodBeat.o(93239);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93232);
    nativeRelease(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(93232);
  }
  
  public final List<FileEntry> ui(String paramString)
  {
    AppMethodBeat.i(93236);
    if (this.mNativePtr == 0L)
    {
      paramString = new IllegalArgumentException("Reuse already released SFSContext.");
      AppMethodBeat.o(93236);
      throw paramString;
    }
    ArrayList localArrayList = new ArrayList();
    if (nativeList(this.mNativePtr, paramString, localArrayList) != 0)
    {
      paramString = new IOException(nativeErrorMessage());
      AppMethodBeat.o(93236);
      throw paramString;
    }
    AppMethodBeat.o(93236);
    return localArrayList;
  }
  
  public final FileEntry uj(String paramString)
  {
    AppMethodBeat.i(93238);
    if (this.mNativePtr == 0L)
    {
      paramString = new IllegalArgumentException("Reuse already released SFSContext.");
      AppMethodBeat.o(93238);
      throw paramString;
    }
    String str = paramString;
    if (f.ue(paramString))
    {
      f.ug(paramString);
      str = f.uf(paramString);
    }
    paramString = nativeStat(this.mNativePtr, str);
    AppMethodBeat.o(93238);
    return paramString;
  }
  
  public static class Builder
    implements Parcelable
  {
    public static final Parcelable.Creator<Builder> CREATOR;
    HashMap<Integer, Object> mConf;
    String mName;
    
    static
    {
      AppMethodBeat.i(93229);
      CREATOR = new Parcelable.Creator()
      {
        public final SFSContext.Builder createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(93211);
          paramAnonymousParcel = new SFSContext.Builder(paramAnonymousParcel, null);
          AppMethodBeat.o(93211);
          return paramAnonymousParcel;
        }
        
        public final SFSContext.Builder[] newArray(int paramAnonymousInt)
        {
          return new SFSContext.Builder[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(93229);
    }
    
    public Builder()
    {
      AppMethodBeat.i(93225);
      this.mName = null;
      this.mConf = new HashMap();
      AppMethodBeat.o(93225);
    }
    
    private Builder(Parcel paramParcel)
    {
      AppMethodBeat.i(93228);
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
      AppMethodBeat.o(93228);
    }
    
    public SFSContext create()
    {
      AppMethodBeat.i(93226);
      SFSContext localSFSContext = new SFSContext(this, (byte)0);
      AppMethodBeat.o(93226);
      return localSFSContext;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public Builder setBlockFileMaxSize(int paramInt)
    {
      AppMethodBeat.i(93219);
      this.mConf.put(Integer.valueOf(4), Integer.valueOf(paramInt));
      AppMethodBeat.o(93219);
      return this;
    }
    
    public Builder setBlockFilePrefix(String paramString)
    {
      AppMethodBeat.i(93215);
      this.mConf.put(Integer.valueOf(2), paramString);
      AppMethodBeat.o(93215);
      return this;
    }
    
    public Builder setBlockSizeArray(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(93218);
      this.mConf.put(Integer.valueOf(5), paramArrayOfInt);
      AppMethodBeat.o(93218);
      return this;
    }
    
    public Builder setConnectionPool(int paramInt)
    {
      AppMethodBeat.i(93220);
      this.mConf.put(Integer.valueOf(7), Integer.valueOf(paramInt));
      AppMethodBeat.o(93220);
      return this;
    }
    
    public Builder setDBDirectory(String paramString)
    {
      AppMethodBeat.i(93224);
      String str = paramString;
      if (paramString.endsWith("/")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      this.mConf.put(Integer.valueOf(1), str + "/%s.index");
      AppMethodBeat.o(93224);
      return this;
    }
    
    public Builder setIOMode(int paramInt)
    {
      AppMethodBeat.i(93217);
      this.mConf.put(Integer.valueOf(9), Integer.valueOf(paramInt));
      AppMethodBeat.o(93217);
      return this;
    }
    
    public Builder setIndexDBPath(String paramString)
    {
      AppMethodBeat.i(93214);
      this.mConf.put(Integer.valueOf(1), paramString);
      AppMethodBeat.o(93214);
      return this;
    }
    
    public Builder setMaxConcurrentIO(int paramInt)
    {
      AppMethodBeat.i(93221);
      this.mConf.put(Integer.valueOf(10), Integer.valueOf(paramInt));
      AppMethodBeat.o(93221);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setOverflowPrefix(String paramString)
    {
      AppMethodBeat.i(93216);
      this.mConf.put(Integer.valueOf(3), paramString);
      AppMethodBeat.o(93216);
      return this;
    }
    
    public Builder setStoragePath(String paramString)
    {
      AppMethodBeat.i(93223);
      String str = paramString;
      if (paramString.endsWith("/")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      this.mConf.put(Integer.valueOf(2), str + "/%s.block");
      this.mConf.put(Integer.valueOf(3), str + "/%s/");
      AppMethodBeat.o(93223);
      return this;
    }
    
    public Builder setSyncMode(int paramInt)
    {
      AppMethodBeat.i(93222);
      this.mConf.put(Integer.valueOf(11), Integer.valueOf(paramInt));
      AppMethodBeat.o(93222);
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(93227);
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
      AppMethodBeat.o(93227);
    }
  }
  
  public static class FileEntry
  {
    public String name;
    public long size;
    public long timestamp;
  }
  
  public static class Statistics
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public BlockFile[] blockFiles;
    public long blockSizeEmpty;
    public long blockSizeUsed;
    public BlockType[] blockTypes;
    public long overflowActualSize;
    public long totalActualSize;
    
    public String toString()
    {
      int k = 0;
      AppMethodBeat.i(93230);
      Object localObject1 = new StringBuilder(4096);
      ((StringBuilder)localObject1).append("Total:\n\tActualSize: ").append(this.totalActualSize).append('\n').append("\tUsedBlockSize: ").append(this.blockSizeUsed).append('\n').append("\tEmptyBlockSize: ").append(this.blockSizeEmpty).append('\n').append("\tOverflowSize: ").append(this.overflowActualSize).append('\n');
      int i = 0;
      int j;
      Object localObject2;
      for (;;)
      {
        j = k;
        if (i >= this.blockTypes.length) {
          break;
        }
        localObject2 = this.blockTypes[i];
        ((StringBuilder)localObject1).append("BlockType: ").append(((BlockType)localObject2).blockSize).append('\n').append("\tUsedCount: ").append(((BlockType)localObject2).usedCount).append('\n').append("\tEmptyCount: ").append(((BlockType)localObject2).emptyCount).append('\n').append("\tActualSize: ").append(((BlockType)localObject2).actualSize).append('\n');
        i += 1;
      }
      while (j < this.blockFiles.length)
      {
        localObject2 = this.blockFiles[j];
        ((StringBuilder)localObject1).append("BlockFile: ").append(j).append('\n').append("\tFileSize: ").append(((BlockFile)localObject2).fileSize).append('\n').append("\tUsedBlockCount: ").append(((BlockFile)localObject2).blockCount).append('\n').append("\tEmptyBlockCount: ").append(((BlockFile)localObject2).emptyCount).append('\n').append("\tTimestamp: ").append(((BlockFile)localObject2).timestamp).append('\n').append("\tDeleted: ").append(((BlockFile)localObject2).deleted).append('\n');
        j += 1;
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      AppMethodBeat.o(93230);
      return localObject1;
    }
    
    public static class BlockFile
      implements Serializable
    {
      private static final long serialVersionUID = 1L;
      public int blockCount;
      public boolean deleted;
      public int emptyCount;
      public long fileSize;
      public long timestamp;
    }
    
    public static class BlockType
      implements Serializable
    {
      private static final long serialVersionUID = 1L;
      public long actualSize;
      public int blockSize;
      public int emptyCount;
      public int usedCount;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSContext
 * JD-Core Version:    0.7.0.1
 */