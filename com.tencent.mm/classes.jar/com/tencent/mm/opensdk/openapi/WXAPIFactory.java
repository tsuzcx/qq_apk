package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory
{
  private static final String TAG = "MicroMsg.PaySdk.WXFactory";
  
  private WXAPIFactory()
  {
    AppMethodBeat.i(128079);
    RuntimeException localRuntimeException = new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    AppMethodBeat.o(128079);
    throw localRuntimeException;
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128077);
    paramContext = createWXAPI(paramContext, paramString, true);
    AppMethodBeat.o(128077);
    return paramContext;
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(128078);
    Log.d("MicroMsg.PaySdk.WXFactory", "createWXAPI, appId = " + paramString + ", checkSignature = " + paramBoolean);
    paramContext = new WXApiImplV10(paramContext, paramString, paramBoolean);
    AppMethodBeat.o(128078);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.WXAPIFactory
 * JD-Core Version:    0.7.0.1
 */