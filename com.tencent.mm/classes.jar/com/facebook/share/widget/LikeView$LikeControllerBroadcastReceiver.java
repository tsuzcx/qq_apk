package com.facebook.share.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeView$LikeControllerBroadcastReceiver
  extends BroadcastReceiver
{
  private LikeView$LikeControllerBroadcastReceiver(LikeView paramLikeView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    AppMethodBeat.i(97637);
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getExtras();
    int i = j;
    if (paramIntent != null)
    {
      String str = paramIntent.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
      i = j;
      if (!Utility.isNullOrEmpty(str)) {
        if (!Utility.areObjectsEqual(LikeView.access$600(this.this$0), str)) {
          break label72;
        }
      }
    }
    label72:
    for (i = j; i == 0; i = 0)
    {
      AppMethodBeat.o(97637);
      return;
    }
    if ("com.facebook.sdk.LikeActionController.UPDATED".equals(paramContext))
    {
      LikeView.access$700(this.this$0);
      AppMethodBeat.o(97637);
      return;
    }
    if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(paramContext))
    {
      if (LikeView.access$800(this.this$0) != null)
      {
        LikeView.access$800(this.this$0).onError(NativeProtocol.getExceptionFromErrorData(paramIntent));
        AppMethodBeat.o(97637);
      }
    }
    else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(paramContext))
    {
      LikeView.access$1000(this.this$0, LikeView.access$600(this.this$0), LikeView.access$900(this.this$0));
      LikeView.access$700(this.this$0);
    }
    AppMethodBeat.o(97637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.widget.LikeView.LikeControllerBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */