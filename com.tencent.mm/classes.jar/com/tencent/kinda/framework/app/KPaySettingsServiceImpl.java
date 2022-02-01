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
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ci;
import com.tencent.mm.f.a.ci.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ao.a;
import com.tencent.mm.storage.ao.b;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashMap;

public class KPaySettingsServiceImpl
  implements KPaySettingsService
{
  private static final String TAG = "MicroMsg.KPaySettingsServiceImpl";
  private byte _hellAccFlag_;
  
  private void closeBioPay(final int paramInt, final VoidBoolCallback paramVoidBoolCallback)
  {
    AppMethodBeat.i(265052);
    Context localContext = KindaContext.get();
    KindaContext.getTopOrUIPageFragmentActivity();
    String str = localContext.getString(a.i.fingerprint_close);
    if (paramInt == 2) {
      str = localContext.getString(a.i.faceid_close);
    }
    com.tencent.mm.ui.base.h.a(localContext, false, str, "", localContext.getString(a.i.app_ok), localContext.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(264094);
        paramAnonymousDialogInterface = i.c(KindaContext.get(), false, null);
        final ci localci = new ci();
        localci.fxW.fxY = paramInt;
        localci.callback = new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(264383);
            if (localci.fxX == null)
            {
              KPaySettingsServiceImpl.2.this.val$resultCallback.call(false);
              AppMethodBeat.o(264383);
              return;
            }
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            Log.i("MicroMsg.KPaySettingsServiceImpl", "close event result: %s", new Object[] { Integer.valueOf(localci.fxX.retCode) });
            if (localci.fxX.retCode == 0)
            {
              com.tencent.mm.kernel.h.aHF().kcd.a(new ae(null, 19), 0);
              KPaySettingsServiceImpl.2.this.val$resultCallback.call(true);
              AppMethodBeat.o(264383);
              return;
            }
            Context localContext = KindaContext.get();
            String str = localContext.getString(a.i.fingerprint_close_error);
            if (KPaySettingsServiceImpl.2.this.val$biometricType == 2) {
              str = localContext.getString(a.i.wallet_password_setting_ui_close_faceid_fail);
            }
            com.tencent.mm.ui.base.h.c(localContext, str, "", true);
            KPaySettingsServiceImpl.2.this.val$resultCallback.call(false);
            AppMethodBeat.o(264383);
          }
        };
        EventCenter.instance.asyncPublish(localci, KindaContext.get().getMainLooper());
        AppMethodBeat.o(264094);
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(262908);
        paramVoidBoolCallback.call(false);
        AppMethodBeat.o(262908);
      }
    });
    AppMethodBeat.o(265052);
  }
  
  private String normalizedReddotId(String paramString)
  {
    AppMethodBeat.i(265046);
    paramString = paramString + "_BOOLEAN_SYNC";
    AppMethodBeat.o(265046);
    return paramString;
  }
  
  private void showEnrollBiometricGuideAlert(int paramInt)
  {
    AppMethodBeat.i(265053);
    Log.i("MicroMsg.KPaySettingsServiceImpl", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    Context localContext = KindaContext.get();
    String str = localContext.getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_text);
    if (paramInt == 1) {
      str = localContext.getString(a.i.wallet_password_setting_ui_set_sys_fp_guide_text);
    }
    com.tencent.mm.ui.base.h.a(localContext, str, "", localContext.getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(265053);
  }
  
  private void startOpenBioPayProcess(int paramInt)
  {
    AppMethodBeat.i(265051);
    Log.i("MicroMsg.KPaySettingsServiceImpl", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(KindaContext.getTopOrUIPageFragmentActivity(), "FingerprintAuth", localBundle);
    AppMethodBeat.o(265051);
  }
  
  public void commitHbRefundWayTypeChange()
  {
    AppMethodBeat.i(265041);
    cyt localcyt = new cyt();
    com.tencent.mm.kernel.h.aHH();
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxr, Long.valueOf(0L))).longValue();
    if ((l & 1L) != 0L)
    {
      localcyt.TGS = 1L;
      localcyt.TGT = 2L;
    }
    for (;;)
    {
      Log.i("MicroMsg.KPaySettingsServiceImpl", "doSettingsOplog: extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(l), Long.toBinaryString(localcyt.TGS), Long.toBinaryString(localcyt.TGT) });
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(218, localcyt));
      AppMethodBeat.o(265041);
      return;
      if ((l & 0x2) != 0L)
      {
        localcyt.TGS = 2L;
        localcyt.TGT = 1L;
      }
    }
  }
  
  public void commitTransferDelayTypeChange()
  {
    AppMethodBeat.i(265034);
    com.tencent.mm.kernel.h.aHH();
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
    int i = 0;
    if ((0x10 & l) != 0L) {
      i = 1;
    }
    for (;;)
    {
      cyu localcyu = new cyu();
      localcyu.Iza = i;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(205, localcyu));
      AppMethodBeat.o(265034);
      return;
      if ((l & 0x20) != 0L) {
        i = 2;
      }
    }
  }
  
  public KHbRefundWayType getHbRefundWayType()
  {
    AppMethodBeat.i(265039);
    com.tencent.mm.kernel.h.aHH();
    if (Util.isEqual(((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxr, Long.valueOf(0L))).longValue() & 0x3, 2L))
    {
      localKHbRefundWayType = KHbRefundWayType.ORIGIN;
      AppMethodBeat.o(265039);
      return localKHbRefundWayType;
    }
    KHbRefundWayType localKHbRefundWayType = KHbRefundWayType.LQ;
    AppMethodBeat.o(265039);
    return localKHbRefundWayType;
  }
  
  public boolean getReddotStatus(String paramString)
  {
    AppMethodBeat.i(265042);
    com.tencent.mm.kernel.h.aHH();
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().E(normalizedReddotId(paramString), Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(265042);
    return bool;
  }
  
  public KTransferDelayType getTransferDelayType()
  {
    AppMethodBeat.i(265030);
    com.tencent.mm.kernel.h.aHH();
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
    KTransferDelayType localKTransferDelayType = KTransferDelayType.NODELAY;
    if ((0x10 & l) != 0L) {
      localKTransferDelayType = KTransferDelayType.DELAY2HOUR;
    }
    for (;;)
    {
      AppMethodBeat.o(265030);
      return localKTransferDelayType;
      if ((l & 0x20) != 0L) {
        localKTransferDelayType = KTransferDelayType.DELAY24HOUR;
      }
    }
  }
  
  public int getTransferPhoneGrantFlag()
  {
    AppMethodBeat.i(265036);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VxG, Integer.valueOf(2))).intValue();
    AppMethodBeat.o(265036);
    return i;
  }
  
  public void handlePushBioPaySettingPageImpl(final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(265050);
    Object localObject = new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(263870);
        paramVoidCallback.call();
        AppMethodBeat.o(263870);
      }
    };
    paramVoidCallback = KindaContext.get();
    Intent localIntent = new Intent(paramVoidCallback, WalletBiometricPaySettingsUI.class);
    localIntent.putExtra("key_should_update_result_receiver", (Parcelable)localObject);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramVoidCallback, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/kinda/framework/app/KPaySettingsServiceImpl", "handlePushBioPaySettingPageImpl", "(Lcom/tencent/kinda/gen/VoidCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramVoidCallback.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramVoidCallback, "com/tencent/kinda/framework/app/KPaySettingsServiceImpl", "handlePushBioPaySettingPageImpl", "(Lcom/tencent/kinda/gen/VoidCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(265050);
  }
  
  public boolean isBioPayTypeEnabled(KBioPayType paramKBioPayType)
  {
    AppMethodBeat.i(265048);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (paramKBioPayType == KBioPayType.FACEID)
    {
      bool = locala.eoq();
      AppMethodBeat.o(265048);
      return bool;
    }
    boolean bool = locala.eon();
    AppMethodBeat.o(265048);
    return bool;
  }
  
  public void logGeneralUserAction(int paramInt)
  {
    AppMethodBeat.i(265054);
    g.azK(paramInt);
    AppMethodBeat.o(265054);
  }
  
  public void markReddotConsumed(String paramString)
  {
    AppMethodBeat.i(265044);
    com.tencent.mm.kernel.h.aHH();
    ao localao = com.tencent.mm.kernel.h.aHG().aHp();
    String str = normalizedReddotId(paramString);
    Object localObject1 = Boolean.TRUE;
    Object localObject2;
    if (!Util.isNullOrNil(str))
    {
      localObject2 = str.split("_");
      paramString = localObject2[(localObject2.length - 1)];
      if (!paramString.equals("SYNC")) {
        break label328;
      }
      paramString = localObject2[(localObject2.length - 2)];
    }
    label309:
    label314:
    label322:
    label328:
    for (int i = 1;; i = 0)
    {
      if (ao.a(paramString, localObject1, true))
      {
        int j = str.lastIndexOf(paramString);
        localObject2 = str.substring(0, paramString.length() + j);
        if (localObject1 != null) {
          break label322;
        }
      }
      for (paramString = ao.VfQ;; paramString = (String)localObject1)
      {
        if (!paramString.equals(localao.VfS.put(localObject2, paramString)))
        {
          if (paramString != ao.VfQ) {
            break label249;
          }
          localObject1 = null;
        }
        for (;;)
        {
          try
          {
            localao.VfU.put(localObject2, localObject1);
            if (i != 0)
            {
              localao.hxT();
              if (paramString != ao.VfQ) {
                break label309;
              }
              i = 5;
              localao.doNotify(i, localao, str);
              localObject1 = new StringBuilder("SET: ").append((String)localObject2).append(" => ");
              if (paramString != ao.VfQ) {
                break label314;
              }
              paramString = "(DELETED)";
              Log.i("MicroMsg.ConfigStorage", paramString);
              AppMethodBeat.o(265044);
              return;
              label249:
              localObject1 = ao.b.eg(paramString);
              if (localObject1 == null) {
                continue;
              }
              break;
            }
            if (localao.VfV) {
              continue;
            }
            localao.VfV = true;
            localao.mHandler.postDelayed(localao.VfW, 30000L);
            continue;
            i = 4;
          }
          finally
          {
            AppMethodBeat.o(265044);
          }
          continue;
          paramString = paramString.toString();
        }
      }
    }
  }
  
  public void setBioPayTypeEnabledImpl(KBioPayType paramKBioPayType, boolean paramBoolean, VoidBoolCallback paramVoidBoolCallback)
  {
    AppMethodBeat.i(265049);
    if (paramKBioPayType == KBioPayType.FACEID)
    {
      if (paramBoolean)
      {
        if (com.tencent.mm.plugin.wallet.b.a.gIf())
        {
          startOpenBioPayProcess(2);
          paramVoidBoolCallback.call(true);
          AppMethodBeat.o(265049);
          return;
        }
        paramVoidBoolCallback.call(false);
        showEnrollBiometricGuideAlert(2);
        AppMethodBeat.o(265049);
        return;
      }
      closeBioPay(2, paramVoidBoolCallback);
      AppMethodBeat.o(265049);
      return;
    }
    if (paramKBioPayType == KBioPayType.TOUCHID)
    {
      if (paramBoolean)
      {
        if (com.tencent.mm.plugin.wallet.b.a.gIe())
        {
          startOpenBioPayProcess(1);
          paramVoidBoolCallback.call(true);
          AppMethodBeat.o(265049);
          return;
        }
        paramVoidBoolCallback.call(false);
        showEnrollBiometricGuideAlert(1);
        AppMethodBeat.o(265049);
        return;
      }
      closeBioPay(1, paramVoidBoolCallback);
    }
    AppMethodBeat.o(265049);
  }
  
  public void setHbRefundWayType(KHbRefundWayType paramKHbRefundWayType)
  {
    AppMethodBeat.i(265040);
    com.tencent.mm.kernel.h.aHH();
    long l2 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vxr, Long.valueOf(0L))).longValue();
    long l1;
    if (paramKHbRefundWayType == KHbRefundWayType.LQ) {
      l1 = (l2 | 1L) & 0xFFFFFFFD;
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxr, Long.valueOf(l1));
      AppMethodBeat.o(265040);
      return;
      l1 = l2;
      if (paramKHbRefundWayType == KHbRefundWayType.ORIGIN) {
        l1 = l2 & 0xFFFFFFFE | 0x2;
      }
    }
  }
  
  public void setTransferDelayType(KTransferDelayType paramKTransferDelayType)
  {
    AppMethodBeat.i(265031);
    com.tencent.mm.kernel.h.aHH();
    long l2 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
    long l1;
    if (paramKTransferDelayType == KTransferDelayType.NODELAY) {
      l1 = l2 & 0xFFFFFFEF & 0xFFFFFFDF;
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(147457, Long.valueOf(l1));
      AppMethodBeat.o(265031);
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
    AppMethodBeat.i(265037);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxG, Integer.valueOf(paramInt));
    AppMethodBeat.o(265037);
  }
  
  public ArrayList<KBioPayType> supportedBioPayTypes()
  {
    AppMethodBeat.i(265047);
    ArrayList localArrayList = new ArrayList();
    if (com.tencent.mm.plugin.wallet.b.a.gIf()) {
      localArrayList.add(KBioPayType.FACEID);
    }
    if (com.tencent.mm.plugin.wallet.b.a.gIe()) {
      localArrayList.add(KBioPayType.TOUCHID);
    }
    AppMethodBeat.o(265047);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KPaySettingsServiceImpl
 * JD-Core Version:    0.7.0.1
 */