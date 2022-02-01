package com.tencent.kinda.framework.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KBioPayType;
import com.tencent.kinda.gen.KHbRefundWayType;
import com.tencent.kinda.gen.KPaySettingsService;
import com.tencent.kinda.gen.KTransferDelayType;
import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.cr;
import com.tencent.mm.autogen.a.cr.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.l;
import java.util.ArrayList;

public class KPaySettingsServiceImpl
  implements KPaySettingsService
{
  private static final String TAG = "MicroMsg.KPaySettingsServiceImpl";
  private byte _hellAccFlag_;
  
  private void closeBioPay(final int paramInt, final VoidBoolCallback paramVoidBoolCallback)
  {
    AppMethodBeat.i(226401);
    Context localContext = KindaContext.get();
    KindaContext.getTopOrUIPageFragmentActivity();
    String str = localContext.getString(a.i.fingerprint_close);
    if (paramInt == 2) {
      str = localContext.getString(a.i.faceid_close);
    }
    k.a(localContext, false, str, "", localContext.getString(a.i.app_ok), localContext.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(226407);
        paramAnonymousDialogInterface = l.c(KindaContext.get(), false, null);
        final cr localcr = new cr();
        localcr.hCB.hCD = paramInt;
        localcr.callback = new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(226358);
            if (localcr.hCC == null)
            {
              KPaySettingsServiceImpl.2.this.val$resultCallback.call(false);
              AppMethodBeat.o(226358);
              return;
            }
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            Log.i("MicroMsg.KPaySettingsServiceImpl", "close event result: %s", new Object[] { Integer.valueOf(localcr.hCC.retCode) });
            if (localcr.hCC.retCode == 0)
            {
              h.baD().mCm.a(new ae(null, 19), 0);
              KPaySettingsServiceImpl.2.this.val$resultCallback.call(true);
              AppMethodBeat.o(226358);
              return;
            }
            Context localContext = KindaContext.get();
            String str = localContext.getString(a.i.fingerprint_close_error);
            if (KPaySettingsServiceImpl.2.this.val$biometricType == 2) {
              str = localContext.getString(a.i.wallet_password_setting_ui_close_faceid_fail);
            }
            k.c(localContext, str, "", true);
            KPaySettingsServiceImpl.2.this.val$resultCallback.call(false);
            AppMethodBeat.o(226358);
          }
        };
        localcr.asyncPublish(KindaContext.get().getMainLooper());
        AppMethodBeat.o(226407);
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(226398);
        paramVoidBoolCallback.call(false);
        AppMethodBeat.o(226398);
      }
    });
    AppMethodBeat.o(226401);
  }
  
  private String normalizedReddotId(String paramString)
  {
    AppMethodBeat.i(226393);
    paramString = paramString + "_BOOLEAN_SYNC";
    AppMethodBeat.o(226393);
    return paramString;
  }
  
  private void showEnrollBiometricGuideAlert(int paramInt)
  {
    AppMethodBeat.i(226403);
    Log.i("MicroMsg.KPaySettingsServiceImpl", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    Context localContext = KindaContext.get();
    String str = localContext.getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_text);
    if (paramInt == 1) {
      str = localContext.getString(a.i.wallet_password_setting_ui_set_sys_fp_guide_text);
    }
    k.a(localContext, str, "", localContext.getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(226403);
  }
  
  private void startOpenBioPayProcess(int paramInt)
  {
    AppMethodBeat.i(226397);
    Log.i("MicroMsg.KPaySettingsServiceImpl", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(KindaContext.getTopOrUIPageFragmentActivity(), "FingerprintAuth", localBundle);
    AppMethodBeat.o(226397);
  }
  
  public void commitHbRefundWayTypeChange()
  {
    AppMethodBeat.i(226424);
    dpz localdpz = new dpz();
    h.baF();
    long l = ((Long)h.baE().ban().get(at.a.acZd, Long.valueOf(0L))).longValue();
    if ((l & 1L) != 0L)
    {
      localdpz.aaWz = 1L;
      localdpz.aaWA = 2L;
    }
    for (;;)
    {
      Log.i("MicroMsg.KPaySettingsServiceImpl", "doSettingsOplog: extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(l), Long.toBinaryString(localdpz.aaWz), Long.toBinaryString(localdpz.aaWA) });
      ((n)h.ax(n.class)).bzz().d(new k.a(218, localdpz));
      AppMethodBeat.o(226424);
      return;
      if ((l & 0x2) != 0L)
      {
        localdpz.aaWz = 2L;
        localdpz.aaWA = 1L;
      }
    }
  }
  
  public void commitTransferDelayTypeChange()
  {
    AppMethodBeat.i(226412);
    h.baF();
    long l = ((Long)h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
    int i = 0;
    if ((0x10 & l) != 0L) {
      i = 1;
    }
    for (;;)
    {
      dqa localdqa = new dqa();
      localdqa.OzH = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(205, localdqa));
      AppMethodBeat.o(226412);
      return;
      if ((l & 0x20) != 0L) {
        i = 2;
      }
    }
  }
  
  public KHbRefundWayType getHbRefundWayType()
  {
    AppMethodBeat.i(226421);
    h.baF();
    if (Util.isEqual(((Long)h.baE().ban().get(at.a.acZd, Long.valueOf(0L))).longValue() & 0x3, 2L))
    {
      localKHbRefundWayType = KHbRefundWayType.ORIGIN;
      AppMethodBeat.o(226421);
      return localKHbRefundWayType;
    }
    KHbRefundWayType localKHbRefundWayType = KHbRefundWayType.LQ;
    AppMethodBeat.o(226421);
    return localKHbRefundWayType;
  }
  
  public boolean getReddotStatus(String paramString)
  {
    AppMethodBeat.i(226427);
    h.baF();
    boolean bool = ((Boolean)h.baE().ban().R(normalizedReddotId(paramString), Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(226427);
    return bool;
  }
  
  public KTransferDelayType getTransferDelayType()
  {
    AppMethodBeat.i(226406);
    h.baF();
    long l = ((Long)h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
    KTransferDelayType localKTransferDelayType = KTransferDelayType.NODELAY;
    if ((0x10 & l) != 0L) {
      localKTransferDelayType = KTransferDelayType.DELAY2HOUR;
    }
    for (;;)
    {
      AppMethodBeat.o(226406);
      return localKTransferDelayType;
      if ((l & 0x20) != 0L) {
        localKTransferDelayType = KTransferDelayType.DELAY24HOUR;
      }
    }
  }
  
  public int getTransferPhoneGrantFlag()
  {
    AppMethodBeat.i(226415);
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acZt, Integer.valueOf(2))).intValue();
    AppMethodBeat.o(226415);
    return i;
  }
  
  public void handlePushBioPaySettingPageImpl(final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(226441);
    Object localObject = new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(226408);
        paramVoidCallback.call();
        AppMethodBeat.o(226408);
      }
    };
    paramVoidCallback = KindaContext.get();
    Intent localIntent = new Intent(paramVoidCallback, WalletBiometricPaySettingsUI.class);
    localIntent.putExtra("key_should_update_result_receiver", (Parcelable)localObject);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramVoidCallback, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/kinda/framework/app/KPaySettingsServiceImpl", "handlePushBioPaySettingPageImpl", "(Lcom/tencent/kinda/gen/VoidCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramVoidCallback.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramVoidCallback, "com/tencent/kinda/framework/app/KPaySettingsServiceImpl", "handlePushBioPaySettingPageImpl", "(Lcom/tencent/kinda/gen/VoidCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(226441);
  }
  
  public boolean isBioPayTypeEnabled(KBioPayType paramKBioPayType)
  {
    AppMethodBeat.i(226435);
    com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    if (paramKBioPayType == KBioPayType.FACEID)
    {
      bool = locala.ftt();
      AppMethodBeat.o(226435);
      return bool;
    }
    boolean bool = locala.ftq();
    AppMethodBeat.o(226435);
    return bool;
  }
  
  public void logGeneralUserAction(int paramInt)
  {
    AppMethodBeat.i(226446);
    i.aGA(paramInt);
    AppMethodBeat.o(226446);
  }
  
  public void markReddotConsumed(String paramString)
  {
    AppMethodBeat.i(226429);
    h.baF();
    h.baE().ban().S(normalizedReddotId(paramString), Boolean.TRUE);
    AppMethodBeat.o(226429);
  }
  
  public void setBioPayTypeEnabledImpl(KBioPayType paramKBioPayType, boolean paramBoolean, VoidBoolCallback paramVoidBoolCallback)
  {
    AppMethodBeat.i(226436);
    if (paramKBioPayType == KBioPayType.FACEID)
    {
      if (paramBoolean)
      {
        if (com.tencent.mm.plugin.wallet.b.a.ihj())
        {
          startOpenBioPayProcess(2);
          paramVoidBoolCallback.call(true);
          AppMethodBeat.o(226436);
          return;
        }
        paramVoidBoolCallback.call(false);
        showEnrollBiometricGuideAlert(2);
        AppMethodBeat.o(226436);
        return;
      }
      closeBioPay(2, paramVoidBoolCallback);
      AppMethodBeat.o(226436);
      return;
    }
    if (paramKBioPayType == KBioPayType.TOUCHID)
    {
      if (paramBoolean)
      {
        if (com.tencent.mm.plugin.wallet.b.a.ihi())
        {
          startOpenBioPayProcess(1);
          paramVoidBoolCallback.call(true);
          AppMethodBeat.o(226436);
          return;
        }
        paramVoidBoolCallback.call(false);
        showEnrollBiometricGuideAlert(1);
        AppMethodBeat.o(226436);
        return;
      }
      closeBioPay(1, paramVoidBoolCallback);
    }
    AppMethodBeat.o(226436);
  }
  
  public void setHbRefundWayType(KHbRefundWayType paramKHbRefundWayType)
  {
    AppMethodBeat.i(226423);
    h.baF();
    long l2 = ((Long)h.baE().ban().get(at.a.acZd, Long.valueOf(0L))).longValue();
    long l1;
    if (paramKHbRefundWayType == KHbRefundWayType.LQ) {
      l1 = (l2 | 1L) & 0xFFFFFFFD;
    }
    for (;;)
    {
      h.baF();
      h.baE().ban().set(at.a.acZd, Long.valueOf(l1));
      AppMethodBeat.o(226423);
      return;
      l1 = l2;
      if (paramKHbRefundWayType == KHbRefundWayType.ORIGIN) {
        l1 = l2 & 0xFFFFFFFE | 0x2;
      }
    }
  }
  
  public void setTransferDelayType(KTransferDelayType paramKTransferDelayType)
  {
    AppMethodBeat.i(226410);
    h.baF();
    long l2 = ((Long)h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
    long l1;
    if (paramKTransferDelayType == KTransferDelayType.NODELAY) {
      l1 = l2 & 0xFFFFFFEF & 0xFFFFFFDF;
    }
    for (;;)
    {
      h.baF();
      h.baE().ban().B(147457, Long.valueOf(l1));
      AppMethodBeat.o(226410);
      return;
      if (paramKTransferDelayType == KTransferDelayType.DELAY2HOUR)
      {
        l1 = l2 & 0xFFFFFFDF | 0x10;
      }
      else
      {
        l1 = l2;
        if (paramKTransferDelayType == KTransferDelayType.DELAY24HOUR) {
          l1 = l2 & 0xFFFFFFEF | 0x20;
        }
      }
    }
  }
  
  public void setTransferPhoneGrantFlag(int paramInt)
  {
    AppMethodBeat.i(226420);
    h.baE().ban().set(at.a.acZt, Integer.valueOf(paramInt));
    AppMethodBeat.o(226420);
  }
  
  public ArrayList<KBioPayType> supportedBioPayTypes()
  {
    AppMethodBeat.i(226431);
    ArrayList localArrayList = new ArrayList();
    if (com.tencent.mm.plugin.wallet.b.a.ihj()) {
      localArrayList.add(KBioPayType.FACEID);
    }
    if (com.tencent.mm.plugin.wallet.b.a.ihi()) {
      localArrayList.add(KBioPayType.TOUCHID);
    }
    AppMethodBeat.o(226431);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KPaySettingsServiceImpl
 * JD-Core Version:    0.7.0.1
 */