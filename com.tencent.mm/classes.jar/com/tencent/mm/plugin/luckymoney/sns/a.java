package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends d
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(65350);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(65344);
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
          {
            ad.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " errMsg:" + paramAnonymousString);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              h.cf(this.activity, this.activity.getString(2131760920));
              a.FU(121);
              a.a(a.this).putBoolean("is_open_sns_pay", true);
              a.this.a(this.activity, 0, a.b(a.this));
            }
            for (;;)
            {
              AppMethodBeat.o(65344);
              return true;
              h.cf(this.activity, this.activity.getString(2131760919));
              a.FU(122);
              a.this.g(this.activity, 0);
            }
          }
          AppMethodBeat.o(65344);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(65345);
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[0];
          this.Ieo.a(new com.tencent.mm.plugin.luckymoney.sns.a.a(1, paramAnonymousVarArgs, ""), true, 1);
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
  
  public final d a(Activity paramActivity, Bundle paramBundle)
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
  
  public final String cuB()
  {
    return "LuckyFreePwdProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(65348);
    b(paramActivity, null);
    AppMethodBeat.o(65348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.a
 * JD-Core Version:    0.7.0.1
 */