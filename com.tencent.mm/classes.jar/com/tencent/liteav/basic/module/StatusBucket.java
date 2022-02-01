package com.tencent.liteav.basic.module;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StatusBucket
{
  private static final String TAG;
  private long mBucketObj;
  
  static
  {
    AppMethodBeat.i(222034);
    TAG = StatusBucket.class.getName();
    AppMethodBeat.o(222034);
  }
  
  public StatusBucket()
  {
    AppMethodBeat.i(222024);
    this.mBucketObj = 0L;
    this.mBucketObj = nativeCreateStatusBucket();
    AppMethodBeat.o(222024);
  }
  
  public StatusBucket(long paramLong)
  {
    this.mBucketObj = 0L;
    this.mBucketObj = paramLong;
  }
  
  private static native long nativeCreateStatusBucket();
  
  private static native void nativeDestroyStatusBucket(long paramLong);
  
  private static native boolean nativeGetBooleanStatus(long paramLong, String paramString, int paramInt);
  
  private static native int nativeGetIntStatus(long paramLong, String paramString, int paramInt);
  
  private static native long nativeGetLongStatus(long paramLong, String paramString, int paramInt);
  
  private static native void nativeMerge(long paramLong1, long paramLong2);
  
  private static native void nativeSetBooleanStatus(long paramLong, String paramString, int paramInt, boolean paramBoolean);
  
  private static native void nativeSetIntStatus(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeSetLongStatus(long paramLong1, String paramString, int paramInt, long paramLong2);
  
  public static void testStatusBucket()
  {
    AppMethodBeat.i(222033);
    StatusBucket localStatusBucket1 = new StatusBucket();
    StatusBucket localStatusBucket2 = new StatusBucket();
    localStatusBucket1.setBooleanStatus("1", 1, true);
    localStatusBucket1.setIntStatus("2", 2, 2);
    localStatusBucket1.setLongStatus("3", 3, 3L);
    localStatusBucket2.setIntStatus("1", 4, 4);
    localStatusBucket2.setBooleanStatus("5", 5, true);
    localStatusBucket2.setLongStatus("6", 6, 6L);
    localStatusBucket1.merge(localStatusBucket2);
    TXCLog.e(TAG, "test_status_bucket: id:1, key:1, value:" + localStatusBucket1.getBooleanStatus("1", 1));
    TXCLog.e(TAG, "test_status_bucket: id:1, key:4, value:" + localStatusBucket1.getIntStatus("1", 4));
    TXCLog.e(TAG, "test_status_bucket: id:2, key:2, value:" + localStatusBucket1.getIntStatus("2", 2));
    TXCLog.e(TAG, "test_status_bucket: id:3, key:3, value:" + localStatusBucket1.getLongStatus("3", 3));
    TXCLog.e(TAG, "test_status_bucket: id:5, key:5, value:" + localStatusBucket1.getBooleanStatus("5", 5));
    TXCLog.e(TAG, "test_status_bucket: id:6, key:6, value:" + localStatusBucket1.getLongStatus("6", 6));
    AppMethodBeat.o(222033);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(222032);
    super.finalize();
    long l = this.mBucketObj;
    this.mBucketObj = 0L;
    nativeDestroyStatusBucket(l);
    AppMethodBeat.o(222032);
  }
  
  public boolean getBooleanStatus(String paramString, int paramInt)
  {
    AppMethodBeat.i(222028);
    boolean bool = nativeGetBooleanStatus(this.mBucketObj, paramString, paramInt);
    AppMethodBeat.o(222028);
    return bool;
  }
  
  public int getIntStatus(String paramString, int paramInt)
  {
    AppMethodBeat.i(222029);
    paramInt = nativeGetIntStatus(this.mBucketObj, paramString, paramInt);
    AppMethodBeat.o(222029);
    return paramInt;
  }
  
  public long getLongStatus(String paramString, int paramInt)
  {
    AppMethodBeat.i(222030);
    long l = nativeGetLongStatus(this.mBucketObj, paramString, paramInt);
    AppMethodBeat.o(222030);
    return l;
  }
  
  public void merge(StatusBucket paramStatusBucket)
  {
    AppMethodBeat.i(222031);
    nativeMerge(this.mBucketObj, paramStatusBucket.mBucketObj);
    AppMethodBeat.o(222031);
  }
  
  public void setBooleanStatus(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(222025);
    nativeSetBooleanStatus(this.mBucketObj, paramString, paramInt, paramBoolean);
    AppMethodBeat.o(222025);
  }
  
  public void setIntStatus(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222026);
    nativeSetIntStatus(this.mBucketObj, paramString, paramInt1, paramInt2);
    AppMethodBeat.o(222026);
  }
  
  public void setLongStatus(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(222027);
    nativeSetLongStatus(this.mBucketObj, paramString, paramInt, paramLong);
    AppMethodBeat.o(222027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.module.StatusBucket
 * JD-Core Version:    0.7.0.1
 */