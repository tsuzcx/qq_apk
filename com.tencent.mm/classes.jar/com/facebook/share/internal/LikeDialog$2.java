package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeDialog$2
  implements CallbackManagerImpl.Callback
{
  LikeDialog$2(LikeDialog paramLikeDialog, ResultProcessor paramResultProcessor) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(97100);
    boolean bool = ShareInternalUtility.handleActivityResult(this.this$0.getRequestCode(), paramInt, paramIntent, this.val$resultProcessor);
    AppMethodBeat.o(97100);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.internal.LikeDialog.2
 * JD-Core Version:    0.7.0.1
 */