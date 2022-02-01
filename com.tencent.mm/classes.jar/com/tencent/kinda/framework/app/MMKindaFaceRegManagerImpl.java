package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFaceRegManager;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public class MMKindaFaceRegManagerImpl
  implements KindaFaceRegManager
{
  private static final int FACE_ACTION_REQUEST_CODE = 1;
  private final String TAG = "MMKindaFaceRegManagerImpl";
  
  public void startFaceImpl(int paramInt, String paramString1, String paramString2, VoidBoolStringI32StringCallback paramVoidBoolStringI32StringCallback, VoidCallback paramVoidCallback, String paramString3)
  {
    AppMethodBeat.i(199427);
    Object localObject = KindaContext.getTopOrUIPageFragmentActivity();
    if ((!(localObject instanceof UIPageFragmentActivity)) && (!(localObject instanceof WalletBrandUI)))
    {
      ad.e("MMKindaFaceRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(199427);
      return;
    }
    if ((localObject instanceof WalletBrandUI))
    {
      localObject = (WalletBrandUI)localObject;
      ((WalletBrandUI)localObject).DqT = true;
      ((WalletBrandUI)localObject).grl = paramVoidBoolStringI32StringCallback;
      ((WalletBrandUI)localObject).grm = paramVoidCallback;
      paramVoidBoolStringI32StringCallback = new rh();
      paramVoidBoolStringI32StringCallback.dFR.dsa = ((Activity)localObject);
      paramVoidBoolStringI32StringCallback.dFR.scene = paramInt;
      paramVoidBoolStringI32StringCallback.dFR.packageName = paramString1;
      paramVoidBoolStringI32StringCallback.dFR.dFT = paramString2;
      paramVoidBoolStringI32StringCallback.dFR.dFU = paramString3;
      paramVoidBoolStringI32StringCallback.dFR.requestCode = 4;
      a.IbL.l(paramVoidBoolStringI32StringCallback);
      AppMethodBeat.o(199427);
      return;
    }
    localObject = (UIPageFragmentActivity)localObject;
    ((UIPageFragmentActivity)localObject).grl = paramVoidBoolStringI32StringCallback;
    ((UIPageFragmentActivity)localObject).grm = paramVoidCallback;
    paramVoidBoolStringI32StringCallback = new rh();
    paramVoidBoolStringI32StringCallback.dFR.dsa = ((Activity)localObject);
    paramVoidBoolStringI32StringCallback.dFR.scene = paramInt;
    paramVoidBoolStringI32StringCallback.dFR.packageName = paramString1;
    paramVoidBoolStringI32StringCallback.dFR.dFT = paramString2;
    paramVoidBoolStringI32StringCallback.dFR.dFU = paramString3;
    paramVoidBoolStringI32StringCallback.dFR.requestCode = 4;
    a.IbL.l(paramVoidBoolStringI32StringCallback);
    AppMethodBeat.o(199427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFaceRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */