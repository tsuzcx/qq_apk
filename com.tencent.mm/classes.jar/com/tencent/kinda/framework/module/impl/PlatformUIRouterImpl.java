package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.kinda.gen.KPlatformUIRouter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class PlatformUIRouterImpl
  implements KPlatformUIRouter
{
  public static final String TAG = "MicroMsg.PlatformUIRouterImpl";
  private byte _hellAccFlag_;
  
  public void gotoExternApp(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18675);
    paramString3 = new nh();
    paramString3.hPE.hGE = paramInt1;
    paramString3.hPE.returnKey = paramString2;
    paramString3.hPE.appid = paramString1;
    paramString3.publish();
    AppMethodBeat.o(18675);
  }
  
  public void jointpayGotoExternApp(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18676);
    paramString3 = new nh();
    paramString3.hPE.hGE = paramInt1;
    paramString3.hPE.returnKey = paramString2;
    paramString3.hPE.appid = paramString1;
    paramString3.publish();
    AppMethodBeat.o(18676);
  }
  
  public void openUrlScheme(String paramString)
  {
    AppMethodBeat.i(226681);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(226681);
      return;
    }
    if (paramString.startsWith("telprompt://"))
    {
      Log.i("MicroMsg.PlatformUIRouterImpl", "call dial: %s", new Object[] { paramString });
      localObject = paramString.replace("telprompt://", "");
      paramString = new Intent("android.intent.action.DIAL");
      paramString.setFlags(268435456);
      paramString.setData(Uri.parse("tel:".concat(String.valueOf(localObject))));
      if (Util.isIntentAvailable(MMApplicationContext.getContext(), paramString))
      {
        localObject = MMApplicationContext.getContext();
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject).startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(226681);
      return;
    }
    Log.i("MicroMsg.PlatformUIRouterImpl", "startOuterApp callbackUrl is ".concat(String.valueOf(paramString)));
    Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    ((Intent)localObject).addFlags(268435456);
    if (Util.isIntentAvailable(MMApplicationContext.getContext(), (Intent)localObject))
    {
      paramString = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(226681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.PlatformUIRouterImpl
 * JD-Core Version:    0.7.0.1
 */