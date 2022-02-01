package com.tencent.mm.game.liblockstep;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

@Keep
public class LockStepNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_LOCKSTEP_ERROR;
  public static int REPEAT_INIT_ERROR;
  public static String TAG = "LockStepNative";
  private boolean initCallBackFlag;
  volatile long mNativeInst;
  
  static
  {
    NEW_LOCKSTEP_ERROR = -1000;
    REPEAT_INIT_ERROR = -1001;
  }
  
  @Keep
  public LockStepNative(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(220926);
    this.mNativeInst = 0L;
    this.initCallBackFlag = false;
    this.mNativeInst = initBindingLockStep(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(220926);
  }
  
  private native void destoryBindingLockStep(long paramLong);
  
  private native long initBindingLockStep(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, ILockStepListener paramILockStepListener, ILockStepReportListener paramILockStepReportListener);
  
  private static native void initConfigLockStep(long paramLong, HashMap<String, String> paramHashMap);
  
  public static native void test();
  
  private native void testLockStepBinding(long paramLong);
  
  private native void updateNativeUdpInterface(long paramLong1, long paramLong2);
  
  @Keep
  public void destoryLockStep()
  {
    AppMethodBeat.i(43432);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(43432);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingLockStep(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(43432);
  }
  
  @Keep
  public void initConfig(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(43434);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(43434);
      return;
    }
    initConfigLockStep(this.mNativeInst, paramHashMap);
    AppMethodBeat.o(43434);
  }
  
  @Keep
  public int setCallback(final ILockStepListener paramILockStepListener, final ILockStepReportListener paramILockStepReportListener)
  {
    AppMethodBeat.i(43433);
    if (this.mNativeInst == -1L)
    {
      i = NEW_LOCKSTEP_ERROR;
      AppMethodBeat.o(43433);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new ILockStepListener()new ILockStepReportListener
      {
        public final void onCallBack(long paramAnonymousLong, String paramAnonymousString)
        {
          AppMethodBeat.i(43427);
          paramILockStepListener.onCallBack(paramAnonymousLong, paramAnonymousString);
          AppMethodBeat.o(43427);
        }
      }, new ILockStepReportListener()
      {
        public final int getNetworkType()
        {
          AppMethodBeat.i(43428);
          int i = paramILockStepReportListener.getNetworkType();
          AppMethodBeat.o(43428);
          return i;
        }
        
        public final void onIdKeyStat(int[] paramAnonymousArrayOfInt1, int[] paramAnonymousArrayOfInt2, int[] paramAnonymousArrayOfInt3)
        {
          AppMethodBeat.i(43430);
          paramILockStepReportListener.onIdKeyStat(paramAnonymousArrayOfInt1, paramAnonymousArrayOfInt2, paramAnonymousArrayOfInt3);
          AppMethodBeat.o(43430);
        }
        
        public final void onKvStat(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(43429);
          paramILockStepReportListener.onKvStat(paramAnonymousInt, paramAnonymousString);
          AppMethodBeat.o(43429);
        }
      });
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(43433);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(43433);
      return i;
    }
    int i = REPEAT_INIT_ERROR;
    AppMethodBeat.o(43433);
    return i;
  }
  
  public void testLockStepBinding()
  {
    AppMethodBeat.i(43436);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(43436);
      return;
    }
    testLockStepBinding(this.mNativeInst);
    AppMethodBeat.o(43436);
  }
  
  @Keep
  public void updateNativeInterface(long paramLong)
  {
    AppMethodBeat.i(43435);
    new StringBuilder("mmudp updateNativeInterface mNativeInst:").append(this.mNativeInst).append(",locksteplogicId:").append(paramLong);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(43435);
      return;
    }
    updateNativeUdpInterface(this.mNativeInst, paramLong);
    AppMethodBeat.o(43435);
  }
  
  @Keep
  public static abstract interface ILockStepListener
  {
    @Keep
    public abstract void onCallBack(long paramLong, String paramString);
  }
  
  @Keep
  public static abstract interface ILockStepReportListener
  {
    @Keep
    public abstract int getNetworkType();
    
    @Keep
    public abstract void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
    
    @Keep
    public abstract void onKvStat(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.liblockstep.LockStepNative
 * JD-Core Version:    0.7.0.1
 */