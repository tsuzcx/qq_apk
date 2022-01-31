package com.tencent.mm.game.liblockstep;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class LockStepNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_LOCKSTEP_ERROR;
  public static int REPEAT_INIT_ERROR;
  public static String TAG = "LockStepNative";
  private static boolean initCallBackFlag = false;
  volatile long mNativeInst;
  
  static
  {
    NEW_LOCKSTEP_ERROR = -1000;
    REPEAT_INIT_ERROR = -1001;
  }
  
  @Keep
  public LockStepNative(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(152613);
    this.mNativeInst = 0L;
    this.mNativeInst = initBindingLockStep(paramLong1, paramLong2);
    AppMethodBeat.o(152613);
  }
  
  private native void destoryBindingLockStep(long paramLong);
  
  private native long initBindingLockStep(long paramLong1, long paramLong2);
  
  private native int initCallBack(long paramLong, LockStepNative.ILockStepListener paramILockStepListener, LockStepNative.ILockStepReportListener paramILockStepReportListener);
  
  public static native void test();
  
  private native void testLockStepBinding(long paramLong);
  
  private native void updateNativeUdpInterface(long paramLong);
  
  @Keep
  public void destoryLockStep()
  {
    AppMethodBeat.i(152614);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(152614);
      return;
    }
    if (initCallBackFlag)
    {
      initCallBackFlag = false;
      destoryBindingLockStep(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(152614);
  }
  
  @Keep
  public int setCallback(LockStepNative.ILockStepListener paramILockStepListener, LockStepNative.ILockStepReportListener paramILockStepReportListener)
  {
    AppMethodBeat.i(152615);
    if (this.mNativeInst == -1L)
    {
      i = NEW_LOCKSTEP_ERROR;
      AppMethodBeat.o(152615);
      return i;
    }
    if (!initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new LockStepNative.1(this, paramILockStepListener), new LockStepNative.2(this, paramILockStepReportListener));
      if (i == 0)
      {
        initCallBackFlag = true;
        AppMethodBeat.o(152615);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(152615);
      return i;
    }
    int i = REPEAT_INIT_ERROR;
    AppMethodBeat.o(152615);
    return i;
  }
  
  public void testLockStepBinding()
  {
    AppMethodBeat.i(152617);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(152617);
      return;
    }
    testLockStepBinding(this.mNativeInst);
    AppMethodBeat.o(152617);
  }
  
  @Keep
  public void updateNativeInterface()
  {
    AppMethodBeat.i(152616);
    new StringBuilder("updateNativeInterface mNativeInst:").append(this.mNativeInst);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(152616);
      return;
    }
    updateNativeUdpInterface(this.mNativeInst);
    AppMethodBeat.o(152616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.game.liblockstep.LockStepNative
 * JD-Core Version:    0.7.0.1
 */