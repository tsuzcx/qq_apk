package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KScanWidget;
import com.tencent.kinda.gen.VoidStringStringBinaryCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.rv.a;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.rw.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.y;
import com.tenpay.ndk.Encrypt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KindaScanWidgetImpl
  implements KScanWidget
{
  private static final String TAG = "KindaScanWidgetImpl";
  private boolean isDismissOnScanFinish;
  private VoidStringStringBinaryCallback mCallback;
  private c mScanBankCardResultListener;
  private c scanBankCardConfirmResultListener;
  
  public KindaScanWidgetImpl()
  {
    AppMethodBeat.i(18651);
    this.isDismissOnScanFinish = true;
    this.scanBankCardConfirmResultListener = new c()
    {
      public boolean callback(rv paramAnonymousrv)
      {
        AppMethodBeat.i(18647);
        if ((paramAnonymousrv.duM.action == 1) && (!bs.isNullOrNil(paramAnonymousrv.duM.cardNum)) && (KindaScanWidgetImpl.this.mCallback != null))
        {
          String str = paramAnonymousrv.duM.cardNum;
          paramAnonymousrv = paramAnonymousrv.duM.duN;
          str = str.replaceAll("-", "").replaceAll(" ", "");
          KindaScanWidgetImpl.this.mCallback.call(KindaScanWidgetImpl.access$100(KindaScanWidgetImpl.this, str), str, KindaScanWidgetImpl.this.getBitmapByte(paramAnonymousrv));
        }
        KindaScanWidgetImpl.this.scanBankCardConfirmResultListener.dead();
        AppMethodBeat.o(18647);
        return false;
      }
    };
    this.mScanBankCardResultListener = new c()
    {
      public boolean callback(rw paramAnonymousrw)
      {
        AppMethodBeat.i(18649);
        if ((!bs.isNullOrNil(paramAnonymousrw.duO.cardId)) && (KindaScanWidgetImpl.this.mCallback != null))
        {
          String str = paramAnonymousrw.duO.cardId;
          paramAnonymousrw = paramAnonymousrw.duO.duP;
          str = str.replaceAll("-", "").replaceAll(" ", "");
          KindaScanWidgetImpl.this.mCallback.call(KindaScanWidgetImpl.access$100(KindaScanWidgetImpl.this, str), str, KindaScanWidgetImpl.this.getBitmapByte(paramAnonymousrw));
        }
        KindaScanWidgetImpl.this.mScanBankCardResultListener.dead();
        AppMethodBeat.o(18649);
        return false;
      }
    };
    AppMethodBeat.o(18651);
  }
  
  private String getEncryptDataWithHash(String paramString)
  {
    AppMethodBeat.i(18653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(18653);
      return null;
    }
    Encrypt localEncrypt = new Encrypt();
    localEncrypt.setTimeStamp(y.fAm());
    b.fzz();
    if (b.fzA())
    {
      paramString = localEncrypt.encryptPasswdWithRSA2048(paramString);
      AppMethodBeat.o(18653);
      return paramString;
    }
    paramString = localEncrypt.encryptPasswd(paramString);
    AppMethodBeat.o(18653);
    return paramString;
  }
  
  public void dismissOnScanFinish(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.isDismissOnScanFinish = paramBoolean;
      return;
    }
  }
  
  public byte[] getBitmapByte(Bitmap paramBitmap)
  {
    AppMethodBeat.i(18654);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    try
    {
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      label33:
      paramBitmap = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(18654);
      return paramBitmap;
    }
    catch (IOException paramBitmap)
    {
      break label33;
    }
  }
  
  public void scan(String paramString)
  {
    AppMethodBeat.i(18652);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ac.e("KindaScanWidgetImpl", "KindaScanWidgetImpl scan() KindaContext.get() return null!");
      AppMethodBeat.o(18652);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("scan_bankcard_with_confirm_ui", this.isDismissOnScanFinish);
    localIntent.putExtra("bank_card_owner", paramString);
    localIntent.addFlags(536870912);
    d.b(localContext, "scanner", ".ui.ScanCardUI", localIntent);
    this.scanBankCardConfirmResultListener.alive();
    this.mScanBankCardResultListener.alive();
    AppMethodBeat.o(18652);
  }
  
  public void setHandlerImpl(VoidStringStringBinaryCallback paramVoidStringStringBinaryCallback)
  {
    this.mCallback = paramVoidStringStringBinaryCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaScanWidgetImpl
 * JD-Core Version:    0.7.0.1
 */