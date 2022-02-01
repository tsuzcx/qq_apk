package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.luckymoney.sns.a.a;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;

public class b
  extends e
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(65350);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(65344);
          if ((paramAnonymousp instanceof a))
          {
            Log.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " errMsg:" + paramAnonymousString);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              k.cZ(this.activity, this.activity.getString(a.i.lucky_money_open_sns_pay_success));
              b.ZU(121);
              b.a(b.this).putBoolean("is_open_sns_pay", true);
              b.this.a(this.activity, 0, b.b(b.this));
            }
            for (;;)
            {
              AppMethodBeat.o(65344);
              return true;
              k.cZ(this.activity, this.activity.getString(a.i.lucky_money_open_sns_pay_failed));
              b.ZU(122);
              b.this.i(this.activity, 0);
            }
          }
          AppMethodBeat.o(65344);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(65345);
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[0];
          this.agTR.a(new a(1, paramAnonymousVarArgs, ""), true, 1);
          AppMethodBeat.o(65345);
          return true;
        }
      };
      AppMethodBeat.o(65350);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(65350);
    return paramMMActivity;
  }
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(65346);
    if ((paramActivity instanceof SnsLuckyMoneyFreePwdSetting)) {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
    AppMethodBeat.o(65346);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(65347);
    b(paramActivity, paramBundle);
    AppMethodBeat.o(65347);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(65349);
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localIntent.putExtras(localBundle);
    a(paramActivity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, localIntent, true);
    AppMethodBeat.o(65349);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "LuckyFreePwdProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(65348);
    b(paramActivity, null);
    AppMethodBeat.o(65348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.b
 * JD-Core Version:    0.7.0.1
 */