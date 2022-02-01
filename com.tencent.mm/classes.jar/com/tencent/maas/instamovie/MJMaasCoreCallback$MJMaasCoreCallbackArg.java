package com.tencent.maas.instamovie;

import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;

public class MJMaasCoreCallback$MJMaasCoreCallbackArg
  extends NativeCallbackManager.CallbackArgs
{
  public static class BoolCompleteArg
    extends MJMaasCoreCallback.MJMaasCoreCallbackArg
  {
    public final boolean value;
    
    public BoolCompleteArg(boolean paramBoolean)
    {
      this.value = paramBoolean;
    }
  }
  
  public static class CompleteArg
    extends MJMaasCoreCallback.MJMaasCoreCallbackArg
  {
    public final MJError error;
    
    public CompleteArg(MJError paramMJError)
    {
      this.error = paramMJError;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMaasCoreCallback.MJMaasCoreCallbackArg
 * JD-Core Version:    0.7.0.1
 */