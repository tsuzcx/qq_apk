package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFaceRegManager;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.g.a.se;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKindaFaceRegManagerImpl
  implements KindaFaceRegManager
{
  private static final int FACE_ACTION_REQUEST_CODE = 1;
  private final String TAG = "MMKindaFaceRegManagerImpl";
  
  public void startFaceImpl(int paramInt, String paramString1, String paramString2, VoidBoolStringI32StringCallback paramVoidBoolStringI32StringCallback, VoidCallback paramVoidCallback, String paramString3)
  {
    AppMethodBeat.i(214427);
    Object localObject = KindaContext.getTopOrUIPageFragmentActivity();
    if ((!(localObject instanceof UIPageFragmentActivity)) && (!(localObject instanceof WalletBrandUI)))
    {
      Log.e("MMKindaFaceRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(214427);
      return;
    }
    if ((localObject instanceof WalletBrandUI))
    {
      localObject = (WalletBrandUI)localObject;
      ((WalletBrandUI)localObject).IrP = true;
      ((WalletBrandUI)localObject).hgw = paramVoidBoolStringI32StringCallback;
      ((WalletBrandUI)localObject).hgx = paramVoidCallback;
      paramVoidBoolStringI32StringCallback = new se();
      paramVoidBoolStringI32StringCallback.dYI.dKq = ((Activity)localObject);
      paramVoidBoolStringI32StringCallback.dYI.scene = paramInt;
      paramVoidBoolStringI32StringCallback.dYI.packageName = paramString1;
      paramVoidBoolStringI32StringCallback.dYI.dYK = paramString2;
      paramVoidBoolStringI32StringCallback.dYI.dYL = paramString3;
      paramVoidBoolStringI32StringCallback.dYI.requestCode = 4;
      EventCenter.instance.publish(paramVoidBoolStringI32StringCallback);
      AppMethodBeat.o(214427);
      return;
    }
    localObject = (UIPageFragmentActivity)localObject;
    ((UIPageFragmentActivity)localObject).hgw = paramVoidBoolStringI32StringCallback;
    ((UIPageFragmentActivity)localObject).hgx = paramVoidCallback;
    paramVoidBoolStringI32StringCallback = new se();
    paramVoidBoolStringI32StringCallback.dYI.dKq = ((Activity)localObject);
    paramVoidBoolStringI32StringCallback.dYI.scene = paramInt;
    paramVoidBoolStringI32StringCallback.dYI.packageName = paramString1;
    paramVoidBoolStringI32StringCallback.dYI.dYK = paramString2;
    paramVoidBoolStringI32StringCallback.dYI.dYL = paramString3;
    paramVoidBoolStringI32StringCallback.dYI.requestCode = 4;
    EventCenter.instance.publish(paramVoidBoolStringI32StringCallback);
    AppMethodBeat.o(214427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFaceRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */