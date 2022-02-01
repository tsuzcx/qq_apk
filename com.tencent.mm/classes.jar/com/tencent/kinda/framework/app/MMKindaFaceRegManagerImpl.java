package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFaceRegManager;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public class MMKindaFaceRegManagerImpl
  implements KindaFaceRegManager
{
  private static final int FACE_ACTION_REQUEST_CODE = 1;
  private final String TAG = "MMKindaFaceRegManagerImpl";
  
  public void startFaceImpl(int paramInt, String paramString1, String paramString2, VoidBoolStringI32StringCallback paramVoidBoolStringI32StringCallback, VoidCallback paramVoidCallback, String paramString3)
  {
    AppMethodBeat.i(193137);
    Object localObject = KindaContext.getTopOrUIPageFragmentActivity();
    if ((!(localObject instanceof UIPageFragmentActivity)) && (!(localObject instanceof WalletBrandUI)))
    {
      ae.e("MMKindaFaceRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(193137);
      return;
    }
    if ((localObject instanceof WalletBrandUI))
    {
      localObject = (WalletBrandUI)localObject;
      ((WalletBrandUI)localObject).DIy = true;
      ((WalletBrandUI)localObject).gtL = paramVoidBoolStringI32StringCallback;
      ((WalletBrandUI)localObject).gtM = paramVoidCallback;
      paramVoidBoolStringI32StringCallback = new ri();
      paramVoidBoolStringI32StringCallback.dGW.dtg = ((Activity)localObject);
      paramVoidBoolStringI32StringCallback.dGW.scene = paramInt;
      paramVoidBoolStringI32StringCallback.dGW.packageName = paramString1;
      paramVoidBoolStringI32StringCallback.dGW.dGY = paramString2;
      paramVoidBoolStringI32StringCallback.dGW.dGZ = paramString3;
      paramVoidBoolStringI32StringCallback.dGW.requestCode = 4;
      a.IvT.l(paramVoidBoolStringI32StringCallback);
      AppMethodBeat.o(193137);
      return;
    }
    localObject = (UIPageFragmentActivity)localObject;
    ((UIPageFragmentActivity)localObject).gtL = paramVoidBoolStringI32StringCallback;
    ((UIPageFragmentActivity)localObject).gtM = paramVoidCallback;
    paramVoidBoolStringI32StringCallback = new ri();
    paramVoidBoolStringI32StringCallback.dGW.dtg = ((Activity)localObject);
    paramVoidBoolStringI32StringCallback.dGW.scene = paramInt;
    paramVoidBoolStringI32StringCallback.dGW.packageName = paramString1;
    paramVoidBoolStringI32StringCallback.dGW.dGY = paramString2;
    paramVoidBoolStringI32StringCallback.dGW.dGZ = paramString3;
    paramVoidBoolStringI32StringCallback.dGW.requestCode = 4;
    a.IvT.l(paramVoidBoolStringI32StringCallback);
    AppMethodBeat.o(193137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFaceRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */