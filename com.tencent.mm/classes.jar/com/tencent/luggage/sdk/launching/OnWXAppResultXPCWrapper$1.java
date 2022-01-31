package com.tencent.luggage.sdk.launching;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

class OnWXAppResultXPCWrapper$1
  extends ResultReceiver
{
  OnWXAppResultXPCWrapper$1(OnWXAppResultXPCWrapper paramOnWXAppResultXPCWrapper, Handler paramHandler, b paramb)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(101669);
    if (paramBundle == null)
    {
      this.bEW.b(null);
      AppMethodBeat.o(101669);
      return;
    }
    paramBundle.setClassLoader(OnWXAppResultXPCWrapper.SafeParcelableWrapper.class.getClassLoader());
    try
    {
      this.bEW.b(OnWXAppResultXPCWrapper.SafeParcelableWrapper.a((OnWXAppResultXPCWrapper.SafeParcelableWrapper)paramBundle.getParcelable("parcel")));
      AppMethodBeat.o(101669);
      return;
    }
    catch (NullPointerException paramBundle)
    {
      d.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "onReceiveResult, e = %s", new Object[] { paramBundle });
      this.bEW.b(null);
      AppMethodBeat.o(101669);
      return;
    }
    catch (ClassCastException paramBundle)
    {
      label62:
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.1
 * JD-Core Version:    0.7.0.1
 */