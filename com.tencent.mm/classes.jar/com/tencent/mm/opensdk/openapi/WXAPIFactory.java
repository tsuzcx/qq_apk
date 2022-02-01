package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory
{
  private static final String TAG = "MicroMsg.PaySdk.WXFactory";
  
  private WXAPIFactory()
  {
    AppMethodBeat.i(3767);
    RuntimeException localRuntimeException = new RuntimeException(WXAPIFactory.class.getSimpleName() + " should not be instantiated");
    AppMethodBeat.o(3767);
    throw localRuntimeException;
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(3765);
    paramContext = createWXAPI(paramContext, paramString, true);
    AppMethodBeat.o(3765);
    return paramContext;
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(3766);
    Log.d("MicroMsg.PaySdk.WXFactory", "createWXAPI, appId = " + paramString + ", checkSignature = " + paramBoolean);
    paramContext = createWXAPI(paramContext, paramString, paramBoolean, 2);
    AppMethodBeat.o(3766);
    return paramContext;
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(253793);
    Log.d("MicroMsg.PaySdk.WXFactory", "createWXAPI, appId = " + paramString + ", checkSignature = " + paramBoolean + ", launchMode = " + paramInt);
    paramContext = new WXApiImplV10(paramContext, paramString, paramBoolean, paramInt);
    AppMethodBeat.o(253793);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.WXAPIFactory
 * JD-Core Version:    0.7.0.1
 */