package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFaceRegManager;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.tf;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
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
    AppMethodBeat.i(264897);
    startFaceImpl(paramInt, paramString1, paramString2, paramVoidBoolStringI32StringCallback, paramVoidCallback, paramString3, "");
    AppMethodBeat.o(264897);
  }
  
  public void startFaceImpl(int paramInt, String paramString1, String paramString2, VoidBoolStringI32StringCallback paramVoidBoolStringI32StringCallback, VoidCallback paramVoidCallback, String paramString3, String paramString4)
  {
    AppMethodBeat.i(264899);
    Object localObject = KindaContext.getTopOrUIPageFragmentActivity();
    if ((!(localObject instanceof UIPageFragmentActivity)) && (!(localObject instanceof WalletBrandUI)))
    {
      Log.e("MMKindaFaceRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(264899);
      return;
    }
    Log.i("MMKindaFaceRegManagerImpl", "siScene:%s，strPackage：%s,strPackageSign:%s,otherVerifyTitle:%s，faceVerifyTitle：%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
    if ((localObject instanceof WalletBrandUI))
    {
      localObject = (WalletBrandUI)localObject;
      ((WalletBrandUI)localObject).Pky = true;
      ((WalletBrandUI)localObject).jSq = paramVoidBoolStringI32StringCallback;
      ((WalletBrandUI)localObject).jSr = paramVoidCallback;
      paramVoidBoolStringI32StringCallback = new tf();
      paramVoidBoolStringI32StringCallback.fSA.fDf = ((Activity)localObject);
      paramVoidBoolStringI32StringCallback.fSA.scene = paramInt;
      paramVoidBoolStringI32StringCallback.fSA.packageName = paramString1;
      paramVoidBoolStringI32StringCallback.fSA.fSC = paramString2;
      paramVoidBoolStringI32StringCallback.fSA.fSD = paramString3;
      paramVoidBoolStringI32StringCallback.fSA.fSF = paramString4;
      paramVoidBoolStringI32StringCallback.fSA.requestCode = 4;
      EventCenter.instance.publish(paramVoidBoolStringI32StringCallback);
      AppMethodBeat.o(264899);
      return;
    }
    localObject = (UIPageFragmentActivity)localObject;
    ((UIPageFragmentActivity)localObject).jSq = paramVoidBoolStringI32StringCallback;
    ((UIPageFragmentActivity)localObject).jSr = paramVoidCallback;
    paramVoidBoolStringI32StringCallback = new tf();
    paramVoidBoolStringI32StringCallback.fSA.fDf = ((Activity)localObject);
    paramVoidBoolStringI32StringCallback.fSA.scene = paramInt;
    paramVoidBoolStringI32StringCallback.fSA.packageName = paramString1;
    paramVoidBoolStringI32StringCallback.fSA.fSC = paramString2;
    paramVoidBoolStringI32StringCallback.fSA.fSD = paramString3;
    paramVoidBoolStringI32StringCallback.fSA.fSF = paramString4;
    paramVoidBoolStringI32StringCallback.fSA.requestCode = 4;
    EventCenter.instance.publish(paramVoidBoolStringI32StringCallback);
    AppMethodBeat.o(264899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFaceRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */