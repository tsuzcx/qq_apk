package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KScanWidget;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.w;
import com.tenpay.ndk.Encrypt;

public class KindaScanWidgetImpl
  implements KScanWidget
{
  private VoidStringCallback mCallback;
  private c scanBankCardConfirmResultListener;
  
  public KindaScanWidgetImpl()
  {
    AppMethodBeat.i(144535);
    this.scanBankCardConfirmResultListener = new KindaScanWidgetImpl.1(this);
    AppMethodBeat.o(144535);
  }
  
  private String getEncryptDataWithHash(String paramString)
  {
    AppMethodBeat.i(144537);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(144537);
      return null;
    }
    Encrypt localEncrypt = new Encrypt();
    localEncrypt.setTimeStamp(w.dSo());
    b.dRI();
    if (b.dRJ())
    {
      paramString = localEncrypt.encryptPasswdWithRSA2048(paramString);
      AppMethodBeat.o(144537);
      return paramString;
    }
    paramString = localEncrypt.encryptPasswd(paramString);
    AppMethodBeat.o(144537);
    return paramString;
  }
  
  public void scan()
  {
    AppMethodBeat.i(144536);
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("scan_bankcard_with_confirm_ui", true);
    localIntent.addFlags(536870912);
    d.b(KindaContext.get(), "scanner", ".ui.SingleTopScanUI", localIntent);
    this.scanBankCardConfirmResultListener.alive();
    AppMethodBeat.o(144536);
  }
  
  public void setHandlerImpl(VoidStringCallback paramVoidStringCallback)
  {
    this.mCallback = paramVoidStringCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaScanWidgetImpl
 * JD-Core Version:    0.7.0.1
 */