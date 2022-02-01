package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFaceRegManager;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public class MMKindaFaceRegManagerImpl
  implements KindaFaceRegManager
{
  private static final int FACE_ACTION_REQUEST_CODE = 1;
  private final String TAG = "MMKindaFaceRegManagerImpl";
  
  public void startFaceImpl(int paramInt, String paramString1, String paramString2, VoidBoolStringI32StringCallback paramVoidBoolStringI32StringCallback, VoidCallback paramVoidCallback, String paramString3)
  {
    AppMethodBeat.i(207375);
    Object localObject = KindaContext.getTopOrUIPageFragmentActivity();
    if ((!(localObject instanceof UIPageFragmentActivity)) && (!(localObject instanceof WalletBrandUI)))
    {
      ac.e("MMKindaFaceRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(207375);
      return;
    }
    if ((localObject instanceof WalletBrandUI))
    {
      localObject = (WalletBrandUI)localObject;
      ((WalletBrandUI)localObject).BQA = true;
      ((WalletBrandUI)localObject).fXP = paramVoidBoolStringI32StringCallback;
      ((WalletBrandUI)localObject).fXQ = paramVoidCallback;
      paramVoidBoolStringI32StringCallback = new qw();
      paramVoidBoolStringI32StringCallback.dtR.dgE = ((Activity)localObject);
      paramVoidBoolStringI32StringCallback.dtR.scene = paramInt;
      paramVoidBoolStringI32StringCallback.dtR.packageName = paramString1;
      paramVoidBoolStringI32StringCallback.dtR.dtT = paramString2;
      paramVoidBoolStringI32StringCallback.dtR.dtU = paramString3;
      paramVoidBoolStringI32StringCallback.dtR.requestCode = 4;
      a.GpY.l(paramVoidBoolStringI32StringCallback);
      AppMethodBeat.o(207375);
      return;
    }
    localObject = (UIPageFragmentActivity)localObject;
    ((UIPageFragmentActivity)localObject).fXP = paramVoidBoolStringI32StringCallback;
    ((UIPageFragmentActivity)localObject).fXQ = paramVoidCallback;
    paramVoidBoolStringI32StringCallback = new qw();
    paramVoidBoolStringI32StringCallback.dtR.dgE = ((Activity)localObject);
    paramVoidBoolStringI32StringCallback.dtR.scene = paramInt;
    paramVoidBoolStringI32StringCallback.dtR.packageName = paramString1;
    paramVoidBoolStringI32StringCallback.dtR.dtT = paramString2;
    paramVoidBoolStringI32StringCallback.dtR.dtU = paramString3;
    paramVoidBoolStringI32StringCallback.dtR.requestCode = 4;
    a.GpY.l(paramVoidBoolStringI32StringCallback);
    AppMethodBeat.o(207375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFaceRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */