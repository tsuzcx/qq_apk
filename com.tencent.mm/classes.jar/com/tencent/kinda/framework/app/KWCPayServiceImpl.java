package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KWCPayService;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.g.a.yl.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.a.a;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class KWCPayServiceImpl
  implements KWCPayService
{
  private int mEntryScene;
  private int mPayChannel;
  private int mPayScene;
  private VoidITransmitKvDataCallback mQuitCallback;
  private int mReportScene;
  private String mUseCaseUrl;
  private c<yl> mWalletEndResultEventIListener;
  
  public KWCPayServiceImpl()
  {
    AppMethodBeat.i(18377);
    this.mQuitCallback = null;
    this.mWalletEndResultEventIListener = new c()
    {
      public boolean callback(yl paramAnonymousyl)
      {
        AppMethodBeat.i(18374);
        KWCPayServiceImpl.this.mWalletEndResultEventIListener.dead();
        if (KWCPayServiceImpl.this.mQuitCallback == null)
        {
          AppMethodBeat.o(18374);
          return false;
        }
        ITransmitKvData localITransmitKvData = ITransmitKvData.create();
        if (paramAnonymousyl.dNP.result == -1) {
          localITransmitKvData.putBool("result", true);
        }
        for (;;)
        {
          KWCPayServiceImpl.this.mQuitCallback.call(localITransmitKvData);
          AppMethodBeat.o(18374);
          return false;
          localITransmitKvData.putBool("result", false);
        }
      }
    };
    AppMethodBeat.o(18377);
  }
  
  private WalletJsapiData createJsapiData(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18381);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramITransmitKvData.allKeys().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramITransmitKvData.getString(str));
    }
    paramITransmitKvData = new WalletJsapiData(localHashMap);
    AppMethodBeat.o(18381);
    return paramITransmitKvData;
  }
  
  private void doRealnameSceneProgress(Context paramContext)
  {
    AppMethodBeat.i(18378);
    paramContext = (MMActivity)paramContext;
    paramContext.getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.id_verify.a.class.hashCode());
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_activity", "kinda");
    localBundle.putString("realname_verify_process_jump_plugin", "offline");
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", 8);
    localBundle.putBoolean("process_finish_stay_orgpage", false);
    localBundle.putBoolean("is_from_new_cashier", true);
    localBundle.putString("start_activity_class", paramContext.getClass().getName());
    com.tencent.mm.wallet_core.a.a(paramContext, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, null);
    paramContext = com.tencent.mm.wallet_core.a.bs(paramContext);
    if (!(paramContext instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      ae.e("WCPayService", "Fail to get correct wallet process in KWCPayServiceImpl, expect RealNameVerifyProcess got %s", new Object[] { paramContext.getClass().getName() });
      AppMethodBeat.o(18378);
      return;
    }
    ((com.tencent.mm.plugin.wallet_core.id_verify.a)paramContext).Dhv = new a.a()
    {
      public void run(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(18376);
        if ((paramAnonymousActivity instanceof WalletPwdConfirmUI))
        {
          if (KWCPayServiceImpl.this.mUseCaseUrl.equalsIgnoreCase("receipt"))
          {
            f.au(paramAnonymousActivity, KWCPayServiceImpl.access$400(KWCPayServiceImpl.this, KWCPayServiceImpl.this.mEntryScene));
            AppMethodBeat.o(18376);
            return;
          }
          if (KWCPayServiceImpl.this.mUseCaseUrl.equalsIgnoreCase("reward")) {
            d.Q(paramAnonymousActivity, "collect", ".reward.ui.QrRewardMainUI");
          }
        }
        AppMethodBeat.o(18376);
      }
    };
    AppMethodBeat.o(18378);
  }
  
  private int getCollectReportScene(int paramInt)
  {
    if (paramInt == 2) {}
    do
    {
      return 1;
      if (paramInt == 1) {
        return 2;
      }
      if (paramInt == 8) {
        return 4;
      }
    } while (paramInt != 4);
    return 6;
  }
  
  public void getBannerInfoImpl(int paramInt, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback) {}
  
  public boolean isNeedWalletLock()
  {
    return false;
  }
  
  public boolean isWCPayRegUser()
  {
    AppMethodBeat.i(18380);
    boolean bool = t.eJf().eJH();
    AppMethodBeat.o(18380);
    return bool;
  }
  
  public void startUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback)
  {
    AppMethodBeat.i(18379);
    MMActivity localMMActivity = (MMActivity)KindaContext.get();
    if (!(localMMActivity instanceof MMActivity))
    {
      ae.e("PayServiceImpl", "Fail to start startUseCaseImpl due to incompatible context(%s)", new Object[] { localMMActivity.getClass().getName() });
      AppMethodBeat.o(18379);
      return;
    }
    this.mUseCaseUrl = paramString;
    this.mQuitCallback = paramVoidITransmitKvDataCallback;
    this.mPayScene = paramITransmitKvData.getInt("payScene");
    this.mPayChannel = paramITransmitKvData.getInt("payChannel");
    this.mEntryScene = paramITransmitKvData.getInt("entry_scene");
    this.mReportScene = paramITransmitKvData.getInt("pay_receipt_scene");
    if (paramString.equalsIgnoreCase("receipt"))
    {
      if (isWCPayRegUser())
      {
        f.au(localMMActivity, getCollectReportScene(this.mEntryScene));
        AppMethodBeat.o(18379);
        return;
      }
      doRealnameSceneProgress(localMMActivity);
      AppMethodBeat.o(18379);
      return;
    }
    if (paramString.equalsIgnoreCase("reward"))
    {
      if (isWCPayRegUser())
      {
        d.Q(localMMActivity, "collect", ".reward.ui.QrRewardMainUI");
        AppMethodBeat.o(18379);
        return;
      }
      doRealnameSceneProgress(localMMActivity);
      AppMethodBeat.o(18379);
      return;
    }
    if (paramString.equalsIgnoreCase("groupaa"))
    {
      paramString = new Intent();
      if (this.mReportScene == 2) {
        paramString.putExtra("enter_scene", 2);
      }
      for (;;)
      {
        d.b(localMMActivity, "aa", ".ui.AAEntranceUI", paramString);
        AppMethodBeat.o(18379);
        return;
        if (this.mReportScene == 1) {
          paramString.putExtra("enter_scene", 4);
        }
      }
    }
    if (paramString.equalsIgnoreCase("faceHongBao"))
    {
      d.Q(localMMActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
      AppMethodBeat.o(18379);
      return;
    }
    if (paramString.equalsIgnoreCase("transferBank"))
    {
      d.Q(localMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
      AppMethodBeat.o(18379);
      return;
    }
    if (paramString.equalsIgnoreCase("walletLock"))
    {
      paramString = new Intent();
      ((b)g.ab(b.class)).e(localMMActivity, paramString);
      AppMethodBeat.o(18379);
      return;
    }
    if (paramString.equalsIgnoreCase("paySecurity"))
    {
      paramString = new Intent();
      if (8 == this.mPayScene) {
        paramString.putExtra("wallet_lock_jsapi_scene", 2);
      }
      d.b(localMMActivity, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramString);
      AppMethodBeat.o(18379);
      return;
    }
    if (paramString.equalsIgnoreCase("pureBindCard"))
    {
      paramString = createJsapiData(paramITransmitKvData);
      paramITransmitKvData = new Intent();
      paramITransmitKvData.putExtra("appId", paramString.appId);
      paramITransmitKvData.putExtra("timeStamp", paramString.timeStamp);
      paramITransmitKvData.putExtra("nonceStr", paramString.nonceStr);
      paramITransmitKvData.putExtra("packageExt", paramString.packageExt);
      paramITransmitKvData.putExtra("signtype", paramString.signType);
      paramITransmitKvData.putExtra("paySignature", paramString.dDF);
      paramITransmitKvData.putExtra("url", paramString.url);
      paramITransmitKvData.putExtra("key_bind_scene", 4);
      paramITransmitKvData.putExtra("pay_channel", paramString.dpc);
      paramITransmitKvData.putExtra("from_kinda", true);
      d.a(localMMActivity, "wallet", ".bind.ui.WalletBindUI", paramITransmitKvData, 0, false);
      this.mWalletEndResultEventIListener.alive();
      AppMethodBeat.o(18379);
      return;
    }
    if (paramString.equalsIgnoreCase("verifyPassword"))
    {
      paramString = createJsapiData(paramITransmitKvData);
      paramITransmitKvData = new Intent();
      paramITransmitKvData.putExtra("appId", paramString.appId);
      paramITransmitKvData.putExtra("timeStamp", paramString.timeStamp);
      paramITransmitKvData.putExtra("nonceStr", paramString.nonceStr);
      paramITransmitKvData.putExtra("packageExt", paramString.packageExt);
      paramITransmitKvData.putExtra("signtype", paramString.signType);
      paramITransmitKvData.putExtra("paySignature", paramString.dDF);
      paramITransmitKvData.putExtra("url", paramString.url);
      paramITransmitKvData.putExtra("scene", 1);
      paramITransmitKvData.putExtra("from_kinda", true);
      d.a(localMMActivity, "wallet_core", ".ui.WalletCheckPwdUI", paramITransmitKvData, 0, false);
      this.mWalletEndResultEventIListener.alive();
    }
    AppMethodBeat.o(18379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KWCPayServiceImpl
 * JD-Core Version:    0.7.0.1
 */