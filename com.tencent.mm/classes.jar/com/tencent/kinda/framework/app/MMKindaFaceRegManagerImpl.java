package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFaceRegManager;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.uu;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKindaFaceRegManagerImpl
  implements KindaFaceRegManager
{
  private static final int FACE_ACTION_REQUEST_CODE = 1;
  private final String TAG = "MMKindaFaceRegManagerImpl";
  
  public void startFaceImpl(int paramInt, String paramString1, String paramString2, VoidBoolStringI32StringCallback paramVoidBoolStringI32StringCallback, VoidCallback paramVoidCallback, String paramString3)
  {
    AppMethodBeat.i(226370);
    startFaceImpl(paramInt, paramString1, paramString2, paramVoidBoolStringI32StringCallback, paramVoidCallback, paramString3, "");
    AppMethodBeat.o(226370);
  }
  
  public void startFaceImpl(int paramInt, String paramString1, String paramString2, VoidBoolStringI32StringCallback paramVoidBoolStringI32StringCallback, VoidCallback paramVoidCallback, String paramString3, String paramString4)
  {
    AppMethodBeat.i(226372);
    Object localObject = KindaContext.getTopOrUIPageFragmentActivity();
    if ((!(localObject instanceof UIPageFragmentActivity)) && (!(localObject instanceof WalletBrandUI)))
    {
      Log.e("MMKindaFaceRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(226372);
      return;
    }
    Log.i("MMKindaFaceRegManagerImpl", "siScene:%s，strPackage：%s,strPackageSign:%s,otherVerifyTitle:%s，faceVerifyTitle：%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    if ((localObject instanceof WalletBrandUI))
    {
      localObject = (WalletBrandUI)localObject;
      ((WalletBrandUI)localObject).WbB = true;
      ((WalletBrandUI)localObject).msH = paramVoidBoolStringI32StringCallback;
      ((WalletBrandUI)localObject).msI = paramVoidCallback;
      paramVoidBoolStringI32StringCallback = new uu();
      paramVoidBoolStringI32StringCallback.hYx.hHU = ((Activity)localObject);
      paramVoidBoolStringI32StringCallback.hYx.scene = paramInt;
      paramVoidBoolStringI32StringCallback.hYx.packageName = paramString1;
      paramVoidBoolStringI32StringCallback.hYx.hYz = paramString2;
      paramVoidBoolStringI32StringCallback.hYx.hYA = paramString3;
      paramVoidBoolStringI32StringCallback.hYx.hYD = paramString4;
      paramVoidBoolStringI32StringCallback.hYx.hPm = 4;
      paramVoidBoolStringI32StringCallback.publish();
      AppMethodBeat.o(226372);
      return;
    }
    localObject = (UIPageFragmentActivity)localObject;
    ((UIPageFragmentActivity)localObject).msH = paramVoidBoolStringI32StringCallback;
    ((UIPageFragmentActivity)localObject).msI = paramVoidCallback;
    paramVoidBoolStringI32StringCallback = new uu();
    paramVoidBoolStringI32StringCallback.hYx.hHU = ((Activity)localObject);
    paramVoidBoolStringI32StringCallback.hYx.scene = paramInt;
    paramVoidBoolStringI32StringCallback.hYx.packageName = paramString1;
    paramVoidBoolStringI32StringCallback.hYx.hYz = paramString2;
    paramVoidBoolStringI32StringCallback.hYx.hYA = paramString3;
    paramVoidBoolStringI32StringCallback.hYx.hYD = paramString4;
    paramVoidBoolStringI32StringCallback.hYx.hPm = 4;
    paramVoidBoolStringI32StringCallback.publish();
    AppMethodBeat.o(226372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFaceRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */