package com.tencent.mm.modelsfs;

import android.text.TextUtils;
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
  
  private SFSContext(SFSContext.Builder paramBuilder)
  {
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
    if (l == 0L) {
      throw new RuntimeException(nativeErrorMessage());
    }
    this.mNativePtr = l;
  }
  
  private static native int nativeClear(long paramLong);
  
  static native String nativeErrorMessage();
  
  private static native boolean nativeExists(long paramLong, String paramString);
  
  private static native long nativeInit(String paramString);
  
  private static native int nativeList(long paramLong, String paramString, List<SFSContext.FileEntry> paramList);
  
  private static native long nativeOpenRead(long paramLong, String paramString);
  
  private static native long nativeOpenWrite(long paramLong, String paramString);
  
  private static native void nativeRelease(long paramLong);
  
  private static native void nativeSetIntArrayConf(int paramInt, int[] paramArrayOfInt);
  
  private static native void nativeSetIntConf(int paramInt1, int paramInt2);
  
  private static native void nativeSetStringConf(int paramInt, String paramString);
  
  private static native SFSContext.FileEntry nativeStat(long paramLong, String paramString);
  
  static native Statistics nativeStatistics(long paramLong);
  
  private static native boolean nativeUnlink(long paramLong, String paramString);
  
  public final OutputStream aB(String paramString1, String paramString2)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException("Reuse already released SFSContext.");
    }
    long l = nativeOpenWrite(this.mNativePtr, paramString1);
    if (l == 0L) {
      throw new IOException(paramString1 + ": " + nativeErrorMessage());
    }
    if (!TextUtils.isEmpty(paramString2)) {
      return new e(l, paramString2);
    }
    return new SFSOutputStream(l);
  }
  
  public final boolean exists(String paramString)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException("Reuse already released SFSContext.");
    }
    String str = paramString;
    if (f.mT(paramString))
    {
      f.mV(paramString);
      str = f.mU(paramString);
    }
    return nativeExists(this.mNativePtr, str);
  }
  
  protected void finalize()
  {
    if (this.mNativePtr != 0L) {
      release();
    }
    super.finalize();
  }
  
  public final OutputStream jI(String paramString)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException("Reuse already released SFSContext.");
    }
    String str2 = "";
    String str1 = paramString;
    if (f.mT(paramString))
    {
      str2 = f.mW(paramString);
      str1 = f.mU(paramString);
    }
    return aB(str1, str2);
  }
  
  public final boolean jJ(String paramString)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException("Reuse already released SFSContext.");
    }
    String str = paramString;
    if (f.mT(paramString))
    {
      f.mV(paramString);
      str = f.mU(paramString);
    }
    return nativeUnlink(this.mNativePtr, str);
  }
  
  public final List<SFSContext.FileEntry> mX(String paramString)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException("Reuse already released SFSContext.");
    }
    ArrayList localArrayList = new ArrayList();
    if (nativeList(this.mNativePtr, paramString, localArrayList) != 0) {
      throw new IOException(nativeErrorMessage());
    }
    return localArrayList;
  }
  
  public final SFSContext.FileEntry mY(String paramString)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException("Reuse already released SFSContext.");
    }
    String str = paramString;
    if (f.mT(paramString))
    {
      f.mV(paramString);
      str = f.mU(paramString);
    }
    return nativeStat(this.mNativePtr, str);
  }
  
  public final InputStream openRead(String paramString)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException("Reuse already released SFSContext.");
    }
    long l1;
    if (f.mT(paramString))
    {
      l1 = f.mV(paramString);
      paramString = f.mU(paramString);
    }
    for (;;)
    {
      long l2 = nativeOpenRead(this.mNativePtr, paramString);
      if (l2 == 0L) {
        throw new FileNotFoundException(paramString + ": " + nativeErrorMessage());
      }
      if (l1 != 0L) {
        return new d(l2, l1);
      }
      return new SFSInputStream(l2);
      l1 = 0L;
    }
  }
  
  public final void release()
  {
    nativeRelease(this.mNativePtr);
    this.mNativePtr = 0L;
  }
  
  public static class Statistics
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public SFSContext.Statistics.BlockFile[] blockFiles;
    public long blockSizeEmpty;
    public long blockSizeUsed;
    public SFSContext.Statistics.BlockType[] blockTypes;
    public long overflowActualSize;
    public long totalActualSize;
    
    public String toString()
    {
      int k = 0;
      StringBuilder localStringBuilder = new StringBuilder(4096);
      localStringBuilder.append("Total:\n\tActualSize: ").append(this.totalActualSize).append('\n').append("\tUsedBlockSize: ").append(this.blockSizeUsed).append('\n').append("\tEmptyBlockSize: ").append(this.blockSizeEmpty).append('\n').append("\tOverflowSize: ").append(this.overflowActualSize).append('\n');
      int i = 0;
      int j;
      Object localObject;
      for (;;)
      {
        j = k;
        if (i >= this.blockTypes.length) {
          break;
        }
        localObject = this.blockTypes[i];
        localStringBuilder.append("BlockType: ").append(((SFSContext.Statistics.BlockType)localObject).blockSize).append('\n').append("\tUsedCount: ").append(((SFSContext.Statistics.BlockType)localObject).usedCount).append('\n').append("\tEmptyCount: ").append(((SFSContext.Statistics.BlockType)localObject).emptyCount).append('\n').append("\tActualSize: ").append(((SFSContext.Statistics.BlockType)localObject).actualSize).append('\n');
        i += 1;
      }
      while (j < this.blockFiles.length)
      {
        localObject = this.blockFiles[j];
        localStringBuilder.append("BlockFile: ").append(j).append('\n').append("\tFileSize: ").append(((SFSContext.Statistics.BlockFile)localObject).fileSize).append('\n').append("\tUsedBlockCount: ").append(((SFSContext.Statistics.BlockFile)localObject).blockCount).append('\n').append("\tEmptyBlockCount: ").append(((SFSContext.Statistics.BlockFile)localObject).emptyCount).append('\n').append("\tTimestamp: ").append(((SFSContext.Statistics.BlockFile)localObject).timestamp).append('\n').append("\tDeleted: ").append(((SFSContext.Statistics.BlockFile)localObject).deleted).append('\n');
        j += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSContext
 * JD-Core Version:    0.7.0.1
 */