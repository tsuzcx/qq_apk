package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.kinda.gen.KPlatformUIRouter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.sdk.event.EventCenter;
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
    paramString3 = new lk();
    paramString3.dQI.dIZ = paramInt1;
    paramString3.dQI.returnKey = paramString2;
    paramString3.dQI.dNI = paramString1;
    EventCenter.instance.publish(paramString3);
    AppMethodBeat.o(18675);
  }
  
  public void jointpayGotoExternApp(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18676);
    paramString3 = new lk();
    paramString3.dQI.dIZ = paramInt1;
    paramString3.dQI.returnKey = paramString2;
    paramString3.dQI.dNI = paramString1;
    EventCenter.instance.publish(paramString3);
    AppMethodBeat.o(18676);
  }
  
  public void openUrlScheme(String paramString)
  {
    AppMethodBeat.i(214453);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(214453);
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramString.axQ(), "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject).startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(214453);
      return;
    }
    Log.i("MicroMsg.PlatformUIRouterImpl", "startOuterApp callbackUrl is ".concat(String.valueOf(paramString)));
    Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    ((Intent)localObject).addFlags(268435456);
    if (Util.isIntentAvailable(MMApplicationContext.getContext(), (Intent)localObject))
    {
      paramString = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(214453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.PlatformUIRouterImpl
 * JD-Core Version:    0.7.0.1
 */